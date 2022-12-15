package com.testng.practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.social.sointeractive.framework.generic.BaseClass;

@Listeners(com.social.sointeractive.framework.generic.ListenerImplementation.class)
public class TestNGPractice1 extends BaseClass {

	
//	retryAnalyzer = com.social.sointeractive.framework.generic.RetryImplementationClass.class
	@Test()
	public void Test1() {
	System.out.println("Test1");	
	Assert.assertEquals("A", "A");
	}
}
 
