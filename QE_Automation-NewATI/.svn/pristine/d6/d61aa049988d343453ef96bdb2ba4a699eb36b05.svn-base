package com.automation.newati.pages;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;

public class TakingAssessmentPage extends TestTabPage {
	private Logger logger = LogManager.getLogger(this.getClass());
	private BaseHandler baseHandler;
	private WindowHandler windowHandler;
	public TakingAssessmentPage(WebDriver webDriver) {
		super(webDriver);
		baseHandler = new BaseHandler(driver);
		windowHandler = new WindowHandler(driver);
	}
	
	/**
	 * Method is used to complete Test
	 * 
	 * breakFlag If assessment has to be stopped in middle.
	 * 
	 * rationaleFlag Need to check for Rationale and My Answer.
	 * 
	 * @param bool
	 * @param breakFlag
	 * @param rationaleFlag
	 * @throws Exception
	 */
	public void takeTestWithFlagging(boolean bool, boolean breakFlag,
			boolean rationaleFlag, boolean flagquestion) throws Exception {
		logger.info("Method : takeTestWithFlagging :::::::: Starts");
		boolean flag = false;
		try {

			//waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			switchToAssessmentFrameHandler();
			// Getting Total Question Number
			String maxQtnTextNo = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.question.number.loc")).get(1).getText();

			// Convert String to Integer
			int maxCount = Integer.parseInt(maxQtnTextNo);

			// Getting Current Question Number
			String minQtnTextNo = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.question.number.loc")).get(0).getText();

			// Convert String to Integer
			int minCount = Integer.parseInt(minQtnTextNo);

			// Maximum Question minus Minimum Questions
			int count = maxCount - minCount;

			for (int i = 0; i <= count; i++) {

				// Flagging 2, 4 and 4 question. 
				if( i == 2 || i == 4 || i == 6) {
					flagquestion = true;
					baseHandler
					.findElement(
							PropertiesRepository
									.getString("new-atitesting.generic.tutorial.flag.value"))
					.click();
				}
				if(!flagquestion) {
					List<WebElement> checkBoxElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.generic.tutorial.checkbox.new.loc"));
					List<WebElement> radioElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.generic.tutorial.radio.button.new.loc"));

					if (checkBoxElement != null) {
						checkBoxElement.get(0).click();
						checkBoxElement.get(1).click();
					}

					if (driver.findElements(By.cssSelector(".answer-fill-in-the-blank.numericTextEntry.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty")).size() > 0) {
						verifyFillForm("10");

					}

					if (CollectionUtils.isNotEmpty(baseHandler.findElements(PropertiesRepository.getString("new-atitesting.generic.tutorial.dragbox1.loc")))) {
						DragAndDropAnswer(false);
					}

					if (CollectionUtils.isNotEmpty(radioElement) && radioElement.size() > 0) {
						radioElement.get(0).click();
					}

					if (CollectionUtils.isNotEmpty(baseHandler.findElements(PropertiesRepository.getString("new-atitesting.question.img.loc")))) {
						hotSpotQuestion();
					}

					if (i == count) {
						switchToAssessmentFrameHandler();
						List<WebElement> buttonElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
						if(CollectionUtils.isNotEmpty(buttonElement)) {
							if(buttonElement.get(0).isDisplayed()) {
								WebElement continueButtonElement = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
								if(continueButtonElement != null) {
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									if(!continueButtonElement.isEnabled()) {
										clickButton(PropertiesRepository.getString("new-atitesting.myati.assessment.question.unanswered.close.loc"), 0);
										clickAssessmemtType();
									}
								}
							}
						}
						flag = takeAssessmentWithFlagging(rationaleFlag, flagquestion);
					} else {
						if (i == 0 && flagquestion) {
							switchToAssessmentFrameHandler();
							verifyFlag(true);
							logger.info("Question has been flaged");
							Thread.sleep(4000);
						} else {
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
							switchToAssessmentFrameHandler();
							waitUntillElementIsVisible(PropertiesRepository
									.getString("new-atitesting.generic.tutorial.submit.new.loc"));
							List<WebElement> buttonElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
							if(CollectionUtils.isNotEmpty(buttonElement)) {
								if(buttonElement.get(0).isDisplayed()) {
									WebElement continueButtonElement = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
									if(continueButtonElement != null) {
										continueButtonElement.sendKeys(Keys.ENTER);
										waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
										if(verifyQuestionUnAsweredPopup()) {
											List<WebElement> assessmentCompleteElement = baseHandler.findElements(".modal-section button");
											if(CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
												assessmentCompleteElement.get(0).click();
											}
											//clickButton(PropertiesRepository.getString("new-atitesting.myati.assessment.question.unanswered.close.loc"), 0);
											clickAssessmemtType();
										}
									}
								}
							}
						}
						if (rationaleFlag) {
							waitUntillLoadingImageIsDisappeared("new-atitesting.pleasewait.bufferLoc");
							List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
							if(CollectionUtils.isNotEmpty(rationalContinue)) {
								rationalContinue.get(0).sendKeys(Keys.ENTER);
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
							}
						}
						switchToAssessmentFrameHandler();

						if (bool) {
							switchToAssessmentFrameHandler();
							waitUntillElementIsVisible(PropertiesRepository
									.getString("new-atitesting.generic.tutorial.continue.loc"));
							Thread.sleep(1000);
							List<WebElement> buttonElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
							if(CollectionUtils.isNotEmpty(buttonElement)) {
								if(buttonElement.get(0).isDisplayed()) {
									WebElement continueButtonElement = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
									if(continueButtonElement != null) {
										continueButtonElement.sendKeys(Keys.ENTER);
										waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
										if(verifyQuestionUnAsweredPopup()) {
											List<WebElement> assessmentCompleteElement = baseHandler.findElements(".modal-section button");
											if(CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
												assessmentCompleteElement.get(0).click();
											}
											//clickButton(PropertiesRepository.getString("new-atitesting.myati.assessment.question.unanswered.close.loc"), 0);
											clickAssessmemtType();
										}
									}
								}
							}

						}
						if (breakFlag) {
							break;
						}
					}
				} else {
					List<WebElement> buttonElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
					if(CollectionUtils.isNotEmpty(buttonElement)) {
						if(buttonElement.get(0).isDisplayed()) {
							WebElement continueButtonElement = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
							if(continueButtonElement != null) {
								continueButtonElement.sendKeys(Keys.ENTER);
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								if(verifyQuestionUnAsweredPopup()) {
									List<WebElement> assessmentCompleteElement = baseHandler.findElements(".modal-section button");
									if(CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
										assessmentCompleteElement.get(0).click();
									}
									//clickButton(PropertiesRepository.getString("new-atitesting.myati.assessment.question.unanswered.close.loc"), 0);
									clickAssessmemtType();
								}
							}
						}
					}
					flagquestion = false;
				}
				
			}
		} catch (DriverException e) {
			logger.info("unable to take practice assessment" + e);
		}
		waitUntillBufferInvisible(PropertiesRepository
				.getString("new-atitesting.pleasewait.bufferLoc"));
		logger.info("Method : takeTestWithFlagging :::::::: END");
	}

