package productsTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import base.Pages;

public class CategoriesTests extends Pages {
    private static Logger logger = LoggerFactory.getLogger(CategoriesTests.class);

    //        @RepeatedTest(10)
    @Test
    @DisplayName("Verify number of products in categories display")
    public void productsInCategoriesTest() {
        softly.assertThat(headerPage.getCategories()).isNotEmpty();

        for (int i = 0; i < headerPage.numberOfCategories(); i++) {
            headerPage.openCategory(i);
            logger.info("Category entered: " + headerPage.getCategoryName(i));

            softly.assertThat(headerPage.getCategoryName(i)).isEqualTo(productsPage.getCategoryHeader().getText());
            softly.assertThat(productsPage.getProductsCount()).isEqualTo(productsPage.productsCountInSubtitle());
        }
        softly.assertAll();
    }
}
