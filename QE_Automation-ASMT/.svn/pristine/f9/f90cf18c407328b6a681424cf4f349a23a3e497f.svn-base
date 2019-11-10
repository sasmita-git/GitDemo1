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

public class TEASTest3 extends BaseTest {
	
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
	
	@Test(priority = 1, alwaysRun = true, description = "ASMT-216:Verify TEAS practice assessment header.")
	public void ASMT216_VerifyTEASHeader() throws Exception {
		log(logger, "ASMT216_VerifyTEASHeader Start");
		
		//loginPage.loginToApplication("AutoUser23022018862", "Test123");
		
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
				"ATI TEAS Equating Basea");
		assessmentPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		VerificationHandler.verifyTrue(assessmentPage
				.verifyAssesmentHeaderName(".lesson-header-details ul li span[ data-atiid='assessmentTitle']"),
				"Unable to verify TEAS Assessment Header");
		assessmentPage.takeTestTEAS(false, false, false, false);
		
		VerificationHandler.verifyTrue(assessmentPage
				.verifyAssesmentHeaderName(".lesson-header-details ul li span[ data-atiid='assessmentTitle']"),
				"Unable to verify TEAS Assessment Header");
		assessmentPage.takeTestTEAS(false, false, false, false);
		
		VerificationHandler.verifyTrue(assessmentPage
				.verifyAssesmentHeaderName(".lesson-header-details ul li span[ data-atiid='assessmentTitle']"),
				"Unable to verify TEAS Assessment Header");
		assessmentPage.takeTestTEAS(false, false, false, false);
		
		VerificationHandler.verifyTrue(assessmentPage
				.verifyAssesmentHeaderName(".lesson-header-details ul li span[ data-atiid='assessmentTitle']"),
				"Unable to verify TEAS Assessment Header");
		assessmentPage.takeTestTEAS(false, false, false, false);
		
		VerificationHandler.verifyTrue(assessmentPage
				.verifyAssesmentHeaderName(".lesson-header-details ul li span[ data-atiid='assessmentTitle']"),
				"Unable to verify TEAS Assessment Header");
		assessmentPage.takeTestTEAS(false, false, false, false);
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
		
		log(logger, "ASMT216_VerifyTEASHeader End");
	}




@Test(priority = 2, alwaysRun = true, description = "ASMT-276:Verify Rational is not display for Post Assessment Survey")
public void ASMT276_VerifyRationalPostAssessment() throws Exception {
	log(logger, "ASMT276_VerifyRationalPostAssessment Start");
	
	//loginPage.loginToApplication("AutoUser23022018862", "Test123");
	
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
			"ATI TEAS Equating Basea");
	
	log(logger, "Answer all questions in first section and click on go to next section");
	VerificationHandler.verifyTrue(assessmentPage.takeTestTEASSection(false, false, false, false),
			"Unable to Answer all questions in first section and click on go to next section");
	
	log(logger, "Answer all questions in second section and click on go to next section");
	VerificationHandler.verifyTrue(assessmentPage.takeTestTEASSection(false, false, false, false),
			"Unable to Answer all questions in second section and click on go to next section");
	
	log(logger, "Answer all questions in third section and click on go to next section");
	VerificationHandler.verifyTrue(assessmentPage.takeTestTEASSection(false, false, false, false),
			"Unable to Answer all questions in third section and click on go to next section");
	
	log(logger, "Answer all questions in fourth section and click on Complete Post Assessment");
	VerificationHandler.verifyTrue(assessmentPage.takeTestTEASPostAssessmentSection(false, false, false, false),
			"Unable to Answer all questions in fourth section and click on Complete Post Assessment");
	
	log(logger, "Answer all questions in post assessment and click on Finalize Assessment");
	VerificationHandler.verifyTrue(assessmentPage.takeTestTEASVerifyFinalSectionAfterPostAssessment(false, false, false, false),
			"Unable to Answer all questions in post assessment and click on Finalize Assessment");
	
	log(logger, "Verifying IPP Page Header");
	VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
	
	log(logger, "ASMT276_VerifyRationalPostAssessment End");
}

@Test(priority = 3, alwaysRun = true, description = "ASMT-220:Verify Assessment Completed header in completion window of TEAS assessment")
public void ASMT220_VerifyAssessmentCompleted() throws Exception {
	log(logger, "ASMT220_VerifyAssessmentCompleted Start");
	
	//loginPage.loginToApplication("AutoUser23022018862", "Test123");
	
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
			"ATI TEAS Equating Basea");
	
	log(logger, "Verify Section completed message and go to next section");
	VerificationHandler.verifyTrue(assessmentPage.takeTestTEASSection(false, false, false, false),"Unable to verify Section completed message and go to next section");
	
	log(logger, "Verify Section completed message and go to next section");
	VerificationHandler.verifyTrue(assessmentPage.takeTestTEASSection(false, false, false, false),"Unable to verify Section completed message and go to next section");
	
	log(logger, "Verify Section completed message and go to next section");
	VerificationHandler.verifyTrue(assessmentPage.takeTestTEASSection(false, false, false, false),"Unable to verify Section completed message and go to next section");		
	
	log(logger, "Verify assessment completed message and finalize results");
	VerificationHandler.verifyTrue(assessmentPage.takeTestTEASFinalSection(false, false, false, false),"Unable to verify assessment completed message and finalize results");;
	
	log(logger, "Verifying IPP Page Header");
	VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
	
	log(logger, "ASMT220_VerifyAssessmentCompleted End");
}

