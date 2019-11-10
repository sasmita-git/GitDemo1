package com.automation.asmt.page;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.ButtonHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;

public class QuizBankAssessmentPage extends ASMTBasePage {
	private Logger logger = LogManager.getLogger(this.getClass());
	public BaseHandler baseHandler;
	private WindowHandler windowHandler;
	private ButtonHandler buttonHandler;
	private boolean flag;

	public QuizBankAssessmentPage(WebDriver webDriver) {
		super(webDriver);
		baseHandler = new BaseHandler(driver);
		windowHandler = new WindowHandler(driver);
		buttonHandler = new ButtonHandler(driver);
	}
	
	/**
	 * Method used to switch to PDF Frame.
	 * 
	 * @author saravanan.jothimani
	 * @throws DriverException
	 */
	public void swithToProctorFrame(WebDriver chromeDriver) throws DriverException {
		logger.info("Method: swithToProctorFrame Starts");
    	try {
    		windowHandler.switchToLatestWindow();
    		List<WebElement> iframe = chromeDriver.findElements(By.cssSelector(".card-shadow"));
    		if(CollectionUtils.isNotEmpty(iframe)) {
    			chromeDriver.switchTo().frame(iframe.get(0));
    		}
    	} catch (Exception e) {
    		logger.info("Unable to swithToProctorFrame" );
			log(logger, "Unable to swithToProctorFrame" );
    		throw new DriverException("Unable to swithToProctorFrame" , e); 
    	}
    	logger.info("Method: swithToProctorFrame End " );
	}
	
	public void clickAssessmemtType() throws Exception {			
		
		List<WebElement> checkBoxElement = driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.tutorial.checkbox.new.loc")));
		List<WebElement> radioElement = driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.tutorial.radio.button.new.loc")));
		List<WebElement> hotSpotElement = driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.question.img.loc")));				
		List<WebElement> inputBoxOption = driver.findElements(By.cssSelector("input[id^='fillIn']"));
		List<WebElement> textBoxElement2 = driver.findElements(By.cssSelector("#fillInNumericAnswer"));	
		List<WebElement> textAreaElement = driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.maint.textarea.loc")));
		List<WebElement> dragNDrop = driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc")));
		
		if (CollectionUtils.isNotEmpty(checkBoxElement)
				&& checkBoxElement.size() > 0) {
			checkBoxElement.get(0).click();
		} else 	if(CollectionUtils.isNotEmpty(hotSpotElement) && hotSpotElement.size() > 0) { // Clicking Flag if it has Hot Spot Image
			hotSpotQuestion();
		} else if (CollectionUtils.isNotEmpty(radioElement)
				&& radioElement.size() > 0) {
			radioElement.get(0).click();
		} else if(CollectionUtils.isNotEmpty(inputBoxOption)) {
			verifyFillForm("10");
		} else if(CollectionUtils.isNotEmpty(textBoxElement2)) {
			verifyFillForm("10");		} 
		else if(CollectionUtils.isNotEmpty(textAreaElement)) {
			verifyFillForm("10");
		} else if(CollectionUtils.isNotEmpty(dragNDrop)) {
			DragAndDropAnswer(false);
		} else {
			buttonHandler.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.flag.button"));
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		}		
	}
	
