package pages.userHandling;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;
import pages.home.HeaderPage;

public class LoginPage extends BasePage {
    private static Logger logger = LoggerFactory.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailInput;
    @FindBy(css = ".js-visible-password")
    private WebElement passwordInput;
    @FindBy(css = "#submit-login")
    private WebElement signInBtn;

    public void loginPredefinedUser() {
        driver.get(System.getProperty("login_url"));
        waitForElement(emailInput);
        emailInput.sendKeys(System.getProperty("user_email"));
        passwordInput.sendKeys(System.getProperty("user_password"));
        signInBtn.click();
        HeaderPage headerPage = new HeaderPage(driver);
        waitForElements(headerPage.getCategories());
    }
}
