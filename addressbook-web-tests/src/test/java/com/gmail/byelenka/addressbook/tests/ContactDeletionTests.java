package com.gmail.byelenka.addressbook.tests;

import com.gmail.byelenka.addressbook.model.ContactData;
import com.gmail.byelenka.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupData().withName("test1"));
        }
        app.goTo().homePage();
        if (app.contact().list().size() == 0) {
            app.contact().createContact(new ContactData()
                    .withFirstname("Leon").withLastname("Killer").withAddress("Paris").withEmail("killer@gmail.com").withHomenumber("+123456789").withGroup("[none]"));
        }
    }

    @Test
    public void testContactDeletion1() {
        List<ContactData> before = app.contact().list();
        int index = before.size()-1;
        app.contact().delete(index);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size()-1);

        before.remove(index);
        Assert.assertEquals(before, after);
    }

    @Test
    public void testContactDeletion2() {
        List<ContactData> before = app.contact().list();
        int index = before.size()-1;
        app.contact().delete(index);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size()-1);

        before.remove(index);
        Assert.assertEquals(before, after);
    }
}
