package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	 static Properties prop;

	    static {
	        try {
	            prop = new Properties();
	            FileInputStream fis = new FileInputStream("resources/config.properties");
	            prop.load(fis);
	        } catch (Exception e) {
	            e.printStackTrace();//file not found exception error
	        }
	    }

	    public static String getProperty(String key) {
	        return prop.getProperty(key);
	    }

}
