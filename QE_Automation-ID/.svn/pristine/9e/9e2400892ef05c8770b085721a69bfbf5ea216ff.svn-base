package com.automation.id.pages;

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

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.ButtonHandler;
import com.ascendlearning.automation.ui.handlers.TextHandler;

public class HomePage2 extends HomePage3 {

	private Logger logger = LogManager.getLogger(this.getClass());
	private TextHandler textHandler;
	private ButtonHandler buttonHandler;
	private LoginPage loginPage;

	public HomePage2(WebDriver webDriver) {
		super(webDriver);
		textHandler = new TextHandler(driver);
		buttonHandler = new ButtonHandler(driver);
		loginPage = new LoginPage(driver);
	}

	
	/**
	 * Method used to verify and click on link verifying text.
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @param value
	 * @param message
	 * @return
	 * @throws Exception
	 */
	public boolean verifyAndClickUsingEquals(String locator, String value, boolean click, String message) throws Exception {
		logger.info("Method : verifyAndClickUsingEquals Start");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(locator);
			if(CollectionUtils.isNotEmpty(element)) {
				for(WebElement linkElement : element) {
					if(linkElement.getText().equalsIgnoreCase(value)) {
						flag = true;
						if(click) {
							linkElement.click();
						}
					}
				}
			} else {
				logger.info("Unable to find locator in verifyAndClickUsingEquals--> " + message);
			}
		}catch (Exception e) {
    		logger.info("Unable to verifyAndClickUsingEquals" );
			log(logger, "Unable to verifyAndClickUsingEquals" );
    		throw new DriverException("Unable to verifyAndClickUsingEquals" , e); 
    	}
		logger.info("Method: verifyAndClickUsingEquals End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to verify and click on link verifying text.
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @param value
	 * @param message
	 * @return
	 * @throws Exception
	 */
	public boolean verifyAndClickUsingContains(String locator, String value, boolean click, String message) throws Exception {
		logger.info("Method : verifyAndClickUsingContains Start");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(locator);
			if(CollectionUtils.isNotEmpty(element)) {
				for(WebElement linkElement : element) {
					if(linkElement.getText().contains(value)) {
						flag = true;
						if(click) {
							linkElement.click();
						}
					}
				}
			} else {
				logger.info("Unable to find locator in verifyAndClickUsingContains--> " + message);
			}
		}catch (Exception e) {
    		logger.info("Unable to verifyAndClickUsingContains" );
			log(logger, "Unable to verifyAndClickUsingContains" );
    		throw new DriverException("Unable to verifyAndClickUsingContains" , e); 
    	}
		logger.info("Method: verifyAndClickUsingContains End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Verify if Grid Data is Displayed
	 * @author syed.pasha
	 * @throws Exception
	 */
	public boolean verifyIfGridDataDisplayed(String Loactor) throws Exception {
		logger.info("Method:  verifyIfGridDataDisplayed End");
		boolean flag = false;		
		try {
			List<WebElement> messages = baseHandler.findElements(Loactor);
			if(messages.size()>0)
			{
				flag = true;
			}			
		} catch (Exception e) {
			logger.info("Unable to Verify Data");
			throw new DriverException("Unable to Verify Data", e);
		}
		logger.info("Method: verifyIfGridDataDisplayed End");
		return flag;
	}
	/**
	 * Method used to verify course cohort table header value
	 * 
	 * Cohort
	 * Size
	 * Institution
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws Exception
	 */
	public boolean verifyCourseCohortTableHeader() throws Exception {
		logger.info("Method : verifyCourseCohortTableHeader Start");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("id.home.course.cohort.table.header.loc"));
			if(CollectionUtils.isNotEmpty(element)) {
				// Getting hidden attributes
					int size = element.size();
					int count = 0;
					for(int index = 1; index < size; index++) {
					boolean textFlag = false;
					if(StringUtils.isEmpty(element.get(index).getAttribute("hidden"))) {
						// Getting header text
						List<WebElement> headerElement = element.get(index).findElements(By.cssSelector(PropertiesRepository.getString("id.home.course.cohort.table.header.text.loc")));
						if(CollectionUtils.isNotEmpty(headerElement)) {
							if(headerElement.get(0).getText().equalsIgnoreCase(PropertiesRepository.getString("id.home.profile.institution.name.input"))
									|| headerElement.get(0).getText().equalsIgnoreCase(PropertiesRepository.getString("cohort.text.people.page"))
									|| headerElement.get(0).getText().equalsIgnoreCase(PropertiesRepository.getString("id.home.size.name.input"))) {
								textFlag = true;
								count ++;
							} if(!textFlag) {
								logger.info("Course Cohort Header values are not matched.");
								break;
							} else if(count == 3){
								flag = true;
							}
						}
					}
				}
			} else {
				logger.info("Unable to find elements for Couse Cohort Table Header");
			}
		}catch (Exception e) {
    		logger.info("Unable to verifyCourseCohortTableHeader " );
			log(logger, "Unable to verifyCourseCohortTableHeader " );
    		throw new DriverException("Unable to verifyCourseCohortTableHeader " , e); 
    	}
		logger.info("Method: verifyCourseCohortTableHeader End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Verify Which tab is Active
	 * @author syed.pasha
	 * @throws Exception
	 */
	public boolean verifyActiveTab(String Loactor , int index ) throws Exception {
		logger.info("Method:  verifyIfElementDisplayed End");
		boolean flag = false;		
		try {
			List<WebElement> messages = baseHandler.findElements(Loactor);
			if(messages.get(index).getAttribute("aria-selected").equals("true"))
			{
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to Verify Active Tab");
			throw new DriverException("Unable to Verify Active Tab", e);
		}
		logger.info("Method: verifyIfElementDisplayed End");
		return flag;
	}
	/**
	 * Method used to count table row for Graduation Cohort/ Course Cohort.
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @return
	 * @throws Exception
	 */
	public boolean verifyTableRowCount(String locator, int size) throws Exception {
		logger.info("Method : verifyTableRowCount Start");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(locator);
			if(CollectionUtils.isNotEmpty(element)) {
				if(element.size() == size) {
					flag = true;
				}
			} else {
				logger.info("Unable to find Table row locator for Graduation/ Course Cohort");
			}
		}catch (Exception e) {
    		logger.info("Unable to verifyTableRowCount" );
			log(logger, "Unable to verifyTableRowCount" );
    		throw new DriverException("Unable to verifyTableRowCount" , e); 
    	}
		logger.info("Method: verifyTableRowCount End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to count minimum table row for Graduation Cohort/ Course Cohort.
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @return
	 * @throws Exception
	 */
	public boolean verifyTableMinimumRowCount(String locator, int size) throws Exception {
		logger.info("Method : verifyTableMinimumRowCount Start");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(locator);
			if(CollectionUtils.isNotEmpty(element)) {
				if(element.size() > size) {
					flag = true;
				}
			} else {
				logger.info("Unable to find Table row locator for Graduation/ Course Cohort");
			}
		}catch (Exception e) {
    		logger.info("Unable to verifyTableMinimumRowCount" );
			log(logger, "Unable to verifyTableMinimumRowCount" );
    		throw new DriverException("Unable to verifyTableMinimumRowCount" , e); 
    	}
		logger.info("Method: verifyTableMinimumRowCount End flag --> " + flag);
		return flag;
	}
	
	public String clickAndGetCohortNameFromTable() throws Exception {
		logger.info("Method : clickCohort Start");
		String selectedCohortName = null;
		try {
			// To get the count of cohort selected. clickAndGetCohortNameFromTable
			int beforeClickCohortSelectCount = getCohortSelectCount();
			logger.info("Cohort before clicking --> "+ beforeClickCohortSelectCount);
			selectedCohortName = clickCohortFromTable();
			
			if (StringUtils.isNotBlank(selectedCohortName)) {
				logger.info("Cohort Selected --> ");
				int afterClickCohortSelectCount = getCohortSelectCount();
				logger.info("Cohort after clicking --> "+ afterClickCohortSelectCount);
				
				if (afterClickCohortSelectCount > beforeClickCohortSelectCount) {
					logger.info("Selected Cohort is greater than the previous and returning its name");
				} else {
					logger.info("Cohort Selected count is not increased...");
					selectedCohortName = null;
				}
			} else {
				logger.info("Chort is not selected");
			}
		} catch (Exception e) {
			logger.info("Unable to clickCohort");
			log(logger, "Unable to clickCohort");
			throw new DriverException("Unable to clickCohort", e);
		}
		logger.info("Method: clickCohort End Cohort Name --> " + selectedCohortName);
		return selectedCohortName;
	}
	
	/**
	 * Method used to get selected count from cohort table 
	 * 1 Cohort(s) Selected.
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws Exception
	 */
	public int getCohortSelectCount() throws Exception {
		logger.info("Method : getCohortSelectCount Start");
		int count = 0;
		try {
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("id.home.cohort.selected.count.loc"));
			if(CollectionUtils.isNotEmpty(element)) {
				String value = element.get(0).getText();
				String cohortSelected = value.substring(0, value.indexOf("Cohort")).trim();
				count = Integer.valueOf(cohortSelected);
			}
		}catch (Exception e) {
    		logger.info("Unable to getCohortSelectCount" );
			log(logger, "Unable to getCohortSelectCount" );
    		throw new DriverException("Unable to getCohortSelectCount" , e); 
    	}
		logger.info("Method: getCohortSelectCount End count --> " + count);
		return count;
	}
	
	/**
	 * Method used to get selected Cohort name after clicking on check box from Cohort Table. 
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws Exception
	 */
	public String clickCohortFromTable() throws Exception {
		logger.info("Method : clickCohortFromTable Start");
		String name = null;
		try {
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("id.home.course.cohort.table.all.row.count.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				// Getting td from tr
				int size = element.size();
				for (int index = 0; index < size; index++) {
					// Check for check cohort name, if not click on unchecked check box.
					// if clicked, continue.
					WebElement rowElement = element.get(index);
					List<WebElement> checkCohortSelectStatus = rowElement.findElements(By.cssSelector(PropertiesRepository.getString("id.home.cohort.checked.checkbox.cohort.table.loc")));
					if (CollectionUtils.isNotEmpty(checkCohortSelectStatus)) {
						continue;
					} else {
						List<WebElement> tdElement = rowElement.findElements(By.cssSelector(PropertiesRepository.getString("id.home.cohort.unchecked.checkbox.cohort.table.loc")));
						if (CollectionUtils.isNotEmpty(tdElement)) {
							List<WebElement> tdClickElement = element.get(index)
									.findElements(By.cssSelector(PropertiesRepository
											.getString("id.home.cohort.unchecked.checkbox.cohort.table.loc")));
							if (CollectionUtils.isNotEmpty(tdClickElement)) {
								logger.info("Cohort Check box clicked");
								tdClickElement.get(0).click();
								// Getting Cohort Name. 
								List<WebElement> nametdElement = rowElement.findElements(By.cssSelector("td"));
								if(CollectionUtils.isNotEmpty(nametdElement)) {
									WebElement nameElement = nametdElement.get(1).findElement(By.cssSelector("span"));
									if(nameElement != null) {
										name = nameElement.getText();
									}else {
										logger.info("Unable to get Cohort name");
									}
								}
								break;
							}
						}
					}
				}
			} else {
				logger.info("Unable to click Cohort name from Cohort table");
			}
		} catch (Exception e) {
			logger.info("Unable to clickCohortFromTable");
			log(logger, "Unable to clickCohortFromTable");
			throw new DriverException("Unable to clickCohortFromTable", e);
		}
		logger.info("Method: clickCohortFromTable End name --> " + name);
		return name;
	}
	
	
	/**
	 * Method used to get selected Cohort name after verifying institution name. 
	 * 1. If it is clicked already, return cohort name and click on view dashboard. 
	 * 2. If it is not clicked, it will click, then save and view dashboard. 
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws Exception
	 */
	public String verifyInstitutionSelectedInGraduationCohort(String institutionName) throws Exception {
		logger.info("Method : verifyInstitutionSelectedInGraduationCohort Start");
		String name = null;
		try {
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("id.home.course.cohort.table.all.row.count.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				// Getting td from tr
				int size = element.size();
				for (int index = 0; index < size; index++) {
					// Check for check cohort name, if not click on unchecked check box.
					// if clicked, continue.
					WebElement rowElement = element.get(index);
					// To get institution name from table.
					List<WebElement> institutionElement = rowElement
							.findElements(By.cssSelector(PropertiesRepository.getString("id.home.cohort.institution.name.cohort.table.loc")));
					if(CollectionUtils.isNotEmpty(institutionElement)) {
						String institutionUIName = institutionElement.get(1).getText();
						if(StringUtils.isNotBlank(institutionUIName) && institutionName.equalsIgnoreCase(institutionUIName)) {
							// Getting checked and uncheked cohort from table.
							List<WebElement> checkedBoxElement = rowElement
									.findElements(By.cssSelector(PropertiesRepository.getString("id.home.cohort.checked.checkbox.cohort.table.loc")));
							List<WebElement> unCheckedBoxElement = rowElement
									.findElements(By.cssSelector(PropertiesRepository.getString("id.home.cohort.unchecked.checkbox.cohort.table.loc")));
							if(CollectionUtils.isNotEmpty(checkedBoxElement) && checkedBoxElement.size() > 0) {
								logger.info("Check box is already clicked for " + institutionName);
								
								// Getting Cohort Name. 
								List<WebElement> nametdElement = rowElement.findElements(By.cssSelector("td"));
								if(CollectionUtils.isNotEmpty(nametdElement)) {
									WebElement nameElement = nametdElement.get(1).findElement(By.cssSelector("span"));
									if(nameElement != null) {
										name = nameElement.getText();
									}else {
										logger.info("Unable to get Cohort name");
									}
								}
								
								// Clicking on View Dashboard button
								verifyAndClick(
										PropertiesRepository.getString("id.home.cohort.view.dashboard.button.loc"), true);
								
								break;
							} else {
								logger.info("Check box is not clicked for " + institutionName + " so clicking institution check box");
								if (CollectionUtils.isNotEmpty(unCheckedBoxElement)) {
									List<WebElement> tdClickElement = element.get(index)
											.findElements(By.cssSelector(PropertiesRepository
													.getString("id.home.cohort.unchecked.checkbox.cohort.table.loc")));
									if (CollectionUtils.isNotEmpty(tdClickElement)) {
										logger.info("Cohort Check box clicked");
										tdClickElement.get(0).click();
									}
								}
								
								// Getting Cohort Name. 
								List<WebElement> nametdElement = rowElement.findElements(By.cssSelector("td"));
								if(CollectionUtils.isNotEmpty(nametdElement)) {
									WebElement nameElement = nametdElement.get(1).findElement(By.cssSelector("span"));
									if(nameElement != null) {
										name = nameElement.getText();
									}else {
										logger.info("Unable to get Cohort name");
									}
								}
								
								// Clicking on Save button. 
								verifyAndClick(
										PropertiesRepository.getString("id.home.cohort.save.and.view.dashboard.button.loc"), true);
								
								// Clicking on View Dashboard button
								verifyAndClick(
										PropertiesRepository.getString("id.home.cohort.view.dashboard.button.loc"), true);
								break;
							}
							
						} else {
							logger.info(institutionName + "-->  Institution name is not checked");
						}
					}
				}
			} else {
				logger.info("Unable to click Cohort name from Cohort table");
			}
		} catch (Exception e) {
			logger.info("Unable to verifyInstitutionSelectedInGraduationCohort");
			log(logger, "Unable to verifyInstitutionSelectedInGraduationCohort");
			throw new DriverException("Unable to verifyInstitutionSelectedInGraduationCohort", e);
		}
		logger.info("Method: verifyInstitutionSelectedInGraduationCohort End name --> " + name);
		return name;
	}
	
	/**
	 * Method used to get selected Cohort name after verifying institution name and cohort name. 
	 * 1. If it is clicked already, return cohort name and click on view dashboard. 
	 * 2. If it is not clicked, it will click, then save and view dashboard. 
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws Exception
	 */
	public String verifyInstitutionSelectedInGraduationCohort(String institutionName, String cohortName) throws Exception {
		logger.info("Method : verifyInstitutionSelectedInGraduationCohort Start");
		String name = null;
		try {
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("id.home.course.cohort.table.all.row.count.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				// Getting td from tr
				int size = element.size();
				for (int index = 0; index < size; index++) {
					// Check for check cohort name, if not click on unchecked check box.
					// if clicked, continue.
					WebElement rowElement = element.get(index);
					// To get institution name from table.
					List<WebElement> institutionElement = rowElement
							.findElements(By.cssSelector(PropertiesRepository.getString("id.home.cohort.institution.name.cohort.table.loc")));
					if(CollectionUtils.isNotEmpty(institutionElement)) {
						String institutionUIName = institutionElement.get(1).getText();
						
						// Getting Cohort Name. 
						List<WebElement> nametdElement = rowElement.findElements(By.cssSelector("td"));
						if(CollectionUtils.isNotEmpty(nametdElement)) {
							WebElement nameElement = nametdElement.get(1).findElement(By.cssSelector("span"));
							if(nameElement != null) {
								name = nameElement.getText();
							}else {
								logger.info("Unable to get Cohort name");
							}
						}
						
						if(StringUtils.isNotBlank(institutionUIName) && institutionName.equalsIgnoreCase(institutionUIName)
								&& name.equalsIgnoreCase(cohortName)) {
							// Getting checked and uncheked cohort from table.
							List<WebElement> checkedBoxElement = rowElement
									.findElements(By.cssSelector(PropertiesRepository.getString("id.home.cohort.checked.checkbox.cohort.table.loc")));
							if(CollectionUtils.isNotEmpty(checkedBoxElement) && checkedBoxElement.size() > 0) {
								logger.info("Check box is already clicked for " + institutionName);
								
								logger.info("Check box is already clicked for " + name + " so clicking cohort check box");
								checkedBoxElement.get(0).click();
								
								// Clicking on Save button. 
								verifyAndClick(
										PropertiesRepository.getString("id.home.cohort.save.and.view.dashboard.button.loc"), true);
								
								// Clicking on View Dashboard button
								verifyAndClick(
										PropertiesRepository.getString("id.home.cohort.view.dashboard.button.loc"), true);
								break;
							} 
						} else {
							logger.info(institutionName + "-->  Institution name is not checked");
						}
					}
				}
			} else {
				logger.info("Unable to click Cohort name from Cohort table");
			}
		} catch (Exception e) {
			logger.info("Unable to verifyInstitutionSelectedInGraduationCohort");
			log(logger, "Unable to verifyInstitutionSelectedInGraduationCohort");
			throw new DriverException("Unable to verifyInstitutionSelectedInGraduationCohort", e);
		}
		logger.info("Method: verifyInstitutionSelectedInGraduationCohort End name --> " + name);
		return name;
	}
	/**
	 * Method used to verify Cohort type and Cohort name in Home Page. 
	 * 
	 * @author saravanan.jothimani
	 * @param cohortType
	 * @param cohortName
	 * @return
	 * @throws Exception
	 */
	public boolean verifyCohortAndItsNameInDashboard(String cohortType, String cohortName) throws Exception {
		logger.info("Method : verifyCohortAndItsNameInDashboard Start");
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
									flag = true;
									break;
								}
							}
						} 
					}
				}
			} else {
				logger.info("Unable to find locator for cohort in home page");
			}
			
		}catch (Exception e) {
    		logger.info("Unable to verifyCohortAndItsNameInDashboard" );
			log(logger, "Unable to verifyCohortAndItsNameInDashboard" );
    		throw new DriverException("Unable to verifyCohortAndItsNameInDashboard" , e); 
    	}
		logger.info("Method: verifyCohortAndItsNameInDashboard End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to verify Cohort type and Cohort name in Home Page. 
	 * 
	 * @author saravanan.jothimani
	 * @param cohortType
	 * @param cohortName
	 * @return
	 * @throws Exception
	 */
	public boolean verifyCohortAndItsNameInDashboardAndItsInstutiton(String cohortType, String cohortName, String institutionName) throws Exception {
		logger.info("Method : verifyCohortAndItsNameInDashboard Start");
		boolean flag = false;
		try {
			// Getting Cohort list in Home Page
			List<WebElement> element = baseHandler.findElements("div[class='home-card-section']");
			if(CollectionUtils.isNotEmpty(element) ) {
				for(WebElement cohortList : element) {
					// Getting sub title ie cohort type name Graduation/ Course Cohort.
					List<WebElement> cohortTypeList = cohortList.findElements(By.cssSelector(PropertiesRepository.getString("id.home.dashboard.subtitle.name.loc")));
					if(CollectionUtils.isNotEmpty(cohortTypeList)) {
						String cohortTypeValue = cohortTypeList.get(0).getText();
						if(cohortTypeValue.contains(cohortType)) {
							// Getting institution name. 
							List<WebElement> institutionElement = cohortList.findElements(By.cssSelector("div[class='institution-align ng-star-inserted']"));
							if(CollectionUtils.isNotEmpty(institutionElement) && institutionElement.get(0).getText().trim().equalsIgnoreCase(institutionName)) {
								// Getting title ie cohort name.
								List<WebElement> cohortNameList = cohortList.findElements(By.cssSelector(PropertiesRepository.getString("id.home.dashboard.title.name.loc")));
								if(CollectionUtils.isNotEmpty(cohortNameList)) {
									String cohortNameValue = cohortNameList.get(0).getText();
									if(cohortNameValue.equalsIgnoreCase(cohortName)) {
										flag = true;
										break;
									}
								} else {
									logger.info("Unable to verify cohort name");
								}
							} else {
								logger.info("Unable to verify institution name");
							}
						} else {
							logger.info("Unable to verify cohort type");
						}
					} else {
						logger.info("Unable to get cohort type list");
					}
				}
			} else {
				logger.info("Unable to find locator for cohort in home page");
			}
			
		}catch (Exception e) {
    		logger.info("Unable to verifyCohortAndItsNameInDashboardAndItsInstutiton" );
			log(logger, "Unable to verifyCohortAndItsNameInDashboardAndItsInstutiton" );
    		throw new DriverException("Unable to verifyCohortAndItsNameInDashboardAndItsInstutiton" , e); 
    	}
		logger.info("Method: verifyCohortAndItsNameInDashboardAndItsInstutiton End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to reset the checked cohort name in Customize page. 
	 * 
	 * @author saravanan.jothimani
	 * @param cohortName
	 * @return
	 * @throws Exception
	 */
	public boolean resetCohortName(String cohortName) throws Exception {
		logger.info("Method : resetCohortName Start");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("id.home.course.cohort.table.all.row.count.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				// Getting td from tr
				int size = element.size();
				for (int index = 0; index < size; index++) {
					WebElement rowElement = element.get(index);
					
					// Getting Cohort Name. 
					List<WebElement> nametdElement = rowElement.findElements(By.cssSelector("td"));
					if(CollectionUtils.isNotEmpty(nametdElement)) {
						WebElement nameElement = nametdElement.get(1).findElement(By.cssSelector("span"));
						if(nameElement != null) {
							String name = nameElement.getText();
							if(StringUtils.isNotBlank(name) && name.equalsIgnoreCase(cohortName)) {
								// check cohort name is clicked. 
								List<WebElement> checkCohortSelectStatus = rowElement.findElements(By.cssSelector(PropertiesRepository.getString("id.home.cohort.checked.checkbox.cohort.table.loc")));
								if (CollectionUtils.isNotEmpty(checkCohortSelectStatus)) {
									checkCohortSelectStatus.get(0).click();
									flag = true;
									break;
								} else {
									logger.info("Check box is not clicked");
								}
							}
						}else {
							logger.info("Unable to get Cohort name");
						}
					}
				}
			} else {
				logger.info("Unable to click Cohort name from Cohort table");
			}
		}catch (Exception e) {
    		logger.info("Unable to resetCohortName" );
			log(logger, "Unable to resetCohortName" );
    		throw new DriverException("Unable to resetCohortName" , e); 
    	}
		logger.info("Method: resetCohortName End flag --> " + flag);
		return flag;
	}
	/**
	 * Method used to click first Graduation Cohort manage button. 
	 *  
	 * @author kumarisagarika.t
	 * @return
	 * @throws Exception
	 */
	public boolean clickGraduationCohortFirstManageButton() throws Exception {
		logger.info("Method : clickGraduationCohortFirstManageButton Start");
		boolean flag = false;
		try {
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
						if(cohortTypeValue.contains(PropertiesRepository.getString("id.home.graduation.cohorts.home.page.value"))) {
							// Click Manage Button. 
							List<WebElement> manageBtn = rowElement.findElements(By.cssSelector(PropertiesRepository.getString("id.home.dashboard.course.manage.button.loc")));
							if (CollectionUtils.isNotEmpty(manageBtn)) 
							{
								for(int i=0;i<manageBtn.size();i++)
								{
									String actual=manageBtn.get(i).getText();
									String expected=PropertiesRepository.getString("id.home.dashboard.btn.val");
									System.out.println(actual+" "+expected);
								  if(actual.contains(expected))
								   {
								    manageBtn.get(i).click();
								    flag = true;
								    break;
								}}} else {
								logger.info("Unable to verify graduation Cohort Manage Button in Dashboard Page");
							}
						} 
					}
				}
			}
		}catch (Exception e) {
    		logger.info("Unable to clickCourseCohortFirstManageButton" );
			log(logger, "Unable to clickCourseCohortFirstManageButton" );
    		throw new DriverException("Unable to clickCourseCohortFirstManageButton" , e); 
    	}
		logger.info("Method: clickCourseCohortFirstManageButton End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to verify Highlights page content 
	 *  
	 * @author kumarisagarika.t
	 * @return
	 * @throws Exception
	 */
	public boolean verifyHighlightPageCards() throws Exception {
		logger.info("Method : verifyHighlightPageCards Start");
		boolean flag = false;
		String pulse=PropertiesRepository.getString("id.highlight.pulse.card.val");
		String course=PropertiesRepository.getString("id.highlight.coursework.card.val");
		String proc=PropertiesRepository.getString("id.highlight.proctor.card.val");
		String prac=PropertiesRepository.getString("id.highlight.Practice.card.val");
		try {
			// Getting card list in Highlight Page
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("id.highlight.card.list.loc"));
			if(CollectionUtils.isNotEmpty(element) ) {
				int size = element.size();
				for(int index = 0; index < size ; index++) {
					 String cardName = element.get(index).getText();
					 if (cardName.equalsIgnoreCase(pulse) || cardName.equalsIgnoreCase(course) || 
							 cardName.equalsIgnoreCase(prac) || cardName.equalsIgnoreCase(proc))
		
					 {
						 flag = true;
						 
							}
					// else{flag=false;}
						
					}
				}
			
		}catch (Exception e) {
    		logger.info("Unable to verifyHighlightPageCards" );
			log(logger, "Unable to verifyHighlightPageCards" );
    		throw new DriverException("Unable to verifyHighlightPageCards" , e); 
    	}
		logger.info("Method: verifyHighlightPageCards End flag --> " + flag);
		return flag;
	}
	/**
	 * Method used to verify sub-tabs under manage products page . 
	 *  
	 * @author kumarisagarika.t
	 * @return
	 * @throws Exception
	 */
	public boolean VerifySubTabs() throws Exception {
		logger.info("Method : VerifySubTabs Start");
		boolean flag = false;
		String manageProducts = PropertiesRepository.getString("id.products.manageProducts.val");
		try {
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			loginPage.switchToCardShadowFrame();
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("id.tutorial.tab.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				flag=element.get(0).isDisplayed();
				}
			 element = baseHandler.findElements(PropertiesRepository.getString("id.practice.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				flag=element.get(0).isDisplayed();
				}
			element = baseHandler.findElements(PropertiesRepository.getString("id.proctor.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				flag=element.get(0).isDisplayed();
				}
		}catch (Exception e) {
    		logger.info("Unable to VerifySubTabs" );
			log(logger, "Unable to VerifySubTabs" );
    		throw new DriverException("Unable to VerifySubTabs" , e); 
    	}
		logger.info("Method: VerifySubTabs End flag --> " + flag);
		return flag;
	}
	
	
	
	
	/**
	 * Method used to reset the checked cohort name in Customize page. 
	 * 
	 * @author saravanan.jothimani
	 * @param cohortName
	 * @return
	 * @throws Exception
	 */
	public boolean resetCohortName(String checkBoxLocator, String cohortName) throws Exception {
		logger.info("Method : resetCohortName Start");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("id.home.course.cohort.table.all.row.count.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				// Getting td from tr
				int size = element.size();
				for (int index = 0; index < size; index++) {
					WebElement rowElement = element.get(index);
					
					// Getting Cohort Name. 
					List<WebElement> nametdElement = rowElement.findElements(By.cssSelector("td"));
					if(CollectionUtils.isNotEmpty(nametdElement)) {
						WebElement nameElement = nametdElement.get(1).findElement(By.cssSelector("span"));
						if(nameElement != null) {
							String name = nameElement.getText();
							if(StringUtils.isNotBlank(name) && name.equalsIgnoreCase(cohortName)) {
								// check cohort name is clicked. 
								List<WebElement> checkCohortSelectStatus = rowElement.findElements(By.cssSelector(checkBoxLocator));
								if (CollectionUtils.isNotEmpty(checkCohortSelectStatus)) {
									checkCohortSelectStatus.get(0).click();
									flag = true;
									break;
								} else {
									logger.info("Check box is not clicked");
								}
							}
						}else {
							logger.info("Unable to get Cohort name");
						}
					}
				}
			} else {
				logger.info("Unable to click Cohort name from Cohort table");
			}
		}catch (Exception e) {
    		logger.info("Unable to resetCohortName" );
			log(logger, "Unable to resetCohortName" );
    		throw new DriverException("Unable to resetCohortName" , e); 
    	}
		logger.info("Method: resetCohortName End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to verify Course Cohort details in Dashboard page.
	 * 
	 *  Course Type
	 *  Course Name
	 *  Student count 
	 *  Products Available
	 *  Products Count
	 *  Manage Button. 
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws Exception
	 */
	public boolean verifyCourseCohortDetailsInDashboard() throws Exception {
		logger.info("Method : verifyCourseCohortDetailsInDashboard Start");
		boolean flag = false;
		boolean cohortNameFlag = false;
		boolean cohortStudentCountFlag = false;
		boolean productAvailableFlag = false;
		boolean productCountFlag = false;
		boolean manageBtnFlag = false;
		
		try {
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
							// Get Course Cohort Name
							// Getting Cohort Name. 
							
							List<WebElement> cohortNameList = rowElement.findElements(By.cssSelector(PropertiesRepository.getString("id.home.dashboard.title.name.loc")));
							if(CollectionUtils.isNotEmpty(cohortNameList)) {
								String cohortNameValue = cohortNameList.get(0).getText();
								if(StringUtils.isNoneBlank(cohortNameValue)) {
									cohortNameFlag = true;
								} else {
									logger.info("Unable to verify Course Cohort Name in Dashboard Page");
								}
							}
							
							// Get Course Student count. 
							List<WebElement> checkCohortSelectStatus = rowElement.findElements(By.cssSelector(PropertiesRepository.getString("id.home.dashboard.student.count.name.loc")));
							if (CollectionUtils.isNotEmpty(checkCohortSelectStatus)) {
								cohortStudentCountFlag = true;
							} else {
								logger.info("Unable to verify Course Cohort Student in Dashboard Page");
							}
							// Product Available
							List<WebElement> productAvailable = rowElement.findElements(By.cssSelector(PropertiesRepository.getString("id.home.dashboard.course.product.available.loc")));
							if (CollectionUtils.isNotEmpty(productAvailable) && productAvailable.get(0).getText().equalsIgnoreCase(PropertiesRepository.getString("id.home.dashboard.course.product.available.name"))) {
								productAvailableFlag = true;
							} else {
								logger.info("Unable to verify Course Cohort Products Available in Dashboard Page");
							}
							// Product Count.
							List<WebElement> productCount = rowElement.findElements(By.cssSelector(PropertiesRepository.getString("id.home.dashboard.student.count.name.loc")));
							if (CollectionUtils.isNotEmpty(productCount)) {
								productCountFlag = true;
							} else {
								logger.info("Unable to verify Course Cohort Product Count in Dashboard Page");
							}
							// Check Manage Button. 
							List<WebElement> manageBtn = rowElement.findElements(By.cssSelector(PropertiesRepository.getString("id.home.dashboard.course.manage.button.loc")));
							if (CollectionUtils.isNotEmpty(manageBtn)) {
								manageBtnFlag = true;
							} else {
								logger.info("Unable to verify Course Cohort Manage Button in Dashboard Page");
							}
							
							if(cohortNameFlag && cohortStudentCountFlag && productAvailableFlag && productCountFlag && manageBtnFlag) {
								flag = true;
								break;
							}
						} 
					}
				}
			}
		}catch (Exception e) {
    		logger.info("Unable to verifyCourseCohortDetailsInDashboard" );
			log(logger, "Unable to verifyCourseCohortDetailsInDashboard" );
    		throw new DriverException("Unable to verifyCourseCohortDetailsInDashboard" , e); 
    	}
		logger.info("Method: verifyCourseCohortDetailsInDashboard End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to click first Course Cohort manage button. 
	 *  
	 * @author saravanan.jothimani
	 * @return
	 * @throws Exception
	 */
	public boolean clickCourseCohortFirstManageButton() throws Exception {
		logger.info("Method : clickCourseCohortFirstManageButton Start");
		boolean flag = false;
		try {
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
							// Click Manage Button. 
							List<WebElement> manageBtn = rowElement.findElements(By.cssSelector(PropertiesRepository.getString("id.home.dashboard.course.manage.button.loc")));
							if (CollectionUtils.isNotEmpty(manageBtn)) {
								manageBtn.get(0).click();
								break;
							} else {
								logger.info("Unable to verify Course Cohort Manage Button in Dashboard Page");
							}
						} 
					}
				}
			}
		}catch (Exception e) {
    		logger.info("Unable to clickCourseCohortFirstManageButton" );
			log(logger, "Unable to clickCourseCohortFirstManageButton" );
    		throw new DriverException("Unable to clickCourseCohortFirstManageButton" , e); 
    	}
		logger.info("Method: clickCourseCohortFirstManageButton End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to get check Course Cohort name in alphabetical order. 
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws Exception
	 */
	public boolean checkCourseCohortNameInAlphabeticalOrder() throws Exception {
		logger.info("Method : checkCourseCohortNameInAlphabeticalOrder Start");
		boolean flag = false;
		List<String> beforeSortCohortNames = new ArrayList<String>();
		List<String> afterSortCohortNames = new ArrayList<String>();
		
		try {
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("id.home.course.cohort.table.all.row.count.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				// Getting td from tr
				int size = element.size();
				for (int index = 0; index < size; index++) {
					// Check for check cohort name, if not click on unchecked check box.
					// if clicked, continue.
					WebElement rowElement = element.get(index);
					// Getting Cohort Name. 
					List<WebElement> nametdElement = rowElement.findElements(By.cssSelector("td"));
					if(CollectionUtils.isNotEmpty(nametdElement)) {
						WebElement nameElement = nametdElement.get(1).findElement(By.cssSelector("span"));
						if(nameElement != null) {
							beforeSortCohortNames.add(nameElement.getText());
							afterSortCohortNames.add(nameElement.getText());
						}else {
							logger.info("Unable to get Cohort name");
						}
					}
				}
				
				if(CollectionUtils.isNotEmpty(beforeSortCohortNames) && CollectionUtils.isNotEmpty(afterSortCohortNames)) {
					Collections.sort(afterSortCohortNames, String.CASE_INSENSITIVE_ORDER);
					if(beforeSortCohortNames.equals(afterSortCohortNames)) {
						flag = true;
					}
				}
			} else {
				logger.info("Unable to click Cohort name from Cohort table");
			}
		} catch (Exception e) {
			logger.info("Unable to checkCourseCohortNameInAlphabeticalOrder");
			log(logger, "Unable to checkCourseCohortNameInAlphabeticalOrder");
			throw new DriverException("Unable to checkCourseCohortNameInAlphabeticalOrder", e);
		}
		logger.info("Method: checkCourseCohortNameInAlphabeticalOrder End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to enter institution name in institution text box for Personnel user. 
	 * 
	 * @author saravanan.jothimani
	 * @param institutionName
	 * @return
	 * @throws Exception
	 */
	public boolean verifyInstitutionNameForPersonnel(String institutionName) throws Exception {
		logger.info("Method : verifyInstitutionNameForPersonnel Start");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("id.home.institution.text.box.loc"));
			if(CollectionUtils.isNotEmpty(element)) {
				textHandler.writeText(element.get(0), institutionName);
				List<WebElement> buttonElement = baseHandler.findElements(PropertiesRepository.getString("id.home.institution.text.box.showing.single.value.loc"));
				if(CollectionUtils.isNotEmpty(buttonElement)) {
					buttonHandler.clickButton(buttonElement.get(0));
				}
			}
		}catch (Exception e) {
    		logger.info("Unable to verifyInstitutionNameForPersonnel" );
			log(logger, "Unable to verifyInstitutionNameForPersonnel" );
    		throw new DriverException("Unable to verifyInstitutionNameForPersonnel" , e); 
    	}
		logger.info("Method: verifyInstitutionNameForPersonnel End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to verify filter section institution list in Cohort page. 
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws Exception
	 */
	public boolean verifyFilterSectionInstitutions() throws Exception {
		logger.info("Method : verifyFilterSectionInstitutions Start");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("id.home.customize.home.cohort.institution.all.list.loc"));
			if(CollectionUtils.isNotEmpty(element) && element.size() > 0) {
				flag = true;
			}
		}catch (Exception e) {
    		logger.info("Unable to verifyFilterSectionInstitutions" );
			log(logger, "Unable to verifyFilterSectionInstitutions" );
    		throw new DriverException("Unable to verifyFilterSectionInstitutions" , e); 
    	}
		logger.info("Method: verifyFilterSectionInstitutions End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to verify filter section institution list check box in Cohort page. 
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws Exception
	 */
	public boolean verifyFilterSectionInstitutionsCheckBox() throws Exception {
		logger.info("Method : verifyFilterSectionInstitutionsCheckBox Start");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("id.home.customize.home.cohort.institution.all.list.loc"));
			if(CollectionUtils.isNotEmpty(element) && element.size() > 0) {
				for(WebElement checkBoxElement : element) {
					List<WebElement> checkBxElement = checkBoxElement.findElements(By.cssSelector(PropertiesRepository.getString("id.home.customize.home.cohort.institution.checkbox.loc")));
					if(CollectionUtils.isNotEmpty(checkBxElement)) {
						flag = true;
					}
				}
			}
		}catch (Exception e) {
    		logger.info("Unable to verifyFilterSectionInstitutionsCheckBox" );
			log(logger, "Unable to verifyFilterSectionInstitutionsCheckBox" );
    		throw new DriverException("Unable to verifyFilterSectionInstitutionsCheckBox" , e); 
    	}
		logger.info("Method: verifyFilterSectionInstitutionsCheckBox End flag --> " + flag);
		return flag;
	}
	
	
	/**
	 * Method used to verify filter section institution list check box functionality in Cohort page. 
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws Exception
	 */
	public boolean verifyFilterSectionInstitutionsCheckBoxFn() throws Exception {
		logger.info("Method : verifyFilterSectionInstitutionsCheckBoxFn Start");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("id.home.customize.home.cohort.institution.all.list.loc"));
			if(CollectionUtils.isNotEmpty(element) && element.size() > 0) {
				WebElement individualCheckBxEle = null;
				List<WebElement> chckBxEle = null;
				for(WebElement checkBoxElement : element) {
					individualCheckBxEle = null;
					chckBxEle = null;
					List<WebElement> checkBxElement = checkBoxElement.findElements(By.cssSelector("input"));
					if(CollectionUtils.isNotEmpty(checkBxElement)) {
						individualCheckBxEle = checkBxElement.get(0);
						// Check Box Element
						chckBxEle = checkBoxElement.findElements(By.cssSelector("label div[class='mat-checkbox-inner-container']"));
						
						if(individualCheckBxEle != null && getCheckBoxStatus(individualCheckBxEle)) {
							logger.info("Check box is checked and unchecking the check box and verifying the status.");
							
							// Checked
							boolean checkFlag = checkCheckBox(chckBxEle.get(0));
							
							if(checkFlag) {
								flag = true;
								break;
							}
						} else {
							logger.info("Check box is unchecked and checking the checkbox and verifying the status.");
							// Un Checked
							boolean unCheckFlag = checkCheckBox(chckBxEle.get(0));
							if(unCheckFlag) {
								flag = true;
								break;
							}
						}
					}
				}
				
				if(flag) {
					logger.info("Reset to previous value after verifying");
					checkCheckBox(chckBxEle.get(0));
				}
			}
		}catch (Exception e) {
    		logger.info("Unable to verifyFilterSectionInstitutionsCheckBoxFn" );
			log(logger, "Unable to verifyFilterSectionInstitutionsCheckBoxFn" );
    		throw new DriverException("Unable to verifyFilterSectionInstitutionsCheckBoxFn" , e); 
    	}
		logger.info("Method: verifyFilterSectionInstitutionsCheckBoxFn End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to check a check box. 
	 * 
	 * @author saravanan.jothimani
	 * @param element
	 * @return
	 * @throws Exception
	 */
	public boolean checkCheckBox(WebElement element ) throws Exception {
		logger.info("Method : checkCheckBox Start");
		boolean flag = false;
		try {
			if(element != null) {
				element.click();
				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				flag = true;
			}
		}catch (Exception e) {
    		logger.info("Unable to checkCheckBox" );
			log(logger, "Unable to checkCheckBox" );
    		throw new DriverException("Unable to checkCheckBox" , e); 
    	}
		logger.info("Method: checkCheckBox End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to get check box status. 
	 * 
	 * @author saravanan.jothimani
	 * @param element
	 * @return
	 * @throws Exception
	 */
	public boolean getCheckBoxStatus(WebElement element) throws Exception {
		logger.info("Method : getCheckBoxStatus Start");
		boolean flag = false;
		try {
			if(element != null) {
				String checkedStatus = element.getAttribute("checked");
				if(StringUtils.isNotBlank(checkedStatus) && checkedStatus.equalsIgnoreCase("true")) {
					flag = true;
				} else {
					logger.info("Check box is not checked");
				}
			}
		}catch (Exception e) {
    		logger.info("Unable to getCheckBoxStatus" );
			log(logger, "Unable to getCheckBoxStatus" );
    		throw new DriverException("Unable to getCheckBoxStatus" , e); 
    	}
		logger.info("Method: getCheckBoxStatus End flag --> " + flag);
		return flag;
	}

	/**
	 * Verify GRADUATION COHORTS Grid Data
	 * 
	 * @author syed.pasha
	 * @throws DriverException
	 */
	public boolean verifyGDGridData(String gdData0, String gdData1, String gdData2) throws DriverException {
		logger.info("Method : verifyGDGridData Start ");
		boolean flag = false;
		try {
			List<WebElement> tableRow = baseHandler
					.findElements(PropertiesRepository.getString("id.home.customize.home.grid.data.loc"));
			if (tableRow != null && tableRow.get(0).getText().equals(PropertiesRepository.getString(gdData0))
					&& tableRow.get(1).getText().equals(PropertiesRepository.getString(gdData1)) && tableRow.get(2).getText().equals(PropertiesRepository.getString(gdData2))) {
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to Verify GRADUATION COHORTS Grid Data");
			log(logger, "Unable to Verify GRADUATION COHORTS Grid Data");
			throw new DriverException("Unable to Verify GRADUATION COHORTS Grid Data", e);
		}
		logger.info("Method: verifyGDGridData End flag --> " + flag);
		return flag;
	}

	/**
	 * Verify GRADUATION COHORTS Grid Data
	 * 
	 * @author syed.pasha
	 * @throws DriverException
	 */
	public boolean verifyGDGridData(String gdData) throws DriverException {
		logger.info("Method : verifyGDGridData Start ");
		boolean flag = false;
		try {
			List<WebElement> tableRow = baseHandler
					.findElements(PropertiesRepository.getString("id.home.customize.home.grid.data.loc"));
			for(WebElement element : tableRow)
			if (element != null && element.getText().equals(PropertiesRepository.getString(gdData))
					) {
				flag = true;
				break;
			}
		} catch (Exception e) {
			logger.info("Unable to Verify GRADUATION COHORTS Grid Data");
			log(logger, "Unable to Verify GRADUATION COHORTS Grid Data");
			throw new DriverException("Unable to Verify GRADUATION COHORTS Grid Data", e);
		}
		logger.info("Method: verifyGDGridData End flag --> " + flag);
		return flag;
	}

	
	/**
	 * Verify Course COHORTS Grid Data is in Ascending order or Descending ordr
	 * 
	 * @author syed.pasha
	 * @throws DriverException
	 */
	public boolean verifyCCGridDatainAsceDesc(String order) throws DriverException {
		logger.info("Method : verifyCCGridDatainAsceDesc Start ");
		boolean flag = false;
		ArrayList<String> tableRowData = new ArrayList<String>();
		try {
			List<WebElement> tableRow = baseHandler
					.findElements(PropertiesRepository.getString("id.home.customize.home.grid.data.loc"));
			for (int i = 0; i < tableRow.size(); i++) {
				tableRowData.add(tableRow.get(i).getText());
			}
			ArrayList tmp = new ArrayList(tableRowData);
			Collections.sort(tmp , String.CASE_INSENSITIVE_ORDER);			
			
			if(order.contains("descending"))
			{
				Collections.reverse(tmp);
			}
			if (tmp.equals(tableRowData)) {
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to Verify Ascending/Descending order");
			log(logger, "Unable to Verify Ascending/Descending order");
			throw new DriverException("Unable to Verify Ascending/Descending order", e);
		}
		logger.info("Method: verifyCCGridDatainAsceDesc End flag --> " + flag);
		return flag;
	}

}
