package com.gmail.byelenka.addressbook.tests;

import com.gmail.byelenka.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
      app.getNavigationHelper().gotoHomePage();
      app.getContactHelper().createContact(new ContactData("Leon", "Killer", "Paris", "killer@gmail.com", "+123456789", "test1"));
  }
}
