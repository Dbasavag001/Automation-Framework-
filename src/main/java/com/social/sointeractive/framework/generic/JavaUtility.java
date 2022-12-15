package com.social.sointeractive.framework.generic;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	/**
	 * This method is to convert String to int, long datatype
	 * @param s
	 * @return
	 */
	public long stringToInt(String s) {
		return Integer.parseInt(s);
	}
	
	/**
	 * this method is to generate Random number
	 * @param number
	 * @return
	 */
	public int getradomNo(int number)
	{
		Random radomnum=new Random();
	  return  radomnum.nextInt(number);
	}
	
	/**
	 * this method generates current data and time
	 * @return
	 */
	public String getDateTime() {
		Date date = new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd_MM_YYYY_HH_mm_ss");
		String d = sdf.format(date);
		return d;
	}
}
