package com.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	
	public ReadConfig() {
		File src=new File("./Config/configuration.properties");
		
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);	
			
		}
		catch(Exception E){
			System.out.println("Exception is " + E.getMessage());
			
		}
	}
	
	public String getSignUpUrl() {
		String url=pro.getProperty("signupUrl");
		return url;
		}
	
	public String getLoginUrl() {
		String url=pro.getProperty("loginurl");
		return url;
		}
	public String getEmail() {
		String email=pro.getProperty("email");
		return email;
		}
	
	
	
}
