package com.automation.newati.pages;

import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.ButtonHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;


public class HomePage extends HomePage2 {

	private Logger logger = LogManager.getLogger(this.getClass());
	private BaseHandler baseHandler;
	private WindowHandler windowHandler;
	private ButtonHandler btnHandler;
	
	public HomePage(WebDriver webDriver) {
		super(webDriver);
		baseHandler = new BaseHandler(driver);
		windowHandler = new WindowHandler(driver);
		btnHandler = new ButtonHandler(driver);
	}
	
	/**
	 * Method used to click on Tab
	 * Home, MyATI, MyResults and Help
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	public void clickTab(int index) throws Exception {
		logger.info("Method: clickTab Starts");
    	try {
    		waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
    		List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.all.tabs"));
    		if(CollectionUtils.isNotEmpty(element)) {
    			List<WebElement> tabElement = element.get(0).findElements(By.cssSelector(PropertiesRepository.getString("new-atitesting.common.li")));
    			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
    			if(CollectionUtils.isNotEmpty(tabElement)) {
    				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tabElement.get(index));
    				tabElement.get(index).click();
    				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
    			}
    		}
    	} catch (Exception e) {
    		logger.info("Unable to click Tab" );
			log(logger, "Unable to click Tab" );
    		throw new DriverException("Unable to click Tab" , e); 
    	}
    	logger.info("Method: clickTab End " );
	}
	
	/**
	 * Method used to click on Tab
	 * Home, MyATI, MyResults and Help
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	public boolean verifyModalWindowFunctionality(int index) throws Exception {
		logger.info("Method: clickTab Starts");
		boolean flag = false;
    	try {
    		waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
    		List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.all.tabs"));
    		if(CollectionUtils.isNotEmpty(element)) {
    			List<WebElement> tabElement = element.get(0).findElements(By.cssSelector(PropertiesRepository.getString("new-atitesting.common.li")));
    			if(CollectionUtils.isNotEmpty(tabElement)) {
    				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tabElement.get(index));
    				tabElement.get(index).click();
    				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
    				
    			}
    		}
    	} catch (Exception e) {
    		logger.info("Unable to click elemnet for verifyModalWindowFunctionality " );
			log(logger, "Unable to click elemnet for verifyModalWindowFunctionality " );
			flag = true;
    	}
    	logger.info("Method: clickTab End flag --> " + flag );
    	return flag;
	}
	
	/**
	 * Method used to click on Tab
	 * Home, MyATI, MyResults and Help
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	public void clickSubTab(int index) throws Exception {
		logger.info("Method: clickTab Starts");
    	try {
    		waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
    		List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.myati.improve.tab.loc"));
    		if(CollectionUtils.isNotEmpty(element)) {
    			element.get(index).click();
    				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
    		}
    	} catch (Exception e) {
    		logger.info("Unable to click Tab" );
			log(logger, "Unable to click Tab" );
    		throw new DriverException("Unable to click Tab" , e); 
    	}
    	logger.info("Method: clickTab End " );
	}

	public boolean verifyRecentActivity(String recentActivityName) {
	
		List<WebElement> productName = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.hometab.recent.activity.name"));
		if(CollectionUtils.isNotEmpty(productName))
		{
			String name = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerHTML;",productName.get(0));
			
			if(recentActivityName.trim().equals(name.trim()))
			{
				return true; 
			}
		}
		
		return false;
	}
	
	public boolean verifyRecentActivity1(String recentActivityName) {
		List<WebElement> productName = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.hometab.recent.activity.name"));
		if(CollectionUtils.isNotEmpty(productName))
		{
				return true; 
		}
		
		return false;
	}
	
	public boolean verifyRecentActivityPresentStatus()
	 {
	  List<WebElement> inprogressList = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.hometab.recent.activity.statusinprogress"));
	  List<WebElement> elements = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.hometab.recent.activity.completed.status"));
	  System.out.println(elements.get(0).getText());
	  if(CollectionUtils.isNotEmpty(inprogressList))
	  {
	   if("IN PROGRESS".equals(inprogressList.get(0).getText()))
	   {
	    return true;
	   }
	  }
	  else
	   {
	    if(CollectionUtils.isNotEmpty(elements) &&"COMPLETED SCORE".equals(elements.get(0).getText()))
	    {
	     return true;
	    }
	   
	   }
	  
	  return false;
	 }
	
	/**
	 * Method used to verify footer value.
	 *  
	 * @author saravanan.jothimani
	 * @return
	 * @throws Exception
	 */
	public boolean verifyFooter() throws Exception {
		logger.info("Method: verifyFooter Starts");
		boolean flag = false;
    	try {
    		String expectedValue = PropertiesRepository.getString("new-atitesting.footer.value")+", "+PropertiesRepository.getString("new-atitesting.footer.another.value");
    		List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.footer.loc"));
    		if(CollectionUtils.isNotEmpty(element)) {
    			if(element.get(0).getText().equalsIgnoreCase(expectedValue)) {
    				flag = true;
    			}
    		}
    	} catch (Exception e) {
    		logger.info("Unable to verify Footer");
			log(logger, "Unable to verify Footer" );
    		throw new DriverException("Unable to verify Footer" , e); 
    	}
    	logger.info("Method: verifyFooter End flag --> " + flag);
    	return flag;
	}
	
