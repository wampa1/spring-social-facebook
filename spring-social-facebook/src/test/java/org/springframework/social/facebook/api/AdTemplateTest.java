package org.springframework.social.facebook.api;

import static org.junit.Assert.*;
import static org.springframework.http.HttpMethod.*;
import static org.springframework.social.test.client.RequestMatchers.*;
import static org.springframework.social.test.client.ResponseCreators.*;

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

}
