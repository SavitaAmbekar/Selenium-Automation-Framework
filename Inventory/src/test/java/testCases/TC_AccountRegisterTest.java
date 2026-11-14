package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseTest;

public class TC_AccountRegisterTest extends BaseTest {

    @Test
    public void register(){
        HomePage homePage = new HomePage(driver);
        homePage.clickSampleFormButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setFirstName(randomString());
        loginPage.setLastName(randomString());
        loginPage.setEmail(randomString() +"@gmail.com");
        loginPage.setPassword(randomPassword());
        loginPage.setCheckboxReadingHobby();
        loginPage.selectValueFromGenderDropdown("Male");
        loginPage.setTextBoxAboutYourself("human");
        loginPage.clickOnRegisterButton();

        Assert.assertEquals(loginPage.getSuccessMessage(),"User registered successfully!");
    }

    public String randomString()
    {
        return RandomStringUtils.randomAlphabetic(4);
    }

    public String randomPassword()
    {
        String alphaNumber = RandomStringUtils.randomAlphabetic(6);
        String number = RandomStringUtils.randomNumeric(3);
        return (alphaNumber + "@" + number);
    }


}
