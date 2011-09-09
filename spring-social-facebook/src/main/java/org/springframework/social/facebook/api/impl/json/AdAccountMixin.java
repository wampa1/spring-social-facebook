package org.springframework.social.facebook.api.impl.json;

import java.util.List;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.facebook.api.AdAccountGroup;
import org.springframework.social.facebook.api.AdAccountUser;

@JsonIgnoreProperties(ignoreUnknown = true)
class AdAccountMixin {

    @JsonCreator
    AdAccountMixin(@JsonProperty("id") String id,
                   @JsonProperty("account_id") String accountId,
                   @JsonProperty("name") String name,
                   @JsonProperty("account_status") int status,
                   @JsonProperty("daily_spend_limit") int dailySpendLimit,
                   @JsonProperty("users") List<AdAccountUser> users,
                   @JsonProperty("currency") String currency,
                   @JsonProperty("timezone_id") int timezoneId,
                   @JsonProperty("timezone_name") String timezoneName,
                   @JsonProperty("capabilities") List<String> capabilities,
                   @JsonProperty("account_groups") List<AdAccountGroup> accountGroups) {}

}
