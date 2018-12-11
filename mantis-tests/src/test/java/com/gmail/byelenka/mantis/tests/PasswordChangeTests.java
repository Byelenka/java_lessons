package com.gmail.byelenka.mantis.tests;

import com.gmail.byelenka.mantis.model.MailMessage;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class PasswordChangeTests extends TestBase {

    @Test
    public void testPasswordChange() throws MessagingException, IOException {
        String password = "password";
        app.goTo().loginPage("administrator", "root");
        app.goTo().manageUsersPage();
        String email = app.user().selectUserEmail();
        String user = app.user().selectUser();
        app.james().initTelnetSession();
        app.james().doesUserExist(user);
        app.james().drainEmail(user, password);
        app.user().resetUserPassword();
        List<MailMessage> mailMessages = app.james().waitForMail(user, password, 60000);
        String confirmationLink = findConfirmationLink(mailMessages, email);
        app.registration().finish(confirmationLink, password);
        assertTrue(app.newSession().login(user, password));
        app.james().closeTelnetSession();
    }

    private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }
}
