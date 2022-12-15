package com.sdet44.practice;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RoughClass {

	public static void main(String[] args) {

		Random r;
		r=new Random();
		for (int i = 0; i < 25; i++) {

			int num = r.nextInt(200);

			System.out.println(num);	
			
		}	
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		

	}

}
  