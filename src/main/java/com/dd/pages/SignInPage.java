package com.dd.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;



public class SignInPage {
	WebDriver driver;
	WebDriverWait wait;

	public SignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * 
	 * Homepage Sign in  web elements and get method declarations
	 *  
	 */
	
	
	
	@FindBy(xpath = "//*[@id=\'aspnetForm\']/header/div[2]/div/div/div[3]/div/ul/li[1]")
	private WebElement signIn;

	public WebElement getSignIn() {
		return signIn;
	}
	
	//@FindBy(xpath = "//a[normalize-space(.)='Sign In']")
	@FindBy(xpath = "//*[@id='aspnetForm']/header/div[2]/div/div/div[3]/div/ul/li[1]/ul")//-dropdown
	private WebElement signIndropdown;

	public WebElement getSignInDropdown() {
		return signIndropdown;
	}
	
	
	@FindBy(xpath = "//*[@id='aspnetForm']/header/div[2]/div/div/div[3]/div/ul/li[1]/ul/li[2]/a")//--dropdownsignin
	                  //*[@id="aspnetForm"]/header/div[2]/div/div/div[3]/div/ul/li[1]/ul/li[2]/a
	private WebElement dropDownsignIn;
	
	public WebElement getDropdownSignIn() {
		return dropDownsignIn;
	}

	
	@FindBy(xpath = "//*[@id='inputLoginUsername']")
	private WebElement username;

	public WebElement getUsername() {
		return username;
	}

	@FindBy(xpath = "//*[@id='inputLoginPassword']")
	private WebElement password;

	public WebElement getPassword() {
		return password;
	}

	@FindBy(xpath = "//button[normalize-space(.)='Sign in']")
	private WebElement loginBtn;

	public WebElement getLoginBtn() {
		return loginBtn;
	}	
	
	@FindBy(xpath="//*[@id=\"aspnetForm\"]/header/div/div/div/div[3]/div/ul/li[1]/a/span")
	private WebElement userDrodown;

	public WebElement getUserDrodown() {
		return userDrodown;
	}	
	
	@FindBy(xpath = "//a[normalize-space(.)='Sign Out']")
	private WebElement logoutBtn;

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}	
	
	@FindBy(xpath="//*[@id=\'aspnetForm\']/header/div[2]/div/div/div[3]/div/ul/li[1]/a/span")
	private WebElement signedIn;
	
	public WebElement getSignedIn() {
		return signedIn;
	}
	
	@FindBy(xpath = "//*[@id=\"modal-nonregoffer\"]/div/div/div/div[2]/div/h5/a")
	
	private WebElement popupclose;

	public WebElement getPopupClose() {
		return popupclose;
}
	@FindBy(xpath = "//*[@id=\"aspnetForm\"]/div[5]/div/div/div/div[1]/div/div/div")
      
	private WebElement alertMessage;
	
	public WebElement getAlertMessage() {
		return alertMessage;
	}

}
	

