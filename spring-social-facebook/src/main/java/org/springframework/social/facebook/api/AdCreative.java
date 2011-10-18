package org.springframework.social.facebook.api;

import java.util.List;


/**
 * @author Eric Mayhew
 *
 * http://developers.facebook.com/docs/reference/ads-api/adcreative/
 * 
 */
public class AdCreative {

	private final String name;
	private final int type;
	private final long objectId;
	private final String body;
	private final String imageHash;
	private final String imageUrl;
	private final long creativeId;
	private final int countCurrentAdGroups; //?? A string?
	private final String title;
	private final int runStatus;
	private final String linkUrl;
	private final String previewUrl;
	private final String viewTag;
	private final List<String> altViewTags;
	private final String id;
	private final String urlTags;

	
	public AdCreative(String name, int type, long objectId, String body, String imageHash, String imageUrl, long creativeId, int countCurrentAdGroups, String title, int runStatus, String linkUrl, String previewUrl, String viewTag, List<String> altViewTags, String id, String urlTags) {
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
	public int getType() {
		return type;
	}
	public long getObjectId() {
		return objectId;
	}
	public String getBody() {
		return body;
	}
	public String getImageHash() {
		return imageHash;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public long getCreativeId() {
		return creativeId;
	}
	public int getCountCurrentAdGroups() {
		return countCurrentAdGroups;
	}
	public String getTitle() {
		return title;
	}
	public int getRunStatus() {
		return runStatus;
	}
	public String getLinkUrl() {
		return linkUrl;
	}
	public String getPreviewUrl() {
		return previewUrl;
	}
    public String getViewTag() {
        return viewTag;
    }
    public List<String> getAltViewTags() {
        return altViewTags;
    }
    public String getId() {
        return id;
    }
    public String getUrlTags() {
        return urlTags;
    }
}
