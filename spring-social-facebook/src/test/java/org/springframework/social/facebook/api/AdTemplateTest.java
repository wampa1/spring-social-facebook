package org.springframework.social.facebook.api;

import static org.junit.Assert.*;
import static org.springframework.http.HttpMethod.*;
import static org.springframework.social.test.client.RequestMatchers.*;
import static org.springframework.social.test.client.ResponseCreators.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.social.facebook.api.AdTargeting.BroadAge;
import org.springframework.social.facebook.api.AdTargeting.EducationStatus;
import org.springframework.social.facebook.api.AdTargeting.Gender;
import org.springframework.social.facebook.api.AdTargeting.RelationshipStatus;
import org.springframework.social.facebook.api.AdTargeting.UserEvent;

/**
 * @author Will Taylor
 */
public class AdTemplateTest extends AbstractFacebookApiTest {

    @Test
    public void getAdAccount() {
        mockServer.expect(requestTo("https://graph.facebook.com/act_123456"))
                  .andExpect(method(GET))
                  .andExpect(header("Authorization", "OAuth someAccessToken"))
                  .andRespond(withResponse(jsonResource("testdata/adaccount"), responseHeaders));

        AdAccount adAccount = facebook.adOperations().getAdAccount("123456");
        assertNotNull(adAccount);
        assertEquals("act_368811234", adAccount.getId());
        assertNull(adAccount.getAccountId());
        assertEquals("My Account Name", adAccount.getName());
        assertEquals(1, adAccount.getStatus());
        assertEquals("USD", adAccount.getCurrency());
        assertEquals(1, adAccount.getTimezoneId());
        assertEquals("America/Los_Angeles", adAccount.getTimezoneName());
        assertEquals(25000, adAccount.getDailySpendLimit());
        assertEquals(Arrays.asList(), adAccount.getCapabilities());

        List<AdAccountUser> users = adAccount.getUsers();
        assertNotNull(users);
        assertEquals(2, users.size());

        AdAccountUser user = users.get(0);
        assertNotNull(user);
        assertEquals("545071234", user.getUid());
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 7), user.getPermissions());
        assertEquals(1002, user.getRole());

        user = users.get(1);
        assertNotNull(user);
        assertEquals("1270651234", user.getUid());
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 7), user.getPermissions());
        assertEquals(1001, user.getRole());
        
        List<AdAccountGroup> groups = adAccount.getAccountGroups();
        assertNotNull(groups);
        assertEquals(1, groups.size());
        AdAccountGroup group = groups.get(0);
        assertNotNull(group);
        assertEquals("121069936651234", group.getAccountGroupId());
        assertEquals("name_of_account_group", group.getName());
        assertEquals(1, group.getStatus());
    }

    @Test
    public void getAdAccountGroupsForUser() {
        mockServer.expect(requestTo("https://graph.facebook.com/123456/adaccountgroups"))
                  .andExpect(method(GET))
                  .andExpect(header("Authorization", "OAuth someAccessToken"))
                  .andRespond(withResponse(jsonResource("testdata/adaccountgroups"), responseHeaders));

        List<AdAccountGroup> adAccountGroups = facebook.adOperations().getAdAccountGroupsForUser("123456");
        assertNotNull(adAccountGroups);
        assertEquals(2, adAccountGroups.size());

        AdAccountGroup group = adAccountGroups.get(0);
        assertNotNull(group);
        assertEquals("112233445566", group.getAccountGroupId());
        assertEquals("Test Account Group 2", group.getName());
        assertEquals(1, group.getStatus());
        assertEquals("112233445566", group.getId());

        List<AdAccountGroup.User> users = group.getUsers();
        assertNotNull(users);
        assertEquals(1, users.size());
        AdAccountGroup.User user = users.get(0);
        assertNotNull(user);
        assertEquals("12345667", user.getUid());
        assertEquals(1001, user.getRole());

        List<AdAccountGroup.AdAccount> accounts = group.getAccounts();
        assertNotNull(accounts);
        assertEquals(1, accounts.size());
        AdAccountGroup.AdAccount account = accounts.get(0);
        assertNotNull(account);
        assertEquals("2345678", account.getAccountId());
        assertEquals(1, account.getStatus());

        group = adAccountGroups.get(1);
        assertNotNull(group);
        assertEquals("223344556677", group.getAccountGroupId());
        assertEquals("Test Account Group 1", group.getName());
        assertEquals(1, group.getStatus());
        assertEquals("223344556677", group.getId());

        users = group.getUsers();
        assertNotNull(users);
        assertEquals(1, users.size());
        user = users.get(0);
        assertNotNull(user);
        assertEquals("12345667", user.getUid());
        assertEquals(1001, user.getRole());

        accounts = group.getAccounts();
        assertNotNull(accounts);
        assertEquals(1, accounts.size());
        account = accounts.get(0);
        assertNotNull(account);
        assertEquals("1234567", account.getAccountId());
        assertEquals(1, account.getStatus());
    }

    @Test
    public void getAdAccountGroup() {
        mockServer.expect(requestTo("https://graph.facebook.com/112233445566"))
                  .andExpect(method(GET))
                  .andExpect(header("Authorization", "OAuth someAccessToken"))
                  .andRespond(withResponse(jsonResource("testdata/adaccountgroup"), responseHeaders));

        AdAccountGroup group = facebook.adOperations().getAdAccountGroup("112233445566");
        assertNotNull(group);
        assertEquals("112233445566", group.getAccountGroupId());
        assertEquals("Test Account Group 2", group.getName());
        assertEquals(1, group.getStatus());
        assertEquals("112233445566", group.getId());

        List<AdAccountGroup.User> users = group.getUsers();
        assertNotNull(users);
        assertEquals(1, users.size());
        AdAccountGroup.User user = users.get(0);
        assertNotNull(user);
        assertEquals("12345667", user.getUid());
        assertEquals(1001, user.getRole());

        List<AdAccountGroup.AdAccount> accounts = group.getAccounts();
        assertNotNull(accounts);
        assertEquals(1, accounts.size());
        AdAccountGroup.AdAccount account = accounts.get(0);
        assertNotNull(account);
        assertEquals("2345678", account.getAccountId());
        assertEquals(1, account.getStatus());
    }

    @Test public void getAdAccountsForUser() {
        mockServer.expect(requestTo("https://graph.facebook.com/123456/adaccounts"))
                  .andExpect(method(GET))
                  .andExpect(header("Authorization", "OAuth someAccessToken"))
                  .andRespond(withResponse(jsonResource("testdata/adaccounts"), responseHeaders));

        List<AdAccount> adAccounts = facebook.adOperations().getAdAccountsForUser("123456");
        assertNotNull(adAccounts);
    }

    @Test
    public void getAdGroups() throws ParseException {
        mockServer.expect(requestTo("https://graph.facebook.com/act_123456/adgroups"))
                  .andExpect(method(GET))
                  .andExpect(header("Authorization", "OAuth someAccessToken"))
                  .andRespond(withResponse(jsonResource("testdata/adgroups"), responseHeaders));

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");

        List<AdGroup> adGroups = facebook.adOperations().getAdGroups("123456");
        assertNotNull(adGroups);
        assertEquals(1, adGroups.size());

        AdGroup adGroup = adGroups.get(0);
        assertNotNull(adGroup);
        assertEquals(df.parse("2011-09-09T12:58:18+0000"), adGroup.getUpdatedTime());

        AdTargeting targeting = adGroup.getTargeting();
        assertNotNull(targeting);
        assertEquals("50", targeting.getRadius());
        assertEquals(18, targeting.getAgeMin().intValue());
        assertEquals(64, targeting.getAgeMax().intValue());
        assertEquals(BroadAge.valueOf(1), targeting.getBroadAge());
        assertEquals(UserEvent.valueOf(1), targeting.getUserEvent());
        assertEquals(Arrays.asList("24", "43", "51", "6"), targeting.getLocales());
        assertEquals(Arrays.asList("05401", "05446", "90210", "90266", "90267"), targeting.getZips());
        assertEquals(Arrays.asList(Gender.valueOf(1), Gender.valueOf(2)), targeting.getGenders());
        assertEquals(Arrays.asList(Gender.valueOf(1), Gender.valueOf(2)), targeting.getInterestedIn());
        assertEquals(Arrays.asList("US", "CA"), targeting.getCountries());
        assertEquals(Arrays.asList("dirtbikes"), targeting.getKeywords());
        assertEquals(Arrays.asList("business", "computer science"), targeting.getCollegeMajors());
        assertEquals(Arrays.asList(2012, 2013, 2014, 2015), targeting.getCollegeYears());
        assertEquals(Arrays.asList(RelationshipStatus.valueOf(1),
                                   RelationshipStatus.valueOf(2),
                                   RelationshipStatus.valueOf(3),
                                   RelationshipStatus.valueOf(4)), targeting.getRelationshipStatuses());
        assertEquals(Arrays.asList(EducationStatus.valueOf(1),
                                   EducationStatus.valueOf(2),
                                   EducationStatus.valueOf(3)), targeting.getEducationStatuses());

        List<Reference> workNetworks = targeting.getWorkNetworks();
        assertNotNull(workNetworks);
        assertEquals(1, workNetworks.size());
        Reference workNetwork = workNetworks.get(0);
        assertNotNull(workNetwork);
        assertEquals("50432078", workNetwork.getId());
        assertEquals("IBM", workNetwork.getName());

        List<Reference> collegeNetworks = targeting.getCollegeNetworks();
        assertNotNull(collegeNetworks);
        assertEquals(1, collegeNetworks.size());
        Reference collegeNetwork = collegeNetworks.get(0);
        assertNotNull(collegeNetwork);
        assertEquals("16777220", collegeNetwork.getId());
        assertEquals("Yale", collegeNetwork.getName());

        List<Reference> cities = targeting.getCities();
        assertNotNull(cities);
        assertEquals(2, cities.size());

        Reference city = cities.get(0);
        assertNotNull(city);
        assertEquals("2420467", city.getId());
        assertEquals("Manhattan Beach, CA", city.getName());

        city = cities.get(1);
        assertNotNull(city);
        assertEquals("2532970", city.getId());
        assertEquals("Burlington, VT", city.getName());

        List<Reference> regions = targeting.getRegions();
        assertNotNull(regions);
        assertEquals(2, regions.size());

        Reference region = regions.get(0);
        assertNotNull(region);
        assertEquals("50", region.getId());
        assertEquals("Vermont", region.getName());

        region = regions.get(1);
        assertNotNull(region);
        assertEquals("6", region.getId());
        assertEquals("California", region.getName());

        List<Reference> connections = targeting.getConnections();
        assertNotNull(connections);
        assertEquals(1, connections.size());
        Reference connection = connections.get(0);
        assertNotNull(connection);
        assertEquals("125614587505822", connection.getId());
        assertEquals("Demo Motors", connection.getName());

        List<Reference> excludedConnections = targeting.getExcludedConnections();
        assertNotNull(excludedConnections);
        assertEquals(1, excludedConnections.size());
        Reference excludedConnection = excludedConnections.get(0);
        assertNotNull(excludedConnection);
        assertEquals("125614587505822", excludedConnection.getId());
        assertEquals("Demo Motors", excludedConnection.getName());

        List<Reference> friendsOfConnections = targeting.getFriendsOfConnections();
        assertNotNull(friendsOfConnections);
        assertEquals(1, friendsOfConnections.size());
        Reference friendsOfConnection = friendsOfConnections.get(0);
        assertNotNull(friendsOfConnection);
        assertEquals("47190376042235", friendsOfConnection.getId());
        assertEquals("Scuba Steve", friendsOfConnection.getName());

        List<Reference> userAdClusters = targeting.getUserAdClusters();
        assertNotNull(userAdClusters);
        assertEquals(3, userAdClusters.size());

        Reference userAdCluster = userAdClusters.get(0);
        assertNotNull(userAdCluster);
        assertEquals("6002714398172", userAdCluster.getId());
        assertEquals("Newlywed (<1 year)", userAdCluster.getName());

        userAdCluster = userAdClusters.get(1);
        assertNotNull(userAdCluster);
        assertEquals("6002714398772", userAdCluster.getId());
        assertEquals("Engaged (<6 months)", userAdCluster.getName());

        userAdCluster = userAdClusters.get(2);
        assertNotNull(userAdCluster);
        assertEquals("6002714885172", userAdCluster.getId());
        assertEquals("Cooking", userAdCluster.getName());
    }

    @Test
    public void getAdGroup() {
        mockServer.expect(requestTo("https://graph.facebook.com/123456"))
                  .andExpect(method(GET))
                  .andExpect(header("Authorization", "OAuth someAccessToken"))
                  .andRespond(withResponse(jsonResource("testdata/adgroup"), responseHeaders));

        AdGroup adGroup = facebook.adOperations().getAdGroup("123456");
        assertNotNull(adGroup);
    }

    @Test public void getCreatives() {
        mockServer.expect(requestTo("https://graph.facebook.com/act_123456/adcreatives"))
                  .andExpect(method(GET))
                  .andExpect(header("Authorization", "OAuth someAccessToken"))
                  .andRespond(withResponse(jsonResource("testdata/adcreatives"), responseHeaders));

        List<AdCreative> creatives = facebook.adOperations().getCreatives("123456");
        assertNotNull(creatives);
        assertEquals(5, creatives.size());

        AdCreative creative = creatives.get(0);
        assertNotNull(creative);
        assertEquals("", creative.getViewTag());
        assertEquals(Arrays.asList(), creative.getAltViewTags());
        assertEquals(6003608508993l, creative.getCreativeId());
        assertEquals(2, creative.getType());
        assertEquals("", creative.getTitle());
        assertEquals("this is some ad copy", creative.getBody());
        assertEquals("1b1134eae61cdd6d9be8499b8dcbe663", creative.getImageHash());
        assertEquals("http://www.facebook.com/demomotors?sk=wall", creative.getLinkUrl());
        assertEquals(125614587505822l, creative.getObjectId());
        assertEquals("Demo Motors-00", creative.getName());
        assertEquals(1, creative.getRunStatus());
        assertEquals("http://www.facebook.com/ads/api/creative_preview.php?cid=6003608508993", creative.getPreviewUrl());
        assertEquals(0, creative.getCountCurrentAdGroups());
        assertEquals("6003608508993", creative.getId());
        assertEquals("http://creative.ak.fbcdn.net/v41818/flyers/35/10/1315831679242172105_1_e0cee20a.jpg", creative.getImageUrl());
        assertNull( creative.getUrlTags());
    }

    @Test public void getCreative() {
        mockServer.expect(requestTo("https://graph.facebook.com/123456"))
                  .andExpect(method(GET))
                  .andExpect(header("Authorization", "OAuth someAccessToken"))
                  .andRespond(withResponse(jsonResource("testdata/adcreative"), responseHeaders));

        AdCreative creative = facebook.adOperations().getCreative("123456");
        assertNotNull(creative);
        assertEquals("", creative.getViewTag());
        assertEquals(Arrays.asList(), creative.getAltViewTags());
        assertEquals(6003608508993l, creative.getCreativeId());
        assertEquals(2, creative.getType());
        assertEquals("", creative.getTitle());
        assertEquals("this is some ad copy", creative.getBody());
        assertEquals("1b1134eae61cdd6d9be8499b8dcbe663", creative.getImageHash());
        assertEquals("http://www.facebook.com/demomotors?sk=wall", creative.getLinkUrl());
        assertEquals(125614587505822l, creative.getObjectId());
        assertEquals("Demo Motors-00", creative.getName());
        assertEquals(1, creative.getRunStatus());
        assertEquals("http://www.facebook.com/ads/api/creative_preview.php?cid=6003608508993", creative.getPreviewUrl());
        assertEquals(0, creative.getCountCurrentAdGroups());
        assertEquals("6003608508993", creative.getId());
        assertEquals("http://creative.ak.fbcdn.net/v41818/flyers/35/10/1315831679242172105_1_e0cee20a.jpg", creative.getImageUrl());
        assertNull( creative.getUrlTags());
    }

    @Test
    public void getAdCampaigns() {
        fail("test not yet written");
    }

    @Test
    public void getAdCampaign() {
        fail("test not yet written");
    }

    @Test
    public void getAdGroupsForCampaign() {
        fail("test not yet written");
    }

}
