package com.intrum.tests.contactForm;

import com.intrum.framework.pages.contactUsPage.ContactUsPage;
import com.intrum.framework.pages.homePage.HomePage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.Test;
import org.slf4j.Logger;

import static com.intrum.framework.constants.navigation.MenuSections.CONTACT_US_MENU_SECTION;
import static org.slf4j.LoggerFactory.getLogger;

@Feature("Contact form main functionality")
@Story("Contact forms elements")
public class ValidateContactFormsEleTest extends ContactFormsBase {

    private static final Logger LOGGER = getLogger(ValidateContactFormsEleTest.class);

    /**
     * User starts Intrum Latvia home page UI test
     * User navigates from home to contact us page
     * User validates contacts row in contact us page
     * User opens comments and complaints form in contact us page
     * User validates comments and complaints forms content
     */
    @Test
    public void testValidateContactFormElements() {
        LOGGER.info("User starts Intrum Latvia home page UI and navigates contact us page");
        ContactUsPage contactUsPage = new HomePage().startHomePageTest()
                .navigateToPage(CONTACT_US_MENU_SECTION)
                .andGetContactUsPage();

        LOGGER.info("User validates contacts row, opens comments and complaints form and verifies forms content");
        contactUsPage.verifyContactsRowContent()
                .openCommentsAndComplaintsForm()
                .verifyFormsContent();
    }
}
