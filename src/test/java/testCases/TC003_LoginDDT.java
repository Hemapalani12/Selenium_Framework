package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import utilities.DataProviders;


public class TC003_LoginDDT extends BaseTest {
	
	@Test(dataProvider ="Logindata", dataProviderClass=DataProviders.class,groups= "Datadriven")
	public void verify_loginDDT(String email,String pwd,String exp)
	{
	
	logger.info("**** starting TC002_LoginTest ****");

	HomePage hp = new HomePage(driver);

	hp.clickMyAccount();
	hp.clickLogin();

	LoginPage lp = new LoginPage(driver);
	lp.enterLoginDetails(email, pwd);
	lp.clickLoginBtn();

	MyAccountPage account = new MyAccountPage(driver);
	Boolean expectedAccountpage = account.isMyAccountDisplayed();
	//Assert.assertEquals(expectedAccountpage, true, "Login Failed");
	
	if(exp.equalsIgnoreCase("valid"))
	{
		if(expectedAccountpage==true)
		{
			hp.clickMyAccount();
			account.clickLogoutLink();
			Assert.assertTrue(true);
			
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
	
	if(exp.equalsIgnoreCase("invalid"))
	{
		if(expectedAccountpage==true)
		{
			hp.clickMyAccount();
			account.clickLogoutLink();
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(true);
		}
	}
	logger.info("**** finished TC002_LoginTest ****");
	
	
	
	}
}