	public boolean verifyExhibitButton(boolean boolClick) throws Exception {
		logger.info("Method: verifyExhibitButton Starts");
		boolean flag = false;
    	try {
    		List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("asmt.myati.assessment.exhibit.loc"));
    		if(CollectionUtils.isNotEmpty(element)) {
    			flag = true;
    			if(boolClick) {
    				element.get(0).click();
    			}
    		}
    	} catch (Exception e) {
    		logger.info("Unable to ");
			log(logger, "Unable to " );
    		throw new DriverException("Unable to " , e); 
    	}
    	logger.info("Method: verifyExhibitButton End flag --> " + flag);
    	return flag;
	}
	
	
	/**
	 * This method is used to verify the flag button in the assessment page. and
	 * click if click==true author siddharth.roy
	 * 
	 * @throws Exception
	 * @return boolean
	 */
	public boolean verifyFlag(boolean click) throws Exception {

		logger.info("Method:  verifyFlag Starts");
		boolean flag = false;
		try {
			waitUntillBufferInvisible(PropertiesRepository.getString("asmt.pleasewait.bufferLoc"));			
			switchToAssessmentFrameHandler();
			waitUntillElementIsVisible(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"));
			if (baseHandler.isDisplayed(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"))) {
				if (click) {
					waitUntillElementIsVisible(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"));
					baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.flag.value")).click();
				}
				flag = true;
			}
			switchToAssessmentFrameHandler();
		} catch (Exception e) {
			logger.info("Unable to  verify Flag");
			throw new DriverException("Unable to verify Flag", e);
		}
		logger.info("Method:  verifyFlag End flag --> " + flag);
		windowHandler.switchToLatestWindow();
		return flag;
	}
	

	/**
	 * This method is used to identify the hotspot question.
	 * 
	 * @author siddharth roy
	 * @return boolean
	 * @throws DriverException
	 */
	public boolean hotSpotQuestion() throws Exception {
		logger.info("Method : hotSpotQuestion :::::::: start");
		boolean flag = false;
		try {
			switchToAssessmentFrameHandler();

			if (baseHandler.isDisplayed(PropertiesRepository.getString("asmt.question.img.loc"))) {
				buttonHandler.clickButton(PropertiesRepository.getString("asmt.question.img.loc"));
				
			}
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			throw new DriverException("Unable to Verify Submit Disabled", e);
		}
		windowHandler.switchToLatestWindow();
		logger.info("Method:  hotSpotQuestion End --> " + flag);
		return flag;
	}
	
	/**
	 * This method is used to identify the presence of disabled submit button
	 * 
	 * @author siddharth roy
	 * @param locator
	 * @return
	 * @throws DriverException
	 */
	public boolean verifyFillForm(String value) throws Exception {
		boolean flag = false;
		try {
			logger.info("Method : verifyFillForm :::::::: start ");
			
			waitUntillBufferInvisible(PropertiesRepository
					.getString("asmt.pleasewait.bufferLoc"));
			switchToAssessmentFrameHandler();

			//List<WebElement> element = baseHandler.findElements("div[class='free-form-question-container'] .answer-fill-in-the-blank.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty");
			List<WebElement> element = baseHandler.findElements("input[id^='fillIn']");

			if (CollectionUtils.isNotEmpty(element)) {
				element.get(0).sendKeys(value);
				flag = true;
			}
		} catch (Exception e) {
			throw new DriverException("Unable to fill the text entry question",
					e);
		}
		//windowHandler.switchToLatestWindow();
		logger.info("Method:  verifyFillForm End --> " + flag);
		return flag;
	}
	

	/**
	 * This method is used to answer drag and drop question
	 * 
	 * @author siddharth roy
	 * @return boolean
	 * @throws DriverException
	 */
	public void DragAndDropAnswer(boolean stop) throws Exception {
		logger.info("DragAndDropAnswer Start ");
		try {
			waitUntillBufferInvisible(PropertiesRepository
					.getString("asmt.pleasewait.bufferLoc"));
			logger.info("Method : DragAndDropAnswer :::::::: start");
			Actions act = new Actions(driver);
			boolean breakflag = false;

			
			switchToAssessmentFrameHandler();
			int tot = baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc")).findElements(By.cssSelector("li")).size();
			if (baseHandler.isDisplayed(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc"))) {
				System.out.println(baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox2.loc")).findElements(By.cssSelector("li")).size());
				while (baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox2.loc")).findElements(By.cssSelector("li")).size() != tot) {
					if (breakflag) {
						break;
					}
					List<WebElement> btn = baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc")).findElements(By.cssSelector("li"));
					for (int i = 0; i < btn.size(); i++) {
						try {
							wait.until(ExpectedConditions
									.elementToBeClickable(btn.get(i)));
							WebElement toElement = baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox2.loc"));
							if (breakflag) {
								break;
							}

							org.openqa.selenium.interactions.Action atc2 = act
									.clickAndHold(btn.get(i))
									.moveToElement(toElement)
									.release(toElement).build();
							buttonHandler
									.clickButton(PropertiesRepository
											.getString("asmt.generic.tutorial.dragbox2.loc"));
							atc2.perform();
							if (stop) {
								breakflag = true;
							}
							if(i == btn.size()-1){
								breakflag = true;
							}
							Thread.sleep(1000);
						} catch (StaleElementReferenceException e) {
							logger.info("element in stale state countiniuing");
						}
					}
				}
			}
		}

		catch (Exception e) {
			throw new DriverException("Unable to Drag And Drop Answer", e);

		}
		//windowHandler.switchToLatestWindow();
		logger.info("Method:  DragAndDropAnswer End --> ");
	}
	
	/**
	 * This method is used to drag and drop in reverse (Right to left)
	 * 
	 * @author siddharth roy
	 * @return boolean
	 * @throws DriverException
	 */
	public void DragAndDropAnswerReverse(boolean stop) throws Exception {
		logger.info("DragAndDropAnswerReverse Start ");
		try {
			waitUntillBufferInvisible(PropertiesRepository
					.getString("asmt.pleasewait.bufferLoc"));
			logger.info("Method : DragAndDropAnswer :::::::: start");
			Actions act = new Actions(driver);
			boolean breakflag = false;

			
			switchToAssessmentFrameHandler();
			int tot = baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox2.loc")).findElements(By.cssSelector("li")).size();
			if (baseHandler.isDisplayed(PropertiesRepository.getString("asmt.generic.tutorial.dragbox2.loc"))) {
				System.out.println(baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc")).findElements(By.cssSelector("li")).size());
				while (baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc")).findElements(By.cssSelector("li")).size() != tot) {
					if (breakflag) {
						break;
					}
					List<WebElement> btn = baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox2.loc")).findElements(By.cssSelector("li"));
					for (int i = 0; i < btn.size(); i++) {
						try {
							wait.until(ExpectedConditions
									.elementToBeClickable(btn.get(i)));
							WebElement toElement = baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc"));
							if (breakflag) {
								break;
							}

							org.openqa.selenium.interactions.Action atc2 = act
									.clickAndHold(btn.get(i))
									.moveToElement(toElement)
									.release(toElement).build();
							buttonHandler
									.clickButton(PropertiesRepository
											.getString("asmt.generic.tutorial.dragbox1.loc"));
							atc2.perform();
							if (stop) {
								breakflag = true;
							}
							if(i == btn.size()-1){
								breakflag = true;
							}
							Thread.sleep(1000);
						} catch (StaleElementReferenceException e) {
							logger.info("element in stale state countiniuing");
						}
					}
				}
			}
		}

		catch (Exception e) {
			throw new DriverException("Unable to Drag And Drop Answer from right to left", e);

		}
		//windowHandler.switchToLatestWindow();
		logger.info("Method:  DragAndDropAnswerReverse End --> ");
	}
	
	/**
	 * This method is used to answer drag and drop question Uisng Space button
	 * 
	 * 
	 * @return boolean
	 * @throws DriverException
	 */
	public void DragAndDropAnswerUsingSpaceBtn(boolean stop) throws Exception {
		logger.info("DragAndDropAnswerUsingSpaceBtn Start ");
		try {
			waitUntillBufferInvisible(PropertiesRepository
					.getString("asmt.pleasewait.bufferLoc"));
			logger.info("Method : DragAndDropAnswer :::::::: start");
			Actions act = new Actions(driver);
			boolean breakflag = false;

			
			switchToAssessmentFrameHandler();
			int tot = baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc")).findElements(By.cssSelector("li")).size();
			if (baseHandler.isDisplayed(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc"))) {
				System.out.println(baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox2.loc")).findElements(By.cssSelector("li")).size());
				while (baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox2.loc")).findElements(By.cssSelector("li")).size() != tot) {
					if (breakflag) {
						break;
					}
					List<WebElement> btn = baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc")).findElements(By.cssSelector("li"));
					for (int i = 0; i < btn.size(); i++) {
						try {
							wait.until(ExpectedConditions
									.elementToBeClickable(btn.get(i)));
							WebElement toElement = baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox2.loc"));
							if (breakflag) {
								break;
							}

							org.openqa.selenium.interactions.Action atc2 = act
									.clickAndHold(btn.get(i))
									.sendKeys(Keys.SPACE).build();									
							atc2.perform();
							if (stop) {
								breakflag = true;
							}
							if(i == btn.size()-1){
								breakflag = true;
							}
							Thread.sleep(1000);
						} catch (StaleElementReferenceException e) {
							logger.info("element in stale state countiniuing");
						}
					}
				}
			}
		}

		catch (Exception e) {
			throw new DriverException("Unable to Drag And Drop Answer Using space button", e);

		}
		//windowHandler.switchToLatestWindow();
		logger.info("Method:  DragAndDropAnswerUsingSpaceBtn End --> ");
	}
	
	/**
	 * This method is used to answer drag and drop first answers only 
	 * 
	 * @return boolean
	 * @throws DriverException
	 */
	public void DragAndDropOneAnswers(boolean stop) throws Exception {
		logger.info("DragAndDropOneAnswers Start ");
		try {
			waitUntillBufferInvisible(PropertiesRepository
					.getString("asmt.pleasewait.bufferLoc"));
			logger.info("Method : DragAndDropAnswer :::::::: start");
			Actions act = new Actions(driver);
			boolean breakflag = false;
			
			switchToAssessmentFrameHandler();
			if (baseHandler.isDisplayed(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc"))) {
				System.out.println(baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox2.loc")).findElements(By.cssSelector("li")).size());
				List<WebElement> btn = baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc")).findElements(By.cssSelector("li"));
						try {
							wait.until(ExpectedConditions.elementToBeClickable(btn.get(0)));
							WebElement toElement = baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox2.loc"));
							org.openqa.selenium.interactions.Action atc2 = act
									.clickAndHold(btn.get(0))
									.moveToElement(toElement)
									.release(toElement).build();
							buttonHandler
									.clickButton(PropertiesRepository
											.getString("asmt.generic.tutorial.dragbox2.loc"));
							atc2.perform();
							if (stop) {
								breakflag = true;
							}
							if(0 == btn.size()-1){
								breakflag = true;
							}
							Thread.sleep(1000);
						} catch (StaleElementReferenceException e) {
							logger.info("element in stale state countiniuing");
						}
					}
				}
		catch (Exception e) {
			throw new DriverException("Unable to Drag And Drop One Answer", e);

		}
		//windowHandler.switchToLatestWindow();
		logger.info("Method:  DragAndDropOneAnswers End --> ");
	}
	
	/**
	 * This method is used Drag And Drop Answer in answer block itself
	 * 
	 * @return boolean
	 * @throws DriverException
	 */
	public void DragAndDropOneAnswersInAnswerBlock(boolean stop) throws Exception {
		logger.info("DragAndDropOneAnswersInAnswerBlock Start");
		try {
			waitUntillBufferInvisible(PropertiesRepository.getString("asmt.pleasewait.bufferLoc"));
			logger.info("Method : DragAndDropOneAnswersInAnswerBlock :::::::: start");
			Actions act = new Actions(driver);
			boolean breakflag = false;

			switchToAssessmentFrameHandler();
			if (baseHandler.isDisplayed(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc"))) {
				System.out.println(
						baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox2.loc"))
								.findElements(By.cssSelector("li")).size());
				List<WebElement> btn = baseHandler
						.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox2.loc"))
						.findElements(By.cssSelector("li"));
				try {
					wait.until(ExpectedConditions.elementToBeClickable(btn.get(0)));
					WebElement toElement = btn.get(3);
					org.openqa.selenium.interactions.Action atc2 = act.clickAndHold(btn.get(0)).moveToElement(toElement)
							.release(toElement).build();
					//buttonHandler.clickButton(PropertiesRepository.getString("asmt.generic.tutorial.dragbox2.loc"));
					atc2.perform();
					if (stop) {
						breakflag = true;
					}
					if (0 == btn.size() - 1) {
						breakflag = true;
					}
					Thread.sleep(1000);
				} catch (StaleElementReferenceException e) {
					logger.info("element in stale state countiniuing");
				}
			}
		} catch (Exception e) {
			throw new DriverException("Unable to Drag And Drop Answer in answer block itself", e);
		}
		logger.info("Method:  DragAndDropOneAnswersInAnswerBlock End --> ");
	}
	
	/**
	 * This method is used Drag And Drop Answer in Question block itself
	 * 
	 * @return boolean
	 * @throws DriverException
	 */
	public void DragAndDropOneAnswersInQuestionBlock(boolean stop) throws Exception {
		logger.info("DragAndDropOneAnswersInQuestionBlock Start");
		try {
			waitUntillBufferInvisible(PropertiesRepository.getString("asmt.pleasewait.bufferLoc"));
			logger.info("Method : DragAndDropOneAnswersInQuestionBlock :::::::: start");
			Actions act = new Actions(driver);
			boolean breakflag = false;

			switchToAssessmentFrameHandler();
			if (baseHandler.isDisplayed(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc"))) {
				System.out.println(
						baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc"))
								.findElements(By.cssSelector("li")).size());
				List<WebElement> btn = baseHandler
						.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc"))
						.findElements(By.cssSelector("li"));
				try {
					wait.until(ExpectedConditions.elementToBeClickable(btn.get(0)));
					WebElement toElement = btn.get(3);
					org.openqa.selenium.interactions.Action atc2 = act.clickAndHold(btn.get(0)).moveToElement(toElement)
							.release(toElement).build();
					//buttonHandler.clickButton(PropertiesRepository.getString("asmt.generic.tutorial.dragbox2.loc"));
					atc2.perform();
					if (stop) {
						breakflag = true;
					}
					if (0 == btn.size() - 1) {
						breakflag = true;
					}
					Thread.sleep(1000);
				} catch (StaleElementReferenceException e) {
					logger.info("element in stale state countiniuing");
				}
			}
		} catch (Exception e) {
			throw new DriverException("Unable to Drag And Drop in Question block itself", e);
		}
		logger.info("Method:  DragAndDropOneAnswersInQuestionBlock End --> ");
	}
	
	
	
	public boolean viewResultFlag() throws Exception {
		logger.info("Method : viewResultFlag -->start");
		boolean flag = false;
		try {
			windowHandler.switchToModalDialog();
			if (baseHandler
					.findElement("#RevisitFlaggedQuestionDialog button[class='button default-button']") != null) {
				flag = true;
				baseHandler
						.findElement(
								"#RevisitFlaggedQuestionDialog button[class='button default-button']")
						.click();
				Thread.sleep(2000);
				// click on view result button
				waitUntillBufferInvisible(PropertiesRepository
						.getString("asmt.pleasewait.bufferLoc"));
				// windowHandler.switchToModalDialog();
				Thread.sleep(2000);
				buttonHandler.clickButton(PropertiesRepository
						.getString("new-atitesting.test.view.resultsLoc"));
				// click on view result button
				Thread.sleep(2000);
				waitUntillBufferInvisible(PropertiesRepository
						.getString("asmt.pleasewait.bufferLoc"));
				windowHandler.switchToModalDialog();
				buttonHandler
						.clickButton(PropertiesRepository
								.getString("new-atitesting.generic.contiunuetestcomplete.value"));
			}
		} catch (Exception e) {
			logger.info("Unable to verify complete assesment dialog");
			throw new DriverException(
					"Unable to verify the cpomplete aseesment dailog", e);
		}
		logger.info("Method : viewResultFlag -->end");
		return flag;
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
	
	public boolean completeDialogVerifier() throws Exception {
		logger.info("Method : completeDialogVerifier -->start");
		boolean flag = false;
		try {
			if (baseHandler
					.findElement("#CompleteAssessmentDialog div .button.secondary-button") != null
					&& baseHandler
							.findElement("#CompleteAssessmentDialog div .button.secondary-button") != null
					&& baseHandler
							.findElement("#CompleteAssessmentDialog div .button.default-button") != null) {
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to verify complete assesment dialog");
			throw new DriverException(
					"Unable to verify the cpomplete aseesment dailog", e);
		}
		logger.info("Method : completeDialogVerifier -->end");
		return flag;

	}
	
	/**
	 * This method is used to create practice Assessment
	 * boolean return true for Survey : if Complete Post Assessment Survey is triggered
	 * @author Sagar.Rao
	 * 
	 * @throws InterruptedException
	 * 
	 * @throws DriverException
	 */
	public boolean takeAssessment(boolean bool, boolean flagquestion, String complButtonName)
			throws InterruptedException, DriverException {
		logger.info("takeAssessment starts");
		boolean isSurveyLoaded= false; 
		try {
			waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");//waitUntillBufferInvisible(PropertiesRepository.getString("asmt.pleasewait.bufferLoc"));
			switchToAssessmentFrameHandler();
			//Thread.sleep(3000);
			if (bool) {
				//Thread.sleep(500);
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
			List<WebElement> assessmentCompleteElement = baseHandler.findElements(".complete-assessment-dialog div button");
			if(CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
					int size = assessmentCompleteElement.size();
					for(int intSize = 0; intSize < size; intSize++) {
						WebElement quizCompElement = assessmentCompleteElement.get(intSize);
						if(quizCompElement.getText().trim().contains("Finalize and View Results")) {
							quizCompElement.click();
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
							//waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
							//waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
							break;
						}
						//Handling Sections for TEAS Proctor
						else if(quizCompElement.getText().trim().contains("Proceed to Next Section")) {
							quizCompElement.click();
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");							
						}
						else if(quizCompElement.getText().trim().contains("Complete Post Assessment Survey")) {
							quizCompElement.click();
							isSurveyLoaded = true;
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");											
						}
						
					}
				}

			if (flagquestion) {
				viewResultFlag();
			}
			//waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
			logger.info("takeAssessment Ends");
		} catch (Exception e) {
			throw new DriverException("Unable to take practice Assessment", e);
		}
		return isSurveyLoaded;
	}
	
		
	/**
	 * This method is used to complete incomplete Quiz and relaunch that Quiz.
	 * 
	 * @author syed.pasha
	 * @throws InterruptedException
	 */
	public void completeContinueStateQuiz(String assessmentType,String assessmentName) throws Exception {
		logger.info("Method : completeContinueStateQuiz :::::::: Starts");
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
				
			}else if(minCount>=(maxCount/2)){
				flag1=true;
				for (int i = 0; i <= count; i++) {
				clickButton(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"), 0);
				waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
				
				List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
				if(CollectionUtils.isNotEmpty(rationalContinue)) {
					rationalContinue.get(0).sendKeys(Keys.ENTER);
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");					
					}
					if(driver.findElements( By.cssSelector(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc")) ).size() != 0)
					{
						clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
					}				
				}	
			}
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			if(flag1==true){
			// Checking for Assessment Completed Popup
			//List<WebElement> assessmentCompleteElement = baseHandler.findElements(".modal-section div button"); .complete-assessment-dialog div button
				List<WebElement> assessmentCompleteElement = baseHandler.findElements(".complete-assessment-dialog div button"); 
			if(CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
				takeAssessment(false, false,"Finalize and View Results");
			}
			}
			//Click on continue if 'Review flag question pop-up is shown
			try{
				if(baseHandler.findElement(".revisit-flagged-questions-dialog").isDisplayed())
				{
					clickButton(".revisit-flagged-questions-dialog button", 0);
				}				
			}catch(Exception e) {
				logger.info("unable to Click on continue if 'Review flag question pop-up is shown" + e);
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
				new AssessmentPage(driver).clickTestTabAssessmentButtonNew(assessmentType,assessmentName);
			}
			windowHandler.switchToLatestWindow();
			logger.info("Method : completeContinueStateQuiz :::::::: Ends");
		}catch(DriverException e) {
			logger.info("unable to take Quiz" + e);
			
		}
	}
	
	/**
	 * Method is used to complete Test
	 * 
	 * breakFlag If assessment has to be stopped in middle.
	 * 
	 * rationaleFlag Need to check for Rationale and My Answer.
	 * 
	 * shoulCompleteTheSection if true will Proceed to next section, if false will stop the execution after answering all question.
	 * 
	 * @param bool
	 * @param breakFlag
	 * @param rationaleFlag
	 * @throws Exception
	 */
	public boolean takeTest(boolean bool, boolean breakFlag, boolean rationaleFlag, boolean flagquestion,
			boolean shoulCompleteTheSection) throws Exception {

		logger.info("Method : takeTest :::::::: Starts");
		int intExhibitCount = 0;
		boolean flag = false;
		boolean exhibitFlag = false;
		boolean boolExhibitFlag = false;
		boolean boolExhibitHeader = false;
		try {

			waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
			switchToAssessmentFrameHandler();
			// Getting Total Question Number
			String maxQtnTextNo = baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(1).getText();

			// Convert String to Integer
			int maxCount = Integer.parseInt(maxQtnTextNo);

			// Getting Current Question Number
			String minQtnTextNo = baseHandler
					.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(0).getText();

			// Convert String to Integer
			int minCount = Integer.parseInt(minQtnTextNo);

			// Maximum Question minus Minimum Questions
			int count = maxCount - minCount;

			for (int i = 0; i <= count; i++) {

				List<WebElement> checkBoxElement = driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.tutorial.checkbox.new.loc")));				
				if (CollectionUtils.isNotEmpty(checkBoxElement) && checkBoxElement.get(0).isDisplayed()) {
					checkBoxElement.get(0).click();					
				}

				List<WebElement> imgTextElement = driver.findElements(By.cssSelector("div[class='free-form-question-container'] .answer-fill-in-the-blank.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty"));
				if (CollectionUtils.isNotEmpty(imgTextElement) && imgTextElement.get(0).isDisplayed()) {
					imgTextElement.get(0).sendKeys("10");
				}

				List<WebElement> textBoxElement = driver.findElements(By.cssSelector("input[id^='fillIn']"));
				if (CollectionUtils.isNotEmpty(textBoxElement) && textBoxElement.get(0).isDisplayed()) {
					verifyFillForm("10");
				}

				List<WebElement> textBoxElement2 = driver.findElements(By.cssSelector("#fillInNumericAnswer"));
				if (CollectionUtils.isNotEmpty(textBoxElement2) && textBoxElement2.get(0).isDisplayed()) {
					verifyFillForm("10");
				}

				// Text Area
				List<WebElement> textAreaElement = driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.maint.textarea.loc")));
				if (CollectionUtils.isNotEmpty(textAreaElement) && textAreaElement.get(0).isDisplayed()) {
					textAreaElement.get(0).sendKeys("100");
				}

				if (CollectionUtils.isNotEmpty(driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc"))))) {
					DragAndDropAnswer(false);
				}
				
				if (CollectionUtils.isNotEmpty(driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.question.img.loc"))))) {
					hotSpotQuestion();
				}

				if (i == count) {
					switchToAssessmentFrameHandler();
					List<WebElement> buttonElement = baseHandler.findElements(
							PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
					if (CollectionUtils.isNotEmpty(buttonElement)) {
						if (buttonElement.get(0).isDisplayed()) {
							WebElement continueButtonElement = driver
									.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
							if (continueButtonElement != null) {
								continueButtonElement.sendKeys(Keys.ENTER);
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								// Used to Handle Question Unanswered Popup
								if (driver.findElements(By.cssSelector(PropertiesRepository
												.getString("asmt.myati.assessment.question.unanswered.close.loc")))
										.size() != 0) {
									clickButton(PropertiesRepository
											.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
									clickAssessmemtType();
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								}
							}
						}
					}
					if (shoulCompleteTheSection) {
						takeAssessment(rationaleFlag, flagquestion, "Finalize and View Results");
					}
					if (rationaleFlag && !(shoulCompleteTheSection)) {
						waitUntillElementIsVisible(PropertiesRepository.getString("asmt.rational.page.ques.status.loc"));
						//Waiting  for element is not working
						Thread.sleep(2000);
						List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
						if (CollectionUtils.isNotEmpty(rationalContinue)) {
							rationalContinue.get(0).sendKeys(Keys.ENTER);							
						}
					}
					logger.info("After answering all the questions and handling final popup");
					flag = true;
				} else {
					if (i == 0 && flagquestion) {
						switchToAssessmentFrameHandler();
						verifyFlag(true);
						logger.info("Question has been flaged");
						Thread.sleep(4000);
					} else {
						// waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						switchToAssessmentFrameHandler();
						waitUntillElementIsVisible(
								PropertiesRepository.getString("asmt.generic.tutorial.submit.new.loc"));
						List<WebElement> buttonElement = baseHandler.findElements(
								PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
						if (CollectionUtils.isNotEmpty(buttonElement)) {
							if (buttonElement.get(0).isDisplayed()) {
								WebElement continueButtonElement = driver
										.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
								if (continueButtonElement != null) {
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									// Used to Handle Question Unanswered Popup
									if (driver
											.findElements(By.cssSelector(PropertiesRepository
													.getString("asmt.myati.assessment.question.unanswered.close.loc")))
											.size() != 0) {
										clickButton(PropertiesRepository
												.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
										clickAssessmemtType();
										continueButtonElement.sendKeys(Keys.ENTER);
										waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									}
								}
							}
						}
					}
					if (rationaleFlag) {
						// waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
						List<WebElement> rationalContinue = driver
								.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
						if (CollectionUtils.isNotEmpty(rationalContinue)) {
							rationalContinue.get(0).sendKeys(Keys.ENTER);
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						}
					}
					if (breakFlag) {
						logger.info("After answering single questions inside breakFlag");
						flag = true;
						break;
					}
				}
			}
		} catch (DriverException e) {
			logger.info("unable to take Assessment" + e);
		}
		waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		waitUntillBufferInvisible(PropertiesRepository.getString("asmt.pleasewait.bufferLoc"));
		logger.info("Method : takeTest :::::::: END flag --> " + flag);
		return flag;
	}	
	
	/**
	 * Method is used to Answer Only One Question Test
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
	public boolean takeTest_AnswerOnlyOneQuestion(boolean bool, boolean breakFlag,
			boolean rationaleFlag, boolean flagquestion) throws Exception {
		
		logger.info("Method : takeTest_AnswerOnlyOneQuestion :::::::: Starts");
		int intExhibitCount = 0;
		boolean flag = false;
		boolean exhibitFlag = false;
		boolean boolExhibitFlag = false;
		boolean boolExhibitHeader = false;
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

			for (int i = 0; i <1 ; i++) {
				
				List<WebElement> checkBoxElement = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.checkbox.new.loc"));
				List<WebElement> radioElement = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.radio.button.new.loc"));
				
				if (checkBoxElement != null) {
					checkBoxElement.get(0).click();
					checkBoxElement.get(1).click();
					checkBoxElement.get(2).click();
				}

			
				List<WebElement> imgTextElement = driver.findElements(By.cssSelector("div[class='free-form-question-container'] .answer-fill-in-the-blank.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty"));
				if(CollectionUtils.isNotEmpty(imgTextElement) && imgTextElement.get(0).isDisplayed()) {
					imgTextElement.get(0).sendKeys("10");
				}
				
				List<WebElement> textBoxElement = driver.findElements(By.cssSelector("input[id^='fillIn']"));
				if (CollectionUtils.isNotEmpty(textBoxElement) && textBoxElement.get(0).isDisplayed()) {
					verifyFillForm("10");
				}				
				
				List<WebElement> textBoxElement2 = driver.findElements(By.cssSelector("#fillInNumericAnswer"));
				if (CollectionUtils.isNotEmpty(textBoxElement2) && textBoxElement2.get(0).isDisplayed()) {
					verifyFillForm("10");
				}

				// Text Area
				List<WebElement> textAreaElement = baseHandler.findElements(PropertiesRepository.getString("asmt.maint.textarea.loc"));
				if(CollectionUtils.isNotEmpty(textAreaElement) && textAreaElement.get(0).isDisplayed()) {
					textAreaElement.get(0).sendKeys("100");
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
								// Used to Handle Question Unanswered Popup
								if (driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"))).size() != 0) {
									clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
									clickAssessmemtType();
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								}
							}
						}
					}
					takeAssessment(rationaleFlag, flagquestion,"Finalize and View Results");
					logger.info("After answering all the questions and handling final popup");
					flag = true;
				} else {
					if (i == 0 && flagquestion) {
						switchToAssessmentFrameHandler();
						verifyFlag(true);
						logger.info("Question has been flaged");
						Thread.sleep(4000);
					} else {
						//waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
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
									// Used to Handle Question Unanswered Popup
									if (driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"))).size() != 0) {
										clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
										clickAssessmemtType();
										continueButtonElement.sendKeys(Keys.ENTER);
										waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									}
								}
							}
						}
						logger.info("After answering One Question");
						flag = true;											
					}
					if (rationaleFlag) {
						//waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
						List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
						if(CollectionUtils.isNotEmpty(rationalContinue)) {
							rationalContinue.get(0).sendKeys(Keys.ENTER);
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						}
					}

					
					if (breakFlag) {
						logger.info("After answering single questions inside breakFlag");
						flag = true;
						break;
					}
				}
			}
		} catch (DriverException e) {
			logger.info("unable to take ITR Proctor Assessment" + e);
		}
		waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		waitUntillBufferInvisible(PropertiesRepository
				.getString("asmt.pleasewait.bufferLoc"));
		logger.info("Method : takeTest_AnswerOnlyOneQuestion :::::::: END flag --> " + flag);
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
	public boolean takeTestFlag(boolean bool, boolean breakFlag,
			boolean rationaleFlag, boolean flagquestion) throws Exception {
		
		logger.info("Method : takeTestFlag :::::::: Starts ");
		int intExhibitCount = 0;
		boolean flag = false;
		boolean exhibitFlag = false;
		boolean boolExhibitFlag = false;
		boolean boolExhibitHeader = false;
		
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
				boolean flagButton = false;
				if(i < 5) {
					// Clicking on Flag Button. 
					clickButton(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"), 0);
					flagButton = true;
				} else {
					List<WebElement> checkBoxElement = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.checkbox.new.loc"));
					List<WebElement> radioElement = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.radio.button.new.loc"));
					
					if (checkBoxElement != null) {
						checkBoxElement.get(0).click();
						
					}

					if (checkBoxElement != null && !exhibitFlag) {
						
						if(intExhibitCount != 1) {
							// Verifying Exhibit Button
							boolExhibitFlag = verifyExhibitButton(true);
							if (boolExhibitFlag) {
								checkBoxElement.get(0).click();
								checkBoxElement.get(1).click();
								intExhibitCount++;
								if (intExhibitCount == 1) {
									// Verifying Exhibit Header asmt.itr.exhibit.header.loc
									boolExhibitHeader = verifyElementWithSwitchWindow(PropertiesRepository.getString("asmt.itr.exhibit.header.loc"));
									if (boolExhibitHeader) {
										clickButton(PropertiesRepository.getString("asmt.myati.assessment.exhibit.close.button.loc"),0);
										flag = true;
										exhibitFlag = true;
									}
								}
							}
						}
					}

					List<WebElement> imgTextElement = driver.findElements(By.cssSelector("div[class='free-form-question-container'] .answer-fill-in-the-blank.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty"));
					if(CollectionUtils.isNotEmpty(imgTextElement) && imgTextElement.get(0).isDisplayed()) {
						imgTextElement.get(0).sendKeys("10");
					}
					
					//List<WebElement> textBoxElement = driver.findElements(By.cssSelector(".answer-fill-in-the-blank.numericTextEntry.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty"));
					List<WebElement> textBoxElement = driver.findElements(By.cssSelector("input[id^='fillIn']"));

					if (CollectionUtils.isNotEmpty(textBoxElement) && textBoxElement.get(0).isDisplayed()) {
						verifyFillForm("10");
					}

					// Text Area
					List<WebElement> textAreaElement = baseHandler.findElements(PropertiesRepository.getString("asmt.maint.textarea.loc"));
					if(CollectionUtils.isNotEmpty(textAreaElement) && textAreaElement.get(0).isDisplayed()) {
						textAreaElement.get(0).sendKeys("100");
					}
					
					if (CollectionUtils.isNotEmpty(baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc")))) {
						//DragAndDropAnswer(false);
						// Clicking on Flag Button. 
						clickButton(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"), 0);
						flagButton = true;
					}

					if (CollectionUtils.isNotEmpty(radioElement) && radioElement.size() > 0) {
						radioElement.get(0).click();
					}

					if (CollectionUtils.isNotEmpty(baseHandler.findElements(PropertiesRepository.getString("asmt.question.img.loc")))) {
						hotSpotQuestion();
					}
				//}
				

				if (i == count) {
					switchToAssessmentFrameHandler();
					List<WebElement> buttonElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
					if(CollectionUtils.isNotEmpty(buttonElement)) {
						if(buttonElement.get(0).isDisplayed()) {
							WebElement continueButtonElement = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
							if(continueButtonElement != null) {
								continueButtonElement.sendKeys(Keys.ENTER);
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								// Used to Handle Question Unanswered Popup
								if (driver
										.findElements(By.cssSelector(PropertiesRepository
												.getString("asmt.myati.assessment.question.unanswered.close.loc")))
										.size() != 0) {
									clickButton(PropertiesRepository
											.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
									clickAssessmemtType();
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								}
								
							}
						}
					}
					takeAssessment(rationaleFlag, flagquestion,"Review Flagged ");
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
									// Used to Handle Question Unanswered Popup
									if (driver
											.findElements(By.cssSelector(PropertiesRepository
													.getString("asmt.myati.assessment.question.unanswered.close.loc")))
											.size() != 0) {
										clickButton(PropertiesRepository
												.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
										clickAssessmemtType();
										continueButtonElement.sendKeys(Keys.ENTER);
										waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									}
								}
							}
						}
					}
					if(!flagButton) {
						if (rationaleFlag) {
							waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
							List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
							if(CollectionUtils.isNotEmpty(rationalContinue)) {
								rationalContinue.get(0).sendKeys(Keys.ENTER);
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								if(driver.findElements( By.cssSelector(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc")) ).size() != 0)
								{
									clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
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
		} catch (DriverException e) {
			logger.info("unable to take assessment" + e);
		}
		waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		waitUntillBufferInvisible(PropertiesRepository
				.getString("asmt.pleasewait.bufferLoc"));
		logger.info("Method : takeTestFlag :::::::: END flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to verify question no is proctor assessment. 
	 * 
	 * @return
	 * @throws DriverException
	 */
	public boolean verifyQuestionNos() throws DriverException {
		logger.info("Method: verifyQuestionNos Starts");
		boolean flag = false;
    	try {
    		//Thread.sleep(30000);
    		windowHandler.switchToMainWindow();
    		waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
			windowHandler.switchToFrame("assessmentFrame");
    		List<WebElement> maxQuestElement = baseHandler.findElements(PropertiesRepository.getString("asmt.question.no.loc1.new"));
    		if(CollectionUtils.isNotEmpty(maxQuestElement)) {
    			flag = true;
    		}
    	} catch (Exception e) {
    		logger.info("Unable to verifyQuestionNos");
			log(logger, "Unable to verifyQuestionNos" );
    		throw new DriverException("Unable to verifyQuestionNos" , e); 
    	}
    	logger.info("Method: verifyQuestionNos End flag --> " + flag);
    	return flag;
	}
	
	/**
	 * Method used to click on Practice Card Front button.
	 * 
	 * @param assessmentType
	 *            - Practice
	 * @param assessmentName
	 *            - Assessment Name
	 * @param anyButtonName
	 *            - boolean value Any button(false) or specific button(true)
	 *            like (Begin/ Continue/ Retake)
	 * @param buttonName
	 *            - If anyButtonName false, it click on button displayed. if
	 *            anyButtonName true, it verifies the button and click
	 * @throws Exception
	 */
	public void clickTestTabAssessmentButtonNew(String assessmentType, String assessmentName) throws Exception {
		logger.info("Method: clickTestTabAssessmentButtonNew Starts ");
		boolean breakFlag = false;
		try {
			waitUntillElementIsVisible(PropertiesRepository.getString("asmt.myati.test.tab.verify.details.are.displaye.loc"));
			if (baseHandler.isDisplayed(PropertiesRepository.getString("asmt.myati.test.tab.verify.details.are.displaye.loc"))) {
				List<WebElement> pracProcCardElement = baseHandler.findElements(PropertiesRepository.getString("asmt.myati.test.tab.verify.details.are.displaye.loc"));
				if (CollectionUtils.isNotEmpty(pracProcCardElement)) {
					int size = pracProcCardElement.size();
					mainloop:for (int index = 0; index < size; index++) {
						if (breakFlag) {
							break;
						}
						WebElement assessmentTypeElement = pracProcCardElement.get(index);
						// Validating Assessment Type
						WebElement assessmentTypeSingleElement = null;
						if(assessmentTypeElement.findElements(By.cssSelector(PropertiesRepository.getString("asmt.myati.test.tab.assessment.type.loc"))).size() != 0)
						{	
							assessmentTypeSingleElement = assessmentTypeElement.findElement(By.cssSelector(PropertiesRepository.getString("asmt.myati.test.tab.assessment.type.loc")));
						}
						if (assessmentTypeSingleElement != null) {
							String assessmentTypeValue = assessmentTypeSingleElement.getText().trim();
							if (StringUtils.isNotEmpty(assessmentTypeValue)
									&& assessmentTypeValue.equalsIgnoreCase(assessmentType)) {
								// Validating Assessment Name
								WebElement assessmentNameElement = assessmentTypeElement.findElement(By.cssSelector(
										PropertiesRepository.getString("asmt.myati.test.tab.assessment.name.loc")));
								if (assessmentNameElement != null) {
									String assessmentNameValue = assessmentNameElement.getText().trim().replaceAll("\\r\\n|\\r|\\n", " ");
									String assNameIndex= assessmentNameElement.getAttribute("id");
									if (StringUtils.isNotEmpty(assessmentNameValue)	&& assessmentNameValue.equalsIgnoreCase(assessmentName)) {										
										List<WebElement> buttonList = baseHandler.findElements("a[id$='" +assNameIndex.substring(assNameIndex.length() - 1) +"']");
										for (int i = 0; i < buttonList.size(); i++) {
											if(buttonList.get(i).isDisplayed()){
												buttonList.get(i).click();
												break mainloop;
											}											
										}
									} 
										 /** else { log(logger,
										 * "Assessment Name is not matched");
										 * breakFlag = true; }*/
										 
							}
							} else {
								log(logger, "Assessment Type is not matched");
								breakFlag = true;
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

		logger.info("Method: clickTestTabAssessmentButtonNew End ");
	}
	
	/**
	 * Method used to click on Proctor Card Front button.
	 * 
	 * @param assessmentType  Proctor
	 * 
	 * @param assessmentName
	 *            - Assessment Name
	 * @param anyButtonName
	 *            - boolean value Any button(false) or specific button(true)
	 *            like (Begin/ Continue/ Retake)
	 * @param buttonName
	 *            - If anyButtonName false, it click on button displayed. if
	 *            anyButtonName true, it verifies the button and click
	 * @throws Exception
	 */
	public void clickTestTabProctorButtonNew(String assessmentType, String assessmentName) throws Exception {
		logger.info("Method: clickTestTabProctorButtonNew Starts");
		boolean breakFlag = false;
		try {	
			String cssSelector = "";
			if(baseHandler.findElements("#monitoredProducts").size() != 0 && baseHandler.findElement("#monitoredProducts").isDisplayed())			
			{
				cssSelector = PropertiesRepository.getString("asmt.myati.test.tab.proctor.loc");
			}
			else
			{
				cssSelector = PropertiesRepository.getString("asmt.myati.test.tab.verify.details.are.displaye.loc");
			}
			waitUntillElementIsVisible(cssSelector);
			if (baseHandler.isDisplayed(cssSelector)) {
				List<WebElement> pracProcCardElement = baseHandler.findElements(cssSelector);
				if (CollectionUtils.isNotEmpty(pracProcCardElement)) {
					int size = pracProcCardElement.size();
					mainloop:for (int index = 0; index < size; index++) {
						if (breakFlag) {
							break;
						}
						WebElement assessmentTypeElement = pracProcCardElement.get(index);
						// Validating Assessment Type
						WebElement assessmentTypeSingleElement = null;
						if(assessmentTypeElement.findElements(By.cssSelector("section[class='card proctored-assessment front'] header span")).size() != 0)
						{
							assessmentTypeSingleElement = assessmentTypeElement.findElement(By.cssSelector("section[class='card proctored-assessment front'] header span"));
						}
						if (assessmentTypeSingleElement != null) {
							String assessmentTypeValue = assessmentTypeSingleElement.getText().trim();
							if (StringUtils.isNotEmpty(assessmentTypeValue)
									&& assessmentTypeValue.equalsIgnoreCase(assessmentType)) {
								// Validating Assessment Name
								/*WebElement assessmentNameElement = assessmentTypeElement.findElement(By.cssSelector(
										PropertiesRepository.getString("asmt.myati.test.tab.assessment.name.loc")));*/
								WebElement assessmentNameElement = assessmentTypeElement.findElement(By.cssSelector("section[class='card proctored-assessment front'] section div"));
								if (assessmentNameElement != null) {
									String assessmentNameValue = assessmentNameElement.getText().trim().replaceAll("\\r\\n|\\r|\\n", " ");
									//String assNameIndex= assessmentNameElement.getAttribute("id");
									if (StringUtils.isNotEmpty(assessmentNameValue)	&& assessmentNameValue.equalsIgnoreCase(assessmentName)) {										
										List<WebElement> buttonList = baseHandler.findElements("section[class='card proctored-assessment front'] .button.primary-button.button-focus.focus-element-flag");
										for (int i = 0; i < buttonList.size(); i++) {
											if(!(buttonList.get(i).getAttribute("style").equalsIgnoreCase("display: none;"))){
												buttonList.get(i).click();
												break mainloop;
											}											
										}
									} 
										 /** else { log(logger,
										 * "Assessment Name is not matched");
										 * breakFlag = true; }*/
										 
							}
							} else {
								log(logger, "Proctor Assessment Type is not matched");
								breakFlag = true;
							}
						}
					}

				}
			}
		} catch (Exception e) {
			logger.info("Unable to click Test Tab Proctor Assessment Button");
			log(logger, "Unable to click Test Tab Proctor Assessment Button");
			throw new DriverException("Unable to click Test Tab Proctor Assessment Button", e);
		}

		logger.info("Method: clickTestTabProctorButtonNew End");
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
	public boolean takeTestFlagFirst5CheckExhibitAndPopup(boolean bool, boolean breakFlag,
			boolean rationaleFlag, boolean flagquestion) throws Exception {
		
		logger.info("Method : takeTestFlagFirst5CheckExhibitAndPopup :::::::: Starts ");
		int intExhibitCount = 0;
		boolean flag = false;		
		boolean boolExhibitFlag = false;
		boolean boolExhibitHeader = false;
		boolean exhibitFlag = false;
		boolean popup = false;
		
		
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
				boolean flagButton = false;
				if(i < 5) {
										
					//Checking Exhibit
					List<WebElement> checkBoxElement = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.checkbox.new.loc"));
					//Verify if Exhibit is displayed at least for one question
					if (checkBoxElement != null && !exhibitFlag) {						
						if(intExhibitCount != 1) {
							// Verifying Exhibit Button
							boolExhibitFlag = verifyExhibitButton(true);
							if (boolExhibitFlag) {
								flag = true;
								exhibitFlag = true;
								clickButton(PropertiesRepository.getString("asmt.myati.assessment.exhibit.close.button.loc"),0);
							}
						}
					}

					// Clicking on Flag Button. 
					clickButton(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"), 0);
					flagButton = true;
				} else {
					List<WebElement> checkBoxElement = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.checkbox.new.loc"));
					List<WebElement> radioElement = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.radio.button.new.loc"));
					
					if (checkBoxElement != null) {
						checkBoxElement.get(0).click();						
					}

					//Checking Exhibit
					/*if (checkBoxElement != null && !exhibitFlag) {						
						if(intExhibitCount != 1) {
							// Verifying Exhibit Button
							boolExhibitFlag = verifyExhibitButton(true);
							if (boolExhibitFlag) {
								checkBoxElement.get(0).click();
								checkBoxElement.get(1).click();
								intExhibitCount++;
								if (intExhibitCount == 1) {
									// Verifying Exhibit Header asmt.itr.exhibit.header.loc
									boolExhibitHeader = verifyElementWithSwitchWindow(PropertiesRepository.getString("asmt.itr.exhibit.header.loc"));
									if (boolExhibitHeader) {
										clickButton(PropertiesRepository.getString("asmt.myati.assessment.exhibit.close.button.loc"),0);
										flag = true;
										exhibitFlag = true;
									}
								}
							}
						}
					}*/
					
					//Verify if Exhibit is displayed at least for one question
					if (checkBoxElement != null && !exhibitFlag) {						
						if(intExhibitCount != 1) {
							// Verifying Exhibit Button
							boolExhibitFlag = verifyExhibitButton(true);
							if (boolExhibitFlag) {
								flag = true;
								exhibitFlag = true;
								clickButton(PropertiesRepository.getString("asmt.myati.assessment.exhibit.close.button.loc"),0);
							}
						}
					}

					List<WebElement> imgTextElement = driver.findElements(By.cssSelector("div[class='free-form-question-container'] .answer-fill-in-the-blank.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty"));
					if(CollectionUtils.isNotEmpty(imgTextElement) && imgTextElement.get(0).isDisplayed()) {
						imgTextElement.get(0).sendKeys("10");
					}
					
					//List<WebElement> textBoxElement = driver.findElements(By.cssSelector(".answer-fill-in-the-blank.numericTextEntry.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty"));
					List<WebElement> textBoxElement = driver.findElements(By.cssSelector("input[id^='fillIn']"));

					if (CollectionUtils.isNotEmpty(textBoxElement) && textBoxElement.get(0).isDisplayed()) {
						verifyFillForm("10");
					}

					// Text Area
					List<WebElement> textAreaElement = driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.maint.textarea.loc")));
					if(CollectionUtils.isNotEmpty(textAreaElement) && textAreaElement.get(0).isDisplayed()) {
						textAreaElement.get(0).sendKeys("100");
					}
					
					if (CollectionUtils.isNotEmpty(driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc"))))) {
						DragAndDropAnswer(false);
						// Clicking on Flag Button. 
						/*clickButton(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"), 0);
						flagButton = true;*/
					}

					if (CollectionUtils.isNotEmpty(radioElement) && radioElement.size() > 0) {
						radioElement.get(0).click();
					}

					if (CollectionUtils.isNotEmpty(driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.question.img.loc"))))) {
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
								if(rationaleFlag){
									continueButtonElement.sendKeys(Keys.ENTER);
									// Used to Handle Question Unanswered Popup
									if (driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"))).size() != 0) {
										clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
										clickAssessmemtType();
										continueButtonElement.sendKeys(Keys.ENTER);
										waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									}
								}
							}
						}
					}
					
					//Verifying "Assessment Completed" pop up if displaying 3 options
					waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
					waitUntillElementIsVisible(".complete-assessment-dialog div button");
					List<WebElement> assessmentCompleteElement = baseHandler.findElements(".complete-assessment-dialog div button");
					
					popup = assessmentCompleteElement.get(0).getText().contains("Review Flagged Questions") && assessmentCompleteElement.get(1).getText().contains("Go Back to Last Question") && assessmentCompleteElement.get(2).getText().contains("Finalize and View Results");

					
				} else {
					if (i == 0 && flagquestion) {
						switchToAssessmentFrameHandler();
						verifyFlag(true);
						logger.info("Question has been flaged");
						Thread.sleep(4000);
					} else {
						//waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						switchToAssessmentFrameHandler();
						waitUntillElementIsVisible(PropertiesRepository.getString("asmt.generic.tutorial.submit.new.loc"));
						List<WebElement> buttonElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
						if(CollectionUtils.isNotEmpty(buttonElement)) {
							if(buttonElement.get(0).isDisplayed()) {
								WebElement continueButtonElement = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
								if(continueButtonElement != null) {
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									// Used to Handle Question Unanswered Popup
									if (driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"))).size() != 0) {
										clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
										clickAssessmemtType();
										continueButtonElement.sendKeys(Keys.ENTER);
										waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									}
								}
							}
						}
					}
					if(!flagButton) {
						if (rationaleFlag) {
							//waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
							List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
							if(CollectionUtils.isNotEmpty(rationalContinue)) {
								rationalContinue.get(0).sendKeys(Keys.ENTER);
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");								
							}
						}
					}					
					if (breakFlag) {
						break;
					}
				}			
			}
		} catch (DriverException e) {
			logger.info("unable to take assessment" + e);
		}
		waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		waitUntillBufferInvisible(PropertiesRepository.getString("asmt.pleasewait.bufferLoc"));
		logger.info("Method : takeTestFlagFirst5CheckExhibitAndPopup :::::::: END  [Is Exhibit Displayed  --> " + exhibitFlag + " ] [Is Popup Displaying 3 buttons  -->" + popup + " ]");
		return (exhibitFlag && popup);
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
	public boolean takeTestUnFlag(boolean bool, boolean breakFlag,
			boolean rationaleFlag, boolean flagquestion) throws Exception {
		
		logger.info("Method : takeTestUnFlag :::::::: Starts ");
		int intExhibitCount = 0;
		boolean flag = false;
		boolean exhibitFlag = false;
		boolean boolExhibitFlag = false;
		boolean boolExhibitHeader = false;
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
				
				List<WebElement> flagElement = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"));
				if(CollectionUtils.isNotEmpty(flagElement) && flagElement.get(0).isDisplayed()) {
					clickButton(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"), 0);
					
					List<WebElement> checkBoxElement = driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.tutorial.checkbox.new.loc")));
					List<WebElement> radioElement = driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.tutorial.radio.button.new.loc")));
					
					if (checkBoxElement != null) {
						checkBoxElement.get(0).click();
						
					}

					List<WebElement> imgTextElement = driver.findElements(By.cssSelector("div[class='free-form-question-container'] .answer-fill-in-the-blank.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty"));
					if(CollectionUtils.isNotEmpty(imgTextElement) && imgTextElement.get(0).isDisplayed()) {
						imgTextElement.get(0).sendKeys("10");
					}
					
					List<WebElement> textBoxElement = driver.findElements(By.cssSelector("input[id^='fillIn']"));
					if (CollectionUtils.isNotEmpty(textBoxElement) && textBoxElement.get(0).isDisplayed()) {
						verifyFillForm("10");
					}

					// Text Area
					List<WebElement> textAreaElement = driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.maint.textarea.loc")));
					if(CollectionUtils.isNotEmpty(textAreaElement) && textAreaElement.get(0).isDisplayed()) {
						textAreaElement.get(0).sendKeys("100");
					}
					
					if (CollectionUtils.isNotEmpty(driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc"))))) {
						DragAndDropAnswer(false);
					}

					if (CollectionUtils.isNotEmpty(radioElement) && radioElement.size() > 0) {
						radioElement.get(0).click();
					}

					if (CollectionUtils.isNotEmpty(driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.question.img.loc"))))) {
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
									// Used to Handle Question Unanswered Popup
									if (driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"))).size() != 0) {
										clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
										clickAssessmemtType();
										continueButtonElement.sendKeys(Keys.ENTER);
										waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									}									
								}
							}
						}
						takeAssessment(rationaleFlag, flagquestion,"Finalize and View Results");
						logger.info("After answering all the questions and handling final popup");
						flag = true;
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
										// Used to Handle Question Unanswered Popup
										if (driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"))).size() != 0) {
											clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
											clickAssessmemtType();
											continueButtonElement.sendKeys(Keys.ENTER);
											waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
										}
									}
								}
							}
						}
						if (rationaleFlag) {
						//	waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
							List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
								if (CollectionUtils.isNotEmpty(rationalContinue)) {
									rationalContinue.get(0).sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");									
								}
							}												
						if (breakFlag) {
							break;
						}
					}
				} else {
					takeAssessment(false, flagquestion,"Finalize and View Results");
					logger.info("After answering all the questions and handling final popup");
					flag = true;
					break;
				}
				
			}
		} catch (DriverException e) {
			logger.info("unable to take assessment" + e);
		}
		waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		waitUntillBufferInvisible(PropertiesRepository.getString("asmt.pleasewait.bufferLoc"));
		logger.info("Method : takeTestUnFlag :::::::: END flag --> " + flag);
		return flag;
	}
	
	/**
	 * This method is used to check the Assessment Pop up buttons buttons and click on the given button
	 * 
	 * @param loc
	 * @param size
	 * @return
	 * @throws DriverException
	 */
	public boolean isPopupButtonDisplayed(ArrayList<String> buttonList, String clickOnButton) throws DriverException {
		logger.info("Method: isPopupButtonDisplayed Start");
		boolean flag = false;
		ArrayList<String> actualButtonList = new ArrayList<String>();
		List<WebElement> assessmentCompleteElement = baseHandler.findElements(PropertiesRepository.getString("asmt.popup.buttons.loc"));
		try {
			// waitUntillElementIsVisible(PropertiesRepository.getString(loc));
			for (int i = 0; i < assessmentCompleteElement.size(); i++) {
				actualButtonList.add(assessmentCompleteElement.get(i).getText().replaceAll("\\d*$", "").trim());
			}
			Collections.sort(buttonList);
			Collections.sort(actualButtonList);
			if (buttonList.equals(actualButtonList)) {
				flag = true;
				// Click on the button
				for (int i = 0; i < assessmentCompleteElement.size(); i++) {
					WebElement quizCompElement = assessmentCompleteElement.get(i);
					if (quizCompElement.getText().trim().contains(clickOnButton)) {
						quizCompElement.click();
						waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
						break;
					}
				}
			}
		} catch (Exception e) {
			throw new DriverException("buttons are missing" + e);
		}
		logger.info("Method: isPopupButtonDisplayed End");
		return flag;
	}

	/*
	 * @author syed.pasha
	 */
	public boolean verifyResumeDenyNoAction(WebDriver proctorDriver) throws DriverException {
		logger.info("Method: verifyResumeDenyNoAction Start");
		boolean flag = false;		
		swithToProctorFrame(proctorDriver);
		List<WebElement> btnElements = proctorDriver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.proctor.resume.deny.noaction.button.loc")));
		
		try {
			if(btnElements != null && btnElements.get(0).getText().equals("Resume") && btnElements.get(1).getText().equals("Deny") && btnElements.get(2).getText().equals("No Action"))
			{
				flag = true;
			}			
		} catch (Exception e) {
			throw new DriverException("buttons are missing" + e);
		}
		logger.info("Method: verifyResumeDenyNoAction End");
		return flag;
	}

	/*
	 * @author syed.pasha
	 */
	public boolean createCheateEventVerifyPopupandClickResume(String verifyAndClickLocator, String btnName)
			throws DriverException {
		logger.info("Method: createCheateEventVerifyPopupandClickResume Start");
		boolean flag = false;		
		
		try {
		waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//Creating cheat even
		Actions action = new Actions(driver);
		action.sendKeys(Keys.F12);
		action.perform();
		
		waitUntillElementIsVisible(verifyAndClickLocator);
		List<WebElement> btnElements = baseHandler.findElements(verifyAndClickLocator);		
		if (btnElements != null && btnElements.get(0).isDisplayed()	&& btnElements.get(0).getText().contains(btnName)) {
			flag = true;
			btnElements.get(0).click();			
		} else {
			log(logger, "Issue in cheat event handling");
		}
		} catch (Exception e) {
			throw new DriverException("Issue in cheat event handling" + e);
		}
		logger.info("Method: createCheateEventVerifyPopupandClickResume End");
		return flag;
	}
	
	/*
	 * verifyAndClickLocator : locator of the popup button
	 * btnName : resume or stop button
	 * popupMsg : popup message
	 * buttonType : function or ctrl/esc
	 * ctrlKey : CONTROL keys
	 * fnKeys : function Keys
	 * numberOfPopups : how many popups will appear
	 * 
	 * @author syed.pasha
	 */
	public boolean createCheateEventVerifyPopupandAndMsg(String verifyAndClickLocator, String btnName, String popupMsg , String buttonType , String ctrlKey, Keys fnKeys, String numberOfPopups)
			throws DriverException {
		logger.info("Method: createCheateEventVerifyPopupandClickResume Start");
		boolean flag = false;		
		
		try {
		//waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//Creating cheat even
		if(buttonType.contains("function"))
		{
		Actions action = new Actions(driver);
		action.sendKeys(fnKeys).build().perform();		
		
		}	
		else if (buttonType.contains("escape")) {			
			switchToAssessmentFrameHandler();
			/*Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ESCAPE);*/
			Actions action = new Actions(driver);
			action.sendKeys(fnKeys).build().perform();	
		}
		else{
			switchToAssessmentFrameHandler();
			Actions action = new Actions(driver);
			String selectAll = Keys.chord(Keys.CONTROL, ctrlKey);
			action.sendKeys(selectAll).build().perform();
		}
		
		//Will enter only if I Understand Popup is displayed
		if (numberOfPopups.equals("2")) {
			windowHandler.switchToMainWindow();
			List<WebElement> btnElements2 = baseHandler.findElements(PropertiesRepository.getString("asmt.proctor.cheatevent.iUnderstand.btn.loc"));
			
			if (btnElements2 != null && btnElements2.get(0).isDisplayed()
					&& btnElements2.get(0).getAttribute("value").contains(PropertiesRepository.getString("asmt.cheatevent.popup.iUnderstand.btn"))
					&& baseHandler.findElement(PropertiesRepository.getString("asmt.cheatevent.iUnderstand.popup.msg.loc"))
							.getText().contains(PropertiesRepository.getString("asmt.cheatevent.popup.msg"))) {
				flag = true;
			btnElements2.get(0).click();
		}
		}
		switchToAssessmentFrameHandler();
		waitUntillElementIsVisible(verifyAndClickLocator);
		List<WebElement> btnElements = baseHandler.findElements(verifyAndClickLocator);		
			if (btnElements != null && btnElements.get(0).isDisplayed()
					&& btnElements.get(0).getText().contains(btnName)
					&& baseHandler.findElement(PropertiesRepository.getString("asmt.cheatevent.popup.msg.loc"))
							.getText().contains(popupMsg)) {
				flag = true;
			btnElements.get(0).click();
		} else {
			log(logger, "Issue in cheat event handling");
		}
		}catch (Exception e) {
			throw new DriverException("Issue in cheat event handling catch block" + e);
		}
		logger.info("Method: createCheateEventVerifyPopupandClickResume End");
		return flag;
	}
	
	/**
	 * Method is used Flag odd questions and answer even questions for assessment with 10 questions or more than 5 questions
	 * 
	 * Handles all types of questions
	 * 
	 * breakFlag If assessment has to be stopped in middle.
	 * 
	 * rationaleFlag Need to check for Rationale and My Answer.
	 * 
	 * flag_unflag if true, will Flag even questions and answer odd questions
	 * 
	 * flag_unflag if false, will answer all the questions by unflagging all the flagged questions
	 * 
	 * @param bool
	 * @param breakFlag
	 * @param rationaleFlag
	 * @throws Exception
	 */
	public boolean takeTestFlagOddQuesAnswerEvenQues_AlsoUnflag(boolean bool, boolean breakFlag,
			boolean rationaleFlag, boolean flag_unflag) throws Exception {
		
		logger.info("Method : takeTestFlagOddQuesAnswerEvenQues_AlsoUnflag :::::::: Starts");
		boolean flag = false;		
		try {

			//waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
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
			int count = maxCount - minCount +1;

			mainloop:for (int i = 1; i <= count; i++) {
				boolean flagButton = false;
				
				//If flag_unflag is true then it will flag all the odd  odd question numbers
				if ( (flag_unflag) && (!((i % 2) == 0))) {
					// Clicking on Flag Button for odd question numbers. 
					clickButton(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"), 0);
					WebElement continueButtonElement = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
					continueButtonElement.sendKeys(Keys.ENTER);
					Thread.sleep(2000);
					flagButton = true;
				} else {
					
					//If flag_unflag is false then it will click on un flag button
					if (!(flag_unflag)){
						List<WebElement> flagElement = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"));
						if(CollectionUtils.isNotEmpty(flagElement) && flagElement.get(0).isDisplayed()) {
						clickButton(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"), 0);
						}
					}
					
					//Covering a specific scenario to flag and answer at the same time.
					if ( (flag_unflag) && ((i == 4)) ) {
						Thread.sleep(2000);
						clickButton(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"), 0);
					}				
					
					Thread.sleep(3000);
					List<WebElement> checkBoxElement = driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.tutorial.checkbox.new.loc")));
					if (CollectionUtils.isNotEmpty(checkBoxElement) && checkBoxElement.get(0).isDisplayed()) {
						checkBoxElement.get(0).click();						
					}

					List<WebElement> imgTextElement = driver.findElements(By.cssSelector("div[class='free-form-question-container'] .answer-fill-in-the-blank.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty"));
					if (CollectionUtils.isNotEmpty(imgTextElement) && imgTextElement.get(0).isDisplayed()) {
						imgTextElement.get(0).sendKeys("10");
					}

					List<WebElement> textBoxElement = driver.findElements(By.cssSelector("input[id^='fillIn']"));
					if (CollectionUtils.isNotEmpty(textBoxElement) && textBoxElement.get(0).isDisplayed()) {
						verifyFillForm("10");
					}

					List<WebElement> textBoxElement2 = driver.findElements(By.cssSelector("#fillInNumericAnswer"));
					if (CollectionUtils.isNotEmpty(textBoxElement2) && textBoxElement2.get(0).isDisplayed()) {
						verifyFillForm("10");
					}

					// Text Area
					List<WebElement> textAreaElement = driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.maint.textarea.loc")));
					if (CollectionUtils.isNotEmpty(textAreaElement) && textAreaElement.get(0).isDisplayed()) {
						textAreaElement.get(0).sendKeys("100");
					}

					if (CollectionUtils.isNotEmpty(driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc"))))) {
						DragAndDropAnswer(false);
					}

					if (CollectionUtils.isNotEmpty(driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.question.img.loc"))))) {
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
								// Used to Handle Question Unanswered Popup
								if (driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"))).size() != 0) {
									clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
									clickAssessmemtType();
									continueButtonElement.sendKeys(Keys.ENTER);

								}
							}
						}
					}
					
					if (rationaleFlag) {
						waitUntillElementIsVisible(PropertiesRepository.getString("asmt.rational.page.ques.status.loc"));
						//Waiting  for element is not working
						Thread.sleep(2000);
						List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
						if (CollectionUtils.isNotEmpty(rationalContinue)) {
							rationalContinue.get(0).sendKeys(Keys.ENTER);							
						}
					}
					
					//While flagging we verify the below popup
					if(flag_unflag)
					{
					//Verifying "Assessment Completed" pop up if displaying 3 options
					waitUntillElementIsVisible(".complete-assessment-dialog div button");
					List<WebElement> assessmentCompleteElement = baseHandler.findElements(".complete-assessment-dialog div button");
					flag = assessmentCompleteElement.get(0).getText().contains("Review Flagged Questions") && assessmentCompleteElement.get(1).getText().contains("Go Back to Last Question") && assessmentCompleteElement.get(2).getText().contains("Finalize and View Results");
					}					
					
				} 
				else {
						//waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						switchToAssessmentFrameHandler();
						waitUntillElementIsVisible(PropertiesRepository
								.getString("asmt.generic.tutorial.submit.new.loc"));
						List<WebElement> buttonElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
						if(CollectionUtils.isNotEmpty(buttonElement)) {
							if(buttonElement.get(0).isDisplayed()) {
								WebElement continueButtonElement = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
								if(continueButtonElement != null) {
									continueButtonElement.sendKeys(Keys.ENTER);
									
									// Used to Handle Question Unanswered Popup
									if (driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"))).size() != 0) {
										clickButton(PropertiesRepository
												.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
										clickAssessmemtType();
										continueButtonElement.sendKeys(Keys.ENTER);										
									}
									waitUntillElementIsVisible("#highlightWordsText");
									if((!(flag_unflag)) && (driver.findElements(By.cssSelector(".complete-assessment-dialog div button")).size() != 0))
									{	
										//Verifying "Assessment Completed" pop up if displaying 2 options
										List<WebElement> assessmentCompleteElement = baseHandler.findElements(".complete-assessment-dialog div button");
										flag = true;flag = assessmentCompleteElement.get(0).getText()
												.contains(PropertiesRepository.getString("asmt.popup.btn2.loc"))
												&& assessmentCompleteElement.get(1).getText()
														.contains(PropertiesRepository.getString("asmt.popup.btn5.loc"));
										break mainloop;
									}									
								}
							}
						}
					}
					if(!flagButton) {
						if (rationaleFlag) {
							//waitUntillElementIsVisible(PropertiesRepository.getString("asmt.rational.page.ques.status.loc"));
							//Waiting  for element is not working
							Thread.sleep(2000);
							List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
							if(CollectionUtils.isNotEmpty(rationalContinue)) {
								rationalContinue.get(0).sendKeys(Keys.ENTER);
								
								if(driver.findElements( By.cssSelector(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc")) ).size() != 0)
								{
									clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
								}
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
							}
							if(!(flag_unflag) && driver.findElements(By.cssSelector(".complete-assessment-dialog div button")).size()!=0)
							{
							//Verifying "Assessment Completed" pop up if displaying 3 options
							List<WebElement> assessmentCompleteElement = baseHandler.findElements(".complete-assessment-dialog div button");
							flag = assessmentCompleteElement.get(0).getText().contains("Go Back to Last Question") && assessmentCompleteElement.get(1).getText().contains("Finalize and View Results");
							break mainloop;
							}	
							
						}
					}
					
					if (breakFlag) {
						break;
					}
				}
			}
		} catch (DriverException e) {
			logger.info("unable to take assessment" + e);
		}
		waitUntillBufferInvisible(PropertiesRepository.getString("asmt.pleasewait.bufferLoc"));
		logger.info("Method : takeTestFlagOddQuesAnswerEvenQues_AlsoUnflag :::::::: END flag --> " + flag);
		return flag;
	}
	
	
	/**
	 * Method is used Flag odd questions and answer even questions for assessment with 10 questions or more than 5 questions .BUT DOES NOT VERIFY THE POPUP.
	 * 
	 * Handles all types of questions
	 * 
	 * breakFlag If assessment has to be stopped in middle.
	 * 
	 * rationaleFlag Need to check for Rationale and My Answer.
	 * 
	 * flag_unflag if true, will Flag even questions and answer odd questions
	 * 
	 * flag_unflag if false, will answer all the questions by unflagging all the flagged questions
	 * 
	 * @param bool
	 * @param breakFlag
	 * @param rationaleFlag
	 * @throws Exception
	 */
	public boolean takeTestFlagOddQuesAnswerEvenQues_AlsoUnflagNoPopupVerification(boolean bool, boolean breakFlag,
			boolean rationaleFlag, boolean flag_unflag) throws Exception {
		
		logger.info("Method : takeTestFlagOddQuesAnswerEvenQues_AlsoUnflag :::::::: Starts");
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
			int count = maxCount - minCount +1;

			mainloop:for (int i = 1; i <= count; i++) {
				boolean flagButton = false;
				
				//If flag_unflag is true then it will flag all the odd  odd question numbers  AND i==4 is for covering a specific scenario to flag and answer at the same time.
				if ( (flag_unflag) && (!((i % 2) == 0)) || ((i == 4))) {
					// Clicking on Flag Button for odd question numbers. 
					clickButton(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"), 0);					
					if(i == 4){
						clickAssessmemtType();
						Thread.sleep(2000);
					}					
					WebElement continueButtonElement = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
					continueButtonElement.sendKeys(Keys.ENTER);
					Thread.sleep(2000);
					flagButton = true;
				} else {
					
					//If flag_unflag is false then it will click on un flag button
					if (!(flag_unflag)){
						List<WebElement> flagElement = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"));
						if(CollectionUtils.isNotEmpty(flagElement) && flagElement.get(0).isDisplayed()) {
						clickButton(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"), 0);
						}
					}
										
					Thread.sleep(3000);
					List<WebElement> checkBoxElement = driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.tutorial.checkbox.new.loc")));
					if (CollectionUtils.isNotEmpty(checkBoxElement) && checkBoxElement.get(0).isDisplayed()) {
						checkBoxElement.get(0).click();						
					}

					List<WebElement> imgTextElement = driver.findElements(By.cssSelector("div[class='free-form-question-container'] .answer-fill-in-the-blank.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty"));
					if (CollectionUtils.isNotEmpty(imgTextElement) && imgTextElement.get(0).isDisplayed()) {
						imgTextElement.get(0).sendKeys("10");
					}

					List<WebElement> textBoxElement = driver.findElements(By.cssSelector("input[id^='fillIn']"));
					if (CollectionUtils.isNotEmpty(textBoxElement) && textBoxElement.get(0).isDisplayed()) {
						verifyFillForm("10");
					}

					List<WebElement> textBoxElement2 = driver.findElements(By.cssSelector("#fillInNumericAnswer"));
					if (CollectionUtils.isNotEmpty(textBoxElement2) && textBoxElement2.get(0).isDisplayed()) {
						verifyFillForm("10");
					}

					// Text Area
					List<WebElement> textAreaElement = driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.maint.textarea.loc")));
					if (CollectionUtils.isNotEmpty(textAreaElement) && textAreaElement.get(0).isDisplayed()) {
						textAreaElement.get(0).sendKeys("100");
					}

					if (CollectionUtils.isNotEmpty(driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc"))))) {
						DragAndDropAnswer(false);
					}

					if (CollectionUtils.isNotEmpty(driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.question.img.loc"))))) {
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
								// Used to Handle Question Unanswered Popup
								if (driver
										.findElements(By.cssSelector(PropertiesRepository
												.getString("asmt.myati.assessment.question.unanswered.close.loc")))
										.size() != 0) {
									clickButton(PropertiesRepository
											.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
									clickAssessmemtType();
									continueButtonElement.sendKeys(Keys.ENTER);

								}
							}
						}
					}					
					flag = true;					
				} 
				else {
						//waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						switchToAssessmentFrameHandler();
						waitUntillElementIsVisible(PropertiesRepository
								.getString("asmt.generic.tutorial.submit.new.loc"));
						List<WebElement> buttonElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
						if(CollectionUtils.isNotEmpty(buttonElement)) {
							if(buttonElement.get(0).isDisplayed()) {
								WebElement continueButtonElement = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
								if(continueButtonElement != null) {
									continueButtonElement.sendKeys(Keys.ENTER);
									
									// Used to Handle Question Unanswered Popup
									if (driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"))).size() != 0) {
										clickButton(PropertiesRepository
												.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
										clickAssessmemtType();
										continueButtonElement.sendKeys(Keys.ENTER);										
									}
									waitUntillElementIsVisible("#highlightWordsText");
									if((!(flag_unflag)) && (driver.findElements(By.cssSelector(".complete-assessment-dialog div button")).size() != 0))
									{	
										//Verifying "Assessment Completed" pop up if displaying 2 options
										List<WebElement> assessmentCompleteElement = baseHandler.findElements(".complete-assessment-dialog div button");
										flag = true;flag = assessmentCompleteElement.get(0).getText()
												.contains(PropertiesRepository.getString("asmt.popup.btn2.loc"))
												&& assessmentCompleteElement.get(1).getText()
														.contains(PropertiesRepository.getString("asmt.popup.btn5.loc"));
										break mainloop;
									}									
								}
							}
						}
					}
					if(!flagButton) {
						if (rationaleFlag) {
							waitUntillElementIsVisible(PropertiesRepository.getString("asmt.rational.page.ques.status.loc"));
							//Waiting  for element is not working
							Thread.sleep(2000);
							List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
							if(CollectionUtils.isNotEmpty(rationalContinue)) {
								rationalContinue.get(0).sendKeys(Keys.ENTER);								
								if(driver.findElements( By.cssSelector(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc")) ).size() != 0)
								{
									clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
								}
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");	
							}
						}
					}
					
					if (breakFlag) {
						break;
					}
				}
			}
			flag=true;
		} catch (DriverException e) {
			logger.info("unable to take assessment" + e);
		}
		waitUntillBufferInvisible(PropertiesRepository.getString("asmt.pleasewait.bufferLoc"));
		logger.info("Method : takeTestFlagOddQuesAnswerEvenQues_AlsoUnflagNoPopupVerification :::::::: END flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method is used Flag All Questions
	 * 
	  
	 * @param bool
	 * @throws Exception
	 */
	public boolean takeTestFlagAllQues() throws Exception {
		
		logger.info("Method : takeTestFlagAllQues :::::::: Starts");
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

				// Clicking on Flag Button
				waitUntillElementIsVisible("#highlightWordsText");
				//answering first question to handle the JIRA issue of IPP not loading if we flag all the questions , Can be removed once the issue is resolved
				if(i==0)
				{
					clickAssessmemtType();
				}
				clickButton(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"), 0);
				WebElement continueButtonElement = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
				continueButtonElement.sendKeys(Keys.ENTER);
				Thread.sleep(2000);
			}
			
			flag = (maxCount == getFlaggedQuestionNumfromPopup());
		} catch (DriverException e) {
			logger.info("unable to flag all the questions" + e);
		}
		waitUntillBufferInvisible(PropertiesRepository.getString("asmt.pleasewait.bufferLoc"));
		logger.info("Method : takeTestFlagAllQues :::::::: END flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method is used Un flag All Questions
	 * 
	  
	 * @param bool
	 * @throws Exception
	 */
	public boolean takeTestUnFlagAllQues(boolean rationaleFlag) throws Exception {

		logger.info("Method : takeTestUnFlag :::::::: Starts");

		try {
			waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
			switchToAssessmentFrameHandler();
			// Getting Total Question Number
			String maxQtnTextNo = baseHandler
					.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(1).getText();

			// Convert String to Integer
			int maxCount = Integer.parseInt(maxQtnTextNo);

			// Getting Current Question Number
			String minQtnTextNo = baseHandler
					.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(0).getText();

			// Convert String to Integer
			int minCount = Integer.parseInt(minQtnTextNo);

			// Maximum Question minus Minimum Questions
			int count = maxCount - minCount;

			main:for (int i = 0; i <= count; i++) {

				List<WebElement> flagElement = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"));
				clickButton(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"), 0);

				List<WebElement> checkBoxElement = driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.tutorial.checkbox.new.loc")));
				if (CollectionUtils.isNotEmpty(checkBoxElement) && checkBoxElement.get(0).isDisplayed()) {
					checkBoxElement.get(0).click();
				}

				if (CollectionUtils.isNotEmpty(driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.question.img.loc"))))) {
					hotSpotQuestion();
				}

				if (i == count) {
					switchToAssessmentFrameHandler();
					List<WebElement> buttonElement = baseHandler.findElements(
							PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
					if (CollectionUtils.isNotEmpty(buttonElement)) {
						if (buttonElement.get(0).isDisplayed()) {
							WebElement continueButtonElement = driver
									.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
							if (continueButtonElement != null) {
								continueButtonElement.sendKeys(Keys.ENTER);
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								// Used to Handle Question Unanswered Popup
								if (driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"))).size() != 0) {
									clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
									clickAssessmemtType();
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								}
							}
						}
					}					
					flag = true;
				} else {
					switchToAssessmentFrameHandler();
					waitUntillElementIsVisible(PropertiesRepository.getString("asmt.generic.tutorial.submit.new.loc"));
					List<WebElement> buttonElement = baseHandler.findElements(
							PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
					if (CollectionUtils.isNotEmpty(buttonElement)) {
						if (buttonElement.get(0).isDisplayed()) {
							WebElement continueButtonElement = driver
									.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
							if (continueButtonElement != null) {
								continueButtonElement.sendKeys(Keys.ENTER);
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								// Used to Handle Question Unanswered Popup
								if (driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"))).size() != 0) {
									clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
									clickAssessmemtType();
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								}
							}
						}
					}
				}
				if (rationaleFlag) {
					// waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
					List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
					if (CollectionUtils.isNotEmpty(rationalContinue)) {
						rationalContinue.get(0).sendKeys(Keys.ENTER);
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
					}
					
					if (driver.findElements(By.cssSelector(".complete-assessment-dialog")).size() != 0)
					{
						break main;
					}
				}
			}
		} catch (DriverException e) {
			logger.info("unable to take assessment" + e);
		}
		waitUntillBufferInvisible(PropertiesRepository.getString("asmt.pleasewait.bufferLoc"));
		logger.info("Method : takeTestUnFlag :::::::: END flag --> " + flag);
		return flag;
	}
	
	
	public int getFlaggedQuestionNumfromPopup() throws Exception {
		logger.info("Method : getFlaggedQuestionNumfromPopup Start ");
		int noOfFlaggedQuestions = 0;
		logger.info("Fetching number of flagged questions in a section");
		List<WebElement> assessmentCompleteElement = baseHandler.findElements(".complete-assessment-dialog div button");
		if (CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
			int size = assessmentCompleteElement.size();
			for (int intSize = 0; intSize < size; intSize++) {
				WebElement quizCompElement = assessmentCompleteElement.get(intSize);
				if (quizCompElement.getText().trim().contains("Review")) {
					String stringValue = quizCompElement.getText().trim();
					noOfFlaggedQuestions = Integer.parseInt(stringValue.replaceAll("[^0-9]", ""));
					logger.info("Number of Review flagged questions --> " + noOfFlaggedQuestions);
				}
			}
		}
		logger.info("Method : getFlaggedQuestionNumfromPopup :::::::: END Total Flagges questions--> "
				+ noOfFlaggedQuestions);
		return noOfFlaggedQuestions;
	}

	/*
	 * Clicking on Previous Button till the end and answer all the flagged
	 * questions without unflagging
	 */
	public boolean answeringAllFlaggedQuesWithoutUnflagging() throws Exception {
		logger.info("Method : answeringAllFlaggedQuesWithoutUnflagging Start");
		boolean flag = false;
		try {			
			String maxQtnTextNo = baseHandler
					.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(1).getText();

			// Convert String to Integer
			int maxCount = Integer.parseInt(maxQtnTextNo);

			//i!=3 because we are flagging 4th question along with odd questions as well
			for (int i = 0; i < maxCount; i++) {
				if ((!((i % 2) == 0)) && (i!=3) && (isElementDisplayed("asmt.unflag.btn.loc", 0))) {
					clickAssessmemtType();
				}

				if (driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.quiz.previous.btn.loc")))
						.size() != 0) {
					WebElement previousButtonElement = driver
							.findElement(By.cssSelector(PropertiesRepository.getString("asmt.quiz.previous.btn.loc")));
					previousButtonElement.sendKeys(Keys.ENTER);
					// Wait until next question is loaded
					waitUntillElementIsVisible("#highlightWordsText");
					//if rational question appears then clicking on previous again
					if(isElementDisplayed("asmt.practice.rational.container.loc", 0))
					{
						previousButtonElement.sendKeys(Keys.ENTER);
						waitUntillElementIsVisible("#highlightWordsText");
					}
				} else {
					WebElement continueButtonElement = driver
							.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
					continueButtonElement.sendKeys(Keys.ENTER);
					waitUntillElementIsVisible("#highlightWordsText");	
					break;
				}
			}			
			//Clicking Continue for all the questions
			List<WebElement> continueButtonElement2 = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
			while(CollectionUtils.isNotEmpty(continueButtonElement2))
			{
				WebElement continueButtonElement = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
				continueButtonElement.sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				continueButtonElement2 = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
			}
			
			waitUntillElementIsVisible(".complete-assessment-dialog div button");
			List<WebElement> assessmentCompleteElement = baseHandler
					.findElements(".complete-assessment-dialog div button");
			if(assessmentCompleteElement.get(0).getText().contains("Review Flagged Questions")
					&& assessmentCompleteElement.get(1).getText().contains("Go Back to Last Question")
					&& assessmentCompleteElement.get(2).getText().contains("Finalize and View Results"))
				{
					flag = true;				
				}

		} catch (Exception e) {
			logger.info("unable to answer flagged questions" + e);
		}
		logger.info("Method : answeringAllFlaggedQuesWithoutUnflagging Start ");
		return flag;
	}
	
	
	/**
	 * Method is used to answer all the questions including Drag and Drop  and Flag Drag and Drop at the same time.
	 * 
	 * breakFlag If assessment has to be stopped in middle.
	 * 
	 * rationaleFlag Need to check for Rationale and My Answer.
	 * 
	 * shoulCompleteTheSection if true will Proceed to next section, if false will stop the execution after answering all question.
	 * 
	 * @param bool
	 * @param breakFlag
	 * @param rationaleFlag
	 * @throws Exception
	 */
	public boolean takeTestAnswerAllDDAndFlagDD(boolean bool, boolean breakFlag, boolean rationaleFlag1, boolean flagquestion,
			boolean shoulCompleteTheSection) throws Exception {

		logger.info("Method : takeTestAnswerAllDDAndFlagDD :::::::: Starts");
		try {

			//waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
			//switchToAssessmentFrameHandler();
			// Getting Total Question Number
			String maxQtnTextNo = baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(1).getText();

			// Convert String to Integer
			int maxCount = Integer.parseInt(maxQtnTextNo);

			// Getting Current Question Number
			String minQtnTextNo = baseHandler
					.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(0).getText();

			// Convert String to Integer
			int minCount = Integer.parseInt(minQtnTextNo);

			// Maximum Question minus Minimum Questions
			int count = maxCount - minCount;

			for (int i = 0; i <= count; i++) {
				
				//Resetting flag as we are making it false in drag and drop if block
				boolean rationaleFlag = rationaleFlag1;
				
				List<WebElement> checkBoxElement = driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.tutorial.checkbox.new.loc")));				
				if (CollectionUtils.isNotEmpty(checkBoxElement) && checkBoxElement.get(0).isDisplayed()) {
					checkBoxElement.get(0).click();					
				}

				List<WebElement> imgTextElement = driver.findElements(By.cssSelector("div[class='free-form-question-container'] .answer-fill-in-the-blank.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty"));
				if (CollectionUtils.isNotEmpty(imgTextElement) && imgTextElement.get(0).isDisplayed()) {
					imgTextElement.get(0).sendKeys("10");
				}

				List<WebElement> textBoxElement = driver.findElements(By.cssSelector("input[id^='fillIn']"));
				if (CollectionUtils.isNotEmpty(textBoxElement) && textBoxElement.get(0).isDisplayed()) {
					verifyFillForm("10");
				}
				
				// Text Area
				List<WebElement> textAreaElement = driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.maint.textarea.loc")));
				if (CollectionUtils.isNotEmpty(textAreaElement) && textAreaElement.get(0).isDisplayed()) {
					textAreaElement.get(0).sendKeys("100");
				}

				//Flagging Drag and Drop and answering as well
				if (CollectionUtils.isNotEmpty(driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc"))))) {
					waitUntillElementIsVisible("#highlightWordsText");
					clickButton(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"), 0);
					DragAndDropAnswer(false);
					//Because we are flagging , rational is not applicable. 
					rationaleFlag = false;
				}
				
				if (CollectionUtils.isNotEmpty(driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.question.img.loc"))))) {
					hotSpotQuestion();
				}

				if (i == count) {
					switchToAssessmentFrameHandler();
					List<WebElement> buttonElement = baseHandler.findElements(
							PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
					if (CollectionUtils.isNotEmpty(buttonElement)) {
						if (buttonElement.get(0).isDisplayed()) {
							WebElement continueButtonElement = driver
									.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
							if (continueButtonElement != null) {
								continueButtonElement.sendKeys(Keys.ENTER);
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								// Used to Handle Question Unanswered Popup
								if (driver.findElements(By.cssSelector(PropertiesRepository
												.getString("asmt.myati.assessment.question.unanswered.close.loc")))
										.size() != 0) {
									clickButton(PropertiesRepository
											.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
									clickAssessmemtType();
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								}
							}
						}
					}
					if (shoulCompleteTheSection) {
						takeAssessment(rationaleFlag, flagquestion, "Finalize and View Results");
					}					
					if (rationaleFlag) {
						waitUntillElementIsVisible(PropertiesRepository.getString("asmt.rational.page.ques.status.loc"));
						//Waiting  for element is not working
						Thread.sleep(2000);
						List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
						if (CollectionUtils.isNotEmpty(rationalContinue)) {
							rationalContinue.get(0).sendKeys(Keys.ENTER);							
						}
					}
					logger.info("After answering all the questions and handling final popup");
					flag = true;
				} else {
					if (i == 0 && flagquestion) {
						switchToAssessmentFrameHandler();
						verifyFlag(true);
						logger.info("Question has been flaged");
						Thread.sleep(4000);
					} else {
						//waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						//switchToAssessmentFrameHandler();
						waitUntillElementIsVisible(
								PropertiesRepository.getString("asmt.generic.tutorial.submit.new.loc"));
						List<WebElement> buttonElement = baseHandler.findElements(
								PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
						if (CollectionUtils.isNotEmpty(buttonElement)) {
							if (buttonElement.get(0).isDisplayed()) {
								WebElement continueButtonElement = driver
										.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
								if (continueButtonElement != null) {
									continueButtonElement.sendKeys(Keys.ENTER);
									
									// Used to Handle Question Unanswered Popup
									if (driver
											.findElements(By.cssSelector(PropertiesRepository
													.getString("asmt.myati.assessment.question.unanswered.close.loc")))
											.size() != 0) {
										clickButton(PropertiesRepository
												.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
										clickAssessmemtType();
										continueButtonElement.sendKeys(Keys.ENTER);
										waitUntillElementIsVisible("#highlightWordsText");
									}
									waitUntillElementIsVisible("#highlightWordsText");
								}
							}
						}
					}
					if (rationaleFlag) {
						waitUntillElementIsVisible(PropertiesRepository.getString("asmt.rational.page.ques.status.loc"));
						//Waiting  for element is not working
						Thread.sleep(2000);
						List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
						if (CollectionUtils.isNotEmpty(rationalContinue)) {
							rationalContinue.get(0).sendKeys(Keys.ENTER);
							waitUntillElementIsVisible("#highlightWordsText");
						}
					}
					if (breakFlag) {
						logger.info("After answering single questions inside breakFlag");
						flag = true;
						break;
					}
				}
			}
		} catch (DriverException e) {
			logger.info("unable to flag Drag and Drop" + e);
		}
	//	waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		waitUntillBufferInvisible(PropertiesRepository.getString("asmt.pleasewait.bufferLoc"));
		logger.info("Method : takeTestAnswerAllDDAndFlagDD :::::::: END flag --> " + flag);
		return flag;
	}	
	
	public boolean verifyAndClickContinueBtn() {
		logger.info("Method : verifyAndClickContinueBtn Start");
		boolean flag = false;
		try {
			List<WebElement> buttonElement = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
			if (CollectionUtils.isNotEmpty(buttonElement)) {
				if (buttonElement.get(0).isDisplayed()) {
					WebElement continueButtonElement = driver
							.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
					if (continueButtonElement != null) {
						continueButtonElement.sendKeys(Keys.ENTER);
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						flag = true;
					}
				}
			}
		} catch (Exception e) {
			logger.info("unable to click on continue button" + e);
		}
		logger.info("Method : verifyAndClickContinueBtn Ends ");
		return flag;
	}
	
	/*
	 * This method is used to verify the flag button color
	 */
	public boolean verifyFlagBtnColor(String  btnStatus) {
		logger.info("Method : verifyAndClickContinueBtn Start ");
		boolean flag = false;
		try {
			List<WebElement> buttonElement = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"));
			
			if (CollectionUtils.isNotEmpty(buttonElement)) {
				if (btnStatus.equalsIgnoreCase("flagged") && (buttonElement.get(0).getCssValue("background-color").equals("rgba(244, 125, 32, 1)")) && (driver.findElement(By.cssSelector(PropertiesRepository.getString("asmt.assPage.continue.btn.loc"))).isEnabled())) { 
					flag = true;
				}
				else if(btnStatus.equalsIgnoreCase("Notflagged") && (buttonElement.get(0).getCssValue("background-color").equals("rgba(255, 255, 255, 1)")) && (driver.findElement(By.cssSelector(PropertiesRepository.getString("asmt.assPage.continue.btn.loc"))).isDisplayed()))
				{
					flag = true;
				}
			}
		} catch (Exception e) {
			logger.info("unable to click on continue button" + e);
		}
		logger.info("Method : verifyAndClickContinueBtn Ends ");
		return flag;
	}
	
	/**
	 * Navigate to MR Question and select answer
	 * 	  
	 * @param bool
	 * @throws Exception
	 */
	public boolean MR_Functionality() throws Exception {
		
		logger.info("Method : MR_Functionality :::::::: Starts");
		boolean flag = false;		
		try {

			//waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
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
			mainloop:for (int i = 0; i <= count; i++) {				
				
				List<WebElement> checkBoxElement = driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.mr.question.type.loc")));				
				if(CollectionUtils.isNotEmpty(checkBoxElement) && checkBoxElement.get(0).isDisplayed()){
					List<WebElement> checkBoxElementlable = driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.tutorial.checkbox.new.loc")));
					checkBoxElementlable.get(0).click();
					flag = true;
					break mainloop;						
				}
				else{
				// Clicking on Flag Button
				waitUntillElementIsVisible("#highlightWordsText");
				clickButton(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"), 0);
				WebElement continueButtonElement = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
				continueButtonElement.sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				}
			}			
		} catch (DriverException e) {
			logger.info("unable to find MR Question" + e);
		}
		waitUntillBufferInvisible(PropertiesRepository.getString("asmt.pleasewait.bufferLoc"));
		logger.info("Method : MR_Functionality :::::::: END flag --> " + flag);
		return flag;
	}
	
	
	/**
	 * Method is used to answer few questions .No of questions to be answered is provided as parameter
	 * 
	 * breakFlag If assessment has to be stopped in middle.
	 * 
	 * rationaleFlag Need to check for Rationale and My Answer.
	 * 
	 * howManyQuestionsToAnswer : Number of Questions to be answered.
	 * 
	 * @param bool
	 * @param breakFlag
	 * @param rationaleFlag
	 * @throws Exception
	 */
	public void HowManyQuesToAnswer(boolean bool, boolean breakFlag, boolean rationaleFlag, boolean flagquestion, int howManyQuestionsToAnswer) throws Exception {

		logger.info("Method : takeTest :::::::: Starts");
		int intExhibitCount = 0;
		boolean exhibitFlag = false;
		boolean boolExhibitFlag = false;
		boolean boolExhibitHeader = false;
		try {

			//waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
			switchToAssessmentFrameHandler();
			// Getting Total Question Number
			String maxQtnTextNo = baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(1).getText();

			// Convert String to Integer
			int maxCount = Integer.parseInt(maxQtnTextNo);

			// Getting Current Question Number
			String minQtnTextNo = baseHandler
					.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(0).getText();

			// Convert String to Integer
			int minCount = Integer.parseInt(minQtnTextNo);

			// Maximum Question minus Minimum Questions
			int count = maxCount - minCount;

			mainloop:for (int i = 1; i <= count+1; i++) {
				//Answer only Questions as specified in the parameters
				if(i <= howManyQuestionsToAnswer)
				{
				List<WebElement> checkBoxElement = driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.tutorial.checkbox.new.loc")));				
				if (CollectionUtils.isNotEmpty(checkBoxElement) && checkBoxElement.get(0).isDisplayed()) {
					checkBoxElement.get(0).click();					
				}

				List<WebElement> imgTextElement = driver.findElements(By.cssSelector("div[class='free-form-question-container'] .answer-fill-in-the-blank.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty"));
				if (CollectionUtils.isNotEmpty(imgTextElement) && imgTextElement.get(0).isDisplayed()) {
					imgTextElement.get(0).sendKeys("10");
				}

				List<WebElement> textBoxElement = driver.findElements(By.cssSelector("input[id^='fillIn']"));
				if (CollectionUtils.isNotEmpty(textBoxElement) && textBoxElement.get(0).isDisplayed()) {
					verifyFillForm("10");
				}

				List<WebElement> textBoxElement2 = driver.findElements(By.cssSelector("#fillInNumericAnswer"));
				if (CollectionUtils.isNotEmpty(textBoxElement2) && textBoxElement2.get(0).isDisplayed()) {
					verifyFillForm("10");
				}

				// Text Area
				List<WebElement> textAreaElement = driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.maint.textarea.loc")));
				if (CollectionUtils.isNotEmpty(textAreaElement) && textAreaElement.get(0).isDisplayed()) {
					textAreaElement.get(0).sendKeys("100");
				}

				if (CollectionUtils.isNotEmpty(driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc"))))) {
					DragAndDropAnswer(false);
				}
				
				if (CollectionUtils.isNotEmpty(driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.question.img.loc"))))) {
					hotSpotQuestion();
				}

				if (i == count) {
					switchToAssessmentFrameHandler();
					List<WebElement> buttonElement = baseHandler.findElements(
							PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
					if (CollectionUtils.isNotEmpty(buttonElement)) {
						if (buttonElement.get(0).isDisplayed()) {
							WebElement continueButtonElement = driver
									.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
							if (continueButtonElement != null) {
								continueButtonElement.sendKeys(Keys.ENTER);
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								// Used to Handle Question Unanswered Popup
								if (driver.findElements(By.cssSelector(PropertiesRepository
												.getString("asmt.myati.assessment.question.unanswered.close.loc")))
										.size() != 0) {
									clickButton(PropertiesRepository
											.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
									clickAssessmemtType();
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								}
							}
						}
					}
					
				} else {					
						waitUntillElementIsVisible(PropertiesRepository.getString("asmt.generic.tutorial.submit.new.loc"));
						List<WebElement> buttonElement = baseHandler.findElements(
								PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
						if (CollectionUtils.isNotEmpty(buttonElement)) {
							if (buttonElement.get(0).isDisplayed()) {
								WebElement continueButtonElement = driver
										.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
								if (continueButtonElement != null) {
									continueButtonElement.sendKeys(Keys.ENTER);
									// Used to Handle Question Unanswered Popup
									if (driver
											.findElements(By.cssSelector(PropertiesRepository
													.getString("asmt.myati.assessment.question.unanswered.close.loc")))
											.size() != 0) {
										clickButton(PropertiesRepository
												.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
										clickAssessmemtType();
										continueButtonElement.sendKeys(Keys.ENTER);
										waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									}
									waitUntillElementIsVisible("#highlightWordsText");
								}
							}
						}
					}
					if (rationaleFlag) {
						waitUntillElementIsVisible(PropertiesRepository.getString("asmt.rational.page.ques.status.loc"));
						//Waiting  for element is not working
						Thread.sleep(2000);
						List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
						if(CollectionUtils.isNotEmpty(rationalContinue)) {
							rationalContinue.get(0).sendKeys(Keys.ENTER);							
							if(driver.findElements( By.cssSelector(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc")) ).size() != 0)
							{
								clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
							}
							waitUntillElementIsVisible("#highlightWordsText");
						}
					}
					if (breakFlag) {
						logger.info("After answering single questions inside breakFlag");
						break;
					}
				}
				else
				{	
				break mainloop;
				}
			}
		} catch (DriverException e) {
			logger.info("unable to take Assessment" + e);
		}
		//waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		waitUntillBufferInvisible(PropertiesRepository.getString("asmt.pleasewait.bufferLoc"));
		logger.info("Method : HowManyQuesToAnswer :::::::: END");
		
	}
	
	/**
	 * Method is used to Take Test and break out immediately after answering Drag and Drop Question
	 * 
	 * breakFlag If assessment has to be stopped in middle.
	 * 
	 * rationaleFlag Need to check for Rationale and My Answer.
	 * 
	 * shoulCompleteTheSection if true will Proceed to next section, if false will stop the execution after answering all question.
	 * 
	 * @param bool
	 * @param breakFlag
	 * @param rationaleFlag
	 * @throws Exception
	 */
	public boolean takeTestBreakAfterDragDrop(boolean bool, boolean breakFlag, boolean rationaleFlag, boolean flagquestion,
			boolean shoulCompleteTheSection) throws Exception {

		logger.info("Method : takeTestBreakAfterDragDrop :::::::: Starts");
		boolean foundDD =false;
		try {

			waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
			switchToAssessmentFrameHandler();
			// Getting Total Question Number
			String maxQtnTextNo = baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(1).getText();

			// Convert String to Integer
			int maxCount = Integer.parseInt(maxQtnTextNo);

			// Getting Current Question Number
			String minQtnTextNo = baseHandler
					.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(0).getText();

			// Convert String to Integer
			int minCount = Integer.parseInt(minQtnTextNo);

			// Maximum Question minus Minimum Questions
			int count = maxCount - minCount;

			mainloop:for (int i = 0; i <= count; i++) {

				List<WebElement> checkBoxElement = driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.tutorial.checkbox.new.loc")));				
				if (CollectionUtils.isNotEmpty(checkBoxElement) && checkBoxElement.get(0).isDisplayed()) {
					checkBoxElement.get(0).click();					
				}

				List<WebElement> imgTextElement = driver.findElements(By.cssSelector("div[class='free-form-question-container'] .answer-fill-in-the-blank.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty"));
				if (CollectionUtils.isNotEmpty(imgTextElement) && imgTextElement.get(0).isDisplayed()) {
					imgTextElement.get(0).sendKeys("10");
				}

				List<WebElement> textBoxElement = driver.findElements(By.cssSelector("input[id^='fillIn']"));
				if (CollectionUtils.isNotEmpty(textBoxElement) && textBoxElement.get(0).isDisplayed()) {
					verifyFillForm("10");
				}

				List<WebElement> textBoxElement2 = driver.findElements(By.cssSelector("#fillInNumericAnswer"));
				if (CollectionUtils.isNotEmpty(textBoxElement2) && textBoxElement2.get(0).isDisplayed()) {
					verifyFillForm("10");
				}

				// Text Area
				List<WebElement> textAreaElement = driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.maint.textarea.loc")));
				if (CollectionUtils.isNotEmpty(textAreaElement) && textAreaElement.get(0).isDisplayed()) {
					textAreaElement.get(0).sendKeys("100");
				}

				if (CollectionUtils.isNotEmpty(driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc"))))) {
					DragAndDropAnswer(false);
					foundDD = true; 
				}
				
				if (CollectionUtils.isNotEmpty(driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.question.img.loc"))))) {
					hotSpotQuestion();
				}

				if (i == count) {
					switchToAssessmentFrameHandler();
					List<WebElement> buttonElement = baseHandler.findElements(
							PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
					if (CollectionUtils.isNotEmpty(buttonElement)) {
						if (buttonElement.get(0).isDisplayed()) {
							WebElement continueButtonElement = driver
									.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
							if (continueButtonElement != null) {
								continueButtonElement.sendKeys(Keys.ENTER);
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								// Used to Handle Question Unanswered Popup
								if (driver.findElements(By.cssSelector(PropertiesRepository
												.getString("asmt.myati.assessment.question.unanswered.close.loc")))
										.size() != 0) {
									clickButton(PropertiesRepository
											.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
									clickAssessmemtType();
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								}
							}
						}
					}
					if (shoulCompleteTheSection) {
						takeAssessment(rationaleFlag, flagquestion, "Finalize and View Results");
					}
					if (rationaleFlag) {
						waitUntillElementIsVisible(PropertiesRepository.getString("asmt.rational.page.ques.status.loc"));
						//Waiting  for element is not working
						Thread.sleep(2000);
						List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
						if (CollectionUtils.isNotEmpty(rationalContinue)) {
							rationalContinue.get(0).sendKeys(Keys.ENTER);							
						}
					}
					logger.info("After answering all the questions and handling final popup");
					flag = true;
				} else {
					if (i == 0 && flagquestion) {
						switchToAssessmentFrameHandler();
						verifyFlag(true);
						logger.info("Question has been flaged");
						Thread.sleep(4000);
					} else {
						// waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						switchToAssessmentFrameHandler();
						waitUntillElementIsVisible(
								PropertiesRepository.getString("asmt.generic.tutorial.submit.new.loc"));
						List<WebElement> buttonElement = baseHandler.findElements(
								PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
						if (CollectionUtils.isNotEmpty(buttonElement)) {
							if (buttonElement.get(0).isDisplayed()) {
								WebElement continueButtonElement = driver
										.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
								if (continueButtonElement != null) {
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									// Used to Handle Question Unanswered Popup
									if (driver
											.findElements(By.cssSelector(PropertiesRepository
													.getString("asmt.myati.assessment.question.unanswered.close.loc")))
											.size() != 0) {
										clickButton(PropertiesRepository
												.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
										clickAssessmemtType();
										continueButtonElement.sendKeys(Keys.ENTER);
										waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									}
								}
							}
						}
					}
					if (rationaleFlag) {
						
						// waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
						List<WebElement> rationalContinue = driver
								.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
						if (CollectionUtils.isNotEmpty(rationalContinue)) {
							rationalContinue.get(0).sendKeys(Keys.ENTER);
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						}
						//come out of method once the DD rational is answered
						if(foundDD){
							break mainloop;
						}
					}
					if (breakFlag) {
						logger.info("After answering single questions inside breakFlag");
						flag = true;
						break;
					}
				}
			}
		} catch (DriverException e) {
			logger.info("unable to take Assessment" + e);
		}
		waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		waitUntillBufferInvisible(PropertiesRepository.getString("asmt.pleasewait.bufferLoc"));
		logger.info("Method : takeTestBreakAfterDragDrop :::::::: END flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method is used to Take Test and break out immediately after answering Hotspot Question
	 * 
	 * breakFlag If assessment has to be stopped in middle.
	 * 
	 * rationaleFlag Need to check for Rationale and My Answer.
	 * 
	 * shoulCompleteTheSection if true will Proceed to next section, if false will stop the execution after answering all question.
	 * 
	 * @param bool
	 * @param breakFlag
	 * @param rationaleFlag
	 * @throws Exception
	 */
	public boolean takeTestBreakAfterHotspot(boolean bool, boolean breakFlag, boolean rationaleFlag, boolean flagquestion,
			boolean shoulCompleteTheSection) throws Exception {

		logger.info("Method : takeTestBreakAfterHotspot :::::::: Starts");
		boolean foundHotSpot = false;
		try {

			waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
			switchToAssessmentFrameHandler();
			// Getting Total Question Number
			String maxQtnTextNo = baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(1).getText();

			// Convert String to Integer
			int maxCount = Integer.parseInt(maxQtnTextNo);

			// Getting Current Question Number
			String minQtnTextNo = baseHandler
					.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(0).getText();

			// Convert String to Integer
			int minCount = Integer.parseInt(minQtnTextNo);

			// Maximum Question minus Minimum Questions
			int count = maxCount - minCount;

			mainloop:for (int i = 0; i <= count; i++) {

				List<WebElement> checkBoxElement = driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.tutorial.checkbox.new.loc")));				
				if (CollectionUtils.isNotEmpty(checkBoxElement) && checkBoxElement.get(0).isDisplayed()) {
					checkBoxElement.get(0).click();					
				}

				List<WebElement> imgTextElement = driver.findElements(By.cssSelector("div[class='free-form-question-container'] .answer-fill-in-the-blank.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty"));
				if (CollectionUtils.isNotEmpty(imgTextElement) && imgTextElement.get(0).isDisplayed()) {
					imgTextElement.get(0).sendKeys("10");
				}

				List<WebElement> textBoxElement = driver.findElements(By.cssSelector("input[id^='fillIn']"));
				if (CollectionUtils.isNotEmpty(textBoxElement) && textBoxElement.get(0).isDisplayed()) {
					verifyFillForm("10");
				}

				List<WebElement> textBoxElement2 = driver.findElements(By.cssSelector("#fillInNumericAnswer"));
				if (CollectionUtils.isNotEmpty(textBoxElement2) && textBoxElement2.get(0).isDisplayed()) {
					verifyFillForm("10");
				}

				// Text Area
				List<WebElement> textAreaElement = driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.maint.textarea.loc")));
				if (CollectionUtils.isNotEmpty(textAreaElement) && textAreaElement.get(0).isDisplayed()) {
					textAreaElement.get(0).sendKeys("100");
				}

				if (CollectionUtils.isNotEmpty(driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc"))))) {
					DragAndDropAnswer(false);
					
				}
				
				if (CollectionUtils.isNotEmpty(driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.question.img.loc"))))) {
					hotSpotQuestion();
					//come out of methos once the DD rational is answered
					foundHotSpot = true;
				}

				if (i == count) {
					switchToAssessmentFrameHandler();
					List<WebElement> buttonElement = baseHandler.findElements(
							PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
					if (CollectionUtils.isNotEmpty(buttonElement)) {
						if (buttonElement.get(0).isDisplayed()) {
							WebElement continueButtonElement = driver
									.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
							if (continueButtonElement != null) {
								continueButtonElement.sendKeys(Keys.ENTER);
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								// Used to Handle Question Unanswered Popup
								if (driver.findElements(By.cssSelector(PropertiesRepository
												.getString("asmt.myati.assessment.question.unanswered.close.loc")))
										.size() != 0) {
									clickButton(PropertiesRepository
											.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
									clickAssessmemtType();
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								}
							}
						}
					}
					if (shoulCompleteTheSection) {
						takeAssessment(rationaleFlag, flagquestion, "Finalize and View Results");
					}
					if (rationaleFlag) {
						waitUntillElementIsVisible(PropertiesRepository.getString("asmt.rational.page.ques.status.loc"));
						//Waiting  for element is not working
						Thread.sleep(2000);
						List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
						if (CollectionUtils.isNotEmpty(rationalContinue)) {
							rationalContinue.get(0).sendKeys(Keys.ENTER);							
						}
					}
					logger.info("After answering all the questions and handling final popup");
					flag = true;
				} else {
					if (i == 0 && flagquestion) {
						switchToAssessmentFrameHandler();
						verifyFlag(true);
						logger.info("Question has been flaged");
						Thread.sleep(4000);
					} else {
						// waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						switchToAssessmentFrameHandler();
						waitUntillElementIsVisible(
								PropertiesRepository.getString("asmt.generic.tutorial.submit.new.loc"));
						List<WebElement> buttonElement = baseHandler.findElements(
								PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
						if (CollectionUtils.isNotEmpty(buttonElement)) {
							if (buttonElement.get(0).isDisplayed()) {
								WebElement continueButtonElement = driver
										.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
								if (continueButtonElement != null) {
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									// Used to Handle Question Unanswered Popup
									if (driver
											.findElements(By.cssSelector(PropertiesRepository
													.getString("asmt.myati.assessment.question.unanswered.close.loc")))
											.size() != 0) {
										clickButton(PropertiesRepository
												.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
										clickAssessmemtType();
										continueButtonElement.sendKeys(Keys.ENTER);
										waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									}
								}
							}
						}
					}
					if (rationaleFlag) {
						//come out of methos once the DD rational is answered
						if(foundHotSpot){
							break mainloop;
						}						
						List<WebElement> rationalContinue = driver
								.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
						if (CollectionUtils.isNotEmpty(rationalContinue)) {
							rationalContinue.get(0).sendKeys(Keys.ENTER);
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						}						
					}
					if (breakFlag) {
						logger.info("After answering single questions inside breakFlag");
						flag = true;
						break;
					}
				}
			}
		} catch (DriverException e) {
			logger.info("unable to take Assessment" + e);
		}
		waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		waitUntillBufferInvisible(PropertiesRepository.getString("asmt.pleasewait.bufferLoc"));
		logger.info("Method : takeTestBreakAfterHotspot :::::::: END flag --> " + flag);
		return flag;
	}	
	
	public boolean verifyAssessButtonContinueStateCF(String assessName) throws Exception{
		logger.info("Method: verifyAssessButtonContinueStateCF Starts ");
		boolean breakFlag = false;
		try {
			List<WebElement> pracProcCardElement = baseHandler
					.findElements(PropertiesRepository.getString("asmt.Quiz.all.modules.loc"));
			if (CollectionUtils.isNotEmpty(pracProcCardElement)) {
				mainloop: for (int i = 0; i < pracProcCardElement.size(); i++) {
					if (pracProcCardElement.get(i).findElement(By.cssSelector(".description")).getText()
							.equals(assessName)) {

						List<WebElement> continueBtn = pracProcCardElement.get(i).findElements(By.cssSelector("section nav a[id^='continueTest']"));
						if (continueBtn.size() >= 1 && continueBtn.get(0).getAttribute("style").equals("")) {
							flag = true;
							break mainloop;
						}
					}
				}
			}
		}catch (Exception e) {
				logger.info("unable to verifyAssessButtonContinueStateCF" + e);
		}
		logger.info("Method : verifyAssessButtonContinueStateCF :::::::: END flag --> " + flag);
		return flag;
	}
	
	public boolean verifyExhibitPopupTabsUniqueness() {
		logger.info("Method: verifyExhibitPopupTabsUniqueness Starts ");
		boolean flag = false;
		try {
			List<String> tabname = new ArrayList<String>();
			List<WebElement> tabList = driver
					.findElements(By.cssSelector(PropertiesRepository.getString("asmt.exhibit.popup.tabs.loc")));
			for (WebElement webElement : tabList) {
				tabname.add(webElement.getText());
			}
			Set<String> set = new HashSet<String>(tabname);
			if (set.size() < tabname.size()) {
				logger.info("tab have duplicate name's");
			} else {
				flag = true;
			}

		} catch (Exception e) {
			logger.info("unable to verifyAssessButtonContinueStateCF" + e);
		}
		logger.info("Method : verifyExhibitPopupTabsUniqueness :::::::: END flag --> " + flag);
		return flag;
	}
}
