package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import utilities.ConfigReader;
//import utilities.DataProviders;

public class TC002_LoginTest extends BaseTest {

	String emailId = ConfigReader.getProperty("emailLogin");
	String loginPswd = ConfigReader.getProperty("password");

	@Test(groups={"Sanity","Master"})
	public void verify_Login_ValidCreds() throws Exception {
		logger.info("**** starting TC002_LoginTest ****");

		HomePage hp = new HomePage(driver);

		hp.clickMyAccount();
		hp.clickLogin();

		LoginPage lp = new LoginPage(driver);
		// lp.enterLoginDetails(emailId, loginPswd);
		lp.enterLoginDetails(emailId, loginPswd);
		lp.clickLoginBtn();

		MyAccountPage account = new MyAccountPage(driver);
		Thread.sleep(1000);
		Boolean expectedAccountpage = account.isMyAccountDisplayed();
		Assert.assertEquals(expectedAccountpage, true, "Login Failed");
		account.clickLogoutLink();
		logger.info("**** finished TC002_LoginTest ****");
	}

}
