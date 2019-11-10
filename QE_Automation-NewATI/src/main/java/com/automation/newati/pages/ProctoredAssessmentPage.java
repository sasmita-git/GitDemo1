package com.automation.newati.pages;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.google.common.collect.Iterables;

public class ProctoredAssessmentPage extends TestTabPage {
	
	private Logger logger = LogManager.getLogger(this.getClass());
	
	public ProctoredAssessmentPage(WebDriver webDriver) {
		super(webDriver);
	}
	
	
	// Faculty Portal Start
	
	public void loginToFacultyPortal(WebDriver chromeDriver, String userName, String password) throws Exception {
		logger.info("loginToFacultyPortal Start");
		chromeDriver.getTitle();
		chromeDriver.findElement(By.cssSelector("#signOnForm-userId")).sendKeys(userName);
		chromeDriver.findElement(By.cssSelector(PropertiesRepository.getString("faculty.portal.password.loc"))).click();
		chromeDriver.findElement(By.cssSelector(PropertiesRepository.getString("faculty.portal.password1.loc"))).sendKeys(password);
		List<WebElement> goButtonElement = chromeDriver.findElements(By.cssSelector(".signOnForm-go"));
		if(CollectionUtils.isNotEmpty(goButtonElement)) {
			goButtonElement.get(0).click();
		}
		logger.info("loginToFacultyPortal End");
	}
	
	
	/**
	 * To check whether element is displayed or not.
	 * 
	 * @param locator
	 * @return
	 * @throws Exception
	 */
	public boolean checkElementDisplayed(WebDriver chromeDriver, String locator)
			throws DriverException {
		logger.info("checkElementDispalyed Start " + locator);
		boolean flag = false;
		List<WebElement> element = chromeDriver.findElements(By.cssSelector(locator));

		if (element != null && element.size() > 0) {
			flag = element.get(0).isDisplayed();
		}

		logger.info("checkElementDisplayed End " + flag);
		return flag;
	}
	
	/**
	 * This method is used to verify the popup
	 * 
	 * @throws DriverException
	 */
	public void checkPopupIsDisplayed(WebDriver chromeDriver) {
		logger.info("Method: checkPopupIsDisplayed Starts");
		try {
			if (checkElementDisplayed(chromeDriver, PropertiesRepository
					.getString("current-atitesting.mainpage.popup.yesLoc"))) {

				// click on yes button
				chromeDriver.findElement(By.cssSelector(PropertiesRepository
						.getString("current-atitesting.mainpage.popup.yesLoc"))).click();
			} else {
				logger.info("pop up is not displayed");
			}
		} catch (Exception e) {
			logger.info("Error occuring while interacting with UI", e);
		}

		logger.info("Method: checkPopupIsDisplayed Ends");
	}
	
	/**
	 * This method is used to select any tab
	 * 
	 * @author Sanapati.Srinu
	 * @param tabLoc
	 * @param index
	 * @throws DriverException
	 */
	public void selectTab(WebDriver chromeDriver, String tabLoc, int index) throws NullPointerException, DriverException {
		logger.info("selectTab  --- Start");
		try {
			List<WebElement> tabList = chromeDriver
					.findElements(By.cssSelector(PropertiesRepository.getString(tabLoc)));
			if (CollectionUtils.isNotEmpty(tabList)) {
				WebElement specificTab = tabList.get(index);
				specificTab.click();
				
			} else {
				logger.info("invalid locator is passed");
			}

		} catch (Exception e) {
			throw new DriverException(
					"unable to select value from the dropdown list", e);
		}
		logger.info("selectTab  --- End");
	}
	
	/**
	 * This method is used to select activity from drop down
	 * 
	 * @param dropDownInput
	 * @throws DriverException
	 */
	public void selectActivity(WebDriver chromeDriver, int i) {
		logger.info("Method: select Activity Starts");
		try {
			// select tutorial from all dropdown
			Select selDrop = new Select(chromeDriver.findElement(By.cssSelector(PropertiesRepository
					.getString("faculty.portal.select.activity.drop.down"))));
			selDrop.selectByIndex(i);
		} catch (Exception e) {
			logger.info("Unable to select Activity");
			log(logger, "Unable to select Activity");
			logger.info("Unable to select Activity", e);
		}
		logger.info("Method: select Activity Ends");
	}
	
	/**
	 * Method used to enter Proctor Id and Pwd.
	 * 
	 * @author saravanan.jothimani
	 * 
	 */
	public void enterProctorIDAndPwd(WebDriver chromeDriver, String selector, String text)
			throws Exception {
		logger.info("Method: enterProctorIDAndPwd Starts");
		try {
			if (chromeDriver.findElement(By.cssSelector(selector)).isDisplayed()) {
				chromeDriver.findElement(By.cssSelector(selector)).sendKeys(text);
			}
		} catch (Exception e) {
			logger.info("Unable to enter Proctor ID And Pwd");
			log(logger, "Unable to enter Proctor ID And Pwd");
			throw new DriverException("Unable to enter Proctor ID And Pwd", e);
		}
		logger.info("Method: enterProctorIDAndPwd End ");
	}
	
