package com.automation.id.pages;

import java.util.ArrayList;
import java.util.Collections;
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


public class ManageRosterPage extends IDBasePage {

	private Logger logger = LogManager.getLogger(this.getClass());

	public ManageRosterPage(WebDriver webDriver) {
		super(webDriver);
	}

	/**
	 * Method used to enter text in Student Roster Search text box. 
	 * 
	 * @author saravanan.jothimani
	 * @param value
	 * @throws Exception
	 */
	public void enterTextInSearchBox(String value) throws Exception {
		logger.info("Method :enterTextInSearchBox Start");
		try {
			List<WebElement> inputText = verifyElementList(PropertiesRepository.getString("id.product.manage.roster.student.roster.search.by.last.name.text.box.loc"));
			if (CollectionUtils.isNotEmpty(inputText)) {
				inputText.get(0).click(); 
				inputText.get(0).sendKeys(value);
				inputText.get(0).sendKeys(Keys.ENTER);
			} else {
				logger.info("Unable to find element in enterTextInSearchBox");
			}
		}catch (Exception e) {
    		logger.info("Unable to enterTextInSearchBox" );
			log(logger, "Unable to enterTextInSearchBox" );
    		throw new DriverException("Unable to enterTextInSearchBox" , e); 
    	}
		logger.info("Method:enterTextInSearchBox End");
	}
	
