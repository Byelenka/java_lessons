package com.gmail.byelenka.addressbook.tests;

import com.gmail.byelenka.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.initContactCreation();
    app.fillContactForm(new ContactData("Leon", "Killer", "Paris", "killer@gmail.com", "+123456789"));
    app.submitContactCreation();
    app.gotoHomePage();
  }
}
