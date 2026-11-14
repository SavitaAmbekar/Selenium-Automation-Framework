package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CustomerHomePage extends BasePage {
    public CustomerHomePage(WebDriver driver) {
        super(driver);
    }

    private By userSelectDropdown = By.id("userSelect");
    private By loginButton = By.xpath("//button[@ng-show=\"custId != ''\"]");
    private By logoutButton = By.xpath("//button[@ng-click='byebye()']");
    public List<WebElement> userValues() {
        return driver.findElements(userSelectDropdown);
    }

    public boolean checkLoginButtonVisible() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void selectUserFromDropDown(String user) {
        Select select = new Select(driver.findElement(userSelectDropdown));
        select.selectByVisibleText(user);
    }

    public void clickOnLogoutButton()
    {
        driver.findElement(logoutButton).click();
    }
}
