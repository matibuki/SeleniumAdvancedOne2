package pages.user;

import models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

import java.util.List;

public class RegistrationPage extends BasePage {
    private static Logger logger = LoggerFactory.getLogger(RegistrationPage.class);

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".custom-radio")
    private List<WebElement> socialTitleRadioButtons;

    @FindBy(xpath = "//input[@name='firstname']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@name='lastname']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@name='birthday']")
    private WebElement birthdayInput;

    @FindBy(css = ".form-control-submit")
    private WebElement submitBtn;

    @FindBy(xpath = "//input[@name='customer_privacy']")
    private WebElement customerPrivacyCheckbox;

    @FindBy(xpath = "//input[@name='psgdpr']")
    private WebElement warunkiUzytkowania;

    public void setRandomSocialTitle() {
        socialTitleRadioButtons.get(random.nextInt(1)).click();
        logger.info("Random gender selected");
    }

    public void fillRegistrationForm(User user) {
        setRandomSocialTitle();

        firstNameInput.sendKeys(user.getFirstName());
        lastNameInput.sendKeys(user.getLastName());
        emailInput.sendKeys(user.getEmail());
        passwordInput.sendKeys(user.getPassword());
        birthdayInput.sendKeys(user.getBirthdate());
    }

    public void obligatoryCheckboxes() {
        customerPrivacyCheckbox.click();
        warunkiUzytkowania.click();
    }
    public void saveUser() {
        submitBtn.click();
        logger.info("User saved!");
    }
}
