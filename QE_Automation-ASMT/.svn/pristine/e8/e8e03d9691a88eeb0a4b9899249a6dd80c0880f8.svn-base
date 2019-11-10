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
import com.automation.asmt.page.ItemTypeRegressionPage2;
import com.automation.asmt.page.LoginPage;

public class TEASTest2 extends BaseTest {
	
	Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private AssessmentPage assessmentPage;
	private ItemTypeRegressionPage2 itemTypeRegressionTest2;
	
	@BeforeMethod
	public void verifyHomePage() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		assessmentPage = new AssessmentPage(driver);
		itemTypeRegressionTest2 = new ItemTypeRegressionPage2(driver);
		loginPage.loginToApplication(PropertiesRepository.getString("asmt.test10.username"),
				PropertiesRepository.getString("asmt.test10.password"));
		
	}
	
	/**
	 * Not completed fully, need user with rationale off. 
	 * 
	 * @throws Exception
	 */
	//@Test(priority = 1, alwaysRun = true, description = "ASMT-16:Practice Assessments - Change Answer - Rationales Off, Forward-Only Off - Short Version")
	public void ASMT16_VerifyTEASRationaleOffAssessment() throws Exception {
		log(logger, "ASMT16_VerifyTEASRationaleOffAssessment Start");
		
		//loginPage.loginToApplication("stageabcd","Test123");
		loginPage.loginToApplication(PropertiesRepository.getString("asmt.practice.assessment.teas.login.username.value"),PropertiesRepository.getString("asmt.practice.assessment.teas.login.pwd.value"));
		
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
		log(logger, "ASMT16_VerifyTEASRationaleOffAssessment End");
	}
	
	@Test(priority = 2, alwaysRun = true, description = "ASMT-137:ASMT-39:Verify and convert completion modal on the practice assessment page for New ATI")
	public void ASMT137_VerifyTEASLastSection() throws Exception {
		log(logger, "ASMT137_VerifyTEASLastSection Start");
		
		//loginPage.loginToApplication("Automation.User22","Test123");
		loginPage.loginToApplication(PropertiesRepository.getString("asmt.practice.assessment.teas.login.username.value"),PropertiesRepository.getString("asmt.practice.assessment.teas.login.pwd.value"));
		
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
		VerificationHandler.verifyTrue(assessmentPage.takeTEASVerifyingGoToBackSection(false, false, true, false), "Unable to verify last question by clicking go back button in last section");
		
		VerificationHandler.verifyTrue(assessmentPage.takeTestTEASVerifyLastSection(false, false, true, false),"Unable to complete assessment");
		
		
		log(logger, "Verifying IPP Page Header");
		//VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
		log(logger, "ASMT137_VerifyTEASLastSection End");
		
	}
	
	
	//@Test(priority = 3, alwaysRun = true, description = "ASMT-289:Verify user is getting IPP after completing Post assessment survey.")
	public void ASMT289_VerifyTEASPostAssessmentSurveySection() throws Exception {
		log(logger, "ASMT289_VerifyTEASPostAssessmentSurveySection Start");
		
		loginPage.loginToApplication("Automation.User22","Test123");
		
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
		VerificationHandler.verifyTrue(assessmentPage.takeTEASVerifyingGoToBackSection(false, false, true, false), "Unable to verify last question by clicking go back button in last section");
		
		VerificationHandler.verifyTrue(assessmentPage.takeTestTEASVerifyLastSection(false, false, true, false),"Unable to complete assessment");
		
		
		log(logger, "Verifying IPP Page Header");
		//VerificationHandler.verifyTrue(assessmentPage.verifyIPPPageHeader(), "Verifying IPP Page Header");
		log(logger, "ASMT289_VerifyTEASPostAssessmentSurveySection End");
		
	}
	
	//@Test(priority = 4, alwaysRun = true, description = "ASMT-270:Verify User can move Exhibit window in TEAS practice assessment.")
		public void ASMT270_VerifyExhibitWindowInTEAS() throws Exception {
			log(logger, "ASMT270_VerifyExhibitWindowInTEAS Start");
			
			loginPage.loginToApplication("AutoUser23022018534","Test123");
			
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
					"ATI TEAS Equating Basea");
			
			VerificationHandler.verifyTrue(itemTypeRegressionTest2.takeTestTEASExhibitMoveSection(false, false, "Proceed "),"Unable to TEAS Section 1complete assessment");
			
			VerificationHandler.verifyTrue(itemTypeRegressionTest2.takeTestTEASExhibitMoveSection(false, false, "Proceed "),"Unable to TEAS Section 2 complete assessment");
			
			VerificationHandler.verifyTrue(itemTypeRegressionTest2.takeTestTEASExhibitMoveSection(false, false, "Proceed "),"Unable to TEAS Section 3 complete assessment");
			
			VerificationHandler.verifyTrue(itemTypeRegressionTest2.takeTestTEASExhibitMoveSection(false, false, "Survey "),"Unable to TEAS Section 4 complete assessment");
			
			VerificationHandler.verifyTrue(itemTypeRegressionTest2.takeTestTEASExhibitLastSurveySection(false, false),"Unable to complete assessment");
			log(logger, "ASMT270_VerifyExhibitWindowInTEAS End");
			
		}
}
