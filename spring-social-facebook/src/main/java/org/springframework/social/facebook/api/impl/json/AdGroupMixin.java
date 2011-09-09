package org.springframework.social.facebook.api.impl.json;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.facebook.api.AdTargets;

//@JsonIgnoreProperties(ignoreUnknown = true)
class AdGroupMixin {

    @JsonCreator
    AdGroupMixin(@JsonProperty("ad_id") long adId,
                 @JsonProperty("campaign_id") long campaignId,
                 @JsonProperty("name") String name,
                 @JsonProperty("ad_status") int status,
                 @JsonProperty("adgroup_status") int adGroupStatus,
                 @JsonProperty("bid_type") int bidType,
                 @JsonProperty("max_bid") String maxBid,
                 @JsonProperty("targeting") AdTargets targeting,
                 @JsonProperty("creative_ids") List<Long> creativeIds,
                 @JsonProperty("adgroup_id") long adGroupId,
                 @JsonProperty("start_time") Date startTime,
                 @JsonProperty("end_time") Date endTime,
                 @JsonProperty("updated_time") Date updatedTime,
                 @JsonProperty("bid_info") Map<String, String> bidInfo,
                 @JsonProperty("foo") List<String> disapproveReasonDescriptions) {}

}