	/**
	 * This method is used to create practice Assessment
	 * 
	 * @author Sagar.Rao
	 * 
	 * @throws InterruptedException
	 * 
	 * @throws DriverException
	 */
	public boolean takeAssessmentWithFlagging(boolean bool, boolean flagquestion)
			throws InterruptedException, DriverException {
		logger.info("takeAssessmentWithFlagging starts");
		boolean flag = false;
		try {
			waitUntillBufferInvisible(PropertiesRepository
					.getString("new-atitesting.pleasewait.bufferLoc"));
			switchToAssessmentFrameHandler();
			Thread.sleep(3000);
			if (bool) {
				Thread.sleep(500);
				List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
				if(CollectionUtils.isNotEmpty(rationalContinue)) {
					rationalContinue.get(0).sendKeys(Keys.ENTER);
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				}
			}
			// switch to model dialogue
			windowHandler.switchToModalDialog();
			if (flagquestion) {
				completeDialogVerifier();
			}
			// click on view result button
			List<WebElement> btn = baseHandler
					.findElements(" .button.primary-button.focus-element-flag");
			for (WebElement ele : btn) {
				if (ele.isDisplayed()) {
					String popupText = ele.getText();
					if(StringUtils.isNotEmpty(popupText) && popupText.equalsIgnoreCase("")) {
						flag = true;
					}
					ele.click();
					waitUntillLoadingImageIsDisappeared("new-atitesting.pleasewait.bufferLoc");
					break;
				}
			}

			if (flagquestion) {
				viewResultFlag();
			}
			logger.info("takeAssessment Ends");
		} catch (Exception e) {
			throw new DriverException("Unable to take practice Assessment", e);
		}
		logger.info("takeAssessmentWithFlagging End");
		return flag;
	}
	
