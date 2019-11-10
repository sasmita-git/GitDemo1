package com.automation.id.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class ProctorPage extends IDBasePage {
	private Logger logger = LogManager.getLogger(this.getClass());
	public BaseHandler baseHandler;
	private TextHandler textHandler;
	private ButtonHandler buttonHandler;
	protected WebDriverWait wait;
	private WindowHandler windowHandler;
	
	public ProctorPage(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
		baseHandler = new BaseHandler(driver);
		textHandler = new TextHandler(driver);
		buttonHandler = new ButtonHandler(driver);
		wait = new WebDriverWait(driver, PropertiesRepository.getInt("global.driver.wait"));
		windowHandler = new WindowHandler(driver);
		
	}
	
	/**
	 * Method to used to login to application.
	 * 
	 * @param userName
	 * @param password
	 * @throws DriverException
	 */
	public void loginToApplication(String userName, String password)
			throws DriverException {
		logger.info("Method : loginToApplication :::::::: START");
		try {
			
			//loading the url
			driver.get(PropertiesRepository.getString("asmt.maint.new-atitesting.url"));
			
			// User Name
			 textHandler
					.writeText(PropertiesRepository
							.getString("asmt.homepage.userNameLoc"),
							userName);

			// Password
			textHandler
					.writeText(PropertiesRepository
							.getString("asmt.homepage.passwordLoc"),
							password);

			// Click Go Button
			buttonHandler
					.clickButton(PropertiesRepository
							.getString("asmt.goBtnLoc"));

			waitUntillBufferInvisible(PropertiesRepository
					.getString("asmt.pleasewait.bufferLoc"));
		} catch (DriverException e) {
			logger.info("Unable to login To Application");
			log(logger, "Unable to login To Application");
			throw new DriverException("Unable to login To Application", e);
		}
		logger.info("Method : loginToApplication :::::::: End");
	}
	
	/**
	 * This method is used to wait until buffer invisible
	 * 
	 * @author Saravanan Jothimani 
	 */
	public void waitUntillBufferInvisible(String loc) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(loc)));
	}
	

	/**
	 * This method is used to wait until the buffer image is completely load.
	 * @author Sanapati.Srinu
	 * @param loc
	 * @throws DriverException
	 */
	public void waitUntillLoadingImageIsDisappeared(String loc) throws DriverException {
		logger.info("Method: waitUntillLoadingImageIsDisappeared Starts");
    	try {
    		List<WebElement> buffecImage = baseHandler.findElements(PropertiesRepository
					.getString(loc));
    		try {
    			while(String.valueOf(buffecImage.size())!=null)
        		{
        			logger.info("page is still loading after click on the element");
        			buffecImage=baseHandler.findElements(PropertiesRepository
        					.getString(loc));
        		}
    			waitUntillOverlayImageIsDisappeared("new-atitesting.peasewait.bufferLoc1");
			} catch (Exception e) {
				waitUntillOverlayImageIsDisappeared("new-atitesting.peasewait.bufferLoc1");
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
	 * This method is used to wait until the buffer image is completely load.
	 * @author Sanapati.Srinu
	 * @param loc
	 * @throws DriverException
	 */
	public void waitUntillOverlayImageIsDisappeared(String loc) throws DriverException {
		logger.info("Method: waitUntillOverlayImageIsDisappeared Starts");
    	try {
    		List<WebElement> buffecImage = baseHandler.findElements(PropertiesRepository
					.getString(loc));
    		try {
    			while(String.valueOf(buffecImage.size())!=null)
        		{
        			logger.info("page is still loading after click on the element");
        			buffecImage=baseHandler.findElements(PropertiesRepository
        					.getString(loc));
        			
        		}
			} catch (Exception e) {
				logger.info("page is loaded successfully");
			}
    		
    	} catch (Exception e) {
    		logger.info("Unable to wait Untill Overlay Image Is not Disappeared" );
			log(logger, "Unable to wait Untill Overlay Image Is not Disappeared" );
    		throw new DriverException("Unable to wait Untill Overlay Image Is not Disappeared" , e); 
    	}
    	logger.info("waitUntillOverlayImageIsDisappeared End");
	}
	
	/**
	 * Method used to enter Proctor Id and Pwd.
	 * 
	 * @author saravanan.jothimani
	 * ".focus-element-flag.focus-on"
	 */
	public void enterValue(String selector, String text)
			throws Exception {
		logger.info("Method: enterProctorIDAndPwd Starts");
		try {
			windowHandler.switchToLatestWindow();
			List<WebElement> element = baseHandler.findElements(selector);
			if(CollectionUtils.isNotEmpty(element)) {
				element.get(0).sendKeys(text.trim());
			}
		} catch (Exception e) {
			logger.info("Unable to enter Proctor ID And Pwd");
			log(logger, "Unable to enter Proctor ID And Pwd");
			throw new DriverException("Unable to enter Proctor ID And Pwd", e);
		}
		logger.info("Method: enterProctorIDAndPwd End ");
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
    		List<WebElement> maxQuestElement = baseHandler.findElements("#litNumPages");
    		List<WebElement> minQuestElement = baseHandler.findElements("#litCurrPage");
    		if(CollectionUtils.isNotEmpty(maxQuestElement) && CollectionUtils.isNotEmpty(minQuestElement)) {
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
	
	public boolean verifyCalculator() throws DriverException {
		logger.info("Method: verifyCalculator Starts");
		boolean flag = false;
    	try {
    		List<WebElement> calculatorElement = baseHandler.findElements("#btnCalcUI");
    		if(CollectionUtils.isNotEmpty(calculatorElement) ) {
    			calculatorElement.get(0).click();
    			List<WebElement> closeButtonElement = baseHandler.findElements("#dwindow span table tbody tr td input");
    			if(CollectionUtils.isNotEmpty(closeButtonElement)) {
    				closeButtonElement.get(0).click();
    			}
    			flag = true;
    		}
    	} catch (Exception e) {
    		logger.info("Unable to verifyCalculator");
			log(logger, "Unable to verifyCalculator" );
    		throw new DriverException("Unable to verifyCalculator" , e); 
    	}
    	logger.info("Method: verifyCalculator End flag --> " + flag);
    	return flag;
	}
	/**
	 * @author Sanapati.Srinu
	 * @return
	 * @throws Exception
	 */
	public boolean takeITRProctorAssessment() throws Exception {
		logger.info("Method : takeITRProctorAssessment :::::::: Starts");
		boolean flag=false;
		boolean optionFlag = false;
		boolean continueFlag = false;
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
						// Getting first question.
						WebElement questionElement = allQuestionElement.get(subIndex);
						if(questionElement != null) {
							// Need to identify the type of question and enter its answer
							optionFlag = clickQuestionTypeFlag(questionElement);
							if(optionFlag) {
								continueFlag = true;
							}
						}
					}
					// Next Page.
					List<WebElement> nextButton = baseHandler.findElements("#btnNextUI");
					if(CollectionUtils.isNotEmpty(nextButton)) {
						nextButton.get(0).click();
					}
					Thread.sleep(5000);
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
						Thread.sleep(10000);
					}
				}
				
				if(breakFlag) {
					Thread.sleep(5000);
					// Finish Button. #btnFinishUI 
					List<WebElement> okButton = baseHandler.findElements("#btnOk");
					if(CollectionUtils.isNotEmpty(okButton)) {
						try {
							okButton.get(0).click();
						} catch (Exception e) {
							logger.info("Popup window not available");
						}
					}
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
			logger.info("unable to take ITR assessment" + e);
		}

		logger.info("Method : takeITRProctorAssessment :::::::: END");
		return flag;
	}
	
	public boolean clickQuestionTypeFlag(WebElement element) throws Exception {
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
	 * Method used to verify IPP Page Header "Individual Performance Profile"
	 * 
	 * @author saravanan.jothimani
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
								PropertiesRepository.getString("new-ati.report.header.value"))) {
					flag = true;
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verify IPP Page Header");
			log(logger, "Unable to verify IPP Page Header");
			throw new DriverException("Unable to verify IPP Page Header", e);
		}
		logger.info("Method: verifyIPPPageHeader End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to click on Button with index. 
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @param index
	 * @throws Exception
	 */
	public void clickButtonWithSwitchToDefault(String locator, int index) throws Exception {
		logger.info("Method: clickButtonWithSwitchToDefault Starts");
    	try {
    		windowHandler.switchToLatestWindow();
    		List<WebElement> element = baseHandler.findElements(locator);
    		if(CollectionUtils.isNotEmpty(element)) {
    			element.get(index).click();
    		}
    	} catch (Exception e) {
    		logger.info("Unable to click Button With Switch To Default" );
			log(logger, "Unable to click Button With Switch To Default" );
    		throw new DriverException("Unable to click Button With Switch To Default" , e); 
    	}
    	logger.info("Method: clickButtonWithSwitchToDefault End " );
	}

	/**
	 * This method is used wait until IPP page is loaded.
	 * 
	 * @author Abhishek Kumar
	 * @throws InterruptedException
	 */
	public void waitUntillIPPPageIsLoaded(String loc) throws Exception {
		logger.info("Method: waitUntillIPPPageIsLoaded Starts");
    	try {
    		List<WebElement> element = baseHandler.findElements(loc); 
    		if(CollectionUtils.isNotEmpty(element)) {
    			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(loc)));
    		}
    	} catch (Exception e) {
    		logger.info("Unable to wait Untill Loading Image Is not Disappeared" );
			log(logger, "Unable to wait Untill Loading Image Is not Disappeared" );
    		throw new DriverException("Unable to wait Untill Loading Image Is Disappeared" , e); 
    	}
    	logger.info("waitUntillIPPPageIsLoaded End");
	}

	/**
	 * Method used to click on Button with index. 
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @param index
	 * @throws Exception
	 */
	public void clickButtonForProctor(String locator, int index) throws Exception {
		logger.info("Method: clickButton Starts");
		try {
    		List<WebElement> element = baseHandler.findElements(locator);
    		if(CollectionUtils.isNotEmpty(element)) {
    			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element.get(index));
    			element.get(index).click();
    		}
    	} catch (Exception e) {
    		logger.info("Unable to click Button" );
			log(logger, "Unable to click Button" );
    		throw new DriverException("Unable to click Button" , e); 
    	}
    	logger.info("Method: clickButton End " );
	}

	/**
	 * @author Sanapati.Srinu
	 * @return
	 * @throws Exception
	 */
	public double takeTEASProctorAssessmentFinalize() throws Exception {
		logger.info("Method : takeTEASProctorAssessmentFinalize :::::::: Starts");
		boolean flag=false;
		boolean optionFlag = false;
		boolean continueFlag = false;
		double averageTimeForLoadingEachQues = 0;
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
		return averageTimeForLoadingEachQues;
	}
	
	/**
	 * @author Sanapati.Srinu
	 * @return
	 * @throws Exception
	 */
	public double takeTEASProctorAssessmentSurvey() throws Exception {
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
						nextButton.get(0).click();
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
						//waitUntillLoadingImageIsDisappearedForProctor("#spnMsgBox");
						Thread.sleep(1000);
					}
				}
				
				if(breakFlag) {
					Thread.sleep(5000);
					
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
		} catch (DriverException e) {
			logger.info("unable to take ITR assessment" + e);
		}

		logger.info("Method : takeTEASProctorAssessmentSurvey :::::::: END");
		return IPPStartTime;
	}
	
	
	/**
	 * @author Sanapati.Srinu
	 * @return
	 * @throws Exception
	 */
	public double takeTEASProctorAssessmentContinue() throws Exception {
		logger.info("Method : takeTEASProctorAssessmentContinue :::::::: Starts");
		boolean optionFlag = false;
		boolean continueFlag = false;
		double averageTimeForLoadingEachQues = 0;
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
					logger.info("Average time for loading each question in this section is >>>>>>>>>>>> " + averageTimeForLoadingEachQues + " milliseconds"); 
					
					List<WebElement> okButton = baseHandler.findElements("#btnNextUI_2");
					if(CollectionUtils.isNotEmpty(okButton)) {
						try {
							okButton.get(0).click();
						} catch (Exception e) {
							logger.info("Popup window not available");
						}
					}
					Thread.sleep(5000);
					/*// Finish Button. #btnFinishUI 
					List<WebElement> finishButton = baseHandler.findElements("#btnContinueUI");
					if(CollectionUtils.isNotEmpty(finishButton)) {
						finishButton.get(0).click();
						flag = true;
					}*/
				}
			}
		} catch (DriverException e) {
			logger.info("unable to take ITR assessment" + e);
		}

		logger.info("Method : takeTEASProctorAssessmentContinue :::::::: END");
		return averageTimeForLoadingEachQues;
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
}
