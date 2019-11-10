package com.automation.id.pages;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.TextHandler;

public class ReportWizardPage extends ReportWizardReportPage {

	private Logger logger = LogManager.getLogger(this.getClass());
	private BaseHandler baseHandler;

	public ReportWizardPage(WebDriver webDriver) {
		super(webDriver);
		baseHandler = new BaseHandler(driver);
		textHandler = new TextHandler(driver);
	}

	/**
	 * @author Syed.Hoque This method will click on group report build button
	 * @throws DriverException
	 */
	public void clikOnBuildBtnForGroupReport() throws DriverException {
		logger.info("clikOnBuildBtnForGroupReport ::: Start");
		try {
			switchToCardShadowFrame();
			baseHandler.findElement(PropertiesRepository.getString("reportwizard.group.build.btn")).click();
			windowHandler.switchToLatestWindow();
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		} catch (Exception e) {
			logger.info("Unable to clikOnBuildBtnForGroupReport ");
			log(logger, "Unable to clikOnBuildBtnForGroupReport");
			throw new DriverException("Unable to clikOnBuildBtnForGroupReport", e);
		}
		logger.info("clikOnBuildBtnForGroupReport ::: END");
	}

	/**
	 * @author Syed.Hoque This method will select custom group of student for
	 *         radio button
	 * @throws DriverException
	 */

	public void selectCustomeGroupOfStudent() throws DriverException {
		logger.info("selectCustomeGroupOfStudent ::: STARTs");
		try {
			switchToCardShadowFrame();
			baseHandler.findElement(PropertiesRepository.getString("customgroup.radio.btn")).click();
			// click on continue btn
			baseHandler.findElement(PropertiesRepository.getString("reportwizard.radio.option.continue.btn")).click();
			windowHandler.switchToLatestWindow();
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			// verify crate new group btn is present
		} catch (Exception e) {
			logger.info("Unable to selectCustomeGroupOfStudent ");
			log(logger, "Unable to selectCustomeGroupOfStudent");
			throw new DriverException("Unable to selectCustomeGroupOfStudent", e);
		}
		logger.info("selectCustomeGroupOfStudent ::: END");
	}

	/**
	 * @author Syed.Hoque This method will verify create new group button is
	 *         present under report wizard custome group
	 * @return
	 * @throws DriverException
	 */
	public boolean verifyCreateNewGrpButton() throws DriverException {
		boolean flag = false;
		try {
			switchToCardShadowFrame();
			WebElement webElement = baseHandler
					.findElement(PropertiesRepository.getString("reportwizard.crete.new.group.btn"));
			if (webElement.isDisplayed() == true) {
				flag = true;
			}
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			logger.info("Unable to verifyCreateNewGrpButton ");
			log(logger, "Unable to verifyCreateNewGrpButton");
			throw new DriverException("Unable to verifyCreateNewGrpButton", e);
		}
		logger.info("Method: verifyCreateNewGrpButton End " + flag);
		return flag;
	}

	/**
	 * @author Syed.Hoque this method will click on radio button of the custom
	 *         group
	 * @throws DriverException
	 */
	public void clickOnCutomGroupRadioBtnFromTable() throws DriverException {
		logger.info("clickOnCutomGroupRadioBtnFromTable ::: START");
		try {
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			switchToCardShadowFrame();
			// click on radio btn from the custom group table
			List<WebElement> customGrpTableElement = baseHandler.findElements(PropertiesRepository.getString("reportwizard.customegroup.radio.btn1"));
			logger.info("Size of radio btn from the custom group table --> " + customGrpTableElement.size());
			if(CollectionUtils.isNotEmpty(customGrpTableElement)) {
				try {
					logger.info("Trying to click using webdriver click");
					customGrpTableElement.get(0).click();
				} catch (Exception e) {
					logger.info("Unable to click using normal webdriver click");
				}
				
				try {
					logger.info("Trying to click using Javascript click");
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", customGrpTableElement.get(0));
				} catch(Exception e) {
					logger.info("Unable to click using Javascript");
				}
			}
			windowHandler.switchToLatestWindow();
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			
			// click on continue button
			switchToCardShadowFrame();
			List<WebElement> continueBtnElement = baseHandler.findElements(PropertiesRepository.getString("reportwizard.crete.new.group.continue.btn"));
			logger.info("Size of continue button --> " + continueBtnElement.size());
			if(CollectionUtils.isNotEmpty(continueBtnElement)) {
				try {
					logger.info("Trying to click using webdriver click");
					continueBtnElement.get(0).click();
				} catch (Exception e) {
					logger.info("Unable to click using normal webdriver click");
				}
				
				try {
					logger.info("Trying to click using Javascript click");
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", continueBtnElement.get(0));
				} catch(Exception e) {
					logger.info("Unable to click using Javascript");
				}
			}
					
			windowHandler.switchToLatestWindow();
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		} catch (Exception e) {
			logger.info("Unable to clickOnCutomGroupRadioBtnFromTable ");
			log(logger, "Unable to clickOnCutomGroupRadioBtnFromTable");
			throw new DriverException("Unable to clickOnCutomGroupRadioBtnFromTable", e);
		}
		logger.info("clickOnCutomGroupRadioBtnFromTable ::: END");
	}

	/**
	 * @author Syed.Hoque verify that proctor and practice assesmsent tabs are
	 *         dispalying
	 * @throws DriverException
	 */
	public boolean verifygroupReportProctorPracticeTab() throws DriverException {
		boolean flag = false;
		logger.info("verifygroupReportProctorPracticeTab ::: START");
		try {
			switchToCardShadowFrame();
			// List<WebElement>
			// element=baseHandler.findElements(PropertiesRepository.getString("reportwizard.proctor.practicie.tab"));
			WebElement webElement1 = baseHandler
					.findElement(PropertiesRepository.getString("reportwizard.proctor.tab"));
			WebElement webElement2 = baseHandler
					.findElement(PropertiesRepository.getString("reportwizard.practice.tab"));

			if (webElement1.isDisplayed() || webElement2.isDisplayed() == true) {
				flag = true;
			}
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			logger.info("Unable to verifygroupReportProctorPracticeTab ");
			log(logger, "Unable to verifygroupReportProctorPracticeTab");
			throw new DriverException("Unable to verifygroupReportProctorPracticeTab", e);
		}
		logger.info("Method: verifygroupReportProctorPracticeTab End " + flag);
		return flag;
	}

