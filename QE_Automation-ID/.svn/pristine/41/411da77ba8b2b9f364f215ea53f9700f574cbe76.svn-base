package com.automation.id.pages;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.TextHandler;

public class QuickReportPage extends IDBasePage {

	private Logger logger = LogManager.getLogger(this.getClass());
	private BaseHandler baseHandler;

	public QuickReportPage(WebDriver webDriver) {
		super(webDriver);
		baseHandler = new BaseHandler(driver);
		textHandler = new TextHandler(driver);
	}

	/**
	 * @author Syed.Hoque This method will enter data on quick report individual
	 *         report from quick report tab
	 * @throws DriverException
	 */

	public boolean generateResultQuickReportIndividualReport(String assessmentid) throws DriverException {
		logger.info(
				"Method: This method will enter data on quick report individual report from quick report tab:::START");
		boolean flag = false;
		try {

			switchToCardShadowFrame();
			List<WebElement> textElement = baseHandler.findElements(PropertiesRepository.getString("quickreport.individual.text"));
			if(CollectionUtils.isNotEmpty(textElement)) {
				textElement.get(0).sendKeys(assessmentid);
				
				List<WebElement> clickElement = baseHandler.findElements(PropertiesRepository.getString("quickreport.individual.buildbtn"));
				if(CollectionUtils.isNotEmpty(clickElement)) {
					clickElement.get(0).click();
					windowHandler.switchToLatestWindow();
					waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
					waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
					switchToCardShadowFrame();
					
					List<WebElement> printReportElement = baseHandler.findElements(PropertiesRepository.getString("quickreport.individual.printreport.btn"));
					if(CollectionUtils.isNotEmpty(printReportElement)) {
						printReportElement.get(0).click();
						windowHandler.switchToLatestWindow();
						waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
						flag = true;
					}
				}
			}
			
			/*baseHandler.findElement(PropertiesRepository.getString("quickreport.individual.text")).click();
			baseHandler.findElement(PropertiesRepository.getString("quickreport.individual.text"))
					.sendKeys(assessmentid);
			baseHandler.findElement(PropertiesRepository.getString("quickreport.individual.buildbtn")).click();
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			baseHandler.findElement(PropertiesRepository.getString("quickreport.individual.printreport.btn")).click();
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			windowHandler.switchToLatestWindow();
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));*/
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Not able to click generate report ");
			throw new DriverException("Not able to click generate report ");
		}
		logger.info(
				"Method: This method will enter data on quick report individual report from quick report tab:::END flag --> " + flag);
		return flag;
	}

