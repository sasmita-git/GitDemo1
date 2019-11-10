package com.automation.newati.pages;

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

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.ButtonHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;

public class TutorialPage2 extends TutorialPage3 {

	private Logger logger = LogManager.getLogger(this.getClass());
	public String actualText = "";
	public BaseHandler baseHandler;
	private ButtonHandler buttonHandler;
	private WindowHandler windowHandler;
	
	public TutorialPage2(WebDriver webDriver) {
		super(webDriver);
		baseHandler = new BaseHandler(driver);
		buttonHandler = new ButtonHandler(driver);
		windowHandler = new WindowHandler(driver);
	}

	/**
	 * Method is used to verify All Begin Button in STT Card Back.
	 * 
	 * Two Buttons.
	 * 
	 * Begin Lesson Begin Test
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean verifyAllBeginLessonInCardBackForNurseLogic(String assessmentName) throws Exception {
		logger.info("Method: verifyAllBeginLessonInCardBackForNurseLogic Starts");
		boolean flag = false;
		try {
			windowHandler.switchToLatestWindow();
			baseHandler
					.waitToBeDisplayed(PropertiesRepository
							.getString("new-atitesting.learntab.tutorial.stt.card.back.header.loc"));
			if (baseHandler
					.isDisplayed(baseHandler.findElement(PropertiesRepository
							.getString("new-atitesting.learntab.tutorial.stt.card.back.header.loc")))) {
				if (assessmentName
						.equalsIgnoreCase(
								baseHandler
										.findElement(
												PropertiesRepository
														.getString("new-atitesting.learntab.tutorial.stt.card.back.header.loc"))
										.getText())) {
					List<WebElement> allBeginButtonLiElement = baseHandler
							.findElements(PropertiesRepository.getString("new-atitesting.learntab.tutorial.nurse.logic.all.card.front.button"));
					if (CollectionUtils.isNotEmpty(allBeginButtonLiElement)) {
						int size = allBeginButtonLiElement.size();
						for (int index = 0; index < size; index++) {
							flag = false;
							List<WebElement> beginElement = allBeginButtonLiElement
									.get(index)
									.findElements(
											By.cssSelector(PropertiesRepository
													.getString("new-atitesting.learntab.tutorial.stt.card.front.begin.lesson.button")));
							if(CollectionUtils.isNotEmpty(beginElement)) {
							String beginLesson = beginElement
									.get(0)									
									.getText().replace("\n", "")
									.replace("\r", "");
								if ("BeginLesson".equalsIgnoreCase(beginLesson)) {
									flag = true;
									if(!flag) {
										break;
									}
								} else {
									flag = false;
									break;
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verifyAllBeginLessonInCardBackForNurseLogic");
			throw new DriverException(
					"Unable to verifyAllBeginLessonInCardBackForNurseLogic", e);
		}
		logger.info("Method: verifyAllBeginLessonInCardBackForNurseLogic End flag --> "
				+ flag);
		return flag;
	}
	
	/**
	 * Method is used to click first PreTest Button based on Module Name in
	 * Skills Module 2.0 Card Back.
	 * 
	 * Begin Test
	 * 
	 * @return
	 * @throws Exception
	 */
	public void clickBeginTestButtonInNurseLogicCardBack(String moduleName)
			throws Exception {
		logger.info("Method: clickBeginTestButtonInNurseLogicCardBack Starts");
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
								List<WebElement> singleModuleButtons = moduleNameDS
										.get(0)
										.findElements(
												By.cssSelector(PropertiesRepository.getString("new-atitesting.learntab.tutorial.stt.card.front.module.section1.new.loc")));
								if (CollectionUtils.isNotEmpty(singleModuleButtons)) {
									List<WebElement> testElements = singleModuleButtons.get(0).findElements(
											By.cssSelector(PropertiesRepository.getString("new-atitesting.learntab.tutorial.nurse.logic.tutorial.begin.test.button.new.loc")));
									if(CollectionUtils.isNotEmpty(testElements)) {
										testElements.get(0).click();
										waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
										break;
									}
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to click BeginTest Button In NurseLogic Card Back");
			throw new DriverException(
					"Unable to click BeginTest Button In NurseLogic Card Back", e);
		}
		logger.info("Method: clickBeginTestButtonInNurseLogicCardBack End ");
	}
	
