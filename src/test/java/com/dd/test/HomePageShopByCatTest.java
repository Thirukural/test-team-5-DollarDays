package com.dd.test;


import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.dd.framework.WebDriverThread;
import com.dd.pages.Homepage;
import com.dd.util.Constants;
import com.dd.framework.factory.*;
import org.testng.annotations.Test;


//@Listeners(com.dd.listeners.ListenerBase.class)
public class HomePageShopByCatTest extends WebDriverThread {
	
	
	WebDriver wbDriver;
	WebDriverWait waitDriver;
	Homepage hp;
	JavascriptExecutor js ;
	String parent;
	List<WebElement> allLinks;
	WebElement a[];
	Map<String, String> allShopByCatUrl;
	private static Logger logger = LogManager.getLogger(HomePageShopByCatTest.class.getName());
	private static String JSON_FILE="ShopByCategoryUrls";
	
	  @BeforeMethod
	  public void initializeDrivers() {
			wbDriver = getDriver();
			waitDriver = new WebDriverWait(wbDriver, 30);
			hp = new Homepage(wbDriver, waitDriver);
			js = (JavascriptExecutor) wbDriver;
			//wbDriver.manage().deleteAllCookies();
		}
	 

	  
	  
	  @Test
	   public void assertShopByCategoryIteams() throws InterruptedException { 
		  		   
		  	wbDriver.get(Constants.BASE_URL);
		  	wbDriver.manage().window().maximize();
		  	allShopByCatUrl = ReadFromJson.getJSONMap(JSON_FILE);
		  	allLinks = hp.getMultipleInputElements();
		  	WebElement a[]=new WebElement[allLinks.size()];
		  	String constUrl="";		 
		  			  	  	
		  	
		   for(int i=0;i<allLinks.size();i++) {
			  			  
			   //waitDriver.until(ExpectedConditions.visibilityOf(allLinks.get(i)));
			   Thread.sleep(1000);			  
			   a[i]= allLinks.get(i);
			   Thread.sleep(1000);			   
			   if(hp.getPopupClose().isDisplayed()) {
				   logger.info("*********INSIDE POP UP");				   
				   hp.getPopupClose().sendKeys(Keys.RETURN);	
				   logger.info("Popup closed");
			   }			   
		      js.executeScript("arguments[0].click()",a[i]);
		      if(allShopByCatUrl.containsKey(String.valueOf(i))){
		    	  constUrl =  allShopByCatUrl.get(String.valueOf(i)); 
		    	  logger.info("constUrl-->"+constUrl);
		      }
		      Assert.assertEquals(wbDriver.getCurrentUrl(),constUrl);
		       wbDriver.navigate().back();
		      
		   } 
		  
	   }
		  
	  
  
 
	/* 
	 * closing the browsers	 
	 */
	
	@AfterMethod
	public void closeAll() {
		quitDriver();
	}


}
