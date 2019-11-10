package com.automation.id.pages;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.DropDownHandler;
import com.ascendlearning.automation.ui.handlers.TextHandler;

public class ProctoredAssessmentPage extends IDBasePage {

	private Logger logger = LogManager.getLogger(this.getClass());
	private TextHandler textHandler;
	DropDownHandler dropDownHandler;
	private IDBasePage idbasepage;

	public ProctoredAssessmentPage(WebDriver webDriver) {
		super(webDriver);
		textHandler = new TextHandler(driver);
		dropDownHandler = new DropDownHandler(driver);
		idbasepage = new IDBasePage(driver);
	}

	/**
	 * @author Sanapati.Srinu
	 * @param assessmentname
	 * @throws DriverException
	 */
	public void clickOnPreviewAssessmentButton(String assessmentname) throws DriverException {
		try {
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			List<WebElement> assessmentNames = baseHandler
					.findElements(PropertiesRepository.getString("id.practice.assessment.names.loc"));

			if (CollectionUtils.isNotEmpty(assessmentNames)) {
				for (int i = 0; i < assessmentNames.size(); i = i + 2) {
					if (assessmentname.trim().equals(assessmentNames.get(i).getText().trim())) {
						List<WebElement> previewLocators = baseHandler
								.findElements(PropertiesRepository.getString("id.practice.assessment.preview.loc"));
						if (CollectionUtils.isNotEmpty(previewLocators)) {
							previewLocators.get(i - 1).click();
							waitUntillLoadingImageIsDisappeared(
									PropertiesRepository.getString("id.common.page.loader"));
						}
					}
				}

			}

		} catch (Exception e) {
			logger.info("Unable to clickOnPreviewAssessmentButton");
			log(logger, "Unable to clickOnPreviewAssessmentButton");
			throw new DriverException("Unable to clickOnPreviewAssessmentButton", e);
		}

	}

	public boolean clickOnStartAssessment() throws DriverException {
		boolean flag = false;
		try {

			windowHandler.switchToMainWindow();
			windowHandler.switchToLatestWindow();
			List<WebElement> startEssessmentNames = baseHandler
					.findElements(PropertiesRepository.getString("id.practice.start.assessment.loc"));
			List<WebElement> endAssessmentNames = baseHandler
					.findElements(PropertiesRepository.getString("id.practice.start.assessment.loc"));
			if (CollectionUtils.isNotEmpty(startEssessmentNames) && CollectionUtils.isNotEmpty(endAssessmentNames)) {
				flag = true;
				startEssessmentNames.get(0).click();
				List<WebElement> proceedButton = baseHandler.findElements("#btnProceed");
				proceedButton.get(0).click();
				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			}

		} catch (Exception e) {
			logger.info("Unable to clickOnStartAssessment");
			log(logger, "Unable to clickOnStartAssessment");
			throw new DriverException("Unable to clickOnStartAssessment", e);
		}
		return flag;

	}

	public void switchToAssessment() throws DriverException {
		try {
			windowHandler.switchToFrame("assessmentFrame");
		} catch (Exception e) {

			logger.info("Unable to switchToAssessment");
			log(logger, "Unable to switchToAssessment");
			throw new DriverException("Unable to switchToAssessment", e);
		}
	}

	public boolean verifyObjectsOnTheAssessmentPage() throws DriverException {

		boolean flag = false;
		try {
			windowHandler.switchToLatestWindow();
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			switchToAssessment();
			List<WebElement> calculatorLoc = baseHandler
					.findElements(PropertiesRepository.getString("id.practice.view.calculator.loc"));
			List<WebElement> flagLoc = baseHandler.findElements(PropertiesRepository.getString("id.practice.flag.loc"));
			if (CollectionUtils.isNotEmpty(calculatorLoc) && CollectionUtils.isNotEmpty(flagLoc)) {
				flag = true;
			}

		} catch (Exception e) {
			logger.info("Unable to clickOnStartAssessment");
			log(logger, "Unable to clickOnStartAssessment");
			throw new DriverException("Unable to clickOnStartAssessment", e);
		}
		return flag;

	}

