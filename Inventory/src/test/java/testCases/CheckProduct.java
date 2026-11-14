package testCases;

import org.testng.annotations.Test;
import pageObjects.CustomerHomePage;
import pageObjects.HomePage;
import testBase.BaseTest;

public class CheckProduct extends BaseTest {

    @Test
    public void testCheck()
    {
        CustomerHomePage customerHomePage = new CustomerHomePage(driver);
        customerHomePage.check();
    }
}
