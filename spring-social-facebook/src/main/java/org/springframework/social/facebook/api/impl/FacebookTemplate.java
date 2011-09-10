/*
 * Copyright 2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.facebook.api.impl;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.CollectionType;
import org.codehaus.jackson.map.type.TypeFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.social.NotAuthorizedException;
import org.springframework.social.UncategorizedApiException;
import org.springframework.social.facebook.api.AdOperations;
import org.springframework.social.facebook.api.CommentOperations;
import org.springframework.social.facebook.api.EventOperations;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.FeedOperations;
import org.springframework.social.facebook.api.FriendOperations;
import org.springframework.social.facebook.api.GroupOperations;
import org.springframework.social.facebook.api.ImageType;
import org.springframework.social.facebook.api.LikeOperations;
import org.springframework.social.facebook.api.MediaOperations;
import org.springframework.social.facebook.api.PageOperations;
import org.springframework.social.facebook.api.PlacesOperations;
import org.springframework.social.facebook.api.UserOperations;
import org.springframework.social.facebook.api.impl.json.FacebookModule;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.OAuth2Version;
import org.springframework.social.support.ClientHttpRequestFactorySelector;
import org.springframework.social.support.URIBuilder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * <p>This is the central class for interacting with Facebook.</p>
 * <p>
 * There are some operations, such as searching, that do not require OAuth
 * authentication. In those cases, you may use a {@link FacebookTemplate} that is
 * created through the default constructor and without any OAuth details.
 * Attempts to perform secured operations through such an instance, however,
 * will result in {@link NotAuthorizedException} being thrown.
 * </p>
 * @author Craig Walls
 */
public class FacebookTemplate extends AbstractOAuth2ApiBinding implements Facebook {

	private UserOperations userOperations;
	
	private PlacesOperations placesOperations;

	private FriendOperations friendOperations;
	
	private FeedOperations feedOperations;
	
	private GroupOperations groupOperations;

	private CommentOperations commentOperations;

	private LikeOperations likeOperations;
	
	private EventOperations eventOperations;
	
	private MediaOperations mediaOperations;
	
	private PageOperations pageOperations;
	
	private AdOperations adOperations;

	private ObjectMapper objectMapper;

	/**
	 * Create a new instance of FacebookTemplate.
	 * This constructor creates a new FacebookTemplate able to perform unauthenticated operations against Facebook's Graph API.
	 * Some operations do not require OAuth authentication. 
	 * For example, retrieving a specified user's profile or feed does not require authentication (although the data returned will be limited to what is publicly available). 
	 * A FacebookTemplate created with this constructor will support those operations.
	 * Those operations requiring authentication will throw {@link NotAuthorizedException}.
	 */
	public FacebookTemplate() {
		initialize();		
	}

	/**
	 * Create a new instance of FacebookTemplate.
	 * This constructor creates the FacebookTemplate using a given access token.
	 * @param accessToken An access token given by Facebook after a successful OAuth 2 authentication (or through Facebook's JS library).
	 */
	public FacebookTemplate(String accessToken) {
		super(accessToken);
		initialize();
	}

	@Override
	public void setRequestFactory(ClientHttpRequestFactory requestFactory) {
		// Wrap the request factory with a BufferingClientHttpRequestFactory so that the error handler can do repeat reads on the response.getBody()
		super.setRequestFactory(ClientHttpRequestFactorySelector.bufferRequests(requestFactory));
	}

	public UserOperations userOperations() {
		return userOperations;
	}
	
	public PlacesOperations placesOperations() {
		return placesOperations;
	}

	public LikeOperations likeOperations() {
		return likeOperations;
	}

	public FriendOperations friendOperations() {
		return friendOperations;
	}
	
	public FeedOperations feedOperations() {
		return feedOperations;
	}
	
	public GroupOperations groupOperations() {
		return groupOperations;
	}

	public CommentOperations commentOperations() {
		return commentOperations;
	}
	
	public EventOperations eventOperations() {
		return eventOperations;
	}
	
	public MediaOperations mediaOperations() {
		return mediaOperations;
	}
	
	public PageOperations pageOperations() {
		return pageOperations;
	}
	
	public AdOperations adOperations() {
	    return adOperations;
	}
	
	// low-level Graph API operations
	public <T> T fetchObject(String objectId, Class<T> type) {
		URI uri = URIBuilder.fromUri(GRAPH_API_URL + objectId).build();
		return getRestTemplate().getForObject(uri, type);
	}
	
	public <T> T fetchObject(String objectId, Class<T> type, MultiValueMap<String, String> queryParameters) {
		URI uri = URIBuilder.fromUri(GRAPH_API_URL + objectId).queryParams(queryParameters).build();
		return getRestTemplate().getForObject(uri, type);
	}

	public <T> List<T> fetchConnections(String objectId, String connectionType, Class<T> type, String... fields) {
		MultiValueMap<String, String> queryParameters = new LinkedMultiValueMap<String, String>();
		if(fields.length > 0) {
			String joinedFields = join(fields);
			queryParameters.set("fields", joinedFields);
		}		
		return fetchConnections(objectId, connectionType, type, queryParameters);
	}

