package com.automation.asmt.page;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.ButtonHandler;

public class NPMStapper2Page extends ASMTBasePage {
	private ButtonHandler buttonHandler;

	private Logger logger = LogManager.getLogger(this.getClass());
	private BaseHandler baseHandler;
	boolean result=false;
	public NPMStapper2Page(WebDriver webDriver) {
		super(webDriver);
		baseHandler = new BaseHandler(driver);
		buttonHandler = new ButtonHandler(driver);

	}
	 

	/**
	 * Method is used to Search assessment in step 2
	 * 
	 *
	 * 
	 * @param int
	
	  @throws Exception
	 **/
	private void clickOnSearchButton() throws Exception {
		logger.info("Method : click on serch button :::::::: Starts");
		try {
	
			logger.info("Click on search button2--> ");
			WebElement searchButton = baseHandler.findElement(PropertiesRepository.getString("step2.search.button"));
			buttonHandler.clickButton(searchButton);	
			
		}
		catch (Exception e) {
				logger.info("unable to search assessment" + e);
}
		logger.info("Method : click on serch button :::::::: Ends");
}
	
	private void searchAssessment(String batchID) throws Exception {
		logger.info("Method : search assessment :::::::: Starts");
		try {
	
			logger.info("search assessement--> "+batchID );
			WebElement searchAssessmenthereelement = baseHandler.findElement(PropertiesRepository.getString("step2.search.here"));
			buttonHandler.clickButton(searchAssessmenthereelement);
			searchAssessmenthereelement.sendKeys(batchID);
			
		}
		catch (Exception e) {
				logger.info("unable to search assessment"+ batchID + e);
}
		logger.info("Method : search assessment :::::::: Ends");
}
	private void selectAssessment() throws Exception {
		logger.info("Method : select assessment :::::::: Starts");
		try {
	
			logger.info("select assessement--> " );
			WebElement selectAssessmentelement = baseHandler.findElement(PropertiesRepository.getString("step2.checkbox.for.assessment"));
			buttonHandler.clickButton(selectAssessmentelement);
			
		}
		catch (Exception e) {
				logger.info("unable to select assessment" + e);
}
		logger.info("Method : select assessment :::::::: Ends");
}
	
	
	private void getSelectedAssessmentName() throws Exception {
		logger.info("Method : Get Selected Assessment Name :::::::: Starts");
		try {
	
			logger.info("Get Selected Assessment Name--> " );
			
			
		}
		catch (Exception e) {
				logger.info("unable to Get Selected Assessment Name" + e);
}
		logger.info("Method : Get Selected Assessment Name :::::::: Ends");
}
	
	
	
	
	
	
	
	
	private void clickOnContinueButton() throws Exception {
		logger.info("Method : click On Continue Button :::::::: Starts");
		try {
	
			logger.info("Click On Continue Button -> " );
			WebElement ClickoncontinueButtonElement = baseHandler.findElement(PropertiesRepository.getString("step2.continue.button"));
			buttonHandler.clickButton(ClickoncontinueButtonElement);
			
		}
		catch (Exception e) {
				logger.info("unable to click on continue button" + e);
}
		logger.info("Method : click On Continue Button :::::::: Ends");
}
	public boolean selectAssesmentAndCloickOnContinue(String batchID) throws Exception {
		
		logger.info("Method : click On Continue Button :::::::: Starts");
		try {
			clickOnSearchButton();
			searchAssessment(batchID);
			Thread.sleep(2000);
			selectAssessment();
			clickOnContinueButton();
			result=true;
			
		}
		catch (Exception e) {
				logger.info("unable to click on continue button" + e);
}
		logger.info("Method : click On Continue Button :::::::: Ends");	
		return result;
}
}