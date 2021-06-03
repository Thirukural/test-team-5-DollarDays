package com.dd.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindAll;

public class Homepage {


WebDriver driver;
//WebDriverWait wait;

public Homepage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public Homepage(WebDriver driver,WebDriverWait wait) {

PageFactory.initElements(driver, this);
//this.wait=wait;

}

/* using wait functionality
 * 
 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	 * "//input[@data-test-id='2015062201382406621763']"))) .sendKeys("01-005");
 */


//Home Page Locators

@FindBy(xpath="//a[@class='dropdown-toggle']//img[@class='header-user']")
private WebElement User_Dropdown_Toggle;

@FindBy(xpath="//a[@href='/logout.aspx'][@class='dropdown-item padditem margn-top']")
private WebElement User_Dropdown_Toggle_Signout;

@FindBy(xpath="//a[@class='dropdown-item'][@href='/myaccount/account.aspx']")
private WebElement User_Dropdown_Toggle_Accounts;


/*
 * 
 *  WebElements for Home page Header menu bar
 *  
 */


@FindBy(xpath="//*[@id=\'sm_menu_ham\']")
private WebElement toggleHamMenu;

@FindBy(xpath="//*[@id='aspnetForm']/header/div/div/div/div[1]/div/div[1]")
private WebElement toggleMenuOpen;

@FindBy(xpath="//*[@id=\'aspnetForm\']/header/div/div/div/div[1]/div/div[3]/div[2]/ul/li[1]/ul/li[1]/a")
private WebElement wholesaleMenu;

@FindBy(xpath="//*[@id=\'aspnetForm\']/header/div/div/div/div[1]/div/div[3]/div[2]/ul/li[1]/ul/li[2]/a")
private WebElement backToSchoolMenu;

@FindBy(xpath="//*[@id=\'aspnetForm\']/header/div/div/div/div[1]/div/div[3]/div[2]/ul/li[1]/ul/li[3]/a")
private WebElement monthAdMenu;

@FindBy(xpath="//*[@id=\'aspnetForm\']/header/div/div/div/div[1]/div/div[3]/div[2]/ul/li[19]/ul/li[1]/a")
private WebElement nonProfitMenu;

@FindBy(xpath="//*[@id='aspnetForm']/header/div/div/div/div[1]/div/div[3]/div[2]/ul/li[19]/ul/li[2]/a")
private WebElement educatorMenu;

@FindBy(xpath="//*[@id=\'aspnetForm\']/header/div/div/div/div[1]/div/div[3]/div[2]/ul/li[19]/ul/li[3]/a")
private WebElement retailersMenu;

@FindBy(xpath="//*[@id=\'aspnetForm\']/header/div/div/div/div[1]/div/div[3]/div[2]/ul/li[19]/ul/li[4]/a")
private WebElement emcPrepMenu;

@FindBy(xpath="//*[@id=\'aspnetForm\']/header/div/div/div/div[1]/div/div[3]/div[2]/ul/li[20]/ul/li[1]/a")
private WebElement myAccMenu;

@FindBy(xpath="//*[@id=\'aspnetForm\']/header/div/div/div/div[1]/div/div[3]/div[2]/ul/li[20]/ul/li[2]/a")
private WebElement contactUsMenu;

@FindBy(xpath="//*[@id=\'aspnetForm\']/header/div/div/div/div[1]/div/div[3]/div[2]/ul/li[20]/ul/li[3]/a")
private WebElement faqMenu;

@FindBy(xpath="//*[@id=\'aspnetForm\']/header/div/div/div/div[1]/div/div[3]/div[2]/ul/li[20]/ul/li[4]/a")
private WebElement returnPolicyMenu;

@FindBy(xpath="//*[@id=\'aspnetForm\']/header/div/div/div/div[1]/div/div[3]/div[2]/ul/li[20]/ul/li[5]/a")
private WebElement shipPolicyMenu;


/*
 * Homepage Searchbar web elements declaration
 */

@FindBy(name="terms")
private WebElement searchText;

@FindBy(xpath="//*[@id='aspnetForm']/header/div[2]/div/div/div[2]/div[1]/div[1]/div/div/button/i")
private WebElement searchButton;

/*
@FindBy(className ="btn btn-primary btn-search dd-search")
*/


/*
 * 
 * Homepage Shop by Category web elements declaration
 *  
 */

@FindAll(
		{
@FindBy(xpath = "//*[@id=\'aspnetForm\']/div[5]/div[2]/div[2]/div/div[2]/div[1]/a"),

@FindBy(xpath = "//*[@id=\'aspnetForm\']/div[5]/div[2]/div[2]/div/div[2]/div[2]/a"),

@FindBy (xpath = "//*[@id=\'aspnetForm\']/div[5]/div[2]/div[2]/div/div[2]/div[3]/a"),

@FindBy(xpath = "//*[@id=\'aspnetForm\']/div[5]/div[2]/div[2]/div/div[2]/div[4]/a"),

@FindBy (xpath = "//*[@id=\'aspnetForm\']/div[5]/div[2]/div[2]/div/div[2]/div[5]/a"),

@FindBy(xpath = "//*[@id=\'aspnetForm\']/div[5]/div[2]/div[2]/div/div[2]/div[6]/a"),

@FindBy (xpath = "//*[@id=\'aspnetForm\']/div[5]/div[2]/div[2]/div/div[2]/div[7]/a"),

@FindBy (xpath = "//*[@id=\'aspnetForm\']/div[5]/div[2]/div[2]/div/div[2]/div[8]/a"),
/*
@FindBy (xpath = "//*[@id=\'aspnetForm\']/div[5]/div[2]/div[2]/div/div[2]/div[9]/a"),

@FindBy (xpath = "//*[@id=\'aspnetForm\']/div[5]/div[2]/div[2]/div/div[2]/div[10]/a"),

@FindBy (xpath = "//*[@id=\'aspnetForm\']/div[5]/div[2]/div[2]/div/div[2]/div[11]/a"),

@FindBy (xpath = "//*[@id=\'aspnetForm\']/div[5]/div[2]/div[2]/div/div[2]/div[12]/a"),

@FindBy (xpath = "//*[@id=\'aspnetForm\']/div[5]/div[2]/div[2]/div/div[2]/div[13]/a"),

@FindBy (xpath = "//*[@id=\'aspnetForm\']/div[5]/div[2]/div[2]/div/div[2]/div[14]/a"),

@FindBy (xpath = "//*[@id=\'aspnetForm\']/div[5]/div[2]/div[2]/div/div[2]/div[15]/a"),

@FindBy (xpath = "//*[@id=\'aspnetForm\']/div[5]/div[2]/div[2]/div/div[2]/div[16]/a"),

@FindBy (xpath = "//*[@id=\'aspnetForm\']/div[5]/div[2]/div[2]/div/div[2]/div[17]/a"),

@FindBy (xpath = "//*[@id=\'aspnetForm\']/div[5]/div[2]/div[2]/div/div[2]/div[18]/a")
*/
		}

)
private List<WebElement> MultipleInputElements;

/*
 * Homepage Shop by Category web elements declaration  ends
 * 
 */

/*
 * Homepage Footer Link Locators-OurCompany web elements declaration  starts
 * 
 */


	

