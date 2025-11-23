package testCases;

import base.BaseTest;
import java.util.UUID;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Validator;
import pages.AccountRegisterPage;

public class TC001_RegistrationTest extends BaseTest {

	@Test(groups={"Regression","Master"})
	public void verifyUserRegistration() {

		String fname = ConfigReader.getProperty("firstname");;
		String lname = ConfigReader.getProperty("lastname");
		String email = generateRandomEmail();
		String phone = ConfigReader.getProperty("phone");
		String password = ConfigReader.getProperty("password");
		
		
		logger.info("**** starting TC001_RegistrationTest ****");
		
		
        HomePage homePage = new HomePage(driver);
		homePage.clickMyAccount();
		homePage.clickRegister();
		
		logger.info(" **** clicked on register link ****");
		
		AccountRegisterPage registerPage = new AccountRegisterPage(driver);
		logger.info("**** providing customer details ****");
		
		registerPage.fillRegistrationForm(fname, lname, email, phone, password);
		//System.out.println(registerPage.getErrorMsg());
		
		logger.info("validating the input datas");
		
		Assert.assertTrue(Validator.areFieldsFilled(fname, lname, email, phone, password), "All fields must be filled");
		Assert.assertTrue(Validator.isValidEmail(email), "Email format is invalid");
		Assert.assertTrue(Validator.isValidPhone(phone), "Phone number must be 10 digits");
		Assert.assertTrue(Validator.isValidPassword(password), "Password does not meet complexity rules");
		
		logger.info("validating the registration confirmation message");
		String expectedMsg = "Your Account Has Been Created!";
		String actualMsg = registerPage.getConfirmationMessage();

		if (!actualMsg.equals(expectedMsg)) {
		    logger.debug("Assertion failed: Confirmation message mismatch");
		    logger.debug("Expected: '{}'", expectedMsg);
		    logger.debug("Actual:   '{}'", actualMsg);
		}

		Assert.assertEquals(actualMsg, expectedMsg, "Confirmation message mismatch");

		logger.info("**** Finished TC001_RegistrationTest ****");
	}

	public String generateRandomEmail() {
		String uniqueId = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 10);
		return "user" + uniqueId + "@gmail.com";
	}

}