	/**
	 * Method is used to complete Test
	 * 
	 * breakFlag If assessment has to be stopped in middle.
	 * 
	 * rationaleFlag Need to check for Rationale and My Answer.
	 * 
	 * @param bool
	 * @param breakFlag
	 * @param rationaleFlag
	 * @throws Exception
	 */
	public void takeTestFlagRemove(boolean bool, boolean breakFlag,
			boolean rationaleFlag, boolean flagquestion) throws Exception {
		logger.info("Method : takeTestFlagRemove :::::::: Starts");
		try {

			//waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			switchToAssessmentFrameHandler();
			// Getting Total Question Number
			String maxQtnTextNo = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.question.number.loc")).get(1).getText();

			// Convert String to Integer
			int maxCount = Integer.parseInt(maxQtnTextNo);

			// Getting Current Question Number
			String minQtnTextNo = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.question.number.loc")).get(0).getText();

			// Convert String to Integer
			int minCount = Integer.parseInt(minQtnTextNo);

			// Maximum Question minus Minimum Questions
			int count = maxCount - minCount;

			for (int i = 0; i <= count; i++) {

				// UnFlagging question. 
				baseHandler
				.findElement(
						PropertiesRepository
								.getString("new-atitesting.generic.tutorial.flag.value"))
				.click();
				
				List<WebElement> checkBoxElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.generic.tutorial.checkbox.new.loc"));
				List<WebElement> radioElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.generic.tutorial.radio.button.new.loc"));

				if (checkBoxElement != null) {
					checkBoxElement.get(0).click();
					checkBoxElement.get(1).click();
				}

				if (driver.findElements(By.cssSelector(".answer-fill-in-the-blank.numericTextEntry.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty")).size() > 0) {
					verifyFillForm("10");

				}

				if (CollectionUtils.isNotEmpty(baseHandler.findElements(PropertiesRepository.getString("new-atitesting.generic.tutorial.dragbox1.loc")))) {
					DragAndDropAnswer(false);
				}

				if (CollectionUtils.isNotEmpty(radioElement) && radioElement.size() > 0) {
					radioElement.get(0).click();
				}

				if (CollectionUtils.isNotEmpty(baseHandler.findElements(PropertiesRepository.getString("new-atitesting.question.img.loc")))) {
					hotSpotQuestion();
				}

				if (i == count) {
					switchToAssessmentFrameHandler();
					List<WebElement> buttonElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
					if(CollectionUtils.isNotEmpty(buttonElement)) {
						if(buttonElement.get(0).isDisplayed()) {
							WebElement continueButtonElement = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
							if(continueButtonElement != null) {
								continueButtonElement.sendKeys(Keys.ENTER);
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								if(!continueButtonElement.isEnabled()) {
									clickButton(PropertiesRepository.getString("new-atitesting.myati.assessment.question.unanswered.close.loc"), 0);
									clickAssessmemtType();
								}
							}
						}
					}
					takeAssessmentWithFlagging(rationaleFlag, flagquestion);
				} else {
					if (i == 0 && flagquestion) {
						switchToAssessmentFrameHandler();
						verifyFlag(true);
						logger.info("Question has been flaged");
						Thread.sleep(4000);
					} else {
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						switchToAssessmentFrameHandler();
						waitUntillElementIsVisible(PropertiesRepository
								.getString("new-atitesting.generic.tutorial.submit.new.loc"));
						List<WebElement> buttonElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
						if(CollectionUtils.isNotEmpty(buttonElement)) {
							if(buttonElement.get(0).isDisplayed()) {
								WebElement continueButtonElement = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
								if(continueButtonElement != null) {
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									if(verifyQuestionUnAsweredPopup()) {
										List<WebElement> assessmentCompleteElement = baseHandler.findElements(".modal-section button");
										if(CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
											assessmentCompleteElement.get(0).click();
										}
										//clickButton(PropertiesRepository.getString("new-atitesting.myati.assessment.question.unanswered.close.loc"), 0);
										clickAssessmemtType();
									}
								}
							}
						}
					}
					if (rationaleFlag) {
						waitUntillLoadingImageIsDisappeared("new-atitesting.pleasewait.bufferLoc");
						List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
						if(CollectionUtils.isNotEmpty(rationalContinue)) {
							rationalContinue.get(0).sendKeys(Keys.ENTER);
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						}
					}

					switchToAssessmentFrameHandler();

					if (bool) {
						switchToAssessmentFrameHandler();
						waitUntillElementIsVisible(PropertiesRepository
								.getString("new-atitesting.generic.tutorial.continue.loc"));
						Thread.sleep(1000);
						List<WebElement> buttonElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
						if(CollectionUtils.isNotEmpty(buttonElement)) {
							if(buttonElement.get(0).isDisplayed()) {
								WebElement continueButtonElement = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
								if(continueButtonElement != null) {
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									if(verifyQuestionUnAsweredPopup()) {
										List<WebElement> assessmentCompleteElement = baseHandler.findElements(".modal-section button");
										if(CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
											assessmentCompleteElement.get(0).click();
										}
										//clickButton(PropertiesRepository.getString("new-atitesting.myati.assessment.question.unanswered.close.loc"), 0);
										clickAssessmemtType();
									}
								}
							}
						}

					}
					if (breakFlag) {
						break;
					}
				}
			}
		} catch (DriverException e) {
			logger.info("unable to take practice assessment" + e);
		}
		waitUntillBufferInvisible(PropertiesRepository
				.getString("new-atitesting.pleasewait.bufferLoc"));
		logger.info("Method : takeTestFlagRemove :::::::: END");
	}


}
