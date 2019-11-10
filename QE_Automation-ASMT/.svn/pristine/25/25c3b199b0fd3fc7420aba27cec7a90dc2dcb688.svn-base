package com.automation.asmt.page;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.ButtonHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;

public class NPMStapper5Page extends ASMTBasePage {

	private Logger logger = LogManager.getLogger(this.getClass());
	private BaseHandler baseHandler;
	ButtonHandler buttonHandler = new ButtonHandler(driver);
	boolean flag=false;
	private MaintenanceScriptID maintenanceScriptID;
	private WindowHandler windowHandler;
	
	
	public NPMStapper5Page(WebDriver webDriver) {
		super(webDriver);
		baseHandler = new BaseHandler(driver);
		maintenanceScriptID= new MaintenanceScriptID(driver);
		windowHandler= new WindowHandler(driver);
	}
	 
	/**
	 * Method is used to click on startproctoring btn in step 5
	 * 
	 *
	 * 
	 * @param
	
	 * @throws Exception
	 */
	public boolean clickOnStartProctoring () throws Exception {
		logger.info("Method : clickOnStartProctoring :::::::: Starts");
		try {
	     
			logger.info("Clicking on Start Proctoring button in step-5 ");
			WebElement StartProctoringButton=baseHandler.findElement(PropertiesRepository.getString("step5.start.proctoring.button"));
			buttonHandler.clickButton(StartProctoringButton);
			flag=true;
			
		}
		
			catch (Exception e ) {
				logger.info("unable click on start proctoring" + e);
}
		return flag;
	}
	
	//////////////////// MY CODE
	   
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
	
	
	public boolean startProctor(WebDriver chromeDriver) throws NullPointerException, DriverException {
		logger.info("Method: startProctor Starts ");
		boolean flag = false;
		try {
			
			swithToProctorFrame(chromeDriver);
			WebElement startproctorelement = verifyElement(chromeDriver, PropertiesRepository.getString("step5.start.proctoring.button"));
		    buttonHandler.clickButton(startproctorelement);
			windowHandler.switchToLatestWindow();
			flag = true;
		}
		
		catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to clickContinue");
			log(logger, "Unable to clickContinue" );
			throw new DriverException("Unable to clickContinue" , e); 
		}
		logger.info("Method: clickContinue End flag--> " +flag);
		return flag;
	}
	
	
	
	
}
