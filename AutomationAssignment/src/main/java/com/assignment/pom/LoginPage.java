
package com.assignment.pom;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.assignment.util.SeleniumUtils;

import io.qameta.allure.Step;

public class LoginPage {

	private static Logger log = Logger.getLogger(LoginPage.class.getName());
	
	@FindBy(linkText="LOG IN")
	public static WebElement loginLink;
	
	@FindBy(id="username")
	public static WebElement emailField;
	
	@FindBy(id="password")
	public static WebElement passwordField;
	
	@FindBy(xpath="//*[@type='submit']")
	static WebElement loginButton;
	
	@FindBy(linkText="Dashboard")
	public static WebElement dashBoardLink;

	/**
	 * This method will login into SurveyMonkey application.
	 * @param username
	 * @param password
	 */
	@Step("Login..")
	public static void login(String username, String password) {
		log.info("Login process..");
		loginLink.click();
		emailField.sendKeys(username);
		log.info("Email Entered.");
		passwordField.sendKeys(password);
		log.info("Password Entered.");
		loginButton.click();
		log.info("Login Successfully.");
	}
}

