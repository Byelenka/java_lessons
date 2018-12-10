package com.gmail.byelenka.mantis.tests;

import org.testng.annotations.Test;

public class PasswordChangeTests extends TestBase {

    @Test
    public void testPasswordChange() {
        app.goTo().loginPage("administrator", "root");

    }
}
