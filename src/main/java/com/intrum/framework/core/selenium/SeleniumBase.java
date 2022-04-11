package com.intrum.framework.core.selenium;

import com.intrum.framework.config.Config;
import org.assertj.core.api.SoftAssertions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;

import java.util.List;

import static java.lang.String.format;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static org.slf4j.LoggerFactory.getLogger;

public class SeleniumBase {

    private static final Logger LOGGER = getLogger(SeleniumBase.class);

    private static final String browserName = Config.getInstance().getBrowserName();

    protected static WebDriver browser;

    public static final int DEFAULT_LOCATE_ELEMENT_TIME = 60;


    @BeforeClass
    public static void createBrowser() {
        LOGGER.info(browserName);
        switch (browserName) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--window-size=1920,1200"); // "--headless",

                LOGGER.info(format("Initiated driver for browser - %s", browserName));
                browser = new ChromeDriver(options);
                break;
            default:
                throw new Error(format("There is no such browser - %s", browserName));
        }
    }

    @AfterClass
    public static void closeBrowser() {
        browser.close();
    }

    public static List<WebElement> getElements(By elementLocator) {
        return browser.findElements(elementLocator);
    }

    public static List<WebElement> getElements(By parent, By child) {
        return browser.findElement(parent).findElements(child);
    }

    public static WebElement getElement(By parent, By child) {
        return browser.findElement(parent).findElement(child);
    }

    public static void click(By element) {
        browser.findElement(element).click();
    }

    public static void waitUntilCondition(ExpectedCondition condition, String timeoutMessage, int timeout) {
        WebDriverWait wait = new WebDriverWait(browser, (long) timeout);
        wait.withMessage(timeoutMessage);
        wait.until(condition);
    }

    public static WebElement waitForElementToBeDisplayed(By elementLocator, String elementsName) {
        ExpectedCondition<WebElement> condition = visibilityOfElementLocated(elementLocator);
        String timeoutMessage = elementsName + " wasn't displayed after " + DEFAULT_LOCATE_ELEMENT_TIME + " seconds.";
        waitUntilCondition(condition, timeoutMessage, DEFAULT_LOCATE_ELEMENT_TIME);
        return browser.findElement(elementLocator);
    }

    public static boolean isElementDisplayed(By element) {
        try {
            browser.findElement(element).isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static boolean isElementPresent(By element) {
        try {
            browser.findElement(element);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static void checkIfElementVisibilitySoft(By element, boolean visibility, SoftAssertions softAssertions) {
        boolean check;
        try {
            browser.findElement(element).isDisplayed();
            check = true;
        } catch (NoSuchElementException e) {
            check = false;
        }
        softAssertions.assertThat(check).as("Visibility of: " + element).isEqualTo(visibility);
    }

    public static void openUrl(String url) {
        browser.get(url);
    }
}
