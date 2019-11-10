package com.automation.asmt.page;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
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

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.ButtonHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;

public class AssessmentCommonPage extends ASMTBasePage {
	private Logger logger = LogManager.getLogger(this.getClass());
	public BaseHandler baseHandler;
	private WindowHandler windowHandler;
	private ButtonHandler buttonHandler;
	private QuizBankAssessmentPage quizPage;
	private boolean flag;

	public AssessmentCommonPage(WebDriver webDriver) {
		super(webDriver);
		baseHandler = new BaseHandler(driver);
		windowHandler = new WindowHandler(driver);
		buttonHandler = new ButtonHandler(driver);
		quizPage = new QuizBankAssessmentPage(driver);
	}
	
	

	/*
	 * This method is used to verify if next question or assessment complete popup is displayed after clicking on Previous/Go Back to Last Question button
	 * 
	 * 
	 */
	public boolean verifyQuesNoOrAssCompletePopup() {
		logger.info("Method : verifyQuesNoOrAssCompletePopup :::::::: Starts");
		boolean flag = false;
		try {
			List<WebElement> maxQuestElement = baseHandler
					.findElements(PropertiesRepository.getString("asmt.question.no.loc1.new"));
			List<WebElement> assCompleteDialog = baseHandler
					.findElements(PropertiesRepository.getString("asmt.assPage.dialog.container.loc"));

			if (CollectionUtils.isNotEmpty(maxQuestElement) || CollectionUtils.isNotEmpty(assCompleteDialog)) {
				if(CollectionUtils.isNotEmpty(maxQuestElement))
				{
					clickButton(PropertiesRepository.getString("asmt.quiz.previous.btn.loc"), 0);
				}
				else
				{
					List<WebElement> assessmentCompleteElement = baseHandler.findElements(".complete-assessment-dialog div button");
					for (int i = 0; i < assessmentCompleteElement.size(); i++) {
						WebElement quizCompElement = assessmentCompleteElement.get(i);
						if (quizCompElement.getText().trim().contains("Go Back to Last Question")) {
							quizCompElement.click();
							waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
							break;
						}
					}
				}
				
				
				flag = true;
			}
		} catch (Exception e) {
			logger.info("unable to verifyQuesNoOrAssCompletePopup" + e);
		}
		logger.info("Method : verifyQuesNoOrAssCompletePopup :::::::: Starts");
		return flag;
	}	
	
