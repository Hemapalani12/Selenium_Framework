package base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Parameters;

import utilities.ConfigReader;

public class BaseTest {
    protected WebDriver driver;
    public Logger logger;

   @BeforeClass(groups= {"Sanity","Master","Regression","Datadriven"})
   @Parameters({"browser","OS"})
    public void setUp(String browser, String os) {
    	
    	
    	logger=LogManager.getLogger(this.getClass());
        //String browser = ConfigReader.getProperty("browser");
        String url = ConfigReader.getProperty("url");
        driver = DriverFactory.initializeDriver(browser,os);
        driver.get(url);
    }

    @AfterClass(groups= {"Sanity","Master","Regression","Datadriven"})
    public void tearDown() {
        if (driver != null) {
           driver.quit();
        }
      } 
    
    public WebDriver getDriver() {
        return driver;
    }

}
