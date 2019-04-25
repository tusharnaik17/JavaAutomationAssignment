package com.assignment.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Set;

import javax.tools.Tool;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.assignment.setup.Setup;

import io.qameta.allure.Attachment;

public class SeleniumUtils {

	private static Logger log = Logger.getLogger(SeleniumUtils.class.getName());

	/**
	 * This method capture screenshot, copy the screenshot to screenshot
	 * directory, if directory is not exist then it creates the directory
	 * 
	 * @return Screenshot File path
	 * @param Test case name
	 */
	@Attachment(value = "Page screenshot", type = "image/png")
	public static byte[] captureScreenshot(String testName) {
		String filePath = null;
		try {
			File scrFile = null;
			log.info("Driver>>>>>> " + Setup.driver.toString());
			scrFile = ((TakesScreenshot) Setup.driver).getScreenshotAs(OutputType.FILE);
			String scrFileName = testName + "_" + CommonUtils.getCurrentTimeForScreenShot() + ".png";
			File directory = new File(Setup.screenshotPath);
			if (!directory.exists()) {
				directory.mkdir();
			}
			filePath = directory + File.separator + scrFileName;
			FileUtils.copyFile(scrFile, new File(filePath));
			log.info(": => Please refer " + filePath);
			log.debug(": => For Verification, Please refer " + scrFileName);
		} catch (Exception e) {
			log.info("Failed to take screenshot : " + e.getMessage());
			e.printStackTrace();
		}
		// return filePath;
		log.info("File path for screenshot" + filePath);
		return ((TakesScreenshot) Setup.driver).getScreenshotAs(OutputType.BYTES);
	}

	/**
	 * This method opens the given user in the current browser session.
	 * 
	 * @return void
	 * @param url
	 */
	public static void openUrl(String url) {
		Setup.driver.navigate().to(url);
		log.info("Navigated to " + url);
	}

	/**
	 * This method switch driver inside the frame by frame name
	 * 
	 * @return void
	 * @param frame
	 *            name
	 */
	public static void switchToIframeByName(String name) {
		Setup.driver.switchTo().frame(name);
		log.info("Switched to " + name + " iframe");
	}

	/**
	 * This method switch driver inside the frame by frame ID
	 * 
	 * @return void
	 * @param frame
	 *            ID
	 */
	public static void switchToIframeById(String id) {
		Setup.driver.switchTo().frame(id);
		log.info("Switched to " + id + " iframe");
	}

	/**
	 * This method switch driver inside the frame by frame ID
	 * 
	 * @return void
	 * @param frame
	 *            ID
	 */
	public static void switchToIframeByIndex(int i) {
		Setup.driver.switchTo().frame(i);
		log.info("Switched to " + i + " iframe");
	}

	/**
	 * This method switch back driver to default frame, if driver is inside any
	 * frame
	 * 
	 * @return void
	 * @param void
	 */
	public static void switchToDefaultIframe() {
		Setup.driver.switchTo().defaultContent();
		log.info("Switched to default iframe");
	}

	/**
	 * This method wait for given element to be visible in DOM
	 * 
	 * @return void
	 * @param WebElement
	 */
	public static void waitForElementToBeVisible(WebElement element) {
		log.info("Waiting for element to be visible....");
		WebDriverWait wait = new WebDriverWait(Setup.driver, 60);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info("Element found");
	}

