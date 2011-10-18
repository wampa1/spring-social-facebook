package org.springframework.social.facebook.api;

import java.util.List;

public class AdTargeting {

	// Location Targets
	private final List<String> countries;
	private final List<Reference> cities;
	private final List<String> zips;
	private final List<Reference> regions;
	private final String radius;
	private final List<String> locales;
	
	// Likes / Interest Targets	
	private final List<String> keywords;
	private final List<Reference> userAdClusters;	
	private final List<Gender> interestedIn;
	
	// Demographics / Events
	private final List<Gender> genders;
	private final Integer ageMin;
	private final Integer ageMax;
	private final BroadAge broadAge;
	private final List<RelationshipStatus> relationshipStatuses;
	private final UserEvent userEvent;
	
	// Facebook Connections
	private final List<Reference> connections;
	private final List<Reference> excludedConnections;
	private final List<Reference> friendsOfConnections;
	
	// Education and Work
	private final List<Reference> collegeNetworks;
	private final List<Reference> workNetworks;
	private final List<EducationStatus> educationStatuses;
	private final List<Integer> collegeYears;
	private final List<String> collegeMajors;
	
	public AdTargeting(List<String> countries, List<Reference> cities, List<String> zips, List<Reference> regions, String radius, List<String> locales, List<String> keywords, List<Reference> userAdClusters, List<Gender> interestedIn, List<Gender> genders, Integer ageMin, Integer ageMax, BroadAge broadAge, List<RelationshipStatus> relationshipStatuses, UserEvent userEvent, List<Reference> connections, List<Reference> excludedConnections, List<Reference> friendsOfConnections, List<Reference> collegeNetworks, List<Reference> workNetworks, List<EducationStatus> educationStatuses, List<Integer> collegeYears, List<String> collegeMajors) {
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

	public List<Gender> getGenders( ) {
		return genders;
	}

	public List<String> getCountries() {
		return countries;
	}

	public List<Reference> getCities() {
		return cities;
	}

	public List<String> getZips() {
		return zips;
	}

	public List<Reference> getRegions() {
		return regions;
	}

	public String getRadius() {
		return radius;
	}

	public List<String> getLocales() {
		return locales;
	}

	public List<String> getKeywords() {
		return keywords;
	}

	public List<Reference> getUserAdClusters() {
		return userAdClusters;
	}

	public List<Gender> getInterestedIn() {
		return interestedIn;
	}

	public Integer getAgeMin() {
		return ageMin;
	}

	public Integer getAgeMax() {
		return ageMax;
	}

	public BroadAge getBroadAge() {
		return broadAge;
	}

	public List<RelationshipStatus> getRelationshipStatuses() {
		return relationshipStatuses;
	}

	public UserEvent getUserEvent() {
		return userEvent;
	}

	public List<Reference> getConnections() {
		return connections;
	}

	public List<Reference> getExcludedConnections() {
		return excludedConnections;
	}

	public List<Reference> getFriendsOfConnections() {
		return friendsOfConnections;
	}

	public List<Reference> getCollegeNetworks() {
		return collegeNetworks;
	}

	public List<Reference> getWorkNetworks() {
		return workNetworks;
	}

	public List<EducationStatus> getEducationStatuses() {
		return educationStatuses;
	}

	public List<Integer> getCollegeYears() {
		return collegeYears;
	}

	public List<String> getCollegeMajors() {
		return collegeMajors;
	}

	public enum Gender {
		UNUSED_0(0), MALE(1), FEMALE(2);
		private final int gender;
		private Gender(int gender){ this.gender = gender; }
		public int getGender() { return gender; }
		public static Gender valueOf(int gender) {
		    Gender result = null;
		    
		    switch ( gender ) {
		    case 1:
		        result = MALE;
		        break;
		    case 2:
		        result = FEMALE;
		        break;
		    default:
		        throw new EnumConstantNotPresentException(Gender.class, String.valueOf(gender));
		    }
		    
		    return result;
		}
	}

	public enum BroadAge {
		UNUSED_0(0), ENABLED(1);
		private final int broadAge;
		private BroadAge(int broadAge){ this.broadAge = broadAge; }
		public int getBroadAge() { return broadAge; }
		public static BroadAge valueOf(int broadAge) {
		    BroadAge result = null;
		    
		    switch ( broadAge ) {
		    case 1:
		        result = ENABLED;
		        break;
		    default:
		        throw new EnumConstantNotPresentException(BroadAge.class, String.valueOf(broadAge));
		    }
		    
		    return result;
		}
	}
	
	public enum RelationshipStatus {
		UNUSED_0(0), SINGLE(1), IN_RELATIONSHIP(2), MARRIED(3), ENGAGED(4);
		private final int relationshipStatus;
		private RelationshipStatus(int relationshipStatus){ this.relationshipStatus = relationshipStatus; }
		public int getRelationshipStatus() { return relationshipStatus; }
		public static RelationshipStatus valueOf(int relationshipStatus) {
		    RelationshipStatus result = null;
		    
		    switch ( relationshipStatus ) {
		    case 1:
		        result = SINGLE;
		        break;
		    case 2:
		        result = IN_RELATIONSHIP;
		        break;
		    case 3:
		        result = MARRIED;
		        break;
		    case 4:
		        result = ENGAGED;
		        break;
		    default:
		        throw new EnumConstantNotPresentException(RelationshipStatus.class, String.valueOf(relationshipStatus));
		    }
		    
		    return result;
		}
	}

	public enum UserEvent {
		UNUSED_0(0), BIRTHDAY(1);
		private final int userEvent;
		private UserEvent(int userEvent){ this.userEvent = userEvent; }
		public int getUserEvent() { return userEvent; }
		public static UserEvent valueOf(int userEvent) {
		    UserEvent result = null;
		    
		    switch ( userEvent ) {
		    case 1:
		        result = BIRTHDAY;
		        break;
		    default:
		        throw new EnumConstantNotPresentException(UserEvent.class, String.valueOf(userEvent));
		    }
		    
		    return result;
		}
	}

	public enum EducationStatus {
		UNUSED_0(0), HIGH_SCHOOL(1), UNDERGRAD(2), ALUM(3);
		private final int educationStatus;
		private EducationStatus(int educationStatus){ this.educationStatus = educationStatus; }
		public int getEducationStatus() { return educationStatus; }
		public static EducationStatus valueOf(int educationStatus) {
		    EducationStatus result = null;
		    
		    switch ( educationStatus ) {
		    case 1:
		        result = HIGH_SCHOOL;
		        break;
		    case 2:
		        result = UNDERGRAD;
		        break;
		    case 3:
		        result = ALUM;
		        break;
		    default:
		        throw new EnumConstantNotPresentException(EducationStatus.class, String.valueOf(educationStatus));
		    }
		    
		    return result;
		}
	}
		

}
