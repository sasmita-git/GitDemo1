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
import com.ascendlearning.automation.ui.handlers.WindowHandler;

public class FlashCardPage extends NewATIBasePage{

	private Logger logger = LogManager.getLogger(this.getClass());
	public String actualText = "";
	public BaseHandler baseHandler;
	private ButtonHandler buttonHandler;
	private WindowHandler windowHandler;
	
	public FlashCardPage(WebDriver webDriver) {
		super(webDriver);
		baseHandler = new BaseHandler(driver);
		buttonHandler = new ButtonHandler(driver);
		windowHandler = new WindowHandler(driver);
	}
	
	public String getFlashCardNameInCardFront() throws DriverException {
		logger.info("Method : getFlashCardNameInCardFront Start");
		String result = null;
		try {
			result = getText(PropertiesRepository.getString("new-atitesting.flashcard.cardfront.name.loc"));
		} catch (DriverException e) {
			logger.info("Unable to get name from card front in Flash Card");
			throw new DriverException("Unable to get name from card front in Flash Card ", e);
		}
		logger.info("Method : getFlashCardNameInCardFront End result --> " + result);
		return result;
	}
	
	/**
	 * Method is used to click on Modules on Card Front
	 * 
	 * @throws DriverException
	 */
	public void clickOnFlashcardModules() throws DriverException {
		logger.info("Method: clickOnQuizBankModules Start");
		try {
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			buttonHandler.clickButton("#tabs-1 ul[class='image-grid flipcontainer'] li:nth-child(1) section nav div:nth-child(1) a[class='button primary-button cardflip focus-element-flag']",
					PropertiesRepository.getString("new-atitesting.flashcard.cardback.being.button.loc"));
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		} catch (Exception e) {
			throw new DriverException("Unable to click on Quiz Bank modules", e);
		}
		logger.info("Method: clickOnQuizBankModules Ends");
	}

	
	/**
	 * Method is used to click on Begin Lesson on Card back.
	 * 
	 * @throws DriverException
	 */
	public void beginLesson() throws DriverException{
		logger.info("Method: beginLesson Start");
		try{
			//waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			//click on begin lesson
			buttonHandler.clickButton(PropertiesRepository
					.getString("new-atitesting.homepage.myatitab.flashcard.beginlesson.link.loc"));
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			//Switch to latest window
			windowHandler.switchToFrame("tutorialFrame");	
			
			setDriverWait(PropertiesRepository
					.getString("new-atitesting.homepage.myatitab.startflashcardlink.loc"));
			
		}
		catch(Exception e){
			throw new DriverException("Unable to click on info card",e);
		}
		logger.info("Method: beginLesson Ends");
	}
	
	public String getFlashCardNameInFlashCardAssessment() throws DriverException {
		logger.info("Method : getFlashCardNameInFlashCardAssessment Start");
		String result = null;
		try {
			windowHandler.switchToMainWindow();
			result = getText(PropertiesRepository.getString("new-atitesting.flashcard.assessment.page.loc"));
		} catch (DriverException e) {
			logger.info("Unable to get name from card front in Flash Card Assessment Page");
			throw new DriverException("Unable to get name from card front in Flash Card Assessment Page", e);
		}
		logger.info("Method : getFlashCardNameInFlashCardAssessment End result --> " + result);
		return result;
	}
	
	public void closeFlashCardAssessmentPopup(String locator) throws Exception {
		logger.info("closeAssessmentPopup Starts " );
		try {
			if(baseHandler.isDisplayed(baseHandler.findElement(PropertiesRepository
								.getString("new-atitesting.flashcard.assessment.page.loc")))) {
				buttonHandler.clickButton(".close-button.focus-element-flag");
				//driver.findElement(By.cssSelector(PropertiesRepository.getString(locator))).click();
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			}
			
		} catch (InterruptedException e) {
			throw new DriverException("Unable to click on Close button ", e);
		}
		logger.info("closeAssessmentPopup End");
	}
	
	public void closeFlashCardCardBack(String locator) throws DriverException {
		logger.info("closeCardBack Starts " );
		if(baseHandler.isDisplayed(baseHandler.findElement(PropertiesRepository
				.getString("new-atitesting.flashcard.cardback.all.product.list.loc")))) {
			buttonHandler.clickButton(PropertiesRepository.getString(locator), PropertiesRepository.getString("new-atitesting.all.modules.loc"));
		}
		logger.info("closeCardBack End");
	}
	
