package com.automation.id.pages;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.TextHandler;

public class TutorialPage extends IDBasePage {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;

	public TutorialPage(WebDriver webDriver) {
		super(webDriver);
		textHandler = new TextHandler(driver);
		loginPage = new LoginPage(driver);
	}

	/**
	 * @author Sanapati.Srinu
	 * @param assessmentname
	 * @throws DriverException
	 */
	public void clickOnAccessModuleButton(String tutorialName) throws DriverException {
		try {
			waitForAwhile(20000);
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			List<WebElement> tutorialNames = baseHandler
					.findElements(PropertiesRepository.getString("id.tutorial.name.loc"));

			if (CollectionUtils.isNotEmpty(tutorialNames)) {
				for (int i = 0; i < tutorialNames.size(); i = i + 2) {
					if (tutorialName.trim().equals(tutorialNames.get(i).getText().trim())) {
						List<WebElement> previewLocators = baseHandler
								.findElements(PropertiesRepository.getString("id.tutorial.access.modules.loc"));
						if (CollectionUtils.isNotEmpty(previewLocators)) {
							previewLocators.get(i).click();
							waitForAwhile(20000);
							waitUntillLoadingImageIsDisappeared(
									PropertiesRepository.getString("id.common.page.loader"));
							break;
						}
					}
				}

			}

		} catch (Exception e) {
			logger.info("Unable to clickOnPreviewAssessmentButton");
			log(logger, "Unable to clickOnPreviewAssessmentButton");
			throw new DriverException("Unable to clickOnPreviewAssessmentButton", e);
		}

	}
	/**
	 * 
	 * @param loc
	 * @param size
	 * @return
	 * @throws DriverException
	 */

	public boolean clickButtonFromListForSTT(String loc, int size) throws DriverException {
		logger.info("clickButtonFromListForSTT Start");
		boolean flag = false;
		try {
			windowHandler.switchToLatestWindow();
			List<WebElement> button = baseHandler.findElements(PropertiesRepository.getString(loc));
			if (CollectionUtils.isNotEmpty(button) && button.get(0).isDisplayed()) {
//				System.out.println("button.get(0).isDisplayed()"+button.get(0).isDisplayed());
				button.get(size).click();
				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader")); 
				flag = true;
			}

		} catch (Exception e) {
			logger.info("Unable to clickButtonFromListForSTT");
			log(logger, "Unable to clickButtonFromListForSTT");
			throw new DriverException("Unable to clickButtonFromListForSTT", e);
		}
		logger.info("clickButtonFromListForSTT End flag --> " + flag);
		return flag;
	}

	
	/**
	 * @author Sanapati.Srinu
	 * @param assessmentname
	 * @throws DriverException
	 */
	public void clickOnAccessModuleButtonWithPreview(String tutorialName) throws DriverException {
		try {
			waitForAwhile(20000);
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			List<WebElement> tutorialNames = baseHandler
					.findElements(PropertiesRepository.getString("id.tutorial.name.loc"));

			if (CollectionUtils.isNotEmpty(tutorialNames)) {
				for (int i = 0; i < tutorialNames.size(); i = i + 2) {
					if (tutorialName.trim().equals(tutorialNames.get(i).getText().trim())) {
						List<WebElement> previewLocators = baseHandler
								.findElements(PropertiesRepository.getString("id.tutorial.access.modules.loc"));
						if (CollectionUtils.isNotEmpty(previewLocators)) {
							previewLocators.get(i).click();
							waitForAwhile(20000);
							waitUntillLoadingImageIsDisappeared(
									PropertiesRepository.getString("id.common.page.loader"));
						}
					}
				}

			}

		} catch (Exception e) {
			logger.info("Unable to clickOnPreviewAssessmentButton");
			log(logger, "Unable to clickOnPreviewAssessmentButton");
			throw new DriverException("Unable to clickOnPreviewAssessmentButton", e);
		}
	}

