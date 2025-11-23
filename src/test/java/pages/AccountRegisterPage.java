package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountRegisterPage {
    WebDriver driver;

    public AccountRegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "input-firstname") WebElement firstNameField;
    @FindBy(id = "input-lastname") WebElement lastNameField;
    @FindBy(id = "input-email") WebElement emailField;
    @FindBy(id = "input-telephone") WebElement telephoneField;
    @FindBy(id = "input-password") WebElement passwordField;
    @FindBy(id = "input-confirm") WebElement confirmPasswordField;
    @FindBy(xpath = "//input[@name='agree']") WebElement agreeCheckbox;
    @FindBy(xpath = "//input[@type='submit']") WebElement continueButton;
    @FindBy(xpath = "//h1[text()='Your Account Has Been Created!']") WebElement confirmationMessage;
    @FindBy(css = ".text-danger") WebElement errorMsg;

    public void fillRegistrationForm(String fname, String lname, String email, String phone, String password) {
        firstNameField.sendKeys(fname);
        lastNameField.sendKeys(lname);
        emailField.sendKeys(email);
        telephoneField.sendKeys(phone);
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(password);
        agreeCheckbox.click();
        continueButton.click();
    }

    public String getConfirmationMessage() {
        return confirmationMessage.getText();
    }
    
    public String getErrorMsg()
    {
    	return errorMsg.getText();
    }
}