	public void startflashcard() throws DriverException, InterruptedException{
		logger.info("Method: beginLesson Start");
		try{
			//click on start flashcard
			buttonHandler.clickButtonWithWait(PropertiesRepository
					.getString("new-atitesting.homepage.myatitab.startflashcardlink.loc"));
			Thread.sleep(1000);
			
		}
		catch(Exception e){
			throw new DriverException("Unable to click on info card",e);
		}
		logger.info("Method: beginLesson Ends");
	}
	
	public void completeFlashAssessment() throws DriverException {
		logger.info("Method: completeFlashAssessment Start");
		try {
			windowHandler.switchToFrame("tutorialFrame");
			List<WebElement> totalTCCount = baseHandler.findElements(".flashcard-main-header p span[data-bind*='VisibleFlashcardCount']");
			if(CollectionUtils.isNotEmpty(totalTCCount)) {
				int tcCount = totalTCCount.size();
				for(int index = 0; index < tcCount; index ++) {
					List<WebElement> startFlashCardElement = baseHandler.findElements("#start-flashcards-btn");
					if(CollectionUtils.isNotEmpty(startFlashCardElement)) {
						// clicking on start flashcard button. 
						startFlashCardElement.get(0).click();
						// Clicking on 
					}
					
				}
			}
			List<WebElement> toValueElement = baseHandler.findElements("#flashcardQuestion1_0 h2 span");
			if(CollectionUtils.isNotEmpty(toValueElement)) {
				String totValue = toValueElement.get(2).getText();
				int value = Integer.parseInt(totValue);
				value = value +1;
				for (int i = 2; i <= value; i++) {
					Thread.sleep(1000);
					if (i == 3) {
						//Thread.sleep(1000);
						WebElement element = driver.findElement(By
								.cssSelector(PropertiesRepository.getString("new-atitesting.homepage.myatitab.showanswerbttn.loc")));
						element.click();

					} else {
						WebElement element = driver.findElement(By
								.cssSelector("#flashcard-slide div:nth-child(" + i
										+ ") #show-answer-btn"));
						element.click();
					}
					
					List<WebElement> elementYes = driver.findElements(By.cssSelector("#flashcard-slide div:nth-child("+i+") div:nth-child(2) header div button"));
					if(elementYes!=null) {
						WebElement element = null;
						if(i == 4 ) {
							element = elementYes.get(1);
						} else {
							element = elementYes.get(0);
						}
						baseHandler.waitToBeDisplayed(element);
						element.click();
					}
					
				}
			}
			
			logger.info("Method: completeFlashAssessment Ends");
		}
		catch (Exception e) {
			throw new DriverException("Unable to select answer in completeFlashAssessment", e);
		}
	}
	
	public void startFlashAssessment() throws DriverException {
		logger.info("Method: startFlashAssessment Start");
		try {
			
//			windowHandler.switchToFrame("tutorialFrame");
			
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			List<WebElement> toValueElement = baseHandler.findElements("#flashcardQuestion1_0 h2 span");
			if(CollectionUtils.isNotEmpty(toValueElement)) {
				String totValue = toValueElement.get(2).getText();
				int value = Integer.parseInt(totValue);
				value = value +1;
				for (int i = 2; i <= value; i++) {
					Thread.sleep(1000);
					if (i == 3) {
						//Thread.sleep(1000);
						WebElement element = driver.findElement(By
								.cssSelector(PropertiesRepository.getString("new-atitesting.homepage.myatitab.showanswerbttn.loc")));
						element.click();

					} else {
						WebElement element = driver.findElement(By
								.cssSelector("#flashcard-slide div:nth-child(" + i
										+ ") #show-answer-btn"));
						element.click();
					}
					
					List<WebElement> elementYes = driver.findElements(By.cssSelector("#flashcard-slide div:nth-child("+i+") div:nth-child(2) header div button"));
					if(elementYes!=null) {
						WebElement element = null;
						if(i == 4 ) {
							element = elementYes.get(1);
						} else {
							element = elementYes.get(0);
						}
						baseHandler.waitToBeDisplayed(element);
						element.click();
					}
					
				}
			}
			
			logger.info("Method: startFlashAssessment Ends");
		}

		catch (Exception e) {
			throw new DriverException("Unable to select answer", e);
		}
	}
	
	public String verifyResults() throws DriverException {
		String result = null;
		result = getText(PropertiesRepository.getString("new-atitesting.flashcard.result.loc"));
		return result;
	}
	
