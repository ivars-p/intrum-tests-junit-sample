package com.intrum.framework.constants.contactUs.commentAndcomplaintForm;

public enum FormsTitles {

    COMMENTS_ADN_COMPLAINTS_FORM_TITLE("Iebildumu un komentāru forma"),
    SUCCESSFULLY_SUBMITTED_FORM("Paldies!");

    private final String title;

    FormsTitles(String value) {
        this.title = value;
    }

    public String toString() {
        return this.title;
    }
}
