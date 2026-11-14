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

    private By firstName = By.xpath("//input[@ng-model='fName']");
    private By lastName = By.xpath("//input[@ng-model='lName']");
    private By postCode = By.xpath("//input[@ng-model='postCd']");
    private By addCustomerButton = By.xpath("//button[text()=\"Add Customer\"]");

    public void setFirstName(String firstNameValue) {
        driver.findElement(firstName).sendKeys(firstNameValue);
    }

    public void setLastName(String lastNameValue) {
        driver.findElement(lastName).sendKeys(lastNameValue);
    }

    public void setPostCode(String postCodeValue) {
        driver.findElement(postCode).sendKeys(postCodeValue);
    }

    public void clickOnAddCustomerButton() {
        driver.findElement(addCustomerButton).click();
    }

    public String getAlertMessageAndAccept() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = webDriverWait.until(ExpectedConditions.alertIsPresent());

        String alertText = alert.getText();
        alert.accept();

        return alertText;
    }
}
