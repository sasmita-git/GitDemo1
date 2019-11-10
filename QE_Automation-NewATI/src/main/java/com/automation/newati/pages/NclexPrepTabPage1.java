package com.automation.newati.pages;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.TextHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;

public class NclexPrepTabPage1 extends NewATIBasePage {

	private Logger logger = LogManager.getLogger(this.getClass());
	public String actualText = "";
	public BaseHandler baseHandler;
	private WindowHandler windowHandler;
	private TextHandler textHandler;

	public NclexPrepTabPage1(WebDriver webDriver) {
		super(webDriver);
		baseHandler = new BaseHandler(driver);
		textHandler = new TextHandler(driver);
		textHandler = new TextHandler(driver);
		windowHandler = new WindowHandler(driver);
	}

	public void clickOnNCLEXModuleButton() throws Exception {
		logger.info("Method: clickModuleButtonByName Start");
		List<WebElement> moduleList = baseHandler
				.findElements(PropertiesRepository.getString("new-atitesting.nclex.all.products.loc"));
		if (moduleList != null && moduleList.size() > 0) {
			int size = moduleList.size();
			for (int i = 0; i < size; i++) {
				WebElement cardFrontDetails = moduleList.get(i).findElement(By.cssSelector(
						"section[class='card front board-vital'] div[class='learn-card-front-wrapper default-container']"));
				if (cardFrontDetails != null) {
					WebElement cardFrontName = cardFrontDetails.findElement(By.cssSelector(".description"));
					if (cardFrontName != null) {
						String name = cardFrontName.getText();
						if (name.equalsIgnoreCase(
								PropertiesRepository.getString("new-atitesting.nclexprep.tab.product.name"))
								|| name.equalsIgnoreCase(PropertiesRepository
										.getString("new-atitesting.nclexprep.tab.rn.product.name"))) {
							// Clicking on button.
							List<WebElement> navDivElement = cardFrontDetails.findElements(By.cssSelector(
									"nav div div a[class='button cardflip focus-element-flag primary-button']"));
							if (CollectionUtils.isNotEmpty(navDivElement)) {
								WebElement buttonElement = navDivElement.get(0);
								if (buttonElement != null) {
									buttonElement.click();
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									break;
								}
							} else {
								List<WebElement> navDivElement1 = cardFrontDetails.findElements(By.cssSelector(
										"section[class='card front board-vital'] div[class='learn-card-front-wrapper default-container'] nav div div a"));
								WebElement buttonElement = navDivElement1.get(0);
								if (buttonElement != null) {
									buttonElement.click();
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									break;
								}
							}
						}
					}
				}
			}
		}
		logger.info("Method: clickModuleButtonByName End");
	}

	public void clickOnNCLEXModuleButtonByName(String moduleName) throws Exception {
		logger.info("Method: clickModuleButtonByName Start");
		List<WebElement> moduleList = baseHandler
				.findElements(PropertiesRepository.getString("new-atitesting.nclex.all.products.loc"));
		if (moduleList != null && moduleList.size() > 0) {
			int size = moduleList.size();
			for (int i = 0; i < size; i++) {
				WebElement cardFrontDetails = moduleList.get(i).findElement(By.cssSelector(
						"section[class='card front board-vital'] div[class='learn-card-front-wrapper default-container']"));
				if (cardFrontDetails != null) {
					WebElement cardFrontName = cardFrontDetails.findElement(By.cssSelector(".description"));
					if (cardFrontName != null) {
						String name = cardFrontName.getText();
						if (name.equalsIgnoreCase(moduleName)) {
							// Clicking on button.
							// List<WebElement> navDivElement =
							// cardFrontDetails.findElements(By.cssSelector("nav
							// div div a[class='button cardflip
							// focus-element-flag primary-button']"));
							List<WebElement> navDivElement = cardFrontDetails.findElements(
									By.cssSelector(".button.cardflip.focus-element-flag.secondary-button"));
							if (CollectionUtils.isNotEmpty(navDivElement)) {
								WebElement buttonElement = navDivElement.get(0);
								if (buttonElement != null) {
									buttonElement.click();
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									break;
								}
							} else {
								List<WebElement> navDivElement1 = cardFrontDetails.findElements(By.cssSelector(
										"section[class='card front board-vital'] div[class='learn-card-front-wrapper default-container'] nav div div a"));
								WebElement buttonElement = navDivElement1.get(0);
								if (buttonElement != null) {
									buttonElement.click();
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									break;
								}
							}
						}
					}
				}
			}
		}
		logger.info("Method: clickModuleButtonByName End");
	}

