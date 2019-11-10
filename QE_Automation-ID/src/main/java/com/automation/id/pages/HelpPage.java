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

public class HelpPage extends IDBasePage {

	private Logger logger = LogManager.getLogger(this.getClass());

	public HelpPage(WebDriver webDriver) {
		super(webDriver);
	}

	/**
	 * Method used to verify Help Page portlet name and message
	 * 
	 * @author saravanan.jothimani
	 * @param subHeading
	 * @param message
	 * @return boolean
	 * @throws NullPointerException
	 * @throws DriverException
	 */
	public boolean verifyHelpMessage(String subHeading, String message) throws NullPointerException, DriverException {
		logger.info("Method: verifyHelpMessage Starts");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("id.help.all.portlets.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				for (WebElement webElement : element) {
					WebElement subHeadingElement = webElement.findElement(By
							.cssSelector(PropertiesRepository.getString("id.help.all.portlets.heading.name.new.loc")));
					if (subHeadingElement.getText().trim().equalsIgnoreCase(subHeading)) {
						WebElement messageElement = webElement.findElement(
								By.cssSelector(PropertiesRepository.getString("id.help.all.portlets.message.new.loc")));
						if (messageElement != null && messageElement.getText().equalsIgnoreCase(message)) {
							flag = true;
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verifyHelpMessage");
			log(logger, "Unable to verifyHelpMessage");
			throw new DriverException("Unable to verifyHelpMessage", e);
		}
		logger.info("Method: verifyHelpMessage End flag --> " + flag);
		return flag;
	}

	/**
	 * Method used to verify Help Page portlet name and message
	 * 
	 * @author saravanan.jothimani
	 * @param subHeading
	 * @param message
	 * @return boolean
	 * @throws NullPointerException
	 * @throws DriverException
	 */
	public boolean verifyHelpMessageContains(String subHeading, String message)
			throws NullPointerException, DriverException {
		logger.info("Method: verifyHelpMessageContains Starts");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("id.help.all.portlets.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				for (WebElement webElement : element) {
					WebElement subHeadingElement = webElement.findElement(By
							.cssSelector(PropertiesRepository.getString("id.help.all.portlets.heading.name.new.loc")));
					if (subHeadingElement.getText().trim().equalsIgnoreCase(subHeading)) {
						WebElement messageElement = webElement.findElement(
								By.cssSelector(PropertiesRepository.getString("id.help.all.portlets.message.new.loc")));
						if (messageElement != null && messageElement.getText().contains(message)) {
							flag = true;
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verifyHelpMessageContains");
			log(logger, "Unable to verifyHelpMessageContains");
			throw new DriverException("Unable to verifyHelpMessageContains", e);
		}
		logger.info("Method: verifyHelpMessageContains End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to verify Help Page portlet name and message
	 * 
	 * @author saravanan.jothimani
	 * @param subHeading
	 * @param message
	 * @return boolean
	 * @throws NullPointerException
	 * @throws DriverException
	 */
	public boolean verifyHelpPageTiles(String subHeading, String message)
			throws NullPointerException, DriverException {
		logger.info("Method: verifyHelpMessageContains Starts");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("id.help.all.portlets.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				for (WebElement webElement : element) {
					WebElement subHeadingElement = webElement.findElement(By
							.cssSelector(PropertiesRepository.getString("id.help.all.portlets.heading.name.new.loc")));
					if (subHeadingElement.getText().trim().equalsIgnoreCase(subHeading)) {
						WebElement messageElement = webElement.findElement(
								By.cssSelector(PropertiesRepository.getString("id.help.all.portlets.message.new.loc")));
						if (messageElement != null && messageElement.getText().contains(message)) {
							subHeadingElement.click();
							waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
							List<WebElement> plusElements = baseHandler
									.findElements(PropertiesRepository.getString("id.help.website.basics.all.menu.plus.symbol.loc"));
							if (CollectionUtils.isNotEmpty(plusElements)) {
								plusElements.get(0).click();
								waitForAwhile(1000);
								
								List<WebElement> linkElement = baseHandler.findElements(
										PropertiesRepository.getString("id.help.tile.list.link"));
								if (CollectionUtils.isNotEmpty(linkElement)) {
									/*if(subHeading.trim().equalsIgnoreCase("eBooks & Active Learning")){
										linkElement.get(0).click();
										waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

										windowHandler.switchToLatestWindow();
										driver.close();
										waitForAwhile(1000);
										windowHandler.switchToLatestWindow();
										waitForAwhile(1000);
									}*/
									List<WebElement> resourceElement = baseHandler.findElements(
											PropertiesRepository.getString("id.help.tile.resources.link"));
									if (resourceElement != null) {
										resourceElement.get(0).click();
										waitForAwhile(1000);
										flag = true;
										break;
									}
									else{
										logger.info("Unable to click on resource link to go back to list of tiles");
									}
								}
								else{
									logger.info("Unable to find links inside the "+subHeading+" tile");
								}							
							}
							else{
								logger.info("Unable to click on plus symbol inside the "+subHeading+" tile");
							}
						}
						else{
							logger.info("Unable to click on "+subHeading+" tile");
						}
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verifyHelpMessageContains");
			log(logger, "Unable to verifyHelpMessageContains");
			throw new DriverException("Unable to verifyHelpMessageContains", e);
		}
		logger.info("Method: verifyHelpMessageContains End flag --> " + flag);
		return flag;
	}
	/*
	*//**
	 * Method used to verify tile links are intact
	 * 
	 * @author girish.m
	 * @param subHeading
	 * @param message
	 * @return boolean
	 * @throws NullPointerException
	 * @throws DriverException
	 *//*
	public boolean verifyTileLinksIntact(String subHeading)
			throws NullPointerException, DriverException {
		logger.info("Method: verifyTileLinksIntact Starts");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("id.help.all.portlets.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				for (WebElement webElementPrnt : element) {
					
					
					
					WebElement subHeadingElement = webElementPrnt.findElement(By
							.cssSelector(PropertiesRepository.getString("id.help.all.portlets.heading.name.new.loc")));
					if (subHeadingElement.getText().trim().equalsIgnoreCase(subHeading)) {
						subHeadingElement.click();
						waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
						List<WebElement> plusElements = baseHandler
								.findElements(PropertiesRepository.getString("id.help.website.basics.all.menu.plus.symbol.loc"));
						if (CollectionUtils.isNotEmpty(plusElements)) {
							plusElements.get(0).click();
							waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
							
							List<WebElement> linkElement = baseHandler.findElements(
									PropertiesRepository.getString("id.help.tile.list.link"));
							if (CollectionUtils.isNotEmpty(linkElement)) {
								List<WebElement> resourceElement = baseHandler.findElements(
										PropertiesRepository.getString("id.help.tile.resources.link"));
								if (resourceElement != null) {
									resourceElement.get(0).click();
									waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
									flag = true;
									break;
								}
								else{
									logger.info("Unable to click on resource link to go back to list of tiles");
								}
							}
							else{
								logger.info("Unable to find links inside the "+subHeading+" tile");
							}							
						}
						else{
							logger.info("Unable to click on plus symbol inside the "+subHeading+" tile");
						}
					}
					else{
						logger.info("Unable to click on "+subHeading+" tile");
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verifyTileLinksIntact");
			log(logger, "Unable to verifyTileLinksIntact");
			throw new DriverException("Unable to verifyTileLinksIntact", e);
		}
		logger.info("Method: verifyTileLinksIntact End flag --> " + flag);
		return flag;
	}
*/
	/**
	 * Method used to verify Help Page portlet name and message
	 * 
	 * @author saravanan.jothimani
	 * @param subHeading
	 * @param message
	 * @return boolean
	 * @throws NullPointerException
	 * @throws DriverException
	 */
	public boolean verifyWebsiteBasicsContent(String subHeading)
			throws NullPointerException, DriverException {
		logger.info("Method: verifyWebsiteBasicsContent Starts");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("id.help.all.portlets.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				for (WebElement webElement : element) {
					WebElement subHeadingElement = webElement.findElement(By
							.cssSelector(PropertiesRepository.getString("id.help.all.portlets.heading.name.new.loc")));
					if (subHeadingElement.getText().trim().equalsIgnoreCase(subHeading)) {
						// Clicking on Website Basics
						webElement.click();
						waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
						
						//Website basic header verification. 
						boolean boolHeader = verifyTextContains(PropertiesRepository.getString("id.help.website.basics.header.loc"), PropertiesRepository.getString("id.help.website.basics.header.value"), 0);
						
						// Verifying Welcome to ATI and its popup. 
						boolean boolWelcomeToATISection = verifyWebsiteBasicHomeAndWebsiteNavigationSection();
						
						if(boolHeader && boolWelcomeToATISection) {
							flag = true;
							break;
						}
					} else {
						logger.info("Unable to get Website Basics content");
					}
				}
			} else {
				logger.info("Unable to get Help Page locators");
			}
		} catch (Exception e) {
			logger.info("Unable to verifyWebsiteBasicsContent");
			log(logger, "Unable to verifyWebsiteBasicsContent");
			throw new DriverException("Unable to verifyWebsiteBasicsContent", e);
		}
		logger.info("Method: verifyWebsiteBasicsContent End flag --> " + flag);
		return flag;
	}
	
	public boolean verifyWebsiteBasicHomeAndWebsiteNavigationSection() throws Exception {
		//logger.info("Method : verifyWebsiteBasicHomeAndWebsiteNavigationSection Start");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("id.help.website.basics.all.menu.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				for (WebElement menuWebElement : element) {
					// Getting and verifying Menu name.
					WebElement menuNameElement = menuWebElement.findElement(
							By.cssSelector(PropertiesRepository.getString("id.help.website.basics.all.menu.name.loc")));
					if (menuNameElement != null && menuNameElement.getText().trim().equalsIgnoreCase(
							PropertiesRepository.getString("id.help.website.basics.all.menu.name.value"))) {
						// Clicking on + symbol.
						WebElement plusElement = menuWebElement.findElement(By.cssSelector(
								PropertiesRepository.getString("id.help.website.basics.all.menu.plus.symbol.loc")));
						if (plusElement != null) {
							plusElement.click();
							// Verifying Welcome to ATI Link. 
							List<WebElement> welcomeToATILinkElement = menuWebElement.findElements(By.cssSelector(
									PropertiesRepository.getString("id.help.website.basics.all.menu.welcome.to.ati.link.loc")));
							if(CollectionUtils.isNotEmpty(welcomeToATILinkElement)) {
								welcomeToATILinkElement.get(1).click();
								waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
								waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
								// Verifying Welcome to ATI Popup 1.
								boolean boolPopup1 = verifyWelcomeToATIPopup(PropertiesRepository.getString("id.help.website.basics.all.menu.welcome.to.ati.link.popup.message1.value"));
								waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
								// Verifying Welcome to ATI Popup 2.
								boolean boolPopup2 = verifyWelcomeToATIPopup(PropertiesRepository.getString("id.help.website.basics.all.menu.welcome.to.ati.link.popup.message2.value"));
								waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
								// Verifying Welcome to ATI Popup 3.
								boolean boolPopup3 = verifyWelcomeToATIPopup(PropertiesRepository.getString("id.help.website.basics.all.menu.welcome.to.ati.link.popup.message3.value"));
								
								if(boolPopup1 && boolPopup2 && boolPopup3 ) {
									flag = true;
								}
								
							}
						} else {
							logger.info("Unable to click on Plus Symbol.");
						}
					} else {
						logger.info("Unable to verify menu name");
					}
				}
			} else {
				logger.info("Unable to get locator element");
			}
		} catch (Exception e) {
			logger.info("Unable to verifyWebsiteBasicHomeAndWebsiteNavigationSection");
			log(logger, "Unable to verifyWebsiteBasicHomeAndWebsiteNavigationSection");
			throw new DriverException("Unable to verifyWebsiteBasicHomeAndWebsiteNavigationSection", e);
		}
		logger.info("Method: verifyWebsiteBasicHomeAndWebsiteNavigationSection End flag --> " + flag);
		return flag;
	}
	
	
	public boolean verifyWelcomeToATIPopup(String message) throws Exception {
		logger.info("Method : Start");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("id.help.website.basics.all.menu.welcome.to.ati.link.popup.message1.loc"));
			if(CollectionUtils.isNotEmpty(element) && element.get(0).getText().trim().equalsIgnoreCase(message)) {
				flag = verifyAndClick(PropertiesRepository.getString("id.help.website.basics.all.menu.welcome.to.ati.link.popup.message1.next.button.loc"), true);
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
