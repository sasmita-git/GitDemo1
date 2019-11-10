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
import org.openqa.selenium.interactions.Actions;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;

public class PractiseAssessmentPage2 extends PractiseAssessmentPage3 {

	private Logger logger = LogManager.getLogger(this.getClass());
	private BaseHandler baseHandler;
	private WindowHandler windowHandler;
	private boolean flag = false;
	int flaggedQuestionCount=0;
	public PractiseAssessmentPage2(WebDriver webDriver) {
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
	public boolean takeTest522(boolean bool, boolean breakFlag,
			boolean rationaleFlag, boolean flagquestion) throws Exception {
		logger.info("Method : takeTest522 :::::::: Starts");
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

				List<WebElement> checkBoxElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.generic.tutorial.checkbox.new.multiple.answer.loc"));
				List<WebElement> radioElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.generic.tutorial.radio.button.new.multiple.answer.loc"));

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
					boolean resultFlag = takeAssessmentVerifySectionNew(rationaleFlag, flagquestion,"Finalize and View Results");
					logger.info("Verification of final popup -->" + resultFlag);
					if(resultFlag) {
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
			logger.info("unable to take practice assessment in takeTest522" + e);
		}
		waitUntillBufferInvisible(PropertiesRepository
				.getString("asmt.pleasewait.bufferLoc"));
		logger.info("Method : takeTest522 :::::::: END flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to take a practice test, when a check box question is found this method answers it and moves two questions forward as the next question should also 
	 * be answered now it goes back to the check box question changes the answer and verifies it after moving forward one question. If verified it answers the remaining questions 
	 * 
	 * @author Vishal
	 * @return boolean
	 * @param bool
	 * @param breakFlag
	 * @param rationaleFlag
	 * @param flagquestion
	 * @throws Exception
	 */
	public boolean takePracticeTestAndChangeAnswers(boolean bool, boolean breakFlag,
			boolean rationaleFlag, boolean flagquestion) throws Exception {
		logger.info("Method : takePracticeTestAndChangeAnswers :::::::: Starts");
		boolean flag=false;
		int FirstQNo = 0;
		boolean checkBoxFlag=false;		//will be set once check box question is answered
		boolean NextQAnswered = false;	//will be set once check box or radio btn question is answered and the next question of these two is also answered
		boolean OneTimeFlag=true;
		boolean rationale1=false;
		boolean rationale2=false;
		boolean btnsFlag1=false;
		boolean btnsFlag2 =false;
		boolean arrowFlag=false;
		boolean asmtFlag=false;
		boolean prevAnsFlag=false;
		boolean nextQuestionFlag=false;
		String[] answers = new String[2];
		int step=0;
		try {

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
			//to select the answers for all the questions 
			for (int i = 0; i <= count; i++) {

				List<WebElement> checkBoxElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.generic.tutorial.checkbox.new.multiple.answer.loc"));
				List<WebElement> radioElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.generic.tutorial.radio.button.new.multiple.answer.loc"));

				if (checkBoxElement != null) {
					checkBoxElement.get(0).click();
					checkBoxElement.get(1).click();
					checkBoxFlag=true;
					step=i;
				}

				if (driver.findElements(By.cssSelector(".answer-fill-in-the-blank.numericTextEntry.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty")).size() > 0) {
					verifyFillForm("10");
				}

				if (CollectionUtils.isNotEmpty(baseHandler.findElements(PropertiesRepository.getString("new-atitesting.generic.tutorial.dragbox1.loc")))) {
					DragAndDropAnswerNew(false);
				}

				if (CollectionUtils.isNotEmpty(radioElement) && radioElement.size() > 0) {
					List<WebElement> radioClickElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.radio.button.loc"));
					if(CollectionUtils.isNotEmpty(radioClickElement)) {
						radioClickElement.get(0).click();
					}
				}
	
				if (CollectionUtils.isNotEmpty(baseHandler.findElements(PropertiesRepository.getString("new-atitesting.question.img.loc")))) {
					hotSpotQuestionNew("new-atitesting.question.new.img.answer.loc");
				}
				//to press continue after the last question 
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
									//clickButton(PropertiesRepository.getString("new-atitesting.myati.assessment.question.unanswered.close.loc"), 0);
									clickAssessmemtType();
								}
							}
						}
					}
					asmtFlag=takeAssessmentVerifySectionNew(rationaleFlag, flagquestion,"Finalize and View Results");
					logger.info("Previous and Continue button Prescence Verification --> " + btnsFlag1);
					logger.info("Previous and Continue button Prescence Verification --> " + btnsFlag2);
					logger.info("Rationale absence Verification --> " + rationale1);
					logger.info("Rationale absence Verification --> " + rationale2);
					logger.info("Left Arrow key Verification --> " + arrowFlag);
					logger.info("Assement Verification --> " + asmtFlag);
					logger.info("Changing Previously answered question Verification --> " + prevAnsFlag);
					logger.info("Next question is displayed after cureent question is answered --> " + nextQuestionFlag);
					
					if(asmtFlag && btnsFlag1 && btnsFlag2 && rationale1 && rationale2 && arrowFlag && prevAnsFlag && nextQuestionFlag) {
						flag = true;
						logger.info("All the functionality have been verified ");
						log(logger,"All the functionality have been verified");
					}
					
				} else {			//to flag the question
					if (i == 0 && flagquestion) {
						switchToAssessmentFrameHandler();
						verifyFlag(true);
						logger.info("Question has been flaged");
						Thread.sleep(8000);
					} else {		
						//Note the current Question number.
						switchToAssessmentFrameHandler();
						List<WebElement> currentQuestionNo = baseHandler.findElements(
								PropertiesRepository.getString("new-atitesting.myati.test.tab.current.question.no.loc"));
						if(CollectionUtils.isNotEmpty(currentQuestionNo)){ 
							String currentQ=currentQuestionNo.get(0).getText();
							FirstQNo =Integer.parseInt(currentQ); 
						}
						
						//to click continue after the answer is selected all questions except the last one 
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
										clickButton(PropertiesRepository.getString("new-atitesting.myati.assessment.question.unanswered.close.loc"), 0);
										clickAssessmemtType();
									}
								}
							}
						}
					}
					
					// to check if the rationale is present or not
					rationale1 = verifyRationaleForNoRationaleTest();
					//check the presence of Continue and Previous button
					logger.info("Verifying Continue button and Previous button presence.");
					if(isElementDisplayed("new-atitesting.test.assessment.continue.button.loc")&&
							isElementDisplayed("new-atitesting.test.assessment.previous.button.loc")) {
						btnsFlag1=true;
					}
					
					//to check if next question is displayed 
					nextQuestionFlag=VerifyNextQuestionNoAfterSubmission(FirstQNo, i);
					if(checkBoxFlag  && i==0) {
						checkBoxFlag = false;
					}

					if(checkBoxFlag  && i!=0) {
						if(NextQAnswered && OneTimeFlag) {
							/*move to previous question is called twice because as we answer the question after either checkbox or textbox it will move to the next question
							 * so to answer the check box or text box it is called twice. 
							*/
							toPressPrevious();
							toPressPrevious();
							//check the presence of Continue and Previous button
							logger.info("Verifying Continue button and Previous button presence.");
							if(isElementDisplayed("new-atitesting.test.assessment.continue.button.loc") &&
									isElementDisplayed("new-atitesting.test.assessment.previous.button.loc")) {
								btnsFlag2=true;
							}
							
							rationale2 = verifyRationaleForNoRationaleTest();
							String[] answerValue = answerPreviousQuestionNew(answers);
							
							toPressContinue();
							arrowFlag=MoveToPreviousQuestion(step);
							prevAnsFlag=verifyPreviousAnswer(answerValue);
							
							//to press continue twice for the same reason as previous twice.
							toPressContinue();
							toPressContinue();
							
							checkBoxFlag=false;
							OneTimeFlag=false;
						}
						NextQAnswered=true; 
					}
					switchToAssessmentFrameHandler();

					/*if (breakFlag) {
						break;
					}*/
				}
			}
		} catch (DriverException e) {
			logger.info("unable to take practice assessment" + e);
		}
		waitUntillBufferInvisible(PropertiesRepository
				.getString("new-atitesting.pleasewait.bufferLoc"));
		logger.info("Method : takePracticeTestAndChangeAnswers :::::::: ENDS --> "+flag);
		return flag;
	}
	
	/**
	 * Method used to verify if the next question is loaded after clicking the CONTINUE btn in a non-rationale asmt
	 * 
	 * @author Vishal
	 * @return boolean
	 * @param FirstQNo
	 * @param i
	 * @throws Exception
	 */
	public boolean VerifyNextQuestionNoAfterSubmission(int FirstQNo, int i) throws Exception {
		logger.info("VerifyNextQuestionNoAfterSubmission");
		boolean flag=false;
		try { 
				switchToAssessmentFrameHandler();
				List<WebElement> currentQuestionNo = baseHandler.findElements(
						PropertiesRepository.getString("new-atitesting.myati.test.tab.current.question.no.loc"));
				if(CollectionUtils.isNotEmpty(currentQuestionNo)){ 
					String currentQ=currentQuestionNo.get(0).getText();
					int currentQNo =Integer.parseInt(currentQ); 
					if(currentQNo == (FirstQNo+1)) {
						logger.info("-------------Next Question is displayed after submission-------------");
						log(logger,"-------------Next Question is displayed after submission-------------");
						flag = true;
					}
				}
			}
		catch (Exception e) {
			logger.info("unable to verify next question displayed" + e);
		}
		logger.info("VerifyNextQuestionNoAfterSubmission");
		return flag;
	}
	
	/**
	 * Method used to press continue btn in the asmt page 
	 * 
	 * @author Vishal
	 * @return boolean
	 * @throws Exception
	 */
	public boolean toPressContinue() {
		logger.info("toPressContinue Starts");
		boolean flag = false;
		try {
			switchToAssessmentFrameHandler();
			waitUntillElementIsVisible(PropertiesRepository
					.getString("new-atitesting.generic.tutorial.submit.new.loc"));
			List<WebElement> buttonElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
			if(CollectionUtils.isNotEmpty(buttonElement)) {
				if(buttonElement.get(0).isDisplayed()) {
					WebElement continueButtonElement = driver.findElement(By.cssSelector("#moveNext"));
					if(continueButtonElement != null) {
						continueButtonElement.sendKeys(Keys.ENTER);
						flag=true;
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						if(verifyQuestionUnAsweredPopup()) {
							List<WebElement> assessmentCompleteElement = baseHandler.findElements(".modal-section button");
							if(CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
								assessmentCompleteElement.get(0).click();
							}
							clickButton(PropertiesRepository.getString("new-atitesting.myati.assessment.question.unanswered.close.loc"), 0);
							clickAssessmemtType();
						}
					}
				}
			}
		}
		catch (Exception e) {
			logger.info("unable to press Continue button"+ e);
		}
		logger.info("toPressContinue Ends -> "+flag);
		return flag;
	}
	
	/**
	 * Method used to click previous btn in the asmt page
	 * 
	 * @author Vishal
	 * @return boolean
	 * @throws Exception
	 */
	
	public boolean toPressPrevious() {
		logger.info("toPressPrevious Starts");
		boolean flag = false;
		try {
			switchToAssessmentFrameHandler();
			waitUntillElementIsVisible(PropertiesRepository
					.getString("new-atitesting.generic.tutorial.submit.new.loc"));
			List<WebElement> buttonElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
			if(CollectionUtils.isNotEmpty(buttonElement)) {
				if(buttonElement.get(0).isDisplayed()) {
					WebElement continueButtonElement = driver.findElement(By.cssSelector("#movePrevious"));
					if(continueButtonElement != null) {
						continueButtonElement.sendKeys(Keys.ENTER);
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						flag=true;
					}
				}
			}
		}
		catch (Exception e) {
			logger.info("unable to press Previous button"+ e);
		}
		logger.info("toPressPrevious Ends -> "+flag);
		return flag;
	}
	
	/**
	 * Method used to verify if rationale is displayed when a question is answered in a non-rationale asmt
	 * 
	 * @author Vishal
	 * @return boolean
	 * @throws Exception
	 */
	
	public boolean verifyRationaleForNoRationaleTest() {
		logger.info("verifyRationaleForNoRationaleTest Starts");
		boolean flag=false;
		try {
			List<WebElement> text=baseHandler.findElements("new-atitesting.myati.test.tab.incorrect.rationale.loc");
			if (CollectionUtils.isEmpty(text)) {
				logger.info("-------------Rationale is not present-------------");
				log(logger, "-------------Rationale Verified-------------");
				flag=true;
			}
		}
		catch (Exception e) {
			logger.info("unable to verify rationale" + e);
		}
		logger.info("verifyRationaleForNoRationaleTest Ends ->"+flag);
		return flag;
	}
	
	/**
	 * Method used to move to a previous question using arrow keys
	 * 
	 * @author Vishal
	 * @return boolean
	 * @param previousQNo
	 * @throws Exception
	 */
	
	public boolean MoveToPreviousQuestion(int previousQNo) {
		logger.info("MoveToPreviousQuestion Starts");
		flag = false;
		try {
			List<WebElement> buttonBackWardElement1 = baseHandler.findElements(".product-footer-nav #movePrevious");
			if (CollectionUtils.isNotEmpty(buttonBackWardElement1)) {
				if (buttonBackWardElement1.get(0).isDisplayed()) {
					WebElement continueButtonElement1 = buttonBackWardElement1.get(0);
					if (continueButtonElement1 != null) {
						Actions action = new Actions(driver);
						action.moveToElement(continueButtonElement1);
						continueButtonElement1.sendKeys(Keys.LEFT);
					}
				}
			}
			flag = verifyPreviousBtn(previousQNo);
		}
		catch (Exception e) {
			logger.info("unable to move to previous question" + e);
		}
		logger.info("MoveToPreviousQuestion Ends -> " +flag);
		return flag;
	}
	
	/**
	 * Method used to verify if the previous question is loaded after pressing previous btn
	 * 
	 * @author Vishal
	 * @return boolean
	 * @param previousQNo
	 * @throws Exception
	 */
	
	public boolean verifyPreviousBtn(int previousQNo) {
		logger.info("verifyPreviousBtn Starts");
		boolean previousBtnFlag = false;
		try{
			switchToAssessmentFrameHandler();
		
			List<WebElement> currentQuestionNo = baseHandler.findElements(
					PropertiesRepository.getString("new-atitesting.myati.test.tab.current.question.no.loc"));
			
			if(CollectionUtils.isNotEmpty(currentQuestionNo)) 
			{ 
				String currentQ=currentQuestionNo.get(0).getText();
				int currentQNo =Integer.parseInt(currentQ); 
				if((currentQNo-1)==previousQNo) {
					previousBtnFlag=true; 
					logger.info("-------------Previous button functionality Verified-------------");
					log(logger,"-------------Previous button functionality Verified-------------"); 
				}
			}
		}
		catch (Exception e) {
			logger.info("unable to verify previous btn functionality" + e);
		}		
		logger.info("verifyPreviousBtn Ends ->"+previousBtnFlag);
		return previousBtnFlag;
	}
	
	/**
	 * Method used to change the answer of a check box (check box question should not be the first question) 
	 * 
	 * @author Vishal
	 * @return boolean
	 * @param answers [] 
	 * @throws Exception
	 */
	
	public String[] answerPreviousQuestionNew(String[] answers) {
		logger.info("answerPreviousQuestion Starts"); 
		boolean flag=false;
		try {
			switchToAssessmentFrameHandler();
			List<WebElement> checkBoxElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.generic.tutorial.checkbox.new.multiple.answer.loc"));
			if (checkBoxElement != null) {
				checkBoxElement.get(0).click();
				checkBoxElement.get(3).click();
				flag=true;
				answers[0]="1";
				answers[1]="3";
			}
		}
		catch (Exception e) {
			logger.info("unable to answer previous question" + e);
		}
		logger.info("answerPreviousQuestion Ends ->"+flag);
		return answers;
	}
	
	/**
	 * Method used to verify if the previous question's answer has benn changed 
	 * 
	 * @author Vishal
	 * @return boolean
	 * @param answers []
	 * @throws Exception
	 */
	
	public boolean verifyPreviousAnswer(String[] answers) {
		logger.info("verifyPreviousAnswer Starts"); 
		boolean flag=false;
		try {
			switchToAssessmentFrameHandler();
			List<WebElement> checkBoxElementList = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.generic.tutorial.checkbox.new.multiple.answer.div.tag.loc"));
			if (CollectionUtils.isNotEmpty(checkBoxElementList)) {
				for(int i=0;i<checkBoxElementList.size();i++) {
					WebElement element =checkBoxElementList.get(i).findElement(By.tagName("input"));
					//logger.info("checklistsize: "+checkBoxElementList.size());
					//logger.info("answer[0]: "+answers[0]);
					String className = element.getAttribute("class");
					//logger.info("className: "+className);
					if(className.contains(PropertiesRepository.getString("new-atitesting.generic.tutorial.checkbox.input.tag.class.name.value"))) {
						if(answers[0].contains(PropertiesRepository.getString("new-atitesting.generic.tutorial.checkbox.1st.answered.option.value"))
								|| answers[1].equalsIgnoreCase(PropertiesRepository.getString("new-atitesting.generic.tutorial.checkbox.2nd.answered.option.value"))) {
							flag=true;		
						}
					}
				}
			}
		}
		catch (Exception e) {
			logger.info("unable to verify previous question answer " + e);
		}
		logger.info("verifyPreviousAnswer Ends ->"+flag);
		return flag;
	}
	
	/**
	 * Method used to take a test and verify if two buttons are displayed in the modal after the last question is answered 
	 * 
	 * @author Vishal
	 * @return boolean
	 * @param bool
	 * @param breakFlag
	 * @param rationaleFlag
	 * @param flagquestion
	 * @throws Exception
	 */
	
	public boolean takeTestAndVerifyModalForTwoBtns(boolean bool, boolean breakFlag,
			boolean rationaleFlag, boolean flagquestion) throws Exception {
		logger.info("Method : takeTestAndVerifyModalForTwoBtns :::::::: Starts");
		boolean flag=false;
		boolean twoBtnFlag=false;
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
			//to select the answers for all the questions

			for (int i = 0; i <= count; i++) {

				List<WebElement> checkBoxElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.generic.tutorial.checkbox.new.multiple.answer.loc"));
				List<WebElement> radioElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.generic.tutorial.radio.button.new.multiple.answer.loc"));

				if (checkBoxElement != null) {
					checkBoxElement.get(0).click();
					checkBoxElement.get(1).click();
				}

				if (driver.findElements(By.cssSelector(".answer-fill-in-the-blank.numericTextEntry.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty")).size() > 0) {
					verifyFillForm("10");

				}

				if (CollectionUtils.isNotEmpty(baseHandler.findElements(PropertiesRepository.getString("new-atitesting.generic.tutorial.dragbox1.loc")))) {
					DragAndDropAnswerNew(false);
				}

				if (CollectionUtils.isNotEmpty(radioElement) && radioElement.size() > 0) {
					List<WebElement> radioClickElement =baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.radio.button.loc"));
					if(CollectionUtils.isNotEmpty(radioClickElement)) {
						radioClickElement.get(0).click();
					}
				}

				if (CollectionUtils.isNotEmpty(baseHandler.findElements(PropertiesRepository.getString("new-atitesting.question.img.loc")))) {
					hotSpotQuestionNew("new-atitesting.question.new.img.answer.loc");
				}
				//to press continue after the last question 
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
									//clickButton(PropertiesRepository.getString("new-atitesting.myati.assessment.question.unanswered.close.loc"), 0);
									clickAssessmemtType();
								}
							}
						}
					}
					
					twoBtnFlag=verifyModalBtns();
					boolean finalFlag=takeAssessmentVerifySectionNew(rationaleFlag, flagquestion,"Finalize and View Results");
					if(finalFlag && twoBtnFlag) {
						logger.info("Two buttons verified");
						log(logger,"Two buttons verified");
						flag = true;
					}
				} else {			//to flag the question
					if (i == 0 && flagquestion) {
						switchToAssessmentFrameHandler();
						verifyFlag(true);
						logger.info("Question has been flaged");
						Thread.sleep(4000);
					} else {		//to click continue after the answer is selected all questions except the last one 
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
										clickButton(PropertiesRepository.getString("new-atitesting.myati.assessment.question.unanswered.close.loc"), 0);
										clickAssessmemtType();
									}
								}
							}
						}
					}
