package org.springframework.social.facebook.api.impl;

import org.springframework.social.facebook.api.AdAccount;
import org.springframework.social.facebook.api.AdOperations;
import org.springframework.social.facebook.api.GraphApi;

public class AdTemplate extends AbstractFacebookOperations implements AdOperations {

    private static final String ACT_PREFIX = "act_";

    private final GraphApi graphApi;
    
    public AdTemplate(GraphApi graphApi, boolean isAuthorized) {
        super(isAuthorized);
        this.graphApi = graphApi;
    }

    public AdAccount getAdAccount(String adAccountId) {
        return graphApi.fetchObject(ACT_PREFIX + adAccountId, AdAccount.class);
    }

}