	/**
	 * Method is used to click first PreTest Button based on Module Name in
	 * Skills Module 2.0 Card Back.
	 * 
	 * Begin Test
	 * 
	 * @return
	 * @throws Exception
	 */
	public void clickBeginTestButtonInNewNurseLogicCardBack(String moduleName)
			throws Exception {
		logger.info("Method: clickBeginTestButtonInNewNurseLogicCardBack Starts");
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
								((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", allBeginButtonLiElement
										.get(index));
								List<WebElement> singleModuleButtons = allBeginButtonLiElement
										.get(index)
										.findElements(
												By.cssSelector(".product-nurselogic-list-cell li"));
								if (CollectionUtils.isNotEmpty(singleModuleButtons)) {
									List<WebElement> testElements = singleModuleButtons.get(0).findElements(
											By.cssSelector("div div a[class='button focus-element-flag primary-button']"));
									if(CollectionUtils.isNotEmpty(testElements)) {
										testElements.get(0).click();
										waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
										break;
									}
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			logger.info("Error in clickBeginTestButtonInNewNurseLogicCardBack " );
			throw new DriverException(
					"Error in clickBeginTestButtonInNewNurseLogicCardBack", e);
		}
		logger.info("Method: clickBeginTestButtonInNewNurseLogicCardBack End ");
	}
	
	/**
	 * Method is used to click first PreTest Button based on Module Name in
	 * Skills Module 2.0 Card Back.
	 * 
	 * Begin Test
	 * 
	 * @return
	 * @throws Exception
	 */
	public void clickBeginTestButtonInNurseLogicCardBackNew(String moduleName)
			throws Exception {
		logger.info("Method: clickBeginTestButtonInNurseLogicCardBackNew Starts");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,200)", "");
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
												By.cssSelector(".product-nurselogic-list-cell a[class='button focus-element-flag primary-button']"));
								if (CollectionUtils.isNotEmpty(singleModuleButtons)) {
									WebElement testElements = singleModuleButtons.get(0);
									if(testElements != null) {
										testElements.click();
										waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
										break;
									}
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to clickBeginTestButtonInNurseLogicCardBackNew");
			throw new DriverException(
					"Unable to clickBeginTestButtonInNurseLogicCardBackNew", e);
		}
		logger.info("Method: clickBeginTestButtonInNurseLogicCardBackNew End ");
	}
	
	/**
	 * Method is used to click first PreTest Button based on Module Name in
	 * Skills Module 2.0 Card Back.
	 * 
	 * Begin Test
	 * 
	 * @return
	 * @throws Exception
	 */
	public void clickBeginLessonButtonInNurseLogicCardBackNew(String moduleName)
			throws Exception {
		logger.info("Method: clickBeginTestButtonInNurseLogicCardBackNew Starts");
		waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
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
												By.cssSelector(".product-tutorial-list-cell a"));
								if (CollectionUtils.isNotEmpty(singleModuleButtons)) {
									WebElement testElements = singleModuleButtons.get(0);
									if(testElements != null) {
										testElements.click();
										waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
										if(checkContinueWhereYouLeftOffWindows()) {
											waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
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
			logger.info("Unable to clickBeginTestButtonInNurseLogicCardBackNew");
			throw new DriverException(
					"Unable to clickBeginTestButtonInNurseLogicCardBackNew", e);
		}
		logger.info("Method: clickBeginTestButtonInNurseLogicCardBackNew End ");
	}
	
	/**
	 * Method is used to click first PreTest Button based on Module Name in
	 * Skills Module 2.0 Card Back.
	 * 
	 * Begin Test
	 * 
	 * @return
	 * @throws Exception
	 */
	public void clickBeginTestButtonInPharmacologyCardBack(String moduleName)
			throws Exception {
		logger.info("Method: clickBeginTestButtonInNurseLogicCardBack Starts");
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
												By.cssSelector(".product-nurselogic-list-cell .module-multi-tests div a[class='button focus-element-flag primary-button']"));
								if (CollectionUtils.isNotEmpty(singleModuleButtons)) {
										((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", singleModuleButtons.get(0));
										singleModuleButtons.get(0).click();
										waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
										break;
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to click BeginTest Button In NurseLogic Card Back");
			throw new DriverException(
					"Unable to click BeginTest Button In NurseLogic Card Back", e);
		}
		logger.info("Method: clickBeginTestButtonInNurseLogicCardBack End ");
	}
	
	/**
	 * Method is used to click first PreTest Button based on Module Name in
	 * Skills Module 2.0 Card Back.
	 * 
	 * Begin Test
	 * 
	 * @return
	 * @throws Exception
	 */
	public void clickBeginLessonButtonInNurseLogicCardBack(String moduleName)
			throws Exception {
		//logger.info("Method: clickBeginTestButtonInNurseLogicCardBack Starts");
		try {
			baseHandler.waitForPageToLoad(PropertiesRepository
							.getString("new-atitesting.learntab.tutorial.stt.all.card.front.button.update"));
			List<WebElement> allBeginButtonLiElement = baseHandler
					.findElements(PropertiesRepository
							.getString("new-atitesting.learntab.tutorial.stt.all.card.front.button.update"));
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
												By.cssSelector(".product-tutorial-list-cell a"));
								if (CollectionUtils.isNotEmpty(singleModuleButtons)) {
									WebElement testElements = singleModuleButtons.get(0);
									if(testElements != null) {
										testElements.click();
										waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
										if(checkContinueWhereYouLeftOffWindows()) {
											waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
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
			logger.info("Unable to clickBeginTestButtonInNurseLogicCardBackNew");
			throw new DriverException(
					"Unable to clickBeginTestButtonInNurseLogicCardBackNew", e);
		}
		logger.info("Method: clickBeginTestButtonInNurseLogicCardBack End ");
	}
	
	public void clickDosageCalculationModuleName(String moduleName) throws Exception {

		logger.info("Method: clickBeginTestButtonInNurseLogicCardBack Starts");
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
								/*List<WebElement> singleModuleButtons = allBeginButtonLiElement
										.get(index)
										.findElements(
												By.cssSelector(PropertiesRepository.getString("new-atitesting.learntab.tutorial.stt.card.front.module.section1.new.loc")));
								if (CollectionUtils.isNotEmpty(singleModuleButtons)) {*/
									List<WebElement> testElements = allBeginButtonLiElement.get(index).findElements(
											By.cssSelector("a[class='button primary-button focus-element-flag']"));
									if(CollectionUtils.isNotEmpty(testElements)) {
										JavascriptExecutor jse = (JavascriptExecutor)driver;
										jse.executeScript("window.scrollBy(0,250)", "");
										testElements.get(0).click();
										waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
										// Verify Continue where you left off windows is displayed. 
										if(checkContinueWhereYouLeftOffWindows()) {
											waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
										}
										break;
									}
								//}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to click BeginTest Button In NurseLogic Card Back");
			throw new DriverException(
					"Unable to click BeginTest Button In NurseLogic Card Back", e);
		}
		logger.info("Method: clickBeginTestButtonInNurseLogicCardBack End ");
	}
	
	public void clickDosageCalculationModuleNameTest(String moduleName) throws Exception {

		logger.info("Method: clickDosageCalculationModuleNameTest Starts");
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
								/*List<WebElement> singleModuleButtons = allBeginButtonLiElement
										.get(index)
										.findElements(
												By.cssSelector(PropertiesRepository.getString("new-atitesting.learntab.tutorial.stt.card.front.module.section1.new.loc")));
								if (CollectionUtils.isNotEmpty(singleModuleButtons)) {*/
									List<WebElement> testElements = allBeginButtonLiElement.get(index).findElements(
											By.cssSelector("ul[class='product-nurselogic-list-cell'] .button.primary-button.focus-element-flag"));
									if(CollectionUtils.isNotEmpty(testElements)) {
										JavascriptExecutor jse = (JavascriptExecutor)driver;
										jse.executeScript("window.scrollBy(0,250)", "");
										testElements.get(0).click();
										waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
										waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
										break;
									}
								//}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to click BeginTest Button In NurseLogic Card Back");
			throw new DriverException(
					"Unable to click BeginTest Button In NurseLogic Card Back", e);
		}
		logger.info("Method: clickDosageCalculationModuleNameTest End ");
	}
	
	/**
	 * Method is used to click first PreTest Button based on Module Name in
	 * Skills Module 2.0 Card Back.
	 * 
	 * Begin Test
	 * 
	 * @return
	 * @throws Exception
	 */
	public void clickBeginLessonButtonInSkillsModuleCardBack(String moduleName)
			throws Exception {
		logger.info("Method: clickBeginLessonButtonInSkillsModuleCardBack Starts");
		try {
			baseHandler.waitForPageToLoad(PropertiesRepository
							.getString("new-atitesting.learntab.tutorial.stt.all.card.front.button"));
			List<WebElement> allBeginButtonLiElement = baseHandler
					.findElements(PropertiesRepository
							.getString("new-atitesting.tutorial.cardback.buttons.update"));
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
											By.cssSelector(".skills-row-back-cell a[class='button primary-button focus-element-flag']"));
							if (CollectionUtils.isNotEmpty(singleModuleButtons)) {
								
								singleModuleButtons.get(0).click();
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								break;
							}
						}
					}

				}
			}
		} catch (Exception e) {
			logger.info("Unable to click BeginTest Button In NurseLogic Card Back");
			throw new DriverException(
					"Unable to click BeginTest Button In NurseLogic Card Back", e);
		}
		logger.info("Method: clickBeginLessonButtonInSkillsModuleCardBack End ");
	}
	
	/**
	 * Method is used to verify Logo in Assessment Page. 
	 * 
	 * @author saravanan.jothimani
	 * @return boolean
	 * @throws Exception
	 */
	public boolean verifyAssessmentLogo() throws Exception {
		logger.info("Method: verifyAssessmentLogo Starts");
		boolean flag = false;
    	try {
//    		windowHandler.switchToFrame("assessmentFrame");
    		baseHandler.waitForPageToLoad(PropertiesRepository.getString("new-atitesting.learntab.tutorial.logo"));
    		if(baseHandler.isDisplayed(baseHandler.findElement(PropertiesRepository.getString("new-atitesting.learntab.tutorial.logo")))) {
    			flag = true;
    		}
    		windowHandler.switchToMainWindow();
    	} catch (Exception e) {
    		logger.info("Unable to verify Assessment Logo");
    		throw new DriverException("Unable to verify Assessment Logo" , e); 
    	}
    	logger.info("Method: verifyAssessmentLogo End flag --> " + flag);
    	return flag;
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
			switchToQuizFrame();
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.question.number.loc"));
			if(CollectionUtils.isNotEmpty(element) && StringUtils.isNotEmpty(element.get(0).getText())) {
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
	 * Method is used to verify Quiz Assessment Starting Number Button
	 * 
	 * 
	 * @author saravanan.jothimani
	 * @return boolean
	 * @throws Exception
	 */
	public boolean verifyAssessmentStartingNumberButtonWithoutSwitch() throws Exception {
		logger.info("Method: verifyAssessmentStartingNumberButton Starts");
		boolean flag = false;
		try {
			switchToAssessmentFrameHandler();
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.new.question.number.loc"));
			//List<WebElement> element = baseHandler.findElements("#header h1 span");
			if(CollectionUtils.isNotEmpty(element) && StringUtils.isNotEmpty(element.get(0).getText())) {
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
			
			switchToQuizFrame();
			baseHandler
					.waitToBeDisplayed(PropertiesRepository
							.getString("new-atitesting.learntab.tutorial.name.value"));
			
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.question.number.loc"));
			if(CollectionUtils.isNotEmpty(element)  && StringUtils.isNotEmpty(element.get(0).getText())) {
				flag = true;
			}
			windowHandler.switchToMainWindow();
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
	 * Method is used to verify Quiz Assessment Ending Number Button
	 * 
	 * 
	 * @author saravanan.jothimani
	 * @return boolean
	 * @throws Exception
	 */
	public boolean verifyAssessmentEndingNumberButtonWithoutSwitch() throws Exception {
		logger.info("Method: verifyAssessmentEndingNumberButtonWithoutSwitch Starts");
		boolean flag = false;
		try {
			switchToAssessmentFrameHandler();
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.new.question.number.loc"));
			//List<WebElement> element = baseHandler.findElements("#header h1 span");
			if(CollectionUtils.isNotEmpty(element)  && StringUtils.isNotEmpty(element.get(1).getText())) {
				flag = true;
			}
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to verify Assessment Ending Number Button");
			throw new DriverException(
					"Unable to verify Assessment Ending Number Button", e);
		}
		logger.info("Method: verifyAssessmentEndingNumberButtonWithoutSwitch End flag --> "
				+ flag);
		return flag;
	}
	
	
	/**
	 * Method is used to verify Quiz Assessment Flag Button
	 * 
	 * 
	 * @author saravanan.jothimani
	 * @return boolean
	 * @throws Exception
	 */
	public boolean verifyAssessmentFlagButton() throws Exception {
		logger.info("Method: verifyAssessmentFlagButton Starts");
		boolean flag = false;
		try {
			switchToQuizFrame();
			baseHandler
					.waitToBeDisplayed(PropertiesRepository
							.getString("new-atitesting.learntab.tutorial.name.value"));		
			if(baseHandler.isDisplayed(baseHandler.findElement(PropertiesRepository.getString("new-atitesting.learntab.quiz.bank.flag.button.loc")))) {
				flag = true;
			}
			windowHandler.switchToMainWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to verify Assessment Flag Button");
			throw new DriverException(
					"Unable to verify Assessment Flag Button", e);
		}
		logger.info("Method: verifyAssessmentFlagButton End flag --> "
				+ flag);
		return flag;
	}
	
	/**
	 * Method is used to verify Quiz Assessment Submit Button
	 * 
	 * 
	 * @author saravanan.jothimani
	 * @return boolean
	 * @throws Exception
	 */
	public boolean verifyAssessmentSubmitButton() throws Exception {
		logger.info("Method: verifyAssessmentEndingNumberButton Starts");
		boolean flag = false;
		try {
			switchToQuizFrame();
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.assessment.continue.button.loc"));
			if(CollectionUtils.isNotEmpty(element)) {
				flag = true;
			}
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to verify Assessment Submit Button");
			throw new DriverException(
					"Unable to verify Assessment Submit Button", e);
		}
		logger.info("Method: verifyAssessmentSubmitButton End flag --> "
				+ flag);
		return flag;
	}
	
	/**
	 * Method is used to verify Quiz Assessment Submit Button
	 * 
	 * 
	 * @author saravanan.jothimani
	 * @return boolean
	 * @throws Exception
	 */
	public boolean verifyAssessmentSubmitButtonWithoutSwitch() throws Exception {
		logger.info("Method: verifyAssessmentSubmitButtonWithoutSwitch Starts");
		boolean flag = false;
		try {
			switchToAssessmentFrameHandler();
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.assessment.continue.button.loc"));
			if(CollectionUtils.isNotEmpty(element)) {
				flag = true;
			}
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to verify Assessment Submit Button");
			throw new DriverException(
					"Unable to verify Assessment Submit Button", e);
		}
		logger.info("Method: verifyAssessmentSubmitButtonWithoutSwitch End flag --> "
				+ flag);
		return flag;
	}
	
	/**
	 * Method is used to verify Previous Button while taking Assessment. 
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	public boolean clickAssessmentPreviousButton() throws Exception {
		logger.info("Method: clickAssessmentPreviousButton Starts");
		boolean flag = false;
    	try {
    		//switchToNurseLogicFrame();
    		switchHandlers();
    		String minQtnTextNo = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.question.number.loc")).get(0).getText();
    		int minCount = Integer.parseInt(minQtnTextNo);
    		// Click Previous button
			List<WebElement> buttonBackWardElement = baseHandler.findElements("#movePrevious");
			if(CollectionUtils.isNotEmpty(buttonBackWardElement)) {
				if(buttonBackWardElement.get(0).isDisplayed()) {
					WebElement continueButtonElement = buttonBackWardElement.get(0);
					if(continueButtonElement != null) {
						continueButtonElement.sendKeys(Keys.ENTER);
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
					}
				}
			}
    		String maxQtnTextNo = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.question.number.loc")).get(0).getText();
    		int afterMinCount = Integer.parseInt(maxQtnTextNo);
    		
    		if(minCount > afterMinCount) {
    			flag = true;
    		}
    		// Clicking on Continue Button.
    		List<WebElement> buttonForwardElement = baseHandler.findElements("#moveNext");
			if(CollectionUtils.isNotEmpty(buttonForwardElement)) {
				if(buttonForwardElement.get(0).isDisplayed()) {
					WebElement continueButtonElement = buttonForwardElement.get(0);
					if(continueButtonElement != null) {
						continueButtonElement.sendKeys(Keys.ENTER);
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
					}
				}
			}
    		windowHandler.switchToLatestWindow();
    	} catch (Exception e) {
    		windowHandler.switchToLatestWindow();
    		logger.info("Unable to click Assessment Previous Button" );
    		throw new DriverException("Unable to click Assessment Previous Button" , e); 
    	}
    	logger.info("Method: clickAssessmentPreviousButton End flag --> " + flag );
    	return flag;
	}
	
	public void switchHandlers() throws Exception {

		windowHandler.switchToMainWindow();
		waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		windowHandler.switchToFrame("assessmentFrame");
	}
	
	/**
	 * Method is used to verify IPP Page Header and click on Close button. 
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws Exception
	 */
	public boolean verifyIPPHeaderAndClickCloseButton() throws Exception {
		logger.info("Method: verifyIPPHeaderAndClickCloseButton Starts");
		boolean flag = false;
    	try {
    		
    		String moduleName = null;
    		waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
    		waitUntillIPPPageIsLoaded(".sub-header>section>img");
    		windowHandler.switchToLatestWindow();
    		List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.learntab.tutorial.nurse.logic.tutorial.ipp.header.loc"));
    		if(CollectionUtils.isNotEmpty(element)) {
    			List<WebElement> headerElement = element.get(2).findElements(By.cssSelector("span"));
    			if(CollectionUtils.isNotEmpty(headerElement)) {
    				moduleName = headerElement.get(1).getText();
        			String appendModuleName = PropertiesRepository.getString("new-atitesting.learntab.tutorial.nurse.logic.card.front.module.name.new");
        			if(StringUtils.isNotEmpty(moduleName) && moduleName.equalsIgnoreCase(appendModuleName)) {
        				buttonHandler.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.nurse.logic.tutorial.ipp.close.button.loc"));
        				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
        				flag = true;
        			}
    			}
    		}
    		  
    	} catch (DriverException e) {
    		logger.info("Unable to verify IPP Header And Click Close Button");
    		throw new DriverException("Unable to verify IPP Header And Click Close Button" , e); 
    	}
    	logger.info("Method: verifyIPPHeaderAndClickCloseButton End flag --> " + flag);
    	return flag;
	}
	
	
	/**
	 * For Peak hour testing, method is used to verify IPP Page Header and click on Close button. 
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws Exception
	 */
	public boolean verifyIPPHeaderAndClickCloseButtonPeakHour(String IPPHeaderName , int index) throws Exception {
		logger.info("Method: verifyIPPHeaderAndClickCloseButton Starts");
		boolean flag = false;
    	try {
    		
    		String moduleName = null;
    		waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
    		waitUntillIPPPageIsLoaded(".sub-header>section>img");
    		windowHandler.switchToLatestWindow();
    		List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.learntab.tutorial.nurse.logic.tutorial.ipp.header.loc"));
    		if(CollectionUtils.isNotEmpty(element)) {
    			List<WebElement> headerElement = element.get(index).findElements(By.cssSelector("span"));
    			if(CollectionUtils.isNotEmpty(headerElement)) {
    				moduleName = headerElement.get(1).getText();
        			String appendModuleName = IPPHeaderName;
        			if(StringUtils.isNotEmpty(moduleName) && moduleName.equalsIgnoreCase(appendModuleName)) {
        				buttonHandler.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.nurse.logic.tutorial.ipp.close.button.loc"));
        				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
        				flag = true;
        			}
    			}
    		}
    		  
    	} catch (DriverException e) {
    		logger.info("Unable to verify IPP Header And Click Close Button");
    		throw new DriverException("Unable to verify IPP Header And Click Close Button" , e); 
    	}
    	logger.info("Method: verifyIPPHeaderAndClickCloseButton End flag --> " + flag);
    	return flag;
	}
}


























