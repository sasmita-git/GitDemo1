package com.automation.id.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.ButtonHandler;
import com.ascendlearning.automation.ui.handlers.TextHandler;

public class HomePage extends HomePage2 {

	private Logger logger = LogManager.getLogger(this.getClass());
	private TextHandler textHandler;
	private ButtonHandler buttonHandler;
	private int intRedBellAlertIndex;
	private LoginPage loginPage;

	public HomePage(WebDriver webDriver) {
		super(webDriver);
		textHandler = new TextHandler(driver);
		buttonHandler = new ButtonHandler(driver);
		loginPage = new LoginPage(driver);
	}

	/**
	 * Method used to verify selected institute and cohort.
	 * 
	 * @param selectedInstitute
	 * @param SelectedCohort
	 * @return
	 * @throws Exception
	 */
	public boolean verifySelectedInstituteNCohort(String selectedInstitute, String SelectedCohort) throws Exception {
		logger.info("verifySelectedInstituteNCohort Start");
		boolean flag = false;
		try {
			List<WebElement> relogininstitutionNCohort = baseHandler
					.findElements(PropertiesRepository.getString("id.home.instcohort.loc"));
			if (CollectionUtils.isNotEmpty(relogininstitutionNCohort)) {
				String reloginInstitution = relogininstitutionNCohort.get(0).getText().trim();
				String reloginCohort = relogininstitutionNCohort.get(1).getText().trim();
				if (reloginInstitution.contains(selectedInstitute) && reloginCohort.contains(SelectedCohort)) {
					flag = true;
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verifySelectedInstituteNCohort");
			throw new DriverException("Unable to verifySelectedInstituteNCohort");
		}
		logger.info("verifySelectedInstituteNCohort End");
		return flag;

	}

	/**
	 * Method used to select cohort in Home page.
	 * 
	 * @author saravanan.jothimani
	 * @param cohortName
	 * @return
	 * @throws DriverException
	 */
	public boolean selectCohort(String cohortName) throws DriverException {
		logger.info("Method: selectCohort Starts");
		boolean flag = false;
		try {

			// Verifying Left cohort icon
			WebElement element = verifyElement(PropertiesRepository.getString("id.home.cohort.icon"));
			if (element != null) {
				// Clicking on Left cohort icon
				element.click();

				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				// Enter Cohort Name
				WebElement cohortTextBox = verifyElement(PropertiesRepository.getString("id.home.cohort.name.loc"));
				textHandler.writeText(cohortTextBox, cohortName);
				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				WebElement cohortDDValue = verifyElement(".mat-option-ripple.mat-ripple");
				if (cohortDDValue != null) {
					waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
					cohortDDValue.click();
					waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				}
				// Clicking on Save button
				WebElement saveButton = verifyElement(PropertiesRepository.getString("id.home.cohort.save.button.loc"));
				buttonHandler.clickButton(saveButton);
				// Verify Cohort Text.
				List<WebElement> cohortTxt = verifyElementList(
						PropertiesRepository.getString("id.home.cohort.verify.loc"));
				if (CollectionUtils.isNotEmpty(cohortTxt)) {
					for (WebElement cohotTxtElement : cohortTxt) {
						if (cohotTxtElement.getText().trim().contains(cohortName)) {
							flag = true;
							break;
						}
					}
				}
			}
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		} catch (Exception e) {
			logger.info("Unable to selectCohort");
			log(logger, "Unable to selectCohort");
			throw new DriverException("Unable to selectCohort", e);
		}
		logger.info("Method: selectCohort End " + flag);
		return flag;
	}

	/**
	 * This method will verify whether links are present or not
	 * 
	 * @author Syed.Hoque
	 * @throws DriverException
	 */

	public boolean verifyLink(String loc, int index, String expectedlink) throws DriverException {
		logger.info("Method: verifyLink Starts");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("id.home.menu.item.list.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				String actuallink = element.get(index).getText().trim();
				if (actuallink.contains(expectedlink)) {
					flag = true;
				}
			}

		} catch (Exception e) {
			logger.info("Unable to verifyLink");
			log(logger, "Unable to verifyLink");
			throw new DriverException("Unable to verifyLink", e);
		}
		logger.info("Method: selectCohort End " + flag);
		return flag;
	}

	/**
	 * Method used to enter cohort (this method is specific to INST-1728
	 * ,INST-1729)
	 * 
	 * @author prasanna.gogineni
	 * @param cohortName
	 * @return
	 * @throws DriverException
	 */

	public boolean enterCohort(String cohortName) throws DriverException {
		logger.info("Method: enterCohort Starts");
		boolean flag = false;
		try {
			WebElement cohortTextBox = verifyElement(PropertiesRepository.getString("id.home.cohort.name.loc"));
			if (cohortTextBox != null) {
				textHandler.writeText(cohortTextBox, cohortName);
				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				WebElement cohortDDValue = verifyElement(".mat-option-ripple.mat-ripple");
				if (cohortDDValue != null) {
					cohortDDValue.click();
					waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
					WebElement saveButton = verifyElement(
							PropertiesRepository.getString("id.home.cohort.save.button.loc"));
					if (saveButton != null) {
						verifyAndClick(PropertiesRepository.getString("id.home.cohort.save.button.loc"), true);
						flag = true;
					}
				}
			}
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		} catch (Exception e) {
			logger.info("Unable to enterCohort	");
			log(logger, "Unable to enterCohort");
			throw new DriverException("Unable to enterCohort", e);
		}
		logger.info("Method: enterCohort End " + flag);
		return flag;
	}

	/**
	 * Method used to select cohort in Home page.
	 * 
	 * @author saravanan.jothimani
	 * @param cohortName
	 * @return
	 * @throws DriverException
	 */
	public boolean selectInstituteAndCohort(String instituteName, String cohortName) throws DriverException {
		logger.info("Method: selectInstituteAndCohort Starts");
		boolean flag = false;
		try {

			// Verifying Left cohort icon
			WebElement element = verifyElement(PropertiesRepository.getString("id.home.cohort.icon"));
			if (element != null) {
				// Clicking on Left cohort icon
				element.click();

				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				// Enter Institute Name
				List<WebElement> instituteAndChorotTextBox = verifyElementList(
						"md-input-container[class='mat-input-container ng-untouched ng-pristine ng-invalid'] input[class='ati-heading ng-untouched ng-pristine ng-invalid mat-input-element']");
				if (CollectionUtils.isNotEmpty(instituteAndChorotTextBox)) {
					textHandler.writeText(instituteAndChorotTextBox.get(0), instituteName);
					WebElement instDDValue = verifyElement(".mat-option-ripple.mat-ripple");
					if (instDDValue != null) {
						instDDValue.click();
						waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
					}
					// waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
					textHandler.writeText(instituteAndChorotTextBox.get(1), cohortName);
					WebElement cohortDDValue = verifyElement(".mat-option-ripple.mat-ripple");
					if (cohortDDValue != null) {
						cohortDDValue.click();
						waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
					}
					// waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				}
				/*
				 * 
				 * // Enter Institute Name
				 * 
				 * WebElement cohortDDValue =
				 * verifyElement(".mat-option-ripple.mat-ripple");
				 * if(cohortDDValue != null) { cohortDDValue.click();
				 * waitUntillLoadingImageIsDisappeared(PropertiesRepository.
				 * getString("id.common.page.loader"));
				 */
			}
			// Clicking on Save button
			WebElement saveButton = verifyElement(PropertiesRepository.getString("id.home.cohort.save.button.loc"));
			buttonHandler.clickButton(saveButton);
			// Verify Cohort Text.
			List<WebElement> cohortTxt = verifyElementList(PropertiesRepository.getString("id.home.cohort.verify.loc"));
			if (CollectionUtils.isNotEmpty(cohortTxt)) {
				for (WebElement cohotTxtElement : cohortTxt) {
					if (cohotTxtElement.getText().trim().contains(cohortName)) {
						flag = true;
						break;
					}
				}
			}
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		} catch (Exception e) {
			logger.info("Unable to selectInstituteAndCohort");
			log(logger, "Unable to selectInstituteAndCohort");
			throw new DriverException("Unable to selectInstituteAndCohort", e);
		}
		logger.info("Method: selectInstituteAndCohort End " + flag);
		return flag;
	}

	/**
	 * Method used to select cohort in Home page.
	 * 
	 * @author saravanan.jothimani
	 * @param cohortName
	 * @return
	 * @throws DriverException
	 */
	public boolean selectInstituteAndCohortForConsortium(String instituteName, String cohortName)
			throws DriverException {
		logger.info("Method: selectInstituteAndCohort Starts");
		boolean flag = false;
		try {

			// Verifying Left cohort icon
			WebElement element = verifyElement(
					".mat-sidenav-content md-toolbar-row[class='mat-toolbar-row'] .flex-item i");
			if (element != null) {
				// Clicking on Left cohort icon
				element.click();

				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				// Enter Institute Name
				List<WebElement> instituteAndChorotTextBox = verifyElementList(
						"md-input-container[class='mat-input-container ng-untouched ng-pristine ng-invalid'] input[class='ati-heading ng-untouched ng-pristine ng-invalid mat-input-element']");
				if (CollectionUtils.isNotEmpty(instituteAndChorotTextBox)) {
					textHandler.writeText(instituteAndChorotTextBox.get(0), instituteName);
					WebElement instDDValue = verifyElement(".mat-option-ripple.mat-ripple");
					if (instDDValue != null) {
						instDDValue.click();
						waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
					}
					// waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
					textHandler.writeText(instituteAndChorotTextBox.get(1), cohortName);
					WebElement cohortDDValue = verifyElement(".mat-option-ripple.mat-ripple");
					if (cohortDDValue != null) {
						cohortDDValue.click();
						waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
					}
					// waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				}
				/*
				 * 
				 * // Enter Institute Name
				 * 
				 * WebElement cohortDDValue =
				 * verifyElement(".mat-option-ripple.mat-ripple");
				 * if(cohortDDValue != null) { cohortDDValue.click();
				 * waitUntillLoadingImageIsDisappeared(PropertiesRepository.
				 * getString("id.common.page.loader"));
				 */
			}
			// Clicking on Save button
			WebElement saveButton = verifyElement(PropertiesRepository.getString("id.home.cohort.save.button.loc"));
			buttonHandler.clickButton(saveButton);
			// Verify Cohort Text.
			List<WebElement> cohortTxt = verifyElementList(PropertiesRepository.getString("id.home.cohort.verify.loc"));
			if (CollectionUtils.isNotEmpty(cohortTxt)) {
				for (WebElement cohotTxtElement : cohortTxt) {
					if (cohotTxtElement.getText().trim().contains(cohortName)) {
						flag = true;
						break;
					}
				}
			}
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		} catch (Exception e) {
			logger.info("Unable to selectInstituteAndCohort");
			log(logger, "Unable to selectInstituteAndCohort");
			throw new DriverException("Unable to selectInstituteAndCohort", e);
		}
		logger.info("Method: selectInstituteAndCohort End " + flag);
		return flag;
	}

	/**
	 * Method used to select cohort in Home page.
	 * 
	 * @author saravanan.jothimani
	 * @param cohortName
	 * @return
	 * @throws DriverException
	 */
	public boolean selectInstituteAndCohortNew(String instituteName, String cohortName) throws DriverException {
		logger.info("Method: selectInstituteAndCohort Starts");
		boolean flag = false;
		try {

			// Verifying Left cohort icon
			WebElement element = verifyElement(PropertiesRepository.getString("id.home.cohort.icon"));
			if (element != null) {
				// Clicking on Left cohort icon
				element.click();

				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				// Enter Institute Name
				List<WebElement> instituteAndChorotTextBox = verifyElementList(
						"md-input-container[class='mat-input-container ng-untouched ng-pristine ng-invalid'] input[class='ati-heading ng-untouched ng-pristine ng-invalid mat-input-element']");
				if (CollectionUtils.isNotEmpty(instituteAndChorotTextBox)) {
					textHandler.writeText(instituteAndChorotTextBox.get(0), instituteName);
					WebElement instDDValue = verifyElement(".mat-option-ripple.mat-ripple");
					if (instDDValue != null) {
						instDDValue.click();
						waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
					}
					// waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
					textHandler.writeText(instituteAndChorotTextBox.get(1), cohortName);
					WebElement cohortDDValue = verifyElement(".mat-option-ripple.mat-ripple");
					if (cohortDDValue != null) {
						cohortDDValue.click();
						waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
					}
					// waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				}
				/*
				 * 
				 * // Enter Institute Name
				 * 
				 * WebElement cohortDDValue =
				 * verifyElement(".mat-option-ripple.mat-ripple");
				 * if(cohortDDValue != null) { cohortDDValue.click();
				 * waitUntillLoadingImageIsDisappeared(PropertiesRepository.
				 * getString("id.common.page.loader"));
				 */
			}
			// Clicking on Save button
			WebElement saveButton = verifyElement(PropertiesRepository.getString("id.home.cohort.save.button.loc"));
			buttonHandler.clickButton(saveButton);
			// Verify Cohort Text.
			List<WebElement> cohortTxt = verifyElementList(PropertiesRepository.getString("id.home.cohort.verify.loc"));
			if (CollectionUtils.isNotEmpty(cohortTxt)) {
				for (WebElement cohotTxtElement : cohortTxt) {
					if (cohotTxtElement.getText().trim().contains(cohortName)) {
						flag = true;
						break;
					}
				}
			}
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		} catch (Exception e) {
			logger.info("Unable to selectInstituteAndCohort");
			log(logger, "Unable to selectInstituteAndCohort");
			throw new DriverException("Unable to selectInstituteAndCohort", e);
		}
		logger.info("Method: selectInstituteAndCohort End " + flag);
		return flag;
	}

	/**
	 * Method used to select cohort in Home page.
	 * 
	 * @author saravanan.jothimani
	 * @param cohortName
	 * @return
	 * @throws DriverException
	 */
	public boolean verifyInstitute() throws DriverException {
		logger.info("Method: verifyInstitute Starts");
		boolean flag = false;
		try {

			// Verifying Left cohort icon
			WebElement element = verifyElement(PropertiesRepository.getString("id.home.cohort.icon"));
			if (element == null) {
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to verifyInstitute");
			log(logger, "Unable to verifyInstitute");
			throw new DriverException("Unable to verifyInstitute", e);
		}
		logger.info("Method: verifyInstitute End " + flag);
		return flag;
	}

	public void verifyText(String textName) {
		try {
			List<WebElement> ele = baseHandler
					.findElements(PropertiesRepository.getString("id.help.resource.contents"));
			if (CollectionUtils.isNotEmpty(ele)) {
				System.out.println(ele.get(0).getText());
			}

		} catch (Exception e) {

		}
	}

	/**
	 * Method used to select cohort in Home page.
	 * 
	 * @author saravanan.jothimani
	 * @param cohortName
	 * @return
	 * @throws DriverException
	 */
	public boolean selectInstitute(String instituteName) throws DriverException {
		logger.info("Method: selectInstitute Starts");
		boolean flag = false;
		try {

			// Verifying Left cohort icon
			WebElement element = verifyElement(PropertiesRepository.getString("id.home.cohort.icon"));
			if (element != null) {
				// Clicking on Left cohort icon
				element.click();

				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				// Enter Institute Name
				List<WebElement> instituteAndChorotTextBox = verifyElementList(
						"md-input-container[class='mat-input-container ng-untouched ng-pristine ng-invalid'] input[class='ati-heading ng-untouched ng-pristine ng-invalid mat-input-element']");
				if (CollectionUtils.isNotEmpty(instituteAndChorotTextBox)) {
					textHandler.writeText(instituteAndChorotTextBox.get(0), instituteName);
					WebElement instDDValue = verifyElement(".mat-option-ripple.mat-ripple");
					if (instDDValue != null) {
						instDDValue.click();
						waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
					}
					/*
					 * //waitUntillLoadingImageIsDisappeared(
					 * PropertiesRepository.getString("id.common.page.loader"));
					 * textHandler.writeText(instituteAndChorotTextBox.get(1),
					 * cohortName); WebElement cohortDDValue =
					 * verifyElement(".mat-option-ripple.mat-ripple");
					 * if(cohortDDValue != null) { cohortDDValue.click();
					 * waitUntillLoadingImageIsDisappeared(PropertiesRepository.
					 * getString("id.common.page.loader")); }
					 * //waitUntillLoadingImageIsDisappeared(
					 * PropertiesRepository.getString("id.common.page.loader"));
					 */ }
				/*
				 * 
				 * // Enter Institute Name
				 * 
				 * WebElement cohortDDValue =
				 * verifyElement(".mat-option-ripple.mat-ripple");
				 * if(cohortDDValue != null) { cohortDDValue.click();
				 * waitUntillLoadingImageIsDisappeared(PropertiesRepository.
				 * getString("id.common.page.loader"));
				 */
			}
			// Clicking on Save button
			WebElement saveButton = verifyElement(PropertiesRepository.getString("id.home.cohort.save.button.loc"));
			buttonHandler.clickButton(saveButton);
			// Verify Cohort Text.
			/*
			 * List<WebElement> cohortTxt =
			 * verifyElementList(PropertiesRepository.getString(
			 * "id.home.cohort.verify.loc"));
			 * if(CollectionUtils.isNotEmpty(cohortTxt)) { for(WebElement
			 * cohotTxtElement : cohortTxt) {
			 * if(cohotTxtElement.getText().trim().contains(cohortName)) { flag
			 * = true; break; } } }
			 */
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		} catch (Exception e) {
			logger.info("Unable to selectInstitute");
			log(logger, "Unable to selectInstitute");
			throw new DriverException("Unable to selectInstitute", e);
		}
		logger.info("Method: selectInstitute End " + flag);
		return flag;
	}

	public List<String> getInstitutionList() throws Exception {
		logger.info("getInstitutionList Start");
		List<String> institutionList = new ArrayList<String>();
		try {
			String[] institutionStrArray = PropertiesRepository.getStringAsArray("id.home.institution.name.list");
			if (institutionStrArray != null) {
				for (String str : institutionStrArray) {
					institutionList.add(str);
				}
			}
		} catch (Exception e) {
			throw new DriverException("Unable to getInstitutionList", e);
		}
		logger.info("getInstitutionList End");
		return institutionList;
	}

	public boolean selectInstituteDDList(List<String> institutionName) throws DriverException {
		logger.info("Method: selectInstitute Starts");
		boolean flag = false;
		try {
			List<String> institutionNameUI = new ArrayList<String>();
			// Verifying Left cohort icon
			WebElement element = verifyElement(PropertiesRepository.getString("id.home.cohort.icon"));
			if (element != null) {
				// Clicking on Left cohort icon
				element.click();

				// Click on Institution text box.
				baseHandler.findElement(PropertiesRepository.getString("instituiton.drop.down")).click();

				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				// Enter Institute Name
				List<WebElement> instituteAndChorotTextBox = verifyElementList("#md-autocomplete-1 md-option");
				if (CollectionUtils.isNotEmpty(instituteAndChorotTextBox)) {
					for (WebElement ddElement : instituteAndChorotTextBox) {
						institutionNameUI.add(ddElement.getText());
					}
				}
				if (CollectionUtils.isNotEmpty(institutionNameUI)) {
					if (institutionNameUI.equals(institutionName)) {
						flag = true;
					}
				}
				/*
				 * 
				 * // Enter Institute Name
				 * 
				 * WebElement cohortDDValue =
				 * verifyElement(".mat-option-ripple.mat-ripple");
				 * if(cohortDDValue != null) { cohortDDValue.click();
				 * waitUntillLoadingImageIsDisappeared(PropertiesRepository.
				 * getString("id.common.page.loader"));
				 */
			}
			// Clicking on Save button
			/*
			 * WebElement saveButton =
			 * verifyElement(PropertiesRepository.getString(
			 * "id.home.cohort.save.button.loc"));
			 * buttonHandler.clickButton(saveButton);
			 */
			// Verify Cohort Text.
			/*
			 * List<WebElement> cohortTxt =
			 * verifyElementList(PropertiesRepository.getString(
			 * "id.home.cohort.verify.loc"));
			 * if(CollectionUtils.isNotEmpty(cohortTxt)) { for(WebElement
			 * cohotTxtElement : cohortTxt) {
			 * if(cohotTxtElement.getText().trim().contains(cohortName)) { flag
			 * = true; break; } } }
			 */
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		} catch (Exception e) {
			logger.info("Unable to selectInstitute");
			log(logger, "Unable to selectInstitute");
			throw new DriverException("Unable to selectInstitute", e);
		}
		logger.info("Method: selectInstitute End " + flag);
		return flag;
	}

	/**
	 * Method used to select cohort in Home page.
	 * 
	 * @author saravanan.jothimani
	 * @param cohortName
	 * @return
	 * @throws DriverException
	 */
	public boolean verifyInstituteName(String instituteName) throws DriverException {
		logger.info("Method: selectInstitute Starts");
		boolean flag = false;
		try {
			List<WebElement> instituteAndChorotTextBox = verifyElementList(
					PropertiesRepository.getString("id.home.institution.header.loc1"));
			if (CollectionUtils.isNotEmpty(instituteAndChorotTextBox)) {
				String institutionNewName = instituteAndChorotTextBox.get(0).getText();
				if (institutionNewName.contains(instituteName)) {
					flag = true;
				}
			}
		} catch (Exception e) {
			logger.info("Unable to selectInstitute");
			log(logger, "Unable to selectInstitute");
			throw new DriverException("Unable to selectInstitute", e);
		}
		logger.info("Method: selectInstitute End " + flag);
		return flag;
	}

	/**
	 * Method used to verify Product Card in Home Page
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws Exception
	 */
	public boolean verifyProductCard() throws DriverException {
		logger.info("Method: verifyProductCard Starts");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("id.home.three.product.main.loc"));
			if (CollectionUtils.isNotEmpty(element) && element.size() == 3) {
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to verifyProductCard");
			log(logger, "Unable to verifyProductCard");
			throw new DriverException("Unable to verifyProductCard", e);
		}
		logger.info("Method: verifyProductCard End flag --> " + flag);
		return flag;
	}

	/**
	 * @author Syed.Hoque Verify that product cards are blank this method will
	 *         verify cards which user did not took any proctor aseessemnt or
	 *         user might have taken 2 proctor assessment taken
	 * @throws DriverException
	 */

	public boolean VerifyBlankProductCard(int index) throws DriverException {
		logger.info("Method: VerifyBlankProductCard :::Starts");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("blank.crad.text"));
			if (CollectionUtils.isNotEmpty(element) && element.size() == index) {
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to VerifyBlankProductCard");
			log(logger, "Unable to VerifyBlankProductCard");
			throw new DriverException("Unable to VerifyBlankProductCard", e);
		}
		logger.info("Method: VerifyBlankProductCard :::Ends");
		return flag;
	}

	public boolean verifyExamdate() throws DriverException {
		logger.info("Method: verifyProductDetails Starts");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("id.home.product.exam.date.loc"));
			if (CollectionUtils.isNotEmpty(element) && element.size() == 3) {
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to verifyExamdate");
			log(logger, "Unable to verifyExamdate");
			throw new DriverException("Unable to verifyExamdate", e);
		}
		logger.info("Method: verifyExamdate End flag --> " + flag);
		return flag;
	}

	public boolean verifyPdfBtn() throws DriverException {
		logger.info("Method: verifyProductDetails Starts");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("id.home.product.pdf.button.loc"));
			if (CollectionUtils.isNotEmpty(element) && element.size() == 3) {
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to verifyPdfBtn");
			log(logger, "Unable to verifyPdfBtn");
			throw new DriverException("Unable to verifyPdfBtn", e);
		}
		logger.info("Method: verifyPdfBtn End flag --> " + flag);
		return flag;
	}

	public boolean verifyProductDetail() throws DriverException {
		logger.info("Method: verifyProductDetails Starts");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("id.home.product.card.name.loc"));
			if (CollectionUtils.isNotEmpty(element) && element.size() == 3) {
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to verifyProductDetails");
			log(logger, "Unable to verifyProductDetails");
			throw new DriverException("Unable to verifyProductDetails", e);
		}
		logger.info("Method: verifyProductDetails End flag --> " + flag);
		return flag;
	}

