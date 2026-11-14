package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerHomePage extends BasePage {
    public CustomerHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageLoaded() {
        return driver.findElement(loginButton).isDisplayed();
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
        clickElement(logoutButton);
    }

    public void check()
    {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        List<WebElement> list = driver.findElements(By.xpath("//*[@class='inventory_item_label']"));
        List<String> stringList = new ArrayList<>();

        for (WebElement w : list)
        {
            stringList.add(w.getText());
        }

        Collections.sort(stringList);
    }
}
