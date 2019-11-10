package com.ascendlearning.automation.ui.driver;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.ascendlearning.automation.ui.config.GlobalProperties;
import com.ascendlearning.automation.ui.config.PropertiesRepository;

import io.appium.java_client.remote.MobileCapabilityType;

public final class CapabilityGenerator {
	public static DesiredCapabilities getCapabilities(String browserType) {
		DesiredCapabilities cap = null;
		System.out.println("BROWSER : " + browserType);
		
		switch (browserType) {
			case GlobalProperties.FIREFOX:
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
				// Private Browser
				firefoxProfile.setPreference("browser.private.browsing.autostart",true);
				
				System.setProperty("webdriver.gecko.driver", PropertiesRepository.getString("global.browser.gecko.driver.executable"));
				cap = DesiredCapabilities.firefox();
				cap.setCapability(FirefoxDriver.PROFILE, firefoxProfile);
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
			
			break;
				
			case GlobalProperties.CHROME:
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
			// Clearing session. 
			cap.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
			
			// Opening incognito browser for clear cache. 
			cap.setCapability("chrome.switches", Arrays.asList("--incognito"));
			
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_settings.popups", 0);
			prefs.put("download.prompt_for_download", false);
			prefs.put("download.default_directory",
					PropertiesRepository.getString("global.download.location"));

			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			options.addArguments("chrome.switches","--disable-extensions"); // To "Disable developer mode extensions"
			options.addArguments("--test-type");
		    options.addArguments("--disable-extensions"); //to disable browser extension popup
		    options.addArguments("--incognito");
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

			options.setExperimentalOption("prefs", prefs);
			
			cap.setCapability(ChromeOptions.CAPABILITY, options);
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		    cap.setCapability(ChromeOptions.CAPABILITY, options);
			break;

			case GlobalProperties.IE:				
			cap = DesiredCapabilities.internetExplorer();
			System.setProperty("webdriver.ie.driver",
					PropertiesRepository.getString("global.browser.ie.driver.executable"));
			cap.setBrowserName(
					PropertiesRepository.getString("global.browser.capability.browserName.ie"));
			cap.setJavascriptEnabled(true);
			cap.setCapability("platform",
					PropertiesRepository.getString("global.browser.capability.platform"));
			cap.setCapability("takesScreenshot", PropertiesRepository
					.getBoolean("global.browser.capability.ie.takesScreenshot"));
			cap.setCapability("handlesAlerts",
					PropertiesRepository.getBoolean("global.browser.capability.ie.handlesAlerts"));
			cap.setCapability("cssSelectorsEnabled", PropertiesRepository
					.getBoolean("global.browser.capability.ie.cssSelectorsEnabled"));
			//cap.setCapability("requireWindowFocus", PropertiesRepository.getBoolean("global.browser.capability.ie.requireWindowFocus"));
			//cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			//cap.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS,true);
			//cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION,true);
			//cap.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING,false);
			//cap.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
			//cap.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, "accept");
			//cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			//cap.setCapability("nativeEvents", false);
			// Private Window. 
			//cap.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, true); 
			//cap.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
			break;
			
			case GlobalProperties.EDGE:				
				cap = DesiredCapabilities.edge();
				System.setProperty("webdriver.edge.driver",
						PropertiesRepository.getString("global.browser.edge.driver.executable"));
				cap.setBrowserName(PropertiesRepository.getString("global.browser.capability.browserName.edge"));
				cap.setJavascriptEnabled(true);
				cap.setCapability("platform",
						PropertiesRepository.getString("global.browser.capability.platform"));
				cap.setCapability("takesScreenshot", PropertiesRepository
						.getBoolean("global.browser.capability.edge.takesScreenshot"));
				cap.setCapability("handlesAlerts",
						PropertiesRepository.getBoolean("global.browser.capability.edge.handlesAlerts"));
				cap.setCapability("cssSelectorsEnabled", PropertiesRepository
						.getBoolean("global.browser.capability.edge.cssSelectorsEnabled"));
				
				cap.setCapability("requireWindowFocus", PropertiesRepository.getBoolean("global.browser.capability.edge.requireWindowFocus"));
				/*cap.setCapability(EdgeDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
				cap.setCapability(EdgeDriver.FORCE_CREATE_PROCESS,true);
				cap.setCapability(EdgeDriver.IE_ENSURE_CLEAN_SESSION,true);
				cap.setCapability(EdgeDriver.ENABLE_PERSISTENT_HOVERING,false);
				cap.setCapability(EdgeDriver.REQUIRE_WINDOW_FOCUS, false);
				cap.setCapability(EdgeDriver.UNEXPECTED_ALERT_BEHAVIOR, "accept");*/
				cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				cap.setCapability("nativeEvents", false);
				//Private Window. 
				/*cap.setCapability(EdgeDriver.FORCE_CREATE_PROCESS, true); 
				cap.setCapability(EdgeDriver.about:InPrivate, "-private");*/
				break;
			
			case GlobalProperties.ANDROID:
				cap = DesiredCapabilities.android();
				//cap.setCapability("platformVersion", "6.0.1");
				cap.setCapability(MobileCapabilityType.DEVICE_NAME, PropertiesRepository.getString("global.mobile.device.name"));
				cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
				cap.setCapability("platformName", "android");
				cap.setCapability("resetKeyboard", true);
				cap.setCapability("unicodeKeyboard", true);
			break;
			
			default:
			FirefoxProfile defaultProfile = new FirefoxProfile();
			defaultProfile.setPreference("browser.download.folderList", 2);
			defaultProfile.setPreference("browser.download.dir",
					PropertiesRepository.getString("global.download.location"));
			defaultProfile.setPreference("browser.download.alertOnEXEOpen", false);
			defaultProfile.setPreference("browser.helperApps.neverAsksaveToDisk",
					"application/x-msexcel,application/excel,application/x-excel,"
							+ "application/excel,application/x-excel,application/excel,"
							+ "application/vnd.ms-excel,application/x-excel,application/x-msexcel");
			defaultProfile.setPreference("browser.download.manager.showWhenStarting", false);
			defaultProfile.setPreference("browser.download.manager.focusWhenStarting", false);
			defaultProfile.setPreference("browser.helperApps.alwaysAsk.force", false);
			defaultProfile.setPreference("browser.download.manager.alertOnEXEOpen", false);
			defaultProfile.setPreference("browser.download.manager.closeWhenDone", false);
			defaultProfile.setPreference("browser.download.manager.showAlertOnComplete", false);
			defaultProfile.setPreference("browser.download.manager.useWindow", false);
			defaultProfile.setPreference("browser.download.manager.showWhenStarting", false);
			defaultProfile.setPreference(
					"services.sync.prefs.sync.browser.download.manager.showWhenStarting", false);
			defaultProfile.setPreference("pdfjs.disabled", true);

			cap = DesiredCapabilities.firefox();
			cap.setCapability(FirefoxDriver.PROFILE, defaultProfile);
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
		}		
		return cap;
	}
}