	/**
	 * This method wait for given element to be invisible in DOM
	 * 
	 * @return void
	 * @param WebElement
	 */
	public static void waitForElementToBeInvisible(WebElement element) {
		log.info("Waiting for element to be invisible....");
		WebDriverWait wait = new WebDriverWait(Setup.driver, 60);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	/**
	 * This method wait for given element to Contains Attribute Value
	 * 
	 * @return void
	 * @param WebElement
	 * @param attribute
	 * @param value
	 */
	public static void waitForElementToContainsAttributeValue(WebElement element, String attribute, String value) {
		log.info("Waiting for element to be invisible....");
		WebDriverWait wait = new WebDriverWait(Setup.driver, 60);
		wait.until(ExpectedConditions.attributeContains(element, attribute, value));
	}
	
	/**
	 * This method wait for given element to be clickable in DOM
	 * 
	 * @return void
	 * @param WebElement
	 */
	public static void waitForElementToBeClickable(WebElement element) {
		log.info("Waiting for element to be visible....");
		WebDriverWait wait = new WebDriverWait(Setup.driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This method returns the current url.
	 * 
	 * @return current url
	 * @param void
	 */
	public static String getCurrentUrl() {
		String currentUrl = Setup.driver.getCurrentUrl();
		return currentUrl;
	}

	/**
	 * This method opens given url in new window and return current and new
	 * window handles.
	 * 
	 * @return window handles
	 * @param url
	 */
	public static Set<String> openUrlInNewWindow(String url) {
		((JavascriptExecutor) Setup.driver).executeScript("window.open(arguments[0])", url);
		Set<String> windowHandles = Setup.driver.getWindowHandles();
		return windowHandles;
	}

	/**
	 * This method switch to new window.
	 * 
	 * @return void
	 * @param window
	 *            handles
	 */
	public static void switchToWindow(String handle) {
		log.info("Switching to window...");
		Setup.driver.switchTo().window(handle);
		
	}

	/**
	 * This method switch to new window and close it.
	 * 
	 * @return void
	 * @param window
	 *            handles
	 */
	public static void switchToWindowAndClose(String handle) {
		log.info("Switching and closing window...");
		Setup.driver.switchTo().window(handle).close();
	}

	/**
	 * This method scrolls window to the bottom.
	 * 
	 * @return void
	 * @param void
	 */
	public static void scrollToBottom() {
		((JavascriptExecutor) Setup.driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		log.info("Scrolling till bottom");
	}

	/**
	 * This method scrolls window to the top
	 * 
	 * @return void
	 * @param void
	 */
	public static void scrollToTop() {
		((JavascriptExecutor) Setup.driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
	}
	
	/**
	 * This method scrolls window vertically.
	 * 
	 * @return void
	 * @param top
	 * @param bottom
	 * 
	 */
	public static void scrollVertically(int top, int bottom) {
		log.info("Scrolling to Vertically...");
		String javaScript = "window.scrollTo("+top+", "+bottom+")";
		((JavascriptExecutor) Setup.driver).executeScript(javaScript);
	}

	
	/**
	 * This method refresh/reload the current page.
	 * 
	 * @return void
	 * @param void
	 */
	public static void refreshPage() {
		Setup.driver.navigate().refresh();
	}

	/**
	 * This method click on ok/yes button of a javascript popup
	 * 
	 * @return void
	 * @param void
	 */
	public static void acceptPopup() {
		Setup.driver.switchTo().alert().accept();
	}

	/**
	 * This method click on cancle/no button of a javascript popup
	 * 
	 * @return void
	 * @param void
	 */
	public static void dismissPopup() {
		Setup.driver.switchTo().alert().dismiss();
	}

	/**
	 * This method executes javascript on target web element
	 * 
	 * @return void
	 * @param javascript, webelement
	 */
	public static void executeJavaScript(String javaScript, WebElement webElement) {
		SeleniumUtils.waitForElementToBeVisible(webElement);
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Setup.driver;
		javascriptExecutor.executeScript(javaScript, webElement);
	}

	/**
	 * This method mouse hovers on target web element
	 * 
	 * @return void
	 * @param webelement
	 */
	public static void mouseHover(WebElement webElement) {
		SeleniumUtils.waitForElementToBeVisible(webElement);
		Actions actionBuilder = new Actions(Setup.driver);
		actionBuilder.moveToElement(webElement).build().perform();
		log.info("Mouse hovered on target element");
	}

	/**
	 * This method will return no of child elements.
	 * @param webElement
	 * @return count
	 */
	public static int numberOfChildElements(String webElement) {
		int count = Setup.driver.findElements(By.xpath(webElement)).size();
		return count;
	}
	

	/**
	 * This method enable caps lock
	 */
	public static void enableCapsLock() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		toolkit.setLockingKeyState(KeyEvent.VK_CAPS_LOCK, true);
		log.info("Caps lock enabled");
		/*try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CAPS_LOCK);
			robot.keyRelease(KeyEvent.VK_CAPS_LOCK);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}
	
	/**
	 * This method enable caps lock
	 */
	public static void disableCapsLock() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		toolkit.setLockingKeyState(KeyEvent.VK_CAPS_LOCK, false);
	}
	
}
