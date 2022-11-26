package pages.order;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;
import java.util.List;

public class OrderHistoryPage extends BasePage {
    private static Logger logger = LoggerFactory.getLogger(OrderHistoryPage.class);
    public OrderHistoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#order-details > ul > li:nth-child(1)")
    private WebElement orderReference;

    @FindBy(linkText = "Details")
    private List<WebElement> detailsLinkList;

    @FindBy(xpath = "//*[@id=\"content\"]/table/tbody/tr")
    private List<WebElement> ordersList;

    public void openOrderByNumber(String orderNumber) {
        for (int i = 0; i < ordersList.size(); i++) {
            if (ordersList.get(i).getText().contains(orderNumber)) {
                detailsLinkList.get(i).click();
            }
        }
    }
}