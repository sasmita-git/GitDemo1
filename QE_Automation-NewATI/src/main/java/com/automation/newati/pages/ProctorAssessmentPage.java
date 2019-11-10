package com.automation.newati.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.ButtonHandler;
import com.ascendlearning.automation.ui.handlers.TextHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;

public class ProctorAssessmentPage extends MyATITabMainPage {

	private Logger logger = LogManager.getLogger(this.getClass());
	public BaseHandler baseHandler;
	private TextHandler textHandler;
	protected WebDriverWait wait;
	private WindowHandler windowHandler;
	
	public ProctorAssessmentPage(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
		baseHandler = new BaseHandler(driver);
		textHandler = new TextHandler(driver);
		wait = new WebDriverWait(driver, PropertiesRepository.getInt("global.driver.wait"));
		windowHandler = new WindowHandler(driver);
		
	}
	
	/**
	 * This method is used to wait until the buffer image is completely load.
	 * @author Sanapati.Srinu
	 * @param loc
	 * @throws DriverException
	 */
	public void waitUntillLoadingImageIsDisappearedForProctor(String loc) throws DriverException {
		logger.info("Method: waitUntillLoadingImageIsDisappeared Starts");
    	try {
    		List<WebElement> buffecImage = baseHandler.findElements(loc);
    		try {
    			while(String.valueOf(buffecImage.size())!=null)
        		{
	    			if(CollectionUtils.isNotEmpty(buffecImage)) {
	    				String loadingImg = buffecImage.get(0).getAttribute("style");
	    				if(loadingImg != null) {
	    					if(!loadingImg.contains("display: inline;")) {
	    						break;
	    					} else {
	    						logger.info("Page is still loading for proctor assessment");
	    					}
	    				} 
	    			}
        		}
    			/*while(String.valueOf(buffecImage.size())!=null)
        		{
        			logger.info("page is still loading after click on the element");
        			buffecImage=baseHandler.findElements(PropertiesRepository
        					.getString(loc));
        		}*/
			} catch (Exception e) {
				logger.info("page is loaded successfully");
			}
    		
    	} catch (Exception e) {
    		logger.info("Unable to wait Untill Loading Image Is not Disappeared" );
			log(logger, "Unable to wait Untill Loading Image Is not Disappeared" );
    		throw new DriverException("Unable to wait Untill Loading Image Is not Disappeared" , e); 
    	}
    	logger.info("waitUntillLoadingImageIsDisappeared End");
	}
	
