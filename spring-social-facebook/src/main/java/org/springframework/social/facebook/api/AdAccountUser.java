package org.springframework.social.facebook.api;

import java.util.List;

public class AdAccountUser {

    private final String uid;
    private final List<Integer> permissions;
    private final int role;

    public AdAccountUser(String uid, List<Integer> permissions, int role) {
        this.uid = uid;
        this.permissions = permissions;
        this.role = role;
    }

    public String getUid() {
        return uid;
    }

    public List<Integer> getPermissions() {
        return permissions;
    }

    public int getRole() {
        return role;
    }

}