	public <T> List<T> fetchConnections(String objectId, String connectionType, Class<T> type, MultiValueMap<String, String> queryParameters) {
		String connectionPath = connectionType != null && connectionType.length() > 0 ? "/" + connectionType : "";
		URIBuilder uriBuilder = URIBuilder.fromUri(GRAPH_API_URL + objectId + connectionPath).queryParams(queryParameters);		
		JsonNode dataNode = getRestTemplate().getForObject(uriBuilder.build(), JsonNode.class);
		return deserializeDataList(dataNode.get("data"), type);
	}

	public byte[] fetchImage(String objectId, String connectionType, ImageType type) {
		URI uri = URIBuilder.fromUri(GRAPH_API_URL + objectId + "/" + connectionType + "?type=" + type.toString().toLowerCase()).build();
		ResponseEntity<byte[]> response = getRestTemplate().getForEntity(uri, byte[].class);
		if(response.getStatusCode() == HttpStatus.FOUND) {
			throw new UnsupportedOperationException("Attempt to fetch image resulted in a redirect which could not be followed. Add Apache HttpComponents HttpClient to the classpath " +
					"to be able to follow redirects.");
		}
		return response.getBody();
	}
	
	@SuppressWarnings("unchecked")
	public String publish(String objectId, String connectionType, MultiValueMap<String, Object> data) {
		MultiValueMap<String, Object> requestData = new LinkedMultiValueMap<String, Object>(data);
		URI uri = URIBuilder.fromUri(GRAPH_API_URL + objectId + "/" + connectionType).build();
		Map<String, Object> response = getRestTemplate().postForObject(uri, requestData, Map.class);
		return (String) response.get("id");
	}
	
	public void post(String objectId, String connectionType, MultiValueMap<String, String> data) {
		URI uri = URIBuilder.fromUri(GRAPH_API_URL + objectId + "/" + connectionType).build();
		getRestTemplate().postForObject(uri, new LinkedMultiValueMap<String, String>(data), String.class);
	}
	
	public void delete(String objectId) {
		LinkedMultiValueMap<String, String> deleteRequest = new LinkedMultiValueMap<String, String>();
		deleteRequest.set("method", "delete");
		URI uri = URIBuilder.fromUri(GRAPH_API_URL + objectId).build();
		getRestTemplate().postForObject(uri, deleteRequest, String.class);
	}
	
	public void delete(String objectId, String connectionType) {
		LinkedMultiValueMap<String, String> deleteRequest = new LinkedMultiValueMap<String, String>();
		deleteRequest.set("method", "delete");
		URI uri = URIBuilder.fromUri(GRAPH_API_URL + objectId + "/" + connectionType).build();
		getRestTemplate().postForObject(uri, deleteRequest, String.class);
	}
	
	// AbstractOAuth2ApiBinding hooks
	@Override
	protected OAuth2Version getOAuth2Version() {
		return OAuth2Version.DRAFT_10;
	}

	@Override
	protected void configureRestTemplate(RestTemplate restTemplate) {
		restTemplate.setErrorHandler(new FacebookErrorHandler());
	}

	@Override
	protected MappingJacksonHttpMessageConverter getJsonMessageConverter() {
		MappingJacksonHttpMessageConverter converter = super.getJsonMessageConverter();
		objectMapper = new ObjectMapper();				
		objectMapper.registerModule(new FacebookModule());
		converter.setObjectMapper(objectMapper);		
		return converter;
	}
	
	// private helpers
	private void initialize() {
		// Wrap the request factory with a BufferingClientHttpRequestFactory so that the error handler can do repeat reads on the response.getBody()
		super.setRequestFactory(ClientHttpRequestFactorySelector.bufferRequests(getRestTemplate().getRequestFactory()));
		initSubApis();
	}
		
	private void initSubApis() {
		userOperations = new UserTemplate(this, getRestTemplate(), isAuthorized());
		placesOperations = new PlacesTemplate(this, isAuthorized());
		friendOperations = new FriendTemplate(this, getRestTemplate(), isAuthorized());
		feedOperations = new FeedTemplate(this, getRestTemplate(), objectMapper, isAuthorized());
		commentOperations = new CommentTemplate(this, isAuthorized());
		likeOperations = new LikeTemplate(this, isAuthorized());
		eventOperations = new EventTemplate(this, isAuthorized());
		mediaOperations = new MediaTemplate(this, getRestTemplate(), isAuthorized());
		groupOperations = new GroupTemplate(this, isAuthorized());
		pageOperations = new PageTemplate(this, isAuthorized());
		adOperations = new AdTemplate(this, isAuthorized());
	}
	
	@SuppressWarnings("unchecked")
	private <T> List<T> deserializeDataList(JsonNode jsonNode, final Class<T> elementType) {
		try {
			CollectionType listType = TypeFactory.defaultInstance().constructCollectionType(List.class, elementType);
			return (List<T>) objectMapper.readValue(jsonNode, listType);
		} catch (IOException e) {
			throw new UncategorizedApiException("Error deserializing data from Facebook: " + e.getMessage(), e);
		}
	}
	
	private String join(String[] strings) {
		StringBuilder builder = new StringBuilder();
		if(strings.length > 0) {
			builder.append(strings[0]);
			for (int i = 1; i < strings.length; i++) {
				builder.append("," + strings[i]);
			}
		}
		return builder.toString();
	}
	
}
