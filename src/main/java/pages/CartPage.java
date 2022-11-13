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
    private static Logger logger = LoggerFactory.getLogger(CartPage.class);

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


    BasePage basePage = new BasePage(driver);



    public void removeProductFromCart() {
        trashIcon.click();
        logger.info("Product removed from cart");
    }

    public Cart toCart() {
        Cart websiteCart = new Cart();
        for (int i = 0; i < cartRows.size(); i++) {
            String name = productsNames.get(i).getText();
            logger.info("Found product in cart page " + name);
            String price = productsPrices.get(i).getText();
            logger.info(price);
            int quantity = Integer.parseInt(productsQuantities.get(i).getAttribute("value"));
            logger.info(String.valueOf(quantity));
            websiteCart.addProduct(new Product(name, price, quantity));
        }
        return websiteCart;
    }
    public List<WebElement> getCartRows() {
        return cartRows;
    }
    public double getTotalValueInCart() {
        logger.info("Value in cart: " + String.valueOf(totalValueInCart.getText()));
        return basePage.getPrice(totalValueInCart);

    }

    public double getShippingCost() {
        return basePage.getPrice(shippingCost);
    }

    public void goToCheckout() {
        waitForElement(goToCheckoutBtn);
        goToCheckoutBtn.click();

    }

//    public String singleProduct(List<Product> list){
//        return list.get(0).toString();
//    }
}


