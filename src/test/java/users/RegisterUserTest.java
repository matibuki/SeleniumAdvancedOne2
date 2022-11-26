package users;

import factory.UserFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import providers.UrlProvider;
import start.Pages;


public class RegisterUserTest extends Pages {
    @Test
    @DisplayName("Register new randomly generated user")
    public void registerUserTest() {
        basePage.openRegistrationPage();
        registrationPage.fillRegistrationForm(UserFactory.getRandomUser());
        registrationPage.obligatoryCheckboxes();
        registrationPage.saveUser();

        softly.assertThat(registrationPage.currentUrl()).isEqualTo(UrlProvider.baseUrl);
        softly.assertThat(headerPage.getLogoutBtn()).contains(System.getProperty("signOutText"));
        softly.assertAll();
    }
}
