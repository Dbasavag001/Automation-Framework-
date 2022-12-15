package com.social.sointeractive.framework.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This is the generic utility for Property file
 * @author D Basava
 *
 */
public class PropertyFileUtility {
	
	private FileInputStream fis;
	private Properties p;
	/**
	 * This method is for opening the property file
	 * @param propertyPath
	 */
	public void openPropertyFile(String propertyPath) {
		try {
			fis=new FileInputStream(propertyPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		p=new Properties();
		try {
			p.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method is for getting the data from Property File
	 * @param key
	 * @return
	 */
	public String getDataFromPropertyFile(String key) {
		String data = p.getProperty(key).trim();
		return data;
	}
	/**
	 * This method is for closing the property file
	 */
	public  void closePropertyFile() {
		try {
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
