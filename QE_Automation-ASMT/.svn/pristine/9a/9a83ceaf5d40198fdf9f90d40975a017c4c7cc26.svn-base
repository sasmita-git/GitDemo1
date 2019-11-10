package com.automation.asmt.page;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;

public class ItemTypeRegressionPage2 extends QuestionTypePage {

	private Logger logger = LogManager.getLogger(this.getClass());
	
	public ItemTypeRegressionPage2(WebDriver webDriver) {
		super(webDriver);
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
	public boolean takeTestStimulusFeatureWithQuestion(boolean bool, boolean breakFlag,
			boolean rationaleFlag, boolean flagquestion) throws Exception {
		boolean flag = false;
		logger.info("Method : takeTestStimulusFeatureWithQuestion :::::::: Starts");
		int stimulusCount = 0;
		boolean firstQuestionNo = false;
		boolean firstQuestionNoResult = true;
		boolean secondQuestionNo = false;
		boolean secondQuestionNoResult = true;
		boolean lastSection = false;
		try {

			waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
			switchToAssessmentFrameHandler();
			// Getting Total Question Number
			String maxQtnTextNo = baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(1).getText();

			// Convert String to Integer
			int maxCount = Integer.parseInt(maxQtnTextNo);

			// Getting Current Question Number
			String minQtnTextNo = baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(0).getText();

			// Convert String to Integer
			int minCount = Integer.parseInt(minQtnTextNo);

			// Maximum Question minus Minimum Questions
			int count = maxCount - minCount;

			for (int i = 0; i <= count; i++) {
				firstQuestionNo = false;
				// Verifying Stimulus Section
				List<WebElement> stimulusElement = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.stimulus.section.loc"));
				if(CollectionUtils.isNotEmpty(stimulusElement)) {
					List<WebElement> stimulusRadioElement =baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.stimulus.radio.button.new.multiple.answer.loc"));
					if(CollectionUtils.isNotEmpty(stimulusRadioElement)) {
						
						// Verify Stimulus Question no. 
						List<WebElement> stimulutQuestionElement = baseHandler.findElements(".page-number");
						if(CollectionUtils.isNotEmpty(stimulutQuestionElement)) {
							List<WebElement> stimulusQuestionSpanEle = stimulutQuestionElement.get(0).findElements(By.cssSelector("span"));
							if(CollectionUtils.isNotEmpty(stimulusQuestionSpanEle) && stimulusQuestionSpanEle.size() == 2) {
								if(stimulusQuestionSpanEle.get(0).getText().trim().equalsIgnoreCase("1") || stimulusQuestionSpanEle.get(0).getText().trim().equalsIgnoreCase("2")) {
									firstQuestionNo = true;
								}
								if(!firstQuestionNo) {
									firstQuestionNoResult = false;
								}
								if(stimulusQuestionSpanEle.get(0).getText().trim().equalsIgnoreCase("2")) {
									secondQuestionNo = true;
								}
								if(!secondQuestionNo) {
									secondQuestionNoResult = false;
								}
							}
						}
						
						// Clicking on stimulus question no. 
						stimulusRadioElement.get(0).click();
						stimulusCount++;
					}
					if(stimulusCount == 2) {
						flag = true;
					}
				}
				
				List<WebElement> checkBoxElement = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.checkbox.new.multiple.answer.loc"));
				List<WebElement> radioElement = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.radio.button.new.multiple.answer.loc"));


				if (checkBoxElement != null) {
					checkBoxElement.get(0).click();
					checkBoxElement.get(1).click();
				}

				if (driver.findElements(By.cssSelector(".answer-fill-in-the-blank.numericTextEntry.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty")).size() > 0) {
					verifyFillForm("10");

				}

				if (CollectionUtils.isNotEmpty(baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc")))) {
					DragAndDropAnswer(false);
				}

				if (CollectionUtils.isNotEmpty(radioElement) && radioElement.size() > 0) {
					List<WebElement> radioClickElement =baseHandler.findElements(".question-option.focus-element-flag.ng-scope label");
					if(CollectionUtils.isNotEmpty(radioClickElement)) {
						radioClickElement.get(0).click();
					}
				}

				if (CollectionUtils.isNotEmpty(baseHandler.findElements(PropertiesRepository.getString("asmt.question.img.loc")))) {
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
									clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
									clickAssessmemtType();
								}
							}
						}
					}
					lastSection = takeAssessmentVerifySection(rationaleFlag, flagquestion,"Finalize and View Results");
					logger.info("Stimulus first question" + firstQuestionNoResult);
					logger.info("Stimulus second question" + secondQuestionNoResult);
					logger.info("Completion section Flag   " + lastSection );
					if(firstQuestionNoResult && secondQuestionNoResult && lastSection) {
						logger.info("Both Stimulus Question 1 and 2 are displayed and assessment completion section worked as expected");
						flag = true;
					}
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
								.getString("asmt.generic.tutorial.submit.new.loc"));
						List<WebElement> buttonElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
						if(CollectionUtils.isNotEmpty(buttonElement)) {
							if(buttonElement.get(0).isDisplayed()) {
								WebElement continueButtonElement = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
								if(continueButtonElement != null) {
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									if(!continueButtonElement.isEnabled()) {
										clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
										clickAssessmemtType();
									}
								}
							}
						}
					}
					if (rationaleFlag) {
						waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
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
								.getString("asmt.generic.tutorial.continue.loc"));
						Thread.sleep(1000);
						List<WebElement> buttonElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
						if(CollectionUtils.isNotEmpty(buttonElement)) {
							if(buttonElement.get(0).isDisplayed()) {
								WebElement continueButtonElement = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
								if(continueButtonElement != null) {
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									if(!continueButtonElement.isEnabled()) {
										clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
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
			logger.info("unable to take practice assessment in takeTestStimulusFeatureWithQuestion" + e);
		}
		waitUntillBufferInvisible(PropertiesRepository
				.getString("asmt.pleasewait.bufferLoc"));
		logger.info("Method : takeTestStimulusFeatureWithQuestion :::::::: END flag --> " + flag);
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
	public boolean takeTestStimulusWithExtraText(boolean bool, boolean breakFlag,
			boolean rationaleFlag, boolean flagquestion) throws Exception {
		boolean flag = false;
		logger.info("Method : takeTestStimulusWithExtraText :::::::: Starts");
		boolean firstQuestionNoResult = true;
		boolean secondQuestionNoResult = true;
		boolean lastSection = false;
		boolean boolText = false;
		
		try {
			waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
			switchToAssessmentFrameHandler();
			// Getting Total Question Number
			String maxQtnTextNo = baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(1).getText();

			// Convert String to Integer
			int maxCount = Integer.parseInt(maxQtnTextNo);

			// Getting Current Question Number
			String minQtnTextNo = baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(0).getText();

			// Convert String to Integer
			int minCount = Integer.parseInt(minQtnTextNo);

			// Maximum Question minus Minimum Questions
			int count = maxCount - minCount;

			for (int i = 0; i <= count; i++) {
				// Verifying Stimulus Section
				List<WebElement> stimulusElement = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.stimulus.section.loc"));
				if(CollectionUtils.isNotEmpty(stimulusElement)) {
					List<WebElement> stimulusRadioElement =baseHandler.findElements("p");
					if(CollectionUtils.isNotEmpty(stimulusRadioElement)) {
						String textValue =stimulusRadioElement.get(1).getText();
						if(StringUtils.isNotBlank(textValue)) {
							if(!textValue.contains("open and close")) {
								boolText = true;
							}
						}
					}
				}
				
				List<WebElement> checkBoxElement = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.checkbox.new.multiple.answer.loc"));
				List<WebElement> radioElement = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.radio.button.new.multiple.answer.loc"));


				if (checkBoxElement != null) {
					checkBoxElement.get(0).click();
					checkBoxElement.get(1).click();
				}

				if (driver.findElements(By.cssSelector(".answer-fill-in-the-blank.numericTextEntry.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty")).size() > 0) {
					verifyFillForm("10");

				}

				if (CollectionUtils.isNotEmpty(baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc")))) {
					DragAndDropAnswer(false);
				}

				if (CollectionUtils.isNotEmpty(radioElement) && radioElement.size() > 0) {
					List<WebElement> radioClickElement =baseHandler.findElements(".question-option.focus-element-flag.ng-scope label");
					if(CollectionUtils.isNotEmpty(radioClickElement)) {
						radioClickElement.get(0).click();
					}
				}

				if (CollectionUtils.isNotEmpty(baseHandler.findElements(PropertiesRepository.getString("asmt.question.img.loc")))) {
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
									clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
									clickAssessmemtType();
								}
							}
						}
					}
					lastSection = takeAssessmentVerifySection(rationaleFlag, flagquestion,"Finalize and View Results");
					logger.info("Completion section Flag   " + boolText );
					logger.info("Completion last section Flag   " + lastSection );
					if(boolText && lastSection) {
						logger.info("Both Stimulus Question 1 and 2 are displayed and assessment completion section worked as expected");
						flag = true;
					}
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
								.getString("asmt.generic.tutorial.submit.new.loc"));
						List<WebElement> buttonElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
						if(CollectionUtils.isNotEmpty(buttonElement)) {
							if(buttonElement.get(0).isDisplayed()) {
								WebElement continueButtonElement = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
								if(continueButtonElement != null) {
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									if(!continueButtonElement.isEnabled()) {
										clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
										clickAssessmemtType();
									}
								}
							}
						}
					}
					if (rationaleFlag) {
						waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
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
								.getString("asmt.generic.tutorial.continue.loc"));
						Thread.sleep(1000);
						List<WebElement> buttonElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
						if(CollectionUtils.isNotEmpty(buttonElement)) {
							if(buttonElement.get(0).isDisplayed()) {
								WebElement continueButtonElement = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
								if(continueButtonElement != null) {
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									if(!continueButtonElement.isEnabled()) {
										clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
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
			logger.info("unable to take practice assessment in takeTestStimulusWithExtraText" + e);
		}
		waitUntillBufferInvisible(PropertiesRepository
				.getString("asmt.pleasewait.bufferLoc"));
		logger.info("Method : takeTestStimulusWithExtraText :::::::: END flag --> " + flag);
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
	public boolean takeTestVerifyQuestionForAllAssessmentsForITR(boolean bool, boolean breakFlag,
			boolean rationaleFlag, boolean flagquestion) throws Exception {
		logger.info("Method : takeTestVerifyQuestionForAllAssessmentsForITR :::::::: Starts");
		boolean flag = false;
		boolean boolQuestionFlag = false;
		boolean boolQuestionResult = true;
		boolean boolLastSection = false;
		boolean boolExhibitQuestion = false;
		boolean boolAudioQuestion = false;
		boolean boolVideoQuestion = false;
		boolean boolStimulusQuestion = false;
		boolean boolExhibitQuestionResult = true;
		boolean boolAudioQuestionResult = true;
		boolean boolVideoQuestionResult = true;
		boolean boolStimulusQuestionResult = false;
		
		try {
			waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
			switchToAssessmentFrameHandler();
			// Getting Total Question Number
			String maxQtnTextNo = baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(1).getText();

			// Convert String to Integer
			int maxCount = Integer.parseInt(maxQtnTextNo);

			// Getting Current Question Number
			String minQtnTextNo = baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(0).getText();

			// Convert String to Integer
			int minCount = Integer.parseInt(minQtnTextNo);

			// Maximum Question minus Minimum Questions
			int count = maxCount - minCount;

			for (int i = 0; i <= count; i++) {
				
				boolExhibitQuestion = false;
				boolAudioQuestion = false;
				boolVideoQuestion = false;
				boolStimulusQuestion = false;

				
				// Verifying Question for all Assessments
				List<WebElement> questionTextElement =baseHandler.findElements(PropertiesRepository.getString("asmt.question.assement.question.text.loc"));
				if(CollectionUtils.isNotEmpty(questionTextElement) && questionTextElement.size() > 0) {
					boolQuestionFlag = true;
					if(!boolQuestionFlag) {
						boolQuestionResult = false;
					}
				}
				
				// Exhibit question type. 
				logger.info("Verifying Exhibit Question type");
				List<WebElement> exhibitQuestion = baseHandler.findElements("button[class='enlarge-exhibit focus-element-flag']");
				if(CollectionUtils.isNotEmpty(exhibitQuestion)) {
					logger.info("Displayed Exhibit Question");
					boolExhibitQuestion = true;
					if(!boolExhibitQuestion) {
						logger.info("Having issues in Exhibit Question");
						boolExhibitQuestionResult = false;
					}
				}
				
				// Audio question type. 
				logger.info("Verifying Audio Question type");
				List<WebElement> audioQuestion = baseHandler.findElements(".contentArea div audio");
				if(CollectionUtils.isNotEmpty(audioQuestion)) {
					logger.info("Displayed Audio Question");
					boolAudioQuestion = true;
					if(!boolAudioQuestion) {
						logger.info("Having issues in Audio Question");
						boolAudioQuestionResult = false;
					}
				}
				
				// Video question type. 
				logger.info("Verifying Video Question type");
				List<WebElement> videoQuestion = baseHandler.findElements(".contentArea div video");
				if(CollectionUtils.isNotEmpty(videoQuestion)) {
					logger.info("Displayed Video Question");
					boolVideoQuestion = true;
					if(!boolVideoQuestion) {
						logger.info("Having issues in Video Question");
						boolVideoQuestionResult = false;
					}
				}
				
				// Stimulus question type. 
				logger.info("Verifying Stimulus Question type");
				List<WebElement> stimulusQuestion = baseHandler.findElements("div[class='stimulus-area'] .ng-binding");
				if(CollectionUtils.isNotEmpty(stimulusQuestion)) {
					logger.info("Displayed Stimulus Question");
					boolStimulusQuestion = true;
					if(!boolStimulusQuestion) {
						logger.info("Having issues in Stimulus Question");
						boolStimulusQuestionResult = false;
					}
				}
				List<WebElement> checkBoxElement = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.checkbox.new.multiple.answer.loc"));
				List<WebElement> radioElement = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.radio.button.new.multiple.answer.loc"));

				if (checkBoxElement != null) {
					checkBoxElement.get(0).click();
					checkBoxElement.get(1).click();
				}

				if (driver.findElements(By.cssSelector(".answer-fill-in-the-blank.numericTextEntry.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty")).size() > 0) {
					verifyFillForm("10");

				}

				if (CollectionUtils.isNotEmpty(baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc")))) {
					DragAndDropAnswer(false);
				}

				if (CollectionUtils.isNotEmpty(radioElement) && radioElement.size() > 0) {
					List<WebElement> radioClickElement =baseHandler.findElements(".question-option.focus-element-flag.ng-scope label");
					if(CollectionUtils.isNotEmpty(radioClickElement)) {
						radioClickElement.get(0).click();
					}
				}

				if (CollectionUtils.isNotEmpty(baseHandler.findElements(PropertiesRepository.getString("asmt.question.img.loc")))) {
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
									clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
									clickAssessmemtType();
								}
							}
						}
					}
					logger.info("Status after verifying question text in all assessments --> " + flag);
					boolLastSection = takeAssessmentVerifySection(boolQuestionFlag, flagquestion, "Finalize and View Results");
					logger.info("Verifying Last Section --> " + boolLastSection);
					logger.info("Verifying Question Section --> " + boolQuestionResult);
					logger.info("Verifying Exhibit Section --> " + boolExhibitQuestionResult);
					logger.info("Verifying Audio Section --> " + boolAudioQuestionResult);
					logger.info("Verifying Video Section --> " + boolVideoQuestionResult);
					logger.info("Verifying Stimulus Section --> " + boolStimulusQuestionResult);
					if(boolQuestionResult && boolLastSection && boolExhibitQuestionResult && boolAudioQuestionResult && boolVideoQuestionResult && boolStimulusQuestionResult) {
						logger.info("Verified all question types");
						flag = true;
					}
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
								.getString("asmt.generic.tutorial.submit.new.loc"));
						List<WebElement> buttonElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
						if(CollectionUtils.isNotEmpty(buttonElement)) {
							if(buttonElement.get(0).isDisplayed()) {
								WebElement continueButtonElement = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
								if(continueButtonElement != null) {
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									if(!continueButtonElement.isEnabled()) {
										clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
										clickAssessmemtType();
									}
								}
							}
						}
					}
					if (rationaleFlag) {
						waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
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
								.getString("asmt.generic.tutorial.continue.loc"));
						Thread.sleep(1000);
						List<WebElement> buttonElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
						if(CollectionUtils.isNotEmpty(buttonElement)) {
							if(buttonElement.get(0).isDisplayed()) {
								WebElement continueButtonElement = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
								if(continueButtonElement != null) {
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									if(!continueButtonElement.isEnabled()) {
										clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
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
			logger.info("unable to take practice assessment for takeTestVerifyQuestionForAllAssessments" + e);
		}
		waitUntillBufferInvisible(PropertiesRepository
				.getString("asmt.pleasewait.bufferLoc"));
		logger.info("Method : takeTestVerifyQuestionForAllAssessmentsForITR :::::::: END flag --> " + flag );
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
	public boolean takeTestTEASExhibitMoveSection(boolean rationaleFlag, boolean flagquestion, String nextSectionValue) throws Exception {
		logger.info("Method : takeTestTEASExhibitMoveSection :::::::: Starts");
		
		boolean flag = false;
		boolean boolExhibitFlag = false;
		boolean boolExhibitHeader = false;
		boolean boolExhinitHeaderMoveResult = false;
		
		try {

			waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
			switchToAssessmentFrameHandler();
			// Getting Total Question Number
			String maxQtnTextNo = baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(1).getText();

			// Convert String to Integer
			int maxCount = Integer.parseInt(maxQtnTextNo);

			// Getting Current Question Number
			String minQtnTextNo = baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(0).getText();

			// Convert String to Integer
			int minCount = Integer.parseInt(minQtnTextNo);

			// Maximum Question minus Minimum Questions
			int count = maxCount - minCount;

			for (int i = 0; i <= count; i++) {

				List<WebElement> checkBoxElement = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.checkbox.new.multiple.answer.loc"));
				List<WebElement> radioElement = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.radio.button.new.multiple.answer.loc"));

				if (checkBoxElement != null) {
					checkBoxElement.get(0).click();
					checkBoxElement.get(1).click();
				}

				if (driver.findElements(By.cssSelector(".answer-fill-in-the-blank.numericTextEntry.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty")).size() > 0) {
					verifyFillForm("10");

				}

				if (CollectionUtils.isNotEmpty(baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc")))) {
					DragAndDropAnswer(false);
				}

				if (CollectionUtils.isNotEmpty(radioElement) && radioElement.size() > 0) {

					List<WebElement> radioClickElement =baseHandler.findElements(".question-option.focus-element-flag.ng-scope label");
					if(CollectionUtils.isNotEmpty(radioClickElement)) {
						radioClickElement.get(0).click();
					}
					
					logger.info("Verifying Exhibit in Radio Button");
					// Verifying Exhibit Button
					boolExhibitFlag = verifyExhibitButton(true);
					if (boolExhibitFlag) {
						// Verifying Exhibit Header asmt.itr.exhibit.header.loc
						boolExhibitHeader = verifyElementWithSwitchWindow(PropertiesRepository.getString("asmt.itr.exhibit.header.loc"));
						if (boolExhibitHeader) {
							WebElement headerElement = baseHandler.findElement(PropertiesRepository.getString("asmt.itr.exhibit.header.loc"));
							if(headerElement != null) {
								// Finding current coordinates x and y axis of Exhibit header 
								Point beforeMove = headerElement.getLocation(); 
								int xBeforeAxis = beforeMove.getX();
								int yBeforeAxis = beforeMove.getY();
								// Moving it current + 100 for the same element and verify element has been moved. 
								Actions builder = new Actions(driver);   
								builder.moveToElement(headerElement).moveByOffset(xBeforeAxis+ 100 , yBeforeAxis + 100).click().build().perform();
								
								Point afterMove = headerElement.getLocation(); 
								int xAfterAxis = afterMove.getX();
								int yAfterAxis = afterMove.getY();
								
								if(xBeforeAxis + 100 == xAfterAxis  && yBeforeAxis + 100 == yAfterAxis) {
									logger.info("Elemnet is moved.");
									boolExhinitHeaderMoveResult = true;
								}
							}
							logger.info("Verified Exhibit button in Radio Button");
							clickButton(PropertiesRepository.getString("asmt.myati.assessment.exhibit.close.button.loc"),0);
							flag = true;
						}
					}
				}

				if (CollectionUtils.isNotEmpty(baseHandler.findElements(PropertiesRepository.getString("asmt.question.img.loc")))) {
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
									clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
									clickAssessmemtType();
								}
							}
						}
					}
					boolean resultFlag = takeAssessmentVerifySection(rationaleFlag, flagquestion, nextSectionValue);
					if(resultFlag && boolExhinitHeaderMoveResult) {
						flag = true;
					}
				} else {
					if (i == 0 && flagquestion) {
						switchToAssessmentFrameHandler();
						verifyFlag(true);
						logger.info("Question has been flaged");
						Thread.sleep(4000);
					} else {

						switchToAssessmentFrameHandler();
						waitUntillElementIsVisible(PropertiesRepository
								.getString("asmt.generic.tutorial.submit.new.loc"));
						List<WebElement> buttonElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
						if(CollectionUtils.isNotEmpty(buttonElement)) {
							if(buttonElement.get(0).isDisplayed()) {
								WebElement continueButtonElement = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
								if(continueButtonElement != null) {
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									if(!continueButtonElement.isEnabled()) {
										clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
										clickAssessmemtType();
									}
								}
							}
						}
					}
					if (rationaleFlag) {
						waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
						List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
						if(CollectionUtils.isNotEmpty(rationalContinue)) {
							rationalContinue.get(0).sendKeys(Keys.ENTER);
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						}
					}

				}
			}
		} catch (DriverException e) {
			logger.info("unable to take practice assessment in takeTestTEASExhibitMoveSection" + e);
		}
		waitUntillBufferInvisible(PropertiesRepository
				.getString("asmt.pleasewait.bufferLoc"));
		logger.info("Method : takeTestTEASExhibitMoveSection :::::::: END flag -->" + flag);
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
	public boolean takeTestTEASExhibitLastSurveySection(boolean rationaleFlag, boolean flagquestion) throws Exception {
		logger.info("Method : takeTestTEASExhibitLastSurveySection :::::::: Starts");
		
		boolean flag = false;
		boolean boolExhibitFlag = false;
		boolean boolExhibitHeader = false;
		boolean boolExhinitHeaderMoveResult = false;
		
		try {

			waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
			switchToAssessmentFrameHandler();
			// Getting Total Question Number
			String maxQtnTextNo = baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(1).getText();

			// Convert String to Integer
			int maxCount = Integer.parseInt(maxQtnTextNo);

			// Getting Current Question Number
			String minQtnTextNo = baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(0).getText();

			// Convert String to Integer
			int minCount = Integer.parseInt(minQtnTextNo);

			// Maximum Question minus Minimum Questions
			int count = maxCount - minCount;

			for (int i = 0; i <= count; i++) {

				List<WebElement> checkBoxElement = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.checkbox.new.multiple.answer.loc"));
				List<WebElement> radioElement = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.radio.button.new.multiple.answer.loc"));

				/*if (checkBoxElement != null) {
					checkBoxElement.get(0).click();
					checkBoxElement.get(1).click();
				}

				if (driver.findElements(By.cssSelector(".answer-fill-in-the-blank.numericTextEntry.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty")).size() > 0) {
					verifyFillForm("10");

				}

				if (CollectionUtils.isNotEmpty(baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc")))) {
					DragAndDropAnswer(false);
				}*/

				if (CollectionUtils.isNotEmpty(radioElement) && radioElement.size() > 0) {

					List<WebElement> radioClickElement =baseHandler.findElements(".question-option.focus-element-flag.ng-scope label");
					if(CollectionUtils.isNotEmpty(radioClickElement)) {
						radioClickElement.get(0).click();
					}
				}

				/*if (CollectionUtils.isNotEmpty(baseHandler.findElements(PropertiesRepository.getString("asmt.question.img.loc")))) {
					hotSpotQuestion();
				}*/

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
									clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
									clickAssessmemtType();
								}
							}
						}
					}
					boolean resultFlag = takeAssessmentVerifySection(rationaleFlag, flagquestion, "Finalize ");
					if(resultFlag && boolExhinitHeaderMoveResult) {
						flag = true;
					}
				} else {
					if (i == 0 && flagquestion) {
						switchToAssessmentFrameHandler();
						verifyFlag(true);
						logger.info("Question has been flaged");
						Thread.sleep(4000);
					} else {

						switchToAssessmentFrameHandler();
						waitUntillElementIsVisible(PropertiesRepository
								.getString("asmt.generic.tutorial.submit.new.loc"));
						List<WebElement> buttonElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
						if(CollectionUtils.isNotEmpty(buttonElement)) {
							if(buttonElement.get(0).isDisplayed()) {
								WebElement continueButtonElement = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
								if(continueButtonElement != null) {
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									if(!continueButtonElement.isEnabled()) {
										clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
										clickAssessmemtType();
									}
								}
							}
						}
					}
					if (rationaleFlag) {
						waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
						List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
						if(CollectionUtils.isNotEmpty(rationalContinue)) {
							rationalContinue.get(0).sendKeys(Keys.ENTER);
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						}
					}

				}
			}
		} catch (DriverException e) {
			logger.info("unable to take practice assessment in takeTestTEASExhibitLastSurveySection" + e);
		}
		waitUntillBufferInvisible(PropertiesRepository
				.getString("asmt.pleasewait.bufferLoc"));
		logger.info("Method : takeTestTEASExhibitLastSurveySection :::::::: END flag -->" + flag);
		return flag;
	}
	
}
