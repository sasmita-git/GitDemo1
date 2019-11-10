package com.automation.id.pages;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.TextHandler;

public class DataExtractPage extends IDBasePage {

	private Logger logger = LogManager.getLogger(this.getClass());
	private BaseHandler baseHandler;

	public DataExtractPage(WebDriver webDriver) {
		super(webDriver);
		baseHandler = new BaseHandler(driver);
		textHandler = new TextHandler(driver);
	}

	/**
	 * @author Syed.Hoque This method will click on assessment from valid
	 *         assessment table
	 * @throws DriverException
	 */

	public boolean clikOnValidAssessment() throws DriverException {
		logger.info("clikOnValidAssessment ::: START");
		boolean flag = false;
		boolean boolAssessment = false;
		boolean boolAssessmentId = false;
		
		try {
			switchToCardShadowFrame();
			List<WebElement> ele = baseHandler
					.findElements(PropertiesRepository.getString("dataextract.studentlist.valid.assessment"));
			if (CollectionUtils.isNotEmpty(ele)) {
				ele.get(0).click();
				boolAssessment = true;
				windowHandler.switchToLatestWindow();
				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				switchToCardShadowFrame();
			}
			// to click on valid assessment id
			List<WebElement> ele1 = baseHandler
					.findElements(PropertiesRepository.getString("dataextract.studentlist.valid.assessmentid"));
			if (CollectionUtils.isNotEmpty(ele1)) {
				ele1.get(0).click();
				boolAssessmentId = true;
			}
			windowHandler.switchToLatestWindow();
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			if(boolAssessment && boolAssessmentId) {
				flag = true;
			}
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Not able to selectStudentFromStudentList ");
			throw new DriverException("Not able to selectStudentFromStudentList");
		}
		logger.info("clikOnValidAssessment ::: ENDS flag --> "+ flag);
		return flag;
	}

	/**
	 * @author Syed.Hoque This method will click on generate extract btn for
	 *         student list
	 * @throws DriverException
	 */
	public boolean clickOnGenerateExtractBtn() throws DriverException {
		logger.info("clickOnGenerateExtractBtn ::: STARTS");
		boolean flag = false;
		try {
			switchToCardShadowFrame();
			List<WebElement> ele = baseHandler
					.findElements(PropertiesRepository.getString("dataextract.generate.extract.btn"));
			if (CollectionUtils.isNotEmpty(ele)) {
				ele.get(0).click();
				flag = true;
			} else {
				logger.info("Unable to find locator in clickOnGenerateExtractBtn");
			}
			windowHandler.switchToLatestWindow();
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Not able to clickOnGenerateExtractBtn ");
			throw new DriverException("Not able to clickOnGenerateExtractBtn", e);
		}
		logger.info("clickOnGenerateExtractBtn ::: ENDS flag --> "+ flag);
		return flag;
	}

	/**
	 * @author Syed.Hoque This method will verify that student list data ,here m
	 *         verifying that user-id is displaying or not
	 * @throws DriverException
	 */

	public boolean verifyUserData(String userid) throws DriverException {
		boolean flag = false;
		//logger.info("verifyUserData ::: START");
		try {
			switchToCardShadowFrame();
			List<WebElement> ele = baseHandler
					.findElements(PropertiesRepository.getString("dataextract.studentlist.data"));
			if (CollectionUtils.isNotEmpty(ele) && ele.get(1).getText().equalsIgnoreCase(userid)) {
				flag = true;
			}
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Not able to verifyUserData ");
			throw new DriverException("Not able to verifyUserData");
		}
		logger.info("Method: verifyUserData End " + flag);
		return flag;
	}

	/**
	 * @author Syed.Hoque This method will select some student from student list
	 * @throws DriverException
	 */
	public boolean selectStudentFromStudentList() throws DriverException {
		logger.info("selectStudentFromStudentList ::: START");
		boolean flag = false;
		boolean boolStudent = false;
		boolean boolRightArrow = false;
		boolean boolRightSideEle = false;
		boolean boolContinue = false;
		
		try {

			switchToCardShadowFrame();
			List<WebElement> eleement = baseHandler
					.findElements(PropertiesRepository.getString("dataextract.student.list"));
			if (CollectionUtils.isNotEmpty(eleement)) {
				eleement.get(0).click();
				boolStudent = true;
			}
			// Now click on right arrow button
			List<WebElement> rightarrow = baseHandler
					.findElements(PropertiesRepository.getString("dataExtract.rightarrow.btn"));
			if (CollectionUtils.isNotEmpty(rightarrow)) {
				rightarrow.get(0).click();
				boolRightArrow = true;
			}

			// Now select the right side element
			List<WebElement> righttableele = baseHandler
					.findElements(PropertiesRepository.getString("dataextract.rightside.table.ele"));
			if (CollectionUtils.isNotEmpty(righttableele)) {
				righttableele.get(0).click();
				boolRightSideEle = true;
			}
			WebElement ele = baseHandler.findElement(PropertiesRepository.getString("dataextract.to.textbox"));
			ele.sendKeys(Keys.TAB, Keys.TAB, Keys.TAB, Keys.TAB, Keys.TAB, Keys.TAB);

			// click on continue button
			List<WebElement> stdcontbtn = baseHandler
					.findElements(PropertiesRepository.getString("dataextract.continue.btn"));
			if (CollectionUtils.isNotEmpty(stdcontbtn)) {
				stdcontbtn.get(0).click();
				boolContinue = true;
			}
			if(boolStudent && boolRightArrow && boolRightSideEle && boolContinue) {
				flag = true;
			}
			windowHandler.switchToLatestWindow();
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Not able to selectStudentFromStudentList ");
			throw new DriverException("Not able to selectStudentFromStudentList");
		}
		logger.info("selectStudentFromStudentList ::: END flag --> " + flag);
		return flag;
	}

}
