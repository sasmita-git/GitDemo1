package com.automation.id.home;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.id.pages.EditProfilePage;
import com.automation.id.pages.HomePage;
import com.automation.id.pages.LoginPage;
import com.jaca.TestAnnotations;

public class HomeTest extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	LoginPage loginPage;
	HomePage homePage;
	EditProfilePage editProfilePage;

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		editProfilePage = new EditProfilePage(driver);
	}

	/**
	 * 
	 * As discussed with Angandeep, verifying only Group Score. verifying
	 * "students at or below level" in available card. Step 4 needs data.
	 * 
	 * PDF Verification is pending.
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 * 
	 * Commented as part of FAC . 
	 * 
	 */

	//@TestAnnotations(testID = "INST-1631")
	//@Test(priority = 1, alwaysRun = true, enabled = true, groups = { "Smoke" }, description = "INST1631:Verify proctor widget for faculty home::Smoke Test Suite")
	public void INST1631_VerifyProctorWidget() throws Exception {
		logger.info("INST1631_VerifyProctorWidget Start");

		log(logger, "Login to application");

		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.faculty.username.home1"),
				PropertiesRepository.getString("id.login.faculty.password.home1"));

		log(logger, "Entering cohort");
		homePage.selectCohort(PropertiesRepository.getString("id.stg.cohort.naming"));

		log(logger, "Verifying Product Card");
		VerificationHandler.verifyTrue(homePage.verifyProductCard(), "Unable to verify Product Card");

		log(logger, "Verifying Product Name");

		VerificationHandler.verifyTrue(homePage.verifyProductDetail());

		log(logger, "Verifying Product Group Score");
		VerificationHandler.verifyTrue(homePage.verifyProductGroupSocre(), "Unable to verify Group Score");

		log(logger, "Students or below level");
		VerificationHandler.verifyTrue(homePage.verifyProductStudentBelowLevel(),
				"Unable to verify Student below level");

		log(logger, "Verifying PDF");
		VerificationHandler.verifyTrue(homePage.verifyPdfBtn(), "Unable to verify Product PDF");

		log(logger, "Verifying Exam Date");
		VerificationHandler.verifyTrue(homePage.verifyExamdate());

		log(logger, "Clicking on PDF button based on index");
		homePage.clickPDFIcon(0);
		logger.info("INST1631_VerifyProctorWidget End");

		log(logger, "select a cohort where no proctor assessment has been taken");
		homePage.selectCohort(PropertiesRepository.getString("id.stg.cohort.no.assessment"));

		log(logger, "verify that no proctor assessment taken for a class");
		homePage.VerifyBlankProductCard(3);

		log(logger, "select a cohort where 2 proctor assessment has been taken");
		homePage.selectCohort(PropertiesRepository.getString("id.stg.cohort.no.assessment1"));

		log(logger, "verify that 2 proctor test has been taken for a class");
		homePage.VerifyBlankProductCard(1);

	}
	
	/**
	 * The same number is in some, but it belongs to Result module, so commenting code. 
	 * 
	 * @author saravanan.jothimani
	 * @throws Exception
	 */
	//@TestAnnotations(testID = "INST-1680")
	//@Test(priority = 2, alwaysRun = true, enabled = true, groups = { "Smoke"}, description = "inst-1680:Verify ATI Conctacts ellipses in	 the top right corner and its functionality")
	public void INST1680_VerifyATIContactsPopUp() throws Exception {
		logger.info("INST1680_VerifyATIContactsPopUp Start");

		log(logger, "Login to application");
		loginPage.loginToApplication(PropertiesRepository.getString("id.faculty..home2.0.login.user.name"),
				PropertiesRepository.getString("id.faculty..home2.0.login.password"));

		log(logger, "click on more info list link");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.static.menu"), 1);

		log(logger, "click on static menu option");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.static.menu.list"), 0);

		log(logger, "verify ATI Contacts static menu popup ");
		VerificationHandler.verifyTrue(
				homePage.verifyTextEqualsList(PropertiesRepository.getString("id.home.static.list.option.loc"),
						PropertiesRepository.getString("id.home.static.list.ati.contacts.option.text")));

		log(logger, "verify content in the popup ");
		VerificationHandler.verifyTrue(homePage.verifyAtiContactsPopUpInfo(
				PropertiesRepository.getString("id.home.static.list.ati.contacts.popup.msg.loc")));

		logger.info("INST1680_VerifyATIContactsPopUp End");
	}

	@TestAnnotations(testID = "INST-1706")
	@Test(priority = 4, alwaysRun = true, enabled = true, groups = {
			"Smoke" }, description = "Verify Proctor logIn into application::Smoke Test Suite")
	public void INST1706_VerifyProctorLogin() throws Exception {
		logger.info("INST1706_VerifyProctorLogin Start");

		log(logger, "Proctor login");
		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.proctor.username.home"),
				PropertiesRepository.getString("id.login.proctor.password.home"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true), "Unable to click left navigation");

		log(logger, "Verifying Home Tab from Left navigation");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "dashboard", false), "Unable to verify Home Link");
		
		log(logger, "Verifying Proctor Tab from Left navigation");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "assessment", false), "Unable to verify  Proctor ");
		
		log(logger, "Verifying ATI Tab from Left navigation");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "ATI Academy", false), "Unable to verify ATI Link");
		
		log(logger, "Verifying Resources Tab from Left navigation");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "help_outline", false), "Unable to verify Resources Link");
		
		log(logger, "Verify product Link is not present");
		VerificationHandler.verifyFalse(homePage.verifyThatWebLinkIsPresent("trending_up"));

		logger.info("INST1706_VerifyProctorLogin End");
	}

	/*
	 * @TestAnnotations(testID="INST-1586")
	 * 
	 * @Test(priority = 5, alwaysRun =true, enabled = true,
	 * groups={"Smoke","Regression"}, description =
	 * "Verify for Edit Profile button on atitesting home page::Smoke Test Suite"
	 * ) public void INST1586_VerifyEditProfile() throws Exception {
	 * logger.info("INST1586_VerifyEditProfile Start");
	 * 
	 * log(logger, "Proctor login");
	 * //loginPage.loginToApplication(PropertiesRepository.getString(
	 * "id.login.proctor.username"),
	 * PropertiesRepository.getString("id.login.proctor.password"));
	 * loginPage.loginToApplication(PropertiesRepository.getString(
	 * "id.login.faculty.username.home"),
	 * PropertiesRepository.getString("id.login.faculty.password.home"));
	 * 
	 * log(logger, "click on close button");
	 * loginPage.clickButtonFromList(PropertiesRepository.getString(
	 * "id.homepage.home.page.alert.close"), 0);
	 * 
	 * log(logger,"Clicking on Left Navigation Link");
	 * editProfilePage.verifyAndClick(PropertiesRepository.getString(
	 * "id.home.page.left.navigator.icon.link"), true);
	 * 
	 * log(logger,"Clicking on user name");
	 * editProfilePage.clickButton(PropertiesRepository.getString(
	 * "id.login.edit.profile.name.loc"), 0);
	 * 
	 * log(logger, "click on settings tab");
	 * editProfilePage.clickElement("id.homepage.main.menu.list",1);
	 * VerificationHandler.verifyEquals(driver.getCurrentUrl().trim(),
	 * PropertiesRepository.getString("profile.url"));
	 * 
	 * logger.info("INST1586_VerifyEditProfile End"); }
	 */

	/**
	 * Commented as part of FAC . 
	 * 
	 * @throws Exception
	 */
	//@TestAnnotations(testID = "INST-1736")
	//@Test(priority = 6, alwaysRun = true, enabled = true, groups = { "Smoke" }, description = "Verify Faculty Navigation UI for Name and Dropdown Design Change::Smoke Test Suite")
	public void INST1736_VerifyEditProfileStudentLogin() throws Exception {
		logger.info("INST1736_VerifyEditProfileStudentLogin Start");

		log(logger, "Proctor login");
		// loginPage.loginToApplication(PropertiesRepository.getString("id.login.faculty.username"),
		// PropertiesRepository.getString("id.login.faculty.password"));
		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.faculty.username.home"),
				PropertiesRepository.getString("id.login.faculty.password.home"));

		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "click on close button");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.home.page.alert.close"), 0);

		log(logger, "Clicking on Left Navigation Link");
		loginPage.verifyAndClick(PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true);

		log(logger, "Verifying Name in Home Page");
		VerificationHandler.verifyTrue(
				homePage.verifyTextContains(PropertiesRepository.getString("id.login.edit.profile.name.loc"),
						PropertiesRepository.getString("id.home.edit.profile.1736.name.value")),
				"Unable to verify Name");

		log(logger, "Clicking on user name");
		editProfilePage.clickButton(PropertiesRepository.getString("id.login.edit.profile.name.loc"), 0);

		log(logger, "Clicking on Edit Profile Link");
		/*
		 * loginPage.verifyAndClick(PropertiesRepository.getString(
		 * "id.home.page.left.navigation.edit.profile.link"), true);
		 */

		editProfilePage.clickButton(PropertiesRepository.getString("id.login.edit.profile.name.loc"), 2);

		log(logger, "click on student view tab");
		editProfilePage.clickElement("id.homepage.main.menu.list.top", 1);

		log(logger, "click on student view continue button link");
		homePage.clickContinueForStudentView();

		// log(logger, "Verifying Student Login");
		// VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText(0,
		// PropertiesRepository.getString("id.home.left.navigation.student.view"),
		// false), "Unable to Student Login in Home Page ");
		logger.info("INST1736_VerifyEditProfileStudentLogin End");

	}

	@TestAnnotations(testID = "INST-1737")
	@Test(priority = 7, alwaysRun = true, enabled = true, groups = {
			"Smoke" }, description = "INST-1737:Verify the left navigation panel should auto hide after user click on any of its menu item::Smoke Test Suite")
	public void INST1737_VerifyHideLeftNavigation() throws Exception {
		logger.info("INST1737_VerifyEditProfile Start");

		loginPage.loginToApplication1(
				PropertiesRepository.getString("id.auto.hm2.instructor7.username"),
				PropertiesRepository.getString("id.auto.hm2.instructor7.password"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true), "Unable to click left navigation");

		log(logger, "Verifying Home Tab from Left navigation");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "dashboard", false), "Unable to verify Home Link");
		
		log(logger, "Verifying Products Tab from Left navigation");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "apps", false), "Unable to verify  Products   ");
		
		log(logger, "Verifying Proctor from Left navigation");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "assessment", false), "Unable to verify Proctor ");
		
		log(logger, "Verifying Assessment Builder Tab from Left navigation");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "build", false), "Unable to verify Assessment Builder Link");

		log(logger, "click on Analytics tab");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "trending_up", false), "Unable to verify Analytics Link");

		log(logger, "click on People tab");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "people", false), "Unable to verify People Link");

		log(logger, "click on ATI Academy tab");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "school", false), "Unable to verify ATI Academy Link");

		log(logger, "click on C-Map tab");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "map", false), "Unable to verify C-Map Link");

		log(logger, "click on Resources   tab");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "help_outline", false), "Unable to verify Resources   Link");

		/*log(logger, "Verifying Home Tab from Left navigation");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", 0, "dashboard", true), "Unable to verify Home Link");

		log(logger, "Verifying Home page header");
		VerificationHandler.verifyTrue(homePage.verifyMessage("id.home.page.tile.loc", 0, PropertiesRepository.getString("id.home.page.tile.value")), "Unable to verify Home page header");
*/		
		log(logger, "Verifying Left Navigation");
		VerificationHandler.verifyTrue(homePage.verifyLeftNavAutoHide(), "Unable to verify Left navigation is hidden or not");
		
		logger.info("INST1737_VerifyEditProfile End");
	}

	@TestAnnotations(testID = "INST-1743")

	@Test(priority = 9, alwaysRun = true, enabled = true, groups = {
			"Smoke" }, description = "INST-1743:Check for Sign out link present in elipses")
	public void INST1743_CheckforSignOutLink() throws Exception {
		logger.info("INST1743_CheckforSignOutLink Start");

		loginPage.loginToApplication1(
				PropertiesRepository.getString("id.auto.hm2.instructor6.username"),
				PropertiesRepository.getString("id.auto.hm2.instructor6.password"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.spinner.loc"));
		
		/*log(logger, "click on close button if exists");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.home.page.alert.close"), 0);*/

		//Step 1
		log(logger, "Click on Ellipses on the top right corner");
		loginPage.clickButton(PropertiesRepository.getString("id.homepage.static.menu"), 1);
		//Step 1
		log(logger, "Verify Customize Home link");
		VerificationHandler.verifyTrue(homePage
				.verifyLink(PropertiesRepository.getString("id.home.menu.item.list.loc"), 0, "settings"));
		//Step 1
		log(logger, "Verify ATI contact link");
		VerificationHandler.verifyTrue(homePage
				.verifyLink(PropertiesRepository.getString("id.home.menu.item.list.loc"), 1, "contacts"));
		//Step 1
		log(logger, "Verify online store link");
		VerificationHandler.verifyTrue(homePage.verifyLink(
				PropertiesRepository.getString("id.home.menu.item.list.loc"), 2, "store_mall_directory"));
		//Step 1
		log(logger, "Verify product solution link");
		VerificationHandler.verifyTrue(homePage.verifyLink(
				PropertiesRepository.getString("id.home.menu.item.list.loc"), 3, "explore"));
		//Step 1
		log(logger, "Verify Sign Out link");
		VerificationHandler.verifyTrue(homePage
				.verifyLink(PropertiesRepository.getString("id.home.menu.item.list.loc"), 4, "exit_to_app"));
		//Step 2
		log(logger, "click on sign out button");
		VerificationHandler.verifyTrue(
				loginPage.verifyAndClick(PropertiesRepository.getString("id.home.menu.item.list.loc"), 4, true),
				"Unabel to click Signout link");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.spinner.loc"));
		//Step 2
		VerificationHandler.verifyTrue(homePage.verifyElementExists(PropertiesRepository.getString("id.login.username.loc")), "Unable to verify User name in login page");
		
		logger.info("INST1743_CheckforSignOutLink End");
	}

	@TestAnnotations(testID = "INST-1751")
	@Test(priority = 11, alwaysRun = true, enabled = true, groups = {
			"Smoke" }, description = "INST-1751:Verify the Warm Transfer from Faculty Login to student")
	public void INST1751_verifyStudentWarmTransfer() throws Exception {
		logger.info("INST1751_verifyStudentWarmTransfer Start");

		log(logger, "Login to application");
		
		loginPage.loginToApplication1(
				PropertiesRepository.getString("id.auto.hm2.instructor6.username"),
				PropertiesRepository.getString("id.auto.hm2.instructor6.password"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.spinner.loc"));

		log(logger, "Clicking on left navigation icon");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true), "Unable to click left navigation");
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.spinner.loc"));
		
		log(logger, "Clicking on user name");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.login.edit.profile.name.loc"), true), "Unable to click User Name in left navigation");

		log(logger, "click on student view tab");
		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.homepage.main.menu.list.top"), 1, true), "Unable to click Student view in left navigation");
		homePage.waitUntillLoadingImageIsDisappeareds("new-atitesting.peasewait.bufferLoc");
		//editProfilePage.clickElement("id.homepage.main.menu.list.top", 1);

		log(logger, "click on student view continue button link");
		VerificationHandler.verifyTrue(homePage.clickContinueForStudentView(), "Unable to verify student view continue button funcationality");
		homePage.waitUntillLoadingImageIsDisappeareds("new-atitesting.peasewait.bufferLoc");

		log(logger, "Click on Return to faculty link");
		VerificationHandler.verifyTrue(homePage.clickOnReturnToFacultyLink(1), "Unable to click Return to faculty link in Student Portal");
		homePage.waitUntillLoadingImageIsDisappeareds("new-atitesting.peasewait.bufferLoc");
		
		/*log(logger, "Verifying Home page header");
		VerificationHandler.verifyTrue(homePage.verifyMessage("id.home.page.tile.loc", 0, PropertiesRepository.getString("id.home.page.tile.value")), "Unable to verify Home page header");
	*/
		
		log(logger, "Clicking on Left Navigation Link to verify that we are back to faculty");
		VerificationHandler.verifyTrue(editProfilePage.verifyAndClick(PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), false), "Unable to click left navifation in faculty portal application");

		logger.info("INST1751_verifyStudentWarmTransfer End");
	}

	/**
	 * Commented as part of FAC . 
	 * 
	 * @throws Exception
	 */
	//@TestAnnotations(testID = "INST-1624")
	//@Test(priority = 12, alwaysRun = true, enabled = true, groups = {"Smoke" }, description = "Verify Pulse score widget")
	public void INST1624_HomePageElement() throws Exception {
		logger.info("INST1624_HomePageElement Start");

		/**
		 * Merging of INST-1624
		 */
		log(logger, "Login to application");
		// loginPage.loginToApplication(PropertiesRepository.getString("id.login.faculty.username"),
		// PropertiesRepository.getString("id.login.faculty.password"));
		loginPage.loginToApplication1(PropertiesRepository.getString("id.login.faculty.username.home"),
				PropertiesRepository.getString("id.login.faculty.password.home"));

		log(logger, "click on close button");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.home.page.alert.close"), 0);

		log(logger, "Entering cohort");

		// homePage.selectCohort(PropertiesRepository.getString("id.stg.cohort.naming"));
		homePage.selectCohort(PropertiesRepository.getString("id.stg.cohort.naming.home"));

		log(logger, "Verifying Pulse Card");
		VerificationHandler.verifyTrue(
				homePage.verifyElementExists(PropertiesRepository.getString("id.home.pulse.tab.loc")),
				"Unable to verify Pulse Card");

		log(logger, "Verifying Exam Date");
		VerificationHandler.verifyTrue(
				homePage.verifyElementExists(PropertiesRepository.getString("id.home.pulse.data.loc")),
				"Unable to verify Pulse Updated Date");

		/**
		 * merging of INST-1586
		 */
		log(logger, "Clicking on Left Navigation Link");
		editProfilePage.verifyAndClick(PropertiesRepository.getString("id.home.page.left.navigator.icon.link"), true);

		log(logger, "Clicking on user name");
		editProfilePage.clickButton(PropertiesRepository.getString("id.login.edit.profile.name.loc"), 0);

		log(logger, "click on settings tab");
		editProfilePage.clickElement("id.homepage.main.menu.list.top", 2);

		VerificationHandler.verifyEquals(driver.getCurrentUrl().trim(), PropertiesRepository.getString("profile.url"));

		/**
		 * Merging of INST-1736
		 */
		log(logger, "Verifying Name in Home Page");
		VerificationHandler.verifyTrue(
				homePage.verifyTextContains(PropertiesRepository.getString("id.login.edit.profile.name.loc"),
						PropertiesRepository.getString("id.home.edit.profile.1736.name.value")),
				"Unable to verify Name");

		log(logger, "Clicking on Edit Profile Link");
		loginPage.verifyAndClick(PropertiesRepository.getString("id.home.page.left.navigation.edit.profile.link"),
				true);

		/**
		 * merging of INST-1743
		 */

		log(logger, "click on more info list link");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.static.menu"), 1);

		log(logger, "click on sign out button");
		VerificationHandler.verifyTrue(
				loginPage.verifyAndClick(PropertiesRepository.getString("id.homepage.static.menu.list"), false),
				"Unabel to click Signout link");
		loginPage.clickButtonFromList(PropertiesRepository.getString("id.homepage.static.menu.list"), 3);

		logger.info("INST1624_HomePageElement End");
	}
}
