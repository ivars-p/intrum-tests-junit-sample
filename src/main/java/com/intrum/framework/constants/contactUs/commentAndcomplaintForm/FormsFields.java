package com.intrum.framework.constants.contactUs.commentAndcomplaintForm;

public enum FormsFields {

    ADDRESS_FIELD("address"),
    CASE_NUMBER_FIELD("case number"),
    CONTACT_NUMBER_FIELD("contact number"),
    COMMENT_AND_COMPLAINT_FIELD("comment and complaint"),
    EMAIL_FIELD("email"),
    NAME_AND_SURNAME_FIELD("name and surname"),
    PERSONAL_CODE_FIELD("personal code"),
    RESPONSE_TYPE_FIELD("response type");

    private final String field;

    FormsFields(String value) {
        this.field = value;
    }

    public String toString() {
        return this.field;
    }
}