	public boolean verifyPrintResult() throws Exception {
		logger.info("Method: verifyPrintResult Starts");
		boolean flag = false;
    	try {
    		List<WebElement> element = baseHandler.findElements("#flashcard-final-screen .print-results-icon");
    		if(CollectionUtils.isNotEmpty(element)) {
    			flag = true;
    		}
    	} catch (Exception e) {
    		logger.info("Unable to verifyPrintResult");
			log(logger, "Unable to verifyPrintResult" );
    		throw new DriverException("Unable to verifyPrintResult" , e); 
    	}
    	logger.info("Method: verifyPrintResult End flag --> " + flag);
    	return flag;
	}
	
	public void clickPrintResult() throws Exception {
		logger.info("Method: clickPrintResult Starts");
    	try {
    		List<WebElement> element = baseHandler.findElements("#flashcard-final-screen .print-results-icon");
    		if(CollectionUtils.isNotEmpty(element)) {
    			element.get(0).click();
    		}
    	} catch (Exception e) {
    		logger.info("Unable to clickPrintResult");
			log(logger, "Unable to clickPrintResult" );
    		throw new DriverException("Unable to clickPrintResult" , e); 
    	}
    	logger.info("Method: clickPrintResult End ");
	}
	
	public boolean verifyPrintResultDetails() throws Exception {
		logger.info("Method: verifyPrintResultDetails Starts");
		boolean flag = false;
    	try {
    		List<WebElement> element = baseHandler.findElements("#pHeader");
    		if(CollectionUtils.isNotEmpty(element)) {
    			flag = true;
    		}
    	} catch (Exception e) {
    		logger.info("Unable to verifyPrintResultDetails");
			log(logger, "Unable to verifyPrintResultDetails" );
    		throw new DriverException("Unable to verifyPrintResultDetails" , e); 
    	}
    	logger.info("Method: verifyPrintResultDetails End flag --> " + flag);
    	return flag;
	}
	/**
	 * Method is used to click on Close button.
	 * 
	 */
	public void clickClose() throws Exception {
		logger.info("clickClose Starts");
		try {
    			windowHandler.switchToMainWindow();
    			buttonHandler
    					.clickButton(
    							PropertiesRepository
    									.getString("new-atitesting.homepage.myatitab.viewactlrntmplt.closepdf.loc"), true, 
    							PropertiesRepository
    									.getString("new-atitesting.cardback.close.loc"));
    			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	    	} catch (DriverException e) {
	    		logger.info("Unable to clickClose" );
				log(logger, "Unable to clickClose" );
	    		throw new DriverException("Unable to clickClose" , e); 
	    	}
		logger.info("clickClose End");
	}
	
	/**
	 * Method is used to click on Card back Close button.
	 * 
	 */
	public void clickCardbackClose() throws Exception {
		logger.info("clickCardbackClose Starts");
		try {
			windowHandler.switchToMainWindow();
			buttonHandler.clickButton(PropertiesRepository
					.getString("new-atitesting.cardback.close.loc"), true);
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
    	} catch (DriverException e) {
    		logger.info("Unable to clickCardbackClose" );
			log(logger, "Unable to clickCardbackClose" );
    		throw new DriverException("Unable to clickCardbackClose" , e); 
    	}
		
		logger.info("clickCardbackClose End");
	}

	/**
	 * Method used to verify whether product type is In Progress and click its
	 * product name.
	 * 
	 * @param flashCardName
	 * @return
	 * @throws Exception
	 */
	public boolean clickFlasCardCardBack(String flashCardName) throws Exception {
		logger.info("Method : clickFlasCardCardBack Start");
		boolean flag = false;
		try {
			List<WebElement> flashCardMainRow = baseHandler.findElements(".flash-cards");
			if (CollectionUtils.isNotEmpty(flashCardMainRow)) {
				for (WebElement flashCardEachRow : flashCardMainRow) {
					// Getting name of flash card from UI
					String flashCardNameInUI = flashCardEachRow.findElement(By.cssSelector("header span")).getText();
					if (StringUtils.isNotEmpty(flashCardNameInUI)) {
						WebElement beginLessonElement = flashCardEachRow.findElement(By.cssSelector(PropertiesRepository
								.getString("new-atitesting.learntab.tutorial.stt.card.front.begin.lesson.button")));
						if (beginLessonElement != null) {
							// Clicking Begin Lesson
							beginLessonElement.click();
							flag = true;
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to clickFlasCardCardBack");
			log(logger, "Unable to clickFlasCardCardBack");
			throw new DriverException("Unable to clickFlasCardCardBack", e);
		}
		logger.info("Method: clickFlasCardCardBack End flag --> " + flag);
		return flag;
	}
}


