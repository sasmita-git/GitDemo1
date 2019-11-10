package com.automation.newati.pages;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ascendlearning.automation.ui.config.GlobalProperties;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.ButtonHandler;
import com.ascendlearning.automation.ui.handlers.DropDownHandler;
import com.ascendlearning.automation.ui.handlers.TextHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;
import com.ascendlearning.automation.ui.page.BasePage;
import com.ascendlearning.automation.ui.utils.SizzleSelector;

public class NewATIBasePage extends BasePage {

	private Logger logger = LogManager.getLogger(this.getClass());
	private BaseHandler baseHandler;
	private TextHandler textHandler;
	private WindowHandler windowHandler;
	private DropDownHandler dropDownHandler;
	protected WebDriverWait wait;
	private ButtonHandler buttonHandler;

	WebDriverWait driverWait = new WebDriverWait(driver, GlobalProperties.EXPLICIT_WAIT);
	SizzleSelector sizzleSelector = new SizzleSelector(driver);

	public NewATIBasePage(WebDriver webDriver) {
		super(webDriver);
		baseHandler = new BaseHandler(driver);
		textHandler = new TextHandler(driver);
		windowHandler = new WindowHandler(driver);
		dropDownHandler = new DropDownHandler(driver);
		buttonHandler = new ButtonHandler(driver);
		wait = new WebDriverWait(driver, PropertiesRepository.getInt("global.driver.wait"));
	}