/*					if (rationaleFlag) {
						waitUntillLoadingImageIsDisappeared("new-atitesting.pleasewait.bufferLoc");
						List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
						if(CollectionUtils.isNotEmpty(rationalContinue)) {
							rationalContinue.get(0).sendKeys(Keys.ENTER);
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						}
					}
*/					switchToAssessmentFrameHandler();

					/*if (breakFlag) {
						break;
					}*/
				}
			}
		} catch (DriverException e) {
			logger.info("unable to take practice assessment" + e);
		}
		waitUntillBufferInvisible(PropertiesRepository
				.getString("new-atitesting.pleasewait.bufferLoc"));
		logger.info("Method : takeTestAndVerifyModalForTwoBtns :::::::: END --> "+flag);
		return flag;

	}
	
	/**
	 * Method used to verify the number of buttons present in the modal displayed after the last question is answered and their content 
	 * 
	 * @author Vishal
	 * @return boolean
	 * @throws Exception
	 */
	
	public boolean verifyModalBtns() throws Exception{
		logger.info("verifyModalBtns Starts");
		boolean flag=false;
		try {
			List<WebElement> buttonList = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.generic.modal.pop.up.2.buttons.loc"));
			if(CollectionUtils.isNotEmpty(buttonList)) {
				int size = buttonList.size();
				logger.info("Modal Button size --> " + size);
				if(size == 2) {
					if(buttonList.get(0).getText().equalsIgnoreCase(PropertiesRepository.getString("new-atitesting.practice.assessment.modal.popup.1st.button.value")) && 
						(buttonList.get(1).getText().equalsIgnoreCase(PropertiesRepository.getString("new-atitesting.practice.assessment.modal.popup.2nd.button.value")))) {
						flag=true;
					}
				}
				else if(size == 3) {
					if(buttonList.get(0).getText().contains(PropertiesRepository.getString("new-atitesting.practice.assessment.modal.popup.3rd.button.value")) && 
							buttonList.get(1).getText().equalsIgnoreCase(PropertiesRepository.getString("new-atitesting.practice.assessment.modal.popup.1st.button.value")) && 
								(buttonList.get(2).getText().equalsIgnoreCase(PropertiesRepository.getString("new-atitesting.practice.assessment.modal.popup.2nd.button.value"))
									|| buttonList.get(2).getText().equalsIgnoreCase(PropertiesRepository.getString("new-atitesting.practice.assessment.modal.popup.4th.button.value")))) {
							flag=true;
					}
				}
			}
		}
		catch(Exception e) {
			logger.info("Unable to verify Two buttons in the modal "+e);
			
		}
		logger.info("verifyModalBtns Starts ->"+flag);
		return flag;
	}
		
	/**
	 * Method used to take a test and verify if 3 buttons are present in the modal after the last question is answered if some questions are flagged
	 * 
	 * @author Vishal
	 * @return boolean
	 * @param bool
	 * @param breakFlag
	 * @param rationaleFlag
	 * @param flagquestion
	 * @throws Exception
	 */
	
	public boolean takeTestAndVerifyModalForThreeBtnsWhileFlagging(boolean bool, boolean breakFlag,
			boolean rationaleFlag, boolean flagquestion) throws Exception {
		logger.info("Method : takeTestAndVerifyModalForThreeBtnsWhileFlagging :::::::: Starts");
		boolean flag=false;
		boolean threeBtnFlag=false;
		boolean questionFlag=false;
		
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
			//to select the answers for all the questions

			for (int i = 0; i <= count; i++) {
				//Flag 2 and 4 question
				if(i==1 || i==3) {	
					List<WebElement> flagElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.flag.button.loc"));
					if(CollectionUtils.isNotEmpty(flagElement) && flagElement.get(0).isDisplayed()) {
						clickButton(PropertiesRepository.getString("new-atitesting.test.assessment.flag.button.loc"), 0);
						questionFlag=true;
					}
				}
				List<WebElement> checkBoxElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.generic.tutorial.checkbox.new.multiple.answer.loc"));
				List<WebElement> radioElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.generic.tutorial.radio.button.new.multiple.answer.loc"));

				if (checkBoxElement != null) {
					checkBoxElement.get(0).click();
					checkBoxElement.get(1).click();
				}

				if (driver.findElements(By.cssSelector(".answer-fill-in-the-blank.numericTextEntry.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty")).size() > 0) {
					verifyFillForm("10");

				}

				if (CollectionUtils.isNotEmpty(baseHandler.findElements(PropertiesRepository.getString("new-atitesting.generic.tutorial.dragbox1.loc")))) {
					DragAndDropAnswerNew(false);
				}

				if (CollectionUtils.isNotEmpty(radioElement) && radioElement.size() > 0) {
					List<WebElement> radioClickElement =baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.radio.button.loc"));
					if(CollectionUtils.isNotEmpty(radioClickElement)) {
						radioClickElement.get(0).click();
					}
				}

				if (CollectionUtils.isNotEmpty(baseHandler.findElements(PropertiesRepository.getString("new-atitesting.question.img.loc")))) {
					hotSpotQuestionNew("new-atitesting.question.new.img.answer.loc");
				}
				//to press continue after the last question 
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
									//clickButton(PropertiesRepository.getString("new-atitesting.myati.assessment.question.unanswered.close.loc"), 0);
									clickAssessmemtType();
								}
							}
						}
					}
					
					threeBtnFlag=verifyModalBtns();
					boolean finalFlag = takeAssessmentVerifySectionNew(rationaleFlag, flagquestion,"Finalize and View Results");
					List<WebElement>  btnsElement= baseHandler.findElements(PropertiesRepository.getString("new-atitesting.learntab.tutorial.flagged.items.continue.button"));
					if(CollectionUtils.isNotEmpty(btnsElement)) {
						btnsElement.get(0).click();
					}
					if(finalFlag && threeBtnFlag && questionFlag) {
						logger.info("Three buttons verified -> " +threeBtnFlag);
						logger.info("Flagged Btn Functionality verified -> "+questionFlag);
						flag=true;
					}
				} else {			//to flag the question
					if (i == 0 && flagquestion) {
						switchToAssessmentFrameHandler();
						verifyFlag(true);
						logger.info("Question has been flaged");
						Thread.sleep(4000);
					} else {		//to click continue after the answer is selected all questions except the last one 
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
										clickButton(PropertiesRepository.getString("new-atitesting.myati.assessment.question.unanswered.close.loc"), 0);
										clickAssessmemtType();
									}
								}
							}
						}
					}
					switchToAssessmentFrameHandler();

				}
			}
		} catch (DriverException e) {
			logger.info("unable to take practice assessment" + e);
		}
		waitUntillBufferInvisible(PropertiesRepository
				.getString("new-atitesting.pleasewait.bufferLoc"));
		logger.info("Method : takeTestAndVerifyModalForThreeBtnsWhileFlagging :::::::: END --> "+flag);
		return flag;
	}
	
	/**
	 * Method used to move to next question using arrow keys.
	 * 
	 * @author vishal
	 * @return boolean
	 * @throws Exception
	 */
	public boolean MoveToNextQuestion(int currentQno) {
		logger.info("MoveToPreviousQuestion Starts");
		boolean flag = false;
		try {
			List<WebElement> buttonBackWardElement1 = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
			if (CollectionUtils.isNotEmpty(buttonBackWardElement1)) {
				if (buttonBackWardElement1.get(0).isDisplayed()) {
					WebElement continueButtonElement1 = buttonBackWardElement1.get(0);
					if (continueButtonElement1 != null) {
						Actions action = new Actions(driver);
						action.moveToElement(continueButtonElement1);
						continueButtonElement1.sendKeys(Keys.RIGHT);
					}
				}
			}
			flag = verifyContinueBtn(currentQno);
		}
		catch (Exception e) {
			logger.info("unable to move to previous question" + e);
		}
		logger.info("MoveToPreviousQuestion Ends -> " +flag);
		return flag;

	}
	
	/**
	 * Method used to verify the continue button by checking the question number.
	 * 
	 * @author vishal
	 * @return boolean
	 * @throws Exception
	 */
	public boolean verifyContinueBtn(int ContinueQNo) {
		logger.info("verifyContinueBtn Starts");
		boolean ContinueBtnFlag = false;
		try{
			switchToAssessmentFrameHandler();
			List<WebElement> currentQuestionNo = baseHandler.findElements(
					PropertiesRepository.getString("new-atitesting.myati.test.tab.current.question.no.loc"));
			if(CollectionUtils.isNotEmpty(currentQuestionNo)) 
			{ 
				String currentQ=currentQuestionNo.get(0).getText();
				int currentQNo =Integer.parseInt(currentQ); 
				if((currentQNo-1)==ContinueQNo) {
					ContinueBtnFlag=true; 
					logger.info("-------------Continue button functionality Verified-------------");
					log(logger,"-------------Continue button functionality Verified-------------"); 
				}
			}
		}
		catch (Exception e) {
			logger.info("unable to verify previous btn functionality" + e);
		}		
		logger.info("verifyContinueBtn Ends ->"+ContinueBtnFlag);
		return ContinueBtnFlag;
	}
	
	/**
	 * Method used to take a test by flagging all questions.
	 * 
	 * @return boolean
	 * @param flagquestion
	 * @param rationaleFlag
	 * @throws Exception
	 */
	public boolean takeTestByFlaggingAll(boolean rationaleFlag, boolean flagquestion) throws Exception{
		logger.info("Method : takeTestByFlaggingAll :::::::: Starts");
		boolean flag=false;
		boolean sectionFlag = false;
		boolean questionFlag=false;
		boolean keyFlag=false;
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
			//to select the answers for all the questions

			for (int i = 0; i <= count; i++) {
				//Flag all questions 
				logger.info("Flagging "+(i+1)+" question");
				List<WebElement> flagElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.flag.button.loc"));
				if(CollectionUtils.isNotEmpty(flagElement) && flagElement.get(0).isDisplayed()) {
					clickButton(PropertiesRepository.getString("new-atitesting.test.assessment.flag.button.loc"), 0);
					questionFlag=true;
				}
				
				//move to next question using the arrow keys
				List<WebElement> currentQuestionNo = baseHandler.findElements(
						PropertiesRepository.getString("new-atitesting.myati.test.tab.current.question.no.loc"));
				//logger.info(currentQuestionNo.get(0).getText());
				
				if(CollectionUtils.isNotEmpty(currentQuestionNo)) 
				{ 
					String currentQ=currentQuestionNo.get(0).getText();
					int currentQNo =Integer.parseInt(currentQ); 
					keyFlag=MoveToNextQuestion(currentQNo);
				}
				if(i==count) {
					sectionFlag=takeAssessmentVerifySectionNew(rationaleFlag, flagquestion,"Finalize and View Results");
					List<WebElement>  btnsElement= baseHandler.findElements(PropertiesRepository.getString("new-atitesting.learntab.tutorial.flagged.items.continue.button"));
					if(CollectionUtils.isNotEmpty(btnsElement)) {
						btnsElement.get(0).click();
					}
				}
			}
			if(keyFlag && questionFlag && sectionFlag) {
				logger.info("Flag Btn Funtionality verified ->"+questionFlag);
				logger.info("Arrow key navigation verified ->"+keyFlag);
				logger.info("Section verified ->"+sectionFlag);
				flag = true;
			}
		}
		catch(Exception e) {
			logger.info("Unable to Flag and navigate through the test "+e);
		}
		logger.info("Method : takeTestByFlaggingAll :::::::: Ends -> "+flag);
		return flag;	
	}
	
	/**
	 * Method used to flag 2 and 3 question of TEAS assessment.
	 * 
	 * @return boolean
	 * @param bool
	 * @param breakFlag
	 * @param rationaleFlag
	 * @throws Exception
	 */
	public boolean takeTestAndFlagForTEAS(boolean bool, boolean breakFlag,
			boolean rationaleFlag, boolean flagquestion) throws Exception {
		logger.info("Method : takeTestAndFlagForTEAS :::::::: Starts");
		boolean flag=false;
		boolean threeBtnFlag=false;
		boolean unflagTestFlag=false;
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
			//to select the answers for all the questions

			boolean questionFlag=false;
			for (int i = 0; i <= count; i++){
				if(i==1 || i==2){
					List<WebElement> flagElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.flag.button.loc"));
					if(CollectionUtils.isNotEmpty(flagElement) && flagElement.get(0).isDisplayed()) {
						clickButton(PropertiesRepository.getString("new-atitesting.test.assessment.flag.button.loc"), 0);
						questionFlag=true;
					}
				}
				else{
					List<WebElement> radioElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.generic.tutorial.radio.button.new.multiple.answer.loc"));
					if (CollectionUtils.isNotEmpty(radioElement) && radioElement.size() > 0) {
						List<WebElement> radioClickElement =baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.radio.button.loc"));
						if(CollectionUtils.isNotEmpty(radioClickElement)) {
							radioClickElement.get(0).click();
						}
					}
				}
				//to press continue after the last question 
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
									//clickButton(PropertiesRepository.getString("new-atitesting.myati.assessment.question.unanswered.close.loc"), 0);
									clickAssessmemtType();
								}
							}
						}
					}
					threeBtnFlag = verifyModalBtns();
					boolean finalFlag=takeAssessmentVerifySectionNew(rationaleFlag, flagquestion,PropertiesRepository.getString("new-atitesting.practice.assessment.modal.popup.3rd.button.value"));
					unflagTestFlag = takeTestWithUnFlagFuncationality(false,false,false,false);
					if( finalFlag && questionFlag && threeBtnFlag && unflagTestFlag) {
						logger.info("Flagged btn functionality verified ->"+questionFlag);
						logger.info("Three buttons are verified ->"+threeBtnFlag);
						logger.info("Review previous button verified ->"+finalFlag);
						logger.info("Answering of Flagged questions verified ->"+unflagTestFlag);
						flag = true;
					}
				} else {			//to flag the question
					if (i == 0 && flagquestion) {
						switchToAssessmentFrameHandler();
						verifyFlag(true);
						logger.info("Question has been flaged");
						Thread.sleep(4000);
					} else {		//to click continue after the answer is selected all questions except the last one 
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
										clickButton(PropertiesRepository.getString("new-atitesting.myati.assessment.question.unanswered.close.loc"), 0);
										clickAssessmemtType();
									}
								}
							}
						}
					}
