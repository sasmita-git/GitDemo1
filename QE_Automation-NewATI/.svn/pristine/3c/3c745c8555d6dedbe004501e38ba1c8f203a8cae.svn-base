package com.automation.newati.learntab;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.WindowHandler;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.newati.pages.HelpPage;
import com.automation.newati.pages.HomePage;
import com.automation.newati.pages.LoginPage;

public class VerifyActiveLearningTemplate extends BaseTest {
	Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	private HomePage homePage;
	private HelpPage helppage;
	private WindowHandler windowhandler;


	@BeforeMethod
	public void verifyHomePage() throws Exception {
		
	loginPage = new LoginPage(driver);
	helppage=new HelpPage(driver);
	homePage=new HomePage(driver);
	windowhandler= new WindowHandler(driver);
	
	loginPage.loginToApplication(PropertiesRepository.getString("newati.login.user.name"), PropertiesRepository.getString("newati.login.password"));
}
	
	@Test(priority = 1, alwaysRun = true, enabled = true, description = "NewATI-9:Verify availability and functionality of 'Active Learning Templete'")
	
	public void NewATI9_VerifyActiveLearningTemplate() throws DriverException, Exception {
		log(logger, "NewATI9_VerifyActiveLearningTemplate Start");
		
		homePage.waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		log(logger, "Clicking MyATI Tab");
		homePage.clickTab(1);
		
		log(logger,"clicking on Active Learning Template Link");
		helppage.clickButton(PropertiesRepository.getString("new-atitesting.myatitab.learntab.active.learning.template"));
		
		log(logger, "clicking on student instructions link");
		homePage.click(PropertiesRepository.getString("new-atitesting.myatitab.learntab.student.instructions"));
		
		windowhandler.switchToLatestWindow();
		
		log(logger, "NewATI-36: Verify availability and functionality of active learning template End");
}
}