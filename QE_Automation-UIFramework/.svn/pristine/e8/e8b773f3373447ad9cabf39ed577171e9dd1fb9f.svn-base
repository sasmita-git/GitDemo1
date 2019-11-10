package com.ascendlearning.automation.ui.handlers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ascendlearning.automation.ui.config.GlobalProperties;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.utils.ByCssSelectorExtended;

public class BaseHandler {
	private Logger logger = LogManager.getLogger(this.getClass());

	protected WebDriver driver = null;
	protected static long config_wait_timeout = 0L;
	protected static long config_verify_interval = 0L;
	JavascriptExecutor executor;
	
	public BaseHandler(WebDriver webDriver) {
		driver = webDriver;
		setupConfigValue();
	}

	private void setupConfigValue() {
		config_wait_timeout = PropertiesRepository.getLong("waittimeout");
		config_verify_interval = PropertiesRepository.getLong("verifyinterval");
	}

	public void setDriverWait(String cssSelector) {
		WebDriverWait driverWait = new WebDriverWait(driver,
				GlobalProperties.EXPLICIT_WAIT);
		driverWait.until(ExpectedConditions
				.visibilityOfElementLocated(ByCssSelectorExtended.cssSelector(
						driver, cssSelector)));
	}

	public void setDriverWait(WebDriver webDriver, String cssSelector) {
		WebDriverWait driverWait = new WebDriverWait(webDriver,
				GlobalProperties.EXPLICIT_WAIT);
		driverWait.until(ExpectedConditions
				.visibilityOfElementLocated(ByCssSelectorExtended.cssSelector(
						webDriver, cssSelector)));
	}

	public void waitForPageToLoad(String cssSelector) {
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript(
						"return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(driver,
				GlobalProperties.EXPLICIT_WAIT);
		wait.until(pageLoadCondition);
	}

	public WebDriver waitForFrameToLoadAndSwitchToIt(String cssSelector) {
		WebDriverWait wait = new WebDriverWait(driver,
				GlobalProperties.EXPLICIT_WAIT);
		wait.until(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt(ByCssSelectorExtended
						.cssSelector(driver, cssSelector)));
		return driver;
	}

	public WebElement findElement(String cssSelector) {
		return findElement(driver,
				ByCssSelectorExtended.cssSelector(driver, cssSelector),
				config_wait_timeout);
	}
	
	public WebElement findElement(WebDriver driver, String cssSelector) {
		return findElement(driver,
				ByCssSelectorExtended.cssSelector(driver, cssSelector),
				config_wait_timeout);
	}
	

	public WebElement findElement(WebDriver driver, By by, long timeout) {
		WebElement ele = null;
		long startTime = System.currentTimeMillis();
		long stopTime = startTime + timeout;
		while (System.currentTimeMillis() < stopTime) {
			ele = driver.findElement(by);
			if (ele != null) {
				break;
			}
			if (config_verify_interval > 0L) {
				if (timeout < config_verify_interval) {
					sleep(timeout);
				} else {
					sleep(config_verify_interval);
				}
			}
		}
		ele = driver.findElement(by);

		return ele;
	}

	public List<WebElement> findElements(String cssSelector) {
		return findElements(driver,ByCssSelectorExtended.cssSelector(driver, cssSelector),config_wait_timeout);
	}

	public List<WebElement> findElements(WebDriver driver, By by, long timeout) {
		List<WebElement> elements = null;
		long stopTime = System.currentTimeMillis() + timeout;
		while (System.currentTimeMillis() < stopTime) {
			elements = driver.findElements(by);
			if ((elements != null) && (elements.size() > 0)) {
				break;
			}
			if (config_verify_interval > 0L) {
				if (timeout < config_verify_interval) {
					sleep(timeout);
				} else {
					sleep(config_verify_interval);
				}
			}
		}
		elements = driver.findElements(by);
		if ((elements == null) || (elements.size() == 0)) {
			return null;
		}
		List<WebElement> elementList = new ArrayList<WebElement>();
		for (WebElement ele : elements) {
			elementList.add(ele);
		}
		return elementList;
	}

	public boolean isDisplayed(WebElement we) {
		if (we == null) {
			throw new WebDriverException("WebElement is null");
		}
		return we.isDisplayed();
	}
	
	public boolean isDisplayed(String locator) {
		boolean flag = false;
		if (locator == null) {
			throw new WebDriverException("WebElement is null");
		}
		List<WebElement> we = findElements(locator);
		if(CollectionUtils.isNotEmpty(we)) {
			flag = we.get(0).isDisplayed(); 
		} else {
			throw new WebDriverException("WebElement Collection is null");
		}
		return flag;
	}

	public boolean isEnabled(WebElement we) {
		if (we == null) {
			throw new WebDriverException("WebElement is null");
		}
		return we.isEnabled();
	}
	
