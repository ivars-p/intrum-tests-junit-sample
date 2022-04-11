package com.intrum.framework.pages.contactUsPage;

import com.intrum.framework.config.Config;
import com.intrum.framework.constants.contactUs.RowHeadings;
import com.intrum.framework.pages.BasePage;
import org.openqa.selenium.By;
import org.slf4j.Logger;

import java.util.List;

import static com.intrum.framework.constants.contactUs.RowHeadings.CONTACT_ROW_HEADING;
import static com.intrum.framework.constants.navigation.PageTitles.CONTACT_US_PAGE_TITLE;
import static com.intrum.framework.constants.navigation.Urls.CONTACT_US_PAGE_URL;
import static com.intrum.framework.core.selenium.SeleniumBase.getElements;
import static com.intrum.framework.core.selenium.SeleniumBase.openUrl;
import static java.lang.String.format;
import static java.util.stream.Collectors.toList;
import static org.openqa.selenium.By.cssSelector;
import static org.slf4j.LoggerFactory.getLogger;

public class ContactUsPage extends BasePage {

    private static final Logger LOGGER = getLogger(ContactUsPage.class);

    private static final By PAGE_ROWS = cssSelector("[class='help-item-cta']");

    CommentsAndComplaintsForm commentsAndComplaintsForm;

    public ContactUsPage() {}

    public ContactUsPage verify() {
        validateTitle(CONTACT_US_PAGE_TITLE.toString());
        return this;
    }

    public ContactUsPage startContactUsPageTest() {
        LOGGER.info(format("Open URL: %s", Config.getInstance().getDefaultIntrumLatviaUrl()));
        openUrl(Config.getInstance().getDefaultIntrumLatviaUrl() + (CONTACT_US_PAGE_URL));
        this.acceptAllCookies();
        this.verify();
        return this;
    }

    public ContactUsRow getRowByHeading(RowHeadings rowHeading) {
        return getPageRows()
                .stream()
                .filter(row -> row.getRowHeading().equals(rowHeading.toString()))
                .findFirst()
                .orElseThrow(() ->
                        new AssertionError("No row found by heading name: " + rowHeading.toString()));
    }

    public List<ContactUsRow> getPageRows() {
        return getElements(PAGE_ROWS)
                .stream()
                .map(ContactUsRow::new)
                .collect(toList());
    }

    public ContactUsPage verifyContactsRowContent() {
        getRowByHeading(CONTACT_ROW_HEADING).verifyCommentsAndComplaintsRow();
        return this;
    }

    public CommentsAndComplaintsForm openCommentsAndComplaintsForm() {
        this.commentsAndComplaintsForm = getRowByHeading(CONTACT_ROW_HEADING)
                .openCommentsAndComplaintsForm().verify();
        return this.commentsAndComplaintsForm;
    }
}
