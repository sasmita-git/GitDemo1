package com.automation.newati.regression.learntab;

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
import com.automation.newati.pages.MyATITabMainPage;
import com.automation.newati.pages.ProctorChromePage;
import com.automation.newati.pages.TutorialPage;
import com.jaca.TestAnnotations;

public class LearnTabOthers extends BaseTest {

	Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private TutorialPage tutorialPage;
	private ProctorChromePage proctorChromePage;
	private MyATITabMainPage myATITabMainPage;
	private BaseHandler baseHandler;

	@BeforeMethod
	public void VerifyLearnTabScenariosReview() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		tutorialPage = new TutorialPage(driver);
		proctorChromePage = new ProctorChromePage(driver);
		myATITabMainPage = new MyATITabMainPage(driver);
	}

	@TestAnnotations(testID = "NewATI-151")
	@Test(priority = 1, alwaysRun = true, enabled = true, groups = { "Smoke",
			"Regression" }, description = "NewATI-151:Hide disabled products checkbox")
	public void NewATI151_VerifyLearnTabHideDisabledCheckbox() throws Exception {
		logger.info("NewATI151_VerifyLearnTabHideDisabledCheckbox Start");

		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name"),
				PropertiesRepository.getString("newati.login.password"));

		// Step 2 Start
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Click on Learn Tab
		log(logger, "Clicking on Learn Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.clickHideCheckboxInLearnTab();
		log(logger, "Unchecking on Hide Check box");

		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		VerificationHandler.verifyTrue(
				tutorialPage.verifyHideItemDisplayed(
						PropertiesRepository.getString("new-atitesting.myatitab.learntab.hide.assessemnt.loc")),
				"Hidden Assessment are not shown");
		log(logger, "Verifying Hidden items are shown");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.clickHideCheckbox(
				PropertiesRepository.getString("new-atitesting.myatitab.learntab.hide.check.box.loc"));
		log(logger, "Checking Hide check box");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyFalse(
				tutorialPage.verifyHideItemDisplayed(
						PropertiesRepository.getString("new-atitesting.myatitab.learntab.hide.assessemnt.loc")),
				"Non Hidden Assessment are shown");
		log(logger, "Verifying Assessment are shown");

		logger.info("NewATI151_VerifyHideDisabledCheckbox End");
	}

	@TestAnnotations(testID = "NewATI-519")
	@Test(priority = 2, alwaysRun = true, enabled = true, groups = { "Smoke",
			"Regression" }, description = "NewATI-519:Flashcards under Semester payment required class")
	public void NewATI519_VerifyFlashCardSemesterPayment() throws Exception {
		logger.info("NewATI519_VerifyFlashCardSemesterPayment Start");

		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.519.user.name"),
				PropertiesRepository.getString("newati.login.519.password"));

		// Step 2 Start
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);

		// Click on Learn Tab
		log(logger, "Clicking on Learn Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		// Sort Tutorial
		tutorialPage
				.selectTutorialFromDropDown(PropertiesRepository.getString("new-atitesting.flashCardDropdown.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		tutorialPage.clickHideCheckboxInLearnTab();
		log(logger, "Unchecking on Hide Check box");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// VerificationHandler.verifyTrue(tutorialPage.verifyFlashCardSemesterPaymentRequiredMsg(),
		// "Unable to verify Flash Card Semester Payment Required message");

		log(logger, "NewATI519_VerifyFlashCardSemesterPayment End");
	}

	@TestAnnotations(testID = "NewATI-113")
	@Test(priority = 3, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-113:STT Tutorials Lesson: Regression Test Case")
	public void NewATI113_VerifySTTTutorialLesson() throws Exception {
		logger.info("NewATI113_VerifySTTTutorialLesson Start");
		
		//Step-1
		loginPage.loginToApplication("stagesingleinstance","Test123");
				
		//Step-2
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsAppeared("new-atitesting.peasewait.bufferLoc");
				
		log(logger, "Clicking on Learn Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 0);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				
		log(logger, "Selecting Tutorial from Learn Tab drop down");
		tutorialPage.selectTutorialFromDropDown(PropertiesRepository.getString("new-atitesting.tutorialDropdown.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				
		//Step-3
		log(logger, "Clicking Module by Name");
		tutorialPage.clickModuleButtonByName(PropertiesRepository.getString("new-atitesting.Demo.product.name"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				
		log(logger, "Verify Modules count and header section in card back");
		VerificationHandler.verifyTrue(tutorialPage.verifyCardBackHeaderSection(PropertiesRepository.getString("newati.card.back.title.loc"),
				PropertiesRepository.getString("new-atitesting.learntab.tutorial.153.assessment.name")), "unable to verify card back header section");
				
		log(logger, "Clicking Begin/Continue Lesson ");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.stt.lesson.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verifying STT lesson page ");
		VerificationHandler.verifyTrue(tutorialPage.verifySTTLessonPage(), "Unable to verify STT Lesson details");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Verifying STT_coursedropdown ");
		VerificationHandler.verifyTrue(tutorialPage.STT_Verifycoursedropdown(),
				"Unable to verify course dropdown values");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "select and Verify course content  ");
		VerificationHandler.verifyTrue(tutorialPage.STT_selectAndVerifyCoursecontent(),
				"Unable to verify course contents");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");	
		
		log(logger, "check pagination icons  ");
		VerificationHandler.verifyTrue(tutorialPage.STTLesson_CheckPaginationicon(),
				"Unable to verify pagination icons");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Click and verify reference tab");
		VerificationHandler.verifyTrue(tutorialPage.STTLesson_clickandVerifyReferenceTab(),
		"Unable to verify reference tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Click and verify meet the author tab");
		VerificationHandler.verifyTrue(tutorialPage.STTLesson_MeetTheAuthorTab(),
		"Unable to verify meet the author tab");

		log(logger, "Click and verify help tab");
		VerificationHandler.verifyTrue(tutorialPage.STTLesson_VerifyHelpTab(),
		"Unable to verify help tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		logger.info("NewATI113_VerifySTTTutorialLesson End");
	}	

	@TestAnnotations(testID = "NewATI-901")
	@Test(priority = 4, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = " NewATI-901:Verify that Quiz Bank tag under Learn tab.")
	public void NewATI901_VerifyQuizBankTagUnderLearnTab() throws Exception {
		logger.info("NewATI901_VerifyQuizBankTagUnderLearnTab Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.pulse.user702.name"),
				PropertiesRepository.getString("newati.login.user.password"));

		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);

		VerificationHandler.verifyTrue(tutorialPage.LearnTab_VerifyQuizbankTag(),
				"Unable to verify quiz bank under learn tab dropdown");

		logger.info("NewATI901_VerifyQuizBankTagUnderLearnTab End");
	}

	@TestAnnotations(testID = "NewATI-813")
	@Test(priority = 5, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-813:To verify VCS for the Pulse user")
	public void NewATI813_VerifyVCSPulseuser() throws Exception {
		logger.info("NewATI813_VerifyVCSPulseuser Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.pulse.user702.name"),
				PropertiesRepository.getString("newati.login.user.password"));

		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);

		log(logger, "Clicking on Apply Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 3);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking Module by Name");

		log(logger, "Click on Modules ");
		loginPage.clickLinkFromList(PropertiesRepository.getString("new-atitesting.myati.apply.tab.simulation.links"),
				PropertiesRepository.getInt("new-atitesting.myati.apply.tab.simulation.link.index.VCS"));

		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking Access case button ");
		loginPage.clickLinkFromList(PropertiesRepository.getString("new-atitesting.myati.apply.tab.simulation.modules"),
				PropertiesRepository.getInt("new-atitesting.myati.apply.tab.simulation.link.index"));
		VerificationHandler.verifyTrue(tutorialPage.Verify_VCSPage(), "Unable to verify Video case study page");

		log(logger, "Click on close button");
		loginPage.clickButton(PropertiesRepository.getString("new-atitesting.cardback.close.loc"));

		logger.info("NewATI813_VerifyVCSPulseuser End");
	}

	/**
	 * 
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-792")
	@Test(priority = 6, alwaysRun = true, enabled = true, groups = {
			"Regression" }, description = "NewATI-792:Verify student mimic account products.")
	public void NewATI792_VerifyStudentMimic() throws Exception {
		logger.info("NewATI792_VerifyStudentMimic Start");

		log(logger, "Login to application");
		proctorChromePage.loginToApplicationID(driver, PropertiesRepository.getString("id.login.faculty.username.792"),
				PropertiesRepository.getString("id.login.faculty.pass.792"));
		proctorChromePage.waitUntillLoadingImageIsDisappeared(driver,
				PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));

		log(logger, "Clicking on Left Navigation Link");
		proctorChromePage.verifyAndClick(driver,
				PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true);
		proctorChromePage.waitUntillLoadingImageIsDisappeared(driver,
				PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		proctorChromePage.waitUntillLoadingImageIsDisappeared(driver,
				PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		Thread.sleep(10000);

		proctorChromePage.waitUntillElementIsVisible(
				PropertiesRepository.getString("id.home.page.left.navigator.arrow.icon.link"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on arrow icon in the Left Navigation header");
		proctorChromePage.verifyAndClick(driver,
				PropertiesRepository.getString("id.home.page.left.navigator.arrow.icon.link"), true);

		log(logger, "Clicking on Student View link");
		proctorChromePage.clickButton(PropertiesRepository.getString("id.home.page.left.navigator.student.view.link"),
				1);
		proctorChromePage.waitUntillLoadingImageIsDisappeared(driver,
				PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		proctorChromePage.waitUntillLoadingImageIsDisappeared(driver,
				PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Clicking on Student View Continue button");
		proctorChromePage.clickButton(PropertiesRepository.getString("modal.continue.btn"), 1);

		proctorChromePage.waitUntillBufferInvisible(".modal-body>div>h3");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verifying if 'Return to Faculty Account' link is displayed");
		VerificationHandler.verifyTrue(homePage.verifyLinkUsingIndex(
				PropertiesRepository.getString("new-atitesting.home.returnToFacultyAcc.link.loc"), 1));

		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);

		log(logger, "Verifying Learn Tab");
		myATITabMainPage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyTrue(
				myATITabMainPage.verifyElement(PropertiesRepository.getString("new-atitesting.learn.type.section")),
				"Unable to verify Learn Tab ");

		log(logger, "Verifying Demo button");
		VerificationHandler.verifyTrue(myATITabMainPage
				.verifyDemoButtonForType(PropertiesRepository.getString("new-atitesting.cdn.learn.tab.product.name")));

		logger.info("NewATI792_VerifyStudentMimic End");
	}

	@TestAnnotations(testID = "NewATI-793")
	@Test(priority = 7, enabled = true, alwaysRun = true, description = "NewATI-793:Verify the flow for products which are not purchase by institution.")
	public void NewATI793_VerifyDemoProductsStudentmimic() throws Exception {

		log(logger, "NewATI793_VerifyDemoProductsStudentmimic Start");

		log(logger, "Login to application-faculty");
		proctorChromePage.loginToApplicationID(driver,
				PropertiesRepository.getString("new-atitesting.demo.products.faculty.user"),
				PropertiesRepository.getString("new-atitesting.demo.products.faculty.pwd"));
		proctorChromePage.waitUntillLoadingImageIsDisappeared(driver,
				PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));

		log(logger, "Clicking on Left Navigation Link");
		proctorChromePage.verifyAndClick(driver,
				PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true);
		proctorChromePage.waitUntillLoadingImageIsDisappeared(driver,
				PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));

		log(logger, "Clicking on arrow icon in the Left Navigation header");
		proctorChromePage.verifyAndClick(driver,
				PropertiesRepository.getString("id.home.page.left.navigator.arrow.icon.link"), true);
		proctorChromePage.waitUntillLoadingImageIsDisappeared(driver,
				PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));

		log(logger, "Clicking on Student View link");
		proctorChromePage.clickButton(PropertiesRepository.getString("id.home.page.left.navigator.student.view.link"),
				1);
		proctorChromePage.waitUntillLoadingImageIsDisappeared(driver,
				PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));

		log(logger, "Clicking on Student View Continue button");
		proctorChromePage.clickButton(PropertiesRepository.getString("modal.continue.btn"), 0);

		proctorChromePage.waitUntillLoadingImageIsDisappeared(driver,
				PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		proctorChromePage.waitUntillElementInvisible(".modal-body>div>h3");

		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);

		log(logger, "Clicking on demo button");
		myATITabMainPage.clickonDemoButton(PropertiesRepository.getString("new-atitesting.Demo.product.name"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verifying Demo popup details");
		VerificationHandler.verifyTrue(myATITabMainPage.verifyDemoButtonpopup());

		log(logger, "Click on cancel button");
		proctorChromePage.clickButton(PropertiesRepository.getString("new-atitesting.demo.popup.button.loc"), 0);

		log(logger, "Click on I understand button");
		myATITabMainPage.clickonDemoButton(PropertiesRepository.getString("new-atitesting.Demo.product.name"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		proctorChromePage.clickButton(PropertiesRepository.getString("new-atitesting.demo.popup.button.loc"), 1);

		log(logger, "Verifying Demo second popup details");
		VerificationHandler.verifyTrue(myATITabMainPage.verifyDemoButtonpopup2());

		log(logger, "NewATI793_VerifyDemoProductsStudentmimic end");
	}

	@TestAnnotations(testID = "NewATI-814")
	@Test(priority = 8, enabled = true, alwaysRun = true, description = "NewATI-814:To verify the Demo button color under student memic account")
	public void NewATI814_VerifyDemoButtonColour() throws Exception {

		log(logger, "NewATI814_VerifyDemoButtonColour Start");

		log(logger, "Login to application-faculty");
		proctorChromePage.loginToApplicationID(driver,
				PropertiesRepository.getString("new-atitesting.demo.products.faculty.user"),
				PropertiesRepository.getString("new-atitesting.demo.products.faculty.pwd"));
		proctorChromePage.waitUntillLoadingImageIsDisappeared(driver,
				PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));

		log(logger, "Clicking on Left Navigation Link");
		proctorChromePage.verifyAndClick(driver,
				PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true);
		proctorChromePage.waitUntillLoadingImageIsDisappeared(driver,
				PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));

		log(logger, "Clicking on arrow icon in the Left Navigation header");
		proctorChromePage.verifyAndClick(driver,
				PropertiesRepository.getString("id.home.page.left.navigator.arrow.icon.link"), true);
		proctorChromePage.waitUntillLoadingImageIsDisappeared(driver,
				PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));

		log(logger, "Clicking on Student View link");
		proctorChromePage.clickButton(PropertiesRepository.getString("id.home.page.left.navigator.student.view.link"),
				1);
		proctorChromePage.waitUntillLoadingImageIsDisappeared(driver,
				PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));

		log(logger, "Clicking on Student View Continue button");
		proctorChromePage.clickButton(PropertiesRepository.getString("modal.continue.btn"), 0);

		proctorChromePage.waitUntillLoadingImageIsDisappeared(driver,
				PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		proctorChromePage.waitUntillElementInvisible(".modal-body>div>h3");

		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		VerificationHandler.verifyTrue(myATITabMainPage.verifyDemoButtonColor(
				PropertiesRepository.getString("new-atitesting.demo.css.color.loc"),
				PropertiesRepository.getString("new-atitesting.demo.button.css.color.value"),
				PropertiesRepository.getString("new-atitesting.demo.css.color.attribue")));
		log(logger, "NewATI814_VerifyDemoButtonColour end");
	}

	@TestAnnotations(testID = "NewATI-795")
	@Test(priority = 9, enabled = true, alwaysRun = true, description = "NewATI-795:Verify the products under student mimic account.")
	public void NewATI795_VerifyDisabledDemoProducts() throws Exception {

		log(logger, "NewATI795_VerifyDisabledDemoProducts Start");

		log(logger, "Login to application-faculty");
		proctorChromePage.loginToApplicationID(driver,
				PropertiesRepository.getString("newati.fac.disable.demo.products.user"),
				PropertiesRepository.getString("newati.fac.disable.demo.products.pwd"));
		proctorChromePage.waitUntillLoadingImageIsDisappeared(driver,
				PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));

		log(logger, "Clicking on Left Navigation Link");
		proctorChromePage.verifyAndClick(driver,
				PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true);
		proctorChromePage.waitUntillLoadingImageIsDisappeared(driver,
				PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));

		log(logger, "Clicking on arrow icon in the Left Navigation header");
		proctorChromePage.verifyAndClick(driver,
				PropertiesRepository.getString("id.home.page.left.navigator.arrow.icon.link"), true);
		proctorChromePage.waitUntillLoadingImageIsDisappeared(driver,
				PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));

		log(logger, "Clicking on Student View link");
		proctorChromePage.clickButton(PropertiesRepository.getString("id.home.page.left.navigator.student.view.link"),
				1);
		proctorChromePage.waitUntillLoadingImageIsDisappeared(driver,
				PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));

		log(logger, "Clicking on Student View Continue button");
		proctorChromePage.clickButton(PropertiesRepository.getString("modal.continue.btn"), 0);

		proctorChromePage.waitUntillLoadingImageIsDisappeared(driver,
				PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		proctorChromePage.waitUntillElementInvisible(".modal-body>div>h3");

		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "unchecking Disabled product checkbox");
		proctorChromePage.clickButton(PropertiesRepository.getString("new-atitesting.hide.disable.checkbox"), 0);

		log(logger, "Verify disabled demo products");
		VerificationHandler.verifyTrue(myATITabMainPage.verifyDisabledDemoProducts(
				PropertiesRepository.getString("new-atitesting.learntab.smartprep.tutorial")));

		log(logger, "NewATI795_VerifyDisabledDemoProducts end");
	}

	@TestAnnotations(testID = "NewATI-789")
	@Test(priority = 10, enabled = true, alwaysRun = true, description = "NewATI-789:Student mimic- Verify the functionality for clicking cancel on Demo popup")
	public void NewATI789_VerifyCancelButtonFunctionality() throws Exception {

		log(logger, "NewATI789_VerifyCancelButtonFunctionality Start");

		log(logger, "Login to application-faculty");
		proctorChromePage.loginToApplicationID(driver,
				PropertiesRepository.getString("new-atitesting.demo.products.faculty.user"),
				PropertiesRepository.getString("new-atitesting.demo.products.faculty.pwd"));
		proctorChromePage.waitUntillLoadingImageIsDisappeared(driver,
				PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));

		log(logger, "Clicking on Left Navigation Link");
		proctorChromePage.verifyAndClick(driver,
				PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true);
		proctorChromePage.waitUntillLoadingImageIsDisappeared(driver,
				PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));

		log(logger, "Clicking on arrow icon in the Left Navigation header");
		proctorChromePage.verifyAndClick(driver,
				PropertiesRepository.getString("id.home.page.left.navigator.arrow.icon.link"), true);
		proctorChromePage.waitUntillLoadingImageIsDisappeared(driver,
				PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));

		log(logger, "Clicking on Student View link");
		proctorChromePage.clickButton(PropertiesRepository.getString("id.home.page.left.navigator.student.view.link"),
				1);
		proctorChromePage.waitUntillLoadingImageIsDisappeared(driver,
				PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));

		log(logger, "Clicking on Student View Continue button");
		proctorChromePage.clickButton(PropertiesRepository.getString("modal.continue.btn"), 0);

		proctorChromePage.waitUntillLoadingImageIsDisappeared(driver,
				PropertiesRepository.getString("ATIFaculti.common.page.spinner.loc"));
		proctorChromePage.waitUntillElementInvisible(".modal-body>div>h3");

		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);

		log(logger, "Clicking on demo button");
		myATITabMainPage.clickonDemoButton(PropertiesRepository.getString("new-atitesting.Demo.product.name"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verifying Demo popup details");
		VerificationHandler.verifyTrue(myATITabMainPage.verifyDemoButtonpopup());

		log(logger, "Click on cancel button");
		proctorChromePage.clickButton(PropertiesRepository.getString("new-atitesting.demo.popup.button.loc"), 0);
		log(logger, "NewATI789_VerifyCancelButtonFunctionality end");
	}

	/**
	 *
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-668")
	@Test(priority = 11, enabled = true, groups = {
			"Regression" }, alwaysRun = true, description = "NewATI-668:Verification for removal of Predict tab under My ATI tab")
	public void NewATI668_verifyBVRecentActivity() throws Exception {

		log(logger, "NewATI668_verifyBVRecentActivity Start");

		// Step 1
		loginPage.loginToApplication(PropertiesRepository.getString("newati.nclex.bv.login.user.name"),
				PropertiesRepository.getString("newati.nclex.bv.login.user.password"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verifying if Home page is displayed");
		VerificationHandler.verifyTrue(driver.getTitle().equals("Home - ATI Testing"));

		// Step 2
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		// Step 3
		log(logger, "Verify if PREDICT tab is not displaying next to APPLY tab");
		List<WebElement> listOfTabs = baseHandler.findElements(
				".ui-tabs-nav.ui-helper-reset.ui-helper-clearfix.ui-widget-header.ui-corner-all li[role='tab'] a");
		VerificationHandler.verifyTrue(!(listOfTabs.get(4).getText().equalsIgnoreCase("PREDICT")));

		logger.info("NewATI668_verifyBVRecentActivity End");
	}
}
