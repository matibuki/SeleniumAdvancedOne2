package pages.userHandling;

import models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;
import pages.commons.HeaderPage;
import providers.UrlProvider;

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

    public void loginPredefinedUser(User user) {
        driver.get(UrlProvider.login);
        waitForElement(emailInput);
        emailInput.sendKeys(user.getEmail());
        passwordInput.sendKeys(user.getPassword());
        signInBtn.click();
        HeaderPage headerPage = new HeaderPage(driver);
        waitForElements(headerPage.getCategories());
    }
}
