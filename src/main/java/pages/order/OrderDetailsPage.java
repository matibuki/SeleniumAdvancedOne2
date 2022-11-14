package pages.order;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;
import pages.userHandling.LoginPage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class OrderDetailsPage extends BasePage {
    private static Logger logger = LoggerFactory.getLogger(OrderDetailsPage.class);

    public OrderDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"order-history\"]/table/tbody/tr/td[1]")
    private WebElement orderDate;

    public String getOrderDate() {
        return orderDate.getText();
    }

    public double getOrderTotalCost() {
        return getPrice(orderTotalCost);
    }

    public String getOrderBillingAddress() {
        return orderBillingAddress.getText();
    }

    public String getOrderPaymentStatus() {
        return orderPaymentStatus.getText();
    }

    @FindBy(xpath = "//*[@id=\"order-products\"]/tfoot/tr[position()=last()]/td[2]")
    private WebElement orderTotalCost;

    @FindBy(xpath = "//*[@id='invoice-address']/address")
    private WebElement orderBillingAddress;

    @FindBy(xpath = "//*[@id=\"order-history\"]/table/tbody/tr/td[2]/span")
    private WebElement orderPaymentStatus;

    public String returnTodayDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date now = new Date();
        return sdf.format(now);
    }


    public String getAddress() {
        return "test";
    }
}
