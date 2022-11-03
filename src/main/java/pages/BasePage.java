package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;
    public Actions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }

    public void clickElement (WebElement element) {
        element.click();
    }
    Random random = new Random();

    public WebElement getRandomElementFromList(List<WebElement> list) {
            return list.get(random.nextInt(list.size()));
    }

    public void clearInput (WebElement element) {
        element.clear();
    }

    public void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElements(List<WebElement> elements) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public Double getPrice(WebElement element) {
        return Double.parseDouble(element.getText().replace(System.getProperty("currency"), ""));
    }
}
