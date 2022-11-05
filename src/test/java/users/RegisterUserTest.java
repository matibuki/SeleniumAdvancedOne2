package users;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import start.Pages;


public class RegisterUserTest extends Pages {
    @Test
    @DisplayName("Register new user")
    public void registerUserTest() {
        basePage.openRegistrationPage();
        registrationPage.fillRegistrationForm();
        registrationPage.obligatoryCheckboxes();
        registrationPage.saveUser();

        softly.assertThat(registrationPage.currentUrl()).isEqualTo(System.getProperty("registeredUserUrl"));
        softly.assertThat(headerPage.getLogoutBtn()).contains(System.getProperty("signOutText"));
        softly.assertAll();
    }
}
