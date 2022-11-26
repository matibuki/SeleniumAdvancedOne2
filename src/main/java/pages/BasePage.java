package pages;

import configuration.WebListener;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.internal.EventFiringMouse;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.UrlProvider;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BasePage {
    private static final Logger logger = LoggerFactory.getLogger(BasePage.class);
    public WebDriver driver;
    public WebDriverWait wait;
    public Actions actions;

    private EventFiringMouse eventFiringMouse;

    private WebListener webListener = new WebListener();


    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(System.getProperty("wait"))));
        this.actions = new Actions(driver);
    }

    public void clickElement (WebElement element) {
        waitForElement(element);
        element.click();
    }
    public Random random = new Random();

    public WebElement getRandomElementFromList(List<WebElement> list) {
            return list.get(random.nextInt(list.size()));
    }

    public void clearInput (WebElement element) {
        element.clear();
    }

    public void waitForElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElements(List<WebElement> elements) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public Double getPrice(WebElement element) {
        return Double.parseDouble(element.getText().replace(System.getProperty("currency"), ""));
    }

    public String currentUrl() {
        return driver.getCurrentUrl();
    }

    protected void mouseHover(WebElement element) {
        waitForElementToBeVisible(element);
        eventFiringMouse = new EventFiringMouse(driver, webListener);
        Locatable item = (Locatable) element;
        Coordinates coordinates = item.getCoordinates();
        highlightElement(element);
        eventFiringMouse.mouseMove(coordinates);
        logger.info("Mouse hover on element" + element.getText());
    }

    protected void highlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 4px solid red;');", element);
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public int productsCountInString(WebElement element) {
        return Integer.parseInt(element.getText().replaceAll("[^0-9]", ""));
    }
    public void openHomepage() {
        driver.get(UrlProvider.baseUrl);
    }
    public void openAccountPage() {
        driver.get(UrlProvider.account);
    }
    public void openRegistrationPage() {
        driver.get(UrlProvider.registration);
    }
}