	/**
	 * This method is used to complete incomplete test and re-launch that test.
	 * 
	 *@throws InterruptedException
	 */
	public void completeContinueStateAssessmentNew(String assessmentType,String assessmentName) throws Exception {
		logger.info("Method : completeContinueStateAssessmentNew :::::::: Starts ");
		try {
	
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
				//waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
				//Click on Flag button if it is not clicked.
				try{
					List<WebElement> buttonElement = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"));
					if (buttonElement.get(0).getCssValue("background-color").equals("rgba(255, 255, 255, 1)")) 
					{ 
					clickButton(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"), 0);
					waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
					}
				}catch(Exception e){
					
				}
				List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
				if(CollectionUtils.isNotEmpty(rationalContinue)) {
					
					rationalContinue.get(0).sendKeys(Keys.ENTER);
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");					
				}
				//close question unanswered pop-up if shown and click on flag and continue
				quizPage.handelQuestionUnansweredPopup();
				
			}else if(minCount>1){
				flag1=true;
				for (int i = 0; i <= count; i++) {
				//answering first question to handle the JIRA issue of IPP not loading if we flag all the questions
				if(i==0)
				{
					quizPage.clickAssessmemtType();
					switchToAssessmentFrameHandler();
				}
				List<WebElement> buttonElement = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"));
				if (buttonElement.get(0).getCssValue("background-color").equals("rgba(255, 255, 255, 1)")) 
				{ 
				clickButton(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"), 0);
				waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
				}
				
				List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
				if(CollectionUtils.isNotEmpty(rationalContinue)) {
					rationalContinue.get(0).sendKeys(Keys.ENTER);
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");					
					}
				}	
			}
			//waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			if(flag1==true){
			// Checking for Assessment Completed Popup
			List<WebElement> assessmentCompleteElement = baseHandler.findElements(".complete-assessment-dialog div button"); 
			if(CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
				quizPage.takeAssessment(false, false,"Finalize and View Results");
			}
			}
			//Click on continue if 'Review flag question pop-up is shown
			try{
				if(baseHandler.findElements(".button.secondary-button.focus-element-flag").size()!=0){
				baseHandler.findElement(".button.secondary-button.focus-element-flag").click();
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
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
			logger.info("Method : completeContinueStateAssessmentNew :::::::: Ends");
		}catch(DriverException e) {
			logger.info("unable to take practice assessment" + e);
			
		}
	}
	
	/**
	 * This method is used to complete incomplete test and DONT re-launch that test.
	 * 
	 *@throws InterruptedException
	 */
	public void completeContinueStateAssessmentNewNext( ) throws Exception {
		logger.info("Method : completeContinueStateAssessmentNew :::::::: Starts ");
		try {
	
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
				//waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
				//Click on Flag button if it is not clicked.
				try{
					List<WebElement> buttonElement = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"));
					if (buttonElement.get(0).getCssValue("background-color").equals("rgba(255, 255, 255, 1)")) 
					{ 
					clickButton(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"), 0);
					waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
					}
				}catch(Exception e){
					
				}
				List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
				if(CollectionUtils.isNotEmpty(rationalContinue)) {
					
					rationalContinue.get(0).sendKeys(Keys.ENTER);
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");					
				}
				//close question unanswered pop-up if shown and click on flag and continue
				quizPage.handelQuestionUnansweredPopup();
				
			}else if(minCount>1){
				flag1=true;
				for (int i = 0; i <= count; i++) {
				//answering first question to handle the JIRA issue of IPP not loading if we flag all the questions
				if(i==0)
				{
					quizPage.clickAssessmemtType();
					switchToAssessmentFrameHandler();
				}
				List<WebElement> buttonElement = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"));
				if (buttonElement.get(0).getCssValue("background-color").equals("rgba(255, 255, 255, 1)")) 
				{ 
				clickButton(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"), 0);
				waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
				}
				
				List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
				if(CollectionUtils.isNotEmpty(rationalContinue)) {
					rationalContinue.get(0).sendKeys(Keys.ENTER);
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");					
					}
				}	
			}
			//waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			if(flag1==true){
			// Checking for Assessment Completed Popup
			List<WebElement> assessmentCompleteElement = baseHandler.findElements(".complete-assessment-dialog div button"); 
			if(CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
				quizPage.takeAssessment(false, false,"Finalize and View Results");
			}
			}
			//Click on continue if 'Review flag question pop-up is shown
			try{
				if(baseHandler.findElements(".button.secondary-button.focus-element-flag").size()!=0){
				baseHandler.findElement(".button.secondary-button.focus-element-flag").click();
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
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
				
			}
			windowHandler.switchToLatestWindow();
			logger.info("Method : completeContinueStateAssessmentNewNext :::::::: Ends");
		}catch(DriverException e) {
			logger.info("unable to take practice assessment" + e);
			
		}
	}
	
	/**
	 * This method is used to complete incomplete test and re-launch that test.
	 * 
	 *@throws InterruptedException
	 */
	public void completeContinueStateTEAS(String assessmentType,String assessmentName) throws Exception {
		logger.info("Method : completeContinueStateTEAS :::::::: Starts");
		try {
			boolean	isSurveyLoaded = false;
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
			
			boolean sectionComplete=false;
			boolean flag1 = false;
			if(count==0){
				sectionComplete=true;
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
				quizPage.handelQuestionUnansweredPopup();
				
			}else{
				sectionComplete=true;
				for (int i = 0; i <= count; i++) {
				//answering first question to handle the JIRA issue of IPP not loading if we flag all the questions
				if(i==0)
				{
					quizPage.clickAssessmemtType();
				}
				clickButton(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"), 0);
				waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
				
				//answering  question as Survey Section does not have flagging option
				if(isSurveyLoaded)
				{
					quizPage.clickAssessmemtType();
				}
				
				List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
				if(CollectionUtils.isNotEmpty(rationalContinue)) {
					rationalContinue.get(0).sendKeys(Keys.ENTER);
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");					
					}
				}	
			}
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			
			if(sectionComplete==true){
			// Checking for Assessment Completed Popup
			List<WebElement> assessmentCompleteElement = baseHandler.findElements(".complete-assessment-dialog div button"); 
			if(CollectionUtils.isNotEmpty(assessmentCompleteElement) && assessmentCompleteElement.size()==3) {
				isSurveyLoaded = quizPage.takeAssessment(false, false,"");
				waitUntillElementIsVisible("#highlightWordsText");
				completeContinueStateTEAS(assessmentType,assessmentName);
			}
			else if(CollectionUtils.isNotEmpty(assessmentCompleteElement) && assessmentCompleteElement.size()==2){
				flag1=true;
				quizPage.takeAssessment(false, false,"Finalize and View Results");
			}
			}
			//Click on continue if 'Review flag question pop-up is shown
			try{
				if(baseHandler.findElements(".button.secondary-button.focus-element-flag").size()!=0){
				baseHandler.findElement(".button.secondary-button.focus-element-flag").click();
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
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

				log(logger,	"Verifying Test Tab Practice and Proctor is displayed or not");
				new AssessmentPage(driver).verifyTestTabDetails();
				new AssessmentPage(driver).clickTestTabAssessmentButtonNew(assessmentType,assessmentName);
			}
			windowHandler.switchToLatestWindow();
			logger.info("Method : completeContinueStateTEAS :::::::: Ends");
		}catch(DriverException e) {
			logger.info("unable to completeContinueStateTEAS" + e);
			
		}
	}
	
	public void hitTabKeyboardButton(int numberOftimes) throws DriverException {		
		try {
			Actions action = new Actions(driver); 
			for(int i=1 ; i<= numberOftimes ; i++){				
			action.sendKeys(Keys.TAB).build().perform();
			}
		} catch (Exception e) {
			logger.info("unable to hitTabKeyboardButton" + e);
			throw new DriverException("Unable to hitTabKeyboardButton" , e); 
		}		
	}
	
	public void hitSpacebKeyboardButton() throws DriverException {		
		try {
			Actions action = new Actions(driver); 
			action.sendKeys(Keys.SPACE).build().perform();
			
		} catch (Exception e) {
			logger.info("unable to hitTabKeyboardButton" + e);
			throw new DriverException("Unable to hitTabKeyboardButton" , e); 
		}		
	}

	public boolean navTocalcAndVerify() throws DriverException {
		boolean flag = false;
		try {
			Actions action = new Actions(driver); 
			action.sendKeys(Keys.TAB).build().perform();
			action.sendKeys(Keys.TAB).build().perform();
			action.sendKeys(Keys.TAB).build().perform();
			action.sendKeys(Keys.TAB).build().perform();
			action.sendKeys(Keys.ENTER).build().perform();
			if(baseHandler.findElement(PropertiesRepository.getString("asmt.calculator.section.loc")).isDisplayed())
			{
				flag=true;
			}
		} catch (Exception e) {
			logger.info("unable to Open and Verify Calculator" + e);
			throw new DriverException("Unable to Open and Verify Calculator" , e); 
		}	
		return flag;
	}
	
	public boolean answerRadioQuesByKeyboardBtns() throws DriverException {
		boolean flag = false;
		try {
			hitTabKeyboardButton(4);
			hitSpacebKeyboardButton();
			hitTabKeyboardButton(2);
			hitSpacebKeyboardButton();
			waitUntillElementIsVisible("#highlightWordsText");
			if(baseHandler.findElement("#highlightWordsText").isDisplayed())
			{
				flag=true;
			}
		} catch (Exception e) {
			logger.info("unable to answer question" + e);
			throw new DriverException("Unable to answer question" , e); 
		}	
		return flag;
	}

	/*
	 * Verifying if Begin/Continue button is displayed for the assessment on the card
	 * front
	 */
	public boolean verifybeginContinueBtnCF(String loc , String assessmentName) throws DriverException {
		boolean flag = false;
		try {
			List<WebElement> pracProcCardElement = baseHandler.findElements(PropertiesRepository.getString("asmt.myati.test.tab.verify.details.are.displaye.loc"));
			for (int i = 0; i < pracProcCardElement.size(); i++) {
				if((pracProcCardElement.get(i).isDisplayed()) && (pracProcCardElement.get(i).findElement(By.cssSelector(".description")).getText().equals(assessmentName))){
				flag = pracProcCardElement.get(i).findElement(By.cssSelector(loc)).isDisplayed();
				}
			}
		} catch (Exception e) {
			logger.info("unable to verifybeginContinueBtnCF" + e);
			throw new DriverException("Unable to verifybeginContinueBtnCF" , e); 
		}	
		return flag;
	}
	
	
}
