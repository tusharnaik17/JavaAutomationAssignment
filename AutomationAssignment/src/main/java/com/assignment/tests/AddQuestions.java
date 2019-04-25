package com.assignment.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.assignment.pom.SurveyOperationPage;
import com.assignment.setup.SetupToAddQuestions;
import com.assignment.util.SeleniumUtils;

import io.qameta.allure.Description;

public class AddQuestions extends SetupToAddQuestions {

	@Test(priority = 0, groups = { "AddQuestions", "editTitle" })
	@Description("Verify - title can be edit.")
	public static void verifyEditTitle() throws IOException, InterruptedException {
		try {
			SurveyOperationPage.editSurveyTitle();
			SurveyOperationPage.selectCategory();
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyEditTitle");
			e.getStackTrace();
			throw e;
		}
	}
	
	@Test(priority = 1, groups = { "AddQuestions", "editPageTitle" })
	@Description("Verify - Page title can be edit.")
	public static void verifyEditPageTitle() throws IOException, InterruptedException {
		try {
			SurveyOperationPage.editPageTitle();
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyEditPageTitle");
			e.getStackTrace();
			throw e;
		}
	}
	
	@Test(priority = 2, groups = { "AddQuestions", "verifyAddPageLogic" })
	@Description("Verify - Page title can be edit.")
	public static void verifyAddPageLogic() throws IOException, InterruptedException {
		try {
			SurveyOperationPage.addPageLogic();
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyAddPageLogic");
			e.getStackTrace();
			throw e;
		}
	}
	
	@Test(priority = 3, groups = { "AddQuestions", "addQuestion1" })
	@Description("Adding Question 1.")
	public static void addQuestion1() throws IOException, InterruptedException {
		try {
			SurveyOperationPage.addQuetionOne();
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("addQuestion1");
			e.getStackTrace();
			throw e;
		}
	}
}
