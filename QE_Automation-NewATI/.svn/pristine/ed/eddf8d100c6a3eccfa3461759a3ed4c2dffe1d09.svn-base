package com.automation.newati.myati.improvetab;


import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.ImproveTabPage;
import com.automation.newati.pages.LoginPage;
import com.jaca.TestAnnotations;

public class VerifyContentAreaDropDownTest extends BaseTest {
	Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private ImproveTabPage improveTabPage;
	
	@BeforeMethod
	public void VerifyLearnTabScenariosReview() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		improveTabPage = new ImproveTabPage(driver);
		
		loginPage.loginToApplication("stagefrstudent","Test123");
}
	
	@TestAnnotations(testID="NewATI1-850")
	@Test(priority=1, alwaysRun = true, enabled = true, groups = "{Regression}", description="Content Area functionality::My ATI")
	public void NewATI850_VerifyContentAreainAlphabeticalOrder() throws Exception 
	{
		log(logger, "NewATI850_VerifyContentAreainAlphabeticalOrder: Start");
		logger.info("NewATI850_VerifyContentAreainAlphabeticalOrder: Start");
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		homePage.clickTab(1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking Improve Tab");
		homePage.clickSubTab(2);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger,"verify all options in ContentArea dropdown are in alphabetical order");
		VerificationHandler.verifyTrue(improveTabPage.verifyImproveTabContentAreaDD(),"Content Area DD in Improve Tab are not matched");
		
		log(logger, "Verifying Content Area in Ascending order");
		improveTabPage.verifyImproveAssessmentsInAscendingOrder();
		
		log(logger, "Verifying Assessment name in Improve Tab");
		improveTabPage.verifyImproveAssessmentsInAscendingOrder();
		
		logger.info("NewATI850_VerifyContentAreainAlphabeticalOrder: Ends");
		log(logger, "NewATI850_VerifyContentAreainAlphabeticalOrder: Ends");
}
	@TestAnnotations(testID="NewATI1-851")
	@Test(priority=1, alwaysRun = true, enabled = true, groups = "{Regression}", description="Content Area tag functionality::My ATI")
	public void NewATI851_VerifyContentAreataginAlphabeticalOrder() throws Exception 
	{
		log(logger, "NewATI851_VerifyContentAreataginAlphabeticalOrder: Start");
		
		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);
		
		log(logger, "Clicking Improve Tab");
		homePage.clickSubTab(2);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger,"verify all options in ContentArea dropdown are in alphabetical order");
		VerificationHandler.verifyTrue(improveTabPage.verifyImproveTabContentAreaDD(),"Content Area DD in Improve Tab are not matched");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		List<String> allNameList = improveTabPage.valueAsList(PropertiesRepository.getString("new-atitesting.myatitab.improvetab.all.assessment.name"));
		
		log(logger, "NewATI851_VerifyContentAreataginAlphabeticalOrder: Ends");
	}
	
	
}
