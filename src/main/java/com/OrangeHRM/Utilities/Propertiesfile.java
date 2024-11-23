package com.OrangeHRM.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Propertiesfile {
	
	public Properties prop;
	public static String getpropval(String key) throws IOException {
		Properties prop= new Properties();
		String file= System.getProperty("user.dir")+"/src/main//resources//config.properties";
		FileInputStream fis= new FileInputStream(file);
		prop.load(fis);
		return prop.getProperty(key);
				
	}

}
