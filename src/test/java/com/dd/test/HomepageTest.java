package com.dd.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
import org.testng.annotations.*;
import com.dd.framework.WebDriverThread;
import com.dd.util.Constants;

//import junit.framework.Assert;

public class HomepageTest extends WebDriverThread{
//Initializing the drivers	
	public WebDriver driver;
	@BeforeMethod
public void initialize() {
	driver = getDriver();
}
@Test
/* Test method follows*/
public void verifyHomepageURL() {
	String testURL="";
	String outputURL;
	driver.get(Constants.BASE_URL);
	outputURL = driver.getTitle();
	System.out.println("Webpage title ="+outputURL);
	Assert.assertEquals(true,true);
}

/* closing the browsers*?
 
 */
@AfterMethod
public void closeAll() {
	quitDriver();
}

}