	/**
	 * Used to verify message in Student roster table with first name and last name. 
	 * 
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @throws Exception
	 */
	public boolean verifyFirstNameAndLastNameInTable(String locator, int index, String value1, String value2) throws DriverException {
		logger.info("verifyFirstNameAndLastNameInTable Start ");
		logger.info("Locator value --> " + locator);
		logger.info("index value --> " + index);
		logger.info("value1 --> " + value1);
		logger.info("value2 --> " + value2);
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(element) && element.size() > 0) {
				StringBuilder sb = new StringBuilder(value1);
				sb.append(", ").append(value2);
				if (sb.toString().equalsIgnoreCase(element.get(index).getText().trim())) {
					flag = true;
				}
			} else {
				logger.info("Unable to find elements for message verification");
			}
		} catch (Exception e) {
			logger.info("Unable to verifyFirstNameAndLastNameInTable");
			log(logger, "Unable to verifyFirstNameAndLastNameInTable");
			throw new DriverException("Unable to verifyFirstNameAndLastNameInTable", e);
		}
		logger.info("verifyFirstNameAndLastNameInTable End flag -->" + flag);
		return flag;
	}
	
	/**
	 * Used to verify message in Student roster table with first name and last name. 
	 * 
	 * 
	 * @author saravanan.jothimani
	 * @param locator
	 * @throws Exception
	 */
	public boolean verifyLastNameInTable(String locator, int index, String value1) throws DriverException {
		logger.info("verifyLastNameInTable Start ");
		logger.info("Locator value --> " + locator);
		logger.info("index value --> " + index);
		logger.info("value1 --> " + value1);
		logger.info("value2 --> " + value1);
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(element) && element.size() > 0) {
				StringBuilder sb = new StringBuilder(value1);
				if (element.get(index).getText().trim().contains(sb.toString())) {
					flag = true;
				}
			} else {
				logger.info("Unable to find elements for message verification");
			}
		} catch (Exception e) {
			logger.info("Unable to verifyLastNameInTable");
			log(logger, "Unable to verifyLastNameInTable");
			throw new DriverException("Unable to verifyLastNameInTable", e);
		}
		logger.info("verifyLastNameInTable End flag -->" + flag);
		return flag;
	}
	
	/**
	 * Method used to verify name is in ascending order. 
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws Exception
	 */
	public boolean verifyNameInAscendingOrder() throws Exception {
		logger.info("Method : verifyNameInAscendingOrder Start");
		boolean flag = false;
		List<String> beforeSort = new ArrayList<String>();
		List<String> afterSort = new ArrayList<String>();
		try {
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("id.product.manage.roster.student.roster.table.row.name.loc"));
			if(CollectionUtils.isNotEmpty(element)) {
				int size = element.size();
				for (int index = 0; index < size; index++) {
					String beforeSplit = element.get(index).getText();
					if(StringUtils.isNotBlank(beforeSplit)) {
						String actualName = beforeSplit.substring(0, beforeSplit.indexOf(","));
						beforeSort.add(actualName);
						afterSort.add(actualName);
					}
				}
				// Sorting afterSort records and verifying with beforeSort
				if(CollectionUtils.isNotEmpty(beforeSort) && CollectionUtils.isNotEmpty(afterSort)) {
					Collections.sort(afterSort, String.CASE_INSENSITIVE_ORDER);
					if(beforeSort.equals(afterSort)) {
						flag = true;
					}
				}
			}
		}catch (Exception e) {
    		logger.info("Unable to verifyNameInAscendingOrder" );
			log(logger, "Unable to verifyNameInAscendingOrder" );
    		throw new DriverException("Unable to verifyNameInAscendingOrder" , e); 
    	}
		logger.info("Method: End flag --> " + flag);
		return flag;
	}
	
	
	/**
	 * Method used to verify name is in ascending order. 
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws Exception
	 */
	public boolean verifyNameInAscendingOrder(String locator) throws Exception {
		logger.info("Method : verifyNameInAscendingOrder Start");
		boolean flag = false;
		List<String> beforeSort = new ArrayList<String>();
		List<String> afterSort = new ArrayList<String>();
		try {
			List<WebElement> element = baseHandler.findElements(locator);
			if(CollectionUtils.isNotEmpty(element)) {
				int size = element.size();
				for (int index = 0; index < size; index++) {
					String beforeSplit = element.get(index).getText();
					if(StringUtils.isNotBlank(beforeSplit)) {
						String actualName = beforeSplit.substring(0, beforeSplit.indexOf(","));
						beforeSort.add(actualName);
						afterSort.add(actualName);
					}
				}
				// Sorting afterSort records and verifying with beforeSort
				if(CollectionUtils.isNotEmpty(beforeSort) && CollectionUtils.isNotEmpty(afterSort)) {
					Collections.sort(afterSort, String.CASE_INSENSITIVE_ORDER);
					if(beforeSort.equals(afterSort)) {
						flag = true;
					}
				}
			}
		}catch (Exception e) {
    		logger.info("Unable to verifyNameInAscendingOrder" );
			log(logger, "Unable to verifyNameInAscendingOrder" );
    		throw new DriverException("Unable to verifyNameInAscendingOrder" , e); 
    	}
		logger.info("Method: End flag --> " + flag);
		return flag;
	}
	
	public boolean selectingCohortNameInStudentRosterPage(String cohortInputName) throws Exception {
		logger.info("Method : selectingCohortNameInStudentRosterPage Start");
		boolean flag = false;
		try {
			List<WebElement> materialIcon = baseHandler.findElements(PropertiesRepository.getString("id.product.manage.roster.student.roster.table.material.icon.loc"));
			if(CollectionUtils.isNotEmpty(materialIcon)) {
				// Material Icon click				
				materialIcon.get(0).click();
				// Entering cohort value.
				//WebElement cohortElement = verifyElement("");
				List<WebElement> chorotElement =baseHandler.findElements("mat-input-container div[class='mat-input-infix mat-form-field-infix'] input");
				if (CollectionUtils.isNotEmpty(chorotElement)) {
					chorotElement.get(2).clear();
					chorotElement.get(2).sendKeys(cohortInputName);
					
					// Selecting value from DD
					WebElement cohortDDValue = verifyElement(
							PropertiesRepository.getString("id.people.reassign.popup.cohort.select.dd.loc"));
					if (cohortDDValue != null) {
						cohortDDValue.click();
						waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
						
						// Clicking on save button
						WebElement saveButton = verifyElement(
								PropertiesRepository.getString("id.product.manage.roster.student.roster.table.cohort.name.save.button.loc"));
						if (saveButton != null) {
							saveButton.click();
							waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
							flag = true;
						}
					} else {
						logger.info("Unable to select value from DD");
					}
				} else {
					logger.info("Unable to enter cohort ");
				}
			}
		}catch (Exception e) {
    		logger.info("Unable to selectingCohortNameInStudentRosterPage" );
			log(logger, "Unable to selectingCohortNameInStudentRosterPage" );
    		throw new DriverException("Unable to selectingCohortNameInStudentRosterPage" , e); 
    	}
		logger.info("Method: End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to verify Transfer History Row Details. 
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws Exception
	 */
	public boolean verifyTransferHistoryRowDetails() throws Exception {
		logger.info("Method : verifyTransferHistoryRowDetails Start");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("id.product.manage.roster.transfer.history.table.row.details.loc"));
			if(CollectionUtils.isNotEmpty(element) && element.size() > 0) {
				// Transfer Summary Coloumn details. 
				List<WebElement> summaryElement = element.get(0).findElements(By.cssSelector(PropertiesRepository.getString("id.product.manage.roster.transfer.history.table.transfer.summary.col.loc")));
					if(CollectionUtils.isNotEmpty(summaryElement)) {
						// Initiated column details.
						List<WebElement> initiatedElement = element.get(0).findElements(By.cssSelector(PropertiesRepository.getString("id.product.manage.roster.transfer.history.table.initiated.col.loc")));
						if(CollectionUtils.isNotEmpty(initiatedElement)) {
							// Status Column details. 
							List<WebElement> statusElement = element.get(0).findElements(By.cssSelector(PropertiesRepository.getString("id.product.manage.roster.transfer.history.table.status.col.loc")));
							if(CollectionUtils.isNotEmpty(statusElement)) {
								// View Column details. 
								List<WebElement> viewElement = element.get(0).findElements(By.cssSelector(PropertiesRepository.getString("id.product.manage.roster.transfer.history.table.view.col.loc")));
								if(CollectionUtils.isNotEmpty(viewElement)) {
									flag = true;
								} else {
									logger.info("Unable to load View Column details");
								}
							} else {
								logger.info("Unable to load Status Column details");
							}
						}else {
							logger.info("Unable to load Initiated Column details");
						}
					}else {
						logger.info("Unable to load Transfer Summary Column details");
					}
			}
		}catch (Exception e) {
    		logger.info("Unable to verifyTransferHistoryRowDetails" );
			log(logger, "Unable to verifyTransferHistoryRowDetails" );
    		throw new DriverException("Unable to verifyTransferHistoryRowDetails" , e); 
    	}
		logger.info("Method: verifyTransferHistoryRowDetails End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to enter base institution in Home Page. 
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws Exception
	 */
	public boolean enterBaseInsititionNameInHomePage(String institutionName) throws Exception {
		logger.info("Method : enterBaseInsititionNameInHomePage Start");
		boolean flag = false;
		try {
			// Entering institution name in text box
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("id.product.manage.roster.student.roster.table.cohort.text.box.loc"));
			if(CollectionUtils.isNotEmpty(element)) {
				element.get(0).click();
				element.get(0).clear();
				element.get(0).sendKeys(institutionName);
				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				// clicking on institution name displayed in drop down. 
				List<WebElement> ddElement = baseHandler.findElements(PropertiesRepository.getString("id.product.manage.roster.student.roster.enter.institution.dd.list.loc"));
				if(CollectionUtils.isNotEmpty(ddElement)) {
					for(WebElement ddValueElement : ddElement) {
						if(ddValueElement.getText().trim().equalsIgnoreCase(institutionName)) {
							ddValueElement.click();
							flag = true;
							waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
							break;
						}
					}
				}
			}
		}catch (Exception e) {
    		logger.info("Unable to enterBaseInsititionNameInHomePage" );
			log(logger, "Unable to enterBaseInsititionNameInHomePage" );
    		throw new DriverException("Unable to enterBaseInsititionNameInHomePage" , e); 
    	}
		logger.info("Method: enterBaseInsititionNameInHomePage End flag --> " + flag);
		return flag;
	}
	
	public boolean selectingInstitutionNameInStudentRosterPage(String cohortInputName) throws Exception {
		logger.info("Method : selectingInstitutionNameInStudentRosterPage Start");
		logger.info("cohortInputName value --> " + cohortInputName);
		boolean flag = false;
		try {
			List<WebElement> materialIcon = baseHandler.findElements(PropertiesRepository.getString("id.product.manage.roster.student.roster.table.material.icon.loc"));
			if(CollectionUtils.isNotEmpty(materialIcon)) {
				// Material Icon click				
				materialIcon.get(0).click();
				// Entering Institution value.
				List<WebElement> chorotElement = baseHandler.findElements(PropertiesRepository.getString("id.product.manage.roster.student.roster.enter.institution.text.box.loc"));
				if (CollectionUtils.isNotEmpty(chorotElement)) {
					chorotElement.get(0).clear();
					chorotElement.get(0).sendKeys(cohortInputName);
					waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
					// Selecting value from DD
					List<WebElement> cohortDDValue = baseHandler.findElements(PropertiesRepository.getString("id.product.manage.roster.student.roster.enter.institution.dd.list.loc"));
					if (cohortDDValue != null) {
						for(WebElement ddValueElement : cohortDDValue) {
							if(ddValueElement.getText().trim().equalsIgnoreCase(cohortInputName)) {
								ddValueElement.click();
								waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
								break;
							}
						}
						// Clicking on save button
						WebElement saveButton = verifyElement(
								PropertiesRepository.getString("id.product.manage.roster.student.roster.table.cohort.name.save.button.loc"));
						if (saveButton != null) {
							saveButton.click();
							waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
							flag = true;
						}
					} else {
						logger.info("Unable to select value from DD");
					}
				} else {
					logger.info("Unable to enter institution");
				}
			}
		}catch (Exception e) {
    		logger.info("Unable to selectingInstitutionNameInStudentRosterPage" );
			log(logger, "Unable to selectingInstitutionNameInStudentRosterPage" );
    		throw new DriverException("Unable to selectingInstitutionNameInStudentRosterPage" , e); 
    	}
		logger.info("Method: End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to enter cohort in student roster page for hide graduated functionality.
	 *  
	 * 
	 * @param Cohortname
	 * @return
	 * @throws DriverException
	 * @throws InterruptedException
	 */
	public boolean searchAndVerifyCohortForHidGradudated(String Cohortname) throws DriverException, InterruptedException {
		logger.info("Method : searchAndVerifyCohortForHidGradudated :::::::: START");
		boolean flag = false;
		try {
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			WebElement cohortDDValue1 = verifyElement("span.ati-heading:nth-child(3)");
			if (cohortDDValue1 != null) {
				cohortDDValue1.click();
				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				// Enter Cohort Name
				WebElement cohortNameTxtElement = driver.findElement(By.cssSelector(PropertiesRepository.getString("id.people.student.by.cohort.name.loc")));
				if (cohortNameTxtElement != null) {
					textHandler.writeText(PropertiesRepository.getString("id.people.student.by.cohort.name.text.box.loc"),
							Cohortname);
					cohortNameTxtElement.sendKeys(Keys.ENTER);
					waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
					
					// Clicking on Select DD 
					WebElement cohortDDValue = verifyElement(PropertiesRepository.getString("id.people.reassign.popup.cohort.select.dd.loc"));
					if (cohortDDValue == null) {
						flag = true;
					}
				}
			}
		} catch (Exception e) {

			logger.info("Unable to searchAndVerifyCohortForHidGradudated");
			throw new DriverException("Unable to searchAndVerifyCohortForHidGradudated", e);
		}
		logger.info("Method : searchAndVerifyCohortForHidGradudated :::::::: START flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to verify role value under role column in faculty roster tab
	 * under people's left navigation link.
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean verifyRoleInFacultyRosterTab(int rowNo, String roleName) throws Exception {
		logger.info("Method : verifyRoleInFacultyRosterTab Start");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(PropertiesRepository
					.getString("id.product.manage.roster.faculty.roster.table.header.role.name.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				List<WebElement> rowElement = element.get(rowNo).findElements(By.cssSelector(PropertiesRepository
						.getString("id.product.manage.roster.faculty.roster.table.header.role.name.span.loc")));
				if (CollectionUtils.isNotEmpty(rowElement)) {
					if (rowElement.get(2).getText().equalsIgnoreCase(roleName)) {
						flag = true;
					} else {
						logger.info("Unable to get role value from table");
					}
				} else {
					logger.info("Unable to get row element");
				}
			} else {
				logger.info("Unable to get value from locator");
			}
		} catch (Exception e) {
			logger.info("Unable to verifyRoleInFacultyRosterTab");
			log(logger, "Unable to verifyRoleInFacultyRosterTab");
			throw new DriverException("Unable to verifyRoleInFacultyRosterTab", e);
		}
		logger.info("Method: verifyRoleInFacultyRosterTab End flag --> " + flag);
		return flag;
	}
}
