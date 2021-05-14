package com.dd.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;

import io.qameta.allure.Allure;

public class Screenshots {
	
	private static boolean createFile(File screenshot) {
		boolean fileCreated = false;
		
		if (screenshot.exists()) {
			fileCreated = true;
		} else {
			File parentDirectory = new File(screenshot.getParent());
			if (parentDirectory.exists() || parentDirectory.mkdirs()) {
				try {
					fileCreated = screenshot.createNewFile();
				} catch (IOException errorCreatingScreenshot) {
					errorCreatingScreenshot.printStackTrace();
				}
			}
		}

		return fileCreated;
	}

	private static void writeScreenshotToFile(WebDriver driver, File screenshot) {
		try {
			FileOutputStream screenshotStream = new FileOutputStream(screenshot);
			screenshotStream.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
			screenshotStream.close();
		} catch (IOException unableToWriteScreenshot) {
			System.err.println("Unable to write " + screenshot.getAbsolutePath());
			unableToWriteScreenshot.printStackTrace();
		}
	}

	private static String save( WebDriver driver) {
		String screenshotAbsolutePath=null;
		try {
			String screenshotDirectory = System.getProperty("screenshotDirectory", "target/screenshots");
			screenshotAbsolutePath = screenshotDirectory + File.separator + System.currentTimeMillis()+ ".png";
			File screenshot = new File(screenshotAbsolutePath);
			if (createFile(screenshot)) {
				try {
					writeScreenshotToFile(driver, screenshot);
				} catch (ClassCastException weNeedToAugmentOurDriverObject) {
					writeScreenshotToFile(new Augmenter().augment(driver), screenshot);
				}
				System.out.println("Written screenshot to " + screenshotAbsolutePath);
			} else {
				System.err.println("Unable to create " + screenshotAbsolutePath);
			}
		} catch (Exception ex) {
			System.err.println("Unable to capture screenshot...");
			ex.printStackTrace();
		}
		
		return screenshotAbsolutePath;
	}
	
	public static void take(String FileName , WebDriver driver)
	{
		String path = save(driver);
		FileInputStream is;
		if(path!=null)
		{
		try {
			is = new FileInputStream(path);
			 Allure.addAttachment(FileName, is);
			    try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
		}
		
	}

}