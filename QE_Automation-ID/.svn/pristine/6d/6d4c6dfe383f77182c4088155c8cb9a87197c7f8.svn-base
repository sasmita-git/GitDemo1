package com.automation.id.home;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.id.pages.EditProfilePage;
import com.automation.id.pages.HomePage;
import com.automation.id.pages.LoginPage;
import com.jaca.TestAnnotations;

public class HomeTest2 extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	LoginPage loginPage;
	HomePage homePage;
	EditProfilePage editProfilePage;

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		editProfilePage=new EditProfilePage(driver);

	}

	@TestAnnotations(testID = "INST-1728")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "Verifying that save institution and cohort always display each login without consortium")
	public void INST1728_VerifyInstitutionForConsortium() throws Exception {
		logger.info("INST1728_VerifyInstitutionForConsortium Start");

		log(logger, "Login to application");
		loginPage.loginToApplication(PropertiesRepository.getString("id.faculty.login.director.user.name"),
				PropertiesRepository.getString("id.faculty.login.director.Password"));
		
		/*log(logger, "click on close button");
		editProfilePage.clickButtonFromList("id.homepage.home.page.alert.close", 0);
		*/
		
		log(logger, "Click on institution dropdown");
		homePage.verifyAndClick(PropertiesRepository.getString("id.home.cohort.icon"), true);

		log(logger, "verify cohort menu displayed on clicking inst dropdown");
		VerificationHandler.verifyTrue(
				homePage.verifyElementExists(PropertiesRepository.getString("id.home.cohort.name.loc")),
				"cohort menu not displayed");

		log(logger, "Entering cohort");
		homePage.enterCohort(PropertiesRepository.getString("id.1911.cohort.name"));

		log(logger, "Clicking signout icon on right side");
		homePage.verifyAndClick(PropertiesRepository.getString("id.home.threedot.loc"), true);

		log(logger, "Clicking signout Link");
		homePage.verifyAndClick(PropertiesRepository.getString("id.home.signout.loc"), 3, true);
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "verify user logged out of the application");
		VerificationHandler.verifyTrue(
				homePage.verifyElementExists(PropertiesRepository.getString("id.login.faculty.proctor.login.loc")),
				"usernot loggedout");

		log(logger, "Relogin to application");
		loginPage.loginToApplication(PropertiesRepository.getString("id.faculty.login.director.user.name"),
				PropertiesRepository.getString("id.faculty.login.director.Password"));

		log(logger, "Verify saved institution and cohort are showing on relogin");
		VerificationHandler.verifyTrue(
				homePage.verifySelectedInstituteNCohort(PropertiesRepository.getString("id.instituton.input.value"),
						PropertiesRepository.getString("id.1911.cohort.name")),
				"selected insitute and cohort saved successfully ");

		logger.info("INST1728_VerifyInstitutionForConsortium End");
	}

	@TestAnnotations(testID = "INST-1727")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "Verifying that save institution and cohort always display each login for personnel")
	public void INST1727_VerifyInstitutionForPersonnel() throws Exception {
		logger.info("INST1727_VerifyInstitutionForPersonnel Start");

		/*
		 * log(logger, "Login to application");
		 * loginPage.loginToApplication(PropertiesRepository.getString(
		 * "id.login.personnel.username"),
		 * PropertiesRepository.getString("id.login.personnel.password"));
		 */

		log(logger, "enter url");
		// loginPage.loginToInstApplication(PropertiesRepository.getString("id.login.user.name"),
		// PropertiesRepository.getString("id.login.password"));
		loginPage.loginToApplication(PropertiesRepository.getString("id.login.personnel.username"),
				PropertiesRepository.getString("id.login.personnel.password"));
		loginPage.waitForAwhile(8000);

		log(logger, "click on close button");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.home.page.alert.close"), 0);

		log(logger, "select institution and cohort from dropdown");
		homePage.selectInstituteAndCohort(PropertiesRepository.getString("new-atitesting.institution.name"),
				PropertiesRepository.getString("id.stg.cohort.naming.home"));

		log(logger, "click on three dots on top right corner");
		homePage.clikOnDotsAtTopRightCorner(1);

		log(logger, "click on log out store");
		homePage.clickOnTopRightCornerElement(7);

		// again login to the application with the same user
		loginPage.loginToApplication(PropertiesRepository.getString("id.login.personnel.username"),
				PropertiesRepository.getString("id.login.personnel.password"));
		loginPage.waitForAwhile(4000);

		log(logger, "Verify instituion name");
		homePage.verifyInstitutionName("inst.name.loc");

		log(logger, "verify class name");
		homePage.verifyCohortName("class.name.loc");

		/*
		 * log(logger, "Verifying Institution name");
		 * VerificationHandler.verifyTrue(homePage.verifyInstitutionName(
		 * PropertiesRepository.getString("id.home.institution.and.cohort.loc"))
		 * , "Unable to verify Institution name");
		 * 
		 * log(logger, "Verifying Cohort name");
		 * homePage.verifyCohortName(PropertiesRepository.getString(
		 * "id.home.institution.and.cohort.loc"));
		 * 
		 * log(logger, "Clicking signout icon on right side");
		 * homePage.verifyAndClick(PropertiesRepository.getString(
		 * "id.home.red.bell.new.loc"), 1, true);
		 * 
		 * log(logger, "Clicking signout Link ");
		 * homePage.verifyAndClick(PropertiesRepository.getString(
		 * "id.home.signout.loc"), 3, true);
		 * homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.
		 * getString("id.common.page.loader"));
		 * 
		 * log(logger, "Relogin to application");
		 * loginPage.loginToApplication(PropertiesRepository.getString(
		 * "id.faculty.login.director.user.name"),
		 * PropertiesRepository.getString("id.faculty.login.director.Password"))
		 * ;
		 * 
		 * log(logger, "Verifying Cohort name");
		 * homePage.verifyCohortName(PropertiesRepository.getString(
		 * "id.home.institution.and.cohort.loc"));
		 * 
		 */ logger.info("INST1727_VerifyInstitutionForPersonnel End");
	}

	@TestAnnotations(testID = "INST-1634")
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "inst-1634:Moving contact us widget")
	public void INST1634_VerifyMovingContactUsWidget() throws Exception {
		logger.info("INST1634_VerifyMovingContactUsWidget Start");

		log(logger, "Login to application");
		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.faculty.username"),
				PropertiesRepository.getString("id.login.faculty.password"));

		log(logger, "Click on Ellipses on the top right corner");
		loginPage.clickButton(PropertiesRepository.getString("id.homepage.static.menu"), 1);
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Verify ATI contact link");
		VerificationHandler.verifyTrue(homePage
				.verifyLink(PropertiesRepository.getString("id.home.menu.item.list.loc"), 1, "contacts"));
		
		log(logger, "click on ATI Contact button");
		VerificationHandler.verifyTrue(
				loginPage.verifyAndClick(PropertiesRepository.getString("id.home.menu.item.list.loc"), 1, true),
				"Unabel to click Signout link");

		log(logger, "verify ATI Contacts static menu popup ");
		VerificationHandler.verifyTrue(
				homePage.verifyTextEqualsList(PropertiesRepository.getString("id.home.static.list.option.loc"),
						PropertiesRepository.getString("id.home.static.list.ati.contacts.option.text")));

		logger.info("INST1634_VerifyMovingContactUsWidget End");
	}

	@TestAnnotations(testID = "INST-1690")
	@Test(priority = 5, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "inst-1690:Check for footer when user logged in")
	public void INST1690_CheckForFooterWhenUserLoggedIn() throws Exception {
		logger.info("INST1690_CheckForFooterWhenUserLoggedIn Start");

		log(logger, "Login to application");
		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.faculty.username"),
				PropertiesRepository.getString("id.login.faculty.password"));
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verify Footer of the page");
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("id.home.footer.loc", 0));

		log(logger, "click on toolbar link");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.layout.link"), 0);

		log(logger, "click on products tab");
		loginPage.clickElement("id.homepage.main.menu.list", 1);

		log(logger, "Verify Footer of the page");
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("id.home.footer.loc", 0));

		log(logger, "click on toolbar link");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.layout.link"), 0);

		log(logger, "click on proctor tab");
		loginPage.clickElement("id.homepage.main.menu.list", 2);

		log(logger, "Verify Footer of the page");
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("id.home.footer.loc", 0));

		log(logger, "click on toolbar link");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.layout.link"), 0);

		log(logger, "click on people tab");
		loginPage.clickElement("id.homepage.main.menu.list", 5);

		log(logger, "Verify Footer of the page");
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("id.home.footer.loc", 0));

		logger.info("INST1690_CheckForFooterWhenUserLoggedIn End");
	}

	@TestAnnotations(testID = "INST-1723")
	@Test(priority = 6, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "inst-1723:Verify Institution drop down functionality for instructor,director,proctor")
	public void INST1723_VerifyATIContactsPopUp() throws Exception {
		logger.info("INST1723_VerifyATIContactsPopUp Start");

		log(logger, "Login to application");
		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.faculty.username"),
				PropertiesRepository.getString("id.login.faculty.password"));

		log(logger, "Entering cohort");
		homePage.selectCohort(PropertiesRepository.getString("id.1911.cohort.name"));

		log(logger, "verify cohort name");
		boolean textContains = homePage.verifyTextContains(PropertiesRepository.getString("id.home.cohort.verify.loc"),
				PropertiesRepository.getString("id.1911.cohort.name"), 1);
		VerificationHandler.verifyTrue(textContains);

		logger.info("INST1723_VerifyATIContactsPopUp End");
	}

	@TestAnnotations(testID = "INST-1724")
	@Test(priority = 7, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "inst-1724:Verify Institution drop down functionality for personnel")
	public void INST1724_VerifyInstitutionDropDownFunctionalityForPersonnel() throws Exception {
		logger.info("INST1724_VerifyInstitutionDropDownFunctionalityForPersonnel Start");

		log(logger, "Login to application");
		loginPage.loginToApplication(PropertiesRepository.getString("id.login.stage.personnel.username"),
				PropertiesRepository.getString("id.login.stage.personnel.password"));

		log(logger, "click on close button");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.home.page.alert.close"), 0);

		log(logger, "Enter institution");
		homePage.selectCohort(PropertiesRepository.getString("new-atitesting.institution.name"));

		log(logger, "verifying cohort for personnel user");
		boolean textContains = homePage.verifyTextContains(PropertiesRepository.getString("id.home.cohort.verify.loc"),
				PropertiesRepository.getString("new-atitesting.institution.name"), 0);
		VerificationHandler.verifyTrue(textContains);

		logger.info("INST1724_VerifyInstitutionDropDownFunctionalityForPersonnel End");
	}

	@TestAnnotations(testID = "INST-1726")
	@Test(priority = 8, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "inst-1726:Verifying that save institution and cohort always display each login")
	public void INST1726_verifyingThatSaveInstitutionandcohortAlwaysDisplayEachLogin() throws Exception {
		logger.info("INST1726_verifyingThatSaveInstitutionandcohortAlwaysDisplayEachLogin Start");

		log(logger, "Login to application");
		loginPage.loginToApplication(PropertiesRepository.getString("id.login.faculty.username"),
				PropertiesRepository.getString("id.login.faculty.password"));

		log(logger, "click on close button");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.home.page.alert.close"), 0);

		log(logger, "Entering cohort");
		homePage.selectCohort(PropertiesRepository.getString("id.1911.cohort.name"));

		log(logger, "click on sign out button");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.static.menu.list"), 3);

		log(logger, "Login to application");
		loginPage.loginToApplication(PropertiesRepository.getString("id.login.faculty.username"),
				PropertiesRepository.getString("id.login.faculty.password"));

		log(logger, "verify cohort name");
		boolean textContains = homePage.verifyTextContains(PropertiesRepository.getString("id.home.cohort.verify.loc"),
				PropertiesRepository.getString("id.1911.cohort.name"), 1);
		VerificationHandler.verifyTrue(textContains);

		logger.info("INST1726_verifyingThatSaveInstitutionandcohortAlwaysDisplayEachLogin End");
	}

	@TestAnnotations(testID = "INST-1720")
	@Test(priority = 9, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "inst-1720:Verify that user role after changing institution")
	public void INST1720_VerifyThatUserRoleAfterChangingInstitution() throws Exception {
		logger.info("INST1720_VerifyThatUserRoleAfterChangingInstitution Start");

		log(logger, "Login to application");
		loginPage.loginToApplication(PropertiesRepository.getString("id.login.faculty.username"),
				PropertiesRepository.getString("id.login.faculty.password"));

		log(logger, "click on close button");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.home.page.alert.close"), 0);

		log(logger, "Entering cohort");
		homePage.selectCohort(PropertiesRepository.getString("id.1911.cohort.name"));

		log(logger, "verifying cohort for personnel user");
		boolean textContains = homePage.verifyTextContains(PropertiesRepository.getString("id.home.cohort.verify.loc"),
				PropertiesRepository.getString("id.1911.cohort.name"), 1);
		VerificationHandler.verifyTrue(textContains);

		logger.info("INST1720_VerifyThatUserRoleAfterChangingInstitution End");
	}

	
	@TestAnnotations(testID = "INST-1603")
	@Test(priority = 10, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "Verify peronnel should not able to access any pages in Faculty portal without select institutiom")
	public void INST1603_verifyPersonnelAccessWithoutInstitution() throws Exception {
		logger.info("INST1603_verifyPersonnelAccessWithoutInstitution Start");

		log(logger, "Login to application");
		loginPage.loginToApplication(PropertiesRepository.getString("id.login.stage.personnel.username"),
				PropertiesRepository.getString("id.login.stage.personnel.password"));

		log(logger, "click on close button");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.home.page.alert.close"), 0);

		log(logger, "click on toolbar link");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.layout.link"), 0);

		log(logger, "click on people tab");
		loginPage.clickElement("id.homepage.main.menu.list", 2);

		// log(logger, "verifying warning message");
		// VerificationHandler.verifyTrue(loginPage.isElementDisplayed("id.home.toast.message.loc",0),"warning
		// message is not displayed");

		log(logger, "Enter institution");
		homePage.selectCohort(PropertiesRepository.getString("new-atitesting.institution.name"));

		log(logger, "verifying cohort for personnel user");
		boolean textContains = homePage.verifyTextContains(PropertiesRepository.getString("id.home.cohort.verify.loc"),
				PropertiesRepository.getString("new-atitesting.institution.name"), 0);
		VerificationHandler.verifyTrue(textContains);

		logger.info("INST1603_verifyPersonnelAccessWithoutInstitution End");
	}
}
