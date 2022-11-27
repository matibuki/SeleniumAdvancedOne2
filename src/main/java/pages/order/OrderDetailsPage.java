package pages.order;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

import java.math.BigDecimal;

public class OrderDetailsPage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(OrderDetailsPage.class);

    public OrderDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"order-history\"]/table/tbody/tr/td[1]")
    private WebElement orderDate;

    @FindBy(xpath = "//*[@id=\"order-products\"]/tfoot/tr[position()=last()]/td[2]")
    private WebElement orderTotalCost;


    @FindBy(xpath = "//*[@id='delivery-address']/address")
    private WebElement orderDeliveryAddress;

    @FindBy(xpath = "//*[@id='invoice-address']/address")
    private WebElement orderBillingAddress;

    @FindBy(xpath = "//*[@id=\"order-history\"]/table/tbody/tr/td[2]/span")
    private WebElement orderPaymentStatus;

    public String getOrderDate() {
        return orderDate.getText();
    }

    public BigDecimal getOrderTotalCost() {
        return BigDecimal.valueOf(getPrice(orderTotalCost));
    }

    public String getOrderDeliveryAddress() {
        return orderDeliveryAddress.getText();
    }

    public String getOrderBillingAddress() {
        return orderBillingAddress.getText();
    }

    public String getOrderPaymentStatus() {
        return orderPaymentStatus.getText();
    }
}
