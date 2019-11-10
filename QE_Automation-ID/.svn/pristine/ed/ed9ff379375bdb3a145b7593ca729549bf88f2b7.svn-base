package com.automation.id.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.TextHandler;

public class HomePage3 extends HomePage4 {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;

	public HomePage3(WebDriver webDriver) {
		super(webDriver);
		textHandler = new TextHandler(driver);
		loginPage = new LoginPage(driver);
	}

	/**
	 * Method used to verify left navigation name and click if required.O
	 * 
	 * @author saravanan.jothimani
	 * @param leftNavName
	 * @param click
	 * @return
	 * @throws DriverException
	 */
	public boolean verifyLeftNavigationText(String locator, int index, String leftNavName, boolean click) throws DriverException {
		logger.info("Method: verifyLeftNavigationText Starts");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString(locator));
			if (CollectionUtils.isNotEmpty(element)) {
				WebElement navElement = element.get(index);
				if (navElement != null && navElement.getText().trim().contains(leftNavName)) {
					flag = true;
					if (click) {
						navElement.click();
						waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verifyLeftNavigationText");
			log(logger, "Unable to verifyLeftNavigationText");
			throw new DriverException("Unable to verifyLeftNavigationText", e);
		}
		logger.info("Method: verifyLeftNavigationText End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to verify left navigation name and click if required.O
	 * 
	 * @author saravanan.jothimani
	 * @param leftNavName
	 * @param click
	 * @return
	 * @throws DriverException
	 */
	public boolean verifyLeftNavigationText(String locator, String leftNavName, boolean click) throws DriverException {
		logger.info("Method: verifyLeftNavigationText Starts");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString(locator));
			if (CollectionUtils.isNotEmpty(element)) {
				int size = element.size();
				for(int index = 0; index < size; index++) {
					WebElement navElement = element.get(index);
					if (navElement != null && navElement.getText().trim().contains(leftNavName)) {
						flag = true;
						if (click) {
							navElement.click();
							waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verifyLeftNavigationText");
			log(logger, "Unable to verifyLeftNavigationText");
			throw new DriverException("Unable to verifyLeftNavigationText", e);
		}
		logger.info("Method: verifyLeftNavigationText End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to verify left navigation name and click if required.
	 * 
	 * @author saravanan.jothimani
	 * @param leftNavName
	 * @param click
	 * @return
	 * @throws DriverException
	 */
	public boolean verifyLeftNavigationText(int index, String leftNavName, boolean click) throws DriverException {
		logger.info("Method: verifyLeftNavigationText Starts");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("id.home.page.proctor.left.navigator.icon.link"));
			if (CollectionUtils.isNotEmpty(element)) {
				WebElement navElement = element.get(index);
				if (navElement != null && navElement.getText().trim().equalsIgnoreCase(leftNavName)) {
					flag = true;
					if (click) {
						navElement.click();
						waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verifyLeftNavigationText");
			log(logger, "Unable to verifyLeftNavigationText");
			throw new DriverException("Unable to verifyLeftNavigationText", e);
		}
		logger.info("Method: verifyLeftNavigationText End flag --> " + flag);
		return flag;
	}

	/**
	 * Method used to click right side when Edit Profile is clicked from left
	 * nav. This is used to enable right side locators.
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws DriverException
	 */
	public boolean clickProfileRightNav() throws DriverException {
		logger.info("Method: clickProfileRightNav Starts");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(".mat-sidenav-backdrop.mat-sidenav-shown");
			if (CollectionUtils.isNotEmpty(element)) {
				element.get(0).click();
			}
		} catch (Exception e) {
			logger.info("Unable to clickProfileRightNav");
			log(logger, "Unable to clickProfileRightNav");
			throw new DriverException("Unable to clickProfileRightNav", e);
		}
		logger.info("Method: clickProfileRightNav End flag --> " + flag);
		return flag;
	}

	/**
	 * @author Sanapati.Srinu
	 * @throws DriverException
	 * 
	 */
	public void selectPracticeAssessmentTab() throws DriverException {

		logger.info("Method: selectPracticeAssessmentTab Starts");
		try {
			switchToCardShadowFrame();
			List<WebElement> element = baseHandler
					.findElements("#ctl00_contentPlaceHolderBody_ucTabbedSubMenuManageProducts_PracticeSubNav");
			if (CollectionUtils.isNotEmpty(element)) {
				element.get(0).click();
				windowHandler.switchToLatestWindow();
				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				switchToCardShadowFrame();
				waitForAwhile(1000);
			}
		} catch (Exception e) {
			logger.info("Unable to clickProfileRightNav");
			log(logger, "Unable to clickProfileRightNav");
			throw new DriverException("Unable to clickProfileRightNav", e);
		}
		logger.info("Method: selectPracticeAssessmentTab End");
	}

	/**
	 * @author Sanapati.Srinu
	 * @throws DriverException
	 * 
	 */
	public boolean selectTutorialTab() throws DriverException {
		logger.info("Method: selectPracticeAssessmentTab Starts");
		boolean flag = false;
		try {
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			loginPage.switchToCardShadowFrame();
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("id.tutorial.tab.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				element.get(0).click();
				windowHandler.switchToLatestWindow();
				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				flag = true;
			}
			windowHandler.switchToLatestWindow();
			waitForAwhile(1000);
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to clickProfileRightNav");
			log(logger, "Unable to clickProfileRightNav");
			throw new DriverException("Unable to clickProfileRightNav", e);
		}
		logger.info("Method: selectPracticeAssessmentTab End flag --> " + flag);
		return flag;
	}

	/**
	 * Method used to verify left navigation name and click if required.
	 * 
	 * @author saravanan.jothimani
	 * @param leftNavName
	 * @param click
	 * @return
	 * @throws DriverException
	 */
	public boolean verifyLeftNavigationText(String leftNavName, boolean click) throws DriverException {
		logger.info("Method: verifyLeftNavigationText Starts");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("id.home.page.proctor.left.navigator.icon.link"));
			if (CollectionUtils.isNotEmpty(element)) {
				int size = element.size();
				for (int index = 0; index < size; index++) {
					WebElement navElement = element.get(index);
					if (navElement != null && navElement.getText().trim().equalsIgnoreCase(leftNavName)) {
						flag = true;
						if (click) {
							navElement.click();
						}
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verifyLeftNavigationText");
			log(logger, "Unable to verifyLeftNavigationText");
			throw new DriverException("Unable to verifyLeftNavigationText", e);
		}
		logger.info("Method: verifyLeftNavigationText End flag --> " + flag);
		return flag;
	}

	/*
	 * To click on help tab
	 */
	public void clikOnLeftNavLink(int index) throws DriverException {
		logger.info("Method: clikOnLeftNavLink Starts");
		try {
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("id.home.page.proctor.left.navigator.icon.link.new.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				// int size = element.size();
				element.get(index).click();
				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				Thread.sleep(10000);
			}
		} catch (Exception e) {
			logger.info("Unable to clikOnLeftNavLink");
			log(logger, "Unable to clikOnLeftNavLink");
			throw new DriverException("Unable to clikOnLeftNavLink", e);
		}
		logger.info("Method: clikOnLeftNavLink Ends");
	}

	/**
	 * Click On Based on text
	 * 
	 * @throws DriverException
	 */

	public void clickOnText(String actualText) throws DriverException {
		logger.info("Method: clickOnText Start");
		try {

			List<WebElement> ele = baseHandler.findElements(PropertiesRepository.getString("home.link.loc1"));
			if (CollectionUtils.isNotEmpty(ele) & ele.size() > 0) {
				for (int i = 0; i < ele.size(); i++) {
					String text1 = ele.get(i).getText();
					System.out.println(text1);
					WebElement indexOfEle = ele.get(i);
					String[] menu = indexOfEle.getText().split("\\n");
					if (menu[1].equalsIgnoreCase(actualText)) {
						indexOfEle.click();
					}

				}
			}

		} catch (Exception e) {
			logger.info("Unable to clickOnText");
			log(logger, "Unable to clickOnText");
			throw new DriverException("Unable to clickOnText", e);
		}
		logger.info("Method: clickOnText Ends");
	}

	/**
	 * Method used to verify Institution name.
	 * 
	 * @param locator
	 * @return
	 * @throws DriverException
	 */
	public boolean verifyInstitutionName(String locator) throws DriverException {
		logger.info("Method: verifyInstitutionName Starts");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(element)) {
				String[] splitValue = element.get(0).getText().split(":");
				if (splitValue != null && splitValue.length > 0) {
					if (splitValue[0].trim().equalsIgnoreCase("Institution")) {
						if (splitValue[1].trim().length() > 0) {
							flag = true;
						}
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verifyInstitutionName");
			log(logger, "Unable to verifyInstitutionName");
			throw new DriverException("Unable to verifyInstitutionName", e);
		}
		logger.info("Method: verifyInstitutionName End flag --> " + flag);
		return flag;
	}

	

	/**
	 * This method will verify ATI contact Us widget
	 * 
	 * @author Syed.Hoque
	 * @throws DriverException
	 */
	public boolean contactUsSectionForProctor() throws DriverException {
		boolean flag = true;
		try {
			List<WebElement> element = baseHandler.findElements("ati.contact.headings");
			if (CollectionUtils.isNotEmpty(element) && element.size() == 2) {
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to verify contactUsSectionForProctor");
			log(logger, "Unable to verify contactUsSectionForProctor");
			throw new DriverException("Unable to verify contactUsSectionForProctor", e);
		}
		logger.info("Method: contactUsSectionForProctor End");
		return flag;
	}

	/**
	 * This method will verify instructions of proctor contact us contact of the
	 * drop down
	 * 
	 * @author Syed.Hoque
	 * @throws DriverException
	 */

	public void verifyATIContactUsInstructions() throws DriverException {
		logger.info("Method: verifyAtiContactUsInstructions Start");
		try {
			// to get the element under a list
			List<WebElement> elemnet = baseHandler.findElements(PropertiesRepository.getString("ati.contact.parent"));

			// to click on other region drop down
			if (CollectionUtils.isNotEmpty(elemnet)) {
				elemnet.get(0).click();
				Thread.sleep(2000);
				elemnet.get(2).click();
				Thread.sleep(2000);
			}

			// to verify that mails and phone are present or not
			List<WebElement> dropdownelements = baseHandler
					.findElements(PropertiesRepository.getString("email.phno.element"));
			if (CollectionUtils.isNotEmpty(dropdownelements)) {
				VerificationHandler.verifyEquals(dropdownelements.get(0).getText(), "sendclientmanager@atitesting.com");
				VerificationHandler.verifyEquals(dropdownelements.get(1).getText(), "contact_phone913-721-5695");
				VerificationHandler.verifyEquals(dropdownelements.get(2).getText(), "sendEmail Support");
				VerificationHandler.verifyEquals(dropdownelements.get(3).getText(), "contact_phone1(800) 667-7531");
			}

		} catch (Exception e) {
			logger.info("Unable to verify verifyAtiContactUsInstructions");
			log(logger, "Unable to verify verifyAtiContactUsInstructions");
			throw new DriverException("Unable to verifyAtiContactUsInstructions", e);
		}
		logger.info("Method: verifyAtiContactUsInstructions End");
	}

	/**
	 * This method will click on the three dots at top right corner which will
	 * display ATI contact /online store link etc
	 * 
	 * @author Syed.Hoque
	 * @throws DriverException
	 */

	public boolean clikOnDotsAtTopRightCorner(int index) throws DriverException {
		logger.info("Method: clikOnDotsAtTopRightCorner Start");
		boolean flag = false;
		try {
			// to click on 3 dots at top right corner
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("id.home.dots.at.top.right"));
			if (CollectionUtils.isNotEmpty(element)) {
				element.get(index).click();
				flag = true;
			}
			//Thread.sleep(2000);
		} catch (Exception e) {
			logger.info("Unable to click clikOnDotsAtTopRightCorner");
			log(logger, "Unable to click clikOnDotsAtTopRightCorner");
			throw new DriverException("Unable to click clikOnDotsAtTopRightCorner", e);
		}
		logger.info("Method: clikOnDotsAtTopRightCorner End flag --> " + flag);
		return flag;
	}

	/**
	 * This method will click on any one of ATI Contact,Online store,Product
	 * solution ,sign out
	 * 
	 * @author Syed.Hoque
	 * @throws DriverException
	 */
	public boolean clickOnTopRightCornerElement(int index) throws DriverException {
		logger.info("Method: clickOnTopRightCornerElement Start");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("id.home.toprightcorner.new.element"));
			if (CollectionUtils.isNotEmpty(element)) {
				element.get(index).click();
				flag = true;
				Thread.sleep(4000);
			} else {
				logger.info("Top Right Navigation list is not available");
			}

		} catch (Exception e) {
			logger.info("Unable to select top rightcorner element");
			log(logger, "Unable to select top rightcorner element");
			throw new DriverException("Unable to select top rightcorner element", e);
		}
		logger.info("Method: clickOnTopRightCornerElement End flag --> " + flag);
		return flag;
	}

	/**
	 * This method will verify that online store Home
	 * 
	 * @author Syed.Hoque
	 * @throws DriverException
	 */
	public boolean VerifyOnLineStoreHome(String expected) throws DriverException {
		logger.info("Method: VerifyOnLineStoreHome Start");
		boolean flag = false;
		try {
			List<WebElement> actual = baseHandler
					.findElements(PropertiesRepository.getString("id.online.store.home.page.not.an.educator.visit.the.student.site.link.loc"));
			if (CollectionUtils.isNotEmpty(actual)) {
				String actualElement = actual.get(0).getText();
				if (StringUtils.isNotBlank(actualElement) && actualElement.equalsIgnoreCase(expected)) {
					flag = true;
				}
			}

		} catch (Exception e) {
			logger.info("Unable to VerifyOnLineStoreHome");
			log(logger, "Unable to VerifyOnLineStoreHome");
			throw new DriverException("Unable to VerifyOnLineStoreHome", e);
		}
		logger.info("Method: VerifyOnLineStoreHome End flag --> " + flag);
		return flag;
	}

	public boolean verifyAtiContactsPopUpInfo(String loc) throws DriverException {
		logger.info("Method: verifyAtiContactsPopUpInfo Starts");
		ArrayList<Boolean> list = new ArrayList<Boolean>();
		try {
			List<WebElement> findElement = baseHandler.findElements(loc);
			if (CollectionUtils.isNotEmpty(findElement)) {

				for (WebElement webElement : findElement) {
					list.add(webElement.isDisplayed());
				}

			}
			List<WebElement> findElement1 = baseHandler
					.findElements(PropertiesRepository.getString("id.home.static.list.ati.contacts.popup.msg.loc1"));
			if (CollectionUtils.isNotEmpty(findElement1)) {
				for (WebElement webElement : findElement1) {
					list.add(webElement.isDisplayed());
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verifyCohortName");
			log(logger, "Unable to verifyCohortName");
			throw new DriverException("Unable to verifyCohortName", e);
		}

		logger.info("Method: verifyAtiContactsPopUpInfo Starts");

		return list.contains(false) ? false : true;

	}

	/**
	 * @author Syed.Hoque This method will click on "Return to faculty" link
	 * @throws DriverException
	 */
	public boolean clickOnReturnToFacultyLink(int index) throws DriverException {
		logger.info("Method: clickOnReturnToFacultyLink START");
		boolean flag = false; 
		try {
			List<WebElement> findElement = baseHandler
					.findElements(PropertiesRepository.getString("returntofaculty.link"));
			if (CollectionUtils.isNotEmpty(findElement)) {
				findElement.get(index).click();
				waitUntillLoadingImageIsDisappeared(".mobile-loader-rect");
				//waitForAwhile(6000);
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to click on continue button for return to faculty link");
			log(logger, "Unable to click on continue button for return to faculty link");
			throw new DriverException("Unable to click on continue button for return to faculty link", e);
		}
		logger.info("Method: clickOnReturnToFacultyLink ENDS flag --> " + flag);
		return flag;
	}

	/**
	 * @author Syed.Hoque This method will click on continue button of student
	 *         view pop up
	 * @throws DriverException
	 */
	public boolean clickContinueForStudentView() throws DriverException {
		logger.info("Method: clickContinueForStudentView Starts");
		boolean flag = false;
		
		try {
			List<WebElement> ele = baseHandler
					.findElements(PropertiesRepository.getString("studentmimic.continue.btn"));
			if (CollectionUtils.isNotEmpty(ele) && ele.size() > 0) {
				ele.get(0).click();
			}
			waitUntillLoadingImageIsDisappeared(".mat-dialog-container ng-component div");
			waitUntillLoadingImageIsAppeared(".mobile-loader-rect");
			waitUntillLoadingImageIsDisappeared(".mobile-loader-rect");
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.spinner.loc1"));
			waitUntillLoadingImageIsDisappeared(".blockUI.blockMsg.blockPage");
			// Checking Student Portal is displayed or not. 
			
			WebElement studLogo = verifyElement(".logo");
			if(studLogo != null && studLogo.isDisplayed()) {
				flag = true;
			}
			// Click on I Agree of Terms and Condition checkbox if present
			WebElement studATITermsOfUserPopup = verifyElement("#TermsConditionsDialog .checkbox-not-checked");
			if(studATITermsOfUserPopup != null && studATITermsOfUserPopup.isDisplayed()) {
				studATITermsOfUserPopup.click();
				// Clicking on Continue button in Popup. 
				WebElement studATITermsOfUserPopupContBtn = verifyElement(".button.create-account-button.step-modal-nav-right.focus-element-flag.create-account-button-active");
				if(studATITermsOfUserPopupContBtn != null) {
					studATITermsOfUserPopupContBtn.click();
					logger.info("Popup is displayed and clicked on check box and continue button.");
				}
			}
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.spinner.loc"));
			
		} catch (Exception e) {
			logger.info("Unable to click on continue button for student view home link");
			log(logger, "Unable to click on continue button for student view home link");
			throw new DriverException("Unable to click on continue button for student view home link", e);
		}
		logger.info("Method: clickContinueForStudentView ENDS flag --> " + flag);
		return flag;
	}

	public boolean verifyURL(String loc, String input) throws DriverException {
		logger.info("Method: verifyURL Starts");
		try {
			WebElement findElement = baseHandler.findElement(PropertiesRepository.getString(loc));
			if (findElement != null) {
				findElement.click();
				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.spinner.loc"));
				if (driver.getCurrentUrl().contains(PropertiesRepository.getString(input))) {
					return true;
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verify URL");
			log(logger, "Unable to verify URL");
			throw new DriverException("Unable to verify URL", e);
		}

		logger.info("Method: verifyURL End");
		return false;
	}

	public void selectInstitutionLDropDown() throws DriverException {
		WebElement element = verifyElement(PropertiesRepository.getString("id.home.cohort.icon"));
		if (element != null) {
			// Clicking on Left cohort icon
			element.click();
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		}
	}

	/**
	 * @author Syed.Hoque this method will verify that webLink is not present on
	 *         the leftnav menu
	 * @return
	 * @throws DriverException
	 */
	public boolean verifyThatWebLinkIsPresent(String elementText) throws DriverException {
		boolean flag = false;
		try {
			List<String> lstLeftNavValue = new ArrayList<String>();
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("id.home.page.proctor.left.navigator.icon.link.new.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				for (WebElement webElement : element) {
					lstLeftNavValue.add(webElement.getText().trim());
				}
			}
			if (lstLeftNavValue.contains(elementText)) {
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to verify link");
			log(logger, "Unable to verify link");
			throw new DriverException("Unable to verify URL", e);
		}
		return flag;
	}

	/**
	 * @author Syed.Hoque This method will click on student tab form nextgen
	 *         page
	 * @throws DriverException
	 */
	public void clickOnStudentTab() throws DriverException {
		logger.info("Method: VerifyStudentAndFacultyNavigation:: START");
		try {
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("student.faculty.btn"));

			element.get(0).click();
			waitForAwhile(2000);
		} catch (Exception e) {
			logger.info("Unable to validate clickOnStudentTab");
			log(logger, "Unable to validate clickOnStudentTab");
			throw new DriverException("Unable to validate clickOnStudentTab", e);
		}
		logger.info("Method: clickOnStudentTab:: ENDS");
	}

	/**
	 * @author Syed.Hoque 
	 * This method will click on student tab form nextgen page
	 * @throws DriverException
	 */
	public void clickOnFacultyTab() throws DriverException {
		logger.info("Method: VerifyStudentAndFacultyNavigation:: START");
		try {
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("student.faculty.btn"));

			element.get(1).click();
			waitForAwhile(2000);
		} catch (Exception e) {
			logger.info("Unable to validate clickOnFacultyTab");
			log(logger, "Unable to validate clickOnFacultyTab");
			throw new DriverException("Unable to validate clickOnFacultyTab", e);
		}
		logger.info("Method: clickOnFacultyTab:: ENDS");
	}

	public boolean verifyAlertToastMessageDisplayed(String locator) throws NullPointerException, DriverException {
		logger.info("Method: verifyAndClick Starts");
		boolean flag = false;
		try {
			WebElement element = verifyElement(locator);
			if (element != null) {
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to verifyAndClick");
			log(logger, "Unable to verifyAndClick");
			throw new DriverException("Unable to verifyAndClick", e);
		}
		logger.info("Method: verifyAndClick End flag --> " + flag);
		return flag;
	}

	/**
	 * Used to verify Alerts/News list is displayed
	 * 
	 * @author prasanna.gogineni
	 * @param locator
	 * @throws Exception
	 */
	public boolean VerifyNewsAndAlertsList(String locator) throws DriverException {
		logger.info("VerifyNewsAndAlertsList Start " + locator);
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString(locator));

			if (CollectionUtils.isNotEmpty(element) && element.size() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to VerifyNewsAndAlertsList");
			log(logger, "Unable to VerifyNewsAndAlertsList");
			throw new DriverException("Unable to VerifyNewsAndAlertsList", e);
		}
		logger.info("VerifyNewsAndAlertsList End flag" + flag);
		return flag;

	}

	/**
	 * This method will handle waits while user navigating to cab
	 * 
	 * @author Syed.Hoque
	 * @throws DriverException
	 */

	public void waitTillCabLoaded() throws DriverException {
		logger.info("waitTillCabLoaded  --- Start");
		try {
			Thread.sleep(50000);
			waitUntillLoadingImageIsDisappeared(".mobile-loader-rect");

		} catch (Exception e) {
			logger.info("Unable to VerifyNewsAndAlertsList");
			log(logger, "Unable to VerifyNewsAndAlertsList");
			throw new DriverException("Unable to VerifyNewsAndAlertsList", e);
		}
		logger.info("waitTillCabLoaded  --- ENDS");
	}

	/**
	 * Used to click and verify the text
	 * 
	 * @author prasanna.gogineni
	 * @param locator
	 * @return
	 * @throws Exception
	 */
	public boolean clickAndVerifyTextFromList(String loc1, String loc2, int index)
			throws NullPointerException, DriverException {
		logger.info("clickAndVerifyTextFromList  --- Start");
		boolean flag = false;
		try {
			List<WebElement> elements = baseHandler.findElements(PropertiesRepository.getString(loc1));

			if (CollectionUtils.isNotEmpty(elements)) {
				String expectedAlertText = elements.get(0).getText();
				new Actions(driver).moveToElement(elements.get(index)).click().build().perform();
				List<WebElement> element2 = baseHandler.findElements(PropertiesRepository.getString(loc2));
				if (CollectionUtils.isNotEmpty(element2)) {
					String actualText = element2.get(0).getText().trim();
					if (expectedAlertText.contains(actualText)) {
						flag = true;
					}
				}
			}
			// if(baseHandler.isDisplayed(PropertiesRepository.getString(loc1))){}
		} catch (Exception e) {
			logger.info("unable to click button and verify text");
			throw new DriverException("unable to click button and verify text", e);
		}
		logger.info("clickAndVerifyTextFromList  --- End");
		return flag;
	}

	/*
	 * public void selectInstitutionLDropDown() throws DriverException {
	 * WebElement element = verifyElement(PropertiesRepository
	 * .getString("id.home.cohort.icon")); if (element != null) { // Clicking on
	 * Left cohort icon element.click();
	 * waitUntillLoadingImageIsDisappeared(PropertiesRepository
	 * .getString("id.common.page.loader")); } }
	 */

	/**
	 * 
	 */

	public void waitUntillLoadingImageIsDisappeareds(String loc) throws Exception {
		logger.info("Method: waitUntillLoadingImageIsDisappeared Starts");
		long startTime = System.currentTimeMillis();
		try {
			List<WebElement> buffecImage = baseHandler.findElements(PropertiesRepository.getString(loc));
			try {
				while ((String.valueOf(buffecImage.size()) != null)
						&& ((System.currentTimeMillis() - startTime) < 120000)) {
					logger.info("page is still loading after click on the element");
					logger.info("Wait Counter in Seconds >>>> "
							+ (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - startTime)));
					buffecImage = baseHandler.findElements(PropertiesRepository.getString(loc));
				}
				// waitUntillOverlayImageIsDisappeared("new-atitesting.peasewait.bufferLoc1");
			} catch (Exception e) {
				// waitUntillOverlayImageIsDisappeared("new-atitesting.peasewait.bufferLoc1");
				if (!((System.currentTimeMillis() - startTime) < 120000)) {
					logger.info("Waited 120 seconds to load the page");
				} else {
					logger.info("Page load complete");
				}
			}
		} catch (Exception e) {
			logger.info("Unable to wait Untill Loading Image Is not Disappeared");
			log(logger, "Unable to wait Untill Loading Image Is not Disappeared");
			throw new DriverException("Unable to wait Untill Loading Image Is not Disappeared", e);
		}
		logger.info("waitUntillLoadingImageIsDisappeared End");
	}

	/**
	 * Method used to click on Tab Home, MyATI, MyResults and Help
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	public void clickTab(int index) throws Exception {
		logger.info("Method: clickTab Starts");
		try {
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.all.tabs"));
			if (CollectionUtils.isNotEmpty(element)) {
				List<WebElement> tabElement = element.get(0)
						.findElements(By.cssSelector(PropertiesRepository.getString("new-atitesting.common.li")));
				if (CollectionUtils.isNotEmpty(tabElement)) {
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
							tabElement.get(index));
					tabElement.get(index).click();
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				}
			}
		} catch (Exception e) {
			logger.info("Unable to click Tab");
			log(logger, "Unable to click Tab");
			throw new DriverException("Unable to click Tab", e);
		}
		logger.info("Method: clickTab End ");
	}

	public boolean verifyCohortList() throws Exception {
		logger.info("verifyCohortList  --- ENDS");
		boolean flag = false;
		try {

			WebElement element = verifyElement(PropertiesRepository.getString("id.home.cohort.icon"));
			if (element != null) {
				element.click();
				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				WebElement cohortTextBox = verifyElement(PropertiesRepository.getString("id.home.cohort.name.loc"));
				if (cohortTextBox != null) {
					cohortTextBox.click();
					verifyElementExists(PropertiesRepository.getString("reassign.drop.down.ele"));
					element.click();
					flag = true;

				}

			}

		} catch (Exception e) {
			logger.info("Unable to click Tab");
			log(logger, "Unable to click Tab");
			throw new DriverException("Unable to click Tab", e);

		}
		logger.info("verifyCohortList  --- ENDS");
		return flag;
	}

	/**
	 * Method is used to verify id the Customized Home link is present on the
	 * top of the menu and Click
	 * 
	 * @author syed.pasha
	 * 
	 */
	public boolean verifyIfCustomizedHomeLinkIsFirstAndClick() throws DriverException {
		logger.info("verifyIfCustomizedHomeLinkIsFirstAndClick  --- Starts");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("id.home.menu.item.list.loc"));
			if (CollectionUtils.isNotEmpty(element) &&  element.get(0).getText().contains(PropertiesRepository.getString("id.home.customize.home.link.value"))) {
				element.get(0).click();
				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to verifyIfCustomizedHomeLinkIsFirstAndClick");
			log(logger, "Unable to verifyIfCustomizedHomeLinkIsFirstAndClick");
			throw new DriverException("Unable to verifyIfCustomizedHomeLinkIsFirstAndClick", e);
		}
		logger.info("verifyIfCustomizedHomeLinkIsFirstAndClick  --- Ends");
		return flag;
	}
}
