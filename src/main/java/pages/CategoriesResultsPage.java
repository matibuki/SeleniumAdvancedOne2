package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CategoriesResultsPage extends BasePage {
    private static Logger logger = LoggerFactory.getLogger(CategoriesResultsPage.class);

    public CategoriesResultsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".ui-autocomplete-input")
    private WebElement searchCatalogInput;

    @FindBy(css = ".product")
    private List<WebElement> products;

    @FindBy(css = ".price")
    private List<WebElement> prices;

    public WebElement getTotalProductsNumber() {
        return totalProductsNumber;
    }

    @FindBy(css = ".total-products")
    private WebElement totalProductsNumber;

    public WebElement getCategoryHeader() {
        return categoryHeader;
    }

    @FindBy(css = "#js-product-list-header h1")
    private WebElement categoryHeader;

    public List<WebElement> getProducts() {
        return products;
    }

    public int extractNumberOfProductsFromString() {
        return Integer.parseInt(totalProductsNumber.getText().replaceAll("[^0-9]", ""));

    }
    public double getProductPrice(int i) {
        return getPrice(prices.get(i));
    }

    public double getProductsCount() {
        return getProducts().size();
    }





}