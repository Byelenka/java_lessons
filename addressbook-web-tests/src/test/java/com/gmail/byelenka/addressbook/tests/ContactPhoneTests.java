package com.gmail.byelenka.addressbook.tests;

import com.gmail.byelenka.addressbook.model.ContactData;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase {

    @Test
    public void testContactPhones() {
        app.goTo().homePage();
        ContactData contact = app.contact().allCont().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getHomeNumber(), equalTo(cleaned(contactInfoFromEditForm.getHomeNumber())));
        assertThat(contact.getMobileNumber(), equalTo(cleaned(contactInfoFromEditForm.getMobileNumber())));
        assertThat(contact.getWorkNumber(), equalTo(cleaned(contactInfoFromEditForm.getWorkNumber())));
    }

    public String cleaned (String phone) {
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }
}
