package com.cueback.setup;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.cueback.pom.AboutUsPage;
import com.cueback.pom.ActivityPage;
import com.cueback.pom.AdminUserDashboard;
import com.cueback.pom.AllMemberPage;
import com.cueback.pom.AlumniProfilePage;
import com.cueback.pom.ContactUsPage;
import com.cueback.pom.EditDetailsPage;
import com.cueback.pom.EditProfilePage;
import com.cueback.pom.EventAccessAndSentInvitePage;
import com.cueback.pom.EventPage;
import com.cueback.pom.EventTypePage;
import com.cueback.pom.FAQsPage;
import com.cueback.pom.FeedPage;
import com.cueback.pom.ForgotPasswordPage;
import com.cueback.pom.FriendCirclePage;
import com.cueback.pom.FriendPage;
import com.cueback.pom.HelpUsFindAdmin;
import com.cueback.pom.HelpUsFindPage;
import com.cueback.pom.HomePage;
import com.cueback.pom.InviteFriendsPage;
import com.cueback.pom.InvitePage;
import com.cueback.pom.LoginPage;
import com.cueback.pom.MemoryDraftPage;
import com.cueback.pom.MyFriendPage;
import com.cueback.pom.MyOderPage;
import com.cueback.pom.MyProfilePage;
import com.cueback.pom.PaymenPage;
import com.cueback.pom.PrivacyPolicyPage;
import com.cueback.pom.WelcomePage;
import com.cueback.pom.YopmailPage;
import com.cueback.pom.RegisterPage;
import com.cueback.pom.SentRequestsPage;
import com.cueback.pom.SuggestedFriendsPage;
import com.cueback.pom.SupportPage;
import com.cueback.pom.ThankYouPage;
import com.cueback.pom.UserMessagePage;
import com.cueback.pom.UserMessegePage;
import com.cueback.util.CommonUtils;
import com.cueback.util.Prop;

public class Setup {
	
	public static WebDriver driver;
	public static int i = 1;
	private static Logger log = Logger.getLogger(Setup.class.getName());
	public static String screenshotPath = System.getProperty("user.dir") + File.separator + "screenshots";
	private static String allureReportPath = System.getProperty("user.dir") + File.separator + "allure-results";
	//private static String logPath = System.getProperty("user.dir") + File.separator + "log";
	public static Properties testData = null;
	public static Properties config = null;
	private static String configPropertiesFilePath = Paths
			.get(System.getProperty("user.dir"), "src", "main", "resources", "properties", "config.properties")
			.toString();
	public static String testDataPropertiesFilePath = Paths
			.get(System.getProperty("user.dir"), "src", "main", "resources", "properties", "testData.properties")
			.toString();

	@BeforeSuite(alwaysRun = true)
	public void testBedSetup() throws Exception {

		// Create or clean screenshot directory
		CommonUtils.cleanOrCreateDirectory(screenshotPath);

		// Create or clean allure report directory
		CommonUtils.cleanOrCreateDirectory(allureReportPath);

		// Create or clean log directory
		// CommonUtils.cleanOrCreateDirectory(logPath);

		// load properties files
		config = Prop.loadPropertiesFile(configPropertiesFilePath);
		testData = Prop.loadPropertiesFile(testDataPropertiesFilePath);
	}

	@AfterSuite(alwaysRun = true)
	public void testBedTearDown() throws Exception {
		try {
			driver.quit();
			log.info("Closed browser");
		} catch (Exception e) {
			log.info("Browser is already closed by test method");
		}
	}

	@BeforeMethod(alwaysRun = true)
	public static void testSetup() throws IOException {
		log.info("\n");
		log.info("**********************************************");
		log.info("Executing Test Case Number: " + i++);
		driver = Driver.getDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(CommonUtils.getURL());

		// Initialize PageFactory classes

		PageFactory.initElements(driver, WelcomePage.class);
		PageFactory.initElements(driver, LoginPage.class);
		PageFactory.initElements(driver, HomePage.class);
		PageFactory.initElements(driver, RegisterPage.class);
		PageFactory.initElements(driver, ForgotPasswordPage.class);
		PageFactory.initElements(driver, YopmailPage.class);
		PageFactory.initElements(driver, MyProfilePage.class);
		PageFactory.initElements(driver, EditProfilePage.class);
		PageFactory.initElements(driver, AlumniProfilePage.class);
		PageFactory.initElements(driver, UserMessegePage.class);
		PageFactory.initElements(driver, ActivityPage.class);
		PageFactory.initElements(driver, FeedPage.class);
		PageFactory.initElements(driver, ContactUsPage.class);
		PageFactory.initElements(driver, FAQsPage.class);
		PageFactory.initElements(driver, AboutUsPage.class);
		PageFactory.initElements(driver, PrivacyPolicyPage.class);
		PageFactory.initElements(driver, SupportPage.class);
		PageFactory.initElements(driver, EventPage.class);
		PageFactory.initElements(driver, FriendPage.class);
		PageFactory.initElements(driver, MemoryDraftPage.class);
		PageFactory.initElements(driver, EventTypePage.class);
		PageFactory.initElements(driver, PaymenPage.class);
		PageFactory.initElements(driver, ThankYouPage.class);
		PageFactory.initElements(driver, MyOderPage.class);
		PageFactory.initElements(driver, HelpUsFindPage.class);
		PageFactory.initElements(driver, MyFriendPage.class);
		PageFactory.initElements(driver, FriendCirclePage.class);
		PageFactory.initElements(driver, SentRequestsPage.class);
		PageFactory.initElements(driver, SuggestedFriendsPage.class); 
		PageFactory.initElements(driver, AllMemberPage.class);
		PageFactory.initElements(driver, InviteFriendsPage.class);
		PageFactory.initElements(driver, EventAccessAndSentInvitePage.class);
		PageFactory.initElements(driver, EditDetailsPage.class);
		PageFactory.initElements(driver, InvitePage.class);
		PageFactory.initElements(driver, AdminUserDashboard.class);
		PageFactory.initElements(driver, HelpUsFindAdmin.class);
		PageFactory.initElements(driver, UserMessagePage.class);
	}

	@AfterMethod(alwaysRun = true)
	public static void testTearDown() {
		driver.quit();
		log.info("Closed browser");
	}

}