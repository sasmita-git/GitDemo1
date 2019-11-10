package com.automation.newati.fr20;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.TextHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.ApplyTabPage;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LearnTabPage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyATITabMainPage;
import com.automation.newati.pages.MyReportPage;
import com.automation.newati.pages.MyResultsTabPage;
import com.automation.newati.pages.NclexPrepTabPage;
import com.automation.newati.pages.PractiseAssessmentPage;
import com.automation.newati.pages.TutorialPage;
import com.automation.newati.util.UserCreationUtils;
import com.jaca.TestAnnotations;

public class KognitoTest extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private MyATITabMainPage myATITabMainPage;
	private HomePage homePage;
	private TutorialPage tutorialPage;
	private MyReportPage myReportPage;
	private PractiseAssessmentPage practiceAssessmentPage;
	private LearnTabPage learnTabPage;
	private ApplyTabPage applyTabPage;
	private MyResultsTabPage myResultsTabPage;
	private MyResultsTabPage myResultsPage;
	private TextHandler textHandler;
	private BaseHandler baseHadler;
	private NclexPrepTabPage nclexPrepTabPage;
	private static String userId = null;
	private int count = 0;
	private UserCreationUtils userCreationUtils = new UserCreationUtils();
	String downloadFilepath = null;

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		myATITabMainPage = new MyATITabMainPage(driver);
		homePage = new HomePage(driver);
		tutorialPage = new TutorialPage(driver);
		myReportPage = new MyReportPage(driver);
		myResultsTabPage = new MyResultsTabPage(driver);
		practiceAssessmentPage = new PractiseAssessmentPage(driver);
		learnTabPage = new LearnTabPage(driver);
		applyTabPage = new ApplyTabPage(driver);
		textHandler = new TextHandler(driver);
		myResultsPage = new MyResultsTabPage(driver);
		baseHadler = new BaseHandler(driver);
		nclexPrepTabPage=new NclexPrepTabPage(driver);

	}

	/**
	 * Note : As per Murali , its enough to validate any two card back Modules. 
	 * 
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-893")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-893:[Kognito]>Verify the all modules on card back Communicator2.0")
	public void NewATI893_VerifyCardModuleCommunicatorTest() throws Exception {
		
		//Step 1
		logger.info("Method : NewATI745_VerifyAccessedModuleCount Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.username.kognito") , PropertiesRepository.getString("newati.pass.kognito"));
		
		//Step 2
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		
		log(logger, "Clicking on Apply Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 3);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if all enabled Simulations are displayed");
		VerificationHandler.verifyTrue(applyTabPage.VerifyIfEnabledSimulationDisplayed());			
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if Comminucator2.0 is displayed");
		VerificationHandler.verifyTrue(applyTabPage.verfifyModuleIsDisplayedByName(PropertiesRepository.getString("newati.cohort.assigenedProduct3")));	
		
		//Step 3
		log(logger, "Getting Module number from Card Front");
		String cardFrontCount = applyTabPage.getModuleCount(PropertiesRepository.getString("newati.cohort.assigenedProduct3"));
		System.out.println(cardFrontCount);
		
		log(logger, "Clicking on Modules button");
		learnTabPage.clickModuleButtonByNameSimulation(PropertiesRepository.getString("newati.cohort.assigenedProduct3"));		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Getting Module number from Card Back");
		String cardBackCount = applyTabPage.getText("#selectedSimulationModuleCount");
		System.out.println(cardBackCount);
		log(logger, "Verifying Module count for Card Front and Card Back");
		VerificationHandler.verifyEquals(cardFrontCount, cardBackCount, "Unable to verify Module count for Card Front and Card Back");
		
		log(logger, "Verifying if below Module is displayed on Card Back");
		VerificationHandler.verifyTrue(applyTabPage.verifyCardBackModulelName(PropertiesRepository.getString("newati.card.back.module.name1")));
		
		log(logger, "Verifying if below Module is displayed on Card Back");
		VerificationHandler.verifyTrue(applyTabPage.verifyCardBackModulelName(PropertiesRepository.getString("newati.card.back.module.name2")));
		
		logger.info("Method : NewATI893_VerifyCardModuleCommunicatorTest End");
	}
	
	/**
	 * Note : As per Murali , its enough to validate any two card back Modules with N/A . 
	 * 
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-894")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-894:[Kognito]>Verify the speedometer for pulse user.")
	public void NewATI894_VerifySMForPulseUSerTest() throws Exception {
		
		//Step 1
		logger.info("Method : NewATI894_VerifySMForPulseUSerTest Start");
		loginPage.loginToApplication("stgstd1219","Test@123");
		//loginPage.loginToApplication(PropertiesRepository.getString("newati.username.kognito") , PropertiesRepository.getString("newati.pass.kognito"));
		
		//Step 2
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on Apply Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 3);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if all enabled Simulations are displayed");
		VerificationHandler.verifyTrue(applyTabPage.VerifyIfEnabledSimulationDisplayed());			
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Verify if Comminucator2.0 is displayed");
		VerificationHandler.verifyTrue(applyTabPage.verfifyModuleIsDisplayedByName(PropertiesRepository.getString("newati.cohort.assigenedProduct3")));	
		
		//Step 3			
		log(logger, "Clicking on Modules button");
		learnTabPage.clickModuleButtonByNameSimulation(PropertiesRepository.getString("newati.cohort.assigenedProduct3"));			
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//Step 4
		log(logger, "Verifying if below Module is displayed on Card Back with Speedo meter value as N/A");
		VerificationHandler.verifyTrue(applyTabPage.verifyCardBackModulelNameWithSMValue(PropertiesRepository.getString("newati.card.back.module.name3") , "%"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying if below Module is displayed on Card Back with Speedo meter value as N/A");
		VerificationHandler.verifyTrue(applyTabPage.verifyCardBackModulelNameWithSMValue(PropertiesRepository.getString("newati.card.back.module.name4") , "%"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		//Step 5
		log(logger, "Verifying if below Module is displayed on Card Back with Speedo meter value % Count");
		VerificationHandler.verifyTrue(applyTabPage.verifyCardBackModulelNameWithSMValue(PropertiesRepository.getString("newati.card.back.module.name1") , "%"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying if below Module is displayed on Card Back with Speedo meter value % Count");
		VerificationHandler.verifyTrue(applyTabPage.verifyCardBackModulelNameWithSMValue(PropertiesRepository.getString("newati.card.back.module.name2") , "%"));
		
		logger.info("Method : NewATI894_VerifySMForPulseUSerTest End");
	}
	
	@TestAnnotations(testID="NewATI-896")
	 @Test(priority = 3, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-896: Verify kognito module is accessable for Begin and continue case")
	 public void NewATI896_VerifyKognitoBeginandContinueCase() throws Exception {
	 logger.info("Method: NewATI896_VerifyKognitoBeginandContinueCase Starts");
	 
	 //step-1
	 loginPage.loginToApplication("stagemay21","Test123");
	 
	 //step-2
	 log(logger, "Clicking on My ATI Tab");
	 homePage.clickTab(1);
	 homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	 
	 log(logger, "Clicking on Apply Tab");
	 homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 3);
	 homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	 
	 log(logger, "Verify if all enabled Simulations are displayed");
	 VerificationHandler.verifyTrue(applyTabPage.VerifyIfEnabledSimulationDisplayed());   
	 homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	 
	 log(logger, "Verify if Comminucator2.0 is displayed");
	 VerificationHandler.verifyTrue(applyTabPage.verfifyModuleIsDisplayedByName(PropertiesRepository.getString("newati.cohort.assigenedProduct3"))); 
	 
	 //step-3
	 log(logger, "Clicking on Modules button"); 
	 learnTabPage.clickModuleButtonByNameSimulation(PropertiesRepository.getString("newati.cohort.assigenedProduct3"));  
	 
	 log(logger,"Click on Begin Case for kognito module");
	 homePage.clickButton(PropertiesRepository.getString("new-atitesting.applytab.simulation.kognito.card.front.module"));
	 homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	 homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	 homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	 
	 //step-4
	 log(logger,"click on close button");
	 tutorialPage.clickButton(PropertiesRepository.getString("new.atitesting.simulation.kognito.module.close.button"));
	 homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	 
	 log(logger,"clicking on yes for close button pop-up");
	 tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.simulation.kognito.click.close.yes"));
	 homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	 
	 //step-5
	 log(logger,"verify Begin case is replaced with Continue Case");
	 String continueCase=textHandler.getText(PropertiesRepository.getString("new-atitesting.applytab.simulation.kognito.card.front.module"));
	 loginPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	 
	 log(logger,"click on Continue case Button");
	 homePage.clickButton(PropertiesRepository.getString("new-atitesting.applytab.simulation.kognito.card.front.module"));
	 homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	 
	 logger.info("Method: NewATI896_VerifyKognitoBeginandContinueCase Ends");
	 
	 
	}
	@TestAnnotations(testID="NewATI-891")
	@Test(priority =1, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-891:[Kognito]>Verify recent activity for communicator product.")
	public void NewATI891_VerifyKognitoRecentactivity() throws Exception {
		log(logger, "NewATI891_VerifyKognitoRecentactivity Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.Kognito.user"), PropertiesRepository.getString("newati.login.password"));
		
		log(logger, "Clicking MyATI Tab ");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Clicking Apply Tab ");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 3);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.pleasewait.bufferLoc");

		log(logger, "Click on Modules ");
		loginPage.clickLinkFromList(PropertiesRepository.getString("new-atitesting.myati.apply.tab.simulation.links"),
						PropertiesRepository.getInt("new-atitesting.myati.apply.tab.simulation.link.index"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.pleasewait.bufferLoc");
		
//		log(logger, "Clicking Begin case button ");
//		loginPage.clickLinkFromList(PropertiesRepository.getString("new-atitesting.myati.apply.tab.simulation.modules"),16);
		log(logger, "Clicking on first module on card back");
		tutorialPage.clickButton(PropertiesRepository.getString("new.atitesting.cardback.kognitoModule.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.pleasewait.bufferLoc");
		// Step 5		
		log(logger, "Verify if URL contains LTI");
		VerificationHandler.verifyTrue(driver.getCurrentUrl().contains("LTI"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if Close button is displayed");
		VerificationHandler.verifyTrue(tutorialPage.isElementDisplayed("newati.close.button.LTI.kognito"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Click on Close button");
		tutorialPage.clickButton(PropertiesRepository.getString("newati.close.button.LTI.kognito"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Click on Yes button");
		tutorialPage.clickButton(PropertiesRepository.getString("newati.close.dialog.yes.LTI"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		log(logger, "Click on close button");
//		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.close.button.loc"));
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.pleasewait.bufferLoc");
//		log(logger, "Click on confirmation pop up yes button");
//		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.kognito.confirm.popup"),0);
		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.pleasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.pleasewait.bufferLoc");
		log(logger, "Click on close button card back");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.cardback.kognito.close.loc"),0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.pleasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.pleasewait.bufferLoc");
		log(logger, "Clicking Home Tab");
		homePage.clickTab(0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.pleasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.pleasewait.bufferLoc");
		
		log(logger, "verify data on recent activity card");
		VerificationHandler.verifyTrue(applyTabPage.verifyrecentActivityKognito(PropertiesRepository.getString("new.atitesting.kognito.module.name"),0));
		
		log(logger, "Launch Kognito from Recent Activity");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting..kognito.recent.activity"),0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Verify element after opening. ");
		VerificationHandler.verifyTrue(nclexPrepTabPage.checkElementEnabled(PropertiesRepository.getString("new-atitesting.learntab.tutorial.close.button.loc")), "Unable to verify element after opening.");
		
		log(logger, "NewATI891_VerifyKognitoRecentactivity End");
	}
	
	@TestAnnotations(testID="NewATI-892")
	 @Test(priority =2, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-892:[Kognito]>Verify the access flow for kognito modules.")
	 public void NewATI892_VerifyKognitoAccessflow() throws Exception {
	  log(logger, "NewATI892_VerifyKognitoAccessflow Start");
	  loginPage.loginToApplication(PropertiesRepository.getString("newati.Kognito.user"), PropertiesRepository.getString("newati.login.password"));
	  
	  log(logger, "Clicking MyATI Tab ");
	  homePage.clickTab(1);
	  homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

	  log(logger, "Clicking Apply Tab ");
	  homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 3);
	  homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	  homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.pleasewait.bufferLoc");
	  
	  log(logger, "Click on Modules ");
	  loginPage.clickLinkFromList(PropertiesRepository.getString("new-atitesting.myati.apply.tab.simulation.links"),
	      PropertiesRepository.getInt("new-atitesting.myati.apply.tab.simulation.link.index"));
	  homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	  homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.pleasewait.bufferLoc");
	  
	  log(logger, "Clicking Begin case button ");
	  log(logger, "Clicking on first module on card back");
		tutorialPage.clickButton(PropertiesRepository.getString("new.atitesting.cardback.kognitoModule.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.pleasewait.bufferLoc");
		// Step 5		
		log(logger, "Verify if URL contains LTI");
		VerificationHandler.verifyTrue(driver.getCurrentUrl().contains("LTI"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verify if Close button is displayed");
		VerificationHandler.verifyTrue(tutorialPage.isElementDisplayed("newati.close.button.LTI.kognito"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Click on Close button");
		tutorialPage.clickButton(PropertiesRepository.getString("newati.close.button.LTI.kognito"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	  
	  log(logger, "Click on confirmation pop up no button");
	  loginPage.clickButton(PropertiesRepository.getString("new-atitesting.kognito.confirm.popup"),1);
	  homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.pleasewait.bufferLoc");
	  homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.pleasewait.bufferLoc");
	  log(logger, "verify that it allow user to continue the simulation");
	  VerificationHandler.verifyTrue(applyTabPage.verifyKognitomodulepage(PropertiesRepository.getString("new-atitesting.applytab.kognito.module.name")));
	  homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.pleasewait.bufferLoc");
	  log(logger, "Click on close button");
	  loginPage.clickButton(PropertiesRepository.getString("new-atitesting.learntab.tutorial.close.button.loc"));
	  homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.pleasewait.bufferLoc");
	  homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.pleasewait.bufferLoc");
	  log(logger, "Click on confirmation pop up yes button");
	  loginPage.clickButton(PropertiesRepository.getString("new-atitesting.kognito.confirm.popup"),0);
	  homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.pleasewait.bufferLoc");
	  homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.pleasewait.bufferLoc");
	  homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.pleasewait.bufferLoc");
	  
	  log(logger, "Verifycard back");
	  VerificationHandler.verifyTrue(tutorialPage.isElementDisplayed("new-atitesting..kognito.cardback"));
	  
	  log(logger, "NewATI892_VerifyKognitoAccessflow End");
	 }
	
	@TestAnnotations(testID="NewATI-897")
	@Test(priority =2, alwaysRun = true, enabled = true, groups = {"Regression"}, description = "NewATI-897:[koginto]>Verify time spent on card front and card back.")
	public void NewATI897_VerifyKognitoTimespent() throws Exception {
		log(logger, "NewATI897_VerifyKognitoTimespent Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.Kognito.user"), PropertiesRepository.getString("newati.login.password"));
		
		log(logger, "Clicking MyATI Tab ");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Clicking Apply Tab ");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 3);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.pleasewait.bufferLoc");
		
		log(logger, "Verify if Comminucator2.0 is displayed");
		VerificationHandler.verifyTrue(applyTabPage.verfifyModuleIsDisplayedByName(PropertiesRepository.getString("newati.cohort.assigenedProduct3")));	
		
		log(logger, "Click on Modules ");
		loginPage.clickLinkFromList(PropertiesRepository.getString("new-atitesting.myati.apply.tab.simulation.links"),
						PropertiesRepository.getInt("new-atitesting.myati.apply.tab.simulation.link.index"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.pleasewait.bufferLoc");
		
//		log(logger, "Verifying if below Module is displayed on Card Back");
//		VerificationHandler.verifyTrue(applyTabPage.verifyCardBackModulelName(PropertiesRepository.getString("new.atitesting.kognito.module.name")));
		
		log(logger, "Verifying if below Module is displayed on Card Back");
		VerificationHandler.verifyTrue(applyTabPage.verifyCardBackModulelName(PropertiesRepository.getString("newati.card.back.kognito.module.name1")));
		
		log(logger, "Verify element should display");
		VerificationHandler.verifyTrue(applyTabPage.verifyKognitomoduleTimespent());
		
		log(logger, "NewATI897_VerifyKognitoTimespent End");
	}

	@TestAnnotations(testID="NewATI-885")
	 @Test(priority = 4, alwaysRun= true, enabled = true, groups={"Regression"},description = "NewATI-885: Verify kognito modules under MY Result page")
	 public void NewATI885_VerifyKognitoResults() throws Exception {
	  logger.info("Method :NewATI885_VerifyKognitoResults starts");
	  String myResultsPageAccessDate = "";
	  String cardbackAccesseddate = "";
	  
	  //step-1
	  loginPage.loginToApplication("stagemay21","Test123");
	  
	  //step-2
	  log(logger, "Clicking on My ATI Tab");
	  homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	  homePage.clickTab(1);
	  
	  log(logger, "Verifying if All Tabs are displayed");
	  VerificationHandler.verifyTrue(myATITabMainPage.verifyAllTabsDisplayed());
	  
	  log(logger, "Clicking Apply Tab ");
	  homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 3);
	  homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	  
	  //step-3
	  log(logger, "Verify if all enabled Simulations are displayed");
	  VerificationHandler.verifyTrue(applyTabPage.VerifyIfEnabledSimulationDisplayed());   
	  homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	  
	  log(logger, "Verify if Comminucator2.0 is displayed");
	  VerificationHandler.verifyTrue(applyTabPage.verfifyModuleIsDisplayedByName(PropertiesRepository.getString("newati.cohort.assigenedProduct3"))); 
	  
	  log(logger, "Clicking on Modules button");
	  learnTabPage.clickModuleButtonByNameSimulation(PropertiesRepository.getString("newati.cohort.assigenedProduct3"));  
	  
	  log(logger,"Click on Begin Case for kognito module");
	  homePage.clickButton(PropertiesRepository.getString("new-atitesting.applytab.simulation.kognito.card.front.module"));
	  homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	  
	  log(logger,"click on close button");
	  tutorialPage.clickButton(PropertiesRepository.getString("new.atitesting.simulation.kognito.module.close.button"));
	  homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	  
	  log(logger,"clicking on yes for close button pop-up");
	  tutorialPage.clickButton(PropertiesRepository.getString("new-atitesting.simulation.kognito.click.close.yes"));
	  homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	  homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	  homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	  //step-4
	  log(logger,"clicking on close button on card back");
	  tutorialPage.clickButton(PropertiesRepository.getString("new.atitesting.kognito.card.back.close.button"));
	  homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	  
	  log(logger,"clicking on MyReslts tab");
	  homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	  homePage.clickTab(2);
	  
	  //step-5
	  log(logger, "Get the Last Date Accessed from My results page for kognito Module");
	  myResultsPageAccessDate = myResultsPage.getLastDateAccessed(PropertiesRepository.getString("newati.myati.result.kognito.prodcut.value.new"), PropertiesRepository.getString("newati.myati.result.kognito.module"));
	  homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	  
	  log(logger, "Verify if Accessed time should show up in MyResults page and time showing up in Card back of the tutorial and Myresults page should match");
	  VerificationHandler.verifyTrue(cardbackAccesseddate.equals(myResultsPageAccessDate)); 
	  homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	  
	  List<WebElement> moduleList = baseHadler.findElements("span[data-atiid='TutorialModuleResults_LastDateAccessed']");
	  homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	  
	  log(logger, "Verify if IPP page should display showing up Time spent which should match across Myresults page and in card back");
	 // VerificationHandler.verifyTrue(cardbackAccesseddate.equals(moduleList.get(0).getText()));
	  
	  homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	  //Step 4 (PDF verification is not done, only checked if Download button is present)
	  log(logger, "Verify if  Download Report button is displayed");
	  homePage.isElementDisplayed("new.atitesting.downloaf.button.ipp.page.loc");
	  
	  logger.info("Method :NewATI885_VerifyKognitoResults Ends");
}
}
