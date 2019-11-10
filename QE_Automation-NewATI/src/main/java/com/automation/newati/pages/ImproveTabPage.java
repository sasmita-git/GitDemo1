package com.automation.newati.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.DropDownHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;

public class ImproveTabPage extends ImproveTabPage2 {

	private Logger logger = LogManager.getLogger(this.getClass());
	private BaseHandler baseHandler;
	private DropDownHandler dropDownHandler;
	private WindowHandler windowHandler;
	
	public ImproveTabPage(WebDriver webDriver) {
		super(webDriver);
		baseHandler = new BaseHandler(driver);
		dropDownHandler = new DropDownHandler(driver);
		windowHandler = new WindowHandler(driver);
	}

	/**
	 * Method used to verify Custom Assessment.
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws Exception
	 */
	public boolean verifyCustomAssessmentDetails() throws Exception {
		logger.info("Method : verifyCustomAssessmentDetails Start");
		boolean flag = false;
		boolean headerFlag = false;
		boolean nameFlag = false;

		try {
			// Getting all tables headers under improve tab.
			List<WebElement> element = baseHandler.findElements(
					PropertiesRepository.getString("new-atitesting.improve.tab.assessment.all.list.with.name.loc"));

			List<WebElement> tableElement = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.improve.tab.assessment.all.list.loc"));

			if (CollectionUtils.isNotEmpty(element) && CollectionUtils.isNotEmpty(tableElement)) {
				for (WebElement improveElement : element) {
					if (improveElement.getText().trim().equalsIgnoreCase(PropertiesRepository
							.getString("new-atitesting.improve.tab.assessment.list.header.value"))) {
						headerFlag = true;
					} else {
						logger.info("Unable to verify custom assessment header");
					}
				}
			} else {
				logger.info("Unable to get improve tab");
			}

			for (WebElement custAssessmentNameElement : tableElement) {
				// Verifying Custom Assessment name
				List<WebElement> customNameElement = custAssessmentNameElement.findElements(By.cssSelector(
						PropertiesRepository.getString("new-atitesting.improve.tab.assessment.sub.list.name.loc")));
				if (CollectionUtils.isNotEmpty(customNameElement)) {
					for (WebElement nameElement : customNameElement) {
						if (nameElement.getText().trim()
								.equalsIgnoreCase(PropertiesRepository
										.getString("new-atitesting.improve.tab.custom.assessment.name1.value"))
								|| nameElement.getText().trim()
										.equalsIgnoreCase(PropertiesRepository
												.getString("new-atitesting.improve.tab.custom.assessment.name2.value"))
								|| nameElement.getText().trim().equalsIgnoreCase(PropertiesRepository
										.getString("new-atitesting.improve.tab.custom.assessment.name3.value"))) {
							nameFlag = true;
						}
					}
				} else {
					logger.info("Unable to verify custom assessment name");
				}
			}
			if (headerFlag && nameFlag) {
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to verifyCustomAssessmentDetails");
			log(logger, "Unable to verifyCustomAssessmentDetails");
			throw new DriverException("Unable to verifyCustomAssessmentDetails", e);
		}
		logger.info("Method: verifyCustomAssessmentDetails End flag --> " + flag);
		return flag;
	}

	/**
	 * Getting Attempt 1 value from drop down.
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws Exception
	 */
	public boolean verifyAttemptDDValue(String assessmentName) throws Exception {
		logger.info("Method : verifyAttemptDDValue Start");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.improve.tab.assessment.all.list.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				for (WebElement attemptElement : element) {
					// Verifying name.
					WebElement nameElement = attemptElement.findElement(By.cssSelector(
							PropertiesRepository.getString("new-atitesting.improve.tab.assessment.name.loc")));
					if (nameElement != null && nameElement.getText().trim().equalsIgnoreCase(assessmentName)) {
						// Verifying values in Attempt DD.
						WebElement attemptDDElement = attemptElement.findElement(By.cssSelector(PropertiesRepository
								.getString("new-atitesting.improve.tab.assessment.attempt.drop.down.loc")));
						List<WebElement> ddValue = dropDownHandler.getOptions(attemptDDElement);
						for (WebElement item : ddValue) {
							if (PropertiesRepository.getString("new-atitesting.improve.tab.fr.2.0.attempt1.value")
									.equalsIgnoreCase(item.getText())) {
								flag = true;
								break;
							} else {
								logger.info("Unable to verify Attempt 1 dropdown for parameterized assessment name "
										+ assessmentName);
							}
						}
					} else {
						logger.info("Unable to verify name");
					}
				}
			} else {
				logger.info("Unable to get all assessemnt list");
			}
		} catch (Exception e) {
			logger.info("Unable to verifyAttemptDDValue");
			log(logger, "Unable to verifyAttemptDDValue");
			throw new DriverException("Unable to verifyAttemptDDValue", e);
		}
		logger.info("Method: verifyAttemptDDValue End flag --> " + flag);
		return flag;
	}

	/**
	 * Getting Info Icon value for given assessment.
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws Exception
	 */
	public boolean verifyInfoIconValue(String assessmentName) throws Exception {
		logger.info("Method : verifyAttemptDDValue Start");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.improve.tab.assessment.all.list.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				for (WebElement attemptElement : element) {
					// Verifying name.
					WebElement nameElement = attemptElement.findElement(By.cssSelector(
							PropertiesRepository.getString("new-atitesting.improve.tab.assessment.name.loc")));
					if (nameElement != null && nameElement.getText().trim().equalsIgnoreCase(assessmentName)) {
						// Verifying values in infoIconElement.
						List<WebElement> infoIconElement = attemptElement.findElements(By.cssSelector(
								PropertiesRepository.getString("new-atitesting.improve.tab.assessment.info.icon.loc")));
						if (CollectionUtils.isNotEmpty(infoIconElement)) {
							// Clicking on Info icon.
							infoIconElement.get(0).click();
							// Verify info header details like Name, Product ID, Source and Added.
							List<WebElement> infoHeaderElement = baseHandler.findElements(PropertiesRepository
									.getString("new-atitesting.improve.tab.assessment.info.header.loc"));
							if (CollectionUtils.isNotEmpty(infoHeaderElement)) {
								List<WebElement> h3HeaderElement = infoHeaderElement.get(0)
										.findElements(By.cssSelector("h3"));
								if (CollectionUtils.isNotEmpty(h3HeaderElement)) {
									if ("Name:".equalsIgnoreCase(h3HeaderElement.get(0).getText().trim())
											&& "Product ID:".equalsIgnoreCase(h3HeaderElement.get(1).getText().trim())
											&& "Source:".equalsIgnoreCase(h3HeaderElement.get(2).getText().trim())
											&& "Added:".equalsIgnoreCase(h3HeaderElement.get(3).getText().trim())) {
										// Clicking on close button.
										List<WebElement> prodInfoCloseBtn = baseHandler
												.findElements(PropertiesRepository.getString(
														"new-atitesting.improve.tab.assessment.info.close.button.loc"));
										if (CollectionUtils.isNotEmpty(prodInfoCloseBtn)) {
											prodInfoCloseBtn.get(0).click();
											flag = true;
											break;
										}
									}
								}
							} else {
								logger.info("Unable to get Info popup");
							}
						} else {
							logger.info("Unable to get Info Icon details");
						}

					} else {
						logger.info("Unable to get Assessment name ");
					}
					if (flag) {
						break;
					}
				}
			} else {
				logger.info("Unable to get Assessment details");
			}
		} catch (Exception e) {
			logger.info("Unable to verifyAttemptDDValue");
			log(logger, "Unable to verifyAttemptDDValue");
			throw new DriverException("Unable to verifyAttemptDDValue", e);
		}
		logger.info("Method: verifyAttemptDDValue End flag --> " + flag);
		return flag;
	}

	/**
	 * Getting Info Icon value for given assessment.
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws Exception
	 */
	public boolean verifyInfoIconValue(String assessmentName, String infoIconName) throws Exception {
		logger.info("Method : verifyAttemptDDValue Start");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.improve.tab.assessment.all.list.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				for (WebElement attemptElement : element) {
					// Verifying name.
					WebElement nameElement = attemptElement.findElement(By.cssSelector(
							PropertiesRepository.getString("new-atitesting.improve.tab.assessment.name.loc")));
					if (nameElement != null && nameElement.getText().trim().equalsIgnoreCase(assessmentName)) {
						// Verifying values in infoIconElement.
						List<WebElement> infoIconElement = attemptElement.findElements(By.cssSelector(
								PropertiesRepository.getString("new-atitesting.improve.tab.assessment.info.icon.loc")));
						if (CollectionUtils.isNotEmpty(infoIconElement)) {
							// Clicking on Info icon.
							infoIconElement.get(0).click();
							// Verify info details.
							List<WebElement> infoName = baseHandler
									.findElements("div[id='productInfoDialog'] div[data-bind='text: Name']");
							if (CollectionUtils.isNotEmpty(infoName)) {
								for (WebElement infoElement : infoName) {
									if (infoElement.getText().trim().contains(infoIconName)) {
										// Clicking on close button.
										List<WebElement> prodInfoCloseBtn = baseHandler
												.findElements(PropertiesRepository.getString(
														"new-atitesting.improve.tab.assessment.info.close.button.loc"));
										if (CollectionUtils.isNotEmpty(prodInfoCloseBtn)) {
											prodInfoCloseBtn.get(0).click();
											flag = true;
											break;
										}
									} else {
										logger.info("Unable to verify info name");
									}
								}
							}
						} else {
							logger.info("Unable to get Info Icon details");
						}

					} else {
						logger.info("Unable to get Assessment name ");
					}
					if (flag) {
						break;
					}
				}
			} else {
				logger.info("Unable to get Assessment details");
			}
		} catch (Exception e) {
			logger.info("Unable to verifyAttemptDDValue");
			log(logger, "Unable to verifyAttemptDDValue");
			throw new DriverException("Unable to verifyAttemptDDValue", e);
		}
		logger.info("Method: verifyAttemptDDValue End flag --> " + flag);
		return flag;
	}

	/**
	 * Verifying Retake button under Select Instance for parameterized assessment
	 * name.
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws Exception
	 */

	public boolean verifyRetakeButtonInSelectInstance(String assessmentName) throws Exception {
		logger.info("Method : verifyRetakeButtonInSelectInstance Start");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.improve.tab.assessment.all.list.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				for (WebElement attemptElement : element) {
					// Verifying name.
					WebElement nameElement = attemptElement.findElement(By.cssSelector(
							PropertiesRepository.getString("new-atitesting.improve.tab.assessment.name.loc")));
					if (nameElement != null && nameElement.getText().trim().equalsIgnoreCase(assessmentName)) {
						// Verifying values in Attempt DD.
						WebElement attemptDDElement = attemptElement.findElement(By.cssSelector(PropertiesRepository
								.getString("new-atitesting.improve.tab.assessment.attempt.drop.down.loc")));
						List<WebElement> ddValue = dropDownHandler.getOptions(attemptDDElement);
						for (WebElement item : ddValue) {
							if (PropertiesRepository.getString("new-atitesting.improve.tab.fr.2.0.new.attempt.value")
									.trim().equalsIgnoreCase(item.getText().trim())) {
								item.click();
								// Verifying Retake Buton in Select Instance.
								List<WebElement> selectInstanceElement = baseHandler.findElements(PropertiesRepository
										.getString("new-atitesting.improve.tab.select.instance.loc"));
								if (CollectionUtils.isNotEmpty(selectInstanceElement)) {
									for (WebElement buttonElement : selectInstanceElement) {
										// Verifying header.
										WebElement headerElement = buttonElement.findElement(By.cssSelector(
												"header[class='duplicate-product-header'] span[data-bind*='ID']"));
										if (headerElement != null) {
											if (PropertiesRepository.getString(
													"new-atitesting.improve.tab.select.instance.retake.cdn.product.id.value")
													.equalsIgnoreCase(headerElement.getText().trim())) {
												// Getting first button(Begin, Continue / Retake)
												List<WebElement> beginBtnElement = buttonElement
														.findElements(By.cssSelector(PropertiesRepository.getString(
																"new-atitesting.improve.tab.select.instance.buttons.loc")));
												if (CollectionUtils.isNotEmpty(beginBtnElement)) {
													WebElement retakeBtnElement = beginBtnElement.get(0)
															.findElement(By.cssSelector(PropertiesRepository.getString(
																	"new-atitesting.improve.tab.select.instance.retake.button.loc")));
													if (retakeBtnElement != null && "Retake"
															.equalsIgnoreCase(retakeBtnElement.getText().trim())) {
														flag = true;
														break;
													} else {
														logger.info(
																"Unable to verify Retake button under Select Instance.");
													}
												} else {
													logger.info(
															"Buttons are not available under Select Instance Section");
												}
											} else {
												logger.info(
														"Unable to verify CDN and Product ID for Retake button section");
											}
										} else {
											logger.info("Unable to get header element locator");
										}
									}
									if (flag) {
										break;
									}
								}

							} else {
								logger.info("Unable to verify Attempt dropdown for parameterized assessment name "
										+ assessmentName);
							}
						}
						if (flag) {
							break;
						}
					} else {
						logger.info("Unable to verify name");
					}
				}
			} else {
				logger.info("Unable to get all assessemnt list");
			}
		} catch (Exception e) {
			logger.info("Unable to verifyRetakeButtonInSelectInstance");
			log(logger, "Unable to verifyRetakeButtonInSelectInstance");
			throw new DriverException("Unable to verifyRetakeButtonInSelectInstance", e);
		}
		logger.info("Method: verifyRetakeButtonInSelectInstance End flag --> " + flag);
		return flag;
	}

	public boolean verifyCustomAssessmentName(String assessmentName) throws Exception {
		logger.info("Method : verifyCustomAssessmentNameStart");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.improve.tab.assessment.name.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				for (WebElement nameElement : element) {
					if (assessmentName.equalsIgnoreCase(nameElement.getText().trim())) {
						flag = true;
						break;
					}
					// if(PropertiesRepository.getString("new-atitesting.improve.tab.custom.assessment.name1.value").eq)
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verifyCustomAssessmentName");
			log(logger, "Unable to verifyCustomAssessmentName");
			throw new DriverException("Unable to verifyCustomAssessmentName", e);
		}
		logger.info("Method: verifyCustomAssessmentName End flag --> " + flag);
		return flag;
	}

	/**
	 * Getting test type and sort by drop down for Study Material button.
	 * 
	 * @param assessmentName
	 * @return
	 * @throws Exception
	 */
	public boolean verifyStudyMaterialButtonValue(String assessmentName) throws Exception {
		logger.info("Method : verifyStudyMaterialButtonDDValue Start");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.improve.tab.assessment.all.list.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				for (WebElement attemptElement : element) {
					// Verifying name.
					WebElement nameElement = attemptElement.findElement(By.cssSelector(
							PropertiesRepository.getString("new-atitesting.improve.tab.assessment.name.loc")));
					if (nameElement != null && nameElement.getText().trim().equalsIgnoreCase(assessmentName)) {
						// Getting Study Material button.
						List<WebElement> studyBtnElement = attemptElement
								.findElements(By.cssSelector(PropertiesRepository
										.getString("new-atitesting.improve.tab.assessment.study.material.button.loc")));
						if (CollectionUtils.isNotEmpty(studyBtnElement)) {
							studyBtnElement.get(0).click();
							flag = true;
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
							break;
						}
					} else {
						logger.info("Unable to get Assessment name ");
					}
				}
			} else {
				logger.info("Unable to get Assessment details");
			}
		} catch (Exception e) {
			logger.info("Unable to verifyStudyMaterialButtonDDValue");
			log(logger, "Unable to verifyStudyMaterialButtonDDValue");
			throw new DriverException("Unable to verifyStudyMaterialButtonDDValue", e);
		}
		logger.info("Method: verifyStudyMaterialButtonDDValue End flag --> " + flag);
		return flag;
	}

	/**
	 * Method used to verify dd value for Test type and sort by dd value.
	 * 
	 * @author saravanan.jothimani
	 * @param assessmentName
	 * @return
	 * @throws Exception
	 */
	public boolean verifyTestTypeAndSortByDDValue(String assessmentName, int testOrSortIndex, List<String> dropDownValue) throws Exception {
		logger.info("Method : verifyTestTypeAndSortByDDValue Start");
		boolean flag = false;
		boolean countFlag = false;
		List<String> nameList = new ArrayList<String>();
		try {
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.improve.tab.assessment.all.list.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				for (WebElement attemptElement : element) {
					// Verifying name.
					WebElement nameElement = attemptElement.findElement(By.cssSelector(
							PropertiesRepository.getString("new-atitesting.improve.tab.assessment.name.loc")));
					if (nameElement != null && nameElement.getText().trim().equalsIgnoreCase(assessmentName)) {
						// Verifying values in Attempt DD.
						
						List<WebElement> attemptDDElement = attemptElement.findElements(By.cssSelector(PropertiesRepository
								.getString("new-atitesting.improve.tab.assessment.study.material.test.type.and.sort.by.select.loc")));
						List<WebElement> ddValue = dropDownHandler.getOptions(attemptDDElement.get(testOrSortIndex));
						for (WebElement item : ddValue) {
							nameList.add(item.getText().trim());
							if(dropDownValue.size() == nameList.size()) {
								countFlag = true;
								break;
							}
						}
					} else {
						logger.info("Unable to verify name");
					}
					if(countFlag) {
						// Sorting
						Collections.sort(nameList, String.CASE_INSENSITIVE_ORDER);
						Collections.sort(dropDownValue, String.CASE_INSENSITIVE_ORDER);
						if (CollectionUtils.isNotEmpty(nameList) && CollectionUtils.isNotEmpty(dropDownValue)) {
							if (nameList.equals(dropDownValue)) {
								flag = true;
							}
						}					 
						break;
					}
				}
			} else {
				logger.info("Unable to get all assessemnt list");
			}
		} catch (Exception e) {
			logger.info("Unable to verifyTestTypeAndSortByDDValue");
			log(logger, "Unable to verifyTestTypeAndSortByDDValue");
			throw new DriverException("Unable to verifyTestTypeAndSortByDDValue", e);
		}
		logger.info("Method: verifyTestTypeAndSortByDDValue End flag --> " + flag);
		return flag;
	}

	/**
	 * Method used to verify dd default value for Test type and sort by dd value.
	 * 
	 * @author saravanan.jothimani
	 * @param assessmentName
	 * @return
	 * @throws Exception
	 */
	public boolean verifyTestTypeAndSortByDDDefaultValue(String assessmentName, int testOrSortIndex,
			String defaultSelectedOption) throws Exception {
		logger.info("Method : verifyTestTypeAndSortByDDDefaultValue Start");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.improve.tab.assessment.all.list.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				for (WebElement attemptElement : element) {
					// Verifying name.
					WebElement nameElement = attemptElement.findElement(By.cssSelector(
							PropertiesRepository.getString("new-atitesting.improve.tab.assessment.name.loc")));
					if (nameElement != null && nameElement.getText().trim().equalsIgnoreCase(assessmentName)) {
						// Verifying values in Attempt DD.

						List<WebElement> attemptDDElement = attemptElement
								.findElements(By.cssSelector(PropertiesRepository.getString(
										"new-atitesting.improve.tab.assessment.study.material.test.type.and.sort.by.select.loc")));
						String selectedOption = new Select(attemptDDElement.get(testOrSortIndex))
								.getFirstSelectedOption().getText();
						if (StringUtils.isNotEmpty(selectedOption)
								&& selectedOption.trim().equalsIgnoreCase(defaultSelectedOption)) {
							flag = true;
							break;
						}
					} else {
						logger.info("Unable to verify name");
					}
				}
			} else {
				logger.info("Unable to get all assessemnt list");
			}
		} catch (Exception e) {
			logger.info("Unable to verifyTestTypeAndSortByDDDefaultValue");
			log(logger, "Unable to verifyTestTypeAndSortByDDDefaultValue");
			throw new DriverException("Unable to verifyTestTypeAndSortByDDDefaultValue", e);
		}
		logger.info("Method: verifyTestTypeAndSortByDDDefaultValue End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to verify Practice Assessment section in My Results page. 
	 * 1. Verify Focused Review Time in Practice Assessment header section. 
	 * 2. Verify Focused Review Time value in it row. 
	 * 
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws Exception
	 */
	public boolean verifyFR20TimeSpentInMyResultsTab(String assessmentName) throws Exception {
		logger.info("Method : verifyFR20TimeSpentInMyResultsTabStart");
		boolean flag = false;
		boolean focusedReviewTimeFlag = false;
		try {
			List<WebElement> element = baseHandler.findElements(PropertiesRepository
					.getString("new-atitesting.improve.tab.my.results.practice.assessment.header.loc"));
			if (CollectionUtils.isNotEmpty(element) && element.size() > 1) {
				int mainSize = element.size();
				
				for(int mainIndex = 0; mainIndex < mainSize; mainIndex++) {
					// Verify practice Assessment table header
					List<WebElement> headerElement = element.get(mainIndex).findElements(By.cssSelector("tr th"));
					if (CollectionUtils.isNotEmpty(headerElement) && headerElement.size() == 6
							&& "Focused Review Time".equalsIgnoreCase(headerElement.get(4).getText())) {
						// Getting all rows to get value for Focused Review Time section.

						List<WebElement> trElement = element.get(mainIndex).findElements(By.cssSelector("tr"));
						int tableRowSize = trElement.size();
						for(int tableRowIndex = 1; tableRowIndex < tableRowSize; tableRowIndex ++) {
							List<WebElement> tdElement = trElement.get(tableRowIndex).findElements(By.cssSelector("td"));
							// Getting assessment name from each row. 
							if(CollectionUtils.isNotEmpty(trElement) && 
									assessmentName.equalsIgnoreCase(tdElement.get(0).findElement(By.cssSelector("a")).getText())) {
								List<WebElement> spanElement = tdElement.get(4).findElements(By.cssSelector("span[class='focus-element-flag']"));
								for(WebElement styleElement : spanElement ) {
									if(CollectionUtils.isNotEmpty(spanElement) 
											&& !styleElement.getAttribute("style").equalsIgnoreCase("display: none;")
											&& StringUtils.isNotEmpty(styleElement.getText())) {
										focusedReviewTimeFlag = true;
										break;
									} else {
										logger.info("Focused Review time is not displayed for above assessment -->  " + assessmentName );
									}
								}
							} else {
								logger.info("Unable to verify Assessment name");
							}
						}
					
					} else {
						logger.info("Unable to verify table header");
					}
					if(focusedReviewTimeFlag) {
						flag = true;
						break;
					}
				} 
				
			} else {
				logger.info("Records are not available under Practice Assessment to verify.");
			}
		} catch (Exception e) {
			logger.info("Unable to verifyFR20TimeSpentInMyResultsTab");
			log(logger, "Unable to verifyFR20TimeSpentInMyResultsTab");
			throw new DriverException("Unable to verifyFR20TimeSpentInMyResultsTab", e);
		}
		logger.info("Method: verifyFR20TimeSpentInMyResultsTab End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Verifying Select Test for an assessment.
	 * 
	 * @param assessmentName
	 * @return
	 * @throws Exception
	 */
	public boolean verifySelectTestForAssessment(String assessmentName, String buttonName) throws Exception {
		logger.info("Method : verifySelectTestForAssessment Start");
		boolean flag = false;
		boolean resultFlag = false;
		try {
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.improve.tab.assessment.all.list.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				for (WebElement attemptElement : element) {
					// Verifying name.
					WebElement nameElement = attemptElement.findElement(By.cssSelector(
							PropertiesRepository.getString("new-atitesting.improve.tab.assessment.name.loc")));
					if (nameElement != null && nameElement.getText().trim().equalsIgnoreCase(assessmentName)) {
						List<WebElement> buttonElement = attemptElement.findElements(By.cssSelector("li[class='remediation-list-item'] span[class='remediation-button-span'] a"));
						if(CollectionUtils.isNotEmpty(buttonElement)) {
							for(WebElement styleElement : buttonElement) {
								String styleValue = styleElement.getAttribute("style");
								if(!styleValue.equalsIgnoreCase("display: none;") ) {
										if("Select Test".equalsIgnoreCase(styleElement.getText().trim())
												&& buttonName.equalsIgnoreCase(styleElement.getText().trim())) {
											styleElement.click();
											// Verifying it has multiple assessment.
											List<WebElement> selectInstanceList = baseHandler.findElements("ul[class='product-list-style duplicate-list'] li");
											if(CollectionUtils.isNotEmpty(selectInstanceList) && selectInstanceList.size() > 0) {
												resultFlag = true;
												styleElement.click();
												break;
											}
										} else if("Begin".equalsIgnoreCase(styleElement.getText().trim())
												&& buttonName.equalsIgnoreCase(styleElement.getText().trim())) {
											resultFlag = true;
											break;
										}
								}
							}
						}
					} else {
						logger.info("Unable to get Assessment name ");
					}
					if(resultFlag) {
						flag = true;
						break;
					}
				}
			} else {
				logger.info("Unable to get Assessment details");
			}
		} catch (Exception e) {
			logger.info("Unable to verifySelectTestForAssessment");
			log(logger, "Unable to verifySelectTestForAssessment");
			throw new DriverException("Unable to verifySelectTestForAssessment", e);
		}
		logger.info("Method: verifySelectTestForAssessment End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Verifying Select Test for an assessment and its details.
	 * 
	 * @param assessmentName
	 * @return
	 * @throws Exception
	 */
	public boolean verifySelectTestForAssessmentAndItsDetails(String assessmentName, String buttonName)
			throws Exception {
		logger.info("Method : verifySelectTestForAssessmentAndItsDetails Start");
		boolean flag = false;
		boolean resultFlag = false;
		try {
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.improve.tab.assessment.all.list.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				for (WebElement attemptElement : element) {
					// Verifying name.
					WebElement nameElement = attemptElement.findElement(By.cssSelector(
							PropertiesRepository.getString("new-atitesting.improve.tab.assessment.name.loc")));
					if (nameElement != null && nameElement.getText().trim().equalsIgnoreCase(assessmentName)) {
						List<WebElement> buttonElement = attemptElement.findElements(By.cssSelector(
								"li[class='remediation-list-item'] span[class='remediation-button-span'] a"));
						if (CollectionUtils.isNotEmpty(buttonElement)) {
							for (WebElement styleElement : buttonElement) {
								String styleValue = styleElement.getAttribute("style");
								if (!styleValue.equalsIgnoreCase("display: none;")) {
									if ("Select Test".equalsIgnoreCase(styleElement.getText().trim())
											&& buttonName.equalsIgnoreCase(styleElement.getText().trim())) {
										styleElement.click();
										// Verifying it has multiple assessment and its assessment name.
										List<WebElement> selectInstanceList = baseHandler.findElements(
												"ul[class='product-list-style duplicate-list'] li div[class='duplicate-info-proctored'] span");
										if (CollectionUtils.isNotEmpty(selectInstanceList)
												&& selectInstanceList.size() > 0) {
											for (WebElement nameValueElement : selectInstanceList) {
												if (nameValueElement.getText().trim()
														.equalsIgnoreCase(assessmentName)) {
													resultFlag = true;
												} else {
													styleElement.click();
													resultFlag = false;
													break;
												}
											}
											styleElement.click();
										} else {
											logger.info(
													"Unable to verify Assessment name for all instanaces under Select Test");
										}
									} else {
										logger.info("Unable to verify Select Test button");
									}
									if (resultFlag) {
										flag = true;
										break;
									}
								}
							}
							if (resultFlag) {
								flag = true;
								break;
							}
						} else {
							logger.info("Unable to get Assessment name ");
						}
					}
					if (resultFlag) {
						flag = true;
						break;
					}
				}
			} else {
				logger.info("Unable to get Assessment details");
			}
		} catch (Exception e) {
			logger.info("Unable to verifySelectTestForAssessmentAndItsDetails");
			log(logger, "Unable to verifySelectTestForAssessmentAndItsDetails");
			throw new DriverException("Unable to verifySelectTestForAssessmentAndItsDetails", e);
		}
		logger.info("Method: verifySelectTestForAssessmentAndItsDetails End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Verifying Proctor Not available message.
	 * 
	 * @param assessmentName
	 * @return
	 * @throws Exception
	 */
	public boolean verifyProctorNotAvailableMessage(String assessmentName, String buttonName) throws Exception {
		logger.info("Method : verifyProctorNotAvailableMessage Start");
		boolean flag = false;
		boolean resultFlag = false;
		try {
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.improve.tab.assessment.all.list.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				for (WebElement attemptElement : element) {
					// Verifying name.
					WebElement nameElement = attemptElement.findElement(By.cssSelector(
							PropertiesRepository.getString("new-atitesting.improve.tab.assessment.name.loc")));
					if (nameElement != null && nameElement.getText().trim().equalsIgnoreCase(assessmentName)) {
						List<WebElement> buttonElement = attemptElement.findElements(By.cssSelector("li[class='remediation-list-item'] span[class='remediation-button-span'] a"));
						if(CollectionUtils.isNotEmpty(buttonElement)) {
							for(WebElement styleElement : buttonElement) {
								String styleValue = styleElement.getAttribute("style");
								if(!styleValue.equalsIgnoreCase("display: none;") ) {
										if("Select Test".equalsIgnoreCase(styleElement.getText().trim())
												&& buttonName.equalsIgnoreCase(styleElement.getText().trim())) {
											styleElement.click();
											// Verifying it has multiple assessment and its assessment name.
											List<WebElement> selectInstanceList = baseHandler.findElements("ul[class='product-list-style duplicate-list'] li a");
											if(CollectionUtils.isNotEmpty(selectInstanceList) && selectInstanceList.size() > 0) {
												for(WebElement nameValueElement : selectInstanceList) {
													
													String styleAValue = nameValueElement.getAttribute("style");
													if(!styleAValue.equalsIgnoreCase("display: none;") ) {
														nameValueElement.click();
														// Verifying toast message. 
														waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
														break;
													}
													
												}
												styleElement.click();
											} else {
												logger.info("Unable to verify Assessment name for all instanaces under Select Test");
											}
										} else {
											logger.info("Unable to verify Select Test button");
										}
										if(resultFlag) {
											
											flag = true;
											break;
										}
								} 
							} 
							if(resultFlag) {
								
								flag = true;
								break;
							}
						}else {
							logger.info("Unable to get Assessment name ");
						}
					} 
					if(resultFlag) {
						
						flag = true;
						break;
					}
				}
			} else {
				logger.info("Unable to get Assessment details");
			}
		} catch (Exception e) {
			logger.info("Unable to verifyProctorNotAvailableMessage");
			log(logger, "Unable to verifyProctorNotAvailableMessage");
			throw new DriverException("Unable to verifyProctorNotAvailableMessage", e);
		}
		logger.info("Method: verifyProctorNotAvailableMessage End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to get assessment name from individual section and verify it is in ascending order. 
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws Exception
	 */
	public boolean verifyImproveAssessmentsInAscendingOrder() throws Exception {
		logger.info("Method : Start");
		boolean flag = false;
		try {
			// Will get all main section under improve tab
			List<WebElement> element = baseHandler.findElements("li[class='remediation-list-item'] ul");
			if (CollectionUtils.isNotEmpty(element)) {
				for (WebElement tableElement : element) {
					List<String> beforeAssessmentName = new ArrayList<String>();
					List<String> afterAssessmentName = new ArrayList<String>();
					// Individual section assessment name.
					List<WebElement> individualSection = tableElement.findElements(
							By.cssSelector("li[class='remediation-list-item'] span[data-bind='text:Name']"));
					if (CollectionUtils.isNotEmpty(individualSection)) {
						for(WebElement nameElement : individualSection) {
							beforeAssessmentName.add(nameElement.getText());
							afterAssessmentName.add(nameElement.getText());
						}
					}
					Collections.sort(afterAssessmentName);
					if(beforeAssessmentName.equals(afterAssessmentName)) {
						flag = true;
					} else {
						logger.info("Assessment name are not in ascending order");
						flag = false;
						break;
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to ");
			log(logger, "Unable to ");
			throw new DriverException("Unable to ", e);
		}
		logger.info("Method: End flag --> " + flag);
		return flag;
	}
	
}
