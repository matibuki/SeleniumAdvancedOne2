package ProductsTests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import start.Pages;

public class OnSaleTests extends Pages {
    private static Logger logger = LoggerFactory.getLogger(OnSaleTests.class);

    //        @RepeatedTest(10)
    @Test
    public void onSaleTest() {
        headerPage.clickElement(footerPage.getPricesDropLink());
        softly.assertThat(productsPage.getProductListTitle()).isEqualTo(System.getProperty("onSaleHeader"));

        for (WebElement tag : productsPage.getDiscountTag()) {
            softly.assertThat(tag.getText()).isEqualTo("-20%");
        }
        int i = productsPage.numberOfProductsFound();

        softly.assertAll();
    }
}
