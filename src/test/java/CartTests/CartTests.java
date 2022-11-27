package CartTests;

import factory.UserFactory;
import models.Cart;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import start.Pages;
import utils.Helpers;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.offset;
import static org.assertj.core.api.Assertions.withPrecision;

public class CartTests extends Pages {
    private static final Logger logger = LoggerFactory.getLogger(CartTests.class);

    //        @RepeatedTest(10)
    @Test
    @DisplayName("Add product to cart and compare with cart")
    public void cartPopupTest() {
        headerPage.enterCategoryByName(System.getProperty("basket_categoryname"));
        productsPage.openProductByName(System.getProperty("basket_productname"));
        singleProductPage.setProductQuantity(System.getProperty("basket_quantity"));
        Cart expectedCart = new Cart();
        expectedCart.addProduct(singleProductPage.newProduct());
        singleProductPage.addProductToCart();

        softly.assertThat(expectedCart.getProducts().get(0).getProductName()).isEqualTo(productDialogPage.productInDialog().getProductName());
        softly.assertThat(expectedCart.getProducts().get(0).getProductPrice()).isEqualTo(productDialogPage.productInDialog().getProductPrice());
        softly.assertThat(expectedCart.getProducts().get(0).getProductQuantity()).isEqualTo(productDialogPage.productInDialog().getProductQuantity());
        softly.assertAll();
    }

    @Test
    public void cartCalculationsTest() {
        Cart expectedCart = new Cart();
        for (int i = 1; i <= Integer.parseInt(System.getProperty("numberOfCalculationRuns")); i++) {
            basePage.openHomepage();
            productsPage.openRandomProductFromHomePage();
            singleProductPage.setRandomProductQuantity(1, 5);
            expectedCart.addProduct(singleProductPage.newProduct());
            singleProductPage.addProductToCart();
            productDialogPage.continueShopping();
        }
        headerPage.openCartPage();
        softly.assertThat(expectedCart).usingRecursiveComparison().isEqualTo(cartPage.toCart());
        softly.assertThat(cartPage.getTotalValueInCart()).isEqualByComparingTo(expectedCart.getTotalOrderCost());
        softly.assertAll();
    }

    @Test
    public void checkoutTest() {
        loginPage.loginUser(UserFactory.getAlreadyRegisteredUser());
        headerPage.enterCategoryByName(System.getProperty("basket_categoryname"));
        productsPage.openProductByName(System.getProperty("basket_productname"));
        singleProductPage.addProductToCart();
        productDialogPage.gotoCheckout();
        BigDecimal totalOrderValue = cartPage.getTotalValueInCart();
        cartPage.goToCheckout();

        checkoutPage.changeBillingAddress();
        checkoutPage.fillAddress(UserFactory.getAlreadyRegisteredUser());
        checkoutPage.chooseRandomShippingMethod();
        checkoutPage.payByCheck();
        checkoutPage.acceptTermsAndConditions();
        checkoutPage.placeOrder();
        String orderNumber = orderConfirmationPage.getOrderReference();
        basePage.openAccountPage();
        accountPage.openOrderHistory();
        orderHistoryPage.openOrderByNumber(orderNumber);

        String userAddress = UserFactory.getAlreadyRegisteredUser().getFirstName() + " " +
                UserFactory.getAlreadyRegisteredUser().getLastName() + "\n" +
                UserFactory.getAlreadyRegisteredUser().getStreetName() + "\n" +
                UserFactory.getAlreadyRegisteredUser().getZipCode() + " " +
                UserFactory.getAlreadyRegisteredUser().getCity() + "\n" +
                UserFactory.getAlreadyRegisteredUser().getCountry();

        softly.assertThat(orderDetailsPage.getOrderDate()).isEqualTo(Helpers.todayDate());
        softly.assertThat(orderDetailsPage.getOrderTotalCost()).isEqualTo(totalOrderValue);
        softly.assertThat(orderDetailsPage.getOrderBillingAddress()).isEqualToIgnoringNewLines(userAddress);
        softly.assertThat(orderDetailsPage.getOrderDeliveryAddress()).isEqualTo(userAddress);
        softly.assertThat(orderDetailsPage.getOrderPaymentStatus()).isEqualTo(System.getProperty("payment_status"));
        softly.assertAll();
    }
}