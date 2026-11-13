package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    private By customerLogin = By.cssSelector("//button[@ng-click=\"customer()\"]");
    private By yourNameDropdown = By.id("userSelect");
    private By loginButton = By.cssSelector("//button[@ng-show=\"custId != ''\"]");
    private By logoutButton = By.cssSelector("//button[@ng-click=\"byebye()\"]");
    private By userText = By.cssSelector("span.fontBig.ng-binding");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

}
