package com.social.sointeractive.framework.generic;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener {
	
	private ExtentReports report;
	private ExtentTest test;
//	private WebDriverUtility webDriverUtility;

	@Override
	public void onTestStart(ITestResult result) {
//		System.out.println("Execution Started Successfully");
		System.out.println(Thread.currentThread().getId()+"   onTestStart"); 
		test = report.createTest(result.getMethod().getMethodName());
		ThreadSafe.setExtentTest(test); 			//setting extent test
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(Thread.currentThread().getId()+"   onTestSuccess"); 
		ThreadSafe.getExtentTest().pass(result.getMethod().getMethodName()+ "  is Passed");

	}

	@Override
	public void onTestFailure(ITestResult result) {

//		DateTimeFormatter dff = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH_mm_ss");
//		LocalDateTime now = LocalDateTime.now();
//		String dateAndTime = dff.format(now);
//		String testName = result.getMethod().getMethodName();
//		
//		EventFiringWebDriver eDriver=new EventFiringWebDriver(driver); 
//		File src = eDriver.getScreenshotAs(OutputType.FILE);
//		File dest = new File("./screenshot/"+ testName +"_"+ dateAndTime +".png"); 
//
//		try {
//			FileUtils.copyFile(src, dest);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		System.out.println(Thread.currentThread().getId()+"   onTestFailure"); 
	//	ThreadSafe.getWebDriverUtility().takesScreenShot(result.getMethod().getMethodName());
		ThreadSafe.getExtentTest().fail(result.getMethod().getMethodName()+ "  is failed");
		ThreadSafe.getExtentTest().fail(result.getThrowable());		// for printing all the exceptions in report
		String screenshot = ThreadSafe.getWebDriverUtility().takeScreenShot();
		ThreadSafe.getExtentTest().addScreenCaptureFromBase64String(screenshot, result.getMethod().getMethodName());
		
		
	}    

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(Thread.currentThread().getId()+"   onTestSkipped"); 
		ThreadSafe.getExtentTest().skip(result.getMethod().getMethodName()+ "  is Skipped");
		ThreadSafe.getExtentTest().skip(result.getThrowable());
	}


	@Override
	public void onStart(ITestContext context) {
		
		
//		webDriverUtility = new WebDriverUtility();
//		ThreadSafe.setWebDriverUtility(webDriverUtility);
		
		
		System.out.println(Thread.currentThread().getId()+"  On Start ---> test");
		ExtentSparkReporter spark=new ExtentSparkReporter("./extentReport/extentHtmlReport.html");
		spark.config().setDocumentTitle("Document Title");
		spark.config().setReportName("Report Name");
		spark.config().setTheme(Theme.STANDARD);
		report= new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Operating System", "Windows 10");
		report.setSystemInfo("Browser Name", "Chrome");
		report.setSystemInfo("Browser Version", "107");
		report.setSystemInfo("Reporter Name", "D Basva");
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println(Thread.currentThread().getId()+"   onFinish"); 
		report.flush();
//		ITestNGMethod[] methods = context.getAllTestMethods();
//		System.out.println(methods);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

}
