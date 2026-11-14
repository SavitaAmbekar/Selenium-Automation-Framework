package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseTest;

public class TC_AccountRegisterTest extends BaseTest {

    @Test
    public void register() {
        try {
            logger.info("******* TC_AccountRegisterTest Execution Started ******");
            HomePage homePage = new HomePage(driver);
            homePage.clickSampleFormButton();

            LoginPage loginPage = new LoginPage(driver);
            loginPage.setFirstName(randomString());
            logger.info("******* Successfully First name is set ******");

            loginPage.setLastName(randomString());
            logger.info("******* Successfully Last name is set ******");

            loginPage.setEmail(randomString() + "@gmail.com");
            logger.info("******* Successfully email is set ******");

            loginPage.setPassword(randomPassword());
            logger.info("******* Successfully Password is set ******");

            loginPage.setCheckboxReadingHobby();
            logger.info("******* Successfully Reading hobby is selected ******");

            loginPage.selectValueFromGenderDropdown("Male");
            logger.info("******* Successfully gender is selected from drop down ******");

            loginPage.setTextBoxAboutYourself("human");
            logger.info("******* Successfully added text to about yourself textbox ******");

            loginPage.clickOnRegisterButton();
            logger.info("******* Successfully clicked on register button ******");

            if (loginPage.getSuccessMessage().equals("User registered successfully!")) {
                Assert.assertTrue(true);
                logger.info("******* Successfully verified user registration message ******");
            } else {
                logger.error("Test Failed .....");
                logger.debug("debug logs....");
                Assert.assertTrue(false);
            }

            //Assert.assertEquals(loginPage.getSuccessMessage(),"User registered successfully!");
        } catch (Exception e) {

            Assert.fail();
        }

        logger.info("************* TC_AccountRegisterTest Execution Completed ******");

    }

    public String randomString() {
        return RandomStringUtils.randomAlphabetic(4);
    }

    public String randomPassword() {
        String alphaNumber = RandomStringUtils.randomAlphabetic(6);
        String number = RandomStringUtils.randomNumeric(3);
        return (alphaNumber + "@" + number);
    }


}
