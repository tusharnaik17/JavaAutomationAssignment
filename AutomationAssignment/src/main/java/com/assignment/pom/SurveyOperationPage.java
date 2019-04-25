
package com.assignment.pom;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.assignment.setup.Setup;
import com.assignment.util.Prop;
import com.assignment.util.SeleniumUtils;

public class SurveyOperationPage {

	private static Logger log = Logger.getLogger(SurveyOperationPage.class.getName());

	@FindBy(id = "surveyTitle")
	public static WebElement surveyTitleTextBox;

	@FindBy(xpath = "//form[@id='surveyTitleForm']//a[contains(@class,'save')]")
	public static WebElement saveSurveyTitle;

	@FindBy(xpath = "//div[contains(@class,'has-survey-title')]")
	public static WebElement surveyTitle;

	@FindBy(xpath = "//span[contains(text(),'PAGE TITLE')]")
	public static WebElement pageTitle;
	
	@FindBy(id = "pageTitle")
	public static WebElement pageTitleTextBox;
	
	@FindBy(xpath = "//form[@id='pageTitleForm']//a[contains(@class,'save')]")
	public static WebElement savePageTitle;
	
	@FindBy(linkText = "Page Logic")
	public static WebElement pageLogicLink;
	
	@FindBy(linkText = "Page skip logic")
	public static WebElement pageLogicLink1;
	
	@FindBy(linkText = "Question randomization")
	public static WebElement pageLogicLink2;
	
	@FindBy(linkText = "Page randomization")
	public static WebElement pageLogicLink3;
	
	@FindBy(linkText = "APPLY")
	static WebElement applyLink;
	
	@FindBy(id = "surveyCategory")
	public static WebElement surveyCategory;
	
	@FindBy(xpath = "//*[@id='surveyCategory']/option[text()='Just for Fun']")
	public static WebElement selectCategory;
	
	@FindBy(id = "editTitle")
	public static WebElement question1TextBox;
	
	@FindBy(id = "changeQType")
	public static WebElement changeQType;
	
	@FindBy(xpath = "//div[@id='editQuestion']//section[@class='t1']//a[contains(@class,'save')]")
	public static WebElement saveQuestion;

	public static void editSurveyTitle() {
		SeleniumUtils.waitForElementToBeVisible(surveyTitle);
		surveyTitle.click();
		surveyTitleTextBox.clear();
		surveyTitleTextBox.sendKeys(Prop.getTestData("newSurveyTitle"));
		saveSurveyTitle.click();
		log.info("Title saved after edit.");
	}

	public static void editPageTitle() {
		SeleniumUtils.waitForElementToBeVisible(pageTitle);
		SeleniumUtils.executeJavaScript("arguments[0].click();", pageTitle);
		log.info("Clicke on Page title.");
		pageTitleTextBox.clear();
		pageTitleTextBox.sendKeys(Prop.getTestData("pageTitle"));
		log.info("Page Title edit.");
	}

	public static void addPageLogic() {
		SeleniumUtils.waitForElementToBeVisible(pageLogicLink);
		pageLogicLink.click();
		log.info("Clicked on page logic link.");
		SeleniumUtils.waitForElementToBeVisible(pageLogicLink1);
		pageLogicLink1.click();
		SeleniumUtils.waitForElementToBeClickable(applyLink);
		applyLink.click();
		log.info("Page logic changes applied.");
	}

	public static void selectCategory() {
		SeleniumUtils.waitForElementToBeVisible(surveyCategory);
		SeleniumUtils.executeJavaScript("arguments[0].click();", surveyCategory);
		log.info("Clicked on Survey Category");
		selectCategory.click();
		log.info("Select category");
		savePageTitle.click();
		log.info("Category selected and saved.");
	}

	public static void addQuetionOne() {
		SeleniumUtils.waitForElementToBeVisible(question1TextBox);
		question1TextBox.clear();
		question1TextBox.sendKeys(Prop.getTestData("Que1"));
		selectQuestionTypeAndSave(Prop.getTestData("Type1"));
	}

	private static void selectQuestionTypeAndSave(String questionType) {
		changeQType.click();
		WebElement qType = Setup.driver.findElement(By.xpath("//a[contains(text(),'" + questionType + "')]"));
		SeleniumUtils.waitForElementToBeVisible(qType);
		qType.click();
		saveQuestion.click();
		log.info("Add an save question.");
	}

}
