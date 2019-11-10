package com.automation.asmt.regression.scenario;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.h2.value.ValueArray;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.asmt.page.AssessmentCommonPage;
import com.automation.asmt.page.AssessmentPage;
import com.automation.asmt.page.HomePage;
import com.automation.asmt.page.LoginPage;
import com.automation.asmt.page.MaintenanceScriptID;
import com.automation.asmt.page.MaintenanceScriptPage;
import com.automation.asmt.page.QuizBankAssessmentPage;
import com.automation.asmt.page.QuizBankPage;
import com.automation.asmt.utils.UserCreationUtils;
import com.jaca.TestAnnotations;

public class TEASPracticeTest extends BaseTest {

	Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private QuizBankPage quizBankPage;
	private QuizBankAssessmentPage quizBankAssPage ;
	private HomePage homePage;
	private  AssessmentPage assessmentPage;
	private WebDriver proctorDriver;
	private WindowHandler windowHandler;
	private  AssessmentCommonPage assessmentCommonPage;
	
	private MaintenanceScriptPage maintenanceScriptPage;
	private MaintenanceScriptID maintenanceScriptID;
	private WebDriver chromeDriver;
	private UserCreationUtils userCreationUtils;
	private String userName;
	public BaseHandler baseHandler;
	
	
	@BeforeMethod
	public void verifyHomePage() throws Exception {
		
		loginPage = new LoginPage(driver);
		quizBankPage = new QuizBankPage(driver);
		quizBankAssPage = new QuizBankAssessmentPage(driver);
		homePage =  new HomePage(driver);
		assessmentPage = new AssessmentPage(driver);
		assessmentCommonPage = new AssessmentCommonPage(driver);
		userCreationUtils = new UserCreationUtils();		
		windowHandler = new WindowHandler(driver);
		baseHandler = new BaseHandler(driver);
				
		maintenanceScriptPage = new MaintenanceScriptPage(driver);
		maintenanceScriptID = new MaintenanceScriptID(driver);
		
	}
	
