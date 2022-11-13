package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CheckoutPage extends BasePage {
    private static Logger logger = LoggerFactory.getLogger(CheckoutPage.class);

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Billing address differs from shipping address")
    private WebElement diffAddressLink;

    @FindBy(xpath = "//input[@name=\"address1\"]")
    private WebElement addressField;

    @FindBy(xpath = "//input[@name=\"postcode\"]")
    private WebElement postcodeField;

    @FindBy(xpath = "//input[@name=\"city\"]")
    private WebElement cityField;

    @FindBy(xpath = "//button[@name=\"confirm-addresses\"]")
    private WebElement continueBtn;

    @FindBy(css = ".delivery-option .custom-radio")
    private List<WebElement> deliveryOptions;

    @FindBy(xpath = "//button[@name=\"confirmDeliveryOption\"]")
    private WebElement deliveryOptionsBtn;

    @FindBy(css = "#payment-option-1")
    private WebElement paymentOptionByCheck;

    @FindBy(xpath = "//input[@id=\"conditions_to_approve[terms-and-conditions]\"]")
    private WebElement termsAndConditionsCheckbox;

    @FindBy(css = "#payment-confirmation .btn")
    private WebElement placeOrderBtn;

    public void changeBillingAddress() {
        clickElement(diffAddressLink);
    }

    public void fillDifferentAddress() {
        waitForElement(addressField);
        addressField.sendKeys(System.getProperty("account_address"));
        postcodeField.sendKeys(System.getProperty("account_postcode"));
        actions.scrollToElement(cityField);
        waitForElement(cityField);
        cityField.sendKeys(System.getProperty("account_city"));
        continueBtn.click();
    }

    public String billingAddress() {
        return "test";
    }


    public void chooseRandomShippingMethod() {
        deliveryOptions.get(random.nextInt(deliveryOptions.size())).click();
        deliveryOptionsBtn.click();
    }

    public void payByCheck() {
        clickElement(paymentOptionByCheck);
    }

    public void acceptTermsAndConditions() {
        clickElement(termsAndConditionsCheckbox);
    }

    public void placeOrder() {
        clickElement(placeOrderBtn);
    }

    public String getAddress() {
        return "test adddress";
    }
}
