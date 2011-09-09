package org.springframework.social.facebook.api;

import java.util.List;


//Name	Type	Description
//countries	array	The countries parameter is the only required targeting parameter. It must be an array of country names. To use the complete list, incorporate the Autocomplete file (referenced above) into your app. Limit: 25 countries.
//cities	array	Use the complete cities list by incorporating the Autocomplete file (referenced above) into your app. For example, specify "id":"2421215","name":"Palo Alto, CA". Alternatively, for cities in the US or Canada, specify the two letter state or province code, e.g. "name":"New York,NY" (or for international cities, the country name, e.g. "name":"Paris,France"). Limit: 200 cities.
//zips	array	String array of 5-digit ZIP codes (postal codes) specified by the United States Postal Service. For example: '94304'. Currently, the zips parameter does not support international postal codes, autocomplete, the radius parameter, or a countries parameter specification outside of 'US'. Limit: 2500 zip codes.
//regions	array	State, province, or region. To use the complete list, incorporate the Autocomplete file (referenced above) into your app. Limit: 200 regions.
//radius	int	Must be used in conjunction with cities. Specifies a radius around cities.
//locales	array	Array of locales, specified as indices. The indices are in a sub-array called 'locales'. To use the complete list, incorporate the Autocomplete file (referenced above) into your app. Use of this parameter includes for targeting users with a different language than the common language for the specified location parameter; you specify an ID for the language, e.g. 5 for German. Limit: 50 locales.
//
//
//		keywords	array	Array of keyword strings for precise interest targeting. The keywords parameter applies only to precise interest targeting. See topic targeting. Keywords (either topic keywords or non-topic keywords) are matched to data from users' profiles. For example, if an advertiser sells cameras, targeting parameters could specify users who are interested in photography. You can post targeting data to /act_{account-id}/reachestimate to determine if proposed keywords match any profiles. Limit: 200 keywords.
//user_adclusters	array	Array of ID-name pairs for broad-category targeting (BCT). The user_adclusters parameter applies only for BCT, which cannot be used with precise interest targeting. To include BCT in an ad, use act_{account-id}/broadtargetingcategories. For an example of how to use this parameter, see broad category targeting, above. Limit: 50 ID-name pairs.
//interested_in	array	Indicates targeting based on the "interested in" field of the user profile. You can specify an integer of 1 to indicate MALE (for example, if you specify "interested_in":[1]). An integer of 2 indicates FEMALE. The default of ALL is used if you specify Null. The default of ALL is also used if you do not specify the field. Do not specify zero.
//Demographics and events
//Name	Type	Description
//genders	array	Indicates gender-based targeting. You can specify an integer of 1 to indicate MALE (for example, if you specify "genders":[1]). An integer of 2 indicates FEMALE. The default of ALL is used if you specify Null. The default of ALL is also used if you do not specify the field. Do not specify zero.
//age_min	int	Minimum age. If used, must be 13 or higher.
//age_max	int	Maximum age.
//broad_age	int	Whether or not to enable "broad-age-match" targeting. The default is 0 (disabled). Set to 1 to enable broad-age-match targeting.
//relationship_statuses	array	Array of integers for targeting based on relationship status. Use 1 for SINGLE, 2 for IN_RELATIONSHIP, 3 for MARRIED, and 4 for ENGAGED. The default of ALL is used if you specify Null. The default of ALL is also used if you do not specify the field. Do not specify zero.
//user_event	array	Array of integers corresponding to user-relevant events. Currently only supports birthday. To use birthday, pass a one-member array with a value of 1, e.g. "user_event":[1].
//Facebook connections
//Name	Type	Description
//connections	array	An array of Facebook IDs. Connections allows you to target your ads to users who have become a fan of your Page, a member of your Group, RSVPÕd to your Event or authorized your Application. The session user has to be an admin of the page, group or event, or developer of the application that is being targeted against. Limit: 50 connections.
//excluded_connections	array	An array of Facebook IDs. Excluded connections allows you to target your ads to users who have not become fans of your Page, members of your Group, RSVP'd to your Event or authorized your Application. The session user has to be an admin of the page, group or event, or developer of the application that is being targeted against.
//friends_of_connections	array	An array of Facebook IDs. "Friends of connections" allows you to target friends of your connections. Connections are fans of your Page, users who have RSVPÕd Yes or Maybe to your Event, members of your Group, and users who have interacted with your app. The session user has to be an admin of the page, group or event, or a developer of the application that is being targeted against.
//Education and work
//Note that for the complete list of work networks, and of college networks and majors, the Autocomplete file (referenced above) should be downloaded and incorporated into your app.
//
//Name	Type	Description
//college_networks	array	Colleges, for college graduates. Limit: 200 college networks.
//work_networks	array	Company, organization, or other workplace. Limit: 200 work networks.
//education_statuses	array	Array of integers for targeting based on education level. Use 1 for HIGH_SCHOOL, 2 for UNDERGRAD, and 3 for ALUM. For one ad group, you can specify only one value. The education_statuses parameter is required if you specify the college_majors parameter.
//college_years	array	Array of integers for graduation year from college.
//college_majors	array	Array of strings for specific college majors. Requires that you also specify a value for the education_statuses parameter. Limit: 200 college majors.

public class AdTargets {

	// Location Targets
	private List<String> countries;
	private List<String> cities;
	private List<String> zips;
	private List<String> regions;
	private int radius;
	private List<String> locales;
	
	// Likes / Interest Targets
	
	private List<String> keywords;
	
	private List<Integer> interestedIn;
	
	
}
