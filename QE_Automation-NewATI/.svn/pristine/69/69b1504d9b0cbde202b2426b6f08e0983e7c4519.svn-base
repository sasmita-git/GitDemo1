package com.automation.newati.pages;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.ButtonHandler;
import com.ascendlearning.automation.ui.handlers.TextHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;

public class QuizPage extends NewATIBasePage {
	
	private Logger logger = LogManager.getLogger(this.getClass());
	public String actualText = "";
	private boolean flag = false;
	public BaseHandler baseHandler;
	private ButtonHandler buttonHandler;
	private WindowHandler windowHandler;
	private TextHandler textHandler;

	public QuizPage(WebDriver webDriver) {
		super(webDriver);
		baseHandler = new BaseHandler(driver);
		buttonHandler = new ButtonHandler(driver);
		textHandler = new TextHandler(driver);
		textHandler = new TextHandler(driver);
		windowHandler = new WindowHandler(driver);
	}
	
	/**
	 * Method is used to get the no of quizses count form the card front verify
	 * below details.
	 * 
	 * Name Product ID Source Added
	 * 
	 * @author Siddharth.Roy
	 * @param assessmentName
	 * @throws DriverException
	 */
	public int getQuizCardFrontCount(String assessmentName) throws Exception {
		logger.info("Method: getQuizCardFrontCount Start ");
		String count = "";
		try {

			List<WebElement> moduleList = baseHandler
					.findElements(PropertiesRepository
							.getString("new-atitesting.generic.QuizBankname.value"));
			if (moduleList != null && moduleList.size() > 0) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					WebElement element = moduleList
							.get(i)
							.findElement(
									By.cssSelector(PropertiesRepository
											.getString("new-atitesting.specific.QuizBankname.value")));
					WebElement element1 = moduleList.get(i);
					if (assessmentName.equalsIgnoreCase(element.getText())) {
						List<WebElement> element2 = element1.findElements(By.cssSelector(PropertiesRepository.getString("new-atitesting.specific.QuizBanknameCount.value")));
								count = element2.get(0).getText();
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to get quiz card front count");
			throw new Exception("Unable to get quiz card front count");
		}
		logger.info("Method: getQuizCardFrontCount End --> " + count);
		return Integer.parseInt(count);
	}

	/**
	 * Method is used to select card front based on name and click on Info and
	 * verify below details.
	 * 
	 * Name Product ID Source Added
	 * 
	 * 
	 * @param assessmentName
	 * @throws DriverException
	 */
	public boolean checkInfoButtonByAssessmentNameForQuiz(String assessmentName)
			throws Exception {
		logger.info("Method: checkInfoButtonByAssessmentNameForQuiz Start");
		boolean flag = false;
		try {

			List<WebElement> moduleList = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.Quiz.all.modules.loc"));
			if (moduleList != null && moduleList.size() > 0) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					WebElement element = moduleList.get(i).findElement(By.cssSelector(PropertiesRepository.getString("new-atitesting.specific.modules.name.loc")));
					WebElement element1 = moduleList.get(i);
					if (assessmentName.equalsIgnoreCase(element.getText())) {
						element1.findElement(By.cssSelector(PropertiesRepository.getString("new-atitesting.learntab.quiz.bank.info.loc"))).click();
						windowHandler.switchToLatestWindow();
						List<WebElement> allInfoDetails = baseHandler
								.findElements(PropertiesRepository.getString("new-atitesting.learntab.info.loc"));
						String name = allInfoDetails.get(0).getText();
						if (assessmentName.equalsIgnoreCase(name)) {
							flag = true;							
							break;
						}
					}
				}
				//close the info popup
				List<WebElement> closeBtns = baseHandler.findElements(PropertiesRepository.getString("newati.payment.mypurchase.order.close.button2"));
				for (int i = 0; i < closeBtns.size(); i++) {
					if(closeBtns.get(i).isDisplayed())
					{
						closeBtns.get(i).click();
						break;
					}
					
				}
			}
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			logger.info("Unable to check Info Button By Assessment Name For Quiz");
			throw new Exception(
					"Unable to check Info Button By Assessment Name For Quiz");
		}
		logger.info("Method: checkInfoButtonByAssessmentNameForQuiz End --> " + flag);
		return flag;
	}
	
	
	
	/**
	 * Method is used to verify Assessment Access State as Never. 
	 * 
	 * Accessed : Never
	 * 
	 * @author saravanan.jothimani
	 * @return boolean
	 * @throws Exception
	 */
	public boolean verifyAssessmentAccessedStateAsNever(String assessmentName) throws Exception {
		logger.info("Method: verifyAssessmentAccessedStateAsNever Starts");
		boolean flag = false;
    	try {
    		if("Never".equalsIgnoreCase(checkAccessedInfoByAssessmentName(assessmentName))) {
    			flag = true;
    		}
    	} catch (DriverException e) {
    		logger.info("Unable to verify Assessment Accessed State As Never ");
    		throw new DriverException("Unable to verify Assessment Accessed State As Never ", e); 
    	}
    	logger.info("Method: verifyAssessmentAccessedStateAsNever End flag --> " + flag);
    	return flag;
	}
	
	/**
	 * Method is used to select card front based on name and verify Accessed
	 * state.
	 * new-atitesting.learntab.tutorial.accessed.loc
	 * @author saravanan.jothimani
	 * @param assessmentName
	 * @throws DriverException
	 */
	public String checkAccessedInfoByAssessmentName(String assessmentName)
			throws Exception {
		waitUntillBufferInvisible(PropertiesRepository
				.getString("new-atitesting.peasewait.bufferLoc"));
		logger.info("Method: checkAccessedInfoByAssessmentName Start");
		String accessedState = null;
		try {

			List<WebElement> moduleList = baseHandler
					.findElements(".card.front.quiz-banks");
			if (moduleList != null && moduleList.size() > 0) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					WebElement element = moduleList
							.get(i)
							.findElement(
									By.cssSelector(PropertiesRepository
											.getString("new-atitesting.specific.modules.name.loc")));
					WebElement element1 = moduleList.get(i);
					if (assessmentName.equalsIgnoreCase(element.getText())) {
						accessedState = element1
								.findElement(
										By.cssSelector("footer[role='presentation'] span[class='time-accessed'] span"))
								.getText();
						break;
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to check Accessed Info By Assessment Name");
			throw new Exception(
					"Unable to check Accessed Info By Assessment Name");
		}
		logger.info("Method: checkAccessedInfoByAssessmentName End --> " + flag);
		return accessedState;
	}
	
	/**
	 * Method is used to get the no of quizses count form the card front verify
	 * below details.
	 * 
	 * Name Product ID Source Added
	 * 
	 * @author Siddharth.Roy
	 * @throws DriverException
	 */
	public int getQuizCardbackCount() throws Exception {
		logger.info("Method: checkInfoButtonByAssessmentName Start");
		waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.peasewait.bufferLoc"));		
		int count = 0;
		logger.info("Method: checkAccessedInfoByAssessmentName Start");
		try {
			List<WebElement> moduleList = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.generic.QuizBankname.value"));
			if (moduleList != null && moduleList.size() > 0) {
				count = moduleList.size();
			}
		} catch (Exception e) {
			logger.info("Unable to check Accessed Info By Assessment Name");
			throw new Exception(
					"Unable to check Accessed Info By Assessment Name");
		}
		logger.info("Method: checkAccessedInfoByAssessmentName End --> " + flag);
		return count;
	}
	
	/**
	 * Method is used to click Begin Quiz Button based on Module Name in Quiz Bank Card Back.
	 * 
	 * Begin Quiz
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean clickBeginQuizInCardBack(String quizName)
			throws Exception {
		logger.info("Method: clickBeginQuizInCardBack Starts");
		boolean flag = false;
		try {
			
			//baseHandler.waitToBeDisplayed(PropertiesRepository.getString("new-atitesting.learntab.quiz.bank.all.begin.quiz.button.loc"));
			//waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			if(baseHandler.isDisplayed(baseHandler.findElement(PropertiesRepository.getString("new-atitesting.learntab.quiz.bank.all.begin.quiz.button.loc")))) {
				List<WebElement> allBeginQuizButtonLiElement = baseHandler
						.findElements(PropertiesRepository
								.getString("new-atitesting.learntab.quiz.bank.all.begin.quiz.button.loc"));
				if (CollectionUtils.isNotEmpty(allBeginQuizButtonLiElement)) {
					int size = allBeginQuizButtonLiElement.size();
					for (int index = 0; index < size; index++) {
						String moduleNameFromUI = allBeginQuizButtonLiElement
								.get(index)
								.findElement(
										By.cssSelector(PropertiesRepository
												.getString("new-atitesting.learntab.quiz.bank.all.begin.quiz.card.back.name.loc")))
								.getText();
						// Matching Module Name
						if (StringUtils.isNotEmpty(moduleNameFromUI)) {
							if (quizName.equalsIgnoreCase(moduleNameFromUI)) {
								if (CollectionUtils.isNotEmpty(allBeginQuizButtonLiElement)) {
									allBeginQuizButtonLiElement
											.get(index)
											.findElement(
													By.cssSelector(PropertiesRepository
															.getString("new-atitesting.learntab.quiz.bank.all.begin.quiz.card.back.begin.quiz.button.loc")))
											.click(); 
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									break;
								}
							}
						}

					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to click Begin Quiz In Card Back");
			throw new DriverException(
					"Unable to click Begin Quiz In Card Back", e);
		}
		logger.info("Method: clickBeginQuizInCardBack End flag --> "
				+ flag);
		return flag;
	}
	
	/**
	 * Method used to verify Assessment name in Assessment page
	 * 
	 * @author siddharth.roy
	 * @return boolean
	 * @throws Exception
	 */
	public boolean verifyAssesmentNameInAssessmentPage() throws Exception {
		logger.info("verifyAssesmentNameInAssessmentPage Start ");
		boolean flag = false;
		try {
			//waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			// Switch to latest window
			switchToAssessmentFrameHandler();
			baseHandler.waitToBeDisplayed(".lesson-header-details ul li span");

			if (baseHandler
					.findElement(".lesson-header-details ul li span") != null) {
				flag = true;
			}
			windowHandler.switchToMainWindow();
		} catch (Exception e) {
			logger.info("Unable to verify Assesment Name In Assessment Page");
			throw new DriverException(
					"Unable to verify Assesment Name In Assessment Page", e);
		}
		logger.info("Method: verifyAssesmentNameInAssessmentPage End flag --> "
				+ flag);
		return flag;
	}
	
	/**
	 * Method is used to verify Quiz Assessment Show Hint Button
	 * 
	 * 
	 * @author saravanan.jothimani
	 * @return boolean
	 * @throws Exception
	 */
	public boolean verifyAssessmentShowHintButton() throws Exception {
		logger.info("Method: verifyAssessmentShowHintButton Starts ");
		boolean flag = false;
		try {
			switchToAssessmentFrameHandler();
			baseHandler.waitToBeDisplayed(PropertiesRepository.getString("new-atitesting.learntab.tutorial.name.value"));
			if(baseHandler.isDisplayed(baseHandler.findElement(PropertiesRepository.getString("new-atitesting.learntab.quiz.bank.show.hint.button.loc1")))) {
				flag = true;
			}
			windowHandler.switchToMainWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to verify Assessment Show Hint Button");
			throw new DriverException(
					"Unable to verify Assessment Show Hint Button", e);
		}
		logger.info("Method: verifyAssessmentShowHintButton End flag --> "
				+ flag);
		return flag;
	}
	
	/**
	 * Method is used to switch to Assessment name Frame.
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	public void switchToQuizFrame() throws Exception {
		logger.info("switchToQuizFrame Start");
		try {
			windowHandler.switchToFrame("assessmentFrame");
		} catch (Exception e) {
			logger.info("Unable to switch To Quiz Frame");
			throw new DriverException("Unable to switch To Quiz Frame", e);
		}
		logger.info("Method: switchToQuizFrame End ");
	}
	
	/**
	 * Method is used to verify Quiz Assessment Starting Number Button
	 * 
	 * 
	 * @author saravanan.jothimani
	 * @return boolean
	 * @throws Exception
	 */
	public boolean verifyAssessmentStartingNumberButton() throws Exception {
		logger.info("Method: verifyAssessmentStartingNumberButton Starts");
		boolean flag = false;
		try {
			windowHandler.switchToLatestWindow();
			baseHandler
					.waitToBeDisplayed(PropertiesRepository
							.getString("new-atitesting.learntab.tutorial.name.value"));
			switchToQuizFrame();
			if(baseHandler.isDisplayed(baseHandler.findElement(PropertiesRepository.getString("new-atitesting.learntab.quiz.bank.question.starting.number.loc")))) {
				flag = true;
			}
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to verify Assessment Starting Number Button");
			throw new DriverException(
					"Unable to verify Assessment Starting Number Button", e);
		}
		logger.info("Method: verifyAssessmentStartingNumberButton End flag --> "
				+ flag);
		return flag;
	}
	
	/**
	 * Method is used to verify Quiz Assessment Ending Number Button
	 * 
	 * 
	 * @author saravanan.jothimani
	 * @return boolean
	 * @throws Exception
	 */
	public boolean verifyAssessmentEndingNumberButton() throws Exception {
		logger.info("Method: verifyAssessmentEndingNumberButton Starts");
		boolean flag = false;
		try {
			windowHandler.switchToLatestWindow();
			baseHandler
					.waitToBeDisplayed(PropertiesRepository
							.getString("new-atitesting.learntab.tutorial.name.value"));
			switchToQuizFrame();
			if(baseHandler.isDisplayed(baseHandler.findElement(PropertiesRepository.getString("new-atitesting.learntab.quiz.bank.question.ending.number.loc")))) {
				flag = true;
			}
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to verify Assessment Ending Number Button");
			throw new DriverException(
					"Unable to verify Assessment Ending Number Button", e);
		}
		logger.info("Method: verifyAssessmentEndingNumberButton End flag --> "
				+ flag);
		return flag;
	}
	
	/**
	 * This method is used to verify the submit button in the assessment page
	 * and click on it flag is true author siddharth.roy
	 * 
	 * @throws Exception
	 * @return boolean
	 */
	public boolean verifySubmitButton(Boolean click) throws Exception {

		logger.info("Method: verifySubmitButton Starts");
		waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		boolean flag = false;
		try {
			switchToQuizFrame();
			if (baseHandler
					.findElement(".submit-answer-button-disabled.focus-element-flag") != null) {
				flag = true;
				if (click == true) {
					baseHandler
							.findElement(
									".submit-answer-button-disabled.focus-element-flag")
							.click();
				}
			}
		} catch (Exception e) {
			logger.info("Unable to  verify SubmitButton");
			throw new DriverException("Unable to verify SubmitButton", e);
		}
		logger.info("Method: verifySubmitButton End flag --> " + flag);
		windowHandler.switchToLatestWindow();
		return flag;

	}
	
	/**
	 * This method is used to verify the continue button in the assessment page.
	 * author siddharth.roy
	 * 
	 * @throws Exception
	 * @return boolean
	 */
	public boolean verifyContinue(Boolean click) throws Exception {

		logger.info("Method:  verifyContinue Starts");
		waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		boolean flag = false;
		try {
			switchToQuizFrame();
			if (baseHandler
					.findElement(PropertiesRepository
							.getString("new-atitesting.generic.tutorial.continue.value")) != null) {
				if (click == true) {
					baseHandler
							.findElement(
									PropertiesRepository
											.getString("new-atitesting.generic.tutorial.continue.value"))
							.click();

				}
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to   verify Continue");
			throw new DriverException("Unable to  verify Continue", e);
		}
		logger.info("Method:  verifyContinue End flag --> " + flag);
		windowHandler.switchToLatestWindow();
		return flag;
	}
	
	/**
	 * Method is used to click Quiz Assessment Tools Button
	 * 
	 * Glossary
	 * Calculator
	 * Study Guide
	 * 
	 * @author saravanan.jothimani
	 * @return boolean
	 * @throws Exception
	 */
	public boolean clickAssessmentToolsButton() throws Exception {
		logger.info("Method: clickAssessmentToolsButton Starts");
		boolean flag = false;
		try {
			windowHandler.switchToLatestWindow();
			baseHandler
					.waitToBeDisplayed(PropertiesRepository
							.getString("new-atitesting.learntab.tutorial.name.value"));
			switchToQuizFrame();
			buttonHandler.clickButton(PropertiesRepository.getString("new-atitesting.learntab.quiz.bank.tools.button.loc"));
			if(baseHandler.isDisplayed(baseHandler.findElement(PropertiesRepository.getString("new-atitesting.learntab.quiz.bank.tools.glossary.button.loc")))) {
				if(baseHandler.isDisplayed(baseHandler.findElement(PropertiesRepository.getString("new-atitesting.learntab.quiz.bank.tools.calculator.button.loc")))) {
					if(baseHandler.isDisplayed(baseHandler.findElement(PropertiesRepository.getString("new-atitesting.learntab.quiz.bank.tools.study.guide.button.loc")))) {
						flag = true;
					}
				}	
			}
			buttonHandler.clickButton(PropertiesRepository.getString("new-atitesting.learntab.quiz.bank.tools.button.loc"));
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to Click Assessment Tools Button");
			throw new DriverException(
					"Unable to Click Assessment Tools Button", e);
		}
		logger.info("Method: clickAssessmentToolsButton End flag --> "
				+ flag);
		return flag;
	}
	
	/**
	 * Method is used to click Quiz Assessment Tools Button
	 * 
	 * Glossary
	 * Calculator
	 * Study Guide
	 * 
	 * @author saravanan.jothimani
	 * @return boolean
	 * @throws Exception
	 */
	public boolean clickAssessmentToolsButtonWithoutSwitch() throws Exception {
		logger.info("Method: clickAssessmentToolsButtonWithoutSwitch Starts");
		boolean flag = false;
		try {
			switchToAssessmentFrameHandler();
			buttonHandler.clickButton(PropertiesRepository.getString("new-atitesting.learntab.quiz.bank.tools.button.loc"));
			if(baseHandler.isDisplayed(baseHandler.findElement(PropertiesRepository.getString("new-atitesting.learntab.quiz.bank.tools.glossary.button.loc")))) {
				//if(baseHandler.isDisplayed(baseHandler.findElement(PropertiesRepository.getString("new-atitesting.learn.tab.question.no.loc1")))) {
					if(baseHandler.isDisplayed(baseHandler.findElement(PropertiesRepository.getString("new-atitesting.learntab.quiz.bank.tools.study.guide.button.loc")))) {
						flag = true;
					}
				//}	
			}
			buttonHandler.clickButton(PropertiesRepository.getString("new-atitesting.learntab.quiz.bank.tools.button.loc.new"));
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to Click Assessment Tools Button");
			throw new DriverException(
					"Unable to Click Assessment Tools Button", e);
		}
		logger.info("Method: clickAssessmentToolsButtonWithoutSwitch End flag --> "
				+ flag);
		return flag;
	}
	
	/**
	 * Method is used to verify Quiz Assessment Show Hint Button
	 * 
	 * 
	 * @author saravanan.jothimani
	 * @return boolean
	 * @throws Exception
	 */
	public boolean clickAssessmentShowHintButton() throws Exception {
		logger.info("Method: clickAssessmentShowHintButton Starts");
		boolean flag = false;
		try {
			windowHandler.switchToLatestWindow();
			baseHandler
					.waitToBeDisplayed(PropertiesRepository
							.getString("new-atitesting.learntab.tutorial.name.value"));
			switchToQuizFrame();
			buttonHandler.clickButton(PropertiesRepository.getString("new-atitesting.learntab.quiz.bank.show.hint.button.loc"));
			if(baseHandler.isDisplayed(baseHandler.findElement(PropertiesRepository.getString("new-atitesting.learntab.quiz.bank.show.hint.show.in.yellow.color.loc")))) {
				flag = true;
			}
			buttonHandler.clickButton(".focus-element-flag.hint-button-on");
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to Click Assessment Show Hint Button");
			throw new DriverException(
					"Unable to Click Assessment Show Hint Button", e);
		}
		logger.info("Method: clickAssessmentShowHintButton End flag --> "
				+ flag);
		return flag;
	}
	
	/**
	 * Method is used to verify Quiz Assessment Show Hint Button
	 * 
	 * 
	 * @author saravanan.jothimani
	 * @return boolean
	 * @throws Exception
	 */
	public boolean clickAssessmentShowHintButtonWithoutSwitch() throws Exception {
		logger.info("Method: clickAssessmentShowHintButtonWithoutSwitch Starts");
		boolean flag = false;
		try {
			buttonHandler.clickButton(PropertiesRepository.getString("new-atitesting.learntab.quiz.bank.show.hint.button.loc"));
			if(baseHandler.isDisplayed(baseHandler.findElement(PropertiesRepository.getString("new-atitesting.learntab.quiz.bank.show.hint.show.in.yellow.color.loc")))) {
				flag = true;
			}
			buttonHandler.clickButton(".focus-element-flag.hint-button-on");
		} catch (Exception e) {
			logger.info("Unable to Click Assessment Show Hint Button");
			throw new DriverException(
					"Unable to Click Assessment Show Hint Button", e);
		}
		logger.info("Method: clickAssessmentShowHintButtonWithoutSwitch End flag --> "
				+ flag);
		return flag;
	}
	
	/**
	 * Method is used to verify Popup which will be shown while clicking on 
	 * Continue button without selecting any answer.
	 *  
	 * @author saravanan.jothimani
	 * @return boolean
	 * @throws Exception
	 */
	public boolean clickContinueWithoutAnswering() throws Exception {
		logger.info("Method: verifyFacultyProductTabAssessment Starts");
		boolean flag = false;
    	try {
			windowHandler.switchToLatestWindow();
			baseHandler
					.waitToBeDisplayed(PropertiesRepository
							.getString("new-atitesting.learntab.tutorial.name.value"));
			switchToQuizFrame();
			buttonHandler.clickButton("#MoveNext");
			//windowHandler.switchToLatestWindow();
			if("Question Unanswered".equalsIgnoreCase(textHandler.getText(PropertiesRepository.getString("new-atitesting.learntab.quiz.bank.question.continue.wihtout.selecting.answer.message.loc")))) {
				//buttonHandler.clickButton(PropertiesRepository.getString("new-atitesting.learntab.quiz.bank.question.continue.wihtout.selecting.answer.close.button.loc"));
			}
			windowHandler.switchToLatestWindow();
    	} catch (DriverException e) {
    		windowHandler.switchToLatestWindow();
    		logger.info("Unable to verify Faculty User Product Tab ");
    		throw new DriverException("Unable to verify Faculty User Product Tab " , e); 
    	}
    	logger.info("Method: verifyFacultyProductTabAssessment End flag --> " + flag);
    	return flag;
	}
	
	public boolean verifySelectInstance() throws Exception {
		logger.info("Method: verifySelectInstance Starts");
		boolean flag = false;
    	try {
    		List<WebElement> element = baseHandler.findElements("#selectInstanceContainerLearnTab ul");
    		if(CollectionUtils.isNotEmpty(element)) {
    			flag = true;
    		}
    	} catch (Exception e) {
    		logger.info("Unable to verify Select Instance");
    		throw new DriverException("Unable to verify Select Instance" , e); 
    	}
    	logger.info("Method: verifySelectInstance End flag --> " + flag);
    	return flag;
	}
	
	public String clickQuizName(int index) throws Exception {
    	logger.info("Method: clickQuizName Starts");
		String result = "";
    	try {
    		List<WebElement> element = baseHandler.findElements("#learningSystemModuleList .product-list-style li .product-quiz-list-buttons .quiz-actions");
    		if(CollectionUtils.isNotEmpty(element)) {
				WebElement quizElement = element.get(index);
				if(quizElement != null) {
					String name  = quizElement.findElement(By.cssSelector(".quiz-display-name span")).getText();
					if(StringUtils.isNotEmpty(name)) {
						result = name;
						quizElement.findElement(By.cssSelector("div[class='module-buttons quiz-bank-buttons'] a[class='button focus-element-flag primary-button']")).click();
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
					}
				}
    		}
    	} catch (Exception e) {
    		logger.info("Unable to clickQuizName");
			log(logger, "Unable to clickQuizName" );
    		throw new DriverException("Unable to clickQuizName" , e); 
    	}
    	logger.info("Method: clickQuizName End flag --> " + flag);
    	return result;
	}
	
	public String getQuizBankAssessmentName() throws DriverException {
		logger.info("getQuizBankAssessmentName Start");
		String result = null;
		try {
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			driver.switchTo().frame("assessmentFrame");
			List<WebElement> element = baseHandler.findElements(PropertiesRepository
					.getString("new-atitesting.quizbanks.assessmentnameloc.new"));
			if (CollectionUtils.isNotEmpty(element)) {
				result = element.get(2).getText();   
			}
		}
		catch (Exception e) {
			throw new DriverException("Unable to fetch the Quiz Bank Assessment name", e);
		}
		return result;
	}
	
	/**
	 * Method used to verify the NCLEX products are listed in all other My ATI
	 * tabs product Lists
	 * Passing the product list and product visibility locators as input parameters
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 */

	public boolean verifyNCLEXProductList(String prodlist, String prodavilabile) throws Exception {
		logger.info("Method : verifyNCLEXProductList");
		logger.info("Extracting the Product list and comparing with NCLEX Product list Start");
		boolean flag = false;

		try {
			Thread.sleep(10000);
			//Verifying the Product list availability with reference of Style attribute value
			WebElement productsVisible = baseHandler.findElement(PropertiesRepository.getString(prodavilabile));
			String proVisible = productsVisible.getAttribute("style");
			if (proVisible.contains("display: none")) {
				List<WebElement> productsList = baseHandler.findElements(PropertiesRepository.getString(prodlist));
				if (CollectionUtils.isNotEmpty(productsList) && productsList.size() > 0) {

					int size = productsList.size();
					logger.info("All active Product List count is " + size);

					List<WebElement> nclexproductList = baseHandler
							.findElements(PropertiesRepository.getString("newati.myati.NCLEX.tab.product.list.loc"));
					if (CollectionUtils.isNotEmpty(nclexproductList) && nclexproductList.size() > 0) {
                       // Iterating through the Product list and comparing with NCLEX product list which were listed in asmt-myatitab-input properties file 
						for (int i = 0; i < size; i++) {
							flag = false;
							String prodcutName = productsList.get(i).getText();
							logger.info("Active Product Name List is ***** " + prodcutName);
							if (!prodcutName.isEmpty()) {
								Thread.sleep(1000);
								if (!(prodcutName
										.equals(PropertiesRepository
												.getString("newati.myati.assessment.NCLEX.prodcut.value1"))
										|| prodcutName.equals(PropertiesRepository
												.getString("newati.myati.assessment.NCLEX.prodcut.value2"))
										|| prodcutName.equals(PropertiesRepository
												.getString("newati.myati.assessment.NCLEX.prodcut.value3")))) {
									flag = true;

								} else {
	                                // Breaking the test scripts execution due to duplicate products found
									flag = false;
									logger.info("The NCLEX product *** " + productsList.get(i).getText()
											+ " *** is available in List ");
									break;
								}
							}
						}
					}
				}

			} else {
				//No Products are present in to the selected Assessment Tab, hence printing the message and Iterating through the next Tab 
				flag = true;
				logger.info("There are no Active Products displayed ***** " + productsVisible.getText());
			}
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to verify NCLEXProductList");
			log(logger, "Unable to verify verifyNCLEXProductList");
			throw new DriverException("Unable to verifyNCLEXProductList", e);
		}
		logger.info("Method: verifyNCLEXProductList End flag --> " + flag);
		return flag;
	}
	
	/**
	 * This method is used to click on any button or link based on index.
	 * 
	 * @author Sanapati.Srinu
	 * @param loc
	 * @param index
	 * @throws Exception
	 */
	public void clickLinkFromList(String loc, int index) throws Exception {
		logger.info("clickLinkFromList Start");
		try {
			List<WebElement> findElement = baseHandler.findElements(PropertiesRepository.getString(loc));
			if (CollectionUtils.isNotEmpty(findElement)) {
				findElement.get(index).click();
				waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
			}
		} catch (Exception e) {
			logger.info("Unable to click Link From List");
			log(logger, "Unable to click Link From List");
			throw new DriverException("Unable to click Link From List", e);
		}
		logger.info("clickLinkFromList End");
	}
}

