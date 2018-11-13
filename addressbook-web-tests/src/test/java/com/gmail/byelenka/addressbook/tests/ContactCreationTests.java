package com.gmail.byelenka.addressbook.tests;

import com.gmail.byelenka.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
      app.goTo().homePage();
      List<ContactData> before = app.contact().list();
      ContactData contact = new ContactData()
              .withFirstname("Leon").withLastname("Killer").withAddress("Paris").withEmail("killer@gmail.com").withHomenumber("+123456789").withGroup("test1");
      app.contact().createContact(contact);
      List<ContactData> after = app.contact().list();
      Assert.assertEquals(after.size(), before.size() + 1);

      before.add(contact);
      Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
      before.sort(byId);
      after.sort(byId);
      Assert.assertEquals(before, after);
  }
}