	/**
	 * Method used to click Proctor Submit Button.
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 *//*
	public void clickProctorSubmitButtonWithBreak(WebDriver chromeDriver) throws Exception {
		logger.info("clickProctorSubmitButtonInvalidPassword Start");
		try {
			List<WebElement> element = chromeDriver.findElements(By.cssSelector(PropertiesRepository
					.getString("faculty.portal.product.select.activity.proctor.assessment.submit.button.loc"));
			if(CollectionUtils.isNotEmpty(element)) {
				
				chromeDriver.findElement(By.cssSelector(PropertiesRepository
								.getString("faculty.portal.product.select.activity.proctor.assessment.submit.button.loc"))).click();
				waitUntillLoadingImageIsDisappeared(chromeDriver, "new-atitesting.peasewait.bufferLoc");
			}
			
		} catch (Exception e) {
			logger.info("Unable to click Proctor Submit Button Invalid Password");
			log(logger,
					"Unable to click Proctor Submit Button Invalid Password");
			throw new DriverException(
					"Unable to click Proctor Submit Button Invalid Password", e);
		}
		logger.info("Method: clickProctorSubmitButtonInvalidPassword End ");
	}*/
	
	/**
	 * Method used to enter Electronic Signature in Proctor Welcome Page.
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @param text
	 * @throws Exception
	 */
	public void enterElectornicSignature(WebDriver chromeDriver, String locator, String text)
			throws Exception {
		logger.info("Method: enterElectornicSignature Starts");
		try {
			switchToLatestWindow(chromeDriver);
			List<WebElement> welcomeElement = chromeDriver
					.findElements(By.cssSelector(PropertiesRepository
							.getString("faculty.portal.product.select.activity.proctor.assessment.proctor.authentication.page.welcome.message.loc")));

			if (CollectionUtils.isNotEmpty(welcomeElement)) {
				if (chromeDriver
						.findElement(By.cssSelector(locator)).isDisplayed()) {
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
	
	/**
	 * Method used to click Proceed button in Proctor Welcome Page.
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @param text
	 * @throws Exception
	 */
	public void clickProctorWelcomePageProceedButton(WebDriver chromeDriver) throws Exception {
		logger.info("Method: enterProctorWelcomePageDate Starts");
		try {
			switchToLatestWindow(chromeDriver);
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
	
	private WebDriver switchToLatestWindow(WebDriver chromeDriver) {
		logger.info("Switching to window : " + chromeDriver.getTitle());
		chromeDriver.switchTo().window(Iterables.getLast(chromeDriver.getWindowHandles()));
		logger.info("Switching to window : " + chromeDriver.getTitle());
		return driver;
	}
	
	/**
	 * After clicking on Approve button, the application itself will wait for 30 sec. 
	 * so, this method will wait for 30 sec and click on refresh button. 
	 * 
	 * @param loc
	 * @throws NullPointerException
	 * @throws DriverException
	 */
	public void clickButton(WebDriver chromeDriver, String loc) throws NullPointerException, DriverException {
		logger.info("Method: clickButton Starts");
		try {
			List<WebElement> element = chromeDriver
					.findElements(By.cssSelector(PropertiesRepository.getString(loc)));
			if (CollectionUtils.isNotEmpty(element)) {
				element.get(0).click();
			}
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		} catch (Exception e) {
			logger.info("Unable to click Button ");
			log(logger, "Unable to click Button ");
			throw new DriverException("Unable to click Button ", e);
		}
		logger.info("Method: clickButton Ends");
	}
	
	/**
	 * After clicking on Approve button, the application itself will wait for 30 sec. 
	 * so, this method will wait for 30 sec and click on refresh button. 
	 * 
	 * @param loc
	 * @throws NullPointerException
	 * @throws DriverException
	 */
	public void clickButtonWithLoadingImageDisappeared(WebDriver chromeDriver, String loc) throws NullPointerException, DriverException {
		logger.info("Method: clickButtonWithLoadingImageDisappeared Starts");
		try {
			List<WebElement> element = chromeDriver
					.findElements(By.cssSelector(loc));
			if (CollectionUtils.isNotEmpty(element)) {
				element.get(0).click();
				//waitUntillLoadingImageIsDisappeared(chromeDriver, "new-atitesting.peasewait.bufferLoc");
			}
			//waitUntillLoadingImageIsDisappeared(chromeDriver, "new-atitesting.peasewait.bufferLoc");
		} catch (Exception e) {
			logger.info("Unable to click Button With Loading Image Disappeared");
			log(logger, "Unable to click Button With Loading Image Disappeared");
			throw new DriverException("Unable to click Button With Loading Image Disappeared", e);
		}
		logger.info("Method: clickButtonWithLoadingImageDisappeared Ends");
	}
	
	/**
	 * After clicking on Approve button, the application itself will wait for 30 sec. 
	 * so, this method will wait for 30 sec and click on refresh button. 
	 * 
	 * @param loc
	 * @throws NullPointerException
	 * @throws DriverException
	 */
	public void clickButtonWith30SecWait(WebDriver chromeDriver, String loc) throws NullPointerException, DriverException {
		logger.info("Method: clickButtonWith30SecWait Starts");
		try {
			List<WebElement> element = chromeDriver
					.findElements(By.cssSelector(loc));
			if (CollectionUtils.isNotEmpty(element)) {
				element.get(0).click();
			}
			//waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		} catch (Exception e) {
			logger.info("Unable to click Button With 30 Sec Wait");
			log(logger, "Unable to click Button With 30 Sec Wait");
			throw new DriverException("Unable to click Button With 30 Sec Wait", e);
		}
		logger.info("Method: clickButtonWith30SecWait Ends");
	}
	
	public void clickApproveRadioButtonWith30SecWait(WebDriver chromeDriver) throws Exception {
		logger.info("clickApproveRadioButton Start");
		try {
			wait(30000);
			wait(30000);
			List<WebElement> element = chromeDriver.findElements(By.cssSelector(PropertiesRepository.getString("faculty.portal.proctor.approve.radio.button.loc")));
			if(CollectionUtils.isNotEmpty(element)) {
				element.get(0).click();
			}
		} catch(Exception e) {
			throw new Exception ("Unable to click approve radio button with 30 sec wait");
		}
		
		logger.info("clickApproveRadioButton End");
	}
	
	/**
	 * This method is used to wait until the buffer image is completely load.
	 * @author Sanapati.Srinu
	 * @param loc
	 * @throws Exception
	 */
	public void waitUntillLoadingImageIsDisappeared(WebDriver chromeDriver, String loc) throws Exception {
		logger.info("Method: waitUntillLoadingImageIsDisappeared Starts");
    	try {
    		List<WebElement> buffecImage = chromeDriver.findElements(By.cssSelector(PropertiesRepository
					.getString(loc)));
    		try {
    			while(String.valueOf(buffecImage.size())!=null)
        		{
        			logger.info("page is still loading after click on the element");
        			buffecImage=chromeDriver.findElements(By.cssSelector(PropertiesRepository
        					.getString(loc)));
        			
        		}
    			waitUntillOverlayImageIsDisappeared(chromeDriver, "new-atitesting.peasewait.bufferLoc1");
			} catch (Exception e) {
				waitUntillOverlayImageIsDisappeared(chromeDriver, "new-atitesting.peasewait.bufferLoc1");
				logger.info("page is loaded successfully");
			}
    		
    	} catch (Exception e) {
    		logger.info("Unable to wait Untill Loading Image Is not Disappeared" );
			log(logger, "Unable to wait Untill Loading Image Is not Disappeared" );
    		throw new DriverException("Unable to wait Untill Loading Image Is not Disappeared" , e); 
    	}
    	logger.info("waitUntillLoadingImageIsDisappeared End");
	}
	
	// Faculty Portal End
	
	/**
	 * This method is used to wait until the buffer image is completely load.
	 * @author Sanapati.Srinu
	 * @param loc
	 * @throws Exception
	 */
	public void waitUntillOverlayImageIsDisappeared(WebDriver chromeDriver, String loc) throws Exception {
		logger.info("Method: waitUntillOverlayImageIsDisappeared Starts");
    	try {
    		List<WebElement> buffecImage = chromeDriver.findElements(By.cssSelector(PropertiesRepository
					.getString(loc)));
    		try {
    			while(String.valueOf(buffecImage.size())!=null)
        		{
        			logger.info("page is still loading after click on the element");
        			buffecImage=chromeDriver.findElements(By.cssSelector(PropertiesRepository
        					.getString(loc)));
        			
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
	
	// Assessment Start
	public void clickProctorAssessment() throws Exception {
		logger.info("clickProctorAssessment Start");
		try {
			
    	} catch (Exception e) {
    		logger.info("Unable to verify Faculty User Product Tab " );
			log(logger, "Unable to verify Faculty User Product Tab " );
    		throw new DriverException("Unable to verify Faculty User Product Tab " , e); 
    	}
		logger.info("clickProctorAssessment End");
	}
	
	// Assessment End
}


