package com.gmail.byelenka.addressbook.tests;

import com.gmail.byelenka.addressbook.model.ContactData;
import com.gmail.byelenka.addressbook.model.Contacts;
import org.testng.annotations.Test;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
      app.goTo().homePage();
      Contacts before = app.contact().allCont();
      File photo = new File("src/test/resources/SmehAva7.jpg");
      ContactData contact = new ContactData()
              .withFirstname("Leon").withLastname("Killer").withAddress("Paris").withEmail("killer@gmail.com").withHomeNumber("+123456789").withPhoto(photo).withGroup("[none]");
      app.contact().createContact(contact);
      Contacts after = app.contact().allCont();
      assertThat(after.size(), equalTo(before.size() + 1));
      assertThat(after, equalTo(
              before.withAdded(contact.withId(after.stream().mapToInt((c)->c.getId()).max().getAsInt()))));
  }
}
