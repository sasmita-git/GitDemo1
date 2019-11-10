package com.automation.id.pages;

import java.util.List;
import java.util.Random;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.TextHandler;

public class ProductsPage extends IDBasePage {

	private Logger logger = LogManager.getLogger(this.getClass());
	private LoginPage loginPage;

	public ProductsPage(WebDriver webDriver) {
		super(webDriver);
		textHandler = new TextHandler(driver);
		loginPage = new LoginPage(driver);
	}

	/**
	 * Method used to click on Product Menu.
	 * 
	 * @param index
	 * @throws DriverException
	 */
	public void clickProductMenu(int index) throws DriverException {
		logger.info("Method: clickProductMenu Starts");
		try {
			List<WebElement> cohortTxt = verifyElementList(PropertiesRepository.getString("id.product.top.menu.loc"));
			if (CollectionUtils.isNotEmpty(cohortTxt)) {
				cohortTxt.get(index).click();
			}
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		} catch (Exception e) {
			logger.info("Unable to clickProductMenu");
			log(logger, "Unable to clickProductMenu");
			throw new DriverException("Unable to clickProductMenu", e);
		}
		logger.info("Method: clickProductMenu End ");
	}

	/**
	 * @method: to select tab in set benchmark and verify is that tab is selected
	 * @param index
	 * @throws DriverException
	 */

	public boolean clickPracticeAssessmentForSetBenchMark(int index) throws DriverException {
		logger.info("clickPracticeAssessmentForSetBenchMark --- Start");
		boolean flag= false;
		try {
			List<WebElement> proctorasessmentpoolitem = baseHandler
					.findElements(PropertiesRepository.getString("setbenchmark.practice.tab"));
			if (CollectionUtils.isNotEmpty(proctorasessmentpoolitem)) {
				proctorasessmentpoolitem.get(index).click();
				loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				//Syed : initializing again as the element is not recognized after click
				List<WebElement> proctorasessmentpoolitem2 = baseHandler.findElements(PropertiesRepository.getString("setbenchmark.practice.tab"));
				if(proctorasessmentpoolitem2.get(index).getAttribute("class").contains("selected"))
				{
					flag = true;
				}
			}
		} catch (Exception e) {
			log(logger, "clickPracticeAssessmentForSetBenchMark is not functional");
			throw new DriverException("clickPracticeAssessmentForSetBenchMark is not functional", e);
		}
		logger.info("clickPracticeAssessmentForSetBenchMark --- END");
		return flag;
	}
	
	/**
	 * @method: to select Proctor tab in set benchmark and verify is that tab is selected
	 * @param index
	 * @throws DriverException
	 */

	public boolean clickProctorAssessmentForSetBenchMark(int index) throws DriverException {
		logger.info("clickPracticeAssessmentForSetBenchMark --- Start");
		boolean flag= false;
		try {
			List<WebElement> proctorasessmentpoolitem = baseHandler
					.findElements(PropertiesRepository.getString("setbenchmark.proctor.tab"));
			if (CollectionUtils.isNotEmpty(proctorasessmentpoolitem)) {
				proctorasessmentpoolitem.get(index).click();
				loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				//Syed : initializing again as the element is not recognized after click
				List<WebElement> proctorasessmentpoolitem2 = baseHandler.findElements(PropertiesRepository.getString("setbenchmark.proctor.tab"));
				if(proctorasessmentpoolitem2.get(index).getAttribute("class").contains("selected"))
				{
					flag = true;
				}
			}
		} catch (Exception e) {
			log(logger, "clickPracticeAssessmentForSetBenchMark is not functional");
			throw new DriverException("clickPracticeAssessmentForSetBenchMark is not functional", e);
		}
		logger.info("clickPracticeAssessmentForSetBenchMark --- END");
		return flag;
	}

