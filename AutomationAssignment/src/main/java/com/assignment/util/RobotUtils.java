package com.assignment.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class RobotUtils {

	/**
	 * This method will upload file from drive with given file-path.
	 * 
	 * @param filePath
	 */
	public static void uploadFile(String filePath) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Clipboard clipboard = toolkit.getSystemClipboard();
		StringSelection strSel = new StringSelection(filePath);
		clipboard.setContents(strSel, null);
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		robot.delay(250);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.delay(250);
		robot.keyPress(KeyEvent.VK_V);
		robot.delay(250);
		robot.keyPress(KeyEvent.VK_ENTER);
	}
}
