package pages;

import models.Cart;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CartPage extends BasePage {
    private static Logger logger = LoggerFactory.getLogger(CartPage.class);

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".remove-from-cart")
    private WebElement trashIcon;

    @FindBy(css = ".cart-item")
    private List<WebElement> productsInCartList;

    public void removeProductFromCart() {
        trashIcon.click();
        logger.info("Product removed from cart");
    }

    public Cart toCart() {

        return new Cart();

    }
}
