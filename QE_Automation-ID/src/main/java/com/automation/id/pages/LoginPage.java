package com.automation.id.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.ButtonHandler;
import com.ascendlearning.automation.ui.handlers.TextHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;

public class LoginPage extends LoginPage2 {

	private Logger logger = LogManager.getLogger(this.getClass());
	private TextHandler textHandler;
	private ButtonHandler buttonHandler;
	private WindowHandler windowHanlder;

	public LoginPage(WebDriver webDriver) {
		super(webDriver);
		textHandler = new TextHandler(driver);
		buttonHandler = new ButtonHandler(driver);
		windowHanlder = new WindowHandler(driver);
	}

	public void enterURL(String url) throws Exception {
		logger.info("Method : enterURL :::::::: START");
		driver.get(url);
		waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		logger.info("Method : enterURL :::::::: END");
	}

	/*
	 * @author syed.pasha
	 */
	public void MaintanacePopUp() throws InterruptedException, Exception  {
		logger.info("Method : Verifying Maintance pop-up :::: START ");
		List<WebElement> buttonList = driver.findElements(By.cssSelector(".walkme-action-playBf-0.wm-blue-btn.wm-template-main-bg.wm-main-border-bottom-darker.wm-action-text-color.wm-main-bg-hover")); 
		if (CollectionUtils.isNotEmpty(buttonList)) {
			buttonList.get(0).click();
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			
			// Clicking on Welcome to ATI Nursing Education Faculty Portal Small Popup. 
			List<WebElement> smallPopupCloseElement = driver.findElements(By.cssSelector(".walkme-click-and-hover.walkme-custom-balloon-close-button.walkme-action-close.walkme-inspect-ignore"));
			if(CollectionUtils.isNotEmpty(smallPopupCloseElement)) {
				smallPopupCloseElement.get(0).click();
				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				
				// Sorry Popup.
				List<WebElement> sorryPopupCloseElement = driver.findElements(By.cssSelector("span[class='walkme-custom-balloon-button-text']"));
				if(CollectionUtils.isNotEmpty(sorryPopupCloseElement)) {
					sorryPopupCloseElement.get(0).click();
					waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
					
				} else {
					logger.info("Unable to close sorry popup");
				}
			} else {
				logger.info("Unable to close welcome to ati nursing education fp popup");
			}
		} else {
			logger.info("Unable to close main welcome popup window");
		}

		logger.info("Method : Verifying Maintance pop-up :::: END");
	}

	/**
	 * Method used to login to application.
	 * 
	 * @param userName
	 * @param password
	 * @throws NullPointerException
	 * @throws DriverException
	 */
	public boolean loginToApplication(String userName, String password) throws NullPointerException, DriverException {
		logger.info("loginToApplication Start");
		boolean flag = false;
		try {
			driver.get(PropertiesRepository.getString("id.url"));
			WebElement userNameElement = verifyElement(PropertiesRepository.getString("id.login.username.loc"));
			WebElement passwordElement = verifyElement(PropertiesRepository.getString("id.login.password.loc"));
			WebElement goButton = verifyElement(PropertiesRepository.getString("id.login.go.button"));
			
			logger.info("User name --> " + userName);
			logger.info("Password --> " + password);
			
			if (userNameElement != null && passwordElement != null && StringUtils.isNotBlank(userName) && StringUtils.isNotBlank(password)   
					) {
				textHandler.writeText(userNameElement, userName);
				textHandler.writeText(passwordElement, password);
				buttonHandler.clickButton(goButton);
				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				
				// Welcome to ATI Popup Remindme later btn. 
				List<WebElement> welcomeToATIGetStartedBtn = verifyElementList(".walkme-action-remindMeNextDay-1.wm-close-link");
				List<WebElement> welcomeToATIGetStartedBtnNew = verifyElementList(".walkme-action-playBf-0.wm-blue-btn.wm-template-main-bg.wm-main-border-bottom-darker.wm-action-text-color.wm-main-bg-hover");
				
				if(CollectionUtils.isNotEmpty(welcomeToATIGetStartedBtnNew)) {
					welcomeToATIGetStartedBtnNew.get(0).click();
					// Clicking on Welcome to ATI Nursing Education Faculty Portal Small Popup. 
					List<WebElement> smallPopupCloseElement = driver.findElements(By.cssSelector(".walkme-click-and-hover.walkme-custom-balloon-close-button.walkme-action-close.walkme-inspect-ignore"));
					if(CollectionUtils.isNotEmpty(smallPopupCloseElement)) {
						smallPopupCloseElement.get(0).click();
						waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
						
						// Sorry Popup.
						List<WebElement> sorryPopupCloseElement = driver.findElements(By.cssSelector("span[class='walkme-custom-balloon-button-text']"));
						if(CollectionUtils.isNotEmpty(sorryPopupCloseElement)) {
							sorryPopupCloseElement.get(0).click();
							waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
							
						} else {
							logger.info("Unable to close sorry popup");
						}
					} else {
						logger.info("Unable to close welcome to ati nursing education fp popup");
					}
				}
				
				/*if(CollectionUtils.isNotEmpty(welcomeToATIGetStartedBtn)) {
					welcomeToATIGetStartedBtn.get(0).click();
					waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
					
					// Clicking on Welcome to ATI Nursing Education Faculty Portal Small Popup. 
					List<WebElement> smallPopupCloseElement = driver.findElements(By.cssSelector(".walkme-click-and-hover.walkme-custom-balloon-close-button.walkme-action-close.walkme-inspect-ignore"));
					if(CollectionUtils.isNotEmpty(smallPopupCloseElement)) {
						smallPopupCloseElement.get(0).click();
						waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
						
						// Sorry Popup.
						List<WebElement> sorryPopupCloseElement = driver.findElements(By.cssSelector("span[class='walkme-custom-balloon-button-text']"));
						if(CollectionUtils.isNotEmpty(sorryPopupCloseElement)) {
							sorryPopupCloseElement.get(0).click();
							waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
							
						} else {
							logger.info("Unable to close sorry popup");
						}
					} else {
						logger.info("Unable to close welcome to ati nursing education fp popup");
					}
					
				}*/
				
			/*	// Welcome to ATI Popup Start. 
				WebElement welcomeToATIStartBtn = verifyElement("span[class='walkme-custom-balloon-button-text']");
				if(welcomeToATIStartBtn != null) {
					welcomeToATIStartBtn.click();
				}*/
				
				// Close Alert Box if present , close it
				List<WebElement> alertPopupCloseBtn = verifyElementList(PropertiesRepository.getString("id.home.alert.message.popup.loc"));
				if(CollectionUtils.isNotEmpty(alertPopupCloseBtn)) {
					alertPopupCloseBtn.get(0).click();
				}
				/*if ((baseHandler.findElements("a[class='ati-modal-close']")).size() != 0) {
					baseHandler.findElement("a[class='ati-modal-close']").click();
				}*/
				flag = true;
			} else {
				logger.info("Both Username and password values are null");
			}
		} catch (Exception e) {
			logger.info("Unable to loginToApplication");
			log(logger, "Unable to loginToApplication");
			throw new DriverException("Unable to loginToApplication", e);
		}
		logger.info("loginToApplication End flag --> " + flag );
		return flag;
	}
	
