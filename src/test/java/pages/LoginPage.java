package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
	
WebDriver driver;
String loginPageUrl= "https://tutorialsninja.com/demo/index.php?route=account/login";
String accountLogged = "https://tutorialsninja.com/demo/index.php?route=account/account";
public LoginPage(WebDriver driver)
{
	this.driver = driver;
	PageFactory.initElements(driver, this);
}

@FindBy(css = "#input-email") WebElement emailAddress;
@FindBy(css="#input-password") WebElement pswdInput;
@FindBy (xpath ="//input[@type='submit']") WebElement loginBtn;
@FindBy (linkText = "Forgotten Password") WebElement forgotPswd;
@FindBy (css =".alert.alert-danger.alert-dismissible") WebElement errorMsg;


public void enterLoginDetails(String email, String pswd)
{
	emailAddress.sendKeys(email);
	pswdInput.sendKeys(pswd);
}
public void clickLoginBtn ()
{
	loginBtn.click();
}

public void clickforgotpswd()
{
	forgotPswd.click();
}

public String getErrorMsg()
{
	return errorMsg.getText();
}



}
