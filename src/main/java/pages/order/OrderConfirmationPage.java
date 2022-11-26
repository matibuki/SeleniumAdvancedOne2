package pages.order;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

public class OrderConfirmationPage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(OrderConfirmationPage.class);

    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#order-details > ul > li:nth-child(1)")
    private WebElement orderReference;

    public String getOrderReference() {
        waitForElement(orderReference);
        String orderNumber = orderReference.getText().replace("Order reference: ", "");
        logger.info("Order number is: "+ orderNumber);
        return orderNumber;
    }
}
