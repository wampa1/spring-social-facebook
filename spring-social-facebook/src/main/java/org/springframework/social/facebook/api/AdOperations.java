package org.springframework.social.facebook.api;

import java.util.List;

public interface AdOperations {

    AdAccount getAdAccount(String adAccountId);

    List<AdGroup> getAdGroups(String adAccountId);

    AdGroup getAdGroup(String adGroupId);

}
