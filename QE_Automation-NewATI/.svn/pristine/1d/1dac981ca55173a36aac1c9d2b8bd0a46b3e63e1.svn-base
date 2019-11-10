package com.automation.newati.pages;

import java.util.ArrayList;
import java.util.Collections;
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
import com.ascendlearning.automation.ui.handlers.WindowHandler;

public class PractiseAssessmentPage3 extends TestTabPage {

	private Logger logger = LogManager.getLogger(this.getClass());
	private BaseHandler baseHandler;
	private WindowHandler windowHandler;
	int flaggedQuestionCount = 0;

	public PractiseAssessmentPage3(WebDriver webDriver) {
		super(webDriver);
		baseHandler = new BaseHandler(driver);
		windowHandler = new WindowHandler(driver);
	}

	/**
	 * Method used to verify assessment name under test tab.
	 * 
	 * @author saravanan.jothimani
	 * @param assessmentName
	 * @return
	 * @throws Exception
	 */
	public boolean verifyAssessmentNameByName(String assessmentName) throws Exception {
		logger.info("Method: verifyAssessmentNameByName Start ");
		boolean flag = false;
		try {
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			List<WebElement> moduleList = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.all.modules.loc.quiz.new"));
			if (moduleList != null && moduleList.size() > 0) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					WebElement element = moduleList.get(i)
							.findElement(By.cssSelector("section div[class='description']"));
					if (assessmentName.equalsIgnoreCase(element.getText())) {
						flag = true;
						break;
					}
				}
			} else {
				logger.info("Unable to find element in Test Tab");
			}
		} catch (Exception e) {
			logger.info("Unable to verifyAssessmentNameByName");
			log(logger, "Unable to verifyAssessmentNameByName");
			throw new DriverException("Unable to verifyAssessmentNameByName", e);
		}
		logger.info("Method: verifyAssessmentNameByName End");
		return flag;
	}

	/**
	 * Method to verify Dynamic Quizzes Section
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws Exception
	 */
	public boolean verifyDynamicQuizzesSection() throws Exception {
		logger.info("Method : verifyDynamicQuizzesSection Start");
		boolean flag = false;
		try {
			// Dynamic and Standard Quizzes section.
			List<WebElement> element = baseHandler.findElements(
					PropertiesRepository.getString("newati.myati.test.tab.ls.dynamic.standard.quizzes.section.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				WebElement dynamicQuizElement = element.get(0);
				// Verify Dynamic quizzes header.
				List<WebElement> textElement = dynamicQuizElement.findElements(By.cssSelector(
						PropertiesRepository.getString("newati.myati.test.tab.ls.dynamic.quizzes.header.loc")));
				if (CollectionUtils.isNotEmpty(textElement)) {
					if (PropertiesRepository.getString("newati.myati.test.tab.ls.dynamic.quizzes.header.value")
							.equalsIgnoreCase(textElement.get(0).getText().trim())) {
						// Verify Dynamic quizzes section.
						StringBuilder sb = new StringBuilder();
						sb.append(PropertiesRepository
								.getString("newati.myati.test.tab.ls.dynamic.quizzes.section.value1")).append(", ")
								.append(PropertiesRepository
										.getString("newati.myati.test.tab.ls.dynamic.quizzes.section.value2"));
						if (sb.toString().equalsIgnoreCase(textElement.get(2).getText().trim())) {
							// Verify Dynamic Quizzes three buttons.
							List<WebElement> buttonElement = dynamicQuizElement
									.findElements(By.cssSelector(PropertiesRepository
											.getString("newati.myati.test.tab.ls.dynamic.quizzes.button.loc")));
							if (CollectionUtils.isNotEmpty(buttonElement)
									&& PropertiesRepository.getString(
											"newati.myati.test.tab.ls.dynamic.quizzes.button.adaptive.quizzes.value")
											.equalsIgnoreCase(buttonElement.get(0).getText().trim())
									&& PropertiesRepository.getString(
											"newati.myati.test.tab.ls.dynamic.quizzes.button.quiz.by.category.value")
											.equalsIgnoreCase(buttonElement.get(1).getText().trim())
									&& PropertiesRepository.getString(
											"newati.myati.test.tab.ls.dynamic.quizzes.button.quizzes.results.value")
											.equalsIgnoreCase(buttonElement.get(2).getText().trim())) {
								flag = true;
							} else {
								logger.info("Unable to verify button in Dynamic Quizzes Section");
							}
						} else {
							logger.info("Unable to verify Dynamic Quizzed Take a content specific section");
						}
					} else {
						logger.info("Unable to verify Dynamic Quiz header");
					}
				} else {
					logger.info("Unable to get Dynamic Quiz section locator");
				}
			} else {
				logger.info("Unable to get both sections in quiz");
			}
		} catch (Exception e) {
			logger.info("Unable to verifyDynamicQuizzesSection");
			log(logger, "Unable to verifyDynamicQuizzesSection");
			throw new DriverException("Unable to verifyDynamicQuizzesSection", e);
		}
		logger.info("Method: verifyDynamicQuizzesSection End flag --> " + flag);
		return flag;
	}

	/**
	 * Method to verify Standard Quizzes Section
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws Exception
	 */
	public boolean verifyStandardQuizzesSection() throws Exception {
		logger.info("Method : verifyStandardQuizzesSection Start");
		boolean flag = false;
		try {
			// Dynamic and Standard Quizzes section.
			List<WebElement> element = baseHandler.findElements(
					PropertiesRepository.getString("newati.myati.test.tab.ls.dynamic.standard.quizzes.section.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				WebElement standardQuizElement = element.get(1);
				// Verify Dynamic quizzes header.
				List<WebElement> textElement = standardQuizElement.findElements(By.cssSelector(
						PropertiesRepository.getString("newati.myati.test.tab.ls.dynamic.quizzes.header.loc")));
				if (CollectionUtils.isNotEmpty(textElement)) {
					if (PropertiesRepository.getString("newati.myati.test.tab.ls.standard.quizzes.header.value")
							.equalsIgnoreCase(textElement.get(0).getText().trim())) {
						// Verify Dynamic quizzes section.
						StringBuilder sb = new StringBuilder();
						sb.append(PropertiesRepository
								.getString("newati.myati.test.tab.ls.standard.quizzes.section.value1"));
						if (sb.toString().equalsIgnoreCase(textElement.get(2).getText().trim())) {
							flag = true;
						} else {
							logger.info("Unable to verify Standard Quizzed Take a content specific section");
						}
					} else {
						logger.info("Unable to verify Standard Quiz header");
					}
				} else {
					logger.info("Unable to get Standard Quiz section locator");
				}
			} else {
				logger.info("Unable to get both sections in quiz");
			}
		} catch (Exception e) {
			logger.info("Unable to verifyStandardQuizzesSection");
			log(logger, "Unable to verifyStandardQuizzesSection");
			throw new DriverException("Unable to verifyStandardQuizzesSection", e);
		}
		logger.info("Method: verifyStandardQuizzesSection End flag --> " + flag);
		return flag;
	}

	/**
	 * Method used to verify Accessed Status, it will check whether it is Never,
	 * 
	 * @return
	 * @throws Exception
	 */
	public String verifyAccessedStatus() throws Exception {
		logger.info("Method : verifyAccessedStatus Start");
		String accessValue = null;
		try {
			// Dynamic and Standard Quizzes section.
			List<WebElement> element = baseHandler.findElements(
					PropertiesRepository.getString("newati.myati.test.tab.ls.dynamic.standard.quizzes.section.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				WebElement dynamicQuizElement = element.get(0);
				List<WebElement> timeAccess = dynamicQuizElement.findElements(By.cssSelector(
						PropertiesRepository.getString("new-atitesting.nclex.card.back.quiz.bank.accessed.loc")));
				if (CollectionUtils.isNotEmpty(timeAccess)) {
					accessValue = timeAccess.get(0).getText();
				}
			} else {
				logger.info("Unable to get dynamic quizzes section locator");
			}
		} catch (Exception e) {
			logger.info("Unable to ");
			log(logger, "Unable to ");
			throw new DriverException("Unable to ", e);
		}
		logger.info("Method: End accessValue --> " + accessValue);
		return accessValue;
	}

	/**
	 * Method used to get all module names and verifying whether it is in ascending
	 * order.
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean verifyModuleNameInAscendingOrder() throws Exception {
		logger.info("Method : Start");
		boolean flag = false;
		List<String> beforeSort = new ArrayList<String>();
		List<String> afterSort = new ArrayList<String>();
		try {
			// Dynamic and Standard Quizzes section.
			List<WebElement> element = baseHandler.findElements(
					PropertiesRepository.getString("newati.myati.test.tab.ls.dynamic.standard.quizzes.section.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				WebElement standardQuizElement = element.get(1);
				// Getting list of all module name under Standard Quizzes section.
				List<WebElement> allModuleNameList = standardQuizElement
						.findElements(By.cssSelector(PropertiesRepository
								.getString("newati.myati.test.tab.ls.standard.quizzes.all.modules.name.list.loc")));
				if (CollectionUtils.isNotEmpty(allModuleNameList)) {
					int size = allModuleNameList.size();
					for (int index = 0; index < size; index++) {
						beforeSort.add(allModuleNameList.get(index).getText());
						afterSort.add(allModuleNameList.get(index).getText());
					}
				}
				// Sorting
				if (CollectionUtils.isNotEmpty(beforeSort) && CollectionUtils.isNotEmpty(afterSort)) {
					Collections.sort(afterSort, String.CASE_INSENSITIVE_ORDER);
					if (beforeSort.equals(afterSort)) {
						flag = true;
					}
				}

			} else {
				logger.info("Unable to get Standard Quiz section locator");
			}
		} catch (Exception e) {
			logger.info("Unable to ");
			log(logger, "Unable to ");
			throw new DriverException("Unable to ", e);
		}
		logger.info("Method: End flag --> " + flag);
		return flag;
	}

	/**
	 * Method to click Dynamic Quizzes button
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws Exception
	 */
	public boolean clickDynamicQuizzesButton(String buttonName) throws Exception {
		logger.info("Method : clickDynamicQuizzesButton Start");
		boolean flag = false;
		try {
			// Dynamic and Standard Quizzes section.
			List<WebElement> element = baseHandler.findElements(
					PropertiesRepository.getString("newati.myati.test.tab.ls.dynamic.standard.quizzes.section.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				WebElement dynamicQuizElement = element.get(0);
				// Clicking on Button (Adaptive Quizzes/ Quiz By Category/ Quizzes & Results)
				List<WebElement> buttonElement = dynamicQuizElement.findElements(By.cssSelector(
						PropertiesRepository.getString("newati.myati.test.tab.ls.dynamic.quizzes.button.loc")));
				if (CollectionUtils.isNotEmpty(buttonElement)) {
					int size = buttonElement.size();
					for (int index = 0; index < size; index++) {
						if (PropertiesRepository
								.getString("newati.myati.test.tab.ls.dynamic.quizzes.button.adaptive.quizzes.value")
								.equalsIgnoreCase(buttonElement.get(index).getText().trim())) {
							// Clicking on button based on parameter
							buttonElement.get(index).click();
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
							flag = true;
							break;
						} else {
							logger.info("Unable to verify button in Dynamic Quizzes Section");
						}
					}
				}
			} else {
				logger.info("Unable to get both sections in quiz");
			}
		} catch (Exception e) {
			logger.info("Unable to verifyDynamicQuizzesSection");
			log(logger, "Unable to verifyDynamicQuizzesSection");
			throw new DriverException("Unable to verifyDynamicQuizzesSection", e);
		}
		logger.info("Method: verifyDynamicQuizzesSection End flag --> " + flag);
		return flag;
	}

	/**
	 * Method used to verify LS Recent activity.
	 * 
	 * @author saravanan.jothimani
	 * @param tutorialName
	 * @param moduleName
	 * @return
	 * @throws Exception
	 */
	public boolean verifyLSRecentActivity(String tutorialName, String moduleName) throws Exception {
		//logger.info("Method : verifyLSRecentActivity Start");
		boolean flag = false;
		try {
			// Get all recent activities.
			List<WebElement> element = baseHandler
					.findElements("a[class='ra-row rb-col-main focus-element-flag']");
			if (CollectionUtils.isNotEmpty(element)) {

				for (WebElement recentElement : element) {
					// Getting NCLEX Name.
					List<WebElement> nclexName = recentElement.findElements(
							By.cssSelector("span[data-bind$='ModuleName : ProductName']"));
					if (CollectionUtils.isNotEmpty(nclexName)) {
						for (WebElement nclexNameElement : nclexName) {
							if (nclexNameElement.getText().equalsIgnoreCase(tutorialName)) {
								// Getting NCLEX module name
								List<WebElement> nclexModuleName = recentElement
										.findElements(By.cssSelector("span[data-bind='html:ModuleName']"));
								if (CollectionUtils.isNotEmpty(nclexModuleName)) {
									for (WebElement nclexModuleNameElement : nclexModuleName) {
										if (nclexModuleNameElement.getText().equalsIgnoreCase(moduleName)) {
											// Getting Status.
											List<WebElement> nclexStatus = recentElement
													.findElements(By.cssSelector("div[class^='status-in-progress']"));
											if (CollectionUtils.isNotEmpty(nclexStatus)
													&& nclexStatus.get(0).getText().equalsIgnoreCase("In Progress")) {
												flag = true;
												/*// Getting NCLEX prep
												List<WebElement> nclexPrep = recentElement
														.findElements(By.cssSelector(PropertiesRepository.getString(
																"new.atitestig.nclex.recent.activity.nclex.prep.loc")));
												if (CollectionUtils.isNotEmpty(nclexPrep)
														&& nclexPrep.get(0).getText().equalsIgnoreCase("NCLEX PREP")) {
													flag = true;
												} else {
													logger.info("Unable to verify nclex prep value");
												}*/
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
			logger.info("Unable to verifyLSRecentActivity");
			log(logger, "Unable to verifyLSRecentActivity");
			throw new DriverException("Unable to verifyLSRecentActivity", e);
		}
		logger.info("Method: verifyLSRecentActivity End flag --> " + flag);
		return flag;
	}

	public boolean verifyAssessmentTypeAndName(String assessmentType, String assessmentName) throws Exception {
		logger.info("Method: verifyAssessmentTypeAndName Starts");
		boolean flag = false;
		try {
			if (baseHandler.isDisplayed(
					PropertiesRepository.getString("asmt.myati.test.tab.verify.details.are.displaye.loc"))) {
				List<WebElement> pracProcCardElement = baseHandler.findElements(
						PropertiesRepository.getString("asmt.myati.test.tab.verify.details.are.displaye.loc"));
				if (CollectionUtils.isNotEmpty(pracProcCardElement)) {
					int size = pracProcCardElement.size();
					for (int index = 0; index < size; index++) {
						WebElement assessmentTypeElement = pracProcCardElement.get(index);
						// Validating Assessment Type
						WebElement assessmentTypeSingleElement = assessmentTypeElement
								.findElement(By.cssSelector("header span"));
						if (assessmentTypeSingleElement != null) {
							String assessmentTypeValue = assessmentTypeSingleElement.getText().trim();
							if (StringUtils.isNotEmpty(assessmentTypeValue)
									&& assessmentTypeValue.equalsIgnoreCase(assessmentType)) {
								// Validating Assessment Name
								WebElement assessmentNameElement = assessmentTypeElement
										.findElement(By.cssSelector("div section div[class='description']"));
								if (assessmentNameElement != null) {
									String assessmentNameValue = assessmentNameElement.getText().trim()
											.replaceAll("\\r\\n|\\r|\\n", " ");
									if (StringUtils.isNotEmpty(assessmentNameValue)
											&& assessmentNameValue.equalsIgnoreCase(assessmentName)) {
										// Getting Quizzes Button name
										// List<WebElement> navElement =
										// assessmentTypeElement.findElement(By.cssSelector("nav div"));
										List<WebElement> buttonNameElement = assessmentTypeElement
												.findElements(By.cssSelector(
														"nav div a[class='button primary-button cardflip focus-element-flag'] span"));
										if (CollectionUtils.isNotEmpty(buttonNameElement) && buttonNameElement.get(0)
												.getText().trim().equalsIgnoreCase("Quizzes")) {
											// Getting Access Details.
											List<WebElement> accessedElement = assessmentTypeElement
													.findElements(By.cssSelector("footer span span"));
											if (CollectionUtils.isNotEmpty(accessedElement)
													&& accessedElement.get(0).isDisplayed()) {
												// Verifying info icon details. 
												WebElement iconElement = assessmentTypeElement
														.findElement(By.cssSelector("header a"));
												if(iconElement != null) {
													iconElement.click();
													// Verify info details. 
													List<WebElement> infoName = baseHandler.findElements("div[id='productInfoDialog'] div[data-bind='text: Name']");
													if(CollectionUtils.isNotEmpty(infoName) && infoName.get(0).getText().trim().equalsIgnoreCase(PropertiesRepository.getString("newati.myati.assessment.quiz.learning.system.pn.3.0.value"))) {
														flag = true;
														break;
													} else {
														logger.info("Unable to verify info name");
													}
												} else {
													logger.info("Unable to verify info icon");
												}
												
											} else {
												logger.info("Unable to verify footer accessed value");
											}
										} else {
											logger.info("Unable to verify Quizzed button name");
										}
									} else {
										logger.info("Unable to verify LS name");
									}
								}
							} else {
								logger.info("Unable to verify LS Type");
							}
						}
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verifyAssessmentTypeAndName");
			log(logger, "Unable to verifyAssessmentTypeAndName");
			throw new DriverException("Unable to verifyAssessmentTypeAndName", e);
		}
		logger.info("Method: verifyAssessmentTypeAndName End flag --> " + flag);
		return flag;
	}

	/**
	 * Method used to verify LS Assessment count and name. 
	 * 
	 * @author saravanan.jothimani
	 * @param assessmentType
	 * @param assessmentName
	 * @return
	 * @throws Exception
	 */
	public boolean verifyAssessmentNameDisplayed(String assessmentType, List<String> assessmentName) throws Exception {
		logger.info("Method: verifyAssessmentNameDisplayed Starts");
		boolean flag = false;
		List<String> uiAssessmentNameList = new ArrayList<String>();
		try {
			if (baseHandler.isDisplayed(
					PropertiesRepository.getString("asmt.myati.test.tab.verify.details.are.displaye.loc"))) {
				List<WebElement> pracProcCardElement = baseHandler.findElements(
						PropertiesRepository.getString("asmt.myati.test.tab.verify.details.are.displaye.loc"));
				if (CollectionUtils.isNotEmpty(pracProcCardElement)) {
					int size = pracProcCardElement.size();
					for (int index = 0; index < size; index++) {
						WebElement assessmentTypeElement = pracProcCardElement.get(index);
						// Validating Assessment Type
						WebElement assessmentTypeSingleElement = assessmentTypeElement
								.findElement(By.cssSelector("header span"));
						if (assessmentTypeSingleElement != null) {
							String assessmentTypeValue = assessmentTypeSingleElement.getText().trim();
							if (StringUtils.isNotEmpty(assessmentTypeValue)
									&& assessmentTypeValue.equalsIgnoreCase(assessmentType)) {
								// Validating Assessment Name
								WebElement assessmentNameElement = assessmentTypeElement
										.findElement(By.cssSelector("div section div[class='description']"));
								if (assessmentNameElement != null) {
									String assessmentNameValue = assessmentNameElement.getText().trim()
											.replaceAll("\\r\\n|\\r|\\n", " ");
									uiAssessmentNameList.add(assessmentNameValue);
								}
							} else {
								logger.info("Unable to verify LS Type");
							}
						}
					}
					Collections.sort(uiAssessmentNameList);
			        Collections.sort(assessmentName);
					// Verifying Quiz name displayed on UI. 
					if(uiAssessmentNameList.equals(assessmentName)) {
						flag = true;
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verifyAssessmentNameDisplayed");
			log(logger, "Unable to verifyAssessmentNameDisplayed");
			throw new DriverException("Unable to verifyAssessmentNameDisplayed", e);
		}
		logger.info("Method: verifyAssessmentNameDisplayed End flag --> " + flag);
		return flag;
	}
	
	public boolean verifyCustomizeExamSection() throws Exception {
		logger.info("Method : verifyCustomizeExamSectionStart");
		boolean flag = false;
		try {
			switchToLSFrameInQuizPage();
			baseHandler.waitToBeDisplayed("h1[class='box-heading']");
			List<WebElement> element = baseHandler.findElements("h1[class='box-heading']");
			if (CollectionUtils.isNotEmpty(element)) {
				if (element.get(0).getText().equalsIgnoreCase("Customize Exam")) {
					flag = true;
				}
			}
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to verifyCustomizeExamSection");
			log(logger, "Unable to verifyCustomizeExamSection");
			throw new DriverException("Unable to verifyCustomizeExamSection", e);
		}
		logger.info("Method: verifyCustomizeExamSection End flag --> " + flag);
		return flag;
	}

	public void switchToLSFrameInQuizPage() throws Exception {
		// logger.info("Method : switchToLSFrameInQuizPage Start");
		boolean flag = false;
		try {
			final List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
			int size = iframes.size();
			String[] frames = null;
			;
			for (int i = 0; i < size; i++) {
				frames = new String[size];
				String id = iframes.get(i).getAttribute("name");
				if (!id.equals(null) && id.length() > 0) {
					frames[i] = iframes.get(i).getAttribute("name");
				}
			}
			logger.info("Printing all frames --> " + frames);
			windowHandler.switchToFrame(frames[0]);
			final List<WebElement> secondframesElement = driver.findElements(By.tagName("iframe"));
			int secondsize = iframes.size();
			String[] secondframes = null;
			;
			for (int i = 0; i < secondsize; i++) {
				secondframes = new String[size];
				String id = secondframesElement.get(i).getAttribute("name");
				if (!id.equals(null) && id.length() > 0) {
					secondframes[i] = secondframesElement.get(i).getAttribute("name");
				}
			}

			windowHandler.switchToFrame(secondframes[0]);
		} catch (Exception e) {
			logger.info("Unable to switchToLSFrameInQuizPage");
			log(logger, "Unable to switchToLSFrameInQuizPage");
			throw new DriverException("Unable to switchToLSFrameInQuizPage", e);
		}
		logger.info("Method: switchToLSFrameInQuizPage End flag --> " + flag);
	}
	
	public boolean clickModuleButtonByPracticeName(String assessmentName) throws Exception {
		logger.info("Method: clickModuleButtonByPracticeName Start ");
		boolean clickFlag = false;
		boolean flag = false;
		try {
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			List<WebElement> moduleList = baseHandler
					.findElements("section[id='tabs-2'] .flipper");
			if (moduleList != null && moduleList.size() > 0) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					WebElement element = moduleList.get(i)
							.findElement(By.cssSelector("section div[class='description']"));
					if (assessmentName.equalsIgnoreCase(element.getText())) {
						List<WebElement> buttonElement = moduleList.get(i)
								.findElements(By.cssSelector(
										"nav div a[class='button primary-button button-focus focus-element-flag']"));
						for(WebElement moduleElement : buttonElement) {
							if(buttonElement != null) {
								String styleValue = moduleElement.getAttribute("style");
								if(!styleValue.equalsIgnoreCase("display: none;")) {
									((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",moduleElement);
									
									moduleElement.click();
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									clickFlag = true;
									break;
								}
							}
						}
					}if(clickFlag) {
						flag = true;
						break;
					}
				} 
			}
		} catch (Exception e) {
			logger.info("Unable to clickModuleButtonByPracticeName");
			log(logger, "Unable to clickModuleButtonByPracticeName");
			throw new Exception("Unable to clickModuleButtonByPracticeName");
		}

		logger.info("Method: clickModuleButtonByPracticeName End flag --> " + flag);
		return flag;
	}
}
