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

    public void manageUsersPage() {
            click(By.cssSelector("a[href = '/mantisbt-1.2.19/manage_overview_page.php']"));
            click(By.cssSelector("a[href = '/mantisbt-1.2.19/manage_user_page.php']"));
    }

    public String selectUserEmail(int id) {
        click(By.cssSelector(String.format("a[href = 'manage_user_edit_page.php?user_id=%s']", id)));
        String email = wd.findElement(By.name("email")).getAttribute("value");
        return email;
    }

    public void resetUserPassword() {
        click(By.xpath("//input[@value='Reset Password']"));
    }

    public String selectUser() {
        String user = wd.findElement(By.name("username")).getAttribute("value");
        return user;
    }
}
