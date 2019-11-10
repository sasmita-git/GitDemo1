package com.ascendlearning.automation.ui.driver;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.ascendlearning.automation.ui.config.GlobalProperties;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.ExceptionConstants;
import com.ascendlearning.automation.ui.logging.LogHandler;

public final class DriverFactory {

	private Logger logger = LogHandler.getLogger(DriverFactory.class);

	private String browserType = null;
	private String environment = null;

	private DriverFactory() {
	}

	private static DriverFactory instance = new DriverFactory();

	public static DriverFactory getInstance() {
		return instance;
	}

	ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>() { // thread local
																			// threadDriver object for
																			// webdriver
		@Override
		protected WebDriver initialValue() {

			// Getting value from Jenkins for Browser - Start
			browserType = System.getProperty("browserName");
			logger.info("browserType value first ==> " + browserType);

			// If not getting value from properties file
			if (StringUtils.isEmpty(browserType)) {
				browserType = PropertiesRepository.getString("global.browser.name");
			}

			if (browserType.equalsIgnoreCase("ie")) {
				browserType = "internet explorer";
			}

			logger.info("browserType value ==> " + browserType);
			DesiredCapabilities dc = CapabilityGenerator.getCapabilities(browserType);
			logger.info("Desired Capabilities : " + dc);
			// Getting value from Jenkins for Browser - End

			// Getting value from Jenkins for environment - Start
			environment = System.getProperty("env");
			logger.info("environment value ==> " + environment);

			if (StringUtils.isBlank(environment) || StringUtils.isEmpty(environment)) {
				environment = PropertiesRepository.getString("global.environment.name");
				logger.info("environment value from property file==> " + environment);
			}
			// Getting value from Jenkins for environment - End

			if (browserType.equalsIgnoreCase(GlobalProperties.ANDROID)) {
				try {
					URL hubURL = new URL(PropertiesRepository.getString("global.mobile.hub"));
					logger.info("Hub URL for mobile: " + hubURL);
					return new RemoteWebDriver(hubURL, dc);
				} catch (MalformedURLException e) {
					logger.error(ExceptionConstants.PROPERTIES_EXCEPTION, e);
					return null;
				}
			} else {
				if (PropertiesRepository.getBoolean("global.grid.mode")) {
					try {
						URL hubURL = new URL(PropertiesRepository.getString("global.grid.hub"));
						logger.info("Hub URL for Grid: " + hubURL);
						return new RemoteWebDriver(hubURL, dc);
					} catch (MalformedURLException e) {
						logger.error(ExceptionConstants.PROPERTIES_EXCEPTION, e);
						return null;
					}
				} else {
					switch (browserType) {
					case GlobalProperties.FIREFOX:
						return new FirefoxDriver(dc);
					case GlobalProperties.IE:
						return new InternetExplorerDriver(dc);
					case GlobalProperties.CHROME:
						return new ChromeDriver(dc);
					case GlobalProperties.EDGE:
						System.setProperty("webdriver.edge.driver",PropertiesRepository.getString("global.browser.edge.driver.executable"));
						return new EdgeDriver();
					default:
						return new FirefoxDriver(dc);
					}
				}
			}
		}
	};

	public WebDriver getDriver() { // call this method to get the threadDriver object and launch the
									// browser
		return threadDriver.get();
	}

	public void removeDriver() { // Quits the threadDriver and closes the browser
		WebDriver driver = threadDriver.get();

		if (driver == null) {
			return;
		}
		// driver.close();
		driver.quit();
		threadDriver.remove();
	}

	public String getEnvironment() {
		return environment;
	}

	public String setEnvironment(String environment) {
		return this.environment = environment;
	}

}
