package org.springframework.social.facebook.api.impl.json;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

//@JsonIgnoreProperties(ignoreUnknown = true)
class CityMixin {

    @JsonCreator
    CityMixin(@JsonProperty("id") String id,
              @JsonProperty("name") String name) {}

}
