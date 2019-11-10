package com.automation.newati.board.vitals;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.NclexPrepTabPage;

public class VerifyBoardVitalsFunctionalityTest2 extends BaseTest {

	Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
			
	private NclexPrepTabPage nclexPrepTabPage;
	@BeforeMethod
	public void VerifyLearnTabScenariosReview() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		nclexPrepTabPage=new NclexPrepTabPage(driver);
	}
	
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-578:Verify the UI in Card Front page of Board Vitals NCLEX Prep for disabled status")
	public void NewATI578_VerifyAccessNeverInCardFrontPage() throws Exception {
		logger.info("Method : NewATI578_VerifyAccessNeverInCardFrontPage Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.nclex.preptab.login.user.name.new"), PropertiesRepository.getString("newati.nclex.preptab.renew.login.pwd"));
		
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking NCLEXPREP Tab");
		homePage.clickSubTab(4);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		boolean verifySubTabs = nclexPrepTabPage.verifySubTabs();
		VerificationHandler.verifyTrue(verifySubTabs);
		
		boolean result=nclexPrepTabPage.verifyNclexAccessNever(PropertiesRepository.getString("new-atitesting.nclexprep.tab.rn.product.name"));
		VerificationHandler.verifyTrue(result);
		
		logger.info("Method : NewATI578_VerifyAccessNeverInCardFrontPage End");
	}
	
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-586:Verify the card front page before accessing the module")
	public void NewATI586_VerifyCardBeforeAccessing() throws Exception {
		logger.info("Method : NewATI586_VerifyCardBeforeAccessing Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.nclex.preptab.login.user.name.new"), PropertiesRepository.getString("newati.nclex.preptab.renew.login.pwd"));
		
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		
		log(logger, "Clicking NCLEXPREP Tab");
		homePage.clickSubTab(4);
		
		VerificationHandler.verifyTrue(nclexPrepTabPage.verifySubTabs(), "Unable to verify Sub Tabs");
		
		VerificationHandler.verifyTrue(nclexPrepTabPage.verifyProductType("new-atitesting.nclexprep.product.header"), "Unable to verify Adaptive Test ");
		
		VerificationHandler.verifyTrue(nclexPrepTabPage.verifyNclexAccessNever(PropertiesRepository.getString("new-atitesting.nclexprep.tab.rn.product.name")), "Unable to viery Access Never message");
		
		logger.info("Method : NewATI586_VerifyCardBeforeAccessing End");
	}
	
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-589:Verify Board Vital Product part of a CDN and less than 30 days on graduate")
	public void NewATI589_VerifyCDNLessThan30Days() throws Exception {
		logger.info("Method : NewATI589_VerifyCDNLessThan30Days Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.nclex.preptab.login.user.name.new"), PropertiesRepository.getString("newati.nclex.preptab.renew.login.pwd"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking NCLEXPREP Tab");
		homePage.clickSubTab(4);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyTrue(nclexPrepTabPage.verifySubTabs(), "Unable to verify Sub Tabs");
		
		VerificationHandler.verifyTrue(nclexPrepTabPage.verifyProductType("new-atitesting.nclexprep.product.header"), "Unable to verify Adaptive Test ");
		
		VerificationHandler.verifyTrue(nclexPrepTabPage.verifyNclexAccessNever(PropertiesRepository.getString("new-atitesting.nclexprep.tab.rn.product.name")), "Unable to viery Access Never message");
		
		logger.info("Method : NewATI589_VerifyCDNLessThan30Days End");
	}
	
	@Test(priority = 4, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-591:Verify Board Vital products part of institution purchase less than 30 days of graduation")
	public void NewATI591_VerifyInstitutionLessThan30Days() throws Exception {
		logger.info("Method : NewATI591_VerifyInstitutionLessThan30Days Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.nclex.preptab.login.user.name.new"), PropertiesRepository.getString("newati.nclex.preptab.renew.login.pwd"));
		
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking NCLEXPREP Tab");
		homePage.clickSubTab(4);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyTrue(nclexPrepTabPage.verifySubTabs(), "Unable to verify Sub Tabs");
		
		VerificationHandler.verifyTrue(nclexPrepTabPage.verifyProductType("new-atitesting.nclexprep.product.header"), "Unable to verify Adaptive Test ");
		
		VerificationHandler.verifyTrue(nclexPrepTabPage.verifyNclexAccessNever(PropertiesRepository.getString("new-atitesting.nclexprep.tab.rn.product.name")), "Unable to viery Access Never message");
		
		logger.info("Method : NewATI591_VerifyInstitutionLessThan30Days End");
	}
	
	@Test(priority = 5, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-594:Verify Board Vital product after Expiry")
	public void NewATI594_VerifyBoardVitalAfterExpiry() throws Exception {
		logger.info("Method : NewATI594_VerifyBoardVitalAfterExpiry Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.nclex.preptab.login.user.name.new"), PropertiesRepository.getString("newati.nclex.preptab.renew.login.pwd"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking NCLEXPREP Tab");
		homePage.clickSubTab(4);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyTrue(nclexPrepTabPage.verifySubTabs(), "Unable to verify Sub Tabs");
		
		VerificationHandler.verifyTrue(nclexPrepTabPage.verifyProductType("new-atitesting.nclexprep.product.header"), "Unable to verify Adaptive Test ");
		
		VerificationHandler.verifyTrue(nclexPrepTabPage.verifyNclexExpiredAssessment(PropertiesRepository.getString("new-atitesting.nclexprep.tab.product.name.new")), "Unable to viery Expired message");
		
		logger.info("Method : NewATI594_VerifyBoardVitalAfterExpiry End");
	}
}
