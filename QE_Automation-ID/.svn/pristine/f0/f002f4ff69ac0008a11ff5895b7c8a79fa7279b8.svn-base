package com.automation.id.oldtests;

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

public class ReportTest extends BaseTest {

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


	@TestAnnotations(testID = "inst-2047")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Smoke" }, description = " inst-2047: Verify TEAS Cut Score Tile.")
	public void INST2047_VerifyTeasCutScoreTiles() throws Exception {
		logger.info("INST2047_VerifyTeasCutScoreTiles Start");

		log(logger, "Login to application");
		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.rpt.opt.instuctor3.username"),
				PropertiesRepository.getString("id.auto.rpt.opt.instuctor3.password"));
		
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "click on close button");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.home.page.alert.close"), 0);

		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true), "Unable to click left navigation");

		log(logger, "click on Analytics tab");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "trending_up", true), "Unable to verify Analytics Link");
		
		log(logger, "Verifying URL Start");
		//INST1856_VerifyNewAnalyticsLandingPage
		log(logger, "Verifying Classic Report Portlet in Analytics Home page");
		VerificationHandler.verifyTrue(analyticsLandingPgae.verifyAnalyticsReportingHomePage(
				PropertiesRepository.getString("id.analytics.reports.home.page.report.portlet.name")), "Unable to verify Classis Reporting Portlet in Analytics Home Page");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "verify url");
		VerificationHandler
				.verifyTrue(analyticsLandingPgae.verifyAnalyticsUrl(PropertiesRepository.getString("analytics.url")));
		
		log(logger, "Clicking on Analytics Link");
		reportWizardPage.verifyAndClick(PropertiesRepository.getString("id.analytics.report.analytisc.link.loc"), true);
		
		log(logger, "Verifying URL End");
		
		log(logger, "TEAS Cust Score tile start");
		//INST2047_VerifyTeasCutScoreTiles
		log(logger, "Verifying Reporting Page Header");
		VerificationHandler.verifyTrue(
				reportWizardPage.verifyMessage("id.analytics.report.reporting.header.loc", 0,
						PropertiesRepository.getString("id.analytics.report.reporting.header.value")),
				"Unable to verify Reporting page header");

		log(logger, "Verify TEAS Cust Score tile");
		VerificationHandler.verifyTrue(analyticsLandingPgae.VerifyReportingTilesLink("TEAS® Cut Score Analysis Tool", 0), "Unable to verify TEAS Cut score");
		log(logger, "TEAS Cust Score tile End");
		
		log(logger, "Classic start");
		//INST1855_VerifyClassicReportingTile
		log(logger, "Verifying Classic Report Portlet in Analytics Home page");
		VerificationHandler.verifyTrue(analyticsLandingPgae.verifyAnalyticsReportingHomePage(
				PropertiesRepository.getString("id.analytics.reports.home.page.report.portlet.name")), "Unable to verify Classis Reporting Portlet in Analytics Home Page");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying Classic Reporting Home Page");
		VerificationHandler.verifyTrue(analyticsLandingPgae.verifyMessage("id.analytics.reports.classic.reporting.home.page.loc", 0, PropertiesRepository.getString("id.analytics.reports.home.page.report.portlet.name")), "Unable to verify Classic Reporting Home Page");

		log(logger, "verify components of classic reporting page");
		boolean result = reportWizardPage.verifyClassicReportingPageContent();
		VerificationHandler.verifyTrue(result, "components are not present in classic reporting page");
		
		log(logger, "Clicking on Analytics Link");
		reportWizardPage.verifyAndClick(PropertiesRepository.getString("id.analytics.report.analytisc.link.loc"), true);
		
		log(logger, "Classic End");
		
		log(logger, "ATI pulse start");
		//INST1912_VerifyATIpulseTile
		log(logger, "Verifying Reporting Page Header");
		VerificationHandler.verifyTrue(
				reportWizardPage.verifyMessage("id.analytics.report.reporting.header.loc", 0,
						PropertiesRepository.getString("id.analytics.report.reporting.header.value")),
				"Unable to verify Reporting page header");
		
		log(logger, "Verify ATI pulse card is present");
		VerificationHandler.verifyTrue(analyticsLandingPgae.verifyReportingTileText(
				PropertiesRepository.getString("analytics.landing.page.tile"), 0,
				"ATI Pulse (TM)™& Student Engagement"));

		log(logger, "Verify pulse content text on the tile");
		VerificationHandler.verifyTrue(analyticsLandingPgae.verifyReportingTileText(
				PropertiesRepository.getString("analytics.landing.card.description.text"), 0,
				"Designed to give you student and cohort level NCLEX success predictions and product usage analytics."));
		log(logger, "ATI pulse End");
		
		log(logger, "Verifying Beta Report Tile Start");
		//INST1915_VerifyBetaReportTiles
		
		/*log(logger, "Verify that Admission Tiles is displaying");
		VerificationHandler.verifyTrue(analyticsLandingPgae.VerifyReportingTextLink("Admissions (NEW)"),
				"Unable to verify Admission Tiles");

		log(logger, "click and verify admission page opened");
		VerificationHandler.verifyTrue(
				analyticsLandingPgae.clickAndSwitchtoNewwindow(
						PropertiesRepository.getString("id.analytic.betaTile.admissionLoc"),
						PropertiesRepository.getString("analytics.reporting.dashboardText"), 2),
				"admission link not opened");*/

		log(logger, "Verify that Tutorial Tiles is displaying");
		VerificationHandler.verifyTrue(analyticsLandingPgae.VerifyReportingTextLink("Tutorials"),
				"Unable to verify Tutorials Tiles");

		log(logger, "click and verify Tutorial page opened");
		analyticsLandingPgae.clickAndSwitchtoNewwindow(
				PropertiesRepository.getString("id.analytic.betaTile.TutLoc"),
				PropertiesRepository.getString("analytics.reporting.dashboardText"), 3);
		/*VerificationHandler.verifyTrue(
				analyticsLandingPgae.clickAndSwitchtoNewwindow(
						PropertiesRepository.getString("id.analytic.betaTile.TutLoc"),
						PropertiesRepository.getString("analytics.reporting.dashboardText"), 3),
				"Tutorial link not opened");*/

		log(logger, "Verify that Assessment Tiles is displaying");
		VerificationHandler.verifyTrue(analyticsLandingPgae.VerifyReportingTextLink("Assessments"),
				"Unable to verify Assessments Tiles");

		log(logger, "click and verify Assessmnet page opened");
		analyticsLandingPgae.clickAndSwitchtoNewwindow(
				PropertiesRepository.getString("id.analytic.betaTile.assessmentLoc"),
				PropertiesRepository.getString("analytics.reporting.dashboardText"), 4);
		/*VerificationHandler.verifyTrue(
				analyticsLandingPgae.clickAndSwitchtoNewwindow(
						PropertiesRepository.getString("id.analytic.betaTile.assessmentLoc"),
						PropertiesRepository.getString("analytics.reporting.dashboardText"), 4),
				"Assessmnet link not opened");*/

		log(logger, "Verify that Remediation Tiles is displaying");
		VerificationHandler.verifyTrue(analyticsLandingPgae.VerifyReportingTextLink("Remediation"),
				"Unable to verify Remediation Tiles");

		log(logger, "click and verify Remediation page opened");
		analyticsLandingPgae.clickAndSwitchtoNewwindow(
				PropertiesRepository.getString("id.analytic.betaTile.remediationLoc"),
				PropertiesRepository.getString("analytics.reporting.dashboardText"), 5);
		/*VerificationHandler.verifyTrue(
				analyticsLandingPgae.clickAndSwitchtoNewwindow(
						PropertiesRepository.getString("id.analytic.betaTile.remediationLoc"),
						PropertiesRepository.getString("analytics.reporting.dashboardText"), 5),
				"Remediation link not opened");*/
		log(logger, "Verifying Beta Report Tile End");
		logger.info("INST2047_VerifyTeasCutScoreTiles End");
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
	
	@TestAnnotations(testID = "inst-1846")
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {
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
	

	@TestAnnotations(testID = "inst-1612")
	@Test(priority = 4, alwaysRun = true, enabled = true, groups = {
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
	
	@TestAnnotations(testID = "inst-1673")
	@Test(priority = 5, alwaysRun = true, enabled = true, groups = {
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
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verify that results are displaying");
		VerificationHandler.verifyTrue(dataExtractPage.verifyUserData(PropertiesRepository.getString("id.report.1673.data.value")));

		logger.info("INST1673_VerifyAssessmentResultOfDataExtract End");
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
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "click on print individual reprot btn");
		// reportWizardPage.clickOnIndividualReportPrintBtn();
		VerificationHandler.verifyTrue(reportWizardPage.clickOnElementInFrame("reportwizard.printindividual.btn"), "Unable to click on print individual reprot btn");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "click on data extract btn");
		// reportWizardPage.clikOnIndividualReportdataExtract();
		VerificationHandler.verifyTrue(reportWizardPage.clickOnElementInFrame("reportwizard.dataextract.option"), "Unable to click on data extract btn");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "click on csv and xml btn");
		VerificationHandler.verifyTrue(reportWizardPage.clickCsvXmlBtn(), "Unable to click on csv and xml btn");

		logger.info("INST1848_VerifyIndividualReport End");
	}
	
	@TestAnnotations(testID = "inst-1886")
	@Test(priority = 7, alwaysRun = true, enabled = true, groups = {
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
	
	@TestAnnotations(testID = "inst-1851")
	@Test(priority = 8, alwaysRun = true, enabled = true, groups = {
			"Smoke" }, description = "inst-1851 Verify building proctor Assessment 'Question Analysis' Report.")
	public void INST1851_VerifyQuestionAnalysisProctorAssessmentReport() throws Exception {
		logger.info("INST1851_Verify building proctor Assessment 'Question Analysis' report.");

		log(logger, "Login to application");
		loginPage.loginToApplication1(PropertiesRepository.getString("id.personnel..home2.0.login.user.name"),
				PropertiesRepository.getString("id.personnel..home2.0.login.password"));

		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		// Step 1
		log(logger, "click on Analytics tab");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", 4, "trending_up", true),
				"Unable to verify Analytics Link");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Verifying Classic Report Portlet in Analytics Home page");
		VerificationHandler.verifyTrue(
				analyticsLandingPgae.verifyAnalyticsReportingHomePage(
						PropertiesRepository.getString("id.analytics.reports.home.page.report.portlet.name")),
				"Unable to verify Classis Reporting Portlet in Analytics Home Page");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Verifying Classic Reporting Home Page");
		VerificationHandler.verifyTrue(
				analyticsLandingPgae.verifyMessage("id.analytics.reports.classic.reporting.home.page.loc", 0,
						PropertiesRepository.getString("id.analytics.reports.home.page.report.portlet.name")),
				"Unable to verify Classic Reporting Home Page");

		log(logger, "click on Report wizard tab");
		reportWizardPage.clickOnReportWizardTab();

		log(logger, "verify question analysis");
		VerificationHandler.verifyTrue(reportWizardPage.isEleDisplayed("id.reports.reportwizrad.questionanalysis.loc"),
				"question analysis is not visible");

		log(logger, "Click on question analysis button");
		loginPage.verifyAndClickswitchToCardShadowFrame(
				PropertiesRepository.getString("id.reports.reportwizrad.questionanalysis.loc"), true);

		log(logger, "Verify proctored assessment tab");
		VerificationHandler
				.verifyTrue(
						loginPage.verifyMessages("id.reports.reportwizrad.questionanalysis.loc.proctorAss", 0,
								PropertiesRepository
										.getString("id.reports.reportwizrad.questionanalysis.proctorAss.value")),
				"proctor assessment tab not visible");

		log(logger, "Verify practice assessment tab");
		VerificationHandler
				.verifyTrue(
						loginPage.verifyMessages("id.reports.reportwizrad.questionanalysis.loc.practiceAss", 0,
								PropertiesRepository
										.getString("id.reports.reportwizrad.questionanalysis.practiceAss.value")),
				"practice assessment tab not visible");

		log(logger, "Verify proctor assessment grid with list of assessmnt");
		VerificationHandler.verifyTrue(
				reportWizardPage.verifyAssessmentGrid1("id.reports.reportwizrad.questionanalysis.assGrid.loc"),
				"proctor assessment grid is not diplayed");

		log(logger, "click on assessment from the proctor grid list");
		// reportWizardPage.ClickAssessmentFromPool("id.reports.reportwizrad.questionanalysis.assGrid.loc",
		// PropertiesRepository.getString("id.reports.reportwizrad.proctorAss.value"));
		// reportWizardPage.ClickAssessmentFromPools();
		reportWizardPage.ClickAssessmentFromPoolsBasedOnNames("Item Type Regression Test (P)");

		log(logger, "select date to filter");
		reportWizardPage.sendDateInTextField();

		log(logger, "click on assessment id");
		reportWizardPage.clikOnProctorAssessmentId("id.reportwizard.proctor.batch.id");

		log(logger, "Verify Data Extract button");
		VerificationHandler.verifyTrue(
				reportWizardPage.verifyAssessmentGrid1("id.reports.reportwizard.dataExatraction.loc"),
				"DataExtraction is not diplayed");

		log(logger, "Verify pdf page displayed");
		VerificationHandler.verifyTrue(
				reportWizardPage.verifyAssessmentGrid1("id.reports.reportwizard.dataExatraction.pdf.loc"),
				"PDF is not diplayed");

		log(logger, "Click on DataExtract button");
		reportWizardPage.verifyAndClickReportPageBtns(
				PropertiesRepository.getString("id.reports.reportwizard.dataExatraction.loc"), true);

		log(logger, " Verify CSV/Excel and XML buttons");
		VerificationHandler.verifyTrue(
				reportWizardPage.verifyAssessmentGrid1("id.reports.reportwizard.dataExatraction.csvXML.loc"),
				"CSV/Excel is not diplayed");

		log(logger, "Click and Verify CSV/Excel button");
		VerificationHandler.verifyTrue(
				reportWizardPage.verifyAndClickReportPageBtns(
						PropertiesRepository.getString("id.reports.reportwizard.dataExatraction.csv.loc"), true),
				"CSV/Excel button not clicked");

		log(logger, "Click and verify  XML button");
		VerificationHandler.verifyTrue(
				reportWizardPage.verifyAndClickReportPageBtns(
						PropertiesRepository.getString("id.reports.reportwizard.dataExatraction.xml.loc"), true),
				"XML button not clicked");

		logger.info("INST1851_Verify building Practice Assessment 'Question Analysis' report.");
	}
	
	@TestAnnotations(testID = "inst-1850")
	@Test(priority = 9, alwaysRun = true, enabled = true, groups = {
			"Smoke" }, description = "inst-1850 ::Verify building Practice Assessment 'Question Analysis' report.")
	public void INST1850_VerifyQuestionAnalysisPracticeAssessmentReport() throws Exception {
		logger.info("INST1850_Verify building Practice Assessment 'Question Analysis' report.");

		log(logger, "Login to application");
		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.rpt.instuctor2.username"),
				PropertiesRepository.getString("id.auto.rpt.instuctor2.password"));

		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		// Step 1
		log(logger, "click on Analytics tab");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "trending_up", true),
				"Unable to verify Analytics Link");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Verifying Classic Report Portlet in Analytics Home page");
		VerificationHandler.verifyTrue(
				analyticsLandingPgae.verifyAnalyticsReportingHomePage(
						PropertiesRepository.getString("id.analytics.reports.home.page.report.portlet.name")),
				"Unable to verify Classis Reporting Portlet in Analytics Home Page");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Verifying Classic Reporting Home Page");
		VerificationHandler.verifyTrue(
				analyticsLandingPgae.verifyMessage("id.analytics.reports.classic.reporting.home.page.loc", 0,
						PropertiesRepository.getString("id.analytics.reports.home.page.report.portlet.name")),
				"Unable to verify Classic Reporting Home Page");

		log(logger, "click on Report wizard tab");
		reportWizardPage.clickOnReportWizardTab();

		log(logger, "verify question analysis");
		VerificationHandler.verifyTrue(reportWizardPage.isEleDisplayed("id.reports.reportwizrad.questionanalysis.loc"),
				"question analysis is not visible");

		log(logger, "Click on question analysis button");
		loginPage.verifyAndClickswitchToCardShadowFrame(
				PropertiesRepository.getString("id.reports.reportwizrad.questionanalysis.loc"), true);

		log(logger, "Verify proctored assessment tab");
		VerificationHandler
				.verifyTrue(
						loginPage.verifyMessages("id.reports.reportwizrad.questionanalysis.loc.proctorAss", 0,
								PropertiesRepository
										.getString("id.reports.reportwizrad.questionanalysis.proctorAss.value")),
				"proctor assessment tab not visible");

		log(logger, "Verify practice assessment tab");
		VerificationHandler
				.verifyTrue(
						loginPage.verifyMessages("id.reports.reportwizrad.questionanalysis.loc.practiceAss", 0,
								PropertiesRepository
										.getString("id.reports.reportwizrad.questionanalysis.practiceAss.value")),
				"practice assessment tab not visible");

		log(logger, "Verify proctor assessment grid with list of assessmnt");
		VerificationHandler.verifyTrue(
				reportWizardPage.verifyAssessmentGrid1("id.reports.reportwizrad.questionanalysis.assGrid.loc"),
				"proctor assessment grid is not diplayed");

		log(logger, "Click on practice assessment tab");
		loginPage.verifyAndClickswitchToCardShadowFrame(
				PropertiesRepository.getString("id.reports.reportwizrad.questionanalysis.loc.practiceAss"), true);

		log(logger, "Verify practice assessment grid with list of assessmnt");
		VerificationHandler.verifyTrue(
				reportWizardPage.verifyAssessmentGrid1("id.reports.reportwizrad.questionanalysis.assGrid.loc"),
				"practice assessment grid is not diplayed");

		log(logger, "click on assessment from the practice grid list");
		reportWizardPage.ClickAssessmentFromPool("id.reports.reportwizrad.questionanalysis.assGrid.loc",
				PropertiesRepository.getString("id.reports.reportwizrad.practiceAss.value"));

		reportWizardPage.sendDateInTextField();

		log(logger, "click on assessment id");
		reportWizardPage.clikOnProctorAssessmentId("id.reports.reportwizrad.practiceAss.id.values");

		log(logger, "Verify Data Extract button");
		VerificationHandler.verifyTrue(
				reportWizardPage.verifyAssessmentGrid1("id.reports.reportwizard.dataExatraction.loc"),
				"DataExtraction is not diplayed");

		log(logger, "Verify pdf page displayed");
		VerificationHandler.verifyTrue(
				reportWizardPage.verifyAssessmentGrid1("id.reports.reportwizard.dataExatraction.pdf.loc"),
				"PDF is not diplayed");

		log(logger, "Click on DataExtract button");
		reportWizardPage.verifyAndClickReportPageBtns(
				PropertiesRepository.getString("id.reports.reportwizard.dataExatraction.loc"), true);

		log(logger, " Verify CSV/Excel and XML buttons");
		VerificationHandler.verifyTrue(
				reportWizardPage.verifyAssessmentGrid1("id.reports.reportwizard.dataExatraction.csvXML.loc"),
				"CSV/Excel is not diplayed");

		log(logger, "Click and Verify CSV/Excel button");
		VerificationHandler.verifyTrue(
				reportWizardPage.verifyAndClickReportPageBtns(
						PropertiesRepository.getString("id.reports.reportwizard.dataExatraction.csv.loc"), true),
				"CSV/Excel button not clicked");

		log(logger, "Click and verify  XML button");
		VerificationHandler.verifyTrue(
				reportWizardPage.verifyAndClickReportPageBtns(
						PropertiesRepository.getString("id.reports.reportwizard.dataExatraction.xml.loc"), true),
				"XML button not clicked");

		logger.info("INST1850_Verify building Practice Assessment 'Question Analysis' report.");
	}
	
	@TestAnnotations(testID = "inst-2016")
	@Test(priority = 10, alwaysRun = true, enabled = true, groups = {
			"Smoke" }, description = "inst-2016:Verify Group report tile from the communicator 2.0 & civility mentor")
	public void INST2016_VerifyGrpRptTitleForCommunityAndCivilityMentor() throws Exception {
		logger.info("INST2016_VerifyGrpRptTitleForCommunityAndCivilityMentor Start");

		log(logger, "Login to application");
		loginPage.loginToApplication1(PropertiesRepository.getString("id.personnel..home2.0.login.user.name"),
				PropertiesRepository.getString("id.personnel..home2.0.login.password"));

		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		// Step 1
		log(logger, "click on Analytics tab");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", 4, "trending_up", true),
				"Unable to verify Analytics Link");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Verifying Classic Report Portlet in Analytics Home page");
		VerificationHandler.verifyTrue(
				analyticsLandingPgae.verifyAnalyticsReportingHomePage(
						PropertiesRepository.getString("id.analytics.reports.home.page.report.portlet.name")),
				"Unable to verify Classis Reporting Portlet in Analytics Home Page");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Verifying Classic Reporting Home Page");
		VerificationHandler.verifyTrue(
				analyticsLandingPgae.verifyMessage("id.analytics.reports.classic.reporting.home.page.loc", 0,
						PropertiesRepository.getString("id.analytics.reports.home.page.report.portlet.name")),
				"Unable to verify Classic Reporting Home Page");

		log(logger, "Entering Tutorial id in Group Report for Tutorial");
		reportWizardPage.enterTextWithSwitchToCardShow(
				PropertiesRepository
						.getString("id.analytics.classic.reporting.quick.reports.tutorial.group.report.text.box.loc"),
				PropertiesRepository.getString(
						"id.analytics.classic.reporting.quick.reports.tutorial.group.report.text.box.value.2016.value"));

		log(logger, "Clicking on Enter Button");
		VerificationHandler
				.verifyTrue(reportWizardPage.verifyAndClickswitchToCardShadowFrame(
						PropertiesRepository.getString(
								"id.analytics.classic.reporting.quick.reports.tutorial.group.report.enter.button.loc"),
				true), "Unable to click Enter Button");

		log(logger, "Verifying Group Name in Comm and Civility Mentor portlet details");
		VerificationHandler.verifyTrue(
				reportWizardPage.verifyCommAndCivilityMentorPortletDetails(PropertiesRepository.getString(
						"id.analytics.classic.reporting.quick.reports.tutorial.comm.and.civility.mentor.portlet.table.group.report.title.value")),
				"Unable to verify on Group Report Portlet details");

		log(logger, "Clicking on Group Report Continue Button");
		VerificationHandler.verifyTrue(
				reportWizardPage
						.verifyCommAndCivilityMentorPortletDetailsAndClickContinueButton(PropertiesRepository.getString(
								"id.analytics.classic.reporting.quick.reports.tutorial.comm.and.civility.mentor.portlet.table.group.report.title.value")),
				"Unable to click on Group Report continue button");

		log(logger, "Verifying Group Report Assessment Name ");
		VerificationHandler.verifyTrue(
				reportWizardPage.verifyMessage(
						"id.analytics.classic.reporting.quick.reports.tutorial.comm.and.civility.mentor.portlet.assessemnt.name.loc",
						0,
						PropertiesRepository.getString(
								"id.analytics.classic.reporting.quick.reports.tutorial.group.report.assessment.2016.value")),
				"Unable Verifying Group Report Assessment Name ");

		/*
		 * log(logger, "Verifying Group Report Tutorial Id");
		 * reportWizardPage.verifyTextContains( PropertiesRepository.getString(
		 * "id.analytics.classic.reporting.quick.reports.tutorial.comm.and.civility.mentor.portlet.assessment.tutorial.id.loc"
		 * ), PropertiesRepository.getString(
		 * "id.analytics.classic.reporting.quick.reports.tutorial.group.report.tutorial.id.2016.value"
		 * ));
		 */

		log(logger, "Verifying Group Report Modules list");
		VerificationHandler.verifyTrue(
				reportWizardPage
						.verifyCommAndCivilityMentorPortletContinueBtnModulesList(PropertiesRepository.getString(
								"id.analytics.classic.reporting.quick.reports.tutorial.comm.and.civility.mentor.portlet.modules.list.loc")),
				"Unable to Verifying Group Report Modules list");

		logger.info("INST2016_VerifyGrpRptTitleForCommunityAndCivilityMentor End");
	}

	@TestAnnotations(testID = "inst-2017")
	@Test(priority = 11, alwaysRun = true, enabled = true, groups = {
			"Smoke" }, description = "inst-2017:Verify Group & Individual Report > Student Selection feature for civility mentor and communicator")
	public void INST2017_VerifyGrpAndIndvRptTitleForCommunityAndCivilityMentor() throws Exception {
		logger.info("INST2017_VerifyGrpAndIndvRptTitleForCommunityAndCivilityMentor Start");
		log(logger, "INST2017_VerifyGrpAndIndvRptTitleForCommunityAndCivilityMentor Start");

		log(logger, "Login to application");
		loginPage.loginToApplication1(PropertiesRepository.getString("id.personnel..home2.0.login.user.name"),
				PropertiesRepository.getString("id.personnel..home2.0.login.password"));

		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		// Step 1
		log(logger, "click on Analytics tab");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", 4, "trending_up", true),
				"Unable to verify Analytics Link");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Verifying Classic Report Portlet in Analytics Home page");
		VerificationHandler.verifyTrue(
				analyticsLandingPgae.verifyAnalyticsReportingHomePage(
						PropertiesRepository.getString("id.analytics.reports.home.page.report.portlet.name")),
				"Unable to verify Classis Reporting Portlet in Analytics Home Page");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Verifying Classic Reporting Home Page");
		VerificationHandler.verifyTrue(
				analyticsLandingPgae.verifyMessage("id.analytics.reports.classic.reporting.home.page.loc", 0,
						PropertiesRepository.getString("id.analytics.reports.home.page.report.portlet.name")),
				"Unable to verify Classic Reporting Home Page");

		log(logger, "Entering Tutorial id in Group Report for Tutorial");
		reportWizardPage.enterTextWithSwitchToCardShow(
				PropertiesRepository.getString(
						"id.analytics.classic.reporting.quick.reports.tutorial.group.and.individual.report.text.box.loc"),
				PropertiesRepository.getString(
						"id.analytics.classic.reporting.quick.reports.tutorial.group.report.text.box.value.2016.value"));

		log(logger, "Clicking on Enter Button");
		VerificationHandler.verifyTrue(reportWizardPage.verifyAndClickswitchToCardShadowFrame(
				PropertiesRepository.getString(
						"id.analytics.classic.reporting.quick.reports.tutorial.group.and.individual.report.enter.button.loc"),
				true), "Unable to click Enter Button");

		log(logger, "Verifying Group Name in Comm and Civility Mentor portlet details");
		VerificationHandler.verifyTrue(
				reportWizardPage.verifyCommAndCivilityMentorPortletDetails(PropertiesRepository.getString(
						"id.analytics.classic.reporting.quick.reports.tutorial.comm.and.civility.mentor.portlet.table.group.report.and.indv.report.title.value")),
				"Unable to verify on Group Report Portlet details");

		log(logger, "Clicking on Group Report Continue Button");
		VerificationHandler.verifyTrue(
				reportWizardPage
						.verifyCommAndCivilityMentorPortletDetailsAndClickContinueButton(PropertiesRepository.getString(
								"id.analytics.classic.reporting.quick.reports.tutorial.comm.and.civility.mentor.portlet.table.group.report.and.indv.report.title.value")),
				"Unable to click on Group Report continue button");

		log(logger, "Verifying Group Report Assessment Name ");
		VerificationHandler.verifyTrue(
				reportWizardPage.verifyMessage(
						"id.analytics.classic.reporting.quick.reports.tutorial.comm.and.civility.mentor.portlet.assessemnt.name.loc",
						0,
						PropertiesRepository.getString(
								"id.analytics.classic.reporting.quick.reports.tutorial.group.report.assessment.2016.value")),
				"Unable Verifying Group Report Assessment Name ");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		/*
		 * log(logger, "Verifying Group Report Tutorial Id");
		 * reportWizardPage.verifyTextContains( PropertiesRepository.getString(
		 * "id.analytics.classic.reporting.quick.reports.tutorial.comm.and.civility.mentor.portlet.assessment.tutorial.id.loc"
		 * ), PropertiesRepository.getString(
		 * "id.analytics.classic.reporting.quick.reports.tutorial.group.report.tutorial.id.2016.value"
		 * ));
		 */

		log(logger, "Verifying Group Report Modules list");
		VerificationHandler.verifyTrue(
				reportWizardPage
						.verifyCommAndCivilityMentorPortletContinueBtnModulesList(PropertiesRepository.getString(
								"id.analytics.classic.reporting.quick.reports.tutorial.comm.and.civility.mentor.portlet.modules.list.loc")),
				"Unable to Verifying Group Report Modules list");
		log(logger, "INST2017_VerifyGrpAndIndvRptTitleForCommunityAndCivilityMentor End");
		logger.info("INST2017_VerifyGrpAndIndvRptTitleForCommunityAndCivilityMentor End");
	}
}
