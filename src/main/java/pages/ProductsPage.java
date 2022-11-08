package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ProductsPage extends BasePage {
    private static Logger logger = LoggerFactory.getLogger(ProductsPage.class);

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".ui-autocomplete-input")
    private WebElement searchCatalogInput;

    @FindBy(css = ".product")
    private List<WebElement> products;

    @FindBy(css = ".product-title")
    private List<WebElement> availableProducts;


    @FindBy(css = ".price")
    private List<WebElement> prices;

    @FindBy(css = ".total-products")
    private WebElement totalProductsNumber;

    public WebElement getCategoryHeader() {
        return categoryHeader;
    }

    @FindBy(css = "#js-product-list-header h1")
    private WebElement categoryHeader;

    public String getProductListTitle() {
        return productHeader.getText();
    }

    @FindBy(css = "#js-product-list-header")
    private WebElement productHeader;

    public List<WebElement> getDiscountTag() {
        return discountTag;
    }

    @FindBy(css = ".product-flag")
    private List<WebElement> discountTag;

    @FindBy(linkText = "THE BEST IS YET POSTER")
    private WebElement thebestisyetPoster;

    public List<WebElement> getProducts() {
        return products;
    }

    public int productsCountInSubtitle() {
        return Integer.parseInt(totalProductsNumber.getText().replaceAll("[^0-9]", ""));
    }
    public double getProductPrice(int i) {
        return getPrice(prices.get(i));
    }

    public double getProductsCount() {
        return getProducts().size();
    }

    public int numberOfProductsFound() {
        return availableProducts.size();
    }

    String searchResult;

    public String findElementInList(String searchResultElement) {
        for (WebElement element : availableProducts) {
            if (element.getText().equals(searchResultElement)) {
                searchResult = searchResultElement;
                logger.info("Found element: " + searchResult);
            }
        }
        return searchResult;
    }

    public void openBestPoster() {
        thebestisyetPoster.click();

    }
}