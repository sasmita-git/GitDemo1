package com.automation.newati.myati.others;

import java.util.Calendar;
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
import com.automation.newati.pages.ImproveTabPage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyATITabMainPage;
import com.automation.newati.pages.TestTabPage;
import com.automation.newati.pages.TutorialPage;

public class SortFilters extends BaseTest {

Logger logger = LogManager.getLogger(this.getClass());
	
	private LoginPage loginPage = null;
	private HomePage homePage = null;
	private MyATITabMainPage myATIPage = null;
	private ImproveTabPage improveTab = null;
	private ApplyTabPage applyTabPage = null;
	private TestTabPage testTabPage;
	private TutorialPage tutorialPage;
	
	@BeforeMethod
	public void verifyHomePage() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		myATIPage = new MyATITabMainPage(driver);
		improveTab = new ImproveTabPage(driver);
		applyTabPage = new ApplyTabPage(driver);
		testTabPage = new TestTabPage(driver);
		tutorialPage=new TutorialPage(driver);
		
		
	}
	
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = {"Smoke"}, description ="NewATI-109:Type and Sort filters")
	public void NewATI109_LearnTabSortFilters() throws Exception {
		log(logger, "NewATI109_LearnTabSortFilters Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.pulse.user.name"), PropertiesRepository.getString("newati.login.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Click on MyATI Tab
		log(logger, "Clicking on My ATI Tab");
		
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		// Verifying Flash Card
		log(logger, "Selecting Flash Card from Learn Tab");
		tutorialPage.selectTutorialFromDropDown(PropertiesRepository
				.getString("new-atitesting.flashCardDropdown.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyTrue(myATIPage.verifyAssessmentTitle("Flashcards"), "Unable to verify FlashCard");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATIPage.clickLearnTabAllDD();
		log(logger, "Clicking in Flash Card and Verifying only Flash Card displayed");
		
		// Verifying Quiz Bank
//		myATIPage.selectAssessmentFromLearnTabDropDown("Quiz Bank");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
//		VerificationHandler.verifyTrue(myATIPage.verifyAssessmentTitle("Quiz Bank"), "Unable to verify Quiz Bank");
//		myATIPage.clickLearnTabAllDD();
//		log(logger, "Clicking in Quiz Bank and Verifying only Quiz Bank displayed");
//		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		// Verifying Tutorial
		myATIPage.selectAssessmentFromLearnTabDropDown("Tutorial");
		VerificationHandler.verifyTrue(myATIPage.verifyAssessmentTitle("Tutorial"), "Unable to verify Tutorial");
		myATIPage.clickLearnTabAllDD();
		log(logger, "Clicking in Tutorial and Verifying only Tutorial displayed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Verifying eBook
		myATIPage.selectAssessmentFromLearnTabDropDown("eBook");
		VerificationHandler.verifyTrue(myATIPage.verifyAssessmentTitle("eBook"), "Unable to verify EBook");
		myATIPage.clickLearnTabAllDD();
		log(logger, "Clicking in eBook and Verifying only eBook displayed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		myATIPage.sortAllAssessmentDescription();
		log(logger, "Sort Description");
		
		// Verifying Flash Card
		myATIPage.selectAssessmentFromLearnTabDropDown("Flashcards");
		myATIPage.verifyAssessmentTitle("Flashcards");
		//myATIPage.clickLearnTabAllDD();
		log(logger, "Clicking in Flash Card again and Verifying only Flash Card displayed");
		
		log(logger, "Clicking on Test Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking on Learn Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		VerificationHandler.verifyTrue(myATIPage.getLearnTabTypeSelectedOption("Flashcards"), "Unable to verify already selected in Learn Tab");
		log(logger, "Verifying Flash card is dispalyed");
		
		log(logger, "NewATI109_LearnTabSortFilters End");
	}
	
	@Test(priority=3,alwaysRun = true, enabled = true,groups = {"Smoke"}, description="NewATI-8:View, Sort and Type filters")
	public void NewATI8_VerifyTestTabSorting() throws Exception {
		log(logger, "NewATI8_VerifyTestTabSorting Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name"), PropertiesRepository.getString("newati.login.user.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Test Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying all options in View dropdown");
		VerificationHandler.verifyTrue(testTabPage.verifyTestTabValueDD(),"Value DD in Test Tab are not matched");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying all options in Sort dropdown");
		VerificationHandler.verifyTrue(testTabPage.verifyTestTabSortDD(),"Sort DD in Test Tab are not matched");
				
		// Test Link Step 6 Start
		log(logger, "Selecting Name from Sort dropdown");
		testTabPage.selectValueFromSortDDinTestTab(PropertiesRepository.getString("new-atitesting.myatitab.testtab.Sort.dd.2.Sort"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		List<String> allAssessmentName = testTabPage.valueAsList(PropertiesRepository.getString("new-atitesting.myatitab.testtab.all.assessment.name"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying all assessments are sorted in ascending order");
		VerificationHandler.verifyTrue(testTabPage.verifyListSortedOrNot(true, allAssessmentName), "Assessment Name is not in Ascending Order");
		// Test Link Step 6 End
		
		// Test Link Step 7 Start
		log(logger, "Selecting Accessed from View dropdown");
		testTabPage.selectValueFromValueDDinTestTab(PropertiesRepository.getString("new-atitesting.myatitab.testtab.value.dd.2.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		List<String> accessedAssessmentName = testTabPage.valueAsList(PropertiesRepository.getString("new-atitesting.myatitab.testtab.all.assessment.name"));
		
		log(logger, "Verifying all assessments are sorted in ascending order");
		VerificationHandler.verifyTrue(testTabPage.verifyListSortedOrNot(true, accessedAssessmentName), "Assessment Name is not in Ascending Order");
		log(logger, "Verifying only accessed assessments are visible");
		VerificationHandler.verifyFalse(testTabPage.isNotAccessedAssessmentDisplayedinTestTab(), "Not Accessed Assessments are displayed in Test Tab");
		VerificationHandler.verifyTrue(testTabPage.isAccessedAssessmentDisplayedinTestTab(), "Accessed Assessments are not displayed in Test Tab");
		// Test Link Step 7 End
		
		// Test Link Step 8 Start 
		log(logger, "Selecting Date Accessed value from SortDD");
		testTabPage.selectValueFromSortDDinTestTab(PropertiesRepository.getString("new-atitesting.myatitab.testtab.Sort.dd.1.Sort"));		
		
		log(logger, "Selecting Accessed value from ValueDD");
		testTabPage.selectValueFromValueDDinTestTab(PropertiesRepository.getString("new-atitesting.myatitab.testtab.value.dd.2.value"));
				
		List<Calendar> allDateCompareList = testTabPage.dateValueAsList(PropertiesRepository.getString("new-atitesting.test.tab.accessed.date"));
		
		log(logger, "Verifying all assessments are sorted in ascending order");
		VerificationHandler.verifyTrue(testTabPage.isDateSortedInAscendingOrder(allDateCompareList), "Assessment Date is not in Ascending Order");
		log(logger, "Verifying only accessed assessments are visible");
		VerificationHandler.verifyTrue(testTabPage.isAccessedAssessmentDisplayedinTestTab(), "Accessed Assessments are not displayed in Test Tab");
		VerificationHandler.verifyFalse(testTabPage.isNotAccessedAssessmentDisplayedinTestTab(), "Not Accessed Assessments are displayed in Test Tab");
		
		// Test Link Step 8 End

		// Test Link Step 9 Start  - Skipping this as Due date functionality is not clear, not able to find out which is due date
/*		log(logger, "Selecting All value from ViewDD");
		testTabPage.selectValueFromValueDDinTestTab(PropertiesRepository.getString("new-atitesting.myatitab.testtab.value.dd.1.value"));
			
		log(logger, "Selecting Due Date value from SortDD");
		testTabPage.selectValueFromSortDDinTestTab(PropertiesRepository.getString("new-atitesting.myatitab.testtab.Sort.dd.3.Sort"));
			
		List<Calendar> allDateList = testTabPage.dateValueAsList(PropertiesRepository.getString("new-atitesting.test.tab.accessed.date"));
		
		VerificationHandler.verifyTrue(testTabPage.isDateSortedInAscendingOrder(allDateList), "Assessment Date is not in Ascending Order");*/
		// Step 9 End
		
		// Test Link Step 10 Start 
		log(logger, "Selecting Not Accessed value from ViewDD");
		testTabPage.selectValueFromValueDDinTestTab(PropertiesRepository.getString("new-atitesting.myatitab.testtab.value.dd.3.value"));

		log(logger, "Selecting Date Accessed value from SortDD");
		testTabPage.selectValueFromSortDDinTestTab(PropertiesRepository.getString("new-atitesting.myatitab.testtab.Sort.dd.1.Sort"));
		
		log(logger, "Verifying never accessed assessments are displayed and not accessed assessments not displayed");
		VerificationHandler.verifyTrue(testTabPage.isNotAccessedAssessmentDisplayedinTestTab(), "Not Accessed Assessments are displayed in Test Tab");
		VerificationHandler.verifyFalse(testTabPage.isAccessedAssessmentDisplayedinTestTab(), "Accessed Assessments are not displayed in Test Tab");
		// Step 10 End		
		
		// Step 12
		log(logger, "Verifying all options in Type dropdown");
		VerificationHandler.verifyFalse(testTabPage.verifyTestTabTypeDD(),"Type DD in Test Tab are not matched");
		
		// Step 13 Start
		log(logger, "Selecting All value from Type dropdown");
		testTabPage.selectValueFromTypeDDinTestTab(PropertiesRepository.getString("new-atitesting.myatitab.testtab.type.dd.1.value"));
		
		log(logger, "Verifying Practice and Proctored assessments are displayed");
		VerificationHandler.verifyTrue(testTabPage.verifyAssessmentTypeName(), "Practice and proctored assessments are not displayed");
		// Step 13 End		
		
		// Step 14 Start
		log(logger, "Selecting Practice value from TypeDD");
		testTabPage.selectValueFromTypeDDinTestTab(PropertiesRepository.getString("new-atitesting.myatitab.testtab.type.dd.2.value"));
		
		log(logger, "Verifying Assessment Type Name as Practice");		
		VerificationHandler.verifyTrue(testTabPage.verifyAssessmentTypeName(PropertiesRepository.getString("new-atitesting.myatitab.testtab.type.practice.assessment.title.value"),PropertiesRepository.getString("new-atitesting.myatitab.testtab.type.practice.assessment.value")),
				"Practice assessment name is not displayed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyFalse(testTabPage.verifyAssessmentTypeName(PropertiesRepository.getString("new-atitesting.myatitab.testtab.type.proctored.assessment.title.value"),PropertiesRepository.getString("new-atitesting.myatitab.testtab.type.proctored.assessment.value")),
				"Proctored assessment is displayed");
		// Step 14 End
		
		// Step 15 Start
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Selecting Proctored value from TypeDD");
		testTabPage.selectValueFromTypeDDinTestTab(PropertiesRepository.getString("new-atitesting.myatitab.testtab.type.dd.3.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying Assessment Type Name as Proctored");	

		VerificationHandler.verifyTrue(testTabPage.verifyAssessmentTypeName(PropertiesRepository.getString("new-atitesting.myatitab.testtab.type.proctored.assessment.title.value"),PropertiesRepository.getString("new-atitesting.myatitab.testtab.type.proctored.assessment.value")),
				"Proctored assessment is not displayed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyFalse(testTabPage.verifyAssessmentTypeName(PropertiesRepository.getString("new-atitesting.myatitab.testtab.type.practice.assessment.title.value"),PropertiesRepository.getString("new-atitesting.myatitab.testtab.type.practice.assessment.value")),
				"Practice assessment name is displayed");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 15 End

		// Step 16 Start
		// Click on Learn Tab
		log(logger, "Clicking on Learn Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Start 16 End
		
		// Step 17 Start
		// Click on Test Tab
		log(logger, "Clicking on Test Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Verifying selected filters");
		VerificationHandler.verifyTrue(myATIPage.getLearnTabTypeSelectedOption(PropertiesRepository.getString("new-atitesting.myatitab.testtab.dd.loc"),1,PropertiesRepository.getString("new-atitesting.myatitab.testtab.type.dd.3.value")), "Test Tab Selected is verified after coming from learn tab");
		// Step 17 End
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 18 Start
		log(logger,"click on signout button");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.signout.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyTrue(tutorialPage.isElementDisplayed("new-atitesting.forgot.password.link"));
		
		loginPage.loginToApplicationwithoutDeletingCookies(PropertiesRepository.getString("newati.login.user.name"), PropertiesRepository.getString("newati.login.user.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Test Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Verifying selected filters");
		VerificationHandler.verifyTrue(myATIPage.getLearnTabTypeSelectedOption(PropertiesRepository.getString("new-atitesting.myatitab.testtab.dd.loc"),1,PropertiesRepository.getString("new-atitesting.myatitab.testtab.type.dd.3.value")), "Test Tab Selected is verified after coming from learn tab");
		// Step 18 End
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "NewATI8_VerifyTestTabSorting End");
		}

	
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {"Smoke"}, description="NewATI-98:Apply Tab - View and Sort")
	public void NewATI98_VerifyApplyTabSortOption() throws Exception {
		log(logger, "NewATI98_VerifyApplyTabSortOption Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name"), PropertiesRepository.getString("newati.login.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Click on MyATI Tab
		// Step 2 Start
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		// Click on Improve Tab
		log(logger, "Clicking on Improve Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 3);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 3 Start
		VerificationHandler.verifyTrue(applyTabPage.verifyApplyTabValueDD(),"Veifiying Apply tab value DD values");
		log(logger, "Verifying Value DD value in Apply Tab");
		// Step 3 End
		
		// Step 4 Start
		VerificationHandler.verifyTrue(applyTabPage.verifyApplyTabSortDD(),"Veifiying Apply tab Sort DD values");
		log(logger, "Verifying Sort DD value in Apply Tab");
		// Step 4 End		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 5 Start 
		applyTabPage.selectValueFromValueDDinApplyTab(PropertiesRepository.getString("new-atitesting.myatitab.testtab.value.dd.1.value"));
		log(logger, " Apply Tab View DD All Option");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		applyTabPage.selectValueFromSortDDinApplyTab(PropertiesRepository.getString("new-atitesting.myatitab.testtab.Sort.dd.1.Sort"));
		log(logger, "Apply Tab Sort DD Date Accessed option");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		List<Calendar> allDateList = applyTabPage.dateValueAsList(PropertiesRepository.getString("new-atitesting.myatitab.testtab.type.simulation.date.value"));
		
		improveTab.isDateSortedInAscendingOrder(allDateList);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 5 End		

		// Step 6 Start
		applyTabPage.selectValueFromValueDDinApplyTab(PropertiesRepository.getString("new-atitesting.myatitab.testtab.value.dd.1.value"));
		log(logger, " Apply Tab View DD All Option");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		applyTabPage.selectValueFromSortDDinApplyTab(PropertiesRepository.getString("new-atitesting.myatitab.testtab.Sort.dd.2.Sort"));
		log(logger, "Apply Tab Sort DD Name option");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		List<String> allNameList = improveTab.valueAsList(PropertiesRepository.getString("new-atitesting.myatitab.applytab.all.assessment.name"));
		
		//VerificationHandler.verifyTrue(improveTab.verifyListSortedOrNot(true, allNameList), "Assessment Name is not in Ascending Order");
		
		// Step 6 End
		
		// Step 7 Start - 
		applyTabPage.selectValueFromValueDDinApplyTab(PropertiesRepository.getString("new-atitesting.myatitab.testtab.value.dd.1.value"));
		log(logger, " Apply Tab View DD Accessed Option");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		applyTabPage.selectValueFromSortDDinApplyTab(PropertiesRepository.getString("new-atitesting.myatitab.testtab.Sort.dd.1.Sort"));
		log(logger, "Apply Tab Sort DD Date Accessed option");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		List<Calendar> allDateCompareList = applyTabPage.dateValueAsList(PropertiesRepository.getString("new-atitesting.myatitab.testtab.type.simulation.date.value"));
		
		improveTab.isDateSortedInAscendingOrder(allDateCompareList);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 7 End	
		
		// Step 8 Start
		applyTabPage.selectValueFromValueDDinApplyTab(PropertiesRepository.getString("new-atitesting.myatitab.testtab.value.dd.2.value"));
		log(logger, " Apply Tab View DD Accessed Option");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		applyTabPage.selectValueFromSortDDinApplyTab(PropertiesRepository.getString("new-atitesting.myatitab.testtab.Sort.dd.2.Sort"));
		log(logger, "Apply Tab Sort DD Name option");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		List<String> allAssessmentName = improveTab.valueAsList(PropertiesRepository.getString("new-atitesting.myatitab.applytab.all.assessment.name"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyFalse(improveTab.verifyListSortedOrNot(true, allAssessmentName), "Assessment Name is not in Ascending Order");
		// Step 8 End	
		
		// Step 9 Start 
		applyTabPage.selectValueFromValueDDinApplyTab(PropertiesRepository.getString("new-atitesting.myatitab.testtab.value.dd.3.value"));
		log(logger, " Apply Tab View DD Not Accessed Option");
		
		applyTabPage.selectValueFromSortDDinApplyTab(PropertiesRepository.getString("new-atitesting.myatitab.testtab.Sort.dd.1.Sort"));
		log(logger, "Apply Tab Sort DD Date Accessed option");
		
		List<Calendar> allDateCompare = applyTabPage.dateValueAsList(PropertiesRepository.getString("new-atitesting.myatitab.testtab.type.simulation.date.value"));
		
		improveTab.isDateSortedInAscendingOrder(allDateCompare);
	
		// Step 9 End	
		
		// Step 10 Start
		applyTabPage.selectValueFromValueDDinApplyTab(PropertiesRepository.getString("new-atitesting.myatitab.testtab.value.dd.3.value"));
		log(logger, " Apply Tab View DD Not Accessed Option");
		
		applyTabPage.selectValueFromSortDDinApplyTab(PropertiesRepository.getString("new-atitesting.myatitab.testtab.Sort.dd.2.Sort"));
		log(logger, "Apply Tab Sort DD Name option");
		
		List<String> allAssessmentNameList = improveTab.valueAsList(PropertiesRepository.getString("new-atitesting.myatitab.applytab.all.assessment.name"));
		
		//VerificationHandler.verifyTrue(improveTab.verifyListSortedOrNot(true, allAssessmentNameList), "Assessment Name is not in Ascending Order");
		
		// Step 10 End	
		
		// Click on Learn Tab
		log(logger, "Clicking on Learn Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.waitForAwhile(5000);
		// Click on Improve Tab
		log(logger, "Clicking on Apply Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 3);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.waitForAwhile(5000);
		VerificationHandler.verifyTrue(improveTab.getLearnTabTypeSelectedOption(PropertiesRepository.getString("new-atitesting.myatitab.applytab.dd.loc"),1,PropertiesRepository.getString("new-atitesting.myatitab.testtab.Sort.dd.2.Sort")), "Apply Tab Selected is verified after coming from learn tab");
		// Step 11 End	
		log(logger, "NewATI98_VerifyApplyTabSortOption End");
	}
	
//	@Test(priority=3, description="NewATI-8:View, Sort and Type filters")
	/*public void NewATI8_VerifyTestTabSorting() throws Exception {
		log(logger, "NewATI8_VerifyTestTabSorting Start");
		
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Test Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		VerificationHandler.verifyTrue(testTabPage.verifyTestTabValueDD(),"Value DD in Test Tab are not matched");
		log(logger, "Unable to verify Value DD Value in Test Tab");
		
		VerificationHandler.verifyTrue(testTabPage.verifyTestTabSortDD(),"Sort DD in Test Tab are not matched");
		log(logger, "Unable to verify Sort DD Value in Test Tab");
		
		// Test Link Step 6 Start
		testTabPage.selectValueFromSortDDinTestTab(PropertiesRepository.getString("new-atitesting.myatitab.testtab.Sort.dd.2.Sort"));
		log(logger, "Selecting NAME value from SortDD");
		
		List<String> allAssessmentName = testTabPage.valueAsList(PropertiesRepository.getString("new-atitesting.myatitab.testtab.all.assessment.name"));
		
		VerificationHandler.verifyTrue(testTabPage.verifyListSortedOrNot(true, allAssessmentName), "Assessment Name is not in Ascending Order");
		// Test Link Step 6 End
		
		// Test Link Step 7 Start
		testTabPage.selectValueFromValueDDinTestTab(PropertiesRepository.getString("new-atitesting.myatitab.testtab.value.dd.2.value"));
		log(logger, "Selecting ACCESSED value from ValueDD");
		
		List<String> accessedAssessmentName = testTabPage.valueAsList(PropertiesRepository.getString("new-atitesting.myatitab.testtab.all.assessment.name"));
		
		VerificationHandler.verifyTrue(testTabPage.verifyListSortedOrNot(true, accessedAssessmentName), "Assessment Name is not in Ascending Order");
		// Test Link Step 7 End
		
		// Test Link Step 8 Start 
		testTabPage.selectValueFromSortDDinTestTab(PropertiesRepository.getString("new-atitesting.myatitab.testtab.Sort.dd.1.Sort"));
		log(logger, "Selecting Date Accessed value from SortDD");
		
		testTabPage.selectValueFromValueDDinTestTab(PropertiesRepository.getString("new-atitesting.myatitab.testtab.value.dd.2.value"));
		log(logger, "Selecting Accessed value from ValueDD");
		
		List<Calendar> allDateCompareList = testTabPage.dateValueAsList(PropertiesRepository.getString("new-atitesting.myatitab.testtab.type.date.loc"));
		
		//VerificationHandler.verifyTrue(testTabPage.isDateSortedInAscendingOrder(allDateCompareList), "Assessment Date is not in Ascending Order");
		
		// Test Link Step 8 End

		// Test Link Step 9 Start 
		testTabPage.selectValueFromValueDDinTestTab(PropertiesRepository.getString("new-atitesting.myatitab.testtab.value.dd.1.value"));
		log(logger, "Selecting All value from ViewDD");
		
		testTabPage.selectValueFromSortDDinTestTab(PropertiesRepository.getString("new-atitesting.myatitab.testtab.Sort.dd.3.Sort"));
		log(logger, "Selecting Due Date value from SortDD");
		
		List<Calendar> allDateList = testTabPage.dateValueAsList(PropertiesRepository.getString("new-atitesting.myatitab.testtab.type.date.loc"));
		
		//VerificationHandler.verifyTrue(testTabPage.isDateSortedInAscendingOrder(allDateList), "Assessment Date is not in Ascending Order");
		// Step 9 End
		
		// Test Link Step 10 Start 
		testTabPage.selectValueFromValueDDinTestTab(PropertiesRepository.getString("new-atitesting.myatitab.testtab.value.dd.1.value"));
		log(logger, "Selecting All value from ViewDD");
		
		testTabPage.selectValueFromSortDDinTestTab(PropertiesRepository.getString("new-atitesting.myatitab.testtab.Sort.dd.3.Sort"));
		log(logger, "Selecting Due Date value from SortDD");
		
		List<String> accessedAssessmentNameList = testTabPage.valueAsList(PropertiesRepository.getString("new-atitesting.myatitab.testtab.all.assessment.name"));
		
		VerificationHandler.verifyFalse(testTabPage.verifyListSortedOrNot(true, accessedAssessmentNameList), "Assessment Name is not in Ascending Order");
		// Step 10 End
		
		
		// Step 12
		VerificationHandler.verifyTrue(testTabPage.verifyTestTabTypeDD(),"Type DD in Test Tab are not matched");
		log(logger, "Unable to verify Type DD Value in Test Tab");
		
		// Step 13 Start
		
		testTabPage.selectValueFromValueDDinTestTab(PropertiesRepository.getString("new-atitesting.myatitab.testtab.value.dd.1.value"));
		log(logger, "Selecting ACCESSED value from ValueDD");
		
		testTabPage.selectValueFromSortDDinTestTab(PropertiesRepository.getString("new-atitesting.myatitab.testtab.Sort.dd.1.Sort"));
		log(logger, "Selecting NAME value from SortDD");
		
		testTabPage.verifyAssessmentTypeName();
		log(logger, "Verifying Assessment Type Name as Practice/ Proctored");
		// Step 13 End		
		
		// Step 14 Start
		testTabPage.selectValueFromTypeDDinTestTab(PropertiesRepository.getString("new-atitesting.myatitab.testtab.type.dd.2.value"));
		log(logger, "Selecting Practice value from TypeDD");
		
		testTabPage.verifyAssessmentTypeName(PropertiesRepository.getString("new-atitesting.myatitab.testtab.type.practice.assessment.title.value"),PropertiesRepository.getString("new-atitesting.myatitab.testtab.type.practice.assessment.value"));
		log(logger, "Verifying Assessment Type Name as Practice");
		// Step 14 End
		
		// Step 15 Start
		testTabPage.selectValueFromTypeDDinTestTab(PropertiesRepository.getString("new-atitesting.myatitab.testtab.type.dd.3.value"));
		log(logger, "Selecting Practice value from TypeDD");
		
		testTabPage.verifyAssessmentTypeName(PropertiesRepository.getString("new-atitesting.myatitab.testtab.type.proctored.assessment.title.value"),PropertiesRepository.getString("new-atitesting.myatitab.testtab.type.proctored.assessment.value"));
		log(logger, "Verifying Assessment Type Name as Practice");
		// Step 15 End

		// Step 16 Start
		// Click on Learn Tab
		log(logger, "Clicking on Learn Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Start 16 End
		
		// Step Start
		// Click on Test Tab
		log(logger, "Clicking on Test Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		VerificationHandler.verifyTrue(myATIPage.getLearnTabTypeSelectedOption(PropertiesRepository.getString("new-atitesting.myatitab.testtab.dd.loc"),1,PropertiesRepository.getString("new-atitesting.myatitab.testtab.type.dd.3.value")), "Test Tab Selected is verified after coming from learn tab");
		// Step End
		
		log(logger, "NewATI8_VerifyTestTabSorting End");
		
	}*/
}
