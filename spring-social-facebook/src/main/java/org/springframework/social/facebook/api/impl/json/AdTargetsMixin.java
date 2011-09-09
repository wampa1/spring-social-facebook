package org.springframework.social.facebook.api.impl.json;

import java.util.List;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.facebook.api.AdTargets.BroadAge;
import org.springframework.social.facebook.api.AdTargets.EducationStatus;
import org.springframework.social.facebook.api.AdTargets.Gender;
import org.springframework.social.facebook.api.AdTargets.RelationshipStatus;
import org.springframework.social.facebook.api.AdTargets.UserEvent;
import org.springframework.social.facebook.api.UserAdCluster;

//@JsonIgnoreProperties(ignoreUnknown=true)
public class AdTargetsMixin {

    @JsonCreator
    AdTargetsMixin(@JsonProperty("countries") List<String> countries,
                   @JsonProperty("cities") List<String> cities,
                   @JsonProperty("zips") List<String> zips,
                   @JsonProperty("regions") List<String> regions,
                   @JsonProperty("radius") Integer radius,
                   @JsonProperty("locales") List<String> locales,
                   @JsonProperty("keywords") List<String> keywords,
                   @JsonProperty("user_adclusters") List<UserAdCluster> userAdClusters,
                   @JsonProperty("interested_in") List<Integer> interestedIn,
                   @JsonProperty("genders") List<Gender> genders,
                   @JsonProperty("age_min") Integer ageMin,
                   @JsonProperty("age_max") Integer ageMax,
                   @JsonProperty("broad_age") BroadAge broadAge,
                   @JsonProperty("relationship_statuses") List<RelationshipStatus> relationshipStatuses,
                   @JsonProperty("user_event") UserEvent userEvent,
                   @JsonProperty("connections") List<String> connections,
                   @JsonProperty("excluded_connections") List<String> excludedConnections,
                   @JsonProperty("friends_of_connections") List<String> friendsOfConnections,
                   @JsonProperty("college_networks") List<String> collegeNetworks,
                   @JsonProperty("work_networks") List<String> workNetworks,
                   @JsonProperty("education_statuses") List<EducationStatus> educationStatuses,
                   @JsonProperty("college_years") List<Integer> collegeYears,
                   @JsonProperty("college_majors") List<String> collegeMajors) {}
}
