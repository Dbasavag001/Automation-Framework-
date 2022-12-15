package com.social.sointeractive.framework.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonPage {
	 
		WebDriver driver;
		@FindBy(className="btn-sign-in") private  WebElement signinButton;
		@FindBy(className="btn-sign-up") private WebElement SignupButton;
		@FindBy(xpath="//label[.='Home']") private WebElement HomeModuleButton;
		@FindBy(xpath="//label[.='Profile']") private WebElement ProfileModuleButton;
		@FindBy(className="btn-sign-in") private WebElement logoutButton;
		@FindBy(xpath="//div[@class='head-view']/ul/li[8]/a") private WebElement userModuleButton;
		
		public CommonPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
			
		}
	/**
	 * This method used to click on Sign in Button
	 */
		 public void clickonSigninButton()
		 {
			 signinButton.click();
		 }
		/**
		 * This method used to click on Sign up Button 
		 */
		 public void clickonSignupButton()
		 {
			 SignupButton.click();
		 }
		 /**
			 * This method used to click on HomeModule
			 */
		 public void clickonHomeModule()
		 {
			 HomeModuleButton.click();
		 }
		 /**
		  * This method used to click on profileModule
		  */
		 public void clickonprofileModule()
		 {
			 ProfileModuleButton.click();
		 }
		 /**
		  * This method used to click on  logout Button
		  */
		 public void clickonlogoutButton()
		 {
			 logoutButton.click();
		 }
		 /**
		  * This Method is used to click on user Module 
		  */
		 public void clickonuserModule()
		 {
			 userModuleButton.click();
		 }
		 
	
}
