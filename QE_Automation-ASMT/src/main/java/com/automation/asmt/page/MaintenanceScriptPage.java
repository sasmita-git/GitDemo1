package com.automation.asmt.page;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.ButtonHandler;
import com.ascendlearning.automation.ui.handlers.TextHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;
import com.ascendlearning.automation.ui.page.BasePage;
import com.automation.asmt.utils.CommonUtils;

public class MaintenanceScriptPage extends ASMTBasePage {
	private Logger logger = LogManager.getLogger(this.getClass());
	public BaseHandler baseHandler;
	private TextHandler textHandler;
	private ButtonHandler buttonHandler;
	protected WebDriverWait wait;
	private WindowHandler windowHandler;
	
	public MaintenanceScriptPage(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
		baseHandler = new BaseHandler(driver);
		textHandler = new TextHandler(driver);
		buttonHandler = new ButtonHandler(driver);
		wait = new WebDriverWait(driver, PropertiesRepository.getInt("global.driver.wait"));
		windowHandler = new WindowHandler(driver);
	}
	
	
	/*
	 * @author syed.pasha
	 */
	public void MaintanacePopUp() throws InterruptedException {
		logger.info("Method : Verifying Maintance pop-up :::: START ");
		Thread.sleep(2000);
		List<WebElement> buttonList = driver.findElements(By.cssSelector(".wm-close-button.walkme-x-button.walkme-outline-handled"));
		if (CollectionUtils.isNotEmpty(buttonList)) {
			driver.findElement(By.cssSelector(".wm-close-button.walkme-x-button.walkme-outline-handled")).click();
			Thread.sleep(1000);
		}		
		// Close Alert Box if present , close it
		if ((baseHandler.findElements("a[class='ati-modal-close']")) != null) {
			baseHandler.findElement("a[class='ati-modal-close']").click();
		}
		logger.info("Method : Verifying Maintance pop-up :::: END");
		try {
			logger.info("Method : Verifying Welcome pop-up :::: START ");
			if (verifyElement(PropertiesRepository.getString("asmt.getStartedBtnLoc"), 0)){
				logger.info("Getstarted button is displayed on Welcome ATI pop-up");
				buttonHandler.clickButton(PropertiesRepository.getString("asmt.getStartedBtnLoc"));
			}
			
		// Close Alert Box if present In Prod, close it
		Thread.sleep(2000);
		if ((baseHandler.findElements(".walkme-custom-balloon-content-wrapper")) != null) {
			clickButton(".walkme-custom-balloon-content-wrapper div", 0);
		}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info("Method : Verifying Welcome pop-up :::: END");
			e.printStackTrace();
		}
	
		}
	
