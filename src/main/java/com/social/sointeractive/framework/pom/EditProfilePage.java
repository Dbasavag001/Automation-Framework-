package com.social.sointeractive.framework.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.social.sointeractive.framework.generic.WebDriverUtility;

/**
 * This class consist of create a new account and edit the profileinfo
 * @author Admin
 *
 */
public class EditProfilePage 
{
	@FindBy(name="firstname") private WebElement firstnameTextfiled;
	@FindBy(name="lastname") private WebElement lastnameTextfiled;
	@FindBy(name="username") private WebElement usernamenameTextfiled;
	@FindBy(name="username2") private WebElement reusernameTextfiled;
	@FindBy(name="day") private WebElement BirthDay;
	@FindBy(name="month") private WebElement BirthMonth;
	@FindBy(name="year") private WebElement Birthyear;
	@FindBy(xpath="//label[.='Male']/following-sibling::input[@value='male']") private WebElement MaleradioButton;
	@FindBy(xpath="//label[.='Female']/following-sibling::input[@value='female']") private WebElement FemaleradioButton;
	@FindBy(xpath="//input[@name='birthday']") private WebElement birthdayTextfiled;
	@FindBy(name="gender") private WebElement genderdropdown;
	@FindBy(name="number") private WebElement mobileNoTextfield;
	@FindBy(name="save") private WebElement saveButton;
	@FindBy(name="email") private WebElement emailTextFiled;
	@FindBy(name="email2") private WebElement reemailTextFiled;
	@FindBy(name="password") private WebElement passwordTextFiled;
	@FindBy(name="password2") private WebElement repasswordTextFiled;
	@FindBy(name="submit") private WebElement submitButton;
	public EditProfilePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
/**
 * This method used to edit the profileinfo
 * @param wu
 * @param firstname
 * @param lastname
 * @param username
 * @param birthday
 * @param gender
 * @param number 
 */
	 public void  changeprofileinfo(WebDriverUtility wu,String firstname,String lastname,String username,String birthday,String gender, String number)
	 {
		 firstnameTextfiled.clear();
		 firstnameTextfiled.sendKeys(firstname);
		 lastnameTextfiled.clear();
		 lastnameTextfiled.sendKeys(lastname);
		 usernamenameTextfiled.clear();
		 usernamenameTextfiled.sendKeys(username);
		 birthdayTextfiled.sendKeys(birthday);
		 wu.dropDown(genderdropdown).selectByVisibleText(gender);
		 mobileNoTextfield.clear();
		 mobileNoTextfield.sendKeys(number);
		 saveButton.click();
	 }
	 /**
	  * This method is used to create new profile/account
	  * @param wu
	  * @param firstname
	  * @param lastname
	  * @param username
	  * @param birthDay
	  * @param birthMonth
	  * @param birthYear
	  * @param Gender
	  * @param mobileNo
	  * @param emailid
	  * @param password
	  */
	 public void createProfile(WebDriverUtility wu,String firstname,String lastname,String username,
			 String birthDay,String birthMonth,String birthYear,String Gender,String mobileNo,String emailid,String password)
	 {
		 firstnameTextfiled.sendKeys(firstname);
		 lastnameTextfiled.sendKeys(lastname);
		 usernamenameTextfiled.sendKeys(username);
		 reusernameTextfiled.sendKeys(username);
		 wu.dropDown(BirthDay).selectByVisibleText(birthDay);
		 wu.dropDown(BirthMonth).selectByVisibleText(birthMonth);
		 wu.dropDown(Birthyear).selectByVisibleText(birthYear);	
		 if(Gender.equals("Male"))
			{
			 MaleradioButton.click();
			}
			else if(Gender.equals("Female"))
			{
				FemaleradioButton.click();
			}
		 mobileNoTextfield.sendKeys(mobileNo);
		 emailTextFiled.sendKeys(emailid);
		 reemailTextFiled.sendKeys(emailid);
		 passwordTextFiled.sendKeys(password);
		 repasswordTextFiled.sendKeys(password);
		 submitButton.click();
		 
	 }
}
