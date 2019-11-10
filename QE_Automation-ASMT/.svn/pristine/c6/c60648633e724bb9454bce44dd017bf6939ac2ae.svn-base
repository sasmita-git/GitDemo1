package com.automation.asmt.practice.assessment;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.asmt.page.AssessmentPage;
import com.automation.asmt.page.HomePage;
import com.automation.asmt.page.LoginPage;

public class TEASTest extends BaseTest {
	
	Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private AssessmentPage assessmentPage;

	@BeforeMethod
	public void verifyHomePage() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		assessmentPage = new AssessmentPage(driver);
		loginPage.loginToApplication(PropertiesRepository.getString("asmt.test10.username"),
				PropertiesRepository.getString("asmt.test10.password"));
	}
	
	@Test(priority = 1, alwaysRun = true, description = "ASMT-133:ASMT-1015:Verify ATI TEAS OP A and B order of sections appearing correctly in the New UI")
	public void ASMT133_VerifyTEASAssessment() throws Exception {
		log(logger, "ASMT133_VerifyTEASAssessment Start");
		log(logger, "Cicking in My ATI Tab");
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		homePage.clickLinkFromList("asmt.myati.main.tabs",1);

		log(logger, "Clicking on Test Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs",1);
		
		log(logger, "Clicking on Assessment Type");
		assessmentPage.clickAssessmentType(PropertiesRepository
				.getString("asmt.myati.practice.type"));
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		/*log(logger, "Clicking on Test Tab");
		assessmentPage.verifyMyATITabs(
				PropertiesRepository.getString("asmt.myati.all.tab.loc"), 1,
				PropertiesRepository.getString("asmt.myati.tabs.test"), true);*/

		/*log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButton("Practice Assessment",
				"Test of Essential Academic Skills Online Practice V A");*/

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		assessmentPage.clickTestTabAssessmentButtonWOSelectInstance(
				PropertiesRepository.getString("asmt.myati.assessment.type"),
				"Test of Essential Academic Skills Online Practice V A");
		
		log(logger, "TEAS Reading Section started");
		assessmentPage
				.verifyAssesmentHeaderName("Reading",
						".lesson-header-details ul li span[ data-atiid='assessmentTitle']");
		assessmentPage.takeTestTEAS(false, false, true, false);
		log(logger, "TEAS Reading Section Completed");
		
		assessmentPage
				.verifyAssesmentHeaderName("maths",
						".lesson-header-details ul li span[ data-atiid='assessmentTitle']");
		assessmentPage.takeTestTEAS(false, false, true, false);
		assessmentPage
				.verifyAssesmentHeaderName("english",
						".lesson-header-details ul li span[ data-atiid='assessmentTitle']");
		assessmentPage.takeTestTEAS(false, false, true, false);
		assessmentPage
				.verifyAssesmentHeaderName("ability",
						".lesson-header-details ul li span[ data-atiid='assessmentTitle']");
		assessmentPage.takeTestTEAS(false, false, true, false);
		assessmentPage
				.verifyAssesmentHeaderName("science",
						".lesson-header-details ul li span[ data-atiid='assessmentTitle']");
		assessmentPage.takeTestTEAS(false, false, true, false);
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
		log(logger, "ASMT133_VerifyTEASAssessment End");
	}
	
	@Test(priority = 2, alwaysRun = true, description = "ASMT-224:'Finalized and view results' should be displayed when the user completes the last section of a TEAS.")
	public void ASMT224_VerifyTEASAssessment() throws Exception {
		
		log(logger, "ASMT224_VerifyTEASAssessment Start");
		log(logger, "Cicking in My ATI Tab");
		homePage.clickOnMyAtiTab();

		log(logger, "Clicking on Test Tab");
		assessmentPage.verifyMyATITabs(
				PropertiesRepository.getString("asmt.myati.all.tab.loc"), 1,
				PropertiesRepository.getString("asmt.myati.tabs.test"), true);

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButton("Practice Assessment",
				"Test of Essential Academic Skills Online Practice V A");

		assessmentPage
				.verifyAssesmentHeaderName("Reading",
						".lesson-header-details ul li span[ data-atiid='assessmentTitle']");
		assessmentPage.takeTestTEAS(false, false, true, false);
		assessmentPage
				.verifyAssesmentHeaderName("maths",
						".lesson-header-details ul li span[ data-atiid='assessmentTitle']");
		assessmentPage.takeTestTEAS(false, false, true, false);
		assessmentPage
				.verifyAssesmentHeaderName("english",
						".lesson-header-details ul li span[ data-atiid='assessmentTitle']");
		assessmentPage.takeTestTEAS(false, false, true, false);
		assessmentPage
				.verifyAssesmentHeaderName("ability",
						".lesson-header-details ul li span[ data-atiid='assessmentTitle']");
		assessmentPage.takeTestTEAS(false, false, true, false);
		assessmentPage
				.verifyAssesmentHeaderName("science",
						".lesson-header-details ul li span[ data-atiid='assessmentTitle']");
		assessmentPage.takeTestTEAS(false, false, true, false);

		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
		
		log(logger, "ASMT224_VerifyTEASAssessment End");
	}

	//@Test(priority = 3, alwaysRun = true, description = " ASMT-220:Verify Assessment Completed header in completion window of TEAS assessment")
	public void ASMT220_VerifyTEASCompletionWindow() throws Exception {
		
		log(logger, "ASMT220_VerifyTEASCompletionWindow Start");
		log(logger, "Cicking in My ATI Tab");
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		homePage.clickLinkFromList("asmt.myati.main.tabs",1);

		log(logger, "Clicking on Test Tab");
		homePage.clickLinkFromList("asmt.myati.sub.tabs",1);
		
		log(logger, "Clicking on Assessment Type");
		assessmentPage.clickAssessmentType(PropertiesRepository
				.getString("asmt.myati.practice.type"));
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		assessmentPage.clickTestTabAssessmentButtonWOSelectInstance(
				PropertiesRepository.getString("asmt.myati.assessment.type"),
				"Test of Essential Academic Skills Online Practice V A");

		assessmentPage
				.verifyAssesmentHeaderName("Reading",
						".lesson-header-details ul li span[ data-atiid='assessmentTitle']");
		assessmentPage.takeTestTEASVerifySection(false, false, true, false);
		assessmentPage
				.verifyAssesmentHeaderName("maths",
						".lesson-header-details ul li span[ data-atiid='assessmentTitle']");
		assessmentPage.takeTestTEASVerifySection(false, false, true, false);
		assessmentPage
				.verifyAssesmentHeaderName("english",
						".lesson-header-details ul li span[ data-atiid='assessmentTitle']");
		assessmentPage.takeTestTEASVerifySection(false, false, true, false);
		assessmentPage
				.verifyAssesmentHeaderName("ability",
						".lesson-header-details ul li span[ data-atiid='assessmentTitle']");
		assessmentPage.takeTestTEASVerifySection(false, false, true, false);
		assessmentPage
				.verifyAssesmentHeaderName("science",
						".lesson-header-details ul li span[ data-atiid='assessmentTitle']");
		assessmentPage.takeTestTEASVerifyFinalSection(false, false, true, false);

		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
		
		log(logger, "ASMT220_VerifyTEASCompletionWindow End");
	}
}