	public boolean isEnabled(String locator) {
		boolean flag = false;
		if (locator == null) {
			throw new WebDriverException("WebElement is null");
		}
		List<WebElement> we = findElements(locator);
		if(CollectionUtils.isNotEmpty(we)) {
			flag = we.get(0).isEnabled(); 
		} else {
			throw new WebDriverException("WebElement Collection is null");
		}
		return flag;
	}

	public boolean isSelected(WebElement we) {
		if (we == null) {
			throw new WebDriverException("WebElement is null");
		}
		return we.isSelected();
	}
	
	public boolean isSelected(String locator) {
		boolean flag = false;
		if (locator == null) {
			throw new WebDriverException("WebElement is null");
		}
		List<WebElement> we = findElements(locator);
		if(CollectionUtils.isNotEmpty(we)) {
			flag = we.get(0).isSelected(); 
		} else {
			throw new WebDriverException("WebElement Collection is null");
		}
		return flag;
	}
	
	public void clear(WebElement we) {
		if (we == null) {
			throw new WebDriverException("WebElement is null");
		}
		we.clear();
	}

	public long getVerifyTimeout() {
		return config_verify_interval;
	}

	public void setVerifyTimeout(long timeout) {
		config_verify_interval = timeout;
	}

	public long getWaitTimeout() {
		return config_wait_timeout;
	}

	public void setWaitTimeout(long timeout) {
		config_wait_timeout = timeout;
	}

	public void sleep(long ms) {
		sleep(ms, TimeUnit.MILLISECONDS, "");
	}

	public void sleep(long ms, String reason) {
		sleep(ms, TimeUnit.MILLISECONDS, reason);
	}

	public void sleep(long time, TimeUnit unit) {
		sleep(time, unit, "");
	}

	public void sleep(long time, TimeUnit unit, String reason) {
		if (time > 0L) {
			try {
				logger.debug("Sleeping for " + time + " " + unit.toString()
						+ ". " + reason);
				unit.sleep(time);
			} catch (InterruptedException e) {
				logger.error("Caught InterruptedException", e);
			}
		}
	}

	public void waitToBeDisplayed(String locator) throws DriverException {
		logger.info("waitToBeDisplayed with locator Starts");
		waitToBeDisplayed(findElement(locator), config_wait_timeout);
		logger.info("waitToBeDisplayed with locator End");
	}
	public void waitToBeDisplayed(WebElement we) throws DriverException {
		waitToBeDisplayed(we, config_wait_timeout);
	}

	public void waitToBeDisplayed(WebElement we, long timeout)
			throws DriverException {
		long startTime = System.currentTimeMillis();
		long stopTime = startTime + timeout;
		boolean isDisplayed = false;
		logger.debug("Waiting " + timeout + "ms for element to be displayed "
				+ toString());
		while ((System.currentTimeMillis() < stopTime)
				) {
			if (timeout < config_verify_interval) {
				sleep(timeout);
			} else {
				sleep(config_verify_interval);
			}
		}
		isDisplayed = isDisplayed ? isDisplayed : isDisplayed(we);
		long waitTime = System.currentTimeMillis() - startTime;
		if ((we != null) && (isDisplayed)) {
			logger.debug("After " + waitTime + "ms, element is displayed "
					+ toString());
			return;
		}
		String errorMessage = "After " + waitTime
				+ "ms, failed to display element " + toString();

		logger.error(errorMessage);
		throw new DriverException(errorMessage);
	}
	
	public WebDriver waitForInvisibilityOfElementLocated(String cssSelector) {
		WebDriverWait wait = new WebDriverWait(driver,
				GlobalProperties.EXPLICIT_WAIT);
		wait.until(ExpectedConditions
				.invisibilityOfElementLocated(ByCssSelectorExtended
						.cssSelector(driver, cssSelector)));
		return driver;
	}
	
	/**
	 *  Replace value for dynamically defined element
	 * The value to be replaced in locater should be mention as {1} ,{2} etc
	 * Ex:if user passes replaceLocatorValues("//font[contains(text(),'{1}')]/[contains(text(),'{2}')]","header","test")
	 * returnvalue: //font[contains(text(),'header')]/[contains(text(),'test')]
	 * 
	 * @param locator
	 * @param values
	 * @return String 
	 * @throws Exception
	 */
	public String replaceLocatorValues(String locator,String... values){
		try{
	        for (int i = 0; i < values.length; i++) {
	            String value = values[i];
	            locator = locator.replace("{" + (i + 1) + "}", value);
	        }
		}catch(Exception e){
			logger.error("FAILED TO REPLACE VALUES \n METHOD :replaceLocatorValues",e);
		}
		return locator;
	}
	
	/**
	 * Method used to click by javascript
	 * @param element
	 */
	public void clickByJavascript(WebElement element) {
		 try {
			  executor = (JavascriptExecutor)driver;
			 executor.executeScript("arguments[0].click();", element);
	        } catch (Exception e){
				logger.error("FAILED TO click by Javascript \n METHOD :clickByJavascript",e);
			}
	
	}
}