	/**
	 * Method used to login to application.
	 * 
	 * @param userName
	 * @param password
	 * @throws NullPointerException
	 * @throws DriverException
	 */
	public boolean loginToApplicationVerifyLoadingImg(String userName, String password) throws NullPointerException, DriverException {
		logger.info("loginToApplicationVerifyLoadingImg Start");
		boolean flag = false;
		boolean loadingImageFlag = false;
		
		try {
			driver.get(PropertiesRepository.getString("id.url"));
			WebElement userNameElement = verifyElement(PropertiesRepository.getString("id.login.username.loc"));
			WebElement passwordElement = verifyElement(PropertiesRepository.getString("id.login.password.loc"));
			WebElement goButton = verifyElement(PropertiesRepository.getString("id.login.go.button"));
			
			logger.info("User name --> " + userName);
			logger.info("Password --> " + password);
			
			if (userNameElement != null && passwordElement != null && StringUtils.isNotBlank(userName) && StringUtils.isNotBlank(password)   
					) {
				textHandler.writeText(userNameElement, userName);
				textHandler.writeText(passwordElement, password);
				buttonHandler.clickButton(goButton);
				loadingImageFlag = verifyWaitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				
				// Welcome to ATI Popup Remindme later btn. 
				WebElement welcomeToATIGetStartedBtn = verifyElement(".walkme-action-remindMeNextDay-1.wm-close-link");
				WebElement welcomeToATIGetStartedBtnNew = verifyElement(".walkme-action-playBf-0.wm-blue-btn.wm-template-main-bg.wm-main-border-bottom-darker.wm-action-text-color.wm-main-bg-hover");
				
				if(welcomeToATIGetStartedBtnNew != null) {
					welcomeToATIGetStartedBtnNew.click();
					// Clicking on Welcome to ATI Nursing Education Faculty Portal Small Popup. 
					List<WebElement> smallPopupCloseElement = driver.findElements(By.cssSelector(".walkme-click-and-hover.walkme-custom-balloon-close-button.walkme-action-close.walkme-inspect-ignore"));
					if(CollectionUtils.isNotEmpty(smallPopupCloseElement)) {
						smallPopupCloseElement.get(0).click();
						waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
						
						// Sorry Popup.
						List<WebElement> sorryPopupCloseElement = driver.findElements(By.cssSelector("span[class='walkme-custom-balloon-button-text']"));
						if(CollectionUtils.isNotEmpty(sorryPopupCloseElement)) {
							sorryPopupCloseElement.get(0).click();
							waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
							
						} else {
							logger.info("Unable to close sorry popup");
						}
					} else {
						logger.info("Unable to close welcome to ati nursing education fp popup");
					}
				}
				
				if(welcomeToATIGetStartedBtn != null ) {
					welcomeToATIGetStartedBtn.click();
					waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
					
					// Clicking on Welcome to ATI Nursing Education Faculty Portal Small Popup. 
					List<WebElement> smallPopupCloseElement = driver.findElements(By.cssSelector(".walkme-click-and-hover.walkme-custom-balloon-close-button.walkme-action-close.walkme-inspect-ignore"));
					if(CollectionUtils.isNotEmpty(smallPopupCloseElement)) {
						smallPopupCloseElement.get(0).click();
						waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
						
						// Sorry Popup.
						List<WebElement> sorryPopupCloseElement = driver.findElements(By.cssSelector("span[class='walkme-custom-balloon-button-text']"));
						if(CollectionUtils.isNotEmpty(sorryPopupCloseElement)) {
							sorryPopupCloseElement.get(0).click();
							waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
							
						} else {
							logger.info("Unable to close sorry popup");
						}
					} else {
						logger.info("Unable to close welcome to ati nursing education fp popup");
					}
					
				}
				
				// Close Alert Box if present , close it
				WebElement alertPopupCloseBtn = verifyElement(PropertiesRepository.getString("id.home.alert.message.popup.loc"));
				if(alertPopupCloseBtn != null) {
					alertPopupCloseBtn.click();
				}
				if(loadingImageFlag) {
					flag = true;
				}
			} else {
				logger.info("Both Username and password values are null");
			}
		} catch (Exception e) {
			logger.info("Unable to loginToApplicationVerifyLoadingImg");
			log(logger, "Unable to loginToApplicationVerifyLoadingImg");
			throw new DriverException("Unable to loginToApplicationVerifyLoadingImg", e);
		}
		logger.info("loginToApplicationVerifyLoadingImg End flag --> " + flag );
		return flag;
	}
	