	// @FindBy(xpath="//*[@id=\"aspnetForm\"]/footer/div[2]/div[1]/div[2]/div/div[1]/div/ul/li[1]/a")
	@FindBy(linkText = ("Blog"))
	private WebElement blog;

	// @FindBy(xpath="//*[@id=\'aspnetForm\']/footer/div[1]/div[1]/div[2]/div/div[1]/div/ul/li[2]/a")
	@FindBy(linkText = ("About Us"))
	private WebElement aboutUs;

	// @FindBy(xpath="//*[@id=\'aspnetForm\']/footer/div[1]/div[1]/div[2]/div/div[1]/div/ul/li[3]/a")
	@FindBy(linkText = ("Careers"))
	private WebElement careers;

	// @FindBy(xpath="//*[@id=\'aspnetForm\']/footer/div[2]/div[1]/div[2]/div/div[1]/div/ul/li[4]/a")
	@FindBy(linkText = ("Partner with Us"))
	private WebElement partnerWithUs;

	// @FindBy(xpath="//*[@id=\'aspnetForm\']/footer/div[2]/div[1]/div[2]/div/div[1]/div/ul/li[5]/a")
	@FindBy(linkText = ("Wishlist Program"))
	private WebElement wishListProgram;

	// @FindBy(xpath="//*[@id=\'aspnetForm\']/footer/div[2]/div[1]/div[2]/div/div[1]/div/ul/li[6]/a")
	@FindBy(linkText = ("Business Benefits"))
	private WebElement businessBenefits;

