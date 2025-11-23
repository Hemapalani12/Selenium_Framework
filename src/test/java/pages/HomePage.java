package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@title='My Account']")
    WebElement myAccountLink;

    @FindBy(linkText = "Register")
    WebElement registerLink;
    
    @FindBy(linkText = "Login")
    WebElement loginLink;

    public void clickMyAccount() {
    	System.out.println("clickmyaccount method");
        myAccountLink.click();
    }

    public void clickRegister() {
        registerLink.click();
    }
    
    public void clickLogin()
    {
    	loginLink.click();
    }
}