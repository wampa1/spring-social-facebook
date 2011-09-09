package org.springframework.social.facebook.api.impl.json;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
class AdAccountGroupMixin {

    @JsonCreator
    AdAccountGroupMixin(@JsonProperty("account_group_id") String id,
                       @JsonProperty("name") String name,
                       @JsonProperty("status") int status) {}

}
