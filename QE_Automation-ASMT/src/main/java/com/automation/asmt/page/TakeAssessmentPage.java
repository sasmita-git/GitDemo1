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
import com.ascendlearning.automation.ui.handlers.WindowHandler;

public class TakeAssessmentPage extends TakeAssessmentPage1 {

	private Logger logger = LogManager.getLogger(this.getClass());
	private WindowHandler windowHandler;
	
	public TakeAssessmentPage(WebDriver webDriver) {
		super(webDriver);
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
	public void takeTest(boolean bool, boolean breakFlag,
			boolean rationaleFlag, boolean flagquestion) throws Exception {
		logger.info("Method : takeTest :::::::: Starts");
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
					takeAssessment(bool, flagquestion);
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
			logger.info("unable to take practice assessment" + e);
		}
		waitUntillBufferInvisible(PropertiesRepository
				.getString("asmt.pleasewait.bufferLoc"));
		logger.info("Method : takeTest :::::::: END");
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
	public boolean takeTestFlagForDiffQuestion(boolean bool, boolean breakFlag,
			boolean rationaleFlag, boolean flagquestion) throws Exception {
		logger.info("Method : takeTestFlagForDiffQuestion :::::::: Starts");
		boolean flagDiffQuestion = false;
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
				
				if(i == 2) {
					// Flagging the question
					verifyFlag(true);
					flagDiffQuestion = true;
				} else {
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
						List<WebElement> radioClickElement =baseHandler.findElements(".question-option.focus-element-flag.ng-scope label");
						if(CollectionUtils.isNotEmpty(radioClickElement)) {
							radioClickElement.get(0).click();
						}
					}
	
					if (CollectionUtils.isNotEmpty(baseHandler.findElements(PropertiesRepository.getString("asmt.question.img.loc")))) {
						hotSpotQuestion();
					}
				}
				if(i == 3) {
					// Flagging the question
					verifyFlag(true);
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
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						switchToAssessmentFrameHandler();
						waitUntillElementIsVisible(PropertiesRepository
								.getString("asmt.generic.tutorial.submit.new.loc"));
						
						if(i != 3) {
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
						
						if( i == 3) {
							// Clicking on Previous Button. 
							List<WebElement> buttonBackWardElement19 = baseHandler.findElements("#movePrevious");
							if(CollectionUtils.isNotEmpty(buttonBackWardElement19)) {
								if(buttonBackWardElement19.get(0).isDisplayed()) {
									WebElement continueButtonElement19 = buttonBackWardElement19.get(0);
									if(continueButtonElement19 != null) {
										continueButtonElement19.sendKeys(Keys.ENTER);
										waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
									}
								}
							}
							
							// check flag button is disabled. 
							flag = verifyElement(PropertiesRepository.getString("asmt.myati.disabled.flag.button.loc"));
							
							switchToAssessmentFrameHandler();
							// Clicking on Continue for third question.
							List<WebElement> buttonElementNew = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
							if(CollectionUtils.isNotEmpty(buttonElementNew)) {
								if(buttonElementNew.get(0).isDisplayed()) {
									WebElement continueButtonElementNew = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
									if(continueButtonElementNew != null) {
										continueButtonElementNew.sendKeys(Keys.ENTER);
										waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
										if(!continueButtonElementNew.isEnabled()) {
											clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
											clickAssessmemtType();
										}
									}
								}
							}
							
							 // Answering 4th question and clicking on continue button. 
							// UnFlag Question
							clickButton(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"), 0);
							
							switchToAssessmentFrameHandler();
							// Clicking on Continue. 
							List<WebElement> buttonElement4New = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
							if(CollectionUtils.isNotEmpty(buttonElement4New)) {
								if(buttonElement4New.get(0).isDisplayed()) {
									WebElement continueButtonElement4New = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
									if(continueButtonElement4New != null) {
										continueButtonElement4New.sendKeys(Keys.ENTER);
										waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
										if(!continueButtonElement4New.isEnabled()) {
											clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
											clickAssessmemtType();
										}
									}
								}
							}
							
						}
						if(flagDiffQuestion) {
							
							// Clicking on Previous Button. 
							List<WebElement> buttonBackWardElement19 = baseHandler.findElements("#movePrevious");
							if(CollectionUtils.isNotEmpty(buttonBackWardElement19)) {
								if(buttonBackWardElement19.get(0).isDisplayed()) {
									WebElement continueButtonElement19 = buttonBackWardElement19.get(0);
									if(continueButtonElement19 != null) {
										continueButtonElement19.sendKeys(Keys.ENTER);
										waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
									}
								}
							}
							
							// UnFlag Question
							clickButton(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"), 0);
							
							// Answering the question. 
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
								List<WebElement> radioClickElement =baseHandler.findElements(".question-option.focus-element-flag.ng-scope label");
								if(CollectionUtils.isNotEmpty(radioClickElement)) {
									radioClickElement.get(0).click();
								}
							}
			
							if (CollectionUtils.isNotEmpty(baseHandler.findElements(PropertiesRepository.getString("asmt.question.img.loc")))) {
								hotSpotQuestion();
							}
							switchToAssessmentFrameHandler();
							// Clicking on Continue. 
							List<WebElement> buttonElementNew = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
							if(CollectionUtils.isNotEmpty(buttonElementNew)) {
								if(buttonElementNew.get(0).isDisplayed()) {
									WebElement continueButtonElementNew = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
									if(continueButtonElementNew != null) {
										continueButtonElementNew.sendKeys(Keys.ENTER);
										waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
										if(!continueButtonElementNew.isEnabled()) {
											clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
											clickAssessmemtType();
										}
									}
								}
							}
							
							flagDiffQuestion = false;
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
		logger.info("Method : takeTestFlagForDiffQuestion :::::::: END flag --> " + flag);
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
	public boolean takeTestTextBoxValidation(boolean bool, boolean breakFlag,
			boolean rationaleFlag, boolean flagquestion) throws Exception {
		logger.info("Method : takeTestTextBoxValidation :::::::: Starts");
		boolean flag = false;
		boolean boolTextBoxValidation = false;
		boolean boolTextBoxResult = false;
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
					if(i != count && !boolTextBoxResult) {
						List<WebElement> questionText = baseHandler.findElements("#QuestionText");
						if(CollectionUtils.isNotEmpty(questionText) && !questionText.get(0).getText().trim().contains("Test question")) { 
							boolTextBoxValidation = true;
						}
					} else {
						flag = false;
						logger.info("Text box is last question, so not able to perform above functionality");
					}

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
					takeAssessment(rationaleFlag, flagquestion);
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
					if(boolTextBoxValidation) {
						logger.info("Clicking on Previous Button ");
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
						
						verifyFillFormWithClear("1.");
						logger.info("Entering value with decimal");
						switchToAssessmentFrameHandler();
						// Clicking on continue. 
						waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
						List<WebElement> rationalContinueAfterPrevious = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
						if(CollectionUtils.isNotEmpty(rationalContinueAfterPrevious)) {
							rationalContinueAfterPrevious.get(0).sendKeys(Keys.ENTER);
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						}
						//switchToAssessmentFrameHandler();
						// Click Previous button
						List<WebElement> buttonBackWardElement19 = baseHandler.findElements("#movePrevious");
						if(CollectionUtils.isNotEmpty(buttonBackWardElement19)) {
							if(buttonBackWardElement19.get(0).isDisplayed()) {
								WebElement continueButtonElement19 = buttonBackWardElement19.get(0);
								if(continueButtonElement19 != null) {
									continueButtonElement19.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
								}
							}
						}
						
						verifyFillFormWithClear("1234567891234567890.");
						logger.info("Entering value 1234567891234567890 with decimal");
						switchToAssessmentFrameHandler();
						// Clicking on continue. 
						waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
						List<WebElement> rationalContinueAfterPrevious19 = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
						if(CollectionUtils.isNotEmpty(rationalContinueAfterPrevious19)) {
							rationalContinueAfterPrevious19.get(0).sendKeys(Keys.ENTER);
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						}
						
						// Click Previous button
						List<WebElement> buttonBackWardElement20 = baseHandler.findElements("#movePrevious");
						if(CollectionUtils.isNotEmpty(buttonBackWardElement20)) {
							if(buttonBackWardElement20.get(0).isDisplayed()) {
								WebElement continueButtonElement20 = buttonBackWardElement20.get(0);
								if(continueButtonElement20 != null) {
									continueButtonElement20.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
								}
							}
						}
						
						verifyFillFormWithClear("12345678901234567890");
						logger.info("Entering value 12345678901234567890 without decimal");
						switchToAssessmentFrameHandler();
						// Clicking on continue. 
						waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
						List<WebElement> rationalContinueAfterPrevious20 = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
						if(CollectionUtils.isNotEmpty(rationalContinueAfterPrevious20)) {
							rationalContinueAfterPrevious20.get(0).sendKeys(Keys.ENTER);
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						}
						boolTextBoxResult = true;
						boolTextBoxValidation = false;
					}
					if (breakFlag) {
						break;
					}
				}
			}
			if(boolTextBoxResult) {
				flag = true;
			}
		} catch (DriverException e) {
			logger.info("unable to take practice assessment" + e);
		}
		waitUntillBufferInvisible(PropertiesRepository
				.getString("asmt.pleasewait.bufferLoc"));
		logger.info("Method : takeTestTextBoxValidation :::::::: END flag --> " + flag);
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
	public void takeTestDND(boolean bool, boolean breakFlag,
			boolean rationaleFlag, boolean flagquestion) throws Exception {
		logger.info("Method : takeTestDND :::::::: Starts");
		boolean flag = true;
		boolean boolDNDFeature = false;
		boolean boolFinal = false;
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
					boolDNDFeature = DragAndDropAnswerSection(false);
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
					//switchToAssessmentFrameHandler();
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
					boolFinal = takeAssessmentDNDFeature(rationaleFlag, flagquestion);
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

					//switchToAssessmentFrameHandler();

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
			if(boolDNDFeature && boolFinal) {
				flag = true;
			}
		} catch (DriverException e) {
			logger.info("unable to take practice assessment" + e);
		}
		waitUntillBufferInvisible(PropertiesRepository
				.getString("asmt.pleasewait.bufferLoc"));
		logger.info("Method : takeTestDND :::::::: END");
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
	public void takeTestTEAS(boolean bool, boolean breakFlag,
			boolean rationaleFlag, boolean flagquestion) throws Exception {
		logger.info("Method : takeTest :::::::: Starts");
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

			/*	List<WebElement> checkBoxElement = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.checkbox.new.loc"));
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
					List<WebElement> radioClickElement =baseHandler.findElements(".question-option.focus-element-flag.ng-scope label");
					if(CollectionUtils.isNotEmpty(radioClickElement)) {
						radioClickElement.get(0).click();
					}
				}

				if (CollectionUtils.isNotEmpty(baseHandler.findElements(PropertiesRepository.getString("asmt.question.img.loc")))) {
					hotSpotQuestion();
				}*/
				
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
					takeAssessment(bool, flagquestion);
				} else {
					if (i == 0 && flagquestion) {
						switchToAssessmentFrameHandler();
						verifyFlag(true);
						logger.info("Question has been flaged");
						Thread.sleep(4000);
					} else {
						//waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
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

					//switchToAssessmentFrameHandler();

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
		waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		logger.info("Method : takeTest :::::::: END");
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
	public boolean takeTestTEASVerifySection(boolean bool, boolean breakFlag,
			boolean rationaleFlag, boolean flagquestion) throws Exception {
		boolean flag = false;
		logger.info("Method : takeTestTEASVerifySection :::::::: Starts");
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

				if (CollectionUtils.isNotEmpty(radioElement) && radioElement.size() > 0) {
					List<WebElement> radioClickElement =baseHandler.findElements(".question-option.focus-element-flag.ng-scope label");
					if(CollectionUtils.isNotEmpty(radioClickElement)) {
						radioClickElement.get(0).click();
					}
				}
				
				/*if (driver.findElements(By.cssSelector(".answer-fill-in-the-blank.numericTextEntry.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty")).size() > 0) {
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
					flag = takeAssessmentVerifySection(rationaleFlag, flagquestion, "Proceed To Next Section", "Section Completed!");
				} else {
					if (i == 0 && flagquestion) {
						switchToAssessmentFrameHandler();
						verifyFlag(true);
						logger.info("Question has been flaged");
						Thread.sleep(4000);
					} else {
						//waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
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
			logger.info("unable to take practice assessment" + e);
		}
		waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		logger.info("Method : takeTestTEASVerifySection :::::::: END flag --> " + flag);
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
	public boolean takeTestTEASVerifyFinalSection(boolean bool, boolean breakFlag,
			boolean rationaleFlag, boolean flagquestion) throws Exception {
		logger.info("Method : takeTestTEASVerifyFinalSection :::::::: Starts");
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

				if (CollectionUtils.isNotEmpty(radioElement) && radioElement.size() > 0) {
					List<WebElement> radioClickElement =baseHandler.findElements(".question-option.focus-element-flag.ng-scope label");
					if(CollectionUtils.isNotEmpty(radioClickElement)) {
						radioClickElement.get(0).click();
					}
				}
			
				/*if (driver.findElements(By.cssSelector(".answer-fill-in-the-blank.numericTextEntry.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty")).size() > 0) {
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
					flag = takeAssessmentVerifySection(rationaleFlag, flagquestion, "Proceed To Next Section", "Assessment Completed!");
				} else {
					if (i == 0 && flagquestion) {
						switchToAssessmentFrameHandler();
						verifyFlag(true);
						logger.info("Question has been flaged");
						Thread.sleep(4000);
					} else {
						//waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
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
			logger.info("unable to takeTestTEASVerifyFinalSection" + e);
		}
		waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		logger.info("Method : takeTestTEASVerifyFinalSection :::::::: END flag --> " + flag);
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
	public boolean takeTestRationaleEnabledPreviousVerification(boolean bool, boolean breakFlag,
			boolean rationaleFlag, boolean flagquestion) throws Exception {
		logger.info("Method : takeTestRationaleEnabledPreviousVerification :::::::: Starts");
		boolean flag = false;
		//boolean textBox = false;
		boolean verifyPreviousFunc = false;
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
				
				if(i == 1) {
					verifyPreviousFunc = true;
				}
				List<WebElement> checkBoxElement = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.checkbox.new.loc"));
				List<WebElement> radioElement = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.radio.button.new.loc"));

				if (checkBoxElement != null) {
					checkBoxElement.get(0).click();
					checkBoxElement.get(1).click();
				}

				if (driver.findElements(By.cssSelector(".answer-fill-in-the-blank.numericTextEntry.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty")).size() > 0) {
					verifyFillForm("10");
					//textBox = true;
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
					takeAssessment(rationaleFlag, flagquestion);
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
						
						// Clicking on Previous button. 
						
						if(verifyPreviousFunc) {
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
						}
						// Verifying rationaleMessagae after clicking Previous button. 
						List<WebElement> rationaleMessage = baseHandler.findElements(PropertiesRepository.getString("asmt.tutorial.tutorial.myresult.loc"));
						if(CollectionUtils.isNotEmpty(rationaleMessage) && rationaleMessage.size() > 0) {
							flag = true;
						}
						
						// Clicking on continue. 
						waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
						List<WebElement> rationalContinueAfterPrevious = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
						if(CollectionUtils.isNotEmpty(rationalContinueAfterPrevious)) {
							rationalContinueAfterPrevious.get(0).sendKeys(Keys.ENTER);
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						}
					}

					

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
			logger.info("unable to takeTestRationaleEnabledPreviousVerification" + e);
		}
		waitUntillBufferInvisible(PropertiesRepository
				.getString("asmt.pleasewait.bufferLoc"));
		logger.info("Method : takeTestRationaleEnabledPreviousVerification :::::::: END");
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
	public boolean verifyAssessment() throws Exception {
		logger.info("Method : verifyAssessment :::::::: Starts");
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
					List<WebElement> checkedCheckBox = baseHandler.findElements(".question-option.focus-element-flag input[class='ng-pristine ng-untouched ng-valid ng-not-empty']");
					if(CollectionUtils.isNotEmpty(checkedCheckBox) && checkedCheckBox.size() > 0) {
						flag = true;
					}
				}

				if (driver.findElements(By.cssSelector(".answer-fill-in-the-blank.numericTextEntry.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty")).size() > 0) {
					List<WebElement> answeredTextBox = baseHandler.findElements(PropertiesRepository.getString("asmt.assessment.answered.text.box.loc"));
					if(CollectionUtils.isNotEmpty(answeredTextBox)) {
						String value = answeredTextBox.get(0).getText().trim();
						if("10".equalsIgnoreCase(value)) {
							flag = true;
						}
					}
				}

				if (CollectionUtils.isNotEmpty(baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc")))) {
					verifyDragAndDropAnswer();
				}

				if (CollectionUtils.isNotEmpty(radioElement) && radioElement.size() > 0) {
					List<WebElement> checkedCheckBox = baseHandler.findElements(".question-option.focus-element-flag input[class='ng-pristine ng-untouched ng-valid ng-not-empty']");
					if(CollectionUtils.isNotEmpty(checkedCheckBox) && checkedCheckBox.size() > 0) {
						flag = true;
					}
				}

				if (CollectionUtils.isNotEmpty(baseHandler.findElements(PropertiesRepository.getString("asmt.question.img.loc")))) {
					//hotSpotQuestion();
					flag = true;
				}
			}
			windowHandler.switchToLatestWindow();
		} catch (DriverException e) {
			logger.info("unable to take practice assessment" + e);
		}
		waitUntillBufferInvisible(PropertiesRepository
				.getString("asmt.pleasewait.bufferLoc"));
		logger.info("Method : verifyAssessment :::::::: END");
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
	public boolean takeTestDragAndDrop(boolean bool, boolean breakFlag,
			boolean rationaleFlag, boolean flagquestion) throws Exception {
		logger.info("Method : takeTestDragAndDrop :::::::: Starts");
		boolean flag = true;
		boolean dragAndDropFlag = false;
		boolean dragNDropBack = false; // It should be set for first Time.
		int dragNDropCount = 0;
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
				dragAndDropFlag = false;
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
					if(i == 0 ) { // If first assessment id drag and drop, no need to perform.
						DragAndDropAnswer(false);
					} else {
						DragAndDropAnswerForward(false);
						dragAndDropFlag = true;
						dragNDropCount++;
						if(dragNDropCount == 1) {
							dragNDropBack = true;
						}
					}
				}

				if (CollectionUtils.isNotEmpty(radioElement) && radioElement.size() > 0) {
					List<WebElement> radioClickElement =baseHandler.findElements(".question-option.focus-element-flag.ng-scope label");
					if(CollectionUtils.isNotEmpty(radioClickElement)) {
						radioClickElement.get(0).click();
					}
				}


				if (CollectionUtils.isNotEmpty(baseHandler
						.findElements(PropertiesRepository
								.getString("asmt.question.img.loc")))) {
					hotSpotQuestion();
				}

				if (i == count) {
					switchToAssessmentFrameHandler();
					if(dragAndDropFlag && dragNDropBack) {

						// Take current count in test case no.
						String currentValue = baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(0).getText();
						// Convert String to Integer
						int currentCount = Integer.parseInt(currentValue);
						
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
						// Verify count -1. 
						String previousButtonValue = baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(0).getText();
						// Convert String to Integer
						int previousButtonCount = Integer.parseInt(previousButtonValue);
						if(currentCount > previousButtonCount) {
							flag = true;
						}
						// Click and continue button and proceed.
						List<WebElement> buttonElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
						if(CollectionUtils.isNotEmpty(buttonElement)) {
							if(buttonElement.get(0).isDisplayed()) {
								WebElement continueButtonElement = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
								if(continueButtonElement != null) {
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
									DragAndDropAnswer(false);
									switchToAssessmentFrameHandler();
									// Clicking on continue button
									List<WebElement> buttonCtnElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
									if(CollectionUtils.isNotEmpty(buttonCtnElement)) {
										if(buttonElement.get(0).isDisplayed()) {
											WebElement ctnButtonElement = buttonCtnElement.get(0);
											if(ctnButtonElement != null) {
												ctnButtonElement.sendKeys(Keys.ENTER);
												waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
											}
										}
									}
								}
							}
						}
					
					} else {
					List<WebElement> buttonElement = baseHandler.findElements("footer[class='product-screen-footer'] #moveNext");
					if(CollectionUtils.isNotEmpty(buttonElement)) {
						if(buttonElement.get(0).isDisplayed()) {
							WebElement continueButtonElement = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
							if(continueButtonElement != null) {
								continueButtonElement.sendKeys(Keys.ENTER);
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								// Verifying Unanswered popup		
								List<WebElement> unAnsweredElement = baseHandler.findElements(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"));
								if(CollectionUtils.isNotEmpty(unAnsweredElement)) {
									clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
								}
								
								if(!continueButtonElement.isEnabled()) {
									clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
									clickAssessmemtType();
								}
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
						if(dragAndDropFlag && dragNDropBack) {
							// Take current count in test case no.
							String currentValue = baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(0).getText();
							// Convert String to Integer
							int currentCount = Integer.parseInt(currentValue);
							
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
							// Verify count -1. 
							String previousButtonValue = baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(0).getText();
							// Convert String to Integer
							int previousButtonCount = Integer.parseInt(previousButtonValue);
							if(currentCount > previousButtonCount) {
								flag = true;
							}
							// Click and continue button and proceed.
							List<WebElement> buttonElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
							if(CollectionUtils.isNotEmpty(buttonElement)) {
								if(buttonElement.get(0).isDisplayed()) {
									WebElement continueButtonElement = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
									if(continueButtonElement != null) {
										continueButtonElement.sendKeys(Keys.ENTER);
										waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
										DragAndDropAnswer(false);
										switchToAssessmentFrameHandler();
										// Clicking on continue button
										List<WebElement> buttonCtnElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
										if(CollectionUtils.isNotEmpty(buttonCtnElement)) {
											if(buttonElement.get(0).isDisplayed()) {
												WebElement ctnButtonElement = buttonCtnElement.get(0);
												if(ctnButtonElement != null) {
													ctnButtonElement.sendKeys(Keys.ENTER);
													waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
												}
											}
										}
									}
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
										// Verifying Unanswered popup		
										List<WebElement> unAnsweredElement = baseHandler.findElements(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"));
										if(CollectionUtils.isNotEmpty(unAnsweredElement)) {
											clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
										}
										
										if(!continueButtonElement.isEnabled()) {
											clickAssessmemtType();
										}
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
									// Verifying Unanswered popup								
									List<WebElement> unAnsweredElement = baseHandler.findElements(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"));
									if(CollectionUtils.isNotEmpty(unAnsweredElement)) {
										clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
									}
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
		logger.info("Method : takeTestDragAndDrop :::::::: END flag --> " + flag);
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
	public boolean takeTestDragAndDropBackward(boolean bool, boolean breakFlag,
			boolean rationaleFlag, boolean flagquestion) throws Exception {
 		logger.info("Method : takeTestDragAndDropBackward :::::::: Starts");
		boolean flag = true;
		boolean dragAndDropFlag = false;
		boolean dragNDropBack = false; // It should be set for first Time.
		int dragNDropCount = 0;
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
				dragAndDropFlag = false;
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
					if(i == 0 ) { // If first assessment id drag and drop, no need to perform.
						DragAndDropAnswer(false);
					} else {
						DragAndDropAnswerForward(false);
						dragAndDropFlag = true;
						dragNDropCount++;
						if(dragNDropCount == 1) {
							dragNDropBack = true;
						}
					}
				}

				if (CollectionUtils.isNotEmpty(radioElement) && radioElement.size() > 0) {
					List<WebElement> radioClickElement =baseHandler.findElements(".question-option.focus-element-flag.ng-scope label");
					if(CollectionUtils.isNotEmpty(radioClickElement)) {
						radioClickElement.get(0).click();
					}
				}


				if (CollectionUtils.isNotEmpty(baseHandler
						.findElements(PropertiesRepository
								.getString("asmt.question.img.loc")))) {
					hotSpotQuestion();
				}

				if (i == count) {
					switchToAssessmentFrameHandler();
					if(dragAndDropFlag && dragNDropBack) {

						// Take current count in test case no.
						String currentValue = baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(0).getText();
						// Convert String to Integer
						int currentCount = Integer.parseInt(currentValue);
						
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
						// Verify count -1. 
						String previousButtonValue = baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(0).getText();
						// Convert String to Integer
						int previousButtonCount = Integer.parseInt(previousButtonValue);
						if(currentCount > previousButtonCount) {
							flag = true;
						}
						// Click and continue button and proceed.
						List<WebElement> buttonElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
						if(CollectionUtils.isNotEmpty(buttonElement)) {
							if(buttonElement.get(0).isDisplayed()) {
								WebElement continueButtonElement = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
								if(continueButtonElement != null) {
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
									DragAndDropAnswer(false);
									switchToAssessmentFrameHandler();
									// Clicking on continue button
									List<WebElement> buttonCtnElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
									if(CollectionUtils.isNotEmpty(buttonCtnElement)) {
										if(buttonElement.get(0).isDisplayed()) {
											WebElement ctnButtonElement = buttonCtnElement.get(0);
											if(ctnButtonElement != null) {
												ctnButtonElement.sendKeys(Keys.ENTER);
												waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
											}
										}
									}
								}
							}
						}
					
					} else {
					List<WebElement> buttonElement = baseHandler.findElements("footer[class='product-screen-footer'] #moveNext");
					if(CollectionUtils.isNotEmpty(buttonElement)) {
						if(buttonElement.get(0).isDisplayed()) {
							WebElement continueButtonElement = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
							if(continueButtonElement != null) {
								continueButtonElement.sendKeys(Keys.ENTER);
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								// Verifying Unanswered popup		
								List<WebElement> unAnsweredElement = baseHandler.findElements(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"));
								if(CollectionUtils.isNotEmpty(unAnsweredElement)) {
									clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
								}
								
								if(!continueButtonElement.isEnabled()) {
									clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
									clickAssessmemtType();
								}
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
						if(dragAndDropFlag && dragNDropBack) {
							// Take current count in test case no.
							String currentValue = baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(0).getText();
							// Convert String to Integer
							int currentCount = Integer.parseInt(currentValue);
							
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
							// Verify count -1. 
							String previousButtonValue = baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(0).getText();
							// Convert String to Integer
							int previousButtonCount = Integer.parseInt(previousButtonValue);
							if(currentCount > previousButtonCount) {
								flag = true;
							}
							// Click and continue button and proceed.
							List<WebElement> buttonElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
							if(CollectionUtils.isNotEmpty(buttonElement)) {
								if(buttonElement.get(0).isDisplayed()) {
									WebElement continueButtonElement = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
									if(continueButtonElement != null) {
										continueButtonElement.sendKeys(Keys.ENTER);
										waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
										DragAndDropAnswer(false);
										switchToAssessmentFrameHandler();
										// Clicking on continue button
										List<WebElement> buttonCtnElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
										if(CollectionUtils.isNotEmpty(buttonCtnElement)) {
											if(buttonElement.get(0).isDisplayed()) {
												WebElement ctnButtonElement = buttonCtnElement.get(0);
												if(ctnButtonElement != null) {
													ctnButtonElement.sendKeys(Keys.ENTER);
													waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
												}
											}
										}
									}
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
										// Verifying Unanswered popup		
										List<WebElement> unAnsweredElement = baseHandler.findElements(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"));
										if(CollectionUtils.isNotEmpty(unAnsweredElement)) {
											clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
										}
										
										if(!continueButtonElement.isEnabled()) {
											clickAssessmemtType();
										}
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
									// Verifying Unanswered popup								
									List<WebElement> unAnsweredElement = baseHandler.findElements(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"));
									if(CollectionUtils.isNotEmpty(unAnsweredElement)) {
										clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
									}
									if(!continueButtonElement.isEnabled()) {
										clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
										clickAssessmemtType();
									}
								/*	// Balance Drag and Drop from to container.
									if(dragAndDropFlag) {
										DragAndDropAnswerForwardContinue(false);
										flag = true; // Drag and Drop flag
										List<WebElement> buttonAfterDragnDropElement = baseHandler.findElements("footer[class='product-screen-footer'] #moveNext");
										if(CollectionUtils.isNotEmpty(buttonAfterDragnDropElement)) {
											if(buttonAfterDragnDropElement.get(0).isDisplayed()) {
												WebElement continueButtonDragNDropElement = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
												if(continueButtonDragNDropElement != null) {
													continueButtonDragNDropElement.sendKeys(Keys.ENTER);
												}
											}
										}
									}*/
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
		logger.info("Method : takeTestDragAndDropBackward :::::::: END flag --> " + flag);
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
	public void takeTestDragNDropPrevFuncationality(boolean bool, boolean breakFlag,
			boolean rationaleFlag, boolean flagquestion) throws Exception {
		boolean boolPartialVerify = false;
		boolean boolVerify = false;
		boolean flag = false;
		logger.info("Method : takeTest :::::::: Starts");
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
					boolPartialVerify = DragAndDropAnswerPartialMove(false);
					boolVerify = DragAndDropPrevFun(false);
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
					takeAssessment(rationaleFlag, flagquestion);
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
			if(boolPartialVerify && boolVerify) {
				logger.info("Drag and Drop verified for both partial and full movement of element from question to answer.");
				flag = true;
			}
		} catch (DriverException e) {
			logger.info("unable to take practice assessment" + e);
		}
		waitUntillBufferInvisible(PropertiesRepository
				.getString("asmt.pleasewait.bufferLoc"));
		logger.info("Method : takeTest :::::::: END");
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
		logger.info("Method : takeTest :::::::: Starts");
		
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
				
				boolean flagDragAndDrop = false;
				
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
					//DragAndDropAnswer(false);
					// Clicking on Flag Button. 
					clickButton(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"), 0);
					flagDragAndDrop = true;
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
					takeAssessment(true, flagquestion,"Review Flagged ");
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
					if(!flagDragAndDrop) {
						if (rationaleFlag) {
							waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
							List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
							if(CollectionUtils.isNotEmpty(rationalContinue)) {
								rationalContinue.get(0).sendKeys(Keys.ENTER);
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
							}
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
		logger.info("Method : takeTest :::::::: END");

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
	public void takeTestWithFirstAssessmentFlagging(boolean bool, boolean breakFlag,
			boolean rationaleFlag, boolean flagquestion) throws Exception {
		logger.info("Method : takeTest :::::::: Starts");
		
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
				
				boolean flagDragAndDrop = false;
				
				if(i == 0) {
					// Clicking on Flag Button. 
					clickButton(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"), 0);
					flagDragAndDrop = true;
				}
				
				if(!flagDragAndDrop) {
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
						List<WebElement> radioClickElement =baseHandler.findElements(".question-option.focus-element-flag.ng-scope label");
						if(CollectionUtils.isNotEmpty(radioClickElement)) {
							radioClickElement.get(0).click();
						}
					}

					if (CollectionUtils.isNotEmpty(baseHandler.findElements(PropertiesRepository.getString("asmt.question.img.loc")))) {
						hotSpotQuestion();
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
					takeAssessment(true, flagquestion,"Review Flagged ");
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
					if(!flagDragAndDrop) {
						if (rationaleFlag) {
							waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
							List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
							if(CollectionUtils.isNotEmpty(rationalContinue)) {
								rationalContinue.get(0).sendKeys(Keys.ENTER);
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
							}
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
		logger.info("Method : takeTest :::::::: END");

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
	public void takeTestWithUnFlag(boolean bool, boolean breakFlag,
			boolean rationaleFlag, boolean flagquestion) throws Exception {
		logger.info("Method : takeTestWithUnFlag :::::::: Starts");
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

				if (CollectionUtils.isNotEmpty(radioElement) && radioElement.size() > 0) {
					List<WebElement> radioClickElement =baseHandler.findElements(".question-option.focus-element-flag.ng-scope label");
					if(CollectionUtils.isNotEmpty(radioClickElement)) {
						radioClickElement.get(0).click();
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
									}
									/*if(!continueButtonElement.isEnabled()) {
										clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
										clickAssessmemtType();
										// Checking for Assessment Completed Popup if assessment are not clicked properly
										List<WebElement> assessmentCompleteElement = baseHandler.findElements(".modal-section div button");
										if(CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
											takeAssessment(false, flagquestion,"Finalize and View Results");
										}
									}*/
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
										// Checking for Assessment Completed Popup
										List<WebElement> assessmentCompleteElement = baseHandler.findElements(".modal-section div button");
										if(CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
											takeAssessment(false, flagquestion,"Finalize and View Results");
										}
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
		logger.info("Method : takeTestWithUnFlag :::::::: END");

	}
	/**
	 * This method is used to complete incomplete test and relaunch that test.
	 * 
	 * @author Abhishek Kumar
	 * @throws InterruptedException
	 */
	public void completeContinueStateAssessment(String assessmentType,String assessmentName) throws Exception {
		logger.info("Method : completeContinueStateAssessment :::::::: Starts");
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
			
			boolean flag1=false;
			if(count==0){
				flag1=true;
				waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
				//Click on Flag button if it is not clicked.
				try{
					clickButton(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"), 0);
					waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
				}catch(Exception e){
					
				}
				List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
				if(CollectionUtils.isNotEmpty(rationalContinue)) {
					
					rationalContinue.get(0).sendKeys(Keys.ENTER);
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");					
				}
				//close question unanswered pop-up if shown and click on flag and continue
				handelQuestionUnansweredPopup();
				
			}else if(count<=(maxCount/2)){
				flag1=true;
				for (int i = 0; i <= count; i++) {
				clickButton(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"), 0);
				waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
				
				List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
				if(CollectionUtils.isNotEmpty(rationalContinue)) {
					rationalContinue.get(0).sendKeys(Keys.ENTER);
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");					
					}
				}	
			}
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			if(flag1==true){
			// Checking for Assessment Completed Popup
			List<WebElement> assessmentCompleteElement = baseHandler.findElements(".modal-section div button");
			if(CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
				takeAssessment(false, false,"Finalize and View Results");
			}
			}
			//Click on continue if 'Review flag question pop-up is shown
			try{
				baseHandler.findElement(".button.secondary-button.focus-element-flag").click();
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			}catch(Exception e) {
				logger.info("Review flag question pop-up is not shown " + e);
			}
			
			if(flag1==true){
				waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
				waitUntillIPPPageIsLoaded(".sub-header>section>img");
				waitUntillIPPPageIsLoaded(".sub-header>section>img");
				baseHandler.findElement(".close-button.focus-element-flag").click();
				waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
				log(logger, "Clicking on Test Tab");
				new HomePage(driver).clickLinkFromList("asmt.myati.sub.tabs",1);

				log(logger,
						"Verifying Test Tab Practice and Proctor is displayed or not");
				new AssessmentPage(driver).verifyTestTabDetails();
				new AssessmentPage(driver).clickTestTabAssessmentButton(assessmentType,assessmentName);
			}
			
			logger.info("Method : completeContinueStateAssessment :::::::: Ends");
		}catch(DriverException e) {
			logger.info("unable to take practice assessment" + e);
			
		}
		
	}

	
	/**
	 * This method is used to complete incomplete test and relaunch that test.
	 * 
	 * @author Abhishek Kumar
	 * @throws InterruptedException
	 */
	public void completeContinueStateAssessmentFull(String assessmentType,String assessmentName) throws Exception {
		logger.info("Method : completeContinueStateAssessmentFull :::::::: Starts");
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
			
			boolean flag1=false;
			if(count==0){
				flag1=true;
				waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
				//Click on Flag button if it is not clicked.
				try{
					clickButton(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"), 0);
					waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
				}catch(Exception e){
					
				}
				List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
				if(CollectionUtils.isNotEmpty(rationalContinue)) {
					
					rationalContinue.get(0).sendKeys(Keys.ENTER);
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");					
				}
				//close question unanswered pop-up if shown and click on flag and continue
				handelQuestionUnansweredPopup();
				
			}else if(count<=(maxCount)){
				flag1=true;
				for (int i = 0; i <= count; i++) {
				clickButton(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"), 0);
				waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
				
				List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
				if(CollectionUtils.isNotEmpty(rationalContinue)) {
					rationalContinue.get(0).sendKeys(Keys.ENTER);
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");					
					}
				}	
			}
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			if(flag1==true){
			// Checking for Assessment Completed Popup
			List<WebElement> assessmentCompleteElement = baseHandler.findElements(".modal-section div button");
			if(CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
				takeAssessment(false, false,"Finalize and View Results");
			}
			}
			//Click on continue if 'Review flag question pop-up is shown
			try{
				baseHandler.findElement(".button.secondary-button.focus-element-flag").click();
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			}catch(Exception e) {
				logger.info("Review flag question pop-up is not shown " + e);
			}
			
			if(flag1==true){
				waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
				waitUntillIPPPageIsLoaded(".sub-header>section>img");
				waitUntillIPPPageIsLoaded(".sub-header>section>img");
				baseHandler.findElement(".close-button.focus-element-flag").click();
				waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
				log(logger, "Clicking on Test Tab");
				new HomePage(driver).clickLinkFromList("asmt.myati.sub.tabs",1);

				log(logger,
						"Verifying Test Tab Practice and Proctor is displayed or not");
				new AssessmentPage(driver).verifyTestTabDetails();
				new AssessmentPage(driver).clickTestTabAssessmentButton(assessmentType,assessmentName);
			}
			
			logger.info("Method : completeContinueStateAssessmentFull :::::::: Ends");
		}catch(DriverException e) {
			logger.info("unable to take practice assessment" + e);
			
		}
		
	}
	
	/*
	 * This method is used to close question unanswered pop-up if shown and
	 * click on flag and then continue.
	 * 
	 * @author Abhishek Kumar
	 */
	public void handelQuestionUnansweredPopup() {
		try {
			// Close question unanswered pop-up
			clickButton(
					PropertiesRepository
							.getString("asmt.myati.assessment.question.unanswered.close.loc"),
					0);
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

			// click on flag
			clickButton(
					PropertiesRepository
							.getString("asmt.generic.tutorial.flag.value"),
					0);
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

			// click on continue
			List<WebElement> rationalContinue = driver
					.findElements(By
							.cssSelector("footer[class='product-screen-footer'] #moveNext"));
			if (CollectionUtils.isNotEmpty(rationalContinue)) {

				rationalContinue.get(0).sendKeys(Keys.ENTER);
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			}
		} catch (Exception e) {
			logger.info("unable to handel question-unanswered popup" + e);
		}
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
	public boolean takeTestWithUnFlagVerifyPreviousBtnFunc(boolean bool, boolean breakFlag,
			boolean rationaleFlag, boolean flagquestion) throws Exception {
		logger.info("Method : takeTestWithUnFlagVerifyPreviousBtnFunc :::::::: Starts");
		boolean flag = false;
		boolean boolPreBtnFn = false;
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

				if (CollectionUtils.isNotEmpty(radioElement) && radioElement.size() > 0) {
					List<WebElement> radioClickElement =baseHandler.findElements(".question-option.focus-element-flag.ng-scope label");
					if(CollectionUtils.isNotEmpty(radioClickElement)) {
						radioClickElement.get(0).click();
					}
				}

				if (CollectionUtils.isNotEmpty(baseHandler
						.findElements(PropertiesRepository
								.getString("asmt.question.img.loc")))) {
					hotSpotQuestion();
				}

				if(!boolPreBtnFn) {
					waitUntillBufferInvisible(PropertiesRepository
							.getString("asmt.pleasewait.bufferLoc"));
					switchToAssessmentFrameHandler();

					List<WebElement> ele = baseHandler
							.findElements(PropertiesRepository
									.getString("asmt.generic.tutorial.previous.loc"));
					if (CollectionUtils.isEmpty(ele)) {
						flag = true;
						boolPreBtnFn = true;
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
									}
									if(!continueButtonElement.isEnabled()) {
										clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
										clickAssessmemtType();
										// Checking for Assessment Completed Popup if assessment are not clicked properly
										List<WebElement> assessmentCompleteElement = baseHandler.findElements(".modal-section div button");
										if(CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
											takeAssessment(false, flagquestion,"Finalize and View Results");
										}
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
										// Checking for Assessment Completed Popup
										List<WebElement> assessmentCompleteElement = baseHandler.findElements(".modal-section div button");
										if(CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
											takeAssessment(false, flagquestion,"Finalize and View Results");
										}
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
		logger.info("Method : takeTestWithUnFlagVerifyPreviousBtnFunc :::::::: END flag--> " + flag);
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
	public boolean takeTestWithVerifyPreviousBtnFunc(boolean bool, boolean breakFlag,
			boolean rationaleFlag, boolean flagquestion) throws Exception {
		logger.info("Method : takeTestWithVerifyPreviousBtnFunc :::::::: Starts");
		boolean flag = false;
		boolean boolPreBtnFn = false;
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

				if (CollectionUtils.isNotEmpty(radioElement) && radioElement.size() > 0) {
					List<WebElement> radioClickElement =baseHandler.findElements(".question-option.focus-element-flag.ng-scope label");
					if(CollectionUtils.isNotEmpty(radioClickElement)) {
						radioClickElement.get(0).click();
					}
				}

				if (CollectionUtils.isNotEmpty(baseHandler
						.findElements(PropertiesRepository
								.getString("asmt.question.img.loc")))) {
					hotSpotQuestion();
				}

				if(!boolPreBtnFn) {
					waitUntillBufferInvisible(PropertiesRepository
							.getString("asmt.pleasewait.bufferLoc"));
					switchToAssessmentFrameHandler();

					List<WebElement> ele = baseHandler
							.findElements(PropertiesRepository
									.getString("asmt.generic.tutorial.previous.loc"));
					if (CollectionUtils.isEmpty(ele)) {
						flag = true;
						boolPreBtnFn = true;
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
									}
									if(!continueButtonElement.isEnabled()) {
										clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
										clickAssessmemtType();
										// Checking for Assessment Completed Popup if assessment are not clicked properly
										List<WebElement> assessmentCompleteElement = baseHandler.findElements(".modal-section div button");
										if(CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
											takeAssessment(false, flagquestion,"Finalize and View Results");
										}
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
										// Checking for Assessment Completed Popup
										List<WebElement> assessmentCompleteElement = baseHandler.findElements(".modal-section div button");
										if(CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
											takeAssessment(false, flagquestion,"Finalize and View Results");
										}
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
		logger.info("Method : takeTestWithVerifyPreviousBtnFunc :::::::: END flag--> " + flag);
		return flag;
	}
}

	
