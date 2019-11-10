package com.automation.newati.ehr;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.EHRPage;
import com.automation.newati.pages.FacultyPortalPage;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyReportPage;
import com.automation.newati.pages.NclexPrepTabPage;
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class EHRTest extends BaseTest {
	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private TutorialPage tutorialPage;
	private NclexPrepTabPage nclexPrepTabPage;
	private FacultyPortalPage facultyPortalPage;
	private MyReportPage myReportPage;
	private EHRPage ehrPage;

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		tutorialPage = new TutorialPage(driver);
		nclexPrepTabPage = new NclexPrepTabPage(driver);
		facultyPortalPage = new FacultyPortalPage(driver);
		ehrPage = new EHRPage(driver);
	}

	@TestAnnotations(testID = "NewATI-1109")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "Verify the card fron for EMR product")
	public void NewATI1109_VerifyEMRCardFront() throws Exception {
		log(logger, "NewATI1109_VerifyEMRCardFront Start");

		logger.info("NewATI1109_VerifyEMRCardFront Start");

		loginPage.loginToApplication(PropertiesRepository.getString("newati.ehr.login.username"),
				PropertiesRepository.getString("newati.ehr.login.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verify if Add Product Link is displayed in Home page");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("newati.home.page.add.product.link.loc"));

		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verify if Content Area drop down is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("new-atitesting.content.area.dropdown"));

		log(logger, "Clicking Apply Tab");
		homePage.clickSubTab(3);

		log(logger, "Selecting 'NCLEX' Option from Content Area");
		tutorialPage.selectValueBySelectClass(
				PropertiesRepository.getString("new-atitesting.content.area.dropdown.loc"),
				PropertiesRepository.getString("new-atitesting.content.area.value.all"));
		
		log(logger, "Verifying EHR Tutor ");
		VerificationHandler.verifyTrue(ehrPage.VerifyIfEHRTutorDisplayed(
				PropertiesRepository.getString("new-atitesting.apply.tab.simulation.ehr.tutor.name")));

		log(logger, "Getting Module number from Card Front");
		/*VerificationHandler.verifyEquals(*/
				ehrPage.getModuleCount(
						PropertiesRepository.getString("new-atitesting.apply.tab.simulation.ehr.tutor.name"));
				/*PropertiesRepository.getString("new-atitesting.apply.tab.simulation.ehr.tutor.module.count")
				"Unable to verify Module count for EHR Tutor");*/

		log(logger, "Clicking on Modules button");
		ehrPage.clickOnEHRModuleButton(
				PropertiesRepository.getString("new-atitesting.apply.tab.simulation.ehr.tutor.name"));

		log(logger, "Verifying Card back header section");
		VerificationHandler
				.verifyTrue(
						nclexPrepTabPage.verifyCardBackHeaderSection(
								PropertiesRepository.getString("new-atitesting.apply.tab.card.back.header.loc"),
								PropertiesRepository
										.getString("new-atitesting.apply.tab.card.back.ehr.tutor.header.name")),
						"Unable to Verify Card back header section");

		log(logger, "Verifying View label");
		VerificationHandler.verifyTrue(
				ehrPage.verifyMessage("new-atitesting.apply.tab.card.back.view.sort.label.loc", 0,
						PropertiesRepository.getString("new-atitesting.apply.tab.card.back.view.label.value")),
				"Unable to Verify View label");

		log(logger, "Verifying View DD");
		VerificationHandler.verifyTrue(
				ehrPage.verifyElement(PropertiesRepository.getString("new-atitesting.apply.tab.card.back.view.dd.loc")),
				"Unable to Verify View DD");

		log(logger, "Verifying Sort label");
		VerificationHandler.verifyTrue(
				ehrPage.verifyMessageContains(
						PropertiesRepository.getString("new-atitesting.apply.tab.card.back.sort.dd.loc"),
						PropertiesRepository.getString("new-atitesting.apply.tab.card.back.sort.label.value")),
				"Unable to Verify Sort label");

		log(logger, "Verifying Sort DD");
		VerificationHandler.verifyTrue(
				ehrPage.verifyElement(PropertiesRepository.getString("new-atitesting.apply.tab.card.back.sort.dd.loc")),
				"Unable to Verify Sort DD");

		log(logger, "Verifying Course Activities module in cardback");
		VerificationHandler.verifyTrue(
				ehrPage.verifyCardBackIndividualModuleText(PropertiesRepository
						.getString("new-atitesting.apply.tab.card.back.module.name.course.activities.value")),
				"Unable to Verify Course Activities module in cardback");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Verifying EHR Tutor Simulation name");
		VerificationHandler
				.verifyTrue(
						ehrPage.verifyMessage("new-atitesting.apply.tab.assessment.name.loc", 1,
								PropertiesRepository
										.getString("new-atitesting.apply.tab.assessment.simulation.name.value")),
						"Unable to Verify EHR Tutor Simulation name");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Verifying EHR Tutor Module name");
		VerificationHandler
				.verifyTrue(
						ehrPage.verifyMessage("new-atitesting.apply.tab.assessment.name.loc", 3,
								PropertiesRepository
										.getString("new-atitesting.apply.tab.assessment.module.name.value")),
						"Unable to Verify EHR Tutor Module name");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on Close button");
		VerificationHandler.verifyTrue(
				ehrPage.verifyAndClick(
						PropertiesRepository.getString("new-atitesting.apply.tab.assessment.close.button.loc"), true),
				"Unable to Click on Close button");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on Yes button in Popup");
		VerificationHandler.verifyTrue(ehrPage.clicYesInPopup(), "Unable to Click on Yes button in Popup");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on Card back close button");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyTrue(ehrPage.verifyAndClick(PropertiesRepository.getString("new-atitesting.cardback.close.loc.new"), true), "Unable to Click on Card back close button");

		log(logger, "Clicking on Home tab");
		homePage.clickTab(0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verifying Recent History");
		VerificationHandler.verifyTrue(ehrPage.verifyEHRRecentActivity(
				PropertiesRepository.getString("new-atitesting.apply.tab.assessment.simulation.name.value"),
				PropertiesRepository.getString("new-atitesting.apply.tab.assessment.module.name.value")), "Unable to Verify Recent History");
		log(logger, "NewATI1109_VerifyEMRCardFront End");

		logger.info("NewATI1109_VerifyEMRCardFront End");
	}
	
	/**
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-1092")
	@Test(priority = 5, alwaysRun = true, enabled = true, groups = {"Regression" }, description = "Verify NCLEX Experience Enable/Disable Product.")
	public void NewATI1092_VerifyNCLEXEnableDisableProduct() throws Exception {
		log(logger, "NewATI1092_VerifyNCLEXEnableDisableProduct Start");
		logger.info("NewATI1092_VerifyNCLEXEnableDisableProduct Start");
		
		log(logger, "Login to Student Portal Application");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.nclex.login.enable.disable.username"),
				PropertiesRepository.getString("newati.nclex.login.enable.disable.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verify if Add Product Link is displayed in Home page");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("newati.home.page.add.product.link.loc"));

		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);

		log(logger, "Verify if Content Area drop down is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("new-atitesting.content.area.dropdown"));
		
		log(logger, "Clicking Apply Tab");
		homePage.clickSubTab(3);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Verifying EHR Tutor Apply tab");
		log(logger, "Verifying EHR Tutor ");
		VerificationHandler.verifyTrue(ehrPage.VerifyIfEHRTutorDisplayed(
				PropertiesRepository.getString("new-atitesting.apply.tab.simulation.ehr.tutor.name")));
		
		log(logger, "Verifying Disabling message in card front");
		VerificationHandler.verifyFalse(nclexPrepTabPage.verifyMessage(
				PropertiesRepository.getString("new.atitestig.nclex.card.front.disabled.by.instructor.message.loc"),
				PropertiesRepository.getString("new.atitestig.nclex.card.front.disabled.by.instructor.message.value")), "Disabling by Instructor message is displayed");
		
		log(logger, "Login to Faculty Portal Application");
		facultyPortalPage.loginToFacultyApplication(PropertiesRepository.getString("id.login.username.value"),
				PropertiesRepository.getString("id.login.password.value"));
		facultyPortalPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");
		facultyPortalPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		log(logger, "Verifying Products Tab from Left navigation");
		VerificationHandler.verifyTrue(
				facultyPortalPage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "apps", true),
				"Unable to verify  Products   ");
		facultyPortalPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying Products Home page");
		VerificationHandler.verifyTrue(
		facultyPortalPage.verifyMessage(PropertiesRepository.getString("id.product.page.menu.loc"), 0,
				PropertiesRepository.getString("id.product.page.menu.value")),
		"Unable to verify products home page");
		facultyPortalPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Clicking on Cohort search img");
		VerificationHandler.verifyTrue(
		facultyPortalPage.verifyAndClick(PropertiesRepository.getString("id.product.page.cohort.search.img.loc"), true),
		"Unable to click on cohort search image");
		facultyPortalPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Searching cohort name in search text box.");
		facultyPortalPage.enterTextInSearchBox(
				PropertiesRepository.getString("id.product.page.cohort.search.textbox.loc"),
				PropertiesRepository.getString("id.product.page.cohort.search.textbox.value")); 
		facultyPortalPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying Cohort name and clicking on same");
		VerificationHandler.verifyTrue(
		facultyPortalPage.verifyMessage(PropertiesRepository.getString("id.product.page.cohort.search.result.name.loc"),
				PropertiesRepository.getString("id.product.page.cohort.search.textbox.value")), 
		"Unable to verify cohort name after searching");
		
		log(logger, "Clicking on Cohort name after searching");
		VerificationHandler.verifyTrue(
				facultyPortalPage
				.verifyAndClick(PropertiesRepository.getString("id.product.page.cohort.search.result.name.loc"), true), 
				"Unable to click on cohort name after searching");
		facultyPortalPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Clicking on Tutorial Manage Button");
		VerificationHandler.verifyTrue(
		facultyPortalPage.clickTutorialManageButtonForPersonnelUser(), "Unable to click on Tutorial manage button");
		facultyPortalPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verify on NCLEX Access Modules and click on Enable image");
		facultyPortalPage.clickEnableDisableImage(PropertiesRepository.getString("new.atitestig.nclex.cardfront.product.name"));
		
		log(logger, "Clicking on Save Changes button");
		VerificationHandler.verifyTrue(
		facultyPortalPage.verifyAndClickWithSwitchToCardShadowFrame(PropertiesRepository.getString("id.portal.product.tutorial.save.changes.button.loc"), true), 
		"Unable to click on Save Changes button");
		facultyPortalPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Login to Student Portal Application for Verification again resetting");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.nclex.login.enable.disable.username"),
				PropertiesRepository.getString("newati.nclex.login.enable.disable.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verify if Add Product Link is displayed in Home page");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("newati.home.page.add.product.link.loc"));

		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);

		log(logger, "Verify if Content Area drop down is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("new-atitesting.content.area.dropdown"));
		
		log(logger, "Clicking NCLEXPREP Tab");
		homePage.clickSubTab(4);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Verifying check box is checked");
		nclexPrepTabPage.verifyHiddenCheckBoxMessageAndClick();
		Thread.sleep(2000);
		log(logger, "Verifying Nclex RN Live Review producs should up in NCLEX tab");
		VerificationHandler.verifyTrue(nclexPrepTabPage.VerifyIfNCLEXRNLiveTutorialNewDisplayed(
				PropertiesRepository.getString("new.atitestig.nclex.cardfront.product.name")));
		Thread.sleep(2000);
		log(logger, "Verifying Disabling message in card front");
		VerificationHandler.verifyTrue(nclexPrepTabPage.verifyMessage(
				PropertiesRepository.getString("new.atitestig.nclex.card.front.disabled.by.instructor.message.loc"),1,
				PropertiesRepository.getString("new.atitestig.nclex.card.front.disabled.by.instructor.message.value")), "Disabling by Instructor message is displayed");
		
		log(logger, "Login to Faculty Portal Application");
		facultyPortalPage.loginToFacultyApplication(PropertiesRepository.getString("id.login.username.value"),
				PropertiesRepository.getString("id.login.password.value"));
		facultyPortalPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");
		facultyPortalPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		log(logger, "Verifying Products Tab from Left navigation");
		VerificationHandler.verifyTrue(
				facultyPortalPage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "apps", true),
				"Unable to verify  Products   ");
		facultyPortalPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying Products Home page");
		VerificationHandler.verifyTrue(
		facultyPortalPage.verifyMessage(PropertiesRepository.getString("id.product.page.menu.loc"), 0,
				PropertiesRepository.getString("id.product.page.menu.value")),
		"Unable to verify products home page");

		log(logger, "Clicking on Cohort search img");
		VerificationHandler.verifyTrue(
		facultyPortalPage.verifyAndClick(PropertiesRepository.getString("id.product.page.cohort.search.img.loc"), true),
		"Unable to click on cohort search image");
		facultyPortalPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Searching cohort name in search text box.");
		facultyPortalPage.enterTextInSearchBox(
				PropertiesRepository.getString("id.product.page.cohort.search.textbox.loc"),
				PropertiesRepository.getString("id.product.page.cohort.search.textbox.value")); 
		facultyPortalPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying Cohort name and clicking on same");
		VerificationHandler.verifyTrue(
		facultyPortalPage.verifyMessage(PropertiesRepository.getString("id.product.page.cohort.search.result.name.loc"),
				PropertiesRepository.getString("id.product.page.cohort.search.textbox.value")), 
		"Unable to verify cohort name after searching");
		facultyPortalPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Clicking on Cohort name after searching");
		VerificationHandler.verifyTrue(
				facultyPortalPage
				.verifyAndClick(PropertiesRepository.getString("id.product.page.cohort.search.result.name.loc"), true), 
				"Unable to click on cohort name after searching");
		facultyPortalPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Clicking on Tutorial Manage Button");
		VerificationHandler.verifyTrue(
		facultyPortalPage.clickTutorialManageButtonForPersonnelUser(), "Unable to click on Tutorial manage button");
		facultyPortalPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verify on NCLEX Access Modules and click on Enable image");
		facultyPortalPage.clickEnableDisableImage(PropertiesRepository.getString("new.atitestig.nclex.cardfront.product.name"));
		
		log(logger, "Clicking on Save Changes button");
		VerificationHandler.verifyTrue(
		facultyPortalPage.verifyAndClickWithSwitchToCardShadowFrame(PropertiesRepository.getString("id.portal.product.tutorial.save.changes.button.loc"), true), 
		"Unable to click on Save Changes button");
		facultyPortalPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		logger.info("NewATI1092_VerifyNCLEXEnableDisableProduct End");
		log(logger, "NewATI1092_VerifyNCLEXEnableDisableProduct End");
	}
	

}
