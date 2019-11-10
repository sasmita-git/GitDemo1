package com.automation.newati.regression.testtab;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.GlobalProperties;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.TextHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.CreateAccountPageNewSmoke;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.NclexPrepTabPage;
import com.automation.newati.pages.PractiseAssessmentPage;
import com.automation.newati.pages.ProctorChromePage;
import com.automation.newati.pages.ProctoredAssessmentPage;
import com.automation.newati.pages.TestTabPage;
import com.automation.newati.pages.TutorialPage;
import com.automation.newati.util.UserCreationUtils;

public class VerifyProctoredAssessmentTest extends BaseTest {
	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private TestTabPage testTabPage;
	private TextHandler textHandler;
	private PractiseAssessmentPage practiseAssessmentPage;
	private TutorialPage tutorialPage;
	private String browserType = null;
	private WebDriver proctorDriver = null;
	private ProctorChromePage proctorChromePage;
	private ProctoredAssessmentPage proctoredAssessmentPage;
	private  NclexPrepTabPage nclexPrepTabPage;
	private CreateAccountPageNewSmoke createAccountPage;
	private static String userId = null;
	private UserCreationUtils userCreationUtils = new UserCreationUtils();
	@BeforeMethod(alwaysRun = true) 
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		testTabPage = new TestTabPage(driver);
		textHandler=new TextHandler(driver);
		tutorialPage=new TutorialPage(driver);
		practiseAssessmentPage=new PractiseAssessmentPage(driver);
		proctorChromePage = new ProctorChromePage(driver);
		proctoredAssessmentPage = new ProctoredAssessmentPage(driver);
		nclexPrepTabPage=new NclexPrepTabPage(driver);
		createAccountPage = new CreateAccountPageNewSmoke(driver);
	}
	
	@Test(priority=1,description = "NewATI-488:Verification for Separate Frame for Porctor avaliable assessments")
	public void NewATI488_verifySeparateFrameforPorctorAvaliableAssessments() throws Exception {
		log(logger, "NewATI488_verifySeparateFrameforPorctorAvaliableAssessments Start");

		loginPage.loginToApplication(PropertiesRepository.getString("newati.proctor.session.login.uname"), PropertiesRepository.getString("newati.proctor.session.login.pwd"));

		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on Test Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "verify message when proctor is not available");
		String text = homePage.getText(PropertiesRepository.getString("new-atitesting.no.proctor.error.messages.loc"));
		VerificationHandler.verifyEquals(text.trim(), PropertiesRepository.getString("new-atitesting.no.proctor.error.messages.info"));
		
		
		log(logger, "NewATI488_verifySeparateFrameforPorctorAvaliableAssessments End");
	}
	
	
	@Test(priority=2,description = "NewATI-489:Verification for Refresh button in First section under Test tab")
	public void NewATI489_verifyRefreshButtonUnderTestTab() throws Exception {
		log(logger, "NewATI489_verifyRefreshButtonUnderTestTab Start");

		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.namewithrecentactivity"), PropertiesRepository.getString("newati.login.passwordofuserwithrecent"));

		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on Test Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "verify refresh button");
		boolean elementDisplayed = loginPage.isElementDisplayed("new-atitesting.test.tab.proctor.refresh.button");
		VerificationHandler.verifyTrue(elementDisplayed);
		
		log(logger, "NewATI489_verifyRefreshButtonUnderTestTab End");
	}
	
	@Test(priority=3,description = "NewATI-490:Verification for functionality of Refresh Button under Test tab first section")
	public void NewATI490_verifyTheFunctionalityofRefreshButtonUnderTestTab() throws Exception {
		log(logger, "NewATI490_verifyTheFunctionalityofRefreshButtonUnderTestTab Start");

		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.namewithrecentactivity"), PropertiesRepository.getString("newati.login.passwordofuserwithrecent"));

		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on Test Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		
		log(logger, "Clicking on refresth button");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.test.tab.proctor.refresh.button"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "verify proctor section header message");
		boolean elementDisplayed = loginPage.isElementDisplayed("new-atitesting.test.tab.proctor.assessment.header");
		VerificationHandler.verifyTrue(elementDisplayed);		
		
		log(logger, "NewATI490_verifyTheFunctionalityofRefreshButtonUnderTestTab End");
	}
	
	@Test(priority=4,description = "NewATI-491:Verifiaction for Title in First section if proctor is available for assessments")
	public void NewATI491_verifyTheProctorAvailableMessageUnderTestTab() throws Exception {
		log(logger, "NewATI491_verifyTheProctorAvailableMessageUnderTestTab Start");

		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.namewithrecentactivity"), PropertiesRepository.getString("newati.login.passwordofuserwithrecent"));

		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
				
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Test Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "verify proctor section header message");
		String text = homePage.getText(PropertiesRepository.getString("new-atitesting.test.tab.proctor.assessment.header"));
		VerificationHandler.verifyEquals(text.trim(), PropertiesRepository.getString("new-atitesting.proctor.error.messages.header.info"));
		
		log(logger, "NewATI491_verifyTheProctorAvailableMessageUnderTestTab End");
	}
	
	@Test(priority=5,description = " NewATI-493:Verification for message on Card Front for 'TIme Between Attempts' set for Practice Assessments")
	public void NewATI493_verifyTImeBetweenAttemptsForPracticeAssessment() throws Exception {
		log(logger, "NewATI493_verifyTImeBetweenAttemptsForPracticeAssessment Start");

		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name"), PropertiesRepository.getString("newati.login.learn.tab.password"));

		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on Test Tab");
		homePage.clickButtonFromList("new-atitesting.all.tab", 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Select Practice Assessment from Type");
		testTabPage.selectFiltersDropDown(1, "Practice");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Select Tutorial Module name");
		boolean result=practiseAssessmentPage.verifyAvailableDaysForAssessment(PropertiesRepository.getString("new-atitesting.learntab.tutorial.fundamentals.online.assessment.new"));
		VerificationHandler.verifyTrue(result);
		
		log(logger, "NewATI493_verifyTImeBetweenAttemptsForPracticeAssessment End");
	}
	
	/**
	 * Description: Toast message can not be automated as toast message is disappear before the page is getting load.
	 * @throws Exception
	 */
	
	@Test(priority=6,description = "NewATI-652:To verify Launching an assessment when semester payment is due update messaging.")
	public void NewATI652_verifySemesterPaymentisDueupdateMessaging() throws Exception {
		log(logger, "NewATI652_verifySemesterPaymentisDueupdateMessaging Start");

//		loginPage.loginToApplication(PropertiesRepository.getString("newati.due.semester.payment.login.uname"), PropertiesRepository.getString("newati.due.semester.payment.login.pwd"));
		userId = userCreationUtils.getUserDetails();
		if (userId==null) {
			logger.info("Recreation of user started ");
			userId = userCreationUtils.getUserDetails();
		}
		loginPage.loginToApplication(userId, PropertiesRepository.getString("newati.login.payment.pwd"));
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Test Tab");
		homePage.clickButtonFromList("new-atitesting.all.tab", 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Add Product button");
		createAccountPage.clickOnAddProductButtoninLearnTab();
//		homePage.clickButtonFromList("add.product",1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		textHandler.writeText(PropertiesRepository.getString("new-atitesting.createaccount.addProductTextFieldLoc"), PropertiesRepository
				.getString("newati.due.semester.payment.product.productid"));
		
		log(logger, "Clicking on Continue button");
		homePage.click(PropertiesRepository.getString("new-atitesting.add.product.continue.button.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		textHandler.writeText(PropertiesRepository.getString("new-atitesting.add.product.password.loc"), PropertiesRepository
				.getString("newati.due.semester.payment.product.productpwd"));
		
		log(logger, "Clicking on Continue button");
		homePage.click(PropertiesRepository.getString("new-atitesting.add.product.continue.button.loc"));

		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "NewATI652_verifySemesterPaymentisDueupdateMessaging End");
	}
	
	
	@Test(priority=7,description = "NewATI-495:Verification for visibiity of Practice assessment card front when Time b/w attempts is set.")
	public void NewATI495_verifyVisibiityofPracticeAssessmentCardFront() throws Exception {
		log(logger, "NewATI495_verifyVisibiityofPracticeAssessmentCardFront Start");

		loginPage.loginToApplication(PropertiesRepository.getString("newati.retake.disabled.assessment.login.uname"), PropertiesRepository.getString("newati.retake.disabled.assessment.login.pwd"));

		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on Test Tab");
		homePage.clickButtonFromList("new-atitesting.all.tab", 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Select Practice Assessment from Type");
		testTabPage.selectFiltersDropDown(1, "Practice");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "verify retake disable functionality");
		boolean result=practiseAssessmentPage.verifyRetakeDisabledFunctionality(PropertiesRepository.getString("newati.proctored.module.assessment.name.update"));
		VerificationHandler.verifyTrue(result);
		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "NewATI495_verifyVisibiityofPracticeAssessmentCardFront End");
	}
	
	@Test(priority=8,description = "NewATI-606:Verification for TEAS Practice with different sections enabled.")
	public void NewATI606_verifyTEASPracticewithDifferentSectionsEnabled() throws Exception {
		log(logger, "NewATI606_verifyTEASPracticewithDifferentSectionsEnabled Start");

		loginPage.loginToApplication(PropertiesRepository.getString("newati.online.practice.results.not.available.login.uname"), PropertiesRepository.getString("newati.online.practice.results.not.available.login.pwd"));

		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on Test Tab");
		homePage.clickButtonFromList("new-atitesting.all.tab", 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Select Practice Assessment from Type");
		testTabPage.selectFiltersDropDown(1, "Practice");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Select Practice Assessment Name");
		practiseAssessmentPage.clickTestTabAssessmentButton("Practice Assessment",PropertiesRepository.getString("faculty.portal.testtab.assessment.name4"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Taking Assessment");
		tutorialPage.takeTest(false, false, true, false);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Close Button");
		tutorialPage.clickButtonWithSwitchToDefault(PropertiesRepository.getString("new-atitesting.question.assement.question.close.button"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		 log(logger, "Clicking Home Tab");
		  homePage.clickTab(0);
		  homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		  homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		  log(logger, "Launch smart prep from Recent Activity");
		  loginPage.clickButton(PropertiesRepository.getString("new-atitesting.assessment.recent.activity.loc"),0);
		  homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		  homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		  
		  log(logger, "Verify element after opening. ");
		  VerificationHandler.verifyTrue(nclexPrepTabPage.checkElementEnabled(PropertiesRepository.getString("new-atitesting.learntab.tutorial.close.button.loc")), "Unable to verify element after opening.");
		
		log(logger, "NewATI606_verifyTEASPracticewithDifferentSectionsEnabled End");
	}
	
	@Test(priority=9,description = "NewATI-646:Verify the detail information pop up for proctor and practice assessment.")
	public void NewATI646_verifyPopUpInformation() throws Exception {
		log(logger, "NewATI646_verifyPopUpInformation Start");

		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.namewithrecentactivity"), PropertiesRepository.getString("newati.login.passwordofuserwithrecent"));

		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on Test Tab");
		homePage.clickButtonFromList("new-atitesting.all.tab", 1);
		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		boolean verifyProctorPracticeModuleNames = tutorialPage.verifyProctorPracticeModuleNames();
		VerificationHandler.verifyTrue(verifyProctorPracticeModuleNames);
		
		log(logger, "NewATI646_verifyPopUpInformation End");
	}
	
	@Test(priority=10,description = "NewATI-492:Verification for accessibility of proctor assessments available in 'Proctor is available' section")
	public void NewATI492_verifyTheProctorIAgreePage() throws Exception {
		log(logger, "NewATI492_verifyTheProctorIAgreePage Start");

		//Pre-condition starts
		logger.info("Proctor Assessment Starts");
		browserType = System.getProperty("browserName");
		logger.info("browserType value first ==> " + browserType);
		
		// If not getting value from properties file
		if(StringUtils.isEmpty(browserType)) {
			browserType = PropertiesRepository.getString("global.browser.name");
		} 
		
		logger.info("browserType value ==> " + browserType);
		if(browserType.equalsIgnoreCase(GlobalProperties.FIREFOX)) {
			proctorDriver = openProctorChromeDriver();
			logger.info("Opening Chrome Browser");
		} else if(browserType.equalsIgnoreCase(GlobalProperties.CHROME)) {
			proctorDriver = openProctorFirefoxDriver();
			logger.info("Opening Firefox Browser");
		}

		// Faculty Start 
		log(logger, "Login to application");
		proctorChromePage.loginToApplicationID(proctorDriver,
				PropertiesRepository.getString("id.login.proctor.username"),
				PropertiesRepository.getString("id.login.proctor.password"));
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));

		log(logger, "Clicking on Left Navigation Link");		
		//proctorChromePage.verifyAndClick2(proctorDriver, PropertiesRepository.getString("id.home.page.left.navigator.menu.link"), true);		//for newer version of firefox
		proctorChromePage.verifyAndClick(proctorDriver, PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true);		//for older version of firefox
		
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));

		log(logger, "Verifying Home Link in Left Navigation");
		VerificationHandler.verifyTrue(proctorChromePage.verifyLeftNavigationTextSearch(proctorDriver, "assessment",true), "Unable to verify Home ");
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		Thread.sleep(10000);
		
		log(logger, "Entering Proctor id, pwd and click submit button");
		proctorChromePage.enteringProctIdAndPwd(proctorDriver,
				PropertiesRepository.getString("id.rn.adult.medical.surgical.2013.proctor.id.value"),
				PropertiesRepository.getString("id.rn.adult.medical.surgical.2013.proctor.pwd.value"));
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc.new"));

		log(logger, "Entering Electornic Signature");
		proctorChromePage.enterElectornicSignature(proctorDriver,
				PropertiesRepository.getString("faculty.portal.product.select.activity.proctor.assessment.electronic.signature.textbox.loc"),
				PropertiesRepository.getString("faculty.portal.product.select.activity.proctor.assessment.electronic.signature.value"));

		log(logger, "Entering Date");
		proctorChromePage.enterElectornicSignature(proctorDriver,
				PropertiesRepository.getString("faculty.portal.product.select.activity.proctor.assessment.date.textbox.loc"),
				proctorChromePage.getCurrentDate("MM/dd/yyyy"));

		log(logger, "Click Proceed Button");
		proctorChromePage.clickProctorWelcomePageProceedButton(proctorDriver);
		proctorChromePage.waitUntillLoadingImageIsDisappeared(proctorDriver, PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		
		log(logger, "Clicking on Ignore Radio Button");
		proctorChromePage.clickIgnoreRadioButton(proctorDriver, PropertiesRepository.getString("id.proctor.ignore.radio.button.loc"), true);
		
		log(logger, "Clicking on Student Status Section ");
		proctorChromePage.clickStudentStatusForStopOrDeny(proctorDriver);
		
		log(logger, "Clicking on Close Radio button under Stopped Assessment section");
		proctorChromePage.clickCloseButtonInStoppedAssessmentSection(proctorDriver);
		
		//pre-condition ends
		
		//Step 1 --- starts here
		//Student Portal login starts here
		log(logger, "Login to Student Portal");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name.value"), 
			PropertiesRepository.getString("newati.login.passwordofuserwithrecent"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");	
		//Step 1 --- ends here

		//Step 2 --- starts here
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
		//Step 2 --- ends here
		
		//Step 3 --- starts here
		log(logger, "Clicking on Test Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");	
		//Step 3 --- ends here
		
		//Step 4 --- starts here
		log(logger, "Select proctored Assessment");
		practiseAssessmentPage.clickProctorAssessmentMoreThankOne(PropertiesRepository.getString("newati.proctored.module.assessment.name"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");  
		
		log(logger, "Verifying if Proctor Check Box (I agree) is present or not.");
		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("new-atitesting.test.assessment.checkbox.loc"), "I agree check box is not present.");
		//Step 4 --- starts here
		
		log(logger, "NewATI492_verifyTheProctorIAgreePage End");
	}

	@AfterMethod()
	public void finalMethod() {
		if (proctorDriver != null) {
			proctorDriver.quit();
		}
	}

}
