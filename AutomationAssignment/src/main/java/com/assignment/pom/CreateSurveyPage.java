
package com.assignment.pom;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.assignment.util.CommonUtils;
import com.assignment.util.SeleniumUtils;

import io.qameta.allure.Step;

public class CreateSurveyPage {

	private static Logger log = Logger.getLogger(CreateSurveyPage.class.getName());
	
	@FindBy(linkText="CREATE SURVEY")
	public static WebElement createSurveyLink;
	
	@FindBy(id="surveyTitle")
	public static WebElement titleField;
	
	@FindBy(id="scratch")
	public static WebElement surveyFromScratch;
	
	@FindBy(xpath="//button[contains(text(),'CREATE SURVEY')]")
	static WebElement createSurveyButton;
	
	@FindBy(xpath="//div[@class='Select-control']//div[@class='Select-placeholder']")
	static WebElement enterCategory;
	
	@FindBy(xpath="//div[@class='global-navigation-header-centered']//a[contains(@href,'/create/?sm=')]")
	public static WebElement verifyCreateSurvey;

	public static void clickCreateSurvey() {
		SeleniumUtils.waitForElementToBeClickable(createSurveyLink);
		createSurveyLink.click();
		log.info("Create Survey Link clicked.");
		Assert.assertTrue(surveyFromScratch.isDisplayed());
		surveyFromScratch.click();
	}

	public static void enterSurveyTitle() {
		SeleniumUtils.waitForElementToBeVisible(titleField);
		titleField.sendKeys("SampleSurvey" + CommonUtils.getCurrentTimeForScreenShot());
		log.info("Title Entered.");
	}

	public static void enterCategory() {
		SeleniumUtils.waitForElementToBeVisible(enterCategory);
		enterCategory.sendKeys("Just For Fun");
		enterCategory.sendKeys(Keys.ENTER);
		log.info("Category Selected.");
	}
	
	public static void verifySurveyCreated() {
		Assert.assertTrue(verifyCreateSurvey.isDisplayed());
		log.info("Survey Created Successfully.");
	}

	public static void clickCreateSurveyButton() {
		SeleniumUtils.waitForElementToBeClickable(createSurveyButton);
		createSurveyButton.click();
	}
}

