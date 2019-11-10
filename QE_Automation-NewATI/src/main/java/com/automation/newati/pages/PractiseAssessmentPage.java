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
import org.openqa.selenium.interactions.Actions;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.ButtonHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;

public class PractiseAssessmentPage extends PractiseAssessmentPage2 {

	private Logger logger = LogManager.getLogger(this.getClass());
	private BaseHandler baseHandler;
	private WindowHandler windowHandler;
	private ButtonHandler buttonHandler;
	private boolean flag = false;
	int flaggedQuestionCount = 0;

	public PractiseAssessmentPage(WebDriver webDriver) {
		super(webDriver);
		baseHandler = new BaseHandler(driver);
		windowHandler = new WindowHandler(driver);
		buttonHandler = new ButtonHandler(driver);
	}

	public void clickAssessment(String assessmentName) throws Exception {
		logger.info("Method: clickAssessment Starts");
		boolean breakFlag = false;
		try {
			// Getting all assessment list.
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.test.all.assessment"));
			if (CollectionUtils.isNotEmpty(element) && element.size() > 0) {
				int size = element.size();
				for (int index = 0; index < size; index++) {
					// Getting Section
					WebElement section = element.get(index).findElement(
							By.cssSelector(PropertiesRepository.getString("new-atitesting.common.section")));
					if (section != null) {
						// Getting Assessment Name.
						StringBuffer sb = new StringBuffer();
						// sb.append(PropertiesRepository.getString("new-atitesting.common.div"));
						sb.append(PropertiesRepository.getString("new-atitesting.test.default.container"));
						sb.append(" ");
						sb.append(PropertiesRepository.getString("new-atitesting.common.section"));
						sb.append(" ");
						sb.append(PropertiesRepository.getString("new-atitesting.common.div"));
						String practiceName = section.findElement(By.cssSelector(sb.toString())).getText();
						if (StringUtils.isNotEmpty(practiceName)) {
							// Verifying Assessment Name
							if (practiceName.equalsIgnoreCase(assessmentName)) {
								StringBuffer sbNav = new StringBuffer();
								sbNav.append(PropertiesRepository.getString("new-atitesting.test.default.container"));
								sbNav.append(" ");
								sbNav.append(PropertiesRepository.getString("new-atitesting.common.nav"));
								WebElement buttonElement = section.findElement(By.cssSelector(sbNav.toString()));

								// For clicking Begin and Continue Button.
								List<WebElement> divBeginContinueButton = buttonElement.findElements(By.cssSelector(
										PropertiesRepository.getString("new-atitesting.test.assessment.button")));
								List<WebElement> retakeButton = buttonElement.findElements(
										By.cssSelector(".button.secondary-button.button-focus.focus-element-flag"));
								if (CollectionUtils.isNotEmpty(divBeginContinueButton)
										& divBeginContinueButton.get(0).isDisplayed()) {
									int styleSize = divBeginContinueButton.size();
									for (int styleIndex = 0; styleIndex < styleSize; styleIndex++) {
										String styleValue = null;
										WebElement beginContinueStyleElement = divBeginContinueButton.get(styleIndex);
										if (beginContinueStyleElement != null) {
											styleValue = beginContinueStyleElement.getAttribute("style");
											if (StringUtils.isEmpty(styleValue)) {
												beginContinueStyleElement.click();
												breakFlag = true;
												break;
											}
										}
									}
								} else {
									int styleSize = retakeButton.size();
									for (int styleIndex = 0; styleIndex < styleSize; styleIndex++) {
										String styleValue = null;
										WebElement beginContinueStyleElement1 = retakeButton.get(styleIndex);
										if (beginContinueStyleElement1 != null) {
											styleValue = beginContinueStyleElement1.getAttribute("style");
											if (!styleValue.isEmpty()) {
												beginContinueStyleElement1.click();
												breakFlag = true;
												break;
											}
										}
									}
								}
								/*
								 * List<WebElement> divButtonList =
								 * buttonElement.findElements(By.cssSelector("div[id='selectInstanceButton']"));
								 * if(CollectionUtils.isNotEmpty(divButtonList) && divButtonList.size() == 1) {
								 * // If Button has multiple Instance WebElement selectInstanceButton =
								 * divButtonList.get(0); if(selectInstanceButton != null) {
								 * selectInstanceButton.findElement(By.
								 * cssSelector("a[class='button primary-button button-focus focus-element-flag select-instance']"
								 * )).getText();
								 * 
								 * } } else { // It has only one product.
								 * 
								 * }
								 */
							}
						}
					}
					if (breakFlag) {
						break;
					}
				}
			}
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		} catch (Exception e) {
			logger.info("Unable to click Assessment");
			log(logger, "Unable to click Assessment");
			throw new DriverException("Unable to click Assessment", e);
		}
		logger.info("Method: clickAssessment End ");
	}