@Test(priority = 4, alwaysRun = true, description = "ASMT-311:Verify CompletePostAssessmentSurvey button is displayed if IsPostSurveyMandatory is true.")
public void ASMT311_VerifyNoRationalPostAssessment() throws Exception {
	log(logger, "ASMT311_VerifyNoRationalPostAssessment Start");
	
	//loginPage.loginToApplication("AutoUser23022018862", "Test123");
	
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
			"ATI TEAS Equating Basea");
	
	log(logger, "Answer all questions in first section and click on go to next section");
	assessmentPage.takeTestTEASSection(false, false, false, false);
	
	log(logger, "Answer all questions in second section and click on go to next section");
	assessmentPage.takeTestTEASSection(false, false, false, false);
	
	log(logger, "Answer all questions in third section and click on go to next section");
	assessmentPage.takeTestTEASSection(false, false, false, false);
	
	log(logger, "Answer all questions in fourth section and click on Complete Post Assessment");
	VerificationHandler.verifyTrue(assessmentPage.takeTestTEASPostAssessmentSection(false, false, false, false),
			"Unable to click on Complete Post Assessment");
	
	log(logger, "Answer all questions in post assessment and click on Finalize Assessment");
	VerificationHandler.verifyTrue(assessmentPage.takeTestTEASVerifyFinalSectionAfterPostAssessment(false, false, false, false),
			"Unable to Answer all questions in post assessment and click on Finalize Assessment");
	
	log(logger, "Verifying IPP Page Header");
	VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
	
	log(logger, "ASMT311_VerifyNoRationalPostAssessment End");
}

@Test(priority = 5, alwaysRun = true, description = "ASMT-407:Verify Correct Flagged question count is shown in Assessment Completed model of TEAS assessment")
public void ASMT407_VerifyCorrectFlaggedQuestion() throws Exception {
	log(logger, "ASMT407_VerifyCorrectFlaggedQuestion Start");
	
	//loginPage.loginToApplication("AutoUser23022018862", "Test123");
	
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
			"ATI TEAS Equating Basea");
	
	log(logger, "Flag all questions in first section and click on go to Review");
	VerificationHandler.verifyTrue(assessmentPage.takeTestTEASFlagAllQuestionsAndReviewInSection(false, false, false, false),
			"Unable to flag all questions in first section and click on go to Review");
	
	log(logger, "Review all flagged questions in first section and click on go to next section");
	VerificationHandler.verifyTrue(assessmentPage.takeTestTEASReviewAllFlaggedQuestionsAndProceedNextSection(false, false, false, false),
			"Unable to review all flagged questions in first section and click on go to next section");
	
	log(logger, "Flag all questions in second section and click on go to Review");
	VerificationHandler.verifyTrue(assessmentPage.takeTestTEASFlagAllQuestionsAndReviewInSection(false, false, false, false),
			"Unable to flag all questions in second section and click on go to Review");
	
	log(logger, "Review all flagged questions in second section and click on go to next section");
	VerificationHandler.verifyTrue(assessmentPage.takeTestTEASReviewAllFlaggedQuestionsAndProceedNextSection(false, false, false, false),
			"Unable to Review all flagged questions in second section and click on go to next section");
	
	log(logger, "Flag all questions in third section and click on go to Review");
	VerificationHandler.verifyTrue(assessmentPage.takeTestTEASFlagAllQuestionsAndReviewInSection(false, false, false, false),
			"Unable to Flag all questions in third section and click on go to Review");
	
	log(logger, "Review all flagged questions in third section and click on go to next section");
	VerificationHandler.verifyTrue(assessmentPage.takeTestTEASReviewAllFlaggedQuestionsAndProceedNextSection(false, false, false, false),
			"Unable to Review all flagged questions in third section and click on go to next section");
	
	log(logger, "Flag all questions in final section and click on go to Review");
	VerificationHandler.verifyTrue(assessmentPage.takeTestTEASFlagAllQuestionsInFinalSectionAndReviewInSection(false, false, false, false),
			"Unable to flag all questions in final section and click on go to Review");
	
	log(logger, "Review all flagged questions in final section and click on go to next section");
	VerificationHandler.verifyTrue(assessmentPage.takeTestTEASReviewAllFlaggedQuestionsAndFinalizeResults(false, false, false, false),
			"Unable to Review all flagged questions in final section and click on go to next section");
	
	log(logger, "Verifying IPP Page Header");
	VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
	
	log(logger, "ASMT407_VerifyCorrectFlaggedQuestion End");
}


