package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CustomerHomePage;
import pageObjects.HomePage;
import testBase.BaseTest;
import utilities.DataProviders;

public class TC_Login_DDTTest extends BaseTest {

        @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
        public void Login(String firstNameVal, String lastNameVal, String response) {
        try {
            HomePage homePage = new HomePage(driver);
            homePage.clickOnCustomerLoginButton();
            logger.info("*** TC_Login test started ****");

            CustomerHomePage customerHomePage = new CustomerHomePage(driver);
            String user = firstNameVal + lastNameVal;
            customerHomePage.selectUserFromDropDown(user);

            if (response.equalsIgnoreCase("valid")){
                if (customerHomePage.checkLoginButtonVisible() == true)
                {
                    Assert.assertTrue(true);
                    customerHomePage.clickOnLogoutButton();

                }else{
                    Assert.assertTrue(false);
                }

            } else if (response.equalsIgnoreCase("Invalid")) {
                if (customerHomePage.checkLoginButtonVisible() == true)
                {
                    Assert.assertTrue(false);
                }else{
                    Assert.assertTrue(true);
                    customerHomePage.clickOnLogoutButton();
                }
            }

            logger.info("*** TC_Login test completed ****");
        } catch (Exception e) {
            Assert.fail();
        }
    }
}
