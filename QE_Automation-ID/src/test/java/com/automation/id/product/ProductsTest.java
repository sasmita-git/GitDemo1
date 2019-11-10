package com.automation.id.product;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.WindowHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.id.pages.HomePage;
import com.automation.id.pages.LoginPage;
import com.automation.id.pages.ProctoredAssessmentPage;
import com.automation.id.pages.ProductsPage;
import com.jaca.TestAnnotations;

public class ProductsTest extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	LoginPage loginPage;
	HomePage homePage;
	ProctoredAssessmentPage proctoredAssessmentPage;
	ProductsPage productsPage;
	
	@BeforeMethod(alwaysRun = true) 
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		log(logger, "Login to application");
		proctoredAssessmentPage=new ProctoredAssessmentPage(driver);
		productsPage=new ProductsPage(driver);
		loginPage.loginToApplication1(PropertiesRepository.getString("id.faculty..home2.0.login.user.name"), PropertiesRepository.getString("id.faculty..home2.0.login.password"));
	}
	
	//@TestAnnotations(testID="INST-1735")
	//@Test(priority = 1, alwaysRun = true, enabled = true, groups={"Smoke","Regression"}, description = "Verify the sub-tab present under Products page::Regression")
	public void INST1735_VerifyProctorSubTabs() throws Exception {
		logger.info("INST1735_VerifyProctorSubTabs Start");

		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "click on close button");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.home.page.alert.close"), 0);
		
		log(logger, "Entering cohort");
		//homePage.selectCohort(PropertiesRepository.getString("id.1631.cohort.name"));
		homePage.selectCohort(PropertiesRepository.getString("id.1631.cohort.name.product"));
		
		
		log(logger,"Clicking on Left Navigation Link");
		loginPage.verifyAndClick(PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true);
		
		log(logger, "Verifying Products Link in Left Navigation");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText(1, "apps", true), "Unable to click Products ");
		
		log(logger, "Clicking on Manage Products Tab");
		loginPage.clickElement("id.home.products.manage.products",0);
		
		log(logger, "verify Manage Products tab name");
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("id.home.products.manage.products",0));
		new WindowHandler(driver).switchToMainWindow();
		
		log(logger, "Clicking on Close Assessments tab");
		loginPage.clickElement("id.home.products.close.assessments",0);
		
		log(logger, "verify Close Assessments tab name");
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("id.home.products.close.assessments",0));
		new WindowHandler(driver).switchToMainWindow();
		
		log(logger, "Clicking on Set Benchmarks Tab");
		loginPage.clickElement("id.home.products.set.bechmarks",0);
		
		log(logger, "verify set benchmark tab name");
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("id.home.products.set.bechmarks",0));
		new WindowHandler(driver).switchToMainWindow();
		
		logger.info("INST1735_VerifyProctorSubTabs End");
	}
	
	@TestAnnotations(testID="INST-1929")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups={"Smoke"}, description = "User is able to open the schedule assignment modal::Schedule assessment")
	public void INST1929_VerifyScheduleAssignmentModal() throws Exception {
		logger.info("INST1929_VerifyScheduleAssignmentModal Start");

		log(logger, "click on close button");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.home.page.alert.close"), 0);
		
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true), "Unable to click left navigation");

		log(logger, "Verifying Products Tab from Left navigation");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", 1, "apps", true), "Unable to verify  Products   ");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		loginPage.switchToCardShadowFrame();
		
		log(logger, "Verifying Product sub tabs");
		VerificationHandler.verifyTrue(productsPage.verifyProductPageMainTabs("id.homepage.product.sub.tab.loc"), "Product page main tabs are not displayed");

		loginPage.switchToCardShadowFrame();
		
		log(logger, "verify product id");
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("id.assessment.product.id.loc", 0),"Product id is not visible");
		
		log(logger, "click on schedule assignment tab");
		loginPage.clickElement("id.assessment.schedule.assignment.loc",0);
		
		boolean verifyAssignmentPopUpObjects = proctoredAssessmentPage.verifyAssignmentPopUpObjects();
		VerificationHandler.verifyTrue(verifyAssignmentPopUpObjects, "Assignment objects are not visible");
		
		logger.info("INST1929_VerifyScheduleAssignmentModal End");
	}
	
	@TestAnnotations(testID="INST-1939")
	@Test(priority = 3, alwaysRun = true, enabled = true, groups={"Smoke"}, description = "User is able to schedule an assignment for already created course::Schedule assessment")
	public void INST1939_VerifySchedulseAssignmentForAlreadyCreatedUser() throws Exception {
		logger.info("INST1939_VerifyScheduleAssignmentForAlreadyCreatedUser Start");

		log(logger, "click on close button");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.home.page.alert.close"), 0);
		
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true), "Unable to click left navigation");

		log(logger, "Verifying Products Tab from Left navigation");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", 1, "apps", true), "Unable to verify  Products   ");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		loginPage.switchToCardShadowFrame();
		log(logger, "verify product id");
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("id.assessment.product.id.loc", 0),"Product id is not visible");
		
		/*log(logger, "verify cohort name");
		boolean verifyTextEquals = homePage.verifyTextEquals(PropertiesRepository.getString("id.assessment.cohort.loc"),PropertiesRepository.getString("id.1929.cohort.name"));
		VerificationHandler.verifyTrue(verifyTextEquals, "unable to validate cohort");*/
		
		log(logger, "click on schedule assignment tab");
		loginPage.clickElement("id.assessment.schedule.assignment.loc",0);
		loginPage.waitForAwhile(30000);
		//loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "add the assignmnet");
		proctoredAssessmentPage.addAssessmentForProctoredAssessment();
		loginPage.waitForAwhile(90000);
		
		log(logger, "verify assignmnet is added or not");
		boolean result=proctoredAssessmentPage.verifyAddedAssignment("id.assessment.schedule.assignment.table.loc");
		VerificationHandler.verifyTrue(result, "Assignment is not added");
		
		logger.info("INST1939_VerifyScheduleAssignmentForAlreadyCreatedUser End");
	}
	
	@TestAnnotations(testID="INST-1655")
	@Test(priority = 4, alwaysRun = true, enabled = true, groups={"Smoke"}, description = "Verify product page tab feature::Smoke Test Suite")
	public void INST1655_VerifyProductPageTabFeature() throws Exception {
		logger.info("INST1655_VerifyProductPageTabFeature Start");

		log(logger, "click on close button");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.home.page.alert.close"), 0);
		
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true), "Unable to click left navigation");

		log(logger, "Verifying Products Tab from Left navigation");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", 1, "apps", true), "Unable to verify  Products   ");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		loginPage.switchToCardShadowFrame();
		
		log(logger, "Verifying Product sub tabs");
		VerificationHandler.verifyTrue(productsPage.verifyProductPageMainTabs("id.homepage.product.sub.tab.loc"), "Product page main tabs are not displayed");
		
		log(logger, "Verifying Manage Product tab header");
		boolean resutlt1=productsPage.navigateToProductsMainTab("id.product.manage.products.page.header.loc","id.product.manage.products.page.header.input",0);
		VerificationHandler.verifyTrue(resutlt1, "Manage Product page is not displayed");
		
		log(logger, "Verifying Close Assessment tab header");
		VerificationHandler.verifyTrue(productsPage.navigateToProductsMainTab("id.product.close.assessment.header.loc","id.product.close.assessment.header.input",2), "Close Assessment tab is not displayed");
		
		log(logger, "Verifying Set Benchmark tab header");
		VerificationHandler.verifyTrue(productsPage.navigateToProductsMainTab("id.product.set.benchmark.header.loc","id.product.set.benchmark.header.input",4), "set benchmark tab is not displayed");
		
		logger.info("INST1655_VerifyProductsPageTabFeature End");
	}

	@TestAnnotations(testID="inst-1923")
	@Test(priority = 5, alwaysRun = true, enabled = true, groups={"Smoke"}, description = "inst-1923: Check for Carriculum cohorts in top selection for complete client")
	public void INST1923_VerifyCurriculumCohort() throws Exception {
		logger.info("INST1923_Check for Carriculum cohorts in top selection for complete client_start");

		log(logger, "Login to application");
		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.faculty.curriculum.username"), PropertiesRepository.getString("id.login.faculty.curriculum.password"));
		
		log(logger, "Verify list of cohorts displayed");
		VerificationHandler.verifyTrue(homePage.verifyCohortList(),"List of cohorts are not displayed");

		log(logger, "Entering cohort");
		VerificationHandler.verifyTrue(homePage.selectCohort(PropertiesRepository.getString("id.stg.curriculum.cohort")),"Cohort selected is not correct");
		
		log(logger, "click on toolbar link");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.layout.link"), 0);
		
		log(logger, "click on products tab");
		loginPage.clickElement("id.homepage.main.menu.list",1);
				
		loginPage.switchToCardShadowFrame();
		
		log(logger,"Verify products");
		VerificationHandler.verifyTrue(homePage.verifyElementExists(PropertiesRepository.getString("id.products.proctoredGrid.loc")),"No products displayed");
							
		logger.info("INST1923_Check for Carriculum cohorts in top selection for complete client_End");
	}
	
	@TestAnnotations(testID="inst-1925")
	@Test(priority = 6, alwaysRun = true, enabled = true, groups={"Smoke"}, description = "Check for Carriculum cohorts in BRM for complete client")
	public void INST1925_VerifyCurriculumCohort_BRM() throws Exception {
		logger.info("INST1925_Check for Carriculum cohorts in BRM for complete client_start");

		log(logger, "Login to application");
		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.faculty.curriculum.username"), PropertiesRepository.getString("id.login.faculty.curriculum.password"));
		
		/*log(logger, "Verify list of cohorts displayed");
		VerificationHandler.verifyTrue(homePage.verifyCohortList(),"List of cohorts are not displayed");

		log(logger, "Entering cohort");
		VerificationHandler.verifyTrue(homePage.selectCohort(PropertiesRepository.getString("id.stg.curriculum.cohort")),"Cohort selected is not correct");
		
		log(logger, "click on toolbar link");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.layout.link"), 0);
		
		log(logger, "click on People tab");
		loginPage.clickElement("id.homepage.main.menu.list",5);*/
		
		/*log(logger, "Veriyfing Course Cohort name in Dashboard");
		VerificationHandler.verifyTrue(
				homePage.verifyCohortAndItsNameInDashboard(
						PropertiesRepository.getString("id.home.course.cohorts.home.page.value"),
						PropertiesRepository.getString("id.home.course.cohort.name.1925.value")),
				"Unable to verify Cohort name in dashboard");*/

		log(logger, "Clicking on Course Cohort Manage Button");
		homePage.verifyAndClickCourseCohortManageButton(PropertiesRepository.getString("id.home.course.cohorts.home.page.value"),
				PropertiesRepository.getString("id.home.course.cohort.name.1925.value"));
		
		log(logger,"Verify products");
		VerificationHandler.verifyTrue(homePage.verifyElementExists(PropertiesRepository.getString("people.roster.studentlist")),"No students displayed");
							
		logger.info("INST1925_Check for Carriculum cohorts in BRM for complete client_End");
	}	
}