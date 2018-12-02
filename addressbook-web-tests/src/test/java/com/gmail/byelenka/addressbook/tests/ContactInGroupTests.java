package com.gmail.byelenka.addressbook.tests;

import com.gmail.byelenka.addressbook.model.ContactData;
import com.gmail.byelenka.addressbook.model.Contacts;
import com.gmail.byelenka.addressbook.model.GroupData;
import com.gmail.byelenka.addressbook.model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactInGroupTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test1"));
        }
    }

    @Test
    public void testContactCreationInGroup() {
        Groups groups = app.db().groups();
        ContactData contact = new ContactData()
                .withFirstname("Leon").withLastname("Port").withAddress("Berlin")
                .withEmail("leon@gmail.com").withHomeNumber("+123456789").inGroup(groups.iterator().next());
        app.goTo().homePage();
        Contacts before = app.db().contacts();
        app.contact().createContact(contact);
        Contacts after = app.db().contacts();
        assertThat(after.size(), equalTo(before.size() + 1));
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
        System.out.println(contact.getGroups());
    }

}