/*					if (rationaleFlag) {
						waitUntillLoadingImageIsDisappeared("new-atitesting.pleasewait.bufferLoc");
						List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
						if(CollectionUtils.isNotEmpty(rationalContinue)) {
							rationalContinue.get(0).sendKeys(Keys.ENTER);
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						}
					}
*/					switchToAssessmentFrameHandler();

					/*if (breakFlag) {
						break;
					}*/
				}
			}	
		} catch (DriverException e) {
			logger.info("unable to take TEAS practice assessment" + e);
		}
		waitUntillBufferInvisible(PropertiesRepository
				.getString("new-atitesting.pleasewait.bufferLoc"));
		logger.info("Method : takeTestAndFlagForTEAS :::::::: END --> "+flag);
		return flag;
	}
	
	/**
	 * Method is used to complete Test containing only flagged questions while unflagging them 
	 * 
	 * Note: Here for test case NewATI-19, it has been coded to verify that question numbers 2 and 3 that were flagged will appear while reviewing them
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
		boolean flaggedQNo=false;
		boolean proceedFlag=false;
		boolean goBackFlag=false;
		try {
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			switchToAssessmentFrameHandler();
			// Getting Total Question Number
			String maxQtnTextNo = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.new.question.number.loc")).get(1).getText();

			// Convert String to Integer
			int maxCount = Integer.parseInt(maxQtnTextNo);

			// Getting Current Question Number
			String minQtnTextNo = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.new.question.number.loc")).get(0).getText();

			// Convert String to Integer
			int minCount = Integer.parseInt(minQtnTextNo);

			// Maximum Question minus Minimum Questions
			int count = maxCount - minCount;

			for (int i = 0; i <= count; i++) {
				//to check the order of Flagged Questions
				List<WebElement> currentQuestionNo = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.myati.test.tab.current.question.no.loc"));
				if(CollectionUtils.isNotEmpty(currentQuestionNo)) 
				{ 
					String currentQ=currentQuestionNo.get(0).getText();
					if(currentQ.equalsIgnoreCase(PropertiesRepository.getString("new-atitesting.teas.practice.assessment.flagged.question.2.value")) || 
							currentQ.equalsIgnoreCase(PropertiesRepository.getString("new-atitesting.teas.practice.assessment.flagged.question.3.value"))) {
						logger.info("Flagged Question number is verified ");
						flaggedQNo=true;
					}
				}	
				// Unflag the assessment. 
				clickButton(PropertiesRepository.getString("new-atitesting.test.dropdown.practice.assessment.flag.button"), 0);
				
				List<WebElement> radioElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.generic.teas.radio.button.new.multiple.answer.loc"));

				if (driver.findElements(By.cssSelector(".answer-fill-in-the-blank.numericTextEntry.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty"))						.size() > 0) {
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
					proceedFlag=clickModalPopUp(rationaleFlag, flagquestion,PropertiesRepository.getString("new-atitesting.teas.practice.assessment.proceed.to.next.section.value"));
				} else {
					if (i == 0 && flagquestion) {
						switchToAssessmentFrameHandler();
						verifyFlag(true);
						logger.info("Question has been flaged");
						Thread.sleep(4000);
					} else {
						switchToAssessmentFrameHandler();
						waitUntillElementIsVisible(PropertiesRepository.getString("new-atitesting.learntab.tutorial.continue.button"));
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
										//Verify Go back to previous question 
										goBackFlag =clickModalPopUp(false, flagquestion,PropertiesRepository.getString("new-atitesting.teas.practice.assessment.go.back.last.question.value"));
										toPressContinue();
										//Verify proceed to next section 
										proceedFlag=clickModalPopUp(false, flagquestion,PropertiesRepository.getString("new-atitesting.teas.practice.assessment.proceed.to.next.section.value"));
										//flag = true;
										break;
									}
								}
							}
						}
					}
					if (rationaleFlag) {
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
						if(CollectionUtils.isNotEmpty(rationalContinue)) {
							rationalContinue.get(0).sendKeys(Keys.ENTER);
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
							// Checking for Assessment Completed Popup
							List<WebElement> assessmentCompleteElement = baseHandler.findElements(".modal-section div button");
							if(CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
								proceedFlag=clickModalPopUp(false, flagquestion,PropertiesRepository.getString("new-atitesting.teas.practice.assessment.proceed.to.next.section.value"));
								break;
							}
						}
					}
				}
			}
		} catch (DriverException e) {
			logger.info("unable to unflag and take a practice assessment" + e);
		}
		if(goBackFlag && proceedFlag && flaggedQNo) {
			logger.info("Go Back to last question verified -> "+goBackFlag);
			logger.info("Proceed to next question verified -> "+proceedFlag);
			flag=true;			
		}
		waitUntillBufferInvisible(PropertiesRepository
				.getString("new-atitesting.peasewait.bufferLoc"));
		logger.info("Method : takeTestWithUnFlagFuncationality :::::::: END flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to answer one question in a practice asmt.
	 * 
	 * @return boolean
	 * @param bool
	 * @param breakFlag
	 * @param rationaleFlag
	 * @throws Exception
	 */
	public int takeTestAndAnswerOneQ(boolean bool, boolean breakFlag,
			boolean rationaleFlag, boolean flagquestion) throws Exception {
		logger.info("Method : takeTestAndAnswerOneQ :::::::: Starts");
		boolean flag=false;
		int currentQNo=0;
		try {

			switchToAssessmentFrameHandler();
			//to select the answers for the question
			for (int i = 0; i <1 ; i++) {
				
				List<WebElement> checkBoxElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.generic.tutorial.checkbox.new.multiple.answer.loc"));
				List<WebElement> radioElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.generic.tutorial.radio.button.new.multiple.answer.loc"));

				if (checkBoxElement != null) {
					checkBoxElement.get(0).click();
					checkBoxElement.get(1).click();
				}

				if (driver.findElements(By.cssSelector(".answer-fill-in-the-blank.numericTextEntry.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty")).size() > 0) {
					verifyFillForm("10");

				}

				if (CollectionUtils.isNotEmpty(baseHandler.findElements(PropertiesRepository.getString("new-atitesting.generic.tutorial.dragbox1.loc")))) {
					DragAndDropAnswerNew(false);
				}

				if (CollectionUtils.isNotEmpty(radioElement) && radioElement.size() > 0) {
					List<WebElement> radioClickElement =baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.radio.button.loc"));
					if(CollectionUtils.isNotEmpty(radioClickElement)) {
						radioClickElement.get(0).click();
					}
				}

				if (CollectionUtils.isNotEmpty(baseHandler.findElements(PropertiesRepository.getString("new-atitesting.question.img.loc")))) {
					hotSpotQuestionNew("new-atitesting.question.new.img.answer.loc");
				}
				//to press continue after the last question 
				
				//to flag the question
				if (i == 0 && flagquestion) {
					switchToAssessmentFrameHandler();
					verifyFlag(true);
					logger.info("Question has been flaged");
					Thread.sleep(4000);
				} else {		//to click continue after the answer is selected all questions except the last one 
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
								flag= true;
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								if(verifyQuestionUnAsweredPopup()) {
									List<WebElement> assessmentCompleteElement = baseHandler.findElements(".modal-section button");
									if(CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
										assessmentCompleteElement.get(0).click();
									}
									clickButton(PropertiesRepository.getString("new-atitesting.myati.assessment.question.unanswered.close.loc"), 0);
									clickAssessmemtType();
								}
							}
						}
					}
				}
				//get current question number
				switchToAssessmentFrameHandler();
				List<WebElement> currentQuestionNo = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.myati.test.tab.current.question.no.loc"));
				//logger.info(currentQuestionNo.get(0).getText());
				if(CollectionUtils.isNotEmpty(currentQuestionNo)) 
				{ 
					String currentQ=currentQuestionNo.get(0).getText();
					currentQNo =Integer.parseInt(currentQ);
				}
				/*if (rationaleFlag) {
					waitUntillLoadingImageIsDisappeared("new-atitesting.pleasewait.bufferLoc");
					List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
					if(CollectionUtils.isNotEmpty(rationalContinue)) {
						rationalContinue.get(0).sendKeys(Keys.ENTER);
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
					}
				}*/
				switchToAssessmentFrameHandler();

				/*if (breakFlag) {
					break;
				}*/
				}
		} catch (DriverException e) {
			logger.info("unable to answer one question in a practice assessment" + e);
		}
		logger.info("Method : takeTestAndAnswerOneQ :::::::: END --> "+flag);
		return currentQNo;
	}
	
	/**
	 * Method used to verify question number.
	 * 
	 * @author Vishal
	 * @return boolean
	 * @param qNo
	 * @throws Exception
	 */
	public boolean verifyQuestionNumber(int qNo) throws Exception{
		logger.info("Method : verifyQuestionNumber :::::::: Starts");
		boolean flag=false;
		try {
			switchToAssessmentFrameHandler();
			List<WebElement> currentQuestionNo = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.myati.test.tab.current.question.no.loc"));
			//logger.info(currentQuestionNo.get(0).getText());
			if(CollectionUtils.isNotEmpty(currentQuestionNo)) 
			{ 
				String currentQ=currentQuestionNo.get(0).getText();
				int currentQNo =Integer.parseInt(currentQ); 
				//logger.info("------------currentQno"+currentQNo); 
				//logger.info("------------QNo"+qNo); 
				if((currentQNo)==qNo) {
					flag=true; 
					logger.info("-------------Question number Verified-------------");
					log(logger,"-------------Question number Verified-------------"); 
				}
			}
		}
		catch (Exception e) {
			logger.info("unable to verify question number " + e);
		}
		logger.info("Method : verifyQuestionNumber :::::::: Ends -> "+flag);
		return flag;
	}
	
	
	/**
	 * Method used to verify pause time or assessment time captured of a practice asmt
	 * 
	 * @author Vishal
	 * @return boolean
	 * @param pauseTime
	 * @throws Exception
	 */
	public boolean verifyPauseAndAsmtTime(int Time,String type) throws Exception{
		logger.info("Method : verifyPauseAndAsmtTime :::::::: Starts");
		boolean flag=false;
		int timeAfter = 0;
		try {
			timeAfter=captureAsmtAndPauseTime(type);
			//logger.info("------------pauseTimeAfter"+pauseTimeAfter); 
			//logger.info("------------pauseTimeBefore"+pauseTime); 
			int timeDiff=Time-timeAfter;
			//logger.info("------------pauseTimeDiff"+pause);
			if((timeDiff)<3){
				log(logger," "+type+" time is verified.");
				logger.info(" "+type+"time is verified.");
				flag=true;
			}
		}
		catch (Exception e) {
			logger.info("unable to verify "+type+" time " + e);
		}
		logger.info("Method : verifyPauseAndAsmtTime :::::::: Ends -> "+flag);
		return flag;
	}

	/**
	 * Method first verifies if the assessment after opening continues from the previous assessment time
	 * 
	 * @author Vishal
	 * @return boolean
	 * @param asmtTime
	 * @throws Exception
	 */
	public boolean verifyAsmtAndPauseTime(int asmtTime) {
		logger.info("Method : verifyAsmtAndPauseTime :::::::: Starts");
		boolean flag = false;
		int pauseTime=0;
		boolean asmtTimeFlag1=false;
		boolean asmtTimeFlag3=false;
		boolean asmtTimeFlag2=false;
		boolean pauseTimeFlag1=false;
		boolean pauseTimeFlag2=false;
		boolean pauseModalFlag=false;
		int asmtTime2=0;
		int asmtTime3=0;
		int pauseTime2=0;
		try {
			//verify assessment time 
			log(logger,"Verify if the assessment time continues from the previous time");
			asmtTimeFlag1=verifyPauseAndAsmtTime(asmtTime,"Assessment");
			logger.info("Assessment time after reopening the asssessment time is verified.");
			
			//note the asmt time and pause time and verify both the times in the pause modal and resume asmt
			log(logger, "Note the assessment time");
			asmtTime2=captureAsmtAndPauseTime("Assessment");
			log(logger, "Note the pause time");
			pauseTime=captureAsmtAndPauseTime("Pause");
			logger.info("Assessment time and pause time are successfully captured. ");
			
			//click the pause button
			log(logger, "Clicking on Pause Button");
			verifyAssessmentPauseButton(true);
			logger.info("Pause modal opens up");
			
			log(logger, "Verifying the pause timer and resume assessment button presence");
			pauseModalFlag=verifyPauseTimerAndResumeButtonPresence();
		
			log(logger, "Clicking on the Resume assessment button");
			verifyResumeAssessmentButton(true);
			
			log(logger, "Verifying if the assessment time is correct");
			asmtTimeFlag2=verifyPauseAndAsmtTime(asmtTime2,"Assessment");
			
			log(logger, "Verifying if the pause time is correct");
			pauseTimeFlag1=verifyPauseAndAsmtTime(pauseTime,"Pause");
			
			//note the asmt time and pause time and verify both the times in the pause modal and resume asmt
			if(asmtTimeFlag2 && pauseTimeFlag1) {
				log(logger, "Note the assessment time");
				asmtTime3=captureAsmtAndPauseTime("Assessment");
				log(logger, "Note the pause time");
				pauseTime2=captureAsmtAndPauseTime("Pause");
				logger.info("Assessment time and pause time are successfully captured. ");
				
				log(logger, "Answer one question ");
				takeTestAndAnswerOneQ(false, false, false, false);
				
				log(logger, "Verifying if the assessment time is correct after answering the question ");
				asmtTimeFlag3=verifyPauseAndAsmtTime(asmtTime3,"Assessment");
				
				log(logger, "Verifying if the pause time is correct after answering the question");
				pauseTimeFlag2=verifyPauseAndAsmtTime(pauseTime2,"Pause");
			}			
			if(asmtTimeFlag1 && asmtTimeFlag2 && asmtTimeFlag3 && pauseModalFlag && pauseTimeFlag1 && pauseTimeFlag2 ) {
				log(logger,"Pause modal elements along with Assessment time and pause time are verified");
				logger.info("Pause modal elements along with Assessment time and pause time are verified");
				flag=true;
			}
			
		}
		catch (Exception e) {
			logger.info("unable to verify pause time and assessment time" + e);
		}
		logger.info("Method : verifyAsmtAndPauseTime :::::::: Ends -> "+flag);
		return flag;
	}

	
	/**
	 * Method used to capture assessment and pause time of a practice asmt
	 * 
	 * @author Vishal
	 * @param type
	 * @return boolean
	 * @throws Exception
	 */
	public int captureAsmtAndPauseTime(String type) {
		logger.info("captureAsmtAndPauseTime Starts");
		String time="";
		int timeAfter = 0;
		boolean flag=false;
		try {
			switchToAssessmentFrameHandler();
			List<WebElement> timeList1 = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.myati.assessment.timer.loc"));
			if(CollectionUtils.isNotEmpty(timeList1)) {
				time= timeList1.get(2).getText();
				//logger.info("pauseTime: "+pauseTime);
				timeAfter= Integer.parseInt(time.substring(3,5));
				//logger.info("Pause time minutes: "+pauseTimeAfter);
				flag=true;
			}
		}
		catch(Exception e) {
			logger.info("unable to capture "+ type +" time" + e);
		}
		logger.info("captureAsmtAndPauseTime Ends ->" +flag);
		return timeAfter;
	}
	/**
	 * Method is used to verify the pause button is displayed in the asmt page and clicks on the
	 * Pause button if the click is true
	 * 
	 * @author siddharth.roy
	 * @return boolean
	 * @throws Exception
	 */
	public boolean verifyAssessmentPauseButton(boolean click) throws Exception {
		logger.info("Method: verifyAssessmentPauseButton Starts");
		boolean flag = false;
		try {
			waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.peasewait.bufferLoc"));
			switchToAssessmentFrameHandler();
			if (baseHandler.isDisplayed(baseHandler.findElement(PropertiesRepository.getString("new-atitesting.myati.test.tab.assessment.pause.button.loc")))) {
				if (click) {
					baseHandler.findElement(PropertiesRepository.getString("new-atitesting.myati.test.tab.assessment.pause.button.loc")).click();
				}
				flag = true;
			}
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to click Assessment Pause Button");
			throw new DriverException("Unable to click Assessment Pause Button", e);
		}
		logger.info("Method: verifyAssessmentPauseButton End flag --> " + flag);
		return flag;
	}

	/**
	 * Method used to verify Pause Button Header Message.
	 * 
	 * @author saravanan.jothimani
	 * @return boolean
	 * @throws Exception
	 */
	public boolean verifyPauseButtonHeaderMessage() throws Exception {
		logger.info("Method: verifyPauseButtonHeaderMessage Starts");
		boolean flag = false;
		try {
			switchToAssessmentFrameHandler();
			if (baseHandler.isDisplayed(PropertiesRepository.getString("new-atitesting.myati.test.tab.assessment.pause.button.header.message.loc"))) {
				List<WebElement> pauseMessage = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.myati.test.tab.assessment.pause.button.header.message.loc"));
				if (CollectionUtils.isNotEmpty(pauseMessage)) {
					WebElement pauseElement = pauseMessage.get(0);
					if (pauseElement != null) {
						String messageValue = pauseElement.getText().trim();
						if (StringUtils.isNotEmpty(messageValue) && 
								messageValue.equalsIgnoreCase(PropertiesRepository.getString("new-atitesting.myati.test.tab.assessment.pause.button.header.message.value.loc"))) {
							flag = true;
						}
					}
				}
			}
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to verify Pause Button Header Message");
			throw new DriverException(
					"Unable to verify Pause Button Header Message", e);
		}
		logger.info("Method: verifyPauseButtonHeaderMessage End flag --> "+ flag);
		return flag;
	}

	/**
	 * Method used to click Resume button.
	 * 
	 * @author saravanan.jothimani
	 * @return boolean
	 * @throws Exception
	 */
	public boolean verifyResumeAssessmentButton(boolean click)
			throws Exception {
		logger.info("Method: verifyResumeAssessmentButton Starts");
		boolean flag = false;
		try {
			switchToAssessmentFrameHandler();
			if (baseHandler.isDisplayed(PropertiesRepository.getString("new-atitesting.myati.test.tab.assessment.resume.assessment.button.loc"))) {
				List<WebElement> pauseMessage = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.myati.test.tab.assessment.resume.assessment.button.loc"));
				if (CollectionUtils.isNotEmpty(pauseMessage)) {
					if (click) {
						baseHandler.findElement(PropertiesRepository.getString("new-atitesting.myati.test.tab.assessment.resume.assessment.button.loc")).click();
					}
					flag = true;
				}
			}
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to verify Resume Assessment Button");
			throw new DriverException("Unable to verify Resume Assessment Button", e);
		}
		logger.info("Method: verifyResumeAssessmentButton End flag --> "+ flag);
		return flag;
	}

	/**
	 * Method used to verify Pause Timer and Resume button presence.
	 * 
	 * @author saravanan.jothimani
	 * @return boolean
	 * @throws Exception
	 */
	
	public boolean verifyPauseTimerAndResumeButtonPresence()throws Exception {
		logger.info("Method: verifyPauseTimerAndResumeButtonPresence Starts");
		boolean pauseTimerFlag=false;
		boolean resumeBtnFlag=false;
		boolean flag = false;
		try {
			switchToAssessmentFrameHandler();
			if (baseHandler.isDisplayed(PropertiesRepository.getString("new-atitesting.myati.test.tab.assessment.pause.time.from.popup.loc"))) {
				List<WebElement> pauseTimer = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.myati.test.tab.assessment.pause.time.from.popup.loc"));
				if (CollectionUtils.isNotEmpty(pauseTimer)) {
					pauseTimerFlag=true;
				}
			}
			if (baseHandler.isDisplayed(PropertiesRepository.getString("new-atitesting.myati.test.tab.assessment.resume.assessment.button.loc"))) {
				List<WebElement> resumeBtn = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.myati.test.tab.assessment.resume.assessment.button.loc"));
				if (CollectionUtils.isNotEmpty(resumeBtn)) {
					resumeBtnFlag=true;
				}
			}
			if(pauseTimerFlag && resumeBtnFlag) {
				logger.info("Pause Timer is present "+pauseTimerFlag);
				logger.info("Resume Button is present "+resumeBtnFlag);
				flag=true;
			}
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to verify Pause timer and Resume Button presence ");
			throw new DriverException(
					"Unable to verify Pause timer and Resume Button presence ", e);
		}
		logger.info("Method: verifyPauseTimerAndResumeButtonPresence End flag --> "+ flag);
		return flag;
	}
}