	/**
	 * @author Vaishali.Katta
	 * @return
	 * @throws Exception
	 */
	public boolean takeTEASProctorAssessmentContinue_PNCP2014() throws Exception {
		logger.info("Method : takeTEASProctorAssessmentContinue_PNCP2014 :::::::: Starts");
		boolean optionFlag = false;
		boolean continueFlag = false;
		boolean flag = false;
		
		try {
			
			// Getting Total Question Number
			String maxQtnTextNo = textHandler.getText("#litNumPages");
			// Convert String to Integer
			int maxCount = Integer.parseInt(maxQtnTextNo);

			// Getting Current Question Number
			String minQtnTextNo = textHandler.getText("#litCurrPage");
			// Convert String to Integer
			int minCount = Integer.parseInt(minQtnTextNo);

			// Maximum Question minus Minimum Questions
			int count = maxCount - minCount;
			
			long[] timeArray = new long [maxCount];
			boolean breakFlag = false;
			for (int i = 0; i <= count; i++) {
				int currPageCount = Integer.parseInt(textHandler.getText("#litCurrPage"));
				if(maxCount == currPageCount) {
					breakFlag = true;
				}
				List<WebElement> allQuestionElement = baseHandler.findElements(".testpagebox #spanTestWindow>table>tbody>tr");
				if(CollectionUtils.isNotEmpty(allQuestionElement)) {
					int trIndex = allQuestionElement.size();
					
					for(int subIndex = 0; subIndex < trIndex; subIndex++) {
						// Getting first question.
						WebElement questionElement = allQuestionElement.get(subIndex);
						if(questionElement != null) {
							// Need to identify the type of question and enter its answer
							optionFlag = clickQuestionTypeFlagMultiple_New(questionElement);
							/*if(optionFlag) {
								continueFlag = true;
							}*/
						}
					}
					// Next Page.
					List<WebElement> nextButton = baseHandler.findElements("#btnNextUI");
					if(CollectionUtils.isNotEmpty(nextButton)) {
						long testStartTime = System.currentTimeMillis();
						logger.info("Start time for Question load -->" + testStartTime);
						nextButton.get(0).click();
						if(i != count) {
							waitUntillLoadingImageIsDisappearedForProctor("#spnMsgBox");
						}
						long testEndTime = System.currentTimeMillis();
						logger.info("End time for Question load -->" + testEndTime);
						timeArray[i] = TimeUnit.MILLISECONDS.toMillis(testEndTime-testStartTime);
					}
					if(continueFlag) {
						windowHandler.switchToLatestWindow();
						List<WebElement> okCancelPopup = baseHandler.findElements("#spnMsgBox #btnOK");
						if(okCancelPopup != null &&  CollectionUtils.isNotEmpty(okCancelPopup) && okCancelPopup.size() > 0 ) {
							try {
								okCancelPopup.get(0).click();
							} catch (Exception e) {
								logger.info("Popup window not available");
							}
							}
						windowHandler.switchToLatestWindow();
						Thread.sleep(5000);
					}
				}
				
				if(breakFlag) {
					Thread.sleep(5000);
					windowHandler.switchToLatestWindow();
					// Logic to click End of Section. 
					List<WebElement> okCancelPopup = baseHandler.findElements("#spnMsgBox #btnOK");
					if (okCancelPopup != null && CollectionUtils.isNotEmpty(okCancelPopup)&& okCancelPopup.size() > 0) {
						try {
							okCancelPopup.get(0).click();
						} catch (Exception e) {
							logger.info("Popup window not available");
						}
					}

					// Next Section Button. 
					// #btnFinishUI
					
					/*long averageTime = 0;
					for(int j=0; j < timeArray.length ; j++)
					{
						averageTime = averageTime + timeArray[j];
					}*/
					/*averageTimeForLoadingEachQues = averageTime/timeArray.length;
					logger.info("Average time for loading each question in this section is >>>>>>>>>>>> " + averageTimeForLoadingEachQues + " milliseconds"); 
*/					
					/*List<WebElement> okButton = baseHandler.findElements("#btnNextUI_2");
					if(CollectionUtils.isNotEmpty(okButton)) {
						try {
							okButton.get(0).click();
							//flag = true;
						} catch (Exception e) {
							logger.info("Popup window not available");
						}
					}*/
					waitUntillLoadingImageIsDisappearedForProctor("#spnMsgBox");
					Thread.sleep(5000);
					// Finish Button. #btnFinishUI 
					List<WebElement> finishButton = baseHandler.findElements("#btnContinueUI");
					if(CollectionUtils.isNotEmpty(finishButton)) {
						finishButton.get(0).click();
						flag = true;
					}
				}
			}
		} catch (DriverException e) {
			logger.info("unable to take ITR assessment in takeTEASProctorAssessmentContinue_RNL2013" + e);
		}

		logger.info("Method : takeTEASProctorAssessmentContinue_PNCP2014 :::::::: END flag -->" + flag);
		return flag;
	}
	
