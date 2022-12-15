package com.social.sointeractive.framework.testscript;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
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

import io.github.bonigarcia.wdm.WebDriverManager;

/**

1.Launch the application
2.Click on signin button
3.Click on username textfield 
4.Enter valid username 
5.Click on password textfield
6.Enter valid password
7.Click on login button
8.Click on admin button
9.Click on profile pic
10.Click on choose a file button
11.Select a jpeg file
12.Click on save button
13.click on home page"

 */

public class ProfilePicUpdateTest {


	
	@Test
	public void profilePicUpdateTest() throws IOException {
		
		FileInputStream fis=new FileInputStream("./src/test/resources/commondata.property");
		Properties p=new Properties();
		p.load(fis);
		String url = p.getProperty("url").trim();
		String un = p.getProperty("username").trim();
		String pwd = p.getProperty("password").trim();
		String browser = p.getProperty("browser").trim();
		long timeout =Long.parseLong (p.getProperty("timeout").trim());	//converting String type into Long type
		
		FileInputStream fis2 = new FileInputStream("./src/test/resources/TestDataBioBook/ProfilePic001.jpg");
		Workbook wb = WorkbookFactory.create(fis2);
		Cell expCell = wb.getSheet("ProfileModule").getRow(1).getCell(3);
		DataFormatter df=new DataFormatter();
		String expectedProfileImage = df.formatCellValue(expCell);		
		//String browser = "chrome";
		WebDriver driver=null;
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
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		driver.get(url);
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		
		driver.findElement(By.name("email")).sendKeys(un);
		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(By.name("submit")).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='file' and @name='image']")));
		
		driver.findElement(By.xpath("//a[@href='timeline.php']")).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[.='Personal Info']")));
		
	//	String expectedProfileImage = "ProfilePic001.jpg";
		
		driver.findElement(By.xpath("//div[@id='container']/descendant::a[@title='Change Profile Picture']/img")).click();
		
		
		File f = new File("./src/test/resources/TestDataBioBook/ProfilePic001.jpg");
		String absolutepath = f.getAbsolutePath(); 
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(absolutepath);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		String actualProfileImage = driver.findElement(By.xpath("//div[@id='container']/descendant::a[@title='Change Profile Picture']/img")).getAttribute("src");

		if(actualProfileImage.contains(expectedProfileImage)) {
			System.out.println("TestCase Pass ------->>>  Profile Photo Uploaded successfully ");
		}
		else {
			System.out.println("TestCase Fail ------>>> Profile photo Not Uploaded");
		}
		
		driver.findElement(By.xpath("//button[.='Log out']")).click();
		
		driver.quit();

	}
}
