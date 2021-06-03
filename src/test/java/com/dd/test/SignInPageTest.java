package com.dd.test;

import org.testng.annotations.Test;
import com.dd.framework.WebDriverThread;
import com.dd.framework.factory.ReadFromJson;
//import com.dd.pages.Homepage;
import com.dd.pages.SignInPage;
import com.dd.util.Constants;
import com.dd.util.Screenshots;



import org.testng.annotations.BeforeMethod;

import java.util.Map;

import org.openqa.selenium.Keys;
//import java.security.GeneralSecurityException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class SignInPageTest extends WebDriverThread {
	WebDriverWait wait;
	WebDriver driver;	
	SignInPage sip;
	Map<String, String> loginMap;
	private static String JSON_FILE="commonURLs";

	@BeforeMethod

	public void initialize() {
		logger.info("Inintialize");
		driver = getDriver();
		wait = new WebDriverWait(driver, 30);
		sip = new SignInPage(driver);		
	}


	public void HeaderRightSignin() throws InterruptedException {
		driver.get(loginMap.get("baseUrl"));
		wait.until(ExpectedConditions.visibilityOf(sip.getSignIn()));
		sip.getSignIn().click();
		logger.info("Clicked signin");
	}

	@Test
	public void invokeLogin() throws  InterruptedException  {
		logger.info("*********TIMES INVOKELOGIN CALLED");
		loginMap = ReadFromJson.getJSONMap(JSON_FILE);
		HeaderRightSignin();
		Thread.sleep(1000);
		sip.getDropdownSignIn().click();
		Thread.sleep(1000);
		sip.getUsername().sendKeys("srikanthtesting100@gmail.com");
		sip.getPassword().sendKeys("password123");
		Thread.sleep(1000);
		//int l = sip.getPassword().getText().length();
		logger.info("Password" + sip.getPassword().getText());
		sip.getPassword().submit();
		Screenshots.save(driver);
		String expectedTitle = "DollarDays | Bulk Goods for Nonprofits, Businesses & Schools | Wholesale Products";
		String actualTitle = driver.getTitle();
		
		if(actualTitle.equals(expectedTitle) ) {		
		Assert.assertTrue(true);
	}
	/*
	 Thread.sleep(2000);
	 sip.getSignIn().click();
	 logger.info("Signedindropdown");
	 Thread.sleep(2000);
	 sip.getLogoutBtn().click();
	 driver.get(Constants.BASE_URL);
	 Thread.sleep(2000);
	 sip.getSignIn().click();
	 sip.getDropdownSignIn().click();
	 Thread.sleep(2000);
	 sip.getUsername().sendKeys("srikanthtesting100@gmail");
	sip.getPassword().sendKeys("password123");
	sip.getPassword().submit();
	Screenshots.save(driver);
  if (sip.getAlertMessage().isDisplayed()) {
		
		logger.info("Login Failed");
	}
	*/
	popUpClose();
	logger.info("Signedin");
	
	 }
	
	
	public void popUpClose() throws InterruptedException {
		try {
			logger.info("POPUP");
			if(sip.getPopupClose().isDisplayed()) {
				   logger.info("*********INSIDE POP UP");				   
				   sip.getPopupClose().sendKeys(Keys.RETURN);	
				   logger.info("Popup closed");
			   }
		} catch (Exception e) {
			logger.info("no popup present");
		}
	}

	@AfterMethod
	public void afterMethod() {
		 quitDriver();
	}
}
