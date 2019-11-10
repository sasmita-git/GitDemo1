package com.automation.asmt.page;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.DropDownHandler;

public class TestTabPage extends TakeAssessmentPage {

	private Logger logger = LogManager.getLogger(this.getClass());

	private boolean flag;
	private DropDownHandler dropDownHandler;
	
	public TestTabPage(WebDriver webDriver) {
		super(webDriver);
		dropDownHandler = new DropDownHandler(driver);
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
							.getString("asmt.myati.test.tab.verify.details.are.displaye.loc"));
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
			String assessmentName, boolean anyButtonName, String buttonName)
			throws Exception {
		logger.info("Method: clickTestTabAssessmentButton Starts");
		boolean breakFlag = false;
		try {
			waitUntillElementIsVisible(PropertiesRepository
					.getString("asmt.myati.test.tab.verify.details.are.displaye.loc"));
			waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
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
											.getText().trim();
									if (StringUtils
											.isNotEmpty(assessmentNameValue)
											&& assessmentNameValue
													.equalsIgnoreCase(assessmentName)) {
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
													if (anyButtonName) {
														if (buttonNameValue
																.equalsIgnoreCase(buttonName)) {
															if (!styleValue) {
																singleButtonElement
																		.click();
																if (verifySelectInstanceContainer(false)) {
																	boolean selectInstanceFlag = verifySelectInstanceContainer(true);
																	if (selectInstanceFlag) {
																		// Verifying
																		// Loading
																		// image.
																		waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
																		breakFlag = true;
																	}
																} else {
																	breakFlag = true;
																}
															}
														} /*
														 * else { log(logger,
														 * "Button name is not matched, so unable to click"
														 * ); break; }
														 */
													} else {
														if (!styleValue) {
															singleButtonElement
																	.click();
															waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
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
		logger.info("Method: clickTestTabAssessmentButtonNew Starts ");
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
								((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", assessmentTypeElement);
								WebElement assessmentNameElement = assessmentTypeElement
										.findElement(By
												.cssSelector(".description"));
								if (assessmentNameElement != null) {
									String assessmentNameValue = assessmentNameElement
											.getText().trim().replaceAll("\\r\\n|\\r|\\n"," ");
									if (StringUtils
											.isNotEmpty(assessmentNameValue)
											&& assessmentNameValue
													.equalsIgnoreCase(assessmentName)) {
										if (assessmentTypeElement
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
										}
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
	public void clickTestTabAssessmentButtonWOSelectInstance(String assessmentType,
			String assessmentName) throws Exception {
		logger.info("Method: clickTestTabAssessmentButtonWOSelectInstance Starts");
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
								((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", assessmentTypeElement);
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
										if (assessmentTypeElement
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
										}
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
														logger.info("Button Text --> " + singleButtonElement.getText());
														if (singleButtonElement
																.isDisplayed()) {
															singleButtonElement
																	.click();
															waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
															breakFlag = true;
														}
														/*if (verifySelectInstanceContainer(false)) {
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
														}*/
													}

												} /*
												 * else { log(logger,
												 * "Button name is not matched"
												 * ); }
												 */
											}
										}
									} else {
										logger.info("Assessment name is not available under Test Tab " + assessmentName);
									}
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
			logger.info("Unable to clickTestTabAssessmentButtonWOSelectInstance");
			log(logger, "Unable to clickTestTabAssessmentButtonWOSelectInstance");
			throw new DriverException(
					"Unable to clickTestTabAssessmentButtonWOSelectInstance", e);
		}

		logger.info("Method: clickTestTabAssessmentButtonWOSelectInstance End");
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
	public boolean clickTestTabAssessmentButtonWOSelectInstance(String assessmentType,
			String assessmentName, String buttonName) throws Exception {
		logger.info("Method: clickTestTabAssessmentButtonWOSelectInstance Starts");
		boolean breakFlag = false;
		boolean flag = false;
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
								((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", assessmentTypeElement);
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
										if (assessmentTypeElement
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
										}
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
														if(buttonName.equalsIgnoreCase(singleButtonElement.getText())) {
															logger.info("Button name is matched");
															flag = true;
														}
														if (singleButtonElement
																.isDisplayed()) {
															singleButtonElement
																	.click();
															waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
															breakFlag = true;
														}
														/*if (verifySelectInstanceContainer(false)) {
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
														}*/
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
			logger.info("Unable to clickTestTabAssessmentButtonWOSelectInstance");
			log(logger, "Unable to clickTestTabAssessmentButtonWOSelectInstance");
			throw new DriverException(
					"Unable to clickTestTabAssessmentButtonWOSelectInstance", e);
		}
		logger.info("Method: clickTestTabAssessmentButtonWOSelectInstance End flag --> " + flag);
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
	public void clickTestTabITRAssessmentButton(String assessmentType,
			String assessmentName) throws Exception {
		//logger.info("Method: clickTestTabITRAssessmentButton Starts");
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
										if (assessmentTypeElement
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
										}
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
			logger.info("Unable to click Test Tab ITR Assessment Button");
			log(logger, "Unable to click Test Tab ITR Assessment Button");
			throw new DriverException(
					"Unable to click Test Tab ITR Assessment Button", e);
		}

		logger.info("Method: clickTestTabITRAssessmentButton End");
	}

	private boolean verifySelectInstanceContainer(boolean... click)
			throws Exception {
		logger.info("Method: verifySelectInstanceContainer Starts");
		try {
			flag = false;
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
	
	public void clickAssessmentType(String typeName) throws NullPointerException, Exception {
		logger.info("Method: clickAssessmentType Starts");
    	try {
    		List<WebElement> selectTypeElement = baseHandler.findElements(PropertiesRepository.getString("asmt.myati.test.tab.assessment.type.select.loc"));
    		if(CollectionUtils.isNotEmpty(selectTypeElement)) {
    			Select selectType = dropDownHandler.getDropDown(selectTypeElement.get(1));
    			if(selectType != null) {
    				selectType.selectByValue(typeName);
    			}
    		}
    	} catch (Exception e) {
    		logger.info("Unable to click Assessment Type" );
			log(logger, "Unable to verify Faculty User Product Tab " );
    		throw new DriverException("Unable to verify Faculty User Product Tab " , e); 
    	}
    	logger.info("Method: clickAssessmentType End " );
	}
	
	/**
	 * Method used to click on Card back for Practice Assessment Results button. 
	 * 
	 * @author saravanan.jothimani
	 * @param index
	 * @throws DriverException
	 */
	public void clickPractAssCardBackForResults(int index) throws DriverException {
		logger.info("Method: clickPractAssCardBackForResults Starts");
    	try {
    		List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("asmt.myati.practice.assessment.card.back.results.button"));
    		if(CollectionUtils.isNotEmpty(element) && element.size() > 0) {
    			element.get(index).click();
    			waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
    		}
    	} catch (Exception e) {
    		logger.info("Unable to click PractAss Card Back For Results" );
			log(logger, "Unable to click PractAss Card Back For Results" );
    		throw new DriverException("Unable to click PractAss Card Back For Results" , e); 
    	}
    	logger.info("Method: clickPractAssCardBackForResults End " );
	}
	
	public String getCookieDetails() throws Exception {
		logger.info("Method : Start");
		String result = null;
		try {
			for (Cookie ck : driver.manage().getCookies()) {
				logger.info((ck.getName() + ";" + ck.getValue() + ";" + ck.getDomain() + ";" + ck.getPath() + ";"
						+ ck.getExpiry() + ";" + ck.isSecure()));
			}
			Cookie cookie = driver.manage().getCookieNamed("ATITesting_CurrentAssessmentID");
			if (cookie != null) {
				cookie.getName();
				result = cookie.getValue();
			}
		} catch (Exception e) {
			logger.info("Unable to click PractAss Card Back For Results");
			log(logger, "Unable to click PractAss Card Back For Results");
			throw new DriverException("Unable to click PractAss Card Back For Results", e);
		}
		logger.info("Method: End flag --> " + result);
		return result;
	}
}