	/**
	 * @author Syed.Hoque Verify different field of set bench mark practice
	 *         assessment pop up verify 'Bench Mark text field','Reset to
	 *         Default button','Bench Mark type','Save for all assessments check
	 *         box','Save and Cancel button
	 * @throws DriverException
	 */
	public boolean checkFieldsOnSetBenchMarkPopUpPractice(String ExpectedBenchmarkType, String ExpectedIndividual,
			String expecsaveforallassessments) throws DriverException {
		logger.info("checkFieldsOnSetBenchMarkPopUpPractice --- END");
		
		boolean benchMarktextfield = false;
		boolean resetToDefaultbutton = false;		
		boolean type = false;
		boolean individual = false;
		boolean assessment = false;
		boolean chkBoxFlag = false;
		
		boolean flag = true;
		try {
			// to verify benchmark text field
			benchMarktextfield = baseHandler.findElement(PropertiesRepository.getString("setbenchmark.text.value")).isDisplayed();
			
			/*Syed:[5th Sept 2018] Commented below lines as this element is not present anymore
			 * // to verify benchmark reset btn
			baseHandler.findElement(PropertiesRepository.getString("setbenchmark.reset.btn")).isDisplayed();*/
			
			// to verify reset to default button
			resetToDefaultbutton = baseHandler.findElement(PropertiesRepository.getString("setbenchmark.reset.btn")).isDisplayed();
			
			// to verify bench mark type text 'Benchmark Type:Individual %' and
			// 'save for all assessment '
			List<WebElement> practicesetbenchmarkpopuptext = baseHandler
					.findElements(PropertiesRepository.getString("setBenchmark.practiceassessment.popuptexts"));
			if (CollectionUtils.isNotEmpty(practicesetbenchmarkpopuptext)) {
				String actualBenchmarkType = practicesetbenchmarkpopuptext.get(0).getText();
				if (actualBenchmarkType.equalsIgnoreCase(ExpectedBenchmarkType)) {
					type = true;
				}

				String actualIndividual = practicesetbenchmarkpopuptext.get(1).getText();
				if (actualIndividual.equalsIgnoreCase(ExpectedIndividual)) {
					individual = true;
				}

				String actualsaveforallassessments = practicesetbenchmarkpopuptext.get(2).getText();
				if (actualsaveforallassessments.equalsIgnoreCase(expecsaveforallassessments)) {
					assessment = true;
				}

				// to verify check box is present or not
				chkBoxFlag = baseHandler
						.findElement(PropertiesRepository.getString("setBenchmark.practiceassessment.popup.checkbox"))
						.isDisplayed();

				if (type && individual && assessment && chkBoxFlag && benchMarktextfield && resetToDefaultbutton) {
					flag = true;
				}
			}
		} catch (Exception e) {
			log(logger, "checkFieldsOnSetBenchMarkPopUpPractice is not functional");
			throw new DriverException("checkFieldsOnSetBenchMarkPopUpPractice is not functional", e);
		}
		logger.info("checkFieldsOnSetBenchMarkPopUpPractice --- END flag --> " + flag);
		return flag;
	}

