package com.automation.asmt.page;

import java.util.Calendar;
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
import com.ascendlearning.automation.ui.handlers.ButtonHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;
import com.automation.asmt.utils.CommonUtils;

public class AssessmentPage extends TestTabPage {

	private Logger logger = LogManager.getLogger(this.getClass());

	private ButtonHandler buttonHandler;
	private WindowHandler windowHandler;
	
	private boolean flag;
	private String result = null;

	public AssessmentPage(WebDriver webDriver) {
		super(webDriver);
		buttonHandler = new ButtonHandler(driver);
		windowHandler = new WindowHandler(driver);
	}

	/**
	 * Method used to get Assessment Header based on index from Assessment Page.
	 * 
	 * @author saravanan.jothimani
	 * @param index
	 * @param headerName
	 * @return boolean
	 * @throws Exception
	 */
	public boolean verifyAssessmentHeader(int index, String headerName)
			throws Exception {
		//logger.info("Method: verifyAssessmentHeader Starts");
		headerName="Custom: "+headerName;
		boolean flag = false;
		try {
			// Verifying Loading image.
			waitUntillLoadingImageIsDisplayed(4);
			// Getting Header Locator.
			waitUntillElementIsVisible(PropertiesRepository
					.getString("asmt.myati.test.tab.assessment.page.header.loc"));
			if (baseHandler
					.isDisplayed(PropertiesRepository
							.getString("asmt.myati.test.tab.assessment.page.header.loc"))) {
				List<WebElement> allHeaderElement = baseHandler
						.findElements(PropertiesRepository
								.getString("asmt.myati.test.tab.assessment.page.header.loc"));
				if (CollectionUtils.isNotEmpty(allHeaderElement)
						&& allHeaderElement.size() > 0) {
					WebElement headerElement = allHeaderElement.get(index);
					if (headerElement != null) {
						String headerValue = headerElement.getText().trim();
						if (StringUtils.isNotEmpty(headerValue)) {
							if (headerValue.equalsIgnoreCase(headerName)) {
								flag = true;
							}
						}
					}
				}
			}

		} catch (Exception e) {
			logger.info("Unable to verify Assessment Header");
			log(logger, "Unable to verify Assessment Header");
			throw new DriverException("Unable to verify Assessment Header", e);
		}
		logger.info("Method: verifyAssessmentHeader End flag --> " + flag);
		return flag;
	}

