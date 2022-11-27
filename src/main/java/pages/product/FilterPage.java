package pages.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

import java.math.BigDecimal;

public class FilterPage extends BasePage {
    private static Logger logger = LoggerFactory.getLogger(FilterPage.class);

    public FilterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".faceted-slider")
    private WebElement priceSlider;

    @FindBy(css = "li p")
    private WebElement sliderPrices;

    @FindBy(css = ".ui-slider-handle:nth-of-type(1)")
    private WebElement priceSliderHandlerLeft;

    @FindBy(css = ".ui-slider-handle:nth-of-type(2)")
    private WebElement priceSliderHandlerRight;

    @FindBy(css = ".spinner")
    private WebElement spinner;

    public void setMinimumPrice(double price) {
        waitForElement(priceSliderHandlerLeft);
        moveSlider(price, getCurrentMinPrice(), priceSliderHandlerLeft);
    }

    public void setMaximumPrice(double price) {
        waitForElement(priceSliderHandlerRight);
        moveSlider(price, getCurrentMaxPrice(), priceSliderHandlerRight);
    }

    private void moveSlider(double price, double currentPrice, WebElement sliderHandle) {
        double minPrice = Double.parseDouble(priceSlider.getAttribute("data-slider-min"));
        double maxPrice = Double.parseDouble(priceSlider.getAttribute("data-slider-max"));
        int sliderWidth = priceSlider.getSize().width;

        int direction = getDirection(price, currentPrice);

        actions.clickAndHold(sliderHandle).perform();
        while (getCurrentMaxPrice() != price && getCurrentMinPrice() != price) {
            actions.moveByOffset((int) (direction * (sliderWidth / (maxPrice - minPrice))), 0).perform();
        }
        actions.release().perform();
        wait.until(ExpectedConditions.invisibilityOf(spinner));
    }

    private String[] getCurrentPriceFromSlider() {
        return sliderPrices.getText().replace(System.getProperty("currency"), "").split(("-"));
    }

    private Double getCurrentMinPrice() {
        return Double.parseDouble(getCurrentPriceFromSlider()[0]);
    }
    private Double getCurrentMaxPrice() {
        return Double.parseDouble(getCurrentPriceFromSlider()[1]);
    }

    private int getDirection(double price, double currentPrice) {
        double difference = price - currentPrice;
        if (difference > 0) {
            return 1;
        }
        if (difference < 0) {
            return -1;
        }
        return 0;
    }

}