	/**
	 * @author Syed.Hoque This method will click on Data extract tab
	 * @throws DriverException
	 */
	public boolean clicOnDataExtractTab() throws DriverException {
		logger.info("Methode :  clicOnDataExtractTab  :::::::::::START");
		boolean flag = false;
		try {
			switchToCardShadowFrame();
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("dataextract.btn"));
			if (org.apache.commons.collections.CollectionUtils.isNotEmpty(element)) {
				element.get(0).click();
				flag = true;
				windowHandler.switchToLatestWindow();
				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			}
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Not able to click on report wizard tab ");
			throw new DriverException("Not able to click on report wizard tab");
		}
		logger.info("Methode :  clicOnDataExtractTab  :::::::::::ENDS flag --> " + flag);
		return flag;
	}

	/**
	 * @author Syed.Hoque This method will click focused review tab
	 * @throws DriverException
	 */
	public boolean clickOnFocusedReviewTab() throws DriverException {
		logger.info("Methode :  clicOnFocusedReviewTab  :::::::::::START");
		boolean flag = false;
		try {
			switchToCardShadowFrame();
			List<WebElement> ele = baseHandler.findElements(PropertiesRepository.getString("focused.review.btn"));
			if (org.apache.commons.collections.CollectionUtils.isNotEmpty(ele)) {
//				ele.get(0).click();
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", ele.get(0));
				flag = true;
			}
			windowHandler.switchToLatestWindow();
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Not able to click on report wizard tab ");
			throw new DriverException("Not able to click on report wizard tab");
		}
		logger.info("Methode :  clicOnFocusedReviewTab  :::::::::::ENDS flag --> " + flag);
		return flag;
	}

	/**
	 * @author Syed.Hoque This method will click on Report wizard tab
	 */
	public void clickOnReportWizardTab() throws DriverException {
		logger.info("Methode :  clickOnReportWizardTab  :::::::::::START");

		try {
			switchToCardShadowFrame();
			baseHandler.findElement(PropertiesRepository.getString("report.wizard.tab")).click();
			windowHandler.switchToLatestWindow();
			//waitForAwhile(10000);
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Not able to click on report wizard tab ");
			throw new DriverException("Not able to click on report wizard tab");
		}
		logger.info("Methode :  clickOnReportWizardTab  :::::::::::END");
	}
	
	public boolean generateIndividualReportforPracticeNProctor(String assessmentid) throws DriverException {
		logger.info(
				"Method: This method will enter data on quick report individual report from quick report tab:::START");
		boolean flag = false;
		try {

			switchToCardShadowFrame();
			List<WebElement> textElement = baseHandler.findElements(PropertiesRepository.getString("quickreport.individual.text"));
			if(CollectionUtils.isNotEmpty(textElement)) {
				textElement.get(0).sendKeys(assessmentid);
				
				List<WebElement> clickElement = baseHandler.findElements(PropertiesRepository.getString("quickreport.individual.buildbtn"));
				if(CollectionUtils.isNotEmpty(clickElement)) {
					clickElement.get(0).click();
					windowHandler.switchToLatestWindow();
					waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
					switchToCardShadowFrame();
					
					String winHandleBefore =driver.getWindowHandle();
					
					List<WebElement> printReportElement = baseHandler.findElements(PropertiesRepository.getString("quickreport.individual.printreport.btn"));
					if(CollectionUtils.isNotEmpty(printReportElement)) {
						printReportElement.get(0).click();
						waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
						Thread.sleep(10000);
						for (String handle : driver.getWindowHandles()) {
						    if (!handle.equals(winHandleBefore)) {
						        driver.switchTo().window(handle);
						    	driver.close();
						    }
						}					
						Thread.sleep(5000);
					//	windowHandler.switchToMainWindow();
						flag = true;
						driver.switchTo().window(winHandleBefore);
					}
				}
			}
		
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Not able to click generate report ");
			throw new DriverException("Not able to click generate report ");
		}
		logger.info(
				"Method: This method will enter data on quick report individual report from quick report tab:::END flag --> " + flag);
		return flag;
	}
	
	public boolean clickOnDataExtractTab1() throws DriverException {
		logger.info("Methode :  clicOnDataExtractTab  :::::::::::START");
		boolean flag = false;
		try {
		switchToCardShadowFrame();
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("dataextract.btn"));
			if (org.apache.commons.collections.CollectionUtils.isNotEmpty(element)) {
				try {
					logger.info("Trying to click using Javascript click");
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", element.get(0));
					flag=true;
					Thread.sleep(5000);
				} catch(Exception e) {
					logger.info("Unable to click using Javascript");
				}
				
//				element.get(0).click();
//				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
//				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
//				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
//				flag = true;
				windowHandler.switchToLatestWindow();
					}
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Not able to click on report wizard tab ");
			throw new DriverException("Not able to click on report wizard tab");
		}
		logger.info("Methode :  clicOnDataExtractTab  :::::::::::ENDS flag --> " + flag);
		return flag;
	}

	public boolean clickOnCustomReportsTab() throws DriverException {
		logger.info("Methode :  clicOnCustomReportsTab  :::::::::::START");
		boolean flag = false;
		try {
			switchToCardShadowFrame();
			List<WebElement> ele = baseHandler.findElements(PropertiesRepository.getString("quickreports.customreport.tab"));
			if (org.apache.commons.collections.CollectionUtils.isNotEmpty(ele)) {
//				ele.get(0).click();
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", ele.get(0));
				flag = true;
			}
			windowHandler.switchToLatestWindow();
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Not able to click on CustomReportsTab ");
			throw new DriverException("Not able to click on CustomReportsTab");
		}
		logger.info("Methode :  clicOnCustomReportsTab  :::::::::::ENDS flag --> " + flag);
		return flag;
	}
}
