package start;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import pages.*;

public class Pages extends TestBase {
    public CategoriesResultsPage categoriesResultsPage;
    public FilterPage filterPage;
    public HeaderPage headerPage;
    public ProductPage productPage;
    public SearchResultsPage searchResultsPage;
    public SoftAssertions softly;

    @BeforeEach
    public void setupPages() {
        categoriesResultsPage = new CategoriesResultsPage(driver);
        filterPage = new FilterPage(driver);
        headerPage = new HeaderPage(driver);
        productPage = new ProductPage(driver);
        searchResultsPage = new SearchResultsPage(driver);


    }

    @BeforeEach
    public void setupSoftAssertion() {
        softly = new SoftAssertions();
    }
}
