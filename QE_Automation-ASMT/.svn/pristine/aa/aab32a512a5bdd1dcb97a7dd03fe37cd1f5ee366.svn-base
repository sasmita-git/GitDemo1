package com.automation.asmt.page;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;

public class TakeAssessmentPage7 extends TakeAssessmentPage8 {

	private Logger logger = LogManager.getLogger(this.getClass());
	
	public TakeAssessmentPage7(WebDriver webDriver) {
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
	public boolean takeTestVerifyRationaleSectionFunctionality(boolean bool, boolean breakFlag,
			boolean rationaleFlag, boolean flagquestion) throws Exception {
		logger.info("Method : takeTestVerifyRationaleSectionFunctionality :::::::: Starts");
		boolean flag = false;
		boolean boolRationaleVerify = false;
		boolean boolRadioButtonVerify = false;
		boolean boolTextBoxVerify = false;
		boolean boolRadioButtonResult = false;
		boolean boolRadioFinalResult = true;
		boolean boolRationaleFinalResult = true;
		boolean boolTextBoxFinalResult = true;
		boolean boolRationaleResult = false;
		boolean boolTextBoxResult = false;
		boolean boolAnsweredRationale = false;
		boolean boolAnswerdRadioButton = false;
		boolean boolDisplayHotSpot = false;
		boolean boolDisplayDragNDrop = false;
		boolean boolDisplayCheckBox = false;
		boolean boolLastSection = false;
		
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
				
				boolRationaleVerify = false;
				boolRadioButtonVerify = false;
				boolTextBoxVerify = false;
				
				List<WebElement> checkBoxElement = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.checkbox.new.multiple.answer.loc"));
				List<WebElement> radioElement = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.radio.button.new.multiple.answer.loc"));

				if (checkBoxElement != null) {
					checkBoxElement.get(0).click();
					checkBoxElement.get(1).click();
					boolRationaleVerify = true;
					boolDisplayCheckBox = true;
				}

				if (driver.findElements(By.cssSelector(".answer-fill-in-the-blank.numericTextEntry.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty")).size() > 0) {
					verifyFillForm("10");
					boolTextBoxVerify = true;
				}

				if (CollectionUtils.isNotEmpty(baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc")))) {
					DragAndDropAnswer(false);
					boolRationaleVerify = true;
					boolDisplayDragNDrop = true;
				}

				if (CollectionUtils.isNotEmpty(radioElement) && radioElement.size() > 0) {
					List<WebElement> radioClickElement =baseHandler.findElements(".question-option.focus-element-flag.ng-scope label");
					if(CollectionUtils.isNotEmpty(radioClickElement)) {
						radioClickElement.get(0).click();
						boolRadioButtonVerify = true;
					}
				}

				if (CollectionUtils.isNotEmpty(baseHandler.findElements(PropertiesRepository.getString("asmt.question.img.loc")))) {
					hotSpotQuestion();
					boolRationaleVerify = true;
					boolDisplayHotSpot = true;
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
					// Verifying rationale for last question. 
					switchToAssessmentFrameHandler();
					logger.info("Answering last question for takeTestVerifyRationaleSectionFunctionality");
					if(boolRadioButtonVerify) {
						logger.info("Verifying Radio Button Rationale Section");
						boolRadioButtonResult = verifyElement(PropertiesRepository.getString("asmt.myati.radio.rationale.section.loc"));
						boolAnswerdRadioButton = verifyElement(PropertiesRepository.getString("asmt.myati.multiple.choise.rationale.select.checkbox.loc"));
						if(!boolRadioButtonResult && !boolAnswerdRadioButton) {
							boolRadioFinalResult = false;
						}
					} 
					
					if(boolRationaleVerify) {
						logger.info("Verifying CheckBox/ Drag and Drop/ Hot Spot Rationale Section");
						boolRationaleResult = verifyElement(PropertiesRepository.getString("asmt.myati.rationale.section.loc"));
						if(boolDisplayHotSpot) {
							logger.info("Verifying HotSpot Section");
							boolAnsweredRationale = verifyElement(PropertiesRepository.getString("asmt.myati.hotspot.rationale.section.loc"));
						}
						
						if(boolDisplayDragNDrop) {
							logger.info("Verifying Drag N Drop Section");
							boolAnsweredRationale = verifyElement(PropertiesRepository.getString("asmt.myati.dragndrop.answerd.section.loc"));
						}
						
						if(boolDisplayCheckBox) {
							logger.info("Verifying CheckBox Section");
							boolAnsweredRationale = verifyElement(PropertiesRepository.getString("asmt.myati.hotspot.rationale.section.loc"));
						}
						
						if(!boolRationaleResult && !boolAnsweredRationale) {
							logger.info("Rationale Section is not displayed for either of check box/ drag and drop/ hot spot");
							boolRationaleFinalResult = false;
						}
					}
					
					if(boolTextBoxVerify) {
						boolean boolAnsweredTextBox1 = false;
						boolean boolAnsweredTextBox2 = false;
						logger.info("Verifying TextBox Rationale Section");
						boolTextBoxResult = verifyElement(PropertiesRepository.getString("asmt.myati.textbox.rationale.section.loc"));
						boolAnsweredTextBox1 = verifyElement(PropertiesRepository.getString("asmt.assessment.answered.text.box.loc"));
						boolAnsweredTextBox2 = verifyElement(PropertiesRepository.getString("asmt.assessment.answered.text.box.test.question.loc"));
						logger.info("Text Box with test question format 1 --> " + boolAnsweredTextBox1 );
						logger.info("Text Box with test question format 2 --> " + boolAnsweredTextBox2 );
						if(!boolTextBoxResult ) {
							logger.info("Rationale Section is not displayed for any of the two text boxes");
							boolTextBoxFinalResult = false;
						}
						
					}
					
					boolLastSection = takeAssessmentVerifySection(rationaleFlag, flagquestion,"Finalize and View Results");
					
					if(boolRadioFinalResult && boolRationaleFinalResult && boolTextBoxFinalResult && boolLastSection) {
						logger.info("Verified rationale for all types of questions");
						flag = true;
					} else {
						logger.info("Unable to verify rationale for all types of questions");
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
						
						// Verifying rationale for all question other than last question. 
						switchToAssessmentFrameHandler();
						
						if(boolRadioButtonVerify) {
							logger.info("Verifying Radio Button Rationale Section");
							boolRadioButtonResult = verifyElement(PropertiesRepository.getString("asmt.myati.radio.rationale.section.loc"));
							boolAnswerdRadioButton = verifyElement(PropertiesRepository.getString("asmt.myati.multiple.choise.rationale.select.checkbox.loc"));
							if(!boolRadioButtonResult && !boolAnswerdRadioButton) {
								boolRadioFinalResult = false;
							}
						} 
						
						if(boolRationaleVerify) {
							logger.info("Verifying CheckBox/ Drag and Drop/ Hot Spot Rationale Section");
							boolRationaleResult = verifyElement(PropertiesRepository.getString("asmt.myati.rationale.section.loc"));
							if(boolDisplayHotSpot) {
								logger.info("Verifying HotSpot Section");
								boolAnsweredRationale = verifyElement(PropertiesRepository.getString("asmt.myati.hotspot.rationale.section.loc"));
							}
							
							if(boolDisplayDragNDrop) {
								logger.info("Verifying Drag N Drop Section");
								boolAnsweredRationale = verifyElement(PropertiesRepository.getString("asmt.myati.dragndrop.answerd.section.loc"));
							}
							
							if(boolDisplayCheckBox) {
								logger.info("Verifying CheckBox Section");
								boolAnsweredRationale = verifyElement(PropertiesRepository.getString("asmt.myati.radio.button.answerd.section.loc"));
							}
							
							if(!boolRationaleResult && !boolAnsweredRationale) {
								logger.info("Rationale Section is not displayed for either of check box/ drag and drop/ hot spot");
								boolRationaleFinalResult = false;
							}
						}
						
						if(boolTextBoxVerify) {
							boolean boolAnsweredTextBox1 = false;
							boolean boolAnsweredTextBox2 = false;
							logger.info("Verifying TextBox Rationale Section");
							boolTextBoxResult = verifyElement(PropertiesRepository.getString("asmt.myati.textbox.rationale.section.loc"));
							boolAnsweredTextBox1 = verifyElement(PropertiesRepository.getString("asmt.assessment.answered.text.box.loc"));
							boolAnsweredTextBox2 = verifyElement(PropertiesRepository.getString("asmt.assessment.answered.text.box.test.question.loc"));
							logger.info("Text Box with test question format 1 --> " + boolAnsweredTextBox1 );
							logger.info("Text Box with test question format 2 --> " + boolAnsweredTextBox2 );
							if(!boolTextBoxResult ) {
								logger.info("Rationale Section is not displayed for any of the two text boxes");
								boolTextBoxFinalResult = false;
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
			logger.info("unable to take practice assessment in takeTestVerifyRationaleSectionFunctionality" + e);
		}
		waitUntillBufferInvisible(PropertiesRepository
				.getString("asmt.pleasewait.bufferLoc"));
		logger.info("Method : takeTestVerifyRationaleSectionFunctionality :::::::: END flag --> " + flag);
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
	public boolean takeTestHotSpotChangeImage(boolean bool, boolean breakFlag,
			boolean rationaleFlag, boolean flagquestion) throws Exception {
		logger.info("Method : takeTestHotSpotChangeImage :::::::: Starts");
		boolean flag = false;
		boolean boolLastSection = false;
		boolean boolHotSpot = false;
		boolean boolHotSpotResult = false;
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
				}

				if (CollectionUtils.isNotEmpty(baseHandler.findElements(PropertiesRepository.getString("asmt.question.img.loc")))) {
					hotSpotQuestion();
					boolHotSpot = true;
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
					
					// Clicking on Previous button. 
					if(boolHotSpot) {
						// Click Previous button
						List<WebElement> buttonBackWardElement = baseHandler.findElements("#movePrevious");
						if(CollectionUtils.isNotEmpty(buttonBackWardElement)) {
							if(buttonBackWardElement.get(0).isDisplayed()) {
								WebElement continueButtonElement = buttonBackWardElement.get(0);
								if(continueButtonElement != null) {
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
								}
							}
						}
						
						// Change HotSpot Answer. 
						boolHotSpotResult = hotSpotQuestionNextPolygon();
						
						// Clicking on continue. 
						waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
						switchToAssessmentFrameHandler();
						List<WebElement> rationalContinueAfterPrevious = driver.findElements(By.cssSelector("#moveNext"));
						if(CollectionUtils.isNotEmpty(rationalContinueAfterPrevious)) {
							rationalContinueAfterPrevious.get(0).sendKeys(Keys.ENTER);
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						}
						boolHotSpot = false; // To avoid second time verification. 
						
					}
					
					boolLastSection = takeAssessmentVerifySection(rationaleFlag, flagquestion,"Finalize and View Results");
					if(boolHotSpotResult && boolLastSection) {
						logger.info("HotSpot Change image and finalize and view results section verified");
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
						
						// Clicking on Previous button. 
						if(boolHotSpot) {
							// Click Previous button
							List<WebElement> buttonBackWardElement = baseHandler.findElements("#movePrevious");
							if(CollectionUtils.isNotEmpty(buttonBackWardElement)) {
								if(buttonBackWardElement.get(0).isDisplayed()) {
									WebElement continueButtonElement = buttonBackWardElement.get(0);
									if(continueButtonElement != null) {
										continueButtonElement.sendKeys(Keys.ENTER);
										waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
									}
								}
							}
							
							// Change HotSpot Answer. 
							boolHotSpotResult = hotSpotQuestionNextPolygon();
							
							// Clicking on continue. 
							waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
							switchToAssessmentFrameHandler();
							List<WebElement> rationalContinueAfterPrevious = driver.findElements(By.cssSelector("#moveNext"));
							if(CollectionUtils.isNotEmpty(rationalContinueAfterPrevious)) {
								rationalContinueAfterPrevious.get(0).sendKeys(Keys.ENTER);
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
							}
							boolHotSpot = false; // To avoid second time verification. 
						}
					}
				}
			}
		} catch (DriverException e) {
			logger.info("unable to take practice assessment" + e);
		}
		waitUntillBufferInvisible(PropertiesRepository
				.getString("asmt.pleasewait.bufferLoc"));
		logger.info("Method : takeTest :::::::: END flag --> " + flag );
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
	public boolean takeTestWithFlaggingFunctionality(boolean bool, boolean breakFlag,
			boolean rationaleFlag, boolean flagquestion) throws Exception {
		boolean flag = false;
		boolean boolLastSection = false;
		logger.info("Method : takeTestWithFlaggingFunctionality :::::::: Starts");
		
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
					//DragAndDropAnswer(false);
					// Clicking on Flag Button. 
					clickButton(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"), 0);
				}

				if (CollectionUtils.isNotEmpty(radioElement)
						&& radioElement.size() > 0) {

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
					boolLastSection = takeAssessmentVerifyAllSection(boolLastSection, flagquestion, "Review Flagged ");
					if(boolLastSection) {
						logger.info("Verifying All buttons in last section and clicked in Review Flagged button successfully");
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
				}
			}
		} catch (DriverException e) {
			logger.info("unable to take practice assessment in takeTestWithFlaggingFunctionality" + e);
		}
		waitUntillBufferInvisible(PropertiesRepository
				.getString("asmt.pleasewait.bufferLoc"));
		logger.info("Method : takeTestWithFlaggingFunctionality :::::::: END flag --> " + flag);
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
	public boolean takeTestWithUnFlagFuncationality(boolean bool, boolean breakFlag,
			boolean rationaleFlag, boolean flagquestion) throws Exception {
		logger.info("Method : takeTesttakeTestWithUnFlagFuncationalityWithUnFlag :::::::: Starts");
		boolean flag = false;
		try {

			waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
			switchToAssessmentFrameHandler();
			// Getting Total Question Number
			String maxQtnTextNo = baseHandler
					.findElements(
							PropertiesRepository
									.getString("asmt.question.ending.number.loc"))
					.get(1).getText();

			// Convert String to Integer
			int maxCount = Integer.parseInt(maxQtnTextNo);

			// Getting Current Question Number
			String minQtnTextNo = baseHandler
					.findElements(
							PropertiesRepository
									.getString("asmt.question.ending.number.loc"))
					.get(0).getText();

			// Convert String to Integer
			int minCount = Integer.parseInt(minQtnTextNo);

			// Maximum Question minus Minimum Questions
			int count = maxCount - minCount;

			for (int i = 0; i <= count; i++) {
				// Unflag the assessment. 
				clickButton(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"), 0);
				
				List<WebElement> checkBoxElement = baseHandler
						.findElements(PropertiesRepository
								.getString("asmt.generic.tutorial.checkbox.new.loc"));
				List<WebElement> radioElement = baseHandler
						.findElements(PropertiesRepository
								.getString("asmt.generic.tutorial.radio.button.new.loc"));

				if (checkBoxElement != null) {
					checkBoxElement.get(0).click();
					checkBoxElement.get(1).click();
				}

				if (driver
						.findElements(
								By.cssSelector(".answer-fill-in-the-blank.numericTextEntry.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty"))
						.size() > 0) {
					verifyFillForm("10");

				}

				if (CollectionUtils
						.isNotEmpty(baseHandler.findElements(PropertiesRepository
								.getString("asmt.generic.tutorial.dragbox1.loc")))) {
					DragAndDropAnswer(false);
				}

				if (CollectionUtils.isNotEmpty(radioElement)
						&& radioElement.size() > 0) {
					radioElement.get(0).click();
				}

				if (CollectionUtils.isNotEmpty(baseHandler
						.findElements(PropertiesRepository
								.getString("asmt.question.img.loc")))) {
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
					takeAssessment(rationaleFlag, flagquestion,"Finalize and View Results");
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
									// Checking for Assessment Completed Popup if assessment are clicked properly
									List<WebElement> assessmentCompleteContinueElement = baseHandler.findElements(".modal-section div button");
									if(CollectionUtils.isNotEmpty(assessmentCompleteContinueElement)) {
										takeAssessment(false, flagquestion,"Finalize and View Results");
										flag = true;
										break;
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
							// Checking for Assessment Completed Popup
							List<WebElement> assessmentCompleteElement = baseHandler.findElements(".modal-section div button");
							if(CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
								takeAssessment(false, flagquestion,"Finalize and View Results");
							}
						}
					}
				}
			}
		} catch (DriverException e) {
			logger.info("unable to take practice assessment" + e);
		}
		waitUntillBufferInvisible(PropertiesRepository
				.getString("asmt.pleasewait.bufferLoc"));
		logger.info("Method : takeTestWithUnFlagFuncationality :::::::: END flag --> " + flag);
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
	public boolean takeTEASVerifyingGoToBackSection(boolean bool, boolean breakFlag,
			boolean rationaleFlag, boolean flagquestion) throws Exception {
		logger.info("Method : takeTEASVerifyingGoToBackSection :::::::: Starts");
		boolean flag = false;
		boolean boolFinalSection = false;
		boolean boolQuestionNoFlag = false;
		boolean boolAfterLastQuestionButton = false;
		
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

				//List<WebElement> checkBoxElement = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.checkbox.new.loc"));
				List<WebElement> radioElement = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.radio.button.new.multiple.answer.loc"));

				if (CollectionUtils.isNotEmpty(radioElement) && radioElement.size() > 0) {
					List<WebElement> radioClickElement =baseHandler.findElements(".question-option.focus-element-flag.ng-scope label");
					if(CollectionUtils.isNotEmpty(radioClickElement)) {
						radioClickElement.get(0).click();
					}
				}
				
/*				if (checkBoxElement != null) {
					checkBoxElement.get(0).click();
					checkBoxElement.get(1).click();
				}

				if (driver.findElements(By.cssSelector(".answer-fill-in-the-blank.numericTextEntry.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty")).size() > 0) {
					verifyFillForm("10");

				}

				if (CollectionUtils.isNotEmpty(baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc")))) {
					DragAndDropAnswer(false);
				}

				if (CollectionUtils.isNotEmpty(baseHandler.findElements(PropertiesRepository.getString("asmt.question.img.loc")))) {
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
					logger.info("Clicking on Go to Back to Last Section");
					boolAfterLastQuestionButton = takeAssessmentVerifySection(rationaleFlag, flagquestion, "Go Back to Last");
					// Verifying Question No after clicking on Go back to last question. 
					
					// Getting Total Question Number
					String maxQtnTextNoLast = baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(1).getText();

					// Convert String to Integer
					int maxCountLast = Integer.parseInt(maxQtnTextNoLast);

					// Getting Current Question Number
					String minQtnTextNoLast = baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(0).getText();

					// Convert String to Integer
					int minCountLast = Integer.parseInt(minQtnTextNoLast);
					
					logger.info("Verifying question count after clicking go back to last section");
					if(maxCountLast == minCountLast) {
						logger.info("Verified Question No after clicking last question button. ");
						boolQuestionNoFlag = true;
					}
					
					// Clicking on Continue button. 
					List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
					if(CollectionUtils.isNotEmpty(rationalContinue)) {
						rationalContinue.get(0).sendKeys(Keys.ENTER);
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
					}
					
					// Clicking on Finalize and View Results button. 
					logger.info("Clicking on Proceed to Next Section");
					boolFinalSection = takeAssessmentVerifySection(bool, flagquestion, "Proceed to Next");
					
					logger.info("Verifying Last Question" + boolAfterLastQuestionButton);
					logger.info("Verifying Question no at last Question " + boolQuestionNoFlag);
					logger.info("Verifying last section for proceed to next " + boolFinalSection);
					if(boolAfterLastQuestionButton && boolQuestionNoFlag && boolFinalSection) {
						logger.info("Verified all sections");
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
						//switchToAssessmentFrameHandler();
						//waitUntillElementIsVisible(PropertiesRepository.getString("asmt.generic.tutorial.submit.new.loc"));
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
			logger.info("unable to take practice assessment in takeTEASPostAssessmentSurvey" + e);
		}
		waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		logger.info("Method : takeTEASVerifyingGoToBackSection :::::::: END flag --> " + flag);
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
	public boolean takeTestTEASVerifyLastSection(boolean bool, boolean breakFlag,
			boolean rationaleFlag, boolean flagquestion) throws Exception {
		logger.info("Method : takeTestTEASVerifyLastSection :::::::: Starts");
		boolean flag = false;
		boolean boolFinalSection = false;
		
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

				List<WebElement> radioElement = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.radio.button.new.multiple.answer.loc"));

				if (CollectionUtils.isNotEmpty(radioElement) && radioElement.size() > 0) {
					List<WebElement> radioClickElement =baseHandler.findElements(".question-option.focus-element-flag.ng-scope label");
					if(CollectionUtils.isNotEmpty(radioClickElement)) {
						radioClickElement.get(0).click();
					}
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
					boolFinalSection = takeAssessmentVerifySection(rationaleFlag, flagquestion, "Finalize");
					logger.info("Verifying final section --> "+ boolFinalSection);
					
					if(boolFinalSection) {
						logger.info("Verified all sections ") ;
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
			logger.info("unable to take practice assessment in takeTestTEASVerifyLastSection" + e);
		}
		waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		logger.info("Method : takeTest :::::::: END flag --> " + flag);
		return flag;
	}
}

	
