package com.automation.id.reports;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.id.pages.AnalyticsLandingPgae;
import com.automation.id.pages.DataExtractPage;
import com.automation.id.pages.FocusedReviewPage;
import com.automation.id.pages.HomePage;
import com.automation.id.pages.LoginPage;
import com.automation.id.pages.QuickReportPage;
import com.automation.id.pages.ReportWizardPage;
import com.jaca.TestAnnotations;

public class ReportTest1 extends BaseTest {

	Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private QuickReportPage quickReportPage;
	private FocusedReviewPage focusedReviewPage;
	private HomePage homePage;
	private AnalyticsLandingPgae analyticsLandingPgae;
	private DataExtractPage dataExtractPage;
	private ReportWizardPage reportWizardPage;

	@BeforeMethod(alwaysRun = true)
	public void verifyHomePage() throws Exception {
		loginPage = new LoginPage(driver);
		analyticsLandingPgae = new AnalyticsLandingPgae(driver);
		homePage = new HomePage(driver);
		dataExtractPage = new DataExtractPage(driver);
		quickReportPage = new QuickReportPage(driver);
		focusedReviewPage = new FocusedReviewPage(driver);
		reportWizardPage = new ReportWizardPage(driver);
		loginPage = new LoginPage(driver);
	}

	@TestAnnotations(testID = "inst-1612")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {
			"Smoke" }, description = "INST1612 ::Verify individual reports are generated")
	public void INST1612_VerifyIndividualAssessmentReport() throws Exception {
		logger.info("INST1612_VerifyIndividualAssessmentReport Start");

		log(logger, "Login to application");
		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.rpt.instuctor1.username"),
				PropertiesRepository.getString("id.auto.rpt.instuctor1.password"));
		
		/*loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "click on close button");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.home.page.alert.close"), 0);*/

		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true), "Unable to click left navigation");

		//Step 1
		log(logger, "click on Analytics tab");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "trending_up", true), "Unable to verify Analytics Link");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying Classic Report Portlet in Analytics Home page");
		VerificationHandler.verifyTrue(analyticsLandingPgae.verifyAnalyticsReportingHomePage(
				PropertiesRepository.getString("id.analytics.reports.home.page.report.portlet.name")), "Unable to verify Classis Reporting Portlet in Analytics Home Page");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "enter assessment id in individual text field of quick report");
		VerificationHandler.verifyTrue(quickReportPage.generateResultQuickReportIndividualReport(PropertiesRepository.getString("individual.report.batch.id")), "Unable to enter assessment id in individual text field of quick report");

		logger.info("INST1612_VerifyIndividualAssessmentReport End");
	}

	/**
	 * @author syed.hoque
	 */
	@TestAnnotations(testID = "inst-1680")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {
			"Smoke" }, description = "INST:1680-Verify building 'Group Reports' for Students from an existing Custom Group")
	public void INST1680_VerifyReportWizardCustomeGroupReport() throws Exception {
		logger.info("INST1680_VerifyReportWizardCustomeGroupReport Start");

		log(logger, "Login to application");
		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.rpt.instuctor1.username"),
				PropertiesRepository.getString("id.auto.rpt.instuctor1.password"));
		
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true), "Unable to click left navigation");

		//Step 1
		log(logger, "click on Analytics tab");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "trending_up", true), "Unable to verify Analytics Link");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying Classic Report Portlet in Analytics Home page");
		VerificationHandler.verifyTrue(analyticsLandingPgae.verifyAnalyticsReportingHomePage(
				PropertiesRepository.getString("id.analytics.reports.home.page.report.portlet.name")), "Unable to verify Classis Reporting Portlet in Analytics Home Page");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying Classic Reporting Home Page");
		VerificationHandler.verifyTrue(analyticsLandingPgae.verifyMessage("id.analytics.reports.classic.reporting.home.page.loc", 0, PropertiesRepository.getString("id.analytics.reports.home.page.report.portlet.name")), "Unable to verify Classic Reporting Home Page");

		log(logger, "click on report wizard tab");
		quickReportPage.clickOnReportWizardTab();

		log(logger, "click on build button for group report");
		reportWizardPage.clikOnBuildBtnForGroupReport();

		log(logger, "Select the radio button 'a Custom Group of Students");
		reportWizardPage.selectCustomeGroupOfStudent();

		log(logger, "verify that create new group button is present");
		VerificationHandler.verifyTrue(reportWizardPage.verifyCreateNewGrpButton());

		log(logger, "Select one group from custome group list");
		reportWizardPage.clickOnCutomGroupRadioBtnFromTable();

		log(logger, "verify that proctor and prcatice assessment tab are displaying");
		VerificationHandler.verifyTrue(reportWizardPage.verifygroupReportProctorPracticeTab(), "Unable to verify that proctor and prcatice assessment tab are displaying");

		log(logger, "click on one assessment pool name");
		VerificationHandler.verifyTrue(reportWizardPage.clickOnAssessmentPool(), "Unable to verify Generate PDF button");

		// saravanan will see log
		log(logger, "click on data extract btn");
		reportWizardPage.scrollUp();

		logger.info("INST1680_VerifyReportWizardCustomeGroupReport End");
	}

	@TestAnnotations(testID = "inst-1912")
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {
			"Smoke" }, description = "inst-1912:Verify ATI Pulse & Student Engagement Tile on faculty top of the page")
	public void INST1912_VerifyATIpulseTile() throws Exception {
		logger.info("INST1912_VerifyATIpulseTile Start");

		log(logger, "Login to application");
		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.rpt.instuctor3.username"),
				PropertiesRepository.getString("id.auto.rpt.instuctor3.password"));

		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "click on close button");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.home.page.alert.close"), 0);

		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true), "Unable to click left navigation");

		//Step 1
		log(logger, "click on Analytics tab");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "trending_up", true), "Unable to verify Analytics Link");

		
		log(logger, "Verify ATI pulse card is present");
		VerificationHandler.verifyTrue(analyticsLandingPgae.verifyReportingTileText(
				PropertiesRepository.getString("analytics.landing.page.tile"), 0,
				"ATI Pulse (TM)™& Student Engagement"));

		log(logger, "Verify pulse content text on the tile");
		VerificationHandler.verifyTrue(analyticsLandingPgae.verifyReportingTileText(
				PropertiesRepository.getString("analytics.landing.card.description.text"), 0,
				"Designed to give you student and cohort level NCLEX success predictions and product usage analytics."));

		logger.info("INST1912_VerifyATIpulseTile End");
	}

	@TestAnnotations(testID = "inst-1856")
	@Test(priority = 4, alwaysRun = true, enabled = true, groups = {
			"Smoke" }, description = "inst-1856:Verify new analytics landing page")
	public void INST1856_VerifyNewAnalyticsLandingPage() throws Exception {
		logger.info("INST1856_VerifyNewAnalyticsLandingPage Start");

		log(logger, "Login to application");
		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.rpt.instuctor1.username"),
				PropertiesRepository.getString("id.auto.rpt.instuctor1.password"));

		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "click on close button");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.home.page.alert.close"), 0);

		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true), "Unable to click left navigation");

		//Step 1
		log(logger, "click on Analytics tab");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "trending_up", true), "Unable to verify Analytics Link");

		log(logger, "Verifying Classic Report Portlet in Analytics Home page");
		VerificationHandler.verifyTrue(analyticsLandingPgae.verifyAnalyticsReportingHomePage(
				PropertiesRepository.getString("id.analytics.reports.home.page.report.portlet.name")), "Unable to verify Classis Reporting Portlet in Analytics Home Page");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "verify url");
		VerificationHandler
				.verifyTrue(analyticsLandingPgae.verifyAnalyticsUrl(PropertiesRepository.getString("analytics.url")));

		logger.info("INST1856_VerifyNewAnalyticsLandingPage End");
	}

	@TestAnnotations(testID = "inst-1846")
	@Test(priority = 5, alwaysRun = true, enabled = true, groups = {
			"Smoke" }, description = "inst-1846 :Verify that Faculty can build 'Critical Thinking Analysis Report' for one or more students.")
	public void INST1846_VerifyCriticalThinkingAnalysisReport() throws Exception {
		logger.info("INST1846_VerifyCriticalThinkingAnalysisReport Start");

		log(logger, "Login to application");
		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.rpt.instuctor1.username"),
				PropertiesRepository.getString("id.auto.rpt.instuctor1.password"));

		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true), "Unable to click left navigation");

		//Step 1
		log(logger, "click on Analytics tab");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "trending_up", true), "Unable to verify Analytics Link");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying Classic Report Portlet in Analytics Home page");
		VerificationHandler.verifyTrue(analyticsLandingPgae.verifyAnalyticsReportingHomePage(
				PropertiesRepository.getString("id.analytics.reports.home.page.report.portlet.name")), "Unable to verify Classis Reporting Portlet in Analytics Home Page");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying Classic Reporting Home Page");
		VerificationHandler.verifyTrue(analyticsLandingPgae.verifyMessage("id.analytics.reports.classic.reporting.home.page.loc", 0, PropertiesRepository.getString("id.analytics.reports.home.page.report.portlet.name")), "Unable to verify Classic Reporting Home Page");
		
		log(logger, "click on Report wizard tab");
		reportWizardPage.clickOnReportWizardTab();

		log(logger, "click on build button for critical thinking report");
		VerificationHandler.verifyTrue(reportWizardPage.clikOnBuildBtnForCriticalThinkingReport(), "Unable to build button for critical thinking report");

		log(logger, "select one or more student check box and continue");
		VerificationHandler.verifyTrue(reportWizardPage.selectOneOrMoreStudentRadioBtn(), "Unable to select one or more student check box and continue");

		log(logger, "select student from student table and click on continue btn");
		VerificationHandler.verifyTrue(reportWizardPage.selectStudentFormTable(), "Unable to select student from student table and click on continue btn");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "click on as a group print btn");
		VerificationHandler.verifyTrue(reportWizardPage.clickAsGroupPrintBtn(), "Unable to click on as a group print btn");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "click on data extact option");
		VerificationHandler.verifyTrue(reportWizardPage.clickOnDataExtractBtnFroCritical(), "Unable to click on data extact option");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "click on csv and xml btn");
		VerificationHandler.verifyTrue(reportWizardPage.clickCsvXmlBtn(), "Unable to click on csv and xml btn");

		logger.info("INST1846_VerifyCriticalThinkingAnalysisReport End");
	}

	@TestAnnotations(testID = "inst-1848")
	@Test(priority = 6, alwaysRun = true, enabled = true, groups = {
			"Smoke" }, description = "inst-1848 Verify that Faculty can build 'Individual Transcript Report' for one or more students.")
	public void INST1848_VerifyIndividualReport() throws Exception {
		logger.info("INST1848_VerifyIndividualReport Start");

		log(logger, "Login to application");
		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.rpt.instuctor1.username"),
				PropertiesRepository.getString("id.auto.rpt.instuctor1.password"));

		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true), "Unable to click left navigation");

		//Step 1
		log(logger, "click on Analytics tab");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "trending_up", true), "Unable to verify Analytics Link");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying Classic Report Portlet in Analytics Home page");
		VerificationHandler.verifyTrue(analyticsLandingPgae.verifyAnalyticsReportingHomePage(
				PropertiesRepository.getString("id.analytics.reports.home.page.report.portlet.name")), "Unable to verify Classis Reporting Portlet in Analytics Home Page");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying Classic Reporting Home Page");
		VerificationHandler.verifyTrue(analyticsLandingPgae.verifyMessage("id.analytics.reports.classic.reporting.home.page.loc", 0, PropertiesRepository.getString("id.analytics.reports.home.page.report.portlet.name")), "Unable to verify Classic Reporting Home Page");
		
		log(logger, "click on Report wizard tab");
		reportWizardPage.clickOnReportWizardTab();
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "click on build button for critical thinking report");
		reportWizardPage.clickOnIndividualReportbtn();

		log(logger, "select one or more student check box and continue");
		reportWizardPage.selectOneOrMoreStudentRadioBtnIndividual();

		log(logger, "select student from student table and click on continue btn");
		VerificationHandler.verifyTrue(reportWizardPage.selectStudentFormTable(), "Unable to select student from student table and click on continue btn");

		log(logger, "select a assessement from valid assessment table to select assessment table");
		VerificationHandler.verifyTrue(reportWizardPage.selectAssessmentFromValidAssessmentTable(), "Unable to select a assessement from valid assessment table to select assessment table");

		log(logger, "click on continue btn form configure the reports page");
		// reportWizardPage.clickOncontinueBtnFromConfigureReportPage();
		VerificationHandler.verifyTrue(reportWizardPage.clickOnElementInFrame("reportwizrd.valid.assessment.ctn1"), "Unable to click on continue btn form configure the reports page");

		log(logger, "click on print individual reprot btn");
		// reportWizardPage.clickOnIndividualReportPrintBtn();
		VerificationHandler.verifyTrue(reportWizardPage.clickOnElementInFrame("reportwizard.printindividual.btn"), "Unable to click on print individual reprot btn");

		log(logger, "click on data extract btn");
		// reportWizardPage.clikOnIndividualReportdataExtract();
		VerificationHandler.verifyTrue(reportWizardPage.clickOnElementInFrame("reportwizard.dataextract.option"), "Unable to click on data extract btn");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "click on csv and xml btn");
		VerificationHandler.verifyTrue(reportWizardPage.clickCsvXmlBtn(), "Unable to click on csv and xml btn");

		logger.info("INST1848_VerifyIndividualReport End");
	}

	@TestAnnotations(testID = "inst-1673")
	@Test(priority = 7, alwaysRun = true, enabled = true, groups = {
			"Smoke" }, description = "inst-1673:Verify Assessment results in the Data Extract of student list results")
	public void INST1673_VerifyAssessmentResultOfDataExtract() throws Exception {
		logger.info("INST1673_VerifyAssessmentResultOfDataExtract Start");

		log(logger, "Login to application");
		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.rpt.instuctor1.username"),
				PropertiesRepository.getString("id.auto.rpt.instuctor1.password"));
		
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true), "Unable to click left navigation");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		//Step 1
		log(logger, "click on Analytics tab");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "trending_up", true), "Unable to verify Analytics Link");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying Classic Report Portlet in Analytics Home page");
		VerificationHandler.verifyTrue(analyticsLandingPgae.verifyAnalyticsReportingHomePage(
				PropertiesRepository.getString("id.analytics.reports.home.page.report.portlet.name")), "Unable to verify Classis Reporting Portlet in Analytics Home Page");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying Classic Reporting Home Page");
		VerificationHandler.verifyTrue(analyticsLandingPgae.verifyMessage("id.analytics.reports.classic.reporting.home.page.loc", 0, PropertiesRepository.getString("id.analytics.reports.home.page.report.portlet.name")), "Unable to verify Classic Reporting Home Page");
		
		log(logger, "click on data extract tab");
		VerificationHandler.verifyTrue(quickReportPage.clicOnDataExtractTab(), "Unable to click on data extract tab");

		log(logger, "select student from custome result");
		VerificationHandler.verifyTrue(dataExtractPage.selectStudentFromStudentList(), "Unable to select student from custome result");

		log(logger, "click on a assessment from valid assessment table");
		VerificationHandler.verifyTrue(dataExtractPage.clikOnValidAssessment(), "Unable to click on a assessment from valid assessment table");

		log(logger, "clik on generate extract btn");
		VerificationHandler.verifyTrue(dataExtractPage.clickOnGenerateExtractBtn(), "Unable to clik on generate extract btn");

		log(logger, "Verify that results are displaying");
		VerificationHandler.verifyTrue(dataExtractPage.verifyUserData(PropertiesRepository.getString("id.report.1673.data.value")));

		logger.info("INST1673_VerifyAssessmentResultOfDataExtract End");
	}

	@TestAnnotations(testID = "inst-1886")
	@Test(priority = 8, alwaysRun = true, enabled = true, groups = {
			"Smoke" }, description = "inst-1886:Varifying For focused review for assessment is preasent in list.")
	public void INST1886_VerifyFocusedReview() throws Exception {
		logger.info("INST1886_VerifyFocusedReview Start");

		log(logger, "Login to application");
		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.rpt.instuctor1.username"),
				PropertiesRepository.getString("id.auto.rpt.instuctor1.password"));
		
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true), "Unable to click left navigation");

		//Step 1
		log(logger, "click on Analytics tab");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "trending_up", true), "Unable to verify Analytics Link");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying Classic Report Portlet in Analytics Home page");
		VerificationHandler.verifyTrue(analyticsLandingPgae.verifyAnalyticsReportingHomePage(
				PropertiesRepository.getString("id.analytics.reports.home.page.report.portlet.name")), "Unable to verify Classis Reporting Portlet in Analytics Home Page");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying Classic Reporting Home Page");
		VerificationHandler.verifyTrue(analyticsLandingPgae.verifyMessage("id.analytics.reports.classic.reporting.home.page.loc", 0, PropertiesRepository.getString("id.analytics.reports.home.page.report.portlet.name")), "Unable to verify Classic Reporting Home Page");

		log(logger, "click on focused review tab");
		VerificationHandler.verifyTrue(quickReportPage.clickOnFocusedReviewTab(), "Unable to click on focused review tab ");

