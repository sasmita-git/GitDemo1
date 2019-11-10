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
import com.ascendlearning.automation.ui.handlers.TextHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;

public class EHRPage extends NewATIBasePage {

	private Logger logger = LogManager.getLogger(this.getClass());
	public String actualText = "";
	public BaseHandler baseHandler;
	private WindowHandler windowHandler;
	private TextHandler textHandler;

	public EHRPage(WebDriver webDriver) {
		super(webDriver);
		baseHandler = new BaseHandler(driver);
		textHandler = new TextHandler(driver);
		textHandler = new TextHandler(driver);
		windowHandler = new WindowHandler(driver);
	}

	/**
	 * Verify if EHR tutorial is displayed
	 * 
	 * 
	 * @author saravanan.jothimani
	 * @throws DriverException
	 */
	public boolean VerifyIfEHRTutorDisplayed(String tutorialName) throws Exception {
		logger.info("Method: VerifyIfEHRTutorDisplayed Start");
		boolean flag = false;
		try {
			List<WebElement> moduleList = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.applytab.list.all.modules.loc"));
			for (int i = 0; i < moduleList.size(); i++) {
				if (CollectionUtils.isNotEmpty(moduleList) && (moduleList.get(i)
						.findElement(By.cssSelector(PropertiesRepository.getString("new-atitesting.allmodule.name")))
						.getText().equals(PropertiesRepository
								.getString("new-atitesting.apply.tab.simulation.ehr.tutor.name")))) {
					flag = true;
					break;
				}
			}
		} catch (Exception e) {
			logger.info("There are no enabled EHR Tutor Displayed");
			throw new Exception("There are no enabled EHR Tutor Displayed");
		}
		logger.info("Method: VerifyIfEHRTutorDisplayed End --> " + flag);
		return flag;
	}

