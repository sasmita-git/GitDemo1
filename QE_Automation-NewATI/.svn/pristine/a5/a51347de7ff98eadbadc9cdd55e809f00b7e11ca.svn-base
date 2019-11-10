package com.automation.newati.pages;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;

public class PeakHourTestingPage extends NewATIBasePage {

	private Logger logger = LogManager.getLogger(this.getClass());
	public String actualText = "";
	public BaseHandler baseHandler;
	private WindowHandler windowHandler;
	private MyReportPage myReportPage;
	private TutorialPage tutorialPage;
	
	public PeakHourTestingPage(WebDriver webDriver) {
		super(webDriver);
		baseHandler = new BaseHandler(driver);
		windowHandler = new WindowHandler(driver);
		myReportPage = new MyReportPage(driver);
		tutorialPage = new TutorialPage(driver);
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
	public double takeAssessment(boolean bool, boolean flagquestion, String complButtonName , String IIPHeaderName , int index)
			throws InterruptedException, DriverException {
		logger.info("takeAssessment starts");
		double timeTakenToLoadIPPPage = 0;
		try {
			waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.pleasewait.bufferLoc"));
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
			   List<WebElement> assessmentCompleteElement = baseHandler.findElements(".modal-section div button");
			   if(CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
			     int size = assessmentCompleteElement.size();
			     for(int intSize = 0; intSize < size; intSize++) {
			      WebElement quizCompElement = assessmentCompleteElement.get(intSize);
			      if(quizCompElement.getText().trim().contains(complButtonName)) {
			      //Get Time before clicking on 
			    	  long testStartTime = System.currentTimeMillis();	
			    	  quizCompElement.click();
			    	  
			    	  // Loading IPP Page. 
			    	 if(tutorialPage.verifyIPPHeaderAndClickCloseButtonPeakHour(IIPHeaderName , index))
			    	 {
			    		 long testEndTime = System.currentTimeMillis();
			    		 timeTakenToLoadIPPPage = TimeUnit.MILLISECONDS.toSeconds(testEndTime-testStartTime);
			    		 log(logger, "Time taken to Load IPP Page >>>>>> " + timeTakenToLoadIPPPage + " seconds");
			    	 }
   	  		       waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			       //waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			       //waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			       break;
			      }
			     }
			    }

			if (flagquestion) {
				viewResultFlag();
			}
			logger.info("takeAssessment Ends");
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
	public ArrayList<Double> takeTest(boolean bool, boolean breakFlag, boolean rationaleFlag, boolean flagquestion , String IPPHeaderName , int index)
			throws Exception {
		logger.info("Method : takeTest :::::::: Starts");
		
		double averageTimeForLoadingEachQues = 0;
		double timeForLoadingIPPPage = 0;
		try {

			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			switchToAssessmentFrameHandler();
			// Getting Total Question Number
			
			String maxQtnTextNo = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.learn.tab.question.no.loc1")).get(1)
					.getText();
			VerificationHandler.verifyFalse((maxQtnTextNo=="" || maxQtnTextNo==null), "Assessment Page Not loaded");

			// Convert String to Integer
			int maxCount = Integer.parseInt(maxQtnTextNo);

			// Getting Current Question Number
			String minQtnTextNo = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.learn.tab.question.no.loc1")).get(0)
					.getText();

			// Convert String to Integer
			int minCount = Integer.parseInt(minQtnTextNo);

			// Maximum Question minus Minimum Questions
			int count = maxCount - minCount;		
			long[] timeArray = new long [maxCount];

			for (int i = 0; i <= count; i++) {
				
				logger.info("Currently loaded Question no : " + baseHandler.findElements(PropertiesRepository.getString("new-atitesting.learn.tab.question.no.loc1")).get(0)
						.getText()); 
				List<WebElement> checkBoxElement = baseHandler.findElements(
						PropertiesRepository.getString("new-atitesting.generic.tutorial.checkbox.new.loc"));
				// List<WebElement> radioElement =
				// baseHandler.findElements(PropertiesRepository.getString("new-atitesting.generic.tutorial.radio.button.new.loc"));

				if (checkBoxElement != null) {
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkBoxElement.get(0));
					checkBoxElement.get(0).click();
					
				}
				else{
					baseHandler.findElement(PropertiesRepository.getString("new-atitesting.generic.tutorial.flag.value")).click();
				}
			
				if (i == count) {
					//switchToAssessmentFrameHandler();
					List<WebElement> buttonElement = baseHandler.findElements(
							PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
					if (CollectionUtils.isNotEmpty(buttonElement)) {
						if (buttonElement.get(0).isDisplayed()) {
							WebElement continueButtonElement = driver
									.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
							if (continueButtonElement != null) {
								continueButtonElement.sendKeys(Keys.ENTER);
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								if (!continueButtonElement.isEnabled()) {
									clickButton(
											PropertiesRepository.getString(
													"new-atitesting.myati.assessment.question.unanswered.close.loc"),
											0);
									clickAssessmemtType();
								}
							}
						}
					}
					long averageTime = 0;
					for(int j=0; j < timeArray.length ; j++)
					{
						averageTime = averageTime + timeArray[j];
					}
					averageTimeForLoadingEachQues = averageTime/timeArray.length;
					logger.info("Average time for loading each question is >>>>>>>>>>>> " + averageTimeForLoadingEachQues + " seconds"); 
					
					timeForLoadingIPPPage = this.takeAssessment(rationaleFlag, flagquestion, "Finalize and View Results" , IPPHeaderName , index);
					
				} else {
					if (i == 0 && flagquestion) {
						switchToAssessmentFrameHandler();
						verifyFlag(true);
						logger.info("Question has been flaged");
						Thread.sleep(4000);
					} else {
						//waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						//switchToAssessmentFrameHandler();
						//waitUntillElementIsVisible(PropertiesRepository.getString("new-atitesting.generic.tutorial.submit.new.loc"));
						List<WebElement> buttonElement = baseHandler.findElements(
								PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
						if (CollectionUtils.isNotEmpty(buttonElement)) {
							if (buttonElement.get(0).isDisplayed()) {
								WebElement continueButtonElement = driver
										.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
								if (continueButtonElement != null) {
									
									((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", continueButtonElement);
									continueButtonElement.sendKeys(Keys.ENTER);
									long testStartTime = System.currentTimeMillis();
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									long testEndTime = System.currentTimeMillis();
									timeArray[i] = TimeUnit.MILLISECONDS.toSeconds(testEndTime-testStartTime);
									
									if (verifyQuestionUnAsweredPopup()) {
										List<WebElement> assessmentCompleteElement = baseHandler
												.findElements(".modal-section button");
										if (CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
											assessmentCompleteElement.get(0).click();
										}
										// clickButton(PropertiesRepository.getString("new-atitesting.myati.assessment.question.unanswered.close.loc"),
										// 0);
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
			logger.info("Unable to take Assessment" + e);
			throw new DriverException("Unable to take Assessment", e);
		}
		//waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.pleasewait.bufferLoc "));
		ArrayList<Double> timeList = new ArrayList<Double>();
		timeList.add(averageTimeForLoadingEachQues);
		timeList.add(timeForLoadingIPPPage);
				
		logger.info("Method : takeTest :::::::: END");		
		return timeList;
	}
}
