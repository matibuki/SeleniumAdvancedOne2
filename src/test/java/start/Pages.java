package start;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import pages.*;
import pages.home.FooterPage;
import pages.home.HeaderPage;

public class Pages extends TestBase {
    public BasePage basePage;
    public ProductsPage productsPage;
    public FilterPage filterPage;
    public HeaderPage headerPage;

    public FooterPage footerPage;
    public SoftAssertions softly;
    public RegistrationPage registrationPage;

    @BeforeEach
    public void setupPages() {
        basePage = new BasePage(driver);
        productsPage = new ProductsPage(driver);
        filterPage = new FilterPage(driver);
        headerPage = new HeaderPage(driver);
        footerPage = new FooterPage(driver);
        registrationPage = new RegistrationPage(driver);
    }

    @BeforeEach
    public void setupSoftAssertion() {
        softly = new SoftAssertions();
    }
}
