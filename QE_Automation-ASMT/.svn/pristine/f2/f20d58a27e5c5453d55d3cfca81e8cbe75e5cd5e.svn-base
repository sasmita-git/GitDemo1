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

public class NPMStepper22Page extends ASMTBasePage{
	private Logger logger = LogManager.getLogger(this.getClass());
	public BaseHandler baseHandler;
	private TextHandler textHandler;
	private ButtonHandler buttonHandler;
	protected WebDriverWait wait;
	private WindowHandler windowHandler;
	
	
	public NPMStepper22Page(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
		baseHandler = new BaseHandler(driver);
		textHandler = new TextHandler(driver);
		buttonHandler = new ButtonHandler(driver);
		wait = new WebDriverWait(driver, PropertiesRepository.getInt("global.driver.wait"));
		windowHandler = new WindowHandler(driver);
		
	}
	
	
	
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
	
	public boolean verifyElementIsDisplayed(String locator) throws Exception {
		logger.info("verifyElementIsDisplayed Start ");
		boolean flag = false;
		try {
			WebElement element = (WebElement) baseHandler.findElements(locator);
			
				flag = true;
			
		}catch (Exception e) {
    		logger.info("Unable to " );
			log(logger, "Unable to " );
    		throw new DriverException("Unable to " , e); 
    	}
		logger.info("verifyElementIsDisplayed End");
		return flag;
	}
	
	
	public boolean verifyAssessmentCohortInstitutionColumn(WebDriver chromeDriver) throws NullPointerException, DriverException {
		logger.info("Method: verify Assessment Cohort Institution Column ");
		boolean flag = false;
		try {
			
			swithToProctorFrame(chromeDriver);
			WebElement assessmentElement = verifyElement(chromeDriver, PropertiesRepository.getString("step2.Assessment.name.column"));
			WebElement cohortElement = verifyElement(chromeDriver, PropertiesRepository.getString("step2.cohort.group.column"));
			WebElement InstitutionElement = verifyElement(chromeDriver, PropertiesRepository.getString("ste2.institution.column"));
		   
			assessmentElement.getText();
			cohortElement.getText();
			InstitutionElement.getText();
			
			flag = true;
		}
		
		catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to enter batch id");
			log(logger, "Unable to enteringProctIdAndPwd" );
			throw new DriverException("Unable to enteringProctIdAndPwd" , e); 
		}
		logger.info("Method: enteringProctIdAndPwd End flag--> " +flag);
		return flag;
	}
	
		
	public boolean clicksearch(WebDriver chromeDriver) throws NullPointerException, DriverException {
		logger.info("Method: click search Starts ");
		boolean flag = false;
		try {
			
			swithToProctorFrame(chromeDriver);
			WebElement searchElement = verifyElement(chromeDriver, PropertiesRepository.getString("step2.search.button"));
		    buttonHandler.clickButton(searchElement);
			windowHandler.switchToLatestWindow();
			flag = true;
		}
		
		catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to enter batch id");
			log(logger, "Unable to enteringProctIdAndPwd" );
			throw new DriverException("Unable to enteringProctIdAndPwd" , e); 
		}
		logger.info("Method: enteringProctIdAndPwd End flag--> " +flag);
		return flag;
	}
	
	public boolean enteringBatchId(WebDriver chromeDriver, String Batchid) throws NullPointerException, DriverException {
		logger.info("Method: entering batch id Starts ");
		boolean flag = false;
		try {
			
			swithToProctorFrame(chromeDriver);
			WebElement batchidElement = verifyElement(chromeDriver, PropertiesRepository.getString("step2.search.here"));
		    buttonHandler.clickButton(batchidElement);
		    batchidElement.sendKeys(Batchid);
		    Thread.sleep(3000);
			windowHandler.switchToLatestWindow();
			flag = true;
		}
		
		catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to enter batch id");
			log(logger, "Unable to enteringProctIdAndPwd" );
			throw new DriverException("Unable to enteringProctIdAndPwd" , e); 
		}
		logger.info("Method: enteringProctIdAndPwd End flag--> " +flag);
		return flag;
	}
	
	
	public boolean clickAssessment2(WebDriver proctorDriver , String locator, boolean click) throws NullPointerException, DriverException {
		logger.info("Method: clickAssessment2 Starts ");
		boolean flag = false;
		try {
			WebElement element = verifyElement(proctorDriver, locator);
			if (element != null) {
				if (click) {
					// element.click();
					JavascriptExecutor executor = (JavascriptExecutor) proctorDriver;
					executor.executeScript("arguments[0].click();", element);
					//waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
					Thread.sleep(3000);
				}
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to clickAssessment2");
			log(logger, "Unable to clickAssessment2");
			throw new DriverException("Unable to clickAssessment2", e);
		}
		logger.info("Method: clickAssessment2 End flag --> " + flag);
		return flag;
	}
		
	
public boolean clickcontinue(WebDriver chromeDriver) throws NullPointerException, DriverException {
	logger.info("Method: click continue Starts ");
	boolean flag = false;
	try {
		
		swithToProctorFrame(chromeDriver);
		WebElement continueElement = verifyElement(chromeDriver, PropertiesRepository.getString("step2.continue.button"));
	    buttonHandler.clickButton(continueElement);
		windowHandler.switchToLatestWindow();
		flag = true;
	}
	
	catch (Exception e) {
		windowHandler.switchToLatestWindow();
		logger.info("Unable to enter batch id");
		log(logger, "Unable to enteringProctIdAndPwd" );
		throw new DriverException("Unable to enteringProctIdAndPwd" , e); 
	}
	logger.info("Method: enteringProctIdAndPwd End flag--> " +flag);
	return flag;
}
	

public boolean clicksearchclosebutton(WebDriver chromeDriver) throws NullPointerException, DriverException {
	logger.info("Method: click click search close button Starts ");
	boolean flag = false;
	try {
		
		swithToProctorFrame(chromeDriver);
		WebElement clickSearchCloseButtonElement = verifyElement(chromeDriver, PropertiesRepository.getString("step2.close.button"));
	    buttonHandler.clickButton(clickSearchCloseButtonElement);
		windowHandler.switchToLatestWindow();
		flag = true;
	}
	
	catch (Exception e) {
		windowHandler.switchToLatestWindow();
		logger.info("Unable to enter batch id");
		log(logger, "Unable to enteringProctIdAndPwd" );
		throw new DriverException("Unable to enteringProctIdAndPwd" , e); 
	}
	logger.info("Method: enteringProctIdAndPwd End flag--> " +flag);
	return flag;
}

public boolean clickAssessmentArrowbutton(WebDriver chromeDriver) throws NullPointerException, DriverException {
	logger.info("Method: click Assessment Arrow button Starts ");
	boolean flag = false;
	try {
		
		swithToProctorFrame(chromeDriver);
		WebElement clickAssessmentArrowButtonElement = verifyElement(chromeDriver, PropertiesRepository.getString("step2.arrow.button.beside.assessment.name.column"));
	    buttonHandler.clickButton(clickAssessmentArrowButtonElement);
		windowHandler.switchToLatestWindow();
		flag = true;
	}
	
	catch (Exception e) {
		windowHandler.switchToLatestWindow();
		logger.info("Unable to enter batch id");
		log(logger, "Unable to enteringProctIdAndPwd" );
		throw new DriverException("Unable to enteringProctIdAndPwd" , e); 
	}
	logger.info("Method: enteringProctIdAndPwd End flag--> " +flag);
	return flag;
}
	

}
