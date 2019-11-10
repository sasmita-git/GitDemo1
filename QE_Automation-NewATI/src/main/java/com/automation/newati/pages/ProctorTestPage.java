package com.automation.newati.pages;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.ButtonHandler;
import com.ascendlearning.automation.ui.handlers.TextHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;

public class ProctorTestPage extends TestTabPage {

	private Logger logger = LogManager.getLogger(this.getClass());
	private BaseHandler baseHandler;
	private ButtonHandler buttonHandler;
	private TextHandler textHandler;
	private WindowHandler windowHandler;
	
	public ProctorTestPage(WebDriver webDriver) {
		super(webDriver);
		baseHandler = new BaseHandler(driver);
		buttonHandler = new ButtonHandler(driver);
		textHandler = new TextHandler(driver);
		windowHandler = new WindowHandler(driver);
	}

	public void clickQuestionType(WebElement element) throws Exception {
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
	} 
	
	public void clickTEASQuestionType(WebElement element) throws Exception {
		try {
			if(element != null) {
				// Getting 4th tr to get individual question type.
				List<WebElement> individualQuestion = element.findElements(By.cssSelector("table[class='questionFont'] tr"));
				
				if(CollectionUtils.isNotEmpty(individualQuestion)) {

					int size = individualQuestion.size();
					if(size == 4) { // Radio Button
						List<WebElement> radioBtnQuestionType = individualQuestion.get(0).findElements(By.cssSelector("td"));
						if(CollectionUtils.isNotEmpty(radioBtnQuestionType)) {
							WebElement radioElement = radioBtnQuestionType.get(0); 
							List<WebElement> allRadioElement = radioElement.findElements(By.cssSelector("input[type='radio']"));
							if(CollectionUtils.isNotEmpty(allRadioElement)) {
								allRadioElement.get(0).click();
							}
						}
					} 
				} 
			}
		} catch (Exception e) {
			throw new DriverException("Unable to click on Question type", e);
		}
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
								okCancelPopup.get(0).click();
							}
						windowHandler.switchToLatestWindow();
						Thread.sleep(10000);
					}
				}
				
				if(breakFlag) {
					Thread.sleep(10000);
					// Finish Button. #btnFinishUI 
					List<WebElement> finishButton = baseHandler.findElements("#btnFinishUI");
					if(CollectionUtils.isNotEmpty(finishButton)) {
						finishButton.get(0).click();
					}
				}
				
			}
		} catch (DriverException e) {
			logger.info("unable to take ITR assessment" + e);
		}

		logger.info("Method : takeITRProctorAssessment :::::::: END");
		return flag;
	}
	
	/**
	 * @author Sanapati.Srinu
	 * @return
	 * @throws Exception
	 */
	public boolean takeRNCompPredProctorAssessment() throws Exception {
		logger.info("Method : takeRNCompPredProctorAssessment :::::::: Starts");
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
								break;
							}
						}
					}
					// Next Page.
					List<WebElement> nextButton = baseHandler.findElements("#btnNextUI");
					if(CollectionUtils.isNotEmpty(nextButton)) {
						nextButton.get(0).click();
					}
					Thread.sleep(5000);
					/*if(continueFlag) {
						windowHandler.switchToLatestWindow();
						List<WebElement> okCancelPopup = baseHandler.findElements("#spnMsgBox #btnOK");
						if(okCancelPopup != null &&  CollectionUtils.isNotEmpty(okCancelPopup) && okCancelPopup.size() > 0 ) {
								okCancelPopup.get(0).click();
							}
						windowHandler.switchToLatestWindow();
						Thread.sleep(10000);
					}*/
				}
				
				if(breakFlag) {
					Thread.sleep(10000);
					// Finish Button. #btnFinishUI 
					List<WebElement> finishButton = baseHandler.findElements("#btnFinishUI");
					if(CollectionUtils.isNotEmpty(finishButton)) {
						finishButton.get(0).click();
					}
				}
				
			}
		} catch (DriverException e) {
			logger.info("unable to takeRNCompPredProctorAssessment" + e);
		}

		logger.info("Method : takeRNCompPredProctorAssessment :::::::: END");
		return flag;
	}
	
	/**
	 * @author Sanapati.Srinu
	 * @return
	 * @throws Exception
	 */
	public boolean takeTEASProctorAssessment_last() throws Exception {
		logger.info("Method : takeTEASProctorAssessment :::::::: Starts");
		boolean flag=false;
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
							clickTEASQuestionTypeFlag(questionElement);
						}
					}
					
					//Thread.sleep(10000);
					// Next Page.
					List<WebElement> nextButton = baseHandler.findElements("#btnNextUI");
					if(CollectionUtils.isNotEmpty(nextButton)) {
						nextButton.get(0).click();
					}
					Thread.sleep(10000);
					
					// Confirmation msg for un answered question
					if(breakFlag) {
						windowHandler.switchToLatestWindow();
						List<WebElement> okCancelPopup = baseHandler.findElements("#spnMsgBox #btnOK");
						if(okCancelPopup != null &&  CollectionUtils.isNotEmpty(okCancelPopup) && okCancelPopup.size() > 0 ) {
								okCancelPopup.get(0).click();
							}
						windowHandler.switchToLatestWindow();
						Thread.sleep(10000);
					}
				}
			}
		} catch (DriverException e) {
			logger.info("unable to take practice assessment" + e);
		}

		logger.info("Method : takeTEASProctorAssessment :::::::: END");
		return flag;
	}
	
	/**
	 * @author Sanapati.Srinu
	 * @return
	 * @throws Exception
	 */
	public boolean takeTEASProctorAssessment_1() throws Exception {
		logger.info("Method : takeTEASProctorAssessment :::::::: Starts");
		boolean flag=false;
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
					int totalAnsweredCount = trIndex/5;
					int answeredCount = 0;
					boolean continueFlag = false;
					for(int subIndex = 0; subIndex < trIndex; subIndex++) {
						// Getting first question.
						WebElement questionElement = allQuestionElement.get(subIndex);
						if(questionElement != null) {
							// Need to identify the type of question and enter its answer
							boolean selectedAnswerFlag = clickTEASQuestionTypeFlag(questionElement);
							if(selectedAnswerFlag) {
								answeredCount++;
								if(answeredCount == totalAnsweredCount - 1) {
									continueFlag = true;
									break;
								}
							}
						}
					}
					
					//Thread.sleep(10000);
					// Next Page.
					List<WebElement> nextButton = baseHandler.findElements("#btnNextUI");
					if(CollectionUtils.isNotEmpty(nextButton)) {
						nextButton.get(0).click();
					}
					Thread.sleep(10000);
					
					// If any one question is not answered, this popup will be displayed. 
					if(continueFlag & !breakFlag) {
						windowHandler.switchToLatestWindow();
						List<WebElement> okCancelPopup = baseHandler.findElements("#spnMsgBox #btnOK");
						if(okCancelPopup != null &&  CollectionUtils.isNotEmpty(okCancelPopup) && okCancelPopup.size() > 0 ) {
								okCancelPopup.get(0).click();
							}
						windowHandler.switchToLatestWindow();
						Thread.sleep(10000);
					}
					// Confirmation msg for un answered question
					if(breakFlag) {
						windowHandler.switchToLatestWindow();
						List<WebElement> okCancelPopup = baseHandler.findElements("#spnMsgBox #btnOK");
						if(okCancelPopup != null &&  CollectionUtils.isNotEmpty(okCancelPopup) && okCancelPopup.size() > 0 ) {
								okCancelPopup.get(0).click();
							}
						windowHandler.switchToLatestWindow();
						Thread.sleep(10000);
						
						//Thread.sleep(5000);
						// Next Page.
						List<WebElement> finalNextButton = baseHandler.findElements("input[id*='btnNextUI']");
						if(CollectionUtils.isNotEmpty(finalNextButton) && finalNextButton.size() == 2) {
							int btnCount = finalNextButton.size();
							for(int btnIndex = 0 ; btnIndex < btnCount; btnIndex++) {
								logger.info("Next button dispalyed or not --> " + finalNextButton.get(0).isDisplayed());
								logger.info("Next button dispalyed or not --> " + finalNextButton.get(1).isDisplayed());
								WebElement dispalyedElement = finalNextButton.get(btnIndex);
								if(dispalyedElement != null) {
									if(dispalyedElement.isDisplayed()) {
										dispalyedElement.click();
										Thread.sleep(10000);
										break;
									}
								}
							}
						}
					}
				}
			}
		} catch (DriverException e) {
			logger.info("unable to take practice assessment" + e);
		}

		logger.info("Method : takeTEASProctorAssessment :::::::: END");
		return flag;
	}
	
	/**
	 * @author Sanapati.Srinu
	 * @return
	 * @throws Exception
	 */
	public boolean takeTEASProctorAssessment_2() throws Exception {
		logger.info("Method : takeTEASProctorAssessment :::::::: Starts");
		boolean flag=false;
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

			for (int i = 0; i <= count; i++) {
				// If multiple Questions displayed in single page. 
				List<WebElement> currQuestionElement = baseHandler.findElements("#litCurrQuestions");
				int currQuestion = 0;
				int maxQuestion = 0;
				if(CollectionUtils.isNotEmpty(currQuestionElement)) {
					String[] totQuestionValue = currQuestionElement.get(0).getText().split("-");
					if(totQuestionValue != null && totQuestionValue.length>0) {
						currQuestion = Integer.parseInt(totQuestionValue[0]);
						maxQuestion = Integer.parseInt(totQuestionValue[1]);
					}					
				}
				
				if(currQuestion > 0 && maxQuestion > 0 ) { 
					for(int index = currQuestion; index <= maxQuestion; maxQuestion ++) {
						List<WebElement> allQuestionElement = baseHandler.findElements(".testpagebox #spanTestWindow>table>tbody>tr");
						int trIndex = allQuestionElement.size();
						if(CollectionUtils.isNotEmpty(allQuestionElement)) {
							for(int subIndex = 0; subIndex < trIndex; subIndex++) {
								// Getting first question.
								WebElement questionElement = allQuestionElement.get(subIndex);
								if(questionElement != null) {
									// Need to identify the type of question and enter its answer
									clickTEASQuestionType(questionElement);
								}
							}
							
							Thread.sleep(10000);
							// Next Page.
							List<WebElement> nextButton = baseHandler.findElements("#btnNextUI");
							if(CollectionUtils.isNotEmpty(nextButton)) {
								nextButton.get(0).click();
							}
							Thread.sleep(10000);
						}
					}
					
					// Confirmation msg for un answered question
					
					windowHandler.switchToLatestWindow();

					List<WebElement> okCancelPopup = baseHandler.findElements("#spnMsgBox #btnOK");
					if(CollectionUtils.isNotEmpty(okCancelPopup)) {
						okCancelPopup.get(0).click();
					} 
					windowHandler.switchToLatestWindow();

					
					Thread.sleep(10000);
					// Next Page.
					List<WebElement> nextButton = baseHandler.findElements("#btnNextUI_2");
					if(CollectionUtils.isNotEmpty(nextButton)) {
						nextButton.get(0).click();
					}
				}
			}
		} catch (DriverException e) {
			logger.info("unable to take practice assessment" + e);
		}

		logger.info("Method : takeTEASProctorAssessment :::::::: END");
		return flag;
	}
	
	/**
	 * @author Sanapati.Srinu
	 * @return
	 * @throws Exception
	 */
	public boolean takeTEASProctorAssessment_3() throws Exception {
		//logger.info("Method : takeTEASProctorAssessment :::::::: Starts");
		boolean flag=false;
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
							clickTEASQuestionType(questionElement);
						}
					}
					
					Thread.sleep(5000);
					// Next Page.
					List<WebElement> nextButton = baseHandler.findElements("#btnNextUI");
					if(CollectionUtils.isNotEmpty(nextButton)) {
						nextButton.get(0).click();
					}
					Thread.sleep(10000);
					
					// Confirmation msg for un answered question
					if(breakFlag) {
						windowHandler.switchToLatestWindow();
						List<WebElement> okCancelPopup = baseHandler.findElements("#spnMsgBox #btnOK");
						if(okCancelPopup != null &&  CollectionUtils.isNotEmpty(okCancelPopup) && okCancelPopup.size() > 0 ) {
								okCancelPopup.get(0).click();
							}
						windowHandler.switchToLatestWindow();
						Thread.sleep(10000);
						
						/*Thread.sleep(10000);
						// Next Page.
						List<WebElement> finalNextButton = baseHandler.findElements("input[id*='btnContinueUI']");
						if(CollectionUtils.isNotEmpty(finalNextButton)) {
								nextButton.get(0).click();
						}*/
						
					}
				}
			}
		} catch (DriverException e) {
			logger.info("unable to take practice assessment" + e);
		}

		logger.info("Method : takeTEASProctorAssessment :::::::: END");
		return flag;
	}
	/**
	 * @author Sanapati.Srinu
	 * @return
	 * @throws Exception
	 */
	public boolean takeTEASProctorAssessmentFinal() throws Exception {
		logger.info("Method : takeTEASProctorAssessment :::::::: Starts");
		boolean flag=false;
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

			for (int i = 0; i <= count; i++) {
				// If multiple Questions displayed in single page. 
				List<WebElement> currQuestionElement = baseHandler.findElements("#litCurrQuestions");
				int currQuestion = 0;
				int maxQuestion = 0;
				if(CollectionUtils.isNotEmpty(currQuestionElement)) {
					String[] totQuestionValue = currQuestionElement.get(0).getText().split("-");
					if(totQuestionValue != null && totQuestionValue.length>0) {
						currQuestion = Integer.parseInt(totQuestionValue[0]);
						maxQuestion = Integer.parseInt(totQuestionValue[1]);
					}					
				}
				
				if(currQuestion > 0 && maxQuestion > 0 ) { 
					for(int index = currQuestion; index <= maxQuestion; maxQuestion ++) {
						List<WebElement> allQuestionElement = baseHandler.findElements(".testpagebox #spanTestWindow>table>tbody>tr");
						int trIndex = allQuestionElement.size();
						if(CollectionUtils.isNotEmpty(allQuestionElement)) {
							for(int subIndex = 0; subIndex < trIndex; subIndex++) {
								// Getting first question.
								WebElement questionElement = allQuestionElement.get(subIndex);
								if(questionElement != null) {
									// Need to identify the type of question and enter its answer
									clickQuestionType(questionElement);
								}
							}
							// Next Page.
							List<WebElement> nextButton = baseHandler.findElements("#btnNextUI");
							if(CollectionUtils.isNotEmpty(nextButton)) {
								nextButton.get(0).click();
							}
							Thread.sleep(5000);
							// Confirmation msg for un answered question
							windowHandler.switchToLatestWindow();

							List<WebElement> okCancelPopup = baseHandler.findElements("#spnMsgBox #btnOK");
							if(CollectionUtils.isNotEmpty(okCancelPopup)) {
								okCancelPopup.get(0).click();
							} 
							windowHandler.switchToLatestWindow();
						}
					}
					
					Thread.sleep(10000);
					// Finish Button. #btnFinishUI 
					List<WebElement> finishButton = baseHandler.findElements("#btnFinishUI");
					if(CollectionUtils.isNotEmpty(finishButton)) {
						finishButton.get(0).click();
					}
					
				}
			}
		} catch (DriverException e) {
			logger.info("unable to take practice assessment" + e);
		}

		logger.info("Method : takeTEASProctorAssessment :::::::: END");
		return flag;
	}
	
	/**
	 * This method is used to answer drag and drop question
	 * 
	 * @author siddharth roy
	 * @return boolean
	 * @throws DriverException
	 */
	public void DragAndDropAnswer(List<WebElement> dragNDropElement) throws Exception {
		//logger.info("DragAndDropAnswer Start");
		try {
			/*waitUntillBufferInvisible(PropertiesRepository
					.getString("new-atitesting.peasewait.bufferLoc"));*/
			logger.info("Method : DragAndDropAnswer :::::::: start ");
			Actions act = new Actions(driver);
			boolean breakflag = false;

			
			//switchToAssessmentFrameHandler();
			List<WebElement> fromDNDElement = dragNDropElement.get(0).findElements(By.cssSelector("ul[id*='zone1']"));
			List<WebElement> toDNDElement = dragNDropElement.get(2).findElements(By.cssSelector("ul[id*='zone2']"));
			if(CollectionUtils.isNotEmpty(fromDNDElement)) {
				
			}
			int tot = fromDNDElement.get(0).findElements(By.cssSelector("li")).size(); // corrected
			if (baseHandler.isDisplayed(fromDNDElement.get(0))) { // corrected

				while (toDNDElement.get(0).findElements(By.cssSelector("li")).size() != tot) {
					if (breakflag) {
						break;
					}
					List<WebElement> btn = fromDNDElement.get(0).findElements(By.cssSelector("li[id*='ctlQuestionID0']"));
					for (int i = 0; i < btn.size(); i++) {
						try {
							wait.until(ExpectedConditions
									.elementToBeClickable(btn.get(i)));
							btn.get(i).click();
							WebElement toElement = toDNDElement.get(0);
							if (breakflag) {
								break;
							}
							
							org.openqa.selenium.interactions.Action atc12 = act
									.dragAndDrop(btn.get(i), toElement).build();
							atc12.perform();
							
							org.openqa.selenium.interactions.Action atc2 = act
									.clickAndHold(btn.get(i))
									.moveToElement(toElement)
									.release(toElement).build();
							buttonHandler
									.clickButton(toElement);
							atc2.perform();
							Thread.sleep(1000);
						} catch (StaleElementReferenceException e) {
							logger.info("element in stale state countiniuing");
						}
					}
				}
			}
		}

		catch (Exception e) {
			throw new DriverException("Unable to Drag And Drop Answer");

		}
		windowHandler.switchToLatestWindow();
		logger.info("Method:  DragAndDropAnswer End --> ");
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
						}
					} else if(size == 4) { // Radio Button
						List<WebElement> radioBtnQuestionType = individualQuestion.get(0).findElements(By.cssSelector("td"));
						if(CollectionUtils.isNotEmpty(radioBtnQuestionType)) {
							WebElement radioElement = radioBtnQuestionType.get(0); 
							List<WebElement> allRadioElement = radioElement.findElements(By.cssSelector("input[type='radio']"));
							if(CollectionUtils.isNotEmpty(allRadioElement)) {
								allRadioElement.get(0).click();
								flag = true;
							}
						}
					} else if(size == 5) {// Check Box
						List<WebElement> checkBoxBtnQuestionType = individualQuestion.get(0).findElements(By.cssSelector("td"));
						if(CollectionUtils.isNotEmpty(checkBoxBtnQuestionType)) {
							WebElement checkBoxElement = checkBoxBtnQuestionType.get(0); 
							List<WebElement> allCheckBoxElement = checkBoxElement.findElements(By.cssSelector("input[type='checkbox']"));
							if(CollectionUtils.isNotEmpty(allCheckBoxElement)) {
								allCheckBoxElement.get(0).click();
								flag = true;
							}
						}
					}
						
				} else {
					// Checking for Text box
					List<WebElement> inputElement = element.findElements(By.cssSelector("td input[type='text']"));
					if(CollectionUtils.isNotEmpty(inputElement)) {
						inputElement.get(0).sendKeys("10");
					}
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
	
	
	public void clickContinueButton() throws Exception {
		Thread.sleep(30000);
		// Next Page.
		List<WebElement> finalNextButton = baseHandler.findElements("input[id*='btnContinueUI']");
		if(CollectionUtils.isNotEmpty(finalNextButton)) {
			finalNextButton.get(0).click();
		}
	}
	
	public boolean clickTEASQuestionTypeFlag(WebElement element) throws Exception {
		logger.info("clickTEASQuestionTypeFlag Start");
		boolean flag = false;
		try {
			if(element != null) {
				// Getting 4th tr to get individual question type.
				List<WebElement> individualQuestion = element.findElements(By.cssSelector("table[class='questionFont'] tr"));
				
				if(CollectionUtils.isNotEmpty(individualQuestion)) {

					int size = individualQuestion.size();
					if(size == 4) { // Radio Button
						List<WebElement> radioBtnQuestionType = individualQuestion.get(0).findElements(By.cssSelector("td"));
						if(CollectionUtils.isNotEmpty(radioBtnQuestionType)) {
							WebElement radioElement = radioBtnQuestionType.get(0); 
							List<WebElement> allRadioElement = radioElement.findElements(By.cssSelector("input[type='radio']"));
							if(CollectionUtils.isNotEmpty(allRadioElement)) {
								allRadioElement.get(0).click();
								flag = true;
							}
						}
					} else if (size == 2) {
						 // Radio Button
						List<WebElement> radioBtnQuestionType = individualQuestion.get(0).findElements(By.cssSelector("td"));
						if(CollectionUtils.isNotEmpty(radioBtnQuestionType)) {
							WebElement radioElement = radioBtnQuestionType.get(0); 
							List<WebElement> allRadioElement = radioElement.findElements(By.cssSelector("input[type='radio']"));
							if(CollectionUtils.isNotEmpty(allRadioElement)) {
								allRadioElement.get(0).click();
								flag = true;
							}
						}
					
					}
				} 
			}
		} catch (Exception e) {
			throw new DriverException("Unable to click on Question type", e);
		}
		logger.info("clickTEASQuestionTypeFlag End");
		return flag;
	}
	
	/**
	 * @author Sanapati.Srinu
	 * @return
	 * @throws Exception
	 */
	public boolean takeTEASProctorAssessment_FinalSection() throws Exception {
		logger.info("Method : takeTEASProctorAssessment_FinalSection :::::::: Starts");
		boolean flag=false;
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
					int totalAnsweredCount = trIndex/5;
					int answeredCount = 0;
					boolean continueFlag = false;
					for(int subIndex = 0; subIndex < trIndex; subIndex++) {
						// Getting first question.
						WebElement questionElement = allQuestionElement.get(subIndex);
						if(questionElement != null) {
							// Need to identify the type of question and enter its answer
							boolean selectedAnswerFlag = clickTEASQuestionTypeFlag(questionElement);
							if(selectedAnswerFlag) {
								answeredCount++;
								if(answeredCount == totalAnsweredCount - 1) {
									continueFlag = true;
									break;
								}
							}
						}
					}
					
					//Thread.sleep(10000);
					// Next Page.
					List<WebElement> nextButton = baseHandler.findElements("#btnNextUI");
					if(CollectionUtils.isNotEmpty(nextButton)) {
						nextButton.get(0).click();
					}
					Thread.sleep(10000);
					
					// If any one question is not answered, this popup will be displayed. 
					if(continueFlag & !breakFlag) {
						windowHandler.switchToLatestWindow();
						List<WebElement> okCancelPopup = baseHandler.findElements("#spnMsgBox #btnOK");
						if(okCancelPopup != null &&  CollectionUtils.isNotEmpty(okCancelPopup) && okCancelPopup.size() > 0 ) {
								okCancelPopup.get(0).click();
							}
						windowHandler.switchToLatestWindow();
						Thread.sleep(10000);
					}
					// Confirmation msg for un answered question
					if(breakFlag) {

						windowHandler.switchToLatestWindow();
						List<WebElement> okCancelPopup = baseHandler.findElements("#spnMsgBox #btnOK");
						if(okCancelPopup != null &&  CollectionUtils.isNotEmpty(okCancelPopup) && okCancelPopup.size() > 0 ) {
								okCancelPopup.get(0).click();
							}
						windowHandler.switchToLatestWindow();
						Thread.sleep(30000);
					}
				}
			}
		} catch (DriverException e) {
			logger.info("unable to take practice assessment" + e);
		}

		logger.info("Method : takeTEASProctorAssessment_FinalSection :::::::: END");
		return flag;
	}
}
