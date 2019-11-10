package com.automation.newati.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.ButtonHandler;
import com.ascendlearning.automation.ui.handlers.TextHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;

public class FacultyPortalPage extends NewATIBasePage {
	private Logger logger = LogManager.getLogger(this.getClass());

	private TextHandler textHandler;
	private ButtonHandler btnHandler;
	public BaseHandler baseHandler;
	long milliseconds = 0;
	private String result = null;
	private WindowHandler windowHanlder;
	private ButtonHandler buttonHandler;
	private TutorialPage tutorialPage;

	public FacultyPortalPage(WebDriver webDriver) {
		super(webDriver);
		textHandler = new TextHandler(driver);
		btnHandler = new ButtonHandler(driver);
		baseHandler = new BaseHandler(driver);
		windowHanlder = new WindowHandler(driver);
		buttonHandler = new ButtonHandler(driver);
		tutorialPage = new TutorialPage(driver);
	}

	/**
	 * Login to Faculty Portal.
	 * 
	 * @param userName
	 * @param password
	 * @throws NullPointerException
	 * @throws DriverException
	 */
	public void loginToFacultyApplication(String userName, String password)
			throws NullPointerException, DriverException {
		logger.info("loginToFacultyApplication Start ");
		logger.info("userName value --> " + userName);
		logger.info("password value --> " + password);
		try {
			driver.get(PropertiesRepository.getString("id.url"));
			WebElement userNameElement = verifyUIElement(PropertiesRepository.getString("id.login.username.loc"));
			WebElement passwordElement = verifyUIElement(PropertiesRepository.getString("id.login.password.loc"));
			WebElement goButton = verifyUIElement(PropertiesRepository.getString("id.login.go.button"));
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
			logger.info("Unable to loginToFacultyApplication");
			log(logger, "Unable to loginToFacultyApplication");
			throw new DriverException("Unable to loginToFacultyApplication", e);
		}
		logger.info("loginToFacultyApplication End");
	}

