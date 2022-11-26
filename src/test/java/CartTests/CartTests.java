package CartTests;

import models.Cart;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import start.Pages;

public class CartTests extends Pages {
    private static Logger logger = LoggerFactory.getLogger(CartTests.class);

    //        @RepeatedTest(10)
    @Test
    @DisplayName("Add product to cart and compare with cart")
    public void cartPopupTest() {
        headerPage.enterCategoryByName(System.getProperty("basket_categoryname"));
        productsPage.openProductByName(System.getProperty("basket_productname"));
        singleProductPage.setProductQuantity(System.getProperty("basket_quantity"));
        Cart expectedCart = new Cart();
        expectedCart.addProduct(singleProductPage.newProductBuilder());
        singleProductPage.addProductToCart();

        softly.assertThat(expectedCart.getProducts().get(0).getProductName()).isEqualTo(productDialogPage.productInDialog().getProductName());
        softly.assertThat(expectedCart.getProducts().get(0).getProductPrice()).isEqualTo(productDialogPage.productInDialog().getProductPrice());
        softly.assertThat(expectedCart.getProducts().get(0).getProductQuantity()).isEqualTo(productDialogPage.productInDialog().getProductQuantity());
        softly.assertAll();
    }

    @Test
    public void cartCalculationsTest() {
        Cart expectedCart = new Cart();
        for (int i = 0; i < Integer.parseInt(System.getProperty("numberOfCalculationRuns")); i++) {
            basePage.openHomepage();
            productsPage.openRandomProductFromHomePage();
            singleProductPage.setRandomProductQuantity(1, 5);
            expectedCart.addProduct(singleProductPage.newProductBuilder());
            singleProductPage.addProductToCart();
            productDialogPage.continueShopping();
        }
        headerPage.openCartPage();
        softly.assertThat(expectedCart).usingRecursiveComparison().isEqualTo(cartPage.toCart());
        softly.assertThat(cartPage.getTotalValueInCart()).isEqualTo(expectedCart.getTotalOrderCost()); //  + cartPage.getShippingCost()
        softly.assertAll();
    }

    @Test
    public void checkoutTest() {
        loginPage.loginPredefinedUser();
        headerPage.enterCategoryByName(System.getProperty("basket_categoryname"));
        productsPage.openProductByName(System.getProperty("basket_productname"));
        singleProductPage.addProductToCart();
        productDialogPage.gotoCheckout();
        double totalOrderValue = cartPage.getTotalValueInCart();
        cartPage.goToCheckout();

        checkoutPage.changeBillingAddress();
        checkoutPage.fillDifferentAddress();
        checkoutPage.chooseRandomShippingMethod();
        checkoutPage.payByCheck();
        checkoutPage.acceptTermsAndConditions();
        checkoutPage.placeOrder();
        String orderNumber = orderConfirmationPage.getOrderReference();
        basePage.openAccountPage();
        accountHomePage.openOrderHistory();
        orderHistoryPage.findOrderAndOpen(orderNumber);

        softly.assertThat(orderDetailsPage.getOrderDate()).isEqualTo(orderDetailsPage.returnTodayDate());
        softly.assertThat(orderDetailsPage.getOrderTotalCost()).isEqualTo(totalOrderValue);
        softly.assertThat(orderDetailsPage.getOrderBillingAddress()).isEqualTo(checkoutPage.billingAddress());
        softly.assertThat(orderDetailsPage.getAddress()).isEqualTo(checkoutPage.getAddress());
        softly.assertThat(orderDetailsPage.getOrderPaymentStatus()).isEqualTo(System.getProperty("payment_status"));
        softly.assertAll();
    }
}