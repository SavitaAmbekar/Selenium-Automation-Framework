package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By sampleFormButton = By.xpath("//a[@href=\"https://www.way2automation.com/angularjs-protractor/banking/registrationform.html\"]");
    private By bankManagerLoginButton = By.xpath("//button[@ng-click='manager()']");
    private By addCustomerButton = By.xpath("//button[@ng-click='addCust()']");
    private By homeButton = By.xpath("//button[@ng-click='home()']");
    private By customerLoginButton = By.xpath("//button[@ng-click='customer()']");

    public void clickSampleFormButton() {
        driver.findElement(sampleFormButton).click();
    }

    public void clickBankManagerLoginButton() {
        driver.findElement(bankManagerLoginButton).click();
    }

    public void clickAddCustomerButton() {
        driver.findElement(addCustomerButton).click();
    }

    public void clickOnHomeButton() {
        driver.findElement(homeButton).click();
    }

    public void clickOnCustomerLoginButton() {
        driver.findElement(customerLoginButton).click();
    }

}
