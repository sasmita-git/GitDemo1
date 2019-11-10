package com.automation.id.oldtests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
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
	}
	
	@TestAnnotations(testID="INST-1939")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups={"Smoke"}, description = "INST-1939:User is able to schedule an assignment for already created course::Schedule assessment")
	public void INST1939_VerifyScheduledAssignmentForAlreadyCreatedUser() throws Exception {
		logger.info("INST1939_VerifyScheduledAssignmentForAlreadyCreatedUser Start");
		log(logger, "INST1939_VerifyScheduledAssignmentForAlreadyCreatedUser Start");
		
		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.people.instructor.1.username"),
				PropertiesRepository.getString("id.auto.people.instructor.1.password"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true), "Unable to click left navigation");

		log(logger, "Verifying Products Tab from Left navigation");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "apps", true), "Unable to verify  Products   ");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		loginPage.switchToCardShadowFrame();
		log(logger, "verify product id");
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("id.assessment.product.id.loc", 0),"Product id is not visible");
		
		log(logger, "click on schedule assignment tab");
		proctoredAssessmentPage.clickOnScheduleAssessmentButton(PropertiesRepository.getString("id.products.proctored.schedule.assessment.name.value"));
		
		log(logger, "add the assignmnet");
		VerificationHandler.verifyTrue(proctoredAssessmentPage.addAssessmentForProctoredAssessment(), "Unable to add Assignment");
		
		boolean verifyAssignmentPopUpObjects = proctoredAssessmentPage.verifyAssignmentPopUpObjects();
		VerificationHandler.verifyTrue(verifyAssignmentPopUpObjects, "Assignment objects are not visible");
		
		log(logger, "verify assignmnet is added or not");
		boolean result=proctoredAssessmentPage.verifyAddedAssignment("id.assessment.schedule.assignment.table.loc");
		VerificationHandler.verifyTrue(result, "Assignment is not added");
		
		log(logger, "INST1939_VerifyScheduledAssignmentForAlreadyCreatedUser End");
		logger.info("INST1939_VerifyScheduledAssignmentForAlreadyCreatedUser End");
	}
	
	@TestAnnotations(testID="INST-1655")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups={"Smoke"}, description = "INST-1655:Verify product page tab feature::Smoke Test Suite")
	public void INST1655_VerifyProductPageTabFeature() throws Exception {
		logger.info("INST1655_VerifyProductPageTabFeature Start");

		loginPage.loginToApplication1(PropertiesRepository.getString("id.auto.prd.instuctor3.username"), 
				PropertiesRepository.getString("id.auto.prd.instuctor3.password"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
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
		
		logger.info("INST1655_VerifyProductPageTabFeature End");
	}
}

