package com.gmail.byelenka.addressbook.tests;

import com.gmail.byelenka.addressbook.model.ContactData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressTests extends TestBase {

    @BeforeMethod
 /*   public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().allCont().size() == 0) {
            app.contact().createContact(new ContactData()
                    .withFirstname("Leon").withLastname("Killer").withAddress("Paris").withEmail("killer@gmail.com").withHomeNumber("+123456789").withGroup("[none]"));
        }
    }*/

    @Test
    public void testContactAddress() {
        app.goTo().homePage();
        ContactData contact = app.contact().allCont().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getAddress(), equalTo(mergeAddress(contactInfoFromEditForm)));
    }

    private static String mergeAddress(ContactData contact) {
        return Arrays.asList(contact.getAddress()).stream().collect(Collectors.joining("\n"));
    }
}
