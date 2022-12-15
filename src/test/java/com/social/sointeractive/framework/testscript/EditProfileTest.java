package com.social.sointeractive.framework.testscript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/** 
 * "1.Launch the application
2.Click on signin button
3.Click on username textfield 
4.Enter valid username 
5.Click on password textfield
6.Enter valid password
7.Click on login button
8.Click on profile button
9.Click on edit profile
10.Click on username textfield
11.Enter valid username
12.Click on save
13.Click on Home button"
 */


public class EditProfileTest {

	@Test
	public void editProfileTest() {

		String browser = "chrome";
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
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://rmgtestingserver/domain/Bio_Book/signin.php");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		driver.findElement(By.name("email")).sendKeys("janobe@gmail.com");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("submit")).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='file' and @name='image']")));
		driver.findElement(By.xpath("//a[@href='profile.php']")).click();
		
		String expFirstName = "TestAdmin";
		String expLastName = "Man";
		String expUsername = "janobe@gmail.com";
		String expBirthDate = "01012000";
		 String expMobileNum = "6361818890";
		 String male="Male";
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("right-nav")));
		driver.findElement(By.xpath("//button[.='Edit Profile']")).click();
		driver.findElement(By.name("firstname")).sendKeys(Keys.CONTROL+"a"+expFirstName);
		driver.findElement(By.name("lastname")).sendKeys(Keys.CONTROL+"a"+expLastName);
		driver.findElement(By.name("username")).sendKeys(Keys.CONTROL+"a"+expUsername);
		driver.findElement(By.name("birthday")).sendKeys(expBirthDate);
		WebElement dob = driver.findElement(By.name("gender"));
		
		Select s=new Select(dob);
		s.selectByVisibleText("Male");
		
		driver.findElement(By.name("number")).sendKeys(Keys.CONTROL+"a"+expMobileNum);
		driver.findElement(By.xpath("//button[@name='save']")).click();
		
		//Actual results
		
		String actFirstName = driver.findElement(By.xpath("//label[.='Firstname']/following-sibling::b")).getText();
		String actLastName = driver.findElement(By.xpath("//label[.='Lastname']/following-sibling::b")).getText();
		String actUsername = driver.findElement(By.xpath("//label[.='Username']/following-sibling::b")).getText();
		String actBirthDate = driver.findElement(By.xpath("//label[.='Birthday']/following-sibling::b")).getText();
		String actMobileNum = driver.findElement(By.xpath("//label[.='Number']/following-sibling::b")).getText();
		
		System.out.println(actFirstName);
		
//		if() {
//			
//		}
//		
		
		
	}

}
