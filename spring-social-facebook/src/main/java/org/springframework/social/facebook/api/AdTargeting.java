package org.springframework.social.facebook.api;

import java.util.List;

public class AdTargeting {

	// Location Targets
	private List<String> countries;
	private List<City> cities;
	private List<String> zips;
	private List<String> regions;
	private String radius;
	private List<String> locales;
	
	// Likes / Interest Targets	
	private List<String> keywords;
	private List<UserAdCluster> userAdClusters;	
	private List<Integer> interestedIn;
	
	// Demographics / Events
	private List<Gender> genders;
	private Integer ageMin;
	private Integer ageMax;
	private BroadAge broadAge;
	private List<RelationshipStatus> relationshipStatuses;
	private UserEvent userEvent;
	
	// Facebook Connections
	private List<String> connections;
	private List<String> excludedConnections;
	private List<String> friendsOfConnections;
	
	// Education and Work
	private List<String> collegeNetworks;
	private List<String> workNetworks;
	private List<EducationStatus> educationStatuses;
	private List<Integer> collegeYears;
	private List<String> collegeMajors;
	
	public AdTargeting(List<String> countries, List<City> cities, List<String> zips, List<String> regions, String radius, List<String> locales, List<String> keywords, List<UserAdCluster> userAdClusters, List<Integer> interestedIn, List<Gender> genders, Integer ageMin, Integer ageMax, BroadAge broadAge, List<RelationshipStatus> relationshipStatuses, UserEvent userEvent, List<String> connections, List<String> excludedConnections, List<String> friendsOfConnections, List<String> collegeNetworks, List<String> workNetworks, List<EducationStatus> educationStatuses, List<Integer> collegeYears, List<String> collegeMajors) {
        this.countries = countries;
        this.cities = cities;
        this.zips = zips;
        this.regions = regions;
        this.radius = radius;
        this.locales = locales;
        this.keywords = keywords;
        this.userAdClusters = userAdClusters;
        this.interestedIn = interestedIn;
        this.genders = genders;
        this.ageMin = ageMin;
        this.ageMax = ageMax;
        this.broadAge = broadAge;
        this.relationshipStatuses = relationshipStatuses;
        this.userEvent = userEvent;
        this.connections = connections;
        this.excludedConnections = excludedConnections;
        this.friendsOfConnections = friendsOfConnections;
        this.collegeNetworks = collegeNetworks;
        this.workNetworks = workNetworks;
        this.educationStatuses = educationStatuses;
        this.collegeYears = collegeYears;
        this.collegeMajors = collegeMajors;
    }

    public void setGenders( List<Gender> genders ) {
		this.genders = genders;
	}
	
	public List<Gender> getGenders( ) {
		return genders;
	}

	public List<String> getCountries() {
		return countries;
	}

	public void setCountries(List<String> countries) {
		this.countries = countries;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public List<String> getZips() {
		return zips;
	}

	public void setZips(List<String> zips) {
		this.zips = zips;
	}

	public List<String> getRegions() {
		return regions;
	}

	public void setRegions(List<String> regions) {
		this.regions = regions;
	}

	public String getRadius() {
		return radius;
	}

	public void setRadius(String radius) {
		this.radius = radius;
	}

	public List<String> getLocales() {
		return locales;
	}

	public void setLocales(List<String> locales) {
		this.locales = locales;
	}

	public List<String> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}

	public List<UserAdCluster> getUserAdClusters() {
		return userAdClusters;
	}

	public void setUserAdClusters(List<UserAdCluster> userAdClusters) {
		this.userAdClusters = userAdClusters;
	}

	public List<Integer> getInterestedIn() {
		return interestedIn;
	}

	public void setInterestedIn(List<Integer> interestedIn) {
		this.interestedIn = interestedIn;
	}

	public Integer getAgeMin() {
		return ageMin;
	}

	public void setAgeMin(Integer ageMin) {
		this.ageMin = ageMin;
	}

	public Integer getAgeMax() {
		return ageMax;
	}