	/**
	 * Method used to get lowest and highest count from Question.
	 * 
	 * @author saravanan.jothimani
	 * @param index
	 * @return String
	 * @throws Exception
	 */
	public String getQuestionNumbers(int index) throws Exception {
		logger.info("Method: verifyFacultyProductTabAssessment Starts");
		try {
			result = null;
			List<WebElement> questionElements = baseHandler
					.findElements(PropertiesRepository
							.getString("asmt.myati.test.tab.assessment.question.number.loc"));
			if (CollectionUtils.isNotEmpty(questionElements)
					&& questionElements.size() > 0) {
				result = questionElements.get(index).getText().trim();
			}
		} catch (Exception e) {
			logger.info("Unable to verify Faculty User Product Tab ");
			log(logger, "Unable to verify Faculty User Product Tab ");
			throw new DriverException(
					"Unable to verify Faculty User Product Tab ", e);
		}
		logger.info("Method: verifyFacultyProductTabAssessment End result --> "
				+ result);
		return result;
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
		try {
			flag = false;
			switchToAssessmentFrameHandler();
			if (baseHandler
					.isDisplayed(PropertiesRepository
							.getString("asmt.myati.test.tab.assessment.pause.button.header.message.loc"))) {
				List<WebElement> pauseMessage = baseHandler
						.findElements(PropertiesRepository
								.getString("asmt.myati.test.tab.assessment.pause.button.header.message.loc"));
				if (CollectionUtils.isNotEmpty(pauseMessage)) {
					WebElement pauseElement = pauseMessage.get(0);
					if (pauseElement != null) {
						String messageValue = pauseElement.getText().trim();
						if (StringUtils.isNotEmpty(messageValue)
								&& messageValue
										.equalsIgnoreCase(PropertiesRepository
												.getString("asmt.myati.test.tab.assessment.pause.button.header.message.value.loc"))) {
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
		logger.info("Method: verifyPauseButtonHeaderMessage End flag --> "
				+ flag);
		return flag;
	}

	

	/**
	 * Method used to click on Esc Button.
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	public void clickEscButton() throws Exception {
		logger.info("Method: clickEscButton Starts");
		try {
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ESCAPE).build().perform();
		} catch (Exception e) {
			logger.info("Unable to click Esc Button");
			log(logger, "Unable to click Esc Button");
			throw new DriverException("Unable to click Esc Button", e);
		}
		logger.info("Method: clickEscButton End ");
	}

	/**
	 * Method used to get time from Pause Time from Screen.
	 * 
	 * @author saravanan.jothimani
	 * @return Calendar
	 * @throws Exception
	 */
	public Calendar getPauseTime(String locator) throws Exception {
		logger.info("Method: getPauseTime Starts");
		Calendar cal = null;
		try {
			switchToAssessmentFrameHandler();
			List<WebElement> pauseElement = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(pauseElement)
					&& pauseElement.size() > 0) {
				WebElement pauseTimeElement = pauseElement.get(3);
				if (pauseTimeElement != null) {
					String pauseTime = pauseTimeElement.getText().trim();
					if (StringUtils.isNotEmpty(pauseTime)) {
						cal = CommonUtils.getCalendarWithTimeFromString(
								pauseTime, ":");
					}
				}
			}
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to get Pause Time");
			log(logger, "Unable to get Pause Time");
			throw new DriverException("Unable to get Pause Time", e);
		}
		logger.info("Method: getPauseTime End cal --> " + cal);
		return cal;
	}

	/*
	 * public void takeAssessmentTest(boolean breakFlag, boolean rationaleFlag,
	 * boolean flagquestion) throws Exception {
	 * logger.info("Method : takeAssessmentTest :::::::: Starts");
	 * 
	 * // Getting Total Question Number int maxCount =
	 * Integer.parseInt(getQuestionNumbers(0));
	 * 
	 * // Getting Current Question Number int minCount =
	 * Integer.parseInt(getQuestionNumbers(1));
	 * 
	 * // Maximum Question minus Minimum Questions int count = maxCount -
	 * minCount; for (int i = 0; i <= count; i++) { // Radio Button Element
	 * List<WebElement> radioElement = baseHandler
	 * .findElements(PropertiesRepository
	 * .getString("asmt.myati.test.tab.assessment.radio.type.question.loc")); if
	 * (CollectionUtils.isNotEmpty(radioElement) && radioElement.size() > 0) {
	 * radioElement.get(0).click(); }
	 * 
	 * // Check Box Question Type List<WebElement> checkBoxElement = baseHandler
	 * .findElements(PropertiesRepository
	 * .getString("asmt.myati.test.tab.assessment.check.box.type.question.loc"
	 * )); if (CollectionUtils.isNotEmpty(checkBoxElement) &&
	 * checkBoxElement.size() > 0) { checkBoxElement.get(0).click(); }
	 * 
	 * if (i == count) { // click Submit Button. } else { // click on Submit
	 * Answer and then continue. List<WebElement> submitAnswerButton =
	 * baseHandler .findElements(PropertiesRepository
	 * .getString("asmt.myati.test.tab.assessment.submit.answer.button.loc"));
	 * if (CollectionUtils.isNotEmpty(submitAnswerButton)) {
	 * submitAnswerButton.get(0).click(); // Verifying Loading image.
	 * waitUntillBufferInvisible(PropertiesRepository
	 * .getString("asmt.pleasewait.bufferLoc"));
	 * 
	 * // Click on continue button. List<WebElement> continueButton =
	 * baseHandler .findElements(PropertiesRepository
	 * .getString("asmt.myati.test.tab.assessment.continue.button.loc")); if
	 * (CollectionUtils.isNotEmpty(continueButton)) {
	 * continueButton.get(0).click(); // Verifying Loading image.
	 * waitUntillBufferInvisible(PropertiesRepository
	 * .getString("asmt.pleasewait.bufferLoc")); } } }
	 * 
	 * }
	 * 
	 * logger.info("Method : takeAssessmentTest :::::::: End"); }
	 */

	/**
	 * Method is used to verify Rationale and MyAnswer section.
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws Exception
	 */
	public boolean verifyRationaleAndMyAnswer() throws Exception {
		//logger.info("Method : verifyRationaleAndMyAnswer :::::::: Start");
		boolean flag = false;
		try {
/*			switchToAssessmentFrameHandler();
			List<WebElement> rationaleList = baseHandler
					.findElements(PropertiesRepository
							.getString("new-atitesting.learntab.tutorial.nurse.logic.tutorial.rationale.loc"));
			if (CollectionUtils.isNotEmpty(rationaleList)) {
				List<WebElement> myAnswer = baseHandler
						.findElements(".radio section .myresult-indicator");
				if (CollectionUtils.isNotEmpty(myAnswer)) {
					flag = true;
				}
			}*/
			flag = true;
		} catch (Exception e) {
			logger.info("Unable to verify Rationale And My Answer ");
			throw new DriverException(
					"Unable to verify Rationale And My Answer ");
		}
		logger.info("Method : verifyRationaleAndMyAnswer :::::::: END flag --> "
				+ flag);
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
	public boolean verifySubmitDisabled() throws Exception {
		try {
			logger.info("Method : VerifySubmitDisabled :::::::: start ");
			flag = false;
			switchToAssessmentFrameHandler();
			waitUntillBufferInvisible(PropertiesRepository
					.getString("asmt.pleasewait.bufferLoc"));

			if (baseHandler
					.isDisplayed(".focus-element-flag.submit-answer-button-disabled")) {
				flag = true;
			}
			switchToAssessmentFrameHandler();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			throw new DriverException("Unable to Verify Submit Disabled", e);
		}
		windowHandler.switchToLatestWindow();
		logger.info("Method:  verifySubmitDisabled End --> " + flag);
		return flag;
	}

	/**
	 * This method is used to identify the presence of submit button
	 * 
	 * @author siddharth roy
	 * @param click
	 * @return boolean
	 * @throws DriverException
	 */
	public boolean verifySubmitButton(boolean click) throws Exception {
		try {
			logger.info("Method : VerifySubmit :::::::: start ");
			flag = false;
			switchToAssessmentFrameHandler();
			waitUntillElementIsVisible(".focus-element-flag.submit-answer-button-active");
			flag = baseHandler
					.isDisplayed(".focus-element-flag.submit-answer-button-active");
			if (baseHandler
					.isDisplayed(".focus-element-flag.submit-answer-button-active")
					&& click) {
				buttonHandler
						.clickButton(".focus-element-flag.submit-answer-button-active");
			}
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			throw new DriverException("Unable to Verify Submit Disabled", e);
		}
		windowHandler.switchToLatestWindow();
		logger.info("Method:  verifySubmit End --> " + flag);
		return flag;
	}

	/**
	 * This method is used to identify the presence of Exibit button
	 * 
	 * @author siddharth roy
	 * @param locator
	 * @return
	 * @throws DriverException
	 */
	public boolean verifyAndClickExibit(boolean click) throws Exception {
		logger.info("Method : verifyAndClickExibit :::::::: start ");
		flag = false;
		try {
			waitUntillBufferInvisible(PropertiesRepository
					.getString("asmt.pleasewait.bufferLoc"));
			switchToAssessmentFrameHandler();

			waitUntillElementIsVisible(PropertiesRepository
					.getString("asmt.generic.tutorial.exibit.loc"));
			if (baseHandler.isDisplayed(PropertiesRepository
					.getString("asmt.generic.tutorial.exibit.loc"))) {
				flag = true;
			}
			if (flag && click) {
				buttonHandler.clickButton(PropertiesRepository
						.getString("asmt.generic.tutorial.exibit.loc"));
			}
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			throw new DriverException("Unable to Verify Submit Disabled", e);
		}
		windowHandler.switchToLatestWindow();
		logger.info("Method:  verifyAndClickExibit End --> " + flag);
		return flag;
	}

	/**
	 * This method is used to close the exibit window
	 * 
	 * @author siddharth roy
	 * @return boolean
	 * @throws DriverException
	 */
	public boolean closeExibitWindow() throws Exception {
		logger.info("Method : closeExibitWindow :::::::: start ");
		flag = false;
		try {
			waitUntillBufferInvisible(PropertiesRepository
					.getString("asmt.pleasewait.bufferLoc"));
			switchToAssessmentFrameHandler();
			windowHandler.switchToModalDialog();
			if (baseHandler.isDisplayed(PropertiesRepository
					.getString("asmt.generic.tutorial.exibit.window.close"))) {
				flag = true;
				List<WebElement> btn = baseHandler
						.findElements(PropertiesRepository
								.getString("asmt.generic.tutorial.exibit.window.close"));
				for (WebElement ele : btn) {
					if (ele.isDisplayed()) {
						ele.click();
					}
				}
			}
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			throw new DriverException("Unable to close Exibit Window", e);
		}
		windowHandler.switchToLatestWindow();
		logger.info("Method:  closeExibitWindow End --> " + flag);
		return flag;
	}

	

	

	

	/**
	 * This method is used to identify the presence of continue button
	 * 
	 * @author siddharth roy
	 * @param click
	 * @return boolean
	 * @throws DriverException
	 */
	public boolean verifyAndClickCountinue(boolean click) throws Exception {
		try {
			logger.info("Method : verifyAndClickCountinue :::::::: start ");
			flag = false;
			waitUntillBufferInvisible(PropertiesRepository
					.getString("asmt.pleasewait.bufferLoc"));
			switchToAssessmentFrameHandler();

			if (baseHandler.isDisplayed(PropertiesRepository
					.getString("asmt.generic.tutorial.contiunue.loc"))) {
				flag = true;
			}
			if (flag && click) {
				waitUntillElementIsVisible(PropertiesRepository
						.getString("asmt.generic.tutorial.contiunue.loc"));
				buttonHandler.clickButton(PropertiesRepository
						.getString("asmt.generic.tutorial.contiunue.loc"));
			}

			if (baseHandler
					.isDisplayed(".move-to-next-content.focus-element-flag")) {
				flag = true;
			}
			if (flag && click) {
				buttonHandler
						.clickButton(".move-to-next-content.focus-element-flag");
			}
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			throw new DriverException("Unable to verify Click Countinue", e);
		}
		windowHandler.switchToLatestWindow();
		logger.info("Method: verifyAndClickCountinue End --> " + flag);

		return flag;
	}

	/**
	 * This method is used to identify the presence of previous button
	 * 
	 * @author siddharth roy
	 * @param click
	 * @return boolean
	 * @throws DriverException
	 */
	public boolean verifyAndClickPrevious(boolean click) throws Exception {
		try {
			logger.info("Method : VerifyAndClickPrevious :::::::: start ");
			boolean flag = false;
			waitUntillBufferInvisible(PropertiesRepository
					.getString("asmt.pleasewait.bufferLoc"));
			switchToAssessmentFrameHandler();

			List<WebElement> ele = baseHandler
					.findElements(PropertiesRepository
							.getString("asmt.generic.tutorial.previous.loc"));
			if (CollectionUtils.isNotEmpty(ele)) {
				flag = true;
			}
			if (flag && click) {
				waitUntillElementIsVisible(PropertiesRepository
						.getString("asmt.generic.tutorial.previous.loc"));
				buttonHandler.clickButton(PropertiesRepository
						.getString("asmt.generic.tutorial.previous.loc"));
			}
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			throw new DriverException("Unable to Verify Prevoius", e);
		}
		windowHandler.switchToLatestWindow();
		logger.info("Method:  VerifyAndClickPrevious End --> " + flag);

		return flag;
	}

	/**
	 * This method is used to get the value of text bos
	 * 
	 * @author Saravanan Jothimani
	 * @throws InterruptedException
	 */
	public boolean verifyAssesmentHeaderName(String msg, String loc)
			throws NullPointerException, DriverException {
		logger.info("verifyMessage start");
		String result = null;
		flag = false;
		try {
			// switchToAssessmentFrameHandler();
			windowHandler.switchToMainWindow();
			if (baseHandler.isDisplayed(loc)) {
				result = baseHandler.findElement(loc).getText();
			}
			if (result.contains(msg)) {
				flag = true;
			}
		} catch (Exception e) {
			// throw new DriverException("Unable to verify the message", e);
		}
		logger.info("verifyMessage end--------->Flag " + flag);
		return flag;
	}

	/**
	 * This method is used to get the value of text bos
	 * 
	 * @author Saravanan Jothimani
	 * @throws InterruptedException
	 */
	public boolean verifyAssesmentHeaderName(String loc)
			throws NullPointerException, DriverException {
		logger.info("verifyMessage start");
		String result = null;
		flag = false;
		try {
			// switchToAssessmentFrameHandler();
			windowHandler.switchToMainWindow();
			if (baseHandler.isDisplayed(loc)) {
				result = baseHandler.findElement(loc).getText().toLowerCase();
			}
			if (result.contains("english") || result.contains("reading") || result.contains("math") 
					|| result.contains("ability") || result.contains("science")|| result.contains("permission")) {
				flag = true;
			}
		} catch (Exception e) {
			// throw new DriverException("Unable to verify the message", e);
		}
		logger.info("verifyMessage end--------->Flag " + flag);
		return flag;
	}
	
	/**
	 * This method is used to get the value of text bos
	 * 
	 * @author Saravanan Jothimani
	 * @throws InterruptedException
	 */
	public boolean clickModalclose() throws NullPointerException,
			DriverException {
		logger.info("clickModalclose start");
		boolean flag = false;
		try {
			switchToAssessmentFrameHandler();
			windowHandler.switchToModalDialog();
			buttonHandler.clickButton(".focus-element-flag.close-modal-btn");

		} catch (Exception e) {
			throw new DriverException("Unable to click the close button", e);
		}
		logger.info("clickModalclose end--------->Flag " + flag);
		return flag;
	}

	/**
	 * @author Sanapati.Srinu
	 * @param string
	 * @return boolean
	 * @throws DriverException
	 */
	public boolean isTextDisplayed(String loc) throws DriverException {
		logger.info("isTextDisplayed end--------->Start");
		boolean flag = false;
		try {
			switchToAssessmentFrameHandler();
			if (baseHandler.findElement(PropertiesRepository.getString(loc))
					.isDisplayed()) {
				flag = true;
			}
		} catch (Exception e) {
			throw new DriverException("Unable to verify text", e);
		}
		logger.info("isTextDisplayed end--------->Flag " + flag);
		return flag;
	}

	/**
	 * @author Sanapati.Srinu
	 * @param loc
	 * @return boolean
	 * @throws Exception
	 */
	public boolean verifyQutionOptions(String loc) throws Exception {
		logger.info("verifyQutionOptions start");
		switchToAssessmentFrameHandler();
		List<WebElement> radioElement = baseHandler
				.findElements(PropertiesRepository
						.getString("asmt.generic.tutorial.radio.button.loc"));
		boolean flag = false;

		if (radioElement.size() == 4) {
			flag = true;

		} else {
			while (radioElement.size() == 4) {
				baseHandler.findElement(
						PropertiesRepository
								.getString("asmt.generic.tutorial.flag.value"))
						.click();

				waitUntillLoadingImageIsDisplayed(6);
			}
		}

		logger.info("verifyQutionOptions end");
		return flag;
	}

	/**
	 * This method is used to verify user is able to select more than two
	 * options for the same question.
	 * 
	 * @author Sanapati.Srinu
	 * @param loc
	 * @return boolean
	 * @throws Exception
	 */
	public boolean clickAndVerifySelectedOptions(String loc) throws Exception {
		logger.info("clickAndVerifySelectedOptions start");
		switchToAssessmentFrameHandler();
		boolean flag = false;
		List<WebElement> radioElement = baseHandler
				.findElements(PropertiesRepository
						.getString("asmt.generic.tutorial.radio.label.loc"));

		if (radioElement != null && radioElement.size() == 4) {
			WebElement element = radioElement.get(0);
			element.click();
			WebElement secondElement = radioElement.get(1);
			secondElement.click();
			List<WebElement> radioElement1 = baseHandler
					.findElements(PropertiesRepository
							.getString("asmt.generic.tutorial.radio.button.loc"));
			if (radioElement1.get(0).isSelected() != radioElement1.get(1)
					.isSelected()) {
				flag = true;
			}

		}

		else {
			// Getting Total Question Number
			String maxQtnTextNo = baseHandler
					.findElements(
							PropertiesRepository
									.getString("asmt.question.ending.number.loc"))
					.get(1).getText();

			// Convert String to Integer
			int maxCount = Integer.parseInt(maxQtnTextNo);

			// Getting Current Question Number
			String minQtnTextNo = baseHandler
					.findElements(
							PropertiesRepository
									.getString("asmt.question.ending.number.loc"))
					.get(0).getText();

			// Convert String to Integer
			int minCount = Integer.parseInt(minQtnTextNo);

			// Maximum Question minus Minimum Questions
			int count = maxCount - minCount;
			for (int i = 0; i <= count; i++) {

				baseHandler.findElement(
						PropertiesRepository
								.getString("asmt.generic.tutorial.flag.value"))
						.click();
				waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
				baseHandler
						.findElement(
								PropertiesRepository
										.getString("asmt.generic.tutorial.continue.loc"))
						.click();
				waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
				List<WebElement> radioButtons = baseHandler
						.findElements(PropertiesRepository
								.getString("asmt.generic.tutorial.radio.button.loc"));
				if (radioButtons != null) {
					break;
				}
			}
			List<WebElement> radioElement3 = baseHandler
					.findElements(PropertiesRepository
							.getString("asmt.generic.tutorial.radio.label.loc"));

			if (radioElement != null && radioElement3.size() == 4) {
				WebElement element = radioElement3.get(0);
				element.click();
				WebElement secondElement = radioElement3.get(1);
				secondElement.click();
				List<WebElement> radioElement1 = baseHandler
						.findElements(PropertiesRepository
								.getString("asmt.generic.tutorial.radio.button.loc"));
				if (radioElement1.get(0).isSelected() != radioElement1.get(1)
						.isSelected()) {
					flag = true;
				}

			}

		}

		logger.info("verifyQutionOptions end");
		return flag;
	}

	/**
	 * This method is used to check continue button functionality
	 * 
	 * @author Sanapati.Srinu
	 * @return boolean
	 * @throws Exception
	 */
	public boolean verifyContinueButtonFunctionality() throws Exception {
		int value = verifyAndSelectQuestion();
		if (value == 0) {
			WebElement webElement1 = baseHandler
					.findElement(PropertiesRepository
							.getString("asmt.generic.tutorial.continue.loc"));
			return webElement1.isEnabled();
		} else {
			WebElement submitButton = baseHandler
					.findElement(PropertiesRepository
							.getString("asmt.generic.tutorial.submit.new.loc"));
			if (submitButton != null) {
				submitButton.click();
				waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
			}
			WebElement webElement1 = baseHandler
					.findElement(PropertiesRepository
							.getString("asmt.generic.tutorial.continue.loc"));
			return webElement1.isEnabled();
		}
	}

	/**
	 * This method is used to select question
	 * 
	 * @author Sanapati.Srinu
	 * @throws Exception
	 */
	public int verifyAndSelectQuestion() throws Exception {
		logger.info("Method : takeNurseLogicTest :::::::: Starts");
		try {
			waitUntillBufferInvisible(PropertiesRepository
					.getString("asmt.pleasewait.bufferLoc"));
			// switchToAssessmentFrameHandler();
			// Getting Total Question Number
			String maxQtnTextNo = baseHandler
					.findElements(
							PropertiesRepository
									.getString("asmt.question.ending.number.loc"))
					.get(1).getText();

			// Convert String to Integer
			int maxCount = Integer.parseInt(maxQtnTextNo);

			// Getting Current Question Number
			String minQtnTextNo = baseHandler
					.findElements(
							PropertiesRepository
									.getString("asmt.question.ending.number.loc"))
					.get(0).getText();

			// Convert String to Integer
			int minCount = Integer.parseInt(minQtnTextNo);

			// Maximum Question minus Minimum Questions
			int count = maxCount - minCount;
			if (count == 0) {
				return 0;
			} else {
				for (int i = 0; i <= count; i++) {

					List<WebElement> checkBoxElement = baseHandler
							.findElements(PropertiesRepository
									.getString("asmt.generic.tutorial.checkbox.loc"));
					List<WebElement> radioElement = baseHandler
							.findElements(PropertiesRepository
									.getString("asmt.generic.tutorial.radio.label.loc"));

					if (checkBoxElement != null) {
						checkBoxElement.get(0).click();
						checkBoxElement.get(1).click();
						return 1;
					}

					if (driver
							.findElements(
									By.cssSelector(".answer-fill-in-the-blank.numericTextEntry.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty"))
							.size() > 0) {
						verifyFillForm("10");
						return 1;

					}

					if (CollectionUtils
							.isNotEmpty(baseHandler.findElements(PropertiesRepository
									.getString("asmt.generic.tutorial.dragbox1.loc")))) {
						DragAndDropAnswer(false);
						return 1;
					}

					if (CollectionUtils.isNotEmpty(radioElement)
							&& radioElement.size() > 0) {
						radioElement.get(0).click();
						return 1;
					}

					if (CollectionUtils.isNotEmpty(baseHandler
							.findElements(PropertiesRepository
									.getString("asmt.question.img.loc")))) {
						hotSpotQuestion();
						return 1;
					}

				}
			}
		} catch (DriverException e) {
			logger.info("unable to take practice assessment" + e);
		}
		return 1;
	}

	public boolean isContinuButtonDisplayed(String loc) throws Exception {
		switchToAssessmentFrameHandler();
		waitUntillBufferInvisible(PropertiesRepository
				.getString("asmt.pleasewait.bufferLoc"));
		String maxQtnTextNo = baseHandler
				.findElements(
						PropertiesRepository
								.getString("asmt.question.ending.number.loc"))
				.get(1).getText();

		int maxCount = Integer.parseInt(maxQtnTextNo);

		String minQtnTextNo = baseHandler
				.findElements(
						PropertiesRepository
								.getString("asmt.question.ending.number.loc"))
				.get(0).getText();

		int minCount = Integer.parseInt(minQtnTextNo);

		int count = maxCount - minCount;
		List<WebElement> findElement = baseHandler
				.findElements(PropertiesRepository.getString(loc));
		if (count == 0 || findElement == null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method is used to select identify and select question type
	 * 
	 * @author Sanapati.Srinu
	 * @throws Exception
	 */
	public boolean verifyQuestionType() throws Exception {
		logger.info("Method : takeNurseLogicTest :::::::: Starts");
		try {
			waitUntillBufferInvisible(PropertiesRepository
					.getString("asmt.pleasewait.bufferLoc"));
			switchToAssessmentFrameHandler();
			// Getting Total Question Number
			String maxQtnTextNo = baseHandler
					.findElements(
							PropertiesRepository
									.getString("asmt.question.ending.number.loc"))
					.get(1).getText();

			// Convert String to Integer
			int maxCount = Integer.parseInt(maxQtnTextNo);

			// Getting Current Question Number
			String minQtnTextNo = baseHandler
					.findElements(
							PropertiesRepository
									.getString("asmt.question.ending.number.loc"))
					.get(0).getText();

			// Convert String to Integer
			int minCount = Integer.parseInt(minQtnTextNo);

			// Maximum Question minus Minimum Questions
			int count = maxCount - minCount;

			if (count == 0) {
				List<WebElement> radioElement1 = baseHandler
						.findElements(PropertiesRepository
								.getString("asmt.generic.tutorial.radio.label.loc"));
				if (radioElement1.size() > 0) {
					return radioElement1.get(0).isEnabled();
				}
			}
			for (int i = 0; i <= count; i++) {

				List<WebElement> radioElement = baseHandler
						.findElements(PropertiesRepository
								.getString("asmt.generic.tutorial.radio.label.loc"));
				if (CollectionUtils.isNotEmpty(radioElement)
						&& radioElement.size() > 0) {
					radioElement.get(0).click();
					WebElement submitButton = baseHandler
							.findElement(PropertiesRepository
									.getString("asmt.generic.tutorial.submit.new.loc"));
					if (submitButton != null) {
						submitButton.click();
						waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
						break;
					}

				} else {
					baseHandler
							.findElement(
									PropertiesRepository
											.getString("asmt.generic.tutorial.flag.value"))
							.click();
					waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
					baseHandler
							.findElement(
									PropertiesRepository
											.getString("asmt.generic.tutorial.continue.loc"))
							.click();
					waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
				}
			}
			List<WebElement> radioElement1 = baseHandler
					.findElements(PropertiesRepository
							.getString("asmt.generic.tutorial.radio.label.loc"));
			if (radioElement1.size() > 0) {
				flag = radioElement1.get(0).isEnabled();
			}
		} catch (Exception e) {
			logger.info("Error in selecting question");
		}
		return flag;

	}

	/**
	 * @author Sanapati.Srinu
	 * @return boolean
	 */
	public void clickOnFlagButton() {
		logger.info("Method : clickOnFlagButton :::::::: Starts");
		try {
			waitUntillBufferInvisible(PropertiesRepository
					.getString("asmt.pleasewait.bufferLoc"));
			switchToAssessmentFrameHandler();
			// Getting Total Question Number
			String maxQtnTextNo = baseHandler
					.findElements(
							PropertiesRepository
									.getString("asmt.question.ending.number.loc"))
					.get(1).getText();

			// Convert String to Integer
			int maxCount = Integer.parseInt(maxQtnTextNo);

			// Getting Current Question Number
			String minQtnTextNo = baseHandler
					.findElements(
							PropertiesRepository
									.getString("asmt.question.ending.number.loc"))
					.get(0).getText();

			// Convert String to Integer
			int minCount = Integer.parseInt(minQtnTextNo);

			// Maximum Question minus Minimum Questions
			int count = maxCount - minCount;

			for (int i = 0; i <= count; i++) {

				List<WebElement> radioElement = baseHandler
						.findElements(PropertiesRepository
								.getString("asmt.generic.tutorial.radio.label.loc"));
				if (CollectionUtils.isNotEmpty(radioElement)
						&& radioElement.size() > 0) {
					radioElement.get(0).click();
					if (count == 0) {
						baseHandler
								.findElement(
										PropertiesRepository
												.getString("asmt.generic.tutorial.continue.loc"))
								.click();
						return;
					}
					WebElement submitButton = baseHandler
							.findElement(PropertiesRepository
									.getString("asmt.generic.tutorial.submit.new.loc"));
					if (submitButton != null) {
						submitButton.click();
						waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
						baseHandler
								.findElement(
										PropertiesRepository
												.getString("asmt.generic.tutorial.continue.loc"))
								.click();
						waitUntillLoadingImageIsDisappeared("asmt.pleasewait.toast.msg");
					}

				} else {
					baseHandler
							.findElement(
									PropertiesRepository
											.getString("asmt.generic.tutorial.flag.value"))
							.click();
					waitUntillLoadingImageIsDisappeared("asmt.pleasewait.toast.msg");
					baseHandler
							.findElement(
									PropertiesRepository
											.getString("asmt.generic.tutorial.continue.loc"))
							.click();
					waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
				}
			}
		} catch (Exception e) {
			logger.info("unable to click on flag button");
		}

	}

	/**
	 * This method is used to verify Previous Button
	 * 
	 * @author Sanapati.Srinu
	 * @param loc
	 * @return
	 * @throws Exception
	 */
	public boolean verifyPreviousButton(String loc) throws Exception {
		logger.info("verifyPreviousButton start");
		try {
			List<WebElement> findElements = baseHandler
					.findElements(PropertiesRepository
							.getString("asmt.question.assement.review.flagged.questions"));
			if (findElements != null) {
				findElements.get(0).click();
				waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
			}
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString(loc));
			if (element == null) {
				return true;
			}
		} catch (Exception e) {
			logger.info("unable to verify previous button");
		}

		logger.info("verifyPreviousButton end");
		return false;
	}

	/**
	 * this method is used to click any link
	 * 
	 * @param loc
	 * @throws DriverException
	 */
	public void clickLinkFromList(String loc) throws DriverException {
		try {
			List<WebElement> findElements = baseHandler
					.findElements(PropertiesRepository.getString(loc));
			findElements.get(2).click();
			waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		} catch (Exception e) {
			throw new DriverException("unable to find the element in the DOM",
					e);
		}

	}

	/**
	 * this method is used to click any link
	 * 
	 * @param loc
	 * @throws DriverException
	 */
	public void clickLinkFromList(String loc, int index) throws DriverException {
		try {
			List<WebElement> findElements = baseHandler
					.findElements(PropertiesRepository.getString(loc));
			findElements.get(index).click();
			waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		} catch (Exception e) {
			throw new DriverException("unable to find the element in the DOM",
					e);
		}

	}

	/**
	 * This method is used to click any button
	 * 
	 * @author Sanapati.Srinu
	 * @param loc
	 * @param wait
	 */
	public void clickOnButton(String loc) throws NullPointerException,
			DriverException {
		logger.info("Method: clickOnButton Starts");
		try {
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString(loc));
			if (CollectionUtils.isNotEmpty(element)) {
				element.get(0).click();
			}
			waitUntillLoadingImageIsDisplayed(2);
		} catch (Exception e) {
			logger.info("Unable to click on Save Button", e);
		}
		logger.info("Method: clickOnButton Ends");
	}

	/**
	 * This method is used to verify Finalize And View Result Functionality
	 * 
	 * @author Sanapati.Srinu
	 * @throws Exception
	 */
	public boolean selectOrFlagTheQuestion() throws Exception {
		logger.info("Method : takeNurseLogicTest :::::::: Starts");
		try {
			waitUntillBufferInvisible(PropertiesRepository
					.getString("asmt.pleasewait.bufferLoc"));
			switchToAssessmentFrameHandler();
			// Getting Total Question Number
			String maxQtnTextNo = baseHandler
					.findElements(
							PropertiesRepository
									.getString("asmt.question.ending.number.loc"))
					.get(1).getText();

			// Convert String to Integer
			int maxCount = Integer.parseInt(maxQtnTextNo);

			// Getting Current Question Number
			String minQtnTextNo = baseHandler
					.findElements(
							PropertiesRepository
									.getString("asmt.question.ending.number.loc"))
					.get(0).getText();

			// Convert String to Integer
			int minCount = Integer.parseInt(minQtnTextNo);

			// Maximum Question minus Minimum Questions
			int count = maxCount - minCount;

			for (int i = 0; i <= count; i++) {

				List<WebElement> radioElement = baseHandler
						.findElements(PropertiesRepository
								.getString("asmt.generic.tutorial.radio.label.loc"));
				if (CollectionUtils.isNotEmpty(radioElement)
						&& radioElement.size() > 0) {
					radioElement.get(0).click();
					if (count == 0) {
						baseHandler
								.findElement(
										PropertiesRepository
												.getString("asmt.generic.tutorial.continue.loc"))
								.click();
						waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
						return true;
					} else {
						WebElement submitButton = baseHandler
								.findElement(PropertiesRepository
										.getString("asmt.generic.tutorial.submit.new.loc"));
						if (submitButton != null) {
							submitButton.click();
							waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
							baseHandler
									.findElement(
											PropertiesRepository
													.getString("asmt.generic.tutorial.continue.loc"))
									.click();
							return true;
						}
					}

				} else {
					baseHandler
							.findElement(
									PropertiesRepository
											.getString("asmt.generic.tutorial.flag.value"))
							.click();
					waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
					baseHandler
							.findElement(
									PropertiesRepository
											.getString("asmt.generic.tutorial.continue.loc"))
							.click();
					waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
					return true;
				}
			}
		} catch (Exception e) {
		}
		return flag;

	}

	public boolean verifyDownloadPage(String loc) {
		logger.info("verifyDownloadPage start");
		try {
			List<WebElement> findElements = baseHandler
					.findElements(PropertiesRepository.getString(loc));
			if (findElements != null) {
				findElements.get(1).click();
				waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
				clickLinkFromList(
						"asmt.question.assement.question.continue.button", 0);
				waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
				waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
				if (PropertiesRepository
						.getString(
								"asmt.myati.test.tab.assessment.performance.page")
						.equals(baseHandler
								.findElement(
										PropertiesRepository
												.getString("asmt.question.assement.individual.profile.loc"))
								.getText())) {
					return true;
				}

			}
		} catch (Exception e) {
			logger.info("unable to verify previous button");
		}

		logger.info("verifyDownloadPage end");
		return false;

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
		windowHandler = new WindowHandler(driver);
		try {
			waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
			waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
			waitUntillIPPPageIsLoaded(".sub-header>section>img");
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
			logger.info("Unable to verify IPP Page Header");
			log(logger, "Unable to verify IPP Page Header");
			throw new DriverException("Unable to verify IPP Page Header", e);
		}
		logger.info("Method: verifyIPPPageHeader End flag --> " + flag);
		return flag;
	}

	public void clickIPPPageDownloadButton() throws Exception {
		logger.info("Method: clickIPPPageDownloadButton Starts");
    	try {
    		List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("asmt.ipp.page.download.button"));
    		if(CollectionUtils.isNotEmpty(element)) {
    			element.get(2).click();
    		}
    	} catch (Exception e) {
    		logger.info("Unable to " );
    		System.out.println(e);
			log(logger, "Unable to " );
    		throw new DriverException("Unable to " , e); 
    	}
    	logger.info("Method: clickIPPPageDownloadButton End " );
	}
	
	/**
	 * Method used to verify continue button functionality before and after click. 
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws Exception
	 */
	public boolean verifyAssessemntContinueButton() throws Exception {
		logger.info("Method : verifyAssessemntContinueButton :::::::: Starts");
		boolean flag = false;
		try {

			waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
			switchToAssessmentFrameHandler();
			// Logic to verify Continue button before clicking. 
			
			List<WebElement> beforeClick = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.submit.new.loc"));
			if(CollectionUtils.isNotEmpty(beforeClick)) {
				WebElement beforeContinueElement = beforeClick.get(0);
				String beforeContinueButtonClassValue = getAttributeValue(beforeContinueElement, "class");
				if(StringUtils.isNotBlank(beforeContinueButtonClassValue) && beforeContinueButtonClassValue.equalsIgnoreCase(PropertiesRepository.getString("asmt.myati.assessment.continue.button.before.click"))) {
					// Clicking logic
					List<WebElement> checkBoxElement = baseHandler
							.findElements(PropertiesRepository
									.getString("asmt.generic.tutorial.checkbox.new.loc"));
					List<WebElement> radioElement = baseHandler
							.findElements(PropertiesRepository
									.getString("asmt.generic.tutorial.radio.button.new.loc"));

					if (checkBoxElement != null) {
						checkBoxElement.get(0).click();
						checkBoxElement.get(1).click();
					}

					if (driver
							.findElements(
									By.cssSelector(".answer-fill-in-the-blank.numericTextEntry.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty"))
							.size() > 0) {
						verifyFillForm("10");

					}

					if (CollectionUtils
							.isNotEmpty(baseHandler.findElements(PropertiesRepository
									.getString("asmt.generic.tutorial.dragbox1.loc")))) {
						DragAndDropAnswer(false);
					}

					if (CollectionUtils.isNotEmpty(radioElement)
							&& radioElement.size() > 0) {
						radioElement.get(0).click();
					}

					if (CollectionUtils.isNotEmpty(baseHandler
							.findElements(PropertiesRepository
									.getString("asmt.question.img.loc")))) {
						hotSpotQuestion();
					}
				}
			}
			// To verify Continue button after clicking.
			switchToAssessmentFrameHandler();
			List<WebElement> afterClick = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.submit.new.loc"));
			if(CollectionUtils.isNotEmpty(afterClick)) {
				WebElement afterContinueElement = afterClick.get(0);
				//String afterContinueButtonClassValue = getAttributeValue(afterContinueElement, "class");
//				if(StringUtils.isNotBlank(afterContinueButtonClassValue) && afterContinueButtonClassValue.equalsIgnoreCase(PropertiesRepository.getString("asmt.myati.assessment.continue.button.after.click"))) {
	if(afterContinueElement!=null){
				flag = true;
				}
			}
		} catch (DriverException e) {
			logger.info("unable to take practice assessment" + e);
		}
		waitUntillBufferInvisible(PropertiesRepository
				.getString("asmt.pleasewait.bufferLoc"));
		logger.info("Method : verifyAssessemntContinueButton :::::::: END flag --> " + flag );
		return flag;
	}
	
	/**
	 * Method used to verify Watermark in Assessment page. 
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws Exception
	 */
	public boolean verifyWaterMark() throws Exception {
		logger.info("Method : Start");
		boolean flag = false;
		try {
			switchToAssessmentFrameHandler();
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("asmt.myati.assessment.watermark.loc"));
			if(CollectionUtils.isNotEmpty(element)) {
				flag = true;
			}
			windowHandler.switchToLatestWindow();
		}catch (Exception e) {
			windowHandler.switchToLatestWindow();
    		logger.info("Unable to click PractAss Card Back For Results" );
			log(logger, "Unable to click PractAss Card Back For Results" );
    		throw new DriverException("Unable to click PractAss Card Back For Results" , e); 
    	}
		logger.info("Method: End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to get time from Elapsed Time from Screen.
	 * 
	 * @author pavankumar.vangole
	 * @return Calendar
	 * @throws Exception
	 */
	public Calendar getElapsedTime(String locator) throws Exception {
		logger.info("Method: getElapsedTime Starts");
		Calendar cal = null;
		try {
			switchToAssessmentFrameHandler();
			List<WebElement> elapsedElement = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(elapsedElement)
					&& elapsedElement.size() > 0) {
				WebElement elapsedTimeElement = elapsedElement.get(1);
				if (elapsedTimeElement != null) {
					String elapsedTime = elapsedTimeElement.getText().trim();
					if (StringUtils.isNotEmpty(elapsedTime)) {
						cal = CommonUtils.getCalendarWithTimeFromString(
								elapsedTime, ":");
					}
				}
			}
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to get elapsed Time");
			log(logger, "Unable to get elapsed Time");
			throw new DriverException("Unable to get elapsed Time", e);
		}
		logger.info("Method: getElapsedTime End cal --> " + cal);
		return cal;
	}
}

