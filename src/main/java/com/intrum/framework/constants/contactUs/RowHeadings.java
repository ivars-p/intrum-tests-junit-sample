package com.intrum.framework.constants.contactUs;

public enum RowHeadings {

    CONTACT_ROW_HEADING("Iebildumu un komentāru forma");

    private final String heading;

    RowHeadings(String value) {
        this.heading = value;
    }

    public String toString() {
        return this.heading;
    }
}
