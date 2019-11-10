package com.automation.asmt.page;

import java.io.File;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ascendlearning.automation.ui.config.GlobalProperties;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.TextHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;
import com.ascendlearning.automation.ui.page.BasePage;

public class ASMTBasePage extends BasePage {

	private Logger logger = LogManager.getLogger(this.getClass());
	
	protected WebDriverWait wait;
	private BaseHandler baseHandler;
	private WindowHandler windowHandler;
	private TextHandler textHandler;
	
	WebDriverWait driverWait = new WebDriverWait(driver, GlobalProperties.EXPLICIT_WAIT);
	
	public ASMTBasePage(WebDriver webDriver) {
		super(webDriver);
		baseHandler = new BaseHandler(driver);
		windowHandler = new WindowHandler(driver);
		textHandler = new TextHandler(driver);
		
		wait = new WebDriverWait(driver, PropertiesRepository.getInt("global.driver.wait"));
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
	
	public void pressEscapeKey(){
		Actions builder = new Actions(driver);
		builder.sendKeys(Keys.ESCAPE).perform();
	}
	
	/**
	 * This method is used to wait until buffer invisible
	 * 
	 * @author Saravanan Jothimani 
	 */
	public void waitUntillBufferInvisible(String loc) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(loc)));
	}
		
	/**
	 * This method is used to wait until buffer invisible
	 * 
	 * @author Saravanan Jothimani 
	 */
	public void waitUntillElementIsVisible(String loc) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(loc)));
	}
	
	/**
	 * Method used to wait until loading image is displayed. 
	 * It if takes more time, increase the count. 
	 * 
	 * @author saravanan.jothimani
	 * @param count
	 * @throws Exception
	 */
	public void waitUntillLoadingImageIsDisplayed(int count) throws Exception {
		logger.info("Method: waitUntillLoadingImageIsDisplayed Starts");
    	try {
    		// Verifying Loading image.
			waitUntillBufferInvisible(PropertiesRepository
					.getString("asmt.pleasewait.bufferLoc"));
			List<WebElement> buffecImage = baseHandler.findElements(PropertiesRepository
					.getString("asmt.pleasewait.bufferLoc"));
			if(CollectionUtils.isNotEmpty(buffecImage)) {
				for(int index = 0; index < count; index++) {
						waitUntillBufferInvisible(PropertiesRepository
								.getString("asmt.pleasewait.bufferLoc"));
				}
			}
    	} catch (Exception e) {
    		logger.info("Unable to wait Untill Loading Image Is Displayed" );
			log(logger, "Unable to wait Untill Loading Image Is Displayed" );
    		throw new DriverException("Unable to wait Untill Loading Image Is Displayed" , e); 
    	}
    	logger.info("Method: waitUntillLoadingImageIsDisplayed End " );
	}
	
	public void switchToAssessmentFrameHandler() throws Exception {
		logger.info("switchToAssessmentFrameHandler Start");
		try {
			windowHandler.switchToMainWindow();
			waitUntillBufferInvisible(PropertiesRepository.getString("asmt.pleasewait.bufferLoc"));
			windowHandler.switchToFrame("assessmentFrame");
		} catch (Exception e) {
			logger.info("Unable to switch To Assessment Frame Handler Start");
			throw new DriverException("Unable to switch To Assessment Frame Handler Start", e);
		}
		logger.info("Method: switchToAssessmentFrameHandler End ");
	}
	
	/**
	 * This method is used to get the value of text box
	 * 
	 * @author Saravanan Jothimani 
	 * @throws InterruptedException 
	 */
	public String getTextBoxValue(String loc) throws NullPointerException, DriverException {
		logger.info("getTextBoxValue start");
		String result = null;
		try {
			switchToAssessmentFrameHandler();
			List<WebElement> element = baseHandler.findElements(loc);
			if(CollectionUtils.isNotEmpty(element)) {
				result = element.get(1).getAttribute("value");
			}
		} catch(Exception e) {
			throw new DriverException("Unable to get Text Box Value", e);
		}
		logger.info("getTextBoxValue End result --> " + result);
		return result;  
	}
	
	
	public String getText(String textLocator) throws DriverException {
		logger.info("NewATIBasePage getText() Start  " + textLocator);
		String text = null;
		List<WebElement> element = baseHandler.findElements(textLocator);
		if (CollectionUtils.isNotEmpty(element)) {
			text = textHandler.getText(textLocator);
		}
		logger.info("NewATIBasePage getText() End " + text);
		return text;
	}
	
	/**
	 * This method is used to get the value of text box
	 * 
	 * @author Saravanan Jothimani 
	 * @throws InterruptedException 
	 */
	public String getAttributeValue(String loc, String attributeName) throws NullPointerException, DriverException {
		logger.info("getAttributeValue start");
		String result = null;
		try {
			switchToAssessmentFrameHandler();
			List<WebElement> element = baseHandler.findElements(loc);
			if(CollectionUtils.isNotEmpty(element)) {
				result = element.get(0).getAttribute(attributeName);
			}
			switchToAssessmentFrameHandler();
		} catch(Exception e) {
			throw new DriverException("Unable to get Text Box Value", e);
		}
		logger.info("getAttributeValue End result --> " + result);
		return result;  
	}
	
	/**
	 * This method is used to get the value of text box
	 * 
	 * @author Saravanan Jothimani 
	 * @throws InterruptedException 
	 */
	public String getAttributeValue(WebElement element, String attributeName) throws NullPointerException, DriverException {
		logger.info("getAttributeValue start");
		String result = null;
		try {
			switchToAssessmentFrameHandler();
			if(element != null) {
				result = element.getAttribute(attributeName);
			}
			switchToAssessmentFrameHandler();
		} catch(Exception e) {
			throw new DriverException("Unable to get Text Box Value", e);
		}
		logger.info("getAttributeValue End result --> " + result);
		return result;  
	}
	
	/**
	 * This method is used to get the value of text bos
	 * 
	 * @author Saravanan Jothimani
	 * @throws InterruptedException
	 */
	public boolean verifyMessage(String msg, String loc)
			throws NullPointerException, DriverException {
		logger.info("verifyMessage start");
		String result = null;
		boolean flag = false;
		try {
			switchToAssessmentFrameHandler();
			windowHandler.switchToModalDialog();
			if (baseHandler.isDisplayed(loc)) {
				result = baseHandler.findElement(loc).getText();
			}
			if (msg.equalsIgnoreCase(result)) {
				flag = true;
			}
		} catch (Exception e) {
			throw new DriverException("Unable to verify the message", e);
		}
		logger.info("verifyMessage end--------->Flag " + flag);
		return flag;
	}
	
	/**
	 * This method is used to wait until the buffer image is completely load.
	 * @author Sanapati.Srinu
	 * @param loc
	 * @throws Exception
	 *//*
	public void waitUntillLoadingImageIsDisappeared(String loc) throws Exception {
		logger.info("Method: waitUntillLoadingImageIsDisappeared Starts");
    	try {
    		List<WebElement> buffecImage = baseHandler.findElements(PropertiesRepository
					.getString(loc));
    		try {
    			while(String.valueOf(buffecImage.size())!=null)
        		{
        			logger.info("page is still loading after click on the element");
        			buffecImage=baseHandler.findElements(PropertiesRepository
        					.getString(loc));
        			
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
    	
	}*/
	
	/**
	 * This method is used to wait until the buffer image is completely load.
	 * 
	 * @author Sanapati.Srinu
	 * @param loc
	 * @throws Exception
	 */
	public void waitUntillLoadingImageIsDisappeared(String loc) throws Exception {
		logger.info("Method: waitUntillLoadingImageIsDisappeared Starts");
		long startTime = System.currentTimeMillis();
		try {
			List<WebElement> buffecImage = baseHandler.findElements(PropertiesRepository.getString(loc));
			try {
				while (CollectionUtils.isNotEmpty(buffecImage) && ((System.currentTimeMillis() - startTime) < 120000)) {
					logger.info("page is still loading after click on the element");					
					logger.info("Wait Counter in Seconds >>>> " +(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - startTime)));
					buffecImage = baseHandler.findElements(PropertiesRepository.getString(loc));
				}
				if (!((System.currentTimeMillis() - startTime) < 120000)) {
					logger.info("Waited 120 seconds to load the page");
					throw new DriverException("Unable to wait Untill Loading Image Is not Disappeared");
				} else {
					logger.info("Page load complete");
				}
				waitUntillOverlayImageIsDisappeared("new-atitesting.peasewait.bufferLoc1");
			} catch (Exception e) {
				waitUntillOverlayImageIsDisappeared("new-atitesting.peasewait.bufferLoc1");
				if (!((System.currentTimeMillis() - startTime) < 120000)) {
					logger.info("Waited 120 seconds to load the page");
					throw new DriverException("Unable to wait Untill Loading Image Is not Disappeared", e);
				} else {
					logger.info("Page load complete in catch block");
				}
			}
		} catch (Exception e) {
			logger.info("Unable to wait Untill Loading Image Is not Disappeared");
			log(logger, "Unable to wait Untill Loading Image Is not Disappeared");
			throw new DriverException("Unable to wait Untill Loading Image Is not Disappeared", e);
		}
		logger.info("waitUntillLoadingImageIsDisappeared End");
	}
	
	
	/**
	 * This method is used to wait until the buffer image is completely load.
	 * @author Sanapati.Srinu
	 * @param loc
	 * @throws Exception
	 */
	public void waitUntillOverlayImageIsDisappeared(String loc) throws Exception {
		logger.info("Method: waitUntillOverlayImageIsDisappeared Starts");
    	try {
    		List<WebElement> buffecImage = baseHandler.findElements(PropertiesRepository
					.getString(loc));
    		try {
    			while(String.valueOf(buffecImage.size())!=null)
        		{
        			logger.info("page is still loading after click on the element");
        			buffecImage=baseHandler.findElements(PropertiesRepository
        					.getString(loc));
        			
        		}
			} catch (Exception e) {
				logger.info("page is loaded successfully");
			}
    		
    	} catch (Exception e) {
    		logger.info("Unable to wait Untill Overlay Image Is not Disappeared" );
			log(logger, "Unable to wait Untill Overlay Image Is not Disappeared" );
    		throw new DriverException("Unable to wait Untill Overlay Image Is not Disappeared" , e); 
    	}
    	logger.info("waitUntillOverlayImageIsDisappeared End");
	}

	/**
	 * This method is used to wait until the buffer image is completely load.
	 * @author Sanapati.Srinu
	 * @param loc
	 * @throws Exception
	 */
	public void waitUntillLoadingImageIsAppeared(String loc) throws Exception {
		logger.info("Method: waitUntillLoadingImageIsAppeared Starts");
    	try {
    		List<WebElement> buffecImage = baseHandler.findElements(PropertiesRepository
					.getString(loc));
    		try {
    			while(buffecImage.size() == 1)
        		{
        			logger.info("page is not displaying loading image, waiting it to appear.");
        			buffecImage=baseHandler.findElements(PropertiesRepository
        					.getString(loc));
        			
        		}
			} catch (Exception e) {
				logger.info("page is loaded successfully");
			}
    		
    	} catch (Exception e) {
    		logger.info("Unable to wait Untill Loading Image Is not Appeared" );
			log(logger, "Unable to wait Untill Loading Image Is not Appeared" );
    		throw new DriverException("Unable to wait Untill Loading Image Is not Appeared" , e); 
    	}
    	logger.info("waitUntillLoadingImageIsAppeared End");
	}
	
	/**
	 * Method used to click on Button with index. 
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @param index
	 * @throws Exception
	 */
	public void clickButton(String locator, int index) throws Exception {
		logger.info("Method: clickButton Starts ");
    	try {
    		List<WebElement> element = baseHandler.findElements(locator);
    		if(CollectionUtils.isNotEmpty(element)) {
    			element.get(index).click();
    		}
    	} catch (Exception e) {
    		logger.info("Unable to click Button" );
			log(logger, "Unable to click Button" );
    		throw new DriverException("Unable to click Button" , e); 
    	}
    	logger.info("Method: clickButton End " );
	}
	
	/**
	 * Method used to click on Button with index. 
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @param index
	 * @throws Exception
	 */
	public void clickButtonWithSwitchToDefault(String locator, int index) throws Exception {
		logger.info("Method: clickButtonWithSwitchToDefault Starts");
    	try {
    		windowHandler.switchToLatestWindow();
    		List<WebElement> element = baseHandler.findElements(locator);
    		if(CollectionUtils.isNotEmpty(element)) {
    			element.get(index).click();
    		}
    	} catch (Exception e) {
    		logger.info("Unable to click Button With Switch To Default" );
			log(logger, "Unable to click Button With Switch To Default" );
    		throw new DriverException("Unable to click Button With Switch To Default" , e); 
    	}
    	logger.info("Method: clickButtonWithSwitchToDefault End " );
	}
	
	public void clickOnCloseButton(String loc) throws Exception {

		logger.info("clickOnCloseButton start");
		waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		windowHandler.switchToMainWindow();

		WebElement closeButton = baseHandler.findElement(PropertiesRepository
				.getString(loc));
		if (closeButton != null)
			closeButton.click();
		waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");

		logger.info("clickOnCloseButton start");
	}
	
	public void clickOnCloseButtonWithAddingTiming(String loc) throws Exception {
		logger.info("clickOnCloseButtonWithAddingTiming start");
		try {
			waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
			windowHandler.switchToMainWindow();
			Thread.sleep(10000);
			WebElement closeButton = baseHandler.findElement(PropertiesRepository
					.getString(loc));
			if (closeButton != null)
				closeButton.click();
			waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		} catch(Exception e) {
			logger.info("Unable to clickOnCloseButtonWithAddingTiming" );
			log(logger, "Unable to clickOnCloseButtonWithAddingTiming" );
    		throw new DriverException("Unable to clickOnCloseButtonWithAddingTiming" , e); 
		}

		logger.info("clickOnCloseButtonWithAddingTiming start");
	}

	/**
	 * Method used to verify element is present or not in DOM. 
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @return
	 * @throws Exception
	 */
	public boolean verifyElement(String locator) throws Exception {
		logger.info("Method: verifyElement Starts");
		boolean flag = false;
    	try {
    		List<WebElement> element = baseHandler.findElements(locator);
    		if(CollectionUtils.isNotEmpty(element) && element.size() > 0) {
    			flag = true;
    		}
    	} catch (Exception e) {
    		logger.info("Unable to verifyElement");
			log(logger, "Unable to verifyElement" );
    		throw new DriverException("Unable to verifyElement" , e); 
    	}
    	logger.info("Method: verifyElement End flag --> " + flag);
    	return flag;
	}
	
	/**
	 * Method used to verify element is present or not in DOM. 
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @return
	 * @throws Exception
	 */
	public boolean verifyElement(String locator, int index) throws Exception {
		logger.info("Method: verifyElement Starts");
		boolean flag = false;
    	try {
    		List<WebElement> element = baseHandler.findElements(locator);
    		if(CollectionUtils.isNotEmpty(element) && element.size() > 0) {
    			if(StringUtils.isNotEmpty(element.get(index).getText())) {
    				flag = true;
    			}
    		}
    	} catch (Exception e) {
    		logger.info("Unable to verifyElement");
			log(logger, "Unable to verifyElement" );
    		throw new DriverException("Unable to verifyElement" , e); 
    	}
    	logger.info("Method: verifyElement End flag --> " + flag);
    	return flag;
	}
	
	/**
	 * Method used to verify element is present or not in DOM. 
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @return
	 * @throws Exception
	 */
	public boolean verifyElementWithSwitchWindow(String locator) throws Exception {
		logger.info("Method: verifyElementWithSwitchWindow Starts");
		boolean flag = false;
    	try {
    		List<WebElement> element = baseHandler.findElements(locator);
    		if(CollectionUtils.isNotEmpty(element) && element.size() > 0) {
    			flag = true;
    		}
    	} catch (Exception e) {
    		logger.info("Unable to verifyElementWithSwitchWindow");
			log(logger, "Unable to verifyElementWithSwitchWindow" );
    		throw new DriverException("Unable to verifyElementWithSwitchWindow" , e); 
    	}
    	logger.info("Method: verifyElementWithSwitchWindow End flag --> " + flag);
    	return flag;
	}
	
	
	/**
	 * This method is used wait until IPP page is loaded.
	 * 
	 * @author Abhishek Kumar
	 * @throws InterruptedException
	 */
	public void waitUntillIPPPageIsLoaded(String loc) throws Exception {
		logger.info("Method: waitUntillIPPPageIsLoaded Starts");
    	try {
    		List<WebElement> element = baseHandler.findElements(loc);
    		if(CollectionUtils.isNotEmpty(element)) {
    			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(loc)));
    		}
    		
    	} catch (Exception e) {
    		logger.info("Unable to wait Untill Loading Image Is not Disappeared" );
			log(logger, "Unable to wait Untill Loading Image Is not Disappeared" );
    		throw new DriverException("Unable to wait Untill Loading Image Is Disappeared" , e); 
    	}
    	logger.info("waitUntillIPPPageIsLoaded End");
	}
