package org.springframework.social.facebook.api.impl.json;

import java.util.List;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.facebook.api.AdAccountGroup.AdAccount;
import org.springframework.social.facebook.api.AdAccountGroup.User;

//@JsonIgnoreProperties(ignoreUnknown = true)
class AdAccountGroupMixin {

    @JsonCreator
    AdAccountGroupMixin(@JsonProperty("account_group_id") String accountGroupId,
                        @JsonProperty("id") String id,
                        @JsonProperty("name") String name,
                        @JsonProperty("status") int status,
                        @JsonProperty("users") List<User> users,
                        @JsonProperty("accounts") List<AdAccount> accounts) {}

    //@JsonIgnoreProperties(ignoreUnknown = true)
    static class UserMixin {
        @JsonCreator
        UserMixin(@JsonProperty("uid") String uid,
                  @JsonProperty("role") int role) {}
    }

    //@JsonIgnoreProperties(ignoreUnknown = true)
    static class AdAccountMixIn {
        @JsonCreator
        AdAccountMixIn(@JsonProperty("account_id") String accountId,
                       @JsonProperty("status") int status) {}
    }

}
