package com.automation.id.pages;

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
import com.ascendlearning.automation.ui.handlers.TextHandler;

public class ReportWizardReportPage extends IDBasePage {

	private Logger logger = LogManager.getLogger(this.getClass());
	private BaseHandler baseHandler;

	public ReportWizardReportPage(WebDriver webDriver) {
		super(webDriver);
		baseHandler = new BaseHandler(driver);
		textHandler = new TextHandler(driver);
	}

	/**
	 * Method used to get the list of portlet and verify its name, apply and continue button. 
	 * 
	 * @author saravanan.jothimani
	 * @param reportName
	 * @return
	 * @throws Exception
	 */
	public boolean verifyCommAndCivilityMentorPortletDetails(String reportName) throws Exception {
		logger.info("Method verifyCommAndCivilityMentorPortletDetails : Start");
		logger.info("reportName value --> " +reportName);
		boolean flag = false;
		try {
			// Get all portlets.
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString(
					"id.analytics.classic.reporting.quick.reports.tutorial.comm.and.civility.mentor.portlet.table.loc"));
			for(WebElement individualPortletElement : element) {
				// Verifying Title 
				List<WebElement> titleElement = individualPortletElement
						.findElements(By.cssSelector(PropertiesRepository.getString(
								"id.analytics.classic.reporting.quick.reports.tutorial.comm.and.civility.mentor.portlet.table.title.loc")));
				if(CollectionUtils.isNotEmpty(titleElement) && reportName.equalsIgnoreCase(titleElement.get(0).getText().trim())) {
					// Verifying Apply and Continue Button
					List<WebElement> applyBtnElement = individualPortletElement
							.findElements(By.cssSelector(PropertiesRepository.getString(
									"id.analytics.classic.reporting.quick.reports.tutorial.comm.and.civility.mentor.portlet.table.apply.button.loc")));
					
					List<WebElement> continueBtnElement = individualPortletElement
							.findElements(By.cssSelector(PropertiesRepository.getString(
									"id.analytics.classic.reporting.quick.reports.tutorial.comm.and.civility.mentor.portlet.table.continue.button.loc")));
					if(CollectionUtils.isNotEmpty(applyBtnElement) && CollectionUtils.isNotEmpty(continueBtnElement)) {
						flag = true;
						waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
						break;
					} else {
						logger.info("Either apply button or continue button is not displayed");
					}
 				}
				
			} 
		}catch (Exception e) {
    		logger.info("Unable to verifyCommAndCivilityMentorPortletDetails" );
			log(logger, "Unable to verifyCommAndCivilityMentorPortletDetails" );
    		throw new DriverException("Unable to verifyCommAndCivilityMentorPortletDetails" , e); 
    	}
		logger.info("Method: verifyCommAndCivilityMentorPortletDetails End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to get the list of portlet and verify its name, apply and continue button. 
	 * 
	 * @author saravanan.jothimani
	 * @param reportName
	 * @return
	 * @throws Exception
	 */
	public boolean verifyCommAndCivilityMentorPortletDetailsAndClickContinueButton(String reportName) throws Exception {
		logger.info("Method verifyCommAndCivilityMentorPortletDetailsAndClickContinueButton : Start");
		boolean flag = false;
		logger.info("reportName value --> " +reportName);
		try {
			// Get all portlets.
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString(
					"id.analytics.classic.reporting.quick.reports.tutorial.comm.and.civility.mentor.portlet.table.loc"));
			for(WebElement individualPortletElement : element) {
				// Verifying Title 
				List<WebElement> titleElement = individualPortletElement
						.findElements(By.cssSelector(PropertiesRepository.getString(
								"id.analytics.classic.reporting.quick.reports.tutorial.comm.and.civility.mentor.portlet.table.title.loc")));
				if(CollectionUtils.isNotEmpty(titleElement) && reportName.equalsIgnoreCase(titleElement.get(0).getText().trim())) {
					// Clicking on Continue button
					List<WebElement> continueBtnElement = individualPortletElement
							.findElements(By.cssSelector(PropertiesRepository.getString(
									"id.analytics.classic.reporting.quick.reports.tutorial.comm.and.civility.mentor.portlet.table.continue.button.loc")));
					if(CollectionUtils.isNotEmpty(continueBtnElement)) {
						continueBtnElement.get(0).click();
						waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
						flag = true;
						break;
					} else {
						logger.info("Either apply button or continue button is not displayed");
					}
 				}
				
			} 
		}catch (Exception e) {
    		logger.info("Unable to verifyCommAndCivilityMentorPortletDetailsAndClickContinueButton" );
			log(logger, "Unable to verifyCommAndCivilityMentorPortletDetailsAndClickContinueButton" );
    		throw new DriverException("Unable to verifyCommAndCivilityMentorPortletDetailsAndClickContinueButton" , e); 
    	}
		logger.info("Method: verifyCommAndCivilityMentorPortletDetailsAndClickContinueButton End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to verify rows are displayed in Modules. 
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @return
	 * @throws Exception
	 */
	public boolean verifyCommAndCivilityMentorPortletContinueBtnModulesList(String locator) throws Exception {
		logger.info("Method : verifyCommAndCivilityMentorPortletContinueBtnModulesList Start");
		logger.info("Locator value --> " + locator);
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(locator);
			if(CollectionUtils.isNotEmpty(element) && element.size() > 0) {
				flag = true;
			} else {
				logger.info("Modules Rows are not displayed in verifyCommAndCivilityMentorPortletContinueBtnModulesList");
			}
		}catch (Exception e) {
    		logger.info("Unable to verifyCommAndCivilityMentorPortletContinueBtnModulesList" );
			log(logger, "Unable to verifyCommAndCivilityMentorPortletContinueBtnModulesList" );
    		throw new DriverException("Unable to verifyCommAndCivilityMentorPortletContinueBtnModulesList" , e); 
    	}
		logger.info("Method: verifyCommAndCivilityMentorPortletContinueBtnModulesList End flag --> " + flag);
		return flag;
	}
}
