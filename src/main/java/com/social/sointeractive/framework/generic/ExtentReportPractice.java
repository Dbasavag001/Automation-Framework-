package com.social.sointeractive.framework.generic;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportPractice {

	public static void main(String[] args) {
		
		//creating and setting configurations of report
		ExtentSparkReporter spark=new ExtentSparkReporter("./extentReport/extentHtmlReport.html");
		spark.config().setDocumentTitle("Document Title");
		spark.config().setReportName("Report Name");
		spark.config().setTheme(Theme.DARK);
		
		//report data
		ExtentReports report= new ExtentReports();
		report.attachReporter(spark);
	
		report.setSystemInfo("Operating System", "Windows 10");
		report.setSystemInfo("Browser Name", "Chrome");
		report.setSystemInfo("Browser Version", "107");
		report.setSystemInfo("Reporter Name", "D Basva");  
		
		

		ExtentTest test1 = report.createTest("test1");
		test1.info("This information coming from Script");
		test1.warning("Warning Message");
		test1.fail("test1 fail");
		
		ExtentTest test2 = report.createTest("test2");
		test2.info("This information coming from Script");
		test2.info("This information coming from Script");
		test2.info("This information coming from Script");
		test2.info("This information coming from Script");
		test2.pass("test2 Pass");
		
		ExtentTest test3 = report.createTest("test2");
		test3.info("This information coming from Script");
		test3.info("This information coming from Script");
		test3.info("This information coming from Script");
		test3.info("This information coming from Script");
		test3.warning("Warning message");
		test3.info("This information coming from Script");
		test3.info("This information coming from Script");
		test3.info("This information coming from Script");

		report.flush();

	}
}
