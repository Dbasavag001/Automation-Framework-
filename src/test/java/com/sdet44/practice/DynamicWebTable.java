package com.sdet44.practice;

import java.awt.RenderingHints.Key;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicWebTable {
	public static void main(String[] args)  {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin"+Keys.ENTER);
		WebDriverWait wait = new WebDriverWait(driver,10);
		driver.findElement(By.xpath("//td[@class='tabUnSelected']/a[text()='Organizations']")).click();
		
		String page = driver.findElement(By.xpath("//span[@name='Accounts_listViewCountContainerName']")).getText();

		int pageNumber = Integer.parseInt(page.split(" ")[1]);
		int count = 0;
		String expOrgName = "org1";
		for (int j = 0; j < pageNumber; j++) {

			List<WebElement> orgList = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr/td[3]"));

			for (int i = 0; i < orgList.size() ; i++) {
				String actOrgName = orgList.get(i).getText();
				System.out.println(actOrgName);
				if(actOrgName.equals(expOrgName)) {
					System.out.println(actOrgName);
					driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr["+(i+2)+"]/td/input")).click();
					count++;
					break;				
				}
			}
			if(count==1)break;

			driver.findElement(By.xpath("//a[@title='Next']")).click();
			WebElement statusBar = driver.findElement(By.xpath("//div[@id='status']"));
			wait.until(ExpectedConditions.invisibilityOf(statusBar));
		}
	}
}


