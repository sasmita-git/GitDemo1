package com.automation.newati.board.vitals;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.NclexPrepTabPage;
import com.automation.newati.pages.TutorialPage;

public class VerifyBoardVitalsFunctionalityTest1 extends BaseTest {

	Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private TutorialPage tutorialPage;
			
	private NclexPrepTabPage nclexPrepTabPage;
	@BeforeMethod
	public void VerifyLearnTabScenariosReview() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		nclexPrepTabPage=new NclexPrepTabPage(driver);
		tutorialPage=new TutorialPage(driver);
		
	}
	
	@Test(priority = 1, description = "NewATI-571:Verify the header in card back page")
	public void NewATI571_VerifyTheHeaderInCardBackPage() throws Exception {
		logger.info("Method : NewATI571_VerifyTheHeaderInCardBackPage Start");
//		loginPage.loginToApplication(PropertiesRepository.getString("newati.nclex.login.user.name1.boardvital.newusr1"), PropertiesRepository.getString("newati.nclex.login.user.password.boardvital.new"));
		loginPage.loginToApplication("boardvital01","Test123");
		
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking NCLEXPREP Tab");
		homePage.clickSubTab(4);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		boolean verifySubTabs = nclexPrepTabPage.verifySubTabs();
		VerificationHandler.verifyTrue(verifySubTabs);
		log(logger, "Clicking Module by Name");
		tutorialPage.clickOnNCLEXModuleButton(PropertiesRepository.getString("new-atitesting.nclexprep.tab.rn.product.name"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		boolean message=nclexPrepTabPage.verifyNclexCardBackMessage(PropertiesRepository.getString("new-atitesting.nclexprep.cardback.header"));
		VerificationHandler.verifyTrue(message);
		
		log(logger, "click on close button");
		nclexPrepTabPage.clickButton(PropertiesRepository.getString("new-atitesting.cardback.close.loc"));
	
		logger.info("Method : NewATI571_VerifyTheHeaderInCardBackPage End");
	}
	
	@Test(priority = 2, description = "NewATI-599:Verify the Module count in the card back page")
	public void NewATI599_VerifyModuleCountinTheCardBackPage() throws Exception {
		logger.info("Method : NewATI599_VerifyModuleCountinTheCardBackPage Start");
		loginPage.loginToApplication("simulation27thsep","Test123");
		
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking NCLEXPREP Tab");
		homePage.clickSubTab(4);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking Module by Name");
		tutorialPage.clickOnNCLEXModuleButton(PropertiesRepository.getString("new-atitesting.nclexprep.tab.rn.product.name"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		boolean message=nclexPrepTabPage.isDropDownOrCheckBoxDisplayed();
		VerificationHandler.verifyTrue(message);
		
		log(logger, "click on close button");
		nclexPrepTabPage.clickButton(PropertiesRepository.getString("new-atitesting.cardback.close.loc"));
	
		logger.info("Method : NewATI599_VerifyModuleCountinTheCardBackPage End");
	}
	
	
	@Test(priority = 3, description = "NewATI-581:NewATI-580:To verify Board vitals product enablei/disable as Institution purchase")
	public void NewATI581_VerifyModuleCountinTheCardBackPage() throws Exception {
		logger.info("Method : NewATI581_VerifyModuleCountinTheCardBackPage Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.nclex.preptab.login.user.name.new"), PropertiesRepository.getString("newati.nclex.preptab.login.pwd"));
		
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking NCLEXPREP Tab");
		homePage.clickSubTab(4);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		boolean verifySubTabs = nclexPrepTabPage.verifySubTabs();
		VerificationHandler.verifyTrue(verifySubTabs);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on addproduct button");
		nclexPrepTabPage.clickButton(PropertiesRepository.getString("new-atitesting.nclexprep.add.product.button.loc"),1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "enter product");
		nclexPrepTabPage.enterValue("new-atitesting.nclexprep.add.product.button.input.loc",PropertiesRepository.getString("new-atitesting.nclexprep.tab.product.input.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on continue button");
		nclexPrepTabPage.clickButton(PropertiesRepository.getString("new-atitesting.add.product.continue.button.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "enter password");
		nclexPrepTabPage.enterValue("new-atitesting.nclexprep.add.product.button.pwd.loc",PropertiesRepository.getString("new-atitesting.nclexprep.tab.product.pwd.value"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "click on continue button");
		nclexPrepTabPage.clickButton(PropertiesRepository.getString("new-atitesting.add.product.continue.button.loc"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		
		VerificationHandler.verifyTrue(nclexPrepTabPage.verifyProductType("new-atitesting.nclexprep.product.header"), "Unable to verify Adaptive Test ");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		logger.info("Method : NewATI599_VerifyModuleCountinTheCardBackPage End");
	}
	
	
	@Test(priority =4, description = "NewATI-588:Verify the More Info button")
	public void NewATI588_VerifyTheMoreInfoButton() throws Exception {
		logger.info("Method : NewATI588_VerifyTheMoreInfoButton Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.nclex.preptab.login.user.name.new"), PropertiesRepository.getString("newati.nclex.preptab.login.pwd"));
		
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		
		log(logger, "Clicking NCLEXPREP Tab");
		homePage.clickSubTab(4);
		
		log(logger, "click on info icon");
		nclexPrepTabPage.clickButton(PropertiesRepository.getString("new-atitesting.nclexprep.add.product.info.icon.loc"),0);
		
		log(logger, "click on close button");
		//nclexPrepTabPage.clickButton(PropertiesRepository.getString("newati.payment.mypurchase.order.close.button2"),5);
		nclexPrepTabPage.clickButton(PropertiesRepository.getString("newati.info.close.button"));
		logger.info("Method : NewATI588_VerifyTheMoreInfoButton End");
	}
	
	@Test(priority = 5, description = "NewATI-608:Verify sort or filter dropdowns are not present in NCLEX Prep")
	public void NewATI608_VerifyFiltersOnNclexPrepPage() throws Exception {
		logger.info("Method : NewATI608_VerifyFiltersOnNclexPrepPage Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.nclex.preptab.login.user.name.new"), PropertiesRepository.getString("newati.nclex.preptab.login.pwd"));
		
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking NCLEXPREP Tab");
		homePage.clickSubTab(4);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		boolean message=nclexPrepTabPage.isDropDownOrCheckBoxDisplayed();
		VerificationHandler.verifyTrue(message);
		
		log(logger, "verify hide products checkbox ");
		boolean checkElementEnabled = nclexPrepTabPage.checkElementEnabled(PropertiesRepository.getString("new-atitesting.nclexprep.hide.products.loc"));
		VerificationHandler.verifyTrue(checkElementEnabled);
		
		boolean result=nclexPrepTabPage.verifyProductType("new-atitesting.nclexprep.product.header");
		VerificationHandler.verifyTrue(result);
		
		logger.info("Method : NewATI608_VerifyFiltersOnNclexPrepPage End");
	}
	
	@Test(priority = 6, description = "NewATI-671:Verify the Board Vital product launch")
	public void NewATI671_VerifyTheBoardVitalProductLaunch() throws Exception {
		logger.info("Method : NewATI671_VerifyTheBoardVitalProductLaunch Start");
//		loginPage.loginToApplication(PropertiesRepository.getString("newati.nclex.preptab.login.user.name"), PropertiesRepository.getString("newati.nclex.preptab.login.pwd"));
//		loginPage.loginToApplication(PropertiesRepository.getString("newati.nclex.login.user.name1.boardvital.newusr1"), PropertiesRepository.getString("newati.nclex.login.user.password.boardvital.new"));
		loginPage.loginToApplication("boardvital01","Test123");
		
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking NCLEXPREP Tab");
		homePage.clickSubTab(4);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Verifying Sub Tabs");
		VerificationHandler.verifyTrue(nclexPrepTabPage.verifySubTabs(), "Unable to verify sub tabs");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking Module by Name");
		tutorialPage.clickOnNCLEXModuleButton(PropertiesRepository.getString("new-atitesting.nclexprep.tab.rn.product.name"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "click on nclex adaptive test link");
		nclexPrepTabPage.clickButton(PropertiesRepository.getString("new-atitesting.nclexprep.cardback.product.links"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Unable to verify element after opening. ");
		VerificationHandler.verifyTrue(nclexPrepTabPage.checkElementEnabled(PropertiesRepository.getString("new-atitesting.nclexprep.cardback.close.button")), "Unable to verify element after opening.");
		
		logger.info("Method : NewATI671_VerifyTheBoardVitalProductLaunch End");
	}
	
	
	@Test(priority = 7, description = "NewATI-579:Verify the UI in Card Front page of Board Vitals NCLEX Prep for Expired Status")
	public void NewATI579_VerifyTheUIInCardFrontPage() throws Exception {
		logger.info("Method : NewATI579_VerifyTheUIInCardFrontPage Start");
		loginPage.loginToApplication(PropertiesRepository.getString("newati.nclex.preptab.login.user.name.new"), PropertiesRepository.getString("newati.nclex.preptab.renew.login.pwd"));
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking NCLEXPREP Tab");
		homePage.clickSubTab(4);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		boolean verifySubTabs = nclexPrepTabPage.verifySubTabs();
		VerificationHandler.verifyTrue(verifySubTabs);
		
		boolean result=nclexPrepTabPage.verifyNclexExpiredDateNew(PropertiesRepository.getString("new-atitesting.nclexprep.tab.product.name.new"));
		VerificationHandler.verifyTrue(result);
		
		boolean status=nclexPrepTabPage.verifyRenewSubscriptionPage();
		VerificationHandler.verifyTrue(status);
		
		logger.info("Method : NewATI579_VerifyTheUIInCardFrontPage End");
	}
	
	@Test(priority = 8, description = "NewATI-584:Verify ability to renew Board Vitals if the product access has expired")
	public void NewATI584_VerifyAbilityToRenewBoardVitals() throws Exception {
		logger.info("Method : NewATI584_VerifyAbilityToRenewBoardVitals Start");
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.nclex.preptab.renew.login.user.name"), PropertiesRepository.getString("newati.nclex.preptab.renew.login.pwd"));
		
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		
		log(logger, "Clicking NCLEXPREP Tab");
		homePage.clickSubTab(5);
		
		boolean verifySubTabs = nclexPrepTabPage.verifySubTabs();
		VerificationHandler.verifyTrue(verifySubTabs);
		
		boolean result=nclexPrepTabPage.verifyNclexExpiredDate(PropertiesRepository.getString("new-atitesting.nclexprep.tab.rn.product.name"));
		VerificationHandler.verifyTrue(result);
		
		boolean status=nclexPrepTabPage.verifyRenewSubscriptionPage();
		VerificationHandler.verifyTrue(status);

		log(logger, "click on continue button");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		nclexPrepTabPage.clickButton(PropertiesRepository.getString("new-atitesting.semester.payment.status.countinue"));
		
		log(logger, "click on continue button");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		nclexPrepTabPage.clickButton(PropertiesRepository.getString("new-atitesting.semester.payment.status.countinue"));
		
		log(logger, "Enter card details");
		nclexPrepTabPage.enterCardDerailsForReNewPage();
		
		log(logger, "click on submit button");
		//nclexPrepTabPage.clickButton(PropertiesRepository.getString("newati.payment.mypurchase.submit.button.loc"));
		
		
		logger.info("Method : NewATI584_VerifyAbilityToRenewBoardVitals End");
	}
}
