package com.dd.framework.drivers;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;

public class Chrome implements Browsers {

    private ChromeDriverService chromeDriverService;
    private final String operatingSystem = System.getProperty("os.name");
    @Override
    public RemoteWebDriver getWebDriverObject(MutableCapabilities desiredCapabilities) throws MalformedURLException {
    	
    //	if(operatingSystem.equalsIgnoreCase("linux"))
    //		System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver-64-linux");
    	System.out.println("operatingSystem----->"+operatingSystem);
    	if(operatingSystem.equalsIgnoreCase("Mac OS X")) {
            //System.setProperty("webdriver.chrome.driver","src//main//resources//chromedriver-64-mac");
            System.setProperty("webdriver.chrome.driver","src//main//resources//chromedriver-90");
    	  //  System.setProperty("webdriver.chrome.whitelistedIps", "");
    	}
    	else if (operatingSystem.equalsIgnoreCase("Linux")) {
    		System.out.println("Executing in Linux OS .......");
    		System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver-64-linux");
    		System.out.println("System property is set");
    	}
    	else
    		System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
    	
        startDriverService();
        if (runOnGrid()) {
        	
            return new RemoteWebDriver(new URL(HUB_URL), desiredCapabilities);
        } else {
            // Add the WebDriver proxy capability.
           //Proxy proxy = new Proxy();
           //proxy.setHttpProxy("localhost:8081");
           //desiredCapabilities.setCapability("proxy", proxy);        
            
            return new RemoteWebDriver(chromeDriverService.getUrl(), desiredCapabilities);
        }
    }

    public DesiredCapabilities getDesiredCapabilities() {
        HashMap<String,String> chromePreferences = new HashMap<>();
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        
        chromePreferences.put("profile.password_manager_enabled", "false");

        capabilities.setCapability("chrome.switches", Collections.singletonList("--no-default=browser-check"));
        capabilities.setCapability("chrome.prefs",chromePreferences);
        capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);

        return capabilities;
    }

    public ChromeOptions browserOptions(DesiredCapabilities desiredCapabilities) {
        final ChromeOptions chromeOptions = new ChromeOptions();

        //chromeOptions.setHeadless(Boolean.valueOf(System.getProperty("headless")));
        chromeOptions.addArguments("window-size=1080x720");
        chromeOptions.merge(desiredCapabilities);

        return chromeOptions;
    }

    @Override
    public void startDriverService() {
        if (Objects.isNull(chromeDriverService)) {
            try {
            	
            	String driverPath;
            	System.out.println("111111");
            	//if(operatingSystem.equalsIgnoreCase("linux"))
            		//driverPath = "src/main/resources/chromedriver-64-linux";
            	if(operatingSystem.equalsIgnoreCase("Mac OS X"))
            		driverPath = "src//main//resources//chromedriver-64-mac";
            	else if(operatingSystem.equalsIgnoreCase("Linux")){
            		System.out.println("before 2222");
            		driverPath = "src/main/resources/chromedriver-64-linux";  
            		System.out.println("after set driver path--->"+driverPath);
            	}
            	else
            		driverPath = "src/main/resources/chromedriver.exe";
            	System.out.println("3333");
            	System.out.println("after 3333 set driver path--->"+driverPath);
            	System.out.println("Path : " + System.getProperty("webdriver.chrome.driver"));
                chromeDriverService = new ChromeDriverService.Builder()
                        .usingDriverExecutable(new File(System.getProperty("webdriver.chrome.driver")))
                        .usingAnyFreePort()
                        .build();
                System.out.println("4444");
                chromeDriverService.start();
                System.out.println("5555");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void stopDriverService() {
        if (Objects.isNull(chromeDriverService)) {
            throw new NullPointerException("No Driver Service running at the moment");
        }
        chromeDriverService.stop();
    }
}
