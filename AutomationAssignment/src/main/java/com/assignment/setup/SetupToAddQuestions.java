package com.assignment.setup;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.assignment.pom.CreateSurveyPage;
import com.assignment.pom.LoginPage;
import com.assignment.pom.SurveyOperationPage;
import com.assignment.util.CommonUtils;
import com.assignment.util.Prop;

public class SetupToAddQuestions {

	private static Logger log = Logger.getLogger(SetupToAddQuestions.class.getName());
	
	@BeforeTest(alwaysRun = true)
	public static void testSetupForAddingQuestions() throws IOException {
		log.info("\n");
		log.info("**********************************************");
		Setup.driver = Driver.getDriver();
		Setup.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Setup.driver.manage().window().maximize();
		Setup.driver.get(CommonUtils.getURL());
		
		// Initialize PageFactory classes

		PageFactory.initElements(Setup.driver, LoginPage.class);
		PageFactory.initElements(Setup.driver, CreateSurveyPage.class);
		PageFactory.initElements(Setup.driver, SurveyOperationPage.class);
		
		
		LoginPage.login(Prop.getTestData("username"), Prop.getTestData("password"));
		CreateSurveyPage.clickCreateSurvey();
		CreateSurveyPage.enterSurveyTitle();
//		CreateSurveyPage.enterCategory();
		CreateSurveyPage.clickCreateSurveyButton();
		CreateSurveyPage.verifySurveyCreated();
	
	}

	@AfterTest(alwaysRun = true)
	public static void testTearDown() {
	//	driver.quit();
		log.info("Closed browser");
	}

}