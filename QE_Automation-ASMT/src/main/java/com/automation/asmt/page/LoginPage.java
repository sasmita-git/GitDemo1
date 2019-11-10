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
import com.ascendlearning.automation.ui.handlers.ButtonHandler;
import com.ascendlearning.automation.ui.handlers.TextHandler;


public class LoginPage extends ASMTBasePage {

	private Logger logger = LogManager.getLogger(this.getClass());
	private TextHandler textHandler;
	private ButtonHandler buttonHandler;
	private BaseHandler baseHandler;
	
	public LoginPage(WebDriver webDriver) {
		super(webDriver);
		textHandler = new TextHandler(driver);
		buttonHandler = new ButtonHandler(driver);
		baseHandler = new BaseHandler(driver);
	}
	
	/*
	 * @author syed.pasha
	 */
	public void MaintanacePopUp() throws InterruptedException {
		logger.info("Method : Verifying Maintance pop-up :::: START ");
		Thread.sleep(2000);
		List<WebElement> buttonList = driver.findElements(By.cssSelector(".wm-close-button.walkme-x-button.walkme-outline-handled"));
		if (CollectionUtils.isNotEmpty(buttonList)) {
			driver.findElement(By.cssSelector(".wm-close-button.walkme-x-button.walkme-outline-handled")).click();
			Thread.sleep(1000);
		}		
		// Close Alert Box if present , close it
		if ((baseHandler.findElements("a[class='ati-modal-close']")) != null) {
			baseHandler.findElement("a[class='ati-modal-close']").click();
		}
		logger.info("Method : Verifying Maintance pop-up :::: END");
		try {
			logger.info("Method : Verifying Welcome pop-up :::: START ");
			if (verifyElement(PropertiesRepository.getString("asmt.getStartedBtnLoc"), 0)){
				logger.info("Getstarted button is displayed on Welcome ATI pop-up");
				buttonHandler.clickButton(PropertiesRepository.getString("asmt.getStartedBtnLoc"));
			}
			
		// Close Alert Box if present In Prod, close it
		Thread.sleep(2000);
		if ((baseHandler.findElements(".walkme-custom-balloon-content-wrapper")) != null) {
			clickButton(".walkme-custom-balloon-content-wrapper div", 0);
		}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info("Method : Verifying Welcome pop-up :::: END");
			e.printStackTrace();
		}
	
		}
	/*
	 * @author Saravanan Jyothimani
	 */
	public void MaintanacePopUpAndWelComeToHomePagePopUp() throws InterruptedException,Exception {
		logger.info("Method : Verifying Maintance pop-up :::: START ");
		Thread.sleep(2000);
		List<WebElement> buttonList = driver.findElements(By.cssSelector(".walkme-action-playBf-0.wm-blue-btn.wm-template-main-bg.wm-main-border-bottom-darker.wm-action-text-color.wm-main-bg-hover")); 
		if (CollectionUtils.isNotEmpty(buttonList)) {
			buttonList.get(0).click();
			waitUntillLoadingImageIsDisappeared("id.common.page.loader");
			
			// Clicking on Welcome to ATI Nursing Education Faculty Portal Small Popup. 
			List<WebElement> smallPopupCloseElement = driver.findElements(By.cssSelector(".walkme-click-and-hover.walkme-custom-balloon-close-button.walkme-action-close.walkme-inspect-ignore"));
			if(CollectionUtils.isNotEmpty(smallPopupCloseElement)) {
				smallPopupCloseElement.get(0).click();
				waitUntillLoadingImageIsDisappeared("id.common.page.loader");
				
				// Sorry Popup.
				List<WebElement> sorryPopupCloseElement = driver.findElements(By.cssSelector("span[class='walkme-custom-balloon-button-text']"));
				if(CollectionUtils.isNotEmpty(sorryPopupCloseElement)) {
					sorryPopupCloseElement.get(0).click();
					waitUntillLoadingImageIsDisappeared("id.common.page.loader");
					
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
	 * Method to used to login to application.
	 * 
	 * @param userName
	 * @param password
	 * @throws Exception 
	 */
	public boolean loginToApplication(String userName, String password)
			throws Exception {
		logger.info("Method : loginToApplication :::::::: START userName --> " + userName);
		logger.info("Method : loginToApplication :::::::: START password --> " + password);
		boolean flag = false;
		try {			
			//loading the url
			driver.get(PropertiesRepository.getString("new-atitesting.project.url"));
			waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
			if(verifyElement(PropertiesRepository.getString("asmt.homepage.userNameLoc")) && verifyElement(PropertiesRepository.getString("asmt.homepage.passwordLoc"))) 
			{
			// User Name
			logger.info("Entering User Name--> " + userName);
			 textHandler.writeText(PropertiesRepository	.getString("asmt.homepage.userNameLoc"),userName);
			// Password
			 logger.info("Entering User Name--> " + password);
			textHandler.writeText(PropertiesRepository.getString("asmt.homepage.passwordLoc"),password);
			// Click Go Button
			logger.info("Clicking on Go button");
			buttonHandler.clickButton(PropertiesRepository.getString("asmt.goBtnLoc"));
			flag = true;
			waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
			//waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
			MaintanacePopUpAndWelComeToHomePagePopUp();
			}
			else{
				logger.info("Unable to login To Application");
			}			
		} catch (DriverException e) {
			logger.info("Unable to login To Application");
			log(logger, "Unable to login To Application");
			throw new DriverException("Unable to login To Application", e);
		}
		logger.info("Method : loginToApplication :::::::: End flag--> " + flag);
		return flag;
	}
	
	public void enterURL(String url) throws Exception {
		logger.info("Method : enterURL :::::::: START");
		logger.info(PropertiesRepository.getString(url));
		driver.get(PropertiesRepository.getString(url));
		waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		logger.info("Method : enterURL :::::::: END");
	}
}
