package testBase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    public Logger logger;

    @BeforeMethod
    @Parameters({"browser"})
    public void setUp(String browser) {
        logger = LogManager.getLogger(this.getClass());

        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                return;
        }

        driver.manage().window().maximize();
        driver.get("https://www.way2automation.com/angularjs-protractor/banking/#/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