	public void loginToApplication1(String userName, String password) throws NullPointerException, DriverException {
		logger.info("loginToApplication Start ");
		logger.info("userName value --> " + userName);
		logger.info("password value --> " + password);
		try {
			driver.get(PropertiesRepository.getString("id.url"));
			
			// Handle login page popup
			if ((baseHandler.findElements("div[class='wm-close-button walkme-x-button walkme-outline-handled']")) != null) {
				baseHandler.findElement("div[class='wm-close-button walkme-x-button walkme-outline-handled']").click();
			}
			
			WebElement userNameElement = verifyElement(PropertiesRepository.getString("id.login.username.loc"));
			WebElement passwordElement = verifyElement(PropertiesRepository.getString("id.login.password.loc"));
			WebElement goButton = verifyElement(PropertiesRepository.getString("id.login.go.button"));
			if (userNameElement != null && passwordElement != null) {
				textHandler.writeText(userNameElement, userName);
				textHandler.writeText(passwordElement, password);
				buttonHandler.clickButton(goButton);
				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				
				MaintanacePopUp();
				// Close Alert Box if present , close it
				if ((baseHandler.findElements("a[class='ati-modal-close']")) != null) {
					baseHandler.findElement("a[class='ati-modal-close']").click();
				}
				// Click on I Agree of Terms and Condition checkbox if present
				if ((baseHandler.findElements(".mat-checkbox-inner-container")) != null) {
					baseHandler.findElement(".mat-checkbox-inner-container").click();
					baseHandler.findElement(".mat-button.mat-primary").click();
					waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				}
			}
		} catch (Exception e) {
			logger.info("Unable to loginToApplication");
			log(logger, "Unable to loginToApplication");
			throw new DriverException("Unable to loginToApplication", e);
		}
		logger.info("loginToApplication End");
	}
	
	public boolean loginToApplicationInvalidUserVerification(String userName, String password) throws NullPointerException, DriverException {
		logger.info("loginToApplicationInvalidUserVerification Start ");
		boolean flag = false;
		try {
			driver.get(PropertiesRepository.getString("id.url"));
			WebElement userNameElement = verifyElement(PropertiesRepository.getString("id.login.username.loc"));
			WebElement passwordElement = verifyElement(PropertiesRepository.getString("id.login.password.loc"));
			WebElement goButton = verifyElement(PropertiesRepository.getString("id.login.go.button"));
			if (userNameElement != null && passwordElement != null) {
				textHandler.writeText(userNameElement, userName);
				textHandler.writeText(passwordElement, password);
				buttonHandler.clickButton(goButton);
				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				
				MaintanacePopUp();
				// Close Alert Box if present , close it
				if ((baseHandler.findElements("a[class='ati-modal-close']")) != null) {
					baseHandler.findElement("a[class='ati-modal-close']").click();
				}
				// Click on I Agree of Terms and Condition checkbox if present
				if ((baseHandler.findElements(".mat-checkbox-inner-container")) != null) {
					baseHandler.findElement(".mat-checkbox-inner-container").click();
					baseHandler.findElement(".mat-button.mat-primary").click();
					waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				}
				
				windowHandler.switchToLatestWindow();
				WebElement errorMsgElement = verifyElement(
						PropertiesRepository.getString("id.home.inactive.popup.message.loc"));
				WebElement contactMsgElement = verifyElement(
						PropertiesRepository.getString("id.home.inactive.popup.contact.message.loc"));

				if (errorMsgElement != null
						&& errorMsgElement.getText().trim()
								.equalsIgnoreCase(PropertiesRepository.getString("id.home.inactive.popup.message.value"))
						&& contactMsgElement.getText().trim().equalsIgnoreCase(
								PropertiesRepository.getString("id.home.inactive.popup.contact.message.value"))) {
					WebElement closeElement = verifyElement(
							PropertiesRepository.getString("id.home.inactive.popup.close.button.loc"));
					if (closeElement != null) {
						closeElement.click();
						flag = true;
					}
				}
				windowHandler.switchToLatestWindow();
			}
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to loginToApplicationInvalidUserVerification");
			log(logger, "Unable to loginToApplicationInvalidUserVerification");
			throw new DriverException("Unable to loginToApplicationInvalidUserVerification", e);
		}
		logger.info("loginToApplication End flag --> " + flag);
		return flag;
	}

