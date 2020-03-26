package com.naukri.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {
	
	  public static void main(String[] args) {
	    	readPropertiesFile();
	    }
	  
	public static void readPropertiesFile() {
		
	  
		
		Properties prop = new Properties();
		try {
			InputStream ip = new FileInputStream("E:\\eclipse-workspace\\naukrisrikanth\\src\\test\\resources\\testdata\\config.properties");
			prop.load(ip);
			System.out.println(prop.getProperty("browser"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
}
