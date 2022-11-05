package pages.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

public class FooterPage extends BasePage {
    private static Logger logger = LoggerFactory.getLogger(FooterPage.class);

    public FooterPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getPricesDropLink() {
        return pricesDropLink;
    }

    //PRODUCTS
    @FindBy(css = "#link-product-page-prices-drop-1")
    private WebElement pricesDropLink;

    @FindBy(css = "link-product-page-new-products-1")
    private WebElement newProductsLink;

    @FindBy(css = "link-product-page-best-sales-1")
    private WebElement bestSalesLink;


}
