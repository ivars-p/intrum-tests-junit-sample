package com.intrum.framework.pages.homePage;

import com.intrum.framework.pages.contactUsPage.ContactUsPage;

public class HomePagePromise {

    public HomePagePromise() {}

    public ContactUsPage andGetContactUsPage() {
        return new ContactUsPage().verify();
    }
}
