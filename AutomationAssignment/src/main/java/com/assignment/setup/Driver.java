package com.assignment.setup;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Driver {

	public static WebDriver driver;
	public static String url;
	private static Logger log = Logger.getLogger(Driver.class.getName());

	@SuppressWarnings("deprecation")
	public static WebDriver getDriver() throws IOException {
		switch (System.getProperty("Browser")) {
		case "chrome":
//			System.setProperty("webdriver.chrome.driver", CommonUtils.getChromeDriverPath());
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
			driver = new ChromeDriver(dc);
			log.info("Initialized Chrome driver");
			break;
		case "FireFox":
			System.setProperty("webdriver.firefox.driver", ".\\src\\main\\resources\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
			log.info("Initialized Firefox driver");
			break;
		case "IE":
			System.setProperty("webdriver.ie.driver", ".\\src\\main\\resources\\driver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			log.info("Initialized Internet Explorer driver");
			break;
		default:
			log.info("Enter browser name - chrome or FireFox or IE ");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
}