	/**
	 * Method used to click Proctor Assessment based on name.
	 * 
	 * 
	 * @param assessmentName
	 * @throws Exception
	 */
	public boolean clickProctorAssessment(String assessmentName) throws Exception {
		boolean flag = false;
		logger.info("Method : clickProctorAssessment Start ");
		try {
			List<WebElement> proctorMainElement = baseHandler
					.findElements("section[class='proctored-container'] .card.proctored-assessment.front");
			if (CollectionUtils.isNotEmpty(proctorMainElement)) {
				int size = proctorMainElement.size();
				for (int index = 0; index < size; index++) {
					WebElement proctorNameElement = proctorMainElement.get(index)
							.findElement(By.cssSelector(".description"));
					if (proctorNameElement != null) {
						if (assessmentName.equalsIgnoreCase(proctorNameElement.getText().trim())) {
							List<WebElement> proctorElement = proctorMainElement.get(index).findElements(
									By.cssSelector("a[class='button primary-button button-focus focus-element-flag']"));
							if (CollectionUtils.isNotEmpty(proctorElement)) {
								int subSize = proctorElement.size();
								for (int subIndex = 0; subIndex < subSize; subIndex++) {
									String proctorElementStyle = proctorElement.get(subIndex).getAttribute("style");
									if (StringUtils.isEmpty(proctorElementStyle)) {
										proctorElement.get(subIndex).click();
										waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
										flag = true;
										break;
									}
								}
							}
						}
					}
					if (flag) {
						break;
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to click Test Tab Assessment Button");
			log(logger, "Unable to click Test Tab Assessment Button");
			throw new DriverException("Unable to click Test Tab Assessment Button", e);
		}
		logger.info("Method : clickProctorAssessment End flag --> " + flag);
		return flag;
	}

	/**
	 * Method used to click Proctor Assessment based on name.
	 * 
	 * 
	 * @param assessmentName
	 * @throws Exception
	 */
	public boolean clickProctorAssessmentMoreThankOne(String assessmentName) throws Exception {
		boolean flag = false;
		logger.info("Method : clickProctorAssessmentMoreThankOne Start ");
		try {
			List<WebElement> proctorMainElement = baseHandler
					.findElements("section[class='proctored-container'] .card.proctored-assessment.front");
			List<WebElement> proctorMainElement2 = baseHandler
					.findElements("ul[id='testApplications'] .card.proctored-assessment.front");
			if (proctorMainElement != null) {
				int size = proctorMainElement.size();
				for (int index = 0; index < size; index++) {
					WebElement proctorNameElement = proctorMainElement.get(index)
							.findElement(By.cssSelector(".description"));
					if (proctorNameElement != null) {
						if (assessmentName.equalsIgnoreCase(proctorNameElement.getText().trim())) {
							List<WebElement> proctorElement = proctorMainElement.get(index).findElements(
									By.cssSelector("a[class='button primary-button button-focus focus-element-flag']"));
							if (CollectionUtils.isNotEmpty(proctorElement)) {
								int subSize = proctorElement.size();
								for (int subIndex = 0; subIndex < subSize; subIndex++) {
									String proctorElementStyle = proctorElement.get(subIndex).getAttribute("style");
									if (StringUtils.isEmpty(proctorElementStyle)) {
										proctorElement.get(subIndex).click();
										waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
										flag = true;
										break;
									}
								}
							}
						}
					}
					if (flag) {
						break;
					}
				}
			} else if (CollectionUtils.isNotEmpty(proctorMainElement2)) {
				int size = proctorMainElement2.size();
				for (int index = 0; index < size; index++) {
					WebElement proctorNameElement2 = proctorMainElement2.get(index)
							.findElement(By.cssSelector(".description"));
					if (proctorNameElement2 != null) {
						if (assessmentName.equalsIgnoreCase(proctorNameElement2.getText().trim())) {
							WebElement proctorElement2 = proctorMainElement2.get(index).findElement(
									By.cssSelector("a[class='button primary-button button-focus focus-element-flag']"));
							if (proctorElement2 != null) {
								proctorElement2.click();
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								flag = true;
								break;
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
		logger.info("Method : clickProctorAssessmentMoreThankOne End flag --> " + flag);
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
	 *            - boolean value Any button(false) or specific button(true) like
	 *            (Begin/ Continue/ Retake)
	 * @param buttonName
	 *            - If anyButtonName false, it click on button ddisplayed. if
	 *            anyButtonName true, it verifies the button and click
	 * @throws Exception
	 */
	public void clickTestTabAssessmentButton(String assessmentType, String assessmentName) throws Exception {
		logger.info("Method: clickTestTabAssessmentButton Starts");
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
					for (int index = 0; index < size; index++) {
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
										if (assessmentTypeElement.findElement(By.cssSelector(
												PropertiesRepository.getString("asmt.tutorial.retakebutton.loc")))
												.isDisplayed()) {
											assessmentTypeElement.findElement(By.cssSelector(
													PropertiesRepository.getString("asmt.tutorial.retakebutton.loc")))
													.click();
											break;
										}
										// Getting Button name
										List<WebElement> assessmentAllButton = assessmentTypeElement
												.findElements(By.cssSelector(PropertiesRepository
														.getString("asmt.myati.test.tab.assessment.button.loc")));
										if (CollectionUtils.isNotEmpty(assessmentAllButton)) {
											int sizeButon = assessmentAllButton.size();
											for (int indexButon = 0; indexButon < sizeButon; indexButon++) {
												if (breakFlag) {
													break;
												}
												WebElement singleButtonElement = assessmentAllButton.get(indexButon);
												String buttonNameValueWithDiv = singleButtonElement
														.getAttribute("innerHTML");
												String buttonNameValue = buttonNameValueWithDiv.substring(0,
														buttonNameValueWithDiv.indexOf("<"));
												if (StringUtils.isNotEmpty(buttonNameValue)) {
													// It will check for style
													// attribute where it is
													// null, it click on that
													// button.
													String styleAttribute = singleButtonElement.getAttribute("style");
													boolean styleValue = "display: none;"
															.equalsIgnoreCase(styleAttribute);
													// Checking for
													// anyButtonName boolean
													// value

													if (!styleValue) {
														if (singleButtonElement.isDisplayed()) {
															((JavascriptExecutor) driver).executeScript(
																	"arguments[0].scrollIntoView(true);",
																	singleButtonElement);
															singleButtonElement.click();
															waitUntillLoadingImageIsDisappeared(
																	"new-atitesting.peasewait.bufferLoc");
														}
														if (verifySelectInstanceContainer(false)) {
															boolean selectInstanceFlag = verifySelectInstanceContainer(
																	true);
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
													 * else { log(logger, "Button name is not matched" ); }
													 */
											}
										}
									} /*
										 * else { log(logger, "Assessment Name is not matched"); breakFlag = true; }
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
			throw new DriverException("Unable to click Test Tab Assessment Button", e);
		}

		logger.info("Method: clickTestTabAssessmentButton End");
	}

	private boolean verifySelectInstanceContainer(boolean... click) throws Exception {
		logger.info("Method: verifySelectInstanceContainer Starts");
		boolean flag = false;
		try {
			List<WebElement> selectInstanceElement = baseHandler.findElements(
					PropertiesRepository.getString("asmt.myati.test.tab.assessment.button.multiple.assessment.loc"));
			if (CollectionUtils.isNotEmpty(selectInstanceElement) && selectInstanceElement.size() > 0) {
				flag = true;
				if (flag && click[0]) {
					List<WebElement> allElements = selectInstanceElement.get(0)
							.findElements(By.cssSelector("section .duplicate-action div"));
					if (CollectionUtils.isNotEmpty(allElements)) {
						int size = allElements.size();
						for (int index = 0; index < size; index++) {
							WebElement actualButtonElement = allElements.get(index).findElement(By.cssSelector("a"));
							String styleAttribute = actualButtonElement.getAttribute("style");
							boolean styleValue = "display: none;".equalsIgnoreCase(styleAttribute);
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
			throw new DriverException("Unable to verify Select Instance Container", e);
		}
		logger.info("Method: verifySelectInstanceContainer End flag --> " + flag);
		return flag;
	}

	public void clickModuleButtonByName(String assessmentName) throws Exception {
		logger.info("Method: clickModuleButtonByName Start ");
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
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
								moduleList.get(i).findElement(By.cssSelector(
										"nav div a[class='button primary-button cardflip focus-element-flag']")));
						moduleList.get(i)
								.findElement(By.cssSelector(
										"nav div a[class='button primary-button cardflip focus-element-flag']"))
								.click();
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						break;
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to clickModuleButtonByName");
			log(logger, "Unable to clickModuleButtonByName");
			throw new Exception("Unable to clickModuleButtonByName");
		}

		logger.info("Method: clickModuleButtonByName End");
	}

	public boolean clickModuleButtonByName(String assessmentName, boolean click) throws Exception {
		logger.info("Method: clickModuleButtonByName Start ");
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
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
								moduleList.get(i).findElement(By.cssSelector(
										"nav div a[class='button primary-button cardflip focus-element-flag']")));
						if (click) {
							moduleList.get(i)
									.findElement(By.cssSelector(
											"nav div a[class='button primary-button cardflip focus-element-flag']"))
									.click();
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
							flag = true;
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to clickModuleButtonByName");
			log(logger, "Unable to clickModuleButtonByName");
			throw new Exception("Unable to clickModuleButtonByName");
		}
		logger.info("Method: clickModuleButtonByName End flag --> " + flag);
		return flag;
	}

	public void clickModuleButtonByNameEbook(String assessmentName) throws Exception {
		logger.info("Method: clickModuleButtonByName Start ");
		try {
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			List<WebElement> moduleList = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.all.modules.loc"));
			if (moduleList != null && moduleList.size() > 0) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					WebElement element = moduleList.get(i)
							.findElement(By.cssSelector("section div[class='description']"));
					if (assessmentName.equalsIgnoreCase(element.getText())) {
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
								moduleList.get(i).findElement(By.cssSelector(
										"nav div a[class='button primary-button cardflip focus-element-flag']")));
						moduleList.get(i)
								.findElement(By.cssSelector(
										"nav div a[class='button primary-button cardflip focus-element-flag']"))
								.click();
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						break;
					}
				}
			}
		} catch (Exception e) {
			throw new Exception("Unable to click on Learn Tab module");
		}

		logger.info("Method: clickModuleButtonByName End");
	}

	public boolean verifyAvailableDaysForAssessment(String assessmentName) throws Exception {
		logger.info("Method: clickModuleButtonByName Start");
		try {
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			List<WebElement> moduleList = baseHandler
					.findElements("#tabs-2 ul[id='testApplications'] li section div[class='description']");

			if (moduleList != null && moduleList.size() > 0) {
				for (int i = 0; i < moduleList.size(); i++) {
					if (assessmentName.equalsIgnoreCase(moduleList.get(i).getText().trim())) {
						List<WebElement> beginOrContinueButtonLoc = driver.findElements(
								By.cssSelector("#tabs-2 ul[id='testApplications'] li nav[class='actions']"));
						String text = beginOrContinueButtonLoc.get(i)
								.findElement(By.cssSelector("a.default-button-disabled:nth-child(6)")).getText();
						if (StringUtils.isNotEmpty(text)) {
							return true;
						}

						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
					}
				}
			}
		} catch (Exception e) {
			throw new Exception("Unable to click on Learn Tab module");
		}

		logger.info("Method: clickModuleButtonByName End");
		return false;

	}

	/**
	 * Verify Retake disable funcaitonality.
	 * 
	 * @param assessmentName
	 * @return
	 * @throws Exception
	 */
	public boolean verifyRetakeDisabledFunctionality(String assessmentName) throws Exception {
		logger.info("Method: clickModuleButtonByName Start");
		try {
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			List<WebElement> moduleList = baseHandler
					.findElements("#tabs-2 ul[id='testApplications'] li section div[class='description']");
			// List<WebElement> moduleList =
			// baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.all.assessment"));
			if (CollectionUtils.isNotEmpty(moduleList)) {
				for (int i = 0; i < moduleList.size(); i++) {
					if (assessmentName.equalsIgnoreCase(moduleList.get(i).getText().trim())) {
						List<WebElement> beginOrContinueButtonLoc = driver.findElements(
								By.cssSelector("#tabs-2 ul[id='testApplications'] li nav[class='actions']"));
						String attribute = beginOrContinueButtonLoc.get(i)
								.findElement(By.cssSelector("a.default-button-disabled:nth-child(6)"))
								.getAttribute("class");
						if (attribute.contains("default-button-disabled")) {
							flag = true;
						}

					}
				}
			}
		} catch (Exception e) {
			throw new Exception("Unable to click on Learn Tab module");
		}

		logger.info("Method: clickModuleButtonByName End");
		return flag;
	}

	/**
	 * This method is used to click on module of proctored assessments
	 * 
	 * @param assessmentName
	 * @throws Exception
	 */
	public void clickProctoredModuleButtonByName(String assessmentName) throws Exception {
		logger.info("Method: clickProctoredModuleButtonByName Start");
		try {
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			List<WebElement> moduleList = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.proctored.test.all.assessment"));
			if (moduleList != null && moduleList.size() > 0) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					WebElement element = moduleList.get(i).findElement(By.cssSelector(".description"));
					if (assessmentName.equalsIgnoreCase(element.getText())) {
						List<WebElement> beginOrContinueButtonLoc = driver.findElements(By.cssSelector(
								"#monitoredProducts section[class='card proctored-assessment front'] nav div:nth-of-type(1)>a"));
						beginOrContinueButtonLoc.get(i).click();
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						// Thread.sleep(10000);
						break;
					}
				}
			}
		} catch (Exception e) {
			throw new Exception("Unable to click on Learn Tab module");
		}

		logger.info("Method: clickProctoredModuleButtonByName End");
	}

	public void verifyCalculatorFunctionality() {
		windowHandler.switchToFrame("assessmentFrame");
		baseHandler.findElement(".calculator-button.focus-element-flag").click();
		windowHandler.switchToMainWindow();
		List<WebElement> elements = baseHandler.findElements(".calculator-container section");
		List<WebElement> elements2 = elements.get(3).findElements(By.tagName("a"));
		List<WebElement> elements3 = elements.get(6).findElements(By.tagName("a"));
		elements2.get(0).click();
		elements3.get(elements2.size() - 1).click();
		elements2.get(1).click();
		baseHandler.findElement("a[data-atiid='equalsAction']").click();
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).perform();
	}

	/**
	 * Method used to verify Available time in card front.
	 * 
	 * @param assessmentName
	 * @return
	 * @throws Exception
	 */
	public boolean verifyTimeBetweenAttempts(String assessmentName) throws Exception {
		logger.info("Method: verifyTimeBetweenAttempts Starts");
		boolean flag = false;
		try {
			// Getting all assessment list.
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.test.all.assessment"));
			if (CollectionUtils.isNotEmpty(element) && element.size() > 0) {
				int size = element.size();
				for (int index = 0; index < size; index++) {
					// Getting Section
					WebElement section = element.get(index).findElement(
							By.cssSelector(PropertiesRepository.getString("new-atitesting.common.section")));
					if (section != null) {
						// Getting Assessment Name.
						StringBuffer sb = new StringBuffer();
						// sb.append(PropertiesRepository.getString("new-atitesting.common.div"));
						sb.append(PropertiesRepository.getString("new-atitesting.test.default.container"));
						sb.append(" ");
						sb.append(PropertiesRepository.getString("new-atitesting.common.section"));
						sb.append(" ");
						sb.append(PropertiesRepository.getString("new-atitesting.common.div"));
						String practiceName = section.findElement(By.cssSelector(sb.toString())).getText();
						if (StringUtils.isNotEmpty(practiceName)) {
							// Verifying Assessment Name
							if (practiceName.equalsIgnoreCase(assessmentName)) {
								List<WebElement> disabledElement = section.findElements(By.cssSelector(
										".test-card-front-wrapper.default-container .actions div .disabled-message"));
								if (CollectionUtils.isNotEmpty(disabledElement)) {
									String disabledMsg = disabledElement.get(0).getText().trim();
									if (StringUtils.isNotEmpty(disabledMsg) && disabledMsg.contains("Available")) {
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
			throw new DriverException("unable to verifyTimeBetweenAttempts", e);
		}
		logger.info("verifyTimeBetweenAttempts End flag --> " + flag);
		return flag;
	}

	/**
	 * Method used to click on assessment name and verify source.
	 * 
	 * @param assessmentName
	 * @param infoSource
	 * @return
	 * @throws Exception
	 */
	public boolean verifyProctorInfoSource(String assessmentName, String infoSource) throws Exception {
		logger.info("Method: verifyProctorInfoSource Starts");
		boolean flag = false;
		try {
			// Will list all practice assessment
			List<WebElement> element = baseHandler.findElements("#testApplications li");
			if (CollectionUtils.isNotEmpty(element)) {
				int size = element.size();
				for (int index = 0; index < size; index++) {
					// Getting Assessment name
					List<WebElement> nameElement = element.get(index)
							.findElements(By.cssSelector("section section .description"));
					if (CollectionUtils.isNotEmpty(nameElement)) {
						String name = nameElement.get(0).getText().trim();
						if (StringUtils.isNotBlank(name) && name.equalsIgnoreCase(assessmentName)) {
							// Getting info icon and clicking it.
							WebElement infoElement = element.get(index).findElement(By.cssSelector("section header a"));
							if (infoElement != null) {
								infoElement.click();
								// Product Information Popup verification.
								windowHandler.switchToLatestWindow();
								List<WebElement> popupHeader = baseHandler.findElements(".product-info-cell div");
								if (CollectionUtils.isNotEmpty(popupHeader)) {
									WebElement sourceElement = popupHeader.get(2);
									if (sourceElement != null) {
										String source = sourceElement.getText().trim();
										if (StringUtils.isNotEmpty(source) && source.equalsIgnoreCase(infoSource)) {
											flag = true;
											break;
										}
									}
								}
							}
						}

					}

				}
			}
		} catch (Exception e) {
			logger.info("Unable to verifyProctorInfoSource");
			log(logger, "Unable to verifyProctorInfoSource");
			throw new DriverException("Unable to verifyProctorInfoSource", e);
		}
		logger.info("Method: verifyProctorInfoSource End flag --> " + flag);
		return flag;
	}

	public boolean verifyAddProductButton(String loc) throws DriverException {
		logger.info("Unable to verifyAddProductButton start");
		try {
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString(loc));
			if (CollectionUtils.isNotEmpty(element) && element.get(1).isDisplayed()) {
				return true;
			}
		} catch (Exception e) {
			logger.info("Unable to verifyAddProductButton");
			log(logger, "Unable to verifyAddProductButton");
			throw new DriverException("Unable to verifyAddProductButton", e);
		}
		logger.info("Method: verifyProctorInfoSource End");
		return false;
	}

	public boolean takeAssessment(String questionType) throws InterruptedException {
		// logger.info("Method : takeAssessment :::::::: Starts");
		boolean flaggedItems = false;
		boolean value = false;
		try {
			windowHandler.switchToFrame("assessmentFrame");
			// waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.peasewait.bufferLoc"));
			// Thread.sleep(6000);
			List<WebElement> findElements = baseHandler.findElements(
					PropertiesRepository.getString("new-atitesting.test.assessment.maxmin.questions.count"));
			String maxQtnTextNo = findElements.get(1).getText();

			// Convert String to Integer
			int maxCount = Integer.parseInt(maxQtnTextNo);

			String minQtnTextNo = findElements.get(0).getText();

			// Convert String to Integer
			int minCount = Integer.parseInt(minQtnTextNo);

			for (int i = minCount; i <= maxCount; i++) {
				boolean flag = checkElementDispalyed(
						PropertiesRepository.getString("new-atitesting.test.assessment.radio.button.loc"));
				if (flag) {
					try {
						List<WebElement> radioOptions = baseHandler.findElements(
								PropertiesRepository.getString("new-atitesting.test.assessment.radio.button.loc"));
						if (radioOptions != null) {
							if (questionType.equalsIgnoreCase("Flag") && (i == 1 || i == 4 || i == 6)) {
								WebElement findElement = baseHandler.findElement(PropertiesRepository
										.getString("new-atitesting.test.dropdown.practice.assessment.flag.button"));
								if (findElement != null) {
									findElement.click();
									findElement.sendKeys(Keys.TAB);
									findElement.sendKeys(Keys.TAB);
									findElement.sendKeys(Keys.TAB);
									findElement.sendKeys(Keys.TAB);
									findElement.sendKeys(Keys.TAB);
									findElement.sendKeys(Keys.TAB);
									findElement.sendKeys(Keys.TAB);
									// findElement.sendKeys(Keys.TAB);
									findElement.sendKeys(Keys.ENTER);
								}
								// clickButton(PropertiesRepository.getString("new-atitesting.generic.tutorial.submit.new.loc"));
								windowHandler.switchToMainWindow();
								waitUntillBufferInvisible(
										PropertiesRepository.getString("new-atitesting.peasewait.bufferLoc"));
								windowHandler.switchToFrame("assessmentFrame");
								flaggedItems = true;
							} else {
								selectRadioButtonOption(radioOptions);
							}
						}
					} catch (Exception e) {
						logger.info("Exception while selecting option");
					}

				}

				if (i == maxCount) {
					value = reviewResults(flaggedItems);
				}
			}

		} catch (DriverException e) {
			logger.info("unable to take  assessment" + e);
		}

		logger.info("Method : takeAssessment :::::::: END");
		return value;

	}

	/**
	 * 
	 * @param radioOptions
	 * @throws DriverException
	 */
	private void selectRadioButtonOption(List<WebElement> radioOptions) throws DriverException {
		try {
			WebElement element = radioOptions.get(0);
			baseHandler.waitToBeDisplayed(element);
			element.click();
			WebElement radiobuttonele = baseHandler
					.findElement(PropertiesRepository.getString("new-atitesting.test.assessment.radio.button.loc"));

			Actions actions = new Actions(driver);
			actions.moveToElement(radiobuttonele).click().release();

			clickButton(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));

			waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.peasewait.bufferLoc"));
			windowHandler.switchToMainWindow();

			waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.peasewait.bufferLoc"));

			// Switch to latest window
			windowHandler.switchToFrame("assessmentFrame");

			buttonHandler
					.clickButton(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));

			windowHandler.switchToMainWindow();

			waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.peasewait.bufferLoc"));

			// Switch to latest window
			windowHandler.switchToFrame("assessmentFrame");
		} catch (Exception e) {
			throw new DriverException();
		}

	}

	public boolean reviewResults(boolean status) throws InterruptedException, DriverException {
		logger.info("reviewResults starts");
		boolean result = false;
		try {

			// click on continue button
			buttonHandler.clickButton(PropertiesRepository.getString("new-atitesting.generic.tutorial.submit.new.loc"));

			// switch to model dialogue
			windowHandler.switchToModalDialog();
			WebElement ele = driver.findElement(
					By.cssSelector(PropertiesRepository.getString("new-atitesting.test.assessment.flag.questions")));
			String text = ele.getText();

			if (status || ele != null && StringUtils.isNotEmpty(text)) {
				// WebElement
				// ele=driver.findElement(By.cssSelector(PropertiesRepository.getString("new-atitesting.test.assessment.flag.questions")));

				/*
				 * if(ele!=null) {
				 */
				flaggedQuestionCount = Integer.parseInt(ele.getText());
				// }
				baseHandler.findElements(".button.secondary-button").get(1).click();
				// driver.findElement(By.cssSelector("#RevisitFlaggedQuestionDialog.button.secondary-button")).click();
				waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.peasewait.bufferLoc"));

				takeAssessmentForFlaggedQuestion(flaggedQuestionCount);
			}
			result = verifyLastSectionOfAssessment();

		} catch (Exception e) {
			throw new DriverException("Unable to take practice Assessment", e);
		}
		return result;
	}

	private void takeAssessmentForFlaggedQuestion(int flaggedQuestionCount2) throws DriverException {

		for (int i = 0; i < flaggedQuestionCount2; i++) {

			baseHandler.findElement(".flag-for-review-ribbon-off.focus-element-flag.flag-for-review-ribbon-on").click();
			boolean flag = checkElementDispalyed(
					PropertiesRepository.getString("new-atitesting.practice.assessment.radioBtnLoc"));

			if (flag) {

				List<WebElement> radioOptions = driver
						.findElements(By.cssSelector(".radio:nth-child(1) .question-option>label"));
				if (radioOptions != null) {
					WebElement element = radioOptions.get(0);
					baseHandler.waitToBeDisplayed(element);
					element.click();
				}

				WebElement radiobuttonele = baseHandler
						.findElement(PropertiesRepository.getString("new-atitesting.practice.assessment.radioBtnLoc"));

				Actions actions = new Actions(driver);
				actions.moveToElement(radiobuttonele).click().release();
				buttonHandler.clickButton(
						PropertiesRepository.getString("new-atitesting.learntab.tutorials.assessment.submitButton"));

				waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.peasewait.bufferLoc"));
				windowHandler.switchToMainWindow();

				waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.peasewait.bufferLoc"));

				// Switch to latest window
				windowHandler.switchToFrame("assessmentFrame");

				buttonHandler.clickButton(PropertiesRepository.getString("new-atitesting.continueBtnLoc"));

				windowHandler.switchToMainWindow();

				waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.peasewait.bufferLoc"));

				// Switch to latest window
				windowHandler.switchToFrame("assessmentFrame");
			}

		}
	}

	private boolean verifyLastSectionOfAssessment() {
		boolean result = false;
		System.out.println();
		baseHandler.findElements(".button.default-button").get(3).click();
		List<WebElement> findElements = baseHandler
				.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.maxmin.questions.count"));

		String maxQtnTextNo = findElements.get(1).getText();

		// Convert String to Integer
		int maxCount = Integer.parseInt(maxQtnTextNo);
		// Getting Current Question Number
		String minQtnTextNo = findElements.get(0).getText();

		// Convert String to Integer
		int minCount = Integer.parseInt(minQtnTextNo);
		if (maxCount == minCount) {
			result = true;
		}
		return result;

	}

	public void takePracticeAssessmentWithMultipleSections(boolean frameloc, boolean isContinuButtonEnable) {
		if (frameloc) {
			windowHandler.switchToFrame("assessmentFrame");
		}
		waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.peasewait.bufferLoc"));
		waitForAwhile(6000);
		List<WebElement> findElements = baseHandler
				.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.maxmin.questions.count"));
		String maxQtnTextNo = findElements.get(1).getText();
		int maxCount = Integer.parseInt(maxQtnTextNo);
		String minQtnTextNo = findElements.get(0).getText();
		int minCount = Integer.parseInt(minQtnTextNo);
		int count = maxCount - minCount;
		for (int i = 0; i <= count; i++) {
			waitForAwhile(5000);
			List<WebElement> eleByXpath = driver.findElements(
					By.xpath("//input[contains(@name,'MultipleChoiceQuestionGroup')]/parent::div/parent::div//label"));
			if (eleByXpath.get(1).isDisplayed()) {
				eleByXpath.get(1).click();
				waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.peasewait.bufferLoc"));
			} else {

				List<WebElement> elementByXpath = driver.findElements(By
						.xpath("//input[contains(@name,'ChartExhibitQuestionGroup')]/parent::div/parent::div//label"));
				elementByXpath.get(0).click();
				waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.peasewait.bufferLoc"));
			}

			buttonHandler.clickButton(
					PropertiesRepository.getString("new-atitesting.learntab.tutorials.assessment.submitButton"));
			waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.peasewait.bufferLoc"));
			waitForAwhile(9000);
			windowHandler.switchToMainWindow();
			waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.peasewait.bufferLoc"));
			// Switch to latest window
			windowHandler.switchToFrame("assessmentFrame");
			if (isContinuButtonEnable)
				buttonHandler.clickButton(PropertiesRepository.getString("new-atitesting.continueBtnLoc"));
			waitForAwhile(9000);
			waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.peasewait.bufferLoc"));
			windowHandler.switchToMainWindow();
			waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.peasewait.bufferLoc"));
			// Switch to latest window
			windowHandler.switchToFrame("assessmentFrame");

			if (i == count && isContinuButtonEnable) {
				goToNextSectionQuestions(
						PropertiesRepository.getString("new-atitesting.assessment.dialog.proceedto.next.section"));
			} else if (i == count && !isContinuButtonEnable) {
				clickOnNextSectionQuestions(
						PropertiesRepository.getString("new-atitesting.assessment.dialog.proceedto.next.section"));
			}

		}

	}

	private void goToNextSectionQuestions(String loc) {
		windowHandler.switchToModalDialog();
		WebElement element = baseHandler.findElement(loc);
		if ("Proceed to Next Section".equalsIgnoreCase(element.getText())) {
			element.click();
			waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.peasewait.bufferLoc"));
			waitForAwhile(6000);
			takePracticeAssessmentWithMultipleSections(false, true);
		} else {
			WebElement ele = baseHandler.findElement(
					PropertiesRepository.getString("new-atitesting.assessment.dialog.finalizeandview.results"));
			ele.click();
			waitForAwhile(20000);
			waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.peasewait.bufferLoc"));
			try {
				clickClose(PropertiesRepository.getString("new-atitesting.cardback.close.loc"));
				waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.peasewait.bufferLoc"));
				waitForAwhile(11000);
				return;
			} catch (DriverException e) {
			}

		}

	}

	public void waitForAwhile(long milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
		}
	}

	private void clickOnNextSectionQuestions(String loc) {
		windowHandler.switchToModalDialog();
		WebElement element = baseHandler.findElement(loc);
		if ("Proceed to Next Section".equalsIgnoreCase(element.getText())) {
			element.click();
			waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.peasewait.bufferLoc"));
			waitForAwhile(6000);
			takePracticeAssessmentWithMultipleSections(false, true);
		} else {
			WebElement ele = baseHandler.findElement(
					PropertiesRepository.getString("new-atitesting.assessment.dialog.finalizeandview.results"));
			ele.click();
			waitForAwhile(20000);
			waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.peasewait.bufferLoc"));
		}
	}

	public boolean verifyReportHeaderSecIsDisplayed() throws DriverException {
		logger.info("Method: verifyReportHeaderSecIsDisplayed Start");
		boolean flag = false;
		try {
			// verify tutorial info card
			flag = checkElementDispalyed(PropertiesRepository.getString("new-atitesting.test.individualReportLoc"));
		} catch (Exception e) {
			throw new DriverException("report section is not displayed", e);
		}
		logger.info("Method: verifyReportHeaderSecIsDisplayed Ends");
		return flag;
	}

	public boolean verifyDownloadReportActionIsEnabled() throws DriverException {
		logger.info("Method: verifyDownloadReportActionIsEnabled Start");
		boolean flag = false;
		try {
			// verify tutorial info card
			flag = checkElementEnabled(PropertiesRepository.getString("new-atitesting.test.downloadreportLoc"));
		} catch (Exception e) {
			throw new DriverException("Download report action button is not enabled", e);
		}
		logger.info("Method: verifyDownloadReportActionIsEnabled Ends");
		return flag;
	}

	public void clickOnCloseButton() {
		try {
			clickClose(PropertiesRepository.getString("new-atitesting.cardback.close.loc"));
			waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.peasewait.bufferLoc"));
			waitForAwhile(11000);
		} catch (DriverException e) {
		}

	}

	/**
	 * Method used to verify re take button is disabled or not.
	 * 
	 * @param assessmentName
	 * @return
	 * @throws Exception
	 */
	public boolean verifyRetakeButtonDisablility(String assessmentName) throws Exception {
		logger.info("Method: verify Retake button disability Start");
		try {
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			List<WebElement> moduleList = baseHandler
					.findElements("#tabs-2 ul[id='testApplications'] li section div[class='description']");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				for (int i = 0; i < moduleList.size(); i++) {
					if (assessmentName.equalsIgnoreCase(moduleList.get(i).getText().trim())) {
						List<WebElement> beginOrContinueButtonLoc = driver.findElements(
								By.cssSelector("#tabs-2 ul[id='testApplications'] li nav[class='actions']"));
						if (CollectionUtils.isNotEmpty(beginOrContinueButtonLoc)) {
							String attribute = beginOrContinueButtonLoc.get(i)
									.findElement(
											By.cssSelector(".button.secondary-button.button-focus.focus-element-flag"))
									.getAttribute("class");

							if (attribute.contains("default-button-disabled")) {
								flag = true;
							}
						}
					}
				}
			}
		} catch (Exception e) {
			throw new Exception("Unable to click on Learn Tab module");
		}

		logger.info("Method: verify Retake button disability End");
		return flag;

	}

	/**
	 * Method to verify Assessment added in Online Store.
	 * 
	 * @param assessmentName
	 * @return
	 * @throws Exception
	 */
	public boolean verifyAssessmentAddedOnlinestore(String assessmentName) throws Exception {
		logger.info("Method: verifyAssessmentAddedOnlinestore start");
		boolean flag = false;
		try {
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			List<WebElement> description = baseHandler.findElements("#testProduct0");
			if (CollectionUtils.isNotEmpty(description)
					&& assessmentName.equalsIgnoreCase(description.get(0).getText().trim())) {
				flag = true;
			}
		} catch (Exception e) {
			throw new Exception("Unable to verifyAssessmentAddedOnlinestore");
		}
		logger.info("Method: verifyAssessmentAddedOnlinestore End");
		return flag;
	}

	/**
	 * To verify if Rationale is present after submitting the answer in a Practice
	 * test.
	 * 
	 * The Previous button functionality and Disabled Button functionality only
	 * works after Check box question is answered and it should not be the first
	 * question.
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
	public boolean takeTestVerifyRationaleAndDisableFuncationality(boolean bool, boolean breakFlag,
			boolean rationaleFlag, boolean flagquestion) throws Exception {
		logger.info("Method : takeTestVerifyRationaleAndDisableFuncationality :::::::: Starts");
		boolean checkBoxFlag = false;
		boolean disabledOptionFlag = false;
		boolean previousVerified = false;
		boolean previousBtnFlag = false;
		int step = 0;
		try {
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			switchToAssessmentFrameHandler();
			// Getting Total Question Number
			String maxQtnTextNo = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.question.number.loc")).get(1)
					.getText();

			// Convert String to Integer
			int maxCount = Integer.parseInt(maxQtnTextNo);

			// Getting Current Question Number
			String minQtnTextNo = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.question.number.loc")).get(0)
					.getText();

			// Convert String to Integer
			int minCount = Integer.parseInt(minQtnTextNo);

			// Maximum Question minus Minimum Questions
			int count = maxCount - minCount;
			// to select the answers for all the questions
			for (int i = 0; i <= count; i++) {

				List<WebElement> checkBoxElement = baseHandler.findElements(PropertiesRepository
						.getString("new-atitesting.generic.tutorial.checkbox.new.multiple.answer.loc"));
				List<WebElement> radioElement = baseHandler.findElements(PropertiesRepository
						.getString("new-atitesting.generic.tutorial.radio.button.new.multiple.answer.loc"));
				// logger.info("------------step "+step+" i " +i);
				if (checkBoxElement != null) {
					checkBoxElement.get(0).click();
					checkBoxElement.get(1).click();
					checkBoxFlag = true;
					step = i;
					// logger.info("------------step " + step + " i " + i);
				}

				if (driver.findElements(By.cssSelector(
						".answer-fill-in-the-blank.numericTextEntry.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty"))
						.size() > 0) {
					verifyFillForm("10");

				}

				if (CollectionUtils.isNotEmpty(baseHandler.findElements(
						PropertiesRepository.getString("new-atitesting.generic.tutorial.dragbox1.loc")))) {
					DragAndDropAnswerNew(false);
				}

				if (CollectionUtils.isNotEmpty(radioElement) && radioElement.size() > 0) {
					List<WebElement> radioClickElement = baseHandler.findElements(
							PropertiesRepository.getString("new-atitesting.test.assessment.radio.button.loc"));
					if (CollectionUtils.isNotEmpty(radioClickElement)) {
						radioClickElement.get(0).click();
					}
				}

				if (CollectionUtils.isNotEmpty(
						baseHandler.findElements(PropertiesRepository.getString("new-atitesting.question.img.loc")))) {
					hotSpotQuestionNew("new-atitesting.question.new.img.answer.loc");
				}
				// to press continue after the last question
				if (i == count) {
					switchToAssessmentFrameHandler();
					List<WebElement> buttonElement = baseHandler.findElements(
							PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
					if (CollectionUtils.isNotEmpty(buttonElement)) {
						if (buttonElement.get(0).isDisplayed()) {
							WebElement continueButtonElement = driver
									.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
							if (continueButtonElement != null) {
								continueButtonElement.sendKeys(Keys.ENTER);
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								if (!continueButtonElement.isEnabled()) {
									// clickButton(PropertiesRepository.getString("new-atitesting.myati.assessment.question.unanswered.close.loc"),
									// 0);
									clickAssessmemtType();
								}
							}
						}
					}
					// to check if the rationale is present or not
					List<WebElement> text = baseHandler.findElements(".question-status-incorrect-top-status");
					if (CollectionUtils.isNotEmpty(text)) {
						String textContent = driver.findElement(By.cssSelector(".question-status-incorrect-top-status"))
								.getText();
						if (textContent
								.equalsIgnoreCase(PropertiesRepository
										.getString("new-atitesting.practice.assessment.sixquestions.incorrect"))
								|| textContent.equalsIgnoreCase(PropertiesRepository
										.getString("new-atitesting.practice.assessment.sixquestions.incorrect"))) {
							logger.info("-------------Rationale Verified-------------");
							log(logger, "-------------Rationale Verified-------------");
						}
					}
					// --------------
					if (checkBoxFlag) {
						List<WebElement> disabledOptionBtns = baseHandler
								.findElements("new-atitesting.practice.assessment.sixquestions.disabled.options");
						if (CollectionUtils.isEmpty(disabledOptionBtns)) {
							logger.info("-------------Disabled option functionality Verified-------------");
							log(logger, "-------------Disabled option functionality Verified-------------");
							disabledOptionFlag = true;
						}
					}
					// move to the previous question if present question is checkbox question and
					// verify it
					if (checkBoxFlag && i != 0) {
						logger.info("Entered the condition");
						List<WebElement> buttonBackWardElement1 = baseHandler
								.findElements(".product-footer-nav #movePrevious");
						if (CollectionUtils.isNotEmpty(buttonBackWardElement1)) {
							if (buttonBackWardElement1.get(0).isDisplayed()) {
								WebElement continueButtonElement1 = buttonBackWardElement1.get(0);
								if (continueButtonElement1 != null) {
									Actions action = new Actions(driver);
									action.moveToElement(continueButtonElement1);
									checkBoxFlag = false;
									continueButtonElement1.sendKeys(Keys.LEFT);
								}
							}
						}
					}
					// verify the previous question
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
					switchToAssessmentFrameHandler();
					List<WebElement> currentQuestionNo = baseHandler.findElements(
							PropertiesRepository.getString("new-atitesting.myati.test.tab.current.question.no.loc"));
					// logger.info(currentQuestionNo.get(0).getText());

					if (CollectionUtils.isNotEmpty(currentQuestionNo)) {
						String currentQ = currentQuestionNo.get(0).getText();
						int currentQNo = Integer.parseInt(currentQ);
						// logger.info("------------currentQno"+currentQNo);
						// logger.info("------------step "+step+" i " +i);
						if (currentQNo == step) {
							previousBtnFlag = true;
							previousVerified = true;
							logger.info("-------------Previous button functionality Verified-------------");
							log(logger, "-------------Previous button functionality Verified-------------");
						}
					}

					// to press continue after loading previous page
					if (previousVerified) {
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						switchToAssessmentFrameHandler();
						waitUntillElementIsVisible(
								PropertiesRepository.getString("new-atitesting.generic.tutorial.submit.new.loc"));
						List<WebElement> buttonElement1 = baseHandler.findElements(
								PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
						if (CollectionUtils.isNotEmpty(buttonElement1)) {
							if (buttonElement1.get(0).isDisplayed()) {
								WebElement continueButtonElement = driver
										.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
								if (continueButtonElement != null) {
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									if (verifyQuestionUnAsweredPopup()) {
										List<WebElement> assessmentCompleteElement = baseHandler
												.findElements(".modal-section button");
										if (CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
											assessmentCompleteElement.get(0).click();
										}
										clickButton(PropertiesRepository.getString(
												"new-atitesting.myati.assessment.question.unanswered.close.loc"), 0);
										clickAssessmemtType();
									}
								}
							}
						}
						previousVerified = false;
					}
					takeAssessmentVerifySectionNew(rationaleFlag, flagquestion, "Finalize and View Results");
					if (disabledOptionFlag && previousBtnFlag) {
						logger.info(
								"Previous button functionality and Disabled option functionality is verified. in takeTestVerifyRationaleAndDisableFuncationality");
						logger.info("Method : takeTestVerifyRationaleAndDisableFuncationality :::::::: END");
						return true;
					}
				} else { // to flag the question
					if (i == 0 && flagquestion) {
						switchToAssessmentFrameHandler();
						verifyFlag(true);
						logger.info("Question has been flaged");
						Thread.sleep(4000);
					} else { // to click continue after the answer is selected all questions except the last
								// one
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						switchToAssessmentFrameHandler();
						waitUntillElementIsVisible(
								PropertiesRepository.getString("new-atitesting.generic.tutorial.submit.new.loc"));
						List<WebElement> buttonElement = baseHandler.findElements(
								PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
						if (CollectionUtils.isNotEmpty(buttonElement)) {
							if (buttonElement.get(0).isDisplayed()) {
								WebElement continueButtonElement = driver
										.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
								if (continueButtonElement != null) {
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									if (verifyQuestionUnAsweredPopup()) {
										List<WebElement> assessmentCompleteElement = baseHandler
												.findElements(".modal-section button");
										if (CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
											assessmentCompleteElement.get(0).click();
										}
										clickButton(PropertiesRepository.getString(
												"new-atitesting.myati.assessment.question.unanswered.close.loc"), 0);
										clickAssessmemtType();
									}
								}
							}
						}
					}
					// to check if the rationale is present or not
					List<WebElement> text = baseHandler.findElements(".question-status-incorrect-top-status");
					if (CollectionUtils.isNotEmpty(text)) {
						String textContent = driver.findElement(By.cssSelector(".question-status-incorrect-top-status"))
								.getText();
						if (textContent
								.equalsIgnoreCase(PropertiesRepository
										.getString("new-atitesting.practice.assessment.sixquestions.incorrect"))
								|| textContent.equalsIgnoreCase(PropertiesRepository
										.getString("new-atitesting.practice.assessment.sixquestions.incorrect"))) {
							logger.info("-------------Rationale Verified-------------");
							log(logger, "-------------Rationale Verified-------------");
						}
					}
					// to check if the answer submitted can be changed or not.
					if (checkBoxFlag) {
						List<WebElement> disabledOptionBtns = baseHandler
								.findElements("new-atitesting.practice.assessment.sixquestions.disabled.options");
						if (CollectionUtils.isEmpty(disabledOptionBtns)) {
							logger.info("-------------Disabled option functionality Verified-------------");
							log(logger, "-------------Disabled option functionality Verified-------------");
							disabledOptionFlag = true;
						}
					}
					// move to the previous question if present question is checkbox question and
					// verify it
					if (checkBoxFlag && i != 0) {
						logger.info("Entered the condition");
						List<WebElement> buttonBackWardElement1 = baseHandler
								.findElements(".product-footer-nav #movePrevious");
						if (CollectionUtils.isNotEmpty(buttonBackWardElement1)) {
							if (buttonBackWardElement1.get(0).isDisplayed()) {
								WebElement continueButtonElement1 = buttonBackWardElement1.get(0);
								if (continueButtonElement1 != null) {
									Actions action = new Actions(driver);
									action.moveToElement(continueButtonElement1);
									checkBoxFlag = false;
									continueButtonElement1.sendKeys(Keys.LEFT);
								}
							}
						}
					}
					// verify the previous question
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
					switchToAssessmentFrameHandler();
					List<WebElement> currentQuestionNo = baseHandler.findElements(
							PropertiesRepository.getString("new-atitesting.myati.test.tab.current.question.no.loc"));
					// logger.info(currentQuestionNo.get(0).getText());

					if (CollectionUtils.isNotEmpty(currentQuestionNo)) {
						String currentQ = currentQuestionNo.get(0).getText();
						int currentQNo = Integer.parseInt(currentQ);
						// logger.info("------------currentQno"+currentQNo);
						// logger.info("------------step "+step+" i " +i);
						if (currentQNo == step) {
							previousBtnFlag = true;
							previousVerified = true;
							logger.info("-------------Previous button functionality Verified-------------");
							log(logger, "-------------Previous button functionality Verified-------------");
						}
					}

					// to press continue after loading previous page
					if (previousVerified) {
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						switchToAssessmentFrameHandler();
						waitUntillElementIsVisible(
								PropertiesRepository.getString("new-atitesting.generic.tutorial.submit.new.loc"));
						List<WebElement> buttonElement = baseHandler.findElements(
								PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
						if (CollectionUtils.isNotEmpty(buttonElement)) {
							if (buttonElement.get(0).isDisplayed()) {
								WebElement continueButtonElement = driver
										.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
								if (continueButtonElement != null) {
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									if (verifyQuestionUnAsweredPopup()) {
										List<WebElement> assessmentCompleteElement = baseHandler
												.findElements(".modal-section button");
										if (CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
											assessmentCompleteElement.get(0).click();
										}
										clickButton(PropertiesRepository.getString(
												"new-atitesting.myati.assessment.question.unanswered.close.loc"), 0);
										clickAssessmemtType();
									}
								}
							}
						}
						previousVerified = false;
					}
					if (rationaleFlag) {
						waitUntillLoadingImageIsDisappeared("new-atitesting.pleasewait.bufferLoc");
						List<WebElement> rationalContinue = driver
								.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
						if (CollectionUtils.isNotEmpty(rationalContinue)) {
							rationalContinue.get(0).sendKeys(Keys.ENTER);
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						}
					}
					switchToAssessmentFrameHandler();

					if (breakFlag) {
						break;
					}
				}
			}

		} catch (DriverException e) {
			logger.info("unable to take practice assessment in takeTestVerifyRationaleAndDisableFuncationality" + e);
		}
		waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.pleasewait.bufferLoc"));
		if (disabledOptionFlag && previousBtnFlag) {
			logger.info(
					"Previous button functionality and Disabled option functionality is verified. in takeTestVerifyRationaleAndDisableFuncationality");
			logger.info("Method : takeTestVerifyRationaleAndDisableFuncationality :::::::: END");
			return true;
		}
		return false;
	}

	public void takeTestWithIPPDownload(boolean bool, boolean breakFlag, boolean rationaleFlag, boolean flagquestion)
			throws Exception {
		logger.info("Method : takePracticeTest :::::::: Starts");
		try {

			// waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			switchToAssessmentFrameHandler();
			// Getting Total Question Number
			String maxQtnTextNo = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.question.number.loc")).get(1)
					.getText();

			// Convert String to Integer
			int maxCount = Integer.parseInt(maxQtnTextNo);

			// Getting Current Question Number
			String minQtnTextNo = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.question.number.loc")).get(0)
					.getText();

			// Convert String to Integer
			int minCount = Integer.parseInt(minQtnTextNo);

			// Maximum Question minus Minimum Questions
			int count = maxCount - minCount;
			// to select the answers for all the questions
			for (int i = 0; i <= count; i++) {

				List<WebElement> checkBoxElement = baseHandler.findElements(PropertiesRepository
						.getString("new-atitesting.generic.tutorial.checkbox.new.multiple.answer.loc"));
				List<WebElement> radioElement = baseHandler.findElements(PropertiesRepository
						.getString("new-atitesting.generic.tutorial.radio.button.new.multiple.answer.loc"));

				if (checkBoxElement != null) {
					checkBoxElement.get(0).click();
					checkBoxElement.get(1).click();
				}

				if (driver.findElements(By.cssSelector(
						".answer-fill-in-the-blank.numericTextEntry.focus-element-flag.ng-pristine.ng-untouched.ng-valid.ng-empty"))
						.size() > 0) {
					verifyFillForm("10");

				}

				if (CollectionUtils.isNotEmpty(baseHandler.findElements(
						PropertiesRepository.getString("new-atitesting.generic.tutorial.dragbox1.loc")))) {
					DragAndDropAnswerNew(false);
				}

				if (CollectionUtils.isNotEmpty(radioElement) && radioElement.size() > 0) {
					List<WebElement> radioClickElement = baseHandler.findElements(
							PropertiesRepository.getString("new-atitesting.test.assessment.radio.button.loc"));
					if (CollectionUtils.isNotEmpty(radioClickElement)) {
						radioClickElement.get(0).click();
					}
				}

				if (CollectionUtils.isNotEmpty(
						baseHandler.findElements(PropertiesRepository.getString("new-atitesting.question.img.loc")))) {
					hotSpotQuestionNew("new-atitesting.question.new.img.answer.loc");
				}
				// to press continue after the last question
				if (i == count) {
					switchToAssessmentFrameHandler();
					List<WebElement> buttonElement = baseHandler.findElements(
							PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
					if (CollectionUtils.isNotEmpty(buttonElement)) {
						if (buttonElement.get(0).isDisplayed()) {
							WebElement continueButtonElement = driver
									.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
							if (continueButtonElement != null) {
								continueButtonElement.sendKeys(Keys.ENTER);
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								if (!continueButtonElement.isEnabled()) {
									// clickButton(PropertiesRepository.getString("new-atitesting.myati.assessment.question.unanswered.close.loc"),
									// 0);
									clickAssessmemtType();
								}
							}
						}
					}
					takeAssessmentVerifySectionNew(rationaleFlag, flagquestion, "Finalize and View Results");
				} else { // to flag the question
					if (i == 0 && flagquestion) {
						switchToAssessmentFrameHandler();
						verifyFlag(true);
						logger.info("Question has been flaged");
						Thread.sleep(4000);
					} else { // to click continue after the answer is selected all questions except the last
								// one
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						switchToAssessmentFrameHandler();
						waitUntillElementIsVisible(
								PropertiesRepository.getString("new-atitesting.generic.tutorial.submit.new.loc"));
						List<WebElement> buttonElement = baseHandler.findElements(
								PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
						if (CollectionUtils.isNotEmpty(buttonElement)) {
							if (buttonElement.get(0).isDisplayed()) {
								WebElement continueButtonElement = driver
										.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
								if (continueButtonElement != null) {
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									if (verifyQuestionUnAsweredPopup()) {
										List<WebElement> assessmentCompleteElement = baseHandler
												.findElements(".modal-section button");
										if (CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
											assessmentCompleteElement.get(0).click();
										}
										clickButton(PropertiesRepository.getString(
												"new-atitesting.myati.assessment.question.unanswered.close.loc"), 0);
										clickAssessmemtType();
									}
								}
							}
						}
					}
					if (rationaleFlag) {
						waitUntillLoadingImageIsDisappeared("new-atitesting.pleasewait.bufferLoc");
						List<WebElement> rationalContinue = driver
								.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
						if (CollectionUtils.isNotEmpty(rationalContinue)) {
							rationalContinue.get(0).sendKeys(Keys.ENTER);
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						}
					}
					switchToAssessmentFrameHandler();

					if (breakFlag) {
						break;
					}
				}
			}
		} catch (DriverException e) {
			logger.info("unable to take practice assessment" + e);
		}
		waitUntillBufferInvisible(PropertiesRepository.getString("new-atitesting.pleasewait.bufferLoc"));
		logger.info("Method : takePracticeTest :::::::: END");
	}
	public void clickTestTabAssessmentResultButton(String assessmentType, String assessmentName) throws Exception {
		logger.info("Method: clickTestTabAssessmentResultButton Starts");
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
					for (int index = 0; index < size; index++) {
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
										if (assessmentTypeElement.findElement(By.cssSelector(
												PropertiesRepository.getString("asmt.tutorial.resultbutton.loc")))
												.isDisplayed()) {
											assessmentTypeElement.findElement(By.cssSelector(
													PropertiesRepository.getString("asmt.tutorial.resultbutton.loc")))
													.click();
											break;
										}
										// Getting Button name
										
									}
								}
							}
							
						}
						
					}
					
							} else {
								log(logger, "Assessment Type is not matched");
								breakFlag = true;
							}
						}
		} catch (Exception e) {
			logger.info("Unable to click Test Tab Result Button");
			log(logger, "Unable to click Test Tab Result Button");
			throw new DriverException("Unable to click Test Tab Result Button", e);
		}

		logger.info("Method: clickTestTabAssessmentResultButton End");
	}
	
	public void clickTestTabAssessmentButtonNew(String assessmentType, String assessmentName) throws Exception {
		logger.info("Method: clickTestTabAssessmentButtonNew Starts ");
		boolean breakFlag = false;
		try {
			waitUntillElementIsVisible(PropertiesRepository.getString("asmt.myati.test.tab.verify.details.are.displaye.loc"));
			if (baseHandler.isDisplayed(PropertiesRepository.getString("asmt.myati.test.tab.verify.details.are.displaye.loc"))) {
				List<WebElement> pracProcCardElement = baseHandler.findElements(PropertiesRepository.getString("asmt.myati.test.tab.verify.details.are.displaye.loc"));
				if (CollectionUtils.isNotEmpty(pracProcCardElement)) {
					int size = pracProcCardElement.size();
					mainloop:for (int index = 0; index < size; index++) {
						if (breakFlag) {
							break;
						}
						WebElement assessmentTypeElement = pracProcCardElement.get(index);
						// Validating Assessment Type
						WebElement assessmentTypeSingleElement = null;
						if(assessmentTypeElement.findElements(By.cssSelector(PropertiesRepository.getString("asmt.myati.test.tab.assessment.type.loc"))).size() != 0)
						{	
							assessmentTypeSingleElement = assessmentTypeElement.findElement(By.cssSelector(PropertiesRepository.getString("asmt.myati.test.tab.assessment.type.loc")));
						}
						if (assessmentTypeSingleElement != null) {
							String assessmentTypeValue = assessmentTypeSingleElement.getText().trim();
							if (StringUtils.isNotEmpty(assessmentTypeValue)
									&& assessmentTypeValue.equalsIgnoreCase(assessmentType)) {
								// Validating Assessment Name
								WebElement assessmentNameElement = assessmentTypeElement.findElement(By.cssSelector(
										PropertiesRepository.getString("asmt.myati.test.tab.assessment.name.loc")));
								if (assessmentNameElement != null) {
									String assessmentNameValue = assessmentNameElement.getText().trim().replaceAll("\\r\\n|\\r|\\n", " ");
									String assNameIndex= assessmentNameElement.getAttribute("id");
									if (StringUtils.isNotEmpty(assessmentNameValue)	&& assessmentNameValue.equalsIgnoreCase(assessmentName)) {										
										List<WebElement> buttonList = baseHandler.findElements("a[id$='" +assNameIndex.substring(assNameIndex.length() - 1) +"']");
										for (int i = 0; i < buttonList.size(); i++) {
											if(buttonList.get(i).isDisplayed()){
												buttonList.get(i).click();
												break mainloop;
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

		logger.info("Method: clickTestTabAssessmentButtonNew End ");
	}

}
