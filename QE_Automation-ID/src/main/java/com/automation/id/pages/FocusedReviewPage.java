package com.automation.id.pages;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.TextHandler;

public class FocusedReviewPage extends IDBasePage {

	private Logger logger = LogManager.getLogger(this.getClass());
	private BaseHandler baseHandler;

	public FocusedReviewPage(WebDriver webDriver) {
		super(webDriver);
		baseHandler = new BaseHandler(driver);
		textHandler = new TextHandler(driver);
	}

	/**
	 * @author Syed.Hoque This method will click on any assessment to generate
	 *         FR
	 * @throws DriverException
	 */

	public boolean clickAssessmentForFocusedReview() throws DriverException {
		logger.info("clickAssessmentForFocusedReview ::: START");
		boolean flag = false;
		try {
			switchToCardShadowFrame();
			List<WebElement> ele = baseHandler.findElements(PropertiesRepository.getString("focusedreview.assessment"));
			if (CollectionUtils.isNotEmpty(ele)) {
				ele.get(0).click();
				flag = true;
			}
			windowHandler.switchToLatestWindow();
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to clickAssessmentForFocusedReview ");
			log(logger, "Unable to clickAssessmentForFocusedReview");
			throw new DriverException("Unable to clickAssessmentForFocusedReview", e);
		}
		logger.info("clickAssessmentForFocusedReview ::: END flag --> "+ flag);
		return flag;
	}

	/**
	 * This method will click on pagination of focused review
	 * 
	 * @throws DriverException
	 */

	public void clickOnPagination(int index) throws DriverException {
		logger.info("clickOnPagination ::: START");
		try {
			switchToCardShadowFrame();
			List<WebElement> ele = baseHandler.findElements(PropertiesRepository.getString("focused.review.pageno"));
			if (CollectionUtils.isNotEmpty(ele)) {
				ele.get(index).click();
			}
			windowHandler.switchToLatestWindow();
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to clickOnIndividualReportPrintBtn ");
			log(logger, "Unable to clickOnIndividualReportPrintBtn");
			throw new DriverException("Unable to clickOnIndividualReportPrintBtn", e);
		}
		logger.info("clickOnPagination ::: END");
	}

	public boolean verifyPagiantion() throws DriverException {
		logger.info("verifyPagiantion ::: START");
		boolean flag = false;
		try {
			switchToCardShadowFrame();
			List<WebElement> firstpage = baseHandler
					.findElements(PropertiesRepository.getString("focused.review.firstpage"));
			if (CollectionUtils.isNotEmpty(firstpage)) {
				flag = true;
			}

			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to clickOnIndividualReportPrintBtn ");
			log(logger, "Unable to clickOnIndividualReportPrintBtn");
			throw new DriverException("Unable to clickOnIndividualReportPrintBtn", e);

		}
		logger.info("Method: verifyHelpMessage End flag --> " + flag);
		return flag;
	}

	/**
	 * @author Syed.Hoque This method will sent creator name in text box
	 * @throws DriverException
	 */

	public boolean sendCreatorName(String text) throws DriverException {
		logger.info("sendCreatorName ::: START");
		boolean flag = false;
		try {
			switchToCardShadowFrame();
			List<WebElement> ele = baseHandler
					.findElements(PropertiesRepository.getString("focused.review.creator.textbox"));
			if (CollectionUtils.isNotEmpty(ele)) {
				ele.get(0).sendKeys(text);
			}
			// click on search btn
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("focused.review.search.btn"));
			if (CollectionUtils.isNotEmpty(element)) {
				element.get(0).click();
				flag = true;
			}
			windowHandler.switchToLatestWindow();
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to sendCreatorName ");
			log(logger, "Unable to sendCreatorName");
			throw new DriverException("Unable to sendCreatorName", e);
		}
		logger.info("sendCreatorName ::: END flag -- > " + flag);
		return flag;
	}

}