package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CustomerHomePage extends BasePage {
    public CustomerHomePage(WebDriver driver) {
        super(driver);
    }

    private By userSelectDropdown = By.id("userSelect");

    public List<WebElement> userValues() {
        return driver.findElements(userSelectDropdown);
    }
}
