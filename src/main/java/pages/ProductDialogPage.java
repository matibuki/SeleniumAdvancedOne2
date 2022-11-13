package pages;

import models.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductDialogPage extends BasePage {
    private static Logger logger = LoggerFactory.getLogger(ProductDialogPage.class);

    public ProductDialogPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".cart-content .cart-products-count")
    private WebElement productCountString;

    @FindBy(css = ".col-md-6 .h6.product-name")
    private WebElement productName;

    @FindBy(css = ".divide-right .col-md-6 .product-price")
    private WebElement productPrice;



    @FindBy(css = ".col-md-5 .col-md-6 .product-quantity")
    private WebElement productQuantity;

    @FindBy(css = ".product-total .value")
    private WebElement totalPrice;

    @FindBy(css = ".cart-content-btn .btn-secondary")
    private WebElement continueShoppingBtn;


    @FindBy(css = "    .cart-content-btn .btn-primary")
    private WebElement goToCheckoutBtn;

    public WebElement getProductCountString() {
        return productCountString;
    }

    public WebElement getProductName() {
        return productName;
    }

    public WebElement getProductPrice() {
        return productPrice;
    }

    public int getProductQuantityString() {
        return Integer.parseInt(productQuantity.getText().replaceAll("[a-zA-Z\\s:]", ""));
    }

    public WebElement getTotalPrice() {
        return totalPrice;
    }

    public WebElement getContinueShoppingBtn() {
        return continueShoppingBtn;
    }

    public WebElement getGoToCheckoutBtn() {
        return goToCheckoutBtn;
    }

    public void continueShopping() {
        waitForElement(continueShoppingBtn);
        continueShoppingBtn.click();
        logger.info("Back to page");
    }
    public void gotoCheckout() {
        waitForElement(goToCheckoutBtn);
        goToCheckoutBtn.click();
    }

    public Product productInDialog() {
        return new Product(productName.getText(), productPrice.getText(), getProductQuantityString());
    }
}
