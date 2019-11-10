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
import com.ascendlearning.automation.ui.handlers.ButtonHandler;
import com.ascendlearning.automation.ui.handlers.TextHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;

public class LoginPage2 extends IDBasePage {

	private Logger logger = LogManager.getLogger(this.getClass());
	private TextHandler textHandler;
	private ButtonHandler buttonHandler;
	private WindowHandler windowHanlder;

	public LoginPage2(WebDriver webDriver) {
		super(webDriver);
		textHandler = new TextHandler(driver);
		buttonHandler = new ButtonHandler(driver);
		windowHanlder = new WindowHandler(driver);
	}

	public boolean verifyElementIsEnabled(String locator) throws Exception {
		logger.info("Method : verifyElementIsEnabled Start");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(locator);
			if(CollectionUtils.isNotEmpty(element) && baseHandler.isDisplayed(element.get(0))) {
					element.get(0).sendKeys("Testing");
 				logger.info("Element is not enabled");
			} else {
				logger.info("Element is enabled");
			}
		}catch (Exception e) {
    		logger.info("Unable to verifyElementIsEnabled " );
			log(logger, "Unable to verifyElementIsEnabled" );
    		throw new DriverException("Unable to verifyElementIsEnabled" , e); 
    	}
		logger.info("Method: verifyElementIsEnabled End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to verify Browser name and its corresponding download link. 
	 * 
	 * @author saravanan.jothimani
	 * @param browserName
	 * @return
	 * @throws Exception
	 */
	public boolean verifyTechnicalRequirementDownloadLink(String browserName) throws Exception {
		logger.info("Method : verifyTechnicalRequirementDownloadLink Start");
		boolean flag = false;
		try {
			windowHandler.switchToLatestWindow();
			// Getting browser and device table in technical requirement section
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("id.login.page.technical.requirement.download.table.row.loc"));
			if(CollectionUtils.isNotEmpty(element)) {
				for(WebElement downloadLinkElement : element) {
					// Getting browser name and verifying download link.
					List<WebElement> browserUIName = downloadLinkElement.findElements(By.cssSelector("td"));
					if(CollectionUtils.isNotEmpty(browserUIName) ) {
						if(browserUIName.get(0).getText().trim().contains(browserName)) {
						WebElement downloadLinkEle = browserUIName.get(2).findElement(By.cssSelector("a"));
						if(downloadLinkEle != null) {
							flag = true;
							break;
						}
						}
					} else {
						logger.info("Browser Name is not matched");
					}
				} 
			} else {
				logger.info("Browser list is not present");
			}
		}catch (Exception e) {
    		logger.info("Unable to verifyTechnicalRequirementDownloadLink" );
			log(logger, "Unable to verifyTechnicalRequirementDownloadLink" );
    		throw new DriverException("Unable to verifyTechnicalRequirementDownloadLink" , e); 
    	}
		logger.info("Method: verifyTechnicalRequirementDownloadLink End flag --> " + flag);
		return flag;
	}
}
