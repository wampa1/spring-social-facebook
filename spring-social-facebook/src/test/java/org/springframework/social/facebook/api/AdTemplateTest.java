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
        assertEquals("act_6712834698284", adAccount.getId());
        assertEquals("6712834698284", adAccount.getAccountId());
        assertEquals("Some Name", adAccount.getName());
        assertEquals(1, adAccount.getStatus());
        assertEquals("USD", adAccount.getCurrency());
        assertEquals(7, adAccount.getTimezoneId());
        assertEquals("America/New_York", adAccount.getTimezoneName());
        assertEquals(25000, adAccount.getDailySpendLimit());
        assertEquals(Arrays.asList("cap1", "cap2", "cap3"), adAccount.getCapabilities());
        
        List<AdAccountUser> users = adAccount.getUsers();
        assertNotNull(users);
        assertEquals(1, users.size());
        AdAccountUser user = users.get(0);
        assertNotNull(user);
        assertEquals("67284301", user.getUid());
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 7), user.getPermissions());
        assertEquals(1001, user.getRole());
    }

}
