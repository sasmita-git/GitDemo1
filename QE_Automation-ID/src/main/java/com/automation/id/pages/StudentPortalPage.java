package com.automation.id.pages;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.ButtonHandler;
import com.ascendlearning.automation.ui.handlers.TextHandler;

public class StudentPortalPage extends IDBasePage {

	private Logger logger = LogManager.getLogger(this.getClass());
	public String actualText = "";
	public BaseHandler baseHandler;
	private TextHandler textHandler;
	private ButtonHandler buttonHandler;
	
	public StudentPortalPage(WebDriver webDriver) {
		super(webDriver);
		baseHandler = new BaseHandler(driver);
		textHandler = new TextHandler(driver);
		buttonHandler = new ButtonHandler(driver);
	}

	/**
	 * Method used to click on Tab
	 * Home, MyATI, MyResults and Help
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	public void clickSubTab(int index) throws Exception {
		logger.info("Method: clickTab Starts");
    	try {
    		waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
    		List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.myati.improve.tab.loc"));
    		if(CollectionUtils.isNotEmpty(element)) {
    			element.get(index).click();
    				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
    		}
    	} catch (Exception e) {
    		logger.info("Unable to click Tab" );
			log(logger, "Unable to click Tab" );
    		throw new DriverException("Unable to click Tab" , e); 
    	}
    	logger.info("Method: clickTab End " );
	}
	
	/**
	 * Method used to click on Tab
	 * Home, MyATI, MyResults and Help
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	public void clickTab(int index) throws Exception {
		logger.info("Method: clickTab Starts");
    	try {
    		waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
    		List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.all.tabs"));
    		if(CollectionUtils.isNotEmpty(element)) {
    			List<WebElement> tabElement = element.get(0).findElements(By.cssSelector(PropertiesRepository.getString("new-atitesting.common.li")));
    			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
    			if(CollectionUtils.isNotEmpty(tabElement)) {
    				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tabElement.get(index));
    				tabElement.get(index).click();
    				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
    			}
    		}
    	} catch (Exception e) {
    		logger.info("Unable to click Tab" );
			log(logger, "Unable to click Tab" );
    		throw new DriverException("Unable to click Tab" , e); 
    	}
    	logger.info("Method: clickTab End " );
	}
	
	/**
	 * @author Sanapati.Srinu
	 * @param loc
	 * @return boolean
	 * @throws DriverException
	 */
	public boolean isElementDisplayed(String loc) throws DriverException {
		logger.info("Method: isElementDisplayed Start");
		try {
			WebElement findElement = baseHandler.findElement(PropertiesRepository.getString(loc));
			if (findElement != null) {
				return findElement.isDisplayed();
			}

		} catch (Exception e) {
			throw new DriverException("element is not visible", e);
		}

		logger.info("Method: isElementDisplayed End");
		return false;
	}
	/**
	 * Method to used to login to application.
	 * 
	 * @param userName
	 * @param password
	 * @return
	 * @throws DriverException
	 */
	public boolean loginToApplication(String userName, String password) throws DriverException {
		logger.info("Method : loginToApplication :::::::: START ");
		boolean flag = false;
		try {
			driver.get(PropertiesRepository.getString("newati.login.url"));

			driver.manage().deleteAllCookies();

			logger.info("User name --> " + userName);
			logger.info("Password --> " + password);

			if (baseHandler.isDisplayed(PropertiesRepository.getString("new-atitesting.homepage.userNameLoc"))
					&& baseHandler.isDisplayed(PropertiesRepository.getString("new-atitesting.homepage.passwordLoc"))
					&& StringUtils.isNotBlank(userName) && StringUtils.isNotBlank(password)) {
				// User Name
				logger.info("UserName Element & Password is displayed ");
				textHandler.writeText(PropertiesRepository.getString("new-atitesting.homepage.userNameLoc"), userName);
				// Password
				textHandler.writeText(PropertiesRepository.getString("new-atitesting.homepage.passwordLoc"), password);
				logger.info("Password value -->"
						+ getText(PropertiesRepository.getString("new-atitesting.homepage.passwordLoc")));
				// Click Go Button
				buttonHandler.clickButton(PropertiesRepository.getString("new-atitesting.goBtnLoc"));
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

				String termsHeader = getText(PropertiesRepository.getString("new-atitesting.paymentstabloc"));

				if (StringUtils.isNotEmpty(termsHeader) && "ATI Terms of Use".equalsIgnoreCase(termsHeader)) {
					// Clicking on Check Box.
					verifyAndClickWithList(".checkbox-not-checked", 3, true);

					// Clicking on Continue Button.
					verifyAndClick(PropertiesRepository.getString("new-atitesting.smartprep.continue.button"), true);

					// Wait for loading image.
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

				}

				String welcomepopup = getText(PropertiesRepository.getString("new-atitesting.welcometoati"));

				if (StringUtils.isNotEmpty(welcomepopup) && "Welcome to ATI!".equalsIgnoreCase(welcomepopup)) {

					// Clicking on Continue Button.
					verifyAndClick(PropertiesRepository.getString("new-atitesting.welcometoati.close"), true);

					// Wait for loading image.
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				}

				MaintanacePopUp();
				flag = true;
			} else {
				logger.info("Unable to login To Application");
			}

		} catch (Exception e) {
			logger.info("Unable to login To Application" + e);
			log(logger, "Unable to login To Application" + e);
			throw new DriverException("Unable to login To Application", e);
		}

		logger.info("Method : loginToApplication :::::::: End flag --> " + flag);
		return flag;
	}
	