	public boolean isElementPresent(String loc) throws DriverException {

		boolean flag = false;
		try {
			windowHandler.switchToLatestWindow();
			List<WebElement> button = baseHandler.findElements(PropertiesRepository.getString(loc));
			if (CollectionUtils.isNotEmpty(button) && button.get(0).isDisplayed()) {
				flag = true;
			}

		} catch (Exception e) {
			logger.info("Unable to find the Element");
			log(logger, "Unable to find the Element");
			throw new DriverException("Unable to find the Element", e);

		}
		return flag;
	}

	public boolean verifyAssignmentPopUpObjects() throws DriverException {

		try {
			WebElement courseDropDownLoc = baseHandler
					.findElement(PropertiesRepository.getString("id.schedule.assignment.popup.dropdown"));
			WebElement radioButtonSectionLoc = baseHandler
					.findElement(PropertiesRepository.getString("id.schedule.assignment.popup.radio.button.section"));
			WebElement dateLoc = baseHandler
					.findElement(PropertiesRepository.getString("id.schedule.assignment.popup.date.section"));
			WebElement timeLoc = baseHandler
					.findElement(PropertiesRepository.getString("id.schedule.assignment.popup.time.dd"));
			WebElement commentsLoc = baseHandler
					.findElement(PropertiesRepository.getString("id.schedule.assignment.popup.textarea"));
			WebElement scheduleButton = baseHandler
					.findElement(PropertiesRepository.getString("id.schedule.assignment.popup.schedule.button"));
			if (courseDropDownLoc != null && radioButtonSectionLoc != null && dateLoc != null && timeLoc != null
					&& commentsLoc != null && scheduleButton != null) {
				return true;
			}
		} catch (Exception e) {
			logger.info("Unable to verify Assignment PopUp Objects");
			log(logger, "Unable to verify Assignment PopUp Objects");
			throw new DriverException("Unable to verify Assignment PopUp Objects", e);
		}
		return false;

	}

	public boolean addAssessmentForProctoredAssessment() throws DriverException {
		boolean flag = false;
		try {
			logger.info("addAssessmentForProctoredAssessment start");
			// Select course
			List<WebElement> selectElement = baseHandler.findElements(PropertiesRepository.getString("id.schedule.assignment.popup.dropdown"));
			if(CollectionUtils.isNotEmpty(selectElement)) {
				dropDownHandler.selectByVisibleText(
						dropDownHandler
								.getDropDown(PropertiesRepository.getString("id.schedule.assignment.popup.dropdown")),
						PropertiesRepository.getString("id.schedule.assignment.popup.course.name"));
				
				// Selecting date
				List<WebElement> findElement = baseHandler
						.findElements(PropertiesRepository.getString("id.schedule.assignment.popup.date.section"));
				if(CollectionUtils.isNotEmpty(findElement)) {
					textHandler.writeText(findElement.get(0), PropertiesRepository.getString("id.schedule.assignment.popup.date"));
					// Selecting time
					List<WebElement> timeElement = baseHandler.findElements(PropertiesRepository.getString("id.schedule.assignment.popup.time.dd"));
					if(CollectionUtils.isNotEmpty(timeElement)) {
						dropDownHandler.selectByIndex(
								dropDownHandler.getDropDown(PropertiesRepository.getString("id.schedule.assignment.popup.time.dd")),
								2);
						
						List<WebElement> textArea = baseHandler
								.findElements(PropertiesRepository.getString("id.schedule.assignment.popup.textarea"));
						if(CollectionUtils.isNotEmpty(textArea)) {
							textHandler.writeText(textArea.get(0),
									PropertiesRepository.getString("id.schedule.assignment.popup.comments.input"));
							
							idbasepage.verifyAndClick(PropertiesRepository.getString("id.schedule.assignment.popup.schedule.button"),
									true);
							idbasepage.verifyAndClick(
									PropertiesRepository.getString("id.assessment.schedule.assignment.plus.symbole.loc"), true);
							waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
							waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
							waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
							flag = true;
						} else {
							logger.info("Unable to enter text ares");
						}
					} else {
						logger.info("Unable to select time");
					}
				} else {
					logger.info("Unable to enter date");
				}
			} else {
				logger.info("Unable to select drop down from Add Assessment for popup");
			}
			
		} catch (Exception e) {
			logger.info("Unable to add Assessment For Proctored  Assessment");
			log(logger, "Unable to add Assessment For Proctored Assessment");
			throw new DriverException("Unable to add Assessment For Proctored Assessment", e);
		}
		logger.info("addAssessmentForProctoredAssessment End --> " + flag);
		return flag; 
	}

