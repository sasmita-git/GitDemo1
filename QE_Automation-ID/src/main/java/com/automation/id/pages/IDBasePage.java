package com.automation.id.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.ButtonHandler;
import com.ascendlearning.automation.ui.handlers.TextHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;
import com.ascendlearning.automation.ui.page.BasePage;

public class IDBasePage extends BasePage {

	private Logger logger = LogManager.getLogger(this.getClass());
	protected BaseHandler baseHandler;
	protected WindowHandler windowHandler;
	protected TextHandler textHandler;
	protected WebDriverWait wait;

	public IDBasePage(WebDriver webDriver) {
		super(webDriver);
		baseHandler = new BaseHandler(driver);
		windowHandler = new WindowHandler(driver);
		textHandler = new TextHandler(driver);
		wait = new WebDriverWait(driver, 120);
	}

	/**
	 * Method used to verify Element is present in DOM.
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @return
	 * @throws DriverException
	 */
	public WebElement verifyElement(String locator) throws DriverException {
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
	public void waitUntillLoadingImageIsDisappeared(String loc) throws DriverException {
		logger.info("Method: waitUntillLoadingImageIsDisappeared Starts");
		long startTime = System.currentTimeMillis();
		try {
			List<WebElement> buffecImage = baseHandler.findElements(loc);
			try {
				if (CollectionUtils.isNotEmpty(buffecImage)) {

					while ((String.valueOf(buffecImage.size()) != null)
							&& ((System.currentTimeMillis() - startTime) < 120000)) {
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

				}
			} catch (Exception e) {
				logger.info("Error while handling loading image");
				// waitUntillOverlayImageIsDisappeared("new-atitesting.peasewait.bufferLoc1");
				if (!((System.currentTimeMillis() - startTime) < 120000)) {
					logger.info("Waited 120 seconds to load the page");
					throw new DriverException("Unable to wait Untill Loading Image Is not Disappeared", e);
				} else {
					logger.info("Page load complete");
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
	 * This method is used to wait until the buffer image is completely load.
	 * 
	 * @author Sanapati.Srinu
	 * @param loc
	 * @throws Exception
	 */
	public boolean verifyWaitUntillLoadingImageIsDisappeared(String loc) throws DriverException {
		logger.info("Method: waitUntillLoadingImageIsDisappeared Starts");
		boolean flag = false;
		long startTime = System.currentTimeMillis();
		try {
			List<WebElement> buffecImage = baseHandler.findElements(loc);
			try {
				if (CollectionUtils.isNotEmpty(buffecImage)) {

					while ((String.valueOf(buffecImage.size()) != null)
							&& ((System.currentTimeMillis() - startTime) < 120000)) {
						logger.info("page is still loading after click on the element");
						logger.info("Wait Counter in Seconds >>>> "
								+ (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - startTime)));
						buffecImage = baseHandler.findElements(loc);
						flag = true;
					}
					if (!((System.currentTimeMillis() - startTime) < 120000)) {
						logger.info("Waited 120 seconds to load the page");
						throw new DriverException("Unable to wait Untill Loading Image Is not Disappeared");
					} else {
						logger.info("Page load complete");
					}
					// waitUntillOverlayImageIsDisappeared("new-atitesting.peasewait.bufferLoc1");

				}
			} catch (Exception e) {
				logger.info("Error while handling loading image");
				// waitUntillOverlayImageIsDisappeared("new-atitesting.peasewait.bufferLoc1");
				if (!((System.currentTimeMillis() - startTime) < 120000)) {
					logger.info("Waited 120 seconds to load the page");
					throw new DriverException("Unable to wait Untill Loading Image Is not Disappeared", e);
				} else {
					logger.info("Page load complete");
				}
			}
		} catch (Exception e) {
			logger.info("Unable to wait Untill Loading Image Is not Disappeared");
			log(logger, "Unable to wait Untill Loading Image Is not Disappeared");
			throw new DriverException("Unable to wait Untill Loading Image Is not Disappeared", e);
		}
		logger.info("waitUntillLoadingImageIsDisappeared End flag --> " + flag);
		return flag;
	}

	/**
	 * This method is used to wait until the buffer image is completely load.
	 * 
	 * @author Sanapati.Srinu
	 * @param loc
	 * @throws Exception
	 */

	public void waitUntillLoadingImageIsAppeared(String loc) throws DriverException {
		logger.info("Method: waitUntillLoadingImageIsAppeared Starts");
		long startTime = System.currentTimeMillis();
		try {
			List<WebElement> buffecImage = baseHandler.findElements(loc);
			try {

				while (buffecImage == null && ((System.currentTimeMillis() - startTime) < 120000)) {
					logger.info("page is still loading after click on the element");
					buffecImage = baseHandler.findElements(loc);
				}
			} catch (Exception e) {
				logger.info("page is loaded successfully");
			}

		} catch (Exception e) {
			logger.info("Unable to wait Untill Loading Image Is not Disappeared");
			log(logger, "Unable to wait Untill Loading Image Is not Disappeared");
			throw new DriverException("Unable to wait Untill Loading Image Is not Disappeared", e);
		}
		logger.info("waitUntillLoadingImageIsAppeared End");
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
		try {
			WebElement element = verifyElement(locator);
			if (element != null) {
				if (click) {
					// element.click();
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", element);
					waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				}
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to verifyAndClick");
			log(logger, "Unable to verifyAndClick");
			throw new DriverException("Unable to verifyAndClick", e);
		}
		logger.info("Method: verifyAndClick End flag --> " + flag);
		return flag;
	}

	public boolean verifyText(String locator, int index, String value) throws NullPointerException, DriverException {
		logger.info("Method: verifyText Starts");
		boolean flag = false;
		try {
			WebElement element = verifyElement(locator);
			if (element != null) {
				String text = element.getText();
				if (value.equalsIgnoreCase(text)) {
					flag = true;
				}

			}
		} catch (Exception e) {
			logger.info("Unable to verifyText");
			log(logger, "Unable to verifyText");
			throw new DriverException("Unable to verifyAndClick", e);
		}
		logger.info("Method: verifyText End flag --> " + flag);
		return flag;
	}

	public boolean verifyAndClickswitchToCardShadowFrame(String locator, boolean click)
			throws NullPointerException, DriverException {
		logger.info("Method: verifyAndClickswitchToCardShadowFrame Starts");
		boolean flag = false;
		try {
			switchToCardShadowFrame();
			WebElement element = verifyElement(locator);
			if (element != null) {
				if (click) {
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", element);
				}
				flag = true;
			}
			windowHandler.switchToLatestWindow();
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to verifyAndClickswitchToCardShadowFrame");
			log(logger, "Unable to verifyAndClickswitchToCardShadowFrame");
			throw new DriverException("Unable to verifyAndClickswitchToCardShadowFrame", e);
		}
		logger.info("Method: verifyAndClickswitchToCardShadowFrame End flag --> " + flag);
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
	public boolean verifyAndClickWithoutWait(String locator, boolean click)
			throws NullPointerException, DriverException {
		logger.info("Method: verifyAndClickWithoutWait Starts");
		boolean flag = false;
		try {
			WebElement element = verifyElement(locator);
			if (element != null) {
				if (click) {
					element.click();
				}
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to verifyAndClickWithoutWait");
			log(logger, "Unable to verifyAndClickWithoutWait");
			throw new DriverException("Unable to verifyAndClickWithoutWait", e);
		}
		logger.info("Method: verifyAndClickWithoutWait End flag --> " + flag);
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
	public boolean verifyToastMessage(String locator, String value) throws NullPointerException, DriverException {
		logger.info("Method: verifyToastMessage Starts");
		boolean flag = false;
		try {
			windowHandler.switchToLatestWindow();
			List<WebElement> element = baseHandler.findElements(locator);
			if (element != null) {
				element.get(0).click();
				List<WebElement> toastElement = baseHandler
						.findElements(PropertiesRepository.getString("id.home.email.toast.message.loc"));
				if (toastElement != null) {
					if (toastElement.get(0).getText().trim().equalsIgnoreCase(value)) {
						flag = true;
					}
				}
			}
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to verifyToastMessage");
			log(logger, "Unable to verifyToastMessage");
			throw new DriverException("Unable to verifyToastMessage", e);
		}
		logger.info("Method: verifyToastMessage End flag --> " + flag);
		return flag;
	}

	/**
	 * This method will verify "please select a class" message
	 * 
	 * @author Syed.Hoque
	 * @throws DriverException
	 */
	public boolean verifySelectClassTosterMessage() throws DriverException {
		logger.info("Method: verifySelectClassTosterMessage Starts");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("id.home.page.proctor.left.navigator.icon.link"));
			if (CollectionUtils.isNotEmpty(element)) {
				// int size = element.size();
				element.get(1).click();

				List<WebElement> tostermessage = baseHandler
						.findElements(PropertiesRepository.getString("toaster.message"));
				if (tostermessage != null) {
					flag = true;
				}
			}
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to verifySelectClassTosterMessage");
			log(logger, "Unable to verifySelectClassTosterMessage");
			throw new DriverException("Unable to verifySelectClassTosterMessage", e);
		}
		logger.info("Method: verifySelectClassTosterMessage End flag --> " + flag);
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
	public boolean verifyAndClickWithSwitch(String locator, boolean click)
			throws NullPointerException, DriverException {
		logger.info("Method: verifyAndClick Starts");
		boolean flag = false;
		try {
			windowHandler.switchToLatestWindow();
			WebElement element = verifyElement(locator);
			if (element != null) {
				if (click) {
					element.click();
					waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
					/*
					 * waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString(
					 * "id.common.page.loader")); Thread.sleep(7000);
					 */
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
	public boolean verifyAndClickWithSwitch(String locator, int index, boolean click)
			throws NullPointerException, DriverException {
		logger.info("Method: verifyAndClick Starts");
		boolean flag = false;
		try {
			windowHandler.switchToLatestWindow();
			List<WebElement> element = verifyElementList(locator);
			if (element != null) {
				if (click) {
					element.get(index).click();
					waitForAwhile(8000);
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
	 * @throws DriverException
	 * 
	 */

	public void clikOnCloseOfRL() throws DriverException {
		try {
			windowHandler.switchToLatestWindow();
			List<WebElement> ele = baseHandler.findElements(PropertiesRepository.getString("real.life.close"));
			if (CollectionUtils.isNotEmpty(ele)) {
				ele.get(0).click();
			}
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to verifyAndClick");
			log(logger, "Unable to verifyAndClick");
			throw new DriverException("Unable to verifyAndClick", e);
		}
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
	public boolean verifyAndClick(String locator, int index, boolean click)
			throws NullPointerException, DriverException {
		logger.info("Method: verifyAndClick Starts");
		logger.info("Locator value --> " + locator);
		// index = 7;
		logger.info("index value --> " + index);
		logger.info("click value --> " + click);
		boolean flag = false;
		// locator = "div[class='ng-star-inserted'] button[class='mat-button
		// mat-primary'] span";
		try {
			List<WebElement> element = verifyElementList(locator);
			if (element != null) {
				if (click) {
					element.get(index).click();
				}
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to verifyAndClick");
			log(logger, "Unable to verifyAndClick");
			throw new DriverException("Unable to verifyAndClick", e);
		}
		logger.info("Method: verifyAndClick End flag --> " + flag);
		return flag;
	}

	/**
	 * Click on people tab header loc
	 * 
	 * @param locator
	 * @param index
	 * @param click
	 * @return
	 * @throws NullPointerException
	 * @throws DriverException
	 * @author Syed.Hoque
	 */

	public boolean verifyAndClickd(String locator, int index, boolean click)
			throws NullPointerException, DriverException {
		logger.info("Method: verifyAndClick Starts");
		boolean flag = false;
		try {
			List<WebElement> element = verifyElementList(locator);
			if (element != null) {
				if (click) {
					element.get(index).click();
					waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
					waitForAwhile(2000);
				}
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to verifyAndClick");
			log(logger, "Unable to verifyAndClick");
			throw new DriverException("Unable to verifyAndClick", e);
		}
		logger.info("Method: verifyAndClick End flag --> " + flag);
		return flag;
	}

	/**
	 * Verify Element exists in DOM.
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @return
	 * @throws DriverException
	 */
	public boolean verifyElementExists(String locator) throws DriverException {
		logger.info("Method: verifyElementExists Starts");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(element) && element.size() > 0) {
				flag = true;
			} else {
				logger.info("Unable to find elements in verifyElementExists ");
			}
		} catch (Exception e) {
			logger.info("Unable to verifyElementExists");
			log(logger, "Unable to verifyElementExists");
			throw new DriverException("Unable to verifyElementExists", e);
		}
		logger.info("Method: verifyElementExists End flag --> " + flag);
		return flag;
	}

	/**
	 * Verify Element exists in DOM.
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @return
	 * @throws DriverException
	 */
	public boolean verifyElementExists(String locator, int index) throws DriverException {
		logger.info("Method: verifyElementExists Starts");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(element) && element.size() > 0 && element.get(index) != null) {
				flag = true;
			} else {
				logger.info("Unable to find elements in verifyElementExists ");
			}
		} catch (Exception e) {
			logger.info("Unable to verifyElementExists");
			log(logger, "Unable to verifyElementExists");
			throw new DriverException("Unable to verifyElementExists", e);
		}
		logger.info("Method: verifyElementExists End flag --> " + flag);
		return flag;
	}

	/**
	 * Verify Element exists in DOM.
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @return
	 * @throws DriverException
	 */
	public boolean verifyElementExistsWithDefaultSwitch(String locator) throws DriverException {
		logger.info("Method: verifyElementExistsWithDefaultSwitch Starts");
		boolean flag = false;
		try {
			windowHandler.switchToLatestWindow();
			List<WebElement> element = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(element)) {
				flag = true;
			}
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			logger.info("Unable to verifyElementExistsWithDefaultSwitch");
			log(logger, "Unable to verifyElementExistsWithDefaultSwitch");
			throw new DriverException("Unable to verifyElementExistsWithDefaultSwitch", e);
		}
		logger.info("Method: verifyElementExistsWithDefaultSwitch End flag --> " + flag);
		return flag;
	}

	/**
	 * Verify Element exists in DOM.
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @return
	 * @throws DriverException
	 */
	public boolean verifyElementExistsWtihCardShadowSwitch(String locator) throws DriverException {
		logger.info("Method: verifyElementExistsWtihCardShadowSwitch Starts");
		boolean flag = false;
		try {
			switchToCardShadowFrame();
			List<WebElement> element = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(element)) {
				flag = true;
			}
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to verifyElementExistsWtihCardShadowSwitch");
			log(logger, "Unable to verifyElementExistsWtihCardShadowSwitch");
			throw new DriverException("Unable to verifyElementExistsWtihCardShadowSwitch", e);
		}
		logger.info("Method: verifyElementExistsWtihCardShadowSwitch End flag --> " + flag);
		return flag;
	}

	/**
	 * Verify Element exists in DOM.
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @return
	 * @throws DriverException
	 */
	public boolean verifyElementExistsWtihCardShadowSwitch(String locator, int index, String value)
			throws DriverException {
		logger.info("Method: verifyElementExistsWtihCardShadowSwitch Starts");
		logger.info("Locator value --> " + locator);
		logger.info("index value --> " + index);
		logger.info("value --> " + value);
		boolean flag = false;
		try {
			switchToCardShadowFrame();
			List<WebElement> element = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(element) && element.get(index).getText().equalsIgnoreCase(value)) {
				flag = true;
			} else {
				logger.info("Unable to find element for locator --> " + locator);
			}
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to verifyElementExistsWtihCardShadowSwitch");
			log(logger, "Unable to verifyElementExistsWtihCardShadowSwitch");
			throw new DriverException("Unable to verifyElementExistsWtihCardShadowSwitch", e);
		}
		logger.info("Method: verifyElementExistsWtihCardShadowSwitch End flag --> " + flag);
		return flag;
	}

	/**
	 * Method used to switch to PDF Frame.
	 * 
	 * @author saravanan.jothimani
	 * @throws DriverException
	 */
	public void swithToPDFFrame() throws DriverException {
		logger.info("Method: swithToPDFFrame Starts");
		try {
			windowHandler.switchToLatestWindow();
			windowHandler.switchToFrame("FrameReport");
		} catch (Exception e) {
			logger.info("Unable to swithToPDFFrame");
			log(logger, "Unable to swithToPDFFrame");
			throw new DriverException("Unable to swithToPDFFrame", e);
		}
		logger.info("Method: swithToPDFFrame End ");
	}

	/**
	 * Method used to get text and verify Text.
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @param text
	 * @return
	 * @throws DriverException
	 */
	public boolean verifyTextEquals(String locator, String text) throws DriverException {
		logger.info("Method: verifyTextEquals Starts");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(element)) {
				if (element.get(0).getText().trim().equalsIgnoreCase(text)) {
					flag = true;
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verifyTextEquals");
			log(logger, "Unable to verifyTextEquals");
			throw new DriverException("Unable to verifyTextEquals", e);
		}
		logger.info("Method: verifyTextEquals End flag --> " + flag);
		return flag;
	}

	/**
	 * Method used to get text and verify Text.
	 * 
	 * @author Devika.RS
	 * @param locator
	 * @param text
	 * @return
	 * @throws DriverException
	 */
	public boolean verifyTextEquals(String locator, String text, int index) throws DriverException {
		logger.info("Method: verifyTextEquals Starts");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(element)) {
				if (element.get(index).getText().trim().equalsIgnoreCase(text)) {
					flag = true;
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verifyTextEquals");
			log(logger, "Unable to verifyTextEquals");
			throw new DriverException("Unable to verifyTextEquals", e);
		}
		logger.info("Method: verifyTextEquals End flag --> " + flag);
		return flag;
	}

	/**
	 * Method used to get text and verify Text.
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @param text
	 * @return
	 * @throws DriverException
	 */
	public boolean verifyTextEqualsList(String locator, String text) throws DriverException {
		logger.info("Method: verifyTextEqualsList Starts");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(element)) {
				int size = element.size();
				for (int index = 0; index < size; index++) {
					if (element.get(index).getText().trim().equalsIgnoreCase(text)) {
						flag = true;
						break;
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verifyTextEqualsList");
			log(logger, "Unable to verifyTextEqualsList");
			throw new DriverException("Unable to verifyTextEqualsList", e);
		}
		logger.info("Method: verifyTextEqualsList End flag --> " + flag);
		return flag;
	}

	/**
	 * Method used to get text and verify Text.
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @param text
	 * @return
	 * @throws DriverException
	 */
	public boolean verifyTextContains(String locator, String text) throws DriverException {
		logger.info("Method: verifyTextContains Starts");
		boolean flag = false;
		logger.info("Locator value --> " + locator);
		logger.info("text value --> " + text);
		try {
			List<WebElement> element = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(element)) {
				if (element.get(0).getText().trim().contains(text)) {
					flag = true;
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verifyTextContains");
			log(logger, "Unable to verifyTextContains");
			throw new DriverException("Unable to verifyTextContains", e);
		}
		logger.info("Method: verifyTextContains End flag --> " + flag);
		return flag;
	}

	/**
	 * Method used to get text and verify Text.
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @param text
	 * @return
	 * @throws DriverException
	 */
	public boolean verifyTextContains(String locator, String text, int index) throws DriverException {
		logger.info("Method: verifyTextContains Starts");
		logger.info("Locator value --> " + locator);
		logger.info("index value --> " + index);
		logger.info("text --> " + text);
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(element)) {
				if (element.get(index).getText().trim().contains(text)) {
					flag = true;
				}
			} else {
				logger.info("Unable to get locator value in verifyTextContains");
			}
		} catch (Exception e) {
			logger.info("Unable to verifyTextContains");
			log(logger, "Unable to verifyTextContains");
			throw new DriverException("Unable to verifyTextContains", e);
		}
		logger.info("Method: verifyTextContains End flag --> " + flag);
		return flag;
	}

	/**
	 * @author Sanapati.Srinu
	 * @param loc
	 * @param index
	 * @throws DriverException
	 *//*
		 * public void clickButtonFromList(String loc, int index) throws
		 * NullPointerException, DriverException { logger.info(
		 * "clickButtonFromList  --- Start"); try {
		 * waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString(
		 * "id.common.page.loader")); if
		 * (baseHandler.isDisplayed(PropertiesRepository.getString(loc))) {
		 * List<WebElement> webElements =
		 * baseHandler.findElements(PropertiesRepository.getString(loc)); if
		 * (CollectionUtils.isNotEmpty(webElements)) { new
		 * Actions(driver).moveToElement(webElements.get(index)).click().build()
		 * .perform();
		 * waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString(
		 * "id.common.page.loader")); //asmt.pleasewait.bufferLoc
		 * 
		 * }
		 * 
		 * } } catch (Exception e) { throw new DriverException(
		 * "unable to click the button", e); } logger.info(
		 * "clickButtonFromList  --- End"); }
		 */

	/**
	 * This method is used to check element is displayed or not
	 * 
	 * @author Sanapati.Srinu
	 * @param loc
	 * @param index
	 * @return
	 * @throws DriverException
	 */
	public boolean isElementDisplayed(String loc, int index) throws DriverException {
		logger.info("isElementDisplayed start");
		boolean flag = false;
		String subWindowHandler = null;
		try {
			Set<String> handles = driver.getWindowHandles();
			Iterator<String> iterator = handles.iterator();
			while (iterator.hasNext()) {
				subWindowHandler = iterator.next();
				driver.switchTo().window(subWindowHandler);
				windowHandler.switchToLatestWindow();
				if (baseHandler.isDisplayed(PropertiesRepository.getString(loc))) {
					List<WebElement> webElements = baseHandler.findElements(PropertiesRepository.getString(loc));
					if (CollectionUtils.isNotEmpty(webElements)) {
						webElements.get(index).isDisplayed();
						flag = true;
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to click the button or no data found");
			log(logger, "Unable to click the button or no data found");
			throw new DriverException("Unable to click the button or no data found", e);
		}
		logger.info("isElementDisplayed end");
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
			waitForAwhile(1000);
			WebElement frameElement = driver.findElement(By.cssSelector(".card-shadow"));
			// if(frameElement ! n)
			driver.switchTo().frame(frameElement);
			/**
			 * if(frameElement != null) { driver.switchTo().frame(frameElement); } else {
			 * logger.info("Unable to switch to card-show frame"); }
			 */
		} catch (Exception e) {
			throw new DriverException("unable to swith to frame");

		}
		logger.info("switchToCardShadowFrame  end");
	}

	/**
	 * Method used to click on Button with index.
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @param index
	 * @throws Exception
	 */
	public void clickButton(String locator, int index) throws DriverException {
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
	public void clickButtonInsideFrame(String locator, int index) throws DriverException {
		logger.info("Method: clickButton Starts");
		try {

			List<WebElement> ele = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(ele)) {
				ele.get(index).click();
			}

			/*
			 * baseHandler.findElement(PropertiesRepository.getString(
			 * "setbenchmark.proctor.edit.field")).click(); Thread.sleep(1000);
			 */

		} catch (Exception e) {
			logger.info("Unable to click Button clickButtonInsideFrame");
			log(logger, "Unable to click Button clickButtonInsideFrame");
			throw new DriverException("Unable to click Button clickButtonInsideFrame", e);
		}
		logger.info("Method: clickButton End ");
	}

	/**
	 * This method is used to wait for some time when identifying the element on the
	 * page
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
	 * Method used to enter text in text box.
	 * 
	 * @param locator
	 * @param value
	 * @throws DriverException
	 */
	public void enterText(String locator, String value) throws DriverException {
		logger.info("Method: enterText Starts");
		try {
			List<WebElement> inputText = verifyElementList(locator);
			if (CollectionUtils.isNotEmpty(inputText)) {
				inputText.get(0).click(); // unknown error: cannot focus element
				inputText.get(0).sendKeys(value);
				inputText.get(0).sendKeys(Keys.ENTER);
			}
		} catch (Exception e) {
			logger.info("Unable to enterText");
			log(logger, "Unable to enterText");
			throw new DriverException("Unable to enterText", e);
		}
		logger.info("Method: clickButton End ");
	}

	/**
	 * Method used to enter text in text box.
	 * 
	 * @param locator
	 * @param value
	 * @throws DriverException
	 */
	public void enterTextInInstitution(String locator, String value) throws DriverException {
		logger.info("Method: enterTextInInstitution Starts");
		try {
			List<WebElement> inputText = verifyElementList(locator);
			if (CollectionUtils.isNotEmpty(inputText)) {
				inputText.get(0).click();
				inputText.get(0).clear();
				inputText.get(0).sendKeys(value);
				inputText.get(0).sendKeys(Keys.ENTER);
			}
		} catch (Exception e) {
			logger.info("Unable to enterTextInInstitution");
			log(logger, "Unable to enterTextInInstitution");
			throw new DriverException("Unable to enterTextInInstitution", e);
		}
		logger.info("Method: enterTextInInstitution End ");
	}

	/**
	 * Method used to enter text in text box.
	 * 
	 * @param locator
	 * @param value
	 * @throws DriverException
	 */
	public void enterTextWithSwitchToLatestWindow(String locator, String value) throws DriverException {
		logger.info("Method: enterTextWithSwitchToLatestWindow Starts");
		logger.info("Locator value --> " + locator);
		logger.info("value value --> " + value);
		try {
			windowHandler.switchToLatestWindow();
			WebElement textElement = verifyElement(locator);
			if (textElement != null) {
				textHandler.writeText(textElement, value);
			} else {
				logger.info("Unable to enter value in text box.");
			}
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to enterTextWithSwitchToLatestWindow");
			log(logger, "Unable to enterTextWithSwitchToLatestWindow");
			throw new DriverException("Unable to enterTextWithSwitchToLatestWindow", e);
		}
		logger.info("Method: enterTextWithSwitchToLatestWindow End ");
	}

	/**
	 * Method used to enter text in text box.
	 * 
	 * @param locator
	 * @param value
	 * @throws DriverException
	 */
	public void enterTextWithSwitchToCardShow(String locator, String value) throws DriverException {
		logger.info("Method: enterTextWithSwitchToCardShow Starts");
		logger.info("Locator value --> " + locator);
		logger.info("value value --> " + value);
		try {
			switchToCardShadowFrame();
			WebElement textElement = verifyElement(locator);
			if (textElement != null) {
				textHandler.writeText(textElement, value);
			} else {
				logger.info("Unable to enter value in text box.");
			}
			windowHandler.switchToLatestWindow();
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to enterTextWithSwitchToCardShow");
			log(logger, "Unable to enterTextWithSwitchToCardShow");
			throw new DriverException("Unable to enterTextWithSwitchToCardShow", e);
		}
		logger.info("Method: enterTextWithSwitchToCardShow End ");
	}

	/**
	 * Method used to enter text in text box with its index.
	 * 
	 * @param locator
	 * @param value
	 * @throws DriverException
	 */
	public void enterTextList(String locator, int index, String value) throws DriverException {
		logger.info("Method: enterTextList Starts");
		logger.info("Locator value --> " + locator);
		logger.info("index index --> " + index);
		logger.info("index value --> " + value);
		try {
			List<WebElement> inputText = verifyElementList(locator);
			if (CollectionUtils.isNotEmpty(inputText)) {
				inputText.get(index).click();
				inputText.get(index).sendKeys(value);
			}
		} catch (Exception e) {
			logger.info("Unable to enterTextList");
			log(logger, "Unable to enterTextList");
			throw new DriverException("Unable to enterTextList", e);
		}
		logger.info("Method: enterTextList End ");
	}

	/**
	 * Method used to enter text in text box with its index.
	 * 
	 * @param locator
	 * @param value
	 * @throws DriverException
	 */
	public void enterTextListAndTab(String locator, int index, String value) throws DriverException {
		logger.info("Method: enterTextList Starts");
		logger.info("Locator value --> " + locator);
		logger.info("index index --> " + index);
		logger.info("index value --> " + value);
		try {
			List<WebElement> inputText = verifyElementList(locator);
			if (CollectionUtils.isNotEmpty(inputText)) {
				inputText.get(index).click();
				inputText.get(index).sendKeys(value);
				inputText.get(index).sendKeys(Keys.TAB);
			}
		} catch (Exception e) {
			logger.info("Unable to enterTextList");
			log(logger, "Unable to enterTextList");
			throw new DriverException("Unable to enterTextList", e);
		}
		logger.info("Method: enterTextList End ");
	}

	/**
	 * This method will send security ans in text box
	 * 
	 * @throws DriverException
	 */
	public void sendAnswers(int index, String ans) throws DriverException {
		logger.info("Method: sendAnswers Starts");
		try {
			List<WebElement> textbox = baseHandler.findElements(PropertiesRepository.getString("security.answers.loc"));
			if (CollectionUtils.isNotEmpty(textbox)) {
				textbox.get(index).click();
				textbox.get(index).sendKeys(ans);
			}
		} catch (Exception e) {
			logger.info("Unable to sendAnswers");
			log(logger, "Unable to sendAnswers");
			throw new DriverException("Unable to sendAnswers", e);
		}
		logger.info("Method: sendAnswers Ends");
	}

	/**
	 * Method used to enter Application URL.
	 * 
	 * @author saravanan.jothimani
	 * @param url
	 * @throws Exception
	 */
	public void launchLoginPage(String url) throws Exception {
		logger.info("Method : launchLoginPage :::::::: START");
		try {
			driver.get(url);
		} catch (Exception e) {
			logger.info("Unable to launch Login Page");
			log(logger, "Unable to launch Login Page");
			throw new DriverException("Unable to launch Login Page", e);
		}
		logger.info("Method : launchLoginPage :::::::: END");
	}

	/**
	 * Method used to launch MU application.
	 * 
	 * @author saravanan.jothimani
	 * @param url
	 * @throws Exception
	 */
	public void loginIntoMU() throws Exception {

		logger.info("Method : loginIntoMU :::::::: Start");
		try {
			enterTextInTextField("current-atitesting.mu.username.loc", "current-atitesting.mu.username");

			JavascriptExecutor executor = (JavascriptExecutor) driver;

			executor.executeScript(
					"document.getElementById('" + PropertiesRepository.getString("current-atitesting.mu.password.loc")
							+ "').value='" + PropertiesRepository.getString("current-atitesting.mu.password") + "'");

			clickButtonWithWait("current-atitesting.mu.signin.button.loc");
			waitForLoad(driver);
		} catch (DriverException e) {
			logger.info("Method : Unable to login in to MU :::::::: Start");
			log(logger, "Method : Unable to login in to MU :::::::: Start");
			throw new DriverException("Method : Unable to login in to MU :::::::: Start", e);
		}
		logger.info("Method : loginIntoMU :::::::: Start");
	}

	/**
	 * This method is used to send the text to textfield
	 * 
	 * @author Srinu
	 * @param textFieldLoc
	 * @param input
	 * @throws DriverException
	 * @throws InterruptedException
	 */
	public void enterTextInTextField(String locator, String input) throws DriverException {
		logger.info("enterTextInTextField Start " + PropertiesRepository.getString(input));

		try {
			// enter username
			waitForLoad(driver);
			textHandler.writeText(PropertiesRepository.getString(locator), PropertiesRepository.getString(input));

		} catch (DriverException e) {
			logger.info("Unable to enterTextInTextField " + PropertiesRepository.getString(input));
			log(logger, "Unable to enterTextInTextField " + PropertiesRepository.getString(input));
			throw new DriverException("Unable to enterTextInTextField " + PropertiesRepository.getString(input), e);
		}
		logger.info("enterTextInTextField End");
	}

	/**
	 * This method is to wait for page to load
	 */
	public void waitForLoad(WebDriver driver) {
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(pageLoadCondition);
	}

	/**
	 * Used to click on Dismiss in Alert Message.
	 * 
	 * @author prasanna.gogineni
	 * @param locator
	 * @throws Exception
	 */
	public void clickButtonWithWait(String locator, String... waitFor) throws DriverException {
		logger.info("clickButtonWithWait Start " + locator);
		try {
			List<WebElement> buttonElement = baseHandler.findElements(PropertiesRepository.getString(locator));
			if (CollectionUtils.isNotEmpty(buttonElement)) {
				new ButtonHandler(driver).clickButton(PropertiesRepository.getString(locator), true);
				if (waitFor != null && waitFor.length > 0) {
					baseHandler.setDriverWait(driver, waitFor[0]);
				}
			}
		} catch (Exception e) {
			logger.info("Unable to clickButtonWithWait");
			log(logger, "Unable to clickButtonWithWait");
			throw new DriverException("Unable to clickButtonWithWait", e);
		}
		logger.info("clickButtonWithWait End");
	}

	/**
	 * this method will navigate to frame and then verify some locator
	 * 
	 * @param locator
	 * @param index
	 * @param value
	 * @return
	 * @author Syed.Hoque
	 * @throws DriverException
	 */
	public boolean verifyMessages(String locator, int index, String value) throws DriverException {
		logger.info("verifyMessages Start " + locator);
		logger.info("Locator value --> " + locator);
		logger.info("index value --> " + index);
		logger.info("value --> " + value);
		boolean flag = false;
		try {
			switchToCardShadowFrame();
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString(locator));
			if (CollectionUtils.isNotEmpty(element) && element.size() > 0) {
				if (value.equalsIgnoreCase(element.get(index).getText().trim())) {
					flag = true;
				}
			}
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to verifyMessages");
			log(logger, "Unable to verifyMessages");
			throw new DriverException("Unable to verifyMessages", e);
		}
		logger.info("verifyMessages End flag --> " + flag);
		return flag;
	}

	/**
	 * Used to verify message
	 * 
	 * @author prasanna.gogineni
	 * @param locator
	 * @throws Exception
	 */
	public boolean verifyMessage(String locator, int index, String value) throws DriverException {
		logger.info("verifyMessage Start ");
		logger.info("Locator value --> " + locator);
		logger.info("index value --> " + index);
		logger.info("value --> " + value);
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString(locator));
			if (CollectionUtils.isNotEmpty(element) && element.size() > 0) {
				System.out.println(element.get(0).getText());
				if (value.equalsIgnoreCase(element.get(index).getText().trim())) {
					flag = true;
				}
			} else {
				logger.info("Unable to find elements for message verification");
			}

		} catch (Exception e) {
			logger.info("Unable to verifyMessage");
			log(logger, "Unable to verifyMessage");
			throw new DriverException("Unable to verifyMessage", e);
		}
		logger.info("verifyMessage End flag -->" + flag);
		return flag;
	}

	/**
	 * Used to verify message
	 * 
	 * @author prasanna.gogineni
	 * @param locator
	 * @throws Exception
	 */
	public boolean verifyMessageWithDefaultSwitch(String locator, int index, String value) throws DriverException {
		logger.info("verifyMessageWithDefaultSwitch Start " + locator);
		boolean flag = false;
		try {
			windowHandler.switchToLatestWindow();
			List<WebElement> element = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(element) && element.size() > 0) {
				if (value.equalsIgnoreCase(element.get(index).getText().trim())) {
					flag = true;
				}
			} else {
				logger.info("Unable to find elements for message verification");
			}
		} catch (Exception e) {
			logger.info("Unable to verifyMessageWithDefaultSwitch");
			log(logger, "Unable to verifyMessageWithDefaultSwitch");
			throw new DriverException("Unable to verifyMessageWithDefaultSwitch", e);
		}
		logger.info("verifyMessageWithDefaultSwitch End flag -->" + flag);
		return flag;
	}

	/**
	 * Used to verify message
	 * 
	 * @author prasanna.gogineni
	 * @param locator
	 * @throws Exception
	 */
	public boolean verifyContainsMessageWithDefaultSwitch(String locator, int index, String value)
			throws DriverException {
		logger.info("verifyContainsMessageWithDefaultSwitch Start " + locator);
		boolean flag = false;
		try {
			windowHandler.switchToLatestWindow();
			List<WebElement> element = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(element) && element.size() > 0) {
				if (element.get(index).getText().trim().contains(value)) {
					flag = true;
				}
			} else {
				logger.info("Unable to find elements for message verification");
			}
		} catch (Exception e) {
			logger.info("Unable to verifyContainsMessageWithDefaultSwitch");
			log(logger, "Unable to verifyContainsMessageWithDefaultSwitch");
			throw new DriverException("Unable to verifyContainsMessageWithDefaultSwitch", e);
		}
		logger.info("verifyContainsMessageWithDefaultSwitch End flag -->" + flag);
		return flag;
	}

	/**
	 * Used to verify message
	 * 
	 * @author prasanna.gogineni
	 * @param locator
	 * @throws Exception
	 */
	public boolean verifyATIAcademyPage(String locator, int index, String value) throws DriverException {
		logger.info("verifyATIAcademyPage Start " + locator);
		boolean flag = false;
		try {
			windowHandler.switchToLatestWindow();
			List<WebElement> element = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(element) && element.size() > 0) {
				if (element.get(index).getText().trim().contains(value)) {
					flag = true;
				}
			} else {
				logger.info("Unable to find elements for message verification");
			}
			driver.close();
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			logger.info("Unable to verifyATIAcademyPage");
			log(logger, "Unable to verifyATIAcademyPage");
			throw new DriverException("Unable to verifyATIAcademyPage", e);
		}
		logger.info("verifyATIAcademyPage End flag -->" + flag);
		return flag;
	}

	/**
	 * Used to verify message
	 * 
	 * @author prasanna.gogineni
	 * @param locator
	 * @throws Exception
	 */
	public boolean verifyMessageUsingGetAttribute(String locator, int index, String value) throws DriverException {
		logger.info("verifyMessageUsingGetAttribute Start " + locator);
		logger.info("Locator value --> " + locator);
		logger.info("index value --> " + index);
		// value = "01/31/2017";
		logger.info("value --> " + value);
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(element) && element.size() > 0) {
				if (value.equalsIgnoreCase(element.get(index).getAttribute("value").trim())) {
					flag = true;
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verifyMessageUsingGetAttribute");
			log(logger, "Unable to verifyMessageUsingGetAttribute");
			throw new DriverException("Unable to verifyMessageUsingGetAttribute", e);
		}
		logger.info("verifyMessageUsingGetAttribute End flag --> " + flag);
		return flag;
	}

	/**
	 * This method is used to wait until buffer invisible
	 * 
	 * @author Saravanan Jothimani
	 */
	public boolean waitUntillElementIsVisible(String loc) throws Exception {
		logger.info("Method: waitUntillElementIsVisible Start");
		boolean flag = false;
		WebElement element = null;
		try {
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			switchToCardShadowFrame();
			// waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			// waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(loc)));
			if (element != null) {
				flag = true;
			}
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to waitUntillElementIsVisible");
			log(logger, "Unable to waitUntillElementIsVisible");
			throw new DriverException("Unable to waitUntillElementIsVisible", e);
		}
		logger.info("Method: waitUntillElementIsVisible End flag --> " + flag);
		return flag;
	}

}
