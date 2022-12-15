package com.testng.practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.social.sointeractive.framework.generic.ListenerImplementation.class)
public class Practice_02 {
	@Test()
	public void Test02__01() {
	System.out.println("Test02__01");	
	Assert.assertEquals("A", "A");
	}
	
	@Test()
	public void Test02__02() {
	System.out.println("Test02__02");	
	Assert.assertEquals("A", "A");
	}
	
	@Test()
	public void Test02__03() {
	System.out.println("Test02__03");	
	Assert.assertEquals("A", "A");
	}
	
	@Test()
	public void Test02__04() {
	System.out.println("Test02__04");	
	Assert.assertEquals("A", "A");
	}
}
