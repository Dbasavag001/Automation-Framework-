package com.social.sointeractive.framework.generic;


public class practice1 {

	public static void main(String[] args) {
		
		WebDriverUtility webDriverUtility=new WebDriverUtility();
		PropertyFileUtility propertyFileUtility=new PropertyFileUtility();
		JavaUtility javaUtility=new JavaUtility();
		propertyFileUtility.openPropertyFile(IConstantPath.PROPERTY_FILE_PATH);
		String browser = propertyFileUtility.getDataFromPropertyFile(PropertyFileKeys.BROWSER.convertToString());
		String url = propertyFileUtility.getDataFromPropertyFile(PropertyFileKeys.URL.convertToString());
		String timeout = propertyFileUtility.getDataFromPropertyFile(PropertyFileKeys.TIMEOUT.convertToString());
		long time = javaUtility.stringToInt(timeout);
		webDriverUtility.openApplication(browser, url, time);
		propertyFileUtility.closePropertyFile();
		webDriverUtility.closeApplication();
		
	}
}
