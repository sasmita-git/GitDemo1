package com.automation.newati.nclex;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyReportPage;
import com.automation.newati.pages.MyResultsTabPage;
import com.automation.newati.pages.NclexPrepTabPage;
import com.automation.newati.pages.PractiseAssessmentPage;
import com.automation.newati.pages.TestTabPage;
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class RegressionNCLEXTest2 extends BaseTest {
	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private TestTabPage testTabPage;
	private PractiseAssessmentPage practiceAssessmentPage;
	private MyReportPage reportPage;
	private TutorialPage tutorialPage;
	private NclexPrepTabPage nclexPrepTabPage;
	private MyResultsTabPage myResultsPage;
	private BaseHandler baseHandler;
	
	@BeforeMethod(alwaysRun = true) 
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		testTabPage = new TestTabPage(driver);
		practiceAssessmentPage = new PractiseAssessmentPage(driver);
		reportPage = new MyReportPage(driver);
		tutorialPage = new TutorialPage(driver);
		nclexPrepTabPage=new NclexPrepTabPage(driver);
		myResultsPage = new MyResultsTabPage(driver);
		baseHandler = new BaseHandler(driver);
	}
	
	/**
	 * Note:-PDF verification is not done, only checked if Download button is present
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-928")
	@Test(priority = 5, alwaysRun = true, enabled = true, groups = {"Regression" }, description = "NewATI-928:Verify accessed RN Live Review Tutorials showing up in Myresults Page")
	public void NewATI928_VerifyRNLiveREview() throws Exception {

		log(logger, "NewATI928_VerifyRNLiveREview Start");
		String cardbackAccesseddate = "";
		String myResultsPageAccessDate = "";
		//Step 1
		loginPage.loginToApplication(PropertiesRepository.getString("newati.user.928"),PropertiesRepository.getString("newati.login.user.password"));
				
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking NCLEXPREP Tab");				
		homePage.clickSubTab(4);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying Nclex RN Live Review producs should up in NCLEX tab");
		VerificationHandler.verifyTrue(nclexPrepTabPage.VerifyIfNCLEXRNLiveTutorialNewDisplayed());
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking Module by Name");
		tutorialPage.clickOnNCLEXModuleButton(PropertiesRepository.getString("newati.myati.assessment.NCLEX.prodcut.value.new"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger,"Get the Access Date from the Card Back");
		cardbackAccesseddate = homePage.getAccessedDateCardBack(PropertiesRepository.getString("newati.myati.NCLEX.live.review"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Cardback Close button");
		nclexPrepTabPage.clickButton(PropertiesRepository.getString("new-atitesting.nclex.card.back.close.button.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//Step 1
		log(logger, "Clicking on My Results Tab");
		homePage.clickTab(2);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Get the Last Date Accessed from My results page for NCLEX-RN Live Review Tutorial");
		myResultsPageAccessDate = myResultsPage.getLastDateAccessed(PropertiesRepository.getString("newati.myati.assessment.NCLEX.prodcut.value.new"), PropertiesRepository.getString("newati.myati.NCLEX.live.review"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//Step 2 and 3
		log(logger, "Verify if Accessed time should show up in MyResults page and time showing up in Card back of the tutorial and Myresults page should match");
		VerificationHandler.verifyTrue(cardbackAccesseddate.equals(myResultsPageAccessDate));	
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		List<WebElement> moduleList = baseHandler.findElements("span[data-atiid='TutorialModuleResults_LastDateAccessed']");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if IPP page should display showing up Time spent which should match across Myresults page and in card back");
		VerificationHandler.verifyTrue(cardbackAccesseddate.equals(moduleList.get(0).getText()));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//Step 4 (PDF verification is not done, only checked if Download button is present)
		log(logger, "Verify if  Download Report button is displayed");
		homePage.isElementDisplayed("new.atitesting.downloaf.button.ipp.page.loc");
		
		logger.info("Method : NewATI928_VerifyRNLiveREview Start");
	}
	
	/**
	 * Note:-PDF verification is not done, only checked if Download button is present
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-929")
	@Test(priority = 6, alwaysRun = true, enabled = true, groups = {"Regression" }, description = "NewATI-929:Verify accessed PN Live Review Tutorials showing up in Myresults Page")
	public void NewATI929_VerifyPNLiveREview() throws Exception {

		log(logger, "NewATI929_VerifyPNLiveREview Start");
		String cardbackAccesseddate = "";
		String myResultsPageAccessDate = "";
		//Step 1
		loginPage.loginToApplication(PropertiesRepository.getString("newati.user.928"),PropertiesRepository.getString("newati.login.user.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");	
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking NCLEXPREP Tab");				
		homePage.clickSubTab(4);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying Nclex PN Live Review producs should up in NCLEX tab");
		VerificationHandler.verifyTrue(nclexPrepTabPage.VerifyIfPNLiveTutorialsDisplayed());
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking Module by Name");
		tutorialPage.clickOnNCLEXModuleButton(PropertiesRepository.getString("newati.myati.assessment.NCLEX.prodcut.pn.value.new"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger,"Get the Access Date from the Card Back");
		cardbackAccesseddate = homePage.getAccessedDateCardBack(PropertiesRepository.getString("newati.myati.NCLEX.live.review"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Cardback Close button");
		nclexPrepTabPage.clickButton(PropertiesRepository.getString("new-atitesting.nclex.card.back.close.button.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//Step 1
		log(logger, "Clicking on My Results Tab");
		homePage.clickTab(2);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Get the Last Date Accessed from My results page for NCLEX-PN Live Review Tutorial");
		myResultsPageAccessDate = myResultsPage.getLastDateAccessed(PropertiesRepository.getString("newati.myati.assessment.NCLEX.prodcut.pn.value.new"), PropertiesRepository.getString("newati.myati.NCLEX.live.review"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//Step 2 and 3
		log(logger, "Verify if Accessed time should show up in MyResults page and time showing up in Card back of the tutorial and Myresults page should match");
		VerificationHandler.verifyTrue(cardbackAccesseddate.equals(myResultsPageAccessDate));	
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		List<WebElement> moduleList = baseHandler.findElements("span[data-atiid='TutorialModuleResults_LastDateAccessed']");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if IPP page should display showing up Time spent which should match across Myresults page and in card back");
		VerificationHandler.verifyTrue(cardbackAccesseddate.equals(moduleList.get(0).getText()));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//Step 4 (PDF verification is not done, only checked if Download button is present)
		log(logger, "Verify if  Download Report button is displayed");
		homePage.isElementDisplayed("new.atitesting.downloaf.button.ipp.page.loc");
		
		logger.info("Method : NewATI929_VerifyPNLiveREview Start");
	}
		
}
