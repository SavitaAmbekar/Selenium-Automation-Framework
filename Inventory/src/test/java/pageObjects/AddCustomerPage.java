package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddCustomerPage extends BasePage {

    public AddCustomerPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageLoaded() {
        return driver.findElement(addCustomerButton).isDisplayed();
    }

    private By firstName = By.xpath("//input[@ng-model='fName']");
    private By lastName = By.xpath("//input[@ng-model='lName']");
    private By postCode = By.xpath("//input[@ng-model='postCd']");
    private By addCustomerButton = By.xpath("//button[text()=\"Add Customer\"]");

    public void setFirstName(String firstNameValue) {
        enterText(firstName,firstNameValue);
    }

    public void setLastName(String lastNameValue) {
        enterText(lastName,lastNameValue);
    }

    public void setPostCode(String postCodeValue) {
        enterText(postCode,postCodeValue);
    }

    public void clickOnAddCustomerButton() {
        clickElement(addCustomerButton);
    }

    public String getAlertMessageAndAccept() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = webDriverWait.until(ExpectedConditions.alertIsPresent());

        String alertText = alert.getText();
        alert.accept();

        return alertText;
    }
}
