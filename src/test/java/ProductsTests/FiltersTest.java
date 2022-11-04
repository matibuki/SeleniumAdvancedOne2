package ProductsTests;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import start.Pages;

public class FiltersTest extends Pages {
    private static Logger logger = LoggerFactory.getLogger(FiltersTest.class);

    //        @RepeatedTest(10)
    @Test
    public void filtersTest() {
        headerPage.enterCategoryByName(System.getProperty("filterTestCategory"));

        double priceRangeMin = Double.parseDouble(System.getProperty("minPriceRange"));
        double priceRangeMax = Double.parseDouble(System.getProperty("maxPriceRange"));

        filterPage.setMinimumPrice(priceRangeMin);
        filterPage.setMaximumPrice(priceRangeMax);

        if (productsPage.getProducts().size() > 0) {
            logger.info("Number of products found: " + productsPage.getProducts().size());
            for (int i = 0; i < productsPage.getProducts().size(); i++) {
                logger.info("Product price: " + productsPage.getProductPrice(i));

                softly.assertThat(productsPage.getProductPrice(i)).isBetween(priceRangeMin,priceRangeMax);
                softly.assertAll();
            }
        } else {
            logger.info("There are no products in that price range!");
        }
    }
}