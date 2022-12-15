package com.social.sointeractive.framework.testscript;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.social.sointeractive.framework.generic.ExcelUtility;
import com.social.sointeractive.framework.generic.IConstantPath;
import com.social.sointeractive.framework.generic.JavaUtility;
import com.social.sointeractive.framework.generic.PropertyFileKeys;
import com.social.sointeractive.framework.generic.PropertyFileUtility;
import com.social.sointeractive.framework.generic.SheetName;
import com.social.sointeractive.framework.generic.WebDriverUtility;
import com.social.sointeractive.framework.pom.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
"1.Launch the application
2.Click on signin button
3.Click on username textfield 
4.Enter valid username 
5.Click on password textfield
6.Enter valid password
7.Click on login button
8.Click on choose file button
9.Select a .jpeg file
10.Add a caption
11.Click on Share
12.Click on admin button"
**/
public class AddStatusPomTest {
	

	@Test
	public void addStatusPomTest()
	{
		
		WebDriverUtility webDriverUtility = new WebDriverUtility();
		PropertyFileUtility propertyFileUtility=new PropertyFileUtility();
		JavaUtility javaUtility=new JavaUtility();
		ExcelUtility excelUtility=new ExcelUtility();

		int num = webDriverUtility.randomNumber();
		propertyFileUtility.openPropertyFile(IConstantPath.PROPERTY_FILE_PATH);
		String browser = propertyFileUtility.getDataFromPropertyFile(PropertyFileKeys.BROWSER.convertToString());
		String url = propertyFileUtility.getDataFromPropertyFile(PropertyFileKeys.URL.convertToString());
		String timeout = propertyFileUtility.getDataFromPropertyFile(PropertyFileKeys.TIMEOUT.convertToString());
		long time = javaUtility.stringToInt(timeout);
		WebDriver driver = webDriverUtility.openApplication(browser, url, time);
		
		
		LoginPage login=new LoginPage(driver);
		
		

		
	//	WebDriverWait wait = webDriverUtility.webDriverWait(time, xpath("//input[@type='file' and @name='image']"));
		
		excelUtility.openExcel(IConstantPath.EXCEL_PATH);
		String expectedImageName = excelUtility.getDataFromExcel(SheetName.HOMEMODULE.convertToString(), 2, 2);
		String expectedCaption = excelUtility.getDataFromExcel(SheetName.HOMEMODULE.convertToString(), 2	, 1);
		
		
		//login.loginAction(usern);
		By element=By.xpath("//input[@type='file' and @name='image']");
		webDriverUtility.webDriverWait(time, element);
		
		
//		driver.findElement(By.xpath("//input[@type='file' and @name='image']")).click();
		
	
//		String expectedCaption = "Test Message "+num;
//		String expectedImageName = expectedImage+""+num;
		  
		

		//String expectedImageName = "Testfile.jpeg";
		File f=new File("./src/test/resources/TestDataBioBook/"+expectedImageName);
		String absolutePath1 = f.getAbsolutePath();
		driver.findElement(By.xpath("//input[@type='file' and @name='image']")).sendKeys(absolutePath1);
		driver.findElement(By.name("content")).sendKeys(expectedCaption);
		driver.findElement(By.name("Submit")).click();
		driver.findElement(By.xpath("//a[@href='timeline.php']")).click();
		
	//	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='user-details']")));
		 
		
		String actualCaption = driver.findElement(By.xpath("//div[@id='container']/descendant::div/p[text()='Test Message "+num+"']")).getText();
		
		String actualImage = driver.findElement(By.xpath("//div[@id='container']/descendant::div/p[text()='Test Message "+num+"']/following-sibling::center/img")).getAttribute("src");
		
		//String expectedCapt = expectedCaption+num;
		System.out.println(actualCaption);
		//System.out.println(expectedCapt);
		System.out.println(expectedCaption);
		System.out.println(actualImage);
		System.out.println(expectedImageName);
		
//		FileOutputStream fos= new FileOutputStream("./src/test/resources/TestScript.xlsx");
//		int lastCellnum = wb.getSheet("HomeModule").getRow(0).getLastCellNum();
//		System.out.println(lastCellnum);
//		if (actualCaption.equals(expectedCaption) && actualImage.contains(expectedImageName)) {
//			wb.getSheet("HomeModule").getRow(3).getCell(lastCellnum-1).setCellValue(pass);
//			System.out.println("TestCase Pass ---->>   Image uploaded successfully with caption");
//		}
//		else {
//			wb.getSheet("HomeModule").getRow(3).getCell(lastCellnum-1).setCellValue(fail);
//			System.out.println("TestCase Fail ---->>   Image Not uploaded ");
//		}
//	 
//		
//		wb.write(fos);
//		System.out.println("updated");
//		wb.close();
//		fis.close();
//		fis2.close();
//		
		driver.findElement(By.xpath("//button[.='Log out']")).click();

		driver.quit();
	}
}




