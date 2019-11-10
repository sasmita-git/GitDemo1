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
import com.ascendlearning.automation.ui.handlers.ButtonHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;

public class TakeAssessmentPage3 extends TakeAssessmentPage4 {
	
	private Logger logger = LogManager.getLogger(this.getClass());

	private ButtonHandler buttonHandler;
	private WindowHandler windowHandler;
	
	public TakeAssessmentPage3(WebDriver webDriver) {
		super(webDriver);
		buttonHandler = new ButtonHandler(driver);
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
	public boolean takeTestContinueButtonErrorMsgFeature(boolean bool, boolean breakFlag,
			boolean rationaleFlag, boolean flagquestion) throws Exception {
		logger.info("Method : takeTestContinueButtonErrorMsgFeature :::::::: Starts");
		boolean boolFlagButton = false;
		int countFlagButton = 0;
		boolean flag = false;
		
		boolean firstPreviousButton = false;
		boolean firstContinousButton = false;
		boolean secondPreviousButton = false;
		boolean secondContinousButton = false;
		
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
				boolFlagButton = false;
				List<WebElement> checkBoxElement = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.checkbox.new.loc"));
				List<WebElement> radioElement = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.radio.button.new.loc"));

				if (checkBoxElement != null) {
					checkBoxElement.get(0).click();
					checkBoxElement.get(1).click();
				}

				if (driver.findElements(By.cssSelector(".answer-fill-in-the-blank.numericTextEntry.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty")).size() > 0) {
					countFlagButton++;
					if(countFlagButton == 1) {
						
					} else {
						verifyFillForm("10");						
					}
				}

				if (CollectionUtils.isNotEmpty(baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc")))) {
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
					takeAssessment(rationaleFlag, flagquestion);
				} else {
					if (i == 0 && flagquestion) {
						switchToAssessmentFrameHandler();
						verifyFlag(true);
						logger.info("Question has been flaged");
						Thread.sleep(4000);
					} else {
						switchToAssessmentFrameHandler();
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						if(minCount == 1 && i == 0) {
							// Verify Previous Button
							List<WebElement> buttonBackWardElement = baseHandler.findElements(".move-to-prev-content.focus-element-flag.ng-hide");
							if(CollectionUtils.isNotEmpty(buttonBackWardElement) && buttonBackWardElement.size() == 1) {
								firstPreviousButton = true;
							}
							
							// Verify Continous Button
							List<WebElement> buttonElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
							if(CollectionUtils.isNotEmpty(buttonElement)) {
								if(buttonElement.get(0).isDisplayed()) {
									WebElement continueButtonElement = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
									if(continueButtonElement != null) {
										firstContinousButton = true;
										continueButtonElement.sendKeys(Keys.ENTER);
										waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
										if(!continueButtonElement.isEnabled()) {
											clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
											clickAssessmemtType();
										}
									}
								}
							}
						} else {
							if(countFlagButton == 1) {
								// Verify Previous Button 
								List<WebElement> buttonBackWardElement = baseHandler.findElements("#movePrevious");
								if(CollectionUtils.isNotEmpty(buttonBackWardElement)) {
									if(buttonBackWardElement.get(0).isDisplayed()) {
										WebElement continueButtonElement = buttonBackWardElement.get(0);
										if(continueButtonElement != null) {
											secondPreviousButton = true;
										}
									}
								}
								// Verify Continous Button
								List<WebElement> buttonElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
								if(CollectionUtils.isNotEmpty(buttonElement)) {
									if(buttonElement.get(0).isDisplayed()) {
										WebElement continueButtonElement = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
										if(continueButtonElement != null) {
											secondContinousButton = true;
											boolFlagButton = true;
											continueButtonElement.sendKeys(Keys.ENTER);
											waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
											// Verifying Unanswered Question
											List<WebElement> unAnsweredQuestion = baseHandler.findElements(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"));
											if(CollectionUtils.isNotEmpty(unAnsweredQuestion)) {
												clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
												// Entering value for text box
												verifyFillForm("10");
												boolFlagButton = true;
												switchToAssessmentFrameHandler();
												// clicking on Continous Button again to proceed.
												List<WebElement> buttonElementAgain = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
												if(CollectionUtils.isNotEmpty(buttonElementAgain)) {
													if(buttonElementAgain.get(0).isDisplayed()) {
														WebElement continueButtonElementAgain = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
														if(continueButtonElementAgain != null) {
															continueButtonElementAgain.sendKeys(Keys.ENTER);
															waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
														}
													}
												}
											}
											
											/*if(!continueButtonElement.isEnabled()) {
												
											}*/
										}
									}
								}
							} else {
								// Verify Continue Button
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
					
					// Verifying Rationale Feature
					if(firstPreviousButton && firstContinousButton && secondPreviousButton && secondContinousButton && boolFlagButton) {
						if (rationaleFlag) {
							System.out.println(firstPreviousButton+"   "+ firstContinousButton+"   "+secondPreviousButton+"   "+secondContinousButton+"   "+boolFlagButton);
							flag = true;
						}
					}
					switchToAssessmentFrameHandler();
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
			logger.info("unable to take practice assessment" + e);
		}
		waitUntillBufferInvisible(PropertiesRepository
				.getString("asmt.pleasewait.bufferLoc"));
		logger.info("Method : takeTestContinueButtonErrorMsgFeature :::::::: END flag --> " + flag);
		return flag;
	}

	/**
	 * Method is used to stop when corresponding question type is matched in
	 * parameter. Currently it will work for
	 * 
	 * 1. Text Box. 2. Drop Down.
	 * 
	 * @param rationalFlag
	 *            - If yes click on continue
	 * @param questiontype
	 *            - Text box or drag and drop or checkbox or hotspot.
	 * @param textans
	 *            - Filling the text box.
	 * @param stop
	 *            - Used only for Drag and Drop o - If yes, only one item will
	 *            be moved from source to target.
	 * @throws Exception
	 */
	public void takeTestTillTypeOfQuestion(boolean rationalFlag,
			String questiontype, String textans, boolean stop) throws Exception {
		logger.info("Method : takeNurseLogicTest :::::::: Starts");
		try {
			waitUntillBufferInvisible(PropertiesRepository
					.getString("asmt.pleasewait.bufferLoc"));
			waitUntillBufferInvisible(PropertiesRepository
					.getString("asmt.pleasewait.bufferLoc"));
			waitUntillBufferInvisible(PropertiesRepository
					.getString("asmt.pleasewait.bufferLoc"));
			waitUntillBufferInvisible(PropertiesRepository
					.getString("asmt.pleasewait.bufferLoc"));
			waitUntillBufferInvisible(PropertiesRepository
					.getString("asmt.pleasewait.bufferLoc"));
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

				List<WebElement> checkBoxElement = baseHandler
						.findElements(".question-option.focus-element-flag label");

				List<WebElement> radioElement = baseHandler
						.findElements(PropertiesRepository
								.getString("asmt.generic.tutorial.radio.button.loc"));

				if (checkBoxElement != null) {
					checkBoxElement.get(0).click();
					checkBoxElement.get(1).click();
					if (questiontype.equalsIgnoreCase("checkbox"))
						break;
				}

				if (driver
						.findElements(
								By.cssSelector(".answer-fill-in-the-blank.numericTextEntry.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty"))
						.size() > 0) {
					verifyFillForm(textans);
					if (questiontype.equalsIgnoreCase("text"))
						break;
				}

				if (CollectionUtils
						.isNotEmpty(baseHandler.findElements(PropertiesRepository
								.getString("asmt.generic.tutorial.dragbox1.loc")))) {
					DragAndDropAnswer(stop);
					if (questiontype.equalsIgnoreCase("draganddrop"))
						break;
				}

				if (CollectionUtils.isNotEmpty(radioElement)
						&& radioElement.size() > 0) {
					baseHandler
							.findElements(
									PropertiesRepository
											.getString("asmt.generic.tutorial.radio.button.loc"))
							.get(0).click();
				}

				if (CollectionUtils.isNotEmpty(baseHandler
						.findElements(PropertiesRepository
								.getString("asmt.question.img.loc")))) {
					hotSpotQuestion();
					if (questiontype.equalsIgnoreCase("hotspot")) {
						break;
					}
				}

				if (i == count) {
					switchToAssessmentFrameHandler();
					waitUntillElementIsVisible(PropertiesRepository
							.getString("asmt.generic.tutorial.submit.new.loc"));
					Thread.sleep(2000);
					buttonHandler.clickButton(PropertiesRepository
							.getString("asmt.generic.tutorial.submit.new.loc"));
					takeAssessment(false, false);
				} else {
					switchToAssessmentFrameHandler();
					Thread.sleep(2000);
					waitUntillElementIsVisible(PropertiesRepository
							.getString("asmt.generic.tutorial.submit.new.loc"));
					baseHandler
							.findElement(
									PropertiesRepository
											.getString("asmt.generic.tutorial.submit.new.loc"))
							.click();
					if (rationalFlag) {
						waitUntillElementIsVisible(PropertiesRepository
								.getString("asmt.generic.tutorial.continue.loc"));
						Thread.sleep(2000);
						buttonHandler
								.clickButton(PropertiesRepository
										.getString("asmt.generic.tutorial.continue.loc"));
						switchToAssessmentFrameHandler();
					}

				}

			}
		} catch (DriverException e) {
			logger.info("unable to take practice assessment" + e);
		}
		waitUntillBufferInvisible(PropertiesRepository
				.getString("asmt.pleasewait.bufferLoc"));
		logger.info("Method : takeNurseLogicTest :::::::: END");

	}
	
	/**
	 * Method is used to complete Test
	 * 
	 * breakFlag If assessment has to be stopped in middle.
	 * 
	 * rationaleFlag Need to check for Rationale and My Answer.
	 * 
	 * @param rationaleFlag
	 * @throws Exception
	 */
	public boolean takeTestContinueButtonFeature(boolean rationaleFlag, boolean flagquestion) throws Exception {
		logger.info("Method : takeTestContinueButtonFeature :::::::: Starts");
		int rationaleVerificationCount = 0;
		boolean flag = false;
		boolean boolInitialContinueElement = false;
		boolean boolContinueBtnEnabled = false;
		boolean boolRationaleVerification = false;
		boolean boolPreviousButtonVerify = false;
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
				boolInitialContinueElement = false;
				boolPreviousButtonVerify = false;
				
				// To verify rationale by clicking previous button.
				if(boolRationaleVerification) {
					boolPreviousButtonVerify = true;
				}
				// Verify Continue button. 
				List<WebElement> initialContinueElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
				if(CollectionUtils.isNotEmpty(initialContinueElement)) {
					if(initialContinueElement.get(0).isDisplayed()) {
						WebElement continueButtonElement = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
						if(continueButtonElement != null) {
							boolInitialContinueElement = true;
						} else {
							boolInitialContinueElement = false;
						}
					}
				}
				// If it is not displayed for each assessment, break and make the test case fail.
				if(!boolInitialContinueElement) {
					log(logger, "Initially Continue button is not displayed");
					flag = false;
					break;
				}
				List<WebElement> checkBoxElement = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.checkbox.new.loc"));
				List<WebElement> radioElement = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.radio.button.new.loc"));

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
					radioElement.get(0).click();
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
					takeAssessment(rationaleFlag, flagquestion);
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
						// It used to verify back functionality.
						if(minCount == 1 && i != 0) {
							rationaleVerificationCount++;
						}
						if(rationaleVerificationCount == 1) {
							boolRationaleVerification = true;
						}
						
						// Clicking previous button for txt box.
						if(boolPreviousButtonVerify) {
							boolRationaleVerification = false;
							// Verify Previous Button 
							List<WebElement> buttonBackWardElement = baseHandler.findElements("#movePrevious");
							if(CollectionUtils.isNotEmpty(buttonBackWardElement)) {
								if(buttonBackWardElement.get(0).isDisplayed()) {
									WebElement previousButtonElement = buttonBackWardElement.get(0);
									if(previousButtonElement != null) {
										previousButtonElement.click();
										waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									}
								}
							}
							// Verify Rationale on. 
							flag = verifyFlagDisabled();
							switchToAssessmentFrameHandler();
							
							// Clicking on Previous page Continue Button.
							List<WebElement> buttonElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));

							if(CollectionUtils.isNotEmpty(buttonElement)) {
								if(buttonElement.get(0).isDisplayed()) {
									WebElement continueButtonElement = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
									if(continueButtonElement != null) {
										continueButtonElement.sendKeys(Keys.ENTER);
										waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
										clickAssessmemtType();
									}
								}
							}
						}
						switchToAssessmentFrameHandler();						
						List<WebElement> buttonElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
						if(CollectionUtils.isNotEmpty(buttonElement)) {
							if(buttonElement.get(0).isDisplayed()) {
								WebElement continueButtonElement = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
								if(continueButtonElement != null) {
									boolContinueBtnEnabled = true;
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									if(!continueButtonElement.isEnabled()) {
										clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
										clickAssessmemtType();
									}
								} else {
									boolContinueBtnEnabled = false;
								}
							}
						}
						// After selecting option for each assessment.
						if(!boolContinueBtnEnabled) {
							log(logger, "Continue button is not displayed after selecting option from each assessment");
							flag = false;
							break;
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
			logger.info("unable to take practice assessment" + e);
		}
		waitUntillBufferInvisible(PropertiesRepository
				.getString("asmt.pleasewait.bufferLoc"));
		logger.info("Method : takeTestContinueButtonFeature :::::::: END flag -> " + flag);
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
	public void takeTestAnswerMovePosition(boolean rationaleFlag, boolean flagquestion) throws Exception {
		logger.info("Method : takeTestAnswerMovePosition :::::::: Starts");
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

				List<WebElement> checkBoxElement = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.checkbox.new.loc"));
				List<WebElement> radioElement = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.radio.button.new.loc"));

				if (checkBoxElement != null) {
					checkBoxElement.get(0).click();
					checkBoxElement.get(1).click();
				}

				if (driver.findElements(By.cssSelector(".answer-fill-in-the-blank.numericTextEntry.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty")).size() > 0) {
					verifyFillForm("10");

				}

				if (CollectionUtils.isNotEmpty(baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc")))) {
					DragAndDropAnswerMovingPosition(false);
				}

				if (CollectionUtils.isNotEmpty(radioElement) && radioElement.size() > 0) {
					radioElement.get(0).click();
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
					takeAssessment(rationaleFlag, flagquestion);
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
			logger.info("unable to take practice assessment" + e);
		}
		waitUntillBufferInvisible(PropertiesRepository
				.getString("asmt.pleasewait.bufferLoc"));
		logger.info("Method : takeTestAnswerMovePosition :::::::: END");
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
	public boolean takeTestReturnToLastQuestion(boolean bool, boolean breakFlag,
			boolean rationaleFlag, boolean flagquestion) throws Exception {
		logger.info("Method : takeTestReturnToLastQuestion :::::::: Starts");
		boolean flag = false;
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

				List<WebElement> checkBoxElement = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.checkbox.new.loc"));
				List<WebElement> radioElement = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.radio.button.new.loc"));

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
					radioElement.get(0).click();
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
					takeAssessment(true, flagquestion,"Go Back to");
					flag = verifyLastQuestion();
					if(flag) {
						clickContinueButton();
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
				}
			}
		} catch (DriverException e) {
			logger.info("unable to take practice assessment" + e);
		}
		waitUntillBufferInvisible(PropertiesRepository
				.getString("asmt.pleasewait.bufferLoc"));
		logger.info("Method : takeTestReturnToLastQuestion :::::::: END flag --> " + flag);
		return flag;
	}
	
	public boolean verifyLastQuestion() throws Exception {
		logger.info("Method: verifyLastQuestion Starts");
		boolean flag = false;
    	try {
    		switchToAssessmentFrameHandler();
			// Getting Total Question Number
			String maxQtnTextNo = baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(1).getText();

			// Convert String to Integer
			int maxCount = Integer.parseInt(maxQtnTextNo);

			// Getting Current Question Number
			String minQtnTextNo = baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(0).getText();

			// Convert String to Integer
			int minCount = Integer.parseInt(minQtnTextNo);
			
			if(minCount == maxCount) {
				flag = true;
			}
			windowHandler.switchToLatestWindow();
    	} catch (Exception e) {
    		logger.info("Unable to verifyLastQuestion");
			log(logger, "Unable to verifyLastQuestion" );
    		throw new DriverException("Unable to verifyLastQuestion" , e); 
    	}
    	logger.info("Method: verifyLastQuestion End flag --> " + flag);
    	return flag;
	}
	
	public void clickContinueButton() throws Exception {
		logger.info("Method: clickContinueButton Starts");
    	try {
    		switchToAssessmentFrameHandler();
    		waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
			List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
			if(CollectionUtils.isNotEmpty(rationalContinue)) {
				rationalContinue.get(0).sendKeys(Keys.ENTER);
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			}
			takeAssessment(false, false,"Finalize ");
    	} catch (DriverException e) {
    		logger.info("Unable to " );
			log(logger, "Unable to " );
    		throw new DriverException("Unable to " , e); 
    	}
    	logger.info("Method: clickContinueButton End " );
	}
	
}

