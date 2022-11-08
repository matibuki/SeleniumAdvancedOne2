package CartTests;

import ProductsTests.CategoriesTests;
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
    public void cartPopup() {
        headerPage.enterCategoryByName("ART");
        productsPage.openProduct("THE BEST IS YET POSTER");
    }

}
