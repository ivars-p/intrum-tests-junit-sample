package com.intrum.framework.pages.homePage;

import com.intrum.framework.config.Config;
import com.intrum.framework.constants.navigation.MenuSections;
import com.intrum.framework.pages.BasePage;
import org.slf4j.Logger;

import static com.intrum.framework.constants.navigation.PageTitles.HOME_PAGE_TITLE;
import static com.intrum.framework.core.selenium.SeleniumBase.openUrl;
import static java.lang.String.format;
import static org.slf4j.LoggerFactory.getLogger;

public class HomePage extends BasePage {

    private static final Logger LOGGER = getLogger(HomePage.class);

    public HomePage verify() {
        validateTitle(HOME_PAGE_TITLE.toString());
        return this;
    }

    public HomePage startHomePageTest() {
        LOGGER.info(format("Open URL: %s", Config.getInstance().getDefaultIntrumLatviaUrl()));
        openUrl(Config.getInstance().getDefaultIntrumLatviaUrl());
        this.acceptAllCookies();
        this.verify();
        return this;
    }

    public HomePagePromise navigateToPage(MenuSections menuSection) {
        navigateTo(menuSection);
        return new HomePagePromise();
    }
}
