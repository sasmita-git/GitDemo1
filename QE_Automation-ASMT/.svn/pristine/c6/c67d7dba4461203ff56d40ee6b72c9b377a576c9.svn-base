package com.automation.asmt.page;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;

public class TakeAssessmentPage6 extends TakeAssessmentPage7 {

	private Logger logger = LogManager.getLogger(this.getClass());
	
	public TakeAssessmentPage6(WebDriver webDriver) {
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
	public boolean takeTestForDragNDropReverseFunctinoality(boolean bool, boolean breakFlag,
			boolean rationaleFlag, boolean flagquestion) throws Exception {
		logger.info("Method : takeTestForDragNDropReverseFunctinoality :::::::: Starts");
		boolean box1toboxMove = false;
		boolean box2tobox1Move = false;
		boolean box1toboxMove2 = false;
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
					waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
					box1toboxMove = verifyElementIsDisplayedWithAssessmentSwitch(PropertiesRepository.getString("asmt.myati.assessment.continue.button.enabled.loc"));
					waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
					DragAndDropAnswerReverse(false); 
					waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
					box2tobox1Move = verifyElementIsDisplayedWithAssessmentSwitch(PropertiesRepository.getString("asmt.myati.assessment.continue.button.disabled.loc"));
					waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
					DragAndDropAnswer(false);
					waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
					box1toboxMove2 = verifyElementIsDisplayedWithAssessmentSwitch(PropertiesRepository.getString("asmt.myati.assessment.continue.button.enabled.loc"));
					waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
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
				}
			}
		} catch (DriverException e) {
			logger.info("unable to take practice assessment in takeTestForDragNDropReverseFunctinoality" + e);
		}
		waitUntillBufferInvisible(PropertiesRepository
				.getString("asmt.pleasewait.bufferLoc"));
		if(box1toboxMove && box1toboxMove2 && box2tobox1Move) {
			flag = true;
			logger.info("Drag N Drop continue button enabled/ disabled correctly");
		}
		logger.info("Method : takeTestForDragNDropReverseFunctinoality :::::::: END");
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
	public boolean takeTestContinueFuncationalityforNonRationaleAssessment(boolean bool, boolean breakFlag,
			boolean rationaleFlag, boolean flagquestion) throws Exception {
		logger.info("Method : takeTestContinueFuncationalityforNonRationaleAssessment :::::::: Starts");
		boolean lastSection = false;
		boolean selectedCount = false;
		boolean flag = false;
		boolean continueFnFlag = false;
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
					if(i != 0 || !continueFnFlag) { // If it is not the first question.
						switchToAssessmentFrameHandler();
						
						// Verify first option is selected.
						List<WebElement> selectedCheckBox = baseHandler.findElements("input[class='ng-valid ng-not-empty ng-dirty ng-valid-parse ng-touched']");
						if(CollectionUtils.isNotEmpty(selectedCheckBox) && selectedCheckBox.size() == 1) {
							selectedCount = true;
						}
						
						// Click Previous
						List<WebElement> buttonBackWardElement = baseHandler.findElements(".move-to-prev-content.focus-element-flag.ng-hide");
						if(CollectionUtils.isNotEmpty(buttonBackWardElement) && buttonBackWardElement.size() == 1) {
							buttonBackWardElement.get(0).click();
						}
						
						waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
						// Clicking on Previous question continue button. 
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
						waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
						
						// Click second check box. 
						checkBoxElement.get(1).click();
						logger.info("Continue Funcationality is verified in Check box question type");
						continueFnFlag = true;
					}
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
						
						if(i != 0 && !continueFnFlag) { // If it is not the first question.
							switchToAssessmentFrameHandler();
							
							// Verify first option is selected.
							List<WebElement> radionGroup = baseHandler.findElements(".question-option.focus-element-flag.ng-scope");
							for(WebElement radioIndividual : radionGroup) {
								WebElement radioIndElement =radioIndividual.findElement(By.cssSelector("input[class='ng-valid ng-not-empty ng-dirty ng-valid-parse ng-touched']"));
								if(radioIndElement != null) {
									selectedCount = true;
									break;
								}
							}
							
							/*List<WebElement> selectedCheckBox = baseHandler.findElements("input[class='ng-valid ng-not-empty ng-dirty ng-valid-parse ng-touched']");
							if(CollectionUtils.isNotEmpty(selectedCheckBox) && selectedCheckBox.size() == 1) {
								selectedCount = true;
							}*/
							
							// Click Previous
							List<WebElement> buttonBackWardElement = baseHandler.findElements("#movePrevious");
							if(CollectionUtils.isNotEmpty(buttonBackWardElement) && buttonBackWardElement.size() == 1) {
								buttonBackWardElement.get(0).click();
							}
							waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
							// Clicking on Previous question continue button. 
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
							waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
							// Click second check box. 
							radioClickElement.get(1).click();
							logger.info("Continue Funcationality is verified in Radio button question type");
							continueFnFlag = true;
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
					lastSection = takeAssessmentVerifySection(rationaleFlag, flagquestion,"Finalize and View Results");
					logger.info("Timer Flag  value for all questions  " + selectedCount );
					logger.info("Completion section Flag   " + lastSection );
					if(selectedCount && lastSection) {
						logger.info("Both timer flag and assessment completion section worked as expected");
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
				}
			}
		} catch (DriverException e) {
			logger.info("unable to take practice assessment in takeTestContinueFuncationalityforNonRationaleAssessment" + e);
		}
		waitUntillBufferInvisible(PropertiesRepository
				.getString("asmt.pleasewait.bufferLoc"));
		logger.info("Method : takeTestContinueFuncationalityforNonRationaleAssessment :::::::: END flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to verify user is able to click outside the popup and verify it is not getting closed. 
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean verifyUnAnswerePopupClickOutside() throws Exception {
		logger.info("Method : verifyUnAnswerePopupClickOutside Start");
		boolean flag = false;
		try {
			switchToAssessmentFrameHandler();
			// Clicking on Continue button without selecting any answer.
			List<WebElement> buttonElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
			if(CollectionUtils.isNotEmpty(buttonElement)) {
				if(buttonElement.get(0).isDisplayed()) {
					WebElement continueButtonElement = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
					if(continueButtonElement != null) {
						continueButtonElement.sendKeys(Keys.ENTER);
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						/*if(!continueButtonElement.isEnabled()) {
							clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
							clickAssessmemtType();
						}*/
					}
				}
			}
			
			// Clicking outside. 
			List<WebElement> elementOutSide = baseHandler
					.findElements(PropertiesRepository.getString("asmt.myati.assessment.unaswered.clicking.outside.loc"));
			if(CollectionUtils.isNotEmpty(elementOutSide)) {
				elementOutSide.get(0).click();
			}
			
			// Verify Un Answered popup is not closed & Clicking on Close icon in Un Answered Popup. 
			List<WebElement> element = baseHandler
					.findElements(".modal-section p");
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element.get(0));
			if (CollectionUtils.isNotEmpty(element) && element.get(0).getText().trim().equalsIgnoreCase(
					PropertiesRepository.getString("asmt.assessment.unanswered.popup.content.text.value"))) {
				// Clicking on Close button.
				List<WebElement> closeElement = baseHandler.findElements(PropertiesRepository
						.getString("asmt.myati.assessment.question.unanswered.close.without.span.loc"));
				if (CollectionUtils.isNotEmpty(closeElement)) {
					closeElement.get(0).click();
					flag = true;
				}
			}
			switchToAssessmentFrameHandler();
		}catch (Exception e) {
			switchToAssessmentFrameHandler();
    		logger.info("Unable to verifyUnAnswerePopupClickOutside " );
			log(logger, "Unable to verifyUnAnswerePopupClickOutside " );
    		throw new DriverException("Unable to verifyUnAnswerePopupClickOutside " , e); 
    	}
		logger.info("Method: verifyUnAnswerePopupClickOutside End flag --> " + flag);
		return flag;
	}
	/**
	 * Method used to verify content in un answered popup. 
	 * 
	 * @return
	 * @throws Exception
	 */
	private boolean verifyUnAnsweredPopup() throws Exception {
		logger.info("Method : verifyUnAnsweredPopup Start");
		boolean flag = false;
		try {
			switchToAssessmentFrameHandler();
			// Clicking on Continue button without selecting any answer.
			List<WebElement> buttonElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
			if(CollectionUtils.isNotEmpty(buttonElement)) {
				if(buttonElement.get(0).isDisplayed()) {
					WebElement continueButtonElement = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
					if(continueButtonElement != null) {
						continueButtonElement.sendKeys(Keys.ENTER);
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						/*if(!continueButtonElement.isEnabled()) {
							clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
							clickAssessmemtType();
						}*/
					}
				}
			}
			List<WebElement> element = baseHandler
					.findElements(".modal-section p");
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element.get(0));
			if (CollectionUtils.isNotEmpty(element) && element.get(0).getText().trim().equalsIgnoreCase(
					PropertiesRepository.getString("asmt.assessment.unanswered.popup.content.text.value"))) {
				// Clicking on Close button.
				List<WebElement> closeElement = baseHandler.findElements(PropertiesRepository
						.getString("asmt.myati.assessment.question.unanswered.close.without.span.loc"));
				if (CollectionUtils.isNotEmpty(closeElement)) {
					closeElement.get(0).click();
					flag = true;
				}
			}
			switchToAssessmentFrameHandler();
		}catch (Exception e) {
			switchToAssessmentFrameHandler();
    		logger.info("Unable to verifyUnAnsweredPopup " );
			log(logger, "Unable to verifyUnAnsweredPopup " );
    		throw new DriverException("Unable to verifyUnAnsweredPopup " , e); 
    	}
		logger.info("Method: verifyUnAnsweredPopup End flag --> " + flag);
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
	public boolean takeTestToVerifyUnAnsweredPopup(boolean bool, boolean breakFlag,
			boolean rationaleFlag, boolean flagquestion) throws Exception {
		logger.info("Method : takeTestToVerifyUnAnsweredPopup :::::::: Starts");
		boolean flag = false;
		boolean lastSection = false;
		boolean unAnsweredPopupFlag = false;
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
				// Verifying Un Answered popup.
				if(!unAnsweredPopupFlag) {
					if(verifyUnAnsweredPopup()) {
						unAnsweredPopupFlag = true;
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
					logger.info("UnAnswered Flag questions  " + unAnsweredPopupFlag );
					logger.info("Completion section Flag   " + lastSection );
					if(unAnsweredPopupFlag && lastSection) {
						logger.info("Both UnAnswered Flag questions and assessment completion section worked as expected");
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
			logger.info("unable to take practice assessment in takeTestToVerifyUnAnsweredPopup" + e);
		}
		waitUntillBufferInvisible(PropertiesRepository
				.getString("asmt.pleasewait.bufferLoc"));
		logger.info("Method : takeTestToVerifyUnAnsweredPopup :::::::: END flag --> " + flag);
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
	public boolean takeTestVerifyUnAnsweredPopupNotClosed(boolean bool, boolean breakFlag,
			boolean rationaleFlag, boolean flagquestion) throws Exception {
		logger.info("Method : takeTestVerifyUnAnsweredPopupNotClosed :::::::: Starts");
		boolean flag = false;
		boolean lastSection = false;
		boolean unAnsweredPopupFlag = false;
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
				// Verifying Un Answered popup.
				if(!unAnsweredPopupFlag) {
					if(verifyUnAnswerePopupClickOutside()) {
						unAnsweredPopupFlag = true;
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
					logger.info("UnAnswered Popup Not Closed  " + unAnsweredPopupFlag );
					logger.info("Completion section Flag   " + lastSection );
					if(unAnsweredPopupFlag && lastSection) {
						logger.info("Both UnAnswered Popup Not Closed and assessment completion section worked as expected");
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
			logger.info("unable to take practice assessment in takeTestVerifyUnAnsweredPopupNotClosed" + e);
		}
		waitUntillBufferInvisible(PropertiesRepository
				.getString("asmt.pleasewait.bufferLoc"));
		logger.info("Method : takeTestVerifyUnAnsweredPopupNotClosed :::::::: END flag --> " + flag);
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
	public boolean takeTestFlaggedQuestionWithFinalizeAndViewResults(boolean bool, boolean breakFlag,
			boolean rationaleFlag, boolean flagquestion) throws Exception {
		logger.info("Method : takeTestFlaggedQuestionWithFinalizeAndViewResults :::::::: Starts");
		boolean flag = false;
		boolean flaggedItemPopup = false;
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
				boolean flagTEAS = false;
				
				List<WebElement> checkBoxElement = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.checkbox.new.multiple.answer.loc"));
				List<WebElement> radioElement = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.radio.button.new.multiple.answer.loc"));

				if (checkBoxElement != null) {
					// Clicking on Flag Button. 
					clickButton(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"), 0);
					flagTEAS = true;
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
					// Verifying Flagged Item message popup. 
					// Verify Un Answered popup is not closed & Clicking on Close icon in Un Answered Popup. 
					List<WebElement> element = baseHandler
							.findElements(".modal-section p");
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element.get(0));
					if (CollectionUtils.isNotEmpty(element) && element.get(0).getText().trim().contains(
							PropertiesRepository.getString("asmt.myati.assessment.flagged.items.popup.message.value"))) {
						// Clicking on Close button.
						List<WebElement> closeElement = baseHandler.findElements(PropertiesRepository
								.getString("asmt.myati.assessment.flagged.items.popup.continue.button.loc"));
						if (CollectionUtils.isNotEmpty(closeElement)) {
							closeElement.get(0).click();
							flaggedItemPopup = true;
						}
					}
					logger.info("Completion last section Flag   " + lastSection );
					logger.info("Flagged Question With Finalize And View Results   " + flaggedItemPopup );
					if(flaggedItemPopup && lastSection) {
						logger.info("Flagged Question With Finalize And View Results and last sections are working fine");
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
						waitUntillElementIsVisible(PropertiesRepository.getString("asmt.generic.tutorial.submit.new.loc"));
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
					if (rationaleFlag && !flagTEAS) {
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
						waitUntillElementIsVisible(PropertiesRepository.getString("asmt.generic.tutorial.continue.loc"));
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
			logger.info("unable to take practice assessment in takeTestFlaggedQuestionWithFinalizeAndViewResults" + e);
		}
		waitUntillBufferInvisible(PropertiesRepository
				.getString("asmt.pleasewait.bufferLoc"));
		logger.info("Method : takeTestFlaggedQuestionWithFinalizeAndViewResults :::::::: END flag --> " + flag);
		return flag;
	}
	
}

	