	/**
	 * Method used to get module count for EHR Tutor.
	 * 
	 * @author saravanan.jothimani
	 * @param assessmentName
	 * @return
	 * @throws Exception
	 */
	public String getModuleCount(String assessmentName) throws Exception {
		logger.info("Method : getModuleCount Start");
		String result = null;
		try {
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.applytab.list.all.modules.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				for (WebElement allElement : element) {
					String name = allElement
							.findElement(
									By.cssSelector(PropertiesRepository.getString("new-atitesting.allmodule.name")))
							.getText().trim();
					if (StringUtils.isNotBlank(name) && name.equalsIgnoreCase(assessmentName)) {
						result = allElement
								.findElement(By.cssSelector(
										PropertiesRepository.getString("new-atitesting.apply.tab.simulation.name")))
								.getText().trim();
						break;
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to getModuleCount");
			log(logger, "Unable to getModuleCount");
			throw new DriverException("Unable to getModuleCount", e);
		}
		logger.info("Method: getModuleCount End result --> " + result);
		return result;
	}

	public boolean clickOnEHRModuleButton(String assessmentName) throws Exception {
		//logger.info("Method: clickOnEHRModuleButton Start");
		boolean flag = false;
		try {
			List<WebElement> moduleList = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.apply.tab.all.tabs.loc"));
			if (moduleList != null && moduleList.size() > 0) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					WebElement cardFrontDetails = moduleList.get(i).findElement(By.cssSelector(
							PropertiesRepository.getString("new-atitesting.apply.tab.all.tabs.default.container.loc")));
					if (cardFrontDetails != null) {
						WebElement cardFrontName = cardFrontDetails.findElement(
								By.cssSelector(PropertiesRepository.getString("new-atitesting.allmodule.name")));
						if (cardFrontName != null) {
							String name = cardFrontName.getText();
							if (name.equalsIgnoreCase(assessmentName)) {
								// Clicking on button.
								List<WebElement> navDivElement = cardFrontDetails
										.findElements(By.cssSelector(PropertiesRepository
												.getString("new-atitesting.apply.tab.ehr.module.button.loc")));

								if (CollectionUtils.isNotEmpty(navDivElement)) {
									WebElement buttonElement = navDivElement.get(0);

									if (buttonElement != null) {
										JavascriptExecutor executor = (JavascriptExecutor)driver;
										executor.executeScript("arguments[0].click();", buttonElement);
										
										//buttonElement.click();
										waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
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
			logger.info("Unable to clickOnEHRModuleButton");
			log(logger, "Unable to clickOnEHRModuleButton");
			throw new DriverException("Unable to clickOnEHRModuleButton", e);
		}
		logger.info("Method: clickOnEHRModuleButton End flag --> " + flag);
		return flag;
	}

	/**
	 * @author saravanan.jothimani
	 * 
	 * @param index
	 * @param spanText
	 * @param divText
	 * @return
	 * @throws Exception
	 */
	public boolean verifyCardBackIndividualModuleText(String moduleName) throws Exception {
		logger.info("Method : verifyCardBackIndividualModuleText Start");
		boolean flag = false;
		try {
			// Getting all sections from cardback.
			List<WebElement> element = baseHandler.findElements(
					PropertiesRepository.getString("new-atitesting.apply.tab.card.back.module.each.section.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				int size = element.size();
				for (WebElement moduleElement : element) {
					// Verifying Card back module name
					List<WebElement> moduleUIName = moduleElement.findElements(By.cssSelector("header span"));
					if (CollectionUtils.isNotEmpty(moduleUIName)
							&& moduleName.equalsIgnoreCase(moduleUIName.get(0).getText())) {
						// Getting Footer Accessed section.
						List<WebElement> footerElement = moduleElement.findElements(By.cssSelector(PropertiesRepository
								.getString("new-atitesting.nclex.card.back.quiz.bank.accessed.loc")));
						if (CollectionUtils.isNotEmpty(footerElement)) {
							// Clicking on Module Button
							List<WebElement> moduleButtonElement = moduleElement
									.findElements(By.cssSelector(PropertiesRepository
											.getString("new-atitesting.apply.tab.card.back.module.button.loc")));
							if (CollectionUtils.isNotEmpty(moduleButtonElement)) {
								moduleButtonElement.get(0).click();
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								flag = true;
								break;
							} else {
								logger.info("Unable to click on Module button");
							}
						} else {
							logger.info("Unable to get footer info");
						}
					} else {
						logger.info("Unable to verify Module name");
					}

				}
			} else {
				logger.info("Unable to get locator values in verifyCardBackIndividualModuleText");
			}
		} catch (Exception e) {
			logger.info("Unable to verifyCardBackIndividualModuleText");
			log(logger, "Unable to verifyCardBackIndividualModuleText");
			throw new DriverException("Unable to verifyCardBackIndividualModuleText", e);
		}
		logger.info("Method: verifyCardBackIndividualModuleText End flag --> " + flag);
		return flag;
	}

	public void switchToEHRFrame() throws Exception {
		logger.info("Method : switchToContentFrame Start");
		try {
			WebElement frameElement = driver.findElement(By.cssSelector("LTIFrame"));
			driver.switchTo().frame(frameElement);
		} catch (Exception e) {
			logger.info("Unable to ");
			log(logger, "Unable to ");
			throw new DriverException("Unable to ", e);
		}
		logger.info("Method: switchToContentFrame End");

	}

	/**
	 * Method used to verify EHR Assessment Header name
	 * 
	 * @author saravanan.jothimani
	 * @param assessmentHeaderName
	 * @return
	 * @throws Exception
	 */
	public boolean verifyEHRAssessementHeaderName(String assessmentHeaderName) throws Exception {
		logger.info("Method : verifyEHRAssessementHeaderName Start");
		boolean flag = false;
		try {
			switchToEHRFrame();
			List<WebElement> element = baseHandler.findElements(
					PropertiesRepository.getString("new-atitesting.apply.tab.assessment.header.name.loc"));
			if (CollectionUtils.isNotEmpty(element)
					&& assessmentHeaderName.equalsIgnoreCase(element.get(0).getText())) {
				flag = true;
			} else {
				logger.info("Unable to verify EHR Assessment Header Name");
			}
			windowHandler.switchToLatestWindow();
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to verifyEHRAssessementHeaderName");
			log(logger, "Unable to verifyEHRAssessementHeaderName");
			throw new DriverException("Unable to verifyEHRAssessementHeaderName", e);
		}
		logger.info("Method: verifyEHRAssessementHeaderName End flag --> " + flag);
		return flag;
	}

	/**
	 * Method used to click Popup Yes button after clicking on Assessment close
	 * button
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws Exception
	 */
	public boolean clicYesInPopup() throws Exception {
		logger.info("Method : clicYesInPopup Start");
		boolean flag = false;
		try {
			windowHandler.switchToLatestWindow();
			List<WebElement> element = baseHandler.findElements(PropertiesRepository
					.getString("new-atitesting.apply.tab.assessment.confirmation.popup.yes.button.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				element.get(0).click();
				flag = true;
			}
			windowHandler.switchToLatestWindow();
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to clicYesInPopup ");
			log(logger, "Unable to clicYesInPopup");
			throw new DriverException("Unable to clicYesInPopup", e);
		}
		logger.info("Method: clicYesInPopup End flag --> " + flag);
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
	public boolean verifyEHRRecentActivity(String tutorialName, String moduleName) throws Exception {
		logger.info("Method : verifyEHRRecentActivity Start");
		boolean flag = false;
		try {
			// Get all recent activities.
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("new.atitestig.nclex.recent.activity.section.loc"));
			if (CollectionUtils.isNotEmpty(element)) {

				for (WebElement recentElement : element) {
					// Getting Status.
					List<WebElement> nclexStatus = recentElement.findElements(By.cssSelector(PropertiesRepository
							.getString("new.atitestig.nclex.recent.activity.inprogress.completed.section.loc")));
					if (CollectionUtils.isNotEmpty(nclexStatus)
							&& nclexStatus.get(0).getText().equalsIgnoreCase("In Progress")
							&& nclexStatus.get(0).isDisplayed()) {
						// Getting NCLEX Name.
						List<WebElement> nclexName = recentElement
								.findElements(By.cssSelector("span[data-bind*='ProductName']"));
						if (CollectionUtils.isNotEmpty(nclexName)) {
							for (WebElement nclexNameElement : nclexName) {
								if (nclexNameElement.getText().equalsIgnoreCase(tutorialName)) {
									// Getting NCLEX module name
									List<WebElement> nclexModuleName = recentElement
											.findElements(By.cssSelector("span[data-bind='html:ModuleName']"));
									if (CollectionUtils.isNotEmpty(nclexModuleName)) {
										for (WebElement nclexModuleNameElement : nclexModuleName) {
											if (nclexModuleNameElement.getText().equalsIgnoreCase(moduleName)) {
												flag = true;
												break;
											} else {
												logger.info("Unable to verify nclex status");
											}
										} // end for
									} else { // if (nclexNameElement.getText().equalsIgnoreCase(tutorialName)) {
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
				}

			} else {
				logger.info("Unable to get locator details");
			}
		} catch (Exception e) {
			logger.info("Unable to verifyEHRRecentActivity");
			log(logger, "Unable to verifyEHRRecentActivity");
			throw new DriverException("Unable to verifyEHRRecentActivity", e);
		}
		logger.info("Method: verifyEHRRecentActivity End flag --> " + flag);
		return flag;
	}

}
