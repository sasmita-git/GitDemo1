package com.automation.newati.pages;

import java.util.Calendar;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.ButtonHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;

public class TutorialPage3 extends TutorialPage4 {

	private Logger logger = LogManager.getLogger(this.getClass());
	public String actualText = "";
	public BaseHandler baseHandler;
	private ButtonHandler buttonHandler;
	private WindowHandler windowHandler;
	
	public TutorialPage3(WebDriver webDriver) {
		super(webDriver);
		baseHandler = new BaseHandler(driver);
		buttonHandler = new ButtonHandler(driver);
		windowHandler = new WindowHandler(driver);
	}

	/**
	 * Method is used to verify Table of Content and Expand All 
	 * in Nurse Logic. 
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean verifyTableOfContents() throws Exception {
		logger.info("Method: verifyTableOfContents Starts");
		boolean flag = false;
    	try {
    		if(checkContinueWhereYouLeftOffWindows()) {
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			}
    		switchToNurseLogicFrame();
    		if(baseHandler.isDisplayed(baseHandler.findElement(PropertiesRepository.getString("new-atitesting.learntab.tutorial.nurse.logic.table.of.contents.loc")))) {
    			if(baseHandler.isDisplayed(baseHandler.findElement(PropertiesRepository.getString("new-atitesting.learntab.tutorial.nurse.logic.expand.all.loc")))) {
        			flag = true;
        		}
    		}
    		windowHandler.switchToLatestWindow();
    	} catch (Exception e) {
    		windowHandler.switchToLatestWindow();
    		logger.info("Unable to verify Table Of Contents");
    		throw new DriverException("Unable to verify Table Of Contents" , e); 
    	}
    	logger.info("Method: verifyTableOfContents End flag --> " + flag);
    	return flag;
	}
	
	/**
	 * Method is used to verify Table of Content and Expand All 
	 * in Nurse Logic. 
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean verifyTableOfContents1() throws Exception {
		logger.info("Method: verifyTableOfContents Starts");
		boolean flag = false;
    	try {
    		if(checkContinueWhereYouLeftOffWindows()) {
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			}
    		switchToNurseLogicFrame();
    		if(baseHandler.isDisplayed(baseHandler.findElement(".lesson-menu aside h2"))) {
    			flag=true;
    		}
    		windowHandler.switchToLatestWindow();
    	} catch (Exception e) {
    		windowHandler.switchToLatestWindow();
    		logger.info("Unable to verify Table Of Contents");
    		throw new DriverException("Unable to verify Table Of Contents" , e); 
    	}
    	logger.info("Method: verifyTableOfContents End flag --> " + flag);
    	return flag;
	}
	
	/**
	 * Method is used to switch to STT Frame.
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	private void switchToNurseLogicFrame() throws Exception {
		logger.info("switchToNurseLogicFrame Start");
		try {
			windowHandler.switchToFrame("tutorialFrame");
		} catch (Exception e) {
			logger.info("Unable to switch To STT Frame");
			throw new DriverException("Unable to switch To STT Frame", e);
		}
		logger.info("Method: switchToNurseLogicFrame End ");
	}
	
	/**
	 * Method is used to verify ExpandAll and CollapseAll Functionality. 
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean verifyExpandAllFunctionality() throws Exception {
		logger.info("Method: verifyExpandAllFunctionality Starts");
		boolean flag = false;
    	try {
    		switchToNurseLogicFrame();
    		List<WebElement> moreElements = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.learntab.tutorial.nurse.logic.expand.all.more.loc"));
    		if(CollectionUtils.isNotEmpty(moreElements)) {
    			buttonHandler.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.nurse.logic.expand.all.loc"));
    			List<WebElement> lessElements = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.learntab.tutorial.nurse.logic.expand.all.less.loc"));
    			if(CollectionUtils.isNotEmpty(lessElements)) {
    				flag = true;
    			}
    		}
    		windowHandler.switchToLatestWindow();
    	} catch (Exception e) {
    		windowHandler.switchToLatestWindow();
    		logger.info("Unable to verify Expand All Functionality");
    		throw new DriverException("Unable to verify Expand All Functionality" , e); 
    	}
    	logger.info("Method: verifyExpandAllFunctionality End flag --> " + flag);
    	return flag;
	}
	
	/**
	 * Method is used to verify ExpandAll and CollapseAll Functionality. 
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean verifyExpandAllFunctionality1() throws Exception {
		logger.info("Method: verifyExpandAllFunctionality Starts");
		boolean flag = false;
    	try {
    		switchToNurseLogicFrame();
    		List<WebElement> moreElements = baseHandler.findElements(".lesson-menu aside #lessonHeader>a");
    		if(CollectionUtils.isNotEmpty(moreElements)) {
    			moreElements.get(0).click();
    			flag=true;
    		}
    		windowHandler.switchToLatestWindow();
    	} catch (Exception e) {
    		windowHandler.switchToLatestWindow();
    		logger.info("Unable to verify Expand All Functionality");
    		throw new DriverException("Unable to verify Expand All Functionality" , e); 
    	}
    	logger.info("Method: verifyExpandAllFunctionality End flag --> " + flag);
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
	public boolean clickNurseLogicToolsButton() throws Exception {
		logger.info("Method: clickAssessmentToolsButton Starts");
		boolean flag = false;
		try {
			windowHandler.switchToLatestWindow();
			baseHandler
					.waitToBeDisplayed(PropertiesRepository
							.getString("new-atitesting.learntab.tutorial.name.value"));
			switchToNurseLogicFrame();
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
	public boolean clickNurseLogicToolsButton1() throws Exception {
	//	logger.info("Method: clickAssessmentToolsButton Starts");
		boolean flag = false;
		try {
			windowHandler.switchToMainWindow();
			windowHandler.switchToLatestWindow();
			baseHandler
					.waitToBeDisplayed(PropertiesRepository
							.getString("new-atitesting.learntab.tutorial.name.value"));
			switchToNurseLogicFrame();
			buttonHandler.clickButton(PropertiesRepository.getString("new-atitesting.learntab.quiz.bank.tools.button.loc"));
			if(baseHandler.isDisplayed(baseHandler.findElement(PropertiesRepository.getString("new-atitesting.learntab.quiz.bank.tools.glossary.button.loc")))) {
				if(baseHandler.isDisplayed(baseHandler.findElement(PropertiesRepository.getString("new-atitesting.learntab.quiz.bank.tools.calculator.button.loc")))) {
					if(baseHandler.isDisplayed(baseHandler.findElement(".button.default-button.tool-dropdown.focus-element-flag"))) {
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
	 * Method is used to verify Continue and Previous functionality. 
	 * 
	 * Get timing.
	 * Click on Continue Button. 
	 * Get Timing and compare
	 * Click on Previous Button.
	 * 
	 * @author saravanan.jothimani
	 * @return boolean
	 * @throws Exception
	 */
	public boolean verifyContinueButtonFunctionality() throws Exception {
		logger.info("Method: verifyContinueButtonFunctionality Starts");
		boolean flag = false;
    	try {
    		waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
    		switchToNurseLogicFrame();
    		Calendar beforeCalTime = Calendar.getInstance();
    		String beforeTime = baseHandler.findElement(PropertiesRepository.getString("new-atitesting.learntab.tutorial.nurse.logic.maximum.time.button.loc")).getText();
    		if(StringUtils.isNotBlank(beforeTime)) {
    			String[] maxTime = beforeTime.split(":");
    			if(maxTime.length > 0) {
    				beforeCalTime.set(Calendar.MINUTE, Integer.parseInt(maxTime[0]));
    				beforeCalTime.set(Calendar.SECOND, Integer.parseInt(maxTime[1]));
    			}
    		}
    		clickContinueButton();
    		waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
    		Calendar afterCalTime = Calendar.getInstance();
    		String afterTime = baseHandler.findElement(PropertiesRepository.getString("new-atitesting.learntab.tutorial.nurse.logic.maximum.time.button.loc")).getText();
    		if(StringUtils.isNotBlank(afterTime)) {
    			String[] maxTime = afterTime.split(":");
    			if(maxTime.length > 0) {
    				afterCalTime.set(Calendar.MINUTE, Integer.parseInt(maxTime[0]));
    				afterCalTime.set(Calendar.SECOND, Integer.parseInt(maxTime[1]));
    			}
    		}
    		if(beforeCalTime!= null && afterCalTime!=null) {
    			flag = true;
    			clickPreviousButton();
    			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
    		}
    		windowHandler.switchToLatestWindow();
    	} catch (Exception e) {
    		windowHandler.switchToLatestWindow();
    		logger.info("Unable to verify Continue Button Functionality");
    		throw new DriverException("Unable to verify Continue Button Functionality" , e); 
    	}
    	logger.info("Method: verifyContinueButtonFunctionality End flag --> " + flag);
    	return flag;
	}
	
