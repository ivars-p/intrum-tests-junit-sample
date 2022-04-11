package com.intrum.framework.pages.contactUsPage;

import com.intrum.framework.constants.contactUs.commentAndcomplaintForm.FormsFields;
import com.intrum.framework.helpers.User;
import com.intrum.framework.pages.BasePage;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.ByChained;

import static com.intrum.framework.constants.contactUs.commentAndcomplaintForm.FormsFieldNotifications.EMPTY_FIELD_NOTIFICATION;
import static com.intrum.framework.constants.contactUs.commentAndcomplaintForm.FormsTitles.COMMENTS_ADN_COMPLAINTS_FORM_TITLE;
import static com.intrum.framework.constants.contactUs.commentAndcomplaintForm.FormsTitles.SUCCESSFULLY_SUBMITTED_FORM;
import static com.intrum.framework.core.selenium.SeleniumBase.*;
import static java.lang.String.format;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.openqa.selenium.By.cssSelector;

public class CommentsAndComplaintsForm extends BasePage {

    private static final By ADDRESS_LCTR = cssSelector("div.adrese");

    private static final By CASE_NUMBER_LCTR = cssSelector("[class*='lietasnumursnavobligāts']");

    private static final By COMMENT_AND_COMPLAINT_LCTR = cssSelector("[class*='komentāraiebildumubūtība']");

    private static final By CONTACT_NUMBER_LCTR = cssSelector("[class*='kontakttālrunis']");

    private static final By EMAIL_LCTR = cssSelector("[class*='epastaadrese']");

    private static final By ERROR_NOTIFICATION_LCTR = cssSelector("[class='field-validation-error']");

    private static final By NAME_AND_SURNAME_LCTR = cssSelector("[class*='vārdsuzvārds']");

    private static final By PERSONAL_CODE_LCTR = cssSelector("[class*='personaskods']");

    private static final By RESPONSE_TYPE_LCTR = cssSelector("[class*='kāvēlossaņemtatbildi']");

    private static final By SUBMITTED_TITLE_LCTR = cssSelector("[id = slide] h4");

    private static final By SUBMIT_FORM_BUTTON_LCTR = cssSelector("[type='submit']");

    private static final By TITLE_LCTR = cssSelector("[id = slide] h1");

    public CommentsAndComplaintsForm() {
    }

    public CommentsAndComplaintsForm verify() {
        validateFormsTitle(TITLE_LCTR, COMMENTS_ADN_COMPLAINTS_FORM_TITLE.toString());
        return this;
    }

    protected CommentsAndComplaintsForm validateFormsTitle(By element, String expectedTitle) {
        String title = waitForElementToBeDisplayed(element, "Forms title: " + expectedTitle).getText();
        assertThat("Forms title is not correct!", title, is(expectedTitle));
        return this;
    }

    public CommentsAndComplaintsForm verifyFormsContent() {
        SoftAssertions softAssertions = new SoftAssertions();
        checkIfElementVisibilitySoft(NAME_AND_SURNAME_LCTR, true, softAssertions);
        checkIfElementVisibilitySoft(PERSONAL_CODE_LCTR, true, softAssertions);
        checkIfElementVisibilitySoft(CASE_NUMBER_LCTR, true, softAssertions);
        checkIfElementVisibilitySoft(CONTACT_NUMBER_LCTR, true, softAssertions);
        checkIfElementVisibilitySoft(EMAIL_LCTR, true, softAssertions);
        checkIfElementVisibilitySoft(ADDRESS_LCTR, true, softAssertions);
        checkIfElementVisibilitySoft(COMMENT_AND_COMPLAINT_LCTR, true, softAssertions);
        checkIfElementVisibilitySoft(RESPONSE_TYPE_LCTR, true, softAssertions);
        checkIfElementVisibilitySoft(SUBMIT_FORM_BUTTON_LCTR, true, softAssertions);
        softAssertions.assertAll();
        return this;
    }

    public CommentsAndComplaintsForm fillCommentsAndComplaintsForm(User user) {
        fillInputField(NAME_AND_SURNAME_LCTR, user.getName() + ", " + user.getSurname());
        fillInputField(PERSONAL_CODE_LCTR, user.getPersonalCode());
        fillInputField(CASE_NUMBER_LCTR, user.getCaseNumber());
        fillInputField(CONTACT_NUMBER_LCTR, user.getPhone());
        fillInputField(EMAIL_LCTR, user.getEmail());
        fillInputField(ADDRESS_LCTR, user.getAddress());
        fillTextAreaField(COMMENT_AND_COMPLAINT_LCTR, user.getComplaint());
        selectValueFromDropDown(RESPONSE_TYPE_LCTR, user.getResponseType().toString());
        return this;
    }