	/**
	 * @author Syed.Hoque This method will sent value to benchmark text for
	 *         practice bos and click on save button and verify the save data
	 * @throws DriverException
	 */
	public boolean setBenchMarkPracticeValue() throws DriverException {
		logger.info("setBenchMarkPracticeValue --- Start");
		
		Random random = new Random();
		int value = random.nextInt(20);
		String valueStr = Integer.toString(value);
		boolean flag = false;
		try {
			baseHandler.findElement(PropertiesRepository.getString("setbenchmark.text.value")).clear();
			baseHandler.findElement(PropertiesRepository.getString("setbenchmark.text.value")).sendKeys(valueStr);
			baseHandler.findElement(PropertiesRepository.getString("setbenchmark.save.btn.popup")).click();
			
			loginPage.wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(PropertiesRepository.getString("setbenchmark.text.value"))));
			loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			
			// to verify whether edit bench mark is displaying
			List<WebElement> benchMarkElement = baseHandler.findElements(PropertiesRepository.getString("setbenchmark.practice.edit.field.new"));
			if(CollectionUtils.isNotEmpty(benchMarkElement) && benchMarkElement.get(0).getText().contains(valueStr)) 
			/*String editText = baseHandler.findElement(PropertiesRepository.getString("setbenchmark.practice.edit.field.new")).getText();
			if (editText.replaceAll("\\s+","").contains(valueStr.replaceAll("\\s+","")))*/ {
				flag = true;
				
			}

		} catch (Exception e) {
			log(logger, "setBenchMarkPracticeValue is not functional");
			throw new DriverException("setBenchMarkPracticeValue is not functional", e);
		}
		logger.info("setBenchMarkPracticeValue --- End -- flag --> " + flag);
		return flag;
	}
	
	/**
	 * @author Syed.Hoque This method will sent value to benchmark text for
	 *         Proctor bos and click on save button and verify the save data
	 * @throws DriverException
	 */
	public boolean setBenchMarkProctoreValue() throws DriverException {
		logger.info("setBenchMarkProctoreValue --- Start ");
		Random random = new Random();
		int value = random.nextInt(20);
		String valueStr = Integer.toString(value);
		boolean flag = false;
		try {
			baseHandler.findElement(PropertiesRepository.getString("setbenchmark.text.value")).clear();
			baseHandler.findElement(PropertiesRepository.getString("setbenchmark.text.value")).sendKeys(valueStr);
			baseHandler.findElement(PropertiesRepository.getString("setbenchmark.save.btn.popup")).click();
			
			loginPage.wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(PropertiesRepository.getString("setbenchmark.text.value"))));
			loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			
			// to verify whether edit bench mark is displaying
			String editText = baseHandler.findElement(PropertiesRepository.getString("setbenchmark.practice.edit.field.new")).getText();
			if (editText.replaceAll("\\s+","").contains(valueStr.replaceAll("\\s+",""))) {
				flag = true;
				
			}

		} catch (Exception e) {
			log(logger, "setBenchMarkProctoreValue is not functional");
			throw new DriverException("setBenchMarkProctoreValue is not functional", e);
		}
		logger.info("setBenchMarkProctoreValue --- End -- flag --> " + flag);
		return flag;
	}
	
	

	/**
	 * @method: to select Proctor tab in set benchmark
	 * @param index
	 * @throws DriverException
	 */

	public boolean clicProctoAssessmentForSetBenchMark(int index) throws DriverException {
		logger.info("clicProctoAssessmentForSetBenchMark --- Start");
		boolean flag = false;;
		try {
			List<WebElement> proctorasessmentpoolitem = baseHandler.findElements(PropertiesRepository.getString("setbenchmark.proctor.tab"));
			if (CollectionUtils.isNotEmpty(proctorasessmentpoolitem)) {
			proctorasessmentpoolitem.get(index).click();
			loginPage.waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			//Syed : initializing again as the element is not recognized after click
			List<WebElement> proctorasessmentpoolitem2 = baseHandler.findElements(PropertiesRepository.getString("setbenchmark.proctor.tab"));
			if(proctorasessmentpoolitem2.get(index).getAttribute("class").contains("selected"))
			{
				flag = true;
			}
			
			}
		} catch (Exception e) {
			log(logger, "clicProctoAssessmentForSetBenchMark is not functional");
			throw new DriverException("clicProctoAssessmentForSetBenchMark is not functional", e);
		}
		logger.info("clicProctoAssessmentForSetBenchMark --- END");
		return flag;
	}

	/**
	 * method: To verify proctor elements in schedule Assignment
	 * 
	 * @throws DriverException
	 */

	public boolean checkFieldsOnSetBenchMarkPopUpProctor() throws DriverException {
		logger.info("checkFieldsOnScheduleAssignment --- Start");
		boolean flag = false;
		boolean setbenchmarktext = false;
		boolean setbenchmarkreset = false;
		boolean setbenchmarkdropdown = false;
		try {
			// to verify benchmark text field
			if (baseHandler.findElement(PropertiesRepository.getString("setbenchmark.text.value")).isDisplayed()) {
				setbenchmarktext = true;
			}
			// to verify benchmark reset value
			if (baseHandler.findElement(PropertiesRepository.getString("setbenchmark.reset.btn")).isDisplayed()) {
				setbenchmarkreset = true;
			}
			// to verify drop down is present
			if (baseHandler.findElement(PropertiesRepository.getString("setbenchmark.dropdown.type")).isDisplayed()) {
				setbenchmarkdropdown = true;
			}

			if (setbenchmarktext && setbenchmarkreset && setbenchmarkdropdown) {
				flag = true;
			}

		} catch (Exception e) {
			log(logger, "checkFieldsOnScheduleAssignment is not functional");
			throw new DriverException("checkFieldsOnScheduleAssignment is not functional", e);
		}
		logger.info("setBenchMarkPracticeValue --- End -- flag --> " + flag);
		return flag;
	}

	public boolean verifyProductPageMainTabs(String loc) throws DriverException {
		log(logger, "verifyProductPageMainTabs start");
		boolean flag = false;
		try {
			windowHandler.switchToMainWindow();
			List<WebElement> elements = baseHandler.findElements(PropertiesRepository.getString(loc));
			if (CollectionUtils.isNotEmpty(elements)) {
				if (PropertiesRepository.getString("id.product.main.tab1.name")
						.equalsIgnoreCase(elements.get(0).getText().trim())
						&& PropertiesRepository.getString("id.product.main.tab2.name")
								.equalsIgnoreCase(elements.get(2).getText().trim())
						&& PropertiesRepository.getString("id.product.main.tab3.name")
								.equalsIgnoreCase(elements.get(4).getText().trim())) {
					flag = true;
				}
			}

		} catch (Exception e) {
			log(logger, "unable to verify Product Page Main Tabs");
			throw new DriverException("verifyProductPageMainTabs", e);
		}
		logger.info("verifyProductPageMainTabs --- END");
		return flag;
	}

	public boolean navigateToProductsMainTab(String loc, String input, int i) throws DriverException {
		logger.info("navigateToProductsMainTab --- Start");
		boolean flag = false;
		try {
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			List<WebElement> elements = baseHandler
					.findElements(PropertiesRepository.getString("id.homepage.product.sub.tab.loc"));
			if (CollectionUtils.isNotEmpty(elements)) {
				elements.get(i).click();
				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				switchToCardShadowFrame();
				List<WebElement> elements1 = baseHandler.findElements(PropertiesRepository.getString(loc));

				if (CollectionUtils.isNotEmpty(elements1)) {
					if (elements1.get(0).getText().trim().contains(PropertiesRepository.getString(input))) {
						windowHandler.switchToMainWindow();
						flag = true;
					}
				} else {
					logger.info("Unable to verify content for each sub menu");
				}
			} else {
				logger.info("Unable to click on Sub menu");
			}

		} catch (Exception e) {
			log(logger, "unable to navigate To Products MainTab");
			throw new DriverException("navigateToProductsMainTab", e);
		}
		logger.info("navigateToProductsMainTab --- END flag --> " + flag);
		return flag;
	}
	/**
	 * Method used to verify Cohort Section is opened or not. 
	 * If yes, 
	 * 	enter cohort value in search and verify that corresponding cohort is displayed or not. 
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws Exception
	 * 
	 */
	public boolean clickSearchByCohortSection() throws Exception {
		logger.info("Method : clickSearchByCohortSectionStart");
		boolean flag = false;
		try {
			// To Check Cohort section is opened or not.
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("id.products.show.cohorts.associated.with.section.loc"));
			if(CollectionUtils.isNotEmpty(element) && element.size() > 0) { // It is opened
				List<WebElement> iconElement = baseHandler.findElements(PropertiesRepository.getString("id.products.show.cohorts.associated.with.section.product.icon.loc"));
				if(CollectionUtils.isNotEmpty(iconElement)) {
					logger.info("Products icon is not clicked, clicking it now");
					// Clicking on products icons. 
					iconElement.get(0).click();
					// Entering value in Search by Cohort
					List<WebElement> searchElement = baseHandler.findElements(PropertiesRepository.getString("id.products.search.by.cohort.input.type.loc"));
					if(CollectionUtils.isNotEmpty(searchElement)) {
						searchElement.get(0).sendKeys(PropertiesRepository.getString("id.products.search.by.cohort.input.type.value"));
						waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
						// Verifying name after searching. 
						if(verifyCohortInProductsPage(PropertiesRepository.getString("id.products.search.by.cohort.input.type.value"))) {
							flag = true;
						} else {
							logger.info("Cohort name is not matched after searching in dashboard");
						}
					}
				} else {
					logger.info("Products Icon element is not present");
				}
			} else { // It is not opened.  id.products.cohort.dashboard.list.loc
				logger.info("Products icon is clicked, searching cohort and verifying cohort name");
				// Entering value in Search by Cohort
				List<WebElement> searchElement = baseHandler.findElements(PropertiesRepository.getString("id.products.search.by.cohort.input.type.loc"));
				if(CollectionUtils.isNotEmpty(searchElement)) {
					searchElement.get(0).sendKeys(PropertiesRepository.getString("id.products.search.by.cohort.input.type.value"));
					// Verifying name after searching. 
					if(verifyCohortInProductsPage(PropertiesRepository.getString("id.products.search.by.cohort.input.type.value"))) {
						flag = true;
					} else {
						logger.info("Cohort name is not matched after searching in dashboard");
					}
				}
			}
		}catch (Exception e) {
    		logger.info("Unable to clickSearchByCohortSection" );
			log(logger, "Unable to clickSearchByCohortSection" );
    		throw new DriverException("Unable to clickSearchByCohortSection" , e); 
    	}
		logger.info("Method: clickSearchByCohortSection End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to verify cohort and its name in dashboard
	 *  
	 * @author saravanan.jothimani
	 * @param cohortName
	 * @return
	 * @throws Exception
	 */
	public boolean verifyCohortInProductsPage(String cohortName) throws Exception {
		logger.info("Method : verifyCohortInProductsPage Start");
		boolean flag = false;
		try {
			WebElement element = verifyElement(PropertiesRepository.getString("id.products.cohort.dashboard.list.loc"));
			if(element != null) {
				WebElement cohortNameElement = verifyElement(PropertiesRepository.getString("id.products.cohort.dashboard.cohort.name.loc"));
				if(cohortNameElement != null) {
					if(cohortName.equalsIgnoreCase(cohortNameElement.getText().trim())) {
						flag = true;
					}
				} else {
					logger.info("Cohort name is not matched");
				}
			} else {
				logger.info("Cohort is not displayed in Product page after searching");
			}
		}catch (Exception e) {
    		logger.info("Unable to verifyCohortInProductsPage" );
			log(logger, "Unable to verifyCohortInProductsPage" );
    		throw new DriverException("Unable to verifyCohortInProductsPage" , e); 
    	}
		logger.info("Method: verifyCohortInProductsPage End flag --> " + flag);
		return flag;
	}

	/**
	 * Method used to click on Tutorial Manage button for Personnel User. 
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws Exception
	 */
	public boolean clickTutorialManageButtonForPersonnelUser() throws Exception {
		logger.info("Method : clickTutorialManageButtonForPersonnelUser Start");
		boolean flag = false;
		try {
			// Verifying Course Work
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("id.product.course.work.portlet.title.loc"));
			if(CollectionUtils.isNotEmpty(element) && element.get(0).getText().trim().equalsIgnoreCase(PropertiesRepository.getString("id.product.page.tutorial.header.value"))) {
				// Verifying Tutorials, Quiz Banks and Simulations
				List<WebElement> portletNameElement = verifyElementList(PropertiesRepository.getString("id.product.course.work.tutorials.quiz.bank.and.simulation.loc"));
				if(CollectionUtils.isNotEmpty(portletNameElement)) {
					StringBuffer sb = new StringBuffer(PropertiesRepository.getString("id.product.course.work.tutorials.quiz.bank.and.simulation.value1"));
					sb.append(", ").append(PropertiesRepository.getString("id.product.course.work.tutorials.quiz.bank.and.simulation.value2"));
					if(sb.toString().trim().equalsIgnoreCase(portletNameElement.get(0).getText())) {
						// Verifying Products Available and count. 
						List<WebElement> productAvailableElement = verifyElementList(PropertiesRepository.getString("id.product.course.work.products.available.loc"));
						List<WebElement> productAvailableCountElement = verifyElementList(PropertiesRepository.getString("id.product.course.work.products.available.count.loc"));
						if(CollectionUtils.isNotEmpty(productAvailableElement) && CollectionUtils.isNotEmpty(productAvailableCountElement)
								&& productAvailableElement.get(0).getText().equalsIgnoreCase(PropertiesRepository.getString("id.product.course.work.products.available.value"))) {
							int availableCount = Integer.parseInt(productAvailableCountElement.get(0).getText());
							if(availableCount >= 0) {
								// Manage button section
								List<WebElement> manageBtnElement = baseHandler.findElements(PropertiesRepository.getString("id.product.page.tutorial.manage.button.loc"));
								if(CollectionUtils.isNotEmpty(manageBtnElement)) {
									manageBtnElement.get(0).click();
									waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
									flag = true;
								} else {
									logger.info("Unable to click on Manage button");
								}
							} else {
								logger.info("Unable to verify Product Available count");
							}
						} else {
							logger.info("Unable to verify Product Available section");
						}
						
					} else {
						logger.info("Unable to verify Tutorial, Quiz Banks and Simulations");
					}
				} else {
					logger.info("Unable to verify Course Work");
				}
			}
		}catch (Exception e) {
    		logger.info("Unable to clickTutorialManageButtonForPersonnelUser" );
			log(logger, "Unable to clickTutorialManageButtonForPersonnelUser" );
    		throw new DriverException("Unable to clickTutorialManageButtonForPersonnelUser" , e); 
    	}
		logger.info("Method: clickTutorialManageButtonForPersonnelUser End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to institution name in Product Page. 
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws Exception
	 */
	public boolean enterInsititionNameInProductPage(String institutionName) throws Exception {
		logger.info("Method : enterInsititionNameInProductPage Start");
		boolean flag = false;
		try {
			// Clicking on existing institution name
			List<WebElement> element = baseHandler.findElements("mat-form-field mat-select div[class='mat-select-trigger']");
			if(CollectionUtils.isNotEmpty(element)) {
				element.get(0).click();
				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				// Getting institution list from select. 
				List<WebElement> selectElement = baseHandler.findElements("div[class='mat-select-content ng-trigger ng-trigger-fadeInContent'] mat-option");
				if(CollectionUtils.isNotEmpty(selectElement)) {
					for(WebElement selElement : selectElement) {
						WebElement txtElement = selElement.findElement(By.cssSelector("span"));
						if(txtElement != null && institutionName.equalsIgnoreCase(txtElement.getText().trim())) {
							txtElement.click();
							flag =true;
							waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
							break;
						}
					}
					
				} else {
					logger.info("Unable to find institution list");
				}
			} else {
				logger.info("Unable to click institution ");
			}
		}catch (Exception e) {
    		logger.info("Unable to enterInsititionNameInProductPage" );
			log(logger, "Unable to enterInsititionNameInProductPage" );
    		throw new DriverException("Unable to enterInsititionNameInProductPage" , e); 
    	}
		logger.info("Method: enterInsititionNameInProductPage End flag --> " + flag);
		return flag;
	}
	
}