	public void waitForAwhile(int milliSeconds) {
		try {
			Thread.sleep(milliSeconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean clickOnStartAssessment() throws DriverException {
		boolean flag = false;
		try {

			windowHandler.switchToMainWindow();
			windowHandler.switchToLatestWindow();
			List<WebElement> startEssessmentNames = baseHandler
					.findElements(PropertiesRepository.getString("id.practice.start.assessment.loc"));
			List<WebElement> endAssessmentNames = baseHandler
					.findElements(PropertiesRepository.getString("id.practice.start.assessment.loc"));
			if (CollectionUtils.isNotEmpty(startEssessmentNames) && CollectionUtils.isNotEmpty(endAssessmentNames)) {
				flag = true;
				startEssessmentNames.get(0).click();
				List<WebElement> proceedButton = baseHandler.findElements("#btnProceed");
				proceedButton.get(0).click();
				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			}

		} catch (Exception e) {
			logger.info("Unable to clickOnStartAssessment");
			log(logger, "Unable to clickOnStartAssessment");
			throw new DriverException("Unable to clickOnStartAssessment", e);
		}
		return flag;

	}

	public void switchToAssessment() throws DriverException {
		try {
			windowHandler.switchToFrame("assessmentFrame");
		} catch (Exception e) {

			logger.info("Unable to switchToAssessment");
			log(logger, "Unable to switchToAssessment");
			throw new DriverException("Unable to switchToAssessment", e);
		}
	}
	
	public void switchToAssessment(String str) throws DriverException {
		try {
			windowHandler.switchToFrame(str);
		} catch (Exception e) {

			logger.info("Unable to switchToAssessment");
			log(logger, "Unable to switchToAssessment");
			throw new DriverException("Unable to switchToAssessment", e);
		}
	}

	public boolean verifyObjectsOnTheBVLTIPage() throws DriverException {

		boolean flag = false;
		try {
			logger.info("switchToLTIFrame  start");
			try {
				WebElement frameElement = driver.findElement(By.cssSelector("#LTILaunchFrame"));
				driver.switchTo().frame(frameElement);
				waitForAwhile(1000);
				
				WebElement frameElement1 = driver.findElement(By.cssSelector("#LTIActivityFrame"));
				driver.switchTo().frame(frameElement1);
				waitForAwhile(1000);
			} catch (Exception e) {
				throw new DriverException("unable to swith to frame");

			}
			logger.info("switchToCardShadowFrame  end");
			List<WebElement> goButtonLTI = windowHandler.findElements(PropertiesRepository.getString("id.product.tutorial.boardvitas.go.button"));
//			System.out.println("Size: "+goButtonLTI.size());
			if (CollectionUtils.isNotEmpty(goButtonLTI)&&(goButtonLTI.size()>=2)) {
				flag = true;
			}

		} catch (Exception e) {
			logger.info("Unable to clickOnStartAssessment");
			log(logger, "Unable to clickOnStartAssessment");
			throw new DriverException("Unable to clickOnStartAssessment", e);
		}
		return flag;
	}
	

	public boolean isElementPresent(String loc) throws DriverException {

		boolean flag = false;
		try {
			windowHandler.switchToLatestWindow();
			List<WebElement> button = baseHandler.findElements(PropertiesRepository.getString(loc));
			if (CollectionUtils.isNotEmpty(button) && button.get(0).isDisplayed()) {
				flag = true;
			}

		} catch (Exception e) {
			logger.info("Unable to find the Element");
			log(logger, "Unable to find the Element");
			throw new DriverException("Unable to find the Element", e);

		}
		return flag;
	}

	/**
	 * 
	 * @param loc
	 * @param size
	 * @return
	 * @throws DriverException
	 */

	public void clickButtonFromList(String loc, int size) throws DriverException {

		try {
			windowHandler.switchToLatestWindow();
			List<WebElement> button = baseHandler.findElements(PropertiesRepository.getString(loc));
			if (CollectionUtils.isNotEmpty(button) && button.get(0).isDisplayed()) {
				button.get(size).click();
				waitForAwhile(1000);
				windowHandler.switchToLatestWindow();
				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));  
				waitForAwhile(1000);
			}

		} catch (Exception e) {
			logger.info("Unable to click From List");
			log(logger, "Unable to click From List");
			throw new DriverException("Unable to click From List", e);

		}

	}

	/**
	 * 
	 * @param loc
	 * @param size
	 * @return
	 * @throws DriverException
	 */

	public String readTextFromList(String loc, int size) throws DriverException {
		String name = null;
		try {
			List<WebElement> button = baseHandler.findElements(loc);
			if (CollectionUtils.isNotEmpty(button) && button.get(0).isDisplayed()) {
				name = button.get(size).getText();
			}

		} catch (Exception e) {
			logger.info("Unable to click From List");
			log(logger, "Unable to click From List");
			throw new DriverException("Unable to click From List", e);

		}
		return name;

	}

	public boolean verifyBeginScenrioAndOptimalDecisions() throws DriverException, InterruptedException {
		boolean flag = false;
		windowHandler.switchToLatestWindow();
		// waitForAwhile(15000);
		try {
			String optimalDecisionText = readTextFromList(
					PropertiesRepository.getString("id.tutorial.optimal.decisions.text.loc"), 0);
			String beginScenarioText = readTextFromList(
					PropertiesRepository.getString("id.tutorial.begin.scenario.text.loc"), 0);

			if (StringUtils.isNotEmpty(beginScenarioText) && StringUtils.isNotEmpty(optimalDecisionText)
					&& "Begin Scenario".contains(beginScenarioText.trim())
					&& "Optimal Decisions".contains(optimalDecisionText.trim())) {
				flag = true;
			}
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to verify Begin ScenrioAnd Optimal Decisions");
			log(logger, "Unable to verify Begin ScenrioAnd Optimal Decisions");
			throw new DriverException("Unable to verify Begin ScenrioAnd Optimal Decisions", e);
		}
		return flag;

	}

	public void clickButtonToLaunchCourse() throws DriverException {
		try {

			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			windowHandler.switchToFrame("ScormContent");
			clickButtonFromList("id.tutorial.launch.lession.button.loc", 0);

		} catch (Exception e) {
			logger.info("Unable to click Button To Launch Course");
			log(logger, "Unable to click Button To Launch Course");
			throw new DriverException("Unable to click Button To Launch Course", e);
		}

	}

	public void clicOnCloseButton(String loc, int size) throws DriverException {
		try {
			waitForAwhile(10000);
			List<WebElement> button = baseHandler.findElements(PropertiesRepository.getString(loc));
			if (CollectionUtils.isNotEmpty(button)) {
				button.get(size).click();
				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			}

		} catch (Exception e) {
			logger.info("Unable to click From List");
			log(logger, "Unable to click From List");
			throw new DriverException("Unable to click From List", e);

		}
	}

	/*
	 * @author siddharth.roy
	 * 
	 * @return boolean
	 * 
	 * @throws Exception
	 */
	public boolean verifyPreviewButton() throws Exception {
		logger.info("Method: verifyPreviewButton start");
		boolean flag = false;
		try {
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("faculty.stage.buffer.loc"));
			// Get Table
			List<WebElement> tableElement = baseHandler.findElements(
					"table[id*='ctl00_contentPlaceHolderBody_ucProductsTutorials_gvProductsTutorialAssessment_'] tr");
			if (CollectionUtils.isNotEmpty(tableElement) && tableElement.size() > 0) {
				List<WebElement> allColumns = tableElement.get(0).findElements(By.cssSelector(PropertiesRepository
						.getString("id.portal.products.tutorials.simulation.quizbank.access.modules.loc")));
				if (CollectionUtils.isNotEmpty(allColumns)) {
					// Preview Module verification.
					if (allColumns.get(0).findElement(By.cssSelector("input")) != null) {
						// Enable/ Disable
						if (allColumns.get(1).findElement(By.cssSelector("input")) != null) {
							// Enable/ Disable Rationale
							if (allColumns.get(2).findElement(By.cssSelector("input")) != null) {
								// Enable/ Disable Optimal Decisions
								if (allColumns.get(3).findElement(By.cssSelector("input")) != null) {
									// Schedule Assignment.
									if (allColumns.get(4).findElement(By.cssSelector("input")) != null) {
										flag = true;
									}
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to  verify Preview Button");
			log(logger, "Unable to  verify Preview Button");
			throw new DriverException("Unable to  verify Preview Button", e);
		}
		logger.info("verifyPreviewButton--->flag  " + flag);
		return flag;
	}

	/**
	 * This method is used to verify Access Module table headers
	 * 
	 * @param quizName
	 * @param headersList
	 * @return boolean
	 * @throws DriverException
	 */
	public int clickAndExpandAccessModulesSection(String quizName) throws DriverException {
		int selectedIndex = 0;
		logger.info("Method: clickAndExpandAccessModulesSection Starts");
		try {
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			loginPage.switchToCardShadowFrame();
			List<WebElement> moduleNameList = driver.findElements(By.xpath(
					"//table[3]/tbody/tr[2]/td/div[2]/div/table/tbody/tr[not(contains(@class, 'products_tablecontent'))]/td[1]"));
			List<WebElement> imgList = baseHandler
					.findElements(PropertiesRepository.getString("id.portal.product.tab.access.module.img"));
			for (int i = 0; i < moduleNameList.size(); i++) {
				if (quizName.trim().equals(moduleNameList.get(i).getText())) {
					 /*((JavascriptExecutor)
					 driver).executeScript("arguments[0].scrollIntoView(true);",
							 imgList.get(i));*/
					imgList.get(i).click();
					waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
					waitForAwhile(20000);
					selectedIndex = i;
					break;
				}
			}
			windowHandler.switchToLatestWindow();
			waitForAwhile(5000);
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to Expand Access Modules Section");
			log(logger, "Unable to Expand Access Modules Section");
			throw new DriverException("Unable to Expand Access Modules Section", e);
		}
		logger.info("Method: clickAndExpandAccessModulesSection End ");
		return selectedIndex;
	}

	/**/
	/**
	 * This method is used to click On Image By Action Class
	 * 
	 * @param lndex
	 * @param waitFor
	 * @throws DriverException
	 */
	public boolean clickOnPreviewModuleImg(int lndex, int waitFor) throws DriverException {
		logger.info("Method: clickOnPreviewModuleImg Start");
		boolean flag = false;
		try {
			loginPage.switchToCardShadowFrame();
			List<WebElement> previewModuleImageList = driver.findElements(By.xpath(
					"//table[3]/tbody/tr[2]/td/div[2]/div/table/tbody/tr[contains(@class, 'products_tablecontent')]/td[1]/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[3]"));
					//"//table[3]/tbody/tr[2]/td/div[2]/div/table/tbody/tr[contains(@class, 'products_tablecontent')]/td[1]/table/tbody/tr[2]/td/div/table[contains(@id,'ctl00_contentPlaceHolderBody_ucProductsTutorials_gvProductsTutorialAssessment_ctl07_gvModules')]/tbody/tr[1]/td[3]"));
			if (CollectionUtils.isNotEmpty(previewModuleImageList)) {
				WebElement webElement = previewModuleImageList.get(lndex);
				if (webElement != null) {
					Actions action = new Actions(driver);
					action.moveToElement(webElement).click().build().perform();
					windowHandler.switchToLatestWindow();
					waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
					flag = true;
//					waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
				}

			}
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to clickOnPreviewModuleImg");
			log(logger, "Unable to clickOnPreviewModuleImg");
			throw new DriverException("Unable to clickOnPreviewModuleImg", e);
		}
		logger.info("clickOnPreviewModuleImg end flag --> " + flag);
		return flag;
	}


	/**
	 * @author Sanapati.Srinu
	 * @param loc
	 * @throws DriverException
	 *//*
	public void clickOnSkillModuleStartAssessmentButton(String loc) throws DriverException {

		logger.info("clickOnSkillModuleStartAssessmentButton --- Start");
		windowHandler.switchToLatestWindow();
		try {
			WebElement findElement = baseHandler.findElement(PropertiesRepository.getString(loc));
			if (findElement != null) {
				findElement.click();
				waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
				waitForAwhile(8000);
			}
		} catch (Exception e) {
			logger.info("Unable to verify SkillModule Start Assessment Button");
			log(logger, "Unable to verify SkillModule Start Assessment Button");
			throw new DriverException("Unable to verify SkillModule Start Assessment Button", e);
		}
		logger.info("clickOnSkillModuleStartAssessmentButton --- End");
	}
*/
	
	/**
	 * @author Sanapati.Srinu
	 * @param loc
	 * @throws DriverException
	 */
	public boolean clickOnSkillModuleStartAssessmentButton(String loc) throws DriverException {
		logger.info("clickOnSkillModuleStartAssessmentButton --- Start");
		boolean flag = false;
		try {
			windowHandler.switchToLatestWindow();
			List<WebElement> findElement = baseHandler.findElements(PropertiesRepository.getString(loc));
			if (findElement != null) {
				findElement.get(0).click();
				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				flag = true;
			}
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to verify SkillModule Start Assessment Button");
			log(logger, "Unable to verify SkillModule Start Assessment Button");
			throw new DriverException("Unable to verify SkillModule Start Assessment Button", e);
		}
		logger.info("clickOnSkillModuleStartAssessmentButton --- End flag --> " + flag);
		return flag;
	}
	public void goToMainWindow() {

		windowHandler.switchToMainWindow();
		waitForAwhile(20000);
	}

	public void navigateToParentWindow() {
		windowHandler.switchToLatestWindow();
		waitForAwhile(3000);
	}

	/**
	 * @author Sanapati.Srinu
	 * @param loc
	 * @param index
	 * @throws Exception
	 */
	public void clickOnCloseButton(String loc, int index) throws Exception {
		logger.info("clickButtonFromList  --- Start");
		waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		waitForAwhile(3000);
		try {
			if (baseHandler.isDisplayed(PropertiesRepository.getString(loc))) {
				List<WebElement> webElements = baseHandler.findElements(PropertiesRepository.getString(loc));
				if (CollectionUtils.isNotEmpty(webElements)) {
					webElements.get(index).click();
				}
			}
		} catch (Exception e) {
			throw new DriverException("unable to click the button", e);
		}
		logger.info("clickButtonFromList  --- End");

	}
	
	
	public boolean clickLTICloseX() throws DriverException {
		logger.info("clickLTICloseBtn Start");
		boolean flag = false;
		try {
			windowHandler.switchToLatestWindow();
			driver.close();
			waitForAwhile(1000);
			windowHandler.switchToLatestWindow();
			waitForAwhile(1000);
			flag = true;
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to clickLTICloseBtn");
			log(logger, "Unable to clickLTICloseBtn");
			throw new DriverException("Unable to clickLTICloseBtn", e);
		}
		logger.info("Unable to clickLTICloseBtn End flag --> " + flag);
		return flag;
	}

	/**
	 * @author Sanapati.Srinu
	 * @param loc
	 * @param index
	 * @throws Exception
	 */
	public void clickOnCloseButtonWithSwitchToAssessment(String loc, int index) throws Exception {
		logger.info("clickOnCloseButtonWithSwitchToAssessment  --- Start");
		waitUntillLoadingImageIsDisappeared("asmt.pleasewait.bufferLoc");
		try {
			switchToAssessment();
			if (baseHandler.isDisplayed("button[class='mat-button']")) {
				List<WebElement> webElements = baseHandler.findElements("button[class='mat-button']");
				if (CollectionUtils.isNotEmpty(webElements)) {
					webElements.get(index).click();
				}
			} else {
				logger.info("Locator is not displayed in clickOnCloseButtonWithSwitchToAssessment");
			}
			//
			// closing Yes/ No Popup. 
			List<WebElement> yesNoElement = baseHandler.findElements("div[class='button-row'] button");
			if (CollectionUtils.isNotEmpty(yesNoElement)) {
				yesNoElement.get(index).click();
			}
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("unable to click the button clickOnCloseButtonWithSwitchToAssessment" );
			log(logger, "unable to click the button clickOnCloseButtonWithSwitchToAssessment" );
    		throw new DriverException("unable to click the button clickOnCloseButtonWithSwitchToAssessment" , e); 
		}
		logger.info("clickButtonFromList  --- End");

	}
	
	public void switchToParticularFrame() throws Exception {
		log(logger, "switchToParticularFrame Start");
		try {
			windowHandler.switchToFrame("frBack");
		} catch (Exception e) {
			logger.info("Unable to ");
			log(logger, "Unable to ");
			throw new DriverException("Unable to ", e);
		}
		log(logger, "switchToParticularFrame End");
	}

	public void clickYesOrNoButton() throws Exception {
		log(logger, "clickYesOrNoButton Start");
		try {
			windowHandler.switchToLatestWindow();
			List<WebElement> closeBtnElement = baseHandler
					.findElements("div[class='hotspot widget sbobj'] .kineticjs-content canvas");
			if (CollectionUtils.isNotEmpty(closeBtnElement)) {
				closeBtnElement.get(3).click();
			}
			// windowHandler.switchToFrame("frBack");
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to clickYesOrNoButton");
			log(logger, "Unable to clickYesOrNoButton");
			throw new DriverException("Unable to clickYesOrNoButton", e);
		}

		log(logger, "clickYesOrNoButton End");
	}

	public void switchToTeasSmartPrepFrame() throws Exception {
		log(logger, "switchToTeasFrame Start");
		try {
			windowHandler.switchToFrame("iframeOpenPage");
		} catch (Exception e) {
			logger.info("Unable to ");
			log(logger, "Unable to ");
			throw new DriverException("Unable to ", e);
		}

		log(logger, "switchToTeasFrame End");
	}

	/*public boolean verifyATITEASSmartPrepOptions() throws DriverException, InterruptedException {
		boolean flag = false;
		windowHandler.switchToLatestWindow();
		waitForAwhile(3000);
		//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='openpage-frame']")));
		// waitForAwhile(15000);
		try {

			String PreTestText = readTextFromList(PropertiesRepository.getString("id.Teas.PreTest.Locator"), 0);
			String LessonText = readTextFromList(PropertiesRepository.getString("id.Teas.Lesson.Locator"), 0);
			String PostTestText = readTextFromList(PropertiesRepository.getString("id.Teas.PostTest.Locator"), 0);

			if (StringUtils.isNotEmpty(PreTestText) && StringUtils.isNotEmpty(LessonText)
					&& StringUtils.isNotEmpty(PostTestText) && "Pretest".equals(PreTestText.trim())
					&& "Lesson".equals(LessonText.trim()) && "Posttest".equals(PostTestText.trim())
					&& driver.findElement(By.cssSelector(".context-icon.inline-block.vert-align")).isDisplayed()) {
				flag = true;
			}
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to verify PostTest Option");
			log(logger, "Unable to verify Lesson option");
			log(logger, "Unable to verify PreTest option");
			throw new DriverException("Unable to verify Pretest post test and lesson button", e);
		}
		return flag;

	}*/

	/**
	 * Method used to click on TEAS Begin Button
	 * 
	 * @return
	 * @throws DriverException
	 */
	public boolean clickTeasBeginButton() throws DriverException {
		boolean flag = false;
		try {

			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			windowHandler.switchToFrame("iframeOpenPage");

			List<WebElement> startTeasLesson = baseHandler
					.findElements(PropertiesRepository.getString("id.portal.product.tab.tutorial.teassmart.lesson"));
			if (CollectionUtils.isNotEmpty(startTeasLesson)) {
				startTeasLesson.get(0).click();
				waitForAwhile(7000);
				flag = true;
				/*List<WebElement> proceedButton = baseHandler.findElements("#startTest");
				if (CollectionUtils.isNotEmpty(proceedButton)) {
					proceedButton.get(0).click();
					flag = true;
				}*/
			}
		} catch (Exception e) {
			logger.info("Unable to click Button To Launch Course");
			log(logger, "Unable to click Button To Launch Course");
			throw new DriverException("Unable to click Button To Launch Course", e);
		}
		return flag;
	}

	/**
	 * Method used to click on TEAS Close Button
	 * 
	 * @param loc
	 * @param index
	 * @throws Exception
	 */
	public void clickTeasCloseButton(String loc, int index) throws Exception {
		logger.info("clickButtonFromList  --- Start");
		windowHandler.switchToLatestWindow();
//		waitForAwhile(2000);
		try {
			List<WebElement> close = baseHandler.findElements(PropertiesRepository.getString("Id.TEAS.Close.Loc"));
			if (CollectionUtils.isNotEmpty(close)) {
				close.get(0).click();
				waitForAwhile(1000);
			}
		} catch (Exception e) {
			throw new DriverException("unable to click the button", e);
		}
		logger.info("clickButtonFromList  --- End");
	}
	
	/**
	 * Used to verify message
	 * 
	 * @author prasanna.gogineni
	 * @param locator
	 * @throws Exception
	 */
	public boolean verifySTTMessageWithSwitchToAssessment(String locator, int index, String value) throws DriverException {
		logger.info("verifySTTMessageWithSwitchToAssessment Start ");
		logger.info("Locator value --> " + locator);
		logger.info("index value --> " + index);
		logger.info("value --> " + value);
		boolean flag = false;
		try {
			switchToAssessment();
			List<WebElement> element = baseHandler.findElements(locator);
//			System.out.println(element);
			if (CollectionUtils.isNotEmpty(element) && element.size() > 0) {
				if (element.get(index).getText().trim().contains(value)) {
					flag = true;
				}
			} else {
				logger.info("Unable to find elements for message verification");
			}
			driver.close();
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to verifySTTMessageWithSwitchToAssessment");
			log(logger, "Unable to verifySTTMessageWithSwitchToAssessment");
			throw new DriverException("Unable to verifySTTMessageWithSwitchToAssessment", e);
		}
		logger.info("verifySTTMessageWithSwitchToAssessment End flag -->" + flag);
		return flag;
	}
	
	/**
	 * Used to verify message
	 * 
	 * @author Girish.M
	 * @param locator
	 * @throws Exception
	 */
	public boolean verifyRLMessageWithSwitchToScorm(String locator, int index, String value) throws DriverException {
		logger.info("verifyRLMessageWithSwitchToScorm Start ");
		logger.info("Locator value --> " + locator);
		logger.info("index value --> " + index);
		logger.info("value --> " + value);
		boolean flag = false;
		try {
			windowHandler.switchToLatestWindow();
			waitForAwhile(1000);
			logger.info("switchToScormFrame start");
			switchToAssessment("contentFrame");
			waitForAwhile(1000);
			List<WebElement> element = baseHandler.findElements(locator);
//			System.out.println(element);
			if (CollectionUtils.isNotEmpty(element) && element.size() > 0) {
				if (element.get(index).getText().trim().contains(value)) {
					flag = true;
				}
			} else {
				logger.info("Unable to find elements for message verification");
			}
			driver.close();
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to verifyRLMessageWithSwitchToScorm");
			log(logger, "Unable to verifyRLMessageWithSwitchToScorm");
			throw new DriverException("Unable to verifyRLMessageWithSwitchToScorm", e);
		}
		logger.info("verifyRLMessageWithSwitchToScorm End flag -->" + flag);
		return flag;
	}
	
	/**
	 * Used to verify message
	 * 
	 * @author prasanna.gogineni
	 * @param locator
	 * @throws Exception
	 */
	public boolean verifyMessageWithSwitchToAssessment(String locator, int index, String value) throws DriverException {
		logger.info("verifyMessageWithSwitchToAssessment Start ");
		logger.info("Locator value --> " + locator);
		logger.info("index value --> " + index);
		logger.info("value --> " + value);
		boolean flag = false;
		try {
			switchToAssessment();
			List<WebElement> element = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(element) && element.size() > 0) {
				if (value.equalsIgnoreCase(element.get(index).getText().trim())) {
					flag = true;
				}
			} else {
				logger.info("Unable to find elements for message verification");
			}
			driver.close();
			windowHandler.switchToLatestWindow();
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to verifyMessageWithSwitchToAssessment");
			log(logger, "Unable to verifyMessageWithSwitchToAssessment");
			throw new DriverException("Unable to verifyMessageWithSwitchToAssessment", e);
		}
		logger.info("verifyMessageWithSwitchToAssessment End flag -->" + flag);
		return flag;
	}

}
