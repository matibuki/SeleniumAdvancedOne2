package pages;

import models.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SingleProductPage extends BasePage {
    private static Logger logger = LoggerFactory.getLogger(SingleProductPage.class);

    public SingleProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".h1")
    private WebElement productName;
    @FindBy(css = ".current-price")
    private WebElement productPrice;
    @FindBy(css = "#quantity-wanted")
    private WebElement quantity;

    @FindBy(css = ".btn.btn-primary.add-to-cart")
    private WebElement addToCartBtn;

    public void addProductToCart() {
        addToCartBtn.click();
    }

    public void setProductQuantity(String quantity) {
        this.quantity.clear();
        this.quantity.sendKeys(quantity);
    }

    public Product newProductBuilder() {
        String productName = this.productName.getText();
        String productPrice = this.productPrice.getText();
        String productQuantity = this.quantity.getText();

        logger.info("New product created" + productName + productPrice + productQuantity);
        Product product = new Product(productName, productPrice, Integer.parseInt(productQuantity));
        logger.info(product.toString());
        return product;
//        return new Product(productName, productPrice, Integer.parseInt(productQuantity));

    }



}
