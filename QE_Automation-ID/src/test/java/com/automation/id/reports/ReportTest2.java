package com.automation.id.reports;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.id.pages.AnalyticsLandingPgae;
import com.automation.id.pages.HomePage;
import com.automation.id.pages.LoginPage;
import com.automation.id.pages.QuickReportPage;
import com.automation.id.pages.ReportWizardPage;
import com.jaca.TestAnnotations;

public class ReportTest2 extends BaseTest {

	Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private QuickReportPage quickReportPage;
	private HomePage homePage;
	private AnalyticsLandingPgae analyticsLandingPgae;
	private ReportWizardPage reportWizardPage;

	@BeforeMethod(alwaysRun = true)
	public void verifyHomePage() throws Exception {
		loginPage = new LoginPage(driver);
		analyticsLandingPgae = new AnalyticsLandingPgae(driver);
		homePage = new HomePage(driver);
		quickReportPage = new QuickReportPage(driver);
		reportWizardPage = new ReportWizardPage(driver);
		loginPage = new LoginPage(driver);
	}

	/**
	 * Removed as functionality not available after FAC_18.8.0.30.
	 * 
	 * @throws Exception
	 */
	//@TestAnnotations(testID = "inst-1854")
	//@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Smoke" }, description = "inst-1854:Verify Admissions (New) Tile")
	public void INST1854_VerifyAdmissionsTile() throws Exception {
		logger.info("INST1854_VerifyAdmissionsTile Start");

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
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "trending_up", true),
				"Unable to verify Analytics Link");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Verify that Admission Tiles is displaying");
		VerificationHandler
				.verifyTrue(
						analyticsLandingPgae.VerifyReportingTextLink(
								PropertiesRepository.getString(
										"id.analytics.reporting.admissions.and.ati.pulse.report.card.portlet.loc"),
						PropertiesRepository.getString("id.analytics.reports.home.page.report.admission.name")),
				"Unable to verify Admission Tiles");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		/*
		 * log(logger,
		 * "Verifying Admission Report Portlet in Analytics Home page");
		 * VerificationHandler.verifyTrue(analyticsLandingPgae.
		 * verifyAnalyticsReportingHomePage( PropertiesRepository.getString(
		 * "id.analytics.reports.home.page.report.admission.name")),
		 * "Unable to verify Classis Reporting Portlet in Analytics Home Page");
		 */

		logger.info("INST1854_VerifyAdmissionsTile End");
	}

	//@TestAnnotations(testID = "inst-1678")
	//@Test(priority = 2, alwaysRun = true, enabled = true, groups = {"Smoke" }, description = "inst-1678:Verify that TEAS/Discover report is generated as per the program type selected and if the booklet is valuated based on the program type selected.")
	public void INST1678_VerifyTEASDiscoverReportProgramType() throws Exception {
		log(logger, "INST1678_VerifyTEASDiscoverReportProgramType Start");
		logger.info("INST1678_VerifyTEASDiscoverReportProgramType Start");

		log(logger, "Login to application");
		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.faculty.username.report1"),
				PropertiesRepository.getString("id.login.faculty.password.report1"));

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

		log(logger, "Click on TEAS Discover report button");
		VerificationHandler.verifyTrue(loginPage.verifyAndClickswitchToCardShadowFrame(PropertiesRepository.getString("analytics.reportwizard.teasdiscover.loc"), true), "Unable to Click on TEAS Discover report button");

		reportWizardPage.scrollDown();

		log(logger, "send date to the text field for filter");
		reportWizardPage.sendDateTeasDiscover("03/19/2017");

		log(logger, "click on continue btn");
		reportWizardPage.clickContinueTEASDiscover();

		log(logger, "scroll up");
		reportWizardPage.scrollUP();

		log(logger, "Select radio button for diffrent program type");
		VerificationHandler
				.verifyTrue(
						reportWizardPage.clickAssIdwithIndex(
								PropertiesRepository.getString("select.radio.btn.teas.discover"), 0),
						"Unable to Select radio button for diffrent program type");

		log(logger, "Select program type as pn");
		VerificationHandler
				.verifyTrue(
						reportWizardPage.clickAssIdwithIndex(
								PropertiesRepository.getString("program.type.teas.discover.pn"), 0),
						"Unable to Select program type as pn");

		log(logger, "click on continue btn");
		VerificationHandler.verifyTrue(reportWizardPage.clickOncontinueBtnFromConfigureReportPage(),
				"Unable to click continue button");

		log(logger, "Select check box for student");
		VerificationHandler
				.verifyTrue(
						reportWizardPage.clickAssIdwithIndex(
								PropertiesRepository.getString("teas.discover.select.student.loc"), 0),
						"Unable to Select check box for student");

		log(logger, "click print button");
		VerificationHandler.verifyTrue(
				reportWizardPage
						.clickAssIdwithIndex(PropertiesRepository.getString("teas.discover.report.print.button2"), 0),
				"Unable to click print button");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "click on data extract button");
		VerificationHandler.verifyTrue(
				reportWizardPage.clickAssIdwithIndex(
						PropertiesRepository.getString("id.reports.reportwizard.dataExatraction.loc"), 0),
				"Unable to click on data extract button");
		//loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		//loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "click on previous button");
		VerificationHandler.verifyTrue(
				reportWizardPage.clickAssIdwithIndex(
						PropertiesRepository.getString("reportwizard.individualreport.previous.btn"), 0),
				"Unable to click on previous button");

		log(logger, "click on previous button again");
		VerificationHandler.verifyTrue(
				reportWizardPage.clickAssIdwithIndex(
						PropertiesRepository.getString("teas.discover.report.print.previuos.button"), 0),
				"Unable to click on previous button again");

		/*log(logger, "click on previous button");
		VerificationHandler.verifyTrue(
				reportWizardPage.clickAssIdwithIndex(
						PropertiesRepository.getString("teas.discover.report.print.previuos.button.new.loc"), 0),
				"Unable to click on previous button");*/

		log(logger, "click on program type BSN");
		VerificationHandler
				.verifyTrue(
						reportWizardPage.clickAssIdwithIndex(
								PropertiesRepository.getString("program.type.teas.discover.bsn"), 0),
						"Unable to click on program type BSN");

		log(logger, "click on continue btn");
		VerificationHandler.verifyTrue(reportWizardPage.clickOncontinueBtnFromConfigureReportPage(),
				"Unable to click on continue button");

		log(logger, "click on print btn");
		VerificationHandler.verifyTrue(
				reportWizardPage
						.clickAssIdwithIndex(PropertiesRepository.getString("teas.discover.report.print.button2"), 0),
				"Unabl to click on Print button");

		log(logger, "click on data extract button");
		VerificationHandler.verifyTrue(
				reportWizardPage.clickAssIdwithIndex(
						PropertiesRepository.getString("id.reports.reportwizard.dataExatraction.loc.report"), 0),
				"Unable to click on data extract button");

		log(logger, "Verify that selected program type BSN is displaying now");
		VerificationHandler.verifyTrue(reportWizardPage.verifyTableValue(
				PropertiesRepository.getString("teas.discover.select.program.dataextract.result.loc"), 8, "BSN"),
				"Unable to verify value");

		logger.info("INST1678_VerifyAssessmentResultOfDataExtract End");
		log(logger, "INST1678_VerifyTEASDiscoverReportProgramType End");
	}

	@TestAnnotations(testID = "inst-1850")
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {
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

	//@TestAnnotations(testID = "inst-1851")
	//@Test(priority = 4, alwaysRun = true, enabled = true, groups = {"Smoke" }, description = "inst-1851 Verify building proctor Assessment 'Question Analysis' Report.")
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

	/**
	 * Admission Tiles is removed. 
	 * So commenting the test case. 
	 */
	//@TestAnnotations(testID = "inst-1915")
	//@Test(priority = 5, alwaysRun = true, enabled = true, groups = { "Smoke","Regression" }, description = "inst-1915:Verify that ATI Beta Reporting Tiles are displaying")
	public void INST1915_VerifyBetaReportTiles() throws Exception {

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

		log(logger, "Verify that Admission Tiles is displaying");
		VerificationHandler.verifyTrue(analyticsLandingPgae.VerifyReportingTextLink("Admissions"),
				"Unable to verify Admission Tiles");

		log(logger, "click and verify admission page opened");
		VerificationHandler.verifyTrue(
				analyticsLandingPgae.clickAndSwitchtoNewwindow(
						PropertiesRepository.getString("id.analytic.betaTile.admissionLoc"),
						PropertiesRepository.getString("analytics.reporting.dashboardText"), 2),
				"admission link not opened");

		log(logger, "Verify that Tutorial Tiles is displaying");
		VerificationHandler.verifyTrue(analyticsLandingPgae.VerifyReportingTextLink("Tutorials"),
				"Unable to verify Tutorials Tiles");

		log(logger, "click and verify Tutorial page opened");
		VerificationHandler.verifyTrue(
				analyticsLandingPgae.clickAndSwitchtoNewwindow(
						PropertiesRepository.getString("id.analytic.betaTile.TutLoc"),
						PropertiesRepository.getString("analytics.reporting.dashboardText"), 3),
				"Tutorial link not opened");

		log(logger, "Verify that Assessment Tiles is displaying");
		VerificationHandler.verifyTrue(analyticsLandingPgae.VerifyReportingTextLink("Assessments"),
				"Unable to verify Assessments Tiles");

		log(logger, "click and verify Assessmnet page opened");
		VerificationHandler.verifyTrue(
				analyticsLandingPgae.clickAndSwitchtoNewwindow(
						PropertiesRepository.getString("id.analytic.betaTile.assessmentLoc"),
						PropertiesRepository.getString("analytics.reporting.dashboardText"), 4),
				"Assessmnet link not opened");

		log(logger, "Verify that Remediation Tiles is displaying");
		VerificationHandler.verifyTrue(analyticsLandingPgae.VerifyReportingTextLink("Remediation"),
				"Unable to verify Remediation Tiles");

		log(logger, "click and verify Remediation page opened");
		VerificationHandler.verifyTrue(
				analyticsLandingPgae.clickAndSwitchtoNewwindow(
						PropertiesRepository.getString("id.analytic.betaTile.remediationLoc"),
						PropertiesRepository.getString("analytics.reporting.dashboardText"), 5),
				"Remediation link not opened");
	}

	@TestAnnotations(testID = "inst-2016")
	@Test(priority = 6, alwaysRun = true, enabled = true, groups = {
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
	@Test(priority = 7, alwaysRun = true, enabled = true, groups = {
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
