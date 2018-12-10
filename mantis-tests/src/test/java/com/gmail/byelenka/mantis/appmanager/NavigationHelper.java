package com.gmail.byelenka.mantis.appmanager;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(ApplicationManager app) {
        super(app);
    }

    public void loginPage(String username, String password) {
        wd.get(app.getProperty("web.baseURL") + "/login.php");
        type(By.name("username"), username);
        type(By.name("password"), password);
        click(By.xpath("//input[@value='Login']"));
    }
}
