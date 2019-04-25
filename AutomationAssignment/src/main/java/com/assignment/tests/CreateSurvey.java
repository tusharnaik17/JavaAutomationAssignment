package com.assignment.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.assignment.pom.CreateSurveyPage;
import com.assignment.pom.LoginPage;
import com.assignment.setup.Setup;
import com.assignment.util.Prop;
import com.assignment.util.SeleniumUtils;

import io.qameta.allure.Description;

public class CreateSurvey extends Setup {

	@Test(groups = { "tk", "CreateSurvey" })
	@Description("Create survey from scratch.")
	public static void createSurvey() throws IOException, InterruptedException {
		try {
			LoginPage.login(Prop.getTestData("username"), Prop.getTestData("password"));
			CreateSurveyPage.clickCreateSurvey();
			CreateSurveyPage.enterSurveyTitle();
			CreateSurveyPage.clickCreateSurveyButton();
			CreateSurveyPage.verifySurveyCreated();
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("createSurvey");
			e.getStackTrace();
			throw e;
		}
	}

}