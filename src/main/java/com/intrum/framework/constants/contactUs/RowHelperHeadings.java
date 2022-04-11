package com.intrum.framework.constants.contactUs;

public enum RowHelperHeadings {

    CONTACT_ROW_HELPER_HEADING("SAZINIETIES AR MUMS");

    private final String helperHeading;

    RowHelperHeadings(String value) {
        helperHeading = value;
    }

    public String toString() {
        return this.helperHeading;
    }
}
