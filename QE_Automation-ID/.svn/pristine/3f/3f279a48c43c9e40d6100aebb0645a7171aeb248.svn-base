package com.automation.id.pages;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.TextHandler;

public class HomePage4 extends IDBasePage {

	private Logger logger = LogManager.getLogger(this.getClass());

	public HomePage4(WebDriver webDriver) {
		super(webDriver);
		textHandler = new TextHandler(driver);
	}

	/**
	 * Method used to verify Left Navigation is hidden. 
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws Exception
	 */
	public boolean verifyLeftNavAutoHide() throws Exception {
		logger.info("Method : verifyLeftNavAutoHide Start");
		boolean flag = false;
		try {
			WebElement element = verifyElement("mat-sidenav");
			if(element != null) {
				String attributeValue = element.getAttribute("style");
				if(StringUtils.isNotBlank(attributeValue) ) {
					if(attributeValue.contains("visibility: hidden;")) {
						logger.info("Successfully verified left navigation hide");
						flag = true;
					}
				}
			} else {
				logger.info("Unable to find locaor for verifyLeftNavAutoHide");
			}
			
		}catch (Exception e) {
    		logger.info("Unable to verifyLeftNavAutoHide" );
			log(logger, "Unable to verifyLeftNavAutoHide" );
    		throw new DriverException("Unable to verifyLeftNavAutoHide" , e); 
    	}
		logger.info("Method: verifyLeftNavAutoHide End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to verify Course Cohort details in Dashboard page and click its Manage button.
	 * 
	 * @author saravanan.jothimani
	 * @param cohortType
	 * @param cohortName
	 * @return
	 * @throws Exception
	 */
	public boolean verifyAndClickCourseCohortManageButton(String cohortType, String cohortName) throws Exception {
		logger.info("Method : verifyAndClickCourseCohortManageButton Start");
		boolean flag = false;
		try {
			
			// Getting Cohort list in Home Page
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("id.home.dashboard.cohort.list.loc"));
			if(CollectionUtils.isNotEmpty(element) ) {
				for(WebElement cohortList : element) {
					// Getting sub title ie cohort type name Graduation/ Course Cohort.
					List<WebElement> cohortTypeList = cohortList.findElements(By.cssSelector(PropertiesRepository.getString("id.home.dashboard.subtitle.name.loc")));
					if(CollectionUtils.isNotEmpty(cohortTypeList)) {
						String cohortTypeValue = cohortTypeList.get(0).getText();
						if(cohortTypeValue.contains(cohortType)) {
							// Getting title ie cohort name.
							List<WebElement> cohortNameList = cohortList.findElements(By.cssSelector(PropertiesRepository.getString("id.home.dashboard.title.name.loc")));
							if(CollectionUtils.isNotEmpty(cohortNameList)) {
								String cohortNameValue = cohortNameList.get(0).getText();
								if(cohortNameValue.equalsIgnoreCase(cohortName)) {
									// Check Manage Button. 
									List<WebElement> manageBtn = cohortList.findElements(By.cssSelector(PropertiesRepository.getString("id.home.dashboard.course.manage.button.loc")));
									if (CollectionUtils.isNotEmpty(manageBtn)) {
										manageBtn.get(0).click();
										flag = true;
									} else {
										logger.info("Unable to verify Course Cohort Manage Button in Dashboard Page");
									}
									break;
								} else {
									logger.info("Unable to verify Cohort name");
								}
							}
						} 
					}
				}
			} else {
				logger.info("Unable to find locator for cohort in home page");
			}
			
		
		} catch (Exception e) {
    		logger.info("Unable to verifyAndClickCourseCohortManageButton" );
			log(logger, "Unable to verifyAndClickCourseCohortManageButton" );
    		throw new DriverException("Unable to verifyAndClickCourseCohortManageButton" , e); 
    	}
		/*try {
			// Getting Cohort list in Home Page
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("id.home.dashboard.cohort.list.loc"));
			if(CollectionUtils.isNotEmpty(element) ) {
				int size = element.size();
				for(int index = 0; index < size ; index++) {
					WebElement rowElement = element.get(index);
					// Getting sub title ie cohort type name Graduation/ Course Cohort.
					List<WebElement> cohortTypeList = rowElement.findElements(By.cssSelector(PropertiesRepository.getString("id.home.dashboard.subtitle.name.loc")));
					if(CollectionUtils.isNotEmpty(cohortTypeList)) {
						String cohortTypeValue = cohortTypeList.get(0).getText();
						if(cohortTypeValue.contains(PropertiesRepository.getString("id.home.course.cohorts.home.page.value"))) {
							// Getting title ie cohort name.
							List<WebElement> cohortNameList = cohortList.findElements(By.cssSelector(PropertiesRepository.getString("id.home.dashboard.title.name.loc")));
							if(CollectionUtils.isNotEmpty(cohortNameList)) {
								String cohortNameValue = cohortNameList.get(0).getText();
								if(cohortNameValue.equalsIgnoreCase(cohortName)) {
									flag = true;
									break;
								} else {
									logger.info("Unable to verify Cohort name");
								}
							}
							
							// Check Manage Button. 
							List<WebElement> manageBtn = rowElement.findElements(By.cssSelector(PropertiesRepository.getString("id.home.dashboard.course.manage.button.loc")));
							if (CollectionUtils.isNotEmpty(manageBtn)) {
								manageBtn.get(0).click();
								flag = true;
							} else {
								logger.info("Unable to verify Course Cohort Manage Button in Dashboard Page");
							}
						} 
					}
				}
			}
		}catch (Exception e) {
    		logger.info("Unable to clickCourseCohortManageButton" );
			log(logger, "Unable to clickCourseCohortManageButton" );
    		throw new DriverException("Unable to clickCourseCohortManageButton" , e); 
    	}*/
		logger.info("Method: verifyAndClickCourseCohortManageButton End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to enter cohort in student roster page. 
	 * 
	 * @param Cohortname
	 * @return
	 * @throws DriverException
	 * @throws InterruptedException
	 */
	public boolean searchAndEnterCountry(String locator, String Cohortname) throws DriverException, InterruptedException {
		logger.info("Method : searchAndEnterCountry :::::::: START");
		boolean flag = false;
		try {
			WebElement countryNameTxtElement = driver.findElement(By.cssSelector(locator));
			if (countryNameTxtElement != null) {
				countryNameTxtElement.clear();
				textHandler.writeText(locator,
						Cohortname);
				
				// Clicking on Select DD 
				WebElement countryDDValue = verifyElement(PropertiesRepository.getString("id.people.reassign.popup.cohort.select.dd.loc"));
				if (countryDDValue != null) {
					countryDDValue.click();
					waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
					flag = true;
				}
			}
		} catch (Exception e) {
			logger.info("Unable to searchAndEnterCountry");
			throw new DriverException("Unable to searchAndEnterCountry", e);
		}
		logger.info("Method : searchAndEnterCountry :::::::: START flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to verify details of portlet where no cohort assigned card when
	 * no student have taken any assessment.
	 * 
	 * @author saravanan.jothimani
	 * @param cohortType
	 * @param cohortName
	 * @return
	 * @throws Exception
	 */
	public boolean verifyNoCohortAssignedWithNoStudentPortlet(String cohortType, String cohortName) throws Exception {
		logger.info("Method : verifyNoCohortAssignedWithNoStudentPortlet Start");
		boolean flag = false;
		try {
			// Getting Cohort list in Home Page
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("id.home.dashboard.cohort.list.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				for (WebElement cohortList : element) {
					// Getting sub title ie cohort type name Graduation/ Course Cohort.
					List<WebElement> cohortTypeList = cohortList.findElements(
							By.cssSelector(PropertiesRepository.getString("id.home.dashboard.subtitle.name.loc")));
					if (CollectionUtils.isNotEmpty(cohortTypeList)) {
						String cohortTypeValue = cohortTypeList.get(0).getText();
						if (cohortTypeValue.contains(cohortType)) {
							// Getting title ie cohort name.
							List<WebElement> cohortNameList = cohortList.findElements(
									By.cssSelector(PropertiesRepository.getString("id.home.dashboard.title.name.loc")));
							if (CollectionUtils.isNotEmpty(cohortNameList)) {
								String cohortNameValue = cohortNameList.get(0).getText();
								if (cohortNameValue.equalsIgnoreCase(cohortName)) {
									// Verifying No Data available to process.
									List<WebElement> noDataAvailableElement = cohortList
											.findElements(By.cssSelector(PropertiesRepository.getString(
													"id.home.no.cohort.assigned.details.section.no.data.available.to.process.loc")));
									if (CollectionUtils.isNotEmpty(noDataAvailableElement) && noDataAvailableElement
											.get(0).getText().trim().equalsIgnoreCase(PropertiesRepository.getString(
													"id.home.no.cohort.assigned.details.section.no.data.available.to.process.value"))) {
										// Verifying Reminder Text.
										List<WebElement> reminderElement = cohortList
												.findElements(By.cssSelector(PropertiesRepository
														.getString("id.home.no.cohort.assigned.details.section.loc")));
										if (CollectionUtils.isNotEmpty(reminderElement) && reminderElement.get(1)
												.getText().trim().contains(PropertiesRepository.getString(
														"id.home.no.cohort.assigned.details.section.value"))) {
											flag = true;
											break;
										} else {
											logger.info("Unable to verify Reminder section");
										}
									} else {
										logger.info("Unable to verify No data available to process. in home page");
									}
								}
							} else {
								logger.info("Unable to verify cohort name home page");
							}
						}
					} else {
						logger.info("Unable to verify cohort type in home page");
					}
				} 
			} else {
				logger.info("Unable to find locator for cohort in home page");
			}
		} catch (Exception e) {
			logger.info("Unable to verifyNoCohortAssignedWithNoStudentPortlet");
			log(logger, "Unable to verifyNoCohortAssignedWithNoStudentPortlet");
			throw new DriverException("Unable to verifyNoCohortAssignedWithNoStudentPortlet", e);
		}
		logger.info("Method: verifyNoCohortAssignedWithNoStudentPortlet End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to verify details of portlet when no student has taken any assessment.
	 * 
	 * @author saravanan.jothimani
	 * @param cohortType
	 * @param cohortName
	 * @return
	 * @throws Exception
	 */
	public boolean verifyGraduationCohortWithNoStudentPortlet(String cohortType, String cohortName) throws Exception {
		logger.info("Method : verifyNoCohortAssignedWithNoStudentPortlet Start");
		boolean flag = false;
		try {
			// Getting Cohort list in Home Page
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("id.home.dashboard.cohort.list.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				for (WebElement cohortList : element) {
					// Getting sub title ie cohort type name Graduation/ Course Cohort.
					List<WebElement> cohortTypeList = cohortList.findElements(
							By.cssSelector(PropertiesRepository.getString("id.home.dashboard.subtitle.name.loc")));
					if (CollectionUtils.isNotEmpty(cohortTypeList)) {
						String cohortTypeValue = cohortTypeList.get(0).getText();
						if (cohortTypeValue.contains(cohortType)) {
							// Getting title ie cohort name.
							List<WebElement> cohortNameList = cohortList.findElements(
									By.cssSelector(PropertiesRepository.getString("id.home.dashboard.title.name.loc")));
							if (CollectionUtils.isNotEmpty(cohortNameList)) {
								String cohortNameValue = cohortNameList.get(0).getText();
								if (cohortNameValue.equalsIgnoreCase(cohortName)) {
									// Verifying student count section at top right corner of each portlet. 
									List<WebElement> noOfStudentElement = cohortTypeList.get(0).findElements(By.cssSelector("span"));
									if(CollectionUtils.isNotEmpty(noOfStudentElement)) {
										// Verifying No Data available to process.
										List<WebElement> noDataAvailableElement = cohortList
												.findElements(By.cssSelector(PropertiesRepository.getString(
														"id.home.graduation.cohort.details.section.with.no.student.available.to.process.loc")));
										if (CollectionUtils.isNotEmpty(noDataAvailableElement) && noDataAvailableElement
												.get(0).getText().trim().equalsIgnoreCase(PropertiesRepository.getString(
														"id.home.graduation.cohort.details.section.with.no.student.available.to.process.value"))) {
											// Verifying Reminder Text.
											List<WebElement> reminderElement = cohortList
													.findElements(By.cssSelector(PropertiesRepository
															.getString("id.home.no.cohort.assigned.details.section.loc")));
											if (CollectionUtils.isNotEmpty(reminderElement) && reminderElement.get(1)
													.getText().trim().contains(PropertiesRepository.getString(
															"id.home.graduation.cohort.details.section.with.no.student.available.to.process.details.section.value"))) {
												flag = true;
												break;
											} else {
												logger.info("Unable to verify Reminder section");
											}
										} else {
											logger.info("Unable to verify No data available to process. in home page");
										}
									} else {
										logger.info("Unable to verify Studen count");
									}
								}
							} else {
								logger.info("Unable to verify cohort name home page");
							}
						}
					} else {
						logger.info("Unable to verify cohort type in home page");
					}
				} 
			} else {
				logger.info("Unable to find locator for cohort in home page");
			}
		} catch (Exception e) {
			logger.info("Unable to verifyNoCohortAssignedWithNoStudentPortlet");
			log(logger, "Unable to verifyNoCohortAssignedWithNoStudentPortlet");
			throw new DriverException("Unable to verifyNoCohortAssignedWithNoStudentPortlet", e);
		}
		logger.info("Method: verifyNoCohortAssignedWithNoStudentPortlet End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to verify details of portlet where Graduation Cohort with No
	 * Cohort Assigned Portlet.
	 * 
	 * @author saravanan.jothimani
	 * @param cohortType
	 * @param cohortName
	 * @return
	 * @throws Exception
	 */
	public boolean verifyGraduationCohortWithNoCohortAssignedPortlet(String cohortType, String cohortName)
			throws Exception {
		logger.info("Method : verifyGraduationCohortWithNoCohortAssignedPortlet Start");
		boolean flag = false;
		try {
			// Getting Cohort list in Home Page
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("id.home.dashboard.cohort.list.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				for (WebElement cohortList : element) {
					// Getting sub title ie cohort type name Graduation/ Course Cohort.
					List<WebElement> cohortTypeList = cohortList.findElements(
							By.cssSelector(PropertiesRepository.getString("id.home.dashboard.subtitle.name.loc")));
					if (CollectionUtils.isNotEmpty(cohortTypeList)) {
						String cohortTypeValue = cohortTypeList.get(0).getText();
						if (cohortTypeValue.contains(cohortType)) {
							// Getting title ie cohort name.
							List<WebElement> cohortNameList = cohortList.findElements(
									By.cssSelector(PropertiesRepository.getString("id.home.dashboard.title.name.loc")));
							if (CollectionUtils.isNotEmpty(cohortNameList)) {
								String cohortNameValue = cohortNameList.get(0).getText();
								if (cohortNameValue.equalsIgnoreCase(cohortName)) {
									// Verifying Proctor Assessment Name.
									List<WebElement> assessmentElement = cohortList
											.findElements(By.cssSelector(PropertiesRepository.getString(
													"id.home.graduation.cohort.details.section.assessment.name.loc")));
									if (CollectionUtils.isNotEmpty(assessmentElement)) {
										// Verifying Adjusted Group Score text.
										List<WebElement> adjustedGrpScore = cohortList
												.findElements(By.cssSelector(PropertiesRepository.getString(
														"id.home.graduation.cohort.details.section.adjusted.group.score.loc")));
										if (CollectionUtils.isNotEmpty(adjustedGrpScore) && adjustedGrpScore.get(0)
												.getText().trim().equalsIgnoreCase(PropertiesRepository.getString(
														"id.home.graduation.cohort.details.section.adjusted.group.score.value"))) {
											// Verifying Percentage.
											List<WebElement> percentageElement = cohortList
													.findElements(By.cssSelector(PropertiesRepository.getString(
															"id.home.graduation.cohort.details.section.assessment.completion.percentage.loc")));
											// Verifying PDF button
											List<WebElement> pdfElement = cohortList
													.findElements(By.cssSelector(PropertiesRepository.getString(
															"id.home.graduation.cohort.details.section.assessment.pdf.icon.loc")));
											// Verifying Manage Button
											List<WebElement> manageElement = cohortList
													.findElements(By.cssSelector(PropertiesRepository.getString(
															"id.home.graduation.cohort.details.section.assessment.manage.icon.loc")));

											if (CollectionUtils.isNotEmpty(percentageElement)
													&& pdfElement.get(0).getText().trim().contains("PDF")
													&& manageElement.get(0).getText().trim().contains("MANAGE")) {
												flag = true;
												break;
											} else {
												logger.info("Unable to verify Percentage, PDF and Manage ");
											}
										} else {
											logger.info("Unable to verify Adjusted Group Score Text");
										}
									} else {
										logger.info("Unable to verify Proctor Assessment name locator");
									}
								}
							} else {
								logger.info("Unable to verify cohort name home page");
							}
						}
					} else {
						logger.info("Unable to verify cohort type in home page");
					}
				}
			} else {
				logger.info("Unable to find locator for cohort in home page");
			}
		} catch (Exception e) {
			logger.info("Unable to verifyGraduationCohortWithNoCohortAssignedPortlet");
			log(logger, "Unable to verifyGraduationCohortWithNoCohortAssignedPortlet");
			throw new DriverException("Unable to verifyGraduationCohortWithNoCohortAssignedPortlet", e);
		}
		logger.info("Method: verifyGraduationCohortWithNoCohortAssignedPortlet End flag --> " + flag);
		return flag;
	}
	
	
	/**
	 * Method used to verify details of portlet where Graduation Cohort with some student take any assessment Portlet.
	 * 
	 * @author saravanan.jothimani
	 * @param cohortType
	 * @param cohortName
	 * @return
	 * @throws Exception
	 */
	public boolean verifyGraduationCohortWithSomeStudentPortlet(String cohortType, String cohortName)
			throws Exception {
		logger.info("Method : verifyGraduationCohortWithNoCohortAssignedPortlet Start");
		boolean flag = false;
		try {
			// Getting Cohort list in Home Page
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("id.home.dashboard.cohort.list.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				for (WebElement cohortList : element) {
					// Getting sub title ie cohort type name Graduation/ Course Cohort.
					List<WebElement> cohortTypeList = cohortList.findElements(
							By.cssSelector(PropertiesRepository.getString("id.home.dashboard.subtitle.name.loc")));
					if (CollectionUtils.isNotEmpty(cohortTypeList)) {
						String cohortTypeValue = cohortTypeList.get(0).getText();
						if (cohortTypeValue.contains(cohortType)) {
							// Getting title ie cohort name.
							List<WebElement> cohortNameList = cohortList.findElements(
									By.cssSelector(PropertiesRepository.getString("id.home.dashboard.title.name.loc")));
							if (CollectionUtils.isNotEmpty(cohortNameList)) {
								String cohortNameValue = cohortNameList.get(0).getText();
								if (cohortNameValue.equalsIgnoreCase(cohortName)) {
									// Verifying Student count
									List<WebElement> studentCountElement = cohortList
											.findElements(By.cssSelector(PropertiesRepository.getString(
													"id.home.graduation.cohort.details.section.assessment.student.count.loc")));
									
									// Verifying Student At Rist text. 
									List<WebElement> studentAtElement = cohortList
											.findElements(By.cssSelector(PropertiesRepository.getString(
													"id.home.graduation.cohort.details.section.assessment.student.at.risk.loc")));
									
									// Verifying Student Image. 
									List<WebElement> studentImageElement = cohortList
											.findElements(By.cssSelector(PropertiesRepository.getString(
													"id.home.graduation.cohort.details.section.assessment.student.icon.loc")));
									
									// Verifying Details button
									List<WebElement> detailsElement = cohortList
											.findElements(By.cssSelector(PropertiesRepository.getString(
													"id.home.graduation.cohort.details.section.assessment.details.button.loc")));
									// Verifying Manage Button
									List<WebElement> manageElement = cohortList
											.findElements(By.cssSelector(PropertiesRepository.getString(
													"id.home.graduation.cohort.details.section.assessment.details.button.manage.button.loc")));

									if (CollectionUtils.isNotEmpty(studentCountElement) &&
											CollectionUtils.isNotEmpty(studentAtElement) && 
											studentAtElement.get(0).getText().trim()
													.equalsIgnoreCase(PropertiesRepository.getString(
															"id.home.graduation.cohort.details.section.assessment.student.at.risk.value")) &&
												CollectionUtils.isNotEmpty(studentImageElement) &&	
											detailsElement.get(0).getText().trim().contains("DETAILS")
											&& manageElement.get(0).getText().trim().contains("MANAGE")) {
										flag = true;
										break;
									} else {
										logger.info("Unable to verify Percentage, PDF and Manage ");
									}
								}
							} else {
								logger.info("Unable to verify cohort name home page");
							}
						}
					} else {
						logger.info("Unable to verify cohort type in home page");
					}
				}
			} else {
				logger.info("Unable to find locator for cohort in home page");
			}
		} catch (Exception e) {
			logger.info("Unable to verifyGraduationCohortWithNoCohortAssignedPortlet");
			log(logger, "Unable to verifyGraduationCohortWithNoCohortAssignedPortlet");
			throw new DriverException("Unable to verifyGraduationCohortWithNoCohortAssignedPortlet", e);
		}
		logger.info("Method: verifyGraduationCohortWithNoCohortAssignedPortlet End flag --> " + flag);
		return flag;
	}
	
}