	/**
	 * Method to used to login to application.
	 * 
	 * @param userName
	 * @param password
	 * @throws Exception 
	 */
	public boolean loginToApplication(String userName, String password)
			throws Exception {
		logger.info("Method : loginToApplication :::::::: START userName --> " + userName);
		logger.info("Method : loginToApplication :::::::: START password --> " + password);
		boolean flag = false;
		try {
			
			//loading the url
			driver.get(PropertiesRepository.getString("new-atitesting.project.url"));
			waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
			if(verifyElement(PropertiesRepository.getString("id.login.username.loc")) && verifyElement(PropertiesRepository.getString("id.login.password.loc"))) 
			{
			// User Name
			logger.info("entering username--> " + userName);
			textHandler.writeText(PropertiesRepository	.getString("id.login.username.loc"),userName);
			// Password
			logger.info("entering password --> " + password);
			textHandler.writeText(PropertiesRepository.getString("id.login.password.loc"),password);
			// Click Go Button
			buttonHandler.clickButton(PropertiesRepository.getString("id.login.go.button"));
			flag = true;
			waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
			waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
			MaintanacePopUp();
			}
			else{
				logger.info("Unable to login To Application");
			}
			
		} catch (DriverException e) {
			logger.info("Unable to login To Application");
			log(logger, "Unable to login To Application");
			throw new DriverException("Unable to login To Application", e);
		}
		logger.info("Method : loginToApplication :::::::: End");
		return flag;
	}
	/**
	 * This method is used to wait until the buffer image is completely load.
	 * @author Sanapati.Srinu
	 * @param loc
	 * @throws DriverException
	 */
	public void waitUntillLoadingImageIsDisappeared(String loc) throws DriverException {
		logger.info("Method: waitUntillLoadingImageIsDisappeared Starts");
		long startTime = System.currentTimeMillis();
    	try {
			List<WebElement> buffecImage = baseHandler.findElements(PropertiesRepository.getString(loc));
			try {
				while (CollectionUtils.isNotEmpty(buffecImage) && ((System.currentTimeMillis() - startTime) < 120000)) {
					logger.info("page is still loading after click on the element");					
					logger.info("Wait Counter in Seconds >>>> " +(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - startTime)));
					buffecImage = baseHandler.findElements(PropertiesRepository.getString(loc));
				}
				if (!((System.currentTimeMillis() - startTime) < 120000)) {
					logger.info("Waited 120 seconds to load the page");
					throw new DriverException("Unable to wait Untill Loading Image Is not Disappeared");
				} else {
					logger.info("Page load complete");
				}
				//waitUntillOverlayImageIsDisappeared("new-atitesting.peasewait.bufferLoc1");
			} catch (Exception e) {
				//waitUntillOverlayImageIsDisappeared("new-atitesting.peasewait.bufferLoc1");
				if (!((System.currentTimeMillis() - startTime) < 120000)) {
					logger.info("Waited 120 seconds to load the page");
					throw new DriverException("Unable to wait Untill Loading Image Is not Disappeared", e);
				} else {
					logger.info("Page load complete in catch block");
				}
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
	 * This method is used to wait until buffer invisible
	 * 
	 * @author Saravanan Jothimani 
	 */
	public void waitUntillBufferInvisible(String loc) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(loc)));
	}
	
	/**
	 * This method is used to click on any button or link based on index.
	 * @author Sanapati.Srinu
	 * @param loc
	 * @param index
	 * @throws DriverException 
	 */
	public void clickLinkFromList(String loc, int index) throws Exception {
		
		logger.info("clickLinkFromList Start");
		try {
		List<WebElement> findElement = baseHandler.findElements(PropertiesRepository.getString(loc));
		if(CollectionUtils.isNotEmpty(findElement))
		{
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
	public void clickTestTabAssessmentButton(String assessmentType,
			String assessmentName) throws Exception {
		logger.info("Method: clickTestTabAssessmentButton Starts");
		boolean breakFlag = false;
		try {
			waitUntillElementIsVisible(PropertiesRepository
					.getString("asmt.myati.test.tab.verify.details.are.displaye.loc"));
			if (baseHandler
					.isDisplayed(PropertiesRepository
							.getString("asmt.myati.test.tab.verify.details.are.displaye.loc"))) {
				List<WebElement> pracProcCardElement = baseHandler
						.findElements(PropertiesRepository
								.getString("asmt.myati.test.tab.verify.details.are.displaye.loc"));
				if (CollectionUtils.isNotEmpty(pracProcCardElement)) {
					int size = pracProcCardElement.size();
					for (int index = 0; index < size; index++) {
						if (breakFlag) {
							break;
						}
						WebElement assessmentTypeElement = pracProcCardElement
								.get(index);
						// Validating Assessment Type
						WebElement assessmentTypeSingleElement = assessmentTypeElement
								.findElement(By.cssSelector(PropertiesRepository
										.getString("asmt.myati.test.tab.assessment.type.loc")));
						if (assessmentTypeSingleElement != null) {
							String assessmentTypeValue = assessmentTypeSingleElement
									.getText().trim();
							if (StringUtils.isNotEmpty(assessmentTypeValue)
									&& assessmentTypeValue
											.equalsIgnoreCase(assessmentType)) {
								// Validating Assessment Name
								WebElement assessmentNameElement = assessmentTypeElement
										.findElement(By
												.cssSelector(PropertiesRepository
														.getString("asmt.myati.test.tab.assessment.name.loc")));
								if (assessmentNameElement != null) {
									String assessmentNameValue = assessmentNameElement
											.getText().trim().replaceAll("\\r\\n|\\r|\\n"," ");
									if (StringUtils
											.isNotEmpty(assessmentNameValue)
											&& assessmentNameValue
													.equalsIgnoreCase(assessmentName)) {
										/*if (assessmentTypeElement
												.findElement(
														By.cssSelector(PropertiesRepository
																.getString("asmt.tutorial.retakebutton.loc")))
												.isDisplayed()) {
											assessmentTypeElement
													.findElement(
															By.cssSelector(PropertiesRepository
																	.getString("asmt.tutorial.retakebutton.loc")))
													.click();
											break;
										}*/
										// Getting Button name
										List<WebElement> assessmentAllButton = assessmentTypeElement
												.findElements(By
														.cssSelector(PropertiesRepository
																.getString("asmt.myati.test.tab.assessment.button.loc")));
										if (CollectionUtils
												.isNotEmpty(assessmentAllButton)) {
											int sizeButon = assessmentAllButton
													.size();
											for (int indexButon = 0; indexButon < sizeButon; indexButon++) {
												if (breakFlag) {
													break;
												}
												WebElement singleButtonElement = assessmentAllButton
														.get(indexButon);
												String buttonNameValueWithDiv = singleButtonElement
														.getAttribute("innerHTML");
												String buttonNameValue = buttonNameValueWithDiv
														.substring(
																0,
																buttonNameValueWithDiv
																		.indexOf("<"));
												if (StringUtils
														.isNotEmpty(buttonNameValue)) {
													// It will check for style
													// attribute where it is
													// null, it click on that
													// button.
													String styleAttribute = singleButtonElement
															.getAttribute("style");
													boolean styleValue = "display: none;"
															.equalsIgnoreCase(styleAttribute);
													// Checking for
													// anyButtonName boolean
													// value

													if (!styleValue) {
														if (singleButtonElement
																.isDisplayed()) {
															singleButtonElement
																	.click();
															waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
														}
														if (verifySelectInstanceContainer(false)) {
															boolean selectInstanceFlag = verifySelectInstanceContainer(true);
															if (selectInstanceFlag) {
																// Verifying
																// Loading
																// image.
																// waitUntillLoadingImageIsDisplayed(5);
																breakFlag = true;
															}
														} else {
															breakFlag = true;
														}
													}

												} /*
												 * else { log(logger,
												 * "Button name is not matched"
												 * ); }
												 */
											}
										}
									} /*
									 * else { log(logger,
									 * "Assessment Name is not matched");
									 * breakFlag = true; }
									 */
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
			throw new DriverException(
					"Unable to click Test Tab Assessment Button", e);
		}

		logger.info("Method: clickTestTabAssessmentButton End");
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
		logger.info("Method: clickTestTabAssessmentButtonNew Starts");
		boolean breakFlag = false;
		try {
			waitUntillElementIsVisible(
					PropertiesRepository.getString("asmt.myati.test.tab.verify.details.are.displaye.loc"));
			if (baseHandler.isDisplayed(
					PropertiesRepository.getString("asmt.myati.test.tab.verify.details.are.displaye.loc"))) {
				List<WebElement> pracProcCardElement = baseHandler.findElements(
						PropertiesRepository.getString("asmt.myati.test.tab.verify.details.are.displaye.loc"));
				if (CollectionUtils.isNotEmpty(pracProcCardElement)) {
					int size = pracProcCardElement.size();
					main :for (int index = 0; index < size; index++) {
						if (breakFlag) {
							break;
						}
						WebElement assessmentTypeElement = pracProcCardElement.get(index);
						// Validating Assessment Type
						WebElement assessmentTypeSingleElement = assessmentTypeElement.findElement(By.cssSelector(
								PropertiesRepository.getString("asmt.myati.test.tab.assessment.type.loc")));
						if (assessmentTypeSingleElement != null) {
							String assessmentTypeValue = assessmentTypeSingleElement.getText().trim();
							if (StringUtils.isNotEmpty(assessmentTypeValue)
									&& assessmentTypeValue.equalsIgnoreCase(assessmentType)) {
								// Validating Assessment Name
								WebElement assessmentNameElement = assessmentTypeElement.findElement(By.cssSelector(
										PropertiesRepository.getString("asmt.myati.test.tab.assessment.name.loc")));
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
										}break main;
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
			log(logger, "Unable to click Test Tab Assessment Button" +e);
			throw new DriverException("Unable to click Test Tab Assessment Button", e);
		}

		logger.info("Method: clickTestTabAssessmentButtonNew End");
	}
	
	private boolean verifySelectInstanceContainer(boolean... click)
			throws Exception {
		logger.info("Method: verifySelectInstanceContainer Starts");
		boolean flag = false;
		try {
			List<WebElement> selectInstanceElement = baseHandler
					.findElements(PropertiesRepository
							.getString("asmt.myati.test.tab.assessment.button.multiple.assessment.loc"));
			if (CollectionUtils.isNotEmpty(selectInstanceElement)
					&& selectInstanceElement.size() > 0) {
				flag = true;
				if (flag && click[0]) {
					List<WebElement> allElements = selectInstanceElement
							.get(0)
							.findElements(
									By.cssSelector("section .duplicate-action div"));
					if (CollectionUtils.isNotEmpty(allElements)) {
						int size = allElements.size();
						for (int index = 0; index < size; index++) {
							WebElement actualButtonElement = allElements.get(
									index).findElement(By.cssSelector("a"));
							String styleAttribute = actualButtonElement
									.getAttribute("style");
							boolean styleValue = "display: none;"
									.equalsIgnoreCase(styleAttribute);
							if (!styleValue) {
								actualButtonElement.click();
								break;
							}
						}
					}

				}
			}
		} catch (Exception e) {
			logger.info("Unable to verify Select Instance Container");
			log(logger, "Unable to verify Select Instance Container");
			throw new DriverException(
					"Unable to verify Select Instance Container", e);
		}
		logger.info("Method: verifySelectInstanceContainer End flag --> "
				+ flag);
		return flag;
	}
	
	/**
	 * This method is used to wait until buffer invisible
	 * 
	 * @author Saravanan Jothimani 
	 */
	public void waitUntillElementIsVisible(String loc) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(loc)));
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

			waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
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
				handelQuestionUnansweredPopup();
				
			}else if(minCount>=(maxCount/2)){
				flag1=true;
				for (int i = 0; i <= count; i++) {
				clickButton(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"), 0);
				waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
				
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
				waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
				waitUntillIPPPageIsLoaded(".sub-header>section>img");
				waitUntillIPPPageIsLoaded(".sub-header>section>img");
				baseHandler.findElement(".close-button.focus-element-flag").click();
				waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
				log(logger, "Clicking on Test Tab");
				new HomePage(driver).clickLinkFromList("asmt.myati.sub.tabs",1);
				
				waitUntillBufferInvisible(PropertiesRepository.getString("asmt.loading.loc"));
				waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
				
				log(logger,"Verifying Test Tab Practice and Proctor is displayed or not");
				new AssessmentPage(driver).verifyTestTabDetails();
				new AssessmentPage(driver).clickTestTabAssessmentButtonNew(assessmentType,assessmentName);
			}
			windowHandler.switchToLatestWindow();
			logger.info("Method : completeContinueStateAssessment :::::::: Ends");
		}catch(DriverException e) {
			logger.info("unable to take practice assessment" + e);
			
		}
	}
	
	public void switchToAssessmentFrameHandler() throws Exception {
		logger.info("switchToAssessmentFrameHandler Start");
		try {
			windowHandler.switchToMainWindow();
			waitUntillBufferInvisible(PropertiesRepository
					.getString("asmt.pleasewait.bufferLoc"));
			windowHandler.switchToFrame("assessmentFrame");
		} catch (Exception e) {
			logger.info("Unable to switch To Assessment Frame Handler Start");
			throw new DriverException("Unable to switch To Assessment Frame Handler Start", e);
		}
		logger.info("Method: switchToAssessmentFrameHandler End ");
	}
	
	/**
	 * Method used to click on Button with index. 
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @param index
	 * @throws Exception
	 */
	public void clickButton(String locator, int index) throws DriverException {
		logger.info("Method: clickButton Starts");
    	try {
    		List<WebElement> element = baseHandler.findElements(locator);
    		if(CollectionUtils.isNotEmpty(element)) {
    			element.get(index).click();
    		}
    	} catch (Exception e) {
    		logger.info("Unable to click Button" );
			log(logger, "Unable to click Button" );
    		throw new DriverException("Unable to click Button" , e); 
    	}
    	logger.info("Method: clickButton End " );
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
							.getString("asmt.myati.assessment.question.unanswered.close.loc"),
					0);
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

			// click on flag
			clickButton(
					PropertiesRepository
							.getString("asmt.generic.tutorial.flag.value"),
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
			waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");//waitUntillBufferInvisible(PropertiesRepository.getString("asmt.pleasewait.bufferLoc"));
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
			//waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
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
						.getString("asmt.pleasewait.bufferLoc"));
				// windowHandler.switchToModalDialog();
				Thread.sleep(2000);
				buttonHandler.clickButton(PropertiesRepository
						.getString("new-atitesting.test.view.resultsLoc"));
				// click on view result button
				Thread.sleep(2000);
				waitUntillBufferInvisible(PropertiesRepository
						.getString("asmt.pleasewait.bufferLoc"));
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
	 * Method used to verify element is present or not in DOM. 
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @return
	 * @throws Exception
	 */
	public boolean verifyElement(String locator) throws Exception {
		logger.info("Method: verifyElement Starts ");		
		boolean flag = false;
    	try {
    		List<WebElement> element = baseHandler.findElements(locator);
    		if(CollectionUtils.isNotEmpty(element) && element.size() > 0) {
    			flag = true;
    		}
    	} catch (Exception e) {
    		logger.info("Unable to verifyElement");
			log(logger, "Unable to verifyElement" );
    		throw new DriverException("Unable to verifyElement" , e); 
    	}
    	logger.info("Method: verifyElement End flag --> " + flag);
    	return flag;
	}
	
	
	/**
	 * Method used to verify element is present or not in DOM. 
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @return
	 * @throws Exception
	 */
	public boolean verifyElementWithAssessmentSwitch(String locator) throws Exception {
		logger.info("Method: verifyElementWithAssessmentSwitch Starts");
		boolean flag = false;
    	try {
    		switchToAssessmentFrameHandler();
    		List<WebElement> element = baseHandler.findElements(locator);
    		if(CollectionUtils.isNotEmpty(element) && element.size() > 0) {
    			flag = true;
    		}
    		windowHandler.switchToLatestWindow();
    	} catch (Exception e) {
    		windowHandler.switchToLatestWindow();
    		logger.info("Unable to verifyElementWithAssessmentSwitch");
			log(logger, "Unable to verifyElementWithAssessmentSwitch" );
    		throw new DriverException("Unable to verifyElementWithAssessmentSwitch" , e); 
    	}
    	logger.info("Method: verifyElementWithAssessmentSwitch End flag --> " + flag);
    	return flag;
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
	public boolean verifyAssessmentHeaderWithAssessmentSwitch(int index, String headerName)
			throws Exception {
		logger.info("Method: verifyAssessmentHeaderWithAssessmentSwitch Starts ");
		boolean flag = false;
		try {
			switchToAssessmentFrameHandler();
			List<WebElement> allHeaderElement = baseHandler
					.findElements(PropertiesRepository
							.getString("asmt.myati.test.tab.assessment.page.header.loc"));
			System.out.println("The text before loop "+allHeaderElement.get(0).getText());
			if (CollectionUtils.isNotEmpty(allHeaderElement)) {
				WebElement headerElement = allHeaderElement.get(index);
				if (headerElement != null) {
					String headerValue = headerElement.getText().trim();
					System.out.println("The displayed name is " + headerValue);
					if (StringUtils.isNotEmpty(headerValue)) {
						if (headerValue.contains(headerName)) {
							flag = true;
						}
					}
				}
			}
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to verify Assessment Header verifyAssessmentHeaderWithAssessmentSwitch");
			log(logger, "Unable to verify Assessment Header verifyAssessmentHeaderWithAssessmentSwitch");
			throw new DriverException("Unable to verify Assessment Header verifyAssessmentHeaderWithAssessmentSwitch", e);
		}
		logger.info("Method: verifyAssessmentHeaderWithAssessmentSwitch End flag --> " + flag);
		return flag;
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
		logger.info("Method: verifyAssessmentHeader Starts ");
		boolean flag = false;
		
		try {
			List<WebElement> allHeaderElement = baseHandler
					.findElements(PropertiesRepository
							.getString("asmt.myati.test.tab.assessment.page.header.loc"));
			if (CollectionUtils.isNotEmpty(allHeaderElement)
					&& allHeaderElement.size() > 0) {
				WebElement headerElement = allHeaderElement.get(index);
				if (headerElement != null) {
					String headerValue = headerElement.getText().trim();
					if (StringUtils.isNotEmpty(headerValue)) {
						if (headerValue.contains(headerName)) {
							flag = true;
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
	 * Verifying Previous button;
	 * 
	 * @return
	 * @throws DriverException
	 */
	public boolean verifyPreviousButton() throws DriverException {
		logger.info("Method: verifyPreviousButton Starts");
		boolean flag = false;
    	try {
    		switchToAssessmentFrameHandler();
    		List<WebElement> element = baseHandler.findElements(PropertiesRepository
					.getString("asmt.generic.tutorial.previous.loc"));
    		if(CollectionUtils.isEmpty(element)) {
    			flag = true;
    		}
    		windowHandler.switchToLatestWindow();
    	} catch (Exception e) {
    		windowHandler.switchToLatestWindow();
    		logger.info("Unable to verifyPreviousButton");
			log(logger, "Unable to verifyPreviousButton" );
    		throw new DriverException("Unable to verifyPreviousButton" , e); 
    	}
    	logger.info("Method: verifyPreviousButton End flag --> " + flag);
    	return flag;
	}
	
	/**
	 * Verifying Continue button;
	 * 
	 * @return
	 * @throws DriverException
	 */
	public boolean verifyContinueButton() throws DriverException {
		logger.info("Method: verifyContinueButton Starts");
		boolean flag = false;
    	try {
    		switchToAssessmentFrameHandler();
    		List<WebElement> element = baseHandler.findElements(PropertiesRepository
					.getString("new-atitesting.test.assessment.continue.button.loc"));
    		if(CollectionUtils.isNotEmpty(element)) {
    			flag = true;
    		}
    		windowHandler.switchToLatestWindow();
    	} catch (Exception e) {
    		windowHandler.switchToLatestWindow();
    		logger.info("Unable to verifyContinueButton");
			log(logger, "Unable to verifyContinueButton" );
    		throw new DriverException("Unable to verifyContinueButton" , e); 
    	}
    	logger.info("Method: verifyContinueButton End flag --> " + flag);
    	return flag;
	}
	
	/**
	 * Verifying Question button;
	 * 
	 * @return
	 * @throws DriverException
	 */
	public boolean verifyQuestionValue() throws DriverException {
		logger.info("Method: verifyQuestionValue Starts");
		boolean flag = false;
    	try {
    		switchToAssessmentFrameHandler();
    		List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("asmt.question.ending.number.loc"));
    		if(CollectionUtils.isNotEmpty(element) && element.size() == 2) {
    			flag = true;
    		}
    		windowHandler.switchToLatestWindow();
    	} catch (Exception e) {
    		windowHandler.switchToLatestWindow();
    		logger.info("Unable to verifyQuestionValue");
			log(logger, "Unable to verifyQuestionValue" );
    		throw new DriverException("Unable to verifyQuestionValue" , e); 
    	}
    	logger.info("Method: verifyQuestionValue End flag --> " + flag);
    	return flag;
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
	public boolean takeTest(boolean bool, boolean breakFlag,
			boolean rationaleFlag, boolean flagquestion) throws Exception {
		
		logger.info("Method : takeTest :::::::: Starts");
		int intExhibitCount = 0;
		boolean flag = false;
		boolean exhibitFlag = false;
		boolean boolExhibitFlag = false;
		boolean boolExhibitHeader = false;
		try {

			waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
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

			for (int i = 0; i <= count; i++) {
				
				List<WebElement> checkBoxElement = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.checkbox.new.loc"));
				List<WebElement> radioElement = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.radio.button.new.loc"));
				
				if (checkBoxElement != null) {
					checkBoxElement.get(0).click();
					checkBoxElement.get(1).click();
					checkBoxElement.get(2).click();
				}

				if (checkBoxElement != null && !exhibitFlag) {
					
					/*if(intExhibitCount != 1) {
						// Verifying Exhibit Button
						boolExhibitFlag = verifyExhibitButton(true);
						if (boolExhibitFlag) {
							checkBoxElement.get(0).click();
							checkBoxElement.get(1).click();
							intExhibitCount++;
							if (intExhibitCount == 1) {
								// Verifying Exhibit Header asmt.itr.exhibit.header.loc
								boolExhibitHeader = verifyElementWithSwitchWindow(PropertiesRepository.getString("asmt.itr.exhibit.header.loc"));
								if (boolExhibitHeader) {
									clickButton(PropertiesRepository.getString("asmt.myati.assessment.exhibit.close.button.loc"),0);
									flag = true;
									exhibitFlag = true;
								}
							}
						}
					}*/
				}

				List<WebElement> imgTextElement = driver.findElements(By.cssSelector("div[class='free-form-question-container'] .answer-fill-in-the-blank.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty"));
				if(CollectionUtils.isNotEmpty(imgTextElement) && imgTextElement.get(0).isDisplayed()) {
					imgTextElement.get(0).sendKeys("10");
				}
				
				List<WebElement> textBoxElement = driver.findElements(By.cssSelector(".answer-fill-in-the-blank.numericTextEntry.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty"));
				if (CollectionUtils.isNotEmpty(textBoxElement) && textBoxElement.get(0).isDisplayed()) {
					verifyFillForm("10");
				}				
				
				List<WebElement> textBoxElement2 = driver.findElements(By.cssSelector("#fillInNumericAnswer"));
				if (CollectionUtils.isNotEmpty(textBoxElement2) && textBoxElement2.get(0).isDisplayed()) {
					verifyFillForm("10");
				}
				
				List<WebElement> textBoxElement3 = driver.findElements(By.cssSelector("#fillInAlphaAnswer"));
				if (CollectionUtils.isNotEmpty(textBoxElement3) && textBoxElement3.get(0).isDisplayed()) {
					verifyFillForm("10");
				}

				// Text Area
				List<WebElement> textAreaElement = baseHandler.findElements(PropertiesRepository.getString("asmt.maint.textarea.loc"));
				if(CollectionUtils.isNotEmpty(textAreaElement) && textAreaElement.get(0).isDisplayed()) {
					textAreaElement.get(0).sendKeys("100");
				}
				
				if (CollectionUtils.isNotEmpty(baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc")))) {
					DragAndDropAnswer(false);
				}

				if (CollectionUtils.isNotEmpty(radioElement) && radioElement.size() > 0) {
					radioElement.get(0).click();
				}

				if (CollectionUtils.isNotEmpty(baseHandler.findElements(PropertiesRepository.getString("asmt.question.img.loc")))) {
					hotSpotQuestion();
				}

				if (i == count) {
					switchToAssessmentFrameHandler();
					List<WebElement> buttonElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
					if(CollectionUtils.isNotEmpty(buttonElement)) {
						if(buttonElement.get(0).isDisplayed()) {
							WebElement continueButtonElement = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
							if(continueButtonElement != null) {
								continueButtonElement.sendKeys(Keys.ENTER);
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								/*if(!continueButtonElement.isEnabled()) {
									clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
									clickAssessmemtType();
								}*/
							}
						}
					}
					takeAssessment(rationaleFlag, flagquestion,"Finalize and View Results");
					logger.info("After answering all the questions and handling final popup");
					flag = true;
				} else {
					if (i == 0 && flagquestion) {
						switchToAssessmentFrameHandler();
						verifyFlag(true);
						logger.info("Question has been flaged");
						Thread.sleep(4000);
					} else {
						//waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						switchToAssessmentFrameHandler();
						waitUntillElementIsVisible(PropertiesRepository
								.getString("asmt.generic.tutorial.submit.new.loc"));
						List<WebElement> buttonElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
						if(CollectionUtils.isNotEmpty(buttonElement)) {
							if(buttonElement.get(0).isDisplayed()) {
								WebElement continueButtonElement = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
								if(continueButtonElement != null) {
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									/*if(!continueButtonElement.isEnabled()) {
										clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
										clickAssessmemtType();
									}*/
								}
							}
						}
					}
					if (rationaleFlag) {
						//waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
						List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
						if(CollectionUtils.isNotEmpty(rationalContinue)) {
							rationalContinue.get(0).sendKeys(Keys.ENTER);
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						}
					}

					
					if (breakFlag) {
						logger.info("After answering single questions inside breakFlag");
						flag = true;
						break;
					}
				}
			}
		} catch (DriverException e) {
			logger.info("unable to take ITR Proctor Assessment" + e);
		}
		waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		waitUntillBufferInvisible(PropertiesRepository
				.getString("asmt.pleasewait.bufferLoc"));
		logger.info("Method : takeTest :::::::: END flag --> " + flag);
		return flag;
	}	
	
	/**
	 * Method is used to complete TEAS Test
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
	public boolean takeTestTEAS(boolean bool, boolean breakFlag,
			boolean rationaleFlag, boolean flagquestion) throws Exception {
		
		logger.info("Method : takeTestTEAS :::::::: Starts");
		int intExhibitCount = 0;
		boolean flag = false;
		boolean exhibitFlag = false;
		boolean boolExhibitFlag = false;
		boolean boolExhibitHeader = false;
		try {

			waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
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

			for (int i = 0; i <= count; i++) {
				
				List<WebElement> checkBoxElement = driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.tutorial.checkbox.new.loc")));
				List<WebElement> radioElement = driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.tutorial.radio.button.new.loc")));
				
				if (CollectionUtils.isNotEmpty(checkBoxElement) && checkBoxElement.size() > 0) {
					
					checkBoxElement.get(0).click();
					/*checkBoxElement.get(1).click();
					checkBoxElement.get(2).click();*/
				}
				
				if (CollectionUtils.isNotEmpty(radioElement) && radioElement.size() > 0) {
					radioElement.get(0).click();
				}
				if (i == count) {
					switchToAssessmentFrameHandler();
					List<WebElement> buttonElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
					if(CollectionUtils.isNotEmpty(buttonElement)) {
						if(buttonElement.get(0).isDisplayed()) {
							WebElement continueButtonElement = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
							if(continueButtonElement != null) {
								continueButtonElement.sendKeys(Keys.ENTER);
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								// Used to Handle Question Unanswered Popup
								if (driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"))).size() != 0) {
									clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
									clickAssessmemtType();
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								}
							}
						}
					}
					takeAssessment(rationaleFlag, flagquestion,"Finalize and View Results");
					logger.info("After answering all the questions and handling Popup");
					flag = true;
					
				} else {
					if (i == 0 && flagquestion) {
						switchToAssessmentFrameHandler();
						verifyFlag(true);
						logger.info("Question has been flaged");
						Thread.sleep(4000);
					} else {
						//waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						//switchToAssessmentFrameHandler();
						/*waitUntillElementIsVisible(PropertiesRepository
								.getString("asmt.generic.tutorial.submit.new.loc"));*/
						List<WebElement> buttonElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
						if(CollectionUtils.isNotEmpty(buttonElement)) {
							if(buttonElement.get(0).isDisplayed()) {
								WebElement continueButtonElement = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
								if(continueButtonElement != null) {
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									// Used to Handle Question Unanswered Popup
									if (driver.findElements(By.cssSelector(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"))).size() != 0) {
										clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
										clickAssessmemtType();
										continueButtonElement.sendKeys(Keys.ENTER);
										waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									}
								}
							}
						}
					}
					if (rationaleFlag) {
						//waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
						List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
							if (CollectionUtils.isNotEmpty(rationalContinue)) {
								rationalContinue.get(0).sendKeys(Keys.ENTER);
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								
							}
						}					
					if (breakFlag) {
						logger.info("After answering single questions inside breakFlag");
						flag = true;
						break;
					}
				}
			}
		} catch (DriverException e) {
			logger.info("unable to take TEAS Proctor Assessment" + e);
		}
		logger.info("Method : takeTestTEAS :::::::: END flag --> " + flag);
		return flag;
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
	public boolean takeTestNew(boolean bool, boolean breakFlag,
			boolean rationaleFlag, boolean flagquestion) throws Exception {
		
		logger.info("Method : takeTestNew :::::::: Starts");
		int intExhibitCount = 0;
		boolean flag = false;
		boolean exhibitFlag = false;
		boolean boolExhibitFlag = false;
		boolean boolExhibitHeader = false;
		try {

			waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
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

			for (int i = 0; i <= count; i++) {
				/*List<WebElement> flagElement = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"));
				if(CollectionUtils.isNotEmpty(flagElement) && flagElement.get(0).isDisplayed()) {} else {
					takeAssessment(false, flagquestion,"Finalize and View Results");
					break;
					
					clickButton(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"), 0);
				}*/
				

				
				
				List<WebElement> checkBoxElement = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.checkbox.new.loc"));
				List<WebElement> radioElement = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.radio.button.new.loc"));
				
				if (checkBoxElement != null) {
					checkBoxElement.get(0).click();
					checkBoxElement.get(1).click();
					checkBoxElement.get(2).click();
				}

				if (checkBoxElement != null && !exhibitFlag) {
					
					if(intExhibitCount != 1) {
						// Verifying Exhibit Button
						boolExhibitFlag = verifyExhibitButton(true);
						if (boolExhibitFlag) {
							checkBoxElement.get(0).click();
							checkBoxElement.get(1).click();
							intExhibitCount++;
							if (intExhibitCount == 1) {
								// Verifying Exhibit Header asmt.itr.exhibit.header.loc
								boolExhibitHeader = verifyElementWithSwitchWindow(PropertiesRepository.getString("asmt.itr.exhibit.header.loc"));
								if (boolExhibitHeader) {
									clickButton(PropertiesRepository.getString("asmt.myati.assessment.exhibit.close.button.loc"),0);
									flag = true;
									exhibitFlag = true;
								}
							}
						}
					}
				}

				List<WebElement> imgTextElement = driver.findElements(By.cssSelector("div[class='free-form-question-container'] .answer-fill-in-the-blank.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty"));
				if(CollectionUtils.isNotEmpty(imgTextElement) && imgTextElement.get(0).isDisplayed()) {
					imgTextElement.get(0).sendKeys("10");
				}
				
				List<WebElement> textBoxElement = driver.findElements(By.cssSelector("#fillInNumericAnswer"));
				
				if (CollectionUtils.isNotEmpty(textBoxElement) && 
						textBoxElement.get(0).isDisplayed()
						) {
					textBoxElement.get(0).click();
					textBoxElement.get(0).sendKeys("111"); waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
				}

				List<WebElement> textBoxAlphaElement = driver.findElements(By.cssSelector("#fillInAlphaAnswer"));
				if (CollectionUtils.isNotEmpty(textBoxAlphaElement) && 
						textBoxAlphaElement.get(0).isDisplayed() 
						) {
					
					// Alpha Text box value
					textBoxAlphaElement.get(0).click();
					textBoxAlphaElement.get(0).sendKeys("222"); 
					waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
					//verifyFillForm("10");
				}
				
				// Text Area
				List<WebElement> textAreaElement = baseHandler.findElements(PropertiesRepository.getString("asmt.maint.textarea.loc"));
				if(CollectionUtils.isNotEmpty(textAreaElement) && textAreaElement.get(0).isDisplayed()) {
					textBoxAlphaElement.get(0).click();
					textAreaElement.get(0).sendKeys("333");
					waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
				}
				
				if (CollectionUtils.isNotEmpty(baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc")))) {
					DragAndDropAnswer(false);
				}

				if (CollectionUtils.isNotEmpty(radioElement) && radioElement.size() > 0) {
					radioElement.get(0).click();
				}

				if (CollectionUtils.isNotEmpty(baseHandler.findElements(PropertiesRepository.getString("asmt.question.img.loc")))) {
					hotSpotQuestion();
				}

				if (i == count) {
					switchToAssessmentFrameHandler();
					List<WebElement> buttonElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
					if(CollectionUtils.isNotEmpty(buttonElement)) {
						if(buttonElement.get(0).isDisplayed()) {
							WebElement continueButtonElement = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
							if(continueButtonElement != null) {
								continueButtonElement.sendKeys(Keys.ENTER);
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								if(!continueButtonElement.isEnabled()) {
									clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
									clickAssessmemtType();
								}
							}
						}
					}
					takeAssessment(rationaleFlag, flagquestion,"Finalize and View Results");
					flag = true;
				} else {
					if (i == 0 && flagquestion) {
						switchToAssessmentFrameHandler();
						verifyFlag(true);
						logger.info("Question has been flaged");
						Thread.sleep(4000);
					} else {
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						switchToAssessmentFrameHandler();
						waitUntillElementIsVisible(PropertiesRepository
								.getString("asmt.generic.tutorial.submit.new.loc"));
						List<WebElement> buttonElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
						if(CollectionUtils.isNotEmpty(buttonElement)) {
							if(buttonElement.get(0).isDisplayed()) {
								WebElement continueButtonElement = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
								if(continueButtonElement != null) {
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									if(!continueButtonElement.isEnabled()) {
										clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
										clickAssessmemtType();
									}
								}
							}
						}
					}
					if (rationaleFlag) {
						waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
						List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
						if(CollectionUtils.isNotEmpty(rationalContinue)) {
							rationalContinue.get(0).sendKeys(Keys.ENTER);
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						}
					}

					
					if (breakFlag) {
						break;
					}
				}
			
			}
		} catch (DriverException e) {
			logger.info("unable to take practice assessment" + e);
		}
		waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		waitUntillBufferInvisible(PropertiesRepository
				.getString("asmt.pleasewait.bufferLoc"));
		logger.info("Method : takeTestNew :::::::: END flag --> " + flag);
		return flag;
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
	public boolean takeTestUnFlag(boolean bool, boolean breakFlag,
			boolean rationaleFlag, boolean flagquestion) throws Exception {
		
		logger.info("Method : takeTestUnFlag :::::::: Starts");
		int intExhibitCount = 0;
		boolean flag = false;
		boolean exhibitFlag = false;
		boolean boolExhibitFlag = false;
		boolean boolExhibitHeader = false;
		try {

			waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
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

			for (int i = 0; i <= count; i++) {
				
				
				List<WebElement> flagElement = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"));
				if(CollectionUtils.isNotEmpty(flagElement) && flagElement.get(0).isDisplayed()) {
					clickButton(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"), 0);
					
					List<WebElement> checkBoxElement = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.checkbox.new.loc"));
					List<WebElement> radioElement = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.radio.button.new.loc"));
					
					if (checkBoxElement != null) {
						checkBoxElement.get(0).click();
						checkBoxElement.get(1).click();
						checkBoxElement.get(2).click();
					}

					if (checkBoxElement != null && !exhibitFlag) {
						
						if(intExhibitCount != 1) {
							// Verifying Exhibit Button
							boolExhibitFlag = verifyExhibitButton(true);
							if (boolExhibitFlag) {
								checkBoxElement.get(0).click();
								checkBoxElement.get(1).click();
								intExhibitCount++;
								if (intExhibitCount == 1) {
									// Verifying Exhibit Header asmt.itr.exhibit.header.loc
									boolExhibitHeader = verifyElementWithSwitchWindow(PropertiesRepository.getString("asmt.itr.exhibit.header.loc"));
									if (boolExhibitHeader) {
										clickButton(PropertiesRepository.getString("asmt.myati.assessment.exhibit.close.button.loc"),0);
										flag = true;
										exhibitFlag = true;
									}
								}
							}
						}
					}

					List<WebElement> imgTextElement = driver.findElements(By.cssSelector("div[class='free-form-question-container'] .answer-fill-in-the-blank.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty"));
					if(CollectionUtils.isNotEmpty(imgTextElement) && imgTextElement.get(0).isDisplayed()) {
						imgTextElement.get(0).sendKeys("10");
					}
					
					List<WebElement> textBoxElement = driver.findElements(By.cssSelector(".answer-fill-in-the-blank.numericTextEntry.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty"));
					if (CollectionUtils.isNotEmpty(textBoxElement) && textBoxElement.get(0).isDisplayed()) {
						verifyFillForm("10");
					}

					// Text Area
					List<WebElement> textAreaElement = baseHandler.findElements(PropertiesRepository.getString("asmt.maint.textarea.loc"));
					if(CollectionUtils.isNotEmpty(textAreaElement) && textAreaElement.get(0).isDisplayed()) {
						textAreaElement.get(0).sendKeys("100");
					}
					
					if (CollectionUtils.isNotEmpty(baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc")))) {
						DragAndDropAnswer(false);
					}

					if (CollectionUtils.isNotEmpty(radioElement) && radioElement.size() > 0) {
						radioElement.get(0).click();
					}

					if (CollectionUtils.isNotEmpty(baseHandler.findElements(PropertiesRepository.getString("asmt.question.img.loc")))) {
						hotSpotQuestion();
					}

					if (i == count) {
						switchToAssessmentFrameHandler();
						List<WebElement> buttonElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
						if(CollectionUtils.isNotEmpty(buttonElement)) {
							if(buttonElement.get(0).isDisplayed()) {
								WebElement continueButtonElement = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
								if(continueButtonElement != null) {
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									if(!continueButtonElement.isEnabled()) {
										clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
										clickAssessmemtType();
									}
								}
							}
						}
						takeAssessment(rationaleFlag, flagquestion,"Finalize and View Results");
					} else {
						if (i == 0 && flagquestion) {
							switchToAssessmentFrameHandler();
							verifyFlag(true);
							logger.info("Question has been flaged");
							Thread.sleep(4000);
						} else {
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
							switchToAssessmentFrameHandler();
							waitUntillElementIsVisible(PropertiesRepository
									.getString("asmt.generic.tutorial.submit.new.loc"));
							List<WebElement> buttonElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
							if(CollectionUtils.isNotEmpty(buttonElement)) {
								if(buttonElement.get(0).isDisplayed()) {
									WebElement continueButtonElement = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
									if(continueButtonElement != null) {
										continueButtonElement.sendKeys(Keys.ENTER);
										waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
										if(!continueButtonElement.isEnabled()) {
											clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
											clickAssessmemtType();
										}
									}
								}
							}
						}
						if (rationaleFlag) {
							waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
							List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
							if(CollectionUtils.isNotEmpty(rationalContinue)) {
								rationalContinue.get(0).sendKeys(Keys.ENTER);
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
							}
						}

						
						if (breakFlag) {
							break;
						}
					}
				} else {
					takeAssessment(false, flagquestion,"Finalize and View Results");
					break;
				}
				
			}
		} catch (DriverException e) {
			logger.info("unable to take practice assessment" + e);
		}
		waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		waitUntillBufferInvisible(PropertiesRepository
				.getString("asmt.pleasewait.bufferLoc"));
		logger.info("Method : takeTestUnFlag :::::::: END flag --> " + flag);
		return flag;
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
	public boolean takeTestFlag(boolean bool, boolean breakFlag,
			boolean rationaleFlag, boolean flagquestion) throws Exception {
		
		logger.info("Method : takeTestFlag :::::::: Starts ");
		int intExhibitCount = 0;
		boolean flag = false;
		boolean exhibitFlag = false;
		boolean boolExhibitFlag = false;
		boolean boolExhibitHeader = false;
		
		try {

			waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
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

			for (int i = 0; i <= count; i++) {
				boolean flagButton = false;
				/*if(i == 0 || i ==2) {
					// Clicking on Flag Button. 
					clickButton(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"), 0);
					flagButton = true;
				} else {*/
					List<WebElement> checkBoxElement = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.checkbox.new.loc"));
					List<WebElement> radioElement = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.radio.button.new.loc"));
					
					if (checkBoxElement != null) {
						checkBoxElement.get(0).click();
						checkBoxElement.get(1).click();
						checkBoxElement.get(2).click();
					}

					if (checkBoxElement != null && !exhibitFlag) {
						
						if(intExhibitCount != 1) {
							// Verifying Exhibit Button
							boolExhibitFlag = verifyExhibitButton(true);
							if (boolExhibitFlag) {
								checkBoxElement.get(0).click();
								checkBoxElement.get(1).click();
								intExhibitCount++;
								if (intExhibitCount == 1) {
									// Verifying Exhibit Header asmt.itr.exhibit.header.loc
									boolExhibitHeader = verifyElementWithSwitchWindow(PropertiesRepository.getString("asmt.itr.exhibit.header.loc"));
									if (boolExhibitHeader) {
										clickButton(PropertiesRepository.getString("asmt.myati.assessment.exhibit.close.button.loc"),0);
										flag = true;
										exhibitFlag = true;
									}
								}
							}
						}
					}

					List<WebElement> imgTextElement = driver.findElements(By.cssSelector("div[class='free-form-question-container'] .answer-fill-in-the-blank.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty"));
					if(CollectionUtils.isNotEmpty(imgTextElement) && imgTextElement.get(0).isDisplayed()) {
						imgTextElement.get(0).sendKeys("10");
					}
					
					//List<WebElement> textBoxElement = driver.findElements(By.cssSelector(".answer-fill-in-the-blank.numericTextEntry.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty"));
					List<WebElement> textBoxElement = driver.findElements(By.cssSelector("input[id^='fillIn']"));

					if (CollectionUtils.isNotEmpty(textBoxElement) && textBoxElement.get(0).isDisplayed()) {
						verifyFillForm("10");
					}

					// Text Area
					List<WebElement> textAreaElement = baseHandler.findElements(PropertiesRepository.getString("asmt.maint.textarea.loc"));
					if(CollectionUtils.isNotEmpty(textAreaElement) && textAreaElement.get(0).isDisplayed()) {
						textAreaElement.get(0).sendKeys("100");
					}
					
					if (CollectionUtils.isNotEmpty(baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc")))) {
						//DragAndDropAnswer(false);
						// Clicking on Flag Button. 
						clickButton(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"), 0);
						flagButton = true;
					}

					if (CollectionUtils.isNotEmpty(radioElement) && radioElement.size() > 0) {
						radioElement.get(0).click();
					}

					if (CollectionUtils.isNotEmpty(baseHandler.findElements(PropertiesRepository.getString("asmt.question.img.loc")))) {
						hotSpotQuestion();
					}
				//}
				

				if (i == count) {
					switchToAssessmentFrameHandler();
					List<WebElement> buttonElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
					if(CollectionUtils.isNotEmpty(buttonElement)) {
						if(buttonElement.get(0).isDisplayed()) {
							WebElement continueButtonElement = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
							if(continueButtonElement != null) {
								continueButtonElement.sendKeys(Keys.ENTER);
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								if(!continueButtonElement.isEnabled()) {
									clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
									clickAssessmemtType();
								}
							}
						}
					}
					takeAssessment(rationaleFlag, flagquestion,"Review Flagged ");
				} else {
					if (i == 0 && flagquestion) {
						switchToAssessmentFrameHandler();
						verifyFlag(true);
						logger.info("Question has been flaged");
						Thread.sleep(4000);
					} else {
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						switchToAssessmentFrameHandler();
						waitUntillElementIsVisible(PropertiesRepository
								.getString("asmt.generic.tutorial.submit.new.loc"));
						List<WebElement> buttonElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
						if(CollectionUtils.isNotEmpty(buttonElement)) {
							if(buttonElement.get(0).isDisplayed()) {
								WebElement continueButtonElement = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
								if(continueButtonElement != null) {
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									/*if(!continueButtonElement.isEnabled()) {
										clickButton(PropertiesRepository.getString("asmt.myati.assessment.question.unanswered.close.loc"), 0);
										clickAssessmemtType();
									}*/
								}
							}
						}
					}
					if(!flagButton) {
						if (rationaleFlag) {
							waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
							List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
							if(CollectionUtils.isNotEmpty(rationalContinue)) {
								rationalContinue.get(0).sendKeys(Keys.ENTER);
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
							}
						}
					}
					
					if (breakFlag) {
						break;
					}
				}
			}
		} catch (DriverException e) {
			logger.info("unable to take practice assessment" + e);
		}
		waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		waitUntillBufferInvisible(PropertiesRepository
				.getString("asmt.pleasewait.bufferLoc"));
		logger.info("Method : takeTestFlag :::::::: END flag --> " + flag);
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
	public boolean verifyFillForm(String value) throws Exception {
		boolean flag = false;
		try {
			logger.info("Method : verifyFillForm :::::::: start ");
			
			waitUntillBufferInvisible(PropertiesRepository
					.getString("asmt.pleasewait.bufferLoc"));
			switchToAssessmentFrameHandler();

			//List<WebElement> element = baseHandler.findElements("div[class='free-form-question-container'] .answer-fill-in-the-blank.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty");
			List<WebElement> element = baseHandler.findElements("input[id^='fillIn']");

			if (CollectionUtils.isNotEmpty(element)) {
				element.get(0).sendKeys(value);
				flag = true;
			}
		} catch (Exception e) {
			throw new DriverException("Unable to fill the text entry question",
					e);
		}
		windowHandler.switchToLatestWindow();
		logger.info("Method:  verifyFillForm End --> " + flag);
		return flag;
	}
	

	/**
	 * This method is used to answer drag and drop question
	 * 
	 * @author siddharth roy
	 * @return boolean
	 * @throws DriverException
	 */
	public void DragAndDropAnswer(boolean stop) throws Exception {
		logger.info("DragAndDropAnswer Start");
		try {
			waitUntillBufferInvisible(PropertiesRepository
					.getString("asmt.pleasewait.bufferLoc"));
			logger.info("Method : DragAndDropAnswer :::::::: start");
			Actions act = new Actions(driver);
			boolean breakflag = false;

			
			switchToAssessmentFrameHandler();
			int tot = baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc")).findElements(By.cssSelector("li")).size();
			if (baseHandler.isDisplayed(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc"))) {
				System.out.println(baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox2.loc")).findElements(By.cssSelector("li")).size());
				while (baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox2.loc")).findElements(By.cssSelector("li")).size() != tot) {
					if (breakflag) {
						break;
					}
					List<WebElement> btn = baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc")).findElements(By.cssSelector("li"));
					for (int i = 0; i < btn.size(); i++) {
						try {
							wait.until(ExpectedConditions
									.elementToBeClickable(btn.get(i)));
							WebElement toElement = baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox2.loc"));
							if (breakflag) {
								break;
							}

							org.openqa.selenium.interactions.Action atc2 = act
									.clickAndHold(btn.get(i))
									.moveToElement(toElement)
									.release(toElement).build();
							buttonHandler
									.clickButton(PropertiesRepository
											.getString("asmt.generic.tutorial.dragbox2.loc"));
							atc2.perform();
							if (stop) {
								breakflag = true;
							}
							if(i == btn.size()-1){
								breakflag = true;
							}
							Thread.sleep(1000);
						} catch (StaleElementReferenceException e) {
							logger.info("element in stale state countiniuing");
						}
					}
				}
			}
		}

		catch (Exception e) {
			throw new DriverException("Unable to Drag And Drop Answer", e);

		}
		windowHandler.switchToLatestWindow();
		logger.info("Method:  DragAndDropAnswer End --> ");
	}
	
	/**
	 * This method is used to answer drag and drop question
	 * 
	 * @author siddharth roy
	 * @return boolean
	 * @throws DriverException
	 */
	public void DragAndDropAnswerOriginal(boolean stop) throws Exception {
		logger.info("DragAndDropAnswer Start");
		try {
			waitUntillBufferInvisible(PropertiesRepository
					.getString("asmt.pleasewait.bufferLoc"));
			logger.info("Method : DragAndDropAnswer :::::::: start");
			Actions act = new Actions(driver);
			boolean breakflag = false;

			
			switchToAssessmentFrameHandler();
			int tot = baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc")).findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.dragamddrop.loc"))).size();
			if (baseHandler.isDisplayed(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc"))) {
				System.out.println(baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox2.loc")).findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.dragamddrop.loc"))).size());
				while (baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox2.loc")).findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.dragamddrop.loc"))).size() != tot) {
					if (breakflag) {
						break;
					}
					List<WebElement> btn = baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc")).findElements(By.cssSelector(PropertiesRepository.getString("asmt.generic.dragamddrop.loc")));
					for (int i = 0; i < btn.size(); i++) {
						try {
							wait.until(ExpectedConditions
									.elementToBeClickable(btn.get(i)));
							WebElement toElement = baseHandler.findElement(PropertiesRepository.getString("asmt.generic.tutorial.dragbox2.loc"));
							if (breakflag) {
								break;
							}

							org.openqa.selenium.interactions.Action atc2 = act
									.clickAndHold(btn.get(i))
									.moveToElement(toElement)
									.release(toElement).build();
							buttonHandler
									.clickButton(PropertiesRepository
											.getString("asmt.generic.tutorial.dragbox2.loc"));
							atc2.perform();
							if (stop) {
								breakflag = true;
							}
							if(i == btn.size()-1){
								breakflag = true;
							}
							Thread.sleep(1000);
						} catch (StaleElementReferenceException e) {
							logger.info("element in stale state countiniuing");
						}
					}
				}
			}
		}

		catch (Exception e) {
			throw new DriverException("Unable to Drag And Drop Answer", e);

		}
		windowHandler.switchToLatestWindow();
		logger.info("Method:  DragAndDropAnswer End --> ");
	}
	
	
	/**
	 * This method is used to identify the hotspot question.
	 * 
	 * @author siddharth roy
	 * @return boolean
	 * @throws DriverException
	 */
	public boolean hotSpotQuestion() throws Exception {
		logger.info("Method : hotSpotQuestion :::::::: start");
		boolean flag = false;
		try {
			switchToAssessmentFrameHandler();

			if (baseHandler.isDisplayed(PropertiesRepository.getString("asmt.question.img.loc"))) {
				buttonHandler.clickButton(PropertiesRepository.getString("asmt.question.img.loc"));
			}
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			throw new DriverException("Unable to Verify Submit Disabled", e);
		}
		windowHandler.switchToLatestWindow();
		logger.info("Method:  hotSpotQuestion End --> " + flag);
		return flag;
	}
	
	public void clickAssessmemtType() throws Exception {		
		List<WebElement> checkBoxElement = baseHandler
				.findElements(PropertiesRepository.getString("asmt.generic.tutorial.checkbox.new.loc"));
		List<WebElement> radioElement = baseHandler
				.findElements(PropertiesRepository.getString("asmt.generic.tutorial.radio.button.new.loc"));
		List<WebElement> hotSpotElement = baseHandler
				.findElements(PropertiesRepository.getString("asmt.question.img.loc"));				
		List<WebElement> inputBoxOption = baseHandler.findElements("input[id^='fillIn']");
		List<WebElement> textBoxElement2 = driver.findElements(By.cssSelector("#fillInNumericAnswer"));	
		List<WebElement> dragNDrop = baseHandler.findElements(PropertiesRepository.getString("asmt.generic.tutorial.dragbox1.loc"));
		
		if (CollectionUtils.isNotEmpty(checkBoxElement)
				&& checkBoxElement.size() > 0) {
			checkBoxElement.get(0).click();
		} else 	if(CollectionUtils.isNotEmpty(hotSpotElement) && hotSpotElement.size() > 0) { // Clicking Flag if it has Hot Spot Image
			hotSpotQuestion();
		} else if (CollectionUtils.isNotEmpty(radioElement)
				&& radioElement.size() > 0) {
			radioElement.get(0).click();
		} else if(CollectionUtils.isNotEmpty(inputBoxOption)) {
			verifyFillForm("10");
		} else if(CollectionUtils.isNotEmpty(textBoxElement2)) {
			verifyFillForm("10");
		} else if(CollectionUtils.isNotEmpty(dragNDrop)) {
			DragAndDropAnswer(false);
		} else {
			buttonHandler.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.flag.button"));
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
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
	public void takeAssessment(boolean bool, boolean flagquestion)
			throws InterruptedException, DriverException {
		logger.info("takeAssessment starts");
		try {
			waitUntillBufferInvisible(PropertiesRepository
					.getString("asmt.pleasewait.bufferLoc"));
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
			List<WebElement> btn = baseHandler
					.findElements(" .button.primary-button.focus-element-flag");
			for (WebElement ele : btn) {
				if (ele.isDisplayed()) {
					ele.click();
					waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
					break;
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
	
	
	/**
	 * This method is used to verify the flag button in the assessment page. and
	 * click if click==true author siddharth.roy
	 * 
	 * @throws Exception
	 * @return boolean
	 */
	public boolean verifyFlag(boolean click) throws Exception {

		logger.info("Method:  verifyFlag Starts");
		boolean flag = false;
		try {
			waitUntillBufferInvisible(PropertiesRepository
					.getString("asmt.pleasewait.bufferLoc"));

			
			switchToAssessmentFrameHandler();
			waitUntillElementIsVisible(PropertiesRepository
					.getString("asmt.generic.tutorial.flag.value"));

			if (baseHandler.isDisplayed(PropertiesRepository
					.getString("asmt.generic.tutorial.flag.value"))) {
				if (click) {
					waitUntillElementIsVisible(PropertiesRepository
							.getString("asmt.generic.tutorial.flag.value"));
					baseHandler
							.findElement(
									PropertiesRepository
											.getString("asmt.generic.tutorial.flag.value"))
							.click();
				}
				flag = true;
			}
			switchToAssessmentFrameHandler();
		} catch (Exception e) {
			logger.info("Unable to  verify Flag");
			throw new DriverException("Unable to verify Flag", e);
		}
		logger.info("Method:  verifyFlag End flag --> " + flag);
		windowHandler.switchToLatestWindow();
		return flag;
	}
	
	public boolean verifyExhibitButton(boolean boolClick) throws Exception {
		logger.info("Method: verifyExhibitButton Starts");
		boolean flag = false;
    	try {
    		List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("asmt.myati.assessment.exhibit.loc"));
    		if(CollectionUtils.isNotEmpty(element)) {
    			flag = true;
    			if(boolClick) {
    				element.get(0).click();
    			}
    		}
    	} catch (Exception e) {
    		logger.info("Unable to ");
			log(logger, "Unable to " );
    		throw new DriverException("Unable to " , e); 
    	}
    	logger.info("Method: verifyExhibitButton End flag --> " + flag);
    	return flag;
	}
	
	/**
	 * Method used to verify element is present or not in DOM. 
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @return
	 * @throws Exception
	 */
	public boolean verifyElementWithSwitchWindow(String locator) throws Exception {
		logger.info("Method: verifyElementWithSwitchWindow Starts");
		boolean flag = false;
    	try {
    		List<WebElement> element = baseHandler.findElements(locator);
    		if(CollectionUtils.isNotEmpty(element) && element.size() > 0) {
    			flag = true;
    		}
    	} catch (Exception e) {
    		logger.info("Unable to verifyElementWithSwitchWindow");
			log(logger, "Unable to verifyElementWithSwitchWindow" );
    		throw new DriverException("Unable to verifyElementWithSwitchWindow" , e); 
    	}
    	logger.info("Method: verifyElementWithSwitchWindow End flag --> " + flag);
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
								PropertiesRepository.getString("asmt.report.header.value"))) {
					flag = true;
				}
			}
		} catch (Exception e) {
			driver.navigate().refresh();
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
								PropertiesRepository.getString("asmt.report.header.value"))) {
					flag = true;
				}
			}
//			logger.info("Unable to verify IPP Page Header");
//			log(logger, "Unable to verify IPP Page Header");
//			throw new DriverException("Unable to verify IPP Page Header", e);
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
	 * Method is used to verify the pause button is displayed and clicks on the
	 * Pause button if the click is true
	 * 
	 * @author siddharth.roy
	 * @return boolean
	 * @throws Exception
	 */
	public boolean verifyAssessmentPauseButton(boolean click) throws Exception {
		logger.info("Method: verifyAssessmentPauseButton Starts");
		boolean flag = false;
		try {
			waitUntillBufferInvisible(PropertiesRepository
					.getString("asmt.pleasewait.bufferLoc"));
			switchToAssessmentFrameHandler();
			if (baseHandler
					.isDisplayed(baseHandler.findElement(PropertiesRepository
							.getString("asmt.myati.test.tab.assessment.pause.button.loc")))) {
				if (click) {
					baseHandler
							.findElement(
									PropertiesRepository
											.getString("asmt.myati.test.tab.assessment.pause.button.loc"))
							.click();
				}
				flag = true;
			}
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to verify Assessment Pause Button");
			throw new DriverException(
					"Unable to verify Assessment Pause Button", e);
		}
		logger.info("Method: verifyAssessmentPauseButton End flag --> " + flag);
		return flag;
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
		boolean flag = false;
		try {
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
	 * Method used to verify Pause Button Header Message.
	 * 
	 * @author saravanan.jothimani
	 * @return boolean
	 * @throws Exception
	 */
	public boolean verifyPauseButtonResumeAssessmentButton(boolean click)
			throws Exception {
		logger.info("Method: verifyPauseButtonResumeAssessmentButton Starts");
		boolean flag = false;
		try {
			switchToAssessmentFrameHandler();
			if (baseHandler
					.isDisplayed(PropertiesRepository
							.getString("asmt.myati.test.tab.assessment.resume.assessment.button.loc"))) {
				List<WebElement> pauseMessage = baseHandler
						.findElements(PropertiesRepository
								.getString("asmt.myati.test.tab.assessment.resume.assessment.button.loc"));
				if (CollectionUtils.isNotEmpty(pauseMessage)) {
					if (click) {
						baseHandler
								.findElement(
										PropertiesRepository
												.getString("asmt.myati.test.tab.assessment.resume.assessment.button.loc"))
								.click();
					}
					flag = true;
				}
			}
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to verify Pause Button Resume Assessment Button");
			throw new DriverException(
					"Unable to verify Pause Button Resume Assessment Button", e);
		}
		logger.info("Method: verifyPauseButtonResumeAssessmentButton End flag --> "
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
				WebElement pauseTimeElement = pauseElement.get(0);
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
	
	/**
	 * Method used to verify Calculator Functionality. 
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws DrvierException
	 */
	public boolean verifyCalculatorFuncationality() throws DriverException {
		logger.info("Method: verifyCalculatorFuncationality Starts ");
		boolean flag = false;
    	try {
    		waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
    		switchToAssessmentFrameHandler();
    		waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
    		List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("asmt.maint.calculator.loc"));
    		if(CollectionUtils.isNotEmpty(element)) {
    			// Clicking on Calculator Button
    			element.get(0).click();
    			waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
    			// Getting numbers - Calculation
    			//windowHandler.switchToLatestWindow();
    			waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
    			List<WebElement> sectionElement = baseHandler.findElements(/*PropertiesRepository.getString("asmt.maint.calculator.no.loc")*/".calculator-container section");
    			if(CollectionUtils.isNotEmpty(sectionElement) && sectionElement.size() > 0) {
    				// Entering Value
    				WebElement sectionRowElement = sectionElement.get(3);
    				WebElement sectionEqualElement = sectionElement.get(7);
    				if(sectionRowElement != null && sectionEqualElement !=null ) {
    					List<WebElement> noElement = sectionRowElement.findElements(By.cssSelector("a"));
    					List<WebElement> equalElement = sectionEqualElement.findElements(By.cssSelector("a"));
    					
    					
    					if(CollectionUtils.isNotEmpty(noElement)) {
    						WebElement sevenElement = noElement.get(0);
    						WebElement slashElement = noElement.get(3);
    								
    						// Actual Calculation
    						sevenElement.click();
    						slashElement.click();
    						sevenElement.click();
    						equalElement.get(0).click();
    					}
    				}
    				
    				// Verifying Answer
    				WebElement sectionResultElement = sectionElement.get(0);
    				//List<WebElement> resultElement = sectionResultElement.findElements(By.cssSelector("input"));
    				if(sectionResultElement != null) {
    						flag = true;
    				}
    			}
    		}
    		// Clicking on Calculator close button. 
    		List<WebElement> closeButton = baseHandler.findElements("#viewCalculator .mat-button");
    		if(CollectionUtils.isNotEmpty(closeButton)) {
    			closeButton.get(0).click();
    		}
    		windowHandler.switchToLatestWindow();
    	} catch (Exception e) {
    		windowHandler.switchToLatestWindow();
    		logger.info("Unable to ");
			log(logger, "Unable to " );
    		throw new DriverException("Unable to " , e); 
    	}
    	logger.info("Method: verifyCalculatorFuncationality End flag --> " + flag);
    	return flag;
	}
	
	/**
	 * Method used to click Esc.
	 * 
	 * @throws DriverException
	 */
	public void clickEscAction() throws DriverException {
		logger.info("Method: clickEscAction Starts");
    	try {
    		Actions action = new Actions(driver);
    		action.sendKeys(Keys.ESCAPE);
    	} catch (Exception e) {
    		logger.info("Unable to clickEscAction" );
			log(logger, "Unable to clickEscAction" );
    		throw new DriverException("Unable to clickEscAction" , e); 
    	}
    	logger.info("Method: clickEscAction End " );
	}
	
	/**
	 * Method used to enter Proctor Id and Pwd.
	 * 
	 * @author saravanan.jothimani
	 * ".focus-element-flag.focus-on"
	 */
	public void enterValue(String selector, String text)
			throws DriverException {
		logger.info("Method: enterValue Starts");
		try {
			windowHandler.switchToLatestWindow();
			List<WebElement> element = baseHandler.findElements(selector);
			if(CollectionUtils.isNotEmpty(element)) {
				textHandler.writeText(element.get(0), text.trim());
			}
			windowHandler.switchToLatestWindow();
		} catch (DriverException e) {
			logger.info("Unable to enterValue");
			log(logger, "Unable to enterValue");
			throw new DriverException("Unable to enterValue", e);
		}
		logger.info("Method: enterValue End ");
	}
	
	
	/**
	 * Method used to verify question no in assessment. 
	 * 
	 * @return
	 * @throws DriverException
	 */
	public boolean verifyQuestionNos() throws DriverException {
		logger.info("Method: verifyQuestionNos Starts");
		boolean flag = false;
    	try {
    		//Thread.sleep(30000);
    		windowHandler.switchToMainWindow();
    		waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
			windowHandler.switchToFrame("assessmentFrame");
			waitUntillElementIsVisible(PropertiesRepository.getString("asmt.question.no.loc1.new"));
    		List<WebElement> maxQuestElement = baseHandler.findElements(PropertiesRepository.getString("asmt.question.no.loc1.new"));
    		if(CollectionUtils.isNotEmpty(maxQuestElement) && maxQuestElement.get(0).isDisplayed()) {
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
					/*List<WebElement> okButton = baseHandler.findElements("#btnOk");
					if(CollectionUtils.isNotEmpty(okButton)) {
						okButton.get(0).click();
					}*/
					Thread.sleep(5000);
					// Finish Button. #btnFinishUI 
					List<WebElement> finishButton = baseHandler.findElements("#btnFinishUI");
					if(CollectionUtils.isNotEmpty(finishButton)) {
						finishButton.get(0).click();
						waitUntillLoadingImageIsDisappearedForProctor("#spnMsgBox");
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
	 * After clicking on Approve button, the application itself will wait for 30 sec. 
	 * so, this method will wait for 30 sec and click on refresh button. 
	 * 
	 * @param loc
	 * @throws NullPointerException
	 * @throws DriverException
	 */
	public boolean scrollToElement(WebDriver chromeDriver, String loc) throws NullPointerException, DriverException {
		logger.info("Method: scrollToElement Starts --> " + loc);
		boolean flag = false;
		try {
			swithToProctorFrame(chromeDriver);
			List<WebElement> element = chromeDriver
					.findElements(By.cssSelector(loc));
			logger.info( "scrollToElement element size --> " + element.size());
			if (CollectionUtils.isNotEmpty(element)) {
				((JavascriptExecutor) chromeDriver).executeScript("arguments[0].scrollIntoView(true);", element.get(0));
				flag = true;
			}
			windowHandler.switchToLatestWindow();
			//waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to scrollToElement");
			log(logger, "Unable to scrollToElement");
			throw new DriverException("Unable to scrollToElement", e);
		}
		logger.info("Method: scrollToElement Ends flag--> " + flag);
		return flag;
	}
	
	/**
	 * Method used to switch to PDF Frame.
	 * 
	 * @author saravanan.jothimani
	 * @throws DriverException
	 */
	public void swithToProctorFrame(WebDriver chromeDriver) throws DriverException {
		logger.info("Method: swithToProctorFrame Starts");
    	try {
    		windowHandler.switchToLatestWindow();
    		List<WebElement> iframe = chromeDriver.findElements(By.cssSelector(".card-shadow"));
    		if(CollectionUtils.isNotEmpty(iframe)) {
    			chromeDriver.switchTo().frame(iframe.get(0));
    		}
    	} catch (Exception e) {
    		logger.info("Unable to swithToProctorFrame" );
			log(logger, "Unable to swithToProctorFrame" );
    		throw new DriverException("Unable to swithToProctorFrame" , e); 
    	}
    	logger.info("Method: swithToProctorFrame End " );
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
			
			//locator = "button[aria-labelledby='startTestLabel']";
			waitUntillElementIsVisible(locator);
    		List<WebElement> element = baseHandler.findElements(locator);
    		if(CollectionUtils.isNotEmpty(element)) {
    			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element.get(index));
    			element.get(index).click();
    			logger.info("Start/ Resume Button clicked");
    		}
    	} catch (Exception e) {
    		logger.info("Unable to click Button" );
			log(logger, "Unable to click Button" );
    		throw new DriverException("Unable to click Button" , e); 
    	}
    	logger.info("Method: clickButton End " );
	}
	
	/**
	 * This method is used to check element is displayed or not
	 * 
	 * @param loc
	 * @param size
	 * @return
	 * @throws DriverException
	 */
	public boolean isElementDisplayed(WebDriver proctorDriver , String loc, int size) throws DriverException {
		logger.info("Method: isElementDisplayed Start" );
		try {
			//waitUntillElementIsVisible(PropertiesRepository.getString(loc));
			List<WebElement> element = proctorDriver.findElements(By.cssSelector((PropertiesRepository.getString(loc))));
			if (CollectionUtils.isNotEmpty(element)) {
				return element.get(size).isDisplayed();
			}
		} catch (Exception e) {
			throw new DriverException("error in verifying element" + e);
		}
		logger.info("Method: isElementDisplayed End");
		return false;
	}
	
}


