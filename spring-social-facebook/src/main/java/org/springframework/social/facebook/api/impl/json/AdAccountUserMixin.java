package org.springframework.social.facebook.api.impl.json;

import java.util.List;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

//@JsonIgnoreProperties(ignoreUnknown = true)
class AdAccountUserMixin {

    @JsonCreator
    AdAccountUserMixin(@JsonProperty("uid") String uid,
                       @JsonProperty("permissions") List<Integer> permissions,
                       @JsonProperty("role") int role) {}

}
