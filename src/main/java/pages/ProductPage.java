package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ProductPage extends BasePage {
    private static Logger logger = LoggerFactory.getLogger(ProductPage.class);

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".price")
    private WebElement price;

    @FindBy(css = ".product")
    private WebElement product;

    @FindBy(css = ".product-title")
    private WebElement title;

    public double getProductPrice() {
        return getPrice(price);
    }

    public WebElement getProduct() {
        return product;
    }
}
