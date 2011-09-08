package org.springframework.social.facebook.api;

import java.util.List;

/**
 * Ad account object on Facebook {@link http://developers.facebook.com/docs/reference/ads-api/adaccount/}
 * 
 * @author Will Taylor
 *
 */
public class AdAccount {

    private String accountId;
    private String name;
    private AdAccountStatus status;
    private int dailySpendLimit;
    private List<AdAccountUser> users;
    private String currency;
    private int timezoneId;
    private String timezoneName;
    private List<String> capabilities; // marked as "reserved for future use"
    private List<AdAccountGroup> accountGroups;

    public AdAccount(String accountId, String name, AdAccountStatus status, int dailySpendLimit, List<AdAccountUser> users, String currency, int timezoneId, String timezoneName, List<String> capabilities, List<AdAccountGroup> accountGroups) {
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

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AdAccountStatus getStatus() {
        return status;
    }

    public void setStatus(AdAccountStatus status) {
        this.status = status;
    }

    public int getDailySpendLimit() {
        return dailySpendLimit;
    }

    public void setDailySpendLimit(int dailySpendLimit) {
        this.dailySpendLimit = dailySpendLimit;
    }

    public List<AdAccountUser> getUsers() {
        return users;
    }

    public void setUsers(List<AdAccountUser> users) {
        this.users = users;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getTimezoneId() {
        return timezoneId;
    }

    public void setTimezoneId(int timezoneId) {
        this.timezoneId = timezoneId;
    }

    public String getTimezoneName() {
        return timezoneName;
    }

    public void setTimezoneName(String timezoneName) {
        this.timezoneName = timezoneName;
    }

    public List<String> getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(List<String> capabilities) {
        this.capabilities = capabilities;
    }

    public List<AdAccountGroup> getAccountGroups() {
        return accountGroups;
    }

    public void setAccountGroups(List<AdAccountGroup> accountGroups) {
        this.accountGroups = accountGroups;
    }

}
