package org.springframework.social.facebook.api.impl.json;

import java.util.List;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

//@JsonIgnoreProperties(ignoreUnknown = true)
class AdCreativeMixin {

    @JsonCreator
    AdCreativeMixin(@JsonProperty("name") String name,
                    @JsonProperty("type") int type,
                    @JsonProperty("object_id") long objectId,
                    @JsonProperty("body") String body,
                    @JsonProperty("image_hash") String imageHash,
                    @JsonProperty("image_url") String imageUrl,
                    @JsonProperty("creative_id") long creativeId,
                    @JsonProperty("count_current_adgroups") int countCurrentAdGroups,
                    @JsonProperty("title") String title,
                    @JsonProperty("run_status") int runStatus,
                    @JsonProperty("link_url") String linkUrl,
                    @JsonProperty("preview_url") String previewUrl,
                    @JsonProperty("view_tag") String viewTag,
                    @JsonProperty("alt_view_tags") List<String> altViewTags,
                    @JsonProperty("id") String id,
                    @JsonProperty("url_tags") String urlTags) {}

}
