package com.cueback.setup;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import com.cueback.util.CommonUtils;

public class Driver {

	public static WebDriver driver;
	public static String url;
	private static Logger log = Logger.getLogger(Driver.class.getName());

	public static WebDriver getDriver() throws IOException {
		switch (System.getProperty("Browser")) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", CommonUtils.getChromeDriverPath());
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
		case "headless":
			if (System.getProperty("os.name").startsWith("Windows")) {
				System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\driver\\chromedriver.exe");
			} else {
				System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriverlinux");
			}
			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--headless");
//			options.addArguments("window-size=1280x800");
//			options.addArguments("no-sandbox");
//			options.addArguments("–disable-dev-shm-usage");
//			options.addArguments("start-maximized");
//			options.addArguments("--disable-gpu");
//			options.addArguments("--disable-setuid-sandbox");
//			options.addArguments("--ignore-certificate-errors");
			 options.addArguments("headless");
			 options.addArguments("window-size=1200x600");
			 options.addArguments("--no-sandbox");
			 options.addArguments("--disable-setuid-sandbox");
			driver = new ChromeDriver(options);
			log.info("Initialized Chrome driver for Headless mode.");
			break;
		case "safari":
			// DesiredCapabilities scap = new DesiredCapabilities();
			// scap.setCapability("acceptInsecureCerts", true);
			// SafariOptions options1 = new
			// SafariOptions().setUseTechnologyPreview(true);
			// driver = new SafariDriver(options1);

			driver = new SafariDriver();
			log.info("Initialized safari driver.");
			break;
		default:
			log.info("Enter browser name - chrome or FireFox or IE ");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
}