	public boolean verifyLogo(String loc) {

		boolean displayed = baseHandler.isDisplayed(PropertiesRepository
				.getString(loc));
		if (displayed) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Method used to verify Home Top Links
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean verifyHomeTabTopLinks() throws Exception {
		logger.info("Method: verifyHomeTabTopLinks Starts");
		boolean flag = false;
		try {
			List<WebElement> elements = baseHandler
					.findElements(PropertiesRepository
							.getString("new-atitesting.hometab.upper.links.loc"));
			if (CollectionUtils.isNotEmpty(elements)
					&& elements.size() == 4
					&& PropertiesRepository.getString(
							"new-atitesting.toplink.online.store.name").equals(
							elements.get(1).getText())
					&& PropertiesRepository.getString(
							"new-atitesting.toplink.contact.us.name").equals(
							elements.get(2).getText())
					&& elements.get(0).getText().contains(PropertiesRepository.getString(
							"new-atitesting.users.account.link"))
					&& PropertiesRepository.getString(
							"new-atitesting.toplink.sign.out").equals(
							elements.get(3).getText())) {
				flag = true;				
			}
		} catch (Exception e) {
			logger.info("Unable to verify Home Tab Top Links");
			log(logger, "Unable to verify Home Tab Top Links");
			throw new DriverException("Unable to verify Home Tab Top Links", e);
		}
		logger.info("Method: verifyHomeTabTopLinks End");
		return flag;
	}

	/**
	 * Method used to verify Home Bottom Links
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean verifyHomeTabBottomLinks() throws Exception {
		logger.info("Method: verifyHomeTabBottomLinks Starts");
		boolean flag = false;
		try {
			List<WebElement> elements = baseHandler
					.findElements(PropertiesRepository
							.getString("new-atitesting.hometab.bottom.links.loc"));
			if (CollectionUtils.isNotEmpty(elements)
					&& PropertiesRepository.getString(
							"new-atitesting.bottom.link.privacy.policy")
							.equalsIgnoreCase(elements.get(0).getText())
					&& PropertiesRepository.getString(
							"new-atitesting.bottom.link.website")
							.equalsIgnoreCase(elements.get(1).getText())
					&& PropertiesRepository.getString(
							"new-atitesting.bottom.link.terms.of.use")
							.equalsIgnoreCase(elements.get(2).getText())
					&& PropertiesRepository.getString(
							"new-atitesting.bottom.link.product.solutions.new")
							.equalsIgnoreCase(elements.get(4).getText())) {
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to verify Home Tab Bottom Links");
			log(logger, "Unable to verify Home Tab Bottom Links");
			throw new DriverException("Unable to verify Home Tab Bottom Links",
					e);
		}
		logger.info("Method: verifyHomeTabBottomLinks End flag-->"+flag);
		return flag;
	}

	/**
	 * Method used to verify Home tab Links
	 * 
	 * @return
	 * @throws Exception
	 */

	public boolean verifyHomeTabLinks() throws Exception {
		logger.info("Method: verifyHomeTabLinks Starts");
		boolean flag = false;
		try {
			List<WebElement> elements = baseHandler
					.findElements(PropertiesRepository
							.getString("new-atitesting.hometab.main.tab.links"));
			if (CollectionUtils.isNotEmpty(elements)
					&& PropertiesRepository.getString(
							"new-atitesting.home.tab.link").equalsIgnoreCase(
							elements.get(0).getText())
					&& PropertiesRepository.getString(
							"new-atitesting.myati.tab.link").equalsIgnoreCase(
							elements.get(1).getText())
					&& PropertiesRepository.getString(
							"new-atitesting.myresults.tab.link")
							.equalsIgnoreCase(elements.get(2).getText())
					&& PropertiesRepository.getString(
							"new-atitesting.help.tab.link").equalsIgnoreCase(
							elements.get(3).getText())) {
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to verify Home Tab Links");
			log(logger, "Unable to verify Home Tab Links");
			throw new DriverException("Unable to verify Home Tab Top Links", e);
		}
		logger.info("Method: verifyHomeTabLinks End");
		return flag;
	}

	public void enterIdAndClickContinueButton(String id) throws Exception {
		
		List<WebElement> elements = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.add.product.id.loc"));
		if(CollectionUtils.isNotEmpty(elements))
		{
			elements.get(0).clear();
			elements.get(0).sendKeys(id);
			List<WebElement> elements1 = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.add.product.continue.button.loc"));
			elements1.get(0).click();
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		}
		
	}

	public void enterIdAndPassword(String id,String pwd) throws Exception {

		List<WebElement> elements = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.add.product.id.pwd"));
		if(CollectionUtils.isNotEmpty(elements))
		{
			elements.get(0).clear();
			elements.get(0).sendKeys(id);
			List<WebElement> elements1 = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.add.product.continue.button.loc"));
			elements1.get(0).click();
			waitUntillOverlayImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			elements.get(1).clear();
			elements.get(1).sendKeys(pwd);
			elements1.get(0).click();
			waitUntillOverlayImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		}
		
	}
	
	public void SignOut() throws DriverException, InterruptedException
	{
		logger.info("Clicking on logot button");
		Thread.sleep(4000);
		baseHandler.findElement(PropertiesRepository.getString("new-atitesting.logout.loc")).click();
	}
	

	public void click(String str) throws Exception {
		baseHandler.findElement(str).click();
	}
	

	public void VerifyHomePageElements() throws Exception {
		
		VerificationHandler.verifyEquals("Aditya Singh's Account", baseHandler.findElement(PropertiesRepository.getString("new-atitesting.homepage.my.account.loc")).getText());
		VerificationHandler.verifyEquals("Online Store", baseHandler.findElement(PropertiesRepository.getString("new-atitesting.homepage.online.store.loc")).getText());
		VerificationHandler.verifyEquals("Contact Us", baseHandler.findElement(PropertiesRepository.getString("new-atitesting.homepage.contact.us.loc")).getText());
		VerificationHandler.verifyEquals("Sign Out", baseHandler.findElement(PropertiesRepository.getString("new-atitesting.homepage.sign.out.loc")).getText());
	}
	/*
	public void VerifyHomePageNews(String newsHeading, String news1, String news2, String news3 ) throws Exception {
		
		VerificationHandler.verifyEquals(newsHeading, baseHandler.findElement(PropertiesRepository.getString("new-atitesting.homepage.news.section.loc")).getText());
		VerificationHandler.verifyEquals(news1, baseHandler.findElement(PropertiesRepository.getString("new-atitesting.homepage.news.section.link1.loc")).getText());
		VerificationHandler.verifyEquals(news2, baseHandler.findElement(PropertiesRepository.getString("new-atitesting.homepage.news.section.link2.loc")).getText());
		VerificationHandler.verifyEquals(news3, baseHandler.findElement(PropertiesRepository.getString("new-atitesting.homepage.news.section.link3.loc")).getText());
	}
	*/
	public void VerifyOnlineStoreLink() throws Exception {
		
		click(PropertiesRepository.getString("new-atitesting.homepage.online.store.loc"));
		
		windowHandler.switchToLatestWindow();
		Thread.sleep(20000);
		
//		VerificationHandler.verifyEquals("View Cart", baseHandler.findElement(PropertiesRepository.getString("new-atitesting.ati.store.loc.new")).getText());
	}
	
	public boolean verifyAddProductPopup() throws Exception {
		
		return(driver.findElement(By.cssSelector("#ui-id-6")).isDisplayed());
		
	}
	
		public boolean verifyAddProductPopupInLearnTab() throws Exception {
		
		return(driver.findElement(By.cssSelector(".add-product-step-1>section>h1")).isDisplayed());
		
	}
	/**
	 * To verify if the Pulse Banner is displayed
	 * @author Syed.pasha
	 * @return True if Pulse Banner is displayed
	 * @throws Exception 
	 */
	public boolean VerifyIfPulseBannerDiaplayed() throws Exception {
		logger.info("Method: VerifyIfPulseBannerDiaplayed Starts");
		boolean flag = false;
		try {
			flag = baseHandler.findElement(PropertiesRepository.getString("new-atitesting.homepage.puse.banner.loc")).isDisplayed();
		} catch (Exception e) {
			logger.info("Pulse banner is not Displayed");
			log(logger, "Pulse banner is not Displayed");
			throw new DriverException("Pulse banner is not Displayed", e);
		}
		logger.info("Method: VerifyIfPulseBannerDiaplayed Ends");
		return flag;
	}
	
	/**
	 * To verify if the Pulse Banner Speedometer is displayed
	 * @author Syed.pasha
	 * @return True if Pulse Banner Speedometer is displayed
	 * @throws Exception 
	 */
	public boolean VerifyIfPulseBannerSpeedometerDiaplayed() throws Exception {
		logger.info("Method: VerifyIfPulseBannerSpeedometerDiaplayed Starts");
		boolean flag = false;
		try {
			flag = baseHandler.findElement(PropertiesRepository.getString("new-atitesting.homepage.puse.banner.spedometer.loc")).isDisplayed();
		} catch (Exception e) {
			logger.info("Pulse banner Speedometer is not Displayed");
			log(logger, "Pulse banner Speedometer is not Displayed");
			throw new DriverException("Pulse banner Speedometer is not Displayed", e);
		}
		logger.info("Method: VerifyIfPulseBannerSpeedometerDiaplayed Ends");
		return flag;
	}
	
	/**
	 * To verify if actual and expected text are equal
	 * @author Syed.pasha
	 * @return True if actual and expected text are equal
	 * @throws Exception 
	 */
	public boolean VerifyIfActualAndExpectdTexEqual(String actualTextLoc , String expectedText) throws Exception {
		logger.info("Method: VerifyIfActualAndExpectdTexEqual Starts");
		boolean flag = false;
		try {
			String actualtext = baseHandler.findElement(PropertiesRepository.getString(actualTextLoc)).getText();
			if(actualtext.contains(PropertiesRepository.getString(expectedText)))
			{
				
				flag=true;
			}
		} catch (Exception e) {
			logger.info("actual and expected text are not equal");
			log(logger, "actual and expected text are not equal");
			throw new DriverException("actual and expected text are not equal", e);
		}
		logger.info("Method: VerifyIfActualAndExpectdTexEqual Ends");
		return flag;
	}
	
	/**
	 * To verify if actual and expected text are equal using element index
	 * @author Syed.pasha
	 * @return True if actual and expected text are equal
	 * @throws Exception 
	 */
	public boolean VerifyIfActualAndExpectdTexEqual(String actualTextLoc ,int index , String expectedText) throws Exception {
		logger.info("Method: VerifyIfActualAndExpectdTexEqual Starts");
		boolean flag = false;
		String actualtext = null;
		try {
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString(actualTextLoc));
    		if(CollectionUtils.isNotEmpty(element)) {
    			actualtext = element.get(index).getText();
    			System.out.println(actualtext);
    		}
			flag = actualtext.equals(PropertiesRepository.getString(expectedText));
		} catch (Exception e) {
			logger.info("actual and expected text are not equal");
			log(logger, "actual and expected text are not equal");
			throw new DriverException("actual and expected text are not equal", e);
		}
		logger.info("Method: VerifyIfActualAndExpectdTexEqual Ends" +flag);
		return flag;
	}
	
	/**
	 * To Verify 'Step 1 :I Forgot my...', 'Username button', 'Password button', 'Close button' 
	 * @author Syed.pasha
	 * @return boolean
	 * @throws Exception 
	 */
	public boolean VerifyModelElements() throws Exception {
		logger.info("Method: VerifyModelElements Starts");
		boolean flag = false;
		try {			
			if (VerifyIfActualAndExpectdTexEqual("new-atitesting.homepage.forgot.pass.usename.poup.step.loc", 0,
					"new-atitesting.homepage.forgot.pass.usename.poup.step1")
					&& baseHandler.findElement("a[data-atiid='forgotUsernameAction']").isDisplayed()
					&& baseHandler.findElement("a[data-atiid='forgotPasswordAction']").isDisplayed()
					&& baseHandler
							.findElement(
									"div[aria-describedby='ForgotPasswordDialog'] div button")
							.isDisplayed()) {
				flag = true;
			}				
		} catch (Exception e) {
			logger.info("Cannot VerifyModelElements");
			log(logger, "Cannot VerifyModelElements");
			throw new DriverException("Cannot VerifyModelElements", e);
		}
		logger.info("Method: VerifyModelElements Ends");
		return flag;
	}
	
	/**
	 * To verify 'Step 2 :Enter Your email address', 'Email address edit box', 'Continue button', 'Close button' 
	 * @author Syed.pasha
	 * @return boolean
	 * @throws Exception 
	 */
	public boolean VerifyModelElementsInUsernameSection() throws Exception {
		logger.info("Method: VerifyModelElementsInUsernameSection Starts");
		boolean flag = false;
		try {			
			if (VerifyIfActualAndExpectdTexEqual("new-atitesting.homepage.forgot.pass.usename.poup.step.loc", 1,
					"new-atitesting.homepage.forgot.pass.usename.poup.step2")
					&& baseHandler.findElement("input[data-atiid='forgotUsernameEmail']").isDisplayed()
					&& baseHandler.findElement("#pwdOrUsnameID").isDisplayed()
					&& baseHandler
							.findElement(
									"div[aria-describedby='ForgotPasswordDialog'] div button")
							.isDisplayed()) {
				flag = true;
			}				
		} catch (Exception e) {
			logger.info("Cannot VerifyModelElements in username Section");
			log(logger, "Cannot VerifyModelElements in username Section");
			throw new DriverException("Cannot VerifyModelElements in username Section", e);
		}
		logger.info("Method: VerifyModelElementsInUsernameSection Ends");
		return flag;
	}
	
	/**
	 * To Verify 'Step 2 :Enter Your Username', 'Username edit box', 'label saying Reset your password by:', 'Answering security questions radio button', 'Email radio button', 'Continue button'
	 * @author Syed.pasha
	 * @return boolean
	 * @throws Exception 
	 */
	public boolean VerifyModelElementsInPasswordSection() throws Exception {
		logger.info("Method: VerifyModelElementsInPasswordSection Starts");
		boolean flag = false;
		try {			
			if (VerifyIfActualAndExpectdTexEqual("new-atitesting.homepage.forgot.pass.pass.poup.step.loc", 0,
					"new-atitesting.homepage.forgot.pass.pass.poup.step2")
					&& baseHandler.findElement(".sign-in-step-password input[data-atiid='forgotPasswordUsername']").isDisplayed()
					&& baseHandler.findElement(".sign-in-step-password>p").getText().equals("Reset your password by:")
					&& baseHandler.findElement("#securityChoice").isDisplayed()
					&& baseHandler.findElement("#emailChoice").isDisplayed()					
					&& baseHandler.findElement("a[data-atiid='forgotPasswordAction1']").isDisplayed()){
				flag = true;
			}				
		} catch (Exception e) {
			logger.info("Cannot VerifyModelElements in Password Section");
			log(logger, "Cannot VerifyModelElements in Password Section");
			throw new DriverException("Cannot VerifyModelElements in Password Section", e);
		}
		logger.info("Method: VerifyModelElementsInPasswordSection Ends");
		return flag;
	}
	
	/**
	 * To Verify Status category · 90% - 99% 'On Track' , 80% - 89% 'Needs Improvement' , 79% or below 'At Risk' 
	 * @author Syed.pasha
	 * @return True if category is right
	 * @throws Exception 
	 */
	public boolean VerifyStatusCategory(String score, String statusLocator) throws Exception {
		logger.info("Method: VerifyStatusCategory Starts");
		boolean flag = false;
		try {
			String actualStatus = baseHandler.findElement(PropertiesRepository.getString(statusLocator)).getText();
			int intScore = Integer.parseInt(PropertiesRepository.getString(score));
			if(intScore <= 79)
			{
				flag = actualStatus.equals("At Risk");
			}
			else if(intScore >= 80 && intScore <= 89)
			{
				flag = actualStatus.equals("Needs Improvement");
			}
			else if(intScore >= 90 && intScore <= 99)
			{
				flag = actualStatus.equals("On Track");
			}			
		} catch (Exception e) {
			logger.info("Status does not fall under right category");
			log(logger, "Status does not fall under right category");
			throw new DriverException("Status does not fall under right category", e);
		}
		logger.info("Method: VerifyStatusCategory Ends");
		return flag;
	}
	
	public void pressEscapeKey(){
		Actions builder = new Actions(driver);
		builder.sendKeys(Keys.ESCAPE).perform();
	}
	/**
	 * Method used to verify alert displayed or not. 
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean VerifyAlertDiaplayed() throws Exception {
		logger.info("Method: VerifyAlertDiaplayed Starts");
		boolean flag = false;
		try {
			List<WebElement> elemnet = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.homepage.alert.loc"));
			if(CollectionUtils.isNotEmpty(elemnet) && elemnet.get(0).isDisplayed()) {
				flag = true;
			}
			//flag = baseHandler.findElement(PropertiesRepository.getString("new-atitesting.homepage.alert.loc")).isDisplayed();
		} catch (Exception e) {
			logger.info("Alert is not Displayed");
			log(logger, "Alert is not Displayed");
			throw new DriverException("Alert is not Displayed", e);
		}
		logger.info("Method: VerifyIfPulseBannerDiaplayed Ends flag --> " + flag);
		return flag;
	}

	/**
	 * Method used to scroll up. 
	 * 
	 * 
	 * @throws Exception
	 */
	public void scrollUpPage() throws Exception {
		logger.info("scrollUpPage Start");
		try {
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
		} catch (Exception e) {
			logger.info("Unable to scrollUpPage");
			log(logger, "Unable to scrollUpPage");
			throw new DriverException("Unable to scrollUpPage", e);
		}
		logger.info("scrollUpPage End");
	}
	
	/**
	 * Method used to scroll up. 
	 * 
	 * 
	 * @throws Exception
	 */
	public void scrollDownPage() throws Exception {
		logger.info("scrollDownPage Start");
		try {
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		} catch (Exception e) {
			logger.info("Unable to scrollDownPage");
			log(logger, "Unable to scrollDownPage");
			throw new DriverException("Unable to scrollDownPage", e);
		}
		logger.info("scrollDownPage End");
	}

	/**
	 * To verify if the Pulse Banner is displayed
	 * 
	 * @author Sasmita
	 * @return True if ViewDetailsPage is displayed
	 * @throws DriverException
	 * @throws Exception
	 */
	public boolean verifyViewDetailsPage() throws InterruptedException, DriverException {
		logger.info("Method: verifyViewDetailsPage Starts");
		boolean flag = false;
		try {
			driver.switchTo().frame("predictFrame2");
			List<WebElement> viewDetailsPage = baseHandler.findElements(
					PropertiesRepository.getString("new-atitesting.homepage.full.page.viewDetails.page.loc"));
			if (CollectionUtils.isNotEmpty(viewDetailsPage) && viewDetailsPage.get(0).isDisplayed()) {
				flag = true;
			}
			windowHandler.switchToMainWindow();
		} catch (Exception e) {
			windowHandler.switchToMainWindow();
			logger.info("Error in verifyViewDetailsPage");
			log(logger, "Error in verifyViewDetailsPage");
			throw new DriverException("Error in verifyViewDetailsPage", e);
		}

		logger.info("Method: verifyViewDetailsPage Ends flag-- > " + flag);
		return flag;
	}
	
	public void clickOnCloseButtonInViewDetailspage() {
		logger.info("METHOD : clickOnCloseButtonInViewDetailspage start");
		try {
			((JavascriptExecutor) driver).executeScript("$('.ui-button-text').click();");
		} catch (Exception e) {
			logger.error("FAILED TO click by Javascript \n METHOD :clickByJavascript", e);
		}
		logger.info("METHOD : clickOnCloseButtonInViewDetailspage End");
	}
	
	/**
	 * To verify Tutorial in recentActivity section 
	 * @author Syed.pasha
	 * @return True if Tutorial in recentActivity section displayed
	 * @throws Exception 
	 */
	public boolean verifyTutorailsLinkNamesInRecentActivitySection(String loc) {
		logger.info("Method: verifyTutorailsLinkNamesInRecentActivitySection Starts");
		try {
			List<WebElement> elements = baseHandler.findElements(PropertiesRepository.getString(loc));
			for(int i=0;i<elements.size();i++)
			{
			if(CollectionUtils.isNotEmpty(elements) && "Flash Cards".contains(elements.get(i).getText()) &&
					"SmartPrep".contains(elements.get(i).getText()) &&
							"Skills Modules 2.0".contains(elements.get(i).getText())&&
									"NurseLogic 2.0".contains(elements.get(i).getText()))
							{
						return true;
			}		}
		} catch (Exception e) {
			logger.info("element is not visible");
		}
		logger.info("Method: verifyTutorailsLinkNamesInRecentActivitySection Ends");
		return false;
		
	}
	public void enterTextInAttributeValue(String locator, String text)
			throws Exception {
		logger.info("Method: enterTextFromAttribute Starts");
		try {
			WebElement element = baseHandler.findElement(PropertiesRepository
					.getString(locator));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(
					"arguments[0].setAttribute('value', arguments[1])",
					element, text.trim());
		} catch (Exception e) {
			logger.info("Unable to enter Text " + text);
			log(logger, "Unable to enter Text " + text);
			throw new DriverException("Unable to enter Text " + text, e);
		}
		logger.info("Method: enterTextFromAttribute End");
	}
	/**
	 * Click on system admin method
	 
	
	 * @throws Exception 
	 */
	public void clickSystemAdmin(String menuName) throws Exception {
		logger.info("Method: clickMenu " + menuName + " Starts");
		try {
			WebElement menuElement = baseHandler
					.findElement(PropertiesRepository.getString("new-atitesting.mu.main.menu.loc"));
			menuElement.click();
			/*
			 * Actions act = new Actions(driver);
			 * act.moveToElement(menuElement).build().perform();
			 */
		} catch (Exception e) {
			logger.info("Unable to click Menu");
			log(logger, "Unable to click Menu");
			throw new DriverException("Unable to click Menu", e);
		}
		logger.info("Method: clickMenu " + menuName + " End ");
	}
	public void clickMenuFromSystemAdmnstrtn(String menuName) throws Exception {
		logger.info("Method: clickMenuFromSystemAdmnstrtn " + menuName + " Starts");
		String baseUrl = PropertiesRepository.getString("newati.stage.login.mu.url");
		try {
			List<WebElement> menuElement = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.mu.sys.admn.menu.loc"));

			if (CollectionUtils.isNotEmpty(menuElement)) {
				int size = menuElement.size();
				for (int index = 0; index < size; index++) {
					if (menuElement.get(index).getText().trim().equalsIgnoreCase(menuName)) {
						menuElement.get(index).click();
						break;
					}
				}
			}
			String homeUrl = baseUrl.split("://")[1] + "main.aspx";
			if (driver.getCurrentUrl().split("://")[1].equalsIgnoreCase(homeUrl)) {
				logger.info("Unable to click menu under System Administration " + menuName
						+ ". So directly accessing the url ");
				log(logger, "Unable to click menu under System Administration " + menuName
						+ ". So directly accessing the url ");
				if (menuName.equalsIgnoreCase("Management Utility"))
					driver.get(baseUrl + "personnel/default.aspx");
				else if (menuName.equalsIgnoreCase("TestMaker Utility"))
					driver.get(baseUrl + "testmaker/Menu.aspx");
				else if (menuName.equalsIgnoreCase("Site Monitor"))
					driver.get(baseUrl + "personnel/SiteMonitor.aspx");
				else if (menuName.equalsIgnoreCase("News Tab Editor"))
					driver.get(baseUrl + "sitemanagement/NewsTabEditor.aspx");
				else if (menuName.equalsIgnoreCase("Password Access History"))
					driver.get(baseUrl + "personnel/ViewAccessLog.aspx");

			}
		} catch (Exception e) {
			logger.info("Unable to click menu under System Administration " + menuName);
			log(logger, "Unable to click menu under System Administration " + menuName);
			throw new DriverException("Unable to click menu under System Administration " + menuName, e);
		}
		logger.info("Method: clickMenuFromSystemAdmnstrtn " + menuName + " End ");
	}
	public void clickMenuFromMgmtUtility(String menuName) throws Exception {
		logger.info("Method: clickMenuFromMgmtUtility Starts");
		try {
			List<WebElement> menuElement = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.mu.mgmt.utility.menu.loc"));
			if (CollectionUtils.isNotEmpty(menuElement)) {
				int size = menuElement.size();
				for (int index = 0; index < size; index++) {
					WebElement menu = menuElement.get(index);
					if (menu.getText().trim().equalsIgnoreCase(menuName)) {
						menu.click();
						break;
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to click Mgmt Utility");
			log(logger, "Unable to click Mgmt Utility");
			throw new DriverException("Unable to click Mgmt Utility", e);
		}
		logger.info("Method: clickMenuFromMgmtUtility End ");
	}
	public void clickGoButton() throws Exception {
		logger.info("Method: clickGoButton Starts");
		try {
			btnHandler.clickButton(
							PropertiesRepository
									.getString("new-atitesting.mu.users.go.button.loc"),
							PropertiesRepository
									.getStringAsArray("new-atitesting.mu.users.table.load.loc"));
		} catch (Exception e) {
			logger.info("Unable to click Go Button");
			log(logger, "Unable to click Go Button");
			throw new DriverException("Unable to click Go Button", e);
		}
		logger.info("Method: clickGoButton End ");
	}
	public void clickOnRowLink(String loc, int size) throws Exception {
		logger.info("Method: clickOnRowLink Starts");
		try {
			List<WebElement> usersTable = baseHandler
					.findElements(PropertiesRepository.getString(loc));
			if (CollectionUtils.isNotEmpty(usersTable) && usersTable.size() > 0) {
				usersTable.get(size).click();
			}
		} catch (Exception e) {
			logger.info("Unable to clickOnRowLink");
			log(logger, "Unable to clickOnRowLink");
			throw new DriverException("Unable to clickOnRowLink", e);
		}
		logger.info("Method: clickOnRowLink End ");
	}
	
	/**
	 * Verify link using index 
	 * @author Syed.pasha
	 * @return True if Tutorial in recentActivity section displayed
	 * @throws Exception 
	 */
	public boolean verifyLinkUsingIndex(String loc , int index) {
		boolean flag = false;
		logger.info("Method: verifyLinkUsingIndex Starts");
		try {
			List<WebElement> elements = baseHandler.findElements(loc);
			flag = elements.get(index).isDisplayed();			
		} catch (Exception e) {
			logger.info("element is not visible");
		}
		logger.info("Method: verifyLinkUsingIndex Ends");
		return flag;
		
	}
	
	/**
	 * Verifying if 'User Account' 'Online Store' ' Contact Us' links at the top will not be functional links 
	 * @author Syed.pasha
	 * @throws Exception 
	 */
	public boolean verifyInactiveLinks() {
		boolean flag = false;
		logger.info("Method: verifyInactiveLinks Starts");
		try {
			List<WebElement> elements = baseHandler.findElements(".secondary-nav>ul>li a");
			if((elements.get(0).getAttribute("class").contains("default-button-disabled")) &&  (elements.get(1).getAttribute("class").contains("default-button-disabled")) && (elements.get(2).getAttribute("class").contains("default-button-disabled"))){
				flag = true;
			}
					
		} catch (Exception e) {
			logger.info("All links are not inactive");
		}
		logger.info("Method: verifyInactiveLinks Ends");
		return flag;
		
	}

	/**
	 * To verify that Privacy Policy page is opened 
	 * 
	 * @author Vishal
	 * @return True if Privacy Policy is opened
	 * @throws Exception 
	 */
	public boolean verifyPrivacyPolicyPage() throws Exception {
		logger.info("Method: verifyverifyPrivacyPolicyPage Starts");
		boolean flag = false;
		try {
			windowHandler.switchToLatestWindow();
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.privacypolicy"));
			if (CollectionUtils.isNotEmpty(element)) {
				flag = element.get(0).getText()
						.equalsIgnoreCase(PropertiesRepository.getString("new-atitesting.footer.privacy.policy.name"));
			}
		} catch (Exception e) {
			logger.info("Unable to verifyPrivacyPolicyPage");
			log(logger, "Unable to verifyPrivacyPolicyPage");
			throw new DriverException("Unable to verifyPrivacyPolicyPage", e);
		}
		logger.info("Method: verifyverifyPrivacyPolicyPage Ends flag --> " + flag);
		return flag;
	}
	
	/**
	 * To verify that User Terms and Conditions page is opened 
	 * 
	 * @author Vishal
	 * @return True if User Terms and Conditions Link is opened
	 * @throws Exception 
	 */
	public boolean verifyUserTermsAndConditionsPage() throws Exception {
		logger.info("Method: verifyUserTermsAndConditionsPage Starts");
		boolean flag = false;
		try {
			windowHandler.switchToLatestWindow();
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.user.terms.and.conditions.header.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				flag = element.get(0).getText()
						.equalsIgnoreCase(PropertiesRepository.getString("new-atitesting.user.terms.and.conditions.header.content"));
			}
		} catch (Exception e) {
			logger.info("Unable to verifyUserTermsAndConditionsPage");
			log(logger, "Unable to verifyUserTermsAndConditionsPage");
			throw new DriverException("Unable to verifyUserTermsAndConditionsPage", e);
		}
		logger.info("Method: verifyUserTermsAndConditionsPage Ends flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to click on Recent Activity based on Product Type and Product Name and must be in In Progress State. 
	 * 
	 * @param productType
	 * @param productName
	 * @return
	 */
	public boolean verifyAndClickRecentActivity(String locator, String productType, String productName, String assessmentStatus) throws Exception {
		logger.info("verifyAndClickRecentActivity Start");
		boolean flag = false;
		try {
			List<WebElement> recentActivityElement = baseHandler.findElements(".ra-row.rb-col-main.focus-element-flag");
			if(CollectionUtils.isNotEmpty(recentActivityElement))
			{
				int size = recentActivityElement.size();
				for(int index = 0; index < size; index ++) {
					// Taking individual Recent Activity Row.
					WebElement individualRecentActivityElement = recentActivityElement.get(index).findElement(By.cssSelector("div[class='rb-row-main']"));
					if(individualRecentActivityElement != null) {
						// Verify Product type and name
						WebElement productNameSectionElement = recentActivityElement.get(index).findElement(By.cssSelector(locator));
						if(productNameSectionElement != null && !productNameSectionElement.getAttribute("style").equalsIgnoreCase("display: none;")) {
							WebElement productTypeElement = productNameSectionElement.findElement(By.cssSelector("div[data-bind='html:ProductType']"));
							WebElement productNameElement = productNameSectionElement.findElement(By.cssSelector("div[data-bind='html:ProductName']"));
							if(productTypeElement != null && productNameElement != null 
									&& productTypeElement.getText().trim().equalsIgnoreCase(productType)
									&& productNameElement.getText().trim().equalsIgnoreCase(productName)) {
								// Checking In Progress Status to click Assessment.
								String progressStatus = individualRecentActivityElement.findElement(By.cssSelector("div[class='status-completed-score']")).getText();
								if(StringUtils.isNotEmpty(progressStatus) && progressStatus.trim().equalsIgnoreCase(assessmentStatus)) {
									// Clicking on Product Type. 
									productTypeElement.click();
									flag = true;
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									break;
								}
							}								
						}
					}
				}
			}

		}catch (Exception e) {
    		logger.info("Unable to verifyAndClickRecentActivity" );
			log(logger, "Unable to verifyAndClickRecentActivity" );
    		throw new DriverException("Unable to verifyAndClickRecentActivity" , e); 
    	}
		logger.info("Method: verifyAndClickRecentActivity End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to verify pop up message when clicked on i icon on pulse banner
	 */
	public boolean VerifyMessageInfoIcon() throws Exception {
		logger.info("Method: VerifyMessageInfoIcon Starts");
		boolean flag = false;
		try {
			List<WebElement> bannerinfomsg = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.pulse.banner.messages.loc"));
			if(CollectionUtils.isNotEmpty(bannerinfomsg) && bannerinfomsg.size() > 0){
				if(bannerinfomsg.get(1).getText().trim().contains(PropertiesRepository.getString("new-atitesting.oulse.banner.predict.message1"))
						&& bannerinfomsg.get(1).getText().trim().contains(PropertiesRepository.getString("new-atitesting.oulse.banner.predict.message2"))
						&& bannerinfomsg.get(1).getText().trim().contains(PropertiesRepository.getString("new-atitesting.oulse.banner.predict.message3"))
						&& bannerinfomsg.get(3).getText().trim().contains(PropertiesRepository.getString("new-atitesting.oulse.banner.message2"))
						&& bannerinfomsg.get(4).getText().trim().contains(PropertiesRepository.getString("new-atitesting.oulse.banner.message3"))
						&& bannerinfomsg.get(5).getText().trim().contains(PropertiesRepository.getString("new-atitesting.oulse.banner.message4"))
						&& bannerinfomsg.get(6).getText().trim().contains(PropertiesRepository.getString("new-atitesting.oulse.banner.message5"))){
					flag=true;
				}
				
			}
		} catch (Exception e) {
			logger.info("Pulse banner message is not Displayed in VerifyMessageInfoIcon");
			log(logger, "Pulse banner message is not Displayed in VerifyMessageInfoIcon");
			throw new DriverException("Pulse banner message is not Displayed in VerifyMessageInfoIcon", e);
		}
		logger.info("Method: VerifyMessageInfoIcon Ends");
		return flag;
	}
	
	/**
	 * This method used to select date on the Home Page Calendar.Input Date formate DD/MM/YYYY
	 * @author Syed.pasha
	 * 
	 */
	public void selectDateOnHomeCalendar(String dateMonthYear) throws Exception {
		
		logger.info("Method: selectDateOnHomeCalendar Starts");		
		String monthYear[] = dateMonthYear.split("/", 2);		

		SimpleDateFormat sdf = new SimpleDateFormat("MM/yyyy");
		Date dateGiven = sdf.parse(monthYear[1]);
		
		int month = Month.valueOf((baseHandler.findElement(".ui-datepicker-month").getText()).toUpperCase()).getValue();    	
    	String appDateStr = Integer.toString(month)+"/"+baseHandler.findElement(".ui-datepicker-year").getText();
    	Date appDate = sdf.parse(appDateStr);
    	
    	while(dateGiven.compareTo(appDate) > 0){    	
    		baseHandler.findElement("#datepicker a[title='Next'] span").click();
    		month = Month.valueOf((baseHandler.findElement(".ui-datepicker-month").getText()).toUpperCase()).getValue();    	
        	appDateStr = Integer.toString(month)+"/"+baseHandler.findElement(".ui-datepicker-year").getText();
        	appDate = sdf.parse(appDateStr);
    	}
    	while(dateGiven.compareTo(appDate) < 0){
    		baseHandler.findElement("#datepicker a[title='Prev'] span").click();
    		month = Month.valueOf((baseHandler.findElement(".ui-datepicker-month").getText()).toUpperCase()).getValue();    	
        	appDateStr = Integer.toString(month)+"/"+baseHandler.findElement(".ui-datepicker-year").getText();
        	appDate = sdf.parse(appDateStr);
    	}	
    	
    	List<WebElement> days = baseHandler.findElements("#datepicker .ui-state-default");
    	for (int i = 0; i < days.size(); i++) {
			if(monthYear[0].equals(days.get(i).getText()))
			{
				days.get(i).click();
				break;
			}
		}
		logger.info("Method: selectDateOnHomeCalendar Ends");
		
	}

	/**
	 * This method used to Verify the calendar schedule popup details
	 * @author Syed.pasha
	 * 
	 */
	public boolean verifyCalendarScheduleDetails(String course, String assigenedProduct, String productType) {
		logger.info("Method: verifyCalendarScheduleDetails Starts");
		boolean flag = false;
		if ((baseHandler.findElement("span[data-bind='text:CourseName']").getText().equals(course))
				&& (baseHandler.findElement(".event-details>div>p>span[data-bind='text:Name']").getText().equals(assigenedProduct))
				&& (baseHandler.findElement(".event-details>div>p>span[data-bind='text: LabelText']").getText().equals(productType)))
		{
			flag=true;
		}
			logger.info("Method: verifyCalendarScheduleDetails Ends");
			return flag;
	}
	
	/**
	 * This method used to Verify the calendar schedule popup details
	 * 
	 * @author Syed.pasha
	 * 
	 */
	public String getAccessedDateCardBack(String cardBackModuleName) {

		logger.info("Method: verifyCalendarScheduleDetails Starts ");
		String accessedDate = "";
		List<WebElement> titles = baseHandler.findElements("#productTutorialModuleList .product-list-style>li ");
		for (int i = 0; i < titles.size(); i++) {
			if (titles.get(i).findElement(By.cssSelector(".product-result-take")).getText()
					.equals(cardBackModuleName)) {
				accessedDate = titles.get(i).findElement(By.cssSelector("footer div span")).getText();
				break;
			}
		}
		logger.info("Method: verifyCalendarScheduleDetails Ends");
		return accessedDate;
	}
	
	
}


