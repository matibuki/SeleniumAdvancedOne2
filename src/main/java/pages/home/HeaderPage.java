package pages.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

import java.util.ArrayList;
import java.util.List;

public class HeaderPage extends BasePage {
    private static Logger logger = LoggerFactory.getLogger(HeaderPage.class);

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".ui-autocomplete-input")
    private WebElement searchCatalogInput;

    @FindBy(css = ".product-title")
    private List<WebElement> availableProducts;

    @FindBy(xpath = "//*[@id=\"search_widget\"]/form/button/i")
    private WebElement searchCatalogIcon;

    @FindBy(css = ".ui-widget .ui-menu-item")
    private List<WebElement> dropdownOptions;

    @FindBy(xpath = "//a[@class='dropdown-item']")
    private List<WebElement> categories;

    @FindBy(css = ".total-products")
    private WebElement totalProducts;

    @FindBy(css = ".logout")
    private WebElement signOutBtn;



    public WebElement randomElementToSearch() {
        return getRandomElementFromList(availableProducts);
    }

    public void searchForRandomItemInCatalog() {
        searchCatalogInput.sendKeys(randomElementToSearch().getText());
    }

    public void clickSearch() {
        searchCatalogIcon.click();
    }

    public void searchForDefinedProduct() {
        waitForElement(searchCatalogInput);
        searchCatalogInput.sendKeys(System.getProperty("definedProduct"));
        waitForElements(dropdownOptions);
    }
    public List<String> productSearchResult() {
        List<String> list = new ArrayList<>();
        for (WebElement element : dropdownOptions) {
            list.add(element.getText().toLowerCase());
        }
        return list;
    }

    public List<WebElement> getCategories() {
        return categories;
    }

    public String getCategoryName(int i) {
        return categories.get(i).getText();
    }

    public void enterCategoryByName(String name) {
        for (WebElement category : categories) {
            if (category.getText().toLowerCase().equals(name)) {
                logger.info("Category chosen= " + category.getText());
                category.click();
            }
        }
    }

    public String getLogoutBtn() {
        waitForElement(signOutBtn);
        return signOutBtn.getText();
    }
}

