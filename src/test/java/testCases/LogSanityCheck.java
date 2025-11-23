package testCases;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LogSanityCheck {

	private static final Logger logger = LogManager.getLogger(LogSanityCheck.class);

	@BeforeClass
	public void log()
	{
		new File("logs").mkdirs();
	}
	@Test
	public void testLogging() {
		logger.info("LogSanityCheck: This is an INFO log");
		logger.warn("LogSanityCheck: This is a WARN log");
		logger.error("LogSanityCheck: This is an ERROR log");
		logger.debug("This is a debug test log for file verification");
		System.out.println("Sanity check executed");
		System.out.println("Working directory: " + System.getProperty("user.dir"));
	}
}