	public String getText(String textLocator) throws DriverException {
		logger.info("NewATIBasePage getText() Start  " + textLocator);
		String text = null;
		List<WebElement> element = baseHandler.findElements(textLocator);
		if (CollectionUtils.isNotEmpty(element)) {
			text = textHandler.getText(textLocator);
		}
		logger.info("NewATIBasePage getText() End " + text);
		return text;
	}
	
	/*
	 * @author syed.pasha
	 */
	public void MaintanacePopUp() throws InterruptedException {
		logger.info("Method : Verifying Maintance pop-up :::: START ");
		Thread.sleep(2000);
		// List<WebElement> buttonList =
		// baseHandler.findElements(".wm-template-text");
		List<WebElement> buttonList = driver.findElements(By.cssSelector(".wm-close-button"));
		if (CollectionUtils.isNotEmpty(buttonList)) {
			driver.findElement(By.cssSelector(".wm-close-button")).click();
			Thread.sleep(1000);
		}

		logger.info("Method : Verifying Maintance pop-up :::: END");
	}
	
	
	/**
	 * Method used to verify element and if required, it will click.
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @param click
	 * @return
	 * @throws NullPointerException
	 * @throws DriverException
	 */
	public boolean verifyAndClickWithList(String locator, int index, boolean click)
			throws NullPointerException, DriverException {
		logger.info("Method: verifyAndClickWithList Starts");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(element)) {
				if (click) {
					element.get(index).click();
				}
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to verifyAndClickWithList");
			log(logger, "Unable to verifyAndClickWithList");
			throw new DriverException("Unable to verifyAndClickWithList", e);
		}
		logger.info("Method: verifyAndClickWithList End flag --> " + flag);
		return flag;
	}

	/**
	 * Method used to click on Practice/ Proctor Card Front button.
	 * 
	 * @param assessmentType
	 *            - Practice/ Proctor
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
					PropertiesRepository.getString("new-atitesting.myati.test.tab.verify.details.are.displaye.loc"));
			if (baseHandler.isDisplayed(
					PropertiesRepository.getString("new-atitesting.myati.test.tab.verify.details.are.displaye.loc"))) {
				List<WebElement> pracProcCardElement = baseHandler.findElements(
						PropertiesRepository.getString("new-atitesting.myati.test.tab.verify.details.are.displaye.loc"));
				if (CollectionUtils.isNotEmpty(pracProcCardElement)) {
					int size = pracProcCardElement.size();
					for (int index = 0; index < size; index++) {
						if (breakFlag) {
							break;
						}
						WebElement assessmentTypeElement = pracProcCardElement.get(index);
						// Validating Assessment Type
						WebElement assessmentTypeSingleElement = assessmentTypeElement.findElement(By.cssSelector(
								PropertiesRepository.getString("new-atitesting.myati.test.tab.assessment.type.loc")));
						if (assessmentTypeSingleElement != null) {
							String assessmentTypeValue = assessmentTypeSingleElement.getText().trim();
							if (StringUtils.isNotEmpty(assessmentTypeValue)
									&& assessmentTypeValue.equalsIgnoreCase(assessmentType)) {
								// Validating Assessment Name
								WebElement assessmentNameElement = assessmentTypeElement.findElement(By.cssSelector(
										PropertiesRepository.getString("new-atitesting.myati.test.tab.assessment.name.loc")));
								if (assessmentNameElement != null) {
									String assessmentNameValue = assessmentNameElement.getText().trim()
											.replaceAll("\\r\\n|\\r|\\n", " ");
									if (StringUtils.isNotEmpty(assessmentNameValue)
											&& assessmentNameValue.equalsIgnoreCase(assessmentName)) {
										
										List<WebElement> buttonList = baseHandler.findElements("a[id$='0']");
										for (int i = 0; i < buttonList.size(); i++) {
											if(!(buttonList.get(i).getAttribute("style").equalsIgnoreCase("display: none;"))){
												buttonList.get(i).click();
												break;
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

		logger.info("Method: clickTestTabAssessmentButtonNew End");
	}
	
	/**
	 * This method is used to complete incomplete test and relaunch that test.
	 * 
	 * @author Abhishek Kumar
	 * @throws InterruptedException
	 */
	public void completeContinueStateAssessment(String assessmentType,String assessmentName) throws Exception {
		logger.info("Method : completeContinueStateAssessment :::::::: Starts");
		try {

			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			switchToAssessmentFrameHandler();
			// Getting Total Question Number
			String maxQtnTextNo = baseHandler
					.findElements(
							PropertiesRepository
									.getString("new-atitesting.question.ending.number.loc"))
					.get(1).getText();

			// Convert String to Integer
			int maxCount = Integer.parseInt(maxQtnTextNo);

			// Getting Current Question Number
			String minQtnTextNo = baseHandler
					.findElements(
							PropertiesRepository
									.getString("new-atitesting.question.ending.number.loc"))
					.get(0).getText();

			// Convert String to Integer
			int minCount = Integer.parseInt(minQtnTextNo);

			// Maximum Question minus Minimum Questions
			int count = maxCount - minCount;
			
			boolean flag1=false;
			if(count==0){
				flag1=true;
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				//Click on Flag button if it is not clicked.
				try{
					clickButton(PropertiesRepository.getString("new-atitesting.generic.tutorial.flag.value"), 0);
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
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
				clickButton(PropertiesRepository.getString("new-atitesting.generic.tutorial.flag.value"), 0);
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				
				List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
				if(CollectionUtils.isNotEmpty(rationalContinue)) {
					rationalContinue.get(0).sendKeys(Keys.ENTER);
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");					
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
				baseHandler.findElement(".button.secondary-button.focus-element-flag").click();
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			}catch(Exception e) {
				logger.info("unable to Click on continue if 'Review flag question pop-up is shown" + e);
			}
			
			if(flag1==true){
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				waitUntillIPPPageIsLoaded(".sub-header>section>img");
				waitUntillIPPPageIsLoaded(".sub-header>section>img");
				baseHandler.findElement(".close-button.focus-element-flag").click();
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				log(logger, "Clicking on Test Tab");
				clickLinkFromList("new-atitesting",1);

				log(logger,
						"Verifying Test Tab Practice and Proctor is displayed or not");
				verifyTestTabDetails();
				clickTestTabAssessmentButtonNew(assessmentType,assessmentName);
			}
			windowHandler.switchToLatestWindow();
			logger.info("Method : completeContinueStateAssessment :::::::: Ends");
		}catch(DriverException e) {
			logger.info("unable to take practice assessment" + e);
			
		}
	}
	
	
	/**
	 * Method used to verify whether test tab details are displayed. Verifying
	 * whether Practice/ Proctor Card is displayed or not.
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws Exception
	 */
	public boolean verifyTestTabDetails() throws Exception {
		logger.info("Method: verifyTestTabDetails Starts");
		boolean flag = false;
		try {
			List<WebElement> pracProcCardElement = baseHandler
					.findElements(PropertiesRepository
							.getString("new-atitesting.myati.test.tab.verify.details.are.displaye.loc"));
			if (CollectionUtils.isNotEmpty(pracProcCardElement)
					&& pracProcCardElement.size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to verify Test Tab Details");
			log(logger, "Unable to verify Test Tab Details");
			throw new DriverException("Unable to verify Test Tab Details", e);
		}
		logger.info("Method: verifyTestTabDetails End flag --> " + flag);
		return flag;
	}
	
	/**
	 * This method is used to click on any button or link based on index.
	 * @author Sanapati.Srinu
	 * @param loc
	 * @param index
	 * @throws Exception 
	 */
	public void clickLinkFromList(String loc, int index) throws Exception {
		logger.info("clickLinkFromList Start");
		try {
		List<WebElement> findElement = baseHandler.findElements(PropertiesRepository.getString(loc));
		if(CollectionUtils.isNotEmpty(findElement))
		{
			findElement.get(index).click();
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		}
		} catch (Exception e) {
			logger.info("Unable to click Link From List");
			log(logger, "Unable to click Link From List");
			throw new DriverException("Unable to click Link From List", e);
		}
		logger.info("clickLinkFromList End");
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
							.getString("new-atitesting.myati.assessment.question.unanswered.close.loc"),
					0);
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

			// click on flag
			clickButton(
					PropertiesRepository
							.getString("new-atitesting.generic.tutorial.flag.value"),
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
	
	/**
	 * This method is used to create practice Assessment
	 * 
	 * @author Sagar.Rao
	 * 
	 * @throws InterruptedException
	 * 
	 * @throws DriverException
	 */
	public void takeAssessment(boolean bool, boolean flagquestion, String complButtonName)
			throws InterruptedException, DriverException {
		logger.info("takeAssessment starts");
		try {
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
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
						if(quizCompElement.getText().trim().contains(complButtonName)) {
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
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");											
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
						.getString("new-atitesting.peasewait.bufferLoc"));
				// windowHandler.switchToModalDialog();
				Thread.sleep(2000);
				buttonHandler.clickButton(PropertiesRepository
						.getString("new-atitesting.test.view.resultsLoc"));
				// click on view result button
				Thread.sleep(2000);
				waitUntillBufferInvisible(PropertiesRepository
						.getString("new-atitesting.peasewait.bufferLoc"));
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
	
	
	public void switchToAssessmentFrameHandler() throws Exception {
		logger.info("switchToAssessmentFrameHandler Start");
		try {
			windowHandler.switchToMainWindow();
			waitUntillBufferInvisible(PropertiesRepository
					.getString("new-atitesting.peasewait.bufferLoc"));
			windowHandler.switchToFrame("assessmentFrame");
		} catch (Exception e) {
			logger.info("Unable to switch To Assessment Frame Handler Start");
			throw new DriverException("Unable to switch To Assessment Frame Handler Start", e);
		}
		logger.info("Method: switchToAssessmentFrameHandler End ");
	}
	
	/**
	 * This method is used to wait until buffer invisible
	 * 
	 * @author Saravanan Jothimani 
	 */
	public void waitUntillBufferInvisible(String loc) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(loc)));
	}
	
	
}


