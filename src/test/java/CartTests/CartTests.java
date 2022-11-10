package CartTests;

import models.Cart;
import models.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import start.Pages;

public class CartTests extends Pages {
    private static Logger logger = LoggerFactory.getLogger(CartTests.class);

    //        @RepeatedTest(10)
    @Test
    @DisplayName("Verify number of products in categories display")
    public void cartPopupTest() {
//        headerPage.enterCategoryByName("ART");
//        productsPage.openBestPoster();
//        singleProductPage.setProductQuantity("3");
//        singleProductPage.addProductToCart();
//
//        for (Product product : cart) {
//
//        }
//
//        softly.assertThat(productDialogPage.getProductName()).isEqualTo(product.get);
//        softly.assertThat(productDialogPage.getProductPrice()).isEqualTo();
//        softly.assertThat(basePage.productsCountInString(productDialogPage.getProductCountString())).isEqualTo();
//    }

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
        logger.info("Cart size in cart page: "); //todo

    }
}
