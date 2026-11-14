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

    @Override
    public boolean isPageLoaded() {
        return driver.findElement(firstName).isDisplayed();
    }

    public void setFirstName(String firstNameValue) {
        enterText(firstName,firstNameValue);
    }

    public void setLastName(String lastNameValue) {
        enterText(lastName,lastNameValue);
    }

    public void setEmail(String emailValue) {
        enterText(email,emailValue);
    }

    public void setPassword(String passwordValue) {
        enterText(password,passwordValue);
    }

    public void setCheckboxReadingHobby() {
        clickElement(checkboxReadingHobby);
    }

    public void selectValueFromGenderDropdown(String genderValue) {
        WebElement dropDown = driver.findElement(genderDropDown);
        Select select = new Select(dropDown);
        select.selectByVisibleText(genderValue);
    }

    public void setTextBoxAboutYourself(String value) {
        enterText(textBoxAboutYourself,value);
    }

    public void clickOnRegisterButton() {
        clickElement(registerButton);
    }

    public String getSuccessMessage() {
        try {
            String successMessage = driver.findElement(successMsg).getText();
            return successMessage;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
