package org.springframework.social.facebook.api;

import java.util.List;

public class AdAccountGroup {

    private final String accountGroupId;
    private final String id;
    private final String name;
    private final int status;
    private final List<User> users;
    private final List<AdAccount> accounts;

    public AdAccountGroup(String accountGroupId, String id, String name, int status, List<User> users, List<AdAccount> accounts) {
        this.accountGroupId = accountGroupId;
        this.id = id;
        this.name = name;
        this.status = status;
        this.users = users;
        this.accounts = accounts;
    }

    public String getAccountGroupId() {
        return accountGroupId;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStatus() {
        return status;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<AdAccount> getAccounts() {
        return accounts;
    }

    public static class User {
        private String uid;
        private int role;

        public User(String uid, int role) {
            this.uid = uid;
            this.role = role;
        }

        public String getUid() {
            return uid;
        }

        public int getRole() {
            return role;
        }
    }

    public static class AdAccount {
        private String accountId;
        private int status;

        public AdAccount(String accountId, int status) {
            this.accountId = accountId;
            this.status = status;
        }

        public String getAccountId() {
            return accountId;
        }

        public int getStatus() {
            return status;
        }
    }

}