	/**
	 * @author Syed.Hoque This method will click on any one 1st peroctor
	 *         assessment from proctor assessment table
	 * @throws DriverException
	 */

	public boolean clickOnAssessmentPool() throws DriverException {
		logger.info("clickOnAssessmentPool ::: START");
		boolean flag = false;
		try {
			switchToCardShadowFrame();
			baseHandler.findElement(PropertiesRepository.getString("reprotwizard.assessment.pool.name")).click();
			windowHandler.switchToLatestWindow();
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			//waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			//waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			//waitForAwhile(8000);

			// send date
			switchToCardShadowFrame();
			baseHandler.findElement(PropertiesRepository.getString("reportwizard.date.text")).clear();
			baseHandler.findElement(PropertiesRepository.getString("reportwizard.date.text")).sendKeys("02/03/2000");
			baseHandler.findElement(PropertiesRepository.getString("reportwizard.applyfilter.btn")).click();
			windowHandler.switchToLatestWindow();
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			//waitForAwhile(10000);
			//scrollDown();
			// click on assessment id
			switchToCardShadowFrame();
			List<WebElement> tableElementList = baseHandler
					.findElements("a[id*='lblAssessmentIDItem']");

			if (org.apache.commons.collections.CollectionUtils.isNotEmpty(tableElementList)) {
				WebElement tableElement = tableElementList.get(1);
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tableElement);
				tableElement.click();
				logger.info("Assessment id is clicked");
			} else {
				logger.info("Assessment id is not clicked");
			}
			windowHandler.switchToLatestWindow();
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			// click on generate report button
			switchToCardShadowFrame();
			List<WebElement> generateReportBtn = baseHandler.findElements(PropertiesRepository.getString("reportwizard.generatereport.btn"));
			if(CollectionUtils.isNotEmpty(generateReportBtn)) {
				logger.info("Generate Report Button is displayed");
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", generateReportBtn.get(0));
				generateReportBtn.get(0).click();
			}
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			Thread.sleep(2000);
			windowHandler.switchToLatestWindow();
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			
			switchToCardShadowFrame();
			List<WebElement> dataExtractOptionElement = baseHandler
					.findElements("#ctl00_contentPlaceHolderBody_ReportWizardNavigationControl1_ucViewContainer_btnDataExtractOption");
			if(CollectionUtils.isNotEmpty(dataExtractOptionElement)) {
				flag = true;
			}
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to clickOnAssessmentPool ");
			log(logger, "Unable to clickOnAssessmentPool");
			throw new DriverException("Unable to clickOnAssessmentPool", e);
		}
		logger.info("clickOnAssessmentPool ::: ENDS flag --> " + flag);
		return flag;
	}

	/**
	 * @author Syed.Hoque This method will click on data extract option
	 * @throws DriverException
	 */
	public void scrollUp() {
		try {

			WebElement footertext = baseHandler.findElement(PropertiesRepository.getString("report.footer.text"));
			footertext.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN);

		} catch (Exception e) {

		}
	}

	/**
	 * @author Syed.Hoque This method will scroll down of the page
	 * @throws DriverException
	 */
	public void scrollDown() {
		try {
			switchToCardShadowFrame();
			WebElement footertext = baseHandler
					.findElement(PropertiesRepository.getString("discover.report.wizard.ele"));
			footertext.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN,
					Keys.ARROW_DOWN);
			windowHandler.switchToLatestWindow();

		} catch (Exception e) {

		}
	}

	/**
	 * @author Syed.Hoque This method will scroll down of the page
	 * @throws Exception 
	 */
	public void scrollUP() throws Exception {
		try {
			switchToCardShadowFrame();
			WebElement footertext = baseHandler
					.findElement(PropertiesRepository.getString("reportwizrd.valid.assessment.ctn1"));
			footertext.sendKeys(Keys.ARROW_UP, Keys.ARROW_UP, Keys.ARROW_UP, Keys.ARROW_UP);
			Thread.sleep(2000);
			windowHandler.switchToLatestWindow();

		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			throw new DriverException("Unable to scroll up", e);
		}
	}

	/**
	 * @author Syed.Hoque This method will scroll down of the page
	 * @throws Exception 
	 */
	public void scrollUPWithOutSwitchToCardShowFrame(WebElement element) throws Exception {
		logger.info("");
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",element);

		} catch (Exception e) {
			throw new DriverException("Unable to scroll up", e);
		}
	}

	
	/*
	 * public void clickOnDataExtractBtn() throws DriverException{ logger.info(
	 * "clickOnDataExtractBtn ::: START"); try{ WebElement
	 * footertext=baseHandler.findElement(PropertiesRepository.getString(
	 * "report.footer.text")); footertext.sendKeys(Keys.ARROW_UP,Keys.ARROW_UP);
	 * 
	 * switchToCardShadowFrame(); List<WebElement> tableElementList1 =
	 * baseHandler.findElements(PropertiesRepository.getString(
	 * "custoomereport.tab"));
	 * if(org.apache.commons.collections.CollectionUtils.isNotEmpty(
	 * tableElementList1)) { WebElement tableElement1 =
	 * tableElementList1.get(0); ((JavascriptExecutor)
	 * driver).executeScript("arguments[0].scrollIntoView(true);",
	 * tableElement1);
	 * 
	 * } List<WebElement> tableElementList =
	 * baseHandler.findElements(PropertiesRepository.getString(
	 * "reportwizard.dataextract.option"));
	 * if(org.apache.commons.collections.CollectionUtils.isNotEmpty(
	 * tableElementList)) { WebElement tableElement = tableElementList.get(0);
	 * ((JavascriptExecutor)
	 * driver).executeScript("arguments[0].scrollIntoView(true);",
	 * tableElement); tableElement.click(); }
	 * //baseHandler.findElement(PropertiesRepository.getString(
	 * "reportwizard.dataextract.option")).click();
	 * //waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString(
	 * "id.common.page.loader")); windowHandler.switchToLatestWindow();
	 * }catch(Exception e){ logger.info("Unable to clickOnDataExtractBtn ");
	 * log(logger, "Unable to clickOnDataExtractBtn" ); throw new
	 * DriverException("Unable to clickOnDataExtractBtn" , e); } logger.info(
	 * "clickOnDataExtractBtn ::: ENDS"); }
	 */

	/*
	 * public void clickDataExtract() throws DriverException{ logger.info(
	 * "clickOnDataExtractBtn ::: START"); try{ switchToCardShadowFrame();
	 * baseHandler.findElement(PropertiesRepository.getString(
	 * "reportwizard.dataextract.option")).click();
	 * 
	 * }catch(Exception e){ logger.info("Unable to clickOnDataExtractBtn ");
	 * log(logger, "Unable to clickOnDataExtractBtn" ); throw new
	 * DriverException("Unable to clickOnDataExtractBtn" , e); } logger.info(
	 * "clickOnDataExtractBtn ::: ENDS"); }
	 */

	/**
	 * @author Syed.Hoque This method will click on build button for critical
	 *         thinking analysis report
	 */

	public boolean clikOnBuildBtnForCriticalThinkingReport() throws DriverException {
		logger.info("clikOnBuildBtnForCriticalThinkingReport ::: Start");
		boolean flag = false;
		try {
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			switchToCardShadowFrame();
			//waitForAwhile(800);
			List<WebElement> ele = baseHandler
					.findElements(PropertiesRepository.getString("reportwizard.critiaclthinking.buildbtn"));
			if (CollectionUtils.isNotEmpty(ele)) {
				ele.get(0).click();
				flag = true;
				//waitForAwhile(1000);
			}
			windowHandler.switchToLatestWindow();
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to clikOnBuildBtnForCriticalThinkingReport ");
			log(logger, "Unable to clikOnBuildBtnForCriticalThinkingReport");
			throw new DriverException("Unable to clikOnBuildBtnForCriticalThinkingReport", e);
		}
		logger.info("clikOnBuildBtnForCriticalThinkingReport ::: END flag --> " + flag);
		return flag;
	}

	/**
	 * This method will click on click on continue button with iframe
	 * 
	 * @author Syed.Hoque
	 */

	public void clikOnIframeContinueBtn(String loc) throws DriverException {
		logger.info("clikOnIframeContinueBtn ::: Start");
		try {

			switchToCardShadowFrame();
			baseHandler.findElement(PropertiesRepository.getString(loc)).click();
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			logger.info("Unable to clikOnIframeContinueBtn ");
			log(logger, "Unable to clikOnIframeContinueBtn");
			throw new DriverException("Unable to clikOnIframeContinueBtn", e);
		}
		logger.info("clikOnIframeContinueBtn ::: END");
	}

	/**
	 * @author Syed.Hoque This method will select custom group of student for
	 *         radio button for critical thinking analysis
	 * @throws DriverException
	 */

	public boolean selectOneOrMoreStudentRadioBtn() throws DriverException {
		logger.info("selectCustomeGroupOfStudent ::: STARTs");
		boolean flag = false;
		try {
			switchToCardShadowFrame();
			List<WebElement> ele = baseHandler
					.findElements(PropertiesRepository.getString("reportwizard.radio.option.critical.continue.btns"));
			if (CollectionUtils.isNotEmpty(ele)) {
				ele.get(0).click();
				flag = true;
			}
			windowHandler.switchToLatestWindow();
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		} catch (Exception e) {
			logger.info("Unable to selectOneOrMoreStudentRadioBtn ");
			log(logger, "Unable to selectOneOrMoreStudentRadioBtn");
			throw new DriverException("Unable to selectOneOrMoreStudentRadioBtn", e);
		}
		logger.info("selectOneOrMoreStudentRadioBtn ::: END flag --> " + flag );
		return flag;
	}

	/**
	 * @author Syed.Hoque this method will select student form current search
	 *         result to selected student
	 * @throws DriverException
	 */
	public boolean selectStudentFormTable() throws DriverException {
		logger.info("selectStudentFormTable ::: STARTs");
		boolean flag = false;
		boolean boolSelectStudent = false;
		boolean boolRightArrow = false;
		boolean boolContinueBtn = false;
		
		try {
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			switchToCardShadowFrame();
			// select a student
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("reprotwizard.critical.studentlist"));
			if (org.apache.commons.collections.CollectionUtils.isNotEmpty(element)) {
				element.get(0).click();
				logger.info("select a student");
				boolSelectStudent = true;
			}
			// click on right arrow btn
			List<WebElement> elementbtn = baseHandler
					.findElements(PropertiesRepository.getString("reportwizard.critical.right.btn"));
			if (CollectionUtils.isNotEmpty(elementbtn)) {
				elementbtn.get(0).click();
				logger.info("click on right arrow btn");
				boolRightArrow = true;
			}
			windowHandler.switchToLatestWindow();
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			switchToCardShadowFrame();
			// click on continue btn
			List<WebElement> ctnbtn = baseHandler
					.findElements(PropertiesRepository.getString("reportwizard.critical.right.ctnbtn"));
			logger.info("Size of continue button locator --> " + ctnbtn.size());
			if (CollectionUtils.isNotEmpty(ctnbtn) && ctnbtn.size() > 0) {
				try {
					logger.info("Trying to click using webdriver click");
					ctnbtn.get(0).click();
				} catch (Exception e) {
					logger.info("Unable to click using normal webdriver click");
				}
				
				try {
					logger.info("Trying to click using Javascript click");
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", ctnbtn.get(0));
				} catch(Exception e) {
					logger.info("Unable to click using Javascript");
				}
				
				logger.info("click on continue btn");
				boolContinueBtn = true;
			}
			windowHandler.switchToLatestWindow();
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			if(boolSelectStudent && boolRightArrow && boolContinueBtn) { 
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to selectStudentFormTable ");
			log(logger, "Unable to selectStudentFormTable");
			throw new DriverException("Unable to selectStudentFormTable", e);
		}
		logger.info("selectStudentFormTable ::: ENDS flag --> " + flag);
		return flag;
	}

	/**
	 * @author Syed.Hoque This method will click on as group print to pdf btn
	 *         for critical thinking
	 * @throws DriverException
	 */

	public boolean clickAsGroupPrintBtn() throws DriverException {
		logger.info("clickAsGroupPrintBtn ::: STARTs");
		boolean flag = false;
		try {
			switchToCardShadowFrame();
			List<WebElement> ele = baseHandler
					.findElements(PropertiesRepository.getString("reportwizard.critical.asgroup.printbtn"));
			if (CollectionUtils.isNotEmpty(ele)) {
				ele.get(0).click();
				flag = true;
				//waitForAwhile(8000);
			}
			windowHandler.switchToLatestWindow();
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		} catch (Exception e) {
			logger.info("Unable to clickAsGroupPrintBtn ");
			log(logger, "Unable to clickAsGroupPrintBtn");
			throw new DriverException("Unable to clickAsGroupPrintBtn", e);
		}
		logger.info("clickAsGroupPrintBtn ::: ENDS flag --> "  + flag);
		return flag;
	}

	/**
	 * @author Syed.Hoque This method will click on data extract btn critical
	 *         thinking
	 * @throws DriverException
	 */

	public boolean clickOnDataExtractBtnFroCritical() throws DriverException {
		logger.info("clickAsGroupPrintBtn ::: STARTs");
		boolean flag = false;
		try {
			switchToCardShadowFrame();
			List<WebElement> ele = baseHandler
					.findElements(PropertiesRepository.getString("reportwizard.staextract.btn"));
			if (CollectionUtils.isNotEmpty(ele)) {
				ele.get(0).click();
				flag = true;
				//waitForAwhile(8000);
			}
			windowHandler.switchToLatestWindow();
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		} catch (Exception e) {
			logger.info("Unable to clickOnDataExtractBtnFroCritical ");
			log(logger, "Unable to clickOnDataExtractBtnFroCritical");
			throw new DriverException("Unable to clickOnDataExtractBtnFroCritical", e);
		}
		logger.info("clickOnDataExtractBtnFroCritical ::: ENDS flag --> " + flag);
		return flag;
	}

	/**
	 * @author Syed.Hoque This method will click csv and excel btn
	 * @throws DriverException
	 */

	public boolean clickCsvXmlBtn() throws DriverException {
		logger.info("clickCsvXmlBttn ::: START");
		boolean flag = false;
		boolean boolCSV = false;
		boolean boolXML = false;
		
		try {
			switchToCardShadowFrame();
			WebElement elee = baseHandler
					.findElement(PropertiesRepository.getString("reportwizard.individualreport.previous.btn"));
			elee.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN);
			// click on csv
			List<WebElement> ele = baseHandler.findElements(PropertiesRepository.getString("criticalthinking.cvs.btn"));
			logger.info("Size of csv button locator --> " + ele.size());
			if (CollectionUtils.isNotEmpty(ele)) {
				logger.info("click on csv");
				try {
					logger.info("Trying to click using webdriver click");
					ele.get(0).click();
				} catch (Exception e) {
					logger.info("Unable to click using normal webdriver click");
				}
				
				try {
					logger.info("Trying to click using Javascript click");
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", ele.get(0));
				} catch(Exception e) {
					logger.info("Unable to click using Javascript");
				}
				boolCSV = true;
			}
			waitForAwhile(5000);
			// click on xml
			List<WebElement> ele1 = baseHandler
					.findElements(PropertiesRepository.getString("criticalthinking.xml.btn"));
			logger.info("Size of xml button locator --> " + ele1.size());
			if (CollectionUtils.isNotEmpty(ele1)) {
				logger.info("click on xml");
				try {
					logger.info("Trying to click using webdriver click");
					ele1.get(0).click();
				} catch (Exception e) {
					logger.info("Unable to click using normal webdriver click");
				}
				
				try {
					logger.info("Trying to click using Javascript click");
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", ele1.get(0));
				} catch(Exception e) {
					logger.info("Unable to click using Javascript");
				}
				boolXML = true;
			}
			windowHandler.switchToLatestWindow();
			if(boolCSV && boolXML) {
				flag = true;
			}
 		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to clickCsvXmlBttn ");
			log(logger, "Unable to clickCsvXmlBttn");
			throw new DriverException("Unable to clickCsvXmlBttn", e);
		}
		logger.info("clickCsvXmlBttn ::: ENDS flag --> " + flag);
		return flag;
	}

	/**
	 * @author Syed.Hoque This method will click on individual report btn
	 * @throws DriverException
	 */
	public void clickOnIndividualReportbtn() throws DriverException {
		logger.info("clickOnIndividualReportbtn ::: START");
		try {
			switchToCardShadowFrame();
			baseHandler.findElement(PropertiesRepository.getString("reportwizard.individual.report.btn")).click();
			waitForAwhile(8000);
			windowHandler.switchToLatestWindow();
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to clickOnIndividualReportbtn ");
			log(logger, "Unable to clickOnIndividualReportbtn");
			throw new DriverException("Unable to clickOnIndividualReportbtn", e);
		}
		logger.info("clickOnIndividualReportbtn ::: ENDS");
	}

	/**
	 * @author Syed.Hoque This method will select custom group of student for
	 *         radio button for individual report
	 * @throws DriverException
	 */

	public void selectOneOrMoreStudentRadioBtnIndividual() throws DriverException {
		logger.info("selectOneOrMoreStudentRadioBtnIndividual ::: STARTs");
		try {
			switchToCardShadowFrame();
			// baseHandler.findElement(PropertiesRepository.getString("customgroup.radio.btn")).click();
			// click on continue btn
			baseHandler.findElement(PropertiesRepository.getString("reportwizard.individual.report.ctn")).click();
			windowHandler.switchToLatestWindow();
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			// verify crate new group btn is present
		} catch (Exception e) {
			logger.info("Unable to selectOneOrMoreStudentRadioBtnIndividual ");
			log(logger, "Unable to selectOneOrMoreStudentRadioBtnIndividual");
			throw new DriverException("Unable to selectOneOrMoreStudentRadioBtnIndividual", e);
		}
		logger.info("selectOneOrMoreStudentRadioBtnIndividual ::: END");
	}

	/**
	 * @author Syed.Hoque this method select a assessment from valid assessment
	 *         table to select assessment table
	 * @throws DriverException
	 */

	public boolean selectAssessmentFromValidAssessmentTable() throws DriverException {
		logger.info("selectAssessmentFromValidAssessmentTable ::: START");
		boolean flag = false;
		boolean boolAssessmentName = false;
		boolean boolRightArrow = false;
		boolean boolContinueBtn = false;
		
		try {
			switchToCardShadowFrame();
			List<WebElement> ele = baseHandler
					.findElements(PropertiesRepository.getString("reportwizrd.valid.assessment.name"));
			if (CollectionUtils.isNotEmpty(ele)) {
				ele.get(0).click();
				boolAssessmentName = true;
			}
			// click on right arrow btn
			List<WebElement> ele1 = baseHandler
					.findElements(PropertiesRepository.getString("reportwizrd.valid.assessment.right.arrow"));
			if (CollectionUtils.isNotEmpty(ele1)) {
				ele1.get(0).click();
				boolRightArrow = true;
				windowHandler.switchToLatestWindow();
				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			}
			// click on continue button
			switchToCardShadowFrame();
			List<WebElement> ele2 = baseHandler
					.findElements(PropertiesRepository.getString("reportwizrd.valid.assessment.ctn"));
			logger.info("Size of continue button locator --> " + ele2.size());
			if (CollectionUtils.isNotEmpty(ele2)) {
				try {
					logger.info("Trying to click using webdriver click");
					ele2.get(0).click();
				} catch (Exception e) {
					logger.info("Unable to click using normal webdriver click");
				}
				
				try {
					logger.info("Trying to click using Javascript click");
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", ele2.get(0));
				} catch(Exception e) {
					logger.info("Unable to click using Javascript");
				}
				boolContinueBtn = true;
			}
			windowHandler.switchToLatestWindow();
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			if(boolAssessmentName && boolRightArrow && boolContinueBtn) {
				flag = true;
			}
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to selectAssessmentFromValidAssessmentTable ");
			log(logger, "Unable to selectAssessmentFromValidAssessmentTable");
			throw new DriverException("Unable to selectAssessmentFromValidAssessmentTable", e);
		}
		logger.info("selectAssessmentFromValidAssessmentTable ::: END flag --> " + flag);
		return flag;
	}

	/**
	 * This method is unique which will click any web element inside frames for
	 * report wizard page
	 * 
	 * @author Syed.Hoque
	 * @throws DriverException
	 */
	public boolean clickOnElementInFrame(String webelement) throws DriverException {
		logger.info("clickOnElementInFrame ::: START");
		boolean flag = false;
		try {
			switchToCardShadowFrame();
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString(webelement));
			if (CollectionUtils.isNotEmpty(element)) {
				element.get(0).click();
				flag = true;
				//Thread.sleep(2000);
			}
			windowHandler.switchToLatestWindow();
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to clickOnElementInFrame ");
			log(logger, "Unable to clickOnElementInFrame");
			throw new DriverException("Unable to clickOnElementInFrame ", e);
		}
		logger.info("clickOnElementInFrame ::: END flag --> " + flag);
		return flag;
	}

	/**
	 * @author Syed.Hoque This method will select continue btn from configure
	 *         the reports page for individual report
	 * @throws DriverException
	 */

	public boolean clickOncontinueBtnFromConfigureReportPage() throws DriverException {
		logger.info("clickOncontinueBtnFromConfigureReportPage ::: START");
		boolean flag = false;
		try {
			switchToCardShadowFrame();
			List<WebElement> ele = baseHandler
					.findElements(PropertiesRepository.getString("reportwizrd.valid.assessment.ctn1"));
			logger.info("Size of continue button locator --> " + ele.size());
			if (CollectionUtils.isNotEmpty(ele)) {
				try {
					logger.info("Trying to click using webdriver click");
					ele.get(0).click();
				} catch (Exception e) {
					logger.info("Unable to click using normal webdriver click");
				}
				
				try {
					logger.info("Trying to click using Javascript click");
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", ele.get(0));
				} catch(Exception e) {
					logger.info("Unable to click using Javascript");
				}
				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				flag = true;
			}
			windowHandler.switchToLatestWindow();
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		} catch (Exception e) {
			logger.info("Unable to clickOncontinueBtnFromConfigureReportPage ");
			log(logger, "Unable to clickOncontinueBtnFromConfigureReportPage");
			throw new DriverException("Unable to clickOncontinueBtnFromConfigureReportPage", e);
		}
		logger.info("clickOncontinueBtnFromConfigureReportPage ::: END flag -->" + flag);
		return flag;
	}

	/**
	 * @author Syed.Hoque this method will click on print individual report btn
	 * @throws DriverException
	 */
	public void clickOnIndividualReportPrintBtn() throws DriverException {
		logger.info("clickOnIndividualReportPrintBtn ::: START");
		try {
			switchToCardShadowFrame();
			List<WebElement> ele = baseHandler
					.findElements(PropertiesRepository.getString("reportwizard.printindividual.btn"));
			if (CollectionUtils.isNotEmpty(ele)) {
				ele.get(0).click();
				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				Thread.sleep(800);
			}
			windowHandler.switchToLatestWindow();
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		} catch (Exception e) {
			logger.info("Unable to clickOnIndividualReportPrintBtn ");
			log(logger, "Unable to clickOnIndividualReportPrintBtn");
			throw new DriverException("Unable to clickOnIndividualReportPrintBtn", e);
		}
		logger.info("clickOnIndividualReportPrintBtn ::: END");
	}

	/**
	 * @author Syed.Hoque This method will click on data extract option for
	 *         individual report btn
	 * @throws DriverException
	 */

	public void clikOnIndividualReportdataExtract() throws DriverException {
		logger.info("clikOnIndividualReportdataExtract ::: START");
		try {
			switchToCardShadowFrame();
			List<WebElement> ele = baseHandler
					.findElements(PropertiesRepository.getString("reportwizard.dataextract.option"));
			if (CollectionUtils.isNotEmpty(ele)) {
				ele.get(0).click();
				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			}
			windowHandler.switchToLatestWindow();
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		} catch (Exception e) {
			logger.info("Unable to clikOnIndividualReportdataExtract ");
			log(logger, "Unable to clikOnIndividualReportdataExtract");
			throw new DriverException("Unable to clikOnIndividualReportdataExtract", e);
		}
		logger.info("clikOnIndividualReportdataExtract ::: END");
	}

	/**
	 * This method will select date
	 * 
	 * @author Syed.Hoque
	 * @throws DriverException
	 */

	public void sendDateInTextField() throws DriverException {
		logger.info("sendDateInTextField ::: START");
		try {
			switchToCardShadowFrame();
			baseHandler.findElement(PropertiesRepository.getString("reportwizard.date.text")).clear();
			baseHandler.findElement(PropertiesRepository.getString("reportwizard.date.text")).sendKeys("10/13/2015");
			baseHandler.findElement(PropertiesRepository.getString("reportwizard.applyfilter.btn")).click();
			// waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

			windowHandler.switchToLatestWindow();
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		} catch (Exception e) {
			logger.info("Unable to clikOnIndividualReportdataExtract ");
			log(logger, "Unable to clikOnIndividualReportdataExtract");
			throw new DriverException("Unable to clikOnIndividualReportdataExtract", e);
		}
		logger.info("sendDateInTextField ::: END");
	}

	/**
	 * This method will send date to the TEAS/Discover report text field for
	 * filtering
	 * 
	 * @author Syed.Hoque
	 * @throws DriverException
	 */

	public void sendDateTeasDiscover(String date) throws DriverException {
		logger.info("sendDateTeasDiscover ::: END");
		try {
			switchToCardShadowFrame();
			List<WebElement> ele = baseHandler
					.findElements(PropertiesRepository.getString("reportwizard.teas.discover.date.text"));
			if (CollectionUtils.isNotEmpty(ele)) {
				ele.get(0).clear();
				ele.get(0).sendKeys(date);
				baseHandler.findElement(PropertiesRepository.getString("discover.report.wizard.ele")).click();

			}
			windowHandler.switchToLatestWindow();
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		} catch (Exception e) {
			logger.info("Unable to send date to sendDateTeasDiscover ");
			log(logger, "Unable to send date to sendDateTeasDiscover");
			throw new DriverException("Unable to send date to sendDateTeasDiscover", e);
		}
		logger.info("sendDateTeasDiscover ::: END");
	}

	/**
	 * @author Syed.Hoque This mehtod will click one assessment from proctor
	 *         grid
	 */

	public void clikOnProctorAssessment() throws DriverException {
		logger.info("clikOnIndividualReportdataExtract ::: START");
		try {
			switchToCardShadowFrame();
			List<WebElement> ele = baseHandler
					.findElements(PropertiesRepository.getString("reportwizard.proctor.assessment.id"));
			if (CollectionUtils.isNotEmpty(ele)) {
				ele.get(0).click();
				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				waitForAwhile(60000);
			}
			windowHandler.switchToLatestWindow();
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		} catch (Exception e) {
			logger.info("Unable to clikOnIndividualReportdataExtract ");
			log(logger, "Unable to clikOnIndividualReportdataExtract");
			throw new DriverException("Unable to clikOnIndividualReportdataExtract", e);
		}
		logger.info("clikOnIndividualReportdataExtract ::: END");
	}

	/**
	 * @author Syed.Hoque This mehtod will click one assessment from proctor
	 *         grid
	 */

	public void clikOnProctorAssessmentId(String loc) throws DriverException {
		logger.info("clikOnIndividualReportdataExtract ::: START");
		try {
			switchToCardShadowFrame();
			List<WebElement> ele = baseHandler.findElements(PropertiesRepository.getString(loc));
			if (CollectionUtils.isNotEmpty(ele)) {
				ele.get(0).click();
				// waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

			}
			windowHandler.switchToLatestWindow();
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			//waitForAwhile(10000);
		} catch (Exception e) {
			logger.info("Unable to clikOnIndividualReportdataExtract ");
			log(logger, "Unable to clikOnIndividualReportdataExtract");
			throw new DriverException("Unable to clikOnIndividualReportdataExtract", e);
		}
		logger.info("clikOnIndividualReportdataExtract ::: END");
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
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Not able to click on report wizard tab ");
			throw new DriverException("Not able to click on report wizard tab");
		}
		logger.info("Methode :  clickOnReportWizardTab  :::::::::::END");
	}

	/**
	 * @author Prasanna.Gogineni This method is used to check element is
	 *         displayed or not
	 * @param loc
	 * @param size
	 * @return
	 * @throws DriverException
	 */
	public boolean isEleDisplayed(String loc) throws DriverException {
		boolean flag = false;
		try {
			switchToCardShadowFrame();
			baseHandler.isDisplayed(PropertiesRepository.getString(loc));

			flag = true;
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			throw new DriverException("error in verify element" + e);

		}
		logger.info("Methode :  clickOnReportWizardTab  :::::::::::END" + flag);

		return flag;
	}

	public boolean isEleDisplayeds(String loc) throws DriverException {
		boolean flag = false;
		try {

			baseHandler.isDisplayed(PropertiesRepository.getString(loc));

			flag = true;

		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			throw new DriverException("error in verify element" + e);

		}
		logger.info("Methode :  clickOnReportWizardTab  :::::::::::END" + flag);

		return flag;
	}

	/**
	 * Used to verify assessment grid
	 * 
	 * @author prasanna.gogineni
	 * @param locator
	 * @throws Exception
	 */
	public boolean verifyAssessmentGrid(String locator) throws DriverException {
		logger.info("verifyMessage Start " + locator);
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString(locator));

			if (CollectionUtils.isNotEmpty(element) && element.size() > 0) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element.get(0));
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to verifyMessage");
			log(logger, "Unable to verifyMessage");
			throw new DriverException("Unable to verifyMessage", e);
		}
		logger.info("verifyMessage End flag" + flag);
		return flag;

	}

	public void ClickAssessmentFromPools() throws DriverException {
		logger.info("Method: ClickAssessmentFromPools Starts");
		try {
			switchToCardShadowFrame();
			// click on assessment id
			List<WebElement> tableElementList = baseHandler.findElements(
					PropertiesRepository.getString("id.reports.reportwizrad.questionanalysis.assGrid.loc"));

			if (org.apache.commons.collections.CollectionUtils.isNotEmpty(tableElementList)) {

				tableElementList.get(10).click();
				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				// WebElement tableElement = tableElementList.get(2);
				// ((JavascriptExecutor)
				// driver).executeScript("arguments[0].scrollIntoView(true);",
				// tableElement);
				// tableElement.click();
				waitForAwhile(40000);
			}

			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			logger.info("Unable to ClickAssessmentFromPool");
			log(logger, "Unable to ClickAssessmentFromPool");
			throw new DriverException("Unable to ClickAssessmentFromPool", e);
		}
		logger.info("Method: ClickAssessmentFromPools ENDS");
	}

	/**
	 * This method will click on a assessment on the basis of name present
	 * 
	 * @author Syed.Hoque
	 * @param locator
	 * @return
	 * @throws DriverException
	 */

	public void ClickAssessmentFromPoolsBasedOnNames(String assessmentName) throws DriverException {
		logger.info("Method: ClickAssessmentFromPools Starts");
		try {
			switchToCardShadowFrame();
			// click on assessment id
			List<WebElement> tableElementList = baseHandler.findElements(
					PropertiesRepository.getString("id.reports.reportwizrad.questionanalysis.assGrid.loc"));

			if (org.apache.commons.collections.CollectionUtils.isNotEmpty(tableElementList)) {
				for (int i = 0; i < tableElementList.size(); i++) {
					if (tableElementList.get(i).getText().equalsIgnoreCase(assessmentName)) {
						WebElement proctorTab = baseHandler.findElement(PropertiesRepository.getString("id.reports.reportwizrad.questionanalysis.loc.proctorAss"));
						scrollUPWithOutSwitchToCardShowFrame(proctorTab);
						tableElementList.get(i).click();
						break;
					}
				}

				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			}
			windowHandler.switchToLatestWindow();
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to ClickAssessmentFromPool");
			log(logger, "Unable to ClickAssessmentFromPool");
			throw new DriverException("Unable to ClickAssessmentFromPool", e);
		}
		logger.info("Method: ClickAssessmentFromPools ENDS");
	}

	public boolean verifyAssessmentGrid1(String locator) throws DriverException {
		logger.info("verifyMessage Start " + locator);

		boolean flag = false;
		try {

			switchToCardShadowFrame();
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString(locator));

			if (CollectionUtils.isNotEmpty(element) && element.size() > 0) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element.get(0));
				flag = true;
			}
			windowHandler.switchToLatestWindow();

		} catch (Exception e) {
			logger.info("Unable to verifyMessage");
			log(logger, "Unable to verifyMessage");
			throw new DriverException("Unable to verifyMessage", e);
		}
		logger.info("verifyMessage End flag" + flag);
		return flag;

	}

	/**
	 * Used to click assessment from the grid
	 * 
	 * @author prasanna.gogineni
	 * @param locator
	 * @throws Exception
	 */
	public boolean ClickAssessmentFromPool(String locator, String value) throws DriverException {
		logger.info("ClickAssessmentFromPool " + locator);

		boolean flag = false;

		try {
			switchToCardShadowFrame();
			List<WebElement> elements = baseHandler.findElements(PropertiesRepository.getString(locator));
			if (CollectionUtils.isNotEmpty(elements) && elements.size() > 0) {
				for (WebElement element : elements) {
					if (value.equals(element.getText().trim())) {
						element.click();
						// waitForAwhile(40000);
						waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
						flag = true;
						break;
					}

				}

			}

			windowHandler.switchToLatestWindow();
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to ClickAssessmentFromPool");
			log(logger, "Unable to ClickAssessmentFromPool");
			throw new DriverException("Unable to ClickAssessmentFromPool", e);
		}
		logger.info("verifyMessage End flag" + flag);

		return flag;

	}

	/**
	 * Used to click assessment from the grid
	 * 
	 * @author prasanna.gogineni
	 * @param locator
	 * @throws Exception
	 */
	public boolean ClickAssessmentId(String locator, String value) throws DriverException {
		logger.info("ClickAssessmentFromPool " + locator);

		boolean flag = false;

		try {

			switchToCardShadowFrame();
			List<WebElement> elements = baseHandler.findElements(PropertiesRepository.getString(locator));
			if (CollectionUtils.isNotEmpty(elements) && elements.size() > 0) {
				for (WebElement element : elements) {
					if (value.equals(element.getText().trim())) {
						element.click();
						waitForAwhile(20000);
						// waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
						flag = true;
						break;
					}

				}

			}

			windowHandler.switchToLatestWindow();
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		} catch (Exception e) {
			logger.info("Unable to ClickAssessmentFromPool");
			log(logger, "Unable to ClickAssessmentFromPool");
			throw new DriverException("Unable to ClickAssessmentFromPool", e);
		}
		logger.info("verifyMessage End flag" + flag);

		return flag;

	}

	/**
	 * Method used to click element using index.
	 * 
	 * @author prasanna.gogineni
	 * @param locator
	 * @param click
	 * @return
	 * @throws NullPointerException
	 * @throws DriverException
	 */
	public boolean clickAssIdwithIndex(String locator, int index) throws DriverException {
		 logger.info("Method: clickAssIdwithIndex Starts");
		boolean flag = false;
		try {
			switchToCardShadowFrame();

			List<WebElement> element = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(element)) {
				// ((JavascriptExecutor)
				// driver).executeScript("arguments[0].scrollIntoView(true);",
				// element.get(index));
				element.get(index).click();
				waitForAwhile(1000);
				flag = true;
			}
			windowHandler.switchToLatestWindow();
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to clickAssIdwithIndex");
			log(logger, "Unable to clickAssIdwithIndex");
			throw new DriverException("Unable to clickAssIdwithIndex", e);
		}
		logger.info("Method: clickAssIdwithIndex End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to click element using index.
	 * 
	 * @author prasanna.gogineni
	 * @param locator
	 * @param click
	 * @return
	 * @throws NullPointerException
	 * @throws DriverException
	 */
	public boolean verifyTableValue(String locator, int index, String value) throws DriverException {
		 logger.info("Method: clickAssIdwithIndex Starts");
		boolean flag = false;
		try {
			switchToCardShadowFrame();

			List<WebElement> element = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(element)) {
				if(element.get(index).getText().equalsIgnoreCase(value)) { 
					flag = true;
				}
			}
			windowHandler.switchToLatestWindow();
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to clickAssIdwithIndex");
			log(logger, "Unable to clickAssIdwithIndex");
			throw new DriverException("Unable to clickAssIdwithIndex", e);
		}
		logger.info("Method: clickAssIdwithIndex End flag --> " + flag);
		return flag;
	}

	/**
	 * Method used to verify element and if required, it will click.
	 * 
	 * @author prasanna.gogineni
	 * @param locator
	 * @param click
	 * @return
	 * @throws NullPointerException
	 * @throws DriverException
	 */
	public boolean verifyAndClickReportPageBtns(String locator, boolean click)
			throws NullPointerException, DriverException {
		logger.info("Method: verifyAndClick Starts");
		boolean flag = false;
		try {
			switchToCardShadowFrame();
			WebElement element = verifyElement(locator);
			if (element != null) {
				if (click) {
					// element.click();
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", element);
					flag = true;
					waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				}
			}
			windowHandler.switchToLatestWindow();
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
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
	 * This methtod will click on continue btn for TEAS Discover report
	 * 
	 * @author Syed.Hoque
	 * @return
	 * @throws DriverException
	 * @throws InterruptedException
	 */
	public void clickContinueTEASDiscover() throws DriverException {
		logger.info("Method: clickContinueTEASDiscover START");
		try {
			switchToCardShadowFrame();
			List<WebElement> ele = baseHandler
					.findElements(PropertiesRepository.getString("reportwizard.teasdiscover.continue.btn"));
			if (CollectionUtils.isNotEmpty(ele)) {
				ele.get(0).click();
				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			}

			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to verifyAndClick");
			log(logger, "Unable to verifyAndClick");
			throw new DriverException("Unable to verifyAndClick", e);
		}
		logger.info("Method: clickContinueTEASDiscover ENDS");
	}

	public boolean verifyClassicReportingPageContent() throws DriverException, InterruptedException {
		boolean flag = false;

		try {
			switchToCardShadowFrame();
			List<WebElement> reports = driver.findElements(By.cssSelector("li>a"));
			String Component1 = reports.get(0).getText();
			String Component2 = reports.get(1).getText();
			String Component3 = reports.get(2).getText();
			String Component4 = reports.get(3).getText();
			String Component5 = reports.get(4).getText();

			if (StringUtils.isNotEmpty(Component1) && StringUtils.isNotEmpty(Component2)
					&& StringUtils.isNotEmpty(Component3) && StringUtils.isNotEmpty(Component4)
					&& StringUtils.isNotEmpty(Component5) && "Quick Reports".equalsIgnoreCase(Component1.trim())
					&& "Report Wizard".equalsIgnoreCase(Component2.trim())
					&& "Custom Reports".equalsIgnoreCase(Component3.trim())
					&& "Data Extract".equalsIgnoreCase(Component4.trim())
					&& "Focused Review".equalsIgnoreCase(Component5.trim())) {
				flag = true;
			}
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to verify Classic Reporting Page Contens");
			throw new DriverException("Unable to verify Classic Reporting Page Contens", e);
		}
		return flag;
	}
	
	public void clickOnQuickReportTab() throws DriverException {
		logger.info("Methode :  clickOnReportWizardTab  :::::::::::START");

		try {

			switchToCardShadowFrame();
			baseHandler.findElement(PropertiesRepository.getString("report.quick.tab")).click();
			windowHandler.switchToLatestWindow();
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Not able to click on quick report tab ");
			throw new DriverException("Not able to click on quick report tab");
		}
		logger.info("Methode :  clickOnQuickReportTab  :::::::::::END");
	}

	public boolean clickOnCutomGroupRadioBtnFromTable1() throws DriverException {
		logger.info("clickOnCutomGroupRadioBtnFromTable1 ::: START");
		boolean flag=false;
		try{			
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			switchToCardShadowFrame();
			// click on radio btn from the custom group table
			List<WebElement> customGrpTableElement = baseHandler.findElements(PropertiesRepository.getString("reportwizard.customegroup.radio.btn1"));
			logger.info("Size of radio btn from the custom group table --> " + customGrpTableElement.size());
			if(CollectionUtils.isNotEmpty(customGrpTableElement)) {		
				try {
					logger.info("Trying to click using Javascript click");
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", customGrpTableElement.get(0));
//					waitForAwhile(2000);
					Thread.sleep(5000);
					if (customGrpTableElement.get(0).isSelected()){
						logger.info("radio button selected");
					 flag=true;
					}
				} catch(Exception e) {
					logger.info("Unable to click using Javascript");
				}
			}
			
		}catch (Exception e) {
			logger.info("Unable to clickOnCutomGroupRadioBtnFromTable1 ");
			log(logger, "Unable to clickOnCutomGroupRadioBtnFromTable1");
			throw new DriverException("Unable to clickOnCutomGroupRadioBtnFromTable1", e);
		}
		logger.info("Method: clickOnCutomGroupRadioBtnFromTable1 End " + flag);
		return flag;
	}
		
	public boolean clickOnCutomGroupContinueBtn() throws DriverException {
		boolean flag=false;
		try{
//			windowHandler.switchToLatestWindow();
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			
			// click on continue button
//			switchToCardShadowFrame();
			List<WebElement> continueBtnElement = baseHandler.findElements(PropertiesRepository.getString("reportwizard.crete.new.group.continue.btn"));
			logger.info("Size of continue button --> " + continueBtnElement.size());
			if(CollectionUtils.isNotEmpty(continueBtnElement)) {
			/*	try {
					logger.info("Trying to click using webdriver click");
					continueBtnElement.get(0).click();
					flag=true;
					Thread.sleep(5000);
				} catch (Exception e) {
					logger.info("Unable to click using normal webdriver click");
				}*/
				
				try {
					logger.info("Trying to click using Javascript click");
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", continueBtnElement.get(0));
					flag=true;
					Thread.sleep(5000);
				} catch(Exception e) {
					logger.info("Unable to click using Javascript");
				}
			}
					
			windowHandler.switchToLatestWindow();
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			
			
		}catch (Exception e) {
			logger.info("Unable to clickOnCutomGroupContinueBtn ");
			log(logger, "Unable to clickOnCutomGroupContinueBtn");
			throw new DriverException("Unable to clickOnCutomGroupContinueBtn", e);
		}
		return flag;
	}
}
