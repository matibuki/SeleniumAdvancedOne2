package SearchTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import start.Pages;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchTests extends Pages {

    @RepeatedTest(10)
    @DisplayName("Search for random item from main page")
    public void genericSearchTest() {
        headerPage.searchForRandomItemInCatalog();
        headerPage.clickSearch();
        productsPage.findElementInList(headerPage.randomElementToSearch().getText());

        softly.assertThat(productsPage.numberOfProductsFound()).isEqualTo(1);
        softly.assertThat(headerPage.randomElementToSearch().getText()).isEqualTo(headerPage.randomElementToSearch().getText());
        softly.assertAll();
    }

    @Test
    @DisplayName("Search for product in dropdown")
    public void dropdownSearchTest() {
        headerPage.searchForDefinedProduct();

        for (String product : headerPage.productSearchResult()) {
            softly.assertThat(product).contains(System.getProperty("definedProduct"));
        }
        softly.assertAll();
    }
}

