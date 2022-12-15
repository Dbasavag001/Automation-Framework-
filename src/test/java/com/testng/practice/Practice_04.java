package com.testng.practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.social.sointeractive.framework.generic.ListenerImplementation.class)
public class Practice_04 {
	@Test()
	public void Test04__01() {
	System.out.println("Test04__01");	
	Assert.assertEquals("A", "A");
	}
	
	@Test()
	public void Test04__02() {
	System.out.println("Test04__02");	
	Assert.assertEquals("A", "A");
	}
	
	@Test()
	public void Test04__03() {
	System.out.println("Test04__03");	
	Assert.assertEquals("A", "A");
	}
	
	@Test()
	public void Test04__04() {
	System.out.println("Test04__04");	
	Assert.assertEquals("A", "A");
	}

}
