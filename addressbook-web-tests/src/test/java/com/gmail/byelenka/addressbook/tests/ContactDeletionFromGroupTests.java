package com.gmail.byelenka.addressbook.tests;

import com.gmail.byelenka.addressbook.model.ContactData;
import com.gmail.byelenka.addressbook.model.GroupData;
import com.gmail.byelenka.addressbook.model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ContactDeletionFromGroupTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        Groups groups = app.db().groups();
        ContactData contact = new ContactData();
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test1"));
        }
        if (app.db().contacts().size() == 0) {
            app.goTo().homePage();
            app.contact().createContact(new ContactData()
                    .withFirstname("Leon").withLastname("Killer").withAddress("Paris").withEmail("killer@gmail.com")
                    .withHomeNumber("+123456789").inGroup(groups.iterator().next()));
        }
        if (contact.getGroups().size() == 0) {
            app.goTo().homePage();
            app.contact().addContactToGroup(app.db().contacts().iterator().next());
        }
    }

    @Test
    public void testContactDeletionFromGroup() {
        ContactData deletedContactFromGroup = app.db().contacts().iterator().next();
        System.out.println(deletedContactFromGroup.getGroups());
        Groups before = deletedContactFromGroup.getGroups();
        System.out.println("Contact in group " + before);
        app.goTo().homePage();
        app.contact().deleteContactFromGroup(deletedContactFromGroup);
        Groups after = deletedContactFromGroup.getGroups();
        System.out.println("Contact in group " + after);
        assertEquals(after.size(), before.size() - 1);
    }
}
