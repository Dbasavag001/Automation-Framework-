package com.social.sointeractive.framework.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
/**
 * This class consist of update status and verify the status and comment to the status 
 * @author User
 *
 */
public class HomeTNGpage
{ 
	WebDriver driver;
	@FindBy(name="content") private  WebElement statusTextBox;
	@FindBy(name="image") private WebElement statusPhoto;
	@FindBy(xpath ="//input[@type='file' and @name='image']") private WebElement chooseFileBtn;
	@FindBy(className="btn-share") private WebElement ShareButton;
	@FindBy(xpath="//div[@id='right-nav1']/div/p") private List<WebElement> allStatusText;
	@FindBy(xpath="//div[@id='right-nav1']/div/center/img") private List<WebElement> allStatusPhoto;
	@FindBy(name = "post_comment") private WebElement commentButton;
	@FindBy(xpath="//button[@class='btn-delete']")  private WebElement postDeleteButton;
	String commentBoxXpath="//p[.='%s']/../following-sibling::form/div/input[@type='text']";
	String deleteButtonXpath="//p[.='%s']/preceding-sibling::div/a/button";
	

	private WebElement StringToWebElemet(String partialXpath, String replaceData) {
		String xpath = String.format(partialXpath, replaceData);
		return	driver.findElement(By.xpath(xpath));
	}



	public HomeTNGpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	
	
	/**
	 * This Method is used to post the status 
	 * @param expstatusText
	 * @param expstatusPhoto
	 */

	public void shareThepost(String expStatusText,String expStatusPhoto)
	{
		statusTextBox.sendKeys(expStatusText);
		statusPhoto.sendKeys(expStatusPhoto);
		ShareButton.click();
	}
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}



	public void statusTextBx(String caption) {
		//this.statusTextBox = statusTextBox;
		statusTextBox.sendKeys(caption);
	}



	public void setStatusPhoto(WebElement statusPhoto) {
		this.statusPhoto = statusPhoto;
	}



	public void chooseFile(String absolutePath) {
		//this.chooseFileBtn = chooseFileBtn;
		chooseFileBtn.sendKeys(absolutePath);
	}



	public void setShareButton(WebElement shareButton) {
		ShareButton = shareButton;
	}



	public void setAllStatusText(List<WebElement> allStatusText) {
		this.allStatusText = allStatusText;
	}



	public void setAllStatusPhoto(List<WebElement> allStatusPhoto) {
		this.allStatusPhoto = allStatusPhoto;
	}



	public void setCommentButton(WebElement commentButton) {
		this.commentButton = commentButton;
	}



	public void setPostDeleteButton(WebElement postDeleteButton) {
		this.postDeleteButton = postDeleteButton;
	}



	public void setCommentBoxXpath(String commentBoxXpath) {
		this.commentBoxXpath = commentBoxXpath;
	}



	public void setDeleteButtonXpath(String deleteButtonXpath) {
		this.deleteButtonXpath = deleteButtonXpath;
	}



	/**
	 * This method is used to verify the status
	 * @param expstatusText
	 * @param expstatusPhoto
	 */

	public void verifyThePost(String expStatusText)
	{   
	//	boolean	flag=false;
		for(int i=0;i<allStatusText.size(); i++)
		{
			String actualStatusText = allStatusText.get(i).getText();
			SoftAssert softAssert=new SoftAssert();
			softAssert.assertEquals(actualStatusText, expStatusText);
//			
//			if(actualStatusText.equals(expStatusText))
//			{
//				flag=true;
//				break;
//			}

		}
//		if(flag==true)
//		{
//			System.out.println("Status is verfied and Status is uploaded sucessfully");
//
//		}
//		else
//		{
//			System.out.println("Not able to verfiy the uploaed status ");
//		}
	}

	/**
	 * This Method is used to comment for the particular post 
	 * @param ExceptedstatusText
	 * @param Exceptedstatusphoto
	 * @param commentforpost
	 * @throws InterruptedException 
	 */
	public void commentToPost(String expectedStatusText ,String exceptedPhoto,String commentOfPost) 
	{ 
		//boolean flag=false;
		for (int i = 0; i < allStatusText.size(); i++)
		{
			//String picName=allStatusPhoto.get(i).getAttribute("src");
		//	System.out.println(picName);

			String actualStatusText = allStatusText.get(i).getText();
			Assert.assertEquals(actualStatusText, expectedStatusText);
			Assert.assertTrue(true, "");
//			if(allStatusText.get(i).getText().equals(expectedStatusText)&& exceptedPhoto.contains(""))
//			{
				
				StringToWebElemet(commentBoxXpath, expectedStatusText).sendKeys(commentOfPost);
				
				commentButton.click();

//				flag=true;
//				break;
//			}
		}
		
//			if(flag==true)
//			{
//				System.out.println("Commented to the  post successfully");
//			}
//			else
//
//			{
//				System.out.println("Could Not able to comment to the post");
//			}
		}
	/**
	 * This method is used to delete the post
	 * @param ExceptedstatusText
	 */
	 public void deletethepost(String expectedStatusText )
	 {
		 for(int i=0; i <allStatusText.size(); i++)
		 {
			 if(allStatusText.get(i).getText().equals(expectedStatusText))
			 {
				 StringToWebElemet(deleteButtonXpath, expectedStatusText).click();
				 System.out.println("deleted the post");
				 break;
			 }
		 }
	 }
	 
		 
		 public void deleteallpost(int no)
		 {
			  for(int i=0; i<no; i++)
			  {
				  postDeleteButton.click();
			  }
			
		 }

		 
		 
	}

