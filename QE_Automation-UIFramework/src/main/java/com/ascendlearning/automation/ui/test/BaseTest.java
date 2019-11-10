package com.ascendlearning.automation.ui.test;

import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.driver.DriverFactory;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.jaca.JacaBase;

@Listeners(ExtentReport.class)
public class BaseTest implements JacaBase {
	protected WebDriver driver = null;
	protected WebDriver driverNew = null;	
	private Logger logger = LogManager.getLogger(this.getClass());
	protected WebDriver secondUIDriverInstance = null;
	protected WebDriver chromeUIDriverInstance = null;
	protected WebDriver firefoxUIDriverInstance = null;
	
	static {
		try {
			PropertiesRepository.loadAllProperties();
		} catch (DriverException e) {
			LogManager.getLogger(BaseTest.class).error("Unable to load properties files", e);
		}
	}
	
	
@BeforeMethod(alwaysRun = true)
	public void setup(Method testMethod) {
		try {
			logger.info("Method name in Base Test in setup for creating driver:" + testMethod.getName());
			driver = DriverFactory.getInstance().getDriver();
			ExtentReport.setDriver(driver);
			manageDriver();
		} catch (Exception e) {
			LogManager.getLogger(BaseTest.class).error("Unable to load Driver", e);
		}
		
		try {
			logger.info("Method name in Base Test in setup for loading properties:" + testMethod.getName());
			PropertiesRepository.loadAllProperties(DriverFactory.getInstance().getEnvironment());
		} catch(Exception e) {
			LogManager.getLogger(BaseTest.class).error("Unable to load properties files", e);
		}
	}
			
	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws InterruptedException, Exception  {		
		DriverFactory.getInstance().removeDriver();
		logger.info("Method name in Base Test in tearDown:" + result.getMethod().getMethodName());
		logger.info("Test Case Status :");
		if(result.getStatus() == ITestResult.SUCCESS) {
			logger.info("TC Passed");
	    } else if(result.getStatus() == ITestResult.FAILURE) {
	    	logger.info("TC Failed");
	    } else if(result.getStatus() == ITestResult.SKIP ) {
	    	 logger.info("TC Skiped");
	    }
	}
	
	/**
	 * Return the driver instance for use in listeners
	 * 
	 * @return WebDriver
	 */
	public WebDriver getWebDriver() {
		return driver;
	}

	/**
	 * Load the properties file from the classpath
	 * 
	 * e.g. loadProperties("jblearning.properties");
	 * @param propFile
	 * @throws DriverException 
	 */
	protected void loadProperties(String propFile) {
		try {
			PropertiesRepository.appendProperties(propFile);
		} catch (DriverException e) {
			logger.error("Unable to load properties file : " + propFile, e);
		}
	}
	
	protected void loadAllProperties() {
		try {
			PropertiesRepository.loadAllProperties();
		} catch (DriverException e) {
			e.printStackTrace();
			logger.error("Unable to load properties files", e);
		}
	}
	
	protected void manageDriver() {
		if (driver != null && !PropertiesRepository.getString("global.browser.name").equalsIgnoreCase("android")) {
			driver.manage().window().maximize();
		}
	}
	
	public void log (Logger logger, String log){
		logger.info(log);
		TestNGCustomReporter.customLog(log);
	}
	
