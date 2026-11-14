package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AddCustomerPage;
import pageObjects.CustomerHomePage;
import pageObjects.HomePage;
import testBase.BaseTest;

public class TC_LoginTest extends BaseTest {
    @Test
    public void Login() {
        try {
            HomePage homePage = new HomePage(driver);
            homePage.clickBankManagerLoginButton();
            logger.info("*** TC_Login test started ****");
            homePage.clickAddCustomerButton();

            String firstNameVal = properties.getProperty("firstName");
            String lastNameVal = properties.getProperty("lastName");
            AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
            addCustomerPage.setFirstName(firstNameVal);
            addCustomerPage.setLastName(properties.getProperty("lastName"));
            addCustomerPage.setPostCode(properties.getProperty("postCode"));
            addCustomerPage.clickOnAddCustomerButton();

            Assert.assertTrue(addCustomerPage.getAlertMessageAndAccept().contains("Customer added successfully with customer id"));
            logger.info("*** TC_Login test completed ****");
        } catch (Exception e) {
            Assert.fail();
        }

    }
}
