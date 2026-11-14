package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LoginPage extends BasePage {

    private By firstName = By.id("firstName");
    private By lastName = By.id("lastName");
    private By email = By.id("email");
    private By password = By.id("password");
    private By checkboxReadingHobby = By.xpath("//input[@value=\"Reading\"]");
    private By genderDropDown = By.id("gender");
    private By textBoxAboutYourself = By.id("about");
    private By registerButton = By.xpath("//*[@type=\"submit\"]");
    private By successMsg = By.id("successMessage");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void setFirstName(String firstNameValue) {

        driver.findElement(firstName).sendKeys(firstNameValue);
    }

    public void setLastName(String lastNameValue) {

        driver.findElement(lastName).sendKeys(lastNameValue);
    }

    public void setEmail(String emailValue) {

        driver.findElement(email).sendKeys(emailValue);
    }

    public void setPassword(String passwordValue) {

        driver.findElement(password).sendKeys(passwordValue);
    }

    public void setCheckboxReadingHobby() {

        driver.findElement(checkboxReadingHobby).click();
    }

    public void selectValueFromGenderDropdown(String genderValue) {
        WebElement dropDown = driver.findElement(genderDropDown);
        Select select = new Select(dropDown);
        select.selectByVisibleText(genderValue);
    }

    public void setTextBoxAboutYourself(String value) {
        driver.findElement(textBoxAboutYourself).sendKeys(value);
    }

    public void clickOnRegisterButton() {
        driver.findElement(registerButton).click();
    }

    public String getSuccessMessage() {
        String successMessage = driver.findElement(successMsg).getText();
        return successMessage;
    }
}
