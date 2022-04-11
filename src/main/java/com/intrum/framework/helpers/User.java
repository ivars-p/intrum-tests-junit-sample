package com.intrum.framework.helpers;

import com.intrum.framework.constants.contactUs.commentAndcomplaintForm.FormsResponseTypes;

import static com.intrum.framework.constants.contactUs.commentAndcomplaintForm.FormsResponseTypes.RESPONSE_TYPE_MAIL;

public class User {

    private String name;

    private String surname;

    private String personalCode;

    private String caseNumber;

    private String phone;

    private String email;

    private String address;

    private String complaint;

    private FormsResponseTypes formsResponseTypes;

    public User() {
        this.name = "John";
        this.surname = "Doe";
        this.personalCode = "111111-11111";
        this.caseNumber = "00001";
        this.phone = "+37121111111";
        this.email = "john.doe@gmail.com";
        this.address = "Riga, Central District, LV-1050";
        this.complaint = "System does not work!";
        this.formsResponseTypes = RESPONSE_TYPE_MAIL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPersonalCode() {
        return personalCode;
    }

    public void setPersonalCode(String personalCode) {
        this.personalCode = personalCode;
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public FormsResponseTypes getResponseType() {
        return formsResponseTypes;
    }

    public void setResponseType(FormsResponseTypes formsResponseTypes) {
        this.formsResponseTypes = formsResponseTypes;
    }
}
