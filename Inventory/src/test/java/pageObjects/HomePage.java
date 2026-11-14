package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By sampleFormButton = By.xpath("//a[@href=\"https://www.way2automation.com/angularjs-protractor/banking/registrationform.html\"]");

    public void clickSampleFormButton() {
        driver.findElement(sampleFormButton).click();
    }
}
