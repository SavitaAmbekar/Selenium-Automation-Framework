package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageLoaded() {
        return driver.findElement(customerLoginButton).isDisplayed();
    }

    private By sampleFormButton = By.xpath("//a[@href=\"https://www.way2automation.com/angularjs-protractor/banking/registrationform.html\"]");
    private By bankManagerLoginButton = By.xpath("//button[@ng-click='manager()']");
    private By addCustomerButton = By.xpath("//button[@ng-click='addCust()']");
    private By homeButton = By.xpath("//button[@ng-click='home()']");
    private By customerLoginButton = By.xpath("//button[@ng-click='customer()']");

    public void clickSampleFormButton() {
        clickElement(sampleFormButton);
    }

    public void clickBankManagerLoginButton() {
        clickElement(bankManagerLoginButton);
    }

    public void clickAddCustomerButton() {
        clickElement(addCustomerButton);
    }

    public void clickOnHomeButton() {
        clickElement(homeButton);
    }

    public void clickOnCustomerLoginButton() {
        clickElement(customerLoginButton);
    }

}
