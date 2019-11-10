package com.automation.newati.nclex;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyATITabMainPage;
import com.automation.newati.pages.MyReportPage;
import com.automation.newati.pages.NclexPrepTabPage;
import com.automation.newati.pages.PractiseAssessmentPage;
import com.automation.newati.pages.TestTabPage;
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class BoardVitalsTestNew extends BaseTest {
	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private TestTabPage testTabPage;
	private PractiseAssessmentPage practiceAssessmentPage;
	private MyReportPage reportPage;
	private TutorialPage tutorialPage;
	private NclexPrepTabPage nclexPrepTabPage;
	private BaseHandler baseHandler;
	private MyATITabMainPage myATITabMainPage;

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		testTabPage = new TestTabPage(driver);
		practiceAssessmentPage = new PractiseAssessmentPage(driver);
		reportPage = new MyReportPage(driver);
		tutorialPage = new TutorialPage(driver);
		nclexPrepTabPage = new NclexPrepTabPage(driver);
		baseHandler = new BaseHandler(driver);
		myATITabMainPage = new MyATITabMainPage(driver);
	}

	/**
	 *
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-1015")
	@Test(priority = 1, enabled = true, groups = {
			"Regression" }, alwaysRun = true, description = "NewATI-1015:Verify Board vitals disabled functionality when the class is >120 days from graduation")
	public void NewATI1015_verifyBVDisableFun() throws Exception {

		log(logger, "NewATI1015_verifyBVDisableFun Start");

		// Step 1
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.1015"),
				PropertiesRepository.getString("newati.nclex.bv.login.user.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verifying if Home page is displayed");
		VerificationHandler.verifyTrue(driver.getTitle().equals("Home - ATI Testing"));

		// Step 2
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verifying if All Tabs are displayed");
		VerificationHandler.verifyTrue(myATITabMainPage.verifyAllTabsDisplayed());

		// Step 3
		log(logger, "Clicking on NCLEX PREP Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 4);

		// Step 4
		log(logger, "Uncheck Hide disabled products check box");
		homePage.clickButton(PropertiesRepository.getString("new.atitestig.nclex.checkbox.loc"));

		log(logger, "Verify if disabled board vital product are be displayed");
		VerificationHandler.verifyTrue(baseHandler
				.findElements(PropertiesRepository.getString("new-atitesting.nclex.inactive.bv.products.loc"))
				.size() != 0);

		// Step 5
		log(logger, "Verify that card front is disabled for both RN and PV board vital products");
		VerificationHandler.verifyTrue(nclexPrepTabPage.verifyNclexAccessNever(
				PropertiesRepository.getString("new-atitesting.nclexprep.tab.rn.product.name")));
		VerificationHandler.verifyTrue(nclexPrepTabPage
				.verifyNclexAccessNever(PropertiesRepository.getString("new-atitesting.nclexprep.tab.product.name")));

		// Step 6
		log(logger, "Verify available date for RN board vital product");
		VerificationHandler.verifyTrue(nclexPrepTabPage.verifyAvailableDateNclex(
				PropertiesRepository.getString("new-atitesting.nclexprep.tab.rn.product.name"),
				"Available: " + PropertiesRepository.getString("new-atitesting.nclexprep.tab.rn.availableDate")));

		log(logger, "Verify available date for PN board vital product");
		VerificationHandler.verifyTrue(nclexPrepTabPage.verifyAvailableDateNclex(
				PropertiesRepository.getString("new-atitesting.nclexprep.tab.product.name"),
				"Available: " + PropertiesRepository.getString("new-atitesting.nclexprep.tab.pn.availableDate")));

		// Step 7
		log(logger, "Verify expires date for RN board vital product");
		VerificationHandler.verifyTrue(nclexPrepTabPage.verifyExpiresDateNclexInavtiveProd(
				PropertiesRepository.getString("new-atitesting.nclexprep.tab.rn.product.name"),
				PropertiesRepository.getString("new-atitesting.nclexprep.tab.rn.expiresDate")));

		log(logger, "Verify expires date for PN board vital product");
		VerificationHandler.verifyTrue(nclexPrepTabPage.verifyExpiresDateNclexInavtiveProd(
				PropertiesRepository.getString("new-atitesting.nclexprep.tab.product.name"),
				PropertiesRepository.getString("new-atitesting.nclexprep.tab.pn.expiresDate")));

		// Step 8
		log(logger, "Verify Accessed Never for RN board vital product");
		VerificationHandler.verifyTrue(nclexPrepTabPage.verifyAccessedStatusNclex(
				PropertiesRepository.getString("new-atitesting.nclexprep.tab.rn.product.name"), "Never"));

		log(logger, "Verify Accessed Never for PN board vital product");
		VerificationHandler.verifyTrue(nclexPrepTabPage.verifyAccessedStatusNclex(
				PropertiesRepository.getString("new-atitesting.nclexprep.tab.product.name"), "Never"));

		logger.info("NewATI1015_verifyBVDisableFun End");
	}

	/**
	 *
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-1022")
	@Test(priority = 2, enabled = true, groups = {
			"Regression" }, alwaysRun = true, description = "NewATI-1022: Verify card front of board vital for multiple instances")
	public void NewATI1022_verifyBVMultipleInstance() throws Exception {

		log(logger, "NewATI1022_verifyBVMultipleInstance Start");
		
		// Step 1 and 2
		loginPage.loginToApplication(PropertiesRepository.getString("newati.nclex.bv.login.user1022.name"),
				PropertiesRepository.getString("newati.nclex.bv.login.user.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verifying if Home page is displayed");
		VerificationHandler.verifyTrue(driver.getTitle().equals("Home - ATI Testing"));

		// Step 3
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verifying if All Tabs are displayed");
		VerificationHandler.verifyTrue(myATITabMainPage.verifyAllTabsDisplayed());

		// Step 4
		log(logger, "Clicking on NCLEX PREP Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 4);

		log(logger, "Verifying if Board Vitals NCLEX Prep RN is displayed");
		VerificationHandler.verifyTrue(nclexPrepTabPage.verifyProductIsDiasplayed(
				PropertiesRepository.getString("new-atitesting.nclexprep.tab.rn.product.name"),
				"#tabs-6 .description"));

		log(logger, "Verifying if Board Vitals NCLEX Prep PN is displayed");
		VerificationHandler.verifyTrue(nclexPrepTabPage.verifyProductIsDiasplayed(
				PropertiesRepository.getString("new-atitesting.nclexprep.tab.product.name"), "#tabs-6 .description"));

		//Step 5
		log(logger, "Verify expires date for PN board vital product is not displayed");
		VerificationHandler.verifyTrue(!(nclexPrepTabPage.verifyExpiresDateNclex(	PropertiesRepository.getString("new-atitesting.nclexprep.tab.product.name"),PropertiesRepository.getString("new-atitesting.nclexprep.tab.rn.expiresDate"))));
		
		//Step 6
		log(logger, "Click on begin button for Board Vitals NCLEX Prep PN");
		tutorialPage.clickOnNCLEXModuleButton(PropertiesRepository.getString("new-atitesting.nclexprep.tab.product.name"));
		
		log(logger, "Verify if Select instance modal window is displayed");
		VerificationHandler.verifyTrue(baseHandler.findElement(PropertiesRepository.getString("new-atitesting.select.instance.modal.window.loc")).isDisplayed());
		
		//Step 7
		log(logger, "Verify the datails for each instances");
		VerificationHandler.verifyTrue(nclexPrepTabPage.verifyOnlineStoreGCandCCDetails(
				PropertiesRepository.getString("new-atitesting.nclexprep.onlinestore.id"),
				PropertiesRepository.getString("new-atitesting.nclexprep.onlinestore.expiredOn.date"),
				PropertiesRepository.getString("new-atitesting.nclexprep.gc.id"),
				PropertiesRepository.getString("new-atitesting.nclexprep.gc.accessed"),
				PropertiesRepository.getString("new-atitesting.nclexprep.gc.expiresOn.date"),
				PropertiesRepository.getString("new-atitesting.nclexprep.cc.id"),				
				PropertiesRepository.getString("new-atitesting.nclexprep.cc.available.date"),
				PropertiesRepository.getString("new-atitesting.nclexprep.cc.expiresOn.date")));

		logger.info("NewATI1022_verifyBVMultipleInstance End");
	}
	
	/**
	 *
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-1023")
	@Test(priority = 3, enabled = true, groups = {
			"Regression" }, alwaysRun = true, description = "NewATI-1023: Verify content area tagged for board vital")
	public void NewATI1023_verifyBVContentArea() throws Exception {

		log(logger, "NewATI1023_verifyBVContentArea Start");

		// Step 1 and 2
		loginPage.loginToApplication(PropertiesRepository.getString("newati.nclex.bv.login.user1023.name"),
				PropertiesRepository.getString("newati.nclex.bv.login.user.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verifying if Home page is displayed");
		VerificationHandler.verifyTrue(driver.getTitle().equals("Home - ATI Testing"));

		// Step 3
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verifying if All Tabs are displayed");
		VerificationHandler.verifyTrue(myATITabMainPage.verifyAllTabsDisplayed());

		// Step 4
		log(logger, "Clicking on NCLEX PREP Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 4);

		log(logger, "Verifying if Board Vitals NCLEX Prep RN is displayed");
		VerificationHandler.verifyTrue(nclexPrepTabPage.verifyProductIsDiasplayed(
				PropertiesRepository.getString("new-atitesting.nclexprep.tab.rn.product.name"),
				"#tabs-6 .description"));

		log(logger, "Verifying if Board Vitals NCLEX Prep PN is displayed");
		VerificationHandler.verifyTrue(nclexPrepTabPage.verifyProductIsDiasplayed(
				PropertiesRepository.getString("new-atitesting.nclexprep.tab.product.name"), "#tabs-6 .description"));

		// Step 5
		log(logger, "Selecting 'Fundamentals' Option from Content Area");
		tutorialPage.selectValueBySelectClass(
				PropertiesRepository.getString("new-atitesting.content.area.dropdown.loc"),
				PropertiesRepository.getString("new-atitesting.content.area.value.fundamentals"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verifying if Board Vitals NCLEX Prep RN is not displayed");
		VerificationHandler.verifyTrue(!(nclexPrepTabPage.verifyProductIsDiasplayed(
				PropertiesRepository.getString("new-atitesting.nclexprep.tab.rn.product.name"),
				"#tabs-6 .description")));

		log(logger, "Verifying if Board Vitals NCLEX Prep PN is not displayed");
		VerificationHandler.verifyTrue(!(nclexPrepTabPage.verifyProductIsDiasplayed(
				PropertiesRepository.getString("new-atitesting.nclexprep.tab.product.name"), "#tabs-6 .description")));

		logger.info("NewATI1023_verifyBVContentArea End");
	}

}
