package com.gmail.byelenka.addressbook.tests;

import com.gmail.byelenka.addressbook.model.ContactData;
import com.gmail.byelenka.addressbook.model.Contacts;
import com.gmail.byelenka.addressbook.model.GroupData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupData().withName("test1"));
        }
        app.goTo().homePage();
        if (app.contact().allCont().size() == 0) {
            app.contact().createContact(new ContactData()
                    .withFirstname("Leon").withLastname("Killer").withAddress("Paris").withEmail("killer@gmail.com").withHomeNumber("+123456789").withGroup("[none]"));
        }
    }

    @Test
    public void testContactDeletion1() {
        Contacts before = app.contact().allCont();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        Contacts after = app.contact().allCont();
        assertEquals(after.size(), before.size()-1);
        assertThat(after, equalTo(before.without(deletedContact)));
    }

    @Test
    public void testContactDeletion2() {
        Contacts before = app.contact().allCont();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        Contacts after = app.contact().allCont();
        assertEquals(after.size(), before.size()-1);
        assertThat(after, equalTo(before.without(deletedContact)));
    }
}
