package com.intrum.framework.constants.navigation;

public enum PageTitles {

    CONTACT_US_PAGE_TITLE("Sazinieties ar mums"),
    HOME_PAGE_TITLE("Esam te, lai jums palīdzētu!");

    private final String title;

    PageTitles(String value) {
        this.title = value;
    }

    public String toString() {
        return this.title;
    }
}
