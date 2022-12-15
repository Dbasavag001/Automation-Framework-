package com.social.sointeractive.framework.generic;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class contains generic methods for opening browser and alert ece. 
 * @author D Basava
 *
 */
public class WebDriverUtility {


	WebDriver driver;


	/**
	 * this method is used to open the browser
	 * @return
	 */
	public WebDriver openApplication(String browser, String url, long time) {
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browser.equals("ie")) {
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		else {
			System.out.println("Please enter valid Browser name");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	}

	/**
	 * this method handles the alert popup
	 */
	public void handleAlert() {
		Alert a = driver.switchTo().alert();
		String text1 = a.getText();
		a.accept();
		System.out.println(text1);
	}

	/**
	 * this method creates random number and gives back 
	 * @return
	 */
	public int randomNumber() {  
		Random ran = new Random();
		int num = ran.nextInt(100);
		return num;
	}

	/**
	 * this method is used for waiting condition 
	 * @param time
	 * @param ele
	 */
	public void webDriverWait(long time,By  ele) {
		WebDriverWait wait=new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.presenceOfElementLocated(ele));
	}


	/**
	 * this method is used for closing  the browser
	 */
	public void closeApplication() {
		driver.quit();
	}
	/**
	 * This Method will Handle the drop down 
	 * @param ele
	 * @return
	 */
	public Select dropDown(WebElement ele)

	{
		Select sc=new Select(ele);
		return sc;
	}

	/**
	 * this method takes screenshot and returns absolute path 
	 * @param testCaseName
	 * @return 
	 * @return
	 * @throws IOException 
	 */
	public String takesScreenShot(String testCaseName)  {
		String fileName = testCaseName+"_"+new JavaUtility().getDateTime();
		TakesScreenshot ts= (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/"+fileName+".png");
		try {
			Files.copy(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dest.getAbsolutePath();

		//		FileUtils.copyFile(src, dest);
	}
	
	/**
	 * 
	 * @return
	 */
	public String takeScreenShot() {
		TakesScreenshot ts= (TakesScreenshot)driver;
//		File src = ts.getScreenshotAs(OutputType.FILE);
		return  ts.getScreenshotAs(OutputType.BASE64);
		

		
	}


} 
