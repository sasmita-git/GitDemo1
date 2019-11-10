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
import com.automation.id.pages.LoginPage;
import com.automation.id.pages.ProductsPage;
import com.jaca.TestAnnotations;

public class HomeTest2Instructor extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private EditProfilePage editProfilePage;
	private BaseHandler basehandler;
	private ProductsPage productsPage;
	
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		editProfilePage = new EditProfilePage(driver);
		basehandler = new BaseHandler(driver);
		productsPage = new ProductsPage(driver);
	}

	/**
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	
	@TestAnnotations(testID="INST-1974")
	@Test(priority = 1, alwaysRun =true, enabled = true, groups={"Smoke"}, description = "INST-1974:Verify course cohort grid for instructor")
	public void INST1974_VerifyCourseCohort() throws Exception {
		log(logger, "INST1974_VerifyCourseCohort Start");
		logger.info("INST1974_VerifyCourseCohort Start");
		
		//Step 1
		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.hm2.instructor3.1974.username"),
				PropertiesRepository.getString("id.auto.hm2.instructor3.1974.password"));
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
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
		log(logger, "Verifying Course Cohort, size and Institution in Course Cohorts");
		VerificationHandler.verifyTrue(homePage.verifyCourseCohortTableHeader(),"Unable to verify Course Cohort Table Header");
		
		// Step 2
		log(logger, "Verifying Course Cohort table row size");
		VerificationHandler.verifyTrue(homePage.verifyTableMinimumRowCount(PropertiesRepository.getString("id.home.course.cohort.table.all.row.count.loc"), PropertiesRepository.getInt("id.cohort.table.minimum.row.count")), "Unable to verify Table row count");
		
		// Step 2
		log(logger, "Verifying Page display count arrow ");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.navigation.table.row.display.list.arrow.loc"), false), "Unable to verify page display count arrow");
		
		// Step 2
		log(logger, "Verifying Single right arrow ");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.navigation.table.single.right.arrow.loc"), false), "Unable to verify Single Right arrow");
		
		// Step 2
		log(logger, "Verifying End right arrow ");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.navigation.table.end.right.arrow.loc"), false), "Unable to verify End right arrow");
		
		// Step 2
		log(logger, "Clicking on End right arrow ");
		homePage.verifyAndClick(PropertiesRepository.getString("id.home.navigation.table.end.right.arrow.loc"), true);
		
		// Step 2
		log(logger, "Verifying Single Left arrow ");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.navigation.table.single.left.arrow.loc"), false), "Unable to click Single left arrow");
		
		// Step 2
		log(logger, "Verifying first Left arrow ");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.navigation.table.first.left.arrow.loc"), false), "Unable to verify first left arrow");
		
		log(logger, "Clicking on first Left arrow ");
		homePage.verifyAndClick(PropertiesRepository.getString("id.home.navigation.table.first.left.arrow.loc"), true);
		
		// Step 3
		log(logger, "Getting the cohort name which is clicked in Course Cohort");
		String cohortName = homePage.clickAndGetCohortNameFromTable();
		
		// Step 4 
		log(logger, "Clicking on Save button in Course Cohort");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.cohort.save.and.view.dashboard.button.loc"), true), "Unable to click on save and view dashboard button");
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		// Step 4 
		log(logger, "Clicking on View Dashboard button in Course Cohort");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.cohort.view.dashboard.button.loc"), true), "Unable to click on save and view dashboard button");
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		// Step 4
		log(logger, "Veriyfing Course Cohort name in Dashboard");
		VerificationHandler.verifyTrue(homePage.verifyCohortAndItsNameInDashboard(PropertiesRepository.getString("id.home.course.cohorts.home.page.value"), cohortName), "Unable to verify Cohort name in dashboard");
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		// UnChecking Course Cohort in Customize Home Page - Start. 
		
		log(logger, "Click on Ellipses on the top right corner");
		loginPage.clickButton(PropertiesRepository.getString("id.homepage.static.menu"), 1);
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying if Customized Home link is displayed at the top and click on it");
		VerificationHandler.verifyTrue(homePage.verifyIfCustomizedHomeLinkIsFirstAndClick());
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying and clicking on Course Cohort ");
		VerificationHandler.verifyTrue(homePage.verifyAndClickUsingContains(PropertiesRepository.getString("id.home.graduation.and.course.cohorts.top.menu.loc"), 
				PropertiesRepository.getString("id.home.course.cohorts.top.menu.value"), true,  "Graduation/ Course Cohorts menu link"), "Unable to click Graduation/ Course Cohorts menu link");
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Reset check cohort name in Customize page");
		VerificationHandler.verifyTrue(homePage.resetCohortName(cohortName), "Unable to reset checked cohort in customize page");
		
		log(logger, "Clicking on Save And View Dashboard button in Course Cohort");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.cohort.save.and.view.dashboard.button.loc"), true), "Unable to click on save and view dashboard button");

		// UnChecking Course Cohort in Customize Home Page - End.
		
		logger.info("INST1974_VerifyCourseCohort End");
		log(logger, "INST1974_VerifyCourseCohort End");
	}
	
	/**
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	@TestAnnotations(testID="INST-1989")
	@Test(priority = 2, alwaysRun =true, enabled = true, groups={"Smoke"}, description = "INST-1989:Check the grid after selecting checkbox for a cohort.")
	public void INST1989_VerifyGraduationCohort() throws Exception {
		logger.info("INST1989_VerifyGraduationCohort Start");
		
		//Step 1
		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.hm2.instructor3.1974.username"),
				PropertiesRepository.getString("id.auto.hm2.instructor3.1974.password"));
		
		//Step 1
		log(logger, "Click on Ellipses on the top right corner");
		loginPage.clickButton(PropertiesRepository.getString("id.homepage.static.menu"), 1);
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		//Step 1
		log(logger, "Verifying if Customized Home link is displayed at the top and click on it");
		VerificationHandler.verifyTrue(homePage.verifyIfCustomizedHomeLinkIsFirstAndClick());
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		//Step 1
		log(logger, "Verifying and clicking on Graduation Cohort ");
		VerificationHandler.verifyTrue(homePage.verifyAndClickUsingContains(PropertiesRepository.getString("id.home.graduation.and.course.cohorts.top.menu.loc"), 
				PropertiesRepository.getString("id.home.graduation.cohorts.top.menu.value"), true,  "Graduation/ Course Cohorts menu link"), "Unable to click Graduation/ Course Cohorts menu link");
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		// Step 1
		log(logger, "Verifying Graduation Cohort, size and Institution in Graduation Cohorts");
		VerificationHandler.verifyTrue(homePage.verifyCourseCohortTableHeader(),"Unable to verify Course Cohort Table Header");
		
		// Step 2
		/*log(logger, "Verifying Graduation Cohort table row size");
		VerificationHandler.verifyTrue(homePage.verifyTableRowCount(PropertiesRepository.getString("id.home.course.cohort.table.all.row.count.loc"), PropertiesRepository.getInt("id.cohort.table.row.count")), "Unable to verify Table row count");
*/		
		// Step 3
		log(logger, "Getting the cohort name which is clicked in Graduation Cohort");
		String cohortName = homePage.clickAndGetCohortNameFromTable();
		
		// Step 4
		log(logger, "Clicking on Save button in Course Cohort");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.cohort.save.and.view.dashboard.button.loc"), true), "Unable to click on save and view dashboard button");
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		// Step 4
		log(logger, "Clicking on View Dashboard button in Course Cohort");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.cohort.view.dashboard.button.loc"), true), "Unable to click on save and view dashboard button");
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		// Step 4
		log(logger, "Veriyfing Graduation Cohort name in Dashboard");
		VerificationHandler.verifyTrue(homePage.verifyCohortAndItsNameInDashboard(PropertiesRepository.getString("id.home.graduation.cohorts.home.page.value"), cohortName), "Unable to verify Gradudation Cohort name in dashboard");
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		// UnChecking Course Cohort in Customize Home Page - Start. 
		
		log(logger, "Click on Ellipses on the top right corner");
		loginPage.clickButton(PropertiesRepository.getString("id.homepage.static.menu"), 1);
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying if Customized Home link is displayed at the top and click on it");
		VerificationHandler.verifyTrue(homePage.verifyIfCustomizedHomeLinkIsFirstAndClick());
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		/*log(logger, "Verifying and clicking on Course Cohort ");
		VerificationHandler.verifyTrue(homePage.verifyAndClickUsingContains(PropertiesRepository.getString("id.home.graduation.and.course.cohorts.top.menu.second.time.loc"), 
				PropertiesRepository.getString("id.home.graduation.cohorts.top.menu.value"), true,  "Graduation/ Course Cohorts menu link"), "Unable to click Graduation/ Course Cohorts menu link");
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
*/
		log(logger, "Reset check Graduation cohort name in Customize page");
		VerificationHandler.verifyTrue(homePage.resetCohortName(cohortName), "Unable to reset checked cohort in customize page");
		
		log(logger, "Clicking on Save And View Dashboard button in Course Cohort");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.cohort.save.and.view.dashboard.button.loc"), true), "Unable to click on save and view dashboard button");

		// UnChecking Course Cohort in Customize Home Page - End.
		
		logger.info("INST1989_VerifyGraduationCohort End");
	}
	
	/**
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	@TestAnnotations(testID="INST-1997")
	@Test(priority = 3, alwaysRun =true, enabled = true, groups={"Smoke"}, description = "INST-1997:Verify Course Cohort card.")
	public void INST1997_VerifyCourseCohort() throws Exception {
		logger.info("INST1997_VerifyCourseCohort Start");
		
		//Step 1
		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.hm2.instructor3.1974.username"),
				PropertiesRepository.getString("id.auto.hm2.instructor3.1974.password"));
		
		log(logger, "Verifying Course Cohort deatails in Dashboard Page");
		VerificationHandler.verifyTrue(homePage.verifyCourseCohortDetailsInDashboard(), "Unable to verify Course Cohort details in Dashboard page");
		
		log(logger, "Clicking on First Cohort Manage button");
		homePage.clickCourseCohortFirstManageButton();
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying Manage Product tab");
		VerificationHandler.verifyTrue(homePage.verifyMessage("id.product.manage.products.loc1", 1, PropertiesRepository.getString("id.product.main.tab1.name")), "Unable to verify Products Page");
		
		
		logger.info("INST1997_VerifyCourseCohort End");
	}
	
	/**
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	@TestAnnotations(testID="INST-1994")
	@Test(priority = 4, alwaysRun =true, enabled = true, groups={"Smoke"}, description = "INST-1994:Verify default sort for course cohort in grid.")
	public void INST1994_VerifyCourseCohortNameInAlphabeticalOrder() throws Exception {
		logger.info("INST1994_VerifyCourseCohortNameInAlphabeticalOrder Start");
		
		//Step 1
		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.hm2.instructor3.username1"),
				PropertiesRepository.getString("id.auto.hm2.instructor3.password1"));
		
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
		
		log(logger, "Veriyfing Course Cohort name in alphabetical order");
		VerificationHandler.verifyTrue(homePage.checkCourseCohortNameInAlphabeticalOrder(), "Course Cohort names are not in Ascending Order");
		
		logger.info("INST1994_VerifyCourseCohortNameInAlphabeticalOrder End");
	}

	/**
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	@TestAnnotations(testID="INST-1950")
	@Test(priority = 5, alwaysRun =true, enabled = true, groups={"Smoke"}, description = "INST-1950:Check for tabs for non curriculum cohort institutes")
	public void INST1950_VerifyNonCurriculumCohortInstitutes() throws Exception {
		logger.info("INST1950_VerifyNonCurriculumCohortInstitutes Start");
		
		//Step 1
		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.hm2.instructor6.1950.username"),
				PropertiesRepository.getString("id.auto.hm2.instructor6.1950.password"));
		
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
		VerificationHandler.verifyFalse(homePage.verifyAndClickUsingContains(PropertiesRepository.getString("id.home.graduation.and.course.cohorts.top.menu.loc"), 
				PropertiesRepository.getString("id.home.course.cohorts.top.menu.value"), false,  "Graduation/ Course Cohorts menu link"), "Unable to click Graduation/ Course Cohorts menu link");
		
		logger.info("INST1950_VerifyNonCurriculumCohortInstitutes End");
	}
	
	/**
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	@TestAnnotations(testID = "INST-1982")
	@Test(priority = 6, alwaysRun = true, enabled = true, groups = {
			"Smoke" }, description = "INST-1982:Verify pop up message functionality.")
	public void INST1982_VerifyGraduationFilterApplyBtn() throws Exception {
		logger.info("INST1982_VerifyGraduationFilterApplyBtn Start");

		// Step 1
		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.hm2.director2.1982.username"),
				PropertiesRepository.getString("id.auto.hm2.director2.1982.password"));

		// Step 1
		log(logger, "Click on Ellipses on the top right corner");
		loginPage.clickButton(PropertiesRepository.getString("id.homepage.static.menu"), 1);
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		// Step 1
		log(logger, "Verifying if Customized Home link is displayed at the top and click on it");
		VerificationHandler.verifyTrue(homePage.verifyIfCustomizedHomeLinkIsFirstAndClick());
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		// Step 1
		log(logger, "Verifying and clicking on Graduation Cohort ");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClickUsingContains(
						PropertiesRepository.getString("id.home.graduation.and.course.cohorts.top.menu.loc"),
						PropertiesRepository.getString("id.home.graduation.cohorts.top.menu.value"), true,
						"Graduation/ Course Cohorts menu link"),
				"Unable to click Graduation/ Course Cohorts menu link");
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		// Step 1
		log(logger, "Clicking on Graduation Check box which is not checked in table");
		homePage.clickCohortFromTable();

		// Step 1
		log(logger, "Clicking on Save button in Course Cohort");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(
						PropertiesRepository.getString("id.home.cohort.save.and.view.dashboard.button.loc"), false),
				"save and view dashboard button is not enabled");

		// Step 2
		log(logger, "Clicking on Apply Button from Filter Section");
		homePage.verifyAndClick(PropertiesRepository.getString("id.home.customize.home.cohort.apply.button.loc"), true);

		// Step 2
		log(logger, "Verifying You have unsaved changes message");
		VerificationHandler.verifyTrue(homePage.verifyMessage("id.home.customize.home.filter.apply.button.unsaved.error.message.loc", 0,
				PropertiesRepository
						.getString("id.home.customize.home.filter.apply.button.unsaved.error.message.value")), "Unable to verify You have unsaved changes message");

		// Step 2
		log(logger, "Verifying Click Proceed or Cancel message");
		VerificationHandler.verifyTrue(homePage.verifyMessage(
				"id.home.customize.home.filter.apply.button.unsaved.error.message.click.proceed.or.cancel.loc", 0,
				PropertiesRepository.getString(
						"id.home.customize.home.filter.apply.button.unsaved.error.message.click.proceed.or.cancel.value")), "Unable to verify Click Proceed or Cancel message");

		// Step 2
		log(logger, "Verifying Cancel Button");
		VerificationHandler.verifyTrue(homePage.verifyMessage(
				"id.home.customize.home.filter.apply.button.unsaved.error.message.cancel.and.proceed.btn.loc", 0,
				PropertiesRepository.getString(
						"id.home.customize.home.filter.apply.button.unsaved.error.message.cancel.and.proceed.btn.cancel.value")), "Unable to Verify Cancel Button");

		// Step 2
		log(logger, "Verifying Proceed Button");
		VerificationHandler.verifyTrue(homePage.verifyMessage(
				"id.home.customize.home.filter.apply.button.unsaved.error.message.cancel.and.proceed.btn.loc", 1,
				PropertiesRepository.getString(
						"id.home.customize.home.filter.apply.button.unsaved.error.message.cancel.and.proceed.btn.proceed.value")), "Unable to verify Proceed Button");

		logger.info("INST1982_VerifyGraduationFilterApplyBtn End");
	}
	
	/**
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	@TestAnnotations(testID="INST-2090")
	@Test(priority = 7, alwaysRun =true, enabled = true, groups={"Smoke"}, description = "Go to customize home page from home landing add/remove tile")
	public void INST2090_VerifyAddRemoveTileInHomePage() throws Exception {
		log(logger, "INST2090_VerifyAddRemoveTileInHomePage Start");
		logger.info("INST2090_VerifyAddRemoveTileInHomePage Start");
		
		//Step 1
		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.hm2.instructor3.username"),
				PropertiesRepository.getString("id.auto.hm2.instructor3.password"));
		
		log(logger, "Verifying Add Remove Section header");
		VerificationHandler.verifyTrue(homePage.verifyTextContains(
				PropertiesRepository.getString("id.proctor.home.page.add.remove.section.header.loc"),
				PropertiesRepository.getString(
						"id.proctor.home.page.add.remove.section.header.value")), "Unable to Verify Add Remove Section header");
		
		log(logger, "Verifying Add Remove section button");
		VerificationHandler.verifyTrue(homePage.verifyTextContains(
				PropertiesRepository.getString("id.proctor.home.page.add.remove.section.header.button.loc"), 
				PropertiesRepository.getString(
						"id.proctor.home.page.add.remove.section.header.button.value")), "Unable to Verify Add Remove section button");
		
		log(logger, "INST2090_VerifyAddRemoveTileInHomePage End");
		logger.info("INST2090_VerifyAddRemoveTileInHomePage End");
	}
	
	/**
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	@TestAnnotations(testID="INST-2089")
	@Test(priority = 8, alwaysRun =true, enabled = true, groups={"Smoke"}, description = "Verify removing the cohort tile after removing from home dashboard")
	public void INST2089_VerifyRemovedCohortInHomeDashboard() throws Exception {
		log(logger, "INST2089_VerifyRemovedCohortInHomeDashboard Start");
		logger.info("INST2089_VerifyRemovedCohortInHomeDashboard Start");
		
		//Step 1
		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.hm2.instructor3.username"),
				PropertiesRepository.getString("id.auto.hm2.instructor3.password"));
		
		log(logger, "Click on Ellipses on the top right corner");
		loginPage.clickButton(PropertiesRepository.getString("id.homepage.static.menu"), 1);
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying if Customized Home link is displayed at the top and click on it");
		VerificationHandler.verifyTrue(homePage.verifyIfCustomizedHomeLinkIsFirstAndClick());
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Verifying and clicking on Graduation Cohort ");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClickUsingContains(
						PropertiesRepository.getString("id.home.graduation.and.course.cohorts.top.menu.loc"),
						PropertiesRepository.getString("id.home.graduation.cohorts.top.menu.value"), true,
						"Graduation/ Course Cohorts menu link"),
				"Unable to click Graduation/ Course Cohorts menu link");
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		// Step 2
		log(logger, "To check PN institution name is checked or not and clicking on Save / View Dashboard button");
		String pnCohortName = homePage.verifyInstitutionSelectedInGraduationCohort(
				PropertiesRepository.getString("id.zzIT.test.college.2.institute.name"), PropertiesRepository.getString("id.cohort.input.2089.value"));
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		// Step 2
		log(logger, "Veriyfing Graduation Cohort name is not displayed in Dashboard");
		VerificationHandler.verifyFalse(
				homePage.verifyCohortAndItsNameInDashboardAndItsInstutiton(
						PropertiesRepository.getString("id.home.graduation.cohorts.home.page.value"), pnCohortName,
						PropertiesRepository.getString("id.zzIT.test.college.2.institute.name")),
				"Unable to verify Cohort name in dashboard");
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));		
		
		log(logger, "Click on Ellipses on the top right corner");
		loginPage.clickButton(PropertiesRepository.getString("id.homepage.static.menu"), 1);
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying if Customized Home link is displayed at the top and click on it");
		VerificationHandler.verifyTrue(homePage.verifyIfCustomizedHomeLinkIsFirstAndClick());
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying and clicking on Course Cohort ");
		VerificationHandler.verifyTrue(homePage.verifyAndClickUsingContains(PropertiesRepository.getString("id.home.graduation.and.course.cohorts.top.menu.loc"), 
				PropertiesRepository.getString("id.home.graduation.cohorts.top.menu.value"), true,  "Graduation/ Course Cohorts menu link"), "Unable to click Graduation/ Course Cohorts menu link");
		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Reset check Graduation cohort name in Customize page");
		VerificationHandler.verifyTrue(
				homePage.resetCohortName(PropertiesRepository.getString("id.home.cohort.unchecked.checkbox.cohort.table.loc"), 
						PropertiesRepository.getString("id.cohort.input.2089.value")),
				"Unable to reset checked cohort in customize page");
		
		log(logger, "Clicking on Save And View Dashboard button in Course Cohort");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.cohort.save.and.view.dashboard.button.loc"), true), "Unable to click on save and view dashboard button");

		
		log(logger, "INST2089_VerifyRemovedCohortInHomeDashboard End");
		logger.info("INST2089_VerifyRemovedCohortInHomeDashboard End");
	}
	
	
	/**
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	@TestAnnotations(testID="INST-2096")
	@Test(priority = 9, alwaysRun =true, enabled = true, groups={"Smoke"}, description = "Verify top navigation for instructor")
	public void INST2096_VerifyTopNavigationForIntructor() throws Exception {
		log(logger, "INST2096_VerifyTopNavigationForIntructor Start");
		logger.info("INST2096_VerifyTopNavigationForIntructor Start");
		
		//Step 1
		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.hm2.instructor3.username"),
				PropertiesRepository.getString("id.auto.hm2.instructor3.password"));
		
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				productsPage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Verifying Products Tab from Left navigation");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "apps", true),
				"Unable to verify  Products   ");
		productsPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Clicking on Cohort search img");
		VerificationHandler.verifyTrue(
				productsPage.verifyAndClick(PropertiesRepository.getString("id.product.page.cohort.search.img.loc"), true),
		"Unable to click on cohort search image");
		productsPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying Default Institution Name");
		productsPage.verifyMessage("id.products.search.button.default.institution.name.loc", 0,
				PropertiesRepository.getString("id.products.search.button.default.institution.name.value"));
		
		log(logger, "Clicking on Institution text box in Product page");
		VerificationHandler.verifyTrue(
				productsPage.enterInsititionNameInProductPage(PropertiesRepository.getString("id.home.page.enter.base.institution.2067.value1")), 
		"Unable to Click on Enter base Institution text box in home page");
		
		log(logger, "Searching cohort name in search text box.");
		productsPage.enterText(
				PropertiesRepository.getString("id.product.page.cohort.search.textbox.loc"),
				PropertiesRepository.getString("id.cohort.input.2094.value1")); 
		productsPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying Cohort name and clicking on same");
		VerificationHandler.verifyTrue(
				productsPage.verifyMessage(("id.product.page.cohort.search.result.name.loc"),0,
				PropertiesRepository.getString("id.cohort.input.2094.value1")), 
		"Unable to verify cohort name after searching");
		
		log(logger, "Clicking on Cohort name after searching");
		VerificationHandler.verifyTrue(
				productsPage
				.verifyAndClick(PropertiesRepository.getString("id.product.page.cohort.search.result.name.loc"), true), 
				"Unable to click on cohort name after searching");
		productsPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying Cohort name in Home page");
		VerificationHandler.verifyTrue(productsPage.verifyMessage("id.home.page.cohort.name.loc", 1, PropertiesRepository.getString("id.cohort.input.2094.value1")),
				"Unable to Verify Cohort name in Home page");
		
		// Verifying for invalid cohort name - Start
				log(logger, "Logic for verifying invalid cohort Start");
				log(logger, "Clicking on left navigation icon");
				VerificationHandler.verifyTrue(
						productsPage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
						"Unable to click left navigation");

				log(logger, "Verifying Products Tab from Left navigation");
				VerificationHandler.verifyTrue(
						homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "apps", true),
						"Unable to verify  Products   ");
				productsPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				
				log(logger, "Clicking on Cohort search img");
				VerificationHandler.verifyTrue(
						productsPage.verifyAndClick(PropertiesRepository.getString("id.product.page.cohort.search.img.loc"), true),
				"Unable to click on cohort search image");
				productsPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				
				log(logger, "Clicking on Institution text box in Product page");
				VerificationHandler.verifyTrue(
						productsPage.enterInsititionNameInProductPage(PropertiesRepository.getString("id.home.page.enter.base.institution.2067.value1")), 
				"Unable to Click on Enter base Institution text box in home page");
				
				log(logger, "Searching cohort name in search text box.");
				productsPage.enterText(
						PropertiesRepository.getString("id.product.page.cohort.search.textbox.loc"),
						PropertiesRepository.getString("id.cohort.input.2094.invalid.value1")); 
				productsPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				
				log(logger, "Verifying Cohort name and it should not be displayed");
				VerificationHandler.verifyFalse(
						productsPage.verifyMessage(("id.product.page.cohort.search.result.name.loc"),0,
						PropertiesRepository.getString("id.cohort.input.2094.invalid.value1")), 
				"Unable to verify cohort name after searching");
				// Verifying for invalid cohort name - End
				log(logger, "Logic for verifying invalid cohort End");
				
				log(logger, "Logic for verifying People Tab Start");
				// Verifying Institution name in People tab - Start
				log(logger, "Clicking on left navigation icon");
				VerificationHandler.verifyTrue(
						homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
						"Unable to click left navigation");

				log(logger, "Verifying People Tab from Left navigation");
				VerificationHandler.verifyTrue(
						homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "people", true),
						"Unable to verify People Link");
				loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				
				log(logger, "Verifying Student Roster page is displayed");
				VerificationHandler.verifyTrue(
						productsPage.verifyElementExists(PropertiesRepository
								.getString("id.product.manage.roster.student.roster.page.student.roster.tab.loc")),
						"Unable to Verifying Student Roster page is displayed");
				
				log(logger, "Verifying Default Institution Name");
				productsPage.verifyMessage("id.products.search.button.default.institution.name.loc", 0,
						PropertiesRepository.getString("id.products.search.button.default.institution.name.value"));
				
				log(logger, "Clicking on Institution text box in Product page");
				VerificationHandler.verifyTrue(
						productsPage.enterInsititionNameInProductPage(PropertiesRepository.getString("id.home.page.enter.base.institution.2067.value1")), 
				"Unable to Click on Enter base Institution text box in home page");
				
				log(logger, "Searching cohort name in search text box.");
				productsPage.enterTextInInstitution(
						PropertiesRepository.getString("id.product.page.cohort.search.textbox.loc"),
						PropertiesRepository.getString("id.cohort.input.2094.value1")); 
				productsPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				
				log(logger, "Verifying Cohort name and clicking on same");
				VerificationHandler.verifyTrue(
						productsPage.verifyMessage(("id.product.page.cohort.search.result.name.loc"),0,
						PropertiesRepository.getString("id.cohort.input.2094.value1")), 
				"Unable to verify cohort name after searching");
				// Verifying Institution name in People tab - End
				log(logger, "Logic for verifying People Tab End");
		
        log(logger, "INST2096_VerifyTopNavigationForIntructor End");
		logger.info("INST2096_VerifyTopNavigationForIntructor End");
	}
	
	
	@TestAnnotations(testID="INST-2096")
	@Test(priority = 10, alwaysRun = true, enabled = true, groups={"Regression"}, description = "Verify top navigation for instructor")
	public void INST2096_VerifyTopNavigationForInstructor() throws Exception {
		log(logger, "INST2096_VerifyTopNavigationForInstructor Start");
		logger.info("INST2096_VerifyTopNavigationForInstructor Start");

		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.2096.username"),
				PropertiesRepository.getString("id.login.2096.password"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				productsPage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Verifying Products Tab from Left navigation");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "apps", true),
				"Unable to verify  Products   ");
		productsPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Clicking on Manage Roster icon");
		VerificationHandler.verifyTrue(
				productsPage.verifyAndClickswitchToCardShadowFrame(
						PropertiesRepository.getString("id.product.manage.products.manage.roster.loc"), false),
				"Unable to click manage roster icon");
		
		log(logger, "Clicking on Cohort search img");
		VerificationHandler.verifyTrue(
				productsPage.verifyAndClick(PropertiesRepository.getString("id.product.page.cohort.search.img.loc"), true),
		"Unable to click on cohort search image");
		productsPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying Default Institution Name");
		productsPage.verifyMessage("id.products.search.button.default.institution.name.loc", 0,
				PropertiesRepository.getString("id.products.search.button.default.institution.name.value"));
		
		log(logger, "Clicking on Institution text box in Product page");
		VerificationHandler.verifyTrue(
				productsPage.enterInsititionNameInProductPage(PropertiesRepository.getString("id.home.page.enter.base.institution.2096.value")), 
		"Unable to Click on Enter base Institution text box in home page");
		
		log(logger, "Searching cohort name in search text box.");
		productsPage.enterText(
				PropertiesRepository.getString("id.product.page.cohort.search.textbox.loc"),
				PropertiesRepository.getString("id.cohort.input.2096.value")); 
		productsPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying Cohort name and clicking on same");
		VerificationHandler.verifyTrue(
				productsPage.verifyMessage(("id.product.page.cohort.search.result.name.loc"),0,
				PropertiesRepository.getString("id.cohort.input.2096.value")), 
		"Unable to verify cohort name after searching");
		
		log(logger, "Clicking on Cohort name after searching");
		VerificationHandler.verifyTrue(
				productsPage
				.verifyAndClick(PropertiesRepository.getString("id.product.page.cohort.search.result.name.loc"), true), 
				"Unable to click on cohort name after searching");
		productsPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying Cohort in Products Page");
		productsPage.verifyAndClickswitchToCardShadowFrame(PropertiesRepository.getString("id.product.manage.roster.faculty.roster.table.cohort.name.loc"), false);
		
		// Verifying for invalid cohort name - Start
		log(logger, "Logic for verifying invalid cohort Start");
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				productsPage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Verifying Products Tab from Left navigation");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "apps", true),
				"Unable to verify  Products   ");
		productsPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Clicking on Manage Roster icon");
		VerificationHandler.verifyTrue(
				productsPage.verifyAndClickswitchToCardShadowFrame(
						PropertiesRepository.getString("id.product.manage.products.manage.roster.loc"), false),
				"Unable to click manage roster icon");
		
		log(logger, "Clicking on Cohort search img");
		VerificationHandler.verifyTrue(
				productsPage.verifyAndClick(PropertiesRepository.getString("id.product.page.cohort.search.img.loc"), true),
		"Unable to click on cohort search image");
		productsPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Clicking on Institution text box in Product page");
		VerificationHandler.verifyTrue(
				productsPage.enterInsititionNameInProductPage(PropertiesRepository.getString("id.home.page.enter.base.institution.2096.value")), 
		"Unable to Click on Enter base Institution text box in home page");
		
		log(logger, "Searching cohort name in search text box.");
		productsPage.enterText(
				PropertiesRepository.getString("id.product.page.cohort.search.textbox.loc"),
				PropertiesRepository.getString("id.cohort.input.2096.invalid.value")); 
		productsPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying Cohort name and it should not be displayed");
		VerificationHandler.verifyFalse(
				productsPage.verifyMessage(("id.product.page.cohort.search.result.name.loc"),0,
				PropertiesRepository.getString("id.cohort.input.2096.invalid.value")), 
		"Unable to verify cohort name after searching");
		
		// Verifying for invalid cohort name - End
		log(logger, "Logic for verifying invalid cohort End");
		
		log(logger, "Logic for verifying People Tab Start");
		// Verifying Institution name in People tab - Start
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(
				homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
				"Unable to click left navigation");

		log(logger, "Verifying People Tab from Left navigation");
		VerificationHandler.verifyTrue(
				homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "people", true),
				"Unable to verify People Link");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying Student Roster page is displayed");
		VerificationHandler.verifyTrue(
				productsPage.verifyElementExists(PropertiesRepository
						.getString("id.product.manage.roster.student.roster.page.student.roster.tab.loc")),
				"Unable to Verifying Student Roster page is displayed");
		
		log(logger, "Verifying Default Institution Name");
		productsPage.verifyMessage("id.products.search.button.default.institution.name.loc", 0,
				PropertiesRepository.getString("id.products.search.button.default.institution.name.value"));
		
		log(logger, "Clicking on Institution text box in Product page");
		VerificationHandler.verifyTrue(
				productsPage.enterInsititionNameInProductPage(PropertiesRepository.getString("id.home.page.enter.base.institution.2096.value")), 
		"Unable to Click on Enter base Institution text box in home page");
		
		log(logger, "Searching cohort name in search text box.");
		productsPage.enterTextInInstitution(
				PropertiesRepository.getString("id.product.page.cohort.search.textbox.loc"),
				PropertiesRepository.getString("id.cohort.input.2096.value")); 
		productsPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Verifying Cohort name and clicking on same");
		VerificationHandler.verifyTrue(
				productsPage.verifyMessage(("id.product.page.cohort.search.result.name.loc"),0,
				PropertiesRepository.getString("id.cohort.input.2096.value")), 
		"Unable to verify cohort name after searching");
		// Verifying Institution name in People tab - End
		log(logger, "Logic for verifying People Tab End");
		
		log(logger, "INST2096_VerifyTopNavigationForInstructor End");
		logger.info("INST2096_VerifyTopNavigationForInstructor End");
	}


}
