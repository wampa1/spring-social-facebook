package org.springframework.social.facebook.api;

import java.util.List;

/**
 * Ad account object on Facebook {@link http://developers.facebook.com/docs/reference/ads-api/adaccount/}
 * 
 * @author Will Taylor
 *
 */
public class AdAccount {

    private final String id;
    private final String accountId;
    private final String name;
    private final int status;
    private final int dailySpendLimit;
    private final List<AdAccountUser> users;
    private final String currency;
    private final int timezoneId;
    private final String timezoneName;
    private final List<String> capabilities; // marked as "reserved for future use"
    private final List<AdAccountGroup> accountGroups;

    public AdAccount(String id, String accountId, String name, int status, int dailySpendLimit, List<AdAccountUser> users, String currency, int timezoneId, String timezoneName, List<String> capabilities, List<AdAccountGroup> accountGroups) {
        this.id = id;
        this.accountId = accountId;
        this.name = name;
        this.status = status;
        this.dailySpendLimit = dailySpendLimit;
        this.users = users;
        this.currency = currency;
        this.timezoneId = timezoneId;
        this.timezoneName = timezoneName;
        this.capabilities = capabilities;
        this.accountGroups = accountGroups;
    }

    public String getId() {
        return id;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getName() {
        return name;
    }

    public int getStatus() {
        return status;
    }

    public int getDailySpendLimit() {
        return dailySpendLimit;
    }

    public List<AdAccountUser> getUsers() {
        return users;
    }

    public String getCurrency() {
        return currency;
    }

    public int getTimezoneId() {
        return timezoneId;
    }

    public String getTimezoneName() {
        return timezoneName;
    }

    public List<String> getCapabilities() {
        return capabilities;
    }

    public List<AdAccountGroup> getAccountGroups() {
        return accountGroups;
    }

}