	/**
	 * Method is used to click on Continue Button in Nurse Logic Application. 
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	private void clickContinueButton() throws Exception {
		logger.info("Method: clickContinueButton Starts");
    	try {
    		windowHandler.switchToLatestWindow();
    		switchToNurseLogicFrame();
    		List<WebElement> element = baseHandler.findElements("a[class='move-to-next-content-active focus-element-flag']");
    		if(CollectionUtils.isNotEmpty(element)) {
    			element.get(0).click();
    		}
    	} catch (Exception e) {
    		logger.info("Unable to click Continue Button " );
    		throw new DriverException("Unable to click Continue Button " , e); 
    	}
    	logger.info("Method: clickContinueButton End " );
	}
	
	/**
	 * Method is used to click on Previous Button in Nurse Logic Application. 
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	private void clickPreviousButton() throws Exception {
		logger.info("Method: clickPreviousButton Starts");
    	try {
    		List<WebElement> element = baseHandler.findElements(".move-to-prev-content-active.focus-element-flag");
    		if(CollectionUtils.isNotEmpty(element)) {
    			element.get(0).click();
    			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
    		}
    		//buttonHandler.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.nurse.logic.previous.button.loc"));
    	} catch (Exception e) {
    		logger.info("Unable to click Previous Button " );
    		throw new DriverException("Unable to click Previous Button " , e); 
    	}
    	logger.info("Method: clickPreviousButton End " );
	}
	
	/**
	 * Method is used to click on Close Button in Tutorial. 
	 * .close-button.focus-element-flag
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	public void clickTutorialCloseButton() throws Exception {
		logger.info("Method: clickTutorialCloseButton Starts");
		try {
//			driver.switchTo().frame("assessmentFrame");
//			List<WebElement> element = baseHandler.findElements("button[class='mat-button'] span span");
			waitUntillElementIsVisible(".close-button.focus-element-flag");
			List<WebElement> element = baseHandler.findElements(".close-button.focus-element-flag");
			if(CollectionUtils.isNotEmpty(element)) {
				element.get(0).click();
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			}
			/*buttonHandler
					.clickButton(
							PropertiesRepository
									.getString("new-atitesting.learntab.tutorial.nurse.logic.tutorial.close.button.loc"));
			waitUntillBufferInvisible(PropertiesRepository
					.getString("new-atitesting.peasewait.bufferLoc"));*/
		} catch (Exception e) {
			logger.info("Unable to click Tutorial Close Button");
			throw new DriverException("Unable to click Tutorial Close Button",
					e);
		}
		logger.info("Method: clickTutorialCloseButton End ");
	}
	public void clickTutorialTestCloseButton() throws Exception {
		logger.info("Method: clickTutorialCloseButton Starts");
		try {
			driver.switchTo().frame("assessmentFrame");
			List<WebElement> element = baseHandler.findElements("button[class='mat-button'] span span");
//			List<WebElement> element = baseHandler.findElements(".close-button.focus-element-flag");
			if(CollectionUtils.isNotEmpty(element)) {
				element.get(0).click();
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			}
			/*buttonHandler
					.clickButton(
							PropertiesRepository
									.getString("new-atitesting.learntab.tutorial.nurse.logic.tutorial.close.button.loc"));
			waitUntillBufferInvisible(PropertiesRepository
					.getString("new-atitesting.peasewait.bufferLoc"));*/
		} catch (Exception e) {
			logger.info("Unable to click Tutorial Close Button");
			throw new DriverException("Unable to click Tutorial Close Button",
					e);
		}
		logger.info("Method: clickTutorialCloseButton End ");
	}
	
	/**
	 * Method is used to verify the time spent in Nurse Logic Lesson.
	 * 
	 * Begin Test
	 * 
	 * @return
	 * @throws Exception
	 */
	
	public boolean verifyDosageCalTimeSpentInCardBackForLesson(String moduleName)
			throws Exception {
		logger.info("Method : verifyDosageCalTimeSpentInCardBackForLesson Start");
		Calendar cal = null;
		boolean flag = false;
		Calendar timeSpentCal = null;
		try {
			windowHandler.switchToLatestWindow();
			Thread.sleep(10000);
			cal = Calendar.getInstance();
			cal.set(Calendar.MINUTE, 00);
			cal.set(Calendar.SECOND, 00);

			baseHandler.waitForPageToLoad(PropertiesRepository
					.getString("new-atitesting.learntab.tutorial.stt.all.card.front.button"));
	List<WebElement> allBeginButtonLiElement = baseHandler
			.findElements(PropertiesRepository
					.getString("new-atitesting.learntab.tutorial.stt.all.card.front.button"));
	if (CollectionUtils.isNotEmpty(allBeginButtonLiElement)) {
		int size = allBeginButtonLiElement.size();
		for (int index = 0; index < size; index++) {
			List<WebElement> moduleNameDS = allBeginButtonLiElement
					.get(index)
					.findElements(
							By.cssSelector(PropertiesRepository
									.getString("new-atitesting.learntab.tutorial.skills.module2.card.front.module.name.loc")));
			if(CollectionUtils.isNotEmpty(moduleNameDS)) {
				String moduleNameFromUI = moduleNameDS.get(0)
						.getText();
				// Matching Module Name 
				if (StringUtils.isNotEmpty(moduleNameFromUI)) { 
					if (moduleName.equalsIgnoreCase(moduleNameFromUI)) {
					
					List<WebElement> singleModuleButtons = allBeginButtonLiElement
							.get(index)
							.findElements(
									By.cssSelector(PropertiesRepository
											.getString("new-atitesting.learntab.tutorial.stt.card.front.module.section1.loc")));
					if (CollectionUtils.isNotEmpty(singleModuleButtons)) {
						// Getting div[class='time-suggested-spent'] two elements are available.
						/*List<WebElement> timeSpentElement = singleModuleButtons.get(0).findElements(By.cssSelector(PropertiesRepository.getString("new-atitesting.learntab.tutorial.nurse.logic.tutorial.card.back.time.spent.loc")));*/
						if(CollectionUtils.isNotEmpty(singleModuleButtons)) {
							int divSize = singleModuleButtons.size();
							for(int divIndex = 0; divIndex < divSize; divIndex++) {
								WebElement styleAttElement = singleModuleButtons.get(divIndex);
								String styleAtt = styleAttElement.getAttribute("style").trim();
								if(StringUtils.isEmpty(styleAtt) && !styleAtt.equalsIgnoreCase("display: none;")) {
									String timeSpent = styleAttElement.findElement(By.cssSelector("span")).getText();
									timeSpentCal = Calendar.getInstance();
						    		if(StringUtils.isNotBlank(timeSpent)) {
						    			String[] maxTime = timeSpent.split(":");
						    			if(maxTime.length > 0) {
						    				timeSpentCal.set(Calendar.MINUTE, Integer.parseInt(maxTime[0]));
						    				timeSpentCal.set(Calendar.SECOND, Integer.parseInt(maxTime[1]));
						    			}
						    		}
									if (cal.before(timeSpentCal)) {
									flag = true;
									break;
									}
								}
							}
				    		break;
						}
					}
				
					}
				}
			}
		}
	}
		} catch (Exception e) {
			logger.info("Unable to verify Time Spent In Card Back For Lesson");
			throw new DriverException(
					"Unable to verify Time Spent In Card Back For Lesson", e);
		}
		logger.info("Method : verifyDosageCalTimeSpentInCardBackForLesson End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method is used to verify the time spent in Nurse Logic Lesson.
	 * 
	 * Begin Test
	 * 
	 * @return
	 * @throws Exception
	 */
	
	public boolean verifyTimeSpentInCardBackForLesson(String moduleName)
			throws Exception {
		logger.info("Method : verifyTimeSpentInCardBackForLesson Start");
		Calendar cal = null;
		boolean flag = false;
		try {
			windowHandler.switchToLatestWindow();
			Thread.sleep(10000);
			cal = Calendar.getInstance();
			cal.set(Calendar.MINUTE, 00);
			cal.set(Calendar.SECOND, 00);

			List<WebElement> allBeginButtonLiElement = baseHandler
					.findElements(PropertiesRepository
							.getString("new-atitesting.learntab.tutorial.stt.all.card.front.button"));
			if (CollectionUtils.isNotEmpty(allBeginButtonLiElement)) {
				int size = allBeginButtonLiElement.size();
				for (int index = 0; index < size; index++) {
					String moduleNameFromUI = allBeginButtonLiElement
							.get(index)
							.findElement(
									By.cssSelector(PropertiesRepository
											.getString("new-atitesting.learntab.tutorial.skills.module2.card.front.module.name.loc")))
							.getText();
					// Matching Module Name
					if (StringUtils.isNotEmpty(moduleNameFromUI)) {
						if (moduleName.equalsIgnoreCase(moduleNameFromUI)) {
							List<WebElement> singleModuleButtons = allBeginButtonLiElement
									.get(index)
									.findElements(
											By.cssSelector(PropertiesRepository
													.getString("new-atitesting.learntab.tutorial.stt.card.front.module.section1.loc")));
							if (CollectionUtils.isNotEmpty(singleModuleButtons)) {
								// Getting div[class='time-suggested-spent'] two
								// elements are available.
								/*List<WebElement> timeSpentElement = singleModuleButtons
										.get(0)
										.findElements(
												By.cssSelector(PropertiesRepository
														.getString("new-atitesting.learntab.tutorial.nurse.logic.tutorial.card.back.time.spent.loc")));*/
								if (CollectionUtils
										.isNotEmpty(singleModuleButtons)) {
									String timeSpent = singleModuleButtons
											.get(0)
											.findElement(By.cssSelector("span"))
											.getText();
									Calendar timeSpentCal = Calendar
											.getInstance();
									if (StringUtils.isNotBlank(timeSpent)) {
										String[] maxTime = timeSpent.split(":");
										if (maxTime.length > 0) {
											timeSpentCal
													.set(Calendar.MINUTE,
															Integer.parseInt(maxTime[0]));
											timeSpentCal
													.set(Calendar.SECOND,
															Integer.parseInt(maxTime[1]));
										}
									}
									if (cal.before(timeSpentCal)) {
										flag = true;
										break;
									}
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verify Time Spent In Card Back For Lesson");
			throw new DriverException(
					"Unable to verify Time Spent In Card Back For Lesson", e);
		}
		logger.info("Method : verifyTimeSpentInCardBackForLesson End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method is used to verify the time spent in Nurse Logic Lesson.
	 * 
	 * Begin Test
	 * 
	 * @return
	 * @throws Exception
	 */
	
	public boolean verifyTimeSpentInCardBackForNurseLogicLesson(String moduleName)
			throws Exception {
		logger.info("Method : verifyTimeSpentInCardBackForNurseLogicLesson Start");
		Calendar cal = null;
		boolean flag = false;
		try {
			windowHandler.switchToLatestWindow();
			//Thread.sleep(10000);
			cal = Calendar.getInstance();
			cal.set(Calendar.MINUTE, 00);
			cal.set(Calendar.SECOND, 00);

			List<WebElement> allBeginButtonLiElement = baseHandler
					.findElements(PropertiesRepository
							.getString("new-atitesting.learntab.tutorial.stt.all.card.front.button"));
			if (CollectionUtils.isNotEmpty(allBeginButtonLiElement)) {
				int size = allBeginButtonLiElement.size();
				for (int index = 0; index < size; index++) {
					String moduleNameFromUI = allBeginButtonLiElement
							.get(index)
							.findElement(
									By.cssSelector(PropertiesRepository
											.getString("new-atitesting.learntab.tutorial.skills.module2.card.front.module.name.loc")))
							.getText();
					// Matching Module Name
					if (StringUtils.isNotEmpty(moduleNameFromUI)) {
						if (moduleName.equalsIgnoreCase(moduleNameFromUI)) {
							
							List<WebElement> singleModuleButtons = allBeginButtonLiElement
									.get(index)
									.findElements(
											By.cssSelector(".product-tutorial-list-cell .time-suggested-spent"));
							if (CollectionUtils.isNotEmpty(singleModuleButtons)) {
								int timeSize = singleModuleButtons.size();
								for(int timeIndex = 0; timeIndex < timeSize; timeIndex++) {
									WebElement testElements = singleModuleButtons.get(timeIndex);
									if(testElements != null) {
										String styleAttribute = testElements.getAttribute("style");
										if(StringUtils.isEmpty(styleAttribute) && !"display: none;".equalsIgnoreCase(styleAttribute)) {
											String timeSpent = singleModuleButtons
													.get(0)
													.findElement(By.cssSelector("span"))
													.getText();
											Calendar timeSpentCal = Calendar
													.getInstance();
											if (StringUtils.isNotBlank(timeSpent)) {
												String[] maxTime = timeSpent.split(":");
												if (maxTime.length > 0) {
													timeSpentCal
															.set(Calendar.MINUTE,
																	Integer.parseInt(maxTime[0]));
													timeSpentCal
															.set(Calendar.SECOND,
																	Integer.parseInt(maxTime[1]));
												}
											}
											if (cal.before(timeSpentCal)) {
												flag = true;
												break;
											}
										}
									}
								}
							}
						}
					}
					if(flag) {
						break;
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verifyTimeSpentInCardBackForNurseLogicLesson");
			throw new DriverException(
					"Unable to verifyTimeSpentInCardBackForNurseLogicLesson", e);
		}
		logger.info("Method : verifyTimeSpentInCardBackForNurseLogicLesson End flag --> " + flag);
		return flag;
	}

	/**
	 * Method is used to verify the time spent in Nurse Logic Lesson.
	 * 
	 * @author saravanan.jothimani
	 * @return Calendar
	 * @throws Exception
	 */
	
	public Calendar getTimeSpentInCardBack(String moduleName) throws Exception {
		logger.info("Method : getTimeSpentInCardBack Start");
		Calendar timeSpentCal = null;
		try {
			//Thread.sleep(10000);
			waitUntillBufferInvisible(PropertiesRepository
					.getString("new-atitesting.peasewait.bufferLoc"));
			List<WebElement> allBeginButtonLiElement = baseHandler
					.findElements(PropertiesRepository
							.getString("new-atitesting.learntab.tutorial.stt.all.card.front.button"));
			if (CollectionUtils.isNotEmpty(allBeginButtonLiElement)) {
				int size = allBeginButtonLiElement.size();
				for (int index = 0; index < size; index++) {
					String moduleNameFromUI = allBeginButtonLiElement
							.get(index)
							.findElement(
									By.cssSelector(PropertiesRepository
											.getString("new-atitesting.learntab.tutorial.skills.module2.card.front.module.name.loc")))
							.getText();
					// Matching Module Name
					if (StringUtils.isNotEmpty(moduleNameFromUI)) {
						if (moduleName.equalsIgnoreCase(moduleNameFromUI)) {
							List<WebElement> singleModuleButtons = allBeginButtonLiElement
									.get(index)
									.findElements(
											By.cssSelector(".time-suggested-spent"));
							if (CollectionUtils.isNotEmpty(singleModuleButtons)) {
								// Getting div[class='time-suggested-spent'] two elements are available.
								/*List<WebElement> timeSpentElement = singleModuleButtons.get(0).findElements(By.cssSelector(PropertiesRepository.getString("new-atitesting.learntab.tutorial.nurse.logic.tutorial.card.back.time.spent.loc")));*/
								if(CollectionUtils.isNotEmpty(singleModuleButtons)) {
									int styleSize = singleModuleButtons.size();
									for(int styleIndex = 0; styleIndex < styleSize; styleIndex++) {
										WebElement styleElement = singleModuleButtons.get(styleIndex);
										String styleAttElement = styleElement.getAttribute("style");
										if(StringUtils.isEmpty(styleAttElement) && !"display: none;".equalsIgnoreCase(styleAttElement)) {
											String timeSpent = styleElement.findElement(By.cssSelector("span")).getText();
											timeSpentCal = Calendar.getInstance();
								    		if(StringUtils.isNotBlank(timeSpent)) {
								    			String[] maxTime = timeSpent.split(":");
								    			if(maxTime.length > 0) {
								    				timeSpentCal.set(Calendar.MINUTE, Integer.parseInt(maxTime[0]));
								    				timeSpentCal.set(Calendar.SECOND, Integer.parseInt(maxTime[1]));
								    				break;
								    			}
								    		}
										}
										
									}
						    		break;
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
    		logger.info("Unable to get Time Spent In Card Back");
    		throw new DriverException("Unable to get Time Spent In Card Back" , e); 
    	} 
		logger.info("Method : getTimeSpentInCardBack End Calendar --> "+ timeSpentCal);
		return timeSpentCal;
	}
	
	/**
	 * Method is used to verify the time spent in Nurse Logic Lesson.
	 * 
	 * @author saravanan.jothimani
	 * @return Calendar
	 * @throws Exception
	 */
	
	public Calendar getTimeSpentInCardBackForDosageCalculation(String moduleName) throws Exception {
		logger.info("Method : getTimeSpentInCardBackForDosageCalculation Start");
		Calendar timeSpentCal = null;
		try {

			baseHandler.waitForPageToLoad(PropertiesRepository
							.getString("new-atitesting.learntab.tutorial.stt.all.card.front.button"));
			List<WebElement> allBeginButtonLiElement = baseHandler
					.findElements(PropertiesRepository
							.getString("new-atitesting.learntab.tutorial.stt.all.card.front.button"));
			if (CollectionUtils.isNotEmpty(allBeginButtonLiElement)) {
				int size = allBeginButtonLiElement.size();
				for (int index = 0; index < size; index++) {
					List<WebElement> moduleNameDS = allBeginButtonLiElement
							.get(index)
							.findElements(
									By.cssSelector(PropertiesRepository
											.getString("new-atitesting.learntab.tutorial.skills.module2.card.front.module.name.loc")));
					if(CollectionUtils.isNotEmpty(moduleNameDS)) {
						String moduleNameFromUI = moduleNameDS.get(0)
								.getText();
						// Matching Module Name 
						if (StringUtils.isNotEmpty(moduleNameFromUI)) { 
							if (moduleName.equalsIgnoreCase(moduleNameFromUI)) {
							
							List<WebElement> singleModuleButtons = allBeginButtonLiElement
									.get(index)
									.findElements(
											By.cssSelector(PropertiesRepository
													.getString("new-atitesting.learntab.tutorial.stt.card.front.module.section1.loc")));
							if (CollectionUtils.isNotEmpty(singleModuleButtons)) {
								// Getting div[class='time-suggested-spent'] two elements are available.
								/*List<WebElement> timeSpentElement = singleModuleButtons.get(0).findElements(By.cssSelector(PropertiesRepository.getString("new-atitesting.learntab.tutorial.nurse.logic.tutorial.card.back.time.spent.loc")));*/
								if(CollectionUtils.isNotEmpty(singleModuleButtons)) {
									int divSize = singleModuleButtons.size();
									for(int divIndex = 0; divIndex < divSize; divIndex++) {
										WebElement styleAttElement = singleModuleButtons.get(divIndex);
										String styleAtt = styleAttElement.getAttribute("style").trim();
										if(StringUtils.isEmpty(styleAtt) && !styleAtt.equalsIgnoreCase("display: none;")) {
											String timeSpent = styleAttElement.findElement(By.cssSelector("span")).getText();
											timeSpentCal = Calendar.getInstance();
								    		if(StringUtils.isNotBlank(timeSpent)) {
								    			String[] maxTime = timeSpent.split(":");
								    			if(maxTime.length > 0) {
								    				timeSpentCal.set(Calendar.MINUTE, Integer.parseInt(maxTime[0]));
								    				timeSpentCal.set(Calendar.SECOND, Integer.parseInt(maxTime[1]));
								    			}
								    		}
										}
									}
						    		break;
								}
							}
						
							}
						}
					}
				}
			}
		} catch (Exception e) {
    		logger.info("Unable to getTimeSpentInCardBackForDosageCalculation");
    		throw new DriverException("Unable to getTimeSpentInCardBackForDosageCalculation" , e); 
    	} 
		logger.info("Method : getTimeSpentInCardBackForDosageCalculation End Calendar --> "+ timeSpentCal);
		return timeSpentCal;
	}
	
	/**
	 * Method is used to verify the time spent in Nurse Logic Lesson.
	 * 
	 * @author saravanan.jothimani
	 * @return Calendar
	 * @throws Exception
	 */
	
	public Calendar getTimeSpentInCardBackForNurseLogic(String moduleName) throws Exception {
		logger.info("Method : getTimeSpentInCardBack Start");
		Calendar timeSpentCal = null;
		try {

			baseHandler.waitForPageToLoad(PropertiesRepository
							.getString("new-atitesting.learntab.tutorial.stt.all.card.front.button"));
			
			
			
			
			List<WebElement> allBeginButtonLiElement = baseHandler
					.findElements(PropertiesRepository
							.getString("new-atitesting.learntab.tutorial.stt.all.card.front.button"));
			if (CollectionUtils.isNotEmpty(allBeginButtonLiElement)) {
				int size = allBeginButtonLiElement.size();
				for (int index = 0; index < size; index++) {
					List<WebElement> moduleNameDS = allBeginButtonLiElement
							.get(index)
							.findElements(
									By.cssSelector(PropertiesRepository
											.getString("new-atitesting.learntab.tutorial.skills.module2.card.front.module.name.loc")));
					if(CollectionUtils.isNotEmpty(moduleNameDS)) {
						String moduleNameFromUI = moduleNameDS.get(0)
								.getText();
						// Matching Module Name 
						if (StringUtils.isNotEmpty(moduleNameFromUI)) { 
							if (moduleName.equalsIgnoreCase(moduleNameFromUI)) {
							
								List<WebElement> singleModuleButtons = allBeginButtonLiElement
										.get(index)
										.findElements(
												By.cssSelector(".product-tutorial-list-cell .time-suggested-spent"));
							if (CollectionUtils.isNotEmpty(singleModuleButtons)) {
								// Getting div[class='time-suggested-spent'] two elements are available.
								/*List<WebElement> timeSpentElement = singleModuleButtons.get(0).findElements(By.cssSelector(PropertiesRepository.getString("new-atitesting.learntab.tutorial.nurse.logic.tutorial.card.back.time.spent.loc")));*/
								if(CollectionUtils.isNotEmpty(singleModuleButtons)) {
									int divSize = singleModuleButtons.size();
									for(int divIndex = 0; divIndex < divSize; divIndex++) {
										WebElement styleAttElement = singleModuleButtons.get(divIndex);
										String styleAtt = styleAttElement.getAttribute("style").trim();
										if(StringUtils.isEmpty(styleAtt) && !styleAtt.equalsIgnoreCase("display: none;")) {
											String timeSpent = styleAttElement.findElement(By.cssSelector("span")).getText();
											timeSpentCal = Calendar.getInstance();
								    		if(StringUtils.isNotBlank(timeSpent)) {
								    			String[] maxTime = timeSpent.split(":");
								    			if(maxTime.length > 0) {
								    				timeSpentCal.set(Calendar.MINUTE, Integer.parseInt(maxTime[0]));
								    				timeSpentCal.set(Calendar.SECOND, Integer.parseInt(maxTime[1]));
								    			}
								    		}
										}
									}
						    		break;
								}
							}
						
							}
						}
					}
				}
			}
		} catch (Exception e) {
    		logger.info("Unable to get Time Spent In Card Back");
    		throw new DriverException("Unable to get Time Spent In Card Back" , e); 
    	} 
		logger.info("Method : getTimeSpentInCardBack End Calendar --> "+ timeSpentCal);
		return timeSpentCal;
	}
	
	/**
	 * Method is used to click verify continue button in first module in
	 * Nurse Logic Card Back.
	 * 
	 * 
	 * @throws Exception
	 */
	public void checkAndClickContinueLessonButtonInNurseLogicCardBack(String moduleName)
			throws Exception {
		logger.info("Method: checkAndClickContinueLessonButtonInNurseLogicCardBack Starts");
		try {
			List<WebElement> allBeginButtonLiElement = baseHandler
					.findElements(PropertiesRepository
							.getString("new-atitesting.learntab.tutorial.stt.all.card.front.button"));
			if (CollectionUtils.isNotEmpty(allBeginButtonLiElement)) {
				int size = allBeginButtonLiElement.size();
				for (int index = 0; index < size; index++) {
					String moduleNameFromUI = allBeginButtonLiElement
							.get(index)
							.findElement(
									By.cssSelector(PropertiesRepository
											.getString("new-atitesting.learntab.tutorial.skills.module2.card.front.module.name.loc")))
							.getText();
					// Matching Module Name
					if (StringUtils.isNotEmpty(moduleNameFromUI)) {
						if (moduleName.equalsIgnoreCase(moduleNameFromUI)) {
							List<WebElement> singleModuleButtons = allBeginButtonLiElement
									.get(index)
									.findElements(
											By.cssSelector("section div[class='product-tutorial-list-cell']"));
							if (CollectionUtils.isNotEmpty(singleModuleButtons)) {
								String continueText = singleModuleButtons
										.get(0).findElement(By.cssSelector("a"))
										.getText().replace("\n", "")
										.replace("\r", "");
								if("ContinueLesson".equalsIgnoreCase(continueText)) {
									singleModuleButtons
									.get(0).findElement(By.cssSelector("a")).click();
								}
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								// Verify Continue where you left off windows is displayed. 
								if(checkContinueWhereYouLeftOffWindows()) {
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								}
								break;

							}
						}
					}

				}
			}
		} catch (Exception e) {
			logger.info("Unable to Check and Click Begin Lesson Button In Nurse Logic Card Back");
			throw new DriverException(
					"Unable to Check and Click Begin Lesson Button In Nurse Logic Card Back", e);
		}
		logger.info("Method: checkAndClickContinueLessonButtonInNurseLogicCardBack End ");
	}
	
	/**
	 * Method is used to verify Continue button is displayed in Continue Where you left off Window.
	 * 
	 * @author saravanan.jothimani
	 * @return boolean
	 * @throws Exception
	 */
	public boolean checkContinueWhereYouLeftOffWindows() throws Exception {
		logger.info("Method: checkContinueWhereYouLeftOffWindows Starts");
		boolean flag = false;
    	try {
    		windowHandler.switchToLatestWindow();
    		switchToNurseLogicFrame();
    		if(baseHandler.isDisplayed(baseHandler.findElement("#TutorialContStartOverDialog section div"))) {
    			buttonHandler.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.nurse.logic.continue.where.you.left.off.window.loc"), PropertiesRepository.getString("new-atitesting.learntab.quiz.bank.tools.button.loc"));
    			flag = true;
    		}
    		windowHandler.switchToLatestWindow();
    	} catch (Exception e) {
    		windowHandler.switchToLatestWindow();
    		logger.info("Unable to check Continue Where You Left Of fWindows");
    		throw new DriverException("Unable to check Continue Where You Left Of fWindows" , e); 
    	}
    	logger.info("Method: checkContinueWhereYouLeftOffWindows End flag --> " + flag);
    	return flag;
	}
	
	/**
	 * Method is used to verify time difference between two calendar.
	 * 
	 * @author saravanan.jothimani
	 * @param currentTime
	 * @param updatedTime
	 * @return
	 * @throws Exception
	 */
	public boolean verifyTimeDifference(Calendar currentTime, Calendar updatedTime) throws Exception {
		logger.info("Method: verifyTimeDifference Starts");
		boolean flag = false;
    	try {
    		if(currentTime.equals(updatedTime) || currentTime.before(updatedTime)) {
    			flag = true;
    		}
    	} catch (Exception e) {
    		logger.info("Unable to verify Time Difference ");
    		throw new DriverException("Unable to verify Time Difference " , e); 
    	}
    	logger.info("Method: verifyTimeDifference End flag --> " + flag);
    	return flag;
	}
	
	/**
	 * Method is used to select card front based on name and click on module and
	 * verify below details.
	 * 
	 * Name Product ID Source Added
	 * 
	 * @author siddharth.roy
	 * @param assessmentName
	 * @throws DriverException
	 */
	public boolean selectCardFrontforPME3ModuleName(String assessmentName)
			throws Exception {
		logger.info("Method: selectCardFrontforPME3ModuleName Start");
		boolean flag = false;
		try {
			//assessmentName="Pharmacology Made Easy 2.0";
			List<WebElement> moduleList = baseHandler
					.findElements(".flipper section[class='card front tutorial']");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					WebElement element = moduleList.get(i).findElement(By.cssSelector("section div[class='description']"));
					WebElement elementToFind = moduleList.get(i);
					if(element != null ) {
						if (assessmentName.equalsIgnoreCase(element.getText())) {
							if(elementToFind != null) {
								((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementToFind);
								List<WebElement> moduleElement = elementToFind.findElements(By.cssSelector("nav div[data-bind*='visible']"));
								if(CollectionUtils.isNotEmpty(moduleElement)) {
									int moduleSize = moduleElement.size();
									for(int index = 0 ; index < moduleSize; index++ ) {
										WebElement moduleStyleElement = moduleElement.get(index);
										if(moduleStyleElement != null) {
											String style = moduleStyleElement.getAttribute("style");
											if(!"display: none;".equalsIgnoreCase(style)) {
												List<WebElement> clickModuleList = moduleStyleElement.findElements(By.cssSelector("a[class='button primary-button cardflip focus-element-flag']"));
												
												//WebElement clickModule = moduleStyleElement.findElement(By.cssSelector("a[class='button primary-button cardflip focus-element-flag']"));
												if(CollectionUtils.isNotEmpty(clickModuleList)) {
													clickModuleList.get(0).click();
													break;
												}
											}
										}
										
									}
								}
								/*elementToFind.findElement(By.cssSelector("nav a[class='button primary-button cardflip focus-element-flag']")).click();
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								flag=true;
								break;*/
							}
						}
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to select Card Front Based On Module Name");
			throw new Exception(
					"Unable to select Card Front Based On Module Name");
		}
		logger.info("Method: selectCardFrontBasedOnModuleName End --> " + flag);
		return flag;
	}
	/**
	 * Method is used to click on Close Button in Tutorial. 
	 * .close-button.focus-element-flag
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	public void clickQuizCloseButton() throws Exception {
		logger.info("Method: clickTutorialCloseButton Starts");
		try {
//			driver.switchTo().frame("assessmentFrame");
			List<WebElement> element = baseHandler.findElements("button[class='mat-button'] span span");
			if(CollectionUtils.isNotEmpty(element)) {
				element.get(0).click();
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			}
			/*buttonHandler
					.clickButton(
							PropertiesRepository
									.getString("new-atitesting.learntab.tutorial.nurse.logic.tutorial.close.button.loc"));
			waitUntillBufferInvisible(PropertiesRepository
					.getString("new-atitesting.peasewait.bufferLoc"));*/
		} catch (Exception e) {
			logger.info("Unable to click Tutorial Close Button");
			throw new DriverException("Unable to click Tutorial Close Button",
					e);
		}
		logger.info("Method: clickTutorialCloseButton End ");
	}
}


























