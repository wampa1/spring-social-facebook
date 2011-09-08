package org.springframework.social.facebook.api;

import java.util.List;

public class AdAccountUser {

    private String uid;
    private List<Integer> permissions;
    private int role;

    public AdAccountUser(String uid, List<Integer> permissions, int role) {
        this.uid = uid;
        this.permissions = permissions;
        this.role = role;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public List<Integer> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Integer> permissions) {
        this.permissions = permissions;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

}
