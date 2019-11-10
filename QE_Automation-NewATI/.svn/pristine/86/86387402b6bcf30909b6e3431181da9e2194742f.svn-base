package com.automation.newati.curriculumcohort;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.TextHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.CreateAccountPage;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LearnTabPage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.MyATITabMainPage;
import com.automation.newati.pages.MyReportPage;
import com.automation.newati.pages.NclexPrepTabPage;
import com.automation.newati.pages.PractiseAssessmentPage;
import com.automation.newati.pages.TestTabPage;
import com.automation.newati.pages.TutorialPage;
import com.automation.newati.util.UserCreationUtils;
import com.jaca.TestAnnotations;

public class Regression extends BaseTest {
	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private TestTabPage testTabPage;
	private LearnTabPage learnTabPage;
	private TextHandler textHandler;
	private CreateAccountPage createAccountPage;
	private BaseHandler baseHandler;
	private static String userId = null;
	private UserCreationUtils userCreationUtils = new UserCreationUtils();

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		testTabPage = new TestTabPage(driver);
		learnTabPage = new LearnTabPage(driver);
		textHandler = new TextHandler(driver);
		createAccountPage = new CreateAccountPage(driver);
		baseHandler = new BaseHandler(driver);
	}

	/**
	 *
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-914")
	@Test(priority = 1, enabled = true, groups = {
			"Regression" }, alwaysRun = true, description = "NewATI-914:Verify that student can add graduation and curriculum cohort")
	public void NewATI914_verifyGraduationcurrcilum() throws Exception {

		log(logger, "NewATI914_verifyGraduationcurrcilum Start");

		userId = userCreationUtils.getUserDetails();
		if (userId == null) {
			logger.info("Recreation of user started ");
			userId = userCreationUtils.getUserDetails();
		}
		// Step 1
		loginPage.loginToApplication(userId, PropertiesRepository.getString("newati.login.payment.pwd"));

		// Step 3
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Add Product button");
		homePage.click(PropertiesRepository.getString("new-atitesting.add.product.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		VerificationHandler.verifyTrue(homePage.verifyAddProductPopup());
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		textHandler.writeText(PropertiesRepository.getString("new-atitesting.add.product.id.loc"),
				PropertiesRepository.getString("newati.GC.cohort"));
		log(logger, "Clicking on Continue button");
		homePage.click(PropertiesRepository.getString("new-atitesting.add.product.continue.button.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		// Verifying if Product added
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		// Step 4
		log(logger, "Clicking on Info Icon for Specific Module");
		testTabPage.clickInfoIconByNameLearntab(PropertiesRepository.getString("newati.GC.product"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying the added Product in Learn tab");
		VerificationHandler.verifyTrue(
				learnTabPage.verifyIfProductAdded(PropertiesRepository.getString("newati.GC.cohort.with.batch.id")));

		// Closing the info popup
		homePage.pressEscapeKey();

		// Step 5
		log(logger, "Clicking on Add Product button");
		homePage.click(PropertiesRepository.getString("newati.add.product.learn.tab"));

		VerificationHandler.verifyTrue(homePage.verifyAddProductPopupInLearnTab());
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		textHandler.writeText(PropertiesRepository.getString("new-atitesting.add.product.id.learn.tab.loc"),
				PropertiesRepository.getString("newati.CC.cohort"));
		log(logger, "Clicking on Continue button");
		homePage.click(PropertiesRepository.getString("new-atitesting.add.product.continue.button.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		// Verifying if Product added
		// Step 6
		log(logger, "Clicking on Info Icon for Specific Module");
		testTabPage.clickInfoIconByNameLearntab(PropertiesRepository.getString("newati.CC.product"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying the added Product in Learn tab");
		VerificationHandler.verifyTrue(
				learnTabPage.verifyIfProductAddedFromSecondCDN(PropertiesRepository.getString("newati.GC.cohort.with.batch.id.new")));

		// Closing the info popup
		homePage.pressEscapeKey();

		// Step 7
		log(logger, "Clicking on Info Icon for Specific Module");
		testTabPage.clickInfoIconByNameLearntab(PropertiesRepository.getString("newati.GC.CC.both.products"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Verifying the added Product has both CDN's");
		VerificationHandler.verifyTrue(
				learnTabPage.verifyIfProductAdded(PropertiesRepository.getString("newati.SM1.cohort.with.batch.id")));
		VerificationHandler.verifyTrue(learnTabPage
				.verifyIfProductAddedFromSecondCDN(PropertiesRepository.getString("newati.SM1.cohort.with.batch.id")));
		homePage.pressEscapeKey();

		// Step 8
		log(logger, "Clicking on My Profile link");
		homePage.clickButtonFromList("new-atitesting.hometab.upper.links.loc", 0);

		log(logger, "Clicking on Insitution info edit link");
		homePage.clickButtonFromList("new-atitesting.institution.info.edit.link", 0);

		log(logger, "Changing Institution name");
		createAccountPage.selectDropdownValue(
				PropertiesRepository.getString("new-atitesting.institution.info.dd.institution.loc"),
				PropertiesRepository.getString("new-atitesting.profile.edit.institution.value"));

		log(logger, "Clicking on Save Button");
		homePage.clickButtonFromList("new-atitesting.institution.info.save.button.loc", 0);

		log(logger, "Verifying Institution Name");
		VerificationHandler.verifyTrue(
				homePage.verifyMessage(
						PropertiesRepository.getString("new-atitesting.institution.info.institution.value.loc"),
						PropertiesRepository.getString("new-atitesting.profile.edit.institution.value")),
				"Institution name is not changed");

		// Step 9
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		// Step 10
		log(logger, "Clicking on Add Product button");
		homePage.click(PropertiesRepository.getString("newati.add.product.learn.tab.no.prod"));

		VerificationHandler.verifyTrue(homePage.verifyAddProductPopupInLearnTab());
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		textHandler.writeText(PropertiesRepository.getString("new-atitesting.add.product.id.learn.tab.loc"),
				PropertiesRepository.getString("newati.GC.cohort"));
		log(logger, "Clicking on Continue button");
		homePage.click(PropertiesRepository.getString("new-atitesting.add.product.continue.button.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Verifying error message");
		VerificationHandler.verifyTrue(baseHandler
				.findElement(PropertiesRepository.getString("newati.add.product.error.msg.loc")).getText().contains(
						"The Product ID you have entered does not belong to the Institution recorded in your profile."));
		homePage.pressEscapeKey();

		// Step 11
		log(logger, "Clicking on My Profile link");
		homePage.clickButtonFromList("new-atitesting.hometab.upper.links.loc", 0);

		log(logger, "Clicking on Insitution info edit link");
		homePage.clickButtonFromList("new-atitesting.institution.info.edit.link", 0);

		log(logger, "Changing Institution name");
		createAccountPage.selectDropdownValue(
				PropertiesRepository.getString("new-atitesting.institution.info.dd.institution.loc"),
				PropertiesRepository.getString("new-atitesting.createaccount.institution.value"));

		log(logger, "Clicking on Save Button");
		homePage.clickButtonFromList("new-atitesting.institution.info.save.button.loc", 0);

		log(logger, "Verifying Institution Name");
		VerificationHandler.verifyTrue(
				homePage.verifyMessage(
						PropertiesRepository.getString("new-atitesting.institution.info.institution.value.loc"),
						PropertiesRepository.getString("new-atitesting.createaccount.institution.value")),
				"Institution name is not changed");

		logger.info("NewATI914_verifyGraduationcurrcilum End");
	}

	/**
	 * Precondition : User should have CDN's added as per test link.
	 * 
	 * @author syed.pasha
	 * @throws Exception
	 */
	@TestAnnotations(testID = "NewATI-915")
	@Test(priority = 2, enabled = true, groups = {
			"Regression" }, alwaysRun = true, description = "NewATI-915 : Verify all scheduled product should merged as part of graduation as well as curriculum cohort.")
	public void NewATI915_verifyGraduationcurrcilumInCalender() throws Exception {

		log(logger, "NewATI915_verifyGraduationcurrcilumInCalender Start");

		// Step 1
		loginPage.loginToApplication(PropertiesRepository.getString("newati.cohort.username.915"),
				PropertiesRepository.getString("newati.cohort.passwords.915"));

		// Step 2 and Step 3 is also a part of precondition as already added course cannot be added again		
		
		// Step 5
		log(logger, "Clicking on My ATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		// Click on Calendar below the Tabs
		log(logger, "Clicking on Calendar Link");
		homePage.clickButton("#MyATICalendarSubNav");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		// Clicking on Calander Date
		log(logger, "Clicking on Calendar Date-1 D/M/YYYY");
		homePage.selectDateOnHomeCalendar(PropertiesRepository.getString("newati.cohort.date1"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyTrue(
				homePage.verifyCalendarScheduleDetails(PropertiesRepository.getString("newati.cohort.course1"),
						PropertiesRepository.getString("newati.cohort.assigenedProduct1"),
						PropertiesRepository.getString("newati.cohort.productType1")));
		//Close Calendar Event Popup
		log(logger, "Clicking on Popup Close button");
		baseHandler.findElement(PropertiesRepository.getString("new-atitesting.calendar.event.close.btn.loc")).click();

		log(logger, "Clicking on Calendar Date-2 D/M/YYYY");
		homePage.selectDateOnHomeCalendar(PropertiesRepository.getString("newati.cohort.date2"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyTrue(
				homePage.verifyCalendarScheduleDetails(PropertiesRepository.getString("newati.cohort.course2"),
						PropertiesRepository.getString("newati.cohort.assigenedProduct2"),
						PropertiesRepository.getString("newati.cohort.productType2")));
		//Close Calendar Event Popup
		log(logger, "Clicking on Popup Close button");
		baseHandler.findElement(PropertiesRepository.getString("new-atitesting.calendar.event.close.btn.loc")).click();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Calendar Date-3 D/M/YYYY");
		homePage.selectDateOnHomeCalendar(PropertiesRepository.getString("newati.cohort.date3"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyTrue(
				homePage.verifyCalendarScheduleDetails(PropertiesRepository.getString("newati.cohort.course3"),
						PropertiesRepository.getString("newati.cohort.assigenedProduct3"),
						PropertiesRepository.getString("newati.cohort.productType3")));
		//Close Calendar Event Popup
		log(logger, "Clicking on Popup Close button");
		baseHandler.findElement(PropertiesRepository.getString("new-atitesting.calendar.event.close.btn.loc")).click();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Calendar Date-4 D/M/YYYY");
		homePage.selectDateOnHomeCalendar(PropertiesRepository.getString("newati.cohort.date4"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyTrue(
				homePage.verifyCalendarScheduleDetails(PropertiesRepository.getString("newati.cohort.course4"),
						PropertiesRepository.getString("newati.cohort.assigenedProduct4"),
						PropertiesRepository.getString("newati.cohort.productType4")));
		//Close Calendar Event Popup
		log(logger, "Clicking on Popup Close button");
		baseHandler.findElement(PropertiesRepository.getString("new-atitesting.calendar.event.close.btn.loc")).click();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");		
		log(logger, "Clicking on Calendar Date-5 D/M/YYYY");
		homePage.selectDateOnHomeCalendar(PropertiesRepository.getString("newati.cohort.date5"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyTrue(
				homePage.verifyCalendarScheduleDetails(PropertiesRepository.getString("newati.cohort.course5"),
						PropertiesRepository.getString("newati.cohort.assigenedProduct5"),
						PropertiesRepository.getString("newati.cohort.productType5")));
		//Close Calendar Event Popup
		log(logger, "Clicking on Popup Close button");
		baseHandler.findElement(PropertiesRepository.getString("new-atitesting.calendar.event.close.btn.loc")).click();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Calendar Date-6 D/M/YYYY");
		homePage.selectDateOnHomeCalendar(PropertiesRepository.getString("newati.cohort.date6"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		VerificationHandler.verifyTrue(
				homePage.verifyCalendarScheduleDetails(PropertiesRepository.getString("newati.cohort.course6"),
						PropertiesRepository.getString("newati.cohort.assigenedProduct6"),
						PropertiesRepository.getString("newati.cohort.productType6")));
		//Close Calendar Event Popup
		log(logger, "Clicking on Popup Close button");
		baseHandler.findElement(PropertiesRepository.getString("new-atitesting.calendar.event.close.btn.loc")).click();
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		logger.info("NewATI915_verifyGraduationcurrcilumInCalender End");
	}

}
