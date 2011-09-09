package org.springframework.social.facebook.api;


/**
 * @author Eric Mayhew
 *
 * http://developers.facebook.com/docs/reference/ads-api/adcreative/
 * 
 */
public class AdCreative {

	private String name;
	private String type;
	private int objectId;
	private String body;
	private String imageHash;
	private String imageUrl;
	private int creativeId;
	private String countCurrentAdGroups; //?? A string?
	private String title;
	private String runStatus;
	private String linkUrl;
	private String previewUrl;

	
	public AdCreative() {
		super();
	}
	
	public AdCreative(String name, String type, int objectId, String body,
			String imageHash, String imageUrl, int creativeId,
			String countCurrentAdGroups, String title, String runStatus,
			String linkUrl, String previewUrl) {
		super();
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
	public int getObjectId() {
		return objectId;
	}
	public void setObjectId(int objectId) {
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
	public int getCreativeId() {
		return creativeId;
	}
	public void setCreativeId(int creativeId) {
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
	
	
	
}
