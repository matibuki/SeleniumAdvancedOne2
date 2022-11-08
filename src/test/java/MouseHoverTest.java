import org.junit.jupiter.api.Test;
import start.Pages;

public class MouseHoverTest extends Pages {

    @Test
    public void hoverClothesTest() {
        topMenuPage.moveMouseToCategoryTitle("clothes");
        topMenuPage.enterCategory("clothes");
        softly.assertThat(topMenuPage.getCategoryTitle()).isEqualTo("CLOTHES");

        topMenuPage.moveMouseToCategoryTitle("clothesMen");
        topMenuPage.enterCategory("clothesMen");
        softly.assertThat(topMenuPage.getCategoryTitle()).isEqualTo("MEN");

        topMenuPage.moveMouseToCategoryTitle("clothesWomen");
        topMenuPage.enterCategory("clothesWomen");
        softly.assertThat(topMenuPage.getCategoryTitle()).isEqualTo("WOMEN");

        softly.assertAll();
    }

    @Test
    public void hoverAccessoriesTest() {
        topMenuPage.moveMouseToCategoryTitle("accessories");
        topMenuPage.enterCategory("accessories");
        softly.assertThat(topMenuPage.getCategoryTitle()).isEqualTo("ACCESSORIES");

        topMenuPage.moveMouseToCategoryTitle("stationery");
        topMenuPage.enterCategory("stationery");
        softly.assertThat(topMenuPage.getCategoryTitle()).isEqualTo("STATIONERY");

        topMenuPage.moveMouseToCategoryTitle("homeAccessories");
        topMenuPage.enterCategory("homeAccessories");
        softly.assertThat(topMenuPage.getCategoryTitle()).isEqualTo("HOME ACCESSORIES");

        softly.assertAll();
    }

    @Test
    public void hoverArtTest() {
        topMenuPage.moveMouseToCategoryTitle("art");
        topMenuPage.enterCategory("art");
        softly.assertThat(topMenuPage.getCategoryTitle()).isEqualTo("ART");

        softly.assertAll();
    }
}
