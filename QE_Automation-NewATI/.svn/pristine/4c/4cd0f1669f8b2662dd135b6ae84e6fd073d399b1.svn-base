package com.automation.newati.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.TextHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;

public class TutorialPage4 extends TutorialPage5 {

	private Logger logger = LogManager.getLogger(this.getClass());
	public String actualText = "";
	public BaseHandler baseHandler;
	private WindowHandler windowHandler;
	private TextHandler textHandler;
	
	public TutorialPage4(WebDriver webDriver) {
		super(webDriver);
		baseHandler = new BaseHandler(driver);
		textHandler = new TextHandler(driver);
		textHandler = new TextHandler(driver);
		windowHandler = new WindowHandler(driver);
	}

	public boolean selectCardFrontBasedOnModuleName(String assessmentName)
			throws Exception {
		logger.info("Method: selectCardFrontBasedOnModuleName Start");
		boolean flag = false;
		try {

			List<WebElement> moduleList = baseHandler
					.findElements(".flipper section[class='card front tutorial']");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					WebElement element = moduleList.get(i).findElement(By.cssSelector("section div[class='description']"));
					WebElement elementToFind = moduleList.get(i);
					if(element != null ) {
						if (assessmentName.equalsIgnoreCase(element.getText())) {
							if(elementToFind != null) {
								((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementToFind);
								elementToFind.findElement(By.cssSelector("nav a[class='button primary-button cardflip focus-element-flag']")).click();
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								flag=true;
								break;
							}
						}
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to select Card Front Based On Module Name");
			throw new Exception(
					"Unable to select Card Front Based On Module Name");
		}
		logger.info("Method: selectCardFrontBasedOnModuleName End --> " + flag);
		return flag;
	
	}

	/**
	 * Method is used to select card front based on name and click on module and
	 * verify below details.
	 * 
	 * Name Product ID Source Added
	 * 
	 * @author siddharth.roy
	 * @param assessmentName
	 * @throws DriverException
	 */
	public boolean selectCardFrontBasedOnModuleNameSkillsModule(String assessmentName)
			throws Exception {
		logger.info("Method: selectCardFrontBasedOnModuleNameSkillsModule Start");
		boolean flag = false;
		try {

			List<WebElement> moduleList = baseHandler
					.findElements(".flipper section[class='card front tutorial']");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					WebElement element = moduleList.get(i).findElement(By.cssSelector("section div[class='description']"));
					WebElement elementToFind = moduleList.get(i);
					if(element != null ) {
						if (assessmentName.equalsIgnoreCase(element.getText())) {
							if(elementToFind != null) {
								elementToFind.findElement(By.cssSelector("nav a[class='button primary-button cardflip focus-element-flag']")).click();
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								flag=true;
								break;
							}
						}
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to selectCardFrontBasedOnModuleNameSkillsModule");
			throw new Exception(
					"Unable to selectCardFrontBasedOnModuleNameSkillsModule");
		}
		logger.info("Method: selectCardFrontBasedOnModuleNameSkillsModule End --> " + flag);
		return flag;
	}
	
	/**
	 * Method is used to select card front based on name and click on module and
	 * verify below details.
	 * 
	 * Name Product ID Source Added
	 * 
	 * @author siddharth.roy
	 * @param assessmentName
	 * @throws DriverException
	 */
	public boolean verifyCardFrontBasedOnModuleName(String assessmentName)
			throws Exception {
		logger.info("Method: verifyCardFrontBasedOnModuleName Start");
		boolean flag = false;
		try {

			List<WebElement> moduleList = baseHandler
					.findElements(".flipper section[class='card front tutorial']");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					WebElement element = moduleList.get(i).findElement(By.cssSelector("section div[class='description']"));
					WebElement elementToFind = moduleList.get(i);
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementToFind);
					if(element != null ) {
						if (assessmentName.equalsIgnoreCase(element.getText())) {
							if(elementToFind != null) {
								flag=true;
								break;
							}
						}
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verify Card Front Based On Module Name");
			throw new Exception(
					"Unable to verify Card Front Based On Module Name");
		}
		logger.info("Method: verifyCardFrontBasedOnModuleName End --> " + flag);
		return flag;
	}
	
	/**
	 * Method is used to verify All Begin Button in Skills Module 2.0 Card Back.
	 * 
	 * Begin Test - Pre Test Begin Lesson Begin Test - Post Test
	 * 
	 * @author siddharth.roy
	 * @return boolean
	 * @throws Exception new-atitesting.learntab.tutorial.skills.module2.card.back.name.value
	 */
	public boolean verifyAllBeginButtonInCardBackTutorialForSkillsModule() throws Exception {
		waitUntillBufferInvisible(PropertiesRepository
				.getString("new-atitesting.peasewait.bufferLoc"));
		logger.info("Method: verifyAllBeginButtonInCardBackTutorialForSkillsModule Starts"); 
		boolean flag = false;
		try {
			
			windowHandler.switchToLatestWindow();
			baseHandler
					.waitToBeDisplayed(PropertiesRepository
							.getString("new-atitesting.learntab.tutorial.skills.module2.card.back.header.loc"));
			if (baseHandler
					.isDisplayed(baseHandler.findElement(PropertiesRepository
							.getString("new-atitesting.learntab.tutorial.skills.module2.card.back.header.loc")))) {
				if ("Skills Modules 2.0 (30)"
						.equalsIgnoreCase(
								baseHandler
										.findElement(
												PropertiesRepository
														.getString("new-atitesting.learntab.tutorial.skills.module2.card.back.header.loc"))
										.getText())) {
					List<WebElement> allBeginButtonLiElement = baseHandler
							.findElements(PropertiesRepository
									.getString("new-atitesting.learntab.tutorial.skills.module2.all.card.front.button"));
					if (CollectionUtils.isNotEmpty(allBeginButtonLiElement)) {
						int size = allBeginButtonLiElement.size();
						for (int index = 0; index < size; index++) {
							List<WebElement> beginLessonEle = allBeginButtonLiElement
									.get(index)
									.findElements(
											By.cssSelector(PropertiesRepository
													.getString("new-atitesting.learntab.tutorial.skills.module2.card.front.begin.lesson.button")));
							if(CollectionUtils.isNotEmpty(beginLessonEle)) {
								String beginLesson = beginLessonEle.get(0)
										.getText().replace("\n", "")
										.replace("\r", "");
								if ("BeginLesson".equalsIgnoreCase(beginLesson)) {
									flag = true;
								} else {
									flag = false;
									break;
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verifyAllBeginButtonInCardBackTutorialForSkillsModule");
			throw new DriverException(
					"Unable to verifyAllBeginButtonInCardBackTutorialForSkillsModule", e);
		}
		logger.info("Method: verifyAllBeginButtonInCardBackTutorialForSkillsModule End flag --> "
				+ flag);
		return flag;
	}
	
	/**
	 * Method is used to verify All Begin Button in Skills Module 2.0 Card Back.
	 * 
	 * Begin Test - Pre Test Begin Lesson Begin Test - Post Test
	 * 
	 * @author siddharth.roy
	 * @return boolean
	 * @throws Exception new-atitesting.learntab.tutorial.skills.module2.card.back.name.value
	 */
	public boolean verifyAllBeginButtonInCardBackTutorial() throws Exception {
		waitUntillBufferInvisible(PropertiesRepository
				.getString("new-atitesting.peasewait.bufferLoc"));
		logger.info("Method: verifyAllBeginButtonInCardBack Starts"); 
		boolean flag = false;
		try {
			
			windowHandler.switchToLatestWindow();
			baseHandler
					.waitToBeDisplayed(PropertiesRepository
							.getString("new-atitesting.learntab.tutorial.skills.module2.card.back.header.loc"));
			if (baseHandler
					.isDisplayed(baseHandler.findElement(PropertiesRepository
							.getString("new-atitesting.learntab.tutorial.skills.module2.card.back.header.loc")))) {
				if ("Skills Modules 2.0 (30)"
						.equalsIgnoreCase(
								baseHandler
										.findElement(
												PropertiesRepository
														.getString("new-atitesting.learntab.tutorial.skills.module2.card.back.header.loc"))
										.getText())) {
					List<WebElement> allBeginButtonLiElement = baseHandler
							.findElements(PropertiesRepository
									.getString("new-atitesting.learntab.tutorial.skills.module2.all.card.front.button"));
					if (CollectionUtils.isNotEmpty(allBeginButtonLiElement)) {
						int size = allBeginButtonLiElement.size();
						for (int index = 0; index < size; index++) {
							String beginLesson = allBeginButtonLiElement
									.get(index)
									.findElement(
											By.cssSelector(PropertiesRepository
													.getString("new-atitesting.learntab.tutorial.skills.module2.card.front.begin.lesson.button")))
									.getText().replace("\n", "")
									.replace("\r", "");
							if ("BeginLesson".equalsIgnoreCase(beginLesson)) {
								flag = true;
							} else {
								flag = false;
								break;
							}
						}
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verify All Begin Button In Card Back ");
			throw new DriverException(
					"Unable to verify All Begin Button In Card Back ", e);
		}
		logger.info("Method: verifyAllBeginButtonInCardBack End flag --> "
				+ flag);
		return flag;
	}
	
	/**
	 * Method is used to click on first enabled pre or post test button in card
	 * 
	 * @author siddharth.roy
	 * @param cardBackButtonName
	 * @throws DriverException
	 */
	public String clickCardBackButtonbyName(String name)
			throws Exception {
		logger.info("Method:clickCardBackButtonbyName Start ");
		try {
			List<WebElement> element = baseHandler.findElements(".product-list-style li");
			if(CollectionUtils.isNotEmpty(element)) {
				int size = element.size();
				for(int index = 0; index < size; index ++) {
					String skillsModuleName = element.get(index).findElement(By.cssSelector("header span")).getText();
					if(skillsModuleName.equalsIgnoreCase(name)) {
						List<WebElement> productTutListCellElement = element.get(index).findElements(By.cssSelector("div[class='product-tutorial-list-cell']"));
						if(CollectionUtils.isNotEmpty(productTutListCellElement)) {
							List<WebElement> sectionDivElement = productTutListCellElement.get(0).findElements(By.cssSelector("a[class='button focus-element-flag primary-button']"));
							if(CollectionUtils.isNotEmpty(sectionDivElement)) {
								sectionDivElement.get(0).click();
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								break;
							}
						}
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to click CardBackButtonbyName");
			throw new Exception("Unable to clickCardBackButtonbyName");
		}
		logger.info("Method: clickCardBackButtonbyName End ");
		return name;
	}
	
	
	/**
	 * Method is used to click on first enabled pre or post test button in card
	 * 
	 * @author siddharth.roy
	 * @param cardBackButtonName
	 * @throws DriverException
	 */
	public boolean verifyTimeBetweenAttemptsInLearnTab(String name)
			throws Exception {
		logger.info("Method:clickCardBackButtonbyName Start");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(".product-list-style li");
			if(CollectionUtils.isNotEmpty(element)) {
				int size = element.size();
				for(int index = 0; index < size; index ++) {
					String skillsModuleName = element.get(index).findElement(By.cssSelector("header span")).getText();
					if(skillsModuleName.equalsIgnoreCase(name)) {
						List<WebElement> postTestElement = element.get(index).findElements(By.cssSelector(".skills-cell .product-tutorial-list-cell"));
						if(CollectionUtils.isNotEmpty(postTestElement)) {
							WebElement postElement = postTestElement.get(1);
							List<WebElement> retakeMessageElement = postElement.findElements(By.cssSelector("div div div[class='time-suggested-spent']"));
							if(CollectionUtils.isNotEmpty(retakeMessageElement)) {
								WebElement availableElement = retakeMessageElement.get(1);
								String availableText = availableElement.getText().trim();
								if(availableText.contains("Available In")) {
									flag = true;
									break;
								}
							}
						}
					}
				}
			}
		}catch (Exception e) {
			logger.info("Unable to click CardBackButtonbyName");
			throw new Exception("Unable to clickCardBackButtonbyName");
		}
		logger.info("Method: clickCardBackButtonbyName End --> " + flag);
		return flag;
	}
	/**
	 * 
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public String clickSmartPrepCardBackButtonbyName(String name)
			throws Exception {
		logger.info("clickSmartPrepCardBackButtonbyName Start");
		try {
			List<WebElement> element = baseHandler.findElements(".product-list-style li");
			if(CollectionUtils.isNotEmpty(element)) {
				int size = element.size();
				for(int index = 0; index < size; index ++) {
					String skillsModuleName = element.get(index).findElement(By.cssSelector("header span")).getText();
					if(skillsModuleName.equalsIgnoreCase(name)) {
						List<WebElement> productTutListCellElement = element.get(index).findElements(By.cssSelector("div[class='product-tutorial-list-cell']"));
						if(CollectionUtils.isNotEmpty(productTutListCellElement)) {
							List<WebElement> sectionDivElement = productTutListCellElement.get(0).findElements(By.cssSelector("a[class='button primary-button focus-element-flag']"));
							if(CollectionUtils.isNotEmpty(sectionDivElement)) {
								((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sectionDivElement.get(0));
								sectionDivElement.get(0).click();
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								break;
							}
						}
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to click CardBackButtonbyName");
			throw new Exception("Unable to clickCardBackButtonbyName");
		}
		logger.info("Method: clickSmartPrepCardBackButtonbyName");
		return name;
	}
	
	/**
	 * Method is used to click on first enabled pre or post test button in card
	 * 
	 * @author siddharth.roy
	 * @param cardBackButtonName
	 * @throws DriverException
	 */
	public String clickPostTestCardBackButtonbyName(String name)
			throws Exception {
		logger.info("Method:clickCardBackButtonbyName Start");
		//name = "Ambulation, Transferring, Range of Motion";
		try {
			List<WebElement> element = baseHandler.findElements(".product-list-style li");
			if(CollectionUtils.isNotEmpty(element)) {
				int size = element.size();
				for(int index = 0; index < size; index ++) {
					String skillsModuleName = element.get(index).findElement(By.cssSelector("header span")).getText();
					if(skillsModuleName.equalsIgnoreCase(name)) {
						List<WebElement> productTutListCellElement = element.get(index).findElements(By.cssSelector("div[class='product-tutorial-list-cell']"));
						if(CollectionUtils.isNotEmpty(productTutListCellElement)) {
							List<WebElement> sectionDivElement = productTutListCellElement.get(1).findElements(By.cssSelector("a[class='button focus-element-flag primary-button']"));
							if(CollectionUtils.isNotEmpty(sectionDivElement)) {
								sectionDivElement.get(0).click();
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								break;
							}
						}
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to click CardBackButtonbyName");
			throw new Exception("Unable to clickCardBackButtonbyName");
		}
		logger.info("Method: clickCardBackButtonbyName");
		return name;
	}
	
	
	/**
	 * Method is used to click on first enabled pre or post test button in card
	 * 
	 * @author siddharth.roy
	 * @param cardBackButtonName
	 * @throws DriverException
	 */
	public String clickOnPostTestCardBackButtonbyName(String moduleName)
			throws Exception {
		logger.info("Method:clickCardBackButtonbyName Start");
	//	moduleName = "Airway Management";
		try {
			List<WebElement> element = baseHandler.findElements(".product-list-style li");
			if(CollectionUtils.isNotEmpty(element)) {
				int size = element.size();
				for(int index = 0; index < size; index ++) {
					String skillsModuleName = element.get(index).findElement(By.cssSelector("header span")).getText();
					if(skillsModuleName.equalsIgnoreCase(moduleName.trim())) {
						List<WebElement> productTutListCellElement = element.get(index).findElements(By.cssSelector("div[class='product-tutorial-list-cell']"));
						if(CollectionUtils.isNotEmpty(productTutListCellElement)) {
							List<WebElement> sectionDivElement = productTutListCellElement.get(1).findElements(By.cssSelector("a[class='button focus-element-flag primary-button']"));
							if(CollectionUtils.isNotEmpty(sectionDivElement)) {
								sectionDivElement.get(0).click();
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								break;
							}
						}
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to click CardBackButtonbyName");
			throw new Exception("Unable to clickCardBackButtonbyName");
		}
		logger.info("Method: clickCardBackButtonbyName");
		return moduleName;
	}
	
	/**
	 * Method is used to verify Pre Test button is enabled or not. 
	 * @param locator
	 * @return
	 * @throws DriverException
	 */
	public boolean verifyPreTestButtonIsEnabled() throws DriverException {
		logger.info("verifyPreTestButtonIsEnabled Start  ");
		boolean flag = false;
		try {
			WebElement preTestElement = driver.findElement(By.cssSelector(PropertiesRepository
					.getString("new-atitesting.learntab.tutorialBeginTest.Loc")));
			baseHandler.waitToBeDisplayed(preTestElement);
			flag = baseHandler.isEnabled(preTestElement);
		} catch(Exception e) {
			throw new DriverException("Unable to verify Pre Test button for Tutorials", e);
		}
		logger.info("takeProctoredAssessment End  " + flag);
		return flag;
	}
	
	public void selectValueFromDropDown(String locator,String valueToBeSelected,String optionsLoc)
	{
		driver.findElement(By.cssSelector(PropertiesRepository.getString(locator))).click();
		try {
			Thread.sleep(10000);
			List<WebElement> findElements = driver.findElements(By.cssSelector(PropertiesRepository.getString(optionsLoc)));
			if(findElements.size()>0)
			{
				findElements.get(1).click();
			}
		} catch (InterruptedException e) {
			logger.info("throwing error while verifying the tab content");
		}
		
	}

	public boolean VerifyTabContent(String loc) {
		boolean status = false;
		int size = driver.findElements(By.cssSelector(loc)).size();
		if (size > 0
				|| driver.findElement(By.cssSelector(loc.split(" ")[0] + " .no-data-available-area>h3")).getText()
						.equals(PropertiesRepository.getString("new-atitesting.homepage.myatitab.learntab.nolearning"))
				|| driver.findElement(By.cssSelector(loc.split(" ")[0] + " .no-data-available-area>h3")).getText()
						.equals(PropertiesRepository.getString("new-atitesting.homepage.myatitab.testtab.noitems"))) {
			status = true;
		}
		return status;
	}
	
	public boolean verifyImproveTabPDF() throws Exception {
		logger.info("Method: verifyIPPPageHeader Starts");
		boolean flag = false;
    	try {
    		windowHandler.switchToFrame("focusedReviewFrame");
    		List<WebElement> element = baseHandler.findElements(".fr-media-link");
    		if(CollectionUtils.isNotEmpty(element)) {
    			int size = element.size();
    			for(int index = 0; index < size; index ++) {
    				List<WebElement> pdfElement = element.get(index).findElements(By.cssSelector("div"));
    				if(CollectionUtils.isNotEmpty(pdfElement)) {
    					WebElement divPDFElement = pdfElement.get(0);    					
    					if(divPDFElement != null) {
    						if(divPDFElement.getAttribute("class").equalsIgnoreCase("pdf-icon-minified")) {
    							pdfElement.get(1).click();
        						List<WebElement> pdfContainer = baseHandler.findElements("#RemediationContent");
        						if(CollectionUtils.isNotEmpty(pdfContainer)) {
        							flag = true;
        							break;
        						}
    						}
    					}
    				}
    			}
    		}
    		windowHandler.switchToLatestWindow();
    	} catch (Exception e) {
    		windowHandler.switchToLatestWindow();
    		logger.info("Unable to ");
			log(logger, "Unable to " );
    		throw new DriverException("Unable to " , e); 
    	}
    	logger.info("Method: verifyIPPPageHeader End flag --> " + flag);
    	return flag;
	}
	
	public boolean verifyImproveTabVideo() throws Exception {
		logger.info("Method: verifyIPPPageHeader Starts");
		boolean flag = false;
    	try {
    		windowHandler.switchToFrame("focusedReviewFrame");
    		List<WebElement> element = baseHandler.findElements(".fr-media-link");
    		if(CollectionUtils.isNotEmpty(element)) {
    			int size = element.size();
    			for(int index = 0; index < size; index ++) {
    				List<WebElement> pdfElement = element.get(index).findElements(By.cssSelector("div"));
    				if(CollectionUtils.isNotEmpty(pdfElement)) {
    					WebElement divPDFElement = pdfElement.get(0);    					
    					if(divPDFElement != null) {
    						if(divPDFElement.getAttribute("class").equalsIgnoreCase("video-icon-minified")) {
    							pdfElement.get(1).click();
        						List<WebElement> pdfContainer = baseHandler.findElements(".LimelightEmbeddedPlayerFlash.swfPrev-beforeswfanchor0.swfNext-afterswfanchor0");
        						if(CollectionUtils.isNotEmpty(pdfContainer)) {
        							flag = true;
        							break;
        						}
    						}
    					}
    				}
    			}
    		}
    		windowHandler.switchToLatestWindow();
    	} catch (Exception e) {
    		windowHandler.switchToLatestWindow();
    		logger.info("Unable to ");
			log(logger, "Unable to " );
    		throw new DriverException("Unable to " , e); 
    	}
    	logger.info("Method: verifyIPPPageHeader End flag --> " + flag);
    	return flag;
	}
	
	/**
	 * Method is used to click first PreTest Button based on Module Name in
	 * Skills Module 2.0 Card Back.
	 * 
	 * Begin Test
	 * 
	 * @return
	 * @throws Exception
	 */
	public void clickBeginTestButtonInDosageCalculationCardBack(String moduleName)
			throws Exception {
		logger.info("Method: clickBeginTestButtonInDosageCalculationCardBack Starts");
		try {
			baseHandler.waitForPageToLoad(PropertiesRepository
							.getString("new-atitesting.learntab.tutorial.stt.all.card.front.button"));
			List<WebElement> allBeginButtonLiElement = baseHandler
					.findElements(PropertiesRepository
							.getString("new-atitesting.learntab.tutorial.stt.all.card.front.button"));
			if (CollectionUtils.isNotEmpty(allBeginButtonLiElement)) {
				int size = allBeginButtonLiElement.size();
				for (int index = 0; index < size; index++) {
					String moduleNameFromUI = allBeginButtonLiElement
							.get(index)
							.findElement(
									By.cssSelector(PropertiesRepository
											.getString("new-atitesting.learntab.tutorial.skills.module2.card.front.module.name.loc")))
							.getText();
					// Matching Module Name 
					if (StringUtils.isNotEmpty(moduleNameFromUI)) { 
						if (moduleName.equalsIgnoreCase(moduleNameFromUI)) {
							List<WebElement> singleModuleButtons = allBeginButtonLiElement
									.get(index)
									.findElements(
											By.cssSelector(PropertiesRepository.getString("new-atitesting.learntab.tutorial.stt.card.front.module.section1.new.loc")));
							if (CollectionUtils.isNotEmpty(singleModuleButtons)) {
								List<WebElement> testElements = singleModuleButtons.get(0).findElements(
										By.cssSelector(PropertiesRepository.getString("new-atitesting.learntab.tutorial.nurse.logic.tutorial.begin.test.button.new.loc")));
								if(CollectionUtils.isNotEmpty(testElements)) {
									testElements.get(0).click();
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									break;
								}
							}
						}
					}

				}
			}
		} catch (Exception e) {
			logger.info("Unable to click BeginTest Button In DosageCalculation Card Back");
			throw new DriverException(
					"Unable to click BeginTest Button In DosageCalculation Card Back", e);
		}
		logger.info("Method: clickBeginTestButtonInDosageCalculationCardBack End ");
	}

	public void takeTEASSmartPrep(boolean frameStatus) throws Exception {
		try {
			
			Actions action=new Actions(driver);
			if(frameStatus)
			windowHandler.switchToFrame("OpenPageFrame");
			String maxQtnTextNo = textHandler.getText(PropertiesRepository.getString("new-atitesting.smartprep.total.question.no"));

			int maxCount = Integer.parseInt(maxQtnTextNo);

			String minQtnTextNo = textHandler.getText(PropertiesRepository.getString("new-atitesting.smartprep.current.question.no"));

			int minCount = Integer.parseInt(minQtnTextNo);

			int count = maxCount - minCount;
			

			for (int i = 0; i <= count; i++) {
				List<WebElement> options = baseHandler.findElements("#questionOptions li a");
				if (CollectionUtils.isNotEmpty(options)&&options.size() > 0) {
					action.moveToElement(options.get(0)).click().build().perform();
					baseHandler.findElement("#submitContBtn").click();
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				}
			}
		} catch (Exception e) {
			logger.info("element is not visible");
		}
		
		}

	
	public void takeTEASSmartPrep(Map<Integer, Integer> answer,boolean frameStatus,boolean negativeFlag) throws Exception {
		try {
			Actions action=new Actions(driver);
			if(frameStatus)
			windowHandler.switchToFrame("OpenPageFrame");
			String maxQtnTextNo = textHandler.getText(PropertiesRepository.getString("new-atitesting.smartprep.total.question.no"));
			int maxCount = Integer.parseInt(maxQtnTextNo);
			String minQtnTextNo = textHandler.getText(PropertiesRepository.getString("new-atitesting.smartprep.current.question.no"));
			int minCount = Integer.parseInt(minQtnTextNo);
			int count = maxCount - minCount;
			for (int j = 0; j <= count; j++) {
				if(j == count && negativeFlag) {
					if(answer.get(minCount)==0)
					{
						minCount=1;
					}
					else
					{
						minCount=answer.get(minCount)-1;
					}
				}
				String currMinCountValue = textHandler.getText(PropertiesRepository.getString("new-atitesting.smartprep.current.question.no"));
				int currMinCount = Integer.parseInt(currMinCountValue);
				List<WebElement> options = baseHandler.findElements("#questionOptions li a");
				if (CollectionUtils.isNotEmpty(options)&&options.size() > 0) {
					action.moveToElement(options.get(answer.get(currMinCount))).click().build().perform();
					baseHandler.findElement("#submitContBtn").click();
					Thread.sleep(4000);
					//waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				}
			}
		} catch (Exception e) {
			logger.info("element is not visible");
		}
		}
	
	public void completeQuiz(String loc) throws Exception {
		try {
			Actions action = new Actions(driver);
			List<WebElement> elements = baseHandler.findElements(PropertiesRepository.getString(loc));
			List<WebElement> quizStatusMark = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.smartprep.quizzes.status"));
			if (CollectionUtils.isNotEmpty(elements) && CollectionUtils.isNotEmpty(quizStatusMark)) {
				for (int i = 0; i < elements.size(); i++) {
					if (quizStatusMark.get(i).getAttribute("class").equalsIgnoreCase("quiz OPR_quizNotCompleted")) {
						elements.get(i).click();
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						String minQtnTextNo = textHandler.getText(PropertiesRepository.getString("new-atitesting.quizzes.current.question.no"));
						int minCount = Integer.parseInt(minQtnTextNo);
						String maxQtnTextNo = textHandler.getText(PropertiesRepository.getString("new-atitesting.quizzes.last.question.no"));
						int maxCount = Integer.parseInt(maxQtnTextNo);
						int count = maxCount - minCount;
						for (int j = 0; j <= count; j++) {
							List<WebElement> options = baseHandler.findElements("#questionOptions li a");
							if (CollectionUtils.isNotEmpty(options) && options.size() > 0) {
								action.moveToElement(options.get(0)).click().build().perform();
								baseHandler.findElement("#submitContBtn").click();
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
							}
						}
						clickButton(PropertiesRepository.getString("new-atitesting.quizzes.close.button.loc"));
					}

				}

			}
		} catch (Exception e) {
			logger.info("element not found");
		}
	

	}
	
	public void completeQuiz(Map<Integer, Integer> answer, String loc, boolean negativeFlag) throws Exception {
		try {
			Actions action = new Actions(driver);
			List<WebElement> elements = baseHandler.findElements(PropertiesRepository.getString(loc));
			List<WebElement> quizStatusMark = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.smartprep.quizzes.status"));
			if (CollectionUtils.isNotEmpty(elements) && CollectionUtils.isNotEmpty(quizStatusMark)) {
				for (int i = 0; i < elements.size(); i++) {
					if (quizStatusMark.get(i).getAttribute("class").equalsIgnoreCase("quiz OPR_quizNotCompleted")) {
						elements.get(i).click();
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						String minQtnTextNo = textHandler.getText(PropertiesRepository.getString("new-atitesting.quizzes.current.question.no"));
						int minCount = Integer.parseInt(minQtnTextNo);
						String maxQtnTextNo = textHandler.getText(PropertiesRepository.getString("new-atitesting.quizzes.last.question.no"));
						int maxCount = Integer.parseInt(maxQtnTextNo);
						int count = maxCount - minCount;
						for (int j = 0; j <= count; j++) {
							if(j == count && !negativeFlag) {
								if(answer.get(minCount)==0)
								{
									minCount=1;
								}
								else
								{
									minCount=answer.get(minCount)-1;
								}
							}
							String currMinCountValue = textHandler.getText(PropertiesRepository.getString("new-atitesting.smartprep.current.question.no"));
							int currMinCount = Integer.parseInt(currMinCountValue);
							List<WebElement> options = baseHandler.findElements("#questionOptions li a");
							if (CollectionUtils.isNotEmpty(options) && options.size() > 0) {
								action.moveToElement(options.get(answer.get(currMinCount))).click().build().perform();
								baseHandler.findElement("#submitContBtn").click();
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
							}
						}
						clickButton(PropertiesRepository.getString("new-atitesting.quizzes.close.button.loc"));
					}

				}

			}
		} catch (Exception e) {
			logger.info("element not found");
		}
	

	}
	
	public void clickOnLaunchPostTestButton()
	{
		//windowHandler.switchToFrame("OpenPageFrame");
		try {
			//System.out.println(baseHandler.findElement(PropertiesRepository.getString("new-atitesting.smartprep.launch.posttest.button")).isDisplayed());
			clickButtonByActionClassFromList("new-atitesting.smartprep.launch.posttest.button",0);
			clickButtonByActionClassFromList("new-atitesting.smartprep.launch.posttest.button",0);
		} catch (Exception e) {
		}
	}

	public boolean clickOnAgreementCheckBox() {
		try {
			List<WebElement> findElements = baseHandler.findElements(".question-option.bold>label");
			if(findElements!=null && findElements.size()>0)
			{
				windowHandler.switchToLatestWindow();
				findElements.get(0).click();
				clickButton(PropertiesRepository.getString("new-atitesting.smartprep.continue.button"));
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				return true;
			}
		} catch (Exception e) {
			System.out.println("not clicked");
		}
		return false;
		
		
	}

	public void closeSmartPrepAndCheckIfNewUser() throws Exception {
		logger.info("closeSmartPrepAndCheckIfNewUser Start");
		try {
			windowHandler.switchToFrame("OpenPageFrame");
			clickButton("#startTest");
			windowHandler.switchToLatestWindow();
			
			List<WebElement> closeElement = baseHandler.findElements(".close-button.focus-element-flag");
			if(CollectionUtils.isNotEmpty(closeElement)) {
				closeElement.get(0).click();
			}
		} catch(Exception e) {
			logger.info("Unable to closeSmartPrepAndCheckIfNewUser");
			throw new DriverException(
					"Unable to closeSmartPrepAndCheckIfNewUser", e);
		}
		logger.info("closeSmartPrepAndCheckIfNewUser End");
	}

	public boolean verifyIPPPageTable() {
		List<Boolean> list=new ArrayList<Boolean>();
		try {
			List<WebElement> elements = baseHandler.findElements(PropertiesRepository.getString("new-ati.report.results.tables.loc"));
			if(CollectionUtils.isNotEmpty(elements))
			{
				for (WebElement webElement : elements) {
					list.add(webElement.isDisplayed());
				} 
				
			}
		} catch (Exception e) {
			logger.info("element is not visible");
		}
		
		return list.contains(false)?false:true;
	}

	public boolean verifyCalendarObjects() {
		List<Boolean> list=new ArrayList<Boolean>();
		try {
			
			List<WebElement> elements = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.homepage.full.page.calendar.month.button.loc"));
			if(CollectionUtils.isNotEmpty(elements))
			{
				for (WebElement webElement : elements) {
					list.add(webElement.isDisplayed());
				} 
			}
			list.add(elements.get(0).isEnabled());
			list.add(baseHandler.findElement(PropertiesRepository.getString("new-atitesting.homepage.full.page.calendar.previous.month")).isDisplayed());
			list.add(baseHandler.findElement(PropertiesRepository.getString("new-atitesting.homepage.full.page.calendar.next.month")).isDisplayed());
			list.add(baseHandler.findElement(PropertiesRepository.getString("new-atitesting.homepage.full.page.calendar.today.date")).isDisplayed());
		} catch (Exception e) {
			logger.info("element is not visible");
		}
		
		return list.contains(false)?false:true;
		
	}

	public boolean verifyCalendarYear() {
		try {
			
			List<WebElement> elements = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.homepage.full.page.calendar.year.loc"));
			if(CollectionUtils.isNotEmpty(elements))
			{
				String year = elements.get(1).getText();
				if(year.length()==4)
				{
					return true;
				}
			}
		} catch (Exception e) {
			logger.info("element is not visible");
		} 
	
		return false;
		
	}

	public boolean verifyPreviousYearNavigation() {
		String month=null;
		String newMonth=null;
		try {
			List<WebElement> elements = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.homepage.full.page.calendar.year.loc"));
			if(CollectionUtils.isNotEmpty(elements))
			{
				 month = elements.get(0).getText();
			}
			WebElement previousMonthLoc = baseHandler.findElement(PropertiesRepository.getString("new-atitesting.homepage.full.page.calendar.previous.month"));
			if(previousMonthLoc!=null)
			{
				previousMonthLoc.click();
			}
			List<WebElement> elements1 = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.homepage.full.page.calendar.year.loc"));
			if(CollectionUtils.isNotEmpty(elements))
			{
				newMonth = elements1.get(0).getText();
			}
			
			if(!month.equals(newMonth))
			{
				return true;
			}
		} catch (Exception e) {
			logger.info("element is not visible");
		}
	
		//baseHandler.findElements(PropertiesRepository.getString("new-atitesting.homepage.full.page.calendar.next.month"));
		return false;
		
	}

	public boolean verifyNextYearNavigation() {
		String month=null;
		String newMonth=null;
		try {
			List<WebElement> elements = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.homepage.full.page.calendar.year.loc"));
			if(CollectionUtils.isNotEmpty(elements))
			{
				 month = elements.get(0).getText();
			}
			WebElement nextMonthLoc = baseHandler.findElement(PropertiesRepository.getString("new-atitesting.homepage.full.page.calendar.next.month"));
			if(nextMonthLoc!=null)
			{
				nextMonthLoc.click();
			}
			List<WebElement> elements1 = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.homepage.full.page.calendar.year.loc"));
			if(CollectionUtils.isNotEmpty(elements))
			{
				newMonth = elements1.get(0).getText();
			}
			
			if(!month.equals(newMonth))
			{
				return true;
			}
		} catch (Exception e) {
			logger.info("element is not visible");
		}
	
		return false;
	}
}


























