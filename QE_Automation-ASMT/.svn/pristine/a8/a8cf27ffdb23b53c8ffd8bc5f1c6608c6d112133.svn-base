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

public class TakeAssessmentPage2 extends TakeAssessmentPage3 {
	
	private Logger logger = LogManager.getLogger(this.getClass());

	public TakeAssessmentPage2(WebDriver webDriver) {
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
	public boolean takeTestMouseHoverFeature(boolean bool, boolean breakFlag,
			boolean rationaleFlag, boolean flagquestion) throws Exception {
		logger.info("Method : takeTestMouseHoverFeature :::::::: Starts");
		
		boolean boolMouseHover = false;
		int countMouseHover = 0;
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
				boolMouseHover = false;
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

				if (CollectionUtils.isNotEmpty(radioElement)
						&& radioElement.size() > 0) {
					radioElement.get(0).click();
					countMouseHover ++;
					if(countMouseHover == 1) {
						boolMouseHover = true;
					}
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
								handelQuestionUnansweredPopup();
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								if(!continueButtonElement.isEnabled()) {
								handelQuestionUnansweredPopup();
							}
							}
						}
					}
					if(boolMouseHover) {
						flag = takeAssessmentMouseHover(boolMouseHover, rationaleFlag, flagquestion);
					} else {
						flag = takeAssessmentMouseHover(boolMouseHover, rationaleFlag, flagquestion);
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
										handelQuestionUnansweredPopup();
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

					// Verifying mouse hover feature
					if(boolMouseHover) {
						flag = verifyDisableElement();
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
									handelQuestionUnansweredPopup();
									if(!continueButtonElement.isEnabled()) {
									handelQuestionUnansweredPopup();
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
				.getString("asmt.pleasewait.bufferLoc"));
		logger.info("Method : takeTestMouseHoverFeature :::::::: END");
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
	public boolean takeTestFlagFeature(boolean bool, boolean breakFlag,
			boolean rationaleFlag, boolean flagquestion) throws Exception {
		logger.info("Method : takeTestFlagFeature :::::::: Starts");
		boolean boolFlagButton = false;
		int countFlagButton = 0;
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
			if( minCount != 1) {
				for (int i = minCount; i <= maxCount; i++) {
					boolFlagButton = false;
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

					if (CollectionUtils.isNotEmpty(radioElement)
							&& radioElement.size() > 0) {
						radioElement.get(0).click();
						countFlagButton ++;
						if(countFlagButton == 1) {
							boolFlagButton = true;
						}
					}

					if (CollectionUtils.isNotEmpty(baseHandler
							.findElements(PropertiesRepository
									.getString("asmt.question.img.loc")))) {
						hotSpotQuestion();
					}

					if (i == count) {
						if(!verifyFlagDisabled()) {
						
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
						}
						if(boolFlagButton) {
							flag = takeAssessmentDisabledFlag(boolFlagButton, rationaleFlag, flagquestion);
						} else {
							flag = takeAssessmentDisabledFlag(boolFlagButton, rationaleFlag, flagquestion);
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
						
						// Verifying mouse hover feature
						if(boolFlagButton) {
							flag = verifyFlagDisabled();
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
			}
			for (int i = 0; i <= count; i++) {
				boolFlagButton = false;
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

				if (CollectionUtils.isNotEmpty(radioElement)
						&& radioElement.size() > 0) {
					radioElement.get(0).click();
					countFlagButton ++;
					if(countFlagButton == 1) {
						boolFlagButton = true;
					}
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
					if(boolFlagButton) {
						flag = takeAssessmentDisabledFlag(boolFlagButton, rationaleFlag, flagquestion);
					} else {
						flag = takeAssessmentDisabledFlag(boolFlagButton, rationaleFlag, flagquestion);
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
					
					// Verifying mouse hover feature
					if(boolFlagButton) {
						flag = verifyFlagDisabled();
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
			logger.info("unable to take practice assessment" + e);
		}
		waitUntillBufferInvisible(PropertiesRepository
				.getString("asmt.pleasewait.bufferLoc"));
		logger.info("Method : takeTestFlagFeature :::::::: END flag --> " + flag);
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
	public boolean takeTestPrevContFeature(boolean bool, boolean breakFlag,
			boolean rationaleFlag, boolean flagquestion) throws Exception {
		logger.info("Method : takeTestPrevContFeature :::::::: Starts");
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
					verifyFillForm("10");

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
							
							// Verify Continue Button
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
							countFlagButton++;
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
								// Verify Continue Button
								List<WebElement> buttonElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
								if(CollectionUtils.isNotEmpty(buttonElement)) {
									if(buttonElement.get(0).isDisplayed()) {
										WebElement continueButtonElement = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
										if(continueButtonElement != null) {
											secondContinousButton = true;
											boolFlagButton = true;
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
		logger.info("Method : takeTestPrevContFeature :::::::: END flag --> " + flag);
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
	public boolean takeTestPrevContForTxtBoxFeature(boolean bool, boolean breakFlag,
			boolean rationaleFlag, boolean flagquestion) throws Exception {
		logger.info("Method : takeTestPrevContForTxtBoxFeature :::::::: Starts");
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
					verifyFillForm("10");
					countFlagButton++;
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
											if(!continueButtonElement.isEnabled()) {
												clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
												clickAssessmemtType();
											}
										}
									}
								}
							} else {
								// Verify Continous Button
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
		logger.info("Method : takeTestPrevContForTxtBoxFeature :::::::: END flag --> " + flag);
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
	public boolean takeTestHotSpotFeature(boolean bool, boolean breakFlag,
			boolean rationaleFlag, boolean flagquestion) throws Exception {
		logger.info("Method : takeTestHotSpotFeature :::::::: Starts");
		boolean flag = true;
		int countHotSpot = 0;
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

				if (CollectionUtils.isNotEmpty(radioElement)
						&& radioElement.size() > 0) {
					radioElement.get(0).click();
				}

				if (CollectionUtils.isNotEmpty(baseHandler
						.findElements(PropertiesRepository
								.getString("asmt.question.img.loc")))) {
					hotSpotQuestion();
					countHotSpot ++;
					if(countHotSpot == 1) 
						flag = true;
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
			logger.info("unable to take practice assessment" + e);
		}
		waitUntillBufferInvisible(PropertiesRepository
				.getString("asmt.pleasewait.bufferLoc"));
		logger.info("Method : takeTestHotSpotFeature :::::::: END flag --> " + flag);
		return flag;
	}
	/*
	 * This method is used to close question unanswered pop-up if shown and click on flag and then continue.
	 * @author Abhishek Kumar
	 */
	public void handelQuestionUnansweredPopup(){
		try{
			//Close question unanswered pop-up
			clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			
			//Select answer for question.
			clickAssessmemtType();
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			
			//click on continue
			List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
			if(CollectionUtils.isNotEmpty(rationalContinue)) {
				
				rationalContinue.get(0).sendKeys(Keys.ENTER);
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		}
	} catch(Exception e){
		logger.info("unable to handel question-unanswered popup" + e);
	}
	}
}
