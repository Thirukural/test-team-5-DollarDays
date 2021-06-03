package com.dd.test;


import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.dd.framework.WebDriverThread;
import com.dd.framework.factory.ReadFromJson;
import com.dd.pages.Homepage;
import com.dd.util.Screenshots;

//@Listeners(com.dd.listeners.ListenerBase.class)

public class HomepageHeaderTest extends WebDriverThread {
	
		WebDriverWait wait;
		WebDriver driver;
		Homepage hp;
		JavascriptExecutor jse;
		private static Logger logger = LogManager.getLogger(HomepageHeaderTest.class.getName());
		Map<String, String> headerUrlMap;
		Map<String, String> searchMap;
		
		private static String JSON_FILE="commonURLs";
		private static String JSON_SEARCH_FILE="searchWords";
				
		/*
		 * Initializing the drivers			
		 */
		
		@BeforeMethod
		public void initialize() {
			driver = getDriver();
			
			wait = new WebDriverWait(driver, 60);
			hp = new Homepage(driver,wait);
			jse = (JavascriptExecutor) driver;
			headerUrlMap = ReadFromJson.getJSONMap(JSON_FILE);
			searchMap = ReadFromJson.getJSONMap(JSON_SEARCH_FILE);			
		}
		
		public void openBaseURL() {
			driver.get(headerUrlMap.get("baseUrl"));
			//driver.manage().window().maximize();		
		}
	
		public void clickToggleHamMenu( Homepage hp) throws InterruptedException{
			openBaseURL();			
			jse.executeScript("arguments[0].click()",hp.getToggleHamMenu());
		}
		
		/* 
		 * 
		 * Asserting the menu items for Now Trending, Programs
		 * and Help & Settings sections under Toggle Ham menu
		 * 
		 */
		
	@Test(priority=1)
	public void assertToggleMenuItems() throws InterruptedException{
				
		
		clickToggleHamMenu(hp);
		driver.manage().window().maximize();	
		wait.until(ExpectedConditions.visibilityOf(hp.getToggleMenuOpen()));
		Assert.assertTrue(hp.getToggleMenuOpen().isDisplayed());
		logger.info("---> Toggle ham menu clicked");
		
		
		clickToggleHamMenu(hp);
		wait.until(ExpectedConditions.visibilityOf(hp.getWholesaleMenu()));
		hp.getWholesaleMenu().click();
		Assert.assertEquals(driver.getCurrentUrl(),headerUrlMap.get("wholesaleUrl"));			
		logger.info("---> Wholesale menu link clicked and page loaded successfully");
		
		clickToggleHamMenu(hp);		
		wait.until(ExpectedConditions.visibilityOf(hp.getBackToSchoolMenu()));
		hp.getBackToSchoolMenu().click();
		Assert.assertEquals(driver.getCurrentUrl(),headerUrlMap.get("backToSchoolUrl"));
		logger.info("---> Back to School store menu link clicked and page loaded successfully");
				
		clickToggleHamMenu(hp);
		wait.until(ExpectedConditions.visibilityOf(hp.getMonthAdMenu()));
		hp.getMonthAdMenu().click();
		Assert.assertEquals(driver.getCurrentUrl(),headerUrlMap.get("monthAdUrl"));
		logger.info("---> Monthly Ad menu link clicked and page loaded successfully");
		
		clickToggleHamMenu(hp);
		wait.until(ExpectedConditions.visibilityOf(hp.getNonProfitMenu()));
		hp.getNonProfitMenu().click();
		Assert.assertEquals(driver.getCurrentUrl(),headerUrlMap.get("nonProfitUrl"));
		// Taking screenshot of this menu click
		//Screenshots.save(driver);
		logger.info("---> For Nonprofits menu link clicked and page loaded successfully");
		
		clickToggleHamMenu(hp);
		wait.until(ExpectedConditions.visibilityOf(hp.getEducatorMenu()));
		hp.getEducatorMenu().click();
		Assert.assertEquals(driver.getCurrentUrl(),headerUrlMap.get("educatorUrl"));
		logger.info("---> For Educators menu link clicked and page loaded successfully");		
	
		clickToggleHamMenu(hp);
		wait.until(ExpectedConditions.visibilityOf(hp.getRetailersMenu()));
		hp.getRetailersMenu().click();
		Assert.assertEquals(driver.getCurrentUrl(),headerUrlMap.get("retailersUrl"));
		logger.info("---> For Retailers menu link clicked and page loaded successfully");
		
		clickToggleHamMenu(hp);
		wait.until(ExpectedConditions.visibilityOf(hp.getEmcPrepMenu()));
		hp.getEmcPrepMenu().click();
		Assert.assertEquals(driver.getCurrentUrl(),headerUrlMap.get("emcUrl"));
		logger.info("---> For Emergency Preparedness menu link clicked and page loaded successfully");
		
		clickToggleHamMenu(hp);
		wait.until(ExpectedConditions.visibilityOf(hp.getMyAccMenu()));
		hp.getMyAccMenu().click();
		Assert.assertEquals(driver.getCurrentUrl(),headerUrlMap.get("myAccountUrl"));
		logger.info("---> Your Account menu link clicked and page loaded successfully");
		
		clickToggleHamMenu(hp);
		wait.until(ExpectedConditions.visibilityOf(hp.getContactUsMenu()));
		hp.getContactUsMenu().click();
		Assert.assertEquals(driver.getCurrentUrl(),headerUrlMap.get("contactUsUrl"));
		logger.info("---> Contact Us menu link clicked and page loaded successfully");
		
		clickToggleHamMenu(hp);
		wait.until(ExpectedConditions.visibilityOf(hp.getFaqMenu()));
		hp.getFaqMenu().click();
		Assert.assertEquals(driver.getCurrentUrl(),headerUrlMap.get("faqUrl"));
		logger.info("---> FAQs menu link clicked and page loaded successfully");
		
		clickToggleHamMenu(hp);
		wait.until(ExpectedConditions.visibilityOf(hp.getReturnPolicyMenu()));
		hp.getReturnPolicyMenu().click();
		Assert.assertEquals(driver.getCurrentUrl(),headerUrlMap.get("returnPolicyUrl"));
		logger.info("---> Return Policy menu link clicked and page loaded successfully");
		
		clickToggleHamMenu(hp);
		wait.until(ExpectedConditions.visibilityOf(hp.getShipPolicyMenu()));
		hp.getShipPolicyMenu().click();
		Assert.assertEquals(driver.getCurrentUrl(),headerUrlMap.get("shippingPolicyUrl"));
		logger.info("---> Shipping Policy menu link clicked and page loaded successfully");		
		
	}
	
	
	/*
	 * 
	 * Asserting Search box in Dollardays.com homepage 
	 * 
	 */
	
	@Test(priority=2)
	
	public void assertSearchBar() throws InterruptedException {
		String searchWord;
		openBaseURL();
		driver.manage().window().maximize();	
		wait.until(ExpectedConditions.visibilityOf(hp.getSearchText()));
		for(String mapIndex : searchMap.keySet()) {
			searchWord = searchMap.get(mapIndex);	
			hp.getSearchText().sendKeys(searchWord);	
			Thread.sleep(1000);
			hp.getSearchButton().click();				
			logger.info("---> Searching the DollarDays portal for the product-"+searchWord);
			Screenshots.save(driver);	
			Thread.sleep(1000);
			hp.getSearchText().sendKeys(Keys.CONTROL+"a");
			Thread.sleep(1000);
			hp.getSearchText().sendKeys(Keys.DELETE);
					
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
