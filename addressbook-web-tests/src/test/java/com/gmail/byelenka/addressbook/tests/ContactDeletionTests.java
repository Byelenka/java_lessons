package com.gmail.byelenka.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteSelectedContact();
        app.getContactHelper().confirmContactDeletion();
        app.getContactHelper().gotoHomePage();
    }
}
