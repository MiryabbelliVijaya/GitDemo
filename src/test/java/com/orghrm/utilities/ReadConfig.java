package com.orghrm.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	public Properties pro;
	
	public ReadConfig()
	{
		File src=new File(System.getProperty("user.dir")+"/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//----------- Methods to read property from 'ReadConfig.java file' -----------//
	public String getBrowser() {
		String br =pro.getProperty("browser");
		return br;
	}
	
	public String getBaseURL() {
		String baseurl =pro.getProperty("BaseUrl");
		return baseurl;
	}
		
	public String getLoginUserName() {
		String uname=pro.getProperty("loginusername");
		return uname;
	}
	
	public String getLoginPassword() {
		String pwd=pro.getProperty("loginpwd");
		return pwd;
	}
}