	/**
	 * Method used to verify invalid login.
	 * 
	 * @param userName
	 * @param password
	 * @throws NullPointerException
	 * @throws DriverException
	 */
	public boolean invalidLogin(String userName, String password) throws NullPointerException, DriverException {
		logger.info("invalidLogin Start");
		boolean flag = true;
		try {
			driver.get(PropertiesRepository.getString("id.url"));
			WebElement userNameElement = verifyElement(PropertiesRepository.getString("id.login.username.loc"));
			WebElement passwordElement = verifyElement(PropertiesRepository.getString("id.login.password.loc"));
			WebElement goButton = verifyElement(PropertiesRepository.getString("id.login.go.button"));
			if (userNameElement != null && passwordElement != null) {
				textHandler.writeText(userNameElement, userName);
				textHandler.writeText(passwordElement, password);
				buttonHandler.clickButton(goButton);
				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			}
			WebElement errorMsgElement = verifyElement(
					PropertiesRepository.getString("id.login.invalid.login.error.message.loc"));
			if (errorMsgElement != null
					&& errorMsgElement.getText().trim().equalsIgnoreCase(
							PropertiesRepository.getString("id.login.invalid.login.error.message.value"))
					|| errorMsgElement.getText().trim().equalsIgnoreCase(
							PropertiesRepository.getString("id.login.invalid.login.error.message.value1"))) {
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to invalidLogin");
			log(logger, "Unable to invalidLogin");
			throw new DriverException("Unable to invalidLogin", e);
		}
		logger.info("invalidLogin End flag --> " + flag);
		return flag;
	}

	/**
	 * Method used to verify inactive user login.
	 * 
	 * @param userName
	 * @param password
	 * @throws NullPointerException
	 * @throws DriverException
	 */
	public boolean verifyInActiveUser(String userName, String password) throws NullPointerException, DriverException {
		logger.info("verifyInActiveUser Start");
		boolean flag = true;
		try {
			driver.get(PropertiesRepository.getString("id.url"));
			WebElement userNameElement = verifyElement(PropertiesRepository.getString("id.login.username.loc"));
			WebElement passwordElement = verifyElement(PropertiesRepository.getString("id.login.password.loc"));
			WebElement goButton = verifyElement(PropertiesRepository.getString("id.login.go.button"));
			if (userNameElement != null && passwordElement != null) {
				textHandler.writeText(userNameElement, userName);
				textHandler.writeText(passwordElement, password);
				buttonHandler.clickButton(goButton);
				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			}
			windowHandler.switchToLatestWindow();
			WebElement errorMsgElement = verifyElement(
					PropertiesRepository.getString("id.home.inactive.popup.message.loc"));
			WebElement contactMsgElement = verifyElement(
					PropertiesRepository.getString("id.home.inactive.popup.contact.message.loc"));

			if (errorMsgElement != null
					&& errorMsgElement.getText().trim()
							.equalsIgnoreCase(PropertiesRepository.getString("id.home.inactive.popup.message.value"))
					&& contactMsgElement.getText().trim().equalsIgnoreCase(
							PropertiesRepository.getString("id.home.inactive.popup.contact.message.value"))) {
				WebElement closeElement = verifyElement(
						PropertiesRepository.getString("id.home.inactive.popup.close.button.loc"));
				if (closeElement != null) {
					closeElement.click();
					flag = true;
				}
			}
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			logger.info("Unable to inActiveUser");
			log(logger, "Unable to inActiveUser");
			throw new DriverException("Unable to inActiveUser", e);
		}
		logger.info("verifyInActiveUser End flag --> " + flag);
		return flag;
	}

	/**
	 * Method used to verify Login Header.
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws DriverException
	 */
	public boolean verifyLoginHeader() throws DriverException {
		logger.info("Method: verifyLoginHeader Starts");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("id.login.online.store.and.contact.us.loc"));
			if (CollectionUtils.isNotEmpty(element) && element.size() == 2) {
				if (element.get(0).getText().trim()
						.equalsIgnoreCase(PropertiesRepository.getString("id.login.online.store.link.value"))
						&& element.get(1).getText().trim()
								.equalsIgnoreCase(PropertiesRepository.getString("id.login.contact.us.link.value"))) {
					flag = true;
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verifyLoginHeader");
			log(logger, "Unable to verifyLoginHeader");
			throw new DriverException("Unable to verifyLoginHeader", e);
		}
		logger.info("Method: verifyLoginHeader End flag --> " + flag);
		return flag;
	}

	/**
	 * Method used to verify Login Footer links.
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws DriverException
	 */
	public boolean verifyLoginFooter() throws DriverException {
		logger.info("Method: verifyLoginFooter Starts");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("id.login.footer.loc"));
			if (CollectionUtils.isNotEmpty(element) && element.size() == 5) {
				if (element.get(0).getText().trim()
						.equalsIgnoreCase(PropertiesRepository.getString("id.login.privacy.policy.value"))
						&& element.get(1).getText().trim()
								.equalsIgnoreCase(PropertiesRepository.getString("id.login.web.site.value"))
						&& element.get(2).getText().trim().equalsIgnoreCase(
								PropertiesRepository.getString("id.login.user.terms.and.conditions.value"))
						&& element.get(4).getText().trim().equalsIgnoreCase(
								PropertiesRepository.getString("id.login.ati.product.solutions.value"))) {
					flag = true;
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verifyLoginFooter");
			log(logger, "Unable to verifyLoginFooter");
			throw new DriverException("Unable to verifyLoginFooter", e);
		}
		logger.info("Method: verifyLoginFooter End flag --> " + flag);
		return flag;
	}

	/**
	 * This method is used to wait until the buffer image is completely load.
	 * 
	 * @author Sanapati.Srinu
	 * @param loc
	 * @throws Exception
	 */
	public void waitUntillOverlayImageIsDisappeared(String loc) throws Exception {
		logger.info("Method: waitUntillOverlayImageIsDisappeared Starts");
		try {
			List<WebElement> buffecImage = baseHandler.findElements(PropertiesRepository.getString(loc));
			try {
				while (buffecImage != null) {
					logger.info("page is still loading after click on the element");
					buffecImage = baseHandler.findElements(PropertiesRepository.getString(loc));

				}
			} catch (Exception e) {
				logger.info("page is loaded successfully");
			}

		} catch (Exception e) {
			logger.info("Unable to wait Untill Overlay Image Is not Disappeared");
			log(logger, "Unable to wait Untill Overlay Image Is not Disappeared");
			throw new DriverException("Unable to wait Untill Overlay Image Is not Disappeared", e);
		}
		logger.info("waitUntillOverlayImageIsDisappeared End");
	}

	/**
	 * Method to used to login to application.
	 * 
	 * @param userName
	 * @param password
	 * @return
	 * @throws DriverException
	 */
	public void loginToInstApplication(String userName, String password) throws DriverException {
		logger.info("Method : loginToApplication :::::::: START");
		try {
			driver.get(PropertiesRepository.getString("id.login.url"));

			waitUntillOverlayImageIsDisappeared("id.loading.image.loc");
			driver.navigate().refresh();

			textHandler.writeText(PropertiesRepository.getString("id.login.user.name.loc"), userName);

			// Password
			textHandler.writeText(PropertiesRepository.getString("id.login.password.loc"), password);

			// Click Go Button
			buttonHandler.clickButton(PropertiesRepository.getString("id.goBtnLoc"));

		} catch (Exception e) {
			logger.info("Unable to login To Application");
			log(logger, "Unable to login To Application");
			throw new DriverException("Unable to login To Application", e);
		}

		logger.info("Method : loginToApplication :::::::: End");
	}

	/**
	 * This method is used to wait for some time when identifying the element on
	 * the page
	 * 
	 * @param seconds
	 */
	public void waitForAwhile(int seconds) {
		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to verify error message by passing locator and
	 * message to be validated
	 * Authentication Failed.
	 * @param loc
	 * @param message
	 * @return
	 * @throws DriverException
	 */
	public boolean verifyErrorMessage(String loc, String message) throws DriverException {
		logger.info("Method: verifyErrorMessage Start");
		boolean flag = false;
		try {
			List<WebElement> elements = baseHandler.findElements(PropertiesRepository.getString(loc));
			if (CollectionUtils.isNotEmpty(elements)
					&& ("Invalid Student credentials, Please CLICK HERE to go to Faculty Log-in Page.".equalsIgnoreCase(elements.get(0).getText())
					|| elements.get(0).getText().contains(PropertiesRepository.getString("id.login.invalid.login.error.message.value")))) {
				flag = true;
			}
		} catch (Exception e) {
			throw new DriverException("error in verifying Error Message" + e);
		}
		logger.info("Method: verifyErrorMessage End flag --> " + flag);
		return flag;
	}

	/**
	 * This method is used to select email radio button
	 * 
	 * @author Sanapati.Srinu
	 * @param loc
	 * @param index
	 */
	public void clickButtonFromList(String loc, int index) {
		logger.info("Method: clickButtonFromList Start");
		try {
			List<WebElement> elements = baseHandler.findElements(loc);
			if (CollectionUtils.isNotEmpty(elements)) {
				// new WindowHandler(driver).switchToModalDialog();
				WebElement element = elements.get(index);
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", element);
				// elements.get(index).click();
				waitForAwhile(10000);

			}
		} catch (Exception e) {

			logger.info("Error in clicking button" + e);
		}
		logger.info("Method: clickButtonFromList End");

	}

	/**
	 * This method is used to check element is displayed or not
	 * 
	 * @param loc
	 * @param size
	 * @return
	 * @throws DriverException
	 */
	public boolean isElementDisplayed(String loc, int size) throws DriverException {
		try {
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString(loc));
			if (CollectionUtils.isNotEmpty(element)) {

				return element.get(size).isDisplayed();
			}
		} catch (Exception e) {
			throw new DriverException("error in verify element" + e);

		}

		return false;

	}

	/**
	 * This method is used to verify yHome Page Menu List
	 * 
	 * @param loc
	 * @throws DriverException
	 */
	public boolean verifyHomePageMenuList(String loc) throws DriverException {
		List<Boolean> list = new ArrayList<Boolean>();
		System.out.println();
		try {
			List<WebElement> elements = baseHandler.findElements(PropertiesRepository.getString(loc));
			String[] stringAsArray = PropertiesRepository.getStringAsArray("id.homepage.main.menu.list.info");
			for (int i = 0; i < elements.size(); i++) {
				if (elements.get(i).getText().contains(stringAsArray[i].trim())) {
					list.add(true);
				} else {
					list.add(false);
				}
			}

		} catch (Exception e) {
			throw new DriverException("error in verify Home Page MenuList" + e);
		}
		return list.contains(false) ? false : true;

	}

	/**
	 * This method is used to get the list from UI.
	 * 
	 * @param loc
	 * @return
	 * @throws DriverException
	 */
	public boolean getList(String loc) throws DriverException {
		List<Boolean> list = new ArrayList<Boolean>();
		String[] stringAsArray = PropertiesRepository.getStringAsArray("id.homepage.more.info");
		try {
			// waitForAwhile(6000);
			List<WebElement> elements = baseHandler.findElements(PropertiesRepository.getString(loc));
			for (int i = 0; i < elements.size(); i++) {
				if (elements.get(i).getText().trim().contains(stringAsArray[i])) {
					list.add(true);
				} else {
					list.add(false);
				}
			}
		} catch (Exception e) {
			throw new DriverException("error in verify Home Page MenuList" + e);
		}
		return list.contains(false) ? false : true;

	}

	/**
	 * This method is used to verify Contacts PopUp Info
	 * 
	 * @return
	 * @throws DriverException
	 */
	public boolean verifyContactsPopUpInfo() throws DriverException {
		logger.info("verifyContactsPopUpInfo Start ");
		try {
			windowHanlder.switchToModalDialog();
			String[] stringAsArray = PropertiesRepository
					.getStringAsArray("id.homepage.home.page.static.menu.contacts.headers.info");
			String[] stringAsArray1 = PropertiesRepository
					.getStringAsArray("id.homepage.home.page.static.menu.contacts.headers.info1");
			List<WebElement> elements = baseHandler
					.findElements(PropertiesRepository.getString("id.homepage.home.page.ati.contacts.header.name.loc"));

			List<WebElement> elements1 = baseHandler.findElements(
					PropertiesRepository.getString("id.homepage.home.page.static.menu.contacts.headers.loc1"));
			List<WebElement> elements2 = baseHandler.findElements(
					PropertiesRepository.getString("id.homepage.home.page.static.menu.contacts.headers.loc2"));
			if (CollectionUtils.isNotEmpty(elements) && stringAsArray[0].equals(elements.get(0).getText().trim())
					&& stringAsArray[2].equals(elements.get(1).getText().trim())
					&& stringAsArray1[0].equals(elements1.get(0).getText().trim())
					&& stringAsArray1[2].equals(elements1.get(1).getText().trim())) {
				return true;
			}
		} catch (Exception e) {
			throw new DriverException("error in verify Contacts PopUp Info" + e);
		}
		logger.info("verifyContactsPopUpInfo End");
		return false;
	}

	/**
	 * This method is used to verify Alert Message Text
	 * 
	 * @param loc
	 * @return
	 * @throws DriverException
	 */
	public boolean verifyAlertMessageText(String loc) throws DriverException {
		try {

			List<WebElement> alertText = baseHandler.findElements(".alert-heading-blue");
			if (alertText != null) {
				if (alertText.get(0).getText().equalsIgnoreCase("Alert")) {
					return true;
				}
			}

		} catch (Exception e) {
			throw new DriverException("unable to swith to frame" + e);
		} finally {
		}

		return false;
	}

	/**
	 * This method is used to click element
	 * 
	 * @param loc
	 * @param size
	 * @throws DriverException
	 */
	public void clickElement(String loc, int size) throws DriverException {

		try {
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString(loc));
			if (CollectionUtils.isNotEmpty(element)) {

				element.get(size).click();
				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			}
		} catch (Exception e) {
			throw new DriverException("error in verify element");

		}
	}

	
	public boolean verifyLoginPageHeaders() throws DriverException {
		logger.info("Method: verifyLoginPageHeaders Starts");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("id.login.online.store.and.contact.us.loc"));
			if (CollectionUtils.isNotEmpty(element) && element.size() == 2) {
				element.get(0).click();
				String onlineStoreUrl = driver.getCurrentUrl();
				driver.navigate().back();
				waitForAwhile(5000);
				List<WebElement> element1 = baseHandler
						.findElements(PropertiesRepository.getString("id.login.online.store.and.contact.us.loc"));
				element1.get(1).click();
				String contactUsUrl = driver.getCurrentUrl();
				driver.navigate().back();
				if (PropertiesRepository.getString("id.login.online.store.url").equals(onlineStoreUrl)
						&& PropertiesRepository.getString("id.login.contactus.new.url").equals(contactUsUrl)) {
					flag = true;
				}

			}
		} catch (Exception e) {
			logger.info("Unable to verifyLoginPageHeaders");
			log(logger, "Unable to verifyLoginPageHeaders");
			throw new DriverException("Unable to verifyLoginPageHeaders", e);
		}
		logger.info("Method: verifyLoginPageHeaders End flag --> " + flag);
		return flag;
	}

	
	/**
	 * Method to used to login to application.
	 * 
	 * @param userName
	 * @param password
	 * @return
	 * @throws DriverException
	 */
	public void loginToStudentApplication(String userName, String password) throws DriverException {
		logger.info("Method : loginToApplication :::::::: START");
		try {
			driver.get(PropertiesRepository.getString("newati.login.url"));
			// User Name
			textHandler.writeText(PropertiesRepository.getString("new-atitesting.homepage.userName.new.Loc"), userName);

			// Password
			textHandler.writeText(PropertiesRepository.getString("new-atitesting.homepage.passwordLoc"), password);

			// Click Go Button
			buttonHandler.clickButton(PropertiesRepository.getString("new-atitesting.goBtnLoc"));

			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			
		} catch (Exception e) {
			logger.info("Unable to login To Application");
			log(logger, "Unable to login To Application");
			throw new DriverException("Unable to login To Application", e);
		}

		logger.info("Method : loginToApplication :::::::: End");
	}

	/**
	 * @author Syed.Hoque This method will verify that any link is present or
	 *         not
	 * @throws DriverException
	 */

	public boolean verifyLink(String locator) throws DriverException {
		logger.info("Method: verifyAndClick Starts");
		boolean flag = false;
		try {
			WebElement element = verifyElement(locator);
			if (!(element == null)) {
				flag = true;
			}

		} catch (Exception e) {
			logger.info("Unable to verifyLink");
			log(logger, "Unable to verifyLink");
			throw new DriverException("Unable to verifyLink", e);
		}
		logger.info("Method: verifyLink ENDS");
		logger.info("Method: verifyLink End flag --> " + flag);
		return false;
	}

	/**
	 * @author Syed.Hoque This method will click on browser back button
	 * @throws DriverException
	 */

	public void navigateBack() throws DriverException {
		logger.info("Method: navigateBack Starts");
		try {
			driver.navigate().back();
			waitForAwhile(1000);

		} catch (Exception e) {
			logger.info("Unable to navigateBack");
			log(logger, "Unable to navigateBack");
			throw new DriverException("Unable to navigateBack", e);
		}
		logger.info("Method: navigateBack Ends");
	}

	public boolean verifyHideGraduatedButton() {

		try {
			List<WebElement> element = baseHandler.findElements(".flex-container md-slide-toggle ");
			if (CollectionUtils.isNotEmpty(element)) {
				element.get(0).click();
				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				String findElement = element.get(0).getAttribute("class");
				if (findElement != null && findElement.contains("ng-touched") || !findElement.contains("ng-touched")) {
					return true;
				}
			}

		} catch (Exception e) {
		}
		return false;
	}

	/**
	 * This method will verify that hide gradute is disabled
	 * 
	 * @author Syed.Hoque
	 * @throws DriverException
	 * 
	 */
	public boolean verifyHideGraduteButtonEnabled() throws DriverException {
		logger.info("Method : verifyHideGraduteButtonEnabled :::::::: START");
		boolean flag = false;
		try {
			if (baseHandler.findElement(".flex-container md-slide-toggle ").isEnabled()) {
				flag = true;
				logger.info("Yes the toggle is ON");
			} else {
				logger.info("No the toggle is OFF");
			}
		} catch (Exception e) {
			logger.info("Unable to validate verifyHideGraduteButtonEnabled");
			log(logger, "Unable to validate verifyHideGraduteButtonEnabled");
			throw new DriverException("Unable to validate verifyHideGraduteButtonEnabled", e);
		}
		logger.info("Method: verifyHideGraduteButtonEnabled:::::: ENDS");
		logger.info("Method: verifyLink End flag --> " + flag);
		return flag;
	}

	/**
	 * @author Syed.Hoque This method will enter value in proctor setbenchmark
	 *         text field & then it will save it and after that it will verify
	 *         Whether that value is updated or not
	 * @throws DriverException
	 */
	public void setValuseInProctorBenchMarkText() throws DriverException {
		logger.info("Method : setValuseInProctorBenchMarkText :::::::: START ");
		try {
			Random random = new Random();
			int value = random.nextInt(20);

			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("setbenchmark.text.value"));
			if (CollectionUtils.isNotEmpty(element)) {
				element.get(0).clear();
				element.get(0).sendKeys(String.valueOf(value));
			}
			// click on save button
			baseHandler.findElement(PropertiesRepository.getString("setbenchmark.save.btn.popup")).click();
			Thread.sleep(18000);
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			// verify that the value is updated

		} catch (Exception e) {
			logger.info("Unable to validate setValuseInProctorBenchMarkText");
			log(logger, "Unable to validate setValuseInProctorBenchMarkText");
			throw new DriverException("Unable to validate setValuseInProctorBenchMarkText", e);
		}
		logger.info("Method : setValuseInProctorBenchMarkText :::::::: End");
	}

	/**
	 * @author Syed.Hoque
	 * @param loc
	 * @param size
	 * @return
	 * @throws DriverException
	 *             This method will verify home link is present or not
	 */
	public boolean verifyHomeLink() throws DriverException {
		logger.info("Method : verifyHomeLink :::::::: START");
		boolean flag = false;
		try {
			List<WebElement> homelink = baseHandler.findElements(PropertiesRepository.getString("ng.home.link"));
			if (CollectionUtils.isNotEmpty(homelink)) {
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to validate verifyHomeLink");
			log(logger, "Unable to validate verifyHomeLink");
			throw new DriverException("Unable to validate verifyHomeLink", e);
		}
		logger.info("Method: verifyHomeLink End flag --> " + flag);
		return flag;

	}

	/**
	 * @author Syed.Hoque
	 * @param loc
	 * @param size
	 * @return
	 * @throws DriverException
	 *             This method will verify contactus link and then we will click
	 *             on it then we will navigate to back
	 */

	public boolean verifyContactUsLink(String contactusText) throws DriverException {
		logger.info("Method : verifyContactUsLink :::::::: START");
		boolean flag = false;
		try {
			List<WebElement> links = baseHandler.findElements(PropertiesRepository.getString("ng.links"));
			if (CollectionUtils.isNotEmpty(links)) {
				if (links.get(3).getText().trim().equalsIgnoreCase(contactusText))
					flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to validate verifyContactUsLink");
			log(logger, "Unable to validate verifyContactUsLink");
			throw new DriverException("Unable to validate verifyContactUsLink", e);
		}
		logger.info("Method: verifyContactUsLink End flag --> " + flag);
		return flag;

	}

	/**
	 * @author Syed.Hoque
	 * @param loc
	 * @param size
	 * @return Verify that online store link is present or not
	 * @throws DriverException
	 */

	public boolean verifyOnlineStoreLink(String onlineStoreText) throws DriverException {
		logger.info("Method : verifyOnlineStoreLink :::::::: START");
		boolean flag = false;
		try {
			List<WebElement> links = baseHandler.findElements(PropertiesRepository.getString("ng.links"));
			if (CollectionUtils.isNotEmpty(links)) {
				if (links.get(2).getText().trim().equalsIgnoreCase(onlineStoreText))
					flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to validate verifyOnlineStoreLink");
			log(logger, "Unable to validate verifyOnlineStoreLink");
			throw new DriverException("Unable to validate verifyOnlineStoreLink", e);
		}
		logger.info("Method: verifyOnlineStoreLink End flag --> " + flag);
		return flag;

	}

	/**
	 * @author Syed.Hoque
	 * @param loc
	 * @param size
	 * @return Verify that edit account information link is present or not
	 * @throws DriverException
	 */

	public boolean verifyEditAccountInfoLink(String editaccountInfoLink) throws DriverException {
		logger.info("Method : verifyEditAccountInfoLink :::::::: START");
		boolean flag = false;
		try {
			List<WebElement> links = baseHandler.findElements(PropertiesRepository.getString("ng.links"));
			if (CollectionUtils.isNotEmpty(links)) {
				if (links.get(1).getText().trim().equalsIgnoreCase(editaccountInfoLink))
					flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to validate verifyEditAccountInfoLink");
			log(logger, "Unable to validate verifyEditAccountInfoLink");
			throw new DriverException("Unable to validate verifyEditAccountInfoLink", e);
		}
		logger.info("Method: verifyEditAccountInfoLink End flag --> " + flag);
		return flag;

	}

	/**
	 * @author Syed.Hoque
	 * @param loc
	 * @param size
	 * @return This method will verify home link is present or not
	 * @throws DriverException
	 */

	public boolean verifyHomeLink(String homelink) throws DriverException {
		logger.info("Method : verifyHomeLink :::::::: START");
		boolean flag = false;
		try {
			List<WebElement> links = baseHandler.findElements(PropertiesRepository.getString("ng.links"));
			if (CollectionUtils.isNotEmpty(links)) {
				if (links.get(0).getText().trim().equalsIgnoreCase(homelink))
					flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to validate verifyHomeLink");
			log(logger, "Unable to validate verifyHomeLink");
			throw new DriverException("Unable to validate verifyHomeLink", e);
		}
		logger.info("Method: verifyHomeLink End flag --> " + flag);
		return flag;

	}

	/**
	 * @author Syed.Hoque
	 * @param loc
	 * @param size
	 * @return This method will click on contact us link
	 * @throws DriverException
	 */
	public void clickOnContactUsLink() throws DriverException {
		logger.info("Method : clickOnContactUsLink :::::::: START");
		try {
			List<WebElement> links = baseHandler.findElements(PropertiesRepository.getString("ng.links"));
			if (CollectionUtils.isNotEmpty(links)) {
				links.get(3).click();
				waitForAwhile(5000);
				driver.navigate().back();
				waitForAwhile(1000);
			}

		} catch (Exception e) {
			logger.info("Unable to validate clickOnContactUsLink");
			log(logger, "Unable to validate clickOnContactUsLink");
			throw new DriverException("Unable to validate clickOnContactUsLink", e);
		}
		logger.info("Method : clickOnContactUsLink :::::::: ENDS");
	}

	/**
	 * @author Syed.Hoque
	 * @param loc
	 * @param size
	 * @return This method will click on online store link
	 * @throws DriverException
	 */

	public void clickOnOnlineStoreLink() throws DriverException {
		logger.info("Method : clickOnOnlineStoreLink :::::::: START");
		try {
			List<WebElement> links = baseHandler.findElements(PropertiesRepository.getString("ng.links"));
			if (CollectionUtils.isNotEmpty(links)) {
				links.get(2).click();
				waitForAwhile(1000);
			}
		} catch (Exception e) {
			logger.info("Unable to validate clickOnOnlineStoreLink");
			log(logger, "Unable to validate clickOnOnlineStoreLink");
			throw new DriverException("Unable to validate clickOnOnlineStoreLink", e);
		}
		logger.info("Method : clickOnOnlineStoreLink :::::::: ENDS");
	}

	/**
	 * @author Syed.Hoque
	 * @param loc
	 * @param size
	 * @return This method will click on edit profile link and then it will
	 *         click on online store link
	 * @throws DriverException
	 */

	public void clickOnEditProfileLink() throws DriverException {
		logger.info("Method : clickOnEditProfileLink :::::::: START");
		try {
			List<WebElement> links = baseHandler.findElements(PropertiesRepository.getString("ng.links"));
			if (CollectionUtils.isNotEmpty(links)) {
				links.get(1).click();
				waitForAwhile(2000);
				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

			}

		} catch (Exception e) {
			logger.info("Unable to validate clickOnEditProfileLink");
			log(logger, "Unable to validate clickOnEditProfileLink");
			throw new DriverException("Unable to validate clickOnEditProfileLink", e);
		}
		logger.info("Method : clickOnEditProfileLink :::::::: ENDS");
	}

	public void scrollDown() throws DriverException {
		logger.info("Method : scrollDown :::::::: START");
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,250)", "");
		} catch (Exception e) {
			logger.info("Unable to validate scrollDown");
			log(logger, "Unable to validate scrollDown");
			throw new DriverException("Unable to validate scrollDown", e);
		}
		logger.info("Method : scrollDown :::::::: ENDS");
	}

	/**
	 * This method will click links from login page
	 * 
	 * @author Syed.Hoque
	 * @throws DriverException
	 */

	public boolean VerifyAndclickLoginPageLink(String text, int index) throws DriverException {
		logger.info("Method : VerifyAndclickLoginPageLink :::::::: Start");
		logger.info("text value --> " + text);
		logger.info("index value --> " + index);
		boolean flag = false;
		try {
			List<WebElement> loginpageLinks = baseHandler
					.findElements(PropertiesRepository.getString("login.page.link"));
			if (CollectionUtils.isNotEmpty(loginpageLinks)) {
				if (loginpageLinks.get(index).getText().trim().equalsIgnoreCase(text)) {
					flag = true;
					loginpageLinks.get(index).click();
				}
			}
		} catch (Exception e) {
			logger.info("Unable to validate VerifyAndclickLoginPageLink");
			log(logger, "Unable to validate VerifyAndclickLoginPageLink");
			throw new DriverException("Unable to validate VerifyAndclickLoginPageLink", e);
		}
		logger.info("Method: VerifyAndclickLoginPageLink End flag --> " + flag);
		return flag;
	}

	public boolean verifyUrl(String urlText) throws DriverException {
		logger.info("Method : verifyUrl :::::::: Start");
		logger.info("urlText value --> " + urlText);
		boolean flag = false;
		try {
			String url = driver.getCurrentUrl();
			if (url != null) {
				if (url.trim().equalsIgnoreCase(urlText)) {
					return true;
				}
			}

		} catch (Exception e) {
			logger.info("Unable to validate verifyUrl");
			log(logger, "Unable to validate verifyUrl");
			throw new DriverException("Unable to validate verifyUrl", e);
		}
		logger.info("Method: verifyHomeLink End flag --> " + flag);
		return flag;
	}

	/**
	 * This method will navigate back
	 * 
	 * @author Syed.Hoque
	 * @throws DriverException
	 */

	public void clikNavigateBackToLoginpage() throws DriverException {
		logger.info("clikNavigateBack START");
		try {
			driver.navigate().back();
			List<WebElement> logo = baseHandler.findElements(PropertiesRepository.getString("login.page.logo"));
			if (CollectionUtils.isNotEmpty(logo)) {
				waitForAwhile(1000);
			}
		} catch (Exception e) {
			logger.info("Unable to clikNavigateBack");
			log(logger, "Unable to clikNavigateBack");
			throw new DriverException("Unable to clikNavigateBack", e);
		}
		logger.info("clikNavigateBack End");
	}

	/**
	 * @author Syed.Hoque
	 * @param loc
	 * @param size
	 * @return This method will click on home link
	 * @throws DriverException
	 */

	public void clickOnHomeLink() throws DriverException {
		logger.info("Method : clickOnHomeLink :::::::: START");
		try {
			List<WebElement> links = baseHandler.findElements(PropertiesRepository.getString("ng.links"));
			if (CollectionUtils.isNotEmpty(links)) {
				links.get(0).click();
				waitForAwhile(2000);
				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			}
		} catch (Exception e) {
			logger.info("Unable to validate clickOnHomeLink");
			log(logger, "Unable to validate clickOnHomeLink");
			throw new DriverException("Unable to validate clickOnHomeLink", e);
		}
		logger.info("Method : clickOnHomeLink :::::::: ENDS");
	}

	public boolean verifyClassName(String loc, int size) throws DriverException {

		try {
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString(loc));
			if (CollectionUtils.isNotEmpty(element)) {

				return element.get(size).getText().contains("Select Cohort");

			}
		} catch (Exception e) {
			throw new DriverException("error in verify element" + e);

		}

		return false;
	}
	
	/**
	 * Verify Element is Displayed
	 * @author syed.pasha
	 * @throws Exception
	 */
	public boolean verifyIfElementDisplayed(String Loactor , int index) throws Exception {
		logger.info("Method:  verifyIfElementDisplayed End");
		boolean flag = false;		
		try {
			List<WebElement> messages = baseHandler.findElements(Loactor);
			if(messages.get(index).isDisplayed())
			{
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to Verify Element");
			throw new DriverException("Unable to Verify Element", e);
		}
		logger.info("Method: verifyIfElementDisplayed End");
		return flag;
	}
	
	public String generateLoginPassword() throws Exception {
		logger.info("Method : generateLoginPassword Start");
		String password = null;
		try {
			String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\\\|;:\\'\\\",<.>/?";
			password = RandomStringUtils.random( 8, characters );
			logger.info("New Password --> " + password);
		}catch (Exception e) {
    		logger.info("Unable to generateLoginPassword" );
			log(logger, "Unable to generateLoginPassword" );
    		throw new DriverException("Unable to generateLoginPassword" , e); 
    	}
		logger.info("Method: generateLoginPassword End password --> " + password);
		return password;
	}
}
