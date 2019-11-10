package com.automation.asmt.page;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.ButtonHandler;
import com.ascendlearning.automation.ui.handlers.TextHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;
import com.ascendlearning.automation.ui.page.BasePage;
import com.google.common.collect.Iterables;

public class MaintenanceScriptID extends ASMTBasePage {
	private Logger logger = LogManager.getLogger(this.getClass());
	public BaseHandler baseHandler;
	private TextHandler textHandler;
	private ButtonHandler buttonHandler;
	protected WebDriverWait wait;
	private WindowHandler windowHandler;
	
	public MaintenanceScriptID(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
		baseHandler = new BaseHandler(driver);
		textHandler = new TextHandler(driver);
		buttonHandler = new ButtonHandler(driver);
		wait = new WebDriverWait(driver, PropertiesRepository.getInt("global.driver.wait"));
		windowHandler = new WindowHandler(driver);
		
	}
	
	/*
	 * @author syed.pasha
	 */
	public void MaintanacePopUp(WebDriver webDriver) throws InterruptedException {
		logger.info("Method : Verifying Maintance pop-up :::: START ");
		Thread.sleep(3000);
		List<WebElement> buttonList = webDriver.findElements(By.cssSelector(".walkme-action-remindMeNextDay-1.wm-close-link"));
		if (CollectionUtils.isNotEmpty(buttonList)) {
			webDriver.findElement(By.cssSelector(".walkme-action-remindMeNextDay-1.wm-close-link")).click();
			Thread.sleep(3000);
		}
		
		// Close Alert Box if present , close it
		if ((webDriver.findElements(By.cssSelector("a[class='ati-modal-close']")).size() != 0)) {
			webDriver.findElement(By.cssSelector("a[class='ati-modal-close']")).click();
		}

		logger.info("Method : Verifying Maintance pop-up :::: END");
	}
	
