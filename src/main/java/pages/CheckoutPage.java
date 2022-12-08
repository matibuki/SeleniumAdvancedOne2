package pages;

import models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CheckoutPage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(CheckoutPage.class);

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Billing address differs from shipping address")
    private WebElement diffAddressLink;
    @FindBy(css = "#invoice-addresses")
    private WebElement invoiceAddress;
    @FindBy(css = ".add-address a[href*=\"invoice\"]")
    private WebElement addNewInvoiceAddressBtn;
    @FindBy(css = "#invoice-addresses .address-item:last-of-type .delete-address")
    private WebElement deleteAddressBtn;
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

    @FindBy(css = "#checkout-payment-step.js-current-step")
    private WebElement paymentOptionsSection;

    @FindBy(xpath = "//input[@id=\"conditions_to_approve[terms-and-conditions]\"]")
    private WebElement termsAndConditionsCheckbox;

    @FindBy(css = "#payment-confirmation .btn")
    private WebElement placeOrderBtn;

    public void setNewBillingAddress() {
        click(diffAddressLink);
    }

    public void fillAddress(User user) {
        waitForElement(addressField);
        addressField.sendKeys(user.getStreetName());
        postcodeField.sendKeys(user.getZipCode());
        actions.scrollToElement(cityField);
        waitForElement(cityField);
        cityField.sendKeys(user.getCity());
        continueBtn.click();
        logger.info("Address filled");
    }

    public void chooseRandomShippingMethod() {
        deliveryOptions.get(random.nextInt(deliveryOptions.size())).click();
        deliveryOptionsBtn.click();
    }

    public void payByCheck() {
        waitForElementToBeVisible(paymentOptionsSection);
        paymentOptionByCheck.click();
    }

    public void acceptTermsAndConditions() {
        waitForElementToBeVisible(paymentOptionsSection);
        termsAndConditionsCheckbox.click();
    }

    public void placeOrder() {
        click(placeOrderBtn);
    }

    public void addNewBillingAddress() {
        diffAddressLink.click();
        if (isElementDisplayed(addNewInvoiceAddressBtn)) {
            addNewInvoiceAddressBtn.click();
        }
    }
}
