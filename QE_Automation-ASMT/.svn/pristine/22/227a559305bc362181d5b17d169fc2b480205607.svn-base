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

public class NPMStapper4Page extends ASMTBasePage {

	
	boolean flag=false;
	
	private Logger logger = LogManager.getLogger(this.getClass());
	public BaseHandler baseHandler;
	private TextHandler textHandler;
	private ButtonHandler buttonHandler;
	protected WebDriverWait wait;
	private WindowHandler windowHandler;
	
	public NPMStapper4Page(WebDriver webDriver) {
		super(webDriver);
		
		
		baseHandler = new BaseHandler(driver);
		textHandler = new TextHandler(driver);
		buttonHandler = new ButtonHandler(driver);
		wait = new WebDriverWait(driver, PropertiesRepository.getInt("global.driver.wait"));
		windowHandler = new WindowHandler(driver);
		

	}
	 
	private void selectStudent() throws Exception {
		logger.info("Method : select student :::::::: Starts");
		try {
	
			logger.info("select student--> " );
			WebElement selectStudentelement = baseHandler.findElement(PropertiesRepository.getString("step4.all.students.checkbox"));
			buttonHandler.clickButton(selectStudentelement);
			
		}
		catch (Exception e) {
				logger.info("unable to select student" + e);
}
		logger.info("Method : select student :::::::: Ends");

}
	
	
	private void clickOnSearchButton() throws Exception {
		logger.info("Method : click on serch button :::::::: Starts");
		try {
	
			logger.info("Click on search button2--> ");
			WebElement searchButton = baseHandler.findElement(PropertiesRepository.getString("step4.search.icon"));
			buttonHandler.clickButton(searchButton);	
			
		}
		catch (Exception e) {
				logger.info("unable click on serch button" + e);
}
		logger.info("Method : click on serch button :::::::: Ends");
}
	
	
	
	
	private void searchStudent(String firstNameLastName) throws Exception {
		logger.info("Method : search student :::::::: Starts");
		try {
	
			logger.info("search assessement--> "+firstNameLastName );
			WebElement searchStudentHereElement = baseHandler.findElement(PropertiesRepository.getString("step4.search.here"));
			buttonHandler.clickButton(searchStudentHereElement);
			searchStudentHereElement.sendKeys(firstNameLastName);
			
		}
		catch (Exception e) {
				logger.info("unable to search student"+ firstNameLastName + e);
}
		logger.info("Method : search student :::::::: Ends");
}
	
	private String getTextSearchedStudentName() throws Exception {
		logger.info("Method : Get Search Student Name :::::::: Starts");
		
		String searchedStudentName= "";
		try {
	
			logger.info("Get Search Student Name--> ");
			WebElement searchStudentHereElement1 = baseHandler.findElement(PropertiesRepository.getString("step4.student.name"));
			searchedStudentName= searchStudentHereElement1.getText();
			
			
		}
		catch (Exception e) {
				logger.info("unable to search assessment"+ e);
}
		
		logger.info("Method : Get Search Assessment Name:::::::: Ends");
		return searchedStudentName;
}
	
		
		
	public boolean clickOnContinueButton() throws Exception {
		logger.info("Method : click On Continue Button :::::::: Starts");
		try {
	
			logger.info("Click On Continue Button -> " );
			WebElement ClickoncontinueButtonElement = baseHandler.findElement(PropertiesRepository.getString("step4.continue.button"));
			buttonHandler.clickButton(ClickoncontinueButtonElement);
			flag=true;
			
		}
		catch (Exception e) {
				logger.info("unable to click on continue button" + e);
}
		logger.info("Method : click On Continue Button :::::::: Ends");
		return flag;
}
	
	
	public boolean verifyAllElementofstapper4() throws Exception {
		logger.info("Method : verifyAllElementofstapper4 :::::::: Starts");
		try {
	
			boolean flag1=baseHandler.isDisplayed(PropertiesRepository.getString(""));
			boolean flag2=baseHandler.isDisplayed(PropertiesRepository.getString(""));
			
			baseHandler.isDisplayed(PropertiesRepository.getString(""));
			baseHandler.isDisplayed(PropertiesRepository.getString(""));
			baseHandler.isDisplayed(PropertiesRepository.getString(""));
			
			
			
			flag=(flag1 && flag2 );
			
		}
		catch (Exception e) {
				logger.info("unable to click on continue button" + e);
}
		logger.info("Method : click On Continue Button :::::::: Ends");
		return flag;
}
	
	
	///////////////////////////////////// MY CODE
	
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
	
	
	
public boolean clickcontinuestep4(WebDriver chromeDriver) throws NullPointerException, DriverException {
	logger.info("Method: click continue Starts ");
	boolean flag = false;
	try {
		
		swithToProctorFrame(chromeDriver);
		WebElement continueElement = verifyElement(chromeDriver, PropertiesRepository.getString("step4.continue.button"));
		Thread.sleep(4000);
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
	
	
	
}
