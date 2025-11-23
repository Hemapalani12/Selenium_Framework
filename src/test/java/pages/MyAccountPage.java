package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MyAccountPage{
	
	 WebDriver driver;

	public MyAccountPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy (xpath="//h2[text()='My Account']")WebElement loggedMsg;
	@FindBy (xpath = "//div[@class='list-group']//a[text()='Logout']") WebElement logoutLink;
	
	public boolean isMyAccountDisplayed()
	{
		try
		{
			return (loggedMsg.isDisplayed());
		}
		catch (Exception e)
		{
			return false;
		}
	}
	
	public void clickLogoutLink()
	{
		logoutLink.click();
	}
}
