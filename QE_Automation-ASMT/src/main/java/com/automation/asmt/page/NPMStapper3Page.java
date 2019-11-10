package com.automation.asmt.page;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.ButtonHandler;
import com.ascendlearning.automation.ui.handlers.TextHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;

public class NPMStapper3Page extends ASMTBasePage {

	private Logger logger = LogManager.getLogger(this.getClass());
	public BaseHandler baseHandler;
	private TextHandler textHandler;
	private ButtonHandler buttonHandler;
	protected WebDriverWait wait;
	private WindowHandler windowHandler;
	
	boolean flag=false;
	
	
	public NPMStapper3Page(WebDriver webDriver) {
		super(webDriver);
		
		
		baseHandler = new BaseHandler(driver);
		textHandler = new TextHandler(driver);
		buttonHandler = new ButtonHandler(driver);
		wait = new WebDriverWait(driver, PropertiesRepository.getInt("global.driver.wait"));
		windowHandler = new WindowHandler(driver);
		

	}
	 

	private void selectAllCheckbox() throws Exception {
		logger.info("Method : select check box :::::::: Starts");
		try {
	
			logger.info("select checkbox--> " );
			
			List<WebElement> allcheckbox = baseHandler.findElements(PropertiesRepository.getString("step3.all.checkbox"));
			
			
				for(int i=0; i<allcheckbox.size() ; i++)
				{
    			WebElement checkbox = allcheckbox.get(i);
    			buttonHandler.clickButton(checkbox);
				}
    					
		}
		catch (Exception e) {
				logger.info("unable to select checkbox " + e);
}
		logger.info("Method : select checkbox :::::::: Ends");
}
	
	private void enterElectronicSignature(String signature) throws Exception {
		logger.info("Method : enter electronic signature :::::::: Starts");
		try {
	
			logger.info("Click on enter electronic signature field--> "+ signature);
			WebElement electronicsignatureelement = baseHandler.findElement(PropertiesRepository.getString("step3.electronicsignature"));
			buttonHandler.clickButton(electronicsignatureelement);
			electronicsignatureelement.sendKeys(signature);	
			
		}
		catch (Exception e) {
				logger.info("unable to enter electronic signature" + e);
}
		logger.info("Method : enter electronic signature:::::::: Ends");
}
	
	private void clickOnIAgreeButton() throws Exception {
		logger.info("Method : click On I Agree Button :::::::: Starts");
		try {
	
			logger.info("click On I Agree Button -> " );
			WebElement ClickoniagreeButtonElement = baseHandler.findElement(PropertiesRepository.getString("step3.I.agree.button"));
			buttonHandler.clickButton(ClickoniagreeButtonElement);
			
		}
		catch (Exception e) {
				logger.info("unable to click On I Agree Button" + e);
}
		logger.info("Method : click On I Agree Button :::::::: Ends");
}
	public boolean SelectAgreementCheckboxesEnterSignatureAndContinue() throws Exception {
		logger.info("Method : Select Agreement Checkboxes EnterSignature And click on Continue :::::::: Starts");
		try {
	
			logger.info("Select All the checkboxes in agreement page -> " );
			selectAllCheckbox();
			enterElectronicSignature(PropertiesRepository.getString("npm.step3.signature"));
			clickOnIAgreeButton();
			flag=true;
		}
		catch (Exception e) {
				logger.info("Select Agreement Checkboxes EnterSignature And click on Continue" + e);
}
		logger.info("Method : Select Agreement Checkboxes EnterSignature And click on Continue :::::::: Ends");
		return flag;
}
	
	/////////////////////////////////////////////////////////////////////NEW CODE
	
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
	
	
	public boolean clickAllCheckbox(WebDriver chromeDriver, boolean click) throws NullPointerException, DriverException {
		logger.info("Method: clickAllCheckbox Starts ");
		boolean flag = false;
		try {
			
			swithToProctorFrame(chromeDriver);
    		List<WebElement> element = chromeDriver.findElements(By.cssSelector(PropertiesRepository.getString("step3.all.checkbox")));
    		if(CollectionUtils.isNotEmpty(element)) {
    			int size = element.size();
    			for(int index = 0; index < size; index++) {
    				WebElement navElement = element.get(index);
    				navElement.click();
    				
        			}
    			}
    		
		    
		    
			windowHandler.switchToLatestWindow();
			flag = true;
		}
		
		catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to clickAllCheckbox");
			log(logger, "Unable to clickAllCheckbox" );
			throw new DriverException("Unable to clickAllCheckbox" , e); 
		}
		logger.info("Method: clickAllCheckbox End flag--> " +flag);
		return flag;
	}
	
	public boolean enteringElectronicsignature(WebDriver chromeDriver, String Electronicsignature) throws NullPointerException, DriverException {
		logger.info("Method: enteringProctIdAndPwd Starts ");
		boolean flag = false;
    	try {
    		
    		swithToProctorFrame(chromeDriver);
    		WebElement ElectronisignatureElement = verifyElement(chromeDriver, PropertiesRepository.getString("step3.electronicsignature"));
    		
    		if(ElectronisignatureElement != null) {
    			buttonHandler.clickButton(ElectronisignatureElement);
    			ElectronisignatureElement.sendKeys(Electronicsignature);
    			flag = true;
    		}
    		
    		windowHandler.switchToLatestWindow();
    	} catch (Exception e) {
    		windowHandler.switchToLatestWindow();
    		logger.info("Unable to enter batch id");
			log(logger, "Unable to enteringProctIdAndPwd" );
    		throw new DriverException("Unable to enteringProctIdAndPwd" , e); 
    	}
    	logger.info("Method: enteringProctIdAndPwd End flag--> " +flag);
    	return flag;
	}
	
	public boolean clickIAgree(WebDriver chromeDriver) throws NullPointerException, DriverException {
		logger.info("Method: enteringProctIdAndPwd Starts ");
		boolean flag = false;
		try {
			
			swithToProctorFrame(chromeDriver);
			WebElement ClickIagree = verifyElement(chromeDriver, PropertiesRepository.getString("step3.I.agree.button"));
		    buttonHandler.clickButton(ClickIagree);
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
