package pages.userHandling;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

public class AccountHomePage extends BasePage {
    private static Logger logger = LoggerFactory.getLogger(AccountHomePage.class);

    public AccountHomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Order history and details")
    private WebElement orderHistory;

    public void openOrderHistory() {
        clickElement(orderHistory);
    }
}
