package com.dd.test;

import org.testng.annotations.Test;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.*;
import com.dd.framework.WebDriverThread;
import com.dd.framework.factory.ReadFromJson;
import com.dd.pages.Homepage;
import com.dd.util.Screenshots;

//import junit.framework.Assert;
@Listeners(com.dd.listeners.ListenerBase.class)
public class HomepageTest extends WebDriverThread {

	WebDriverWait wait;
	WebDriver driver;
	Homepage hp;
	Map<String, String> ourcompanyUrlMap;
	private static Logger logger = LogManager.getLogger( HomepageTest.class.getName());
	private static String JSON_FILE="commonURLs";

//Initializing the drivers	

	@BeforeMethod
	public void initialize() {
		System.out.println("Inintialize");
		driver = getDriver();
		wait = new WebDriverWait(driver, 30);
		hp = new Homepage(driver, wait);		
	}

	
	@Test

	public void clickFooterAboutUs() throws InterruptedException {

		ourcompanyUrlMap = ReadFromJson.getJSONMap(JSON_FILE);
		navigateback();
		hp.getBlog().click();
		popUpClose();
        Assert.assertEquals(driver.getCurrentUrl(),ourcompanyUrlMap.get("BLOG_URL"));
        Screenshots.save(driver);
		//System.out.println("ASSERTION - Footer ::Blog Page OPENED -------> Pass");

		navigateback();
		logger.info("after navigate back...");
		hp.getAboutUs().click();
		logger.info("after button click...");
		//Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), ourcompanyUrlMap.get("ABOUT_US_URL"));
		//System.out.println("ASSERTION - Footer :: About Us Page OPENED -------> Pass");
		logger.info("---> About Us link clicked and page loaded successfully");
		
		navigateback();
		logger.info("after navigate back...");
		hp.getCareers().click();
		logger.info("after button click...");
		//Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), ourcompanyUrlMap.get("CAREERS_URL"));
		//System.out.println("ASSERTION - Footer :: Careers Page OPENED -------> Pass");
        logger.info("---> Careers Page  link clicked and page loaded successfully");
		
        navigateback();
        logger.info("after navigate back...");
		hp.getPartnerWithUs().click();
		logger.info("after button click...");
		//Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), ourcompanyUrlMap.get("PARTNERWITHUS_URL"));
		//System.out.println("ASSERTION - Footer :: Partner With Us Page OPENED -------> Pass");
        logger.info("--->  Partner With Us  link clicked and page loaded successfully");
		
        

		navigateback();
		logger.info("after navigate back...");
		hp.getWishListProgram().click();
		logger.info("after button click...");
		//Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(),ourcompanyUrlMap.get("WISHLIST_PROGRAM_URL"));
		//System.out.println("ASSERTION - Footer :: Wishlist Program Page OPENED -------> Pass");
        logger.info("--->  Wishlist Program Page  link clicked and page loaded successfully");

		navigateback();
		logger.info("after navigate back...");
		hp.getBusinessBenefits().click();
		logger.info("after button click...");
		//Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), ourcompanyUrlMap.get("BUSINESS_BENEFIT_URL"));
		//System.out.println("ASSERTION - Footer :: Business Benefit Page OPENED -------> Pass");
        logger.info("--->  Business Benefit Page  link clicked and page loaded successfully");

		
        navigateback();
        logger.info("after navigate back...");
		hp.getEducatorBenefits().click();
		logger.info("after button click...");
		//Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), ourcompanyUrlMap.get("EDUCATOR_BENEFIT_URL"));
		//System.out.println("ASSERTION - Footer :: Educator benefit Page OPENED -------> Pass");
        logger.info("--->  Educator benefit Page  link clicked and page loaded successfully");


		
		navigateback();
		logger.info("after navigate back...");
		hp.getNonprofitBenefits().click();
		logger.info("after button click...");
		//Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(),ourcompanyUrlMap.get("NON_PROFIT_BENEFIT_URL"));
		//System.out.println("ASSERTION - Footer :: Non Profit Benefit Page OPENED -------> Pass");
        logger.info("--->   Non Profit Benefit Page  link clicked and page loaded successfully");
	}

	public void navigateback() throws InterruptedException {
		driver.get(ourcompanyUrlMap.get("baseUrl"));
		//driver.manage().window().maximize();
		popUpClose();
		Thread.sleep(1000);		
	}

	public void popUpClose() throws InterruptedException {
		try {
			
			logger.info("inside pop up");
			Thread.sleep(2000);
			if(hp.getPopupClose().isDisplayed()) {
				   logger.info("*********INSIDE POP UP");				   
				   hp.getPopupClose().sendKeys(Keys.RETURN);	
				   logger.info("Popup closed");
			   }
		} catch (Exception e) {
			logger.info("no popup present");
		}
	}

	/*
	 * closing the browsers*?
	 *
	 */
	@AfterMethod
	public void closeAll() {
		quitDriver();
	}
}
