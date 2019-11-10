package com.automation.newati.pages;

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

public class NclexPrepTabPage extends NclexPrepTabPage1 {

	private Logger logger = LogManager.getLogger(this.getClass());
	public String actualText = "";
	public BaseHandler baseHandler;
	private ButtonHandler buttonHandler;
	private WindowHandler windowHandler;
	
	public NclexPrepTabPage(WebDriver webDriver) {
		super(webDriver);
		baseHandler = new BaseHandler(driver);
		buttonHandler = new ButtonHandler(driver);
		windowHandler = new WindowHandler(driver);
	}

	/**
	 * Method used to verify hidden message and click on check box.
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws Exception
	 */
	public boolean verifyHiddenCheckBoxMessageAndClick() throws Exception {
		logger.info("Method : verifyHiddenCheckBoxMessageAndClick Start");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("new.atitestig.nclex.hide.disabled.product.text.loc"));
			if (CollectionUtils.isNotEmpty(element) && element.get(2).getText().trim().contains("hidden")) {
				buttonHandler
						.clickButton(PropertiesRepository.getString("new.atitestig.nclex.hide.disabled.product.loc"));
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to verifyHiddenCheckBoxMessageAndClick");
			log(logger, "Unable to verifyHiddenCheckBoxMessageAndClick");
			throw new DriverException("Unable to verifyHiddenCheckBoxMessageAndClick", e);
		}
		logger.info("Method: verifyHiddenCheckBoxMessageAndClick End flag --> " + flag);
		return flag;
	}

	/**
	 * Method used to verify hidden message and click on check box.
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws Exception
	 */
	public boolean verifyHiddenCheckBoxMessageAndClickInCardBack() throws Exception {
		logger.info("Method : verifyHiddenCheckBoxMessageAndClickInCardBack Start");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(
					PropertiesRepository.getString("new.atitestig.nclex.hide.disabled.product.in.card.back.text.loc"));
			if (CollectionUtils.isNotEmpty(element) && element.get(2).getText().trim().contains("hidden")) {
				buttonHandler.clickButton(
						PropertiesRepository.getString("new.atitestig.nclex.hide.disabled.product.in.card.back.loc"));
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to verifyHiddenCheckBoxMessageAndClickInCardBack");
			log(logger, "Unable to verifyHiddenCheckBoxMessageAndClickInCardBack");
			throw new DriverException("Unable to verifyHiddenCheckBoxMessageAndClickInCardBack", e);
		}
		logger.info("Method: verifyHiddenCheckBoxMessageAndClickInCardBack End flag --> " + flag);
		return flag;
	}

	/**
	 * Method used to verify Disabled modules in NCLEX Card back.
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws Exception
	 */
	public boolean verifyDisabledModules(String moduleName) throws Exception {
		logger.info("Method : verifyDisabledModules Start");
		logger.info("moduleName value --> " + moduleName);
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(
					PropertiesRepository.getString("new-atitesting.learntab.tutorial.stt.all.card.front.button"));
			if (CollectionUtils.isNotEmpty(element)) {
				for (WebElement moduleElement : element) {
					List<WebElement> headerElement = moduleElement.findElements(By.cssSelector(PropertiesRepository
							.getString("new-atitesting.learntab.tutorial.skills.module2.card.front.module.name.loc")));
					if (CollectionUtils.isNotEmpty(headerElement)
							&& headerElement.get(0).getText().trim().equalsIgnoreCase(moduleName)) {
						List<WebElement> disableElement = moduleElement.findElements(By.cssSelector(PropertiesRepository
								.getString("new-atitesting.learntab.tutorial.card.back.disabled.module.loc")));
						if (CollectionUtils.isNotEmpty(disableElement) && disableElement.size() == 1) {
							flag = true;
							break;
						} else {
							logger.info("Unable to verify disbaled section");
						}
					} else {
						logger.info("Header name is not matched");
					}
				}
			} else {
				logger.info("Unable to get values from locators");
			}
		} catch (Exception e) {
			logger.info("Unable to verifyDisabledModules");
			log(logger, "Unable to verifyDisabledModules");
			throw new DriverException("Unable to verifyDisabledModules", e);
		}
		logger.info("Method: verifyDisabledModules End flag --> " + flag);
		return flag;
	}

	/**
	 * Method used to verify NCLEX Recent activity.
	 * 
	 * @author saravanan.jothimani
	 * @param tutorialName
	 * @param moduleName
	 * @return
	 * @throws Exception
	 */
	public boolean verifyNCLEXRecentActivity(String tutorialName, String moduleName) throws Exception {
		logger.info("Method : verifyNCLEXRecentActivity Start");
		boolean flag = false;
		try {
			// Get all recent activities.
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("new.atitestig.nclex.recent.activity.section.loc"));
			if (CollectionUtils.isNotEmpty(element)) {

				for (WebElement recentElement : element) {
					// Getting NCLEX Name.
					List<WebElement> nclexName = recentElement.findElements(By.cssSelector(
							PropertiesRepository.getString("new.atitestig.nclex.recent.activity.tutorial.header.loc")));
					if (CollectionUtils.isNotEmpty(nclexName)) {
						for (WebElement nclexNameElement : nclexName) {
							if (nclexNameElement.getText().equalsIgnoreCase(tutorialName)) {
								// Getting NCLEX module name
								List<WebElement> nclexModuleName = recentElement
										.findElements(By.cssSelector(PropertiesRepository.getString(
												"new.atitestig.nclex.recent.activity.module.name.header.loc")));
								if (CollectionUtils.isNotEmpty(nclexModuleName)) {
									for (WebElement nclexModuleNameElement : nclexModuleName) {
										if (nclexModuleNameElement.getText().equalsIgnoreCase(moduleName)) {
											// Getting Status.
											List<WebElement> nclexStatus = recentElement
													.findElements(By.cssSelector(PropertiesRepository.getString(
															"new.atitestig.nclex.recent.activity.inprogress.completed.section.loc")));
											if (CollectionUtils.isNotEmpty(nclexStatus)
													&& nclexStatus.get(0).getText().equalsIgnoreCase("In Progress")) {
												// Getting NCLEX prep
												List<WebElement> nclexPrep = recentElement
														.findElements(By.cssSelector(PropertiesRepository.getString(
																"new.atitestig.nclex.recent.activity.nclex.prep.loc")));
												if (CollectionUtils.isNotEmpty(nclexPrep)
														&& nclexPrep.get(0).getText().equalsIgnoreCase("NCLEX PREP")) {
													flag = true;
												} else {
													logger.info("Unable to verify nclex prep value");
												}
											} else {
												logger.info("Unable to verify nclex status");
											}
										} else {
											logger.info("Unable to verify module name");
										}
									}
								} else {
									logger.info("Unable to verify module name");
								}
							} else {
								logger.info("Tutorial Name is not matched");
							}
						}
					} else {
						logger.info("Unable to verify tutorial name");
					}
				}

			} else {
				logger.info("Unable to get locator details");
			}
		} catch (Exception e) {
			logger.info("Unable to verifyNCLEXRecentActivity");
			log(logger, "Unable to verifyNCLEXRecentActivity");
			throw new DriverException("Unable to verifyNCLEXRecentActivity", e);
		}
		logger.info("Method: verifyNCLEXRecentActivity End flag --> " + flag);
		return flag;
	}

	/**
	 * Method used to verify NCLEX Recent activity with module test section.
	 * 
	 * @author saravanan.jothimani
	 * @param tutorialName
	 * @param moduleName
	 * @return
	 * @throws Exception
	 */
	public boolean verifyNCLEXRecentActivityWithModuleTest(String tutorialName, String moduleName) throws Exception {
		logger.info("Method : verifyNCLEXRecentActivityWithModuleTest Start");
		moduleName = "Next Generation NCLEX Sample Item Types";
		boolean flag = false;
		try {
			// Get all recent activities.
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("new.atitestig.nclex.recent.activity.section.loc"));
			if (CollectionUtils.isNotEmpty(element)) {

				for (WebElement recentElement : element) {
					// Getting NCLEX Name.
					List<WebElement> nclexName = recentElement.findElements(By.cssSelector(
							PropertiesRepository.getString("new.atitestig.nclex.recent.activity.tutorial.header.loc")));
					if (CollectionUtils.isNotEmpty(nclexName)) {
						for (WebElement nclexNameElement : nclexName) {
							if (nclexNameElement.getText().equalsIgnoreCase(tutorialName)) {
								// Getting NCLEX module name
								List<WebElement> nclexModuleName = recentElement
										.findElements(By.cssSelector(PropertiesRepository.getString(
												"new.atitestig.nclex.recent.activity.module.name.header.loc")));
								if (CollectionUtils.isNotEmpty(nclexModuleName)) {
									for (WebElement nclexModuleNameElement : nclexModuleName) {
										if (nclexModuleNameElement.getText().equalsIgnoreCase(moduleName)) {

											// Getting Status.
											List<WebElement> nclexStatus = recentElement
													.findElements(By.cssSelector(PropertiesRepository.getString(
															"new.atitestig.nclex.recent.activity.completed.section.loc")));
											if (CollectionUtils.isNotEmpty(nclexStatus)
													&& nclexStatus.get(0).getText().equalsIgnoreCase("COMPLETED SCORE")) {
												// Getting Module Test header
												List<WebElement> nclexModuleTest = recentElement
														.findElements(By.cssSelector(PropertiesRepository.getString(
																"new.atitestig.nclex.recent.activity.module.test.header.loc")));
												if (CollectionUtils.isNotEmpty(nclexModuleTest)
														&& nclexModuleTest.get(0).getText()
																.equalsIgnoreCase("MODULE TEST")) {
													// Getting Module Test Name
													List<WebElement> nclexModuleTestModuleName = recentElement
															.findElements(By.cssSelector(PropertiesRepository.getString(
																	"new.atitestig.nclex.recent.activity.module.test.module.name.loc")));
													if (CollectionUtils.isNotEmpty(nclexModuleTestModuleName)
															&& nclexModuleTestModuleName.get(0).getText()
																	.equalsIgnoreCase(PropertiesRepository.getString(
																			"new.atitestig.nclex.recent.activity.module.test.module.name.value"))) {
														// Getting NCLEX prep
														List<WebElement> nclexPrep = recentElement.findElements(
																By.cssSelector(PropertiesRepository.getString(
																		"new.atitestig.nclex.recent.activity.nclex.prep.loc")));
														if (CollectionUtils.isNotEmpty(nclexPrep) && nclexPrep.get(0)
																.getText().equalsIgnoreCase("NCLEX PREP")) {
															flag = true;
														} else {
															logger.info("Unable to verify nclex prep value");
														}
													}
												}

											} else {
												logger.info("Unable to verify nclex status");
											}
										} else {
											logger.info("Unable to verify module name");
										}
									}
								} else {
									logger.info("Unable to verify module name");
								}
							} else {
								logger.info("Tutorial Name is not matched");
							}
						}
					} else {
						logger.info("Unable to verify tutorial name");
					}
				}

			} else {
				logger.info("Unable to get locator details");
			}
		} catch (Exception e) {
			logger.info("Unable to verifyNCLEXRecentActivityWithModuleTest");
			log(logger, "Unable to verifyNCLEXRecentActivityWithModuleTest");
			throw new DriverException("Unable to verifyNCLEXRecentActivityWithModuleTest", e);
		}
		logger.info("Method: verifyNCLEXRecentActivityWithModuleTest End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to verify quiz name and click on button under quiz section in
	 * NCLEX card back section.
	 * 
	 * @author saravanan.jothimani
	 * @param quizName
	 * @param index
	 * @return
	 * @throws Exception
	 */
	public boolean clickQuizNameInCardBack(String quizName, int index) throws Exception {
		//logger.info("Method : clickQuizNameInCardBack Start");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.nclex.card.back.with.li.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				// Getting 2 Quiz name Element
				List<WebElement> quizElement = element.get(2).findElements(By.cssSelector("li"));
				if (CollectionUtils.isNotEmpty(quizElement)) {
					// Verifying Quiz name.
					List<WebElement> quizNameElement = quizElement.get(index).findElements(By.cssSelector(
							PropertiesRepository.getString("new-atitesting.nclex.card.back.quiz.bank.name.loc")));
					if (CollectionUtils.isNotEmpty(quizNameElement)
							&& quizNameElement.get(0).getText().trim().equalsIgnoreCase(quizName)) {

						// Clicking on Begin/ Continue/ Retake button
						List<WebElement> quizButtonElement = quizElement.get(index).findElements(By.cssSelector(
								PropertiesRepository.getString("new-atitesting.nclex.card.back.quiz.bank.button.loc")));
						if (CollectionUtils.isNotEmpty(quizButtonElement)) {
							
							// Getting Accessed and Span details
							List<WebElement> timeSpentElement = quizElement.get(index).findElements(By.cssSelector(PropertiesRepository.getString("new-atitesting.nclex.card.back.quiz.bank.time.spent.loc")));
							List<WebElement> accessedElement = quizElement.get(index).findElements(By.cssSelector(PropertiesRepository.getString("new-atitesting.nclex.card.back.quiz.bank.accessed.loc")));

							if(quizButtonElement.get(0).getText().trim().equalsIgnoreCase("Begin")) {
								logger.info("Begin Button");
								if(CollectionUtils.isNotEmpty(accessedElement) && accessedElement.get(0).getText().trim().equalsIgnoreCase("Never")) {
									quizButtonElement.get(0).click();
									flag = true;		
								}
							} else {
								logger.info("Other than Begin button");
								if(CollectionUtils.isNotEmpty(timeSpentElement) && CollectionUtils.isNotEmpty(accessedElement)) {
									quizButtonElement.get(0).click();
									flag = true;
								}
							}
						} else {
							logger.info("Unable to verify Button labels");
						}
					} else {
						logger.info("Unable to verify Quiz name");
					}
				} else {
					logger.info("Unable to get quiz element");
				}
			}
		} catch (Exception e) {
			logger.info("Unable to clickQuizNameInCardBack");
			log(logger, "Unable to clickQuizNameInCardBack");
			throw new DriverException("Unable to clickQuizNameInCardBack", e);
		}
		logger.info("Method: clickQuizNameInCardBack End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to verify assessment name in Quiz for NCLEX. 
	 * 
	 * @author saravanan.jothimani
	 * @param assessmentName
	 * @return
	 * @throws Exception
	 */
	public boolean verifyQuizName(String locator, int index, String assessmentName) throws Exception {
		logger.info("Method : verifyQuizName Start");
		boolean flag = false;
		try {
			switchToAssessmentFrameHandler();
			List<WebElement> element = baseHandler.findElements(locator);
			if(CollectionUtils.isNotEmpty(element) && element.get(index).getText().trim().equalsIgnoreCase(assessmentName)) {
				flag = true;
			}
			windowHandler.switchToLatestWindow();
		}catch (Exception e) {
			windowHandler.switchToLatestWindow();
    		logger.info("Unable to verifyQuizName" );
			log(logger, "Unable to verifyQuizName" );
    		throw new DriverException("Unable to verifyQuizName" , e); 
    	}
		logger.info("Method: verifyQuizName End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to verify assessment name in Quiz for NCLEX. 
	 * 
	 * @author saravanan.jothimani
	 * @param assessmentName
	 * @return
	 * @throws Exception
	 */
	public boolean clickQuizCloseButton(String locator) throws Exception {
		logger.info("Method : verifyQuizName Start");
		boolean flag = false;
		try {
			switchToAssessmentFrameHandler();
			List<WebElement> element = baseHandler.findElements(locator);
			if(CollectionUtils.isNotEmpty(element)) {
				element.get(0).click();
				flag = true;
			}
			windowHandler.switchToLatestWindow();
		}catch (Exception e) {
			windowHandler.switchToLatestWindow();
    		logger.info("Unable to verifyQuizName" );
			log(logger, "Unable to verifyQuizName" );
    		throw new DriverException("Unable to verifyQuizName" , e); 
    	}
		logger.info("Method: verifyQuizName End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to verify access status of Module button in Select Instance.
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws Exception
	 */
	public boolean verifyCardFrontModulesButton() throws Exception {
		 logger.info("Method : verifyCardFrontModulesButton Start");
		boolean flag = false;
		boolean notAccessedFlag = false;
		boolean accessedFlag = false;
		try {
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.select.instance.modal.ul.window.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				for (WebElement moduleListElement : element) {
					Thread.sleep(20000);
					List<WebElement> moduleElement = moduleListElement.findElements(By.cssSelector(PropertiesRepository
							.getString("new-atitesting.nclex.select.instance.access.button.module.access.status.loc")));
					if (CollectionUtils.isNotEmpty(moduleElement)
							&& moduleElement.get(0).getText().trim().contains("Never")) {
						logger.info("Verifying Module button colour where module is not accessd");
						
						// Modules accessed
						List<WebElement> moduleAccessedElement = moduleListElement
								.findElements(By.cssSelector(PropertiesRepository
										.getString("new-atitesting.nclex.select.instance.access.never.button.loc")));
						if (CollectionUtils.isNotEmpty(moduleAccessedElement)) {
							notAccessedFlag = true;
						}
						
						
					} else {
						logger.info("Verifying Module button colour where module is accessd");
						// Modules not accessed
						List<WebElement> moduleNotAccessedElement = moduleListElement
								.findElements(By.cssSelector(PropertiesRepository
										.getString("new-atitesting.nclex.select.instance.access.button.loc")));
						if (CollectionUtils.isNotEmpty(moduleNotAccessedElement)) {
							for (WebElement styleElement : moduleNotAccessedElement) {
								String attributeStyle = styleElement.getAttribute("style");
								if (StringUtils.isNotBlank(attributeStyle)
										&& attributeStyle.equalsIgnoreCase("display: none;")) {
									accessedFlag = true;
								}
							}
						}
					}
				}
			} else {
				logger.info("Uable to get locator values");
			}
			if(notAccessedFlag && accessedFlag) {
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to verifyCardFrontModulesButton");
			log(logger, "Unable to verifyCardFrontModulesButton");
			throw new DriverException("Unable to verifyCardFrontModulesButton", e);
		}
		logger.info("Method: verifyCardFrontModulesButton End flag --> " + flag);
		return flag;
	}
}
