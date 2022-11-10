package pages.userHandling;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;
import providers.DataProvider;

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

    public void fillRegistrationForm() {
        setRandomSocialTitle();

        DataProvider provider = new DataProvider();
        firstNameInput.sendKeys(provider.setFirstName());
        lastNameInput.sendKeys(provider.setLastName());
        emailInput.sendKeys((provider.setEmail()));
        passwordInput.sendKeys(provider.setPassword());
        birthdayInput.sendKeys(provider.setBirthdate());
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
