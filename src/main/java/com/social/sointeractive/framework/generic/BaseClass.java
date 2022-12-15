package com.social.sointeractive.framework.generic;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.social.sointeractive.framework.pom.CommonPage;
import com.social.sointeractive.framework.pom.LoginPage;

public class BaseClass {
   
	protected PropertyFileUtility propertyFileUtility=new PropertyFileUtility();
	protected ExcelUtility excelUtility = new ExcelUtility();
	protected WebDriverUtility webDriverUtility;
	
	protected JavaUtility javaUtility = new JavaUtility();
	
	protected static WebDriver driver;
	LoginPage loginPage;
	CommonPage commonPage;
	
	@BeforeClass
	public void openApplication() {
		webDriverUtility = new WebDriverUtility();
		ThreadSafe.setWebDriverUtility(webDriverUtility);
		propertyFileUtility.openPropertyFile(IConstantPath.PROPERTY_FILE_PATH);
		excelUtility.openExcel(IConstantPath.EXCEL_PATH);
		String browser = propertyFileUtility.getDataFromPropertyFile(PropertyFileKeys.BROWSER.convertToString());
		String url = propertyFileUtility.getDataFromPropertyFile(PropertyFileKeys.URL.convertToString());
		String timeout = propertyFileUtility.getDataFromPropertyFile(PropertyFileKeys.TIMEOUT.convertToString());
		long time = javaUtility.stringToInt(timeout);
		driver=webDriverUtility.openApplication(browser, url, time);
		System.out.println("Application opened");
	}
	
	@BeforeMethod
	public void loginToApplication() {
		propertyFileUtility.openPropertyFile(IConstantPath.PROPERTY_FILE_PATH);
		String username = propertyFileUtility.getDataFromPropertyFile(PropertyFileKeys.USERNAME.convertToString());
		String password = propertyFileUtility.getDataFromPropertyFile(PropertyFileKeys.PASSWORD.convertToString());
	//	commonPage.clickonSigninButton();
	//	System.out.println(username +"  "+ password);
		loginPage = new LoginPage(driver);
		loginPage.loginAction(username, password);
	}
	@AfterMethod
	public void logoutApplication() {
		commonPage=new CommonPage(driver);
		commonPage.clickonlogoutButton();
	}
	
	@AfterClass
	public void closeTheApplicaton() {
		excelUtility.closeExcel();
		propertyFileUtility.closePropertyFile();
		webDriverUtility.closeApplication();	
	}
	
}
