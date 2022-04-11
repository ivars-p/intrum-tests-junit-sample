package com.intrum.framework.constants.navigation;

public enum Urls {

    CONTACT_US_PAGE_URL("sazinieties-ar-mums/");

    private final String url;

    Urls(String value) {
        this.url = value;
    }

    public String toString() {
        return this.url;
    }
}
