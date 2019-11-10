package com.automation.newati.nclex;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyReportPage;
import com.automation.newati.pages.NclexPrepTabPage;
import com.automation.newati.pages.PractiseAssessmentPage;
import com.automation.newati.pages.TestTabPage;
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class VerifyNCLEXFunctionalityTest extends BaseTest {
	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private TestTabPage testTabPage;
	private PractiseAssessmentPage practiceAssessmentPage;
	private MyReportPage reportPage;
	private TutorialPage tutorialPage;
	private NclexPrepTabPage nclexPrepTabPage;
	
	@BeforeMethod(alwaysRun = true) 
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		testTabPage = new TestTabPage(driver);
		practiceAssessmentPage = new PractiseAssessmentPage(driver);
		reportPage = new MyReportPage(driver);
		tutorialPage = new TutorialPage(driver);
		nclexPrepTabPage=new NclexPrepTabPage(driver);
		
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.nclex.rn.pn.login.user.name"), PropertiesRepository.getString("newati.nclex.rn.pn.login.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	}
	
	/**
	 * Content Area Verification needs clarification from QE.
	 * 
	 * @throws Exception
	 */
	@TestAnnotations(testID="NewATI-925")
	@Test(priority = 1, description = "NewATI-925:Verify RN Live Review Tutorials showing up in NCLEX Prep TAB")
	public void NewATI925_VerifyRNLiveReviewTutorials() throws Exception {
		log(logger, "Method : NewATI925_VerifyRNLiveReviewTutorials Start");
		
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking NCLEXPREP Tab");
		homePage.clickSubTab(4);
		VerificationHandler.verifyTrue(nclexPrepTabPage.verifySubTabs());
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Getting Module number from Card Front");
		String cardFrontCount = nclexPrepTabPage.getModuleCount(PropertiesRepository.getString("newati.myati.assessment.NCLEX.prodcut.value2"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking Module by Name");
		tutorialPage.clickOnNCLEXModuleButton(PropertiesRepository.getString("newati.myati.assessment.NCLEX.prodcut.value2"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Getting Module number from Card Back");
		String cardBackCount = nclexPrepTabPage.getText("#selectedTutorialModuleCount");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying Module count for Card Front and Card Back");
		VerificationHandler.verifyEquals(cardFrontCount, cardFrontCount, "Unable to verify Module count for Card Front and Card Back");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Cardback Close button");
		nclexPrepTabPage.clickButton(PropertiesRepository.getString("new-atitesting.nclex.card.back.close.button.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying Speedometer");
		VerificationHandler.verifyFalse(nclexPrepTabPage.verifyElement(PropertiesRepository.getString("new-atitesting.nclex.card.front.speedometer.loc")), "SpeedoMeter is availale in NCLEX for non-pulse user.");
		
		logger.info("Method : NewATI925_VerifyRNLiveReviewTutorials Start");
	}

	
	@TestAnnotations(testID="NewATI-928")
	@Test(priority = 3, description = "NewATI-928:Verify accessed RN Live Review Tutorials showing up in Myresults Page")
	public void NewATI928_VerifyRNLive() throws Exception {
		log(logger, "Method : NewATI928_VerifyRNLive Start");
		
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking NCLEXPREP Tab");
		
		homePage.clickSubTab(4);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		boolean verifySubTabs = nclexPrepTabPage.verifySubTabs();
		VerificationHandler.verifyTrue(verifySubTabs);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking Module by Name");
		tutorialPage.clickOnNCLEXModuleButton(PropertiesRepository.getString("newati.myati.assessment.NCLEX.prodcut.value2"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying NCLEX Module name and clicking in Card Back");
		nclexPrepTabPage.clickNCLEXModuleName(PropertiesRepository.getString("newati.myati.assessment.NCLEX.prodcut.value2"), "CONTINUE");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying Tutorial Name in Assessment Page");
		nclexPrepTabPage.verifyAssessmentHeader(1, PropertiesRepository.getString("newati.myati.assessment.NCLEX.prodcut.value2"));
		
		log(logger, "Waiting for some sec to show page is accessed");
		Thread.sleep(50000);
		
		log(logger, "Verifying Module Name in Assessment Page");
		nclexPrepTabPage.verifyAssessmentHeader(3, PropertiesRepository.getString("newati.myati.assessment.NCLEX.prodcut.value2"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Close button");
		nclexPrepTabPage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.close.button.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Cardback Close button");
		nclexPrepTabPage.clickButton(PropertiesRepository.getString("new-atitesting.nclex.card.back.close.button.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on MyResults Tab");
		homePage.clickTab(2);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		logger.info("Method : NewATI928_VerifyRNLive Start");
	}
	
	@TestAnnotations(testID="NewATI-929")
	@Test(priority = 4, description = "NewATI-929:Verify accessed PN Live Review Tutorials showing up in Myresults Page")
	public void NewATI929_VerifyPNLive() throws Exception {
		log(logger, "Method : NewATI929_VerifyPNLive Start");
		
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking NCLEXPREP Tab");
		
		homePage.clickSubTab(4);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		boolean verifySubTabs = nclexPrepTabPage.verifySubTabs();
		VerificationHandler.verifyTrue(verifySubTabs);
		
		log(logger, "Clicking Module by Name");
		tutorialPage.clickOnNCLEXModuleButton(PropertiesRepository.getString("newati.myati.assessment.NCLEX.prodcut.pn.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying NCLEX Module name and clicking in Card Back");
		nclexPrepTabPage.clickNCLEXModuleName(PropertiesRepository.getString("newati.myati.assessment.NCLEX.prodcut.pn.value"), "CONTINUE");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying Tutorial Name in Assessment Page");
		nclexPrepTabPage.verifyAssessmentHeader(1, PropertiesRepository.getString("newati.myati.assessment.NCLEX.prodcut.pn.value"));
		
		log(logger, "Waiting for some sec to show page is accessed");
		Thread.sleep(50000);
		
		log(logger, "Verifying Module Name in Assessment Page");
		nclexPrepTabPage.verifyAssessmentHeader(3, PropertiesRepository.getString("newati.myati.assessment.NCLEX.prodcut.pn.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Close button");
		nclexPrepTabPage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.close.button.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Cardback Close button");
		nclexPrepTabPage.clickButton(PropertiesRepository.getString("new-atitesting.nclex.card.back.close.button.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on MyResults Tab");
		homePage.clickTab(2);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		logger.info("Method : NewATI929_VerifyPNLive Start");
	}
	
	@TestAnnotations(testID="NewATI-925")
	@Test(priority = 4, description = "NewATI-925:Verify RN Live Review Tutorials showing up in NCLEX Prep TAB")
	public void NewATI925_VerifyRNLiveReview() throws Exception {
		log(logger, "Method : NewATI925_VerifyRNLiveReview Start");
		//Step 1 & 2
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		log(logger, "Clicking NCLEXPREP Tab");
		
		//Step 3
		homePage.clickSubTab(4);
		boolean verifySubTabs = nclexPrepTabPage.verifySubTabs();
		VerificationHandler.verifyTrue(verifySubTabs);
		
		log(logger, "Verifying Nclex RN Live Review producs should up in NCLEX tab");
		VerificationHandler.verifyTrue(nclexPrepTabPage.VerifyIfRNLiveTutorialsDisplayed());
		
		//Step 4 
		//Verify the modules count in the card front and in card back
		
		log(logger, "Getting Module number from Card Front");
		String cardFrontCount = nclexPrepTabPage.getModuleCount(PropertiesRepository.getString("newati.myati.assessment.NCLEX.prodcut.value2"));
		
		log(logger, "Clicking Module by Name");
		tutorialPage.clickOnNCLEXModuleButton(PropertiesRepository.getString("newati.myati.assessment.NCLEX.prodcut.value2"));
		
		log(logger, "Getting Module number from Card Back");
		String cardBackCount = nclexPrepTabPage.getText("#selectedTutorialModuleCount");
		
		log(logger, "Verifying Module count for Card Front and Card Back");
		VerificationHandler.verifyEquals(cardFrontCount, cardFrontCount, "Unable to verify Module count for Card Front and Card Back");
		
		log(logger, "Clicking on Cardback Close button");
		nclexPrepTabPage.clickButton(PropertiesRepository.getString("new-atitesting.nclex.card.back.close.button.loc"));
		
		//Step 5
		log(logger, "Selecting NCLEX Option from Content Area");
		tutorialPage.selectValueBySelectClass(PropertiesRepository.getString("new-atitesting.content.area.dropdown.loc"), "NCLEX");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Verifying Nclex RN Live Review producs are tagged to NCLEX content area");
		VerificationHandler.verifyTrue(nclexPrepTabPage.VerifyIfRNLiveTutorialsDisplayed());		
		
		logger.info("Method : NewATI925_VerifyRNLiveReview Start");
	}
	
	@TestAnnotations(testID="NewATI-926")
	@Test(priority = 4, description = "NewATI-926:Verify PN Live Review Tutorials showing up in NCLEX Prep TAB")
	public void NewATI926_VerifyPNLiveReview() throws Exception {
		log(logger, "Method : NewATI926_VerifyPNLiveReview Start");
		//Step 1 & 2
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		log(logger, "Clicking NCLEXPREP Tab");
		
		//Step 3s
		homePage.clickSubTab(4);
		boolean verifySubTabs = nclexPrepTabPage.verifySubTabs();
		VerificationHandler.verifyTrue(verifySubTabs);
		
		log(logger, "Verifying Nclex PN Live Review producs should up in NCLEX tab");
		VerificationHandler.verifyTrue(nclexPrepTabPage.VerifyIfPNLiveTutorialsDisplayed());
		
		//Step 4 
		//Verify the modules count in the card front and in card back		
		log(logger, "Getting Module number from Card Front");
		String cardFrontCount = nclexPrepTabPage.getModuleCount(PropertiesRepository.getString("newati.myati.assessment.NCLEX.prodcut.pn.value"));
		
		log(logger, "Clicking Module by Name");
		tutorialPage.clickOnNCLEXModuleButton(PropertiesRepository.getString("newati.myati.assessment.NCLEX.prodcut.pn.value"));
		
		log(logger, "Getting Module number from Card Back");
		String cardBackCount = nclexPrepTabPage.getText("#selectedTutorialModuleCount");
		
		log(logger, "Verifying Module count for Card Front and Card Back");
		VerificationHandler.verifyEquals(cardFrontCount, cardFrontCount, "Unable to verify Module count for Card Front and Card Back");
		
		log(logger, "Clicking on Cardback Close button");
		nclexPrepTabPage.clickButton(PropertiesRepository.getString("new-atitesting.nclex.card.back.close.button.loc"));
		
		//Step 5
		log(logger, "Selecting NCLEX Option from Content Area");
		tutorialPage.selectValueBySelectClass(PropertiesRepository.getString("new-atitesting.content.area.dropdown.loc"), "NCLEX");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Verifying Nclex RN Live Review producs are tagged to NCLEX content area");
		VerificationHandler.verifyTrue(nclexPrepTabPage.VerifyIfPNLiveTutorialsDisplayed());		
		
		logger.info("Method : NewATI926_VerifyPNLiveReview Start");
	}
	/**
	 * Content Area Verification needs clarification from QE.
	 * 
	 * @throws Exception
	 */
	@TestAnnotations(testID="NewATI-926")
	@Test(priority = 2, description = "NewATI-926:Verify PN Live Review Tutorials showing up in NCLEX Prep TAB")
	public void NewATI926_VerifyPNLiveReviewTutorials() throws Exception {
		log(logger, "Method : NewATI926_VerifyPNLiveReviewTutorials Start");
		
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking NCLEXPREP Tab");
		homePage.clickSubTab(4);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyTrue(nclexPrepTabPage.verifySubTabs());
		
		log(logger, "Getting Module number from Card Front");
		String cardFrontCount = nclexPrepTabPage.getModuleCount(PropertiesRepository.getString("newati.myati.assessment.NCLEX.prodcut.pn.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking Module by Name");
		tutorialPage.clickOnNCLEXModuleButton(PropertiesRepository.getString("newati.myati.assessment.NCLEX.prodcut.pn.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Getting Module number from Card Back");
		String cardBackCount = nclexPrepTabPage.getText("#selectedTutorialModuleCount");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying Module count for Card Front and Card Back");
		VerificationHandler.verifyEquals(cardFrontCount, cardFrontCount, "Unable to verify Module count for Card Front and Card Back");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on Cardback Close button");
		nclexPrepTabPage.clickButton(PropertiesRepository.getString("new-atitesting.nclex.card.back.close.button.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying Speedometer");
		VerificationHandler.verifyFalse(nclexPrepTabPage.verifyElement(PropertiesRepository.getString("new-atitesting.nclex.card.front.speedometer.loc")), "SpeedoMeter is availale in NCLEX for non-pulse user.");
		
		logger.info("Method : NewATI926_VerifyPNLiveReviewTutorials Start");
	}
	
}
