package com.intrum.framework.pages.contactUsPage;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.intrum.framework.constants.contactUs.RowButtons.CONTACT_ROW_FORM_BUTTON;
import static com.intrum.framework.constants.contactUs.RowHelperHeadings.CONTACT_ROW_HELPER_HEADING;
import static org.openqa.selenium.By.cssSelector;

public class ContactUsRow {

    private static final By HELPER_HEADING = cssSelector("[class='helper-heading']");

    private static final By ROW_BUTTON = cssSelector("[class='CTAButton']");

    private static final By ROW_HEADING = cssSelector("h3");

    private static WebElement root;

    public ContactUsRow(WebElement rootElement) {
        this.root = rootElement;
    }

    public String getRowHeading() {
        return root.findElement(ROW_HEADING).getText();
    }

    public String getRowsHelperHeading() {
        return root.findElement(HELPER_HEADING).getText();
    }

    public WebElement getRowButton() {
        return root.findElement(ROW_BUTTON);
    }

    public String getRowsButtonText() {
        return getRowButton().getText();
    }

    public void verifyCommentsAndComplaintsRow() {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(getRowsHelperHeading())
                .as("Comments and complaints rows helper heading")
                .isEqualTo(CONTACT_ROW_HELPER_HEADING.toString());
        softAssertions.assertThat(getRowsButtonText())
                .as("Comments and complaints rows button text")
                .isEqualTo(CONTACT_ROW_FORM_BUTTON.toString());
        softAssertions.assertAll();
    }

    public CommentsAndComplaintsForm openCommentsAndComplaintsForm() {
        getRowButton().click();
        return new CommentsAndComplaintsForm();
    }
}
