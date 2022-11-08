package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CartPage extends BasePage {
    private static Logger logger = LoggerFactory.getLogger(CartPage.class);

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".remove-from-cart")
    private WebElement trashIcon;

    public void removeProductFromCart() {
        trashIcon.click();
        logger.info("Product removed from cart");
    }
}
