package org.springframework.social.facebook.api;

public enum AdAccountStatus {

    ACTIVE(1),
    DISABLED(2),
    UNSETTLED(3);

    private int status;

    private AdAccountStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

}