	/**
	 * This method is used to wait for some time when identifying the element on
	 * the page
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

	public boolean verifyAddedAssignment(String loc) throws DriverException {
		try {
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString(loc));
			if (CollectionUtils.isNotEmpty(element)) {
				List<WebElement> coloumNames = element.get(element.size() - 1).findElements(By.tagName("td"));
				if (coloumNames.get(0).getText()
						.equals(PropertiesRepository.getString("id.schedule.assignment.popup.course.name"))
						&& coloumNames.get(1).getText()
								.equals(PropertiesRepository.getString("id.schedule.assignment.popup.date"))) {
					return true;
				}
			}

		} catch (Exception e) {
			logger.info("Unable to verify Added Assignment");
			log(logger, "Unable to verify AddedAssignment");
			throw new DriverException("Unable to verify AddedAssignment", e);
		}
		return false;
	}
	
	/**
	 * @author Sanapati.Srinu
	 * @param assessmentname
	 * @throws DriverException
	 */
	public boolean clickOnScheduleAssessmentButton(String assessmentname) throws DriverException {
		logger.info(" clickOnScheduleAssessmentButton  start");
		
		boolean flag = false;
		try {
			List<WebElement> assessmentNamesList = baseHandler.findElements(
					"#ctl00_contentPlaceHolderBody_ucProductsProctoredAssessment_gvProductsProctoredAssessment tr");

			if (CollectionUtils.isNotEmpty(assessmentNamesList)) {
				int size = assessmentNamesList.size();
				for (int index = 0; index < size; index++) {
					// Getting all tr and checking for assessment name
					List<WebElement> trEleWithName = assessmentNamesList.get(index)
							.findElements(By.cssSelector("td[class='products_tablecontent']"));
					if (CollectionUtils.isNotEmpty(trEleWithName)
							&& trEleWithName.get(0).getText().trim().equalsIgnoreCase(assessmentname)) {
						// To check whether it is already scheduled or not. It will click if it is not scheduled. 
						List<WebElement> alreadyScheduledPlusImg = assessmentNamesList.get(index)
								.findElements(By.cssSelector("img [id*='imgShowHide']"));
						if(CollectionUtils.isEmpty(alreadyScheduledPlusImg)) {
							// Get that particular td's preview Assessment locator.
							List<WebElement> previewLocators = assessmentNamesList.get(index)
									.findElements(By.cssSelector("input[id*='imgbtnScheduleAssignment']"));
							if (CollectionUtils.isNotEmpty(previewLocators)) {
								previewLocators.get(0).click();
								windowHandler.switchToLatestWindow();
								waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
								waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
								waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
								waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
								flag = true;
								switchToCardShadowFrame();
								break;

							}
						}
					} else {
						logger.info("Assessment is already scheduled.");
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to clickOnScheduleAssessmentButton");
			log(logger, "Unable to clickOnScheduleAssessmentButton");
			throw new DriverException("Unable to clickOnScheduleAssessmentButton", e);
		}
		logger.info(" clickOnScheduleAssessmentButton  end flag --> " + flag);
		return flag;
	}
}
