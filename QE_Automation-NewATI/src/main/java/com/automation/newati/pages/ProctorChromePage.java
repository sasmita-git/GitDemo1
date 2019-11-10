package com.automation.newati.pages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
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
import com.google.common.collect.Iterables;

public class ProctorChromePage extends MyATITabMainPage {
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
		windowHandler = new WindowHandler(driver);
		wait = new WebDriverWait(driver, PropertiesRepository.getInt("global.driver.wait"));
		
	}
	
	/*
	 * @author syed.pasha
	 */
	public void MaintanacePopUp(WebDriver webDriver) throws InterruptedException {
		logger.info("Method : Verifying Maintance pop-up :::: START ");
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
	public void loginToApplicationID(WebDriver chromeDriver, String userName, String password) throws NullPointerException, DriverException {
		logger.info("loginToApplicationID Start");
		boolean flag = false;
		try {
	/*		logger.info("user Name --> " + userName);
			logger.info("Password --> " + password);
			wait = new WebDriverWait(chromeDriver, PropertiesRepository.getInt("global.chromeDriver.wait"));
			chromeDriver.manage().window().maximize();
			chromeDriver.get(PropertiesRepository.getString("newati.login.url"));
			WebElement userNameElement = verifyElement(chromeDriver, "#md-input-1");
			WebElement passwordElement = verifyElement(chromeDriver, "#md-input-3");
			WebElement goButton = verifyElement(chromeDriver, PropertiesRepository.getString("ATIFaculti.login.go.button"));
			if(userNameElement != null && passwordElement != null) {
				userNameElement.sendKeys(userName);
				passwordElement.sendKeys(password);
				goButton.click();
						
			 logger.info("loginToApplicationID submit button clicked");
				waitUntillLoadingImageIsDisappeared(chromeDriver, PropertiesRepository.getString("id.common.page.loader"));
				MaintanacePopUp(chromeDriver);
				//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PropertiesRepository.getString("id.home.page.left.navigator.menu.link"))));
			}
 */
			chromeDriver.get(PropertiesRepository.getString("newati.login.url"));
			chromeDriver.manage().window().maximize();
			Thread.sleep(3000);
		
				Thread.sleep(3000);
				List<WebElement> buttonList = chromeDriver.findElements(By.cssSelector(".walkme-action-remindMeNextDay-1.wm-close-link"));
				if (CollectionUtils.isNotEmpty(buttonList)) {
					chromeDriver.findElement(By.cssSelector(".walkme-action-remindMeNextDay-1.wm-close-link")).click();
					Thread.sleep(3000);
				}
				
				// Close Alert Box if present , close it
				if ((chromeDriver.findElements(By.cssSelector("a[class='ati-modal-close']")).size() != 0)) {
					chromeDriver.findElement(By.cssSelector("a[class='ati-modal-close']")).click();
				}

				if (chromeDriver.getTitle().equals("ATI Testing | Nursing Education | NCLEX Exam Review | TEAS Testing")) {
					if (chromeDriver.findElement(By.cssSelector(PropertiesRepository.getString("ati.login.page.model"))).isDisplayed()) {
//						waitUntillElementIsVisible(PropertiesRepository.getString("ati.login.page.model"));
						logger.info("Select Site");
						List<WebElement> modalbutton = chromeDriver.findElements(By.cssSelector(PropertiesRepository.getString("ati.login.page.model.three.options")));
//						WebElement modalbutton = verifyElement(chromeDriver,PropertiesRepository.getString("ati.login.page.model.three.options"));
						if (CollectionUtils.isNotEmpty(modalbutton)) {
						{
							modalbutton.get(1).click();
						}
						}
						
					}

					logger.info("Click on login button");
					List<WebElement> loginbutton = chromeDriver.findElements(By.cssSelector(PropertiesRepository.getString("ati.login.page.login.btn")));
					if (CollectionUtils.isNotEmpty(loginbutton)) {
					{
						loginbutton.get(0).click();
					}
					}
					Thread.sleep(2000);
					WebElement userNameElement = verifyElement(chromeDriver, PropertiesRepository.getString("ati.student.input.username"));
					WebElement passwordElement = verifyElement(chromeDriver,PropertiesRepository.getString("ati.student.input.pass"));
					WebElement goButton = verifyElement(chromeDriver, PropertiesRepository.getString("ati.student.btn.signIn"));
					if(userNameElement != null && passwordElement != null) {
						userNameElement.sendKeys(userName);
						passwordElement.sendKeys(password);
						goButton.click();
						flag = true;
						waitUntillLoadingImageIsDisappeared(chromeDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
						Thread.sleep(7000);
						waitUntillLoadingImageIsDisappeared(chromeDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
						MaintanacePopUp(chromeDriver);
						Thread.sleep(4000);
						
				}
				
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
			wait = new WebDriverWait(chromeDriver, PropertiesRepository.getInt("global.driver.wait"));
    		List<WebElement> element = chromeDriver.findElements(By.cssSelector(locator));
    		if(CollectionUtils.isNotEmpty(element)) {
    			//wait.until(ExpectedConditions.visibilityOf(element.get(0)));
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

	
	
	public WebElement verifyElementupdate(String locator) throws DriverException {
		logger.info("verifyElement Start");
		WebElement webElement = null;
		try {
			List<WebElement> element = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(element)) {
				webElement = element.get(0);
			} else {
				logger.info("Unable to find element in verifyElement --> " + locator);
			}
		} catch (Exception e) {
			logger.info("Unable to verifyElement");
			log(logger, "Unable to verifyElement");
			throw new DriverException("Unable to verifyElement", e);
		}
		logger.info("verifyElement End");
		return webElement;
	}
/*	public webElement verifyElement(String locator) throws DriverException {
		logger.info("verifyElement Start");
		WebElement webElement = null;
		try {
			List<WebElement> element = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(element)) {
				webElement = element.get(0);
			} else {
				logger.info("Unable to find element in verifyElement --> " + locator);
			}
		} catch (Exception e) {
			logger.info("Unable to verifyElement");
			log(logger, "Unable to verifyElement");
			throw new DriverException("Unable to verifyElement", e);
		}
		logger.info("verifyElement End");
		return webElement;
	}*/
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
	 * @author Sasmita
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
//		logger.info("Method: verifyAndClick Starts");
//		boolean flag = false;
//    	try {
//    		WebElement element = verifyElement(chromeDriver, locator);
//    		if(element != null) {
//    			if(click) {
//    				//wait.until(ExpectedConditions.visibilityOf(element));
//    				element.click();
//    			}
//    			WebElement leftNavElement = verifyElement(chromeDriver, "#mainToolbar > span:nth-child(1)");
//    			if(leftNavElement !=null) {
//    				logger.info("Clicked with Normal click");
//    				flag = true;
//    				return flag;
//    			} else {
//    				try {
//						WebElement jsElement = verifyElement(chromeDriver, " img[class='sidebar-icon'][alt='Open Menu']");
//						JavascriptExecutor executor = (JavascriptExecutor)chromeDriver;
//						executor.executeAsyncScript("arguments[0].click();", jsElement);
//						flag = true;
//					} catch (Exception e) {
//						logger.info("Clicked on left Nav, but showing error");
//					}
//    				
//    				WebElement leftNavElementJS = verifyElement(chromeDriver, "div #side .sidebar-nav.flex-container.mat-sidenav.mat-sidenav-over.mat-sidenav-opened");
//    				//WebElement leftNavElementJS = null;
//        			if(leftNavElementJS !=null) {
//        				logger.info("Clicked with JS click");
//        				flag = true;
//        				return flag;
//        			} 
//    			}
//    		} else {
//    			logger.info("Unable to click on left navigation in verifyAndClick() Retrying to click on left navigation --> " + element);
//    			List<WebElement> leftNavElement = chromeDriver.findElements(By.cssSelector(locator));
//    			if(CollectionUtils.isNotEmpty(leftNavElement)) {
//    				leftNavElement.get(0).click();
//    			}
//    			
//    			WebElement leftNavElementRetry = verifyElement(chromeDriver, "div #side .sidebar-nav.flex-container.mat-sidenav.mat-sidenav-over.mat-sidenav-opened");
//    			if(leftNavElementRetry !=null) {
//    				logger.info("Clicked with Normal click");
//    				flag = true;
//    				return flag;
//    			} else {
//    				try {
//						WebElement jsElementRetry = verifyElement(chromeDriver, "img[class='sidebar-icon'][alt='Open Menu']");
//						JavascriptExecutor executor = (JavascriptExecutor)chromeDriver;
//						executor.executeAsyncScript("arguments[0].click();", jsElementRetry);
//						flag = true;
//					} catch (Exception e) {
//						logger.info("Clicked on left Nav, but showing error");
//					}
//    				
//    				WebElement leftNavElementJSRetry = verifyElement(chromeDriver, "div #side .sidebar-nav.flex-container.mat-sidenav.mat-sidenav-over.mat-sidenav-opened");
//    				//WebElement leftNavElementJS = null;
//        			if(leftNavElementJSRetry !=null) {
//        				logger.info("Clicked with JS click");
//        				flag = true;
//        				return flag;
//        			} 
//    			}
//    		}
    		logger.info("Method: verifyAndClick Starts");
    		boolean flag = false;
    		try {
    			WebElement element = verifyElement(chromeDriver,locator);
    			if (element != null) {
    				if (click) {
    					// element.click();
    					JavascriptExecutor executor = (JavascriptExecutor) chromeDriver;
    					executor.executeScript("arguments[0].click();", element);
//    					waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
    				}
    				flag = true;
    			}
    		} catch (Exception e) {
    			logger.info("Unable to verifyAndClick");
    			log(logger, "Unable to verifyAndClick");
    			throw new DriverException("Unable to verifyAndClick", e);
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
	 */
	public boolean verifyAndClick(WebDriver chromeDriver, String locator) throws NullPointerException, DriverException {
		logger.info("Method: verifyAndClick Starts");
		boolean flag = false;
		logger.info("Locator verifyAndClick --> " + locator);
    	try {
    		WebElement element = verifyElement(chromeDriver, locator);
    		logger.info("element verifyAndClick --> " + element);
    		if(element != null) {
    			element.click();
    			flag = true;
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
	 * Method used to verify element and if required, it will click with scroll option. 
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @param click
	 * @return
	 * @throws NullPointerException
	 * @throws DriverException
	 */
	public boolean verifyAndClickWithScroll(WebDriver chromeDriver, String locator, boolean click) throws NullPointerException, DriverException {
		logger.info("Method: verifyAndClick Starts");
		boolean flag = false;
    	try {
    		WebElement element = verifyElement(chromeDriver, locator);
    		if(element != null) {
    			if(click) {
    				((JavascriptExecutor) chromeDriver).executeScript("arguments[0].scrollIntoView(true);", element);
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
    			/*if(flag) {
    				Thread.sleep(30000);
    				log(logger, "Clicking on Refersh Button in clickIgnoreRadioButton Start");
    				scrollToElement(chromeDriver, "#ctl00_contentPlaceHolderBody_ucMonitorTests_btnAddMonitor");
    				clickButtonWith30SecWait(chromeDriver,
    						"#btnRefreshBottom");
    				scrollToElement(chromeDriver, "#ctl00_contentPlaceHolderBody_ucMonitorTests_btnAddMonitor");
    				log(logger, "Clicking on Refersh Button in clickIgnoreRadioButton End");
    			}*/
    		}
    		/*s*/
    		//windowHandler.switchToLatestWindow();
    	} catch (Exception e) {
    		//windowHandler.switchToLatestWindow();
    		logger.info("Unable to clickIgnoreRadioButton");
			log(logger, "Unable to clickIgnoreRadioButton" );
    		throw new DriverException("Unable to clickIgnoreRadioButton" , e); 
    	}
    	logger.info("Method: clickIgnoreRadioButton End flag --> " + flag);
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
		logger.info("Method: enteringProctIdAndPwd Starts");
		boolean flag = false;
    	try {
    		/*id = "12565935";
    		password = "22Z5484A52";*/
    		//wait = new WebDriverWait(chromeDriver, PropertiesRepository.getInt("global.driver.wait"));
    		swithToProctorFrame(chromeDriver);
    		WebElement idElement = verifyElement(chromeDriver, PropertiesRepository.getString("id.proctor.id.loc"));
    		WebElement pwdElement = verifyElement(chromeDriver, PropertiesRepository.getString("id.proctor.password.loc"));
    		WebElement submitElement  = verifyElement(chromeDriver, PropertiesRepository.getString("id.proctor.submit.loc"));
    		//wait.until(ExpectedConditions.elementToBeClickable(idElement));
    		//wait.until(ExpectedConditions.elementToBeClickable(pwdElement));
    		//wait.until(ExpectedConditions.elementToBeClickable(submitElement));
    		if(idElement != null && pwdElement != null && submitElement != null) {
    			idElement.sendKeys(id);
    			pwdElement.sendKeys(password);
    			waitUntillLoadingImageIsDisappeared(chromeDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
    			submitElement.click();
    			Thread.sleep(20000);
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
//    		if(idElement != null && pwdElement != null && submitElement != null) {
//    			Thread.sleep(10000);
//    			idElement.sendKeys(id);
//    			pwdElement.sendKeys(password);
//    			submitElement.click();
//    			Thread.sleep(20000);
////    			waitUntillLoadingImageIsAppeared(chromeDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
////    			waitUntillLoadingImageIsDisappeared(chromeDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
//    			for(int i = 0; i < 5; i++) {
//    				Thread.sleep(1000);
//	    			WebElement submitElementAnotherTime  = verifyElement(chromeDriver, PropertiesRepository.getString("id.proctor.submit.loc"));
//	    			if(submitElementAnotherTime != null) {
//	    				logger.info("If still not clicked, clicking Submit button "+ i +" time(s)");
//	    				submitElementAnotherTime.click();
//	    				waitUntillLoadingImageIsDisappeared(chromeDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
//	    			} else {
//	    				break;
//	    			}
//	    			//i++;
//    			}
//    		}
//    		Thread.sleep(10000);
//    		//windowHandler.switchToLatestWindow();
//    	} catch (Exception e) {
//    		//windowHandler.switchToLatestWindow();
//    		logger.info("Unable to enteringProctIdAndPwd");
//			log(logger, "Unable to enteringProctIdAndPwd" );
//    		throw new DriverException("Unable to enteringProctIdAndPwd" , e); 
//    	}
//    	logger.info("Method: enteringProctIdAndPwd End");
//	}
	


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
    		waitUntillLoadingImageIsDisappeared(chromeDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
    		List<WebElement> element = chromeDriver.findElements(By.cssSelector(PropertiesRepository.getString("id.home.page.proctor.left.navigator.icon.link")));
    		logger.info("element list --> " + element.size());
    		if(CollectionUtils.isNotEmpty(element)) {
    			int size = element.size();
    			for(int index = 0; index < size; index++) {
    				waitUntillLoadingImageIsDisappeared(chromeDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
    				WebElement navElement = element.get(index);
    				   				
    				
    				logger.info("leftNavName left nav value --> " + navElement.getText().trim());
        			if(navElement != null && navElement.getText().trim().equalsIgnoreCase(leftNavName)) {
        				flag = true;
        				if(click) {
        					navElement.click();
        					break;
        				}
        			} else {
        				logger.info("Not able to get left navigation names, so trying again");
        				
        				List<WebElement> elementAgain = chromeDriver.findElements(By.cssSelector(PropertiesRepository.getString("id.home.page.proctor.left.navigator.icon.link")));
        	    		if(CollectionUtils.isNotEmpty(elementAgain)) {
        	    			int sizeAgain = elementAgain.size();
        	    			for(int indexAgain = 0; indexAgain < sizeAgain; indexAgain++) {
        	    				waitUntillLoadingImageIsDisappeared(chromeDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
        	    				WebElement navElementAgain = elementAgain.get(indexAgain);
        	    				logger.info("leftNavName left nav value --> " + navElementAgain.getText().trim());
        	        			if(navElementAgain != null && navElementAgain.getText().trim().equalsIgnoreCase(leftNavName)) {
        	        				flag = true;
        	        				if(click) {
        	        					navElementAgain.click();
        	        					break;
        	        				}
        	        			} 
        	    			}
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
	 * Mthod used to verify left navigation name and click if required. 
	 * 
	 * @author saravanan.jothimani
	 * @param leftNavName
	 * @param click
	 * @return
	 * @throws DriverException
	 */
	public boolean verifyLeftNavigationTextSearchUpdated(WebDriver chromeDriver, String leftNavName, boolean click) throws DriverException {
		logger.info("Method: verifyLeftNavigationTextSearchUpdated Starts");
		logger.info("leftNavName --> " + leftNavName);
		logger.info("leftNavName Locator --> " + PropertiesRepository.getString("id.home.page.proctor.left.navigator.icon.link"));
		boolean flag = false;
    	try {
    		waitUntillLoadingImageIsDisappeared(chromeDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
    		List<WebElement> element = chromeDriver.findElements(By.cssSelector(PropertiesRepository.getString("id.home.page.proctor.left.navigator.icon.link")));
    		logger.info("element list --> " + element.size());
//    		if(CollectionUtils.isNotEmpty(element)) {
//    			int size = element.size();
//    			for(int index = 0; index < size; index++) {
//    				waitUntillLoadingImageIsDisappeared(chromeDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
//    				WebElement navElement = element.get(index);
//					for (int i = 0; i < 5; i++) {
//						if (element.get(index).getText().isEmpty()) {
//							logger.info("Clicking on Top left icon for left navigation --> " + i);
//								verifyAndClick(chromeDriver,PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true);
//								break;							
//						}
//					}   				  				
//    				logger.info("leftNavName left nav value --> " + navElement.getText().trim());
//        			if(navElement != null && navElement.getText().trim().equalsIgnoreCase(leftNavName)) {
//        				flag = true;
//        				if(click) {
//        					navElement.click();
//        					break;
//        				}
//        			}
//    			}
    				if(CollectionUtils.isNotEmpty(element)) {
    	    			int size = element.size();
    	    			for(int index = 0; index < size; index++) {
    						WebElement navElement = element.get(index);
    						if (navElement != null && navElement.getText().trim().contains(leftNavName)) {
    							flag = true;
    							if (click) {
    								navElement.click();
    								
    								Thread.sleep(10000);
    								break;
    							}
    						}
    	    			}
    	    		}
    		
    	} catch (Exception e) {
    		logger.info("Unable to verifyLeftNavigationTextSearchUpdated");
			log(logger, "Unable to verifyLeftNavigationTextSearchUpdated" );
    		throw new DriverException("Unable to verifyLeftNavigatioverifyLeftNavigationTextSearchUpdatednTextSearch" , e); 
    	}
    	logger.info("Method: verifyLeftNavigationTextSearchUpdated End flag --> " + flag);
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
    		//wait = new WebDriverWait(chromeDriver, PropertiesRepository.getInt("global.driver.wait"));
    		windowHandler.switchToLatestWindow();
    		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card-shadow")));
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
	 * Method used to switch to PDF Frame.
	 * 
	 * @author saravanan.jothimani
	 * @throws DriverException
	 */
	public void swithToProctorFrameHeadingMargin(WebDriver chromeDriver) throws DriverException {
		logger.info("Method: swithToProctorFrameHeadingMargin Starts");
		windowHandler.switchToLatestWindow();
    	try {
    		//wait = new WebDriverWait(chromeDriver, PropertiesRepository.getInt("global.driver.wait"));
    		//windowHandler.switchToLatestWindow();
    		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card-shadow")));
    		List<WebElement> iframe = chromeDriver.findElements(By.cssSelector(".card-shadow"));
    		if(CollectionUtils.isNotEmpty(iframe)) {
    			chromeDriver.switchTo().frame(iframe.get(0));
    		}
    	} catch (Exception e) {
    		windowHandler.switchToLatestWindow();
    		logger.info("Unable to swithToProctorFrameHeadingMargin" );
			log(logger, "Unable to swithToProctorFrameHeadingMargin" );
    		throw new DriverException("Unable to swithToProctorFrameHeadingMargin" , e); 
    	}
    	logger.info("Method: swithToProctorFrameHeadingMargin End " );
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
//		try {
//			swithToProctorFrame(chromeDriver);
//			List<WebElement> welcomeElement = chromeDriver
//					.findElements(By.cssSelector(PropertiesRepository
//							.getString("faculty.portal.product.select.activity.proctor.assessment.proctor.authentication.page.welcome.message.loc")));
//
//			if (CollectionUtils.isNotEmpty(welcomeElement)) {
//				WebElement element = chromeDriver.findElement(By.cssSelector(locator));
//				if(element != null && element.isDisplayed()) {
//					((JavascriptExecutor) chromeDriver).executeScript("arguments[0].scrollIntoView(true);", element);
//					element.clear();
//					element.sendKeys(text);
//				}
//				/*if (chromeDriver
//						.findElement(By.cssSelector(locator)).isDisplayed()) {
//					((JavascriptExecutor) chromeDriver).executeScript("arguments[0].scrollIntoView(true);", welcomeElement.get(0));
//					chromeDriver.findElement(By.cssSelector(locator)).clear();
//					chromeDriver.findElement(By.cssSelector(locator)).sendKeys(text);
//				}*/
//			}
//			switchToLatestWindow(chromeDriver);
//		} catch (Exception e) {
//			switchToLatestWindow(chromeDriver);
//			logger.info("Unable to enter Electornic Signature");
//			log(logger, "Unable to enter Electornic Signature");
//			throw new DriverException("Unable to enter Electornic Signature", e);
//		}
//		logger.info("Method: enterElectornicSignature End ");
//	}
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
					WebElement proceedButtonElement = chromeDriver.findElement(By.cssSelector(PropertiesRepository
							.getString("faculty.portal.product.select.activity.proctor.assessment.proceed.button.loc")));
					if(proceedButtonElement != null) {
						((JavascriptExecutor) chromeDriver).executeScript("arguments[0].scrollIntoView(true);", proceedButtonElement);
						proceedButtonElement.click();
					}
					/*chromeDriver.findElement(By.cssSelector(PropertiesRepository
							.getString("faculty.portal.product.select.activity.proctor.assessment.proceed.button.loc"))).click();*/
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
	
	//#ctl00_contentPlaceHolderBody_ucMonitorTests_btnAddMonitor
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
			//windowHandler.switchToLatestWindow();
			//waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		} catch (Exception e) {
			//windowHandler.switchToLatestWindow();
			logger.info("Unable to scrollToElement");
			log(logger, "Unable to scrollToElement");
			throw new DriverException("Unable to scrollToElement", e);
		}
		logger.info("Method: scrollToElement Ends flag--> " + flag);
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
	public boolean clickButtonWith30SecWait(WebDriver chromeDriver, String loc) throws NullPointerException, DriverException {
		logger.info("Method: clickButtonWith30SecWait Starts -->" + loc);
		boolean flag = false;
		try {
			swithToProctorFrame(chromeDriver);
			List<WebElement> element = chromeDriver
					.findElements(By.cssSelector(loc));
			logger.info( "clickButtonWith30SecWait element size --> " + element.size());
			if (CollectionUtils.isNotEmpty(element)) {
				logger.info("Clicking with Selenium click in clickButtonWith30SecWait in main");
				//((JavascriptExecutor) chromeDriver).executeScript("arguments[0].scrollIntoView(true);", element.get(0));
				element.get(0).click();
				flag = true;
			} else {
				logger.info("Trying with Javascript click in clickButtonWith30SecWait in main");
				List<WebElement> elementAgain = chromeDriver
						.findElements(By.cssSelector(loc));
				logger.info( "clickButtonWith30SecWait element size again--> " + elementAgain.size());
				if (CollectionUtils.isNotEmpty(elementAgain)) {
					JavascriptExecutor executor = (JavascriptExecutor)driver;
					executor.executeScript("arguments[0].click();", elementAgain.get(0));
					logger.info("Clicked with Javascript click in clickButtonWith30SecWait");
				}
			}
			//windowHandler.switchToLatestWindow();
			//waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		} catch (Exception e) {
			//windowHandler.switchToLatestWindow();
			logger.info("Unable to click button with WebElement");
			try {
				logger.info("Trying with Javascript click in clickButtonWith30SecWait ");
				List<WebElement> elementAgain = chromeDriver
						.findElements(By.cssSelector(loc));
				logger.info( "clickButtonWith30SecWait element size again--> " + elementAgain.size());
				if (CollectionUtils.isNotEmpty(elementAgain)) {
					JavascriptExecutor executor = (JavascriptExecutor)driver;
					executor.executeScript("arguments[0].click();", elementAgain.get(0));
					logger.info("Clicked with Javascript click in clickButtonWith30SecWait");
				}
			} catch (Exception jse) {
				log(logger, "Unable to click Button With javascript 30 Sec Wait ");
				throw new DriverException("Unable to click Button With 30 Sec Wait", jse);
			}
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
			if(element.size() ==0)
			{
				logger.info("Approve button is still not visible, so clicking refresh button again");
				Thread.sleep(10000);
				clickButtonWith30SecWait(chromeDriver, "#btnRefreshBottom");
			}
			if (CollectionUtils.isNotEmpty(element) && element.size() == 1) {
				//((JavascriptExecutor) chromeDriver).executeScript("arguments[0].scrollIntoView(true);", element.get(0));
				element.get(0).click();
				for(int i = 0; i < 5; i++) {
					logger.info("Clicked on " + i + " iteration");
					WebElement radioElement = element.get(0);
					if(radioElement.isSelected()) {
						flag = true;
						break;
					} else {
						radioElement.click();
						logger.info("Clicking with Selenium click in clickButtonWith30SecWaitApprove");
					}
				}
			} else {
				logger.info("Trying with Javascript click in clickButtonWith30SecWaitApprove");
				List<WebElement> elementAgain = chromeDriver
						.findElements(By.cssSelector("#ctl00_contentPlaceHolderBody_ucMonitorTests_DataGridStudent_ctl02_ctl00"));
				if (CollectionUtils.isNotEmpty(elementAgain) && elementAgain.size() == 1) {
					//((JavascriptExecutor) chromeDriver).executeScript("arguments[0].scrollIntoView(true);", elementAgain.get(0));
					elementAgain.get(0).click();
					for(int i = 0; i < 5; i++) {
						logger.info("Clicked on " + i + " iteration");
						WebElement radioElementAgain = elementAgain.get(0);
						if(radioElementAgain.isSelected()) {
							flag = true;
							break;
						} else {
							radioElementAgain.click();
							logger.info("Clicked with Javascript click in clickButtonWith30SecWaitApprove");
						}
					}
				}
			}
			//windowHandler.switchToLatestWindow();
			//waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		} catch (Exception e) {
			//windowHandler.switchToLatestWindow();
			logger.info("Unable to click Button With 30 Sec Wait");
			log(logger, "Unable to click Button With 30 Sec Wait");
			throw new DriverException("Unable to click Button With 30 Sec Wait", e);
		}
		logger.info("Method: clickButtonWith30SecWaitApprove Ends flag --> " + flag);
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
			//windowHandler.switchToLatestWindow();
		}catch (Exception e) {
			//windowHandler.switchToLatestWindow();
    		logger.info("Unable to checkStopTestCheckBox" );
			log(logger, "Unable to checkStopTestCheckBox" );
    		throw new DriverException("Unable to checkStopTestCheckBox" , e); 
    	}
		logger.info("Method: checkStopTestCheckBox End flag --> " + flag);
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
    			/*if(flag) {
    				Thread.sleep(30000);
    				log(logger, "Clicking on Refersh Button in clickStudentStatusForStopOrDeny Start");
    				scrollToElement(chromeDriver, "#ctl00_contentPlaceHolderBody_ucMonitorTests_btnAddMonitor");
    				clickButtonWith30SecWait(chromeDriver,
    						"#btnRefreshBottom");
    				scrollToElement(chromeDriver, "#ctl00_contentPlaceHolderBody_ucMonitorTests_btnAddMonitor");
    				log(logger, "Clicking on Refersh Button in clickStudentStatusForStopOrDeny End");
    			}*/
    		}
    		/*s*/
    		//windowHandler.switchToLatestWindow();
    	} catch (Exception e) {
    		//windowHandler.switchToLatestWindow();
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
	public boolean clickStopTestCheckBoxButton(WebDriver chromeDriver) throws NullPointerException, DriverException {
		logger.info("Method: clickStopTestCheckBoxButton Starts");
		boolean flag = false;
    	try {
    		swithToProctorFrame(chromeDriver);
    		// Getting the list of ignore radio button and clicking on it. 
    		
    		List<WebElement> stopTestElement = verifyElementList(chromeDriver, "input[id*='ctl00_contentPlaceHolderBody_ucMonitorTests_DataGridStudent']");
    		if(CollectionUtils.isNotEmpty(stopTestElement)) {
    			int size = stopTestElement.size();
    			for(int index = 0; index < size; index++) {
    				WebElement inputElement =stopTestElement.get(index);
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
    		//windowHandler.switchToLatestWindow();
    	} catch (Exception e) {
    		//windowHandler.switchToLatestWindow();
    		logger.info("Unable to clickStopTestCheckBoxButton");
			log(logger, "Unable to clickStopTestCheckBoxButton" );
    		throw new DriverException("Unable to clickStopTestCheckBoxButton" , e); 
    	}
    	logger.info("Method: clickStopTestCheckBoxButton End flag --> " + flag);
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
    			}Thread.sleep(40000);
    			/*if(flag) {
    				Thread.sleep(30000);
    				log(logger, "Clicking on Refersh Button in clickCloseButtonInStoppedAssessmentSection Start");
    				scrollToElement(chromeDriver, "#ctl00_contentPlaceHolderBody_ucMonitorTests_btnAddMonitor");
    				clickButtonWith30SecWait(chromeDriver,
    						"#btnRefreshBottom");
    				scrollToElement(chromeDriver, "#ctl00_contentPlaceHolderBody_ucMonitorTests_btnAddMonitor");
    				log(logger, "Clicking on Refersh Button in clickCloseButtonInStoppedAssessmentSection End");
    			}*/
    		}
    		/*s*/
    		//windowHandler.switchToLatestWindow();
    		
    		log(logger, "Clicking on Refersh Button in clickCloseButtonInStoppedAssessmentSection Start");
    		scrollToElement(chromeDriver, "#ctl00_contentPlaceHolderBody_ucMonitorTests_btnAddMonitor");
    		clickButtonWith30SecWait(chromeDriver,
    				"#btnRefreshBottom");
    		scrollToElement(chromeDriver, "#ctl00_contentPlaceHolderBody_ucMonitorTests_btnAddMonitor");
    		log(logger, "Clicking on Refersh Button in clickCloseButtonInStoppedAssessmentSection End");
    		
    	} catch (Exception e) {
    		//windowHandler.switchToLatestWindow();
    		logger.info("Unable to clickCloseButtonInStoppedAssessmentSection");
			log(logger, "Unable to clickCloseButtonInStoppedAssessmentSection" );
    		throw new DriverException("Unable to clickCloseButtonInStoppedAssessmentSection" , e); 
    	}	
		
		
    	logger.info("Method: clickCloseButtonInStoppedAssessmentSection End flag --> " + flag);
    	return flag;
	}

	/**
	 * Method used to verify element and if required, it will click. 
	 * @author Vaishali.Katta
	 */
	public boolean verifyAndClick2(WebDriver chromeDriver, String locator, boolean click) throws DriverException {
		logger.info("Method: verifyAndClick2 Starts");
		boolean flag = false;
    	try {
    		waitUntillLoadingImageIsDisappeared(chromeDriver, PropertiesRepository.getString("id.common.page.loader"));
    		wait = new WebDriverWait(chromeDriver, PropertiesRepository.getInt("global.driver.wait"));
    		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locator)));
    		chromeDriver.findElement(By.cssSelector(locator)).click();
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PropertiesRepository.getString("id.home.page.sidebar.header"))));
    		flag = chromeDriver.findElement(By.cssSelector(PropertiesRepository.getString("id.home.page.sidebar.header"))).isDisplayed();    			
    	} catch (Exception e) {
    		logger.info("Unable to verifyAndClick");
			log(logger, "Unable to verifyAndClick" );
    		throw new DriverException("Unable to verifyAndClick" , e); 
    	}
    	logger.info("Method: verifyAndClick2 End flag --> " + flag);
    	return flag;
	}
	
	/**
	 * Method used to dismiss the alert. 
	 * @author Vaishali.Katta
	 */
	public void closeAlert(WebDriver chromeDriver) throws DriverException {
		logger.info("Method: closeAlert Starts");
		wait = new WebDriverWait(chromeDriver, PropertiesRepository.getInt("global.driver.wait"));
    	try {
    		waitUntillLoadingImageIsDisappeared(chromeDriver, PropertiesRepository.getString("id.common.page.loader"));
    		Thread.sleep(5000);
    		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(PropertiesRepository.getString("id.home.page.alert.link"))));
        	chromeDriver.findElement(By.cssSelector(PropertiesRepository.getString("id.home.page.alert.link"))).click();
    	} catch (Exception e) {
    		logger.info("Unable to closeAlert");
			log(logger, "Unable to closeAlert" );
    		throw new DriverException("Unable to close the Alert" , e); 
    	}
    	logger.info("Method: closeAlert End flag --> ");
	}
	
	/**
	 * Method used verify Proctor Monitor page 
	 * @author Vaishali.Katta
	 */
	public boolean verifyMonitorPageDisplayed(WebDriver chromeDriver) throws DriverException {
		logger.info("Method: verifyMonitorPageDisplayed Starts");
		boolean flag = false;
    	try {    	
    		wait = new WebDriverWait(chromeDriver, PropertiesRepository.getInt("global.driver.wait"));
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PropertiesRepository.getString("id.proctor.monitor.page.assessment.button"))));
    		flag = chromeDriver.findElement(By.cssSelector(PropertiesRepository.getString("id.proctor.monitor.page.assessment.button"))).isDisplayed();
    	} catch (Exception e) {
    		logger.info("Unable to verify monitor proctor page");
			log(logger, "Unable to verify proctor monitor page" );
    		throw new DriverException("Unable to close the Alert" , e); 
    	}
    	logger.info("Method: verifyMonitorPageDisplayed End flag --> "+flag);
		return flag;
	}
	
	/**
	 * Method used verify Proctor Monitor page 
	 * @author Vaishali.Katta
	 */
	public String getAssessmentName(WebDriver chromeDriver) throws DriverException {
		logger.info("Method: getAssessmentName Starts");
		String assessmentName = null;
    	try {    	
    		wait = new WebDriverWait(chromeDriver, PropertiesRepository.getInt("global.driver.wait"));
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PropertiesRepository.getString("id.proctor.monitor.page.assessment.name"))));
    		assessmentName = chromeDriver.findElement(By.cssSelector(PropertiesRepository.getString("id.proctor.monitor.page.assessment.name"))).getText();
    	} catch (Exception e) {
    		logger.info("Unable to get assessment name");
			log(logger, "Unable to get assessment name" );
    		throw new DriverException("Unable to verify button" , e); 
    	}
    	logger.info("Method: getAssessmentName End flag --> ");
		return assessmentName;
	}
	
	/**
	 * Method used click Submit/Refresh button
	 * @author Vaishali.Katta
	 */
	public void clickSubmitRefreshButton(WebDriver chromeDriver) throws DriverException {
		logger.info("Method: clickSubmitRefreshButton Starts");
    	try {    	
    		wait = new WebDriverWait(chromeDriver, PropertiesRepository.getInt("global.driver.wait"));
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PropertiesRepository.getString("id.proctor.monitor.page.refresh.button"))));
    		Thread.sleep(35000);
    		chromeDriver.findElement(By.cssSelector(PropertiesRepository.getString("id.proctor.monitor.page.refresh.button"))).click();
    	} catch (Exception e) {
    		logger.info("Unable to click on Submit/Refresh button");
			log(logger, "Unable to on Submit/Refresh button" );
    		throw new DriverException("Unable to click on Submit/Refresh button" , e); 
    	}
    	logger.info("Method: clickSubmitRefreshButton End ");
	}
	
	/**
	 * After clicking on Approve button, the application itself will wait for 30 sec. 
	 * so, this method will wait for 30 sec and click on refresh button. 
	 * 
	 * @param loc
	 * @throws NullPointerException
	 * @throws DriverException
	 */
	public boolean clickButtonWith30SecWait2(WebDriver chromeDriver, String loc) throws NullPointerException, DriverException {
		logger.info("Method: clickButtonWith30SecWait2 Starts --> " + loc);
		boolean flag=false;
		try {
			wait = new WebDriverWait(chromeDriver, PropertiesRepository.getInt("global.driver.wait"));
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(loc)));
			chromeDriver.findElement(By.cssSelector(loc)).click();
		} catch (Exception e) {
			logger.info("Unable to click Button With 30 Sec Wait");
			log(logger, "Unable to click Button With 30 Sec Wait");
			throw new DriverException("Unable to click Button With 30 Sec Wait", e);
		}
		logger.info("Method: clickButtonWith30SecWait2 Ends flag--> ");
		return flag;
	}
	
	/**
	 * Method used verify Proctor Monitor page 
	 * @author Vaishali.Katta
	 */
	public boolean verifyButtonAndClick(WebDriver chromeDriver, String locator) throws DriverException {
		logger.info("Method: verifyButtonAndClick Starts");
		boolean flag = false;
    	try {    	
    		wait = new WebDriverWait(chromeDriver, PropertiesRepository.getInt("global.driver.wait"));
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
    		flag = chromeDriver.findElement(By.cssSelector(locator)).isDisplayed();
    		chromeDriver.findElement(By.cssSelector(locator)).click();
    		Thread.sleep(35000);
    	} catch (Exception e) {
    		logger.info("Unable to verify button");
			log(logger, "Unable to verify button" );
    		throw new DriverException("Unable to verify button" , e); 
    	}
    	logger.info("Method: verifyButtonAndClick End flag --> "+flag);
		return flag;
	}
	
	/**
	 * Method used to verify proctor Frame 
	 * @author Vaishali.Katta
	 */
	public boolean verifyAnotherProctorAssessmentInputFrame(WebDriver chromeDriver, String locator) throws DriverException {
		logger.info("Method: verifyAnotherProctorAssessmentInputFrame Starts");
		boolean flag = false;
    	try {
    		wait = new WebDriverWait(chromeDriver, PropertiesRepository.getInt("global.driver.wait"));
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
    		flag = chromeDriver.findElement(By.cssSelector(locator)).isDisplayed();
    	} catch (Exception e) {
    		logger.info("Unable to verify proctor input frame" );
			log(logger, "Unable to verify proctor input frame" );
    		throw new DriverException("Unable to verifyProctorInputFrame" , e); 
    	}
    	logger.info("Method: verifyAnotherProctorAssessmentInputFrame End " );
		return flag;
	}

	/**
	 * Method used to verify manage students window displayed
	 * @author Vaishali.Katta
	 */
	public boolean verifyManageStudentsWindowDisplayedAndClose(WebDriver chromeDriver, String mainHandle) throws DriverException, InterruptedException{
		logger.info("verifyManageStudentsWindowDisplayedAndClose Start");
		log(logger, "Verify that expected link is open after clicking on Launch");
		boolean flag=false;
		try {
			Thread.sleep(2000);
			chromeDriver.switchTo().window(Iterables.getLast(chromeDriver.getWindowHandles()));
			logger.info("Switching to window : " + chromeDriver.getCurrentUrl());
			flag=chromeDriver.getCurrentUrl().contains("ManageStudents");
			chromeDriver.close();
			chromeDriver.switchTo().window(mainHandle);
		}catch(NoSuchElementException e){
			throw new DriverException("Unable to verify manage students window ", e);
		}
		logger.info("verifyManageStudentsWindowDisplayedAndClose End "+flag);
		return flag;
	}
	
	/**
	 * Method used to verify auto refresh/Submit timings
	 * @author Vaishali.Katta
	 */
	public boolean verifyAutoRefreshAndSubmitTimings(WebDriver chromeDriver, String newTime) throws DriverException{
		logger.info("verifyAutoRefreshAndSubmitTimings Start");
		boolean flag=false;
		wait = new WebDriverWait(chromeDriver, PropertiesRepository.getInt("global.driver.wait"));
		try {
			Thread.sleep(2000);
			WebElement webElement = chromeDriver.findElement(By.cssSelector(PropertiesRepository.getString("id.proctor.monitor.page.autorefresh.textfield")));
			webElement.clear();
			webElement.sendKeys(newTime);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PropertiesRepository.getString("id.proctor.monitor.page.updatetime.button"))));
			chromeDriver.findElement(By.cssSelector(PropertiesRepository.getString("id.proctor.monitor.page.updatetime.button"))).click();
			flag = webElement.getAttribute("value").equalsIgnoreCase(newTime);
		}catch(Exception e){
			throw new DriverException("Unable to verify auto refresh/Submit timings", e);
		}
		logger.info("verifyAutoRefreshAndSubmitTimings End "+flag);
		return flag;
	}
	
	/**
	 * Method used to select and enter cohort
	 * @author Vaishali.Katta
	 */
	public void selectAndEnterCohortWithToggleOnOff(WebDriver chromeDriver, String cohortName) throws DriverException{
		logger.info("selectAndEnterCohortWithToggleOnOff Start");
		wait = new WebDriverWait(chromeDriver, PropertiesRepository.getInt("global.driver.wait"));
		try {
			waitUntillLoadingImageIsAppeared(chromeDriver, PropertiesRepository.getString("id.common.page.loader"));
			chromeDriver.findElement(By.cssSelector(PropertiesRepository.getString("id.home.page.cohort.select.text"))).click();
			chromeDriver.findElement(By.cssSelector(PropertiesRepository.getString("id.home.page.cohort.enter.textfield"))).sendKeys("pulse");
			Thread.sleep(1000);
			chromeDriver.findElement(By.cssSelector(PropertiesRepository.getString("id.home.page.cohort.enter.textfield"))).sendKeys("again");
			chromeDriver.findElement(By.cssSelector(PropertiesRepository.getString("id.home.page.cohort.selected.textfield"))).click();
			waitUntillLoadingImageIsAppeared(chromeDriver, PropertiesRepository.getString("id.common.page.loader"));
			chromeDriver.findElement(By.cssSelector(PropertiesRepository.getString("id.home.page.cohort.toggle"))).click();
			waitUntillLoadingImageIsAppeared(chromeDriver, PropertiesRepository.getString("id.common.page.loader"));
			chromeDriver.findElement(By.cssSelector(PropertiesRepository.getString("id.home.page.cohort.save.button"))).click();
		}catch(Exception e){
			throw new DriverException("Unable to select and enter cohort", e);
		}
		logger.info("selectAndEnterCohortWithToggleOnOff End ");
	}
	
	/**
	 * Method used to switch to Product frame
	 * @author Vaishali.Katta
	 */
	public void swithToProductFrame(WebDriver chromeDriver) throws DriverException {
		logger.info("Method: swithToProductFrame Starts");
		wait = new WebDriverWait(chromeDriver, PropertiesRepository.getInt("global.driver.wait"));
    	try {
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card-shadow")));
    		List<WebElement> iframe = chromeDriver.findElements(By.cssSelector(".card-shadow"));
    		if(CollectionUtils.isNotEmpty(iframe)) {
    			chromeDriver.switchTo().frame(iframe.get(0));
    		}
    	} catch (Exception e) {
    		logger.info("Unable to swithToProductFrame" );
			log(logger, "Unable to swithToProductFrame" );
    		throw new DriverException("Unable to swithToProductFrame" , e); 
    	}
    	logger.info("Method: swithToProductFrame End " );
	}
	
	/**
	 * Method used to enable/disable practice assessments
	 * @author Vaishali.Katta
	 */
	public void enableDisablePracticeAssessmentsAndSave(WebDriver chromeDriver, String assessmentName) throws DriverException{
		logger.info("enableDisablePracticeAssessmentsAndSave Start");
		wait = new WebDriverWait(chromeDriver, PropertiesRepository.getInt("global.driver.wait"));
		JavascriptExecutor jse = (JavascriptExecutor)chromeDriver;
		//String loc1 = ".products_tableGrid>tbody>tr:contains('RN Comprehensive Online Practice 2016 A')>td:nth-child(6)>input";
		WebElement webElement = null;
		String id = null; int count = 1;
		try {
			String mainHandle = chromeDriver.getWindowHandle();
			swithToProductFrame(chromeDriver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PropertiesRepository.getString("id.product.page.practice.assessment.tab"))));
			chromeDriver.findElement(By.cssSelector(PropertiesRepository.getString("id.product.page.practice.assessment.tab"))).click();
			waitUntillLoadingImageIsDisappeared(chromeDriver, PropertiesRepository.getString("id.common.page.loader"));
			chromeDriver.switchTo().window(mainHandle);
			Thread.sleep(10000);
			//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(PropertiesRepository.getString("id.product.page.practice.assessment.all.rows"))));
			List<WebElement> allRows = chromeDriver.findElements(By.cssSelector(PropertiesRepository.getString("id.product.page.practice.assessment.all.rows")));
			for (WebElement row : allRows) {
				count = count+1;
				if (row.getText().contains(assessmentName)) {
					if (count<10) {
						id = "#ctl00_contentPlaceHolderBody_ucProductsPracticeAssessments_gvProductsProctoredAssessment_ctl0"+count+"_imgbtnEnableDisableAssessment";
						System.out.println("id --------->" +id);
						break;
					}else {
						id = "#ctl00_contentPlaceHolderBody_ucProductsPracticeAssessments_gvProductsProctoredAssessment_ctl"+count+"_imgbtnEnableDisableAssessment";
						break;
					}						
				}
			}
			waitUntillLoadingImageIsDisappeared(chromeDriver, PropertiesRepository.getString("id.common.page.loader"));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(id)));
			jse.executeScript("arguments[0].click();", chromeDriver.findElement(By.cssSelector(id)));
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PropertiesRepository.getString("id.product.page.practice.assessment.tab.save.button"))));
			webElement=chromeDriver.findElement(By.cssSelector(PropertiesRepository.getString("id.product.page.practice.assessment.tab.save.button")));
			jse.executeScript("arguments[0].click();", webElement);
			waitUntillLoadingImageIsDisappeared(chromeDriver, PropertiesRepository.getString("id.common.page.loader"));
		}catch(Exception e){
			throw new DriverException("Unable to enable and disable assessment", e);
		}
		logger.info("enableDisablePracticeAssessmentsAndSave End ");
	}
	
	/**
	 * Method used to enable/disable practice assessments
	 * @author Vaishali.Katta
	 */
	public void enableDisablePracticeAssessmentsAndSaveWithoutSwitch(WebDriver chromeDriver, String assessmentName) throws DriverException{
		logger.info("enableDisablePracticeAssessmentsAndSaveWithoutSwitch Start");
		wait = new WebDriverWait(chromeDriver, PropertiesRepository.getInt("global.driver.wait"));
		JavascriptExecutor jse = (JavascriptExecutor)chromeDriver;
		WebElement webElement = null;
		String id = null; int count = 1;
		try {
			String mainHandle = chromeDriver.getWindowHandle();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PropertiesRepository.getString("id.product.page.practice.assessment.tab"))));
			chromeDriver.findElement(By.cssSelector(PropertiesRepository.getString("id.product.page.practice.assessment.tab"))).click();
			waitUntillLoadingImageIsDisappeared(chromeDriver, PropertiesRepository.getString("id.common.page.loader"));
			Thread.sleep(10000);
			//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(PropertiesRepository.getString("id.product.page.practice.assessment.all.rows"))));
			List<WebElement> allRows = chromeDriver.findElements(By.cssSelector(PropertiesRepository.getString("id.product.page.practice.assessment.all.rows")));
			for (WebElement row : allRows) {
				count = count+1;
				if (row.getText().contains(assessmentName)) {
					if (count<10) {
						id = "#ctl00_contentPlaceHolderBody_ucProductsPracticeAssessments_gvProductsProctoredAssessment_ctl0"+count+"_imgbtnEnableDisableAssessment";
						System.out.println("id without switch -----> "+id);
						break;
					}else {
						id = "#ctl00_contentPlaceHolderBody_ucProductsPracticeAssessments_gvProductsProctoredAssessment_ctl"+count+"_imgbtnEnableDisableAssessment";
						break;
					}						
				}
			}
			waitUntillLoadingImageIsDisappeared(chromeDriver, PropertiesRepository.getString("id.common.page.loader"));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(id)));
			jse.executeScript("arguments[0].click();", chromeDriver.findElement(By.cssSelector(id)));
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(PropertiesRepository.getString("id.product.page.practice.assessment.tab.save.button"))));
			webElement=chromeDriver.findElement(By.cssSelector(PropertiesRepository.getString("id.product.page.practice.assessment.tab.save.button")));			
			jse.executeScript("arguments[0].click();", webElement);
			waitUntillLoadingImageIsDisappeared(chromeDriver, PropertiesRepository.getString("id.common.page.loader"));
		}catch(Exception e){
			throw new DriverException("Unable to enable and disable assessment", e);
		}
		logger.info("enableDisablePracticeAssessmentsAndSaveWithoutSwitch End ");
	}
	
	
	/**
	 * Method used to enable/disable practice assessments
	 * @author Vaishali.Katta
	 */
	public boolean verifySignaturePageDisplayed(WebDriver chromeDriver) throws DriverException{
		logger.info("verifySignaturePageDisplayed Start");
		boolean flag = false;
		try {
			List<WebElement> webElements = chromeDriver.findElements(By.cssSelector(PropertiesRepository.getString(
					"id.proctor.monitor.page.instruction.header")));
			if (webElements.size()>0) {
				flag = webElements.get(0).isDisplayed();
			}			
		}catch(Exception e){
			throw new DriverException("Unable to enable and disable assessment", e);
		}
		logger.info("enableDisablePracticeAssessmentsAndSave End " + flag);
		return flag;
	}
	
	public void MaintanacePopUp() throws InterruptedException {
		logger.info("Method : Verifying Maintance pop-up :::: START ");
		Thread.sleep(2000);
		// List<WebElement> buttonList =
		// baseHandler.findElements(".wm-template-text");
		List<WebElement> buttonList = driver.findElements(By.cssSelector(".walkme-action-remindMeNextDay-1.wm-close-link"));
		if (CollectionUtils.isNotEmpty(buttonList)) {
			driver.findElement(By.cssSelector(".walkme-action-remindMeNextDay-1.wm-close-link")).click();
			Thread.sleep(1000);
		}

		logger.info("Method : Verifying Maintance pop-up :::: END");
	}
	
	
}
