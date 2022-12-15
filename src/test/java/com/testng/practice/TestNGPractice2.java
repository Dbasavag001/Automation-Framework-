package com.testng.practice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestNGPractice2 {

	public static void main(String[] args) {
		
	
	DateTimeFormatter dff = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
	LocalDateTime now = LocalDateTime.now();
	String dateAndTime = dff.format(now);
	System.out.println(dateAndTime);
}
}
