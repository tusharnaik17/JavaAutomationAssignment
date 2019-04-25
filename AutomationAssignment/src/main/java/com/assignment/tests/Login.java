package com.assignment.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.assignment.pom.LoginPage;
import com.assignment.setup.Setup;
import com.assignment.util.Prop;
import com.assignment.util.SeleniumUtils;

import io.qameta.allure.Description;

public class Login extends Setup {

	@Test(groups = { "Login" })
	@Description("Verify that user is able to perform login")
	public static void verifyLogin() throws IOException, InterruptedException {
		try {
			LoginPage.login(Prop.getTestData("username"), Prop.getTestData("password"));
		} catch (Exception e) {
			SeleniumUtils.captureScreenshot("verifyLogin");
			e.getStackTrace();
			throw e;
		}
	}

}