@Test(priority = 6, alwaysRun = true, description = "ASMT-244:Flag all the questions in a TEAS section and select Proceed to the next Section")
public void ASMT244_VerifyFlagAllTEASSection() throws Exception 
{
	log(logger, "ASMT244_VerifyFlagAllTEASSection Start");
	
	//loginPage.loginToApplication("AutoUser23022018862", "Test123");
	
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
			"ATI TEAS Equating Basea");
	
	log(logger, "Flag all questions in first section and click on go to Review");
	VerificationHandler.verifyTrue(assessmentPage.takeTestTEASFlagAllQuestionsAndReviewInSection(false, false, false, false),
			"Unable to flag all questions in first section and click on go to Review");
	
	log(logger, "Review all flagged questions in first section and click on Go Back to Last Question");
	VerificationHandler.verifyTrue(assessmentPage.takeTestTEASReviewAllFlaggedQuestionsAndGoBackToLastQuestion(false, false, false, false),
			"Unable to review all flagged questions in first section and click on Go Back to Last Question");
	
	log(logger, "Answer the last questions in first section and click on proceed to next section");
	VerificationHandler.verifyTrue(assessmentPage.takeTestTEASSectionLastQuestion(false, false, false, false),
			"Unable to answer the last questions in first section and click on proceed to next section");
	
	log(logger, "Answer all questions in second section and click on go to next section");
	assessmentPage.takeTestTEASSection(false, false, false, false);
	
	log(logger, "Answer all questions in third section and click on go to next section");
	assessmentPage.takeTestTEASSection(false, false, false, false);
	
	log(logger, "Flag all questions in final section and click on go to Revie");
	VerificationHandler.verifyTrue(assessmentPage.takeTestTEASFlagAllQuestionsInFinalSectionAndReviewInSection(false, false, false, false),
			"Unable to flag all questions in final section and click on go to Review");
	
	log(logger, "Review all flagged questions in final section and click on go to next section");
	VerificationHandler.verifyTrue(assessmentPage.takeTestTEASReviewAllFlaggedQuestionsAndFinalizeResults(false, false, false, false),
			"Unable to Review all flagged questions in final section and click on go to next section");
	
	
	log(logger, "Verifying IPP Page Header");
	VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
	
	log(logger, "ASMT244_VerifyFlagAllTEASSection End");
}

@Test(priority = 7, alwaysRun = true, description = "ASMT-245:TEAS: 'Section Completed' should be displayed when all the questions in the section are flagged/ans")
public void ASMT245_VerifyFlagAllTEASSectionCompletedMsg() throws Exception 
{
	log(logger, "ASMT245_VerifyFlagAllTEASSectionCompletedMsg Start");
	
	//loginPage.loginToApplication("AutoUser23022018862", "Test123");
	
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
			"ATI TEAS Equating Basea");
	
	log(logger, "Flag all questions in first section and click on go to Review");
	VerificationHandler.verifyTrue(assessmentPage.takeTestTEASFlagAllQuestionsAndReviewInSection(false, false, false, false),
			"Unable to flag all questions in first section and click on go to Review");
	
	log(logger, "Review all flagged questions in first section and click on Go Back to Last Question");
	VerificationHandler.verifyTrue(assessmentPage.takeTestTEASReviewAllFlaggedQuestionsAndGoBackToLastQuestion(false, false, false, false),
			"Unable to review all flagged questions in first section and click on Go Back to Last Question");
	
	log(logger, "Answer the last questions in first section and click on proceed to next section");
	VerificationHandler.verifyTrue(assessmentPage.takeTestTEASSectionLastQuestion(false, false, false, false),
			"Unable to answer the last questions in first section and click on proceed to next section");
	
	log(logger, "Answer all questions in second section and click on go to next section");
	assessmentPage.takeTestTEASSection(false, false, false, false);
	
	log(logger, "Answer all questions in third section and click on go to next section");
	assessmentPage.takeTestTEASSection(false, false, false, false);
	
	log(logger, "Answer few questions in final section and flag few questions and click on go to Review");
	VerificationHandler.verifyTrue(assessmentPage.takeTestTEASSectionAnswerFewQuestionsAndFlagFewQuestionsInLastSection(false, false, false, false),
			"Unable to flag all questions in final section and click on go to Review");
	
	log(logger, "Review all flagged questions in final section and click on go to next section");
	VerificationHandler.verifyTrue(assessmentPage.takeTestTEASReviewAllFlaggedQuestionsAndFinalizeResults(false, false, false, false),
			"Unable to Review all flagged questions in final section and click on go to next section");
	
	
	log(logger, "Verifying IPP Page Header");
	VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
	
	log(logger, "ASMT245_VerifyFlagAllTEASSectionCompletedMsg End");
}
	
}
