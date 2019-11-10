package com.automation.newati.nclex;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.FacultyPortalPage;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyReportPage;
import com.automation.newati.pages.NclexPrepTabPage;
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class NCLEXTest extends BaseTest {
	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private TutorialPage tutorialPage;
	private NclexPrepTabPage nclexPrepTabPage;
	private FacultyPortalPage facultyPortalPage;
	private MyReportPage myReportPage;
	
	@BeforeMethod(alwaysRun = true) 
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		tutorialPage = new TutorialPage(driver);
		nclexPrepTabPage=new NclexPrepTabPage(driver);
		facultyPortalPage = new FacultyPortalPage(driver);
	}
	
	/**
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-1071")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Regression" }, description = "Verify NCLEX Experience Card back")
	public void NewATI1071_VerifyNCLEXCardFront() throws Exception {
		log(logger, "NewATI1071_VerifyNCLEXCardFront Start");
		
		logger.info("NewATI1071_VerifyNCLEXCardFront Start");
		
		// Step 1 & 2
		log(logger, "NewATI1063_VerifyNCLEXCardFront Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.nclex.login.username"),
				PropertiesRepository.getString("newati.nclex.login.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verify if Add Product Link is displayed in Home page");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("newati.home.page.add.product.link.loc"));

		// Step 3
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);

		log(logger, "Verify if Content Area drop down is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("new-atitesting.content.area.dropdown"));
		// Step 4
		log(logger, "Clicking NCLEXPREP Tab");
		homePage.clickSubTab(4);

		// Step 4
		log(logger, "Verifying Nclex RN Live Review producs should up in NCLEX tab");
		VerificationHandler.verifyTrue(nclexPrepTabPage.VerifyIfNCLEXRNLiveTutorialNewDisplayed(
				PropertiesRepository.getString("new.atitestig.nclex.cardfront.product.name")));
		
		// Step 4
		log(logger, "Getting Module number from Card Front");
		VerificationHandler.verifyEquals(nclexPrepTabPage.getModuleCount(PropertiesRepository.getString("new.atitestig.nclex.cardfront.product.name")),
				PropertiesRepository.getString("new.atitestig.nclex.cardfront.module.count"), "Unable to verify Module count for NCLEX");
		
		logger.info("NewATI1071_VerifyNCLEXCardFront End");
		log(logger, "NewATI1071_VerifyNCLEXCardFront End");
	}
	
	/**
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-1072")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {"Regression" }, description = "Verify NCLEX Experience Card Back Functionality")
	public void NewATI1072_VerifyNCLEXCardBack() throws Exception {
		log(logger, "NewATI1072_VerifyNCLEXCardBack Start");
		
		logger.info("NewATI1072_VerifyNCLEXCardBack Start");
		
		// Step 1 & 2
		log(logger, "NewATI1072_VerifyNCLEXCardBack Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.nclex.login.username"),
				PropertiesRepository.getString("newati.nclex.login.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verify if Add Product Link is displayed in Home page");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("newati.home.page.add.product.link.loc"));

		// Step 3
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);

		log(logger, "Verify if Content Area drop down is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("new-atitesting.content.area.dropdown"));
		
		// Step 3
		log(logger, "Clicking NCLEXPREP Tab");
		homePage.clickSubTab(4);

		// Step 3
		log(logger, "Verifying Nclex RN Live Review producs should up in NCLEX tab");
		VerificationHandler.verifyTrue(nclexPrepTabPage.VerifyIfNCLEXRNLiveTutorialNewDisplayed(
				PropertiesRepository.getString("new.atitestig.nclex.cardfront.product.name")));

		// Step 4
		log(logger, "Clicking on NCLEX Cardback");
		tutorialPage.clickOnNCLEXModuleButton(PropertiesRepository.getString("new.atitestig.nclex.cardfront.product.name"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		// Step 4
		log(logger, "Verifying Card back header section");
		VerificationHandler.verifyTrue(
				nclexPrepTabPage.verifyCardBackHeaderSection(
						PropertiesRepository.getString("new.atitestig.nclex.cardfront.product.with.module.count")),
				"Unable to Verify Card back header section");
		// Step 4
		log(logger, "Verifying OverviewView Videos text in cardback");
		VerificationHandler.verifyTrue(nclexPrepTabPage.verifyCardBackIndividualModuleText(0),
				"Unable to Verify OverviewView Videos text in cardback");
		// Step 4
		log(logger, "Verifying Next Generation NCLEX Item Type Videos text in cardback");
		VerificationHandler.verifyTrue(nclexPrepTabPage.verifyCardBackIndividualModuleText(1),
				"Unable to Verify Next Generation NCLEX Item Type Videos text in cardback");
		// Step 4
//		log(logger, "Verifying Next Generation NCLEX Sample Item Types text in cardback");
//		VerificationHandler.verifyTrue(nclexPrepTabPage.verifyCardBackIndividualModuleText(2),
//				"Unable to verify Next Generation NCLEX Item Type Quizzes text in cardback");
		// Step 5
//		log(logger, "Verifying Advertisement Section in Cardback");
//		VerificationHandler.verifyTrue(nclexPrepTabPage.verifyCardBackAdvertisementSection(), "Unable to verify Advertisement Section in Cardback");
		
		logger.info("NewATI1072_VerifyNCLEXCardBack End");
		log(logger, "NewATI1072_VerifyNCLEXCardBack End");
	}

	/**
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-1073")
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {"Regression" }, description = "Verify NCLEX Experience Content Area Tag")
	public void NewAT1073_VerifyNCLEXContentArea() throws Exception {
		log(logger, "NewAT1073_VerifyNCLEXContentArea Start");
		
		logger.info("NewAT1073_VerifyNCLEXContentArea Start");
		
		// Step 1 & 2
		log(logger, "NewATI1063_VerifyNCLEXCardFront Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.nclex.login.username"),
				PropertiesRepository.getString("newati.nclex.login.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verify if Add Product Link is displayed in Home page");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("newati.home.page.add.product.link.loc"));

		// Step 3
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);

		log(logger, "Verify if Content Area drop down is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("new-atitesting.content.area.dropdown"));
		
		// Step 3
		log(logger, "Clicking NCLEXPREP Tab");
		homePage.clickSubTab(4);

		// Step 4
		log(logger, "Selecting 'NCLEX' Option from Content Area");
		tutorialPage.selectValueBySelectClass(
				PropertiesRepository.getString("new-atitesting.content.area.dropdown.loc"),
				PropertiesRepository.getString("new-atitesting.content.area.value.nclex"));
		
		// Step 4
		log(logger, "Verifying Nclex RN Live Review producs should up in NCLEX tab");
		VerificationHandler.verifyTrue(nclexPrepTabPage.VerifyIfNCLEXRNLiveTutorialNewDisplayed(
				PropertiesRepository.getString("new.atitestig.nclex.cardfront.product.name")));
		
		// Step 4
		log(logger, "Getting Module number from Card Front");
		VerificationHandler.verifyEquals(nclexPrepTabPage.getModuleCount(PropertiesRepository.getString("new.atitestig.nclex.cardfront.product.name")),
				PropertiesRepository.getString("new.atitestig.nclex.cardfront.module.count"), "Unable to verify Module count for NCLEX");
		
		// Step 4
		log(logger, "Clicking on NCLEX Cardback");
		tutorialPage.clickOnNCLEXModuleButton(PropertiesRepository.getString("new.atitestig.nclex.cardfront.product.name"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		// Step 4
		log(logger, "Verifying OverviewView Videos text in cardback");
		VerificationHandler.verifyTrue(nclexPrepTabPage.verifyCardBackIndividualModuleText(0),
				"Unable to Verify OverviewView Videos text in cardback");
		// Step 4
		log(logger, "Verifying Next Generation NCLEX Item Type Videos text in cardback");
		VerificationHandler.verifyTrue(nclexPrepTabPage.verifyCardBackIndividualModuleText(1),
				"Unable to Verify Next Generation NCLEX Item Type Videos text in cardback");
		// Step 4
		log(logger, "Verifying Next Generation NCLEX Item Type Quizzes text in cardback");
		VerificationHandler.verifyTrue(nclexPrepTabPage.verifyCardBackIndividualModuleText(2),
				"Unable to verify Next Generation NCLEX Item Type Quizzes text in cardback");
		// Step 5
//		log(logger, "Verifying Advertisement Section in Cardback");
//		VerificationHandler.verifyTrue(nclexPrepTabPage.verifyCardBackAdvertisementSection(), "Unable to verify Advertisement Section in Cardback");
		
		// Step 4
		log(logger, "Verifying Card back header section");
		VerificationHandler.verifyTrue(
				nclexPrepTabPage.verifyCardBackHeaderSection(
						PropertiesRepository.getString("new.atitestig.nclex.cardfront.product.with.module.count")),
				"Unable to Verify Card back header section");
		
		// Step 4
		log(logger, "Clicking on Cardback Close button");
		nclexPrepTabPage.clickButton(PropertiesRepository.getString("new-atitesting.nclex.card.back.close.button.loc"));
		
		// Step 4
		log(logger, "Selecting 'Study and Testing Skills' Option from Content Area");
		tutorialPage.selectValueBySelectClass(
				PropertiesRepository.getString("new-atitesting.content.area.dropdown.loc"),
				PropertiesRepository.getString("new-atitesting.content.area.value.study.and.teting.skills"));
		
		// Step 4
		log(logger, "Verifying Nclex RN Live Review producs should up in NCLEX tab");
		VerificationHandler.verifyTrue(nclexPrepTabPage.VerifyIfNCLEXRNLiveTutorialNewDisplayed(
				PropertiesRepository.getString("new.atitestig.nclex.cardfront.product.name")));
		
		// Step 4
		log(logger, "Getting Module number from Card Front");
		VerificationHandler.verifyEquals(nclexPrepTabPage.getModuleCount(PropertiesRepository.getString("new.atitestig.nclex.cardfront.product.name")),
				PropertiesRepository.getString("new.atitestig.nclex.cardfront.module.count"), "Unable to verify Module count for NCLEX");
		
		// Step 4
		log(logger, "Clicking on NCLEX Cardback");
		tutorialPage.clickOnNCLEXModuleButton(PropertiesRepository.getString("new.atitestig.nclex.cardfront.product.name"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		// Step 4
		log(logger, "Verifying Card back header section");
		VerificationHandler.verifyTrue(
				nclexPrepTabPage.verifyCardBackHeaderSection(
						PropertiesRepository.getString("new.atitestig.nclex.cardfront.product.with.module.count")),
				"Unable to Verify Card back header section");
		
		// Step 4
		log(logger, "Verifying OverviewView Videos text in cardback");
		VerificationHandler.verifyTrue(nclexPrepTabPage.verifyCardBackIndividualModuleText(0),
				"Unable to Verify OverviewView Videos text in cardback");
		// Step 4
		log(logger, "Verifying Next Generation NCLEX Item Type Videos text in cardback");
		VerificationHandler.verifyTrue(nclexPrepTabPage.verifyCardBackIndividualModuleText(1),
				"Unable to Verify Next Generation NCLEX Item Type Videos text in cardback");
		// Step 4
		log(logger, "Verifying Next Generation NCLEX Item Type Quizzes text in cardback");
		VerificationHandler.verifyTrue(nclexPrepTabPage.verifyCardBackIndividualModuleText(2),
				"Unable to verify Next Generation NCLEX Item Type Quizzes text in cardback");
		// Step 5
		log(logger, "Verifying Advertisement Section in Cardback");
//		VerificationHandler.verifyTrue(nclexPrepTabPage.verifyCardBackAdvertisementSection(), "Unable to verify Advertisement Section in Cardback");
		
		log(logger, "NewAT1073_VerifyNCLEXContentArea End");
		logger.info("NewAT1073_VerifyNCLEXContentArea End");
	}
	
	/**
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-1074")
	@Test(priority = 4, alwaysRun = true, enabled = true, groups = {"Regression" }, description = "Verify NCLEX Experience buy now button functionality from the card back")
	public void NewATI1074_VerifyNCLEXCardBackBuyButton() throws Exception {
		log(logger, "NewATI1074_VerifyNCLEXCardBackBuyButton Start");
		
		logger.info("NewATI1074_VerifyNCLEXCardBackBuyButton Start");
		
		// Step 1 & 2
		log(logger, "NewATI1063_VerifyNCLEXCardFront Start");
		loginPage.loginToApplication("stagebuynow","Test123");
		//loginPage.loginToApplication(PropertiesRepository.getString("newati.nclex.login.username"),
				//PropertiesRepository.getString("newati.nclex.login.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verify if Add Product Link is displayed in Home page");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("newati.home.page.add.product.link.loc"));

		// Step 3
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);

		log(logger, "Verify if Content Area drop down is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("new-atitesting.content.area.dropdown"));
		// Step 3
		log(logger, "Clicking NCLEXPREP Tab");
		homePage.clickSubTab(4);

		// Step 3
		log(logger, "Verifying Nclex RN Live Review producs should up in NCLEX tab");
		VerificationHandler.verifyTrue(nclexPrepTabPage.VerifyIfNCLEXRNLiveTutorialNewDisplayed(
				PropertiesRepository.getString("new.atitestig.nclex.cardfront.product.name")));

		// Step 3
		log(logger, "Clicking on NCLEX Cardback");
		tutorialPage.clickOnNCLEXModuleButton(PropertiesRepository.getString("new.atitestig.nclex.cardfront.product.name"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		// Step 3
		log(logger, "Verifying Card back header section");
		VerificationHandler.verifyTrue(
				nclexPrepTabPage.verifyCardBackHeaderSection(
						PropertiesRepository.getString("new.atitestig.nclex.cardfront.product.with.module.count")),
				"Unable to Verify Card back header section");
		
		// Step 4
		log(logger, "Clicking on Experience Buy Button");
		VerificationHandler.verifyTrue(nclexPrepTabPage.clickExpBuyButton(),"Unable to Click on Experience Buy Button");
		
		// Step 5
		log(logger, "Verifying URL");
		VerificationHandler.verifyTrue(nclexPrepTabPage.verifyOnlinStoreURL(), "Unable to verify URL");
		
		
		logger.info("NewATI1074_VerifyNCLEXCardBackBuyButton End");
		log(logger, "NewATI1074_VerifyNCLEXCardBackBuyButton End");
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
		
		log(logger, "Clicking NCLEXPREP Tab");
		homePage.clickSubTab(4);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Verifying Nclex RN Live Review producs should up in NCLEX tab");
		VerificationHandler.verifyTrue(nclexPrepTabPage.VerifyIfNCLEXRNLiveTutorialNewDisplayed(
				PropertiesRepository.getString("new.atitestig.nclex.cardfront.product.name")));
		
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
	
	/**
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-1093")
	@Test(priority = 6, alwaysRun = true, enabled = true, groups = {"Regression" }, description = "Verify NCLEX Experience Enable/Disable Modules.")
	public void NewATI1093_VerifyNCLEXEnableDisableModule() throws Exception {
		log(logger, "NewATI1093_VerifyNCLEXEnableDisableModule Start");
		logger.info("NewATI1093_VerifyNCLEXEnableDisableModule Start");
		
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
		
		log(logger, "Clicking NCLEXPREP Tab");
		homePage.clickSubTab(4);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying Nclex RN Live Review producs should up in NCLEX tab");
		VerificationHandler.verifyTrue(nclexPrepTabPage.VerifyIfNCLEXRNLiveTutorialNewDisplayed(
				PropertiesRepository.getString("new.atitestig.nclex.cardfront.product.name")));
		
		log(logger, "Clicking on NCLEX Cardback");
		tutorialPage.clickOnNCLEXModuleButton(PropertiesRepository.getString("new.atitestig.nclex.cardfront.product.name"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Verifying Card back header section");
		VerificationHandler.verifyTrue(
				nclexPrepTabPage.verifyCardBackHeaderSection(
						PropertiesRepository.getString("new.atitestig.nclex.cardfront.product.with.module.count")),
				"Unable to Verify Card back header section");
		
		log(logger, "Verifying disabled module in card back");
		VerificationHandler.verifyFalse(
		nclexPrepTabPage.verifyDisabledModules("Overview Videos"), "Unable to verify disabled module");
		
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
		
		log(logger, "Verify on NCLEX Access Modules and click on Expand Button");
		int index = facultyPortalPage.clickAndExpandAccessModulesSection(PropertiesRepository.getString("new.atitestig.nclex.cardfront.product.name"));
		
		log(logger, "Clicking on Enable/ Disable Button");
		VerificationHandler.verifyTrue(facultyPortalPage.clickOnEnableDisableImg(index, 6), "Unable to Clicking on Preview Button");
		
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
		
		log(logger, "Verifying Nclex RN Live Review producs should up in NCLEX tab");
		VerificationHandler.verifyTrue(nclexPrepTabPage.VerifyIfNCLEXRNLiveTutorialNewDisplayed(
				PropertiesRepository.getString("new.atitestig.nclex.cardfront.product.name")));
		
		log(logger, "Clicking on NCLEX Cardback");
		tutorialPage.clickOnNCLEXModuleButton(PropertiesRepository.getString("new.atitestig.nclex.cardfront.product.name"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Verifying Card back header section");
		VerificationHandler.verifyTrue(
				nclexPrepTabPage.verifyCardBackHeaderSection(
						PropertiesRepository.getString("new.atitestig.nclex.cardfront.product.with.module.count")),
				"Unable to Verify Card back header section");
		
		log(logger, "Verifying hidden modules in card back");
		nclexPrepTabPage.verifyHiddenCheckBoxMessageAndClickInCardBack();
		Thread.sleep(2000);
		log(logger, "Verifying disabled module in card back");
		VerificationHandler.verifyTrue(
		nclexPrepTabPage.verifyDisabledModules("Overview Videos"), "Unable to verify Disabled modules in card back");
		
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
		
		log(logger, "Verify on NCLEX Access Modules and click on Expand Button");
		int indexAfter = facultyPortalPage.clickAndExpandAccessModulesSection(PropertiesRepository.getString("new.atitestig.nclex.cardfront.product.name"));
		
		log(logger, "Clicking on Enable/ Disable Button");
		VerificationHandler.verifyTrue(facultyPortalPage.clickOnEnableDisableImg(indexAfter, 6), "Unable to Clicking on Preview Button");
		
		log(logger, "Clicking on Save Changes button");
		VerificationHandler.verifyTrue(
		facultyPortalPage.verifyAndClickWithSwitchToCardShadowFrame(PropertiesRepository.getString("id.portal.product.tutorial.save.changes.button.loc"), true), 
		"Unable to click on Save Changes button");
		facultyPortalPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		logger.info("NewATI1093_VerifyNCLEXEnableDisableModule End");
		log(logger, "NewATI1093_VerifyNCLEXEnableDisableModule End");
	}
	
	@TestAnnotations(testID = "NewATI-1095")
	@Test(priority = 7, alwaysRun = true, enabled = true, groups = {"Regression" }, description = "Verify NCLEX Experience Downloaded report Functionality")
	public void NewATI1095_VerifyNCLEXReportDownloadReportFunctionality() throws Exception {
		log(logger, "NewATI1095_VerifyNCLEXReportDownloadReportFunctionality Start");
		logger.info("NewATI1095_VerifyNCLEXReportDownloadReportFunctionality Start");
		//step-1
		loginPage.loginToApplication(PropertiesRepository.getString("newati.nclex.login.username"),
				PropertiesRepository.getString("newati.nclex.login.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	
		log(logger, "Clicking NCLEXPREP Tab");				
		homePage.clickSubTab(4);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "verifying NCLEX Experience product shown up in NCLEX Tab");
		VerificationHandler.verifyTrue(nclexPrepTabPage.VerifyIfNCLEXRNLiveTutorialNewDisplayed(
				PropertiesRepository.getString("new.atitestig.nclex.cardfront.product.name")));

		log(logger,"clicking Module by name");
		tutorialPage.clickOnNCLEXModuleButton(PropertiesRepository.getString("new.atitestig.nclex.cardfront.product.name"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		//step-2
		log(logger, "clicking on My Results Tab");
		homePage.clickTab(2);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		//step-3
		log(logger, "verify Download Report under myResults page");
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("newati.myresults.download.report.button"), "Download Report is not displyed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		//step-4
		log(logger, "Clicking on Download report");
		tutorialPage.clickButton(PropertiesRepository.getString("newati.myresults.download.report.button"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		//step-5 cannot automate as verifying Download Report is not possible
		logger.info("NewATI1095_VerifyNCLEXReportDownloadReportFunctionality End");
		log(logger, "NewATI1095_VerifyNCLEXReportDownloadReportFunctionality End");
		
	}
	
	@TestAnnotations(testID="NewATI-1082")
	@Test(priority = 8, alwaysRun = true, enabled = true, groups = {"Regression" }, description = "Verify NCLEX Experience Individual Performance Profile for Videos")
	public void NewATI1082_VerifyNCLEXIPPforVideos() throws Exception {
		log(logger, "NewATI1082_VerifyNCLEXIPPforVideos Start");
		logger.info("NewATI1082_VerifyNCLEXIPPforVideos Start");
		//step-1
		loginPage.loginToApplication(PropertiesRepository.getString("newati.nclex.login.username"),
				PropertiesRepository.getString("newati.nclex.login.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		//step-2
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	
		log(logger, "Verify if Content Area drop down is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("new-atitesting.content.area.dropdown"));
		
		log(logger, "Clicking NCLEXPREP Tab");				
		homePage.clickSubTab(4);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "verifying NCLEX Experience product shown up in NCLEX Tab");
		VerificationHandler.verifyTrue(nclexPrepTabPage.VerifyIfNCLEXRNLiveTutorialNewDisplayed(
				PropertiesRepository.getString("new.atitestig.nclex.cardfront.product.name")));

		log(logger,"clicking Module by name");
		tutorialPage.clickOnNCLEXModuleButton(PropertiesRepository.getString("new.atitestig.nclex.cardfront.product.name"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		//step-3
		log(logger, "clicking on My Results Tab");
		homePage.clickTab(2);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		//step-4
		log(logger, "Clicking on Completed Accessed Module video");
		tutorialPage.clickNCLEXModuleReuslt("Lesson");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		//step-5
		log(logger, "verify logo in IPP Page");
		VerificationHandler.verifyTrue(tutorialPage.verifyAssessmentLogo(), "unable to verify logo");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(myReportPage.verifyIPPPageHeader(),"Verifying IPP Page Header");
		
		log(logger, "verify Download Report");
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("newati.ipp.page.download.report"),"Download report is not available");
		
		log(logger,"click on download Report");
		tutorialPage.clickButton(PropertiesRepository.getString("newati.ipp.page.download.report"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		logger.info("NewATI1082_VerifyNCLEXIPPforVideos Ends");
		log(logger, "NewATI1082_VerifyNCLEXIPPforVideos Ends");
	}
}
