package com.automation.asmt.page;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class PeakPage extends ASMTBasePage {
	private Logger logger = LogManager.getLogger(this.getClass());
	public BaseHandler baseHandler;
	private WindowHandler windowHandler;
	private ButtonHandler buttonHandler;
	private boolean flag;

	public PeakPage(WebDriver webDriver) {
		super(webDriver);
		baseHandler = new BaseHandler(driver);
		windowHandler = new WindowHandler(driver);
		buttonHandler = new ButtonHandler(driver);
	}
	
	/**
	 * For Peak hour testing, method is used to verify IPP Page Header and click on Close button. 
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws Exception
	 */
	public boolean verifyIPPHeaderAndClickCloseButtonPeakHour(String IPPHeaderName , int index) throws Exception {
		logger.info("Method: verifyIPPHeaderAndClickCloseButton Starts");
		boolean flag = false;
    	try {
    		
    		String moduleName = null;
    		waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
    		waitUntillIPPPageIsLoaded(".sub-header>section>img");
    		windowHandler.switchToLatestWindow();
    		List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("asmt.learntab.tutorial.nurse.logic.tutorial.ipp.header.loc"));
    		if(CollectionUtils.isNotEmpty(element)) {
    			List<WebElement> headerElement = element.get(index).findElements(By.cssSelector("span"));
    			if(CollectionUtils.isNotEmpty(headerElement)) {
    				moduleName = headerElement.get(1).getText();
        			String appendModuleName = IPPHeaderName;
        			if(StringUtils.isNotEmpty(moduleName) && moduleName.equalsIgnoreCase(appendModuleName)) {
        				buttonHandler.clickButton(PropertiesRepository.getString("asmt.learntab.tutorial.nurse.logic.tutorial.ipp.close.button.loc"));
        				waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
        				flag = true;
        			}
    			}
    		}
    		  
    	} catch (DriverException e) {
    		logger.info("Unable to verify IPP Header And Click Close Button");
    		throw new DriverException("Unable to verify IPP Header And Click Close Button" , e); 
    	}
    	logger.info("Method: verifyIPPHeaderAndClickCloseButton End flag --> " + flag);
    	return flag;
	}
	
	/**
	 * Method used to verify IPP Page Header "Individual Performance Profile"
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean verifyIPPPageHeader() throws Exception {
		logger.info("Method: verifyIPPPageHeader Starts");
		boolean flag = false;
		try {
			waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
			waitUntillIPPPageIsLoaded(".sub-header>section>img");
			windowHandler.switchToLatestWindow();
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository
							.getString("new-ati.report.header.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				if (element
						.get(0)
						.getText()
						.equalsIgnoreCase(
								PropertiesRepository.getString("asmt.report.header.value"))) {
					flag = true;
				}
			}
		} catch (Exception e) {			
			logger.info("Unable to load IPP Page");
			throw new Exception("Unable to load IPP Page");
		}
		logger.info("Method: verifyIPPPageHeader End flag --> " + flag);
		return flag;
	}

	
	public void clickInfoIconByName(String productName) throws Exception {
		logger.info("Method: clickInfoIconByName Start ");
		List<WebElement> elements = baseHandler.findElements(PropertiesRepository.getString("asmt.practice.card.front.loc"));
		for (int i = 0; i < elements.size(); i++) {
			if (elements.get(i).findElement(By.cssSelector("div section div")).getText().contains(productName)) {
				elements.get(i).findElement(By.cssSelector("header a")).click();
				break;
			}
		}

		logger.info("Method: clickInfoIconByName End");
	}
	
	public boolean verifyIfProductAdded(String ProductID) throws Exception {
		logger.info("Method: verifyIfProductAdded Start ");
		boolean flag = false;
		try {
			List<WebElement> elements = baseHandler.findElements(PropertiesRepository.getString("asmt.product.information.popup.loc"));
			if (CollectionUtils.isNotEmpty(elements)) {
				VerificationHandler.verifyEquals(ProductID, elements.get(1).getText());
				flag = (ProductID.equals(elements.get(1).getText()));
			}
		} catch (Exception e) {
			logger.info("Product is not added");
			throw new Exception("Product is not added");
		}
		logger.info("Method: verifyIfProductAdded End flag --> " + flag);
		return flag;

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
			if (CollectionUtils.isNotEmpty(iframe)) {
				chromeDriver.switchTo().frame(iframe.get(0));
			}
		} catch (Exception e) {
			logger.info("Unable to swithToProctorFrame");
			log(logger, "Unable to swithToProctorFrame");
			throw new DriverException("Unable to swithToProctorFrame", e);
		}
		logger.info("Method: swithToProctorFrame End ");
	}

	public void clickAssessmemtType() throws Exception {

		List<WebElement> checkBoxElement = driver
				.findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.tutorial.checkbox.new.loc")));
		List<WebElement> radioElement = driver.findElements(
				By.cssSelector(PropertiesRepository.getString("asmt.generic.tutorial.radio.button.new.loc")));
		List<WebElement> hotSpotElement = driver
				.findElements(By.cssSelector(PropertiesRepository.getString("asmt.question.img.loc")));
		List<WebElement> inputBoxOption = driver.findElements(By.cssSelector("input[id^='fillIn']"));
		List<WebElement> textBoxElement2 = driver.findElements(By.cssSelector("#fillInNumericAnswer"));
		List<WebElement> textAreaElement = driver
				.findElements(By.cssSelector(PropertiesRepository.getString("asmt.maint.textarea.loc")));
		List<WebElement> dragNDrop = driver
				.findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc")));

		if (CollectionUtils.isNotEmpty(checkBoxElement) && checkBoxElement.size() > 0) {
			checkBoxElement.get(0).click();
			checkBoxElement.get(1).click();
		} else if (CollectionUtils.isNotEmpty(hotSpotElement) && hotSpotElement.size() > 0) {
			// Clicking Flag if it has Hot Spot Image
			hotSpotQuestion();
		} else if (CollectionUtils.isNotEmpty(radioElement) && radioElement.size() > 0) {
			radioElement.get(0).click();
			radioElement.get(0).click();
		} else if (CollectionUtils.isNotEmpty(inputBoxOption)) {
			verifyFillForm("10");
		} else if (CollectionUtils.isNotEmpty(textBoxElement2)) {
			verifyFillForm("10");
		} else if (CollectionUtils.isNotEmpty(textAreaElement)) {
			verifyFillForm("10");
		} else if (CollectionUtils.isNotEmpty(dragNDrop)) {
			DragAndDropAnswer(false);
		} else {
			buttonHandler.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.flag.button"));
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		}
	}

	/**
	 * This method is used to identify the hotspot question.
	 * 
	 * @author siddharth roy
	 * @return boolean
	 * @throws DriverException
	 */
	public boolean hotSpotQuestion() throws Exception {
		logger.info("Method : hotSpotQuestion :::::::: start ");
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

			waitUntillBufferInvisible(PropertiesRepository.getString("asmt.pleasewait.bufferLoc"));
			switchToAssessmentFrameHandler();

			// List<WebElement> element =
			// baseHandler.findElements("div[class='free-form-question-container']
			// .answer-fill-in-the-blank.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty");
			List<WebElement> element = baseHandler.findElements("input[id^='fillIn']");

			if (CollectionUtils.isNotEmpty(element)) {
				element.get(0).sendKeys(value);
				flag = true;
			}
		} catch (Exception e) {
			throw new DriverException("Unable to fill the text entry question", e);
		}
		// windowHandler.switchToLatestWindow();
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
		logger.info("DragAndDropAnswer Start");
		try {
			waitUntillBufferInvisible(PropertiesRepository.getString("asmt.pleasewait.bufferLoc"));
			logger.info("Method : DragAndDropAnswer :::::::: start");
			Actions act = new Actions(driver);
			boolean breakflag = false;

			switchToAssessmentFrameHandler();
			int tot = baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc"))
					.findElements(By.cssSelector("li")).size();
			if (baseHandler.isDisplayed(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc"))) {
				System.out.println(
						baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox2.loc"))
								.findElements(By.cssSelector("li")).size());
				while (baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox2.loc"))
						.findElements(By.cssSelector("li")).size() != tot) {
					if (breakflag) {
						break;
					}
					List<WebElement> btn = baseHandler
							.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc"))
							.findElements(By.cssSelector("li"));
					for (int i = 0; i < btn.size(); i++) {
						try {
							wait.until(ExpectedConditions.elementToBeClickable(btn.get(i)));
							WebElement toElement = baseHandler
									.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox2.loc"));
							if (breakflag) {
								break;
							}

							org.openqa.selenium.interactions.Action atc2 = act.clickAndHold(btn.get(i))
									.moveToElement(toElement).release(toElement).build();
							buttonHandler
									.clickButton(PropertiesRepository.getString("asmt.generic.tutorial.dragbox2.loc"));
							atc2.perform();
							if (stop) {
								breakflag = true;
							}
							if (i == btn.size() - 1) {
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
		// windowHandler.switchToLatestWindow();
		logger.info("Method:  DragAndDropAnswer End --> ");
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
			clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

			// click on flag
			clickButton(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"), 0);
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

			// click on continue
			List<WebElement> rationalContinue = driver
					.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
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
			if (baseHandler.findElement("#CompleteAssessmentDialog div .button.secondary-button") != null
					&& baseHandler.findElement("#CompleteAssessmentDialog div .button.secondary-button") != null
					&& baseHandler.findElement("#CompleteAssessmentDialog div .button.default-button") != null) {
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to verify complete assesment dialog");
			throw new DriverException("Unable to verify the cpomplete aseesment dailog", e);
		}
		logger.info("Method : completeDialogVerifier -->end");
		return flag;

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
	public double takeAssessmentPeak(boolean bool, boolean flagquestion, String complButtonName)throws InterruptedException, DriverException {
		logger.info("takeAssessmentPeak starts");
		double timeTakenToLoadIPPPage = 0;
		try {
			//waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");// waitUntillBufferInvisible(PropertiesRepository.getString("asmt.pleasewait.bufferLoc"));
			switchToAssessmentFrameHandler();
			/*if (bool) {
				List<WebElement> rationalContinue = driver
						.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
				if (CollectionUtils.isNotEmpty(rationalContinue)) {
					rationalContinue.get(0).sendKeys(Keys.ENTER);
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				}
			}*/
			// switch to model dialogue
			windowHandler.switchToModalDialog();
			if (flagquestion) {
				completeDialogVerifier();
			}

			// click on view result button
			List<WebElement> assessmentCompleteElement = baseHandler
					.findElements(".complete-assessment-dialog div button");
			if (CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
				int size = assessmentCompleteElement.size();
				for (int intSize = 0; intSize < size; intSize++) {
					WebElement quizCompElement = assessmentCompleteElement.get(intSize);
					if (quizCompElement.getText().trim().contains(complButtonName)) {
											
						//Get Time before clicking on 
				    	  long testStartTime = System.currentTimeMillis();	
				    	  quizCompElement.click();
				    	  
				    	  // Loading IPP Page. 
				    	 if(verifyIPPPageHeader())
				    	 {
				    		 long testEndTime = System.currentTimeMillis();
				    		 timeTakenToLoadIPPPage = TimeUnit.MILLISECONDS.toSeconds(testEndTime-testStartTime);
				    		//log(logger, "Time taken to Load IPP Page >>>>>> " + timeTakenToLoadIPPPage + " seconds");
				    	 }
				    	 else
				    	 {
				    		 throw new DriverException("IPP Page did not load up"); 
				    	 }
	   	  		       //waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				       //waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				       //waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				       break;
					}
				}
			}
			logger.info("takeAssessmentPeak Ends");
		} catch (Exception e) {
			throw new DriverException("Unable to take practice Assessment", e);
		}
		return timeTakenToLoadIPPPage;
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
	public ArrayList<Double> takeTestPeak(boolean bool, boolean breakFlag, boolean rationaleFlag, boolean flagquestion) throws Exception {

		logger.info("Method : takeTestPeak :::::::: Starts ");
		boolean flag = false;
		double averageTimeForLoadingEachQues = 0;
		double timeForLoadingIPPPage = 0;
		
		try {
			//waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
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
			
			long[] timeArray = new long [maxCount];

			for (int i = 0; i <= count; i++) {

				logger.info("Currently loaded Question no : " + baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(0).getText()); 
				
				List<WebElement> checkBoxElement = driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.tutorial.checkbox.new.loc")));
				if (CollectionUtils.isNotEmpty(checkBoxElement) && checkBoxElement.get(0).isDisplayed()) {
					checkBoxElement.get(0).click();
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
					if (rationaleFlag) {
						waitUntillElementIsVisible(
								PropertiesRepository.getString("asmt.rational.page.ques.status.loc"));
						// Waiting for element is not working
						Thread.sleep(3000);
						List<WebElement> rationalContinue = driver
								.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
						if (CollectionUtils.isNotEmpty(rationalContinue)) {
							rationalContinue.get(0).sendKeys(Keys.ENTER);
							
							//logging time after clicking on continue button
							long testStartTime = System.currentTimeMillis();
							
							if (driver
									.findElements(By.cssSelector(PropertiesRepository
											.getString("asmt.myati.assessment.question.unanswered.close.loc")))
									.size() != 0) {
								clickButton(PropertiesRepository
										.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
							}
							
							waitUntillElementIsVisible(".complete-assessment-dialog div button");
							// Waiting for element is not working sometimes,so waiting for two second
							Thread.sleep(2000);
							//logging time after next question is loaded
							long testEndTime = System.currentTimeMillis();
							timeArray[i] = TimeUnit.MILLISECONDS.toSeconds(testEndTime-testStartTime);
						}
					}
					
					
					double averageTime = 0;
					for(int j=0; j < timeArray.length ; j++)
					{
						averageTime = averageTime + timeArray[j];
					}
					averageTimeForLoadingEachQues = averageTime/timeArray.length;
					logger.info("Average time for loading each question is >>>>>>>>>>>> " + averageTimeForLoadingEachQues + " seconds"); 
					
					timeForLoadingIPPPage = takeAssessmentPeak(rationaleFlag, flagquestion, "Finalize and View Results");
										
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
								
								/*//logging time after clicking on continue button
								long testStartTime = System.currentTimeMillis();*/							
								
								// Used to Handle Question Unanswered Popup
								if (driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"))).size() != 0) {
									clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
									clickAssessmemtType();
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								}
								waitUntillElementIsVisible("#highlightWordsText");	
								/*// Waiting for element is not working sometimes,so waiting for two second
								Thread.sleep(2000);
								//logging time after next question is loaded
								long testEndTime = System.currentTimeMillis();
								timeArray[i] = TimeUnit.MILLISECONDS.toSeconds(testEndTime-testStartTime);*/
							}
						}
					}
					if (rationaleFlag) {
						waitUntillElementIsVisible(
								PropertiesRepository.getString("asmt.rational.page.ques.status.loc"));
						// Waiting for element is not working
						Thread.sleep(2000);
						List<WebElement> rationalContinue = driver
								.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
						if (CollectionUtils.isNotEmpty(rationalContinue)) {
							rationalContinue.get(0).sendKeys(Keys.ENTER);
							
							//logging time after clicking on continue button
							long testStartTime = System.currentTimeMillis();
							
							if (driver
									.findElements(By.cssSelector(PropertiesRepository
											.getString("asmt.myati.assessment.question.unanswered.close.loc")))
									.size() != 0) {
								clickButton(PropertiesRepository
										.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
							}
							waitUntillElementIsVisible("#highlightWordsText");
							// Waiting for element is not working sometimes,so waiting for two second
							Thread.sleep(2000);
							//logging time after next question is loaded
							long testEndTime = System.currentTimeMillis();
							timeArray[i] = TimeUnit.MILLISECONDS.toSeconds(testEndTime-testStartTime);
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
			logger.info("unable to take Assessment Peak" + e);
			throw new DriverException("unable to take Assessment Peak", e);
		}
		ArrayList<Double> timeList = new ArrayList<Double>();
		timeList.add(averageTimeForLoadingEachQues);
		timeList.add(timeForLoadingIPPPage);		
		
		logger.info("Method : takeTestPeak :::::::: END flag --> " + flag);
		return timeList;
	}
	
	/**
	 * Method is used to complete Test for Proctor
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
	public ArrayList<Double> takeTestProctorPeak(boolean bool, boolean breakFlag, boolean rationaleFlag, boolean flagquestion) throws Exception {

		logger.info("Method : takeTestProctorPeak :::::::: Starts ");
		boolean flag = false;
		double averageTimeForLoadingEachQues = 0;
		double timeForLoadingIPPPage = 0;
		
		try {
			//waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
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
			
			long[] timeArray = new long [maxCount];

			for (int i = 0; i <= count; i++) {

				logger.info("Currently loaded Question no : " + baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc")).get(0).getText()); 
				
				List<WebElement> checkBoxElement = driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.tutorial.checkbox.new.loc")));
				if (CollectionUtils.isNotEmpty(checkBoxElement) && checkBoxElement.get(0).isDisplayed()) {
					checkBoxElement.get(0).click();
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
								
								//logging time after clicking on continue button
								long testStartTime = System.currentTimeMillis();								
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
								
								waitUntillElementIsVisible(".complete-assessment-dialog div button");
								// Waiting for element is not working sometimes,so waiting for one second
								Thread.sleep(2000);
								//logging time after next question is loaded
								long testEndTime = System.currentTimeMillis();
								timeArray[i] = TimeUnit.MILLISECONDS.toSeconds(testEndTime-testStartTime);
							}
						}
					}
					
					double averageTime = 0;
					for(int j=0; j < timeArray.length ; j++)
					{
						averageTime = averageTime + timeArray[j];
					}
					averageTimeForLoadingEachQues = averageTime/timeArray.length;
					logger.info("Average time for loading each question is >>>>>>>>>>>> " + averageTimeForLoadingEachQues + " seconds"); 
					
					timeForLoadingIPPPage = takeAssessmentPeak(rationaleFlag, flagquestion, "Finalize and View Results");
										
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
								
								//logging time after clicking on continue button
								long testStartTime = System.currentTimeMillis();							
								
								// Used to Handle Question Unanswered Popup
								if (driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"))).size() != 0) {
									clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
									clickAssessmemtType();
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								}
								waitUntillElementIsVisible("#highlightWordsText");	
								// Waiting for element is not working sometimes,so waiting for one second
								Thread.sleep(2000);
								//logging time after next question is loaded
								long testEndTime = System.currentTimeMillis();
								timeArray[i] = TimeUnit.MILLISECONDS.toSeconds(testEndTime-testStartTime);
							}
						}
					}			
				}
			}
		} catch (DriverException e) {
			logger.info("unable to take Proctor Assessment Peak" + e);
			throw new DriverException("unable to take Proctor Assessment Peak", e);
		}
		ArrayList<Double> timeList = new ArrayList<Double>();
		timeList.add(averageTimeForLoadingEachQues);
		timeList.add(timeForLoadingIPPPage);		
		
		logger.info("Method : takeTestProctorPeak :::::::: END flag --> " + flag);
		return timeList;
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
			waitUntillElementIsVisible(
					PropertiesRepository.getString("asmt.myati.test.tab.verify.details.are.displaye.loc"));
			if (baseHandler.isDisplayed(
					PropertiesRepository.getString("asmt.myati.test.tab.verify.details.are.displaye.loc"))) {
				List<WebElement> pracProcCardElement = baseHandler.findElements(
						PropertiesRepository.getString("asmt.myati.test.tab.verify.details.are.displaye.loc"));
				if (CollectionUtils.isNotEmpty(pracProcCardElement)) {
					int size = pracProcCardElement.size();
					mainloop: for (int index = 0; index < size; index++) {
						if (breakFlag) {
							break;
						}
						WebElement assessmentTypeElement = pracProcCardElement.get(index);
						// Validating Assessment Type
						WebElement assessmentTypeSingleElement = assessmentTypeElement.findElement(By.cssSelector(
								PropertiesRepository.getString("asmt.myati.test.tab.assessment.type.loc")));
						if (assessmentTypeSingleElement != null) {
							String assessmentTypeValue = assessmentTypeSingleElement.getText().trim();
							if (StringUtils.isNotEmpty(assessmentTypeValue)
									&& assessmentTypeValue.equalsIgnoreCase(assessmentType)) {
								// Validating Assessment Name
								WebElement assessmentNameElement = assessmentTypeElement.findElement(By.cssSelector(
										PropertiesRepository.getString("asmt.myati.test.tab.assessment.name.loc")));
								if (assessmentNameElement != null) {
									String assessmentNameValue = assessmentNameElement.getText().trim()
											.replaceAll("\\r\\n|\\r|\\n", " ");
									String assNameIndex = assessmentNameElement.getAttribute("id");
									if (StringUtils.isNotEmpty(assessmentNameValue)
											&& assessmentNameValue.equalsIgnoreCase(assessmentName)) {
										List<WebElement> buttonList = baseHandler.findElements(
												"a[id$='" + assNameIndex.substring(assNameIndex.length() - 1) + "']");
										for (int i = 0; i < buttonList.size(); i++) {
											if (!(buttonList.get(i).getAttribute("style")
													.equalsIgnoreCase("display: none;"))) {
												buttonList.get(i).click();
												break mainloop;
											}
										}
									}
									/**
									 * else { log(logger, "Assessment Name is
									 * not matched"); breakFlag = true; }
									 */
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

		logger.info("Method: clickTestTabAssessmentButtonNew End");
	}

	/**
	 * Method used to click on Proctor Card Front button.
	 * 
	 * @param assessmentType
	 *            Proctor
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
			waitUntillElementIsVisible(PropertiesRepository.getString("asmt.myati.test.tab.proctor.loc"));
			if (baseHandler.isDisplayed(PropertiesRepository.getString("asmt.myati.test.tab.proctor.loc"))) {
				List<WebElement> pracProcCardElement = baseHandler
						.findElements(PropertiesRepository.getString("asmt.myati.test.tab.proctor.loc"));
				if (CollectionUtils.isNotEmpty(pracProcCardElement)) {
					int size = pracProcCardElement.size();
					mainloop: for (int index = 0; index < size; index++) {
						if (breakFlag) {
							break;
						}
						WebElement assessmentTypeElement = pracProcCardElement.get(index);
						// Validating Assessment Type
						// WebElement assessmentTypeSingleElement =
						// assessmentTypeElement.findElement(By.cssSelector(PropertiesRepository.getString("asmt.myati.test.tab.assessment.type.loc")));
						WebElement assessmentTypeSingleElement = assessmentTypeElement.findElement(
								By.cssSelector("section[class='card proctored-assessment front'] header span"));

						if (assessmentTypeSingleElement != null) {
							String assessmentTypeValue = assessmentTypeSingleElement.getText().trim();
							if (StringUtils.isNotEmpty(assessmentTypeValue)
									&& assessmentTypeValue.equalsIgnoreCase(assessmentType)) {
								// Validating Assessment Name
								/*
								 * WebElement assessmentNameElement =
								 * assessmentTypeElement.findElement(By.
								 * cssSelector( PropertiesRepository.getString(
								 * "asmt.myati.test.tab.assessment.name.loc")));
								 */
								WebElement assessmentNameElement = assessmentTypeElement.findElement(
										By.cssSelector("section[class='card proctored-assessment front'] section div"));
								if (assessmentNameElement != null) {
									String assessmentNameValue = assessmentNameElement.getText().trim()
											.replaceAll("\\r\\n|\\r|\\n", " ");
									// String assNameIndex=
									// assessmentNameElement.getAttribute("id");
									if (StringUtils.isNotEmpty(assessmentNameValue)
											&& assessmentNameValue.equalsIgnoreCase(assessmentName)) {
										List<WebElement> buttonList = baseHandler
												.findElements(".button.primary-button.button-focus.focus-element-flag");
										for (int i = 0; i < buttonList.size(); i++) {
											if (!(buttonList.get(i).getAttribute("style")
													.equalsIgnoreCase("display: none;"))) {
												buttonList.get(i).click();
												break mainloop;
											}
										}
									}
									/**
									 * else { log(logger, "Assessment Name is
									 * not matched"); breakFlag = true; }
									 */

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
	 * This method is used to check the Assessment Pop up buttons buttons and
	 * click on the given button
	 * 
	 * @param loc
	 * @param size
	 * @return
	 * @throws DriverException
	 */
	public boolean isPopupButtonDisplayed(ArrayList<String> buttonList, String clickOnButton) throws DriverException {
		logger.info("Method: isPopupButtonDisplayed Start ");
		boolean flag = false;
		ArrayList<String> actualButtonList = new ArrayList<String>();
		List<WebElement> assessmentCompleteElement = baseHandler.findElements(".complete-assessment-dialog div button");
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
	
	public void enterProductID(String locator , String value)
	{		
		JavascriptExecutor ex = (JavascriptExecutor)driver;
		ex.executeScript("arguments[0].click();", driver.findElement(By.cssSelector(locator)));
		driver.findElement(By.cssSelector(locator)).sendKeys(value);
	}
}
