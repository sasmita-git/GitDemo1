package com.automation.id.smoke;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.test.BaseTest;
import com.automation.id.pages.HomePage;
import com.automation.id.pages.LoginPage;
import com.automation.id.pages.ProductsPage;
import com.jaca.TestAnnotations;

public class Smoke_HomeTest extends BaseTest {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;
	//private EditProfilePage editProfilePage;
	private HomePage homePage;
	private ProductsPage productsPage;
	
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
	//	editProfilePage = new EditProfilePage(driver);
		productsPage = new ProductsPage(driver);
	}
	
	
	/**
	 * @author kumarisagarika.t
	 * @throws Exception
	 */
	@TestAnnotations(testID="1")
	@Test(priority = 4, alwaysRun = true, enabled = true, groups={"smoke"}, description = "Smoke_HomeTest :: Verify Customize home for carp institution for DOC User")
	public void VerifyCustomizeHomeForCarpInstitutionForDOCUser() throws Exception {
		
		log(logger, "VerifyCustomizeHomeForCarpInstitutionForDOCUser Start");
		logger.info("VerifyCustomizeHomeForCarpInstitutionForDOCUser Start");

		//step-1
		loginPage.loginToApplication1(PropertiesRepository.getString("id.director.of.consortium.2095.username"),
				PropertiesRepository.getString("id.director.of.consortium.2095.password"));
		loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		
		
		//Step 1
				log(logger, "Click on Ellipses on the top right corner");
				loginPage.clickButton(PropertiesRepository.getString("id.homepage.static.menu"), 1);
				homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				
		//Step 1
				log(logger, "Verifying if Customized Home link is displayed at the top and click on it");
				VerificationHandler.verifyTrue(homePage.verifyIfCustomizedHomeLinkIsFirstAndClick());
				homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				
		//Step 1
				log(logger, "Verifying and clicking on Graduation Cohort ");
				VerificationHandler.verifyTrue(homePage.verifyAndClickUsingContains(PropertiesRepository.getString("id.home.graduation.and.course.cohorts.top.menu.loc"), 
						PropertiesRepository.getString("id.home.graduation.cohorts.top.menu.value"), true,  "Graduation/ Course Cohorts menu link"), "Unable to click Graduation/ Course Cohorts menu link");
				homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));	
     
        // Step 2
    		log(logger, "Verifying Graduation Cohort, size and Institution in Graduation Cohorts");
    		VerificationHandler.verifyTrue(homePage.verifyCourseCohortTableHeader(),"Unable to verify Graduation Cohort Table Header");
    		
    	// Step 3
    		log(logger, "Getting the cohort name which is clicked in Graduation Cohort");
    		String cohortName = homePage.clickAndGetCohortNameFromTable();
    		
    	// Step 4
    		log(logger, "Clicking on Save button in Graduation Cohort");
    		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.cohort.save.and.view.dashboard.button.loc"), true), "Unable to click on save and view dashboard button");
    		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
    		
        // Step 4
 		log(logger, "Clicking on View Dashboard button in Graduation Cohort");
 		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.cohort.view.dashboard.button.loc"), true), "Unable to click on save and view dashboard button");
 		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
 		
 		// Step 4
 		log(logger, "Veriyfing Graduation Cohort name in Dashboard");
 		VerificationHandler.verifyTrue(homePage.verifyCohortAndItsNameInDashboard(PropertiesRepository.getString("id.home.graduation.cohorts.home.page.value"), cohortName), "Unable to verify Gradudation Cohort name in dashboard");
 		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));		
		
 	// UnChecking Graduation Cohort in Customize Home Page - Start. 
 		
 	 		log(logger, "Click on Ellipses on the top right corner");
 	 		loginPage.clickButton(PropertiesRepository.getString("id.homepage.static.menu"), 1);
 	 		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
 	 		
 	 		log(logger, "Verifying if Customized Home link is displayed at the top and click on it");
 	 		VerificationHandler.verifyTrue(homePage.verifyIfCustomizedHomeLinkIsFirstAndClick());
 	 		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
 	 		
 	 		log(logger, "Reset check Graduation cohort name in Customize page");
 			VerificationHandler.verifyTrue(homePage.resetCohortName(cohortName), "Unable to reset checked cohort in customize page");
 			
 			log(logger, "Clicking on Save And View Dashboard button in Course Cohort");
 			VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.cohort.save.and.view.dashboard.button.loc"), true), "Unable to click on save and view dashboard button");
 			// UnChecking Graduation Cohort in Customize Home Page - End.
 			
 			//Course cohort selection
 			//Step 1
 					log(logger, "Click on Ellipses on the top right corner");
 					loginPage.clickButton(PropertiesRepository.getString("id.homepage.static.menu"), 1);
 					homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
 					
 		
 			//Step 1
 					log(logger, "Verifying if Customized Home link is displayed at the top and click on it");
 					VerificationHandler.verifyTrue(homePage.verifyIfCustomizedHomeLinkIsFirstAndClick());
 					homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
 					
 			//Step 1
 					log(logger, "Verifying and clicking on Course Cohort ");
 					VerificationHandler.verifyTrue(homePage.verifyAndClickUsingContains(PropertiesRepository.getString("id.home.graduation.and.course.cohorts.top.menu.loc"), 
 							PropertiesRepository.getString("id.home.course.cohorts.top.menu.value"), true,  "Graduation/ Course Cohorts menu link"), "Unable to click Graduation/ Course Cohorts menu link");
 					homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
 					
 			// Step 2
 		    		log(logger, "Verifying course Cohort, size and Institution in course Cohorts");
 		    		VerificationHandler.verifyTrue(homePage.verifyCourseCohortTableHeader(),"Unable to verify Course Cohort Table Header");
 		    		
 		        // Step 3
 		    		log(logger, "Getting the cohort name which is clicked in course Cohort");
 		    		 cohortName = homePage.clickAndGetCohortNameFromTable();
 		    		
 		    	// Step 4
 		    		log(logger, "Clicking on Save button in course Cohort");
 		    		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.cohort.save.and.view.dashboard.button.loc"), true), "Unable to click on save and view dashboard button");
 		    		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
 		    		 // Step 4
 		     		log(logger, "Clicking on View Dashboard button in Graduation Cohort");
 		     		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.cohort.view.dashboard.button.loc"), true), "Unable to click on save and view dashboard button");
 		     		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
 		     		
 		     	// Step 4
 		     		log(logger, "Veriyfing course Cohort name in Dashboard");
 		     		VerificationHandler.verifyTrue(homePage.verifyCohortAndItsNameInDashboard(PropertiesRepository.getString("id.home.course.cohorts.home.page.value"), cohortName), "Unable to verify course Cohort name in dashboard");
 		     		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
 		     		
 		     	// UnChecking Course Cohort in Customize Home Page - Start. 
 		     		
 			     	log(logger, "Click on Ellipses on the top right corner");
 			     		loginPage.clickButton(PropertiesRepository.getString("id.homepage.static.menu"), 1);
 			     		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
 			     		
 			     		log(logger, "Verifying if Customized Home link is displayed at the top and click on it");
 			     		VerificationHandler.verifyTrue(homePage.verifyIfCustomizedHomeLinkIsFirstAndClick());
 			     		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
 			     	log(logger, "Verifying and clicking on Course Cohort ");
 						VerificationHandler.verifyTrue(homePage.verifyAndClickUsingContains(PropertiesRepository.getString("id.home.graduation.and.course.cohorts.top.menu.loc"), 
 								PropertiesRepository.getString("id.home.course.cohorts.top.menu.value"), true,  "Graduation/ Course Cohorts menu link"), "Unable to click Graduation/ Course Cohorts menu link");
 						homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));	
 			     		
 			     		log(logger, "Reset check Graduation cohort name in Customize page");
 			    		VerificationHandler.verifyTrue(homePage.resetCohortName(cohortName), "Unable to reset checked cohort in customize page");
 			    		
 			    		log(logger, "Clicking on Save And View Dashboard button in Course Cohort");
 			    		VerificationHandler.verifyTrue(homePage.verifyAndClick(PropertiesRepository.getString("id.home.cohort.save.and.view.dashboard.button.loc"), true), "Unable to click on save and view dashboard button");
 			    		
 			    		log(logger, "Clicking on left navigation icon");
 			    		VerificationHandler.verifyTrue(
 			    				productsPage.verifyAndClick(PropertiesRepository.getString("id.home.left.navigation.icon.loc"), true),
 			    				"Unable to click left navigation");
 			    		log(logger, "Verifying Home Tab from Left navigation");
 			    		VerificationHandler.verifyTrue(homePage.verifyLeftNavigationText("id.home.left.navigation.menu.list.loc", "dashboard", true), "Unable to verify Home Link");
 			    		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
 			   // UnChecking Course Cohort in Customize Home Page - End.
 			    		
 			    		//Clicking on manage button of cohort card	
 			    		log(logger, "Clicking on First Cohort Manage button");
 			    		homePage.clickGraduationCohortFirstManageButton();
 			    		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
 			    		Thread.sleep(2000);
 			    		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader")); 
 			   //Verifying Highlights page cards
 			    		log(logger , "Verifying highlights page starts");
 			    		VerificationHandler.verifyTrue(homePage.verifyHighlightPageCards());
 			   //Verify Manage Products tab
 			    		log(logger, "Verify Manage Products Tab in Products Page");
 			    		VerificationHandler.verifyTrue(loginPage.isElementDisplayed("id.home.graduation.and.course.cohorts.top.menu.loc",3));
 			    //Navigate to manage products page
 			    		log(logger , "Navigating & verifying manage products page");
 			    		loginPage.clickElement("id.home.graduation.and.course.cohorts.top.menu.loc",1);
 			    		homePage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
 			  //Verifying proctored assessment,practice assessment,Tutorials sub-tab is displaying under manage products page
 			          log(logger , "verifying proctored assessment,practice assessment,Tutorials sub-tab is displaying under manage products page");
 			          VerificationHandler.verifyTrue(homePage.VerifySubTabs()); 
	}

}
