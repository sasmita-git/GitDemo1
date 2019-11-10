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

public class MyATIPage extends ASMTBasePage {
	private Logger logger = LogManager.getLogger(this.getClass());
	public BaseHandler baseHandler;
	private boolean flag = false;

	public MyATIPage(WebDriver webDriver) {
		super(webDriver);
		baseHandler = new BaseHandler(driver);

	}
	
	/**
	 * Method used to verify individual tab under My ATI Tab. 
	 * 
	 * Learn
	 * Test
	 * Improve 
	 * Apply
	 * 
	 * If click is true, it should click on corresponding tab. 
	 * 
	 * @param locator
	 * @param index
	 * @param tabName
	 * @param click
	 * @return flag
	 * @throws Exception
	 */
	public boolean verifyMyATITabs(String locator, int index, String tabName, boolean click) throws Exception {
		logger.info("Method: verifyMyATITabs Starts");
    	try {
    		flag = false;
    		if(baseHandler.isDisplayed(locator)) {
    			List<WebElement> allTabElement = baseHandler.findElements(locator);
    			if(CollectionUtils.isNotEmpty(allTabElement)) {
    				WebElement element = allTabElement.get(index);
    				if(element != null) {
    					if(element.getText().trim().equalsIgnoreCase(tabName)) {
    						flag = true;
    						if(flag && click) {
    							element.click();
    							waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
    			    		}
    					}
    				}
    			}
    		}
    	} catch (Exception e) {
    		logger.info("Unable to verify My ATI Tabs");
			log(logger, "Unable to verify My ATI Tabs");
			throw new DriverException("Unable to verify My ATI Tabs", e);
    	}
    	logger.info("Method: verifyMyATITabs End flag --> " + flag);
    	return flag;
	}
	
	/**
	 * Method used to verify individual tab under My ATI Tab. 
	 * 
	 * Learn
	 * Test
	 * Improve 
	 * Apply
	 * 
	 * If click is true, it should click on corresponding tab. 
	 * 
	 * @param locator
	 * @param index
	 * @param tabName
	 * @param click
	 * @return flag
	 * @throws Exception
	 */
	public boolean verifyMyATITabValue(String locator, int index, String tabName, boolean click) throws Exception {
		logger.info("Method: verifyMyATITabs Starts");
    	try {
    		flag = false;
    		if(baseHandler.isDisplayed(locator)) {
    			List<WebElement> allTabElement = baseHandler.findElements(locator);
    			if(CollectionUtils.isNotEmpty(allTabElement)) {
    				WebElement element = allTabElement.get(index);
    				if(element != null) {
    					if(element.getText().trim().equalsIgnoreCase(tabName)) {
    						flag = true;
    						if(flag && click) {
    							element.click();
    			    		}
    					}
    				}
    			}
    		}
    	} catch (Exception e) {
    		logger.info("Unable to verify My ATI Tabs");
			log(logger, "Unable to verify My ATI Tabs");
			throw new DriverException("Unable to verify My ATI Tabs", e);
    	}
    	logger.info("Method: verifyMyATITabs End flag --> " + flag);
    	return flag;
	}
	
	/**
	 * Method used to verify all tabs in My ATI Tab.
	 *  
	 * @author saravanan.jothimani
	 * @return boolean
	 * @throws Exception
	 */
	public boolean verifyAllTabsUnderMyATITab() throws Exception {
		logger.info("Method: verifyAllTabsUnderMyATITab Starts");
		try {
			flag = false;
			// Learn Tab
			if (verifyMyATITabs(
					PropertiesRepository.getString("asmt.myati.all.tab.loc"),
					0, PropertiesRepository.getString("asmt.myati.tabs.learn"), false)) {
				// Test Tab
				if (verifyMyATITabs(
						PropertiesRepository
								.getString("asmt.myati.all.tab.loc"),
						1, PropertiesRepository
								.getString("asmt.myati.tabs.test"), false)) {
					// Improve Tab
					if (verifyMyATITabs(
							PropertiesRepository
									.getString("asmt.myati.all.tab.loc"),
							2, PropertiesRepository
									.getString("asmt.myati.tabs.improve"), false)) {
						// Apply Tab
						if (verifyMyATITabs(
								PropertiesRepository
										.getString("asmt.myati.all.tab.loc"),
								3, PropertiesRepository
										.getString("asmt.myati.tabs.apply"), false)) {
							flag = true;
						} else {
							log(logger, "Unabel to verify Apply tab");
						}
					} else {
						log(logger, "Unabel to verify Improve tab");
					}
				} else {
					log(logger, "Unabel to verify Test tab");
				}
			} else {
				log(logger, "Unabel to verify Learn tab");
			}
		} catch (Exception e) {
			logger.info("Unable to verify All Tabs Under My ATI Tab");
			log(logger, "Unable to verify All Tabs Under My ATI Tab");
			throw new DriverException(
					"Unable to verify All Tabs Under My ATI Tab", e);
		}
		logger.info("Method: verifyAllTabsUnderMyATITab End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to verify button name based on assessment name. 
	 * Button name can be Begin/ Continue/ Retake.
	 * 
	 * @param assessmentName
	 * @return
	 * @throws Exception
	 */
	public boolean verifyPractiseAssessentButtonName(String assessmentName) throws Exception {
		logger.info("Method : Start");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements("#testApplications .card.practice-assessment.front");
			if(CollectionUtils.isNotEmpty(element)) {
				int size = element.size();
				for(int index = 0 ; index < size; index++) {
					WebElement practiseElement =element.get(index);
					WebElement nameElement =element.get(index).findElement(By.cssSelector(".description"));
					if(nameElement != null && assessmentName.equalsIgnoreCase(nameElement.getText())) {
						List<WebElement> buttonElement = practiseElement.findElements(By.cssSelector(".actions div a[class='button primary-button button-focus focus-element-flag']"));
						if(CollectionUtils.isNotEmpty(buttonElement)) {
							for(WebElement btnNameElement : buttonElement) {
								if(!btnNameElement.getAttribute("style").equalsIgnoreCase("display: none;")) {
									if(btnNameElement.getText().equalsIgnoreCase("Continue")) {
										flag = true;
										break;
									}
								}
							}
						}
					}
				}
			}
		}catch (Exception e) {
    		logger.info("Unable to " );
			log(logger, "Unable to " );
    		throw new DriverException("Unable to " , e); 
    	}
		logger.info("Method: End flag --> " + flag);
		return flag;
	}
}
