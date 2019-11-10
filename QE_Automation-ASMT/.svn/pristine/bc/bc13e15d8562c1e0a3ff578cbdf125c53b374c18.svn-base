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

public class MyResultsPage extends ASMTBasePage {

	private Logger logger = LogManager.getLogger(this.getClass());
	private BaseHandler baseHandler;
	
	public MyResultsPage(WebDriver webDriver) {
		super(webDriver);
		baseHandler = new BaseHandler(driver);
	}
	
	public boolean verifyPracticeAssessmentTitle(int index, String assessmentName) throws Exception {
		logger.info("Method: verifyPracticeAssessmentTitle Starts");
		boolean flag = false;
    	try {
    		List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("asmt.myresults.all.table"));
    		if(CollectionUtils.isNotEmpty(element) && element.size() > 0) {
    			// Getting Practice Assessment Section
    			WebElement practiceSection = element.get(1);
    			if(practiceSection != null) {
    				List<WebElement> trElement = element.get(1).findElements(By.cssSelector(PropertiesRepository.getString("asmt.myresults.practice.assessment.table")));
    				if(CollectionUtils.isNotEmpty(trElement)) {
    					// Getting first row from Practice Assessment
    					List<WebElement> assessmentAllColumnElement = trElement
    							.get(index).findElements(By.cssSelector("td"));
    					if(CollectionUtils.isNotEmpty(assessmentAllColumnElement) && assessmentAllColumnElement.get(0).getText().trim().equalsIgnoreCase(assessmentName)) {
    						flag = true;
    					}
    				}
    			}
    		}
    	} catch (Exception e) {
    		logger.info("Unable to verify Practice Assessment Title");
			log(logger, "Unable to verify Practice Assessment Title" );
    		throw new DriverException("Unable to verify Practice Assessment Title" , e); 
    	}
    	logger.info("Method: verifyPracticeAssessmentTitle End flag --> " + flag);
    	return flag;
	}
	
	public boolean verifyPracticeAssessmentOtherHeadings(int index, int columnIndex) throws Exception {
		logger.info("Method: verifyPracticeAssessmentTitle Starts");
		boolean flag = false;
    	try {
    		List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("asmt.myresults.all.table"));
    		if(CollectionUtils.isNotEmpty(element) && element.size() > 0) {
    			// Getting Practice Assessment Section
    			WebElement practiceSection = element.get(1);
    			if(practiceSection != null) {
    				List<WebElement> trElement = element.get(1).findElements(By.cssSelector(PropertiesRepository.getString("asmt.myresults.practice.assessment.table")));
    				if(CollectionUtils.isNotEmpty(trElement)) {
    					// Getting row from Practice Assessment
    					// Getting first row from Practice Assessment
    					List<WebElement> assessmentAllColumnElement = trElement.get(index).findElements(By.cssSelector("td"));
    					if(CollectionUtils.isNotEmpty(assessmentAllColumnElement)) {
    						flag = assessmentAllColumnElement.get(columnIndex).isDisplayed();
    						}
    					}
    				}
    			}
    	} catch (Exception e) {
    		logger.info("Unable to verify Practice Assessment Title");
			log(logger, "Unable to verify Practice Assessment Title" );
    		throw new DriverException("Unable to verify Practice Assessment Title" , e); 
    	}
    	logger.info("Method: verifyPracticeAssessmentTitle End flag --> " + flag);
    	return flag;
	}

}