	/**
	 * Method used to click on Button.
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @throws Exception
	 */
	public boolean clickButton(String locator) throws Exception {
		logger.info("Method: clickButton Starts");
		boolean flag = false; 
		try {
			Thread.sleep(2000);
			List<WebElement> element = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(element)) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element.get(0));
				element.get(0).click(); 
				Thread.sleep(2000);
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to click Button");
			log(logger, "Unable to click Button");
			throw new DriverException("Unable to click Button", e);
		}
		logger.info("Method: clickButton End flag --> " + flag);
		return flag;
	}

	/**
	 * Method used to click on Button.
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @throws Exception
	 */
	public void clickButtonATiFaculty(String locator) throws Exception {
		logger.info("Method: clickButton Starts");
		try {
			Thread.sleep(2000);
			List<WebElement> element = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(element)) {
				element.get(0).click();
				waitUntillLoadingImageIsDisappeared("ATIFaculty.common.page.loader");
			}
		} catch (Exception e) {
			logger.info("Unable to click Button");
			log(logger, "Unable to click Button");
			throw new DriverException("Unable to click Button", e);
		}
		logger.info("Method: clickButton End ");
	}

	/**
	 * Method used to click on Button with index.
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @throws Exception
	 */
	public void clickButtonATiFacultyWithIndex(String locator, int index) throws Exception {
		logger.info("Method: clickButton Starts");
		try {
			Thread.sleep(2000);
			List<WebElement> element = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(element)) {
				element.get(index).click();
				waitUntillLoadingImageIsDisappeared("ATIFaculty.common.page.loader");
			}
		} catch (Exception e) {
			logger.info("Unable to click Button");
			log(logger, "Unable to click Button");
			throw new DriverException("Unable to click Button", e);
		}
		logger.info("Method: clickButton End ");
	}

	/**
	 * Method used to click on Button.
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @throws Exception
	 */
	public void clickButton(String locator, boolean wait) throws Exception {
		logger.info("Method: clickButton Starts");
		try {
			List<WebElement> element = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(element)) {
				element.get(0).click();
				if (wait) {
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				}
			}
		} catch (Exception e) {
			logger.info("Unable to click Button");
			log(logger, "Unable to click Button");
			throw new DriverException("Unable to click Button", e);
		}
		logger.info("Method: clickButton End ");
	}

	/**
	 * To check whether element is displayed or not.
	 * 
	 * @author prasanna.gogineni
	 * @param locator
	 * @return
	 * @throws Exception
	 */
	public boolean checkElementDispalyed(String locator, String... waitFor) throws DriverException {
		logger.info("checkElementDispalyed Start " + locator);
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(locator);

			if (element.size() > 0) {
				WebElement elementDispalyed = element.get(0);
				// baseHandler.waitToBeDisplayed(elementDispalyed);
				flag = baseHandler.isDisplayed(elementDispalyed);
			}

			if (flag && waitFor != null && waitFor.length > 0) {
				baseHandler.setDriverWait(driver, waitFor[0]);
			}
		} catch (Exception e) {
			logger.info("Unable to click Button");
			log(logger, "Unable to click Button");
			throw new DriverException("Unable to click Button", e);
		}

		logger.info("checkElementDispalyed End " + flag);
		return flag;
	}

	/**
	 * Method used to click on Button with index.
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @param index
	 * @throws Exception
	 */
	public void clickButton(String locator, int index) throws Exception {
		logger.info("Method: clickButton Starts");
		try {
			List<WebElement> element = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(element)) {
				element.get(index).click();
			}
		} catch (Exception e) {
			logger.info("Unable to click Button");
			log(logger, "Unable to click Button");
			throw new DriverException("Unable to click Button", e);
		}
		logger.info("Method: clickButton End ");
	}

	/**
	 * Method used to click on Button with index.
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @param index
	 * @throws Exception
	 */
	public void clickButtonForProctor(String locator, int index) throws Exception {
		logger.info("Method: clickButton Starts");
		try {
			Thread.sleep(35000);
			List<WebElement> element = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(element)) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element.get(index));
				element.get(index).click();
				logger.info("Start/ Resume Button clicked");
			}
		} catch (Exception e) {
			logger.info("Unable to click Button");
			log(logger, "Unable to click Button");
			throw new DriverException("Unable to click Button", e);
		}
		logger.info("Method: clickButton End ");
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
			List<WebElement> buffecImage = baseHandler.findElements(PropertiesRepository.getString(loc));
			try {
				while (CollectionUtils.isNotEmpty(buffecImage) && ((System.currentTimeMillis() - startTime) < 120000)) {
					logger.info("page is still loading after click on the element");
					logger.info("Wait Counter in Seconds >>>> "
							+ (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - startTime)));
					buffecImage = baseHandler.findElements(PropertiesRepository.getString(loc));
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
	 * This method is used to wait until Product Loading Message is disappeared.
	 * 
	 * @author syed.pasha
	 * @param loc
	 * @throws Exception
	 */
	public void waitUntillProductLoadingMsgDisappeared(String loc) throws Exception {
		logger.info("Method: waitUntillLoadingImageIsDisappeared Starts");
		long startTime = System.currentTimeMillis();
		try {
			WebElement buffecImage = baseHandler.findElement(PropertiesRepository.getString(loc));
			try {
				while ((buffecImage.isDisplayed()) && ((System.currentTimeMillis() - startTime) < 120000)) {
					logger.info("Products are still loading ....");
					logger.info("Wait Counter in Seconds >>>> "
							+ (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - startTime)));
					buffecImage = baseHandler.findElement(PropertiesRepository.getString(loc));
				}
			} catch (Exception e) {
				if (!((System.currentTimeMillis() - startTime) < 120000)) {
					logger.info("Waited 120 seconds to load the products");
				} else {
					logger.info("product load complete");
				}
			}
		} catch (Exception e) {
			logger.info("Unable to wait Untill Product load message disappeard");
			log(logger, "Unable to wait Untill Product load message disappeard");
			throw new DriverException("Unable to wait Untill Product load message disappeard", e);
		}
		logger.info("waitUntillLoadingImageIsDisappeared End");
	}

	/**
	 * This method is used to wait until the buffer image is completely load.
	 * 
	 * @author Sanapati.Srinu
	 * @param loc
	 * @throws Exception
	 */
	public void waitUntillLoadingTestTabAssessmentDisappeared(String loc) throws Exception {
		logger.info("Method: waitUntillLoadingTestTabAssessmentDisappeared Starts");
		try {
			List<WebElement> buffecImage = baseHandler.findElements(PropertiesRepository.getString(loc));
			try {

				while (String.valueOf(buffecImage.size()) != null) {
					logger.info("page is still loading after click on the element");
					buffecImage = baseHandler.findElements(PropertiesRepository.getString(loc));
				}
			} catch (Exception e) {
				logger.info("page is loaded successfully");
			}

		} catch (Exception e) {
			logger.info("Unable to waitUntillLoadingTestTabAssessmentDisappeared");
			log(logger, "Unable to waitUntillLoadingTestTabAssessmentDisappeared");
			throw new DriverException("Unable to waitUntillLoadingTestTabAssessmentDisappeared", e);
		}
		logger.info("waitUntillLoadingTestTabAssessmentDisappeared End");
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
				while (String.valueOf(buffecImage.size()) != null) {
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
	 * This method is used to wait until the buffer image is completely load.
	 * 
	 * @author Sanapati.Srinu
	 * @param loc
	 * @throws Exception
	 */
	public void waitUntillLoadingImageIsAppeared(String loc) throws Exception {
		logger.info("Method: waitUntillLoadingImageIsAppeared Starts");
		try {
			List<WebElement> buffecImage = baseHandler.findElements(PropertiesRepository.getString(loc));
			try {
				while (buffecImage.size() == 1) {
					logger.info("page is not displaying loading image, waiting it to appear.");
					buffecImage = baseHandler.findElements(PropertiesRepository.getString(loc));

				}
			} catch (Exception e) {
				logger.info("page is loaded successfully");
			}

		} catch (Exception e) {
			logger.info("Unable to wait Untill Loading Image Is not Appeared");
			log(logger, "Unable to wait Untill Loading Image Is not Appeared");
			throw new DriverException("Unable to wait Untill Loading Image Is not Appeared", e);
		}
		logger.info("waitUntillLoadingImageIsAppeared End");
	}

	/**
	 * Method used to enter Proctor Id and Pwd.
	 * 
	 * @author saravanan.jothimani ".focus-element-flag.focus-on"
	 */
	public void enterValue(String selector, String text) throws Exception {
		logger.info("Method: enterProctorIDAndPwd Starts");
		try {
			windowHandler.switchToLatestWindow();
			List<WebElement> element = baseHandler
					.findElements("section[class='sign-in-step-username'] input[class='focus-element-flag focus-on']");
			if (CollectionUtils.isNotEmpty(element)) {
				textHandler.writeText(element.get(0), text.trim());
			}
		} catch (DriverException e) {
			logger.info("Unable to enter Proctor ID And Pwd");
			log(logger, "Unable to enter Proctor ID And Pwd");
			throw new DriverException("Unable to enter Proctor ID And Pwd", e);
		}
		logger.info("Method: enterProctorIDAndPwd End ");
	}

	public void enterTextValue(String locator, String value) throws Exception {
		logger.info("enterTextValue Start");
		try {
			List<WebElement> element = baseHandler.findElements(locator);
			System.out.println(element.size());
			if (CollectionUtils.isNotEmpty(element)) {
				element.get(0).sendKeys(value);
			}
		} catch (Exception e) {
			logger.info("Unable to enterTextValue");
			log(logger, "Unable to enterTextValue");
			throw new DriverException("Unable to enterTextValue", e);
		}
		logger.info("enterTextValue End");
	}

	/**
	 * Method used to click with selenium, if it is not clicked, it will click
	 * with Javascript.
	 * 
	 * @param locator
	 * @throws Exception
	 */
	public boolean verifyAssessmentIDPopup(String locator) throws Exception {
		logger.info("verifyAssessmentIDPopup Start");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(element)) {
				if (!element.get(0).isDisplayed()) {
					logger.info("Clicking using Javascript click");
					// Clicking on Add Product.
					List<WebElement> addProductElement = baseHandler
							.findElements(".add-product-btn.focus-element-flag");
					if (CollectionUtils.isNotEmpty(addProductElement)) {
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
								addProductElement.get(0));
						List<WebElement> elementSecond = baseHandler.findElements(locator);
						if (CollectionUtils.isNotEmpty(elementSecond) && elementSecond.get(0).isDisplayed()) {
							flag = true;
						}
					}
				} else {
					logger.info("Clicking on Selenium click");
					// Selneium Click
					element.get(0).click();
					flag = true;
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verifyAssessmentIDPopup");
			log(logger, "Unable to verifyAssessmentIDPopup");
			throw new DriverException("Unable to verifyAssessmentIDPopup", e);
		}
		logger.info("verifyAssessmentIDPopup End flag--> " + flag);
		return flag;
	}

	public void enterTextValue(String locator, boolean clearText, String value) throws Exception {
		logger.info("enterTextValue Start");
		try {
			List<WebElement> element = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(element)) {
				if (clearText) {
					element.get(0).clear();
				}
				element.get(0).sendKeys(value);
			}
		} catch (Exception e) {
			logger.info("Unable to enterTextValue");
			log(logger, "Unable to enterTextValue");
			throw new DriverException("Unable to enterTextValue", e);
		}
		logger.info("enterTextValue End");
	}

	public void clickTab(String loc) {
		logger.info("Method : clickTab :::::::: START");
		driver.findElement(By.cssSelector(loc)).sendKeys(Keys.TAB);
		logger.info("Method : clickTab :::::::: END");
	}

	public void selectDatePicker(String txtFieldLoc, String inputDate) {
		logger.info("Method : selectDatePicker :::::::: START");
		List<WebElement> element = baseHandler.findElements(txtFieldLoc);
		if (CollectionUtils.isNotEmpty(element)) {
			element.get(0).sendKeys(inputDate);
			element.get(0).sendKeys(Keys.TAB);
		}
		logger.info("Method : selectDatePicker :::::::: END");
	}

	public String getText(String textLocator) throws DriverException {
		logger.info("NewATIBasePage getText() Start  " + textLocator);
		String text = null;
		List<WebElement> element = baseHandler.findElements(textLocator);
		if (CollectionUtils.isNotEmpty(element)) {
			text = textHandler.getText(textLocator);
		}
		logger.info("NewATIBasePage getText() End " + text);
		return text;
	}

	public String getTextFromLst(String textLocator, int index) throws Exception {
		logger.info("NewATIBasePage getTextFromLst() Start  " + textLocator);
		String text = null;
		try {
			List<WebElement> element = baseHandler.findElements(textLocator);
			if (CollectionUtils.isNotEmpty(element)) {
				text = element.get(index).getText();
			}
		} catch (Exception e) {
			throw new DriverException("getTextFromLst", e);
		}
		logger.info("NewATIBasePage getTextFromLst() End " + text);
		return text;
	}

	protected String getEnvironment() throws DriverException {
		logger.info("Method : getEnvironment :::::::: START");

		String result = null;
		result = driver.getCurrentUrl();
		if (result.contains("stage")) {
			result = "Stage";
		} else if (result.contains("qa")) {
			result = "QA";
		} else {
			result = "Production";
		}
		logger.info("Method : getEnvironment :::::::: End  " + result);
		return result;
	}

	public boolean checkElementEnabled(String locator) throws DriverException {
		logger.info("checkElementEnabled Start " + locator);
		boolean flag = false;
		try {
//			windowHandler.switchToFrame("assessmentFrame");
			List<WebElement> element = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(element) && element.size() > 0) {
				flag = baseHandler.isEnabled(element.get(0));
			} else {
				logger.info("Unable to find Elements for locator --> " + locator);
			}
		} catch (Exception e) {
			throw new DriverException("Unable to locate element" + e);
		}

		logger.info("checkElementEnabled End " + flag);
		return flag;
	}

	public boolean checkElementSelected(String locator) throws DriverException {
		logger.info("checkElementSelected Start " + locator);
		boolean flag = false;
		List<WebElement> element = baseHandler.findElements(locator);

		if (CollectionUtils.isNotEmpty(element) && element.size() > 0) {
			flag = baseHandler.isSelected(element.get(0));
		} else {
			logger.info("Unable to find Elements for locator --> " + locator);
		}
		logger.info("checkElementSelected End " + flag);
		return flag;
	}

	public void selectDropdownValue(String objloc, String indName) throws DriverException {
		logger.info("Method : selectDropdownValue :::::::: START");
		try {
			if (StringUtils.isNotBlank(objloc) && StringUtils.isNotBlank(indName)) {
				Select selDrop = dropDownHandler.getDropDown(objloc);
				dropDownHandler.selectByVisibleText(selDrop, indName);
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			}
		} catch (Exception e) {
			throw new DriverException("Unable to locate dropdown element" + e);
		}
		logger.info("Method : selectDropdownValue :::::::: END");
	}

	/**
	 * Method is used to verify Message.
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @param message
	 * @return flag
	 * @throws Exception
	 */
	public boolean verifyMessage(String locator, String message) throws Exception {
		logger.info("Method: verifyMessage Starts ");
		logger.info("Locator value --> " + locator);
		logger.info("message --> " + message);
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(element)) {
				flag = element.get(0).getText().equalsIgnoreCase(message);
			} else {
				logger.info("Unable to get locator for " + locator);
			}
		} catch (Exception e) {
			logger.info("Unable to verify Message");
			log(logger, "Unable to verify Message");
			throw new DriverException("Unable to verify Message", e);
		}
		logger.info("Method: verifyMessage End flag --> " + flag);
		return flag;
	}

	/**
	 * Method is used to verify Message.
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @param message
	 * @return flag
	 * @throws Exception
	 */
	public boolean verifyMessage(String locator, int index,  String message) throws Exception {
		logger.info("Method: verifyMessage Starts ");
		logger.info("Locator value --> " + locator);
		logger.info("index --> " + index);
		logger.info("message --> " + message);
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(element)) {
				flag = element.get(index).getText().equalsIgnoreCase(message);
			} else {
				logger.info("Unable to get locator for " + locator);
			}
		} catch (Exception e) {
			logger.info("Unable to verify Message");
			log(logger, "Unable to verify Message");
			throw new DriverException("Unable to verify Message", e);
		}
		logger.info("Method: verifyMessage End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method is used to verify Message.
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @param message
	 * @return flag
	 * @throws Exception
	 */
	public boolean verifyMessageContains(String locator, String message) throws Exception {
		logger.info("Method: verifyMessage Starts ");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(element)) {
				flag = element.get(0).getText().contains(message);
			}
		} catch (Exception e) {
			logger.info("Unable to verify Message");
			log(logger, "Unable to verify Message");
			throw new DriverException("Unable to verify Message", e);
		}
		logger.info("Method: verifyMessage End flag --> " + flag);
		return flag;
	}

	/**
	 * Method is used to verify Message after switching to current window.
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @param message
	 * @return flag
	 * @throws Exception
	 */
	public boolean verifyMessageWithDefaultWinSwitch(String locator, String message) throws Exception {
		logger.info("Method: verifyMessageWithDefaultWinSwitch Starts");
		boolean flag = false;
		try {
			windowHandler.switchToLatestWindow();
			List<WebElement> element = baseHandler.findElements(locator);
			System.out.println(element.get(0).getText());
			if (CollectionUtils.isNotEmpty(element)) {
				flag = element.get(0).getText().equalsIgnoreCase(message);
			}
		} catch (Exception e) {
			logger.info("Unable to verify Message With Default Win Switch");
			log(logger, "Unable to verify Message With Default Win Switch");
			throw new DriverException("Unable to verify Message With Default Win Switch", e);
		}
		logger.info("Method: verifyMessageWithDefaultWinSwitch End flag --> " + flag);
		return flag;
	}

	/**
	 * Method is used to verify contains Message after switching to current
	 * window.
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @param message
	 * @return flag
	 * @throws Exception
	 */
	public boolean verifyContainsMessageWithDefaultWinSwitch(String locator, String message) throws Exception {
		logger.info("Method: verifyContainsMessageWithDefaultWinSwitch Starts");
		boolean flag = false;
		try {
			windowHandler.switchToLatestWindow();
			List<WebElement> element = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(element)) {
				flag = element.get(0).getText().contains(message);
			}
		} catch (Exception e) {
			logger.info("Unable to verify ContainsMessageWithDefaultWinSwitch");
			log(logger, "Unable to verify Message");
			throw new DriverException("Unable to verify Message", e);
		}
		logger.info("Method: verifyContainsMessageWithDefaultWinSwitch End flag --> " + flag);
		return flag;
	}

	/**
	 * Method is used to verify Message after switching to current window.
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @param message
	 * @return flag
	 * @throws Exception
	 */
	public boolean verifyMessageWithDefaultWinSwitch(String locator, int index, String message) throws Exception {
		logger.info("Method: verifyMessage Starts");
		boolean flag = false;
		try {
			windowHandler.switchToLatestWindow();
			List<WebElement> element = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(element)) {
				flag = element.get(index).getText().equalsIgnoreCase(message);
			}
		} catch (Exception e) {
			logger.info("Unable to verify Message");
			log(logger, "Unable to verify Message");
			throw new DriverException("Unable to verify Message", e);
		}
		logger.info("Method: verifyMessage End flag --> " + flag);
		return flag;
	}

	/**
	 * This method is used to select DD Value from drop down
	 * 
	 * @author Sagar.Rao
	 * @throws DriverException
	 */
	public void selectAssessmentFromLearnTabDropDown(String assessmentName) throws DriverException {
		logger.info("Method: selectAssessmentFromLearnTabDropDown Starts");
		try {
			List<WebElement> moduleList = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.all.modules.loc"));
			if (moduleList != null && moduleList.size() > 0) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					WebElement element = moduleList.get(i).findElement(
							By.cssSelector(PropertiesRepository.getString("new-atitesting.all.modules.type.loc")));
					if (assessmentName.equalsIgnoreCase(element.getText())) {
						Select selDrop = dropDownHandler
								.getDropDown(PropertiesRepository.getString("new-atitesting.tutorial.dropdownLoc"));

						if ("Quiz Bank".equalsIgnoreCase(assessmentName)) {
							dropDownHandler.selectByValue(selDrop,
									PropertiesRepository.getString("new-atitesting.allDropdown.quizbans.value"));
						} else if ("Flashcards".equalsIgnoreCase(assessmentName)) {
							dropDownHandler.selectByValue(selDrop,
									PropertiesRepository.getString("new-atitesting.flashCardDropdown.value"));
						} else if ("Tutorial".equalsIgnoreCase(assessmentName)) {
							dropDownHandler.selectByValue(selDrop,
									PropertiesRepository.getString("new-atitesting.tutorialDropdown.value"));
						} else if ("eBook".equalsIgnoreCase(assessmentName)) {
							dropDownHandler.selectByValue(selDrop,
									PropertiesRepository.getString("new-atitesting.ebookDropdown.value"));
						}
						break;
					}
				}
			}
		} catch (Exception e) {
			throw new DriverException("Unable to select Assessment from dropdown", e);
		}
		logger.info("Method: selectAssessmentFromLearnTabDropDown Ends");
	}

	/**
	 * Method is used to verify Assessment Title Ex : My ATI - Learn Tab - Sort
	 * using All - Select Tutorial - Make sure only Tutorial are displayed.
	 * 
	 * @param assessmentTitle
	 * @return
	 * @throws Exception
	 */
	public boolean verifyAssessmentTitle(String assessmentTitle) throws Exception {
		logger.info("Method: verifyAssessmentTitle Start");
		boolean flag = false;
		try {
			List<WebElement> allAssessmentTitle = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.infocard.titleLoc"));
			int size = allAssessmentTitle.size();
			if (allAssessmentTitle != null && size > 0) {
				for (WebElement element : allAssessmentTitle) {
					if (assessmentTitle.equalsIgnoreCase(element.getText())) {
						flag = true;
					}
				}
			}
		} catch (Exception e) {
			throw new DriverException("Unable to verify Assessment Title", e);
		}
		logger.info("Method: verifyAssessmentTitle Ends flag --> " + flag);
		return flag;
	}

	/**
	 * Method is used to click Learn Tab Type DD All.
	 * 
	 * @throws DriverException
	 */
	public void clickLearnTabAllDD() throws DriverException {
		logger.info("Method: clickLearnTabAllDD Start");
		try {
			List<WebElement> selectDiv = baseHandler.findElements(
					PropertiesRepository.getString("new-atitesting.homepage.myatitab.learntab.type.dd.loc"));
			int size = selectDiv.size();
			if (selectDiv != null && size > 0) {
				Select selDrop = new Select(selectDiv.get(0).findElement(By.cssSelector("select")));
				dropDownHandler.selectByValue(selDrop, PropertiesRepository.getString("new-atitesting.all.value"));
			}
		} catch (DriverException e) {
			logger.info("Unable to click on Learn Tab All value in Type Drop down");
			throw new DriverException("Unable to click on Learn Tab All value in Type Drop down", e);
		}
		logger.info("Method: clickLearnTabAllDD Ends ");
	}

	/**
	 * Method is used to compare two list.
	 * 
	 * @return
	 * @throws DriverException
	 */
	public boolean sortAllAssessmentDescription() throws DriverException {
		logger.info("sortAllAssessmentDescription Start");
		List<String> beforeSort = null;
		List<String> afterSort = null;
		boolean flag = false;
		try {
			beforeSort = new ArrayList<String>();
			afterSort = new ArrayList<String>();

			beforeSort = getAllAssessmentDescription();
			afterSort = getAllAssessmentDescription();
			Collections.sort(afterSort);

			Set<Object> set1 = new HashSet<Object>();
			set1.addAll(beforeSort);
			Set<Object> set2 = new HashSet<Object>();
			set2.addAll(afterSort);

			if (set1.equals(set2)) {
				flag = true;
			}
		} catch (DriverException e) {
			logger.info("Unable to sort in ascending order");
			throw new DriverException("Unable to sort in ascending order", e);
		}
		logger.info("sortAllAssessmentDescription End flag --> " + flag);
		return flag;
	}

	/**
	 * Method is used to get all assessment name in Learn Tab.
	 * 
	 * @throws DriverException
	 */
	public List<String> getAllAssessmentDescription() throws DriverException {
		logger.info("Method: getAllAssessmentDescription Start");
		List<String> allDescription = new ArrayList<String>();

		try {
			List<WebElement> allNames = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.infocard.tutorialNameLoc"));
			int size = allNames.size();
			if (allNames != null && size > 0) {
				for (WebElement element : allNames) {
					allDescription.add(element.getText());
				}
			}
		} catch (Exception e) {
			logger.info("Unable to get All Assessment name under Learn Tab");
		}
		logger.info("Method: getAllAssessmentDescription End allDescription --> " + allDescription);
		return allDescription;
	}

	/**
	 * Method is used to get the Selected option from Learn Tab All Type.
	 * 
	 * @throws DriverException
	 */
	public boolean getLearnTabTypeSelectedOption(String assessmentName) throws DriverException {
		logger.info("Method: clickLearnTabAllDD Start");
		boolean flag = false;
		try {
			List<WebElement> selectDiv = baseHandler.findElements(
					PropertiesRepository.getString("new-atitesting.homepage.myatitab.learntab.type.dd.loc"));
			int size = selectDiv.size();
			if (selectDiv != null && size > 0) {
				Select selDrop = new Select(selectDiv.get(0).findElement(By.cssSelector("select")));
				WebElement element = selDrop.getFirstSelectedOption();
				if (assessmentName.equalsIgnoreCase(element.getText())) {
					flag = true;
				}
			}
		} catch (Exception e) {
			logger.info("Unable to click on Learn Tab All value in Type Drop down");
			throw new DriverException("Unable to click on Learn Tab All value in Type Drop down", e);
		}
		logger.info("Method: clickLearnTabAllDD Ends flag --> " + flag);
		return flag;
	}

	/**
	 * Method is used to complete Test
	 * 
	 * breakFlag If assessment has to be stopped in middle.
	 * 
	 * rationaleFlag Need to check for Rationale and My Answer.
	 * 
	 * @param bool
	 * @param breakFlag
	 * @param rationaleFlag
	 * @throws Exception
	 */
	public void takeTestNew(boolean bool, boolean breakFlag, boolean rationaleFlag, boolean flagquestion)
			throws Exception {
		logger.info("Method : takeTest :::::::: Starts");
		try {

			// waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			switchToAssessmentFrameHandler();
			// Getting Total Question Number
			String maxQtnTextNo = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.question.number.loc")).get(1)
					.getText();

			// Convert String to Integer
			int maxCount = Integer.parseInt(maxQtnTextNo);

			// Getting Current Question Number
			String minQtnTextNo = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.question.number.loc")).get(0)
					.getText();

			// Convert String to Integer
			int minCount = Integer.parseInt(minQtnTextNo);

			// Maximum Question minus Minimum Questions
			int count = maxCount - minCount;

			for (int i = 0; i <= count; i++) {

				List<WebElement> checkBoxElement = baseHandler.findElements(
						PropertiesRepository.getString("new-atitesting.generic.tutorial.checkbox.new.loc"));
				List<WebElement> radioElement = baseHandler.findElements(
						PropertiesRepository.getString("new-atitesting.generic.tutorial.radio.button.new.loc"));

				if (checkBoxElement != null) {
					checkBoxElement.get(0).click();
					checkBoxElement.get(1).click();
				}

				if (driver
						.findElements(By.cssSelector(
								".answer-fill-in-the-blank.numericTextEntry.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty"))
						.size() > 0) {
					verifyFillForm("10");

				}

				if (CollectionUtils.isNotEmpty(baseHandler.findElements(
						PropertiesRepository.getString("new-atitesting.generic.tutorial.dragbox1.loc")))) {
					DragAndDropAnswer(false);
				}

				if (CollectionUtils.isNotEmpty(radioElement) && radioElement.size() > 0) {
					radioElement.get(0).click();
				}

				if (CollectionUtils.isNotEmpty(
						baseHandler.findElements(PropertiesRepository.getString("new-atitesting.question.img.loc")))) {
					hotSpotQuestion();
				}

				if (i == count) {
					switchToAssessmentFrameHandler();
					List<WebElement> buttonElement = baseHandler.findElements(
							PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
					if (CollectionUtils.isNotEmpty(buttonElement)) {
						if (buttonElement.get(0).isDisplayed()) {
							WebElement continueButtonElement = driver
									.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
							if (continueButtonElement != null) {
								continueButtonElement.sendKeys(Keys.ENTER);
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								if (!continueButtonElement.isEnabled()) {
									clickButton(
											PropertiesRepository.getString(
													"new-atitesting.myati.assessment.question.unanswered.close.loc"),
											0);
									clickAssessmemtType();
								}
							}
						}
					}
					takeAssessment(rationaleFlag, flagquestion, "Proceed to Next Section");
				} else {
					if (i == 0 && flagquestion) {
						switchToAssessmentFrameHandler();
						verifyFlag(true);
						logger.info("Question has been flaged");
						Thread.sleep(4000);
					} else {
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						switchToAssessmentFrameHandler();
						waitUntillElementIsVisible(
								PropertiesRepository.getString("new-atitesting.generic.tutorial.submit.new.loc"));
						List<WebElement> buttonElement = baseHandler.findElements(
								PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
						if (CollectionUtils.isNotEmpty(buttonElement)) {
							if (buttonElement.get(0).isDisplayed()) {
								WebElement continueButtonElement = driver
										.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
								if (continueButtonElement != null) {
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									if (verifyQuestionUnAsweredPopup()) {
										List<WebElement> assessmentCompleteElement = baseHandler
												.findElements(".modal-section button");
										if (CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
											assessmentCompleteElement.get(0).click();
										}
										// clickButton(PropertiesRepository.getString("new-atitesting.myati.assessment.question.unanswered.close.loc"),
										// 0);
										clickAssessmemtType();
									}
								}
							}
						}
					}
					if (rationaleFlag) {
						waitUntillLoadingImageIsDisappeared("new-atitesting.pleasewait.bufferLoc");
						List<WebElement> rationalContinue = driver
								.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
						if (CollectionUtils.isNotEmpty(rationalContinue)) {
							rationalContinue.get(0).sendKeys(Keys.ENTER);
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						}
					}

					switchToAssessmentFrameHandler();

					if (bool) {
						switchToAssessmentFrameHandler();
						waitUntillElementIsVisible(
								PropertiesRepository.getString("new-atitesting.generic.tutorial.continue.loc"));
						Thread.sleep(1000);
						List<WebElement> buttonElement = baseHandler.findElements(
								PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
						if (CollectionUtils.isNotEmpty(buttonElement)) {
							if (buttonElement.get(0).isDisplayed()) {
								WebElement continueButtonElement = driver
										.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
								if (continueButtonElement != null) {
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									if (verifyQuestionUnAsweredPopup()) {
										List<WebElement> assessmentCompleteElement = baseHandler
												.findElements(".modal-section button");
										if (CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
											assessmentCompleteElement.get(0).click();
										}
										// clickButton(PropertiesRepository.getString("new-atitesting.myati.assessment.question.unanswered.close.loc"),
										// 0);
										clickAssessmemtType();
									}
								}
							}
						}

					}
					if (breakFlag) {
						break;
					}
				}
			}
		} catch (DriverException e) {
			logger.info("unable to take practice assessment" + e);
		}
		waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.pleasewait.bufferLoc"));
		logger.info("Method : takeTest :::::::: END");
	}

	/**
	 * Method is used to complete Test
	 * 
	 * breakFlag If assessment has to be stopped in middle.
	 * 
	 * rationaleFlag Need to check for Rationale and My Answer.
	 * 
	 * @param bool
	 * @param breakFlag
	 * @param rationaleFlag
	 * @throws Exception
	 */
	public void takeTestNew(boolean bool, boolean breakFlag, boolean rationaleFlag, boolean flagquestion,
			String finalSectionString) throws Exception {
		logger.info("Method : takeTest :::::::: Starts");
		try {

			// waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			switchToAssessmentFrameHandler();
			// Getting Total Question Number
			String maxQtnTextNo = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.question.number.loc")).get(1)
					.getText();

			// Convert String to Integer
			int maxCount = Integer.parseInt(maxQtnTextNo);

			// Getting Current Question Number
			String minQtnTextNo = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.question.number.loc")).get(0)
					.getText();

			// Convert String to Integer
			int minCount = Integer.parseInt(minQtnTextNo);

			// Maximum Question minus Minimum Questions
			int count = maxCount - minCount;

			for (int i = 0; i <= count; i++) {

				List<WebElement> checkBoxElement = baseHandler.findElements(
						PropertiesRepository.getString("new-atitesting.generic.tutorial.checkbox.new.loc"));
				List<WebElement> radioElement = baseHandler.findElements(
						PropertiesRepository.getString("new-atitesting.generic.tutorial.radio.button.new.loc"));

				if (checkBoxElement != null) {
					checkBoxElement.get(0).click();
					checkBoxElement.get(1).click();
				}

				if (driver
						.findElements(By.cssSelector(
								".answer-fill-in-the-blank.numericTextEntry.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty"))
						.size() > 0) {
					verifyFillForm("10");

				}

				if (CollectionUtils.isNotEmpty(baseHandler.findElements(
						PropertiesRepository.getString("new-atitesting.generic.tutorial.dragbox1.loc")))) {
					DragAndDropAnswer(false);
				}

				if (CollectionUtils.isNotEmpty(radioElement) && radioElement.size() > 0) {
					radioElement.get(0).click();
				}

				if (CollectionUtils.isNotEmpty(
						baseHandler.findElements(PropertiesRepository.getString("new-atitesting.question.img.loc")))) {
					hotSpotQuestion();
				}

				if (i == count) {
					switchToAssessmentFrameHandler();
					List<WebElement> buttonElement = baseHandler.findElements(
							PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
					if (CollectionUtils.isNotEmpty(buttonElement)) {
						if (buttonElement.get(0).isDisplayed()) {
							WebElement continueButtonElement = driver
									.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
							if (continueButtonElement != null) {
								continueButtonElement.sendKeys(Keys.ENTER);
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								if (!continueButtonElement.isEnabled()) {
									clickButton(
											PropertiesRepository.getString(
													"new-atitesting.myati.assessment.question.unanswered.close.loc"),
											0);
									clickAssessmemtType();
								}
							}
						}
					}
					takeAssessment(rationaleFlag, flagquestion, finalSectionString);
				} else {
					if (i == 0 && flagquestion) {
						switchToAssessmentFrameHandler();
						verifyFlag(true);
						logger.info("Question has been flaged");
						Thread.sleep(4000);
					} else {
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						switchToAssessmentFrameHandler();
						waitUntillElementIsVisible(
								PropertiesRepository.getString("new-atitesting.generic.tutorial.submit.new.loc"));
						List<WebElement> buttonElement = baseHandler.findElements(
								PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
						if (CollectionUtils.isNotEmpty(buttonElement)) {
							if (buttonElement.get(0).isDisplayed()) {
								WebElement continueButtonElement = driver
										.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
								if (continueButtonElement != null) {
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									if (verifyQuestionUnAsweredPopup()) {
										List<WebElement> assessmentCompleteElement = baseHandler
												.findElements(".modal-section button");
										if (CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
											assessmentCompleteElement.get(0).click();
										}
										// clickButton(PropertiesRepository.getString("new-atitesting.myati.assessment.question.unanswered.close.loc"),
										// 0);
										clickAssessmemtType();
									}
								}
							}
						}
					}
					if (rationaleFlag) {
						waitUntillLoadingImageIsDisappeared("new-atitesting.pleasewait.bufferLoc");
						List<WebElement> rationalContinue = driver
								.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
						if (CollectionUtils.isNotEmpty(rationalContinue)) {
							rationalContinue.get(0).sendKeys(Keys.ENTER);
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						}
					}

					switchToAssessmentFrameHandler();

					if (bool) {
						switchToAssessmentFrameHandler();
						waitUntillElementIsVisible(
								PropertiesRepository.getString("new-atitesting.generic.tutorial.continue.loc"));
						Thread.sleep(1000);
						List<WebElement> buttonElement = baseHandler.findElements(
								PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
						if (CollectionUtils.isNotEmpty(buttonElement)) {
							if (buttonElement.get(0).isDisplayed()) {
								WebElement continueButtonElement = driver
										.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
								if (continueButtonElement != null) {
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									if (verifyQuestionUnAsweredPopup()) {
										List<WebElement> assessmentCompleteElement = baseHandler
												.findElements(".modal-section button");
										if (CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
											assessmentCompleteElement.get(0).click();
										}
										// clickButton(PropertiesRepository.getString("new-atitesting.myati.assessment.question.unanswered.close.loc"),
										// 0);
										clickAssessmemtType();
									}
								}
							}
						}

					}
					if (breakFlag) {
						break;
					}
				}
			}
		} catch (DriverException e) {
			logger.info("unable to take practice assessment" + e);
		}
		waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.pleasewait.bufferLoc"));
		logger.info("Method : takeTest :::::::: END");
	}
	
	/**
	 * Method used to verify question no in assessment. 
	 * 
	 * @return
	 * @throws DriverException
	 */
	public boolean verifyQuestionNos() throws DriverException {
		logger.info("Method: verifyQuestionNos Starts");
		boolean flag = false;
    	try {
    		//Thread.sleep(30000);
    		
    		waitUntillLoadingImageIsDisappeared("new-atitesting.pleasewait.bufferLoc");
    		switchToAssessmentFrameHandler();
			waitUntillElementIsVisible(PropertiesRepository.getString("new-atitesting.learn.tab.question.no.loc1.new"));
    		List<WebElement> maxQuestElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.learn.tab.question.no.loc1.new"));
    		if(CollectionUtils.isNotEmpty(maxQuestElement) && maxQuestElement.get(0).isDisplayed()) {
    			flag = true;
    		}
    	} catch (Exception e) {
    		logger.info("Unable to verifyQuestionNos");
			log(logger, "Unable to verifyQuestionNos" );
    		throw new DriverException("Unable to verifyQuestionNos" , e); 
    	}
    	logger.info("Method: verifyQuestionNos End flag --> " + flag);
    	return flag;
	}

	/**
	 * Method is used to complete Test
	 * 
	 * breakFlag If assessment has to be stopped in middle.
	 * 
	 * rationaleFlag Need to check for Rationale and My Answer.
	 * 
	 * @param bool
	 * @param breakFlag
	 * @param rationaleFlag
	 * @throws Exception
	 */
	public void takeTest(boolean bool, boolean breakFlag, boolean rationaleFlag, boolean flagquestion)
			throws Exception {
		logger.info("Method : takeTest :::::::: Starts ");
		try {

			// waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			switchToAssessmentFrameHandler();
			// Getting Total Question Number
			String maxQtnTextNo = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.learn.tab.question.no.loc1.new"))
					.get(1).getText();

			// Convert String to Integer
			int maxCount = Integer.parseInt(maxQtnTextNo);

			// Getting Current Question Number
			String minQtnTextNo = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.learn.tab.question.no.loc1.new"))
					.get(0).getText();

			// Convert String to Integer
			int minCount = Integer.parseInt(minQtnTextNo);

			// Maximum Question minus Minimum Questions
			int count = maxCount - minCount;

			for (int i = 0; i <= count; i++) {

				List<WebElement> checkBoxElement = driver.findElements(By.cssSelector(PropertiesRepository.getString("new-atitesting.generic.tutorial.checkbox.new.loc")));
				List<WebElement> radioElement = driver.findElements(By.cssSelector(PropertiesRepository.getString("new-atitesting.generic.tutorial.radio.button.new.loc")));

				if (CollectionUtils.isNotEmpty(checkBoxElement) && checkBoxElement.get(0).isDisplayed()) {
					checkBoxElement.get(0).click();
					checkBoxElement.get(1).click();
				}

				List<WebElement> textBoxElement = driver.findElements(By.cssSelector(
						".answer-fill-in-the-blank.numericTextEntry.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty"));

				if (CollectionUtils.isNotEmpty(textBoxElement) && textBoxElement.get(0).isDisplayed()) {
					verifyFillForm("10");
				}

				// Text Area
				List<WebElement> textAreaElement = driver.findElements(By.cssSelector((PropertiesRepository.getString("asmt.maint.textarea.loc"))));
				if (CollectionUtils.isNotEmpty(textAreaElement) && textAreaElement.get(0).isDisplayed()) {
					textAreaElement.get(0).sendKeys("100");
				}

				if (CollectionUtils.isNotEmpty(driver.findElements(By.cssSelector(	PropertiesRepository.getString("new-atitesting.generic.tutorial.dragbox1.loc"))))) {
					DragAndDropAnswer(false);
				}

				if (CollectionUtils.isNotEmpty(radioElement) && radioElement.size() > 0) {
					radioElement.get(0).click();
				}

				if (CollectionUtils.isNotEmpty(driver.findElements(By.cssSelector(PropertiesRepository.getString("new-atitesting.question.img.loc"))))) {
					hotSpotQuestion();
				}

				if (i == count) {
					switchToAssessmentFrameHandler();
					List<WebElement> buttonElement = baseHandler.findElements(
							PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
					if (CollectionUtils.isNotEmpty(buttonElement)) {
						if (buttonElement.get(0).isDisplayed()) {
							WebElement continueButtonElement = driver
									.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
							if (continueButtonElement != null) {
								continueButtonElement.sendKeys(Keys.ENTER);
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								if (driver
										.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"))
										.size() != 0) {
									if (!continueButtonElement.isEnabled()) {
										if (!(baseHandler.findElements(".complete-assessment-dialog div button")
												.size() != 0)) {
											clickButton(
													PropertiesRepository.getString(
															"new-atitesting.myati.assessment.question.unanswered.close.loc"),
													0);
											clickAssessmemtType();
										}
									}
								}
							}
						}
					}
					takeAssessment(rationaleFlag, flagquestion);
				} else {
					if (i == 0 && flagquestion) {
						switchToAssessmentFrameHandler();
						verifyFlag(true);
						logger.info("Question has been flaged");
						Thread.sleep(4000);
					} else {
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						switchToAssessmentFrameHandler();
						waitUntillElementIsVisible(
								PropertiesRepository.getString("new-atitesting.generic.tutorial.submit.new.loc"));
						List<WebElement> buttonElement = baseHandler.findElements(
								PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
						if (CollectionUtils.isNotEmpty(buttonElement)) {
							if (buttonElement.get(0).isDisplayed()) {
								WebElement continueButtonElement = driver
										.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
								if (continueButtonElement != null) {
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									if (verifyQuestionUnAsweredPopup()) {
										List<WebElement> assessmentCompleteElement = baseHandler
												.findElements(".modal-section button");
										if (CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
											assessmentCompleteElement.get(0).click();
										}
										// clickButton(PropertiesRepository.getString("new-atitesting.myati.assessment.question.unanswered.close.loc"),
										// 0);
										clickAssessmemtType();
									}
								}
							}
						}
					}
					if (rationaleFlag) {
						waitUntillLoadingImageIsDisappeared("new-atitesting.pleasewait.bufferLoc");
						List<WebElement> rationalContinue = driver
								.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
						if (CollectionUtils.isNotEmpty(rationalContinue)) {
							rationalContinue.get(0).sendKeys(Keys.ENTER);
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						}
						
					}

					switchToAssessmentFrameHandler();

					if (bool) {
						switchToAssessmentFrameHandler();
						waitUntillElementIsVisible(
								PropertiesRepository.getString("new-atitesting.generic.tutorial.continue.loc"));
						Thread.sleep(1000);
						List<WebElement> buttonElement = baseHandler.findElements(
								PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
						if (CollectionUtils.isNotEmpty(buttonElement)) {
							if (buttonElement.get(0).isDisplayed()) {
								WebElement continueButtonElement = driver
										.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
								if (continueButtonElement != null) {
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									if (verifyQuestionUnAsweredPopup()) {
										List<WebElement> assessmentCompleteElement = baseHandler
												.findElements(".modal-section button");
										if (CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
											assessmentCompleteElement.get(0).click();
										}
										// clickButton(PropertiesRepository.getString("new-atitesting.myati.assessment.question.unanswered.close.loc"),
										// 0);
										clickAssessmemtType();
									}
								}
							}
						}

					}
					if (breakFlag) {
						break;
					}
				}
			}
		} catch (DriverException e) {
			logger.info("unable to take practice assessment" + e);
		}
		waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.pleasewait.bufferLoc"));
		logger.info("Method : takeTest :::::::: END");
	}

	/**
	 * Method is used to complete Test
	 * 
	 * breakFlag If assessment has to be stopped in middle.
	 * 
	 * rationaleFlag Need to check for Rationale and My Answer.
	 * 
	 * @param bool
	 * @param breakFlag
	 * @param rationaleFlag
	 * @throws Exception
	 */
	public void takeTestTEAS(boolean bool, boolean breakFlag, boolean rationaleFlag, boolean flagquestion)
			throws Exception {
		logger.info("Method : takeTest :::::::: Starts");
		try {

			// waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			switchToAssessmentFrameHandler();
			// Getting Total Question Number
			String maxQtnTextNo = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.question.number.loc")).get(1)
					.getText();

			// Convert String to Integer
			int maxCount = Integer.parseInt(maxQtnTextNo);

			// Getting Current Question Number
			String minQtnTextNo = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.question.number.loc")).get(0)
					.getText();

			// Convert String to Integer
			int minCount = Integer.parseInt(minQtnTextNo);

			// Maximum Question minus Minimum Questions
			int count = maxCount - minCount;

			for (int i = 0; i <= count; i++) {

				List<WebElement> checkBoxElement = baseHandler.findElements(
						PropertiesRepository.getString("new-atitesting.generic.tutorial.checkbox.new.loc"));
				List<WebElement> radioElement = baseHandler.findElements(
						PropertiesRepository.getString("new-atitesting.generic.tutorial.radio.button.new.loc"));

				if (checkBoxElement != null) {
					checkBoxElement.get(0).click();
					checkBoxElement.get(1).click();
				}

				List<WebElement> textBoxElement = driver.findElements(By.cssSelector(
						".answer-fill-in-the-blank.numericTextEntry.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty"));

				if (CollectionUtils.isNotEmpty(textBoxElement) && textBoxElement.get(0).isDisplayed()) {
					verifyFillForm("10");
				}

				/*
				 * // Text Area List<WebElement> textAreaElement =
				 * baseHandler.findElements(PropertiesRepository.getString(
				 * "asmt.maint.textarea.loc"));
				 * if(CollectionUtils.isNotEmpty(textAreaElement) &&
				 * textAreaElement.get(0).isDisplayed()) {
				 * textAreaElement.get(0).sendKeys("100"); }
				 */

				if (CollectionUtils.isNotEmpty(baseHandler.findElements(
						PropertiesRepository.getString("new-atitesting.generic.tutorial.dragbox1.loc")))) {
					DragAndDropAnswer(false);
				}

				if (CollectionUtils.isNotEmpty(radioElement) && radioElement.size() > 0) {
					radioElement.get(0).click();
				}

				if (CollectionUtils.isNotEmpty(
						baseHandler.findElements(PropertiesRepository.getString("new-atitesting.question.img.loc")))) {
					hotSpotQuestion();
				}

				if (i == count) {
					switchToAssessmentFrameHandler();
					List<WebElement> buttonElement = baseHandler.findElements(
							PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
					if (CollectionUtils.isNotEmpty(buttonElement)) {
						if (buttonElement.get(0).isDisplayed()) {
							WebElement continueButtonElement = driver
									.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
							if (continueButtonElement != null) {
								continueButtonElement.sendKeys(Keys.ENTER);
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								if (!continueButtonElement.isEnabled()) {
									clickButton(
											PropertiesRepository.getString(
													"new-atitesting.myati.assessment.question.unanswered.close.loc"),
											0);
									clickAssessmemtType();
								}
							}
						}
					}
					takeAssessment(rationaleFlag, flagquestion);
				} else {
					if (i == 0 && flagquestion) {
						switchToAssessmentFrameHandler();
						verifyFlag(true);
						logger.info("Question has been flaged");
						Thread.sleep(4000);
					} else {
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						switchToAssessmentFrameHandler();
						waitUntillElementIsVisible(
								PropertiesRepository.getString("new-atitesting.generic.tutorial.submit.new.loc"));
						List<WebElement> buttonElement = baseHandler.findElements(
								PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
						if (CollectionUtils.isNotEmpty(buttonElement)) {
							if (buttonElement.get(0).isDisplayed()) {
								WebElement continueButtonElement = driver
										.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
								if (continueButtonElement != null) {
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									if (verifyQuestionUnAsweredPopup()) {
										List<WebElement> assessmentCompleteElement = baseHandler
												.findElements(".modal-section button");
										if (CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
											assessmentCompleteElement.get(0).click();
										}
										// clickButton(PropertiesRepository.getString("new-atitesting.myati.assessment.question.unanswered.close.loc"),
										// 0);
										clickAssessmemtType();
									}
								}
							}
						}
					}
					if (rationaleFlag) {
						waitUntillLoadingImageIsDisappeared("new-atitesting.pleasewait.bufferLoc");
						List<WebElement> rationalContinue = driver
								.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
						if (CollectionUtils.isNotEmpty(rationalContinue)) {
							rationalContinue.get(0).sendKeys(Keys.ENTER);
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						}
					}

					switchToAssessmentFrameHandler();

					if (bool) {
						switchToAssessmentFrameHandler();
						waitUntillElementIsVisible(
								PropertiesRepository.getString("new-atitesting.generic.tutorial.continue.loc"));
						Thread.sleep(1000);
						List<WebElement> buttonElement = baseHandler.findElements(
								PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
						if (CollectionUtils.isNotEmpty(buttonElement)) {
							if (buttonElement.get(0).isDisplayed()) {
								WebElement continueButtonElement = driver
										.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
								if (continueButtonElement != null) {
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									if (verifyQuestionUnAsweredPopup()) {
										List<WebElement> assessmentCompleteElement = baseHandler
												.findElements(".modal-section button");
										if (CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
											assessmentCompleteElement.get(0).click();
										}
										// clickButton(PropertiesRepository.getString("new-atitesting.myati.assessment.question.unanswered.close.loc"),
										// 0);
										clickAssessmemtType();
									}
								}
							}
						}

					}
					if (breakFlag) {
						break;
					}
				}
			}
		} catch (DriverException e) {
			logger.info("unable to take practice assessment" + e);
		}
		waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.pleasewait.bufferLoc"));
		logger.info("Method : takeTest :::::::: END");
	}

	/**
	 * Method is used to complete Test
	 * 
	 * breakFlag If assessment has to be stopped in middle.
	 * 
	 * rationaleFlag Need to check for Rationale and My Answer.
	 * 
	 * @param bool
	 * @param breakFlag
	 * @param rationaleFlag
	 * @throws Exception
	 */
	public void takeTestForDosage(boolean bool, boolean breakFlag, boolean rationaleFlag, boolean flagquestion)
			throws Exception {
		logger.info("Method : takeTestForDosage :::::::: Starts");
		try {

			// waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			switchToAssessmentFrameHandler();
			// Getting Total Question Number
			String maxQtnTextNo = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.learn.tab.question.no.loc1.new"))
					.get(1).getText();

			// Convert String to Integer
			int maxCount = Integer.parseInt(maxQtnTextNo);

			// Getting Current Question Number
			String minQtnTextNo = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.learn.tab.question.no.loc1.new"))
					.get(0).getText();

			// Convert String to Integer
			int minCount = Integer.parseInt(minQtnTextNo);

			// Maximum Question minus Minimum Questions
			int count = maxCount - minCount;

			for (int i = 0; i <= count; i++) {

				List<WebElement> checkBoxElement = baseHandler.findElements(
						PropertiesRepository.getString("new-atitesting.generic.tutorial.checkbox.new.loc"));
				List<WebElement> radioElement = baseHandler.findElements(
						PropertiesRepository.getString("new-atitesting.generic.tutorial.radio.button.new.loc"));

				if (checkBoxElement != null) {
					checkBoxElement.get(0).click();
					checkBoxElement.get(1).click();
				}

				List<WebElement> textBoxElement = driver.findElements(By.cssSelector(
						".answer-fill-in-the-blank.numericTextEntry.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty"));

				if (CollectionUtils.isNotEmpty(textBoxElement) && textBoxElement.get(0).isDisplayed()) {
					verifyFillForm("10");
				}

				List<WebElement> textAreaElement = baseHandler
						.findElements(PropertiesRepository.getString("asmt.maint.textarea.loc"));
				if (CollectionUtils.isNotEmpty(textAreaElement) && textAreaElement.get(0).isDisplayed()) {
					textAreaElement.get(0).sendKeys("100");
				}

				if (CollectionUtils.isNotEmpty(baseHandler.findElements(
						PropertiesRepository.getString("new-atitesting.generic.tutorial.dragbox1.loc")))) {
					DragAndDropAnswer(false);
				}

				if (CollectionUtils.isNotEmpty(radioElement) && radioElement.size() > 0) {
					radioElement.get(0).click();
				}

				if (CollectionUtils.isNotEmpty(
						baseHandler.findElements(PropertiesRepository.getString("new-atitesting.question.img.loc")))) {
					hotSpotQuestion();
				}

				if (i == count) {
					switchToAssessmentFrameHandler();
					List<WebElement> buttonElement = baseHandler.findElements(
							PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
					if (CollectionUtils.isNotEmpty(buttonElement)) {
						if (buttonElement.get(0).isDisplayed()) {
							WebElement continueButtonElement = driver
									.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
							if (continueButtonElement != null) {
								continueButtonElement.sendKeys(Keys.ENTER);
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								if (!continueButtonElement.isEnabled()) {
									if (!(baseHandler.findElements(".complete-assessment-dialog div button")
											.size() != 0)) {
										clickButton(
												PropertiesRepository.getString(
														"new-atitesting.myati.assessment.question.unanswered.close.loc"),
												0);
										clickAssessmemtType();
									}
								}
							}
						}
					}
					takeAssessment(rationaleFlag, flagquestion);
				} else {
					if (i == 0 && flagquestion) {
						switchToAssessmentFrameHandler();
						verifyFlag(true);
						logger.info("Question has been flaged");
						Thread.sleep(4000);
					} else {
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						switchToAssessmentFrameHandler();
						waitUntillElementIsVisible(
								PropertiesRepository.getString("new-atitesting.generic.tutorial.submit.new.loc"));
						List<WebElement> buttonElement = baseHandler.findElements(
								PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
						if (CollectionUtils.isNotEmpty(buttonElement)) {
							if (buttonElement.get(0).isDisplayed()) {
								WebElement continueButtonElement = driver
										.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
								if (continueButtonElement != null) {
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									if (verifyQuestionUnAsweredPopup()) {
										List<WebElement> assessmentCompleteElement = baseHandler
												.findElements(".modal-section button");
										if (CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
											assessmentCompleteElement.get(0).click();
										}
										// clickButton(PropertiesRepository.getString("new-atitesting.myati.assessment.question.unanswered.close.loc"),
										// 0);
										clickAssessmemtType();
									}
								}
							}
						}
					}
					if (rationaleFlag) {
						waitUntillLoadingImageIsDisappeared("new-atitesting.pleasewait.bufferLoc");
						List<WebElement> rationalContinue = driver
								.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
						if (CollectionUtils.isNotEmpty(rationalContinue)) {
							rationalContinue.get(0).sendKeys(Keys.ENTER);
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						}
					}

					switchToAssessmentFrameHandler();

					if (bool) {
						switchToAssessmentFrameHandler();
						waitUntillElementIsVisible(
								PropertiesRepository.getString("new-atitesting.generic.tutorial.continue.loc"));
						Thread.sleep(1000);
						List<WebElement> buttonElement = baseHandler.findElements(
								PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
						if (CollectionUtils.isNotEmpty(buttonElement)) {
							if (buttonElement.get(0).isDisplayed()) {
								WebElement continueButtonElement = driver
										.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
								if (continueButtonElement != null) {
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									if (verifyQuestionUnAsweredPopup()) {
										List<WebElement> assessmentCompleteElement = baseHandler
												.findElements(".modal-section button");
										if (CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
											assessmentCompleteElement.get(0).click();
											waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
											waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
										}
										// clickButton(PropertiesRepository.getString("new-atitesting.myati.assessment.question.unanswered.close.loc"),
										// 0);
										clickAssessmemtType();
									}
								}
							}
						}

					}
					if (breakFlag) {
						break;
					}
				}
			}
		} catch (DriverException e) {
			logger.info("unable to take practice assessment takeTestForDosage" + e);
		}
		waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.pleasewait.bufferLoc"));
		logger.info("Method : takeTestForDosage :::::::: END");
	}

	/**
	 * Method is used to complete Test
	 * 
	 * breakFlag If assessment has to be stopped in middle.
	 * 
	 * rationaleFlag Need to check for Rationale and My Answer.
	 * 
	 * @param bool
	 * @param breakFlag
	 * @param rationaleFlag
	 * @throws Exception
	 */
	public void takeTestPharmacologyAndNurseLogic(boolean bool, boolean breakFlag, boolean rationaleFlag,
			boolean flagquestion) throws Exception {
		logger.info("Method : takeTestPharmacology :::::::: Starts");
		try {

			// waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			switchToAssessmentFrameHandler();
			// Getting Total Question Number
			String maxQtnTextNo = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.question.number.loc")).get(1)
					.getText();

			// Convert String to Integer
			int maxCount = Integer.parseInt(maxQtnTextNo);

			// Getting Current Question Number
			String minQtnTextNo = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.question.number.loc")).get(0)
					.getText();

			// Convert String to Integer
			int minCount = Integer.parseInt(minQtnTextNo);

			// Maximum Question minus Minimum Questions
			int count = maxCount - minCount;

			for (int i = 0; i <= count; i++) {

				List<WebElement> checkBoxElement = baseHandler.findElements(
						PropertiesRepository.getString("new-atitesting.generic.tutorial.checkbox.new.loc"));
				List<WebElement> radioElement = baseHandler.findElements(
						PropertiesRepository.getString("new-atitesting.generic.tutorial.radio.button.new.loc"));

				if (checkBoxElement != null) {
					checkBoxElement.get(0).click();
					checkBoxElement.get(1).click();
				}

				if (CollectionUtils.isNotEmpty(radioElement) && radioElement.size() > 0) {
					List<WebElement> radioClickElement = baseHandler
							.findElements(".question-option.focus-element-flag.ng-scope label");
					if (CollectionUtils.isNotEmpty(radioClickElement)) {
						radioClickElement.get(0).click();
					}
				}

				if (i == count) {
					// switchToAssessmentFrameHandler();
					List<WebElement> buttonElement = baseHandler.findElements(
							PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
					if (CollectionUtils.isNotEmpty(buttonElement)) {
						if (buttonElement.get(0).isDisplayed()) {
							WebElement continueButtonElement = driver
									.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
							if (continueButtonElement != null) {
								continueButtonElement.sendKeys(Keys.ENTER);
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								if (!continueButtonElement.isEnabled()) {
									if (!(baseHandler.findElements(".complete-assessment-dialog div button")
											.size() != 0)) {
										clickButton(
												PropertiesRepository.getString(
														"new-atitesting.myati.assessment.question.unanswered.close.loc"),
												0);
										clickAssessmemtType();
									}
								}
							}
						}
					}
					takeAssessment(rationaleFlag, flagquestion);
				} else {
					if (i == 0 && flagquestion) {
						switchToAssessmentFrameHandler();
						verifyFlag(true);
						logger.info("Question has been flaged");
						Thread.sleep(4000);
					} else {
						// waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						// switchToAssessmentFrameHandler();
						waitUntillElementIsVisible(
								PropertiesRepository.getString("new-atitesting.generic.tutorial.submit.new.loc"));
						List<WebElement> buttonElement = baseHandler.findElements(
								PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						if (CollectionUtils.isNotEmpty(buttonElement)) {
							if (buttonElement.get(0).isDisplayed()) {
								WebElement continueButtonElement = driver
										.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								if (continueButtonElement != null) {
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									if (verifyQuestionUnAsweredPopup()) {
										List<WebElement> assessmentCompleteElement = baseHandler
												.findElements(".modal-section button");
										if (CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
											assessmentCompleteElement.get(0).click();
										}
										// clickButton(PropertiesRepository.getString("new-atitesting.myati.assessment.question.unanswered.close.loc"),
										// 0);
										clickAssessmemtType();
									}
								}
							}
						}
					}
					if (rationaleFlag) {
						// waitUntillLoadingImageIsDisappeared("new-atitesting.pleasewait.bufferLoc");
						List<WebElement> rationalContinue = driver
								.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						if (CollectionUtils.isNotEmpty(rationalContinue)) {
							rationalContinue.get(0).sendKeys(Keys.ENTER);
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						}
					}

					// switchToAssessmentFrameHandler();

					if (bool) {
						switchToAssessmentFrameHandler();
						waitUntillElementIsVisible(
								PropertiesRepository.getString("new-atitesting.generic.tutorial.continue.loc"));
						Thread.sleep(1000);
						List<WebElement> buttonElement = baseHandler.findElements(
								PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
						if (CollectionUtils.isNotEmpty(buttonElement)) {
							if (buttonElement.get(0).isDisplayed()) {
								WebElement continueButtonElement = driver
										.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
								if (continueButtonElement != null) {
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									if (verifyQuestionUnAsweredPopup()) {
										List<WebElement> assessmentCompleteElement = baseHandler
												.findElements(".modal-section button");
										if (CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
											assessmentCompleteElement.get(0).click();
										}
										// clickButton(PropertiesRepository.getString("new-atitesting.myati.assessment.question.unanswered.close.loc"),
										// 0);
										clickAssessmemtType();
									}
								}
							}
						}

					}
					if (breakFlag) {
						break;
					}
				}
			}
		} catch (DriverException e) {
			logger.info("unable to take practice assessment" + e);
		}
		waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.pleasewait.bufferLoc"));
		logger.info("Method : takeTestPharmacology :::::::: END");
	}

	/**
	 * Method is used to complete Test
	 * 
	 * breakFlag If assessment has to be stopped in middle.
	 * 
	 * rationaleFlag Need to check for Rationale and My Answer.
	 * 
	 * @param bool
	 * @param breakFlag
	 * @param rationaleFlag
	 * @throws Exception
	 */
	public boolean takeTestSTT(boolean bool, boolean breakFlag, boolean rationaleFlag, boolean flagquestion)
			throws Exception {
		boolean flag = false;
		logger.info("Method : takeTestSTT :::::::: Starts");
		try {

			// waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			switchToAssessmentFrameHandler();
			// Getting Total Question Number
			String maxQtnTextNo = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.question.number.loc")).get(1)
					.getText();

			// Convert String to Integer
			int maxCount = Integer.parseInt(maxQtnTextNo);

			// Getting Current Question Number
			String minQtnTextNo = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.question.number.loc")).get(0)
					.getText();

			// Convert String to Integer
			int minCount = Integer.parseInt(minQtnTextNo);

			// Maximum Question minus Minimum Questions
			int count = maxCount - minCount;

			for (int i = 0; i <= count; i++) {

				List<WebElement> checkBoxElement = baseHandler.findElements(
						PropertiesRepository.getString("new-atitesting.generic.tutorial.checkbox.new.loc"));
				List<WebElement> radioElement = baseHandler.findElements(
						PropertiesRepository.getString("new-atitesting.generic.tutorial.radio.button.new.loc"));

				if (checkBoxElement != null) {
					checkBoxElement.get(0).click();
					checkBoxElement.get(1).click();
				}

				if (CollectionUtils.isNotEmpty(radioElement) && radioElement.size() > 0) {
					radioElement.get(0).click();
				}

				if (i == count) {
					switchToAssessmentFrameHandler();
					//WebElement btnElement = 
					List<WebElement> buttonElement = baseHandler.findElements(
							PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
					if (CollectionUtils.isNotEmpty(buttonElement)) {
						if (buttonElement.get(0).isDisplayed()) {
							WebElement continueButtonElement = driver
									.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
							if (continueButtonElement != null) {
								continueButtonElement.sendKeys(Keys.ENTER);
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								if (driver
										.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"))
										.size() != 0) {
									if (!continueButtonElement.isEnabled()) {
										if (!(baseHandler.findElements(".complete-assessment-dialog div button")
												.size() != 0))
											clickButton(
													PropertiesRepository.getString(
															"new-atitesting.myati.assessment.question.unanswered.close.loc"),
													0);
										clickAssessmemtType();
									}
								}
							}
						}
					}
					takeAssessment(rationaleFlag, flagquestion, "Finalize and View Results");
					logger.info("After answering all the questions and handling final popup");
					flag = true;
				} else {
					if (i == 0 && flagquestion) {
						switchToAssessmentFrameHandler();
						verifyFlag(true);
						logger.info("Question has been flaged");
						Thread.sleep(4000);
					} else {
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						switchToAssessmentFrameHandler();
						waitUntillElementIsVisible(
								PropertiesRepository.getString("new-atitesting.generic.tutorial.submit.new.loc"));
						List<WebElement> buttonElement = baseHandler.findElements(
								PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
						if (CollectionUtils.isNotEmpty(buttonElement)) {
							if (buttonElement.get(0).isDisplayed()) {
								WebElement continueButtonElement = driver
										.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
								if (continueButtonElement != null) {
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									if (verifyQuestionUnAsweredPopup()) {
										List<WebElement> assessmentCompleteElement = baseHandler
												.findElements(".modal-section button");
										if (CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
											assessmentCompleteElement.get(0).click();
										}
										// clickButton(PropertiesRepository.getString("new-atitesting.myati.assessment.question.unanswered.close.loc"),
										// 0);
										clickAssessmemtType();
									}
								}
							}
						}
					}
					if (rationaleFlag) {
						waitUntillLoadingImageIsDisappeared("new-atitesting.pleasewait.bufferLoc");
						List<WebElement> rationalContinue = driver
								.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
						if (CollectionUtils.isNotEmpty(rationalContinue)) {
							rationalContinue.get(0).sendKeys(Keys.ENTER);
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						}
					}

					switchToAssessmentFrameHandler();

					if (bool) {
						switchToAssessmentFrameHandler();
						waitUntillElementIsVisible(
								PropertiesRepository.getString("new-atitesting.generic.tutorial.continue.loc"));
						Thread.sleep(1000);
						List<WebElement> buttonElement = baseHandler.findElements(
								PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
						if (CollectionUtils.isNotEmpty(buttonElement)) {
							if (buttonElement.get(0).isDisplayed()) {
								WebElement continueButtonElement = driver
										.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
								if (continueButtonElement != null) {
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									if (verifyQuestionUnAsweredPopup()) {
										List<WebElement> assessmentCompleteElement = baseHandler
												.findElements(".modal-section button");
										if (CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
											assessmentCompleteElement.get(0).click();
										}
										// clickButton(PropertiesRepository.getString("new-atitesting.myati.assessment.question.unanswered.close.loc"),
										// 0);
										clickAssessmemtType();
									}
								}
							}
						}

					}
					if (breakFlag) {
						logger.info("After answering single questions inside breakFlag");
						flag = true;
						break;
					}
				}
			}
		} catch (DriverException e) {
			logger.info("unable to take practice assessment" + e);
		}
		waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.pleasewait.bufferLoc"));
		logger.info("Method : takeTestSTT :::::::: END flag --> " + flag);
		return flag;
	}

	public boolean takeTestRationale(boolean bool, boolean breakFlag, boolean rationaleFlag, boolean flagquestion)
			throws Exception {
		logger.info("Method : takeTestRationale :::::::: Starts");
		boolean flag = false;
		try {

			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			switchToAssessmentFrameHandler();
			// Getting Total Question Number
			String maxQtnTextNo = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.new.question.number.loc")).get(1)
					.getText();

			// Convert String to Integer
			int maxCount = Integer.parseInt(maxQtnTextNo);

			// Getting Current Question Number
			String minQtnTextNo = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.new.question.number.loc")).get(0)
					.getText();

			// Convert String to Integer
			int minCount = Integer.parseInt(minQtnTextNo);

			// Maximum Question minus Minimum Questions
			int count = maxCount - minCount;

			for (int i = 0; i <= count; i++) {

				List<WebElement> checkBoxElement = baseHandler.findElements(
						PropertiesRepository.getString("new-atitesting.generic.tutorial.checkbox.new.loc"));
				List<WebElement> radioElement = baseHandler.findElements(
						PropertiesRepository.getString("new-atitesting.generic.tutorial.radio.button.new.loc"));

				if (checkBoxElement != null) {
					checkBoxElement.get(0).click();
					checkBoxElement.get(1).click();
				}

				if (driver
						.findElements(By.cssSelector(
								".answer-fill-in-the-blank.numericTextEntry.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty"))
						.size() > 0) {
					verifyFillForm("10");

				}

				if (CollectionUtils.isNotEmpty(baseHandler.findElements(
						PropertiesRepository.getString("new-atitesting.generic.tutorial.dragbox1.loc")))) {
					DragAndDropAnswer(false);
				}

				if (CollectionUtils.isNotEmpty(radioElement) && radioElement.size() > 0) {
					radioElement.get(0).click();
				}

				if (CollectionUtils.isNotEmpty(
						baseHandler.findElements(PropertiesRepository.getString("new-atitesting.question.img.loc")))) {
					hotSpotQuestion();
				}

				if (i == count) {
					switchToAssessmentFrameHandler();
					List<WebElement> buttonElement = baseHandler.findElements(
							PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
					if (CollectionUtils.isNotEmpty(buttonElement)) {
						if (buttonElement.get(0).isDisplayed()) {
							WebElement continueButtonElement = driver
									.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
							if (continueButtonElement != null) {
								continueButtonElement.sendKeys(Keys.ENTER);
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								if (!continueButtonElement.isEnabled()) {
									clickButton(
											PropertiesRepository.getString(
													"new-atitesting.myati.assessment.question.unanswered.close.loc"),
											0);
									clickAssessmemtType();
								}
							}
						}
					}
					takeAssessment(rationaleFlag, flagquestion);
				} else {
					if (i == 0 && flagquestion) {
						switchToAssessmentFrameHandler();
						verifyFlag(true);
						logger.info("Question has been flaged");
						Thread.sleep(4000);
					} else {
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						// switchToAssessmentFrameHandler();
						waitUntillElementIsVisible(
								PropertiesRepository.getString("new-atitesting.generic.tutorial.submit.new.loc"));
						List<WebElement> buttonElement = baseHandler.findElements(
								PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
						if (CollectionUtils.isNotEmpty(buttonElement)) {
							if (buttonElement.get(0).isDisplayed()) {
								WebElement continueButtonElement = driver
										.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
								if (continueButtonElement != null) {
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									if (verifyQuestionUnAsweredPopup()) {
										List<WebElement> assessmentCompleteElement = baseHandler
												.findElements(".modal-section button");
										if (CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
											assessmentCompleteElement.get(0).click();
										}
										// clickButton(PropertiesRepository.getString("new-atitesting.myati.assessment.question.unanswered.close.loc"),
										// 0);
										clickAssessmemtType();
									}
									if (!flag) {

										// Verifying Incorrect label.
										boolean boolIncorrect = false;
										List<WebElement> incorrectLableElement = baseHandler
												.findElements(".question-rationale-incorrect");
										if (CollectionUtils.isNotEmpty(incorrectLableElement)
												&& incorrectLableElement.size() == 3) {
											boolIncorrect = true;
										}
										// Verifying correct label.
										boolean boolCorrect = false;
										List<WebElement> correctLableElement = baseHandler.findElements(
												".question-rationale-correct.question-rationale-correct-no-smile");
										if (CollectionUtils.isNotEmpty(correctLableElement)
												&& correctLableElement.size() == 1) {
											boolCorrect = true;
										}
										// Verifying My Answer label.
										boolean boolMyAnswer = false;
										List<WebElement> myAnswerLableElement = baseHandler
												.findElements("div[class='myresult-indicator']");
										if (CollectionUtils.isNotEmpty(myAnswerLableElement)
												&& myAnswerLableElement.size() == 1) {
											boolMyAnswer = true;
										}
										if (boolIncorrect && boolCorrect && boolMyAnswer) {
											flag = true;
										}
									}
								}
							}
						}
					}
					if (rationaleFlag) {
						waitUntillLoadingImageIsDisappeared("new-atitesting.pleasewait.bufferLoc");
						List<WebElement> rationalContinue = driver
								.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
						if (CollectionUtils.isNotEmpty(rationalContinue)) {
							rationalContinue.get(0).sendKeys(Keys.ENTER);
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						}
					}
				}
			}
		} catch (DriverException e) {
			logger.info("unable to take practice assessment" + e);
		}
		waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.pleasewait.bufferLoc"));
		logger.info("Method : takeTestRationale :::::::: END flag --> " + flag);
		return flag;
	}

	/**
	 * Method is used to complete Test
	 * 
	 * breakFlag If assessment has to be stopped in middle.
	 * 
	 * rationaleFlag Need to check for Rationale and My Answer.
	 * 
	 * @param bool
	 * @param breakFlag
	 * @param rationaleFlag
	 * @throws Exception
	 */
	public boolean takeTestQuiz(boolean bool, boolean breakFlag, boolean rationaleFlag, boolean flagquestion)
			throws Exception {
		logger.info("Method : takeTestQuiz :::::::: Starts ");
		boolean flag = false;
		try {
			
			// waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			switchToAssessmentFrameHandler();
			// Getting Total Question Number
			String maxQtnTextNo = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.learn.tab.question.no.loc1.new"))
					.get(1).getText();

			// Convert String to Integer
			int maxCount = Integer.parseInt(maxQtnTextNo);

			// Getting Current Question Number
			String minQtnTextNo = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.learn.tab.question.no.loc1.new"))
					.get(0).getText();

			// Convert String to Integer
			int minCount = Integer.parseInt(minQtnTextNo);

			// Maximum Question minus Minimum Questions
			int count = maxCount - minCount;

			for (int i = 0; i <= count; i++) {

				List<WebElement> checkBoxElement = baseHandler.findElements(
						PropertiesRepository.getString("new-atitesting.generic.tutorial.checkbox.new.loc"));
				List<WebElement> radioElement = baseHandler.findElements(
						PropertiesRepository.getString("new-atitesting.generic.tutorial.radio.button.new.loc"));

				if (checkBoxElement != null) {
					checkBoxElement.get(0).click();
					checkBoxElement.get(1).click();
				}

				/*
				 * if (driver.findElements(By.cssSelector(
				 * ".answer-fill-in-the-blank.numericTextEntry.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty"
				 * )).size() > 0) { verifyFillForm("10");
				 * 
				 * }
				 * 
				 * if (CollectionUtils.isNotEmpty(baseHandler.findElements(
				 * PropertiesRepository.getString(
				 * "new-atitesting.generic.tutorial.dragbox1.loc")))) {
				 * DragAndDropAnswer(false); }
				 */

				if (CollectionUtils.isNotEmpty(radioElement) && radioElement.size() > 0) {
					radioElement.get(0).click();
				}

				/*
				 * if (CollectionUtils.isNotEmpty(baseHandler.findElements(
				 * PropertiesRepository.getString(
				 * "new-atitesting.question.img.loc")))) { hotSpotQuestion(); }
				 */
				if (i == count) {
					switchToAssessmentFrameHandler();
					List<WebElement> buttonElement = baseHandler.findElements(
							PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
					if (CollectionUtils.isNotEmpty(buttonElement)) {
						if (buttonElement.get(0).isDisplayed()) {
							WebElement continueButtonElement = driver
									.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
							if (continueButtonElement != null) {
								continueButtonElement.sendKeys(Keys.ENTER);
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								if (!continueButtonElement.isEnabled()) {
									if (!(baseHandler.findElements(".complete-assessment-dialog div button")
											.size() != 0)) {
										clickButton(
												PropertiesRepository.getString(
														"new-atitesting.myati.assessment.question.unanswered.close.loc"),
												0);
										clickAssessmemtType();
									}
								}
							}
						}
					}
					takeAssessmentQuiz(rationaleFlag, flagquestion);
					logger.info("After answering all the questions and handling final popup");
					flag = true;
				} else {
					if (i == 0 && flagquestion) {
						switchToAssessmentFrameHandler();
						verifyFlag(true);
						logger.info("Question has been flaged");
						Thread.sleep(4000);
					} else {
						/*
						 * waitUntillLoadingImageIsDisappeared(
						 * "new-atitesting.peasewait.bufferLoc");
						 * switchToAssessmentFrameHandler();
						 * waitUntillElementIsVisible(PropertiesRepository
						 * .getString(
						 * "new-atitesting.generic.tutorial.submit.new.loc"));
						 */
						List<WebElement> buttonElement = baseHandler.findElements(
								PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
						if (CollectionUtils.isNotEmpty(buttonElement)) {
							if (buttonElement.get(0).isDisplayed()) {
								WebElement continueButtonElement = driver
										.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
								if (continueButtonElement != null) {
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									if (verifyQuestionUnAsweredPopup()) {
										List<WebElement> assessmentCompleteElement = baseHandler
												.findElements(".modal-section button");
										if (CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
											assessmentCompleteElement.get(0).click();
										}
										// clickButton(PropertiesRepository.getString("new-atitesting.myati.assessment.question.unanswered.close.loc"),
										// 0);
										clickAssessmemtType();
									}
								}
							}
						}
					}
					if (rationaleFlag) {
						waitUntillLoadingImageIsDisappeared("new-atitesting.pleasewait.bufferLoc");
						List<WebElement> rationalContinue = driver
								.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
						if (CollectionUtils.isNotEmpty(rationalContinue)) {
							rationalContinue.get(0).sendKeys(Keys.ENTER);
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						}
					}

					// switchToAssessmentFrameHandler();

					if (bool) {
						switchToAssessmentFrameHandler();
						waitUntillElementIsVisible(
								PropertiesRepository.getString("new-atitesting.generic.tutorial.continue.loc"));
						Thread.sleep(1000);
						List<WebElement> buttonElement = baseHandler.findElements(
								PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
						if (CollectionUtils.isNotEmpty(buttonElement)) {
							if (buttonElement.get(0).isDisplayed()) {
								WebElement continueButtonElement = driver
										.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
								if (continueButtonElement != null) {
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									if (verifyQuestionUnAsweredPopup()) {
										List<WebElement> assessmentCompleteElement = baseHandler
												.findElements(".modal-section button");
										if (CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
											assessmentCompleteElement.get(0).click();
										}
										// clickButton(PropertiesRepository.getString("new-atitesting.myati.assessment.question.unanswered.close.loc"),
										// 0);
										clickAssessmemtType();
									}
								}
							}
						}

					}
					if (breakFlag) {
						logger.info("After answering single questions inside breakFlag");
						flag = true;
						break;
					}
				}
			}
		} catch (DriverException e) {
			logger.info("unable to take practice assessment" + e);
		}
		waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.pleasewait.bufferLoc"));
		logger.info("Method : takeTestQuiz :::::::: END");
		return flag;
	}

	public boolean verifyQuestionUnAsweredPopup() throws Exception {
		boolean flag = false;
		try {
			List<WebElement> assessmentCompleteElement = baseHandler.findElements(".modal-section");
			if (CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Method : takeTest :::::::: END");
			throw new DriverException("Unable to verify Question UnAnswered Popup");
		}
		return flag;
	}

	/**
	 * This method is used to identify the presence of disabled submit button
	 * 
	 * @author siddharth roy
	 * @param locator
	 * @return
	 * @throws DriverException
	 */
	public boolean verifyFillForm(String value) throws Exception {
		boolean flag = false;
		try {
			logger.info("Method : verifyFillForm :::::::: start ");

			waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.pleasewait.bufferLoc"));
			switchToAssessmentFrameHandler();

			List<WebElement> element = baseHandler.findElements(
					"div[class='free-form-question-container'] .answer-fill-in-the-blank.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty");

			if (CollectionUtils.isNotEmpty(element)) {
				element.get(0).sendKeys(value);
				flag = true;
			}
		} catch (Exception e) {
			throw new DriverException("Unable to fill the text entry question", e);
		}
		windowHandler.switchToLatestWindow();
		logger.info("Method:  verifyFillForm End --> " + flag);
		return flag;
	}

	/**
	 * This method is used to wait until buffer invisible
	 * 
	 * @author Saravanan Jothimani
	 */
	public void waitUntillBufferInvisible(String loc) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(loc)));
	}

	/**
	 * This method is used to wait until element is disappeared
	 * 
	 * @author syed.pasha
	 */
	public void waitUntillElementInvisible(String loc) {
		logger.info("Waiting for element to disappear");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(loc)));
		new WebDriverWait(driver, 120).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(loc)));

	}

	/**
	 * This method is used to answer drag and drop question
	 * 
	 * @author siddharth roy
	 * @return boolean
	 * @throws DriverException
	 */
	public void DragAndDropAnswer(boolean stop) throws Exception {
		logger.info("DragAndDropAnswer Start ");
		try {
			waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.pleasewait.bufferLoc"));
			logger.info("Method : DragAndDropAnswer :::::::: start ");
			Actions act = new Actions(driver);
			boolean breakflag = false;

			switchToAssessmentFrameHandler();
			int tot = baseHandler
					.findElement(PropertiesRepository.getString("new-atitesting.generic.tutorial.dragbox1.loc")).findElements(By.cssSelector("li")).size();
			if (baseHandler.isDisplayed(PropertiesRepository.getString("new-atitesting.generic.tutorial.dragbox1.loc"))) {

				while (baseHandler.findElement(PropertiesRepository.getString("new-atitesting.generic.tutorial.dragbox2.loc")).findElements(By.cssSelector("li")).size() != tot) {
					if (breakflag) {
						break;
					}
					List<WebElement> btn = baseHandler.findElement(PropertiesRepository.getString("new-atitesting.generic.tutorial.dragbox1.loc")).findElements(By.cssSelector("li"));
					for (int i = 0; i < btn.size(); i++) {
						try {
							wait.until(ExpectedConditions.elementToBeClickable(btn.get(i)));
							WebElement toElement = baseHandler.findElement(
									PropertiesRepository.getString("new-atitesting.generic.tutorial.dragbox2.loc"));
							if (breakflag) {
								break;
							}

							org.openqa.selenium.interactions.Action atc2 = act.clickAndHold(btn.get(i))
									.moveToElement(toElement).release(toElement).build();
							buttonHandler.clickButton(
									PropertiesRepository.getString("new-atitesting.generic.tutorial.dragbox2.loc"));
							atc2.perform();
							if (stop) {
								breakflag = true;
							}
							Thread.sleep(1000);
						} catch (StaleElementReferenceException e) {
							logger.info("element in stale state countiniuing");
						}
					}
				}
			}
		}

		catch (Exception e) {
			throw new DriverException("Unable to Drag And Drop Answer");

		}
		windowHandler.switchToLatestWindow();
		logger.info("Method:  DragAndDropAnswer End --> ");
	}

	/**
	 * This method is used to identify the hotspot question.
	 * 
	 * @author siddharth roy
	 * @return boolean
	 * @throws DriverException
	 */
	public boolean hotSpotQuestion() throws Exception {
		boolean flag = false;
		try {
			logger.info("Method : hotSpotQuestion :::::::: start ");
			switchToAssessmentFrameHandler();

			if (baseHandler.isDisplayed(PropertiesRepository.getString("new-atitesting.question.img.loc"))) {
				buttonHandler.clickButton(PropertiesRepository.getString("new-atitesting.question.img.loc"));
			}
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			throw new DriverException("Unable to Verify Submit Disabled", e);
		}
		windowHandler.switchToLatestWindow();
		logger.info("Method:  hotSpotQuestion End --> " + flag);
		return flag;
	}

	public void clickAssessmemtType() throws Exception {
		switchToAssessmentFrameHandler();
		List<WebElement> checkBoxElement = baseHandler
				.findElements(PropertiesRepository.getString("new-atitesting.generic.tutorial.checkbox.new.loc"));
		List<WebElement> radioElement = baseHandler
				.findElements(PropertiesRepository.getString("new-atitesting.generic.tutorial.radio.button.new.loc"));
		List<WebElement> hotSpotElement = baseHandler
				.findElements(PropertiesRepository.getString("new-atitesting.question.img.loc"));
		List<WebElement> inputBoxOption = baseHandler.findElements(
				".answer-fill-in-the-blank.numericTextEntry.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty");
		List<WebElement> dragNDrop = baseHandler
				.findElements(PropertiesRepository.getString("new-atitesting.generic.tutorial.dragbox1.loc"));

		if (CollectionUtils.isNotEmpty(checkBoxElement) && checkBoxElement.size() > 0) {
			checkBoxElement.get(0).click();
		} else if (CollectionUtils.isNotEmpty(hotSpotElement) && hotSpotElement.size() > 0) { // Clicking
																								// Flag
																								// if
																								// it
																								// has
																								// Hot
																								// Spot
																								// Image
			hotSpotQuestion();
		} else if (CollectionUtils.isNotEmpty(radioElement) && radioElement.size() > 0) {
			radioElement.get(0).click();
		} else if (CollectionUtils.isNotEmpty(inputBoxOption)) {
			verifyFillForm("10");
		} else if (CollectionUtils.isNotEmpty(dragNDrop)) {
			DragAndDropAnswer(false);
		} else {
			buttonHandler.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.flag.button"));
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		}
		windowHandler.switchToLatestWindow();
	}

	/**
	 * This method is used to create practice Assessment
	 * 
	 * @author Sagar.Rao
	 * 
	 * @throws InterruptedException
	 * 
	 * @throws DriverException
	 */
	public void takeAssessment(boolean bool, boolean flagquestion) throws InterruptedException, DriverException {
		logger.info("takeAssessment starts");
		try {
			waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.pleasewait.bufferLoc"));
			switchToAssessmentFrameHandler();
			Thread.sleep(3000);
			if (bool) {
				Thread.sleep(2000);
				List<WebElement> rationalContinue = driver
						.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
				if (CollectionUtils.isNotEmpty(rationalContinue)) {
					rationalContinue.get(0).sendKeys(Keys.ENTER);
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				}
			}
			// switch to model dialogue
			windowHandler.switchToModalDialog();
			if (flagquestion) {
				completeDialogVerifier();
			}

			// click on view result button
			List<WebElement> btn = baseHandler.findElements(" .button.primary-button.focus-element-flag");
			for (WebElement ele : btn) {
				if (ele.isDisplayed()) {
					ele.click();
					waitUntillLoadingImageIsDisappeared("new-atitesting.pleasewait.bufferLoc");
					break;
				}
			}

			if (flagquestion) {
				viewResultFlag();
			}
			logger.info("takeAssessment Ends");
		} catch (Exception e) {
			throw new DriverException("Unable to take practice Assessment", e);
		}
	}

	/**
	 * This method is used to create practice Assessment
	 * 
	 * @author Sagar.Rao
	 * 
	 * @throws InterruptedException
	 * 
	 * @throws DriverException
	 */
	public void takeAssessment(boolean bool, boolean flagquestion, String complButtonName)
			throws InterruptedException, DriverException {
		logger.info("takeAssessment starts");
		try {
			waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.pleasewait.bufferLoc"));
			switchToAssessmentFrameHandler();
			Thread.sleep(3000);
			if (bool) {
				Thread.sleep(500);
				List<WebElement> rationalContinue = driver
						.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
				if (CollectionUtils.isNotEmpty(rationalContinue)) {
					rationalContinue.get(0).sendKeys(Keys.ENTER);
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				}
			}
			// switch to model dialogue
			windowHandler.switchToModalDialog();
			if (flagquestion) {
				completeDialogVerifier();
			}

			// click on view result button
			// List<WebElement> assessmentCompleteElement =
			// baseHandler.findElements(".modal-section div button");
			List<WebElement> assessmentCompleteElement = baseHandler
					.findElements(".complete-assessment-dialog div button");
			if (CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
				int size = assessmentCompleteElement.size();
				for (int intSize = 0; intSize < size; intSize++) {
					WebElement quizCompElement = assessmentCompleteElement.get(intSize);
					if (quizCompElement.getText().trim().contains(complButtonName)) {
						quizCompElement.click();
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						// waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						// waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						break;
					}
				}
			}

			if (flagquestion) {
				viewResultFlag();
			}
			logger.info("takeAssessment Ends");
		} catch (Exception e) {
			throw new DriverException("Unable to take practice Assessment", e);
		}
	}

	/**
	 * This method is used to create practice Assessment
	 * 
	 * @author Sagar.Rao
	 * 
	 * @throws InterruptedException
	 * 
	 * @throws DriverException
	 */
	public void takeAssessmentQuiz(boolean bool, boolean flagquestion) throws InterruptedException, DriverException {
		logger.info("takeAssessmentQuiz starts");
		try {
			waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.pleasewait.bufferLoc"));
			switchToAssessmentFrameHandler();
			Thread.sleep(3000);

			// code for rationale
			if (bool) {
				Thread.sleep(500);
				List<WebElement> rationalContinue = driver
						.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
				if (CollectionUtils.isNotEmpty(rationalContinue)) {
					rationalContinue.get(0).sendKeys(Keys.ENTER);
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				}
			}
			// switch to model dialogue
			windowHandler.switchToModalDialog();
			if (flagquestion) {
				completeDialogVerifier();
			}

			// click on view result button
			List<WebElement> btn = baseHandler.findElements(" .button.primary-button.focus-element-flag");
			for (WebElement ele : btn) {
				if (ele.getText().equalsIgnoreCase("Finalize and View Results")) {
					if (ele.isDisplayed()) {
						ele.click();
						Thread.sleep(6000);
						// ele.click();
						waitUntillBufferInvisible(
								PropertiesRepository.getString("new-atitesting.pleasewait.bufferLoc"));
						Thread.sleep(1000);
						waitUntillIPPPageIsLoaded(PropertiesRepository.getString("new-atitesting.loading.ipppage.loc"));
						/*
						 * waitUntillElementIsVisible(PropertiesRepository
						 * .getString("new-atitesting.ipppage.header.loc"));
						 */
						break;
					}
				}
			}

			if (flagquestion) {
				viewResultFlag();
			}
			logger.info("takeAssessmentQuiz Ends");
		} catch (Exception e) {
			throw new DriverException("Unable to take practice Assessment", e);
		}
	}

	/**
	 * This method is used to verify the flag button in the assessment page. and
	 * click if click==true author siddharth.roy
	 * 
	 * @throws Exception
	 * @return boolean
	 */
	public boolean verifyFlag(boolean click) throws Exception {

		logger.info("Method:  verifyFlag Starts");
		boolean flag = false;
		try {
			waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.pleasewait.bufferLoc"));

			switchToAssessmentFrameHandler();
			waitUntillElementIsVisible(PropertiesRepository.getString("new-atitesting.generic.tutorial.flag.value"));

			if (baseHandler.isDisplayed(PropertiesRepository.getString("new-atitesting.generic.tutorial.flag.value"))) {
				if (click) {
					waitUntillElementIsVisible(
							PropertiesRepository.getString("new-atitesting.generic.tutorial.flag.value"));
					waitUntillLoadingImageIsDisplayed(2);
					baseHandler
							.findElement(PropertiesRepository.getString("new-atitesting.generic.tutorial.flag.value"))
							.click();
				}
				flag = true;
			}
			switchToAssessmentFrameHandler();
		} catch (Exception e) {
			logger.info("Unable to  verify Flag");
			throw new DriverException("Unable to verify Flag", e);
		}
		logger.info("Method:  verifyFlag End flag --> " + flag);
		windowHandler.switchToLatestWindow();
		return flag;
	}

	public void switchToAssessmentFrameHandler() throws Exception {
		logger.info("switchToAssessmentFrameHandler Start");
		try {
			windowHandler.switchToMainWindow();
			waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.peasewait.bufferLoc"));
			windowHandler.switchToFrame("assessmentFrame");
		} catch (Exception e) {
			logger.info("Unable to switch To Assessment Frame Handler");
			throw new DriverException("Unable to switch To Assessment Frame Handler", e);
		}
		logger.info("Method: switchToAssessmentFrameHandler End ");
	}

	/**
	 * This method is used to wait until buffer invisible
	 * 
	 * @author Saravanan Jothimani
	 */
	public void waitUntillElementIsVisible(String loc) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(loc)));
	}

	public boolean completeDialogVerifier() throws Exception {
		logger.info("Method : completeDialogVerifier -->start");
		boolean flag = false;
		try {
			if (baseHandler.findElement("#CompleteAssessmentDialog div .button.secondary-button") != null
					&& baseHandler.findElement("#CompleteAssessmentDialog div .button.secondary-button") != null
					&& baseHandler.findElement("#CompleteAssessmentDialog div .button.default-button") != null) {
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to verify complete assesment dialog");
			throw new DriverException("Unable to verify the cpomplete aseesment dailog", e);
		}
		logger.info("Method : completeDialogVerifier -->end");
		return flag;

	}

	public boolean viewResultFlag() throws Exception {
		logger.info("Method : viewResultFlag -->start");
		boolean flag = false;
		try {
			windowHandler.switchToModalDialog();
			if (baseHandler
					.findElement("#RevisitFlaggedQuestionDialog button[class='button default-button']") != null) {
				flag = true;
				baseHandler.findElement("#RevisitFlaggedQuestionDialog button[class='button default-button']").click();
				Thread.sleep(2000);
				// click on view result button
				waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.pleasewait.bufferLoc"));
				// windowHandler.switchToModalDialog();
				Thread.sleep(2000);
				buttonHandler.clickButton(PropertiesRepository.getString("new-atitesting.test.view.resultsLoc"));
				// click on view result button
				Thread.sleep(2000);
				waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.pleasewait.bufferLoc"));
				windowHandler.switchToModalDialog();
				buttonHandler.clickButton(
						PropertiesRepository.getString("new-atitesting.generic.contiunuetestcomplete.value"));
			}
		} catch (Exception e) {
			logger.info("Unable to verify complete assesment dialog");
			throw new DriverException("Unable to verify the cpomplete aseesment dailog", e);
		}
		logger.info("Method : viewResultFlag -->end");
		return flag;
	}

	/**
	 * Method used to wait until loading image is displayed. It if takes more
	 * time, increase the count.
	 * 
	 * @author saravanan.jothimani
	 * @param count
	 * @throws Exception
	 */
	public void waitUntillLoadingImageIsDisplayed(int count) throws Exception {
		logger.info("Method: waitUntillLoadingImageIsDisplayed Starts");
		try {
			// Verifying Loading image.
			waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.pleasewait.bufferLoc"));
			List<WebElement> buffecImage = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.pleasewait.bufferLoc"));
			if (CollectionUtils.isNotEmpty(buffecImage)) {
				for (int index = 0; index < count; index++) {
					waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.pleasewait.bufferLoc"));
				}
			}
		} catch (Exception e) {
			logger.info("Unable to wait Untill Loading Image Is Displayed");
			log(logger, "Unable to wait Untill Loading Image Is Displayed");
			throw new DriverException("Unable to wait Untill Loading Image Is Displayed", e);
		}
		logger.info("Method: waitUntillLoadingImageIsDisplayed End ");
	}

	/**
	 * Method used to click on Button with index.
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @param index
	 * @throws Exception
	 */
	public void clickButtonWithSwitchToDefault(String locator, int index) throws Exception {
		logger.info("Method: clickButtonWithSwitchToDefault Starts");
		try {
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			String currentFrame = (String) jsExecutor.executeScript("return self.name");
//			if (!(currentFrame.equalsIgnoreCase("assessmentFrame"))) {
//				windowHandler.switchToFrame("assessmentFrame");
//			}
			List<WebElement> element = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(element)) {
				element.get(index).click();
			}
			waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.pleasewait.bufferLoc"));
			if (baseHandler.findElements("div[class='button-row'] button[aria-label='YES']") != null) {
				baseHandler.findElement("div[class='button-row'] button[aria-label='YES']").sendKeys(Keys.RETURN);
			}
			windowHandler.switchToMainWindow();
		} catch (Exception e) {
			logger.info("Unable to click Button With Switch To Default");
			log(logger, "Unable to click Button With Switch To Default");
			throw new DriverException("Unable to click Button With Switch To Default", e);
		}
		logger.info("Method: clickButtonWithSwitchToDefault End ");
	}

	/**
	 * Method is used to click first PreTest Button based on Module Name in
	 * Nurse Logic Card Back.
	 * 
	 * Begin Test
	 * 
	 * @return
	 * @throws Exception
	 */
	public void clickBeginLessonButtonInNurseLogicCardBack(String moduleName) throws Exception {
		logger.info("Method: clickBeginLessonButtonInNurseLogicCardBack Starts");
		try {
			List<WebElement> allBeginButtonLiElement = baseHandler.findElements(
					PropertiesRepository.getString("new-atitesting.learntab.tutorial.stt.all.card.front.button"));
			if (CollectionUtils.isNotEmpty(allBeginButtonLiElement)) {
				int size = allBeginButtonLiElement.size();
				for (int index = 0; index < size; index++) {
					String moduleNameFromUI = allBeginButtonLiElement.get(index)
							.findElement(By.cssSelector(PropertiesRepository.getString(
									"new-atitesting.learntab.tutorial.skills.module2.card.front.module.name.loc")))
							.getText();
					// Matching Module Name
					if (StringUtils.isNotEmpty(moduleNameFromUI)) {
						if (moduleName.equalsIgnoreCase(moduleNameFromUI)) {
							List<WebElement> singleModuleButtons = allBeginButtonLiElement.get(index)
									.findElements(By.cssSelector(PropertiesRepository.getString(
											"new-atitesting.learntab.tutorial.stt.card.front.module.section1.loc")));
							if (CollectionUtils.isNotEmpty(singleModuleButtons)) {
								singleModuleButtons.get(0)
										.findElement(By.cssSelector(PropertiesRepository.getString(
												"new-atitesting.learntab.tutorial.stt.card.front.begin.lesson.button")))
										.click();
								Thread.sleep(10000);
								waitUntillBufferInvisible(
										PropertiesRepository.getString("new-atitesting.peasewait.bufferLoc"));
								// Verify Continue where you left off windows is
								// displayed.
								if (checkContinueWhereYouLeftOffWindows()) {
									Thread.sleep(10000);
									waitUntillBufferInvisible(
											PropertiesRepository.getString("new-atitesting.peasewait.bufferLoc"));
								}
								break;
							}
						}
					}

				}
			}
		} catch (Exception e) {
			logger.info("Unable to click Begin Lesson Button In Nurse Logic Card Back");
			throw new DriverException("Unable to click Begin Lesson Button In Nurse Logic Card Back", e);
		}
		logger.info("Method: clickBeginLessonButtonInNurseLogicCardBack End ");
	}

	/**
	 * Method is used to verify Continue button is displayed in Continue Where
	 * you left off Window.
	 * 
	 * @author saravanan.jothimani
	 * @return boolean
	 * @throws Exception
	 */
	private boolean checkContinueWhereYouLeftOffWindows() throws Exception {
		logger.info("Method: checkContinueWhereYouLeftOffWindows Starts");
		boolean flag = false;
		try {

			windowHandler.switchToLatestWindow();
			switchToNurseLogicFrame();
			if (baseHandler.isDisplayed(baseHandler.findElement("#TutorialContStartOverDialog section div"))) {
				buttonHandler.clickButton(
						PropertiesRepository.getString(
								"new-atitesting.learntab.tutorial.nurse.logic.continue.where.you.left.off.window.loc"),
						PropertiesRepository.getString("new-atitesting.learntab.quiz.bank.tools.button.loc"));
				flag = true;
			}
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to check Continue Where You Left Of fWindows");
			throw new DriverException("Unable to check Continue Where You Left Of fWindows", e);
		}
		logger.info("Method: checkContinueWhereYouLeftOffWindows End flag --> " + flag);
		return flag;
	}

	/**
	 * Method is used to switch to STT Frame.
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	private void switchToNurseLogicFrame() throws Exception {
		logger.info("switchToNurseLogicFrame Start");
		try {
			windowHandler.switchToFrame("tutorialFrame");
		} catch (Exception e) {
			logger.info("Unable to switch To STT Frame");
			throw new DriverException("Unable to switch To STT Frame", e);
		}
		logger.info("Method: switchToNurseLogicFrame End ");
	}

	public void clickButtonFromList(String loc, int index) throws Exception {
		logger.info("clickButtonFromList Start ");
		try {
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			List<WebElement> elements = baseHandler.findElements(PropertiesRepository.getString(loc));
			if (CollectionUtils.isNotEmpty(elements)) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elements.get(index));
				driverWait.until(ExpectedConditions.visibilityOf(elements.get(index)));
				elements.get(index).click();
			}
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		} catch (Exception e) {
			logger.info("Unable to clickButtonFromList");
			log(logger, "Unable to clickButtonFromList");
			throw new DriverException("Unable to clickButtonFromList", e);
		}
		logger.info("clickButtonFromList End");
	}

	/** wait until element is visible */
	public void expWaitVisibilityofElement(String str) throws InterruptedException {

		WebDriverWait w = new WebDriverWait(driver, 20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(str)));
	}

	/**
	 * This method is used wait until IPP page is loaded.
	 * 
	 * @author Abhishek Kumar
	 * @throws InterruptedException
	 */
	public void waitUntillIPPPageIsLoaded(String loc) throws Exception {
		logger.info("Method: waitUntillIPPPageIsLoaded Starts");
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(loc)));
			driver.navigate().refresh();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(loc)));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(loc)));

		} catch (Exception e) {
			logger.info("Unable to wait Untill Loading Image Is not Disappeared");
			log(logger, "Unable to wait Untill Loading Image Is not Disappeared");
			throw new DriverException("Unable to wait Untill Loading Image Is not Disappeared", e);
		}
		logger.info("waitUntillIPPPageIsLoaded End");
	}

	/**
	 * Method is used to complete Test
	 * 
	 * breakFlag If assessment has to be stopped in middle.
	 * 
	 * rationaleFlag Need to check for Rationale and My Answer.
	 * 
	 * @param bool
	 * @param breakFlag
	 * @param rationaleFlag
	 * @throws Exception
	 */
	public void takeTest() throws Exception {
		logger.info("Method : takeTest :::::::: Starts");
		try {

			// waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			windowHandler.switchToFrame("assessmentFrame");
			// Getting Total Question Number
			String maxQtnTextNo = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.question.number.loc")).get(1)
					.getText();

			// Convert String to Integer
			int maxCount = Integer.parseInt(maxQtnTextNo);

			// Getting Current Question Number
			String minQtnTextNo = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.question.number.loc")).get(0)
					.getText();

			// Convert String to Integer
			int minCount = Integer.parseInt(minQtnTextNo);

			// Maximum Question minus Minimum Questions
			int count = maxCount - minCount;

			for (int i = 0; i <= count; i++) {

				List<WebElement> checkBoxElement = baseHandler.findElements(
						PropertiesRepository.getString("new-atitesting.generic.tutorial.checkbox.new.loc"));
				List<WebElement> radioElement = baseHandler.findElements(
						PropertiesRepository.getString("new-atitesting.generic.tutorial.radio.button.new.loc"));

				if (checkBoxElement != null) {
					checkBoxElement.get(0).click();
					checkBoxElement.get(1).click();
				}

				if (driver
						.findElements(By.cssSelector(
								".answer-fill-in-the-blank.numericTextEntry.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty"))
						.size() > 0) {
					verifyFillForm("10");

				}

				if (CollectionUtils.isNotEmpty(baseHandler.findElements(
						PropertiesRepository.getString("new-atitesting.generic.tutorial.dragbox1.loc")))) {
					DragAndDropAnswer(false);
				}

				if (CollectionUtils.isNotEmpty(radioElement) && radioElement.size() > 0) {
					radioElement.get(0).click();
				}

				if (CollectionUtils.isNotEmpty(
						baseHandler.findElements(PropertiesRepository.getString("new-atitesting.question.img.loc")))) {
					hotSpotQuestion();
				}

				if (i == count) {
					if (!driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"))
							.isSelected()) {
						{
							driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"))
									.sendKeys(Keys.ENTER);
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
							// clickButton(".button.primary-button.focus-element-flag",1);
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
							return;
						}
					} else {
						driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"))
								.sendKeys(Keys.ENTER);
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						clickButton(".button.primary-button.focus-element-flag", 1);
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						List<WebElement> list = baseHandler.findElements(PropertiesRepository
								.getString("new-atitesting.learntab.tutorial.flagged.items.continue.button"));
						if (list != null) {
							clickButton(PropertiesRepository
									.getString("new-atitesting.learntab.tutorial.flagged.items.continue.button"));
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						}
						return;

					}
				} else {
					if (i == 0) {
						try {
							buttonHandler.clickButton(
									PropertiesRepository.getString("new-atitesting.learntab.tutorial.flag.button"));
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
							if (driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"))
									.isEnabled()) {
								buttonHandler.clickButton(PropertiesRepository
										.getString("new-atitesting.learntab.tutorial.continue.button"));
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
							}
						} catch (Exception e) {
							logger.info("unable to click the button" + e);
							throw new DriverException("unable to click the button", e);
						}
					} else {
						driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"))
								.sendKeys(Keys.ENTER);
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"))
								.sendKeys(Keys.ENTER);
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
					}

				}
			}
		} catch (Exception e) {
			logger.info("Unable to take the assessment");
			log(logger, "Unable to take the assessment");
			throw new DriverException("Unable to take the assessment", e);
		}
	}

	/**
	 * Method used to verify an element is available in DOM or not.
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @return
	 * @throws Exception
	 */
	public boolean verifyElement(String locator) throws Exception {
		logger.info("Method: verifyElement Starts");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(element) && element.size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to verify Element");
			log(logger, "Unable to verify Element");
			throw new DriverException("Unable to verify Element", e);
		}
		logger.info("Method: verifyElement End flag --> " + flag);
		return flag;
	}

	
	/**
	 * Method used to verify an element is available in DOM or not.
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @return
	 * @throws Exception
	 */
	public boolean verifyElement(String locator, int index) throws Exception {
		//logger.info("Method: verifyElement Starts");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(element) && element.size() > 0 && element.get(index).isDisplayed()) {
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to verify Element");
			log(logger, "Unable to verify Element");
			throw new DriverException("Unable to verify Element", e);
		}
		logger.info("Method: verifyElement End flag --> " + flag);
		return flag;
	}
	/**
	 * Method is used to click on Close button.
	 * 
	 */
	public void clickClose(String... waitFor) throws DriverException {
		logger.info("clickClose Starts");
		try {
			windowHandler.switchToMainWindow();
			// if(baseHandler.isDisplayed(we))
			baseHandler.waitToBeDisplayed(
					PropertiesRepository.getString("new-atitesting.homepage.myatitab.viewactlrntmplt.closepdf.loc"));

			buttonHandler.clickButton(
					PropertiesRepository.getString("new-atitesting.homepage.myatitab.viewactlrntmplt.closepdf.loc"),
					true);
			waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.peasewait.bufferLoc"));
		} catch (DriverException e) {
			throw new DriverException("Unable to click on Tutorial Close button", e);
		}

		logger.info("clickClose End");
	}

	/**
	 * Method used to create directory
	 * 
	 * @author saravanan.jothimani
	 * @param directoryName
	 * @return
	 * @throws Exception
	 */
	public boolean createDirectory(String directoryName) throws Exception {
		logger.info("createDirectory Start");
		boolean flag = false;
		try {
			File directory = new File(directoryName);
			if (directory.exists() && directory.isFile()) {
				System.out.println("The dir with name could not be" + " created as it is a normal file");
			} else {
				if (!directory.exists()) {
					directory.mkdir();
				}
			}
		} catch (Exception e) {
			throw new DriverException("Unable to createDirectory", e);
		}
		logger.info("createDirectory End");
		return flag;
	}

	public boolean verifyFileExists(String downloadFilepath) throws Exception {
		logger.info("verifyFileExists Start ");
		boolean flag = false;
		try {
			// Navigation to folder to verify
			File f = new File(downloadFilepath);
			File[] fileName = f.listFiles();
			if (fileName != null) {
				if (fileName[0].getName().equalsIgnoreCase("Report.pdf")) {
					flag = true;
				}
			}
		} catch (Exception e) {
			throw new DriverException("Unable to verifyFileExists", e);
		}
		logger.info("verifyFileExists End flag --> " + flag);
		return flag;
	}

	public boolean deleteFileExists(String downloadFilepath) throws Exception {
		logger.info("deleteFileExists Start");
		boolean flag = false;
		try {
			File f = new File(downloadFilepath);
			File[] fileName = f.listFiles();
			for (File listFile : fileName) {
				listFile.delete();
			}
		} catch (Exception e) {
			throw new DriverException("Unable to deleteFileExists", e);
		}
		logger.info("deleteFileExists Start");
		return flag;
	}

	/*
	 * public boolean deleteFileExists(String downloadFilepath) throws Exception
	 * { logger.info("deleteFileExists Start"); boolean flag = false; try { File
	 * f = new File(downloadFilepath); flag = Files.deleteIfExists(f.toPath());
	 * 
	 * } catch(Exception e) { throw new
	 * DriverException("Unable to deleteFileExists", e); }
	 * logger.info("deleteFileExists Start"); return flag; }
	 */
	/**
	 * Method used to delete after verifying the folder.
	 * 
	 * @author saravanan.jothimani
	 * @param downloadFilepath
	 * @param projectPath
	 * @param currMillSec
	 * @throws Exception
	 */
	public boolean deleteFolder(String downloadFilepath, String projectPath, String currMillSec) throws Exception {
		boolean flag = false;
		try {
			flag = verifyFileExists(downloadFilepath);

			/*
			 * if (flag) { File deleteFolder = new File(projectPath); if
			 * (deleteFolder != null) { File[] filesList =
			 * deleteFolder.listFiles(); for (File listFile : filesList) { if
			 * (listFile.isDirectory()) { if
			 * (listFile.getName().equalsIgnoreCase(currMillSec)) {
			 * listFile.delete(); break; } } } } }
			 */
		} catch (Exception e) {
			System.out.println("Exception while deleting");
		}
		return flag;
	}

	/**
	 * Method is to click on close button from product information
	 * 
	 * @throws Exception
	 */

	public void clikButtonUsingJavaScript(String locator) throws Exception {
		logger.info("Method: clikButtonUsingJavaScript start");
		try {
			List<WebElement> elements = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(elements)) {
				baseHandler.clickByJavascript(elements.get(0));
			}
		} catch (Exception e) {
			logger.info("unable to clikButtonUsingJavaScript");
			throw new Exception("unable to clikButtonUsingJavaScript");
		}
		logger.info("Method: clikButtonUsingJavaScript End ");

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
	public boolean verifyAndClick(String locator, boolean click) throws NullPointerException, DriverException {
		logger.info("Method: verifyAndClick Starts");
		boolean flag = false;
		windowHandler.switchToLatestWindow();
//		locator = "section[class='end-assessment-confirm-dialog'] button";
		try {
			List<WebElement> element = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(element)) {
				if (click) {
					element.get(0).click();
				}
				flag = true;
			}
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to verifyAndClick");
			log(logger, "Unable to verifyAndClick");
			throw new DriverException("Unable to verifyAndClick", e);
		}
		logger.info("Method: verifyAndClick End flag --> " + flag);
		return flag;
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
	public boolean verifyAndClickWithList(String locator, int index, boolean click)
			throws NullPointerException, DriverException {
		logger.info("Method: verifyAndClickWithList Starts");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(element)) {
				if (click) {
					element.get(index).click();
				}
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to verifyAndClickWithList");
			log(logger, "Unable to verifyAndClickWithList");
			throw new DriverException("Unable to verifyAndClickWithList", e);
		}
		logger.info("Method: verifyAndClickWithList End flag --> " + flag);
		return flag;
	}

	/**
	 * This method is used to answer drag and drop question
	 * 
	 * @author siddharth roy
	 * @change Vishal Small change has been done for the locator in clickButton
	 *         method below, as the previous method DragAndDropAnswer() (above)
	 *         was not moving any box.
	 * @return boolean
	 * @throws DriverException
	 */
	public void DragAndDropAnswerNew(boolean stop) throws Exception {
		logger.info("DragAndDropAnswer Start");
		try {
			waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.pleasewait.bufferLoc"));
			logger.info("Method : DragAndDropAnswer :::::::: start ");
			Actions act = new Actions(driver);
			boolean breakflag = false;

			switchToAssessmentFrameHandler();
			int tot = baseHandler
					.findElement(PropertiesRepository.getString("new-atitesting.generic.tutorial.dragbox1.loc"))
					.findElements(
							By.cssSelector(PropertiesRepository.getString("new-atitesting.generic.draganddrop.loc")))
					.size();
			if (baseHandler
					.isDisplayed(PropertiesRepository.getString("new-atitesting.generic.tutorial.dragbox1.loc"))) {

				while (baseHandler
						.findElement(PropertiesRepository.getString("new-atitesting.generic.tutorial.dragbox2.loc"))
						.findElements(By
								.cssSelector(PropertiesRepository.getString("new-atitesting.generic.draganddrop.loc")))
						.size() != tot) {
					if (breakflag) {
						break;
					}
					List<WebElement> btn = baseHandler
							.findElement(PropertiesRepository.getString("new-atitesting.generic.tutorial.dragbox1.loc"))
							.findElements(By.cssSelector(
									PropertiesRepository.getString("new-atitesting.generic.draganddrop.loc")));
					for (int i = 0; i < btn.size(); i++) {
						try {
							wait.until(ExpectedConditions.elementToBeClickable(btn.get(i)));
							WebElement toElement = baseHandler.findElement(
									PropertiesRepository.getString("new-atitesting.generic.tutorial.dragbox2.loc"));
							if (breakflag) {
								break;
							}

							org.openqa.selenium.interactions.Action atc2 = act.clickAndHold(btn.get(i))
									.moveToElement(toElement).release(toElement).build();
							buttonHandler.clickButton(
									PropertiesRepository.getString("new-atitesting.generic.tutorial.dragbox2.loc"));
							atc2.perform();
							if (i + 1 == tot) {
								breakflag = true;
							}
							Thread.sleep(1000);
						} catch (StaleElementReferenceException e) {
							logger.info("element in stale state countiniuing");
						}
					}
				}
			}
		}

		catch (Exception e) {
			throw new DriverException("Unable to Drag And Drop Answer", e);

		}
		windowHandler.switchToLatestWindow();
		logger.info("Method:  DragAndDropAnswer End --> ");
	}

	/**
	 * This method is used to select an option after the practice Assessment is
	 * completed
	 * 
	 * @author Sagar.Rao
	 * @change Vishal
	 * @throws InterruptedException
	 * 
	 * @throws DriverException
	 */
	public boolean takeAssessmentVerifySectionNew(boolean bool, boolean flagquestion, String complButtonName)
			throws InterruptedException, DriverException {
		logger.info("takeAssessmentVerifySectionNew starts");
		boolean flag = false;
		try {
			waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.peasewait.bufferLoc"));
			switchToAssessmentFrameHandler();
			Thread.sleep(5000);
			if (bool) {
				Thread.sleep(2000);
				List<WebElement> rationalContinue = driver
						.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
				if (CollectionUtils.isNotEmpty(rationalContinue)) {
					rationalContinue.get(0).sendKeys(Keys.ENTER);
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
					Thread.sleep(2000);
				}
			}
			// switch to model dialogue
			windowHandler.switchToModalDialog();
			if (flagquestion) {
				completeDialogVerifier();
			}

			// click on view result button
			List<WebElement> assessmentCompleteElement = baseHandler.findElements(".modal-section div button");
			if (CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
				int size = assessmentCompleteElement.size();
				for (int intSize = 0; intSize < size; intSize++) {
					WebElement quizCompElement = assessmentCompleteElement.get(intSize);
					if (quizCompElement.getText().trim().contains(complButtonName)) {
						Thread.sleep(2000);
						quizCompElement.click();
						Thread.sleep(7000);
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						flag = true;
						break;
					}
				}
			}
		} catch (Exception e) {
			throw new DriverException("Unable to take practice Assessment", e);
		}
		logger.info("takeAssessmentVerifySectionNew Ends flag --> " + flag);
		return flag;
	}

	/**
	 * This method is used to identify the hotspot question.
	 * 
	 * @author siddharth roy
	 * @change Vishal Small change has been done for the locator in clickButton
	 *         method below, as the previous method hotSpotQuestion() (above)
	 *         was not selecting any box.
	 * @return boolean
	 * @throws DriverException
	 */
	public boolean hotSpotQuestionNew() throws Exception {
		boolean flag = false;
		try {
			logger.info("Method : hotSpotQuestion :::::::: start ");
			switchToAssessmentFrameHandler();

			if (baseHandler.isDisplayed(PropertiesRepository.getString("new-atitesting.question.img.loc"))) {
				buttonHandler.clickButton(PropertiesRepository.getString("new-atitesting.question.new.img.answer.loc"));
			}
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			throw new DriverException("Unable to Verify Submit Disabled", e);
		}
		windowHandler.switchToLatestWindow();
		logger.info("Method:  hotSpotQuestion End --> " + flag);
		return flag;
	}

	/**
	 * @author Sanapati.Srinu
	 * @param loc
	 * @return boolean
	 * @throws DriverException
	 */
	public boolean isElementDisplayed(String loc) throws DriverException {
		logger.info("Method: isElementDisplayed Start ");
		try {
			WebElement findElement = baseHandler.findElement(PropertiesRepository.getString(loc));
			if (findElement != null) {
				return findElement.isDisplayed();
			}

		} catch (Exception e) {
			throw new DriverException("element is not visible", e);
		}

		logger.info("Method: isElementDisplayed End");
		return false;
	}

	/**
	 * Method used to enable/disable practice assessments
	 * 
	 * @author Vaishali.Katta
	 */
	public void clickHideDisabledProducts() throws DriverException {
		logger.info("clickHideDisabledProducts Start");
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.cssSelector(PropertiesRepository.getString("new-atitesting.home.hide.checkbox"))));
			driver.findElement(By.cssSelector(PropertiesRepository.getString("new-atitesting.home.hide.checkbox")))
					.click();
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			Thread.sleep(2000);
		} catch (Exception e) {
			throw new DriverException("Unable to enable and disable assessment", e);
		}
		logger.info("clickHideDisabledProducts End ");
	}

	/**
	 * @author Vaishali.Katta
	 */
	public boolean verifyAssessmentCardEnabledInTestTab(String assessmentName, String button, boolean enable)
			throws DriverException {
		logger.info("Method: VerifyAssessmentCardEnabledInTestTab Start");
		String loc1 = "#tabs-2 .card.practice-assessment:contains('" + assessmentName
				+ "') div:nth-child(1) .button:contains('" + button + "')";
		String loc2 = "#tabs-2 .disabled-background-tab2:contains('" + assessmentName + "') .disabled-message+a+a";
		boolean flag = false;
		try {
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			wait.until(ExpectedConditions.invisibilityOfElementLocated(
					By.cssSelector(PropertiesRepository.getString("new-atitesting.home.test.tab.message"))));
			if (enable) {
				wait.until(ExpectedConditions.visibilityOf(sizzleSelector.findElementBySizzleCss(driver, loc1)));
				flag = sizzleSelector.findElementBySizzleCss(driver, loc1).isDisplayed();
			} else {
				wait.until(ExpectedConditions.visibilityOf(sizzleSelector.findElementBySizzleCss(driver, loc1)));
				wait.until(ExpectedConditions.visibilityOf(sizzleSelector.findElementBySizzleCss(driver, loc2)));
				flag = sizzleSelector.findElementBySizzleCss(driver, loc1).isDisplayed()
						&& sizzleSelector.findElementBySizzleCss(driver, loc2).isDisplayed();
			}
		} catch (Exception e) {
			throw new DriverException("Assessment card is not visible", e);
		}

		logger.info("Method: VerifyAssessmentCardEnabledInTestTab End");
		return flag;
	}

	/**
	 * This method is used to identify the hotspot question.
	 * 
	 * @author siddharth roy
	 * @change Vishal Small change has been done for the locator in clickButton
	 *         method below, as the previous method hotSpotQuestion() (above)
	 *         was not selecting any box.
	 * @return boolean
	 * @throws DriverException
	 */
	public boolean hotSpotQuestionNew(String loc) throws Exception {
		boolean flag = false;
		try {
			logger.info("Method : hotSpotQuestion :::::::: start ");
			switchToAssessmentFrameHandler();

			if (baseHandler.isDisplayed(PropertiesRepository.getString("new-atitesting.question.img.loc"))) {
				buttonHandler.clickButton(PropertiesRepository.getString(loc));
				flag = true;
			}
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			throw new DriverException("Unable to Verify Submit Disabled", e);
		}
		windowHandler.switchToLatestWindow();
		logger.info("Method:  hotSpotQuestion End --> " + flag);
		return flag;
	}

	/**
	 * This method is used to create practice Assessment
	 * 
	 * @author Sagar.Rao
	 * 
	 * @throws InterruptedException
	 * 
	 * @throws DriverException
	 */
	public boolean clickModalPopUp(boolean bool, boolean flagquestion, String complButtonName)
			throws InterruptedException, DriverException {
		logger.info("clickModalPopUp starts");
		boolean flag = false;
		try {
			waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.pleasewait.bufferLoc"));
			switchToAssessmentFrameHandler();
			Thread.sleep(3000);
			if (bool) {
				Thread.sleep(500);
				List<WebElement> rationalContinue = driver
						.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
				if (CollectionUtils.isNotEmpty(rationalContinue)) {
					rationalContinue.get(0).sendKeys(Keys.ENTER);
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				}
			}
			// switch to model dialogue
			windowHandler.switchToModalDialog();
			if (flagquestion) {
				completeDialogVerifier();
			}

			// click on view result button
			List<WebElement> assessmentCompleteElement = baseHandler.findElements(".modal-section div button");
			if (CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
				int size = assessmentCompleteElement.size();
				for (int intSize = 0; intSize < size; intSize++) {
					WebElement quizCompElement = assessmentCompleteElement.get(intSize);
					if (quizCompElement.getText().trim().contains(complButtonName)) {
						quizCompElement.click();
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						flag = true;
						break;
					}
				}
			}

			if (flagquestion) {
				viewResultFlag();
			}
			logger.info("clickModalPopUp Ends  -> " + flag);
		} catch (Exception e) {
			throw new DriverException("Unable to click buttons of the modal pop up after practice Assessment ", e);
		}
		return flag;
	}

	/**
	 * Method used to move focus to the locator provided in parameter.
	 * 
	 * @param locator
	 * @throws Exception
	 */
	public void moveToElementUsingJavaScript(String locator) throws Exception {
		logger.info("Method : moveToElementUsingJavaScript");
		try {
			List<WebElement> element = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(element)) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element.get(0));
			}
		} catch (Exception e) {
			logger.info("Unable to moveToElementUsingJavaScript");
			log(logger, "Unable to moveToElementUsingJavaScript");
			throw new DriverException("Unable to moveToElementUsingJavaScript", e);
		}
		logger.info("Method: moveToElementUsingJavaScriptEnd ");
	}

	/**
	 * Method used to verify Assessment header/ module name in Assessment Page.
	 * 
	 * @author saravanan.jothimani
	 * @param index
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public boolean verifyAssessmentHeader(int index, String value) throws Exception {
		logger.info("Method : verifyAssessmentHeader Start");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.learntab.tutorial.name.value"));
			if (CollectionUtils.isNotEmpty(element) && element.size() > 0) {
				String nameInPage = element.get(index).getText().trim();
				if (StringUtils.isNotBlank(nameInPage) && nameInPage.equalsIgnoreCase(value)) {
					flag = true;
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verifyAssessmentHeader ");
			log(logger, "Unable to verifyAssessmentHeader");
			throw new DriverException("Unable to verifyAssessmentHeader", e);
		}
		logger.info("Method: verifyAssessmentHeader End flag --> " + flag);
		return flag;
	}

	/**
	 * Method used to verify text when break tags are involved.
	 * 
	 * @author Vishal.r
	 * @param loc
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public boolean verifyTextWithBreak(String loc, int index, String value) throws Exception {
		logger.info("Method : verifyTextWithBreak Start");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(loc);
			if (CollectionUtils.isNotEmpty(element) && element.size() > 0) {
				if (element.get(index).getText().replaceAll("\\r\\n|\\r|\\n", " ").equalsIgnoreCase(value)) {
					flag = true;
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verifyTextWithBreak ");
			log(logger, "Unable to verifyTextWithBreak");
			throw new DriverException("Unable to verifyTextWithBreak", e);
		}
		logger.info("Method: verifyTextWithBreak End flag --> " + flag);
		return flag;
	}

	/**
	 * This method verifies the presence of the download file with name as a
	 * parameter of the file download.
	 * 
	 * @param downloadFilepath
	 * @param fName
	 * @return
	 * @throws Exception
	 */
	public boolean verifyFileExists(String downloadFilepath, String fName) throws Exception {
		logger.info("verifyFileExists Start ");
		boolean flag = false;
		try {
			// Navigation to folder to verify
			File f = new File(downloadFilepath);
			File[] fileName = f.listFiles();
			if (fileName != null) {
				if (fileName[0].getName().equalsIgnoreCase(fName)) {
					flag = true;
				}
			}
		} catch (Exception e) {
			throw new DriverException("Unable to verifyFileExists", e);
		}
		logger.info("verifyFileExists End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to verify header name in card back.
	 * 
	 * @author saravanan.jothimani
	 * @param cardBackName
	 * @return
	 * @throws Exception
	 */

	public boolean verifyCardBackHeaderSection(String locator, String cardBackName) throws Exception {
		logger.info("Method : verifyCardBackHeaderSection Start");
		logger.info("cardBackName value --> " + cardBackName);
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(element) && element.get(0).getText().trim().equalsIgnoreCase(cardBackName)) {
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to verifyCardBackHeaderSection");
			log(logger, "Unable to verifyCardBackHeaderSection");
			throw new DriverException("Unable to verifyCardBackHeaderSection", e);
		}
		logger.info("Method: verifyCardBackHeaderSection End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Used to verify message
	 * 
	 * @author prasanna.gogineni
	 * @param locator
	 * @throws Exception
	 */
	public boolean verifyMessageWithSwitchToAssessmentFrame(String locator, int index, String value) throws DriverException {
		logger.info("verifyMessageWithSwitchToAssessmentFrame Start ");
		logger.info("Locator value --> " + locator);
		logger.info("index value --> " + index);
		logger.info("value --> " + value);
		boolean flag = false;
		try {
			switchToAssessmentFrameHandler();
			List<WebElement> element = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(element) && element.size() > 0) {
				if (value.equalsIgnoreCase(element.get(index).getText().trim())) {
					flag = true;
				}
			} else {
				logger.info("Unable to find elements for message verification");
			}
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to verifyMessageWithSwitchToAssessmentFrame");
			log(logger, "Unable to verifyMessageWithSwitchToAssessmentFrame");
			throw new DriverException("Unable to verifyMessageWithSwitchToAssessmentFrame", e);
		}
		logger.info("verifyMessageWithSwitchToAssessmentFrame End flag -->" + flag);
		return flag;
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
	public boolean verifyAndClickWithSwitchToAssessmentFrame(String locator, boolean click) throws NullPointerException, DriverException {
		logger.info("Method: verifyAndClickWithSwitchToAssessmentFrame Starts");
		boolean flag = false;
		locator = "div[class='back-button-container'] button";
		try {
			switchToAssessmentFrameHandler();
			List<WebElement> element = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(element)) {
				if (click) {
					element.get(0).click();
				}
				flag = true;
			}
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to verifyAndClickWithSwitchToAssessmentFrame");
			log(logger, "Unable to verifyAndClickWithSwitchToAssessmentFrame");
			throw new DriverException("Unable to verifyAndClickWithSwitchToAssessmentFrame", e);
		}
		logger.info("Method: verifyAndClickWithSwitchToAssessmentFrame End flag --> " + flag);
		return flag;
	}
}
