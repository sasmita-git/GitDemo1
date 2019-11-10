package com.automation.newati.pages;

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
import com.ascendlearning.automation.ui.handlers.WindowHandler;


public class HomePage2 extends NewATIBasePage {

	private Logger logger = LogManager.getLogger(this.getClass());
	private BaseHandler baseHandler;
	private WindowHandler windowHandler;
	
	public HomePage2(WebDriver webDriver) {
		super(webDriver);
		baseHandler = new BaseHandler(driver);
		windowHandler = new WindowHandler(driver);
	}
	
	/**
	 * Method used to verify the News section on the Home page.
	 * The VerifyHomePageNews() was hard coded for certain news, while this method verifies the presence and the pop up that is opened on clicking one of them.  
	 * 
	 * @author Vishal.r
	 * @param productType
	 * @param productName
	 * @return
	 */
	public boolean VerifyHomePageNewsNew() throws Exception {
		logger.info("Method : VerifyHomePageNewsNew Starts");
		boolean flag = false;
		boolean headerFlag = false;
		boolean popUpFlag = false;
		try {		
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.home.page.news.header.loc"));
			if(CollectionUtils.isNotEmpty(element)) {
				if(element.get(0).getText().equalsIgnoreCase(PropertiesRepository.getString("new-atitesting.home.page.news.header.value"))) {
					logger.info("News header is present.");
					headerFlag=true;
				}
			}
			if(headerFlag) {
			List<WebElement> newsElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.home.page.news.links.loc"));
				if(CollectionUtils.isNotEmpty(newsElement)) {
					String linkText = newsElement.get(0).getText();
					newsElement.get(0).click();
					logger.info("link ->" +newsElement.get(0).getText());
					//logger.info("popup header -> " + );
					String popUpText = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.news.link.pop.up.name.loc")).get(0).getText();
					if(popUpText.equalsIgnoreCase(linkText)) {
						popUpFlag = true;
					}
				}
			}
			if (headerFlag && popUpFlag) {
				logger.info("News header is present -> "+ headerFlag );
				logger.info("News link of the selected link is opened -> " + popUpFlag);
				flag = true;
			}
		}
		catch (Exception e) {
    		logger.info("Unable to verify the News section" );
			log(logger, "Unable to verify the News section" );
    		throw new DriverException("Unable to verify the News section" , e); 
    	}
		logger.info("Method: End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to verify news link and click on first link and click on close button. 
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws Exception
	 */
	public boolean verifyNewsMessage() throws Exception {
		logger.info("Method : verifyNewsMessage Start");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("newati.atitesting.homepage.news.list.loc"));
			// All list of news displayed. 
			if(CollectionUtils.isNotEmpty(element) && element.size() > 0) {
				// Getting name of first news link. 
				List<WebElement> firstNewsName = element.get(0).findElements(By.cssSelector(PropertiesRepository.getString("newati.atitesting.homepage.news.name.loc")));
				if(CollectionUtils.isNotEmpty(firstNewsName)) {
					// Clicking on first news link.
					List<WebElement> firstNewsLink = element.get(0).findElements(By.cssSelector("a"));
					if(CollectionUtils.isNotEmpty(firstNewsLink)) {
						firstNewsLink.get(0).click();
						windowHandler.switchToLatestWindow();
						// Getting Popup header name. 
						List<WebElement> popupHeader = baseHandler.findElements(PropertiesRepository.getString("newati.atitesting.homepage.news.popup.name.loc"));
						if(CollectionUtils.isNotEmpty(popupHeader)) {
							if(firstNewsName.get(0).getText().trim().equalsIgnoreCase(popupHeader.get(0).getText().trim())) {
								WebElement closeBtnElement = baseHandler.findElement(PropertiesRepository.getString("newati.atitesting.homepage.news.popup.close.button.loc"));
								if(closeBtnElement != null) {
									closeBtnElement.click();
									flag =  true;
								} else {
									logger.info("Unable to click on close button");
								}
							}else {
								logger.info("News name before and after click is not matching");
							}
						}else {
							logger.info("Unable to Getting Popup header name.");
						}
					} else {
						logger.info("Unable to Clicking on first news link.");
					}
				} else {
					logger.info("Unable to Get name of first news link. ");
				}
				windowHandler.switchToLatestWindow();
			} else {
				logger.info("News list is not present");
			}
		}catch (Exception e) {
    		logger.info("Unable to verifyNewsMessage" );
			log(logger, "Unable to verifyNewsMessage" );
    		throw new DriverException("Unable to verifyNewsMessage" , e); 
    	}
		logger.info("Method: verifyNewsMessageEnd flag --> " + flag);
		return flag;
	}
}


