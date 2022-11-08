package pages;

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
        quantity.clear();
        quantity.sendKeys(String.valueOf(random.nextInt(10)));
    }



}