	public WebDriver openProctorFirefoxDriver() {
		DesiredCapabilities cap = null;
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		firefoxProfile.setPreference("browser.download.folderList", 2);
		firefoxProfile.setPreference("browser.download.dir",
				PropertiesRepository.getString("global.download.location"));
		firefoxProfile.setPreference("browser.download.alertOnEXEOpen", false);
		firefoxProfile.setPreference("browser.helperApps.neverAsksaveToDisk",
				"application/x-msexcel,application/excel,application/x-excel,"
						+ "application/excel,application/x-excel,application/excel,"
						+ "application/vnd.ms-excel,application/x-excel,application/x-msexcel,application/pdf,"
						+ "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;");
		firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/msword, application/csv, application/ris, text/csv, image/png, application/pdf, text/html, text/plain, application/zip, application/x-zip, application/x-zip-compressed, application/download, application/octet-stream");
		firefoxProfile.setPreference("browser.download.manager.focusWhenStarting", false);
		firefoxProfile.setPreference("browser.helperApps.alwaysAsk.force", false);
		firefoxProfile.setPreference("browser.download.manager.alertOnEXEOpen", false);
		firefoxProfile.setPreference("browser.download.manager.closeWhenDone", false);
		firefoxProfile.setPreference("browser.download.manager.showAlertOnComplete", false);
		firefoxProfile.setPreference("browser.download.manager.useWindow", false);
		firefoxProfile.setPreference("browser.download.manager.showWhenStarting", false);
		firefoxProfile.setPreference("browser.download.manager.showAlertOnComplete", false);
	    firefoxProfile.setPreference("services.sync.prefs.sync.browser.download.manager.showWhenStarting", false);
		//firefoxProfile.setPreference("pdfjs.disabled", true);
		firefoxProfile.setPreference("browser.download.manager.alertOnEXEOpen", false);
		firefoxProfile.setPreference("browser.download.manager.closeWhenDone", true);
		firefoxProfile.setPreference("plugin.state.npctrl", 2);
		System.setProperty("webdriver.gecko.driver", "C:\\WebDrivers\\geckodriver.exe");
		cap = DesiredCapabilities.firefox();
		cap.setCapability(FirefoxDriver.PROFILE, firefoxProfile);
		cap.setCapability("firefox_binary", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		cap.setBrowserName(
				PropertiesRepository.getString("global.browser.capability.browserName.ff"));
		cap.setJavascriptEnabled(true);
		cap.setCapability("platform",
				PropertiesRepository.getString("global.browser.capability.platform"));
		cap.setCapability("takesScreenshot", PropertiesRepository
				.getBoolean("global.browser.capability.firefox.takesScreenshot"));
		cap.setCapability("handlesAlerts", PropertiesRepository
				.getBoolean("global.browser.capability.firefox.handlesAlerts"));
		cap.setCapability("cssSelectorsEnabled", PropertiesRepository
				.getBoolean("global.browser.capability.firefox.cssSelectorsEnabled"));
		cap.setCapability("marionette", true);
		firefoxUIDriverInstance = new FirefoxDriver(cap);
		return firefoxUIDriverInstance;
	}
	
	public WebDriver openProctorChromeDriver() {
		DesiredCapabilities cap = null;
		System.setProperty("webdriver.chrome.driver",
				PropertiesRepository.getString("global.browser.chrome.driver.executable"));
		cap = DesiredCapabilities.chrome();
		cap.setBrowserName(
				PropertiesRepository.getString("global.browser.capability.browserName.ch"));
		cap.setJavascriptEnabled(true);
		cap.setCapability("platform",
				PropertiesRepository.getString("global.browser.capability.platform"));
		cap.setCapability("takesScreenshot", PropertiesRepository
				.getBoolean("global.browser.capability.chrome.takesScreenshot"));
		cap.setCapability("handlesAlerts", PropertiesRepository
				.getBoolean("global.browser.capability.chrome.handlesAlerts"));
		cap.setCapability("cssSelectorsEnabled", PropertiesRepository
				.getBoolean("global.browser.capability.chrome.cssSelectorsEnabled"));

		ChromeOptions options = new ChromeOptions();
		options.addArguments("chrome.switches","--disable-extensions"); // To "Disable developer mode extensions"
		String extensions = PropertiesRepository
				.getString("global.browser.capability.chrome.extensions");
		if (extensions != null && !extensions.trim().equals("")) {
			StringTokenizer tokens = new StringTokenizer(extensions, ",");
			String extensionPath = PropertiesRepository
					.getString("global.browser.capability.chrome.extensionpath");
			File[] extFiles = new File[tokens.countTokens()];
			int i = 0;
			while (tokens.hasMoreElements()) {
				extFiles[i] = new File(extensionPath + "/" + tokens.nextToken());
				i++;
			}
			options.addExtensions(extFiles);
		}

		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_settings.popups", 0);
		prefs.put("download.prompt_for_download", false);
		prefs.put("download.default_directory",
				PropertiesRepository.getString("global.download.location"));

		options.setExperimentalOption("prefs", prefs);

		cap.setCapability(ChromeOptions.CAPABILITY, options);
		
		chromeUIDriverInstance = new ChromeDriver(cap);
		return chromeUIDriverInstance;
	}
	
	public WebDriver openProctorIEDriver() {
		
		/*DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		DesiredCapabilities.internetExplorer().setCapability("ignoreProtectedModeSettings", true);
		
		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\iedriver\\IEDriverServer.exe");
		//capabilities.setCapability("IE.binary", "C:/Program Files (x86)/Internet Explorer/iexplore.exe");
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	    capabilities.setJavascriptEnabled(true);
	    capabilities.setCapability("requireWindowFocus", true);
	    capabilities.setCapability("enablePersistentHover", false);
	    secondUIDriverInstance = new InternetExplorerDriver(capabilities);
	    */
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		DesiredCapabilities.internetExplorer().setCapability("ignoreProtectedModeSettings", true);
		
		/*WindowsUtils.writeIntRegistryValue("IE8RunOnceLastShown", 1);
	    WindowsUtils.writeIntRegistryValue("IE8RunOncePerInstallCompleted", 1);
	    WindowsUtils.writeStringRegistryValue("IE8RunOnceCompletionTime", "");
	    WindowsUtils.writeIntRegistryValue("IE8TourShown", 1);
	    WindowsUtils.writeStringRegistryValue("IE8TourShownTime", "");
	    WindowsUtils.writeStringRegistryValue("IE8RunOnceLastShown", "");*/
	    
		System.setProperty("webdriver.ie.driver", "C:\\WebDrivers\\IEDriverServer.exe");
		secondUIDriverInstance = new InternetExplorerDriver(capabilities);
		return secondUIDriverInstance;
	}
	
	@Override
	public WebDriver getDriver() {
		// TODO Auto-generated method stub
		return this.driver;
	}
}
