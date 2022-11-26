package pages;

import models.Cart;
import models.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(CartPage.class);

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".cart-item")
    private List<WebElement> cartList;

    @FindBy(css = ".product-line-info:nth-child(1)")
    private List<WebElement> productsNames;

    @FindBy(css = ".current-price")
    private List<WebElement> productsPrices;

    @FindBy(css = ".js-cart-line-product-quantity")
    private List<WebElement> productsQuantities;

    @FindBy(css = ".remove-from-cart")
    private WebElement trashIcon;

    @FindBy(css = ".cart-item")
    private List<WebElement> cartRows;

    @FindBy(css = ".cart-total .value")
    private WebElement totalValueInCart;

    @FindBy(css = "#cart-subtotal-shipping .value")
    private WebElement shippingCost;

    @FindBy(css = ".checkout .btn-primary")
    private WebElement goToCheckoutBtn;

    public void removeProductFromCart() {
        trashIcon.click();
        logger.info("Product removed from cart");
    }

    public Cart toCart() {
        Cart cart = new Cart();
        for (int i = 0; i < cartRows.size(); i++) {
            String name = productsNames.get(i).getText();
            String price = productsPrices.get(i).getText();
            int quantity = Integer.parseInt(productsQuantities.get(i).getAttribute("value"));
            cart.addProduct(new Product(name, price, quantity));
        }
        return cart;
    }
    public List<WebElement> getCartRows() {
        return cartRows;
    }
    public double getTotalValueInCart() {
        logger.info("Value in cart: " + totalValueInCart.getText());
        return getPrice(totalValueInCart);
    }

    public double getShippingCost() {
        return getPrice(shippingCost);
    }

    public void goToCheckout() {
        waitForElement(goToCheckoutBtn);
        goToCheckoutBtn.click();
    }
}


