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

public class AddStatusTest {
	
	@Test
	public void addStatusTest() throws IOException {
		
		
		FileInputStream fis=new FileInputStream("./src/test/resources/commondata.property");
		Properties p=new Properties();
		p.load(fis);
		String url = p.getProperty("url").trim();
		String un = p.getProperty("username").trim();
		String pwd = p.getProperty("password").trim();
		String browser = p.getProperty("browser").trim();
		String pass = p.getProperty("pass").trim();
		String fail = p.getProperty("fail").trim();
		long timeout =Long.parseLong (p.getProperty("timeout").trim());	//converting String type into Long type
		
		
		Random ran=new Random();
		int num = ran.nextInt(100);
		
		FileInputStream fis2= new FileInputStream("./src/test/resources/TestScript.xlsx");
		Workbook wb = WorkbookFactory.create(fis2);
		String expectedCaption = wb.getSheet("HomeModule").getRow(2).getCell(1).getStringCellValue()+num;
		String expectedImageName = wb.getSheet("HomeModule").getRow(2).getCell(2).getStringCellValue();
	//	String expectedCaption = expectedCapt+num;
	//	String browser = "chrome";
		
		
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
		
//		driver.findElement(By.xpath("//input[@type='file' and @name='image']")).click();
		
	
		//String expectedCaption = "Test Message "+num;
		//String expectedImageName = expectedImage+""+num;

		//String expectedImageName = "Testfile.jpeg";
		File f=new File("./src/test/resources/TestDataBioBook/"+expectedImageName);
		String absolutePath1 = f.getAbsolutePath();
		driver.findElement(By.xpath("//input[@type='file' and @name='image']")).sendKeys(absolutePath1);
		driver.findElement(By.name("content")).sendKeys(expectedCaption);
		driver.findElement(By.name("Submit")).click();
		driver.findElement(By.xpath("//a[@href='timeline.php']")).click();
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='user-details']")));
		 
		
		String actualCaption = driver.findElement(By.xpath("//div[@id='container']/descendant::div/p[text()='Test Message "+num+"']")).getText();
		
		String actualImage = driver.findElement(By.xpath("//div[@id='container']/descendant::div/p[text()='Test Message "+num+"']/following-sibling::center/img")).getAttribute("src");
		
		//String expectedCapt = expectedCaption+num;
		System.out.println(actualCaption);
		//System.out.println(expectedCapt);
		System.out.println(expectedCaption);
		System.out.println(actualImage);
		System.out.println(expectedImageName);
		
		FileOutputStream fos= new FileOutputStream("./src/test/resources/TestScript.xlsx");
		int lastCellnum = wb.getSheet("HomeModule").getRow(0).getLastCellNum();
		System.out.println(lastCellnum);
		if (actualCaption.equals(expectedCaption) && actualImage.contains(expectedImageName)) {
			wb.getSheet("HomeModule").getRow(3).getCell(lastCellnum-1).setCellValue(pass);
			System.out.println("TestCase Pass ---->>   Image uploaded successfully with caption");
		}
		else {
			wb.getSheet("HomeModule").getRow(3).getCell(lastCellnum-1).setCellValue(fail);
			System.out.println("TestCase Fail ---->>   Image Not uploaded ");
		}
	 
		
		wb.write(fos);
		System.out.println("updated");
		wb.close();
		fis.close();
		fis2.close();
		
		driver.findElement(By.xpath("//button[.='Log out']")).click();

		driver.quit();
	}
}
