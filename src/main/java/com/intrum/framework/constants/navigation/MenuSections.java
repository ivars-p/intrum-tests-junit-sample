package com.intrum.framework.constants.navigation;

public enum MenuSections {

    CONTACT_US_MENU_SECTION("Sazinieties ar mums");

    private final String sections;

    MenuSections(String value) {
        this.sections = value;
    }

    public String toString() {
        return this.sections;
    }
}