	public boolean verifyNclexCardBackMessage(String locator) throws DriverException {
		logger.info("Method: verifyNclexCardBackMessage Starts");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(element)
					&& element.get(0).getText().equalsIgnoreCase(
							PropertiesRepository.getString("new-atitesting.nclexprep.tab.product.name"))
					|| element.get(0).getText().equalsIgnoreCase(
							PropertiesRepository.getString("new-atitesting.nclexprep.tab.rn.product.name"))) {
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to verify Message");
			log(logger, "Unable to verify Message");
			throw new DriverException("Unable to verify Message", e);
		}
		logger.info("Method: verifyNclexCardBackMessage End flag --> " + flag);
		return flag;
	}

	public boolean isDropDownOrCheckBoxDisplayed() {

		windowHandler.switchToModalDialog();
		WebElement element = baseHandler.findElement("#productBoardVitalsList");
		List<WebElement> dropdownList = element.findElements(By.tagName("select"));
		if (dropdownList != null) {
			return true;
		}

		return false;
	}

	public boolean verifySubTabs() throws DriverException {
		try {
			WebElement learnTab = baseHandler.findElement(PropertiesRepository.getString("new-atitesting.learn.tab"));
			WebElement testTab = baseHandler.findElement(PropertiesRepository.getString("new-atitesting.test.tab"));
			WebElement improveTab = baseHandler
					.findElement(PropertiesRepository.getString("new-atitesting.improve.tab"));
			WebElement applyTab = baseHandler.findElement(PropertiesRepository.getString("new-atitesting.apply.tab"));
			WebElement nclexTab = baseHandler.findElement(PropertiesRepository.getString("new-atitesting.nclex.tab"));
			if ("LEARN".equalsIgnoreCase(learnTab.getText()) && "TEST".equalsIgnoreCase(testTab.getText())
					&& "IMPROVE".equalsIgnoreCase(improveTab.getText()) && "APPLY".equalsIgnoreCase(applyTab.getText())
					&& "NCLEX® PREP".equalsIgnoreCase(nclexTab.getText())) {
				return true;
			}
		} catch (Exception e) {
			logger.info("Unable to verify Sub Tabs");
			log(logger, "Unable to verify Sub Tabs");
			throw new DriverException("Unable to verify Sub Tabs", e);
		}

		return false;

	}

	public void enterValue(String selector, String text) throws Exception {
		logger.info("Method: enterProctorIDAndPwd Starts");
		try {
			windowHandler.switchToLatestWindow();
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString(selector));
			if (CollectionUtils.isNotEmpty(element)) {
				textHandler.writeText(element.get(0), text.trim());
			}
		} catch (DriverException e) {
			logger.info("Unable to enter Proctor ID And Pwd");
			log(logger, "Unable to enter Proctor ID And Pwd");
			throw new DriverException("Unable to enter Proctor ID And Pwd", e);
		}
		logger.info("Method: enterProctorIDAndPwd End ");
	}

	public boolean verifyProductType(String locator) throws Exception {
		logger.info("Method: verifyProductType Starts");
		try {
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString(locator));
			if (CollectionUtils.isNotEmpty(element) && "Adaptive Test".equalsIgnoreCase(element.get(0).getText())) {

				return true;
			}
		} catch (Exception e) {
			logger.info("Unable to verify Product Type");
			log(logger, "Unable to verify Product Type");
			throw new DriverException("Unable to verify Product Type", e);
		}
		logger.info("Method: verifyProductType End ");
		return false;
	}

	public boolean verifyNclexExpiredDateNew(String name) throws DriverException {
		logger.info("Method: verifyNclexExpiredDate Start ");
		try {
			List<WebElement> moduleList = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.nclex.all.products.loc"));
			if (moduleList != null && moduleList.size() > 0) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					WebElement cardFrontDetails = moduleList.get(i).findElement(By.cssSelector(
							".learn-card-front-wrapper.default-container>section"));
					if (cardFrontDetails != null) {
						WebElement cardFrontName = cardFrontDetails.findElement(By.cssSelector(".description"));
						if (cardFrontName != null) {
							String name1 = cardFrontName.getText();
							if (name1.equalsIgnoreCase(name)) {
								WebElement webEle = moduleList.get(i);
								WebElement continueButton = webEle.findElement(By.cssSelector(PropertiesRepository
										.getString("new-atitesting.nclexprep.cardback.continue.button")));
								WebElement element = webEle.findElement(By.cssSelector(PropertiesRepository
										.getString("new-atitesting.nclexprep.cardback.expired.date")));
								WebElement reNewButton = webEle.findElement(
										By.cssSelector("#renewNCLEX1"));

								if (element.isDisplayed() && reNewButton.isDisplayed()
										&& continueButton.isDisplayed()) {
									reNewButton.click();
									return true;
								}
							}
						}
					}
				}
			}

		} catch (Exception e) {
			logger.info("Unable to verifyNclexExpiredDate");
			log(logger, "Unable to verifyNclexExpiredDate");
			throw new DriverException("Unable to verifyNclexExpiredDate", e);
		}
		return false;
	}

	public boolean verifyNclexExpiredDate(String name) throws DriverException {
		logger.info("Method: verifyNclexExpiredDate Start ");
		try {
			List<WebElement> moduleList = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.nclex.all.products.loc"));
			if (moduleList != null && moduleList.size() > 0) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					WebElement cardFrontDetails = moduleList.get(i).findElement(By.cssSelector(
							"section[class='card front board-vital'] div[class='learn-card-front-wrapper default-container']"));
					if (cardFrontDetails != null) {
						WebElement cardFrontName = cardFrontDetails.findElement(By.cssSelector(".description"));
						if (cardFrontName != null) {
							String name1 = cardFrontName.getText();
							if (name1.equalsIgnoreCase(
									PropertiesRepository.getString("new-atitesting.nclexprep.tab.product.name"))
									|| name.equalsIgnoreCase(PropertiesRepository
											.getString("new-atitesting.nclexprep.tab.rn.product.name"))) {
								WebElement webEle = moduleList.get(i);
								WebElement beginButton = webEle.findElement(By.cssSelector(
										PropertiesRepository.getString("new-atitesting.nclexprep.begin.button")));
								WebElement element = webEle.findElement(By.cssSelector(PropertiesRepository
										.getString("new-atitesting.nclexprep.cardback.expired.date")));
								WebElement reNewButton = webEle.findElement(
										By.cssSelector(".button.primary-button.button-focus.focus-element-flag"));

								if (element.isDisplayed() && reNewButton.isDisplayed() && beginButton.isDisplayed()) {
									reNewButton.click();
									return true;
								}
							}
						}
					}
				}
			}

		} catch (Exception e) {
			logger.info("Unable to verifyNclexExpiredDate");
			log(logger, "Unable to verifyNclexExpiredDate");
			throw new DriverException("Unable to verifyNclexExpiredDate", e);
		}
		return false;
	}

	public boolean verifyNclexAccessNever(String name) throws DriverException {
		logger.info("Method: verifyNclexAccessNever Start ");
		boolean beginFlag = false;
		try {
			List<WebElement> moduleList = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.nclex.all.products.loc"));
			if (moduleList != null && moduleList.size() > 0) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					WebElement cardFrontDetails = moduleList.get(i).findElement(By.cssSelector(
							"section[class='card front board-vital'] div[class='learn-card-front-wrapper default-container']"));
					if (cardFrontDetails != null) {
						WebElement cardFrontName = cardFrontDetails.findElement(By.cssSelector(".description"));
						if (cardFrontName != null) {
							String name1 = cardFrontName.getText();
							if (name1.equalsIgnoreCase(
									PropertiesRepository.getString("new-atitesting.nclexprep.tab.product.name"))
									|| name.equalsIgnoreCase(PropertiesRepository
											.getString("new-atitesting.nclexprep.tab.rn.product.name"))) {
								WebElement webEle = moduleList.get(i);
								List<WebElement> beginButtonList = webEle.findElements(By.cssSelector(".actions div"));
								if (CollectionUtils.isNotEmpty(beginButtonList)) {
									int divSize = beginButtonList.size();
									for (int index = 0; index < divSize; index++) {
										WebElement style = beginButtonList.get(index);
										if (style != null) {
											String styleValue = style.getAttribute("style");
											if (StringUtils.isBlank(styleValue)
													&& !styleValue.equalsIgnoreCase("display: none;")
													&& "Begin".equalsIgnoreCase(
															style.findElement(By.cssSelector("span")).getText())) {
												beginFlag = true;
												break;
											}
										}
									}
								}
								WebElement footerElement = webEle.findElement(By.cssSelector("footer span"));
								WebElement infoIcon = webEle
										.findElement(By.cssSelector("#tabs-6 .icon.focus-element-flag"));

								if (infoIcon.isDisplayed() && beginFlag && footerElement.isDisplayed()) {
									return true;
								}
							}
						}
					}
				}
			}

		} catch (Exception e) {
			logger.info("Unable to verifyNclexAccessNever");
			log(logger, "Unable to verifyNclexAccessNever");
			throw new DriverException("Unable to verifyNclexAccessNever", e);
		}
		logger.info("verifyNclexAccessNever End");
		return false;
	}
	
	

	public boolean verifyDisabledNclex() throws DriverException {
		logger.info("Method: verifyDisabledNclex Start ");
		boolean flag = false;
		try {
			List<WebElement> moduleList = baseHandler
					.findElements("#tabs-6 ul li section div[class='disabled-background-tab2']");
			if (CollectionUtils.isEmpty(moduleList)) {
				List<WebElement> disabledElement = baseHandler
						.findElements("#tabs-6 .question-option.disabled-checkbox>label");
				if (CollectionUtils.isNotEmpty(disabledElement)) {
					disabledElement.get(0).click();
					List<WebElement> moduleList1 = baseHandler
							.findElements("#tabs-6 ul li section div[class='disabled-background-tab2']");
					if (CollectionUtils.isNotEmpty(moduleList1) && moduleList1.size() > 0) {
						flag = true;
					}
				}
			} else {
				if (moduleList != null && moduleList.size() > 0) {
					flag = true;
				}
			}

		} catch (Exception e) {
			logger.info("Unable to verifyDisabledNclex");
			log(logger, "Unable to verifyDisabledNclex");
			throw new DriverException("Unable to verifyDisabledNclex", e);
		}
		logger.info("verifyDisabledNclex End flag --> " + flag);
		return flag;
	}

	public boolean verifyNclexExpiredAssessment(String name) throws DriverException {
		logger.info("Method: verifyNclexExpiredAssessment Start ");
		boolean beginFlag = false;
		try {
			List<WebElement> moduleList = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.nclex.all.products.loc"));
			if (moduleList != null && moduleList.size() > 0) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					WebElement cardFrontDetails = moduleList.get(i).findElement(By.cssSelector(
							".learn-card-front-wrapper.default-container>section"));
					if (cardFrontDetails != null) {
						WebElement cardFrontName = cardFrontDetails.findElement(By.cssSelector(".description"));
						if (cardFrontName != null) {
							String name1 = cardFrontName.getText();
							if (name1.equalsIgnoreCase(
									PropertiesRepository.getString("new-atitesting.nclexprep.tab.product.name.new"))
									|| name.equalsIgnoreCase(PropertiesRepository
											.getString("new-atitesting.nclexprep.tab.rn.product.name"))) {
								WebElement webEle = moduleList.get(i);
								List<WebElement> beginButtonList = webEle.findElements(By.cssSelector(".actions div"));
								if (CollectionUtils.isNotEmpty(beginButtonList)) {
									int divSize = beginButtonList.size();
									for (int index = 0; index < divSize; index++) {
										WebElement style = beginButtonList.get(index);
										if (style != null) {
											String styleValue = style.getAttribute("style");
											if (StringUtils.isBlank(styleValue)
													&& !styleValue.equalsIgnoreCase("display: none;")
													&& ("Begin".equalsIgnoreCase(
															style.findElement(By.cssSelector("span")).getText())
															|| "Continue".equalsIgnoreCase(style
																	.findElement(By.cssSelector("span")).getText()))) {
												beginFlag = true;
												break;
											}
										}
									}
								}
								WebElement element = webEle.findElement(By.cssSelector(PropertiesRepository
										.getString("new-atitesting.nclexprep.cardback.expired.date")));
								WebElement reNewButton = webEle.findElement(
										By.cssSelector("#renewNCLEX1"));

								if (element.isDisplayed() && reNewButton.isDisplayed() && beginFlag) {
									return true;
								}
							}
						}
					}
				}
			}

		} catch (Exception e) {
			logger.info("Unable to verifyNclexExpiredAssessment");
			log(logger, "Unable to verifyNclexExpiredAssessment");
			throw new DriverException("Unable to verifyNclexExpiredAssessment", e);
		}
		return false;
	}

	public boolean verifyRenewSubscriptionPage() throws DriverException {
		logger.info("Method: verifyRenewSubscriptionPage Starts");
		try {
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			List<WebElement> elements = baseHandler.findElements(
					PropertiesRepository.getString("new-atitesting.nclexprep.renew.subscription.page.loc"));
			String text = elements.get(1).getText();
			String[] split = text.split("\\.");
			if (CollectionUtils.isNotEmpty(elements) && elements.size() == 4 && split[0].equalsIgnoreCase("$42")) {
				return true;
			}
		} catch (Exception e) {
			logger.info("Unable to verify Renew Subscription Page");
			log(logger, "Unable to verify Renew Subscription Page");
			throw new DriverException("Unable to verify Renew Subscription Page", e);
		}

		logger.info("Method: verifyRenewSubscriptionPage End");
		return false;
	}

	public void enterCardDerailsForReNewPage() throws DriverException {
		logger.info("Method: enterCardDerailsForReNewPage Starts");
		try {
			windowHandler.switchToMainWindow();
			windowHandler.switchToFrame("paymentFrame");
			windowHandler.switchToFrame("braintree-dropin-frame");
			WebElement cardDetails = baseHandler
					.findElement(PropertiesRepository.getString("new-atitesting.nclexprep.renew.subscription.card.no"));
			WebElement date = baseHandler.findElement(
					PropertiesRepository.getString("new-atitesting.nclexprep.renew.subscription.expired.date"));
			WebElement cvvNo = baseHandler
					.findElement(PropertiesRepository.getString("new-atitesting.nclexprep.renew.subscription.cvv"));

			if (cardDetails != null && date != null && cvvNo != null) {
				cardDetails.sendKeys(PropertiesRepository.getString("newati.payment.credit.card.details"));
				date.sendKeys(PropertiesRepository
						.getString("new-atitesting.nclexprep.renew.subscription.expired.date.info"));
				cvvNo.sendKeys(PropertiesRepository.getString("newati.payment.credit.card.cvv.info"));
				cvvNo.sendKeys(Keys.TAB);

			}
		} catch (Exception e) {
			logger.info("Unable to enter Card Derails For ReNewPage");
			log(logger, "Unable to enter Card Derails For ReNewPage");
			throw new DriverException("Unable to enter Card Derail sFor ReNewPage", e);
		}

	}

	/**
	 * Verify if enabled Board Vitals are displayed
	 * 
	 * 
	 * @author syed.pasha
	 * @throws DriverException
	 */
	public boolean VerifyIfEnabledBoardVitalsIsDisplayed() throws Exception {
		logger.info("Method: VerifyIfEnabledBoardVitalsIsDisplayed Start");
		boolean flag = false;
		try {

			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver driver) {
					WebElement button = driver.findElement(By.cssSelector("div[data-bind='visible: IsTab6Loading']"));
					String enabled = button.getAttribute("style");
					if (enabled.equals("display: none;")) {
						logger.info("Products load complete.");
						return true;
					} else {
						logger.info("Products are still loading......");
						return false;
					}
				}
			});
			Thread.sleep(3000);
			List<WebElement> moduleList = baseHandler.findElements(".flipper section[class='card front board-vital']");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				flag = true;
			}
		} catch (Exception e) {
			logger.info("There are no enabled Board Vitals");
			throw new Exception("There are no enabled Board Vitals");
		}
		logger.info("Method: VerifyIfEnabledBoardVitalsIsDisplayed End --> " + flag);
		return flag;
	}

	/**
	 * Method used to click Begin/ Continue Lesson for NCLEX Card back based on
	 * Module Name.
	 * 
	 * @author saravanan.jothimani
	 * @param moduleName
	 * @throws Exception
	 */
	public void clickNCLEXModuleName(String moduleName, String buttonStatus) throws Exception {
		logger.info("Method : clickNCLEXModuleName Start");
		try {
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.nclex.card.back.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				for (WebElement moduleElement : element) {
					String moduleNamePage = moduleElement.findElement(By.cssSelector("li header span")).getText()
							.trim();
					if (StringUtils.isNotEmpty(moduleNamePage) && moduleNamePage.equalsIgnoreCase(moduleName)) {
						List<WebElement> lessonButtonList = moduleElement.findElements(By.cssSelector(
								PropertiesRepository.getString("new-atitesting.nclex.card.front.module.button.loc")));
						if (CollectionUtils.isNotEmpty(lessonButtonList)) {
							for (WebElement lessonButton : lessonButtonList) {
								String styleAttribute = lessonButton.getAttribute("style");
								if (StringUtils.isEmpty(styleAttribute)) {
									WebElement lessonButtonClick = lessonButton.findElement(By.cssSelector("a"));
									if (lessonButtonClick != null
											&& lessonButtonClick.getText().trim().contains(buttonStatus)) {
										lessonButtonClick.click();
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
			logger.info("Unable to clickNCLEXModuleName");
			log(logger, "Unable to clickNCLEXModuleName");
			throw new DriverException("Unable to clickNCLEXModuleName", e);
		}
		logger.info("Method: clickNCLEXModuleName End flag");
	}

	public String getModuleCount(String assessmentName) throws Exception {
		logger.info("Method : getModuleCount Start");
		String result = null;
		try {
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.nclex.all.products.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				for (WebElement allElement : element) {
					String name = allElement.findElement(By.cssSelector(".description")).getText().trim();
					if (StringUtils.isNotBlank(name) && name.equalsIgnoreCase(assessmentName)) {
						result = allElement.findElement(By.cssSelector(".actions div a[id^='NCLEXButtonText'] div"))
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

	/**
	 * Verify if RN Live Review tutorials are displayed
	 * 
	 * 
	 * @author syed.pasha
	 * @throws DriverException
	 */
	public boolean VerifyIfRNLiveTutorialsDisplayed() throws Exception {
		logger.info("Method: VerifyIfRNLiveTutorialsDisplayed Start");
		boolean flag = false;
		try {

			List<WebElement> moduleList = baseHandler.findElements(".flipper section[class='card front tutorial']");
			for (int i = 0; i < moduleList.size(); i++) {
				if (CollectionUtils.isNotEmpty(moduleList) && (moduleList.get(i).findElement(By.cssSelector(".description")).getText().contains("RN Live Review Tutorial"))){
					flag = true;
					break;
				}				
			}			
		} catch (Exception e) {
			logger.info("There are no enabled RN live tutorials");
			throw new Exception("There are no enabled RN live tutorials");
		}
		logger.info("Method: VerifyIfRNLiveTutorialsDisplayed End --> " + flag);
		return flag;
	}
	
	/**
	 * Verify if NCLEX-RN Live Review tutorials are displayed
	 * 
	 * 
	 * @author syed.pasha
	 * @throws DriverException
	 */
	public boolean VerifyIfNCLEXRNLiveTutorialNewDisplayed() throws Exception {
		logger.info("Method: VerifyIfNCLEXRNLiveTutorialNewDisplayed Start");
		boolean flag = false;
		try {

			List<WebElement> moduleList = baseHandler.findElements(".flipper section[class='card front tutorial']");
			for (int i = 0; i < moduleList.size(); i++) {
				if (CollectionUtils.isNotEmpty(moduleList) && (moduleList.get(i).findElement(By.cssSelector(".description")).getText().equals(
						PropertiesRepository.getString("new.atitestig.nclex.cardfront.product.name")))){
					flag = true;
					break;
				}				
			}			
		} catch (Exception e) {
			logger.info("There are no enabled NCLEX-RN live tutorials");
			throw new Exception("There are no enabled NCLEX-RN live tutorials");
		}
		logger.info("Method: VerifyIfNCLEXRNLiveTutorialNewDisplayed End --> " + flag);
		return flag;
	}
	
	/**
	 * Verify if NCLEX-RN Live Review tutorials are displayed
	 * 
	 * 
	 * @author syed.pasha
	 * @throws DriverException
	 */
	public boolean VerifyIfNCLEXRNLiveTutorialNewDisplayed(String tutorialName) throws Exception {
		logger.info("Method: VerifyIfNCLEXRNLiveTutorialNewDisplayed Start");
		boolean flag = false;
		try {
			List<WebElement> moduleList = baseHandler.findElements(PropertiesRepository.getString("new.atitestig.nclex.cardfront.product.name.loc"));
			for (int i = 0; i < moduleList.size(); i++) {
				if (CollectionUtils.isNotEmpty(moduleList)
						&& (moduleList.get(i).findElement(By.cssSelector(".description")).getText().equals(
								PropertiesRepository.getString("new.atitestig.nclex.cardfront.product.name")))) {
					flag = true;
					break;
				}				
			}			
		} catch (Exception e) {
			logger.info("There are no enabled NCLEX-RN live tutorials");
			throw new Exception("There are no enabled NCLEX-RN live tutorials");
		}
		logger.info("Method: VerifyIfNCLEXRNLiveTutorialNewDisplayed End --> " + flag);
		return flag;
	}
	
	/**
	 * Verify if PN Live Review tutorials are displayed
	 * 
	 * 
	 * @author syed.pasha
	 * @throws DriverException
	 */
	public boolean VerifyIfPNLiveTutorialsDisplayed() throws Exception {
		logger.info("Method: VerifyIfPNLiveTutorialsDisplayed Start");
		boolean flag = false;
		try {

			List<WebElement> moduleList = baseHandler.findElements(".flipper section[class='card front tutorial']");
			for (int i = 0; i < moduleList.size(); i++) {
				if (CollectionUtils.isNotEmpty(moduleList) && (moduleList.get(i).findElement(By.cssSelector(".description")).getText().contains("PN Live Review Tutorial"))){
					flag = true;
					break;
				}				
			}			
		} catch (Exception e) {
			logger.info("There are no enabled PN live tutorials");
			throw new Exception("There are no enabled PN live tutorials");
		}
		logger.info("Method: VerifyIfPNLiveTutorialsDisplayed End --> " + flag);
		return flag;
	}
	

	/*
	 * Verify Available date for Board Vitals
	 * 
	 * @author syed.pasha
	 */
	public boolean verifyAvailableDateNclex(String BVname, String availableDate) throws DriverException {
		logger.info("Method: verifyAvailableDateNclex Start ");
		boolean flag = false;
		try {
			List<WebElement> moduleList = baseHandler
					.findElements("#tabs-6 ul li section div[class='disabled-background-tab2']");
			for (int i = 0; i < moduleList.size(); i++) {
				if (CollectionUtils.isNotEmpty(moduleList)
						&& (moduleList.get(i).findElement(By.cssSelector(".description")).getText().contains(BVname))
						&& (moduleList.get(i).findElement(By.cssSelector("span[data-bind$='AvailableOnDate()']"))
								.getText().contains(availableDate))) {
					flag = true;
					break;
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verifyAvailableDateNclex");
			log(logger, "Unable to verifyAvailableDateNclex");
			throw new DriverException("Unable to verifyAvailableDateNclex", e);
		}
		logger.info("verifyAvailableDateNclex End flag --> " + flag);
		return flag;
	}
	
	
	public boolean verifyExpiresDateNclexInavtiveProd(String BVname, String expiresDate) throws DriverException {
		logger.info("Method: verifyExpiresDateNclex Start ");
		boolean flag = false;
		try {
			List<WebElement> moduleList = baseHandler.findElements("#tabs-6 ul li section div[class='disabled-background-tab2']");
			for (int i = 0; i < moduleList.size(); i++) {
				if (CollectionUtils.isNotEmpty(moduleList)
						&& (moduleList.get(i).findElement(By.cssSelector(".description")).getText().contains(BVname))
						&& (moduleList.get(i).findElement(By.cssSelector("section span span"))
								.getText().contains(expiresDate))) {
					flag = true;
					break;
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verifyExpiresDateNclex");
			log(logger, "Unable to verifyExpiresDateNclex");
			throw new DriverException("Unable to verifyExpiresDateNclex", e);
		}
		logger.info("verifyExpiresDateNclex End flag --> " + flag);
		return flag;
	}
	
	/*
	 * Verify Expires date for Board Vitals
	 * 
	 * @author syed.pasha
	 */
	public boolean verifyExpiresDateNclex(String BVname, String expiresDate) throws DriverException {
		logger.info("Method: verifyExpiresDateNclex Start");
		boolean flag = false;
		try {
			List<WebElement> moduleList = baseHandler.findElements("#tabs-6 .card.front.board-vital");
			for (int i = 0; i < moduleList.size(); i++) {
				if (CollectionUtils.isNotEmpty(moduleList)
						&& (moduleList.get(i).findElement(By.cssSelector(".description")).getText().contains(BVname))
						&& (moduleList.get(i).findElement(By.cssSelector(".teas-expired span"))
								.getText().contains(expiresDate))) {
					flag = true;
					break;
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verifyExpiresDateNclex");
			log(logger, "Unable to verifyExpiresDateNclex");
			throw new DriverException("Unable to verifyExpiresDateNclex", e);
		}
		logger.info("verifyExpiresDateNclex End flag --> " + flag);
		return flag;
	}
	
	/*
	 * Verify Accesses tetus for Board Vitals
	 * 
	 * @author syed.pasha
	 */
	public boolean verifyAccessedStatusNclex(String BVname, String accessedStatus) throws DriverException {
		logger.info("Method: verifyAccessedStatusNclex Start ");
		boolean flag = false;
		try {
			List<WebElement> moduleList = baseHandler
					.findElements("#tabs-6 ul li section div[class='disabled-background-tab2']");
			for (int i = 0; i < moduleList.size(); i++) {
				if (CollectionUtils.isNotEmpty(moduleList)
						&& (moduleList.get(i).findElement(By.cssSelector(".description")).getText().contains(BVname))
						&& (moduleList.get(i).findElement(By.cssSelector(".time-accessed span"))
								.getText().contains(accessedStatus))) {
					flag = true;
					break;
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verifyAccessedStatusNclex");
			log(logger, "Unable to verifyAccessedStatusNclex");
			throw new DriverException("Unable to verifyAccessedStatusNclex", e);
		}
		logger.info("verifyAccessedStatusNclex End flag --> " + flag);
		return flag;
	}
	
	/*
	 * Verify if Product is displayed
	 * 
	 * @author syed.pasha
	 */
	public boolean verifyProductIsDiasplayed(String productName, String loc) throws DriverException {
		logger.info("Method: verifyProductIsDiasplayed Start ");
		boolean flag = false;
		try {
			List<WebElement> moduleList = baseHandler.findElements(loc);
			if (moduleList != null) {			
			for (int i = 0; i < moduleList.size(); i++) {
				if (CollectionUtils.isNotEmpty(moduleList)	&& (moduleList.get(i).getText().contains(productName)) && moduleList.get(i).isDisplayed()) {
					flag = true;
					break;
				}
			}
			}
		} catch (Exception e) {
			logger.info("Unable to verifyProductIsDiasplayed");
			log(logger, "Unable to verifyProductIsDiasplayed");
			throw new DriverException("Unable to verifyProductIsDiasplayed", e);
		}
		logger.info("verifyProductIsDiasplayed End flag --> " + flag);
		return flag;
	}
	
	/*
	 * Verify Online Store , GC and CC Details
	 * 
	 * Test Data needs to be as below format for this method to work (ID's and Date can be dynamic)
	 	
	 	1.online store(id:ORD1846640 )

		Expired on: 6/5/2018 , Renew button shoud be displayed

		2.GC(CDN005387528-TUT322366)

		Accessed: Never ,Expires on: 9/12/2018

		Verify Begin/continue button displays

		3.CC(CDN005387730-TUT322394)
		Available: 2/14/2019,Expires on: 8/13/2019
	 
	 * @author syed.pasha
	 */
	public boolean verifyOnlineStoreGCandCCDetails(String osExpiredOnRenewBtnID, String osExpiredOnDate,
			String gcAccessedNeverExpiresOnID, String gcAccessed, String gcExpiresOnDate, String ccAvailableExpiresOnID ,String ccAvailableDate ,String ccExpiresOnDate)
			throws DriverException {
		logger.info("Method: verifyOnlineProdGCandCCDetails Start");
		boolean flag = false;
		boolean osExpiredOnRenewBtnFlag = false;
		boolean gcAccessedNeverExpiresOnFlag = false;
		boolean ccAvailableExpiresOnFlag = false;

		try {
			List<WebElement> moduleList = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.model.window.products.loc"));
			for (int i = 0; i < moduleList.size(); i++) {
				List<WebElement> expireDates = moduleList.get(i).findElements(By.cssSelector(".time-suggested-spent"));
				if (CollectionUtils.isNotEmpty(moduleList) && (moduleList.get(i)
						.findElement(By.cssSelector(
								PropertiesRepository.getString("new-atitesting.model.window.products.ID.loc")))
						.getText().equals(osExpiredOnRenewBtnID))) {
					if (moduleList.get(i)
							.findElement(By.cssSelector(PropertiesRepository
									.getString("new-atitesting.model.window.products.renew.btn.loc")))
							.isDisplayed()
							&& moduleList.get(i)
									.findElement(By.cssSelector(PropertiesRepository
											.getString("new-atitesting.model.window.products.expiresOn.loc")))
									.getText().equals("Expired on: "+osExpiredOnDate))
							{

						osExpiredOnRenewBtnFlag = true;
					}
				}
				else if (CollectionUtils.isNotEmpty(moduleList) && (moduleList.get(i)
						.findElement(By.cssSelector(
								PropertiesRepository.getString("new-atitesting.model.window.products.ID.loc")))
						.getText().equals(gcAccessedNeverExpiresOnID))) {
					if (moduleList.get(i)
							.findElement(By.cssSelector(PropertiesRepository
									.getString("new-atitesting.model.window.products.accessed.loc")))
							.getText().equals("Accessed: "+gcAccessed)
							&& expireDates.get(1).findElement(By.cssSelector("span")).getText().equals("Expires on: "+gcExpiresOnDate)) {

						gcAccessedNeverExpiresOnFlag = true;
					}
				}
				else if (CollectionUtils.isNotEmpty(moduleList) && (moduleList.get(i)
						.findElement(By.cssSelector(
								PropertiesRepository.getString("new-atitesting.model.window.products.ID.loc")))
						.getText().equals(ccAvailableExpiresOnID))) {
					if (moduleList.get(i).findElement(By.cssSelector("span[data-bind$='AvailableOnDate()']")).isDisplayed() 
							&& moduleList.get(i).findElement(By.cssSelector("span[data-bind$='AvailableOnDate()']"))
							.getText().equals("Available: "+ccAvailableDate)
							&& expireDates.get(1).findElement(By.cssSelector("span")).getText().equals("Expires on: "+ccExpiresOnDate)) {

						ccAvailableExpiresOnFlag = true;
					}
				}				
			}			
			if(osExpiredOnRenewBtnFlag && gcAccessedNeverExpiresOnFlag && ccAvailableExpiresOnFlag){
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to verifyOnlineStoreGCandCCDetails");
			log(logger, "Unable to verifyOnlineStoreGCandCCDetails");
			throw new DriverException("Unable to verifyOnlineStoreGCandCCDetails", e);
		}
		logger.info("verifyOnlineProdGCandCCDetails End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to veriy header name in card back. 
	 * 
	 * @author saravanan.jothimani
	 * @param cardBackName
	 * @return
	 * @throws Exception
	 */
	
	public boolean verifyCardBackHeaderSection(String cardBackName) throws Exception {
		logger.info("Method : verifyCardBackHeaderSection Start");
		logger.info("cardBackName value --> " + cardBackName);
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.learntab.tutorial.stt.card.back.header.loc"));
			if(CollectionUtils.isNotEmpty(element) && element.get(0).getText().trim().equalsIgnoreCase(cardBackName)) {
					flag = true;
				}
		}catch (Exception e) {
    		logger.info("Unable to verifyCardBackHeaderSection" );
			log(logger, "Unable to verifyCardBackHeaderSection" );
    		throw new DriverException("Unable to verifyCardBackHeaderSection" , e); 
    	}
		logger.info("Method: verifyCardBackHeaderSection End flag --> " + flag);
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
	public boolean verifyCardBackIndividualModuleText(int index) throws Exception {
		logger.info("Method : verifyCardBackIndividualModuleText Start");
		logger.info("index value --> " + index);
		String spanText = null;
		String divText = null;
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.nclex.card.back.with.li.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				List<WebElement> spanElement = element.get(index).findElements(By.cssSelector(PropertiesRepository.getString("new.atitestig.nclex.cardback.individual.text.span.loc")));
				List<WebElement> divElement = element.get(index).findElements(By.cssSelector(PropertiesRepository.getString("new.atitestig.nclex.cardback.individual.text.div.loc")));
				if(CollectionUtils.isNotEmpty(spanElement) && CollectionUtils.isNotEmpty(divElement)) {
					
					if(index == 0) {
						StringBuilder sbIndex0 = new StringBuilder(PropertiesRepository.getString("new.atitestig.nclex.cardback.section1.value"));
						sbIndex0.append(", ").append(PropertiesRepository.getString("new.atitestig.nclex.cardback.section1.value1"))
						.append(", ").append(PropertiesRepository.getString("new.atitestig.nclex.cardback.section1.value2"));
						divText = sbIndex0.toString();
						spanText = PropertiesRepository.getString("new.atitestig.nclex.cardback.section1.header.value");
					} else if(index == 2) {
						StringBuilder sbIndex2 = new StringBuilder(PropertiesRepository.getString("new.atitestig.nclex.cardback.section3.value"));
						sbIndex2.append(", ").append(PropertiesRepository.getString("new.atitestig.nclex.cardback.section3.value1"));
						divText = sbIndex2.toString();
						spanText = PropertiesRepository.getString("new.atitestig.nclex.cardback.section3.header.value");
					} else {
						divText = divElement.get(0).getText().trim();
						spanText = PropertiesRepository.getString("new.atitestig.nclex.cardback.section2.header.value");
					}
					
					if(spanElement.get(0).getText().trim().equalsIgnoreCase(spanText) && 
							divText.equalsIgnoreCase(divElement.get(0).getText().trim())) {
						flag = true;
					} else {
						logger.info("Both header and its text values are not matched");
					}
				} else {
					logger.info("Header and its text are not displayed");
				}
			} else {
				logger.info("Unable to get locator values in verifyCardBackIndividualModuleText");
			}
		}catch (Exception e) {
    		logger.info("Unable to verifyCardBackIndividualModuleText" );
			log(logger, "Unable to verifyCardBackIndividualModuleText" );
    		throw new DriverException("Unable to verifyCardBackIndividualModuleText" , e); 
    	}
		logger.info("Method: verifyCardBackIndividualModuleText End flag --> " + flag);
		return flag;
	}
	
	public boolean verifyCardBackAdvertisementSection() throws Exception {
		logger.info("Method : verifyCardBackAdvertisementSectionStart");
		boolean flag = false;
		boolean leftSecTopbool = false;
		boolean leftSecBotbool = false; 
		boolean rightSecTopbool = false;
		boolean rightSecBotbool = false;
		
		try {
			List<WebElement> leftSecTop = baseHandler.findElements(PropertiesRepository.getString("new.atitestig.nclex.cardback.experience.left.section.topvalue.loc"));
			List<WebElement> leftSecBot = baseHandler.findElements(PropertiesRepository.getString("new.atitestig.nclex.cardback.experience.left.section.bottomvalue.loc"));
			List<WebElement> rightSecTop = baseHandler.findElements(PropertiesRepository.getString("new.atitestig.nclex.cardback.experience.right.section.topvalue.loc"));
			
			if(CollectionUtils.isNotEmpty(leftSecTop) && leftSecTop.get(0).getText().replace("\n", " ").trim().equalsIgnoreCase(PropertiesRepository.getString("new.atitestig.nclex.cardback.experience.left.section.topvalue.value"))) {
				leftSecTopbool = true;
				logger.info("leftSecTopbool --> " + leftSecTopbool);
			}
			
			if(CollectionUtils.isNotEmpty(leftSecBot)) {
				String leftSecBotValue = leftSecBot.get(0).getText().replace("\n", " ").trim();
				StringBuilder sb1 = new StringBuilder(PropertiesRepository.getString("new.atitestig.nclex.cardback.experience.left.section.bottomvalue.value1"));
				sb1.append(", ").append(PropertiesRepository.getString("new.atitestig.nclex.cardback.experience.left.section.bottomvalue.value2"));
				if(leftSecBotValue.equalsIgnoreCase(sb1.toString())) {
					leftSecBotbool = true;
					logger.info("leftSecBotbool --> " + leftSecBotbool);
				}
			}
			if(CollectionUtils.isNotEmpty(rightSecTop)) {
				String rightSecTopValue = rightSecTop.get(0).getText();
				StringBuilder sb = new StringBuilder(PropertiesRepository.getString("new.atitestig.nclex.cardback.experience.right.section.topvalue.value1"));
				sb.append(", ").append(PropertiesRepository.getString("new.atitestig.nclex.cardback.experience.right.section.topvalue.value2"));
				if(rightSecTopValue.equalsIgnoreCase(sb.toString())) {
					rightSecTopbool = true;
					logger.info("rightSecTopbool --> " + rightSecTopbool);
				}
				
				rightSecBotbool = rightSecTop.get(1).findElement(By.cssSelector("button")).isDisplayed();
				logger.info("rightSecBotbool --> " + rightSecBotbool);
			}
			
			if(leftSecTopbool && leftSecBotbool && rightSecTopbool && rightSecBotbool) {
				flag = true;
			}
		}catch (Exception e) {
    		logger.info("Unable to verifyCardBackAdvertisementSection" );
			log(logger, "Unable to verifyCardBackAdvertisementSection" );
    		throw new DriverException("Unable to verifyCardBackAdvertisementSection" , e); 
    	}
		logger.info("Method: verifyCardBackAdvertisementSection End flag --> " + flag);
		return flag;
	}
	
	public boolean clickExpBuyButton() throws Exception {
		logger.info("Method : clickExpBuyButtonStart");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("new.atitestig.nclex.cardback.experience.right.section.topvalue.loc"));
			if(CollectionUtils.isNotEmpty(element)) {
				WebElement buyButtonElement = element.get(1).findElement(By.cssSelector("button"));
				if(buyButtonElement != null) {
					buyButtonElement.click();
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
					flag = true;
				}
			}
		}catch (Exception e) {
    		logger.info("Unable to clickExpBuyButton" );
			log(logger, "Unable to clickExpBuyButton" );
    		throw new DriverException("Unable to clickExpBuyButton" , e); 
    	}
		logger.info("Method: clickExpBuyButton End flag --> " + flag);
		return flag;
	}
	
	public boolean verifyOnlinStoreURL() throws Exception {
		logger.info("Method : verifyOnlinStoreURL Start");
		boolean flag = false;
		try {
			windowHandler.switchToLatestWindow();
			String url = driver.getCurrentUrl();
			if(url.contains("stage-www.atitesting.com") && url.contains("1507")) {
				flag = true;
			}
		}catch (Exception e) {
    		logger.info("Unable to verifyOnlinStoreURL" );
			log(logger, "Unable to verifyOnlinStoreURL" );
    		throw new DriverException("Unable to verifyOnlinStoreURL" , e); 
    	}
		logger.info("Method: verifyOnlinStoreURL End flag --> " + flag);
		return flag;
	}
	
	/**
	 * 
	 * @throws DriverException
	 */
	public boolean clickNCLEXNameFromCardBack() throws Exception {
		logger.info("Method: clickNCLEXNameFromCardBack Start");
		boolean flag = false;
		boolean nameFlag = false;
		boolean closeFlag = false;
		try {
			List<WebElement> moduleList = baseHandler.findElements("#productTutorialModuleList .product-list-style li");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
						if (size == 1) {
							List<WebElement> moduleNameList = moduleList.get(i).findElements(By.cssSelector("div a[class='button primary-button focus-element-flag']"));
							if(CollectionUtils.isNotEmpty(moduleNameList)) {
								//((JavascriptExecutor)driver).executeScript("arguments[0].click();", moduleNameList.get(0));
								moduleNameList.get(0).click();
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								
								// Swithcing to new window
								windowHandler.switchToLatestWindow();
								switchToContentFrame();
								logger.info("Verifying NCLEX Name");
								List<WebElement> nclexName = baseHandler.findElements("div[class='leftjustified module-info'] span");
								if(CollectionUtils.isNotEmpty(nclexName)) {
									if(nclexName.get(4).getText().equalsIgnoreCase("NCLEX-RN Live Review Tutorial")) {
										logger.info("Verified NCLEX name");
										nameFlag = true;
									}
								}
								
								logger.info("Clicking on Close button");
								List<WebElement> closeBtnElement = baseHandler.findElements("button[class='close-button focus-element-flag']");
								if(CollectionUtils.isNotEmpty(closeBtnElement)) {
									logger.info("Clicked on Close Button");
									closeBtnElement.get(0).click();
									closeFlag = true;
									windowHandler.switchToLatestWindow();
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								}
								logger.info("Clicking on Dismiss button");
							}
						}
				}
				if(nameFlag && closeFlag) {
					flag = true;
				}
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			}
		}catch (Exception e) {
    		logger.info("Unable to clickNCLEXNameFromCardBack" );
			log(logger, "Unable to clickNCLEXNameFromCardBack" );
    		throw new DriverException("Unable to clickNCLEXNameFromCardBack" , e); 
    	}
		logger.info("clickNCLEXNameFromCardBack End flag --> " + flag);
		return flag;
	}
	
	public void switchToContentFrame() throws Exception {
		logger.info("Method : switchToContentFrame Start");
		try {
			WebElement frameElement = driver.findElement(By.cssSelector("#contentFrame"));
			driver.switchTo().frame(frameElement);
		} catch (Exception e) {
			logger.info("Unable to ");
			log(logger, "Unable to ");
			throw new DriverException("Unable to ", e);
		}
		logger.info("Method: switchToContentFrame End");

	}

}