	// @FindBy(xpath="//*[@id=\'aspnetForm\']/footer/div[2]/div[1]/div[2]/div/div[1]/div/ul/li[7]/a")
	@FindBy(linkText = ("Educator Benefits"))
	private WebElement educatorBenefits;

	// @FindBy(xpath="//*[@id=\'aspnetForm\']/footer/div[2]/div[1]/div[2]/div/div[1]/div/ul/li[8]/a")
	@FindBy(linkText = ("Nonprofit Benefits"))
	private WebElement nonProfitBenefits;



/*
 * Getter Method for Homepage Shop by Category web elements
 */


public List<WebElement> getMultipleInputElements() {
	
	return MultipleInputElements;
}

/*
 * Getter Methods for Shop By Category Web elements Ends
 */




/*
 * Get methods for Header Menu Items follows
 */

public WebElement getToggleHamMenu() {
	return toggleHamMenu;
}

public WebElement getToggleMenuOpen() {
	return toggleMenuOpen;
}

public WebElement getWholesaleMenu() {
	return wholesaleMenu;
}

public WebElement getBackToSchoolMenu() {
	return backToSchoolMenu;
}

public WebElement getMonthAdMenu() {
	return monthAdMenu;
}

public WebElement getNonProfitMenu() {
	return nonProfitMenu;
}

public WebElement getEducatorMenu() {
	return educatorMenu;
}

public WebElement getRetailersMenu() {
	return retailersMenu;
}

public WebElement getEmcPrepMenu() {
	return emcPrepMenu;
}

public WebElement getMyAccMenu() {
	return myAccMenu;
}

public WebElement getContactUsMenu() {
	return contactUsMenu;
}

public WebElement getFaqMenu() {
	return faqMenu;
}

public WebElement getReturnPolicyMenu() {
	return returnPolicyMenu;
}

public WebElement getShipPolicyMenu() {
	return shipPolicyMenu;
}

/*
 * Header Menu Search Bar web elements get method definition follows
 */

public WebElement getSearchText() {
	return searchText;
}

public WebElement getSearchButton() {
	return searchButton;
}


/*
 * End of Homepage header bar get method definitions.
 */
 
/*
 * Homepage Footer  web elements get method declarations.
 */
public WebElement getCareers() {
	return careers;
}

public WebElement getAboutUs() {
	return aboutUs;
}

public WebElement getBlog() {
	return blog;
}

public WebElement getPartnerWithUs() {
	return partnerWithUs;
}

public WebElement getWishListProgram() {
	return wishListProgram;
}

public WebElement getBusinessBenefits() {
	return businessBenefits;
}

public WebElement getEducatorBenefits() {
	return educatorBenefits;
}

public WebElement getNonprofitBenefits() {
	return nonProfitBenefits;
}


/* Quit pop-up window in the homepage screen
*
*/

@FindBy(xpath = "//*[@id=\'modal-nonregoffer\']/div/div/div/div[2]/div/h5/a")
private WebElement popupclose;

public WebElement getPopupClose() {
	return popupclose;
}







}