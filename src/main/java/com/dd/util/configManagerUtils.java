package com.dd.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class configManagerUtils {
	public static Properties configProperties = new Properties();
	
	static {
		new configManagerUtils().createConfigManager();
	}
	public void createConfigManager() {
		if (!configProperties.isEmpty()) {
			configProperties.clear();
		}
		try {
			InputStream input = new FileInputStream(
					new File("").getAbsolutePath() + "/src/test/java/config/TestConfig.properties");
			configProperties.load(input);
			configProperties.putAll(System.getenv());
			configProperties.putAll(System.getProperties());
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}