package com.automation.newati.myati.others;

import org.apache.log4j.LogManager; 
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LearnTabPage;
import com.automation.newati.pages.LoginPage;
import com.automation.newati.pages.TestTabPage;


public class VerifyBatchtIDinProductIDTest extends BaseTest {
	Logger logger = LogManager.getLogger(this.getClass());

	private LoginPage loginPage;
	private HomePage homePage;
	private TestTabPage testTabPage;
	private LearnTabPage learnTabPage;
	
	boolean isValidteBatchID = false;
	
	@BeforeMethod
	public void verifyHomePage() throws Exception {
		loginPage = new LoginPage(driver);
		testTabPage = new TestTabPage(driver);
		homePage = new HomePage(driver);
		learnTabPage=new LearnTabPage(driver);
		
		loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name"), PropertiesRepository.getString("newati.login.password"));
	}

	@Test(priority = 1, description = "NewATI-59: Check for BatchtID in Product ID")
	public void NewATI59_VerifyBatchtIDinProductID() throws Exception {
		log(logger, "NewATI59_VerifyBatchtIDinProductID  Start");

		log(logger, "Clicking on My ATI Tab");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.clickTab(1);
		
		log(logger, "Clicking on Test Tab");
		homePage.clickButton(PropertiesRepository.getString("new-atitesting.all.tab"), 1);
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking ProductInfo Icon. ");
		learnTabPage.clickInfoIconByName(PropertiesRepository.getString("new-atitesting.homepage.myati.practiceassessment.product.info.loc"));
					

		log(logger, "Validate BatchtID in Product ID. ");
		
			isValidteBatchID = testTabPage
					.verifyBatchIdinProduct(
							"new-atitesting.homepage.myati.assessment.productid.loc",
							PropertiesRepository
									.getInt("new-atitesting.homepage.myati.assessment.batchid.index"));

			VerificationHandler.verifyFalse(isValidteBatchID,
					"BatchID is not exist in product ID");
			log(logger, "VerifyBatchtIDinProductID: End");
		
		
		log(logger, "NewATI59_VerifyBatchtIDinProductID End");
	}
}