/*		log(logger, "click on pagination no");
		focusedReviewPage.clickOnPagination(1);*/

		log(logger, "send focused review creator name");
		focusedReviewPage.sendCreatorName(PropertiesRepository.getString("id.faculty.1886.value"));

		log(logger, "Verify paginaton");
		VerificationHandler.verifyTrue(focusedReviewPage.verifyPagiantion());

		log(logger, "click on any assessment for focused review");
		focusedReviewPage.clickAssessmentForFocusedReview();

		logger.info("INST1886_VerifyFocusedReview End");
	}

	@TestAnnotations(testID = "inst-1855")
	@Test(priority = 9, alwaysRun = true, enabled = true, groups = {
			"Smoke" }, description = "inst-1855:Verify ALP > Classic Reporting Tile")
	public void INST1855_VerifyClassicReportingTile() throws Exception {
		logger.info("INST1855_VerifyClassicReportingTile Start");

		log(logger, "Login to application");
		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.rpt.instuctor1.username"),
				PropertiesRepository.getString("id.auto.rpt.instuctor1.password"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true), "Unable to click left navigation");

		//Step 1
		log(logger, "click on Analytics tab");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "trending_up", true), "Unable to verify Analytics Link");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying Classic Report Portlet in Analytics Home page");
		VerificationHandler.verifyTrue(analyticsLandingPgae.verifyAnalyticsReportingHomePage(
				PropertiesRepository.getString("id.analytics.reports.home.page.report.portlet.name")), "Unable to verify Classis Reporting Portlet in Analytics Home Page");
		
		log(logger, "Click on classic reporting tile");
		analyticsLandingPgae.clickOncardTiles(2);
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying Classic Reporting Home Page");
		VerificationHandler.verifyTrue(analyticsLandingPgae.verifyMessage("id.analytics.reports.classic.reporting.home.page.loc", 0, PropertiesRepository.getString("id.analytics.reports.home.page.report.portlet.name")), "Unable to verify Classic Reporting Home Page");

		log(logger, "verify components of classic reporting page");
		boolean result = reportWizardPage.verifyClassicReportingPageContent();
		VerificationHandler.verifyTrue(result, "components are not present in classic reporting page");

		logger.info("INST1855_VerifyClassicReportingTile End");
	}

	@TestAnnotations(testID = "inst-2047")
	@Test(priority = 10, alwaysRun = true, enabled = true, groups = {"Smoke" }, description = " inst-1872 Verify TEAS Cut Score Tile.")
	public void INST2047_VerifyTeasCutScoreTiles() throws Exception {
		logger.info("INST2047_VerifyTeasCutScoreTiles Start");

		
		log(logger, "Login to application");
		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.faculty.username.report2.new"),
				PropertiesRepository.getString("id.login.faculty.password.report2.new"));
		
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "click on close button");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.home.page.alert.close"), 0);

		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true), "Unable to click left navigation");

		//Step 1
		log(logger, "click on Analytics tab");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "trending_up", true), "Unable to verify Analytics Link");

		log(logger, "Verify TEAS Cust Score tile");
		VerificationHandler.verifyTrue(analyticsLandingPgae.VerifyReportingTilesLink("TEAS® Cut Score Analysis Tool", 0), "Unable to verify TEAS Cut score");

		logger.info("INST2047_VerifyTeasCutScoreTiles End");
	}
}
