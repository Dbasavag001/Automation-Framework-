package com.social.sointeractive.framework.generic;

import com.aventstack.extentreports.ExtentTest;

public class ThreadSafe {

	private static  ThreadLocal<WebDriverUtility> webDriverUtility=new ThreadLocal<>();
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
	
	/**
	 * 
	 * @return
	 */
	public static WebDriverUtility getWebDriverUtility() {
		return webDriverUtility.get();
	}
	
	/**
	 * 
	 * @param swebDriverUtility
	 */
	public static void setWebDriverUtility(WebDriverUtility swebDriverUtility) {
		webDriverUtility.set(swebDriverUtility);
	}
	
	/**
	 * 
	 * @return
	 */
	public static ExtentTest getExtentTest() {
	return extentTest.get();
	}
	
	/**
	 * 
	 * @param setExExtentTest
	 */
	public static void setExtentTest(ExtentTest setExExtentTest) {
		extentTest.set(setExExtentTest);
	}
}
