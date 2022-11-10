package configuration.factory;

import configuration.models.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BrowserFactory {
    static Logger logger = LoggerFactory.getLogger(BrowserFactory.class);
    private String browserName;
    private WebDriver driver;

    public WebDriver getDriver() {
        this.browserName = System.getProperty("browserName");
        switch (browserName) {
            case "chrome":
                ChromeOptions optionsChrome = new ChromeOptions();
                WebDriverManager.chromedriver().setup();
                optionsChrome.addArguments("window-position=2500,0");
                optionsChrome.addArguments("start-maximized");
                driver = new ChromeDriver(optionsChrome);
                logger.info("CHROME driver loaded");
                break;
            case "firefox":
                FirefoxOptions optionsFirefox = new FirefoxOptions();
                WebDriverManager.firefoxdriver().setup();
//                optionsFirefox.addArguments("start-maximized");
                driver = new FirefoxDriver();
                logger.info("FIREFOX driver loaded");
                break;
            default:
                InternetExplorerOptions optionsDefault = new InternetExplorerOptions();
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver(optionsDefault);
                logger.info("IE driver loaded");
        }
        return this.driver;
    }
}