	/**
	 * Method used to verify Element is present in DOM.
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @return
	 * @throws DriverException
	 */
	public WebElement verifyUIElement(String locator) throws DriverException {
		logger.info("verifyElement Start");
		WebElement webElement = null;
		try {
			List<WebElement> element = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(element)) {
				webElement = element.get(0);
			} else {
				logger.info("Unable to find element in verifyElement --> " + locator);
			}
		} catch (Exception e) {
			logger.info("Unable to verifyElement");
			log(logger, "Unable to verifyElement");
			throw new DriverException("Unable to verifyElement", e);
		}
		logger.info("verifyElement End");
		return webElement;
	}

	/*
	 * @author syed.pasha
	 */
	public void MaintanacePopUp() throws InterruptedException, Exception {
		logger.info("Method : Verifying Maintance pop-up :::: START ");
		List<WebElement> buttonList = driver.findElements(By.cssSelector(
				".walkme-action-playBf-0.wm-blue-btn.wm-template-main-bg.wm-main-border-bottom-darker.wm-action-text-color.wm-main-bg-hover"));
		if (CollectionUtils.isNotEmpty(buttonList)) {
			buttonList.get(0).click();
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

			// Clicking on Welcome to ATI Nursing Education Faculty Portal Small Popup.
			List<WebElement> smallPopupCloseElement = driver.findElements(By.cssSelector(
					".walkme-click-and-hover.walkme-custom-balloon-close-button.walkme-action-close.walkme-inspect-ignore"));
			if (CollectionUtils.isNotEmpty(smallPopupCloseElement)) {
				smallPopupCloseElement.get(0).click();
				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

				// Sorry Popup.
				List<WebElement> sorryPopupCloseElement = driver
						.findElements(By.cssSelector("span[class='walkme-custom-balloon-button-text']"));
				if (CollectionUtils.isNotEmpty(sorryPopupCloseElement)) {
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
	 * Method used to verify left navigation name and click if required.O
	 * 
	 * @author saravanan.jothimani
	 * @param leftNavName
	 * @param click
	 * @return
	 * @throws DriverException
	 */
	public boolean verifyLeftNavigationText(String locator, String leftNavName, boolean click) throws DriverException {
		logger.info("Method: verifyLeftNavigationText Starts");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString(locator));
			if (CollectionUtils.isNotEmpty(element)) {
				int size = element.size();
				for (int index = 0; index < size; index++) {
					WebElement navElement = element.get(index);
					if (navElement != null && navElement.getText().trim().contains(leftNavName)) {
						flag = true;
						if (click) {
							navElement.click();
							waitUntillLoadingImageIsDisappeared(
									PropertiesRepository.getString("id.common.page.loader"));
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verifyLeftNavigationText");
			log(logger, "Unable to verifyLeftNavigationText");
			throw new DriverException("Unable to verifyLeftNavigationText", e);
		}
		logger.info("Method: verifyLeftNavigationText End flag --> " + flag);
		return flag;
	}

	/**
	 * Method used to click on Tutorial Manage button for Personnel User.
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws Exception
	 */
	public boolean clickTutorialManageButtonForPersonnelUser() throws Exception {
		logger.info("Method : clickTutorialManageButtonForPersonnelUser Start");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(
					"product-highlights-course-work mat-card-subtitle[class='student-size-header mat-card-subtitle']");
			if (CollectionUtils.isNotEmpty(element) && element.get(0).getText().trim()
					.equalsIgnoreCase(PropertiesRepository.getString("id.product.page.tutorial.header.value"))) {
				List<WebElement> manageBtnElement = baseHandler
						.findElements(PropertiesRepository.getString("id.product.page.tutorial.manage.button.loc"));
				if (CollectionUtils.isNotEmpty(manageBtnElement)) {
					manageBtnElement.get(0).click();
					flag = true;
				}
			}
		} catch (Exception e) {
			logger.info("Unable to clickTutorialManageButtonForPersonnelUser");
			log(logger, "Unable to clickTutorialManageButtonForPersonnelUser");
			throw new DriverException("Unable to clickTutorialManageButtonForPersonnelUser", e);
		}
		logger.info("Method: clickTutorialManageButtonForPersonnelUser End flag --> " + flag);
		return flag;
	}

	/**
	 * This method is used to verify Access Module table headers
	 * input[id*='imgbtnEnableDisableTutorial']
	 * 
	 * @param quizName
	 * @param headersList
	 * @return boolean
	 * @throws DriverException
	 */
	public int clickAndExpandAccessModulesSection(String quizName) throws DriverException {
		int selectedIndex = 0;
		logger.info("Method: clickAndExpandAccessModulesSection Starts");
		// quizName = "The NCLEX® Experience RN";
		try {
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			switchToCardShadowFrame();
			List<WebElement> moduleNameList = driver.findElements(By.xpath(
					"//table[3]/tbody/tr[2]/td/div[2]/div/table/tbody/tr[not(contains(@class, 'products_tablecontent'))]/td[1]"));
			List<WebElement> imgList = baseHandler
					.findElements(PropertiesRepository.getString("id.portal.product.tab.access.module.img"));
			for (int i = 0; i < moduleNameList.size(); i++) {
				if (quizName.trim().equals(moduleNameList.get(i).getText())) {
					/*
					 * ((JavascriptExecutor)
					 * driver).executeScript("arguments[0].scrollIntoView(true);", imgList.get(i));
					 */
					imgList.get(i).click();
					waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
					// waitForAwhile(20000);
					selectedIndex = i;
					break;
				}
			}
			windowHanlder.switchToLatestWindow();
		} catch (Exception e) {
			windowHanlder.switchToLatestWindow();
			logger.info("Unable to Expand Access Modules Section");
			log(logger, "Unable to Expand Access Modules Section");
			throw new DriverException("Unable to Expand Access Modules Section", e);
		}
		logger.info("Method: clickAndExpandAccessModulesSection End ");
		return selectedIndex;
	}

	/**
	 * This method is used to verify Access Module table headers
	 * input[id*='imgbtnEnableDisableTutorial']
	 * 
	 * @param quizName
	 * @param headersList
	 * @return boolean
	 * @throws DriverException
	 */
	public int clickEnableDisableImage(String quizName) throws DriverException {
		int selectedIndex = 0;
		logger.info("Method: clickEnableDisableImage Starts");
		try {
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			switchToCardShadowFrame();
			List<WebElement> moduleNameList = driver.findElements(By.xpath(
					"//table[3]/tbody/tr[2]/td/div[2]/div/table/tbody/tr[not(contains(@class, 'products_tablecontent'))]/td[1]"));
			List<WebElement> imgList = baseHandler.findElements(
					PropertiesRepository.getString("id.portal.product.tutorial.enable.disable.image.loc"));
			for (int i = 0; i < moduleNameList.size(); i++) {
				if (quizName.trim().equals(moduleNameList.get(i).getText())) {
					/*
					 * ((JavascriptExecutor)
					 * driver).executeScript("arguments[0].scrollIntoView(true);", imgList.get(i));
					 */
					imgList.get(i).click();
					waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

					selectedIndex = i;
					break;
				}
			}
			windowHanlder.switchToLatestWindow();
		} catch (Exception e) {
			windowHanlder.switchToLatestWindow();
			logger.info("Unable to clickEnableDisableImage");
			log(logger, "Unable to clickEnableDisableImage");
			throw new DriverException("Unable to clickEnableDisableImage", e);
		}
		logger.info("Method: clickEnableDisableImage End ");
		return selectedIndex;
	}

	/**
	 * This method is used to click On Image By Action Class
	 * 
	 * @param lndex
	 * @param waitFor
	 * @throws DriverException
	 */
	public boolean clickOnPreviewModuleImg(int lndex, int waitFor) throws DriverException {
		logger.info("Method: clickOnPreviewModuleImg Start");
		boolean flag = false;
		try {
			switchToCardShadowFrame();
			List<WebElement> previewModuleImageList = driver.findElements(By.xpath(
					"//table[3]/tbody/tr[2]/td/div[2]/div/table/tbody/tr[contains(@class, 'products_tablecontent')]/td[1]/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[3]"));
			// "//table[3]/tbody/tr[2]/td/div[2]/div/table/tbody/tr[contains(@class,
			// 'products_tablecontent')]/td[1]/table/tbody/tr[2]/td/div/table[contains(@id,'ctl00_contentPlaceHolderBody_ucProductsTutorials_gvProductsTutorialAssessment_ctl07_gvModules')]/tbody/tr[1]/td[3]"));
			if (CollectionUtils.isNotEmpty(previewModuleImageList)) {
				WebElement webElement = previewModuleImageList.get(lndex);
				if (webElement != null) {
					Actions action = new Actions(driver);
					action.moveToElement(webElement).click().build().perform();
					windowHanlder.switchToLatestWindow();
					waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
					flag = true;
				}

			}
			windowHanlder.switchToLatestWindow();
		} catch (Exception e) {
			windowHanlder.switchToLatestWindow();
			logger.info("Unable to clickOnPreviewModuleImg");
			log(logger, "Unable to clickOnPreviewModuleImg");
			throw new DriverException("Unable to clickOnPreviewModuleImg", e);
		}
		logger.info("clickOnPreviewModuleImg end flag --> " + flag);
		return flag;
	}

	/**
	 * This method is used to click On Image By Action Class
	 * 
	 * @param lndex
	 * @param waitFor
	 * @throws DriverException
	 */
	public boolean clickOnEnableDisableImg(int lndex, int waitFor) throws DriverException {
		logger.info("Method: clickOnEnableDisableImg Start");
		boolean flag = false;
		try {
			switchToCardShadowFrame();
			List<WebElement> previewModuleImageList = driver.findElements(By.xpath(
					"//table[3]/tbody/tr[2]/td/div[2]/div/table/tbody/tr[contains(@class, 'products_tablecontent')]/td[1]/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[4]"));
			// "//table[3]/tbody/tr[2]/td/div[2]/div/table/tbody/tr[contains(@class,
			// 'products_tablecontent')]/td[1]/table/tbody/tr[2]/td/div/table[contains(@id,'ctl00_contentPlaceHolderBody_ucProductsTutorials_gvProductsTutorialAssessment_ctl07_gvModules')]/tbody/tr[1]/td[3]"));
			if (CollectionUtils.isNotEmpty(previewModuleImageList)) {
				WebElement webElement = previewModuleImageList.get(lndex);
				if (webElement != null) {
					Actions action = new Actions(driver);
					action.moveToElement(webElement).click().build().perform();
					windowHanlder.switchToLatestWindow();
					waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
					flag = true;
				}

			}
			windowHanlder.switchToLatestWindow();
		} catch (Exception e) {
			windowHanlder.switchToLatestWindow();
			logger.info("Unable to clickOnEnableDisableImg");
			log(logger, "Unable to clickOnEnableDisableImg");
			throw new DriverException("Unable to clickOnEnableDisableImg", e);
		}
		logger.info("clickOnEnableDisableImg end flag --> " + flag);
		return flag;
	}

	/**
	 * This method is used to switch To Current Frame
	 * 
	 * @throws DriverException
	 */
	public void switchToCardShadowFrame() throws DriverException {
		logger.info("switchToCardShadowFrame  start");
		try {
			WebElement frameElement = driver.findElement(By.cssSelector(".card-shadow"));
			driver.switchTo().frame(frameElement);
		} catch (Exception e) {
			throw new DriverException("unable to swith to frame");

		}
		logger.info("switchToCardShadowFrame  end");
	}

	public void waitForAwhile(int milliSeconds) {
		try {
			Thread.sleep(milliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Method used to enter text in Student Roster Search text box.
	 * 
	 * @author saravanan.jothimani
	 * @param value
	 * @throws Exception
	 */
	public void enterTextInSearchBox(String locator, String value) throws Exception {
		logger.info("Method :enterTextInSearchBox Start");
		try {
			List<WebElement> inputText = verifyElementList(locator);
			if (CollectionUtils.isNotEmpty(inputText)) {
				inputText.get(0).click();
				inputText.get(0).sendKeys(value);
				inputText.get(0).sendKeys(Keys.ENTER);
			} else {
				logger.info("Unable to find element in enterTextInSearchBox");
			}
		} catch (Exception e) {
			logger.info("Unable to enterTextInSearchBox");
			log(logger, "Unable to enterTextInSearchBox");
			throw new DriverException("Unable to enterTextInSearchBox", e);
		}
		logger.info("Method:enterTextInSearchBox End");
	}

	/**
	 * Method used to enter text in Student Roster Search text box.
	 * 
	 * @author saravanan.jothimani
	 * @param value
	 * @throws Exception
	 */
	public void enterTextInSearchBox(String value) throws Exception {
		logger.info("Method :enterTextInSearchBox Start");
		try {
			List<WebElement> inputText = verifyElementList(PropertiesRepository
					.getString("id.product.manage.roster.student.roster.search.by.last.name.text.box.loc"));
			if (CollectionUtils.isNotEmpty(inputText)) {
				inputText.get(0).click();
				inputText.get(0).sendKeys(value);
				inputText.get(0).sendKeys(Keys.ENTER);
			} else {
				logger.info("Unable to find element in enterTextInSearchBox");
			}
		} catch (Exception e) {
			logger.info("Unable to enterTextInSearchBox");
			log(logger, "Unable to enterTextInSearchBox");
			throw new DriverException("Unable to enterTextInSearchBox", e);
		}
		logger.info("Method:enterTextInSearchBox End");
	}

	/**
	 * Method used to verify Element is present in DOM.
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @return
	 * @throws DriverException
	 */
	public List<WebElement> verifyElementList(String locator) throws DriverException {
		logger.info("verifyElementList Start");
		List<WebElement> webElement = null;
		try {
			List<WebElement> element = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(element)) {
				webElement = element;
			}
		} catch (Exception e) {
			logger.info("Unable to verifyElementList");
			log(logger, "Unable to verifyElementList");
			throw new DriverException("Unable to verifyElementList", e);
		}
		logger.info("verifyElementList End");
		return webElement;
	}

	/**
	 * This method is used to wait until the buffer image is completely load.
	 * 
	 * @author Sanapati.Srinu
	 * @param loc
	 * @throws Exception
	 */
	public void waitUntillLoadingImageIsDisappeared(String loc) throws Exception {
		logger.info("Method: waitUntillLoadingImageIsDisappeared Starts");
		long startTime = System.currentTimeMillis();
		try {
			List<WebElement> buffecImage = baseHandler.findElements(loc);
			try {
				while (CollectionUtils.isNotEmpty(buffecImage) && ((System.currentTimeMillis() - startTime) < 120000)) {
					logger.info("page is still loading after click on the element");
					logger.info("Wait Counter in Seconds >>>> "
							+ (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - startTime)));
					buffecImage = baseHandler.findElements(loc);
				}
				if (!((System.currentTimeMillis() - startTime) < 120000)) {
					logger.info("Waited 120 seconds to load the page");
					throw new DriverException("Unable to wait Untill Loading Image Is not Disappeared");
				} else {
					logger.info("Page load complete");
				}
				// waitUntillOverlayImageIsDisappeared("new-atitesting.peasewait.bufferLoc1");
			} catch (Exception e) {
				// waitUntillOverlayImageIsDisappeared("new-atitesting.peasewait.bufferLoc1");
				if (!((System.currentTimeMillis() - startTime) < 120000)) {
					logger.info("Waited 120 seconds to load the page");
					throw new DriverException("Unable to wait Untill Loading Image Is not Disappeared", e);
				} else {
					logger.info("Page load complete in catch block");
				}
			}
		} catch (Exception e) {
			logger.info("Unable to wait Untill Loading Image Is not Disappeared");
			log(logger, "Unable to wait Untill Loading Image Is not Disappeared");
			throw new DriverException("Unable to wait Untill Loading Image Is not Disappeared", e);
		}
		logger.info("waitUntillLoadingImageIsDisappeared End");
	}

	/**
	 * Method used to verify element and if required, it will click.
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @param click
	 * @return
	 * @throws NullPointerException
	 * @throws DriverException
	 */
	public boolean verifyAndClickWithSwitchToCardShadowFrame(String locator, boolean click)
			throws NullPointerException, DriverException {
		logger.info("Method: verifyAndClickWithSwitchToCardShadowFrame Starts");
		boolean flag = false;
		try {
			switchToCardShadowFrame();
			List<WebElement> element = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(element)) {
				if (click) {
					element.get(0).click();
				}
				flag = true;
			}
			windowHanlder.switchToLatestWindow();
		} catch (Exception e) {
			logger.info("Unable to verifyAndClickWithSwitchToCardShadowFrame");
			log(logger, "Unable to verifyAndClickWithSwitchToCardShadowFrame");
			throw new DriverException("Unable to verifyAndClickWithSwitchToCardShadowFrame", e);
		}
		logger.info("Method: verifyAndClickWithSwitchToCardShadowFrame End flag --> " + flag);
		return flag;
	}

}
