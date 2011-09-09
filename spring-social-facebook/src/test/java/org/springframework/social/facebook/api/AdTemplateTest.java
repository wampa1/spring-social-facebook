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
        
        List<City> cities = targeting.getCities();
        assertNotNull(cities);
        assertEquals(2, cities.size());
        
        City city = cities.get(0);
        assertNotNull(city);
        assertEquals("2420467", city.getId());
        assertEquals("Manhattan Beach, CA", city.getName());
        
        city = cities.get(1);
        assertNotNull(city);
        assertEquals("2532970", city.getId());
        assertEquals("Burlington, VT", city.getName());
        
        List<Region> regions = targeting.getRegions();
        assertNotNull(regions);
        assertEquals(2, regions.size());
        
        Region region = regions.get(0);
        assertNotNull(region);
        assertEquals("50", region.getId());
        assertEquals("Vermont", region.getName());
        
        region = regions.get(1);
        assertNotNull(region);
        assertEquals("6", region.getId());
        assertEquals("California", region.getName());
        
        List<String> zips = targeting.getZips();
        assertNotNull(zips);
        assertEquals(Arrays.asList("05401", "05446", "90210", "90266", "90267"), zips);
        
        List<String> countries = targeting.getCountries();
        assertNotNull(countries);
        assertEquals(Arrays.asList("US", "CA"), countries);
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
    }
    
}