	/**
	 * Method used to login to application. 
	 * 
	 * @param userName
	 * @param password
	 * @throws NullPointerException
	 * @throws DriverException
	 */
	public boolean loginToApplicationID(WebDriver chromeDriver, String userName, String password) throws NullPointerException, DriverException {
		logger.info("loginToApplicationID Start");
		boolean flag = false;
		try {
			chromeDriver.get(PropertiesRepository.getString("id.project.url"));
			chromeDriver.manage().window().maximize();
			Thread.sleep(3000);
			MaintanacePopUp(chromeDriver);
			WebElement userNameElement = verifyElement(chromeDriver, PropertiesRepository.getString("id.login.username.loc"));
			WebElement passwordElement = verifyElement(chromeDriver, PropertiesRepository.getString("id.login.password.loc"));
			WebElement goButton = verifyElement(chromeDriver, PropertiesRepository.getString("id.login.go.button"));
			
			if(userNameElement != null && passwordElement != null) {
				logger.info("User Name--> " + userName + "Password--> " + password);
				userNameElement.sendKeys(userName);
				passwordElement.sendKeys(password);
				goButton.click();
				flag = true;
				waitUntillLoadingImageIsDisappeared(chromeDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
				Thread.sleep(7000);
				waitUntillLoadingImageIsDisappeared(chromeDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
				MaintanacePopUp(chromeDriver);
			}
			else{
				logger.info("Unable to login To Application else block");
			}			
    	} catch (Exception e) {
    		logger.info("Unable to loginToApplicationID Catch block");
			log(logger, "Unable to loginToApplicationID" );
    		throw new DriverException("Unable to loginToApplicationID" , e); 
    	}
		logger.info("loginToApplicationID End");
		
		return flag;
	}
	
	/**
	 * Method used to verify Element is present in DOM. 
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @return
	 * @throws DriverException
	 */
	public WebElement verifyElement(WebDriver chromeDriver, String locator) throws DriverException {
		logger.info("verifyElement Start");
		WebElement webElement = null;
		try {
    		List<WebElement> element = chromeDriver.findElements(By.cssSelector(locator));
    		if(CollectionUtils.isNotEmpty(element)) {
    			webElement = element.get(0);
    		}
    	} catch (Exception e) {
    		logger.info("Unable to verifyElement");
			log(logger, "Unable to verifyElement" );
    		throw new DriverException("Unable to verifyElement" , e); 
    	}
		logger.info("verifyElement End");
		return webElement;
	}

	/**
	 * This method is used to wait until the buffer image is completely load.
	 * @author Sanapati.Srinu
	 * @param loc
	 * @throws Exception
	 */
	public void waitUntillLoadingImageIsDisappeared(WebDriver chromeDriver, String loc) throws DriverException {
		logger.info("Method: waitUntillLoadingImageIsDisappeared Starts");
		long startTime = System.currentTimeMillis();
    	try {
			List<WebElement> buffecImage = chromeDriver.findElements(By.cssSelector(loc));
			try {
				while (CollectionUtils.isNotEmpty(buffecImage) && ((System.currentTimeMillis() - startTime) < 120000)) {
					logger.info("page is still loading after click on the element");					
					logger.info("Wait Counter in Seconds >>>> " +(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - startTime)));
					buffecImage = chromeDriver.findElements(By.cssSelector(loc));
				}
				if (!((System.currentTimeMillis() - startTime) < 120000)) {
					logger.info("Waited 120 seconds to load the page");
					throw new DriverException("Unable to wait Untill Loading Image Is not Disappeared");
				} else {
					logger.info("Page load complete");
				}
				//waitUntillOverlayImageIsDisappeared("new-atitesting.peasewait.bufferLoc1");
			} catch (Exception e) {
				//waitUntillOverlayImageIsDisappeared("new-atitesting.peasewait.bufferLoc1");
				if (!((System.currentTimeMillis() - startTime) < 120000)) {
					logger.info("Waited 120 seconds to load the page");
					throw new DriverException("Unable to wait Untill Loading Image Is not Disappeared", e);
				} else {
					logger.info("Page load complete in catch block");
				}
			}
		
    	} catch (Exception e) {
    		logger.info("Unable to wait Untill Loading Image Is not Disappeared" );
			log(logger, "Unable to wait Untill Loading Image Is not Disappeared" );
    		throw new DriverException("Unable to wait Untill Loading Image Is not Disappeared" , e); 
    	}
    	logger.info("waitUntillLoadingImageIsDisappeared End");
	}
	
	/**
	 * This method is used to wait until the buffer image is completely load.
	 * @author Sanapati.Srinu
	 * @param loc
	 * @throws Exception
	 */
	public void waitUntillLoadingImageIsAppeared(String loc) throws DriverException {
		logger.info("Method: waitUntillLoadingImageIsAppeared Starts");
    	try {
    		List<WebElement> buffecImage = baseHandler.findElements(loc);
    		try {
    			
    			while(String.valueOf(buffecImage.size())==null)
        		{
        			logger.info("page is still loading after click on the element");
        			buffecImage=baseHandler.findElements(loc);
        		}
			} catch (Exception e) {
				logger.info("page is loaded successfully");
			}
    		
    	} catch (Exception e) {
    		logger.info("Unable to wait Untill Loading Image Is not Disappeared" );
			log(logger, "Unable to wait Untill Loading Image Is not Disappeared" );
    		throw new DriverException("Unable to wait Untill Loading Image Is not Disappeared" , e); 
    	}
    	logger.info("waitUntillLoadingImageIsAppeared End");
	}
	
	/**
	 * Method used to select cohort in Home page.
	 *  
	 * @author saravanan.jothimani
	 * @param cohortName
	 * @return
	 * @throws DriverException
	 */
	public boolean selectCohort(WebDriver chromeDriver, String cohortName) throws DriverException {
		//logger.info("Method: selectCohort Starts");
		boolean flag = false;
    	try {
    		
    		// Verifying Left cohort icon
			WebElement element = verifyElement(chromeDriver, PropertiesRepository.getString("id.home.cohort.icon"));
			if(element != null) {
	    		// Clicking on Left cohort icon
				//linkHandler.selectLink(element);
				element.click();
			
				waitUntillLoadingImageIsDisappeared(chromeDriver, PropertiesRepository.getString("id.common.page.loader"));
				// Enter Cohort Name
				WebElement cohortTextBox = verifyElement(chromeDriver, PropertiesRepository.getString("id.home.cohort.name.loc"));
				textHandler.writeText(cohortTextBox, cohortName);
				waitUntillLoadingImageIsDisappeared(chromeDriver, PropertiesRepository.getString("id.common.page.loader"));
				WebElement cohortDDValue = verifyElement(chromeDriver, ".mat-option-ripple.mat-ripple");
				if(cohortDDValue != null) {
					cohortDDValue.click();
					waitUntillLoadingImageIsDisappeared(chromeDriver, PropertiesRepository.getString("id.common.page.loader"));
				}
				// Clicking on Save button
				WebElement saveButton = verifyElement(chromeDriver, PropertiesRepository.getString("id.home.cohort.save.button.loc"));
				buttonHandler.clickButton(saveButton);
				// Verify Cohort Text.
				List<WebElement> cohortTxt = verifyElementList(chromeDriver, PropertiesRepository.getString("id.home.cohort.verify.loc"));
				if(CollectionUtils.isNotEmpty(cohortTxt)) {
					for(WebElement cohotTxtElement : cohortTxt) {
						if(cohotTxtElement.getText().trim().contains(cohortName)) {
							flag = true;
							break;
						}
					}
				}
			}
			waitUntillLoadingImageIsDisappeared(chromeDriver, PropertiesRepository.getString("id.common.page.loader"));
    	} catch (Exception e) {
    		logger.info("Unable to selectCohort" );
			log(logger, "Unable to selectCohort" );
    		throw new DriverException("Unable to selectCohort" , e); 
    	}
    	logger.info("Method: selectCohort End " + flag);
    	return flag;
	}
	
	
	
	/**
	 * Method used to verify Element is present in DOM. 
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @return
	 * @throws DriverException
	 */
	public List<WebElement> verifyElementList(WebDriver chromeDriver, String locator) throws DriverException {
		logger.info("verifyElementList Start");
		List<WebElement> webElement = null;
		try {
    		List<WebElement> element = chromeDriver.findElements(By.cssSelector(locator));
    		if(CollectionUtils.isNotEmpty(element)) {
    			webElement = element;
    		}
    	} catch (Exception e) {
    		logger.info("Unable to verifyElementList");
			log(logger, "Unable to verifyElementList" );
    		throw new DriverException("Unable to verifyElementList" , e); 
    	}
		logger.info("verifyElementList End");
		return webElement;
	}
	
	/**
	 * Method used to verify element and if required, it will click.
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @param click
	 * @return
	 * @throws NullPointerException
	 * @throws DriverException
	 */
	public boolean verifyAndClickSimple(WebDriver proctorDriver , String locator, boolean click) throws NullPointerException, DriverException {
		logger.info("Method: verifyAndClickSimple Starts ");
		boolean flag = false;
		try {
			WebElement element = verifyElement(proctorDriver, locator);
			if (element != null) {
				if (click) {
					// element.click();
					JavascriptExecutor executor = (JavascriptExecutor) proctorDriver;
					executor.executeScript("arguments[0].click();", element);
					waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
				}
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to verifyAndClick");
			log(logger, "Unable to verifyAndClick");
			throw new DriverException("Unable to verifyAndClick", e);
		}
		logger.info("Method: verifyAndClickSimple End flag --> " + flag);
		return flag;
	}


	/**
	 * Method used to verify element and if required, it will click. 
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @param click
	 * @return
	 * @throws NullPointerException
	 * @throws DriverException
	 */
	public boolean verifyAndClick(WebDriver chromeDriver, String locator, boolean click) throws NullPointerException, DriverException {
		logger.info("Method: verifyAndClick Starts");
		boolean flag = false;
    	try {
    		WebElement element = verifyElement(chromeDriver, locator);
    		if(element != null) {
    			if(click) {
    				element.click();
    			}
    			WebElement leftNavElement = verifyElement(chromeDriver, "div #side .sidebar-nav.flex-container.mat-sidenav.mat-sidenav-over.mat-sidenav-opened");
    			if(leftNavElement !=null) {
    				logger.info("Clicked with Normal click");
    				flag = true;
    				return flag;
    			} else {
    				try {
						WebElement jsElement = verifyElement(chromeDriver, " img[class='sidebar-icon'][alt='Open Menu']");
						JavascriptExecutor executor = (JavascriptExecutor)chromeDriver;
						executor.executeAsyncScript("arguments[0].click();", jsElement);
						flag = true;
					} catch (Exception e) {
						logger.info("Clicked on left Nav, but showing error");
					}
    				
    				WebElement leftNavElementJS = verifyElement(chromeDriver, "div #side .sidebar-nav.flex-container.mat-sidenav.mat-sidenav-over.mat-sidenav-opened");
    				//WebElement leftNavElementJS = null;
        			if(leftNavElementJS !=null) {
        				logger.info("Clicked with JS click");
        				flag = true;
        				return flag;
        			} 
    			}
    		} else {
    			logger.info("Unable to click on left navigation in verifyAndClick() Retrying to click on left navigation --> " + element);
    			List<WebElement> leftNavElement = chromeDriver.findElements(By.cssSelector(locator));
    			if(CollectionUtils.isNotEmpty(leftNavElement)) {
    				leftNavElement.get(0).click();
    			}
    			
    			WebElement leftNavElementRetry = verifyElement(chromeDriver, "div #side .sidebar-nav.flex-container.mat-sidenav.mat-sidenav-over.mat-sidenav-opened");
    			if(leftNavElementRetry !=null) {
    				logger.info("Clicked with Normal click");
    				flag = true;
    				return flag;
    			} else {
    				try {
						WebElement jsElementRetry = verifyElement(chromeDriver, " img[class='sidebar-icon'][alt='Open Menu']");
						JavascriptExecutor executor = (JavascriptExecutor)chromeDriver;
						executor.executeAsyncScript("arguments[0].click();", jsElementRetry);
						flag = true;
					} catch (Exception e) {
						logger.info("Clicked on left Nav, but showing error");
					}
    				
    				WebElement leftNavElementJSRetry = verifyElement(chromeDriver, "div #side .sidebar-nav.flex-container.mat-sidenav.mat-sidenav-over.mat-sidenav-opened");
    				//WebElement leftNavElementJS = null;
        			if(leftNavElementJSRetry !=null) {
        				logger.info("Clicked with JS click");
        				flag = true;
        				return flag;
        			} 
    			}
    		}
    	} catch (Exception e) {
    		logger.info("Unable to verifyAndClick");
			log(logger, "Unable to verifyAndClick" );
    		throw new DriverException("Unable to verifyAndClick" , e); 
    	}
    	logger.info("Method: verifyAndClick End flag --> " + flag);
    	return flag;
	}
	
	/**
	 * Method used to enter id and password for proctor and click submit button. 
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @param click
	 * @throws NullPointerException
	 * @throws DriverException
	 */
	public boolean enteringProctIdAndPwd(WebDriver chromeDriver, String id, String password) throws NullPointerException, DriverException {
		logger.info("Method: enteringProctIdAndPwd Starts ");
		boolean flag = false;
    	try {
    		
    		swithToProctorFrame(chromeDriver);
    		WebElement idElement = verifyElement(chromeDriver, PropertiesRepository.getString("id.proctor.id.loc"));
    		WebElement pwdElement = verifyElement(chromeDriver, PropertiesRepository.getString("id.proctor.password.loc"));
    		WebElement submitElement  = verifyElement(chromeDriver, PropertiesRepository.getString("id.proctor.submit.loc"));
    		
    		if(idElement != null && pwdElement != null && submitElement != null) {
    			idElement.sendKeys(id);
    			pwdElement.sendKeys(password);
    			waitUntillLoadingImageIsDisappeared(chromeDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
    			submitElement.click();
    			waitUntillLoadingImageIsDisappeared(chromeDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
    		
    		}
    		
    		WebElement submitElement1  = verifyElement(chromeDriver, PropertiesRepository.getString("id.proctor.submit.loc"));
    		WebDriverWait wait1 = new WebDriverWait(chromeDriver, 60);
    		//wait1.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("input[id$='_chkAutoRefresh']"))));
    		
    		if(submitElement1 != null)
    		{   				
    			wait1.until(ExpectedConditions.invisibilityOf(submitElement));    		
    			waitUntillLoadingImageIsDisappeared(chromeDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
    		}
    		WebElement submitElement2  = verifyElement(chromeDriver, PropertiesRepository.getString("id.proctor.submit.loc"));
    		if((submitElement2 == null)){
    			flag=true;
    		}
    		windowHandler.switchToLatestWindow();
    	} catch (Exception e) {
    		windowHandler.switchToLatestWindow();
    		logger.info("Unable to enteringProctIdAndPwd");
			log(logger, "Unable to enteringProctIdAndPwd" );
    		throw new DriverException("Unable to enteringProctIdAndPwd" , e); 
    	}
    	logger.info("Method: enteringProctIdAndPwd End flag--> " +flag);
    	return flag;
	}
	


	/**
	 * Mthod used to verify left navigation name and click if required. 
	 * 
	 * @author saravanan.jothimani
	 * @param leftNavName
	 * @param click
	 * @return
	 * @throws DriverException
	 */
	public boolean verifyLeftNavigationText(WebDriver chromeDriver, int index, String leftNavName, boolean click) throws DriverException {
		logger.info("Method: verifyLeftNavigationText Starts");
		boolean flag = false;
    	try {
    		List<WebElement> element = chromeDriver.findElements(By.cssSelector(PropertiesRepository.getString("id.home.page.proctor.left.navigator.icon.link")));
    		if(CollectionUtils.isNotEmpty(element)) {
    			WebElement navElement = element.get(index);
    			if(navElement != null && navElement.getText().trim().equalsIgnoreCase(leftNavName)) {
    				flag = true;
    				if(click) {
    					navElement.click();
    				}
    			}
    		}
    	} catch (Exception e) {
    		logger.info("Unable to verifyLeftNavigationText");
			log(logger, "Unable to verifyLeftNavigationText" );
    		throw new DriverException("Unable to verifyLeftNavigationText" , e); 
    	}
    	logger.info("Method: verifyLeftNavigationText End flag --> " + flag);
    	return flag;
	}
	
	/**
	 * Mthod used to verify left navigation name and click if required. 
	 * 
	 * @author saravanan.jothimani
	 * @param leftNavName
	 * @param click
	 * @return
	 * @throws DriverException
	 */
	public boolean verifyLeftNavigationText(String leftNavName, boolean click) throws DriverException {
		logger.info("Method: verifyLeftNavigationText Starts");
		boolean flag = false;
    	try {
    		List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("id.home.page.proctor.left.navigator.icon.link"));
    		if(CollectionUtils.isNotEmpty(element)) {
    			int size = element.size();
    			for(int index = 0; index < size; index ++) {
        			WebElement navElement = element.get(index);
        			if(navElement != null && navElement.getText().trim().equalsIgnoreCase(leftNavName)) {
        				flag = true;
        				if(click) {
        					navElement.click();
        				}
        			}
    			}
    		}
    	} catch (Exception e) {
    		logger.info("Unable to verifyLeftNavigationText");
			log(logger, "Unable to verifyLeftNavigationText" );
    		throw new DriverException("Unable to verifyLeftNavigationText" , e); 
    	}
    	logger.info("Method: verifyLeftNavigationText End flag --> " + flag);
    	return flag;
	}
	
	/**
	 * Mthod used to verify left navigation name and click if required. 
	 * 
	 * @author saravanan.jothimani
	 * @param leftNavName
	 * @param click
	 * @return
	 * @throws DriverException
	 */
	public boolean verifyLeftNavigationTextSearch(WebDriver chromeDriver, String leftNavName, boolean click) throws DriverException {
		logger.info("Method: verifyLeftNavigationTextSearch Starts");
		logger.info("leftNavName --> " + leftNavName);
		logger.info("leftNavName Locator --> " + PropertiesRepository.getString("id.home.page.proctor.left.navigator.icon.link"));
		boolean flag = false;
    	try {    		
    		//waitUntillElementIsVisible(".white-text-primary");
    		Thread.sleep(5000);
    		List<WebElement> element = chromeDriver.findElements(By.cssSelector(PropertiesRepository.getString("id.home.page.proctor.left.navigator.icon.link")));
    		if(CollectionUtils.isNotEmpty(element)) {
    			int size = element.size();
    			for(int index = 0; index < size; index++) {
    				WebElement navElement = element.get(index);
    				logger.info("leftNavName left nav value --> " + navElement.getText().trim());
        			if(navElement != null && navElement.getText().trim().equalsIgnoreCase(leftNavName)) {
        				//Thread.sleep(2000);
        				flag = true;
        				if(click) {
        					navElement.click();
        					waitUntillLoadingImageIsDisappeared(chromeDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
        					break;
        				}
        			}
    			}
    		}
    	} catch (Exception e) {
    		logger.info("Unable to verifyLeftNavigationTextSearch");
			log(logger, "Unable to verifyLeftNavigationTextSearch" );
    		throw new DriverException("Unable to verifyLeftNavigationTextSearch" , e); 
    	}
    	logger.info("Method: verifyLeftNavigationTextSearch End flag --> " + flag);
    	return flag;
	}
	
	
	/**
	 * Method used to switch to PDF Frame.
	 * 
	 * @author saravanan.jothimani
	 * @throws DriverException
	 */
	public void swithToProctorFrame(WebDriver chromeDriver) throws DriverException {
		logger.info("Method: swithToProctorFrame Starts");
    	try {
    		windowHandler.switchToLatestWindow();
    		List<WebElement> iframe = chromeDriver.findElements(By.cssSelector(".card-shadow"));
    		if(CollectionUtils.isNotEmpty(iframe)) {
    			chromeDriver.switchTo().frame(iframe.get(0));
    		}
    	} catch (Exception e) {
    		logger.info("Unable to swithToProctorFrame" );
			log(logger, "Unable to swithToProctorFrame" );
    		throw new DriverException("Unable to swithToProctorFrame" , e); 
    	}
    	logger.info("Method: swithToProctorFrame End " );
	}
	
	/**
	 * Method used to enter Electronic Signature in Proctor Welcome Page.
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @param text
	 * @throws Exception
	 */
	public void enterElectornicSignature(WebDriver chromeDriver, String locator, String text)
			throws DriverException {
		logger.info("Method: enterElectornicSignature Starts");
		try {
			swithToProctorFrame(chromeDriver);
			List<WebElement> welcomeElement = chromeDriver
					.findElements(By.cssSelector(PropertiesRepository
							.getString("faculty.portal.product.select.activity.proctor.assessment.proctor.authentication.page.welcome.message.loc")));

			if (CollectionUtils.isNotEmpty(welcomeElement)) {
				WebElement element = chromeDriver.findElement(By.cssSelector(locator));
				if(element != null && element.isDisplayed()) {
					((JavascriptExecutor) chromeDriver).executeScript("arguments[0].scrollIntoView(true);", element);
					element.clear();
					element.sendKeys(text);
				}
				/*if (chromeDriver
						.findElement(By.cssSelector(locator)).isDisplayed()) {
					((JavascriptExecutor) chromeDriver).executeScript("arguments[0].scrollIntoView(true);", welcomeElement.get(0));
					chromeDriver.findElement(By.cssSelector(locator)).clear();
					chromeDriver.findElement(By.cssSelector(locator)).sendKeys(text);
				}*/
			}
			switchToLatestWindow(chromeDriver);
		} catch (Exception e) {
			switchToLatestWindow(chromeDriver);
			logger.info("Unable to enter Electornic Signature");
			log(logger, "Unable to enter Electornic Signature");
			throw new DriverException("Unable to enter Electornic Signature", e);
		}
		logger.info("Method: enterElectornicSignature End ");
	}
	
	private WebDriver switchToLatestWindow(WebDriver chromeDriver) {
		logger.info("Switching to window : " + chromeDriver.getTitle());
		chromeDriver.switchTo().window(Iterables.getLast(chromeDriver.getWindowHandles()));
		logger.info("Switching to window : " + chromeDriver.getTitle());
		return driver;
	}

	/**
	 * Method used to get current date with specified pattern. 
	 * 
	 * @param pattern
	 * @return
	 * @throws Exception
	 */
	public String getCurrentDate(String pattern) throws IllegalArgumentException, DriverException {
		logger.info("Method: getCurrentDate Starts ");
		String result = null;
    	try {
			Date currDate = new Date();
				SimpleDateFormat format = new SimpleDateFormat(pattern);
					result = format.format(currDate);
    	} 
    	catch (IllegalArgumentException e) {
    		logger.info("Unable to get Current Date");
    		throw new IllegalArgumentException("Unable to get Current Date" , e); 
    	}
    	catch (Exception e) {
    		logger.info("Unable to get Current Date");
    		throw new DriverException("Unable to get Current Date" , e); 
    	}
    	logger.info("Method: getCurrentDate End result --> " + result);
    	return result;
	}
	
	/**
	 * Method used to click Proceed button in Proctor Welcome Page.
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @param text
	 * @throws Exception
	 */
	public void clickProctorWelcomePageProceedButton(WebDriver chromeDriver) throws DriverException {
		logger.info("Method: enterProctorWelcomePageDate Starts");
		try {
			swithToProctorFrame(chromeDriver);
			List<WebElement> welcomeElement = chromeDriver
					.findElements(By.cssSelector(PropertiesRepository
							.getString("faculty.portal.product.select.activity.proctor.assessment.proctor.authentication.page.welcome.message.loc")));

			if (CollectionUtils.isNotEmpty(welcomeElement)) {
				if (chromeDriver.findElement(By.cssSelector(PropertiesRepository
								.getString("faculty.portal.product.select.activity.proctor.assessment.proceed.button.loc")))
						.isDisplayed()) {
					chromeDriver.findElement(By.cssSelector(PropertiesRepository
							.getString("faculty.portal.product.select.activity.proctor.assessment.proceed.button.loc"))).click();
				}
			}
			switchToLatestWindow(chromeDriver);
		} catch (Exception e) {
			switchToLatestWindow(chromeDriver);
			logger.info("Unable to enter Proctor Welcome Page Date");
			log(logger, "Unable to enter Proctor Welcome Page Date");
			throw new DriverException(
					"Unable to enter Proctor Welcome Page Date", e);
		}
		logger.info("Method: enterProctorWelcomePageDate End ");
	}
	
	/**
	 * After clicking on Approve button, the application itself will wait for 30 sec. 
	 * so, this method will wait for 30 sec and click on refresh button. 
	 * 
	 * @param loc
	 * @throws NullPointerException
	 * @throws DriverException
	 */
	public boolean clickButtonWith30SecWait(WebDriver chromeDriver, String loc) throws NullPointerException, DriverException {
		logger.info("Method: clickButtonWith30SecWait Starts --> " + loc);
		boolean flag = false;
		
		try {
			swithToProctorFrame(chromeDriver);
			List<WebElement> element = chromeDriver
					.findElements(By.cssSelector(loc));
			logger.info( "clickButtonWith30SecWait element size --> " + element.size());
			if (CollectionUtils.isNotEmpty(element)) {
				//((JavascriptExecutor) chromeDriver).executeScript("arguments[0].scrollIntoView(true);", element.get(0));
				element.get(0).click();
				flag = true;
			}
			windowHandler.switchToLatestWindow();
			//waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to click Button With 30 Sec Wait");
			log(logger, "Unable to click Button With 30 Sec Wait");
			throw new DriverException("Unable to click Button With 30 Sec Wait", e);
		}
		logger.info("Method: clickButtonWith30SecWait Ends flag--> " + flag);
		return flag;
	}
	
	/**
	 * After clicking on Approve button, the application itself will wait for 30 sec. 
	 * so, this method will wait for 30 sec and click on refresh button. 
	 * 
	 * @param loc
	 * @throws NullPointerException
	 * @throws DriverException
	 */
	public boolean clickButtonWith30SecWaitApprove(WebDriver chromeDriver) throws NullPointerException, DriverException {
		logger.info("Method: clickButtonWith30SecWaitApprove Starts ");
		boolean flag = false;
		try {
			//Thread.sleep(15000);
			swithToProctorFrame(chromeDriver);
			List<WebElement> element = chromeDriver
					.findElements(By.cssSelector("#ctl00_contentPlaceHolderBody_ucMonitorTests_DataGridStudent_ctl02_ctl00"));
			logger.info( "clickButtonWith30SecWait element size --> " + element.size());
			if (CollectionUtils.isNotEmpty(element)) {
				//((JavascriptExecutor) chromeDriver).executeScript("arguments[0].scrollIntoView(true);", element.get(0));
				element.get(0).click();
				for(int i = 0; i < 5; i++) {
					WebElement radioElement = element.get(0);
					if(radioElement.isSelected()) {
						flag = true;
						break;
					} else {
						radioElement.click();
					}
				}
			}
			windowHandler.switchToLatestWindow();
			//waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to click Button With 30 Sec Wait");
			log(logger, "Unable to click Button With 30 Sec Wait");
			throw new DriverException("Unable to click Button With 30 Sec Wait", e);
		}
		logger.info("Method: clickButtonWith30SecWaitApprove Ends flag --> " + flag);
		return flag;
	}
	
	/**
	 * After clicking on Stop button, the application itself will wait for 30 sec. 
	 * so, this method will wait for 30 sec and click on refresh button. 
	 * 
	 * @param loc
	 * @throws NullPointerException
	 * @throws DriverException
	 */
	public boolean clickButtonWith30SecWaitStop(WebDriver chromeDriver) throws NullPointerException, DriverException {
		logger.info("Method: clickButtonWith30SecWaitStop Starts");
		boolean flag = false;
		try {
			//Thread.sleep(15000);
			swithToProctorFrame(chromeDriver);
			List<WebElement> element = chromeDriver
					.findElements(By.cssSelector("input[id*='ctl00_contentPlaceHolderBody_ucMonitorTests_DataGridStudent']"));
			logger.info( "clickButtonWith30SecWait element size --> " + element.size());
			if (CollectionUtils.isNotEmpty(element)) {
				//((JavascriptExecutor) chromeDriver).executeScript("arguments[0].scrollIntoView(true);", element.get(0));
				element.get(0).click();
				for(int i = 0; i < 5; i++) {
					WebElement radioElement = element.get(0);
					if(radioElement.isSelected()) {
						flag = true;
						break;
					} else {
						radioElement.click();
					}
				}
			}
			windowHandler.switchToLatestWindow();
			//waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to click Stop Button With 30 Sec Wait");
			log(logger, "Unable to click Stop Button With 30 Sec Wait");
			throw new DriverException("Unable to click Stop Button With 30 Sec Wait", e);
		}
		logger.info("Method: clickButtonWith30SecWaitStop Ends flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to click on ignore radio button and click on stop monitoring button. 
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @param click
	 * @return
	 * @throws NullPointerException
	 * @throws DriverException
	 */
	public boolean clickIgnoreRadioButton(WebDriver chromeDriver, String locator, boolean click) throws NullPointerException, DriverException {
		logger.info("Method: clickIgnoreRadioButton Starts");
		boolean flag = false;
    	try {
    		Thread.sleep(3000);
    		swithToProctorFrame(chromeDriver);
    		// Getting the list of ignore radio button and clicking on it. 
    		
    		List<WebElement> ignoreElement = verifyElementList(chromeDriver, locator);
    		if(CollectionUtils.isNotEmpty(ignoreElement)) {
    			int size = ignoreElement.size();
    			for(int index = 1; index < size; index++) {
    				WebElement inputElement =ignoreElement.get(index).findElement(By.cssSelector("td input"));
    				if(inputElement != null) {
    					inputElement.click();
    					flag = true;
    				}
    				if(!flag) {
        				flag = false;
        				break;
        			}
    			}
    			if(flag) {
    				Thread.sleep(30000);
    				log(logger, "Clicking on Refersh Button");
    				scrollToElement(chromeDriver, "#ctl00_contentPlaceHolderBody_ucMonitorTests_btnAddMonitor");
    				clickButtonWith30SecWait(chromeDriver,
    						"#btnRefreshBottom");
    				scrollToElement(chromeDriver, "#ctl00_contentPlaceHolderBody_ucMonitorTests_btnAddMonitor");
    			}
    		}
    		/*s*/
    		windowHandler.switchToLatestWindow();
    	} catch (Exception e) {
    		windowHandler.switchToLatestWindow();
    		logger.info("Unable to clickIgnoreRadioButton");
			log(logger, "Unable to clickIgnoreRadioButton" );
    		throw new DriverException("Unable to clickIgnoreRadioButton" , e); 
    	}
    	logger.info("Method: clickIgnoreRadioButton End flag --> " + flag);
    	return flag;
	}
	
	/**
	 * After clicking on Approve button, the application itself will wait for 30 sec. 
	 * so, this method will wait for 30 sec and click on refresh button. 
	 * 
	 * @param loc
	 * @throws NullPointerException
	 * @throws DriverException
	 */
	public boolean scrollToElement(WebDriver chromeDriver, String loc) throws NullPointerException, DriverException {
		logger.info("Method: scrollToElement Starts --> " + loc);
		boolean flag = false;
		try {
			swithToProctorFrame(chromeDriver);
			List<WebElement> element = chromeDriver
					.findElements(By.cssSelector(loc));
			logger.info( "scrollToElement element size --> " + element.size());
			if (CollectionUtils.isNotEmpty(element)) {
				((JavascriptExecutor) chromeDriver).executeScript("arguments[0].scrollIntoView(true);", element.get(0));
				flag = true;
			}
			windowHandler.switchToLatestWindow();
			//waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to scrollToElement");
			log(logger, "Unable to scrollToElement");
			throw new DriverException("Unable to scrollToElement", e);
		}
		logger.info("Method: scrollToElement Ends flag--> " + flag);
		return flag;
	}
	
	/**
	 * Method used to click on stop check box. 
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @param click
	 * @return
	 * @throws NullPointerException
	 * @throws DriverException
	 */
	public boolean clickStudentStatusForStopOrDeny(WebDriver chromeDriver) throws NullPointerException, DriverException {
		logger.info("Method: clickStudentStatusForStopOrDeny Starts");
		boolean flag = false;
    	try {
    		swithToProctorFrame(chromeDriver);
    		// Getting the list of ignore radio button and clicking on it. 
    		
    		List<WebElement> studentStatusElement = verifyElementList(chromeDriver, "#ctl00_contentPlaceHolderBody_ucMonitorTests_DataGridStudent tr");
    		if(CollectionUtils.isNotEmpty(studentStatusElement)) {
    			int size = studentStatusElement.size();
    			for(int index = 1; index < size; index++) {
    				flag = false;
    				WebElement inputElement =studentStatusElement.get(index);
    				if(inputElement != null) {
    					List<WebElement> proctorActionElement = inputElement.findElements(By.cssSelector("td input"));
    					if(CollectionUtils.isNotEmpty(proctorActionElement) && proctorActionElement.size() == 3) {
    						proctorActionElement.get(1).click();
    						flag = true;
    					} else if(CollectionUtils.isNotEmpty(proctorActionElement) && proctorActionElement.size() == 1){
    						proctorActionElement.get(0).click();
    						flag = true;
    					}
    				}
/*    				if(inputElement != null) {
    					inputElement.click();
    					flag = true;
    				}
*/    				if(!flag) {
        				flag = false;
        				break;
        			}
    			}
    			if(flag) {
    				Thread.sleep(30000);
    				log(logger, "Clicking on Refersh Button");
    				scrollToElement(chromeDriver, "#ctl00_contentPlaceHolderBody_ucMonitorTests_btnAddMonitor");
    				clickButtonWith30SecWait(chromeDriver,
    						"#btnRefreshBottom");
    				scrollToElement(chromeDriver, "#ctl00_contentPlaceHolderBody_ucMonitorTests_btnAddMonitor");
    			}
    		}
    		/*s*/
    		windowHandler.switchToLatestWindow();
    	} catch (Exception e) {
    		windowHandler.switchToLatestWindow();
    		logger.info("Unable to clickStudentStatusForStopOrDeny");
			log(logger, "Unable to clickStudentStatusForStopOrDeny" );
    		throw new DriverException("Unable to clickStudentStatusForStopOrDeny" , e); 
    	}
    	logger.info("Method: clickStudentStatusForStopOrDeny End flag --> " + flag);
    	return flag;
	}
	
	/**
	 * Method used to click on stop check box. 
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @param click
	 * @return
	 * @throws NullPointerException
	 * @throws DriverException
	 */
	public boolean clickCloseButtonInStoppedAssessmentSection(WebDriver chromeDriver) throws NullPointerException, DriverException {
		logger.info("Method: clickCloseButtonInStoppedAssessmentSection Starts");
		boolean flag = false;
    	try {
    		swithToProctorFrame(chromeDriver);
    		// Getting the list of ignore radio button and clicking on it. 
    		
    		List<WebElement> stopTestElement = verifyElementList(chromeDriver, "#ctl00_contentPlaceHolderBody_ucMonitorTests_DataGridStopped tr");
    		if(CollectionUtils.isNotEmpty(stopTestElement)) {
    			int size = stopTestElement.size();
    			for(int index = 1; index < size; index++) {
    				List<WebElement> inputTdElement =stopTestElement.get(index).findElements(By.cssSelector("input[id*='ctl00_contentPlaceHolderBody_ucMonitorTests_DataGridStopped']"));
    				if(CollectionUtils.isNotEmpty(inputTdElement) && inputTdElement.size() == 3) {
    					WebElement inputElement = inputTdElement.get(0);
    					if(inputElement != null) {
        					inputElement.click();
        					flag = true;
        				}
        				if(!flag) {
            				flag = false;
            				break;
            			}
    				}
    			}
    			if(flag) {
    				Thread.sleep(3000);
    				log(logger, "Clicking on Refersh Button");
    				scrollToElement(chromeDriver, "#ctl00_contentPlaceHolderBody_ucMonitorTests_btnAddMonitor");
    				clickButtonWith30SecWait(chromeDriver,
    						"#btnRefreshBottom");
    				scrollToElement(chromeDriver, "#ctl00_contentPlaceHolderBody_ucMonitorTests_btnAddMonitor");
    			}
    		}
    		/*s*/
    		windowHandler.switchToLatestWindow();
    	} catch (Exception e) {
    		windowHandler.switchToLatestWindow();
    		logger.info("Unable to clickCloseButtonInStoppedAssessmentSection");
			log(logger, "Unable to clickCloseButtonInStoppedAssessmentSection" );
    		throw new DriverException("Unable to clickCloseButtonInStoppedAssessmentSection" , e); 
    	}
    	logger.info("Method: clickCloseButtonInStoppedAssessmentSection End flag --> " + flag);
    	return flag;
	}
	
	public boolean checkStopTestCheckBox(WebDriver proctorDriver) throws Exception {
		logger.info("Method : checkStopTestCheckBox Start");
		boolean flag = false;
		try {
			swithToProctorFrame(proctorDriver);
			List<WebElement> stopTestElement = verifyElementList(proctorDriver, "input[id*='ctl00_contentPlaceHolderBody_ucMonitorTests_DataGridStudent']");
			if(CollectionUtils.isNotEmpty(stopTestElement)) {
				logger.info("Stop Test is displayed");
				flag = true;
			} else {
				logger.info("Stop Test is not displayed and trying again");
				waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
				scrollToElement(proctorDriver, "#ctl00_contentPlaceHolderBody_ucMonitorTests_btnAddMonitor");
				log(logger, "Clicking on Refersh Button");
				VerificationHandler.verifyTrue(clickButtonWith30SecWait(proctorDriver,"#btnRefreshBottom"), "Unable to click Refresh Button");
				
				Thread.sleep(30000);
				scrollToElement(proctorDriver, "#ctl00_contentPlaceHolderBody_ucMonitorTests_btnAddMonitor");
				log(logger, "Clicking on Approve Button");
				clickButtonWith30SecWaitApprove(proctorDriver);

				log(logger, "Clicking on Refresh Button");
				Thread.sleep(30000);
				scrollToElement(proctorDriver, "#ctl00_contentPlaceHolderBody_ucMonitorTests_btnAddMonitor");
				//proctorChromePage.scrollToElement(proctorDriver, "#ctl00_contentPlaceHolderBody_ucMonitorTests_TableComplete");
				VerificationHandler.verifyTrue(clickButtonWith30SecWait(proctorDriver,"#btnRefreshBottom"), "Unable to click Refresh Button");
				Thread.sleep(30000);
				
				List<WebElement> elementSecond = verifyElementList(proctorDriver, "input[id*='ctl00_contentPlaceHolderBody_ucMonitorTests_DataGridStudent']");
				if(CollectionUtils.isNotEmpty(elementSecond)) {
					logger.info("Stop Test is displayed after trying again");
					flag = true;
				} 
			}
			windowHandler.switchToLatestWindow();
		}catch (Exception e) {
			windowHandler.switchToLatestWindow();
    		logger.info("Unable to checkStopTestCheckBox" );
			log(logger, "Unable to checkStopTestCheckBox" );
    		throw new DriverException("Unable to checkStopTestCheckBox" , e); 
    	}
		logger.info("Method: checkStopTestCheckBox End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to click on abandon radio button. 
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @param click
	 * @return
	 * @throws NullPointerException
	 * @throws DriverException
	 */
	public boolean clickAbandonButnInStoppedAssetSec(WebDriver chromeDriver) throws NullPointerException, DriverException {
		logger.info("Method: clickAbandonButnInStoppedAssetSec Starts");
		boolean flag = false;
    	try {
    		swithToProctorFrame(chromeDriver);
    		// Getting the list of ignore radio button and clicking on it. 
    		
    		List<WebElement> stopTestElement = verifyElementList(chromeDriver, "#ctl00_contentPlaceHolderBody_ucMonitorTests_DataGridStopped tr");
    		if(CollectionUtils.isNotEmpty(stopTestElement)) {
    			int size = stopTestElement.size();
    			for(int index = 1; index < size; index++) {
    				List<WebElement> inputTdElement =stopTestElement.get(index).findElements(By.cssSelector("input[id*='ctl00_contentPlaceHolderBody_ucMonitorTests_DataGridStopped']"));
    				if(CollectionUtils.isNotEmpty(inputTdElement) && inputTdElement.size() == 3) {
    					WebElement inputElement = inputTdElement.get(1);
    					if(inputElement != null) {
        					inputElement.click();
        					flag = true;
        				}
        				if(!flag) {
            				flag = false;
            				break;
            			}
    				}
    			}
    			if(flag) {
    				Thread.sleep(32000);
    				log(logger, "Clicking on Refersh Button");
    				scrollToElement(chromeDriver, "#ctl00_contentPlaceHolderBody_ucMonitorTests_btnAddMonitor");
    				clickButtonWith30SecWait(chromeDriver,
    						"#btnRefreshBottom");
    				scrollToElement(chromeDriver, "#ctl00_contentPlaceHolderBody_ucMonitorTests_btnAddMonitor");
    			}
    		}
    		/*s*/
    		windowHandler.switchToLatestWindow();
    	} catch (Exception e) {
    		windowHandler.switchToLatestWindow();
    		logger.info("Unable to clickAbandonButnInStoppedAssetSec");
			log(logger, "Unable to clickAbandonButnInStoppedAssetSec" );
    		throw new DriverException("Unable to clickAbandonButnInStoppedAssetSec" , e); 
    	}
    	logger.info("Method: clickAbandonButnInStoppedAssetSec End flag --> " + flag);
    	return flag;
	}
	
}


