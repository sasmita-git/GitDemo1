package com.automation.id.pages;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.TextHandler;

public class PracticeAssessmentPage extends IDBasePage {

	private Logger logger = LogManager.getLogger(this.getClass());

	public PracticeAssessmentPage(WebDriver webDriver) {
		super(webDriver);
		textHandler = new TextHandler(driver);
	}

	/**
	 * @author Sanapati.Srinu
	 * @param assessmentname
	 * @throws DriverException
	 */
	public boolean clickOnPreviewAssessmentButton(String assessmentname) throws DriverException {
		logger.info(" clickOnPreviewAssessmentButton  start");
		boolean flag = false;
		try {
			List<WebElement> assessmentNamesList = baseHandler.findElements(
					"#ctl00_contentPlaceHolderBody_ucProductsPracticeAssessments_gvProductsProctoredAssessment tr");

			if (CollectionUtils.isNotEmpty(assessmentNamesList)) {
				int size = assessmentNamesList.size();
				for (int index = 0; index < size; index++) {
					// Getting all tr and checking for assessment name
					List<WebElement> trEleWithName = assessmentNamesList.get(index)
							.findElements(By.cssSelector("td[class='products_tablecontent']"));
					if (CollectionUtils.isNotEmpty(trEleWithName)
							&& trEleWithName.get(0).getText().trim().equalsIgnoreCase(assessmentname)) {
						// Get that particular td's preview Assessment locator.
						List<WebElement> previewLocators = assessmentNamesList.get(index)
								.findElements(By.cssSelector("input[id*='imgbtnPreviewAssessment']"));
						if (CollectionUtils.isNotEmpty(previewLocators)) {
							previewLocators.get(0).click();
							windowHandler.switchToLatestWindow();
							waitUntillLoadingImageIsDisappeared(
									PropertiesRepository.getString("id.common.page.loader"));
							flag = true;
							break;

						}
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to clickOnPreviewAssessmentButton");
			log(logger, "Unable to clickOnPreviewAssessmentButton");
			throw new DriverException("Unable to clickOnPreviewAssessmentButton", e);
		}
		logger.info(" clickOnPreviewAssessmentButton  end flag --> " + flag);
		return flag;
	}

	
	public boolean clickOnStartAssessment() throws DriverException {
		logger.info("clickOnStartAssessment Start");
		boolean flag = false;
		try {
			windowHandler.switchToMainWindow();
			windowHandler.switchToLatestWindow();
			List<WebElement> startEssessmentNames = baseHandler
					.findElements(PropertiesRepository.getString("id.practice.start.assessment.loc"));
			List<WebElement> endAssessmentNames = baseHandler
					.findElements(PropertiesRepository.getString("id.practice.start.assessment.loc"));
			if (CollectionUtils.isNotEmpty(startEssessmentNames) && CollectionUtils.isNotEmpty(endAssessmentNames)) {
				startEssessmentNames.get(0).click();
				waitForAwhile(7000);
				List<WebElement> proceedButton = baseHandler.findElements("#btnProceed");
				if (CollectionUtils.isNotEmpty(proceedButton)) {
					proceedButton.get(0).click();
					waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
					waitForAwhile(7000);
					flag = true;
				} else {
					logger.info("Assessment page is not loaded");
				}
			}

		} catch (Exception e) {
			windowHandler.switchToMainWindow();
			logger.info("Unable to clickOnStartAssessment");
			log(logger, "Unable to clickOnStartAssessment");
			throw new DriverException("Unable to clickOnStartAssessment", e);
		}
		logger.info("clickOnStartAssessment End flag --> " + flag);
		return flag;
	}

	public void switchToAssessment() throws DriverException {
		try {
			waitForAwhile(1000);
			windowHandler.switchToFrame("assessmentFrame");
		} catch (Exception e) {

			logger.info("Unable to switchToAssessment");
			log(logger, "Unable to switchToAssessment");
			throw new DriverException("Unable to switchToAssessment", e);
		}
	}

	public void switchToSTTLesson() throws DriverException {
		try {
			windowHandler.switchToFrame("id.stt.lesson.frame.loc");
		} catch (Exception e) {

			logger.info("Unable to switchToSTTLesson");
			log(logger, "Unable to switchToSTTLesson");
			throw new DriverException("Unable to switchToSTTLesson", e);
		}
	}

	public boolean verifyObjectsOnTheAssessmentPage() throws DriverException {
		logger.info("verifyObjectsOnTheAssessmentPage Start");
		boolean flag = false;
		try {
			windowHandler.switchToLatestWindow();
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			switchToAssessment();
			List<WebElement> flagLoc = baseHandler.findElements(".flag-for-review-ribbon-off.focus-element-flag");
			if (CollectionUtils.isNotEmpty(flagLoc)) {
				flag = true;
			}

		} catch (Exception e) {
			logger.info("Unable to clickOnStartAssessment");
			log(logger, "Unable to clickOnStartAssessment");
			throw new DriverException("Unable to clickOnStartAssessment", e);
		}
		logger.info("verifyObjectsOnTheAssessmentPage End flag --> " + flag);
		return flag;

	}

	public boolean isElementPresent(String loc) throws DriverException {
		logger.info("isElementPresent Start");
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
		logger.info("isElementPresent End flag --> " + flag);
		return flag;
	}
	
	public boolean clickPracticeAssessmentCloseBtn(String loc, boolean click) throws DriverException {
		logger.info("clickPracticeAssessmentCloseBtn Start");
		boolean flag = false;
		try {
			windowHandler.switchToLatestWindow();
			switchToAssessment();
			List<WebElement> button = baseHandler.findElements("button[class='mat-button']");
			if (CollectionUtils.isNotEmpty(button) && button.get(0).isDisplayed()) {
				if(click) {
					button.get(0).click();
				}
				flag = true;
			} else {
				logger.info("Unable to find locator in clickPracticeAssessmentCloseBtn");
			}
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to clickPracticeAssessmentCloseBtn");
			log(logger, "Unable to clickPracticeAssessmentCloseBtn");
			throw new DriverException("Unable to clickPracticeAssessmentCloseBtn", e);
		}
		logger.info("Unable to clickPracticeAssessmentCloseBtn End flag --> " + flag);
		return flag;
	}
	
	public boolean clickPracticeAssessmentCloseX(String loc, boolean click) throws DriverException {
		logger.info("clickPracticeAssessmentCloseBtn Start");
		boolean flag = false;
		try {
			windowHandler.switchToLatestWindow();
			switchToAssessment();
			driver.close();
			windowHandler.switchToLatestWindow();
			flag = true;
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to clickPracticeAssessmentCloseBtn");
			log(logger, "Unable to clickPracticeAssessmentCloseBtn");
			throw new DriverException("Unable to clickPracticeAssessmentCloseBtn", e);
		}
		logger.info("Unable to clickPracticeAssessmentCloseBtn End flag --> " + flag);
		return flag;
	}

	public boolean clickPracticeAssessmentYesBtn(String loc, boolean click) throws DriverException {
		logger.info("clickPracticeAssessmentYesBtn Start");
		boolean flag = false;
		try {
			switchToAssessment();
			//windowHandler.switchToLatestWindow();
			List<WebElement> button = baseHandler.findElements("button[class='button secondary-button focus-element-flag ng-star-inserted'");
			if (CollectionUtils.isNotEmpty(button) && button.get(0).isDisplayed()) {
				if(click) {
					button.get(0).click();
				}
				flag = true;
			} else {
				logger.info("Unable to find locator in clickPracticeAssessmentYesBtn");
			}
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to clickPracticeAssessmentYesBtn");
			log(logger, "Unable to clickPracticeAssessmentYesBtn");
			throw new DriverException("Unable to clickPracticeAssessmentYesBtn", e);
		}
		logger.info("Unable to clickPracticeAssessmentYesBtn End flag --> " + flag);
		return flag;
	}
	
	public boolean verifyObjectsOnTheSTTAssessmentPage() throws DriverException {
		logger.info("verifyObjectsOnTheSTTAssessmentPage Start");
		boolean flag = false;
		try {
			switchToAssessment();
			//windowHandler.switchToLatestWindow();
			List<WebElement> assessmentName = baseHandler.findElements(".lesson-header-details ul li span");
			
			List<WebElement> flagLoc = baseHandler.findElements(
					PropertiesRepository.getString("id.product.manage.products.tutorial.preview.assessment.flag.loc"));
			List<WebElement> continueloc = baseHandler
					.findElements(PropertiesRepository.getString("id.practice.assessment.continue.loc"));
			if (CollectionUtils.isNotEmpty(flagLoc) && CollectionUtils.isNotEmpty(continueloc)
					&& CollectionUtils.isNotEmpty(assessmentName)) {
				flag = true;
			}
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to clickOnStartAssessment");
			log(logger, "Unable to clickOnStartAssessment");
			throw new DriverException("Unable to clickOnStartAssessment", e);
		}
		logger.info("verifyObjectsOnTheSTTAssessmentPage End flag --> " + flag);
		return flag;
	}

	public boolean verifyObjectsOnTheSTTLessonPage() throws DriverException {

		boolean flag = false;
		try {
			windowHandler.switchToLatestWindow();
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			switchToSTTLesson();
			List<WebElement> nextloc = baseHandler
					.findElements(PropertiesRepository.getString("id.stt.lesson.next.loc"));
			List<WebElement> contentheader = baseHandler
					.findElements(PropertiesRepository.getString("id.stt.lesson.header.loc"));
			List<WebElement> lessoncontentheader = baseHandler
					.findElements(PropertiesRepository.getString("id.stt.lesson.content.header.loc"));
			if (CollectionUtils.isNotEmpty(nextloc) && CollectionUtils.isNotEmpty(contentheader)
					&& CollectionUtils.isNotEmpty(lessoncontentheader)) {
				flag = true;
			}

		} catch (Exception e) {
			logger.info("Unable to verify stt lesson objects");
			log(logger, "Unable to verify stt lesson objects");
			throw new DriverException("Unable to verify stt lesson objects", e);
		}
		return flag;

	}

	public boolean verifyObjectsOnTheTeasSmartPrepPage() throws DriverException {
		logger.info("verifyObjectsOnTheTeasSmartPrepPage Start");
		boolean flag = false;
		try {
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			windowHandler.switchToFrame("iframeOpenPage");

			List<WebElement> questionloc = baseHandler
					.findElements("#facultyHeader");
					//.findElements(PropertiesRepository.getString("id.Teas.question.text"));
			List<WebElement> headerloc = baseHandler
					.findElements("#opplayer");
					//.findElements(PropertiesRepository.getString("id.teas.question.header.loc"));opplayer
			if (CollectionUtils.isNotEmpty(questionloc) && CollectionUtils.isNotEmpty(headerloc)) {
				flag = true;
			}
			windowHandler.switchToLatestWindow();
			
		} catch (Exception e) {
			logger.info("Unable to verifyObjectsOnTheTeasSmartPrepPage");
			log(logger, "Unable to verifyObjectsOnTheTeasSmartPrepPage");
			throw new DriverException("Unable to verifyObjectsOnTheTeasSmartPrepPage", e);
		}
		logger.info("verifyObjectsOnTheTeasSmartPrepPage End flag --> " + flag);
		return flag;

	}

	/**
	 * Method used to click Proctor Assessment based on name.
	 * 
	 * 
	 * @param assessmentName
	 * @throws Exception
	 */
	public boolean clickProctorAssessment(String assessmentName) throws Exception {
		boolean flag = false;
		logger.info("Method : clickProctorAssessment Start");
		try {
			List<WebElement> proctorMainElement = baseHandler
					.findElements("section[class='proctored-container'] .card.proctored-assessment.front");
			if (CollectionUtils.isNotEmpty(proctorMainElement)) {
				int size = proctorMainElement.size();
				for (int index = 0; index < size; index++) {
					WebElement proctorNameElement = proctorMainElement.get(index)
							.findElement(By.cssSelector(".description"));
					if (proctorNameElement != null) {
						if (assessmentName.equalsIgnoreCase(proctorNameElement.getText().trim())) {
							List<WebElement> proctorElement = proctorMainElement.get(index).findElements(
									By.cssSelector("a[class='button primary-button button-focus focus-element-flag']"));
							if (CollectionUtils.isNotEmpty(proctorElement)) {
								int subSize = proctorElement.size();
								for (int subIndex = 0; subIndex < subSize; subIndex++) {
									String proctorElementStyle = proctorElement.get(subIndex).getAttribute("style");
									if (StringUtils.isEmpty(proctorElementStyle)) {
										proctorElement.get(subIndex).click();
										waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
										flag = true;
										break;
									}
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to click Test Tab Assessment Button");
			log(logger, "Unable to click Test Tab Assessment Button");
			throw new DriverException("Unable to click Test Tab Assessment Button", e);
		}
		logger.info("Method : clickProctorAssessment End flag --> " + flag);
		return flag;
	}

	public void switchToContentFrame() throws Exception {
		logger.info("Method : switchToContentFrame Start");
		try {
			WebElement frameElement = driver.findElement(By.cssSelector("#contentFrame"));
			driver.switchTo().frame(frameElement);
		} catch (Exception e) {
			logger.info("Unable to ");
			log(logger, "Unable to ");
			throw new DriverException("Unable to ", e);
		}
		logger.info("Method: switchToContentFrame End");

	}

	public boolean verifyAssessmentNameWithSwitchToContentFrame(String locator, int index, String name) throws Exception {
		logger.info("Method : verifyAssessmentNameWithSwitchToContentFrame Start");
		logger.info("Locator value --> " + locator);
		logger.info("index value --> " + index);
		logger.info("name value --> " + name);
		//locator = ".module-header div[class='leftjustified module-info'] span span";
		boolean flag = false;
		try {
			//switchToContentFrame();
			windowHandler.switchToLatestWindow();
			List<WebElement> element = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(element) && element.get(index).getText().trim().equalsIgnoreCase(name)) {
				flag = true;
			}
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to verifyAssessmentNameWithSwitchToContentFrame");
			log(logger, "Unable to verifyAssessmentNameWithSwitchToContentFrame");
			throw new DriverException("Unable to verifyAssessmentNameWithSwitchToContentFrame", e);
		}
		logger.info("Method: verifyAssessmentNameWithSwitchToContentFrame End flag --> " + flag);
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
	public boolean verifyAndClickWithSwitchToContentFrame(String locator, int index, boolean click)
			throws NullPointerException, DriverException {
		logger.info("Method: verifyAndClickWithSwitchToContentFrame Starts");
		boolean flag = false;
		try {
			windowHandler.switchToLatestWindow();
			List<WebElement> element = verifyElementList(locator);
			// clicking on Close button
			if (element != null) {
				if (click) {
					element.get(index).click();
					// Clicking on Yes button in Popup after clicking on close button
					windowHandler.switchToLatestWindow();
					element.get(2).click();
				}
				flag = true;
			}
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to verifyAndClickWithSwitchToContentFrame");
			log(logger, "Unable to verifyAndClickWithSwitchToContentFrame");
			throw new DriverException("Unable to verifyAndClickWithSwitchToContentFrame", e);
		}
		logger.info("Method: verifyAndClickWithSwitchToContentFrame End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Used to verify message
	 * 
	 * @author prasanna.gogineni
	 * @param locator
	 * @throws Exception
	 */
	public boolean verifyMessageWithSwitchToAssessment(String locator, int index, String value) throws DriverException {
		logger.info("verifyMessageWithSwitchToAssessment Start " + locator);
		logger.info("Locator value --> " + locator);
		logger.info("index value --> " + index);
		logger.info("value --> " + index);
		boolean flag = false;
		try {
			switchToAssessment();
			List<WebElement> element = baseHandler.findElements(".lesson-header-details ul li span");
			if (CollectionUtils.isNotEmpty(element) && element.size() > 0) {
				if (value.equalsIgnoreCase(element.get(index).getText().trim())) {
					flag = true;
				}
			} else {
				logger.info("Unable to find elements for message verification in verifyMessageWithSwitchToAssessment");
			}
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to verifyMessageWithSwitchToAssessment");
			log(logger, "Unable to verifyMessageWithSwitchToAssessment");
			throw new DriverException("Unable to verifyMessageWithSwitchToAssessment", e);
		}
		logger.info("verifyMessageWithSwitchToAssessment End flag -->" + flag);
		return flag;
	}

}