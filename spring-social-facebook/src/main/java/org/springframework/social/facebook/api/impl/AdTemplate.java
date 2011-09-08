package org.springframework.social.facebook.api.impl;

import org.springframework.social.facebook.api.AdOperations;
import org.springframework.social.facebook.api.GraphApi;

public class AdTemplate extends AbstractFacebookOperations implements AdOperations {

    private final GraphApi graphApi;
    
    public AdTemplate(GraphApi graphApi, boolean isAuthorized) {
        super(isAuthorized);
        this.graphApi = graphApi;
    }

}
