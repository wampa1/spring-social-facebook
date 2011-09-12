package org.springframework.social.facebook.api;

import java.util.List;


/**
 * @author Eric Mayhew
 *
 * http://developers.facebook.com/docs/reference/ads-api/adcreative/
 * 
 */
public class AdCreative {

	private String name;
	private String type;
	private long objectId;
	private String body;
	private String imageHash;
	private String imageUrl;
	private long creativeId;
	private String countCurrentAdGroups; //?? A string?
	private String title;
	private String runStatus;
	private String linkUrl;
	private String previewUrl;
	private String viewTag;
	private List<String> altViewTags;
	private String id;
	private String urlTags;

	
	public AdCreative(String name, String type, long objectId, String body, String imageHash, String imageUrl, long creativeId, String countCurrentAdGroups, String title, String runStatus, String linkUrl, String previewUrl, String viewTag, List<String> altViewTags, String id, String urlTags) {
        this.name = name;
        this.type = type;
        this.objectId = objectId;
        this.body = body;
        this.imageHash = imageHash;
        this.imageUrl = imageUrl;
        this.creativeId = creativeId;
        this.countCurrentAdGroups = countCurrentAdGroups;
        this.title = title;
        this.runStatus = runStatus;
        this.linkUrl = linkUrl;
        this.previewUrl = previewUrl;
        this.viewTag = viewTag;
        this.altViewTags = altViewTags;
        this.id = id;
        this.urlTags = urlTags;
    }

    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public long getObjectId() {
		return objectId;
	}
	public void setObjectId(long objectId) {
		this.objectId = objectId;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getImageHash() {
		return imageHash;
	}
	public void setImageHash(String imageHash) {
		this.imageHash = imageHash;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public long getCreativeId() {
		return creativeId;
	}
	public void setCreativeId(long creativeId) {
		this.creativeId = creativeId;
	}
	public String getCountCurrentAdGroups() {
		return countCurrentAdGroups;
	}
	public void setCountCurrentAdGroups(String countCurrentAdGroups) {
		this.countCurrentAdGroups = countCurrentAdGroups;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRunStatus() {
		return runStatus;
	}
	public void setRunStatus(String runStatus) {
		this.runStatus = runStatus;
	}
	public String getLinkUrl() {
		return linkUrl;
	}
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
	public String getPreviewUrl() {
		return previewUrl;
	}
	public void setPreviewUrl(String previewUrl) {
		this.previewUrl = previewUrl;
	}

    public String getViewTag() {
        return viewTag;
    }

    public void setViewTag(String viewTag) {
        this.viewTag = viewTag;
    }

    public List<String> getAltViewTags() {
        return altViewTags;
    }

    public void setAltViewTags(List<String> altViewTags) {
        this.altViewTags = altViewTags;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrlTags() {
        return urlTags;
    }

    public void setUrlTags(String urlTags) {
        this.urlTags = urlTags;
    }
	
}
