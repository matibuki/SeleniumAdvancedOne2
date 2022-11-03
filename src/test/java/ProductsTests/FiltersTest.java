package ProductsTests;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.CategoriesResultsPage;
import pages.FilterPage;
import pages.HeaderPage;
import pages.ProductPage;
import start.Pages;
import start.TestBase;

import java.util.List;

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

        if (categoriesResultsPage.getProducts().size() > 0) {
            logger.info("Number of products found: " + categoriesResultsPage.getProducts().size());
            for (int i=0; i < categoriesResultsPage.getProducts().size(); i++) {
                logger.info("Product price: " + categoriesResultsPage.getProductPrice(i));

                softly.assertThat(categoriesResultsPage.getProductPrice(i)).isBetween(priceRangeMin,priceRangeMax);
                softly.assertAll();
            }
        } else {
            logger.info("There are no products in that price range!");
        }
    }
}