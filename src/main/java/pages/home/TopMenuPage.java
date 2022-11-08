package pages.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class TopMenuPage extends BasePage {

    public TopMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#category-3")
    private WebElement clothesCategory;

    @FindBy(css = "#category-4")
    private WebElement clothesMenCategory;

    @FindBy(css = "#category-5")
    private WebElement clothesWomenCategory;

    @FindBy(xpath = "//*[@id='category-6']")
    private WebElement accessoriesCategory;

    @FindBy(xpath = "//*[@id='category-7']")
    private WebElement stationeryCategory;

    @FindBy(xpath = "//*[@id='category-8']")
    private WebElement homeAccessoriesCategory;

    @FindBy(css = "#category-9")
    private WebElement artCategory;

    public String getCategoryTitle() {
        return categoryTitle.getText();
    }

    @FindBy(css = ".h1")
    private WebElement categoryTitle;

    public TopMenuPage moveMouseToCategoryTitle(String categoryTitle) {
        switch (categoryTitle) {
            case "clothes":
                mouseHover(clothesCategory);
                break;
            case "clothesMen":
                mouseHover(clothesCategory);
                mouseHover(clothesMenCategory);
                break;
            case "clothesWomen":
                mouseHover(clothesCategory);
                mouseHover(clothesWomenCategory);
                break;
            case "accessories":
                mouseHover(accessoriesCategory);
                break;
            case "stationery":
                mouseHover(accessoriesCategory);
                mouseHover(stationeryCategory);
                break;
            case "homeAccessories":
                mouseHover(accessoriesCategory);
                mouseHover(homeAccessoriesCategory);
                break;
            case "art":
                mouseHover(artCategory);
                break;

        }
        return this;
    }

    public TopMenuPage enterCategory(String category) {
        switch(category) {
            case "clothes":
                clothesCategory.click();
                waitForElement(categoryTitle);
                break;
            case "clothesMen":
                clothesMenCategory.click();
                waitForElement(categoryTitle);
                break;
            case "clothesWomen":
                clothesWomenCategory.click();
                waitForElement(categoryTitle);
                break;
            case "accessories":
                accessoriesCategory.click();
                waitForElement(categoryTitle);
                break;
            case "stationery":
                stationeryCategory.click();
                waitForElement(categoryTitle);
                break;
            case "homeAccessories":
                homeAccessoriesCategory.click();
                waitForElement(categoryTitle);
                break;
            case "art":
                artCategory.click();
                waitForElement(categoryTitle);
                break;

        }
        return this;
    }
//
//
//    public TopMenuPage moveMouseToMenClothes() {
//        mouseHover(clothesCategory);
//
//        mouseHover(clothesMenCategory);
//        clothesMenCategory.click();
//        waitForElement(categoryTitle);
//        return this;
//    }
//
//    public TopMenuPage moveMouseToWomenClothes() {
//        mouseHover(clothesCategory);
//        mouseHover(clothesWomenCategory);
//        clothesWomenCategory.click();
//        waitForElement(categoryTitle);
//        return this;
//    }
//
//    public TopMenuPage moveMouseToAccessories() {
//        mouseHover(accessoriesCategory);
//
//        mouseHover(stationeryCategory);
//        stationeryCategory.click();
//        waitForElement(categoryTitle);
//
//        mouseHover(homeAccessoriesCategory);
//        homeAccessoriesCategory.click();
//        waitForElement(categoryTitle);
//
//        return this;
//    }
//
//    public TopMenuPage moveMouseToArt() {
//        mouseHover(artCategory);
//        return this;
//    }

}
