package com.testng.practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.social.sointeractive.framework.generic.ListenerImplementation.class)
public class Practice_03 {
	@Test()
	public void Test03__01() {
	System.out.println("Test03__01");	
	Assert.assertEquals("A", "A");
	}
	
	@Test()
	public void Test03__02() {
	System.out.println("Test03__02");	
	Assert.assertEquals("A", "A");
	}
	
	@Test()
	public void Test03__03() {
	System.out.println("Test03__03");	
	Assert.assertEquals("A", "A");
	}
	
	@Test()
	public void Test03__04() {
	System.out.println("Test03__04");	
	Assert.assertEquals("A", "A");
	}
}
