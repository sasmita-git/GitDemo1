package com.automation.id.home2;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.id.pages.EditProfilePage;
import com.automation.id.pages.HomePage;
import com.automation.id.pages.HomePage2;
import com.automation.id.pages.LoginPage;
import com.jaca.TestAnnotations;

public class HomeTest2 extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	LoginPage loginPage;
	HomePage homePage;
	HomePage2 homePage2;
	EditProfilePage editProfilePage;
	BaseHandler basehandler;

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		homePage2 = new HomePage2(driver);
		editProfilePage = new EditProfilePage(driver);
		basehandler = new BaseHandler(driver);
	}

	/**
	 * @author syed.pasha
	 */
	@TestAnnotations(testID = "INST-1946")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {
			"Smoke" }, description = "INST-1946:Check access for faculty to home dashboard")
	public void INST1946_VerifyHomeDashboard() throws Exception {
		logger.info("INST1946_VerifyHomeDashboard Start");

		// Step 1
		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.hm2.instructor1.username"),
				PropertiesRepository.getString("id.auto.hm2.instructor1.password"));

		log(logger, "Verifying if Customized Home button is displayed");
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("id.home.customized.home.btn.loc", 0));

		// Step 2
		log(logger, "Click on Customized Home button ");
		loginPage.clickButton(PropertiesRepository.getString("id.home.customized.home.btn.loc"), 0);

		log(logger, "Verifying if Graduation cohort Tab is displayed");
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("id.home.gradCohorts.tab.loc", 0));

		log(logger, "Verifying if Graduation cohort is selected");
		VerificationHandler.verifyTrue(homePage2.verifyActiveTab(PropertiesRepository.getString("id.home.gradCohorts.tab.loc") , 0));		

		log(logger, "Verifying if Filter Grid Institution is displayed");
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("id.home.fileterGrid.institution.loc", 0));

		log(logger, "Verifying if Cohort Grid data is Present");
		VerificationHandler.verifyTrue(homePage2.verifyIfGridDataDisplayed(PropertiesRepository.getString("id.home.cohortsGrid.checkbox.loc")));

		logger.info("INST1946_VerifyHomeDashboard End");
	}

	/**
	 * @author syed.pasha
	 */
	@TestAnnotations(testID = "INST-1947")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {
			"Smoke" }, description = "INST-1947:Check access for director to home dashboard")
	public void INST1947_VerifyHomeDashboardDirector() throws Exception {
		logger.info("INST1947_VerifyHomeDashboardDirector Start");

		// Step 1
		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.hm2.instructor1.1969.username"),
				PropertiesRepository.getString("id.auto.hm2.instructor1.1969.password"));

		log(logger, "Verifying if Customized Home button is displayed");
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("id.home.customized.home.btn.loc", 0));

		// Step 2
		log(logger, "Click on Customized Home button ");
		loginPage.clickButton(PropertiesRepository.getString("id.home.customized.home.btn.loc"), 0);

		log(logger, "Verifying if Graduation cohort Tab is displayed");
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("id.home.gradCohorts.tab.loc", 0));

		log(logger, "Verifying if Graduation cohort is selected");
		VerificationHandler.verifyTrue(homePage2.verifyActiveTab(PropertiesRepository.getString("id.home.gradCohorts.tab.loc") , 0));

		log(logger, "Verifying if Filter Grid Institution is displayed");
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("id.home.fileterGrid.institution.loc", 0));

		log(logger, "Verifying if Cohort Grid data is Present");
		VerificationHandler.verifyTrue(homePage2.verifyIfGridDataDisplayed(PropertiesRepository.getString("id.home.cohortsGrid.checkbox.loc")));

		logger.info("INST1947_VerifyHomeDashboardDirector End");
	}

	/**
	 * @author syed.pasha
	 */
	@TestAnnotations(testID = "INST-1948")
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {
			"Smoke" }, description = "INST-1948:Verify users can access Customize dashboard from ellipses")
	public void INST1948_VerifyCustomizedFromEllipses() throws Exception {
		logger.info("INST1948_VerifyCustomizedFromEllipses Start");

		// Precondition
		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.hm2.instructor1.username"),
				PropertiesRepository.getString("id.auto.hm2.instructor1.password"));

		log(logger, "Verifying if Customized Home button is displayed");
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("id.home.customized.home.btn.loc", 0));

		// Step 1
		log(logger, "Click on Ellipses on the top right corner");
		loginPage.clickButton(PropertiesRepository.getString("id.homepage.static.menu"), 1);

		// Step 1 and 2
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		log(logger, "Verifying if Customized Home link is displayed at the top and click on it");
		VerificationHandler.verifyTrue(homePage.verifyIfCustomizedHomeLinkIsFirstAndClick());
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Verifying if Graduation cohort Tab is displayed");
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("id.home.gradCohorts.tab.loc", 0));

		logger.info("INST1948_VerifyCustomizedFromEllipses End");
	}
	
	/**
	 * @author syed.pasha
	 */
	@TestAnnotations(testID = "INST-1949")
	@Test(priority = 4, alwaysRun = true, enabled = true, groups = {
			"Smoke" }, description = "INST-1949:Check for tabs for curriculum cohort institutes")
	public void INST1949_VerifyTabsForCC() throws Exception {
		logger.info("INST1949_VerifyTabsForCC Start");

		// Precondition
		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.hm2.instructor1.username"),
				PropertiesRepository.getString("id.auto.hm2.instructor1.password"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying if Customized Home button is displayed");
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("id.home.customized.home.btn.loc", 0));

		// Step 1
		log(logger, "Click on Customized Home button ");
		loginPage.clickButton(PropertiesRepository.getString("id.home.customized.home.btn.loc"), 0);

		log(logger, "Verifying if Graduation cohort Tab is displayed");
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("id.home.gradCohorts.tab.loc", 0));
		
		log(logger, "Verifying if Course cohort Tab is displayed");
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("id.home.gradCohorts.tab.loc", 1));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		// Step 2
		log(logger, "Click on Course cohort Tab");
		loginPage.clickButton(PropertiesRepository.getString("id.home.gradCohorts.tab.loc"), 1);		
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying if Course cohort is selected");
		VerificationHandler.verifyTrue(homePage2.verifyActiveTab(PropertiesRepository.getString("id.home.gradCohorts.tab.loc") , 1));
		
		log(logger, "Verifying if Cohort Grid data is Present");
		VerificationHandler.verifyTrue(homePage2.verifyIfGridDataDisplayed(PropertiesRepository.getString("id.home.cohortsGrid.checkbox.loc")));

		//Step 3
		
		log(logger, "Click on Graduation cohort Tab");
		loginPage.clickButton(PropertiesRepository.getString("id.home.gradCohorts.tab.loc"), 0);
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying if Course cohort is selected");
		VerificationHandler.verifyTrue(homePage2.verifyActiveTab(PropertiesRepository.getString("id.home.gradCohorts.tab.loc") , 0));
		
		log(logger, "Verifying if Graduation Grid data is Present");
		VerificationHandler.verifyTrue(homePage2.verifyIfGridDataDisplayed(PropertiesRepository.getString("id.home.cohortsGrid.checkbox.loc")));
		
		logger.info("INST1949_VerifyTabsForCC End");
	}
	
	/**
	 * Precondition : user(angan.new/Test123) data will not be changes and have only three GD data and institution filter is auto selected
	 * @author syed.pasha
	 */
	@TestAnnotations(testID = "INST-1984")
	@Test(priority = 5, alwaysRun = true, enabled = true, groups = {
			"Smoke" }, description = "inst-1984:Check for appropriate Graduation cohort data in the grid")
	public void INST1984_VerifyGCGridData() throws Exception {
		logger.info("INST1984_VerifyGCGridData Start");

		// Precondition
		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.hm2.instructor5.username"),
				PropertiesRepository.getString("id.auto.hm2.instructor5.password"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying if Customized Home button is displayed");
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("id.home.customized.home.btn.loc", 0));
		
		log(logger, "Click on Customized Home button ");
		loginPage.clickButton(PropertiesRepository.getString("id.home.customized.home.btn.loc"), 0);

		// Step 1
		log(logger, "Verifying if Graduation cohort Tab is displayed");
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("id.home.gradCohorts.tab.loc", 0));

		log(logger, "Verifying if Graduation cohort is selected");
		VerificationHandler.verifyTrue(homePage2.verifyActiveTab(PropertiesRepository.getString("id.home.gradCohorts.tab.loc") , 0));

		// Step 2
		log(logger, "Verifying Graduation cohort Grid data");
		//VerificationHandler.verifyTrue(homePage2.verifyGDGridData("id.home.customize.home.gdData1.value" , "id.home.customize.home.gdData2.value" , "id.home.customize.home.gdData3.value") , "Unable to Verify GRADUATION COHORTS Grid Data");
		VerificationHandler.verifyTrue(homePage2.verifyGDGridData("id.home.customize.home.gdData1.value") , "Unable to Verify GRADUATION COHORTS Grid Data");
		
		logger.info("INST1984_VerifyGCGridData End");
	}
	
	

	/**
	 * @author syed.pasha
	 */
	@TestAnnotations(testID = "INST-1991")
	@Test(priority = 6, alwaysRun = true, enabled = true, groups = {
			"Smoke" }, description = " inst-1991:Verify ascending and descending for the course cohorts in the grid")
	public void INST1991_VerifyCCGridDataAscendingDescending() throws Exception {
		logger.info("INST1991_VerifyCCGridDataAscendingDescending Start");

		// Precondition
		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.hm2.instructor1.username"),
				PropertiesRepository.getString("id.auto.hm2.instructor1.password"));

		log(logger, "Verifying if Customized Home button is displayed");
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("id.home.customized.home.btn.loc", 0));
		
		log(logger, "Click on Customized Home button ");
		loginPage.clickButton(PropertiesRepository.getString("id.home.customized.home.btn.loc"), 0);

		
		log(logger, "Verifying if Graduation cohort Tab is displayed");
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("id.home.gradCohorts.tab.loc", 0));
		
		log(logger, "Verifying if Course cohort Tab is displayed");
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("id.home.gradCohorts.tab.loc", 1));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		// Step 1
		log(logger, "Click on Course cohort Tab");
		loginPage.clickButton(PropertiesRepository.getString("id.home.gradCohorts.tab.loc"), 1);		
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying if Course cohort is selected");
		VerificationHandler.verifyTrue(homePage2.verifyActiveTab(PropertiesRepository.getString("id.home.gradCohorts.tab.loc") , 1));
		
		log(logger, "Verifying if Course cohort Grid Data is in Ascending order");
		VerificationHandler.verifyTrue(homePage2.verifyCCGridDatainAsceDesc("ascending") , "Unable to Verify Ascending/Descending order");
						
		// Step 2
		log(logger, "Click on Course cohort Tab");
		loginPage.clickButton(PropertiesRepository.getString("id.home.customize.home.grid.data.arrow.loc"), 0);
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying if Course cohort Grid Data is in Ascending order");
		VerificationHandler.verifyTrue(homePage2.verifyCCGridDatainAsceDesc("descending") , "Unable to Verify Ascending/Descending order");		
		
		logger.info("INST1991_VerifyCCGridDataAscendingDescending End");
	}
	
	
	@TestAnnotations(testID = "INST-1990")
	@Test(priority = 7, alwaysRun = true, enabled = true, groups = {
			"Smoke" }, description = "inst-1990:Check for appropriate course cohort data in the grid")
	public void INST1990_VerifyCCGridData() throws Exception {
		logger.info("INST1990_VerifyCCGridData Start");

		// Precondition
		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.hm2.instructor1.username"),
				PropertiesRepository.getString("id.auto.hm2.instructor1.password"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		//Step 1
		log(logger, "Click on Ellipses on the top right corner");
		loginPage.clickButton(PropertiesRepository.getString("id.homepage.static.menu"), 1);
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		//Step 1
		log(logger, "Verifying if Customized Home link is displayed at the top and click on it");
		VerificationHandler.verifyTrue(homePage.verifyIfCustomizedHomeLinkIsFirstAndClick());
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		//Step 1
		log(logger, "Verifying and clicking on Course Cohort ");
		VerificationHandler.verifyTrue(homePage.verifyAndClickUsingContains(PropertiesRepository.getString("id.home.graduation.and.course.cohorts.top.menu.loc"), 
				PropertiesRepository.getString("id.home.course.cohorts.top.menu.value"), true,  "Graduation/ Course Cohorts menu link"), "Unable to click Graduation/ Course Cohorts menu link");
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		// Step 1
		log(logger, "Verifying if Course cohort Tab is displayed");
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("id.home.gradCohorts.tab.loc", 1));

		log(logger, "Verifying if Course cohort is selected");
		VerificationHandler.verifyTrue(homePage2.verifyActiveTab(PropertiesRepository.getString("id.home.gradCohorts.tab.loc") , 1));

		// Step 2
		log(logger, "Verifying Course Cohort, size and Institution in Course Cohorts");
		VerificationHandler.verifyTrue(homePage.verifyCourseCohortTableHeader(),"Unable to verify Course Cohort Table Header");
		
		// Step 2
		log(logger, "Verifying Course Cohort table row size");
		VerificationHandler.verifyTrue(homePage.verifyTableMinimumRowCount(PropertiesRepository.getString("id.home.course.cohort.table.all.row.count.loc"), PropertiesRepository.getInt("id.cohort.table.minimum.row.count")), "Unable to verify Table row count");
		
		logger.info("INST1990_VerifyCCGridData End");
	}
	
}
