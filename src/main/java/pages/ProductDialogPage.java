package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductDialogPage extends BasePage{
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


    public WebElement getProductCountString() {
        return productCountString;
    }

    public WebElement getProductName() {
        return productName;
    }

    public WebElement getProductPrice() {
        return productPrice;
    }
}
