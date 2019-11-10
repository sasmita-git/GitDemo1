package com.automation.newati.learntab;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.ApplyTabPage;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyATITabMainPage;
import com.automation.newati.pages.MyReportPage;
import com.automation.newati.pages.MyResultsTabPage;
import com.automation.newati.pages.TutorialPage;

public class STTTest extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private MyATITabMainPage myATITabMainPage;
	private MyReportPage myReportPage;
	private HomePage homePage;
	private TutorialPage tutorialPage;
	private ApplyTabPage applyTabPage;
	private MyResultsTabPage myResultsPage;
	private MyResultsTabPage myResultsTabPage;
		
	

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		myATITabMainPage = new MyATITabMainPage(driver);
		homePage = new HomePage(driver);
		tutorialPage = new TutorialPage(driver);
		applyTabPage = new ApplyTabPage(driver);
		myResultsPage = new MyResultsTabPage(driver);
		myResultsTabPage = new MyResultsTabPage(driver);
		myReportPage = new MyReportPage(driver);
		
	}

	@Test(priority = 1, alwaysRun = true, enabled = true, groups = { "Smoke",
			"Regression" }, description = "Verify Sigma Theta Tau 2017 Modules on card back listed in custom order")
	public void NewATI808_VerifySTTListedInCustomOrder() throws Exception {
		logger.info("NewATI808_VerifySTTListedInCustomOrder Start");
		log(logger, "NewATI808_VerifySTTListedInCustomOrder Start");

		//Step-1
		loginPage.loginToApplication("stagesingleinstance","Test123");
		
		//Step-2 & Step-3
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsAppeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on Learn Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Selecting Tutorial from Learn Tab drop down");
		tutorialPage.selectTutorialFromDropDown(PropertiesRepository.getString("new-atitesting.tutorialDropdown.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		//Step-4
		log(logger, "Clicking Module by Name");
		tutorialPage.clickModuleButtonByName(PropertiesRepository.getString("new-atitesting.Demo.product.name"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		//Step-5
		
		log(logger, "Verify Modules names in card back");
		VerificationHandler.verifyTrue(applyTabPage.verifyCardBackModulelName(PropertiesRepository.getString("sttname10.value")));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		VerificationHandler.verifyTrue(applyTabPage.verifyCardBackModulelName(PropertiesRepository.getString("sttname17.value")));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		VerificationHandler.verifyTrue(applyTabPage.verifyCardBackModulelName(PropertiesRepository.getString("sttname18.value")));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		VerificationHandler.verifyTrue(applyTabPage.verifyCardBackModulelName(PropertiesRepository.getString("sttname16.value")));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		VerificationHandler.verifyTrue(applyTabPage.verifyCardBackModulelName(PropertiesRepository.getString("sttname5.value")));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		VerificationHandler.verifyTrue(applyTabPage.verifyCardBackModulelName(PropertiesRepository.getString("sttname14.value")));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		VerificationHandler.verifyTrue(applyTabPage.verifyCardBackModulelName(PropertiesRepository.getString("sttname8.value")));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		VerificationHandler.verifyTrue(applyTabPage.verifyCardBackModulelName(PropertiesRepository.getString("sttname13.value")));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		VerificationHandler.verifyTrue(applyTabPage.verifyCardBackModulelName(PropertiesRepository.getString("sttname4.value")));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		VerificationHandler.verifyTrue(applyTabPage.verifyCardBackModulelName(PropertiesRepository.getString("sttname12.value")));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		VerificationHandler.verifyTrue(applyTabPage.verifyCardBackModulelName(PropertiesRepository.getString("sttname1.value")));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		VerificationHandler.verifyTrue(applyTabPage.verifyCardBackModulelName(PropertiesRepository.getString("sttname15.value")));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		VerificationHandler.verifyTrue(applyTabPage.verifyCardBackModulelName(PropertiesRepository.getString("sttname11.value")));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		VerificationHandler.verifyTrue(applyTabPage.verifyCardBackModulelName(PropertiesRepository.getString("sttname6.value")));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		VerificationHandler.verifyTrue(applyTabPage.verifyCardBackModulelName(PropertiesRepository.getString("sttname3.value")));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		VerificationHandler.verifyTrue(applyTabPage.verifyCardBackModulelName(PropertiesRepository.getString("sttname7.value")));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		VerificationHandler.verifyTrue(applyTabPage.verifyCardBackModulelName(PropertiesRepository.getString("sttname9.value")));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "NewATI808_VerifySTTListedInCustomOrder End");
		logger.info("NewATI808_VerifySTTListedInCustomOrder End");

	}

		
		@Test(priority = 1, alwaysRun = true, enabled = true, groups = { "Smoke","Regression" }, description = "Verify Sigma Theta Tau 2017 Modules on card back listed in custom order")
		public void NewATI824_VerifySTTDownloadReportforPreTestandPostTest() throws Exception {
		logger.info("NewATI824_VerifySTTDownloadReportforPreTestandPostTest Start");
		log(logger, "NewATI824_VerifySTTDownloadReportforPreTestandPostTest Start");

		//Step-1
		loginPage.loginToApplication("stagenonpulsedata","Test123");

		//Step-2 
		log(logger, "Clicking My Results Tab");
		homePage.clickTab(2);
		homePage.waitUntillLoadingImageIsAppeared("new-atitesting.peasewait.bufferLoc");
		

		  log(logger, "Verifyig My Results Page is displayed");
			VerificationHandler.verifyTrue(
					myResultsPage.verifyMessage(PropertiesRepository.getString("new.atitestig.my.results.header.loc"),
							PropertiesRepository.getString("new.atitestig.my.results.header.value")));
		
		//Step-3
		log(logger, "Click on Download Report");	
		tutorialPage.clickButton(PropertiesRepository.getString("new-ati.report.download.loc"), 0);		
		homePage.waitUntillLoadingImageIsAppeared("new-atitesting.peasewait.bufferLoc");
	
		logger.info("NewATI824_VerifySTTDownloadReportforPreTestandPostTest Ends");
		log(logger, "NewATI824_VerifySTTDownloadReportforPreTestandPostTest Ends");
		}
}
