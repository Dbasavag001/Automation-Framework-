package com.sdet44.practice;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProductPriceList {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter product Name  :  ");
	String name= sc.nextLine();
	WebDriverManager.chromedriver().setup();
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.get("https://www.flipkart.com/");
	driver.findElement(By.xpath("//button[.='✕']")).click(); 
	driver.findElement(By.name("q")).sendKeys(name+Keys.ENTER);
	
	List<WebElement> productNames = driver.findElements(By.xpath("//span[contains(text(),'results for')]/../../../../div[2]/div[1]/div[1]/div[1]/a/div[2]/div[1]/div[1]"));
	List<WebElement> productPrices = driver.findElements(By.xpath("//span[contains(text(),'results for')]/../../../../div[2]/div[1]/div[1]/div[1]/a/div[2]/div[2]/div[1]/div[1]/div[1]"));
	int count = productPrices.size();
	
	for(int i=0; i<count; i++) {
		String names = productNames.get(i).getText();
		String prices = productPrices.get(i).getText();
		System.out.println(names +"      ===============>>>>>>    "+ prices);
		
	}
	
	  
}
}
