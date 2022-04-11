package com.intrum.framework.constants.contactUs.commentAndcomplaintForm;

public enum FormsResponseTypes {

    RESPONSE_TYPE_EMAIL("E-pasts"),
    RESPONSE_TYPE_EMPTY(""),
    RESPONSE_TYPE_MAIL("Pasts");

    private final String type;

    FormsResponseTypes(String value) {
        this.type = value;
    }

    public String toString() {
        return this.type;
    }
}
