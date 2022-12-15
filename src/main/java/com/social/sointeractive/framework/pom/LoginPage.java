package com.social.sointeractive.framework.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(name = "email")
	private WebElement userNameTextBox;
	
	@FindBy (name = "password")
	private WebElement passwordTextBox;
	
	@FindBy ( name = "submit")
	private WebElement submitbButton;
	
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserName(String username) {
		userNameTextBox.sendKeys(username);
	}
	
	public void enterPassWord(String password) {
		passwordTextBox.sendKeys(password);
	}
	public void clickSubmit() {
		submitbButton.click();
	}
	
	public void loginAction(String username, String password) {
		enterUserName(username);
		enterPassWord(password);
		clickSubmit();
			
		
		
	}
	
	
}
