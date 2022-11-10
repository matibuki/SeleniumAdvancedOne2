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

    private List<Product> productsInCartList;

    public void removeProductFromCart() {
        trashIcon.click();
        logger.info("Product removed from cart");
    }

    public Cart toCart() {
        productsInCartList = new ArrayList<>();
        Cart websiteCart = new Cart();
        for (int i = 0; i < cartRows.size(); i++) {
            String name = productsNames.get(i).getText();
            logger.info("Found product in cart page " + name);
            String price = productsPrices.get(i).getText();
            logger.info(price);
            int quantity = Integer.parseInt(productsQuantities.get(i).getAttribute("value"));
            logger.info(String.valueOf(quantity));
            Product product = new Product(name, price, quantity);
            productsInCartList.add(product);
        }
        return websiteCart;
    }

    public List<Product> getProductsInCartList() {
        return productsInCartList;
    }
    public List<WebElement> getCartRows() {
        return cartRows;
    }
}