//	public void waitUntillLoadingImageIsDisappeared(String string) throws InterruptedException {
//		try {
//			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".blockUI.blockMsg.blockPage")));
//			  Thread.sleep(500);
//			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".blockUI.blockMsg.blockPage")));
//			  Thread.sleep(500);
//			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".blockUI.blockMsg.blockPage")));
//			  Thread.sleep(500);
//			  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".blockUI.blockMsg.blockPage")));
//			  
//			  } catch (InterruptedException e) {
//			   // TODO Auto-generated catch block
//			   e.printStackTrace();
//			  }
//		
//	}
	public void waitForPresenceOfElement(String loc){
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(loc)));
		 }
	public void waitForElementToBeClickable(String loc){
		  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(loc)));
		 }
	
	public void clickModuleButtonByName(String assessmentName) throws Exception {
		logger.info("Method: clickModuleButtonByName Start");
		List<WebElement> moduleList = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.all.modules.loc"));
		try {
			if (moduleList != null && moduleList.size() > 0) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					WebElement element = moduleList.get(i).findElement(By.cssSelector(PropertiesRepository.getString("new-atitesting.specific.modules.name.loc.name")));
					WebElement element1 = moduleList.get(i);
					if (assessmentName.equalsIgnoreCase(element.getText())) {
						WebElement mainDivElement = element1.findElement(By.cssSelector("nav[class='actions'] div[data-bind*='visible: !Tutorial.HasMultipleLearningLoopItems()']"));
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mainDivElement);
						if(mainDivElement != null) {
							List<WebElement> moduleButtons = mainDivElement.findElements(By.cssSelector("a[class='button primary-button cardflip focus-element-flag']"));
							moduleButtons.get(0).click();
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
							break;
						}
					} 
				}
			}
		} catch (Exception e) {
			throw new DriverException("Unable to click on module button");
		}
	
		logger.info("Method: clickModuleButtonByName End");
	}
	
	/**
	 * Method is used to verify the time spent in Nurse Logic Lesson.
	 * 
	 * @author saravanan.jothimani
	 * @return Calendar
	 * @throws Exception
	 */
	
	public Calendar getTimeSpentInCardBack(String moduleName) throws Exception {
		logger.info("Method : getTimeSpentInCardBack Start");
		Calendar timeSpentCal = null;
		try {
			//Thread.sleep(10000);
			waitUntillBufferInvisible(PropertiesRepository
					.getString("new-atitesting.peasewait.bufferLoc"));
			List<WebElement> allBeginButtonLiElement = baseHandler
					.findElements("section[class='modal-additional-content'] ul li .quiz-actions");
			if (CollectionUtils.isNotEmpty(allBeginButtonLiElement)) {
				int size = allBeginButtonLiElement.size();
				for (int index = 0; index < size; index++) {
					String moduleNameFromUI = allBeginButtonLiElement
							.get(index)
							.findElement(
									By.cssSelector(".quiz-display-name"))
							.getText();
					// Matching Module Name
					if (StringUtils.isNotEmpty(moduleNameFromUI)) {
						if (moduleName.equalsIgnoreCase(moduleNameFromUI)) {
							List<WebElement> singleModuleButtons = allBeginButtonLiElement
									.get(index)
									.findElements(
											By.cssSelector("div[class='module-buttons quiz-bank-buttons'] .time-suggested-spent"));
							if (CollectionUtils.isNotEmpty(singleModuleButtons)) {
								// Getting div[class='time-suggested-spent'] two elements are available.
								/*List<WebElement> timeSpentElement = singleModuleButtons.get(0).findElements(By.cssSelector(PropertiesRepository.getString("new-atitesting.learntab.tutorial.nurse.logic.tutorial.card.back.time.spent.loc")));*/
								if(CollectionUtils.isNotEmpty(singleModuleButtons)) {
									int styleSize = singleModuleButtons.size();
									for(int styleIndex = 0; styleIndex < styleSize; styleIndex++) {
										WebElement styleElement = singleModuleButtons.get(styleIndex);
										String styleAttElement = styleElement.getAttribute("style");
										if(StringUtils.isEmpty(styleAttElement) && !"display: none;".equalsIgnoreCase(styleAttElement)) {
											String timeSpent = styleElement.findElement(By.cssSelector("span")).getText();
											timeSpentCal = Calendar.getInstance();
								    		if(StringUtils.isNotBlank(timeSpent)) {
								    			String[] maxTime = timeSpent.split(":");
								    			if(maxTime.length > 0) {
								    				timeSpentCal.set(Calendar.MINUTE, Integer.parseInt(maxTime[0]));
								    				timeSpentCal.set(Calendar.SECOND, Integer.parseInt(maxTime[1]));
								    				break;
								    			}
								    		}
										}
										
									}
						    		break;
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
    		logger.info("Unable to get Time Spent In Card Back");
    		throw new DriverException("Unable to get Time Spent In Card Back" , e); 
    	} 
		logger.info("Method : getTimeSpentInCardBack End Calendar --> "+ timeSpentCal);
		return timeSpentCal;
	}
	
	/**
	 * Method is used to verify time difference between two calendar.
	 * 
	 * @author saravanan.jothimani
	 * @param currentTime
	 * @param updatedTime
	 * @return
	 * @throws Exception
	 */
	public boolean verifyTimeDifference(Calendar currentTime, Calendar updatedTime) throws Exception {
		logger.info("Method: verifyTimeDifference Starts");
		boolean flag = false;
    	try {
    		// If currentTime == null, button is BeginQuiz, setting the value as 00 for both values.
    		if(currentTime == null) {
    			currentTime = Calendar.getInstance();
    			currentTime.set(Calendar.MINUTE, 00);
    			currentTime.set(Calendar.SECOND, 00);
    		}
    		if(currentTime.before(updatedTime)) {
    			flag = true;
    		}
    	} catch (Exception e) {
    		logger.info("Unable to verify Time Difference ");
    		throw new DriverException("Unable to verify Time Difference " , e); 
    	}
    	logger.info("Method: verifyTimeDifference End flag --> " + flag);
    	return flag;
	}

	/**
	 * Method used to verify element is displayed or not. 
	 * 
	 * @param locator
	 * @return
	 * @throws Exception
	 */
	public boolean verifyElementIsDisplayed(String locator) throws Exception {
		logger.info("verifyElementIsDisplayed Start ");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(locator);
			if(CollectionUtils.isNotEmpty(element) && element.get(0).isDisplayed()) {
				flag = true;
			}
		}catch (Exception e) {
    		logger.info("Unable to " );
			log(logger, "Unable to " );
    		throw new DriverException("Unable to " , e); 
    	}
		logger.info("verifyElementIsDisplayed End");
		return flag;
	}
	
	/**
	 * Method used to verify element is displayed or not. 
	 * 
	 * @param locator
	 * @return
	 * @throws Exception
	 */
	public boolean verifyElementIsDisplayedWithAssessmentSwitch(String locator) throws Exception {
		logger.info("verifyElementIsDisplayedWithAssessmentSwitch Start");
		boolean flag = false;
		switchToAssessmentFrameHandler();
		try {
			List<WebElement> element = baseHandler.findElements(locator);
			if(CollectionUtils.isNotEmpty(element) && element.get(0).isDisplayed()) {
				flag = true;
			}
		}catch (Exception e) {
			windowHandler.switchToLatestWindow();
    		logger.info("Unable to verifyElementIsDisplayedWithAssessmentSwitch" );
			log(logger, "Unable to verifyElementIsDisplayedWithAssessmentSwitch" );
    		throw new DriverException("Unable to verifyElementIsDisplayedWithAssessmentSwitch" , e); 
    	}
		windowHandler.switchToLatestWindow();
		logger.info("verifyElementIsDisplayedWithAssessmentSwitch End flag -->" + flag);
		return flag;
	}
	
	/**
	 * Verify Page title 
	 * @author Syed.pasha
	 * @param Page Title
	 * @return
	 * @throws Exception
	 */
	public boolean verifyPageTitle(String PageTitle) throws Exception {
		logger.info("verifyPageTitle Start");
		boolean flag = false;
		//switchToAssessmentFrameHandler();
		try {
			
			if(driver.getPageSource().contains(PageTitle)) {
				flag = true;
			}
		}catch (Exception e) {			
    		logger.info("Unable to verifyPageTitle" );
			log(logger, "Unable to verifyPageTitle" );
    		throw new DriverException("Unable to verifyPageTitle" , e); 
    	}
		logger.info("verifyPageTitle End flag -->" + flag);
		return flag;
	}
	
	/**
	 * Verify if element is displayed
	 * @author Syed.pasha
	 * @param loc
	 * @return boolean
	 * @throws DriverException
	 */
	public boolean isElementDisplayed(String loc , int index) throws DriverException {
		logger.info("Method: isElementDisplayed Start ");
		try {	
			waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
			List<WebElement> findElement = baseHandler.findElements(PropertiesRepository.getString(loc));
			if (findElement != null) {
				return findElement.get(index).isDisplayed();
			}

		} catch (Exception e) {
			throw new DriverException("element is not visible", e);
		}

		logger.info("Method: isElementDisplayed End");
		return false;
	}
	
	/**
	 * Verify if element is displayed
	 * @author Syed.pasha
	 * @param loc
	 * @return boolean
	 * @throws DriverException
	 */
	public boolean isElementDisplayedProctor(WebDriver proctorDriver , String loc , int index) throws DriverException {
		logger.info("Method: isElementDisplayed Start");
		try {
			swithToProctorFrame(proctorDriver);
			waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
			List<WebElement> findElement = proctorDriver.findElements(By.cssSelector(PropertiesRepository.getString(loc)));
			if (findElement != null) {
				return findElement.get(index).isDisplayed();
			}

		} catch (Exception e) {
			throw new DriverException("element is not visible", e);
		}

		logger.info("Method: isElementDisplayed End");
		return false;
	}
	
	/**
	 * @author Syed.pasha
	 * @param loc
	 * @return boolean
	 * @throws DriverException
	 */
	public boolean isStringElementDisplayedByIndex(String loc ,String element , int index) throws DriverException {
		logger.info("Method: isStringElementDisplayedByIndex Start ");
		boolean flag = false;
		String actualString = "";
		try {
			waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
			List<WebElement> findElement = baseHandler.findElements(loc);
			if (findElement != null && findElement.get(index).isDisplayed() && findElement.get(index).getText().contains(element)) {
				actualString = findElement.get(index).getText();
				flag = true;
			}
		} catch (Exception e) {
			throw new DriverException("String element is not visible", e);
		}
		logger.info("Method: isStringElementDisplayedByIndex End ******Expected String--> " +element + "******Actual String--> " +actualString );
		return flag;
	}
	
	/**
	 * @author Syed.pasha
	 * @param loc
	 * @return boolean
	 * @throws DriverException
	 */
	public boolean isStringElementDisplayedByIndexByValueTag(String loc ,String element , int index) throws DriverException {
		logger.info("Method: isStringElementDisplayedByIndexByValueTag Start ");
		boolean flag = false;
		String actualString = "";
		try {
			waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
			List<WebElement> findElement = baseHandler.findElements(loc);
			if (findElement != null && findElement.get(index).isDisplayed() && findElement.get(index).getAttribute("value").contains(element)) {
				actualString = findElement.get(index).getText();
				flag = true;
			}
		} catch (Exception e) {
			throw new DriverException("String element is not visible", e);
		}
		logger.info("Method: isStringElementDisplayedByIndexByValueTag End ******Expected String--> " +element + "******Actual String--> " +actualString );
		return flag;
	}
	
	public void clickTab(String loc) {
		logger.info("Method : clickTab :::::::: START");
		driver.findElement(By.cssSelector(loc)).sendKeys(Keys.TAB);
		logger.info("Method : clickTab :::::::: END");
	}
	
	public void selectDatePicker(String txtFieldLoc, String inputDate) {
		logger.info("Method : selectDatePicker :::::::: START");
		List<WebElement> element = baseHandler.findElements(txtFieldLoc);
		if (CollectionUtils.isNotEmpty(element)) {
			element.get(0).sendKeys(inputDate);
			element.get(0).sendKeys(Keys.TAB);
		}
		logger.info("Method : selectDatePicker :::::::: END");
	}
	
	public boolean checkElementEnabled(String locator) throws DriverException {
		logger.info("checkElementEnabled Start " + locator);
		boolean flag = false;
		try {
//			windowHandler.switchToFrame("assessmentFrame");
			List<WebElement> element = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(element) && element.size() > 0) {
				flag = baseHandler.isEnabled(element.get(0));
			} else {
				logger.info("Unable to find Elements for locator --> " + locator);
			}
		} catch (Exception e) {
			throw new DriverException("Unable to locate element" + e);
		}

		logger.info("checkElementEnabled End " + flag);
		return flag;
	}
	
	protected String getEnvironment() throws DriverException {
		logger.info("Method : getEnvironment :::::::: START");

		String result = null;
		result = driver.getCurrentUrl();
		if (result.contains("stage")) {
			result = "Stage";
		} else if (result.contains("qa")) {
			result = "QA";
		} else {
			result = "Production";
		}
		logger.info("Method : getEnvironment :::::::: End  " + result);
		return result;
	}
	
	/**
	 * Method used to click on Button.
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @throws Exception
	 */
	public void clickButton(String locator) throws Exception {
		logger.info("Method: clickButton Starts ");
		try {
			Thread.sleep(2000);
			List<WebElement> element = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(element)) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element.get(0));
				element.get(0).click();
				Thread.sleep(2000);
				waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
			}
		} catch (Exception e) {
			logger.info("Unable to click Button");
			log(logger, "Unable to click Button");
			throw new DriverException("Unable to click Button", e);
		}
		logger.info("Method: clickButton End ");
	}
	
	/**
	 * Method used to create directory
	 * 
	 * @author saravanan.jothimani
	 * @param directoryName
	 * @return
	 * @throws Exception
	 */
	public boolean createDirectory(String directoryName) throws Exception {
		logger.info("createDirectory Start");
		boolean flag = false;
		try {
			File directory = new File(directoryName);
			if (directory.exists() && directory.isFile()) {
				System.out.println("The dir with name could not be" + " created as it is a normal file");
			} else {
				if (!directory.exists()) {
					directory.mkdir();
				}
			}
		} catch (Exception e) {
			throw new DriverException("Unable to createDirectory", e);
		}
		logger.info("createDirectory End");
		return flag;
	}
	
	public boolean deleteFileExists(String downloadFilepath) throws Exception {
		logger.info("deleteFileExists Start");
		boolean flag = false;
		try {
			File f = new File(downloadFilepath);
			File[] fileName = f.listFiles();
			for (File listFile : fileName) {
				listFile.delete();
			}
		} catch (Exception e) {
			throw new DriverException("Unable to deleteFileExists", e);
		}
		logger.info("deleteFileExists Start");
		return flag;
	}
	
	public boolean verifyFileExists(String downloadFilepath) throws Exception {
		logger.info("verifyFileExists Start ");
		boolean flag = false;
		try {
			// Navigation to folder to verify
			File f = new File(downloadFilepath);
			File[] fileName = f.listFiles();
			if (fileName != null) {
				if (fileName[0].getName().equalsIgnoreCase("Report.pdf")) {
					flag = true;
				}
			}
		} catch (Exception e) {
			throw new DriverException("Unable to verifyFileExists", e);
		}
		logger.info("verifyFileExists End flag --> " + flag);
		return flag;
	}

}
