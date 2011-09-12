package org.springframework.social.facebook.api;

import java.util.List;

public interface AdOperations {

    List<AdAccountGroup> getAdAccountGroupsForUser(String userId);

    AdAccountGroup getAdAccountGroup(String adAccountGroupId);

    List<AdAccount> getAdAccountsForUser(String userId);

    AdAccount getAdAccount(String adAccountId);

    List<AdGroup> getAdGroups(String adAccountId);

    AdGroup getAdGroup(String adGroupId);

    List<AdCreative> getCreatives(String adAccountId);

    AdCreative getCreative(String creativeId);

    List<AdCampaign> getAdCampaigns(String adAccountId);

    AdCampaign getAdCampaign(String campaignId);

    List<AdGroup> getAdGroupsForCampaign(String campaignId);

}