	/**
	 * Method used to verify Product Card Name.
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws Exception
	 */
	public boolean verifyProductDetails(String locator) throws DriverException {
		logger.info("Method: verifyProductDetails Starts");
		boolean flag = false;
		try {
			/*
			 * List<WebElement> element = baseHandler
			 * .findElements(PropertiesRepository.getString(
			 * "id.home.three.product.main.loc"));
			 */
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString(locator));
			if (CollectionUtils.isNotEmpty(element) && element.size() == 3) {
				for (WebElement groupElement : element) {
					WebElement groupElementValue = groupElement.findElement(By.cssSelector(locator));
					if (groupElementValue != null) {
						flag = true;
						if (!flag) {
							flag = false;
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verifyProductDetails");
			log(logger, "Unable to verifyProductDetails");
			throw new DriverException("Unable to verifyProductDetails", e);
		}
		logger.info("Method: verifyProductDetails End flag --> " + flag);
		return flag;
	}

	/**
	 * Method used to verify Product Card Name.
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws Exception
	 */
	public boolean clickPDFIcon(int index) throws DriverException {
		logger.info("Method: verifyProductDetails Starts");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("id.home.three.product.main.loc"));
			if (CollectionUtils.isNotEmpty(element) && element.size() > 0) {
				WebElement groupElementValue = element.get(index)
						.findElement(By.cssSelector(PropertiesRepository.getString("id.home.product.pdf.button.loc")));
				if (groupElementValue != null) {
					flag = true;
					groupElementValue.click();
					waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verifyProductDetails");
			log(logger, "Unable to verifyProductDetails");
			throw new DriverException("Unable to verifyProductDetails", e);
		}
		logger.info("Method: verifyProductDetails End flag --> " + flag);
		return flag;
	}

	public boolean verifyPDFPage() throws DriverException {
		logger.info("Method: verifyPDFPage Starts");
		boolean flag = false;
		try {
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			swithToPDFFrame();
			List<WebElement> element = baseHandler.findElements(".textLayer>div");
			if (CollectionUtils.isNotEmpty(element)) {
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to verifyPDFPage");
			log(logger, "Unable to verifyPDFPage");
			throw new DriverException("Unable to verifyPDFPage", e);
		}
		logger.info("Method: verifyPDFPage End flag --> " + flag);
		return flag;
	}

	/**
	 * Method used to verify Product Card in Adjusted Group Score or Group
	 * Score.
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws Exception
	 */
	public boolean verifyProductGroupSocre() throws DriverException {
		logger.info("Method: verifyProductGroupSocre Starts");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("id.home.three.product.main.loc"));
			if (CollectionUtils.isNotEmpty(element) && element.size() == 3) {
				for (WebElement groupElement : element) {
					WebElement groupElementValue = groupElement.findElement(
							By.cssSelector(PropertiesRepository.getString("id.home.product.group.score.value.loc")));
					if (groupElementValue != null && groupElementValue.getText().trim()
							.contains(PropertiesRepository.getString("id.home.product.card.group.score.value"))) {
						flag = true;
						if (!flag) {
							flag = false;
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verifyProductGroupSocre");
			log(logger, "Unable to verifyProductGroupSocre");
			throw new DriverException("Unable to verifyProductGroupSocre", e);
		}
		logger.info("Method: verifyProductGroupSocre End flag --> " + flag);
		return flag;
	}

	/**
	 * Method used to verify Product Card in Adjusted Group Score or Group
	 * Score.
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws Exception
	 */
	public boolean verifyProductStudentBelowLevel() throws DriverException {
		logger.info("Method: verifyProductStudentBelowLevel Starts");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("id.home.three.product.main.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				for (WebElement groupElement : element) {
					List<WebElement> groupElementValue = groupElement.findElements(
							By.cssSelector(PropertiesRepository.getString("id.home.product.student.level.loc")));
					if (CollectionUtils.isNotEmpty(groupElementValue) && groupElementValue.get(0).getText().trim()
							.contains(PropertiesRepository.getString("id.home.product.card.student.level.value"))) {
						flag = true;
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verifyProductStudentBelowLevel");
			log(logger, "Unable to verifyProductStudentBelowLevel");
			throw new DriverException("Unable to verifyProductStudentBelowLevel", e);
		}
		logger.info("Method: verifyProductStudentBelowLevel End flag --> " + flag);
		return flag;
	}

	/**
	 * Method used to click on Alert which has Red Bell.
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws DriverException
	 */
	public boolean clickAlerts() throws DriverException {
		logger.info("Method: clickAlerts Starts");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("id.home.alert.list.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				int size = element.size();
				for (int index = 0; index < size; index++) {
					intRedBellAlertIndex = index;
					List<WebElement> alertElement = element.get(index)
							.findElements(By.cssSelector(PropertiesRepository.getString("id.home.red.bell.loc")));
					if (CollectionUtils.isNotEmpty(alertElement)) {
						alertElement.get(0).click();
						waitForAwhile(4000);
						break;
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to clickAlerts");
			log(logger, "Unable to clickAlerts");
			throw new DriverException("Unable to clickAlerts", e);
		}
		logger.info("Method: clickAlerts End flag --> " + flag);
		return flag;
	}

	/**
	 * Method used to click on Alert which has Red Bell.
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws DriverException
	 */
	public boolean verifyAlerts() throws DriverException {
		logger.info("Method: verifyAlerts Starts");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("id.home.alert.list.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				List<WebElement> nonRedAlertElement = element.get(intRedBellAlertIndex).findElements(By.cssSelector(
						PropertiesRepository.getString("id.home.alert.individual.alert.bell.after.reading.alert.loc")));
				if (CollectionUtils.isNotEmpty(nonRedAlertElement)) {
					flag = true;
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verifyAlerts");
			log(logger, "Unable to verifyAlerts");
			throw new DriverException("Unable to verifyAlerts", e);
		}
		logger.info("Method: verifyAlerts End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to verify Cohort name.
	 * 
	 * @param locator
	 * @return
	 * @throws DriverException
	 */
	public boolean verifyCohortName(String locator) throws DriverException {
		logger.info("Method: verifyCohortName Starts");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(element)) {
				String[] splitValue = element.get(1).getText().split(":");
				if (splitValue != null && splitValue.length == 1) {
					if (splitValue[0].trim().equalsIgnoreCase("Select Cohort")) {
						selectCohort(PropertiesRepository.getString("id.1631.cohort.name"));
					}
				} else if (splitValue.length == 2) {
					if (splitValue[1].trim().length() > 0) {
						flag = true;
					} else {
						selectCohort(PropertiesRepository.getString("id.1631.cohort.name"));
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verifyCohortName");
			log(logger, "Unable to verifyCohortName");
			throw new DriverException("Unable to verifyCohortName", e);
		}
		logger.info("Method: verifyCohortName End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to verify footer of home page for all left navigation links. 
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws Exception
	 */
	public boolean verifyHomePageFooterMessagae() throws Exception {
		logger.info("Method : verifyHomePageFooterMessagae Start");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("id.footer.copyrights.loc"));
			if(CollectionUtils.isNotEmpty(element)) {
				StringBuilder sb = new StringBuilder(PropertiesRepository.getString("id.home.footer.message.value1"));
				sb.append(", ").append(PropertiesRepository.getString("id.home.footer.message.value2"));
				if(element.get(0).getText().trim().equalsIgnoreCase(sb.toString())) {
					flag = true;
				}
			}
		}catch (Exception e) {
    		logger.info("Unable to verifyHomePageFooterMessagae" );
			log(logger, "Unable to verifyHomePageFooterMessagae" );
    		throw new DriverException("Unable to verifyHomePageFooterMessagae" , e); 
    	}
		logger.info("Method: verifyHomePageFooterMessagae End flag --> " + flag);
		return flag;
	}
}
