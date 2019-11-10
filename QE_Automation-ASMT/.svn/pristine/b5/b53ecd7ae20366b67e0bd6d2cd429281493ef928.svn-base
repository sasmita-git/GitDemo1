package com.automation.asmt.practice.assessment.student;

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

public class StudentPracticeAssessmentTest1 extends BaseTest {

	Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private AssessmentPage assessmentPage;

	@BeforeMethod
	public void verifyHomePage() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		assessmentPage = new AssessmentPage(driver);

		loginPage.loginToApplication(
				PropertiesRepository.getString("asmt.username"),
				PropertiesRepository.getString("asmt.password"));
	}

	@Test(priority = 1, alwaysRun = true, groups = { "Smoke" }, description = "ASMT-171:ASMT 1739:Verify pointer should be disabled on FLAG icon, when the FLAG icon is set to off/disable")
	public void verifyPointerFlagFunctionality() throws Exception {
		log(logger, "Cicking in My ATI Tab");
		homePage.clickOnMyAtiTab();

		log(logger, "Clicking on Test Tab");
		assessmentPage.verifyMyATITabs(
				PropertiesRepository.getString("asmt.myati.all.tab.loc"), 1,
				PropertiesRepository.getString("asmt.myati.tabs.test"), true);

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButton("Practice Assessment",
				"Targeted Medical-Surgical 2010: Respiratory");

		log(logger, "completing section 1");
		assessmentPage.takeTest(false, true, true, false);

		VerificationHandler.verifyTrue(assessmentPage.verifyFlagDisabled());

	}

	@Test(priority = 2, alwaysRun = true, groups = { "Smoke" }, description = "ASMT-231:FNB Numeric Question: The Answer text box should accept upto 20 numbers(upto 19 numbers+1 decimal)19")
	public void verifyTextBoxFunctionality() throws Exception {
		log(logger, "Cicking in My ATI Tab");
		homePage.clickOnMyAtiTab();

		log(logger, "Clicking on Test Tab");
		assessmentPage.verifyMyATITabs(
				PropertiesRepository.getString("asmt.myati.all.tab.loc"), 1,
				PropertiesRepository.getString("asmt.myati.tabs.test"), true);

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButton("Practice Assessment",
				"Targeted Medical-Surgical 2010: Respiratory");

		log(logger, "completing section 1");
		assessmentPage
				.takeTestTillTypeOfQuestion(true, "text",
						"11111111111111111111111111111111111111111111111111111111111qqqqqqqqqq11111111",false);

		String value = assessmentPage
				.getTextBoxValue("input[class^='answer-fill-in-the-blank']");

		VerificationHandler
				.verifyNotEquals(
						"11111111111111111111111111111111111111111111111111111111111qqqqqqqqqq11111111",
						value);
	}

	@Test(priority = 3, alwaysRun = true, groups = { "Smoke" }, description = "ASMT-193:ASMT-36:Verify Submit buttons functionality in Angular")
	public void verifySubmitButtonFunctionalityRatinalon() throws Exception {
		log(logger, "Cicking in My ATI Tab");
		homePage.clickOnMyAtiTab();

		log(logger, "Clicking on Test Tab");
		assessmentPage.verifyMyATITabs(
				PropertiesRepository.getString("asmt.myati.all.tab.loc"), 1,
				PropertiesRepository.getString("asmt.myati.tabs.test"), true);

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButton("Practice Assessment",
				"Targeted Medical-Surgical 2010: Respiratory");

		log(logger, "verifying the submit disabled");
		VerificationHandler.verifyTrue(assessmentPage.verifySubmitDisabled());

		log(logger, "verifying the submit disabled");
		assessmentPage.takeTest(true, true, true, false);

		log(logger, "verifying the submit disabled");
		assessmentPage.verifyAndClickPrevious(true);

		log(logger, "verifying the submit disabled");
		assessmentPage.verifySubmitDisabled();

	}
	
	
	/**
	 * Sharan told to complete one TEAS Assessment either A or B.
	 * 
	 * @throws Exception
	 */
	@Test(priority = 4, alwaysRun = true, groups = { "Smoke" }, description = "ASMT-133:ASMT-37:Verify Previous/Continue buttons functionality in Angular")
	public void verifyTeasSectionOrder() throws Exception {
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
		assessmentPage.takeTest(true, false, true, false);
		assessmentPage
				.verifyAssesmentHeaderName("maths",
						".lesson-header-details ul li span[ data-atiid='assessmentTitle']");
		assessmentPage.takeTest(true, false, true, false);
		assessmentPage
				.verifyAssesmentHeaderName("english",
						".lesson-header-details ul li span[ data-atiid='assessmentTitle']");
		assessmentPage.takeTest(true, false, true, false);
		assessmentPage
				.verifyAssesmentHeaderName("ability",
						".lesson-header-details ul li span[ data-atiid='assessmentTitle']");
		assessmentPage.takeTest(true, false, true, false);
		assessmentPage
				.verifyAssesmentHeaderName("science",
						".lesson-header-details ul li span[ data-atiid='assessmentTitle']");
		assessmentPage.takeTest(true, false, true, false);

	}
	
	/**
	 * This test cases will verify Rationale On Scenarios. 
	 * 
	 * @throws Exception
	 */
	@Test(priority = 5, alwaysRun = true, groups = { "Smoke" }, description = "ASMT-176:ASMT-37:Verify Previous/Continue buttons functionality in Angular")
	public void verifyOPMultipleANSWER() throws Exception {
		log(logger, "Cicking in My ATI Tab");
		homePage.clickOnMyAtiTab();

		log(logger, "Clicking on Test Tab");
		assessmentPage.verifyMyATITabs(
				PropertiesRepository.getString("asmt.myati.all.tab.loc"), 1,
				PropertiesRepository.getString("asmt.myati.tabs.test"), true);

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButton("Practice Assessment",
				"Item Type Regression Test (OP)");

		assessmentPage
				.takeTestTillTypeOfQuestion(true, "checkbox", "12", false);
		
		assessmentPage.verifySubmitButton(true);
		
		assessmentPage.verifyRationaleAndMyAnswer();
		
	}
	
	/**
	 * Need proper question type to answer, if not the test case will fail.
	 * 
	 * @throws Exception
	 */
	@Test(priority = 6, alwaysRun = true, groups = { "Smoke" }, description = "ASMT-181:ASMT-1744: Validate the Drag and Drop functionality for Question - Answer Box.")
	public void verifyDragAndDrop() throws Exception {
		log(logger, "Cicking in My ATI Tab");
		homePage.clickOnMyAtiTab();

		log(logger, "Clicking on Test Tab");
		assessmentPage.verifyMyATITabs(
				PropertiesRepository.getString("asmt.myati.all.tab.loc"), 1,
				PropertiesRepository.getString("asmt.myati.tabs.test"), true);

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButton("Practice Assessment",
				"Item Type Regression Test (OP)");

		log(logger, "Dragging and drop answer");
		assessmentPage.takeTestTillTypeOfQuestion(true, "draganddrop", "10",false);

		VerificationHandler.verifyTrue(assessmentPage.verifySubmitButton(false));
	}
	
	
	@Test(priority = 7, alwaysRun = true, groups = { "Smoke" }, description = "ASMT-182:Verify the Hotspot question type to display in Angular")
	public void verifyHotspotTypeQuestion() throws Exception {
		log(logger, "Cicking in My ATI Tab");
		homePage.clickOnMyAtiTab();

		log(logger, "Clicking on Test Tab");
		assessmentPage.verifyMyATITabs(
				PropertiesRepository.getString("asmt.myati.all.tab.loc"), 1,
				PropertiesRepository.getString("asmt.myati.tabs.test"), true);

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButton("Practice Assessment",
				"Item Type Regression Test (OP)");

		log(logger, "Clicking on Practice Assessmen");
		assessmentPage.takeTestTillTypeOfQuestion(true,"hotspot", "10",false);
		
		VerificationHandler.verifyTrue(assessmentPage.verifySubmitButton(false));
	}
	
	/**
	 * Drag and Drop in Target Text area.
	 * 
	 * @throws Exception
	 */
	@Test(priority = 8, alwaysRun = true, groups = { "Smoke" }, description = "MT-183:ASMT-1778:Verify the cursor functionality for Drag and Drop Question - Answer Box.")
	public void verifyDragBox() throws Exception {
		log(logger, "Cicking in My ATI Tab");
		homePage.clickOnMyAtiTab();

		log(logger, "Clicking on Test Tab");
		assessmentPage.verifyMyATITabs(
				PropertiesRepository.getString("asmt.myati.all.tab.loc"), 1,
				PropertiesRepository.getString("asmt.myati.tabs.test"), true);

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButton("Practice Assessment",
			"Item Type Regression Test (OP)");

	   
		assessmentPage.takeTestTillTypeOfQuestion(true,"draganddrop", "12",false);
		
		assessmentPage.verifySubmitButton(false);
	}
	
	@Test(priority = 9, alwaysRun = true, groups = { "Smoke" }, description = " ASMT-184:ASMT-1744: Validate the Forward Navigation for Drag-Drop Question.")
	public void verifyDragIncomplete() throws Exception {
		log(logger, "Cicking in My ATI Tab");
		homePage.clickOnMyAtiTab();

		log(logger, "Clicking on Test Tab");
		assessmentPage.verifyMyATITabs(
				PropertiesRepository.getString("asmt.myati.all.tab.loc"), 1,
				PropertiesRepository.getString("asmt.myati.tabs.test"), true);

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButton("Practice Assessment",
			"Item Type Regression Test (OP)");

	   
		assessmentPage.takeTestTillTypeOfQuestion(true,"draganddrop", "12",true);
		
		assessmentPage.verifyAndClickCountinue(true);
		
		log(logger,"verifiy the error messgae");
		VerificationHandler.verifyTrue(assessmentPage.verifyMessage("Please submit an answer or flag the question to continue.", PropertiesRepository.getString("asmt.question.unsweredpopup.loc")));
		 
		log(logger,"Click Close Button");
		assessmentPage.clickModalclose();
		
		log(logger,"Completing Drag and Drop ");
		assessmentPage.DragAndDropAnswer(false);
		
		log(logger,"verifiy the submit button");
		assessmentPage.verifySubmitButton(false);
	}
	
	@Test(priority = 10, alwaysRun = true, groups = { "Smoke" }, description = " ASMT-185:ASMT-1744: Validate the Backward Navigation for Drag-Drop Question.")
	public void verifyDragIncompleteClicksubmit() throws Exception {
		log(logger, "Cicking in My ATI Tab");
		homePage.clickOnMyAtiTab();

		log(logger, "Clicking on Test Tab");
		assessmentPage.verifyMyATITabs(
				PropertiesRepository.getString("asmt.myati.all.tab.loc"), 1,
				PropertiesRepository.getString("asmt.myati.tabs.test"), true);

		log(logger, "Clicking on Practice Assessment ");
		assessmentPage.clickTestTabAssessmentButton("Practice Assessment",
			"Item Type Regression Test (OP)");

	   
		assessmentPage.takeTestTillTypeOfQuestion(true,"draganddrop", "12",true);
		
		assessmentPage.verifyAndClickCountinue(true);
		
		log(logger,"verifiy the error messgae");
		VerificationHandler.verifyTrue(assessmentPage.verifyMessage("Please submit an answer or flag the question to continue.", PropertiesRepository.getString("asmt.question.unsweredpopup.loc")));
		  
		log(logger,"verifiy the error messgae");
		assessmentPage.clickModalclose();
		
		log(logger,"verifiy the error messgae");
		assessmentPage.DragAndDropAnswer(false);
		
		log(logger,"verifiy the submit button");
		assessmentPage.verifySubmitButton(true);
		
	}
}
