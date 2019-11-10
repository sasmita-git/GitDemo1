package com.automation.asmt.page;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.TextHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;

public class ProctorRNCompPredPage extends ASMTBasePage {
	private Logger logger = LogManager.getLogger(this.getClass());

	private WindowHandler windowHandler;
	public BaseHandler baseHandler;
	private TextHandler textHandler;
	protected WebDriverWait wait;
	
	public ProctorRNCompPredPage(WebDriver webDriver) {
		super(webDriver);
		baseHandler = new BaseHandler(driver);
		textHandler = new TextHandler(driver);
		wait = new WebDriverWait(driver, PropertiesRepository.getInt("global.driver.wait"));
		windowHandler = new WindowHandler(driver);
	}
	
	/**
	 * @author Sanapati.Srinu
	 * @return
	 * @throws Exception
	 */
	public boolean takeRNCompPredProctorAssessment() throws Exception {
		logger.info("Method : takeTEASProctorAssessmentFinalize :::::::: Starts");
		boolean flag=false;
		boolean optionFlag = false;
		boolean continueFlag = false;
		double averageTimeForLoadingEachQues = 0;
		try {
			
			// Getting Total Question Number
			List<WebElement> ques = baseHandler.findElements(".sub-header h1 span");
			String maxQtnTextNo = ques.get(1).getText();

			// Convert String to Integer
			int maxCount = Integer.parseInt(maxQtnTextNo);

			// Getting Current Question Number
			
			String minQtnTextNo = ques.get(0).getText();

			// Convert String to Integer
			int minCount = Integer.parseInt(minQtnTextNo);

			// Maximum Question minus Minimum Questions
			int count = maxCount - minCount;
			long[] timeArray = new long [maxCount];
			boolean breakFlag = false;
			for (int i = 0; i <= count; i++) {

				int currPageCount = Integer.parseInt(textHandler.getText("#ques.get(0).getText()"));
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
							optionFlag = clickQuestionTypeFlagMultiple(questionElement);
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
					//Thread.sleep(5000);
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
						waitUntillLoadingImageIsDisappearedForProctor("#spnMsgBox");
						//waitUntillLoadingImageIsDisappearedForProctor("#spnMsgBox"); display: inline;
						Thread.sleep(1000);
					}
				}
				
				if(breakFlag) {
					Thread.sleep(5000);
					
					// Calculating Time. 
					long averageTime = 0;
					for(int j=0; j < timeArray.length ; j++)
					{
						averageTime = averageTime + timeArray[j];
					}
					averageTimeForLoadingEachQues = averageTime/timeArray.length;
					logger.info("Average time for loading each question in this section is >>>>>>>>>>>> " + averageTimeForLoadingEachQues + " milliseconds");
					
					// Finish Button. #btnFinishUI 
					List<WebElement> okButton = baseHandler.findElements("#btnOk");
					if(CollectionUtils.isNotEmpty(okButton)) {
						try {
							okButton.get(0).click();
						} catch (Exception e) {
							logger.info("Popup window not available");
						}
					}
					waitUntillLoadingImageIsDisappearedForProctor("#spnMsgBox");
					//Thread.sleep(5000); 
					// Finish Button. #btnFinishUI 
					List<WebElement> finishButton = baseHandler.findElements("#btnContinueUI");
					if(CollectionUtils.isNotEmpty(finishButton)) {
						finishButton.get(0).click();
						flag = true;
					}
				}
			}
		} catch (DriverException e) {
			logger.info("unable to take ITR assessment" + e);
		}

		logger.info("Method : takeTEASProctorAssessmentFinalize :::::::: END");
		return flag;
	}
	
	public boolean clickQuestionTypeFlagMultiple(WebElement element) throws Exception {
		boolean flag = false;
		try {
			if(element != null) {
				// Getting 4th tr to get individual question type.
				List<WebElement> individualQuestion = element.findElements(By.cssSelector("table[class='questionFont'] tr"));
				
				if(CollectionUtils.isNotEmpty(individualQuestion)) {

					int size = individualQuestion.size();
					if(size == 1) { // Can be drag and drop or hotspot
						List<WebElement> dndQuestionType = individualQuestion.get(0).findElements(By.cssSelector("td"));
						if(CollectionUtils.isNotEmpty(dndQuestionType) && dndQuestionType.size() == 3) {
							logger.info("Issues in Drag and Drope");
							flag = true;
						}
					} else if(size == 4) { // Radio Button
						List<WebElement> radioBtnQuestionType = individualQuestion.get(0).findElements(By.cssSelector("td"));
						if(CollectionUtils.isNotEmpty(radioBtnQuestionType)) {
							WebElement radioElement = radioBtnQuestionType.get(0); 
							List<WebElement> allRadioElement = radioElement.findElements(By.cssSelector("input[type='radio']"));
							if(CollectionUtils.isNotEmpty(allRadioElement)) {
								allRadioElement.get(0).click();
							}
						}
					} else if(size == 5) {// Check Box
						List<WebElement> checkBoxBtnQuestionType = individualQuestion.get(0).findElements(By.cssSelector("td"));
						if(CollectionUtils.isNotEmpty(checkBoxBtnQuestionType)) {
							WebElement checkBoxElement = checkBoxBtnQuestionType.get(0); 
							List<WebElement> allCheckBoxElement = checkBoxElement.findElements(By.cssSelector("input[type='checkbox']"));
							if(CollectionUtils.isNotEmpty(allCheckBoxElement)) {
								allCheckBoxElement.get(0).click();
							}
						}
					}
						
				} else {
					// Checking for Text box
					List<WebElement> inputElement = element.findElements(By.cssSelector("td input[type='text']"));
					if(CollectionUtils.isNotEmpty(inputElement)) {
						inputElement.get(0).sendKeys("10");
					}
					flag = true;
					// Checking for Image.
					/*List<WebElement> imgElement = element.findElements(By.cssSelector("td img"));
					if(CollectionUtils.isNotEmpty(imgElement)) {
						logger.info("Not clicking on Image");
					}*/
				}
			}
		} catch (Exception e) {
			throw new DriverException("Unable to click on Question type", e);
		}
		return flag;
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
	 * @author Sanapati.Srinu
	 * @return
	 * @throws Exception
	 */
	public boolean takeTEASProctorAssessmentSurvey() throws Exception {
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
							optionFlag = clickQuestionTypeFlagSurvey(questionElement);
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
							flag = true;
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
		return flag;
	}
	
	public boolean clickQuestionTypeFlagSurvey(WebElement element) throws Exception {
		boolean flag = false;
		try {
			if(element != null) {
				// Getting 4th tr to get individual question type.
				// .questionFont>tbody>tr>td textarea[id*='ctlQuestionID4_TxtBox'] input[id*='ctlQuestionID3_Choice'] input[id*='ctlQuestionID2_TxtBox']
				
				// Text Box1 
				List<WebElement> txtBox1 = element.findElements(By.cssSelector("input[id*='ctlQuestionID0_TxtBox']"));
				if(CollectionUtils.isNotEmpty(txtBox1)) {
					txtBox1.get(0).sendKeys("10");
				}
				
				// Text Box2
				List<WebElement> txtBox2 = element.findElements(By.cssSelector("input[id*='ctlQuestionID1_TxtBox']"));
				if(CollectionUtils.isNotEmpty(txtBox2)) {
					txtBox2.get(0).sendKeys("11");
				}
				
				// Text Box3
				List<WebElement> txtBox3 = element.findElements(By.cssSelector("input[id*='ctlQuestionID2_TxtBox']"));
				if(CollectionUtils.isNotEmpty(txtBox3)) {
					txtBox3.get(0).sendKeys("12");
				}
				
				// Radio Button 
				List<WebElement> radioBtnQuestionTypeNew = element.findElements(By.cssSelector("input[id*='ctlQuestionID3_Choice']"));
				if(CollectionUtils.isNotEmpty(radioBtnQuestionTypeNew)) {
					radioBtnQuestionTypeNew.get(0).click();
				}
				
				// Text Area
				List<WebElement> txtArea = element.findElements(By.cssSelector("textarea[id*='ctlQuestionID4_TxtBox']"));
				if(CollectionUtils.isNotEmpty(txtArea)) {
					txtArea.get(0).sendKeys("13");
				}
			}
		} catch (Exception e) {
			throw new DriverException("Unable to click on Question type", e);
		}
		return flag;
	}
}
