package com.assignment.util;

import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.assignment.setup.Driver;

public class LoggingListener extends TestListenerAdapter {

	private static Logger log = Logger.getLogger(Driver.class.getName());
	String testName = null;
	String testsName = null;
	String case_id = null;

	@Override
	public synchronized void onTestStart(ITestResult tr) {
		// String testsName = tr.getTestContext().getName();
		String testName = tr.getMethod().getMethodName();
		log.info("Test Case Name: " + testName);
		log.info("Started Execution for >>> " + tr.getMethod().getMethodName() + " from class "
				+ tr.getTestClass().getName() + " with Thread ID - " + Thread.currentThread().getId()
				+ " with Thread Name - " + Thread.currentThread().getName() + " with Thread Group - "
				+ Thread.currentThread().getThreadGroup());
	}

	@Override
	public synchronized void onTestSuccess(ITestResult tr) {
		testName = tr.getMethod().getMethodName();
		testsName = tr.getTestContext().getName();
		case_id = testName.split("_")[0].substring(1);
		log.info("PASSED: " + testName);
	}

	@Override
	public synchronized void onTestFailure(ITestResult tr) {
		testName = tr.getMethod().getMethodName();
		testsName = tr.getTestContext().getName();
		tr.getThrowable();
		log.info(tr.getThrowable());
		log.info("FAILED: " + testName);
	}

}
