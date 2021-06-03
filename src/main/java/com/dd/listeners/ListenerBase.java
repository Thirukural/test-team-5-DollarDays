package com.dd.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.dd.framework.WebDriverThread;
import com.dd.util.Screenshots;


public class ListenerBase implements ITestListener {
	
	private static Logger logger = LogManager.getLogger(ListenerBase.class.getName());
	WebDriverThread driverThread = new WebDriverThread();
	
	@Override
	public void onTestFailure(ITestResult failingTest) {

		try {
		
			//ITestContext context = failingTest.getTestContext(); 	
			//WebDriver driver = (WebDriver) context.getAttribute("WebDriver");			
			System.out.println( ">>>>>>>>> TEST FAILS for <"+failingTest.getTestClass().getName()+"--"+failingTest.getName()+"> failed!!!");
			logger.info(">>>>>>>>> TEST FAILS for "+failingTest.getTestClass().getName()+"--"+failingTest.getName()+" failed!!!");
			Screenshots.save(driverThread.getDriver());
			driverThread.quitDriver();
			//Screenshots.take("Test Failure ", driver);
		} catch (Exception ex) {
			//System.err.println("Unable to capture screenshot...");
			ex.printStackTrace();
		}
		  
	}

	@Override
	public void onTestStart(ITestResult result) {
		logger.info( ">>>>>>>>> TEST EXECUTION  Started for..."+result.getTestClass().getName()+"--"+result.getName()+"...");
	}

	@Override
	public void onTestSuccess(ITestResult result) {		
		logger.info( ">>>>>>>>> TEST EXECUTION IS SUCCESSFUL for..."+result.getTestClass().getName()+"--"+result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger.info( ">>>>>>>>> SKIPPING TEST EXECUTION for..."+result.getTestClass().getName()+"--"+result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//System.out.println( ">>>>>>>>> TEST Start...");
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//System.out.println( ">>>>>>>>> TEST Finish...");
	}
}
