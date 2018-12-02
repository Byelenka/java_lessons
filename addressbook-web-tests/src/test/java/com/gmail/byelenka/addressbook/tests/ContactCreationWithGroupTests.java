package com.gmail.byelenka.addressbook.tests;

import com.gmail.byelenka.addressbook.model.ContactData;
import com.gmail.byelenka.addressbook.model.GroupData;
import com.gmail.byelenka.addressbook.model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactCreationWithGroupTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test1"));
        }
    }

    @Test
    public void testContactCreationWithGroup() {
        Groups groups = app.db().groups();
        ContactData contact = new ContactData()
                .withFirstname("Leon").withLastname("Port").withAddress("Berlin")
                .withEmail("leon@gmail.com").withHomeNumber("+123456789").inGroup(groups.iterator().next());
        app.goTo().homePage();
        app.contact().createContact(contact);
        System.out.println(contact.getGroups());
    }
}