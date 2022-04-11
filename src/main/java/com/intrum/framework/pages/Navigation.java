package com.intrum.framework.pages;

import com.intrum.framework.constants.navigation.MenuSections;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Optional;

import static com.intrum.framework.core.selenium.SeleniumBase.getElements;
import static org.openqa.selenium.By.cssSelector;

public class Navigation {

    private static final By ROOT = cssSelector("[class='menu-items']");

    private static final By NAVIGATION_SECTIONS = cssSelector("li");

    public Navigation() {
    }

    public void selectSectionByName(MenuSections section) {
        Optional<WebElement> result = getSectionList()
                .stream()
                .filter(el -> el.getText().equals(section.toString()))
                .findFirst();
        if (result.isPresent()) {
            result.get().click();
        } else {
            throw new AssertionError("No navigation section found by name: " + section);
        }
    }

    public List<WebElement> getSectionList() {
        return getElements(ROOT, NAVIGATION_SECTIONS);
    }
}