	/**
	 * @author syed.pasha
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Double> takeTEASProctorAssessmentContinue_PNCP2016() throws Exception {
		logger.info("Method : takeTEASProctorAssessmentContinue_PNCP2014 :::::::: Starts");
		boolean optionFlag = false;
		boolean continueFlag = false;
		boolean flag = false;
		double averageTimeForLoadingEachQues = 0;
		ArrayList<Double> doubleList = new ArrayList<Double>();
		
		try {
			
			// Getting Total Question Number
			String maxQtnTextNo = textHandler.getText("#litNumPages");
			// Convert String to Integer
			int maxCount = Integer.parseInt(maxQtnTextNo);

			// Getting Current Question Number
			String minQtnTextNo = textHandler.getText("#litCurrPage");
			// Convert String to Integer
			int minCount = Integer.parseInt(minQtnTextNo);

			// Maximum Question minus Minimum Questions
			int count = maxCount - minCount;
			
			long[] timeArray = new long [maxCount];
			boolean breakFlag = false;
			for (int i = 0; i <= count; i++) {
				int currPageCount = Integer.parseInt(textHandler.getText("#litCurrPage"));
				if(maxCount == currPageCount) {
					breakFlag = true;
				}
				List<WebElement> allQuestionElement = baseHandler.findElements(".testpagebox #spanTestWindow>table>tbody>tr");
				if(CollectionUtils.isNotEmpty(allQuestionElement)) {
					int trIndex = allQuestionElement.size();
					
					for(int subIndex = 0; subIndex < trIndex; subIndex++) {
						// Getting first question.
						WebElement questionElement = allQuestionElement.get(subIndex);
						if(questionElement != null) {
							// Need to identify the type of question and enter its answer
							optionFlag = clickQuestionTypeFlagMultiple_New(questionElement);
							/*if(optionFlag) {
								continueFlag = true;
							}*/
						}
					}
					// Next Page.
					List<WebElement> nextButton = baseHandler.findElements("#btnNextUI");
					if(CollectionUtils.isNotEmpty(nextButton)) {
						long testStartTime = System.currentTimeMillis();
						logger.info("Start time for Question load -->" + testStartTime);
						nextButton.get(0).click();
						if(i != count) {
							waitUntillLoadingImageIsDisappearedForProctor("#spnMsgBox");
						}
						long testEndTime = System.currentTimeMillis();
						logger.info("End time for Question load -->" + testEndTime);
						timeArray[i] = TimeUnit.MILLISECONDS.toMillis(testEndTime-testStartTime);
					}
					if(continueFlag) {
						windowHandler.switchToLatestWindow();
						List<WebElement> okCancelPopup = baseHandler.findElements("#spnMsgBox #btnOK");
						if(okCancelPopup != null &&  CollectionUtils.isNotEmpty(okCancelPopup) && okCancelPopup.size() > 0 ) {
							try {
								okCancelPopup.get(0).click();
							} catch (Exception e) {
								logger.info("Popup window not available");
							}
							}
						windowHandler.switchToLatestWindow();
						Thread.sleep(5000);
					}
				}
				
				if(breakFlag) {
					Thread.sleep(5000);
					windowHandler.switchToLatestWindow();
					// Logic to click End of Section. 
					List<WebElement> okCancelPopup = baseHandler.findElements("#spnMsgBox #btnOK");
					if (okCancelPopup != null && CollectionUtils.isNotEmpty(okCancelPopup)&& okCancelPopup.size() > 0) {
						try {
							okCancelPopup.get(0).click();
						} catch (Exception e) {
							logger.info("Popup window not available");
						}
					}

					// Next Section Button. 
					// #btnFinishUI
					
					long averageTime = 0;
					for(int j=0; j < timeArray.length ; j++)
					{
						averageTime = averageTime + timeArray[j];
					}
					averageTimeForLoadingEachQues = averageTime/timeArray.length;
					doubleList.add(averageTimeForLoadingEachQues);
					logger.info("Average time for loading each question in this section is >>>>>>>>>>>> " + averageTimeForLoadingEachQues + " milliseconds"); 
					
					/*List<WebElement> okButton = baseHandler.findElements("#btnNextUI_2");
					if(CollectionUtils.isNotEmpty(okButton)) {
						try {
							okButton.get(0).click();
							//flag = true;
						} catch (Exception e) {
							logger.info("Popup window not available");
						}
					}*/
					waitUntillLoadingImageIsDisappearedForProctor("#spnMsgBox");
					Thread.sleep(5000);
					// Finish Button. #btnFinishUI 
					List<WebElement> finishButton = baseHandler.findElements("#btnContinueUI");
					if(CollectionUtils.isNotEmpty(finishButton)) {
						//IPP page Start time
						log(logger, "---------->>>>> IPP Page loading start");
						doubleList.add((double) System.currentTimeMillis());
						finishButton.get(0).click();
						flag = true;
					}
				}
			}
		} catch (DriverException e) {
			logger.info("unable to take ITR assessment in takeTEASProctorAssessmentContinue_RNL2013" + e);
		}

		logger.info("Method : takeTEASProctorAssessmentContinue_PNCP2014 :::::::: END flag -->" + flag);
		return doubleList;
	}
	
	/**
	 * @author Vaishali.Katta
	 * @return
	 * @throws Exception
	 */
	public boolean clickQuestionTypeFlagMultiple_New(WebElement element) throws Exception {
		boolean flag = false;
		try {
			if(element != null) {

				List<WebElement> radioElements = element.findElements(By.cssSelector(PropertiesRepository.getString("new-atitesting.proctor.assessment.page.radio.button")));
				boolean radioFlag = radioElements.size()>0;
				List<WebElement> checkboxElements = element.findElements(By.cssSelector(PropertiesRepository.getString("new-atitesting.proctor.assessment.page.checkbox")));
				boolean checkboxFlag = checkboxElements.size()>0;
				List<WebElement> dragAnddropElements = element.findElements(By.cssSelector(PropertiesRepository.getString("new-atitesting.proctor.assessment.page.draganddrop")));
				boolean dragAnddropFlag = dragAnddropElements.size()==1;
				List<WebElement> textboxElements = element.findElements(By.cssSelector(PropertiesRepository.getString("new-atitesting.proctor.assessment.page.textbox")));
				boolean textFlag = textboxElements.size()>0;
				List<WebElement> imageElements = element.findElements(By.cssSelector(PropertiesRepository.getString("new-atitesting.proctor.assessment.page.hotspot.image")));
				boolean imageFlag = imageElements.size()>0;
				
				if (radioFlag) {
					radioElements.get(0).click();
					flag=true;
				}else if (checkboxFlag) {
					checkboxElements.get(0).click();
					flag=true;
				}else if (dragAnddropFlag) {
					flag=true;
				}else if (textFlag) {
					wait.until(ExpectedConditions.visibilityOf(textboxElements.get(0)));
					textboxElements.get(0).sendKeys("10");
					flag=true;
				}else if (imageFlag) {
					wait.until(ExpectedConditions.visibilityOf(imageElements.get(0)));
					imageElements.get(0).click();
					flag=true;
				}
			}
			} catch (Exception e) {
			throw new DriverException("Unable to click on Question type", e);
		}
		return flag;
	}
	
	/**
	 * @author Sanapati.Srinu
	 * @return
	 * @throws Exception
	 */
	public double takeTEASProctorAssessmentSurvey_pncp2014() throws Exception {
		logger.info("Method : takeTEASProctorAssessmentSurvey :::::::: Starts");
		boolean flag=false;
		boolean optionFlag = false;
		boolean continueFlag = false;
		double IPPStartTime = 0;
		try {
			
			// Getting Total Question Number
			String maxQtnTextNo = textHandler.getText("#litNumPages");

			// Convert String to Integer
			int maxCount = Integer.parseInt(maxQtnTextNo);

			// Getting Current Question Number
			String minQtnTextNo = textHandler.getText("#litCurrPage");

			// Convert String to Integer
			int minCount = Integer.parseInt(minQtnTextNo);

			// Maximum Question minus Minimum Questions
			int count = maxCount - minCount;

			boolean breakFlag = false;
			for (int i = 0; i <= count; i++) {

				int currPageCount = Integer.parseInt(textHandler.getText("#litCurrPage"));
				if(maxCount == currPageCount) {
					breakFlag = true;
				}
				List<WebElement> allQuestionElement = baseHandler.findElements(".testpagebox #spanTestWindow>table>tbody>tr");
				if(CollectionUtils.isNotEmpty(allQuestionElement)) {
					int trIndex = allQuestionElement.size();
					
					for(int subIndex = 0; subIndex < trIndex; subIndex++) {
						logger.info("Survery Questions --> " + subIndex);
						// Getting first question.
						WebElement questionElement = allQuestionElement.get(subIndex);
						if(questionElement != null) {
							// Need to identify the type of question and enter its answer
							optionFlag = clickQuestionTypeFlagMultiple_New(questionElement);
							/*if(optionFlag) {
								continueFlag = true;
							}*/
						}
					}
					// Next Page.
					List<WebElement> nextButton = baseHandler.findElements("#btnNextUI");
					if(CollectionUtils.isNotEmpty(nextButton)) {
						logger.info("Survery Questions Next Button ");
						nextButton.get(0).click();
					}
					//Thread.sleep(5000);
					if(continueFlag) {
						logger.info("Survery Questions Continue Button ");
						windowHandler.switchToLatestWindow();
						List<WebElement> okCancelPopup = baseHandler.findElements("#spnMsgBox #btnOK");
						if(okCancelPopup != null &&  CollectionUtils.isNotEmpty(okCancelPopup) && okCancelPopup.size() > 0 ) {
							try {
								okCancelPopup.get(0).click();
							} catch (Exception e) {
								logger.info("Popup window not available");
							}
							}
						windowHandler.switchToLatestWindow();
						//waitUntillLoadingImageIsDisappearedForProctor("#spnMsgBox");
						Thread.sleep(1000);
					}
				}
				
				if(breakFlag) {
					Thread.sleep(5000);
					logger.info("Survery Questions inside breakflag ");
					// Last Section Popup handling. 
					windowHandler.switchToLatestWindow();
					List<WebElement> okCancelPopup = baseHandler.findElements("#spnMsgBox #btnOK");
					if(okCancelPopup != null &&  CollectionUtils.isNotEmpty(okCancelPopup) && okCancelPopup.size() > 0 ) {
						try {
							// IPP Page will be called afer this.
							IPPStartTime = System.currentTimeMillis();
							okCancelPopup.get(0).click();
							waitUntillLoadingImageIsDisappearedForProctor("#spnMsgBox");
						} catch (Exception e) {
							logger.info("Popup window not available");
						}
					}
					windowHandler.switchToLatestWindow();
					
					/*// Finish Button. #btnFinishUI 
					List<WebElement> okButton = baseHandler.findElements("#btnOk");
					if(CollectionUtils.isNotEmpty(okButton)) {
						try {
							// IPP Page will be called afer this.
							IPPStartTime = System.currentTimeMillis();
							okButton.get(0).click();
						} catch (Exception e) {
							logger.info("Popup window not available");
						}
					}*/
				}
			}
		} catch (Exception e) {
			logger.info("unable to take ITR assessment" + e);
		}

		logger.info("Method : takeTEASProctorAssessmentSurvey :::::::: END");
		return IPPStartTime;
	}
	
	/**
	 * @author Vaishali.Katta
	 * @return
	 * @throws Exception
	 */
	public boolean takeTEASProctorAssessmentContinue_RNNCOC2013() throws Exception {
		logger.info("Method : takeTEASProctorAssessmentContinue_RNNCOC2013 :::::::: Starts");
		boolean optionFlag = false;
		boolean continueFlag = false;
		boolean flag = false;
		try {
			
			// Getting Total Question Number
			String maxQtnTextNo = textHandler.getText("#litNumPages");
			// Convert String to Integer
			int maxCount = Integer.parseInt(maxQtnTextNo);

			// Getting Current Question Number
			String minQtnTextNo = textHandler.getText("#litCurrPage");
			// Convert String to Integer
			int minCount = Integer.parseInt(minQtnTextNo);

			// Maximum Question minus Minimum Questions
			int count = maxCount - minCount;
			
			long[] timeArray = new long [maxCount];
			boolean breakFlag = false;
			for (int i = 0; i <= count; i++) {
				int currPageCount = Integer.parseInt(textHandler.getText("#litCurrPage"));
				if(maxCount == currPageCount) {
					breakFlag = true;
				}
				List<WebElement> allQuestionElement = baseHandler.findElements(".testpagebox #spanTestWindow>table>tbody>tr");
				if(CollectionUtils.isNotEmpty(allQuestionElement)) {
					int trIndex = allQuestionElement.size();
					
					for(int subIndex = 0; subIndex < trIndex; subIndex++) {
						// Getting first question.
						WebElement questionElement = allQuestionElement.get(subIndex);
						if(questionElement != null) {
							// Need to identify the type of question and enter its answer
							optionFlag = clickQuestionTypeFlagMultiple_New(questionElement);
							/*if(optionFlag) {
								continueFlag = true;
							}*/
						}
					}
					// Next Page.
					List<WebElement> nextButton = baseHandler.findElements("#btnNextUI");
					if(CollectionUtils.isNotEmpty(nextButton)) {
						long testStartTime = System.currentTimeMillis();
						logger.info("Start time for Question load -->" + testStartTime);
						nextButton.get(0).click();
						if(i != count) {
							waitUntillLoadingImageIsDisappearedForProctor("#spnMsgBox");
						}
						long testEndTime = System.currentTimeMillis();
						logger.info("End time for Question load -->" + testEndTime);
						timeArray[i] = TimeUnit.MILLISECONDS.toMillis(testEndTime-testStartTime);
					}
					if(continueFlag) {
						windowHandler.switchToLatestWindow();
						List<WebElement> okCancelPopup = baseHandler.findElements("#spnMsgBox #btnOK");
						if(okCancelPopup != null &&  CollectionUtils.isNotEmpty(okCancelPopup) && okCancelPopup.size() > 0 ) {
							try {
								okCancelPopup.get(0).click();
							} catch (Exception e) {
								logger.info("Popup window not available");
							}
							}
						windowHandler.switchToLatestWindow();
						Thread.sleep(5000);
					}
				}
				
				if(breakFlag) {
					Thread.sleep(5000);
					windowHandler.switchToLatestWindow();
					// Logic to click End of Section. 
					List<WebElement> okCancelPopup = baseHandler.findElements("#spnMsgBox #btnOK");
					if (okCancelPopup != null && CollectionUtils.isNotEmpty(okCancelPopup)&& okCancelPopup.size() > 0) {
						try {
							okCancelPopup.get(0).click();
						} catch (Exception e) {
							logger.info("Popup window not available");
						}
					}

					// Next Section Button. 
					// #btnFinishUI
					
					/*long averageTime = 0;
					for(int j=0; j < timeArray.length ; j++)
					{
						averageTime = averageTime + timeArray[j];
					}*/
					/*averageTimeForLoadingEachQues = averageTime/timeArray.length;
					logger.info("Average time for loading each question in this section is >>>>>>>>>>>> " + averageTimeForLoadingEachQues + " milliseconds"); 
*/					
					/*List<WebElement> okButton = baseHandler.findElements("#btnNextUI_2");
					if(CollectionUtils.isNotEmpty(okButton)) {
						try {
							okButton.get(0).click();
							//flag = true;
						} catch (Exception e) {
							logger.info("Popup window not available");
						}
					}*/
					waitUntillLoadingImageIsDisappearedForProctor("#spnMsgBox");
					Thread.sleep(5000);
					// Finish Button. #btnFinishUI 
					List<WebElement> finishButton = baseHandler.findElements("#btnFinishUI");
					if(CollectionUtils.isNotEmpty(finishButton)) {
						finishButton.get(0).click();
						flag = true;
					}
				}
			}
		} catch (DriverException e) {
			logger.info("unable to take ITR assessment in takeTEASProctorAssessmentContinue_RNL2013" + e);
		}

		logger.info("Method : takeTEASProctorAssessmentContinue_RNNCOC2013 :::::::: END flag -->" + flag);
		return flag;
	}
	
	/**
	 * @author Sanapati.Srinu
	 * @return
	 * @throws Exception
	 */
	public boolean takeTEASProctorAssessmentContinue_ITR() throws Exception {
		logger.info("Method : takeTEASProctorAssessmentContinue_RNL2013 :::::::: Starts");
		boolean optionFlag = false;
		boolean continueFlag = false;
		boolean flag = false;
		
		try {
			
			// Getting Total Question Number
			String maxQtnTextNo = textHandler.getText("#litNumPages");

			// Convert String to Integer
			int maxCount = Integer.parseInt(maxQtnTextNo);

			// Getting Current Question Number
			String minQtnTextNo = textHandler.getText("#litCurrPage");

			// Convert String to Integer
			int minCount = Integer.parseInt(minQtnTextNo);

			// Maximum Question minus Minimum Questions
			int count = maxCount - minCount;
			
			long[] timeArray = new long [maxCount];

			boolean breakFlag = false;
			for (int i = 0; i <= count; i++) {

				int currPageCount = Integer.parseInt(textHandler.getText("#litCurrPage"));
				if(maxCount == currPageCount) {
					breakFlag = true;
				}
				List<WebElement> allQuestionElement = baseHandler.findElements(".testpagebox #spanTestWindow>table>tbody>tr");
				if(CollectionUtils.isNotEmpty(allQuestionElement)) {
					int trIndex = allQuestionElement.size();
					
					for(int subIndex = 0; subIndex < trIndex; subIndex++) {
						// Getting first question.
						WebElement questionElement = allQuestionElement.get(subIndex);
						if(questionElement != null) {
							// Need to identify the type of question and enter its answer
							optionFlag = clickQuestionTypeFlagMultiple_New(questionElement);
							/*if(optionFlag) {
								continueFlag = true;
							}*/
						}
					}
					// Next Page.
					List<WebElement> nextButton = baseHandler.findElements("#btnNextUI");
					if(CollectionUtils.isNotEmpty(nextButton)) {
						long testStartTime = System.currentTimeMillis();
						logger.info("Start time for Question load -->" + testStartTime);
						nextButton.get(0).click();
						if(i != count) {
							//Clicking Ok button on the popup before clicking next button
							
							windowHandler.switchToLatestWindow();
							List<WebElement> okCancelPopup = baseHandler.findElements("#spnMsgBox #btnOK");
							if(okCancelPopup != null &&  CollectionUtils.isNotEmpty(okCancelPopup) && okCancelPopup.size() > 0 ) {
								try {
									okCancelPopup.get(0).click();
								} catch (Exception e) {
									logger.info("Popup window not available");
								}
								}
							windowHandler.switchToLatestWindow();
							Thread.sleep(5000);
							
							waitUntillLoadingImageIsDisappearedForProctor("#spnMsgBox");
						}
						long testEndTime = System.currentTimeMillis();
						logger.info("End time for Question load -->" + testEndTime);
						timeArray[i] = TimeUnit.MILLISECONDS.toMillis(testEndTime-testStartTime);
					}
					if(continueFlag) {
						windowHandler.switchToLatestWindow();
						List<WebElement> okCancelPopup = baseHandler.findElements("#spnMsgBox #btnOK");
						if(okCancelPopup != null &&  CollectionUtils.isNotEmpty(okCancelPopup) && okCancelPopup.size() > 0 ) {
							try {
								okCancelPopup.get(0).click();
							} catch (Exception e) {
								logger.info("Popup window not available");
							}
							}
						windowHandler.switchToLatestWindow();
						Thread.sleep(5000);
					}
				}
				
				if(breakFlag) {
					Thread.sleep(5000);
					windowHandler.switchToLatestWindow();
					// Logic to click End of Section. 
					List<WebElement> okCancelPopup = baseHandler
							.findElements("#spnMsgBox #btnOK");
					if (okCancelPopup != null
							&& CollectionUtils.isNotEmpty(okCancelPopup)
							&& okCancelPopup.size() > 0) {
						try {
							okCancelPopup.get(0).click();
						} catch (Exception e) {
							logger.info("Popup window not available");
						}
					}

					// Next Section Button. 
					// #btnFinishUI
					
					/*long averageTime = 0;
					for(int j=0; j < timeArray.length ; j++)
					{
						averageTime = averageTime + timeArray[j];
					}*/
					/*averageTimeForLoadingEachQues = averageTime/timeArray.length;
					logger.info("Average time for loading each question in this section is >>>>>>>>>>>> " + averageTimeForLoadingEachQues + " milliseconds"); 
*/					
					/*List<WebElement> okButton = baseHandler.findElements("#btnNextUI_2");
					if(CollectionUtils.isNotEmpty(okButton)) {
						try {
							okButton.get(0).click();
							//flag = true;
						} catch (Exception e) {
							logger.info("Popup window not available");
						}
					}*/
					waitUntillLoadingImageIsDisappearedForProctor("#spnMsgBox");
					Thread.sleep(5000);
					// Finish Button. #btnFinishUI 
					List<WebElement> finishButton = baseHandler.findElements("#btnFinishUI");
					if(CollectionUtils.isNotEmpty(finishButton)) {
						finishButton.get(0).click();
						flag = true;
					}
				}
			}
		} catch (DriverException e) {
			logger.info("unable to take ITR assessment in takeTEASProctorAssessmentContinue_RNL2013" + e);
		}

		logger.info("Method : takeTEASProctorAssessmentContinue_RNL2013 :::::::: END flag -->" + flag);
		return flag;
	}
	
	/**
	 * @author Sanapati.Srinu
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Double> takeTEASProctorAssessmentContinue_ITR_PeakHour() throws Exception {
		logger.info("Method : takeTEASProctorAssessmentContinue_RNL2013 :::::::: Starts");
		boolean optionFlag = false;
		boolean continueFlag = false;
		boolean flag = false;
		double averageTimeForLoadingEachQues = 0;
		ArrayList<Double> doubleList = new ArrayList<Double>();
		
		try {
			
			// Getting Total Question Number
			String maxQtnTextNo = textHandler.getText("#litNumPages");

			// Convert String to Integer
			int maxCount = Integer.parseInt(maxQtnTextNo);

			// Getting Current Question Number
			String minQtnTextNo = textHandler.getText("#litCurrPage");

			// Convert String to Integer
			int minCount = Integer.parseInt(minQtnTextNo);

			// Maximum Question minus Minimum Questions
			int count = maxCount - minCount;
			
			long[] timeArray = new long [maxCount];

			boolean breakFlag = false;
			for (int i = 0; i <= count; i++) {

				int currPageCount = Integer.parseInt(textHandler.getText("#litCurrPage"));
				if(maxCount == currPageCount) {
					breakFlag = true;
				}
				List<WebElement> allQuestionElement = baseHandler.findElements(".testpagebox #spanTestWindow>table>tbody>tr");
				if(CollectionUtils.isNotEmpty(allQuestionElement)) {
					int trIndex = allQuestionElement.size();
					
					for(int subIndex = 0; subIndex < trIndex; subIndex++) {
						// Getting first question.
						WebElement questionElement = allQuestionElement.get(subIndex);
						if(questionElement != null) {
							// Need to identify the type of question and enter its answer
							optionFlag = clickQuestionTypeFlagMultiple_New(questionElement);
							/*if(optionFlag) {
								continueFlag = true;
							}*/
						}
					}
					// Next Page.
					List<WebElement> nextButton = baseHandler.findElements("#btnNextUI");
					if(CollectionUtils.isNotEmpty(nextButton)) {
						long testStartTime = System.currentTimeMillis();
						logger.info("Start time for Question load -->" + testStartTime);
						nextButton.get(0).click();
						if(i != count) {
							//Clicking Ok button on the popup before clicking next button
							
							windowHandler.switchToLatestWindow();
							List<WebElement> okCancelPopup = baseHandler.findElements("#spnMsgBox #btnOK");
							if(okCancelPopup != null &&  CollectionUtils.isNotEmpty(okCancelPopup) && okCancelPopup.size() > 0 ) {
								try {
									okCancelPopup.get(0).click();
								} catch (Exception e) {
									logger.info("Popup window not available");
								}
								}
							windowHandler.switchToLatestWindow();
							Thread.sleep(5000);
							
							waitUntillLoadingImageIsDisappearedForProctor("#spnMsgBox");
						}
						long testEndTime = System.currentTimeMillis();
						logger.info("End time for Question load -->" + testEndTime);
						timeArray[i] = TimeUnit.MILLISECONDS.toMillis(testEndTime-testStartTime);
					}
					if(continueFlag) {
						windowHandler.switchToLatestWindow();
						List<WebElement> okCancelPopup = baseHandler.findElements("#spnMsgBox #btnOK");
						if(okCancelPopup != null &&  CollectionUtils.isNotEmpty(okCancelPopup) && okCancelPopup.size() > 0 ) {
							try {
								okCancelPopup.get(0).click();
							} catch (Exception e) {
								logger.info("Popup window not available");
							}
							}
						windowHandler.switchToLatestWindow();
						Thread.sleep(5000);
					}
				}
				
				if(breakFlag) {
					Thread.sleep(5000);
					windowHandler.switchToLatestWindow();
					// Logic to click End of Section. 
					List<WebElement> okCancelPopup = baseHandler
							.findElements("#spnMsgBox #btnOK");
					if (okCancelPopup != null
							&& CollectionUtils.isNotEmpty(okCancelPopup)
							&& okCancelPopup.size() > 0) {
						try {
							okCancelPopup.get(0).click();
						} catch (Exception e) {
							logger.info("Popup window not available");
						}
					}

					// Next Section Button. 
					// #btnFinishUI
					
					long averageTime = 0;
					for(int j=0; j < timeArray.length ; j++)
					{
						averageTime = averageTime + timeArray[j];
					}
					averageTimeForLoadingEachQues = averageTime/timeArray.length;
					doubleList.add(averageTimeForLoadingEachQues);
					logger.info("Average time for loading each question in this section is >>>>>>>>>>>> " + averageTimeForLoadingEachQues + " milliseconds"); 
					
					/*List<WebElement> okButton = baseHandler.findElements("#btnNextUI_2");
					if(CollectionUtils.isNotEmpty(okButton)) {
						try {
							okButton.get(0).click();
							//flag = true;
						} catch (Exception e) {
							logger.info("Popup window not available");
						}
					}*/
					waitUntillLoadingImageIsDisappearedForProctor("#spnMsgBox");
					Thread.sleep(5000);
					// Finish Button. #btnFinishUI 
					List<WebElement> finishButton = baseHandler.findElements("#btnFinishUI");
					if(CollectionUtils.isNotEmpty(finishButton)) {
						//IPP page Start time
						log(logger, "---------->>>>> IPP Page loading start");
						doubleList.add((double) System.currentTimeMillis());
						finishButton.get(0).click();						
						flag = true;
						
					}
				}
			}
		} catch (DriverException e) {
			logger.info("unable to take ITR assessment in takeTEASProctorAssessmentContinue_RNL2013" + e);
		}

		logger.info("Method : takeTEASProctorAssessmentContinue_RNL2013 :::::::: END flag -->" + flag);
		return doubleList;
	}
}