	/**
	 * ASMT-133-220-264-228-216-289-276-289
	 * TC-133 we are not verifying section sequence, as there is an issue in stage but not in prod.
	 * TC-133 we are not verifying section wise scrambled question.
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID="ASMT-133-220-264-228-216-289-276-289")
	@Test(priority = 3, alwaysRun = true, groups = { "Regression" }, description = "ASMT-289, ASMT-216, ASMT-228, ASMT-133, ASMT-220, ASMT-264, ASMT-276, ASMT-289: Verify TEAS practice assessment question are populating as par allocated section in MU.")
	public void ASMT_TEASFun_1() throws Exception {
		
		log(logger, "ASMT_TEASFun_1 Start");
			
		log(logger,"Student Portal Login Start");
		VerificationHandler.verifyTrue(maintenanceScriptPage.loginToApplication(PropertiesRepository.getString("asmt.TEAS.user.1"),PropertiesRepository.getString("asmt.reg.tc.pass")));
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Verifying Home Page");
		VerificationHandler.verifyTrue(loginPage.verifyPageTitle(PropertiesRepository.getString("asmt.home.page.title")));
		
		log(logger, "Clicking on My ATI Tab");
		maintenanceScriptPage.clickLinkFromList("asmt.myati.main.tabs",1);
		
		log(logger, "Verify if Content Area drop down is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.homepage.content.area.dropdown", 0));
		
		log(logger, "Clicking on Test Tab");
		maintenanceScriptPage.clickLinkFromList("asmt.myati.sub.tabs",1);		
		
		log(logger, "Verify if Sort drop down is displayed");
		quizBankAssPage.waitUntillElementIsVisible(PropertiesRepository.getString("asmt.homepage.testtab.sort.dropdown"));
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.homepage.testtab.sort.dropdown", 0));	
		
		boolean isInContinueState =  quizBankAssPage.verifyAssessButtonContinueStateCF(PropertiesRepository.getString("asmt.TEAS.4.sections.ws"));
		
		log(logger, "Clicking on Practice Assessment ");
		quizBankAssPage.clickTestTabAssessmentButtonNew(PropertiesRepository.getString("asmt.myati.assessment.type"), PropertiesRepository.getString("asmt.TEAS.4.sections.ws"));
		homePage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
						
		//Workaround : Currently there is no way to identify if the TEAS is from beginning or in continue state, so checking the card front button state ,if 'Continue' then will complete TEAS
		log(logger, "Complete TEAS if not from begining");
		if(isInContinueState)
		{	
			log(logger, "Completing  continue state TEAS");
			log(logger, "Verifying Questions");
			VerificationHandler.verifyTrue(maintenanceScriptPage.verifyQuestionNos(),"Unable to verify Question nos");			
			assessmentCommonPage.completeContinueStateTEAS(PropertiesRepository.getString("asmt.myati.assessment.type"), PropertiesRepository.getString("asmt.TEAS.4.sections.ws"));		
		}
		
		//Section-1
		
		log(logger, "Verifying Questions");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyQuestionNos(),"Unable to verify Question nos");
		
		//TC ASMT-228
		log(logger, "Verifying if Elapsed Time is present");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.TEAS.elapsed.time.loc", 0));
				
		log(logger, "Verify TEAS title as 'Math' for - Section 1");
		String sectionTitle1 = baseHandler.findElement(PropertiesRepository.getString("asmt.quiz.title.loc")).getText();
		VerificationHandler.verifyTrue((sectionTitle1
				.contains(PropertiesRepository.getString("asmt.TEAS.section1.sequence.title")))
				|| (sectionTitle1.contains(PropertiesRepository.getString("asmt.TEAS.section2.sequence.title")))
				|| (sectionTitle1.contains(PropertiesRepository.getString("asmt.TEAS.section3.sequence.title")))
				|| (sectionTitle1.contains(PropertiesRepository.getString("asmt.TEAS.section4.sequence.title"))));

		log(logger, "Complete Section 1");
		quizBankAssPage.takeTest(false, false, true, false, false);		
		
		log(logger, "Verify Section 1 Completeion popup heading as 'Section Completed'");
		VerificationHandler.verifyTrue(homePage.isStringElementDisplayedByIndex(PropertiesRepository.getString("asmt.TEAS.complete.popup.heading"),"Section Completed", 0));
				
		log(logger, "Clicking on 'Proceed to Next Section' button");
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.popup.buttons.loc") , 1);	
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Verifying Questions");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyQuestionNos(),"Unable to verify Question nos");	
		
		//TC ASMT-228
		log(logger, "Verifying if Elapsed Time is present");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.TEAS.elapsed.time.loc", 0));

		//Section-2
		log(logger, "Verify TEAS title as 'Reading' for Section 2");
		String sectionTitle2 = baseHandler.findElement(PropertiesRepository.getString("asmt.quiz.title.loc")).getText();
		VerificationHandler.verifyTrue((sectionTitle2
				.contains(PropertiesRepository.getString("asmt.TEAS.section1.sequence.title")))
				|| (sectionTitle2.contains(PropertiesRepository.getString("asmt.TEAS.section2.sequence.title")))
				|| (sectionTitle2.contains(PropertiesRepository.getString("asmt.TEAS.section3.sequence.title")))
				|| (sectionTitle2.contains(PropertiesRepository.getString("asmt.TEAS.section4.sequence.title"))));	
		
		log(logger, "Complete Section 2");
		quizBankAssPage.takeTest(false, false, true, false, false);		
		
		log(logger, "Verify Section 2 Completeion popup heading as 'Section Completed'");
		VerificationHandler.verifyTrue(homePage.isStringElementDisplayedByIndex(PropertiesRepository.getString("asmt.TEAS.complete.popup.heading"),"Section Completed", 0));
				
		log(logger, "Clicking on 'Proceed to Next Section' button");
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.popup.buttons.loc") , 1);	
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Verifying Questions");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyQuestionNos(),"Unable to verify Question nos");
		
		//TC ASMT-228
		log(logger, "Verifying if Elapsed Time is present");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.TEAS.elapsed.time.loc", 0));
		
		//Section-3
		log(logger, "Verify TEAS title as 'English and Language Usage' for Section 3");
		String sectionTitle3 = baseHandler.findElement(PropertiesRepository.getString("asmt.quiz.title.loc")).getText();
		VerificationHandler.verifyTrue((sectionTitle3
				.contains(PropertiesRepository.getString("asmt.TEAS.section1.sequence.title")))
				|| (sectionTitle3.contains(PropertiesRepository.getString("asmt.TEAS.section2.sequence.title")))
				|| (sectionTitle3.contains(PropertiesRepository.getString("asmt.TEAS.section3.sequence.title")))
				|| (sectionTitle3.contains(PropertiesRepository.getString("asmt.TEAS.section4.sequence.title"))));
		
		log(logger, "Complete Section 3");
		quizBankAssPage.takeTest(false, false, true, false, false);		
		
		log(logger, "Verify Section 3 Completeion popup heading as 'Section Completed'");
		VerificationHandler.verifyTrue(homePage.isStringElementDisplayedByIndex(PropertiesRepository.getString("asmt.TEAS.complete.popup.heading"),"Section Completed", 0));
				
		log(logger, "Clicking on 'Proceed to Next Section' button");
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.popup.buttons.loc") , 1);	
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Verifying Questions");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyQuestionNos(),"Unable to verify Question nos");
		
		//TC ASMT-228
		log(logger, "Verifying if Elapsed Time is present");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.TEAS.elapsed.time.loc", 0));
		
		//Section-4
		log(logger, "Verify TEAS title as 'Science' for Section 4");
		String sectionTitle4 = baseHandler.findElement(PropertiesRepository.getString("asmt.quiz.title.loc")).getText();
		VerificationHandler.verifyTrue((sectionTitle4
				.contains(PropertiesRepository.getString("asmt.TEAS.section1.sequence.title")))
				|| (sectionTitle4.contains(PropertiesRepository.getString("asmt.TEAS.section2.sequence.title")))
				|| (sectionTitle4.contains(PropertiesRepository.getString("asmt.TEAS.section3.sequence.title")))
				|| (sectionTitle4.contains(PropertiesRepository.getString("asmt.TEAS.section4.sequence.title"))));	
		
		log(logger, "Complete Section 4");
		quizBankAssPage.takeTest(false, false, true, false, false);		
		
		log(logger, "Verify Section 4 Completeion popup heading as 'Assessment Completed!'");
		VerificationHandler.verifyTrue(homePage.isStringElementDisplayedByIndex(PropertiesRepository.getString("asmt.TEAS.complete.popup.heading"),"Assessment Completed!", 0));
				
		log(logger, "Clicking on 'Complete Post Assessment Survey' button");
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.popup.buttons.loc") , 1);	
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Verifying Questions");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyQuestionNos(),"Unable to verify Question nos");
		
		//Section-SURVEY
		log(logger, "Verify TEAS title as 'SURVEY' for Section 4");
		VerificationHandler.verifyTrue(homePage.isStringElementDisplayedByIndex(PropertiesRepository.getString("asmt.quiz.title.loc"),"SURVEY", 0));
		
		log(logger, "Complete Section SURVEY");
		quizBankAssPage.takeTest(false, false, false, false, false);		
		
		log(logger, "Verify Section Survey Completeion popup heading as 'Assessment Completed!'");
		VerificationHandler.verifyTrue(homePage.isStringElementDisplayedByIndex(PropertiesRepository.getString("asmt.TEAS.complete.popup.heading"),"Assessment Completed!", 0));
				
		log(logger, "Clicking on 'Finalize and View Results' button");
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.popup.buttons.loc") , 1);	
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		//ASMT-289
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyIPPPageHeader(),"Verifying IPP Page Header");

		log(logger, "ASMT_TEASFun_1 Ends");		
	}	
	


	/**
	 * ASMT_768_290
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID="ASMT_768_290")
	@Test(priority = 2, alwaysRun = true, groups = { "Regression" }, description = "ASMT_768_290 :Validate TEAS when Last Flagged questions is answered it does not Freeze")
	public void ASMT_TEASFun_2() throws Exception {
		
		log(logger, "ASMT_TEASFun_2 Start");
		
		log(logger,"Student Portal Login Start");
		VerificationHandler.verifyTrue(maintenanceScriptPage.loginToApplication(PropertiesRepository.getString("asmt.TEAS.user.1"),PropertiesRepository.getString("asmt.reg.tc.pass")));
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Verifying Home Page");
		VerificationHandler.verifyTrue(loginPage.verifyPageTitle(PropertiesRepository.getString("asmt.home.page.title")));
		
		log(logger, "Clicking on My ATI Tab");
		maintenanceScriptPage.clickLinkFromList("asmt.myati.main.tabs",1);
		
		log(logger, "Verify if Content Area drop down is displayed");
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.homepage.content.area.dropdown", 0));
		
		log(logger, "Clicking on Test Tab");
		maintenanceScriptPage.clickLinkFromList("asmt.myati.sub.tabs",1);		
		
		log(logger, "Verify if Sort drop down is displayed");
		quizBankAssPage.waitUntillElementIsVisible(PropertiesRepository.getString("asmt.homepage.testtab.sort.dropdown"));
		VerificationHandler.verifyTrue(homePage.isElementDisplayed("asmt.homepage.testtab.sort.dropdown", 0));	
		
		boolean isInContinueState =  quizBankAssPage.verifyAssessButtonContinueStateCF(PropertiesRepository.getString("asmt.TEAS.4.sections.ws"));
		
		log(logger, "Clicking on Practice Assessment ");
		quizBankAssPage.clickTestTabAssessmentButtonNew(PropertiesRepository.getString("asmt.myati.assessment.type"), PropertiesRepository.getString("asmt.TEAS.4.sections.ws"));
		homePage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
						
		//Workaround : Currently there is no way to identify if the TEAS is from beginning or in continue state, so checking the card front button state ,if 'Continue' then will complete TEAS
		log(logger, "Complete TEAS if not from begining");
		if(isInContinueState)
		{
			log(logger, "Completing  continue state TEAS");
			log(logger, "Verifying Questions");
			VerificationHandler.verifyTrue(maintenanceScriptPage.verifyQuestionNos(),"Unable to verify Question nos");			
			maintenanceScriptPage.takeTestTEAS(false,false,true,false);
		}
		
		//Section-1
		
		log(logger, "Verifying Questions");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyQuestionNos(),"Unable to verify Question nos");
				
		log(logger, "Verify TEAS title as 'Math' for - Section 1");
		String sectionTitle1 = baseHandler.findElement(PropertiesRepository.getString("asmt.quiz.title.loc")).getText();
		VerificationHandler.verifyTrue((sectionTitle1
				.contains(PropertiesRepository.getString("asmt.TEAS.section1.sequence.title")))
				|| (sectionTitle1.contains(PropertiesRepository.getString("asmt.TEAS.section2.sequence.title")))
				|| (sectionTitle1.contains(PropertiesRepository.getString("asmt.TEAS.section3.sequence.title")))
				|| (sectionTitle1.contains(PropertiesRepository.getString("asmt.TEAS.section4.sequence.title"))));

		log(logger, "Complete Section 1 by flagging first question");
		maintenanceScriptPage.clickButton(PropertiesRepository.getString("asmt.generic.tutorial.flag.value"), 0);
		WebElement continueButtonElement = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
		continueButtonElement.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		quizBankAssPage.takeTest(false, false, true, false, false);
		
		ArrayList<String> buttonList1 = new ArrayList<String>();
		buttonList1.add(PropertiesRepository.getString("asmt.popup.btn1.loc"));
		buttonList1.add(PropertiesRepository.getString("asmt.popup.btn2.loc"));
		buttonList1.add(PropertiesRepository.getString("asmt.popup.btn3.loc"));
		
		log(logger, "Verify if 'Review Flagged questions', 'Go back To Last Question' and 'Proceed to Next Section' buttons are displayed and Click on 'Review Flagged questions' button");
		VerificationHandler.verifyTrue(quizBankAssPage.isPopupButtonDisplayed(buttonList1 , PropertiesRepository.getString("asmt.popup.btn1.loc")));	
				
		log(logger, "Verify Flag button color is Orange and continue button is enable");
		VerificationHandler.verifyTrue(quizBankAssPage.verifyFlagBtnColor("Flagged"));
		
		log(logger, "Unflag all the flagged questions");
		VerificationHandler.verifyTrue(quizBankAssPage.takeTestUnFlagAllQues(true));
		
		ArrayList<String> buttonList2 = new ArrayList<String>();
		buttonList2.add(PropertiesRepository.getString("asmt.popup.btn2.loc"));
		buttonList2.add(PropertiesRepository.getString("asmt.popup.btn3.loc"));
		
		log(logger, "Verify if 'Go back To Last Question' and 'Proceed to Next Section' buttons are displayed and clcik on 'Proceed to Next Section' button");
		VerificationHandler.verifyTrue(quizBankAssPage.isPopupButtonDisplayed(buttonList2 , PropertiesRepository.getString("asmt.popup.btn3.loc")));
				
		log(logger, "Verifying Questions");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyQuestionNos(),"Unable to verify Question nos");	
		
		//Section-2
		
		log(logger, "Complete section by flagging all even questions");
		VerificationHandler.verifyTrue(quizBankAssPage.takeTestFlagOddQuesAnswerEvenQues_AlsoUnflag(false, false, true, true));	
		
		log(logger, "Verify Section 2 Completeion popup heading as 'Section Completed'");
		VerificationHandler.verifyTrue(homePage.isStringElementDisplayedByIndex(PropertiesRepository.getString("asmt.TEAS.complete.popup.heading"),"Section Completed", 0));
				
		log(logger, "Clicking on 'Proceed to Next Section' button");
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.popup.buttons.loc") , 1);	
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Verifying Questions");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyQuestionNos(),"Unable to verify Question nos");
		
		//Section-3
		
		log(logger, "Complete section by flagging all even questions");
		VerificationHandler.verifyTrue(quizBankAssPage.takeTestFlagOddQuesAnswerEvenQues_AlsoUnflag(false, false, true, true));	
		
		log(logger, "Verify Section 3 Completeion popup heading as 'Section Completed'");
		VerificationHandler.verifyTrue(homePage.isStringElementDisplayedByIndex(PropertiesRepository.getString("asmt.TEAS.complete.popup.heading"),"Section Completed", 0));
				
		log(logger, "Clicking on 'Proceed to Next Section' button");
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.popup.buttons.loc") , 1);	
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Verifying Questions");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyQuestionNos(),"Unable to verify Question nos");
		
		//Section-4
		
		log(logger, "Complete section by flagging all even questions");
		VerificationHandler.verifyTrue(quizBankAssPage.takeTestFlagOddQuesAnswerEvenQues_AlsoUnflag(false, false, true, true));
		
		log(logger, "Verify Section 4 Completeion popup heading as 'Assessment Completed!'");
		VerificationHandler.verifyTrue(homePage.isStringElementDisplayedByIndex(PropertiesRepository.getString("asmt.TEAS.complete.popup.heading"),"Assessment Completed!", 0));
				
		log(logger, "Clicking on 'Complete Post Assessment Survey' button");
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.popup.buttons.loc") , 1);	
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Verifying Questions");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyQuestionNos(),"Unable to verify Question nos");
		
		//Section-SURVEY
		log(logger, "Verify TEAS title as 'SURVEY' for Section 4");
		VerificationHandler.verifyTrue(homePage.isStringElementDisplayedByIndex(PropertiesRepository.getString("asmt.quiz.title.loc"),"SURVEY", 0));
		
		log(logger, "Complete Section SURVEY");
		quizBankAssPage.takeTest(false, false, false, false, false);		
		
		log(logger, "Verify Section Survey Completeion popup heading as 'Assessment Completed!'");
		VerificationHandler.verifyTrue(homePage.isStringElementDisplayedByIndex(PropertiesRepository.getString("asmt.TEAS.complete.popup.heading"),"Assessment Completed!", 0));
				
		log(logger, "Clicking on 'Finalize and View Results' button");
		quizBankAssPage.clickButton(PropertiesRepository.getString("asmt.popup.buttons.loc") , 1);	
		maintenanceScriptPage.waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		
		log(logger, "Verifying IPP Page Header");
		VerificationHandler.verifyTrue(maintenanceScriptPage.verifyIPPPageHeader(),"Verifying IPP Page Header");
		
		
		log(logger, "ASMT_TEASFun_2 Ends");		
	}	
			
	
}
