package base;

import java.net.MalformedURLException;
import java.net.URI;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import utilities.ConfigReader;

public class DriverFactory {
	public static WebDriver initializeDriver(String browser, String os) {
		WebDriver driver = null;
		String huburl = ConfigReader.getProperty("hubURL");

		if (ConfigReader.getProperty("execution_env").equalsIgnoreCase("remote")) {

			DesiredCapabilities cap = new DesiredCapabilities();

			if (os.equalsIgnoreCase("windows")) {
				cap.setPlatform(Platform.WIN11);
			} else if (os.equalsIgnoreCase("linux")) {
				cap.setPlatform(Platform.LINUX);
			} else if (os.equalsIgnoreCase("mac")) {
				cap.setPlatform(Platform.MAC);
			} else {
				System.out.println("no matching os");
				throw new IllegalArgumentException("Unsupported OS: " + os);

			}

			switch (browser.toLowerCase()) {
			case "chrome":
				cap.setBrowserName("chrome");
				break;

			case "edge":
				cap.setBrowserName("MicrosoftEdge");
				break;
			case "firefox":
				cap.setBrowserName("firefox");
				break;
			default:
				System.out.println("no matching broswer");
				throw new IllegalArgumentException("Unsupported browser: " + browser);

			}

			URI uri = URI.create(huburl);
			try {
				driver = new RemoteWebDriver(uri.toURL(), cap);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		if (ConfigReader.getProperty("execution_env").equalsIgnoreCase("local")) {
			switch (browser.toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();
				break;

			case "edge":
				driver = new EdgeDriver();
				break;

			default:
				System.out.println("Invalid browser");
				throw new IllegalArgumentException("Unsupported browser: " + browser);

			}
			System.out.println("your OS is: " + os);
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;

	}
}
