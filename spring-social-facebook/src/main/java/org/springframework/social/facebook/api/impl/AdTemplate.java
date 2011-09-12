package org.springframework.social.facebook.api.impl;

import java.util.List;

import org.springframework.social.facebook.api.AdAccount;
import org.springframework.social.facebook.api.AdAccountGroup;
import org.springframework.social.facebook.api.AdCampaign;
import org.springframework.social.facebook.api.AdCreative;
import org.springframework.social.facebook.api.AdGroup;
import org.springframework.social.facebook.api.AdOperations;
import org.springframework.social.facebook.api.GraphApi;

public class AdTemplate extends AbstractFacebookOperations implements AdOperations {

    private static final String ACT_PREFIX = "act_";

    private final GraphApi graphApi;
    
    public AdTemplate(GraphApi graphApi, boolean isAuthorized) {
        super(isAuthorized);
        this.graphApi = graphApi;
    }

    @Override
    public List<AdAccountGroup> getAdAccountGroupsForUser(String userId) {
        return graphApi.fetchConnections(userId, "adaccountgroups", AdAccountGroup.class);
    }

    @Override
    public AdAccountGroup getAdAccountGroup(String adAccountGroupId) {
        return graphApi.fetchObject(adAccountGroupId, AdAccountGroup.class);
    }

    @Override
    public List<AdAccount> getAdAccountsForUser(String userId) {
        return graphApi.fetchConnections(userId, "adaccounts", AdAccount.class);
    }

    @Override
    public AdAccount getAdAccount(String adAccountId) {
        return graphApi.fetchObject(ACT_PREFIX + adAccountId, AdAccount.class);
    }

    @Override
    public List<AdGroup> getAdGroups(String adAccountId) {
        return graphApi.fetchConnections(ACT_PREFIX + adAccountId, "adgroups", AdGroup.class);
    }

    @Override
    public AdGroup getAdGroup(String adGroupId) {
        return graphApi.fetchObject(adGroupId, AdGroup.class);
    }

    @Override
    public List<AdCreative> getCreatives(String adAccountId) {
        return graphApi.fetchConnections(ACT_PREFIX + adAccountId, "adcreatives", AdCreative.class);
    }

    @Override
    public AdCreative getCreative(String creativeId) {
        return graphApi.fetchObject(creativeId, AdCreative.class);
    }

    @Override
    public List<AdCampaign> getAdCampaigns(String adAccountId) {
        return graphApi.fetchConnections(ACT_PREFIX + adAccountId, "adcampaigns", AdCampaign.class);
    }

    @Override
    public AdCampaign getAdCampaign(String campaignId) {
        return graphApi.fetchObject(campaignId, AdCampaign.class);
    }

    @Override
    public List<AdGroup> getAdGroupsForCampaign(String campaignId) {
        return graphApi.fetchConnections(campaignId, "adgroups", AdGroup.class);
    }

}