    protected By getFieldsLocator(FormsFields field) {
        By fieldLocator;
        switch (field) {
            case NAME_AND_SURNAME_FIELD:
                fieldLocator = NAME_AND_SURNAME_LCTR;
                break;
            case PERSONAL_CODE_FIELD:
                fieldLocator = PERSONAL_CODE_LCTR;
                break;
            case CASE_NUMBER_FIELD:
                fieldLocator = CASE_NUMBER_LCTR;
                break;
            case CONTACT_NUMBER_FIELD:
                fieldLocator = CONTACT_NUMBER_LCTR;
                break;
            case EMAIL_FIELD:
                fieldLocator = EMAIL_LCTR;
                break;
            case ADDRESS_FIELD:
                fieldLocator = ADDRESS_LCTR;
                break;
            case COMMENT_AND_COMPLAINT_FIELD:
                fieldLocator = COMMENT_AND_COMPLAINT_LCTR;
                break;
            case RESPONSE_TYPE_FIELD:
                fieldLocator = RESPONSE_TYPE_LCTR;
                break;
            default:
                throw new AssertionError("Unexpected value: " + field);
        }
        return fieldLocator;
    }

    public CommentsAndComplaintsForm submitForm() {
        click(SUBMIT_FORM_BUTTON_LCTR);
        return this;
    }

    public CommentsAndComplaintsForm verifyFormSubmittedSuccessfully() {
        validateFormsTitle(SUBMITTED_TITLE_LCTR, SUCCESSFULLY_SUBMITTED_FORM.toString());
        return this;
    }

    public CommentsAndComplaintsForm verifyMandatoryEmptyFieldsNotifications() {
        SoftAssertions softAssertions = new SoftAssertions();
        verifyEmptyFieldNotificationSoft(NAME_AND_SURNAME_LCTR, softAssertions);
        verifyEmptyFieldNotificationSoft(PERSONAL_CODE_LCTR, softAssertions);
        verifyEmptyFieldNotificationSoft(CONTACT_NUMBER_LCTR, softAssertions);
        verifyEmptyFieldNotificationSoft(EMAIL_LCTR, softAssertions);
        verifyEmptyFieldNotificationSoft(ADDRESS_LCTR, softAssertions);
        verifyEmptyFieldNotificationSoft(COMMENT_AND_COMPLAINT_LCTR, softAssertions);
        verifyEmptyFieldNotificationSoft(RESPONSE_TYPE_LCTR, softAssertions);
        softAssertions.assertAll();
        return this;
    }

    public CommentsAndComplaintsForm verifyEmptyFieldNotificationHard(By element) {
        String notification = waitForElementToBeDisplayed(new ByChained(element, ERROR_NOTIFICATION_LCTR), "Empty field notification").getText();
        assertThat(format("Empty field notification is not correct, expected: %s, but was: %s",
                EMPTY_FIELD_NOTIFICATION.toString(), notification), notification, is(EMPTY_FIELD_NOTIFICATION.toString()));
        return this;
    }

    public CommentsAndComplaintsForm verifyEmptyFieldNotificationSoft(By element, SoftAssertions softAssertions) {
        String notification = waitForElementToBeDisplayed(new ByChained(element, ERROR_NOTIFICATION_LCTR), "Empty field notification").getText();
        softAssertions.assertThat(notification)
                .as("Empty field notification text for - " + element)
                .isEqualTo(EMPTY_FIELD_NOTIFICATION.toString());
        return this;
    }

    public CommentsAndComplaintsForm verifyEmptyFieldNotificationIsNotVisible(By element) {
        assertFalse("Empty field notification is still visible, expected not to be",
                isElementPresent(new ByChained(element, ERROR_NOTIFICATION_LCTR)));
        return this;
    }

    public CommentsAndComplaintsForm clearInputField(FormsFields field) {
        clearInputField(getFieldsLocator(field));
        return this;
    }

    public CommentsAndComplaintsForm clearTextArea(FormsFields field) {
        clearTextAreaField(getFieldsLocator(field));
        return this;
    }

    public CommentsAndComplaintsForm fillInInputField(FormsFields field, String value) {
        fillInputField(getFieldsLocator(field), value);
        return this;
    }

    public CommentsAndComplaintsForm fillInTextAreaField(FormsFields field, String value) {
        fillTextAreaField(getFieldsLocator(field), value);
        return this;
    }

    public CommentsAndComplaintsForm verifyEmptyFieldNotification(FormsFields field, String expectation) {
        if (expectation.equals("VISIBLE")) {
            verifyEmptyFieldNotificationHard(getFieldsLocator(field));
        } else {
            verifyEmptyFieldNotificationIsNotVisible(getFieldsLocator(field));
        }
        return this;
    }

    public CommentsAndComplaintsForm setDropDown(FormsFields field, String type) {
        selectValueFromDropDown(getFieldsLocator(field), type);
        return this;
    }
}
