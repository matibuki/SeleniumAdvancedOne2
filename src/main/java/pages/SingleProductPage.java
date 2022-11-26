package pages;

import models.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SingleProductPage extends BasePage {
    private static Logger logger = LoggerFactory.getLogger(SingleProductPage.class);

    public SingleProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".h1")
    private WebElement productName;
    @FindBy(xpath = "//span[@itemprop='price']")
    private WebElement productPrice;
    @FindBy(css = "#quantity_wanted")
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

    public void setRandomProductQuantity(int randomStart, int randomEnd) {
        waitForElement(quantity);
        String number = String.valueOf(random.nextInt(randomStart, randomEnd));
        this.quantity.clear();
        this.quantity.sendKeys(number);
    }

    public Product newProductBuilder() {
        String newProductName = this.productName.getText();
        String newProductPrice = this.productPrice.getText();
        int newProductQuantity = Integer.parseInt(this.quantity.getAttribute("value"));

        logger.info("New product created " + newProductName + "----" + newProductPrice + "----" + newProductQuantity);
        return new Product(newProductName, newProductPrice, newProductQuantity);
    }
}
