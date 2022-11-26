package start;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import pages.*;
import pages.commons.FooterPage;
import pages.commons.HeaderPage;
import pages.commons.TopMenuPage;
import pages.order.OrderConfirmationPage;
import pages.order.OrderDetailsPage;
import pages.order.OrderHistoryPage;
import pages.product.FilterPage;
import pages.product.ProductDialogPage;
import pages.product.ProductsPage;
import pages.product.SingleProductPage;
import pages.user.AccountPage;
import pages.user.LoginPage;
import pages.user.RegistrationPage;

public class Pages extends TestBase {
    public BasePage basePage;
    public ProductsPage productsPage;
    public FilterPage filterPage;
    public HeaderPage headerPage;
    public FooterPage footerPage;
    public SoftAssertions softly;
    public RegistrationPage registrationPage;
    public TopMenuPage topMenuPage;
    public SingleProductPage singleProductPage;
    public ProductDialogPage productDialogPage;
    public CartPage cartPage;
    public LoginPage loginPage;
    public CheckoutPage checkoutPage;
    public OrderConfirmationPage orderConfirmationPage;
    public AccountPage accountPage;
    public OrderHistoryPage orderHistoryPage;
    public OrderDetailsPage orderDetailsPage;

    @BeforeEach
    public void setupPages() {
        basePage = new BasePage(driver);
        productsPage = new ProductsPage(driver);
        filterPage = new FilterPage(driver);
        headerPage = new HeaderPage(driver);
        footerPage = new FooterPage(driver);
        registrationPage = new RegistrationPage(driver);
        topMenuPage = new TopMenuPage(driver);
        singleProductPage = new SingleProductPage(driver);
        productDialogPage = new ProductDialogPage(driver);
        cartPage = new CartPage(driver);
        loginPage = new LoginPage(driver);
        checkoutPage = new CheckoutPage(driver);
        orderConfirmationPage = new OrderConfirmationPage(driver);
        accountPage = new AccountPage(driver);
        orderHistoryPage = new OrderHistoryPage(driver);
        orderDetailsPage = new OrderDetailsPage(driver);

    }

    @BeforeEach
    public void setupSoftAssertion() {
        softly = new SoftAssertions();
    }
}