	public void setAgeMax(Integer ageMax) {
		this.ageMax = ageMax;
	}

	public BroadAge getBroadAge() {
		return broadAge;
	}

	public void setBroadAge(BroadAge broadAge) {
		this.broadAge = broadAge;
	}

	public List<RelationshipStatus> getRelationshipStatuses() {
		return relationshipStatuses;
	}

	public void setRelationshipStatuses(List<RelationshipStatus> relationshipStatus) {
		this.relationshipStatuses = relationshipStatus;
	}

	public UserEvent getUserEvent() {
		return userEvent;
	}

	public void setUserEvent(UserEvent userEvent) {
		this.userEvent = userEvent;
	}

	public List<String> getConnections() {
		return connections;
	}

	public void setConnections(List<String> connections) {
		this.connections = connections;
	}

	public List<String> getExcludedConnections() {
		return excludedConnections;
	}

	public void setExcludedConnections(List<String> excludedConnections) {
		this.excludedConnections = excludedConnections;
	}

	public List<String> getFriendsOfConnections() {
		return friendsOfConnections;
	}

	public void setFriendsOfConnections(List<String> friendsOfConnections) {
		this.friendsOfConnections = friendsOfConnections;
	}

	public List<String> getCollegeNetworks() {
		return collegeNetworks;
	}

	public void setCollegeNetworks(List<String> collegeNetworks) {
		this.collegeNetworks = collegeNetworks;
	}

	public List<String> getWorkNetworks() {
		return workNetworks;
	}

	public void setWorkNetworks(List<String> workNetworks) {
		this.workNetworks = workNetworks;
	}

	public List<EducationStatus> getEducationStatuses() {
		return educationStatuses;
	}

	public void setEducationStatuses(List<EducationStatus> educationStatuses) {
		this.educationStatuses = educationStatuses;
	}

	public List<Integer> getCollegeYears() {
		return collegeYears;
	}

	public void setCollegeYears(List<Integer> collegeYears) {
		this.collegeYears = collegeYears;
	}

	public List<String> getCollegeMajors() {
		return collegeMajors;
	}

	public void setCollegeMajors(List<String> collegeMajors) {
		this.collegeMajors = collegeMajors;
	}

	
	public enum Gender {
		MALE(1), FEMALE(2), ALL(null);
		private Integer gender;
		private Gender(Integer gender){ this.gender = gender; }
		public Integer getGender() { return gender; }
		public void setGender(Integer gender) { this.gender = gender; }
	}

	public enum BroadAge {
		DISABLED(0), ENABLED(1);
		private Integer broadAge;
		private BroadAge(Integer broadAge){ this.broadAge = broadAge; }
		public Integer getBroadAge() { return broadAge; }
		public void setBroadAge(Integer broadAge) { this.broadAge = broadAge; }
	}
	
	public enum RelationshipStatus {
		SINGLE(1), IN_RELATIONSHIP(2), MARRIED(3), ENGAGED(4), ALL(null);
		private Integer relationshipStatus;
		private RelationshipStatus(Integer relationshipStatus){ this.relationshipStatus = relationshipStatus; }
		public Integer getRelationshipStatus() { return relationshipStatus; }
		public void setRelationshipStatus(Integer relationshipStatus) { this.relationshipStatus = relationshipStatus; }
	}

	public enum UserEvent {
		BIRTHDAY(1), NULL(null);
		private Integer userEvent;
		private UserEvent(Integer userEvent){ this.userEvent = userEvent; }
		public Integer getUserEvent() { return userEvent; }
		public void setUserEvent(Integer userEvent) { this.userEvent = userEvent; }
	}

	public enum EducationStatus {
		HIGH_SCHOOL(1), UNDERGRAD(2), ALUM(3) ;
		private Integer educationStatus;
		private EducationStatus(Integer educationStatus){ this.educationStatus = educationStatus; }
		public Integer getEducationStatus() { return educationStatus; }
		public void setEducationStatus(Integer educationStatus) { this.educationStatus = educationStatus; }
	}
		

}
