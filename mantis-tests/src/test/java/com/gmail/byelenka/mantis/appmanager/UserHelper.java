package com.gmail.byelenka.mantis.appmanager;

import org.openqa.selenium.By;

public class UserHelper extends HelperBase {

    public UserHelper (ApplicationManager app) {
        super(app);
    }

    public String selectUserEmail() {
        click(By.xpath("//a[contains(text(), 'user')]"));
        String email = wd.findElement(By.name("email")).getAttribute("value");
        return email;
    }

    public String selectUser() {
        String user = wd.findElement(By.name("username")).getAttribute("value");
        return user;
    }

    public void resetUserPassword() {
        click(By.xpath("//input[@value='Reset Password']"));
    }
}
