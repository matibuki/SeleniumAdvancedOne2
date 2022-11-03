package start;

import configuration.factory.BrowserFactory;
import configuration.factory.PropertyStore;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBase {
    private static Logger logger = LoggerFactory.getLogger(TestBase.class);
    public static WebDriver driver;
    private static BrowserFactory browserFactory;
    private static PropertyStore propertyStore;


    @BeforeAll
    static void setupDriver() {
        propertyStore = PropertyStore.getInstance();
        browserFactory = new BrowserFactory();
        logger.info("Webdriver started successfully");
    }

    @BeforeEach
    void beforeEach() {
        driver = browserFactory.getDriver();
        driver.get(System.getProperty("url"));
        logger.info("Test page opened");
    }

    @AfterEach
    void afterEach() {
        driver.quit();
        logger.info("Test completed");

    }

    @AfterAll
    public static void tearDown() {

        logger.info("WebDriver closed properly");
    }
}
