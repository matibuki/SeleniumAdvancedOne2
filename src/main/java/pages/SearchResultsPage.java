package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsPage extends BasePage{
    private static Logger logger = LoggerFactory.getLogger(SearchResultsPage.class);

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = ".product-title")
    private List<WebElement> availableProducts;

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
}

