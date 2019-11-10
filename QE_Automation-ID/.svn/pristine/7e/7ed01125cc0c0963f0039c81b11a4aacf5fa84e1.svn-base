package com.automation.id.pages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.ButtonHandler;
import com.ascendlearning.automation.ui.handlers.TextHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;
import com.ascendlearning.automation.ui.page.BasePage;
import com.google.common.collect.Iterables;

public class ProctorChromePage extends BasePage {
	private Logger logger = LogManager.getLogger(this.getClass());
	public BaseHandler baseHandler;
	private TextHandler textHandler;
	private ButtonHandler buttonHandler;
	protected WebDriverWait wait;
	private WindowHandler windowHandler;
	
	public ProctorChromePage(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
		baseHandler = new BaseHandler(driver);
		textHandler = new TextHandler(driver);
		buttonHandler = new ButtonHandler(driver);
		wait = new WebDriverWait(driver, PropertiesRepository.getInt("global.driver.wait"));
		windowHandler = new WindowHandler(driver);
		
	}

	/**
	 * Method used to login to application. 
	 * 
	 * @param userName
	 * @param password
	 * @throws NullPointerException
	 * @throws DriverException
	 */
	public void loginToApplicationID(WebDriver chromeDriver, String userName, String password) throws NullPointerException, DriverException {
		logger.info("loginToApplicationID Start");
		try {
			chromeDriver.get(PropertiesRepository.getString("id.url"));
			Thread.sleep(10000);
			WebElement userNameElement = verifyElement(chromeDriver, PropertiesRepository.getString("id.login.username.loc"));
			WebElement passwordElement = verifyElement(chromeDriver, PropertiesRepository.getString("id.login.password.loc"));
			WebElement goButton = verifyElement(chromeDriver, PropertiesRepository.getString("id.login.go.button"));
			if(userNameElement != null && passwordElement != null) {
				userNameElement.sendKeys(userName);
				passwordElement.sendKeys(password);
				goButton.click();//Thread.sleep(10000);
				//waitUntillLoadingImageIsDisappeared(chromeDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
			}
    	} catch (Exception e) {
    		logger.info("Unable to loginToApplicationID");
			log(logger, "Unable to loginToApplicationID" );
    		throw new DriverException("Unable to loginToApplicationID" , e); 
    	}
		logger.info("loginToApplicationID End");		
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
    	try {
    		List<WebElement> buffecImage = chromeDriver.findElements(By.cssSelector(loc));
    		try {
    			
    			while(buffecImage!=null && buffecImage.size()>0 )
        		{
        			logger.info("page is still loading after click on the element");
        			buffecImage=chromeDriver.findElements(By.cssSelector(loc));
        		}
			} catch (Exception e) {
				logger.info("page is loaded successfully");
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
    			
    			while(buffecImage!=null && buffecImage.size()>0 )
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
	 * This method is used to wait until the buffer image is completely load.
	 * @author Sanapati.Srinu
	 * @param loc
	 * @throws Exception
	 */
	public void waitUntillLoadingImageIsAppeared(WebDriver chromeDriver, String loc) throws DriverException {
		logger.info("Method: waitUntillLoadingImageIsAppeared Starts");
    	try {
    		List<WebElement> buffecImage = chromeDriver.findElements(By.cssSelector(loc));
    		try {
    			
    			while(buffecImage!=null && buffecImage.size()>0 )
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
	 * Method used to verify element and if required, it will click. 
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @param click
	 * @return
	 * @throws NullPointerException
	 * @throws DriverException
	 *//*
	public boolean verifyAndClick(WebDriver chromeDriver, String locator, boolean click) throws NullPointerException, DriverException {
		logger.info("Method: verifyAndClick Starts");
		boolean flag = false;
    	try {
    		WebElement element = verifyElement(chromeDriver, locator);
    		if(element != null) {
    			if(click) {
    				element.click();
    			}
    			flag = true;
    		}
    	} catch (Exception e) {
    		logger.info("Unable to verifyAndClick");
			log(logger, "Unable to verifyAndClick" );
    		throw new DriverException("Unable to verifyAndClick" , e); 
    	}
    	logger.info("Method: verifyAndClick End flag --> " + flag);
    	return flag;
	}*/
	
	/**
	 * Method used to enter id and password for proctor and click submit button. 
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @param click
	 * @throws NullPointerException
	 * @throws DriverException
	 */
	public void enteringProctIdAndPwd(WebDriver chromeDriver, String id, String password) throws NullPointerException, DriverException {
		logger.info("Method: enteringProctIdAndPwd Starts");
    	try {
    		swithToProctorFrame(chromeDriver);
    		WebElement idElement = verifyElement(chromeDriver, PropertiesRepository.getString("id.proctor.id.loc"));
    		WebElement pwdElement = verifyElement(chromeDriver, PropertiesRepository.getString("id.proctor.password.loc"));
    		WebElement submitElement  = verifyElement(chromeDriver, PropertiesRepository.getString("id.proctor.submit.loc"));
    		
    		if(idElement != null && pwdElement != null && submitElement != null) {
    			idElement.sendKeys(id);
    			pwdElement.sendKeys(password);
    			submitElement.click();
    			waitUntillLoadingImageIsDisappeared(chromeDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
    			for(int i = 0; i < 5; i++) {
    				Thread.sleep(1000);
	    			WebElement submitElementAnotherTime  = verifyElement(chromeDriver, PropertiesRepository.getString("id.proctor.submit.loc"));
	    			if(submitElementAnotherTime != null) {
	    				logger.info("If still not clicked, clicking Submit button "+ i +" time(s)");
	    				submitElementAnotherTime.click();
	    				//waitUntillLoadingImageIsDisappeared(chromeDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
	    			} else {
	    				break;
	    			}
	    			//i++;
    			}
    		}
    		//Thread.sleep(10000);
    		windowHandler.switchToLatestWindow();
    	} catch (Exception e) {
    		windowHandler.switchToLatestWindow();
    		logger.info("Unable to enteringProctIdAndPwd");
			log(logger, "Unable to enteringProctIdAndPwd" );
    		throw new DriverException("Unable to enteringProctIdAndPwd" , e); 
    	}
    	logger.info("Method: enteringProctIdAndPwd End");
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
		logger.info("Method: verifyLeftNavigationText Starts");
		boolean flag = false;
    	try {
    		List<WebElement> element = chromeDriver.findElements(By.cssSelector(PropertiesRepository.getString("id.home.page.proctor.left.navigator.icon.link")));
    		if(CollectionUtils.isNotEmpty(element)) {
    			int size = element.size();
    			for(int index = 0; index < size; index++) {
    				WebElement navElement = element.get(index);
        			if(navElement != null && navElement.getText().trim().equalsIgnoreCase(leftNavName)) {
        				flag = true;
        				if(click) {
        					navElement.click();
        					break;
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
				if (chromeDriver
						.findElement(By.cssSelector(locator)).isDisplayed()) {
					chromeDriver.findElement(By.cssSelector(locator)).clear();
					chromeDriver.findElement(By.cssSelector(locator)).sendKeys(text);
				}
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
		logger.info("Method: getCurrentDate Starts");
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
	 *//*
	public void clickButtonWith30SecWait(WebDriver chromeDriver, String loc) throws NullPointerException, DriverException {
		logger.info("Method: clickButtonWith30SecWait Starts");
		try {
			swithToProctorFrame(chromeDriver);
			List<WebElement> element = chromeDriver
					.findElements(By.cssSelector(loc));
			if (CollectionUtils.isNotEmpty(element)) {
				element.get(0).click();
			}
			windowHandler.switchToLatestWindow();
			//waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to click Button With 30 Sec Wait");
			log(logger, "Unable to click Button With 30 Sec Wait");
			throw new DriverException("Unable to click Button With 30 Sec Wait", e);
		}
		logger.info("Method: clickButtonWith30SecWait Ends");
	}*/
	

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
		logger.info("Method: clickButtonWith30SecWaitApprove Ends flag --> " + flag);
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
		logger.info("Method: clickButtonWith30SecWait Starts --> " + loc);
		boolean flag = false;
		try {
			swithToProctorFrame(chromeDriver);
			List<WebElement> element = chromeDriver
					.findElements(By.cssSelector(loc));
			logger.info( "clickButtonWith30SecWait element size --> " + element.size());
			if (CollectionUtils.isNotEmpty(element)) {
				((JavascriptExecutor) chromeDriver).executeScript("arguments[0].scrollIntoView(true);", element.get(0));
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
}
