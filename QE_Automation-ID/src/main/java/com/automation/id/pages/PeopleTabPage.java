package com.automation.id.pages;

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

public class PeopleTabPage extends PeopleTabPage1 {
	private ButtonHandler buttonHandler;
	private Logger logger = LogManager.getLogger(this.getClass());
	public PeopleTabPage(WebDriver webDriver) {
		super(webDriver);
		textHandler = new TextHandler(driver);
		buttonHandler = new ButtonHandler(driver);
	}

	/**
	 * Method used to verify Course Cohort Section in Individual Overview Section.
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws Exception
	 */
	public boolean verifyCourseCohortValueInIndividualOverviewSection(String cohortName) throws Exception {
		logger.info("Method : verifyCourseCohortValueInIndividualOverviewSection Start");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString(
					"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.value.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				for (WebElement cohortElement : element) {
					if (cohortElement != null && cohortElement.getText().trim().equalsIgnoreCase(cohortName)) {
						flag = true;
						break;
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verifyCourseCohortValueInIndividualOverviewSection");
			log(logger, "Unable to verifyCourseCohortValueInIndividualOverviewSection");
			throw new DriverException("Unable to verifyCourseCohortValueInIndividualOverviewSection", e);
		}
		logger.info("Method: verifyCourseCohortValueInIndividualOverviewSection End flag --> " + flag);
		return flag;
	}
	
	
	/**
	 * Used to verify message
	 * 
	 * @author prasanna.gogineni
	 * @param locator
	 * @throws Exception
	 */
	public boolean verifyIndividualOverviewCourseCohortHeaderSection(String locator, int index, String value) throws DriverException {
		logger.info("verifyIndividualOverviewCourseCohortHeaderSection Start ");
		logger.info("Locator value --> " + locator);
		logger.info("index value --> " + index);
		logger.info("value --> " + value);
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString(locator));
			if (CollectionUtils.isNotEmpty(element) && element.size() > 1) {
				if (value.equalsIgnoreCase(element.get(index).getText().trim())) {
					flag = true;
				}
			} else {
				logger.info("Unable to find elements for message verification");
			}
		} catch (Exception e) {
			logger.info("Unable to verifyIndividualOverviewCourseCohortHeaderSection");
			log(logger, "Unable to verifyIndividualOverviewCourseCohortHeaderSection");
			throw new DriverException("Unable to verifyIndividualOverviewCourseCohortHeaderSection", e);
		}
		logger.info("verifyIndividualOverviewCourseCohortHeaderSection End flag -->" + flag);
		return flag;
	}
	
	/**
	 * Method used to verify the count of records displayed under course cohort in Individual Overview section. 
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws Exception
	 */
	public boolean verifyCourseCohortList() throws Exception {
		logger.info("Method : verifyCourseCohortListStart");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString(
					"id.product.manage.roster.student.name.indidivual.overview.course.cohort.section.list.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				List<WebElement> courseCohortListElement = element.get(1)
						.findElements(By.cssSelector("div[class='heading-large']"));
				if (CollectionUtils.isNotEmpty(courseCohortListElement) && courseCohortListElement.size() == 4) {
					flag = true;
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verifyCourseCohortList");
			log(logger, "Unable to verifyCourseCohortList");
			throw new DriverException("Unable to verifyCourseCohortList", e);
		}
		logger.info("Method: verifyCourseCohortList End flag --> " + flag);
		return flag;
	}
	
	public boolean resettingStudentTransfer(String cohortInputName) throws DriverException {
		logger.info(" enterClassToReassignWithContent Start");
		boolean flag = false;
		try {
			// Verifying Reassign Cohort Popup.
			WebElement popupHeaderElement = verifyElement(PropertiesRepository.getString("id.people.reset.reassign.popup.title.loc"));
			if (popupHeaderElement != null && PropertiesRepository.getString("id.people.reassign.popup.title.value")
					.equalsIgnoreCase(popupHeaderElement.getText())) {
				// Entering cohort value.
				WebElement cohortElement = verifyElement(
						PropertiesRepository.getString("id.people.reassign.reset.popup.cohort.text.box.loc"));
				if (cohortElement != null) {
					cohortElement.clear();
					cohortElement.sendKeys(cohortInputName);
				} else {
					logger.info("Unable to enter cohort in Reassign cohort popup");
				}
				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

				WebElement cohortDDValue = verifyElement(
						PropertiesRepository.getString("id.people.reassign.popup.cohort.select.dd.loc"));
				if (cohortDDValue != null) {
					cohortDDValue.click();
					// waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				}

				// Clicking on Confirm button.
				buttonHandler
						.clickButton(PropertiesRepository.getString("id.people.reassign.reset.popup.confirm.button.loc"));

				// Getting second popup value.
				WebElement secondPopupElement = verifyElement(
						PropertiesRepository.getString("id.people.are.you.sure.title.loc"));
				if (secondPopupElement != null && PropertiesRepository.getString("id.people.are.you.sure.title.value")
						.equalsIgnoreCase(secondPopupElement.getText())) {
					// Getting Are you sure? first content and verify.
					boolean boolAreYouSureFirstContent = verifyMessage("id.people.are.you.sure.popup.first.content.loc",
							0, PropertiesRepository.getString("id.people.are.you.sure.popup.first.content.value"));

					// Getting Are you sure? Cohort Name.
					boolean cohortName = verifyMessage("id.people.are.you.sure.popup.selected.cohort.name.loc", 0,
							cohortInputName);

					// Getting Remember message value.
					boolean rememberContent = verifyMessage("id.people.are.you.sure.popup.remember.content.loc", 0,
							PropertiesRepository.getString("id.people.are.you.sure.popup.remember.content.value"));

					// Verifying Are you Sure content.
					if (boolAreYouSureFirstContent && cohortName && rememberContent) {

						// Clicking on Are you Sure Confirm button.
						buttonHandler.clickButton(
								PropertiesRepository.getString("id.people.are.you.sure.confirm.button.loc"));

						// Clicking on Continue button in In Progress Popup.
						WebElement inProgressPopup = verifyElement(
								PropertiesRepository.getString("id.people.in.progress.popup.title.loc"));
						if (inProgressPopup != null
								&& PropertiesRepository.getString("id.people.in.progress.popup.title.value")
										.equalsIgnoreCase(inProgressPopup.getText())) {

							// In Progress popup first content.
							boolean boolFirstContent = verifyMessage(
									"id.people.are.you.sure.popup.first.content.loc", 0,
									PropertiesRepository.getString("id.people.in.progress.first.content.value"));

							// In Progress Getting Cohort name.
							boolean inProgressCohortName = verifyMessage(
									"id.people.are.you.sure.popup.selected.cohort.name.loc",
									0, cohortInputName);

							// In Progress Second content.
							boolean boolSecondContent = verifyTextContains(
									PropertiesRepository.getString("id.people.are.you.sure.popup.first.content.loc"),
									PropertiesRepository.getString("id.people.in.progress.second.content.value"), 1);

							// In Progresss Third content.
							boolean boolThirdContent = verifyTextContains(
									PropertiesRepository.getString("id.people.are.you.sure.popup.first.content.loc"),
									PropertiesRepository.getString("id.people.in.progress.third.content.value"), 2);

							// Verifying In Progress Content.
							if (boolFirstContent && inProgressCohortName && boolSecondContent && boolThirdContent) {
								buttonHandler.clickButton(PropertiesRepository
										.getString("id.people.in.progress.popup.continue.button.loc"));
								flag = true;
							} else {
								logger.info("Unable to verify content in In Progress Popup");
							}
						} else {
							logger.info("Unable to click  Continue button in In Progress Popup");
						}
					} else {
						logger.info("Unable to verify Are you sure? popup content. ");

					}

				} else {
					logger.info("Unable to click Confirm button in Are you sure popup");
				}
			} else {
				logger.info("Popup header is not displayed");
			}
			
		} catch (Exception e) {
			logger.info("Unable assign to enterClassToReassignWithContent");
			throw new DriverException("Unable assign to enterClassToReassignWithContent", e);
		}
		logger.info("enterClassToReassignWithContent End flag --> " + flag);
		return flag;
	}
}
