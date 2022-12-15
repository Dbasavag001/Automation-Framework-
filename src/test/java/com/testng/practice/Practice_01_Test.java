package com.testng.practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.social.sointeractive.framework.generic.ListenerImplementation.class)
public class Practice_01_Test {

	@Test()
	public void Test01__01() {
	System.out.println("Test01__01");	
	Assert.assertEquals("A", "A");
	}
	
	@Test()
	public void Test01__02() {
	System.out.println("Test01__02");	
	Assert.assertEquals("A", "A");
	}
	
	@Test()
	public void Test01__03() {
	System.out.println("Test01__03");	
	Assert.assertEquals("A", "b");
	}
	
	@Test()
	public void Test01__04() {
	System.out.println("Test01__04");	
	Assert.assertEquals("A", "A");
	}
}
