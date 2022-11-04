package start;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import pages.*;
import pages.home.HeaderPage;

public class Pages extends TestBase {
    public ProductsPage productsPage;
    public FilterPage filterPage;
    public HeaderPage headerPage;
    public SoftAssertions softly;

    @BeforeEach
    public void setupPages() {
        productsPage = new ProductsPage(driver);
        filterPage = new FilterPage(driver);
        headerPage = new HeaderPage(driver);

    }

    @BeforeEach
    public void setupSoftAssertion() {
        softly = new SoftAssertions();
    }
}
