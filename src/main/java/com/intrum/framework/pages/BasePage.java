package com.intrum.framework.pages;

import com.intrum.framework.constants.navigation.MenuSections;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import static com.intrum.framework.core.selenium.SeleniumBase.getElement;
import static com.intrum.framework.core.selenium.SeleniumBase.waitForElementToBeDisplayed;
import static java.lang.String.format;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.openqa.selenium.By.cssSelector;

public class BasePage {

    private static final By ACCEPT_ALL_COOKIES_BUTTON = cssSelector("[id='onetrust-accept-btn-handler']");

    private static final By DROPDOWN = cssSelector("select");

    private static final By PAGE_TITLE = cssSelector("h1");

    private static final By TEXT_AREA = cssSelector("textarea");

    protected static final By INPUT_FIELD = cssSelector("input");

    protected Navigation navigationMenu;


    public BasePage() {
        this.navigationMenu = new Navigation();
    }

    protected void validateTitle(String expectedTitle) {
        String title = waitForElementToBeDisplayed(PAGE_TITLE, "Page title").getText();
        assertThat(format("Page title is not correct, expected: %s, but was: %s", expectedTitle, title),
                title, is(expectedTitle));
    }

    protected void navigateTo(MenuSections section) {
        this.navigationMenu.selectSectionByName(section);
    }

    protected void fillInputField(By element, String value) {
        getElement(element, INPUT_FIELD).sendKeys(value);
    }

    public void clearInputField(By element) {
        getElement(element, INPUT_FIELD).clear();
    }

    public void clearTextAreaField(By element) {
        getElement(element, TEXT_AREA).clear();
    }

    public void fillTextAreaField(By element, String value) {
        getElement(element, TEXT_AREA).sendKeys(value);
    }

    public void selectValueFromDropDown(By element, String value) {
        Select dropdown = new Select(getElement(element, DROPDOWN));
        dropdown.selectByValue(value);
    }

    protected void acceptAllCookies() {
        waitForElementToBeDisplayed(ACCEPT_ALL_COOKIES_BUTTON, "Accept all cookies button")
                .sendKeys(Keys.ENTER);
    }
}
