package com.testng.practice;

import org.testng.annotations.Test;

import com.social.sointeractive.framework.generic.BaseClass;
import com.social.sointeractive.framework.generic.SheetName;
import com.social.sointeractive.framework.pom.CommonPage;
import com.social.sointeractive.framework.pom.HomePage;
import com.social.sointeractive.framework.pom.HomeTNGpage;

public class AddStatusTest extends BaseClass  {

	@Test
	public void addStatusWithPhoto() {
		
		CommonPage commonPage=new CommonPage(driver);
		HomeTNGpage homeTNGpage=new HomeTNGpage(driver);
		int num = javaUtility.getradomNo(100);
		String expCaption = excelUtility.getDataFromExcel(SheetName.HOMEMODULE.convertToString(), 2, 1);
		String expImageName = excelUtility.getDataFromExcel(SheetName.HOMEMODULE.convertToString(), 2, 2);
		System.out.println(expCaption);
		System.out.println(expImageName);
		
//		homeTNGpage.shareThepost(expText, expPhoto);
//		homeTNGpage.verifyThePost(expText);
//	
		
	}
	
}
