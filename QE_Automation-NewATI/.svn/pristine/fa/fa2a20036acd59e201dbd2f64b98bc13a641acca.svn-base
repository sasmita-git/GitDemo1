package com.automation.newati.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ascendlearning.automation.ui.assertions.VerificationHandler;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.TextHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;

public class LearnTabPage extends NewATIBasePage {

	private Logger logger = LogManager.getLogger(this.getClass());
	private BaseHandler baseHandler;
	private TextHandler textHandler;
	private WindowHandler windowHandler;
	private ArrayList<String> listOfTutorialsWithSpeedometer = new ArrayList<String>();
	private Map<String, String> tutorialsWithSpeedometerWithValues = new HashMap<String, String>();
	private Map<String, String> moduleNamesWithSpeedometerStatus = new HashMap<String, String>();

	public LearnTabPage(WebDriver driver) {
		super(driver);
		baseHandler = new BaseHandler(driver);
		textHandler = new TextHandler(driver);
		windowHandler = new WindowHandler(driver);
	}

	public void clickInfoIconByName(String productName) throws Exception {
		logger.info("Method: clickInfoIconByName Start");
		List<WebElement> moduleList = baseHandler
				.findElements(PropertiesRepository.getString("new-atitesting.learntab.all.modules.loc"));
		if (moduleList != null && moduleList.size() > 0) {
			int size = moduleList.size();
			for (int i = 0; i < size; i++) {
				WebElement element = moduleList.get(i).findElement(By.cssSelector(
						PropertiesRepository.getString("new-atitesting.learntab.specific.modules.name.loc")));
				WebElement element1 = moduleList.get(i);
				if (productName.equalsIgnoreCase(element.getText())) {
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
							element1.findElement(By.cssSelector(PropertiesRepository
									.getString("new-atitesting.learntab.specific.modules.info.icon.loc"))));
					element1.findElement(By.cssSelector(
							PropertiesRepository.getString("new-atitesting.learntab.specific.modules.info.icon.loc")))
							.click();
					Thread.sleep(10000);
					break;
				}
			}
		}
		logger.info("Method: clickInfoIconByName End");
	}

	public void verifyAddedProduct(String ProductID) throws Exception {
		logger.info("Method: verifyAddedProduct Start");
		List<WebElement> elements = baseHandler
				.findElements(PropertiesRepository.getString("new-atitesting.product.information.popup.loc"));
		if (CollectionUtils.isNotEmpty(elements)) {
			VerificationHandler.verifyEquals(ProductID, elements.get(1).getText());
		} else {
			logger.info("Not able to find the added product");
		}
		logger.info("Method: verifyAddedProduct End");
	}

	public boolean verifyIfProductAdded(String ProductID) throws Exception {
		logger.info("Method: verifyIfProductAdded Start ");
		boolean flag = false;
		try {
			List<WebElement> elements = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.product.information.popup.loc"));
			if (CollectionUtils.isNotEmpty(elements)) {
				VerificationHandler.verifyEquals(ProductID, elements.get(1).getText());
				flag = (ProductID.equals(elements.get(1).getText()));
			}
		} catch (Exception e) {
			logger.info("Product is not added");
			throw new Exception("Product is not added");
		}
		logger.info("Method: verifyIfProductAdded End flag --> " + flag);
		return flag;

	}
	
	public boolean verifyIfProductAddedFromSecondCDN(String ProductID) throws Exception { 
		logger.info("Method: verifyIfProductAdded Start");
		boolean flag = false;
		try {
			List<WebElement> elements = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.product.information.popup.loc"));
			if (CollectionUtils.isNotEmpty(elements)) {
				System.out.println(elements.get(1).getText());
				VerificationHandler.verifyEquals(ProductID, elements.get(1).getText());
				flag = (ProductID.equals(elements.get(1).getText()));
			}
		} catch (Exception e) {
			logger.info("Product is not added");
			throw new Exception("Product is not added");
		}
		logger.info("Method: verifyIfProductAdded End flag --> " + flag);
		return flag;
	}

	/**
	 * Method is used to Verify Added EbookName
	 * 
	 * Ebook Name, Product ID
	 * 
	 * @throws Exception
	 */

	public void verifyAddedEbook(String EbookName) throws Exception {
		logger.info("Method: verifyAddedEbook Start");
		List<WebElement> elements = baseHandler
				.findElements(PropertiesRepository.getString("new-atitesting.product.information.popup.loc"));
		if (CollectionUtils.isNotEmpty(elements)) {

			System.out.println("Product Name=" + elements.get(0).getText());
			VerificationHandler.verifyEquals(EbookName, elements.get(0).getText());
		}
		logger.info("Method: verifyAddedEbook End");
	}

	/**
	 * Method is to Verify that Virtual Classroom Capstone product is displayed
	 * 
	 * Edition Name
	 * 
	 * @throws Exception
	 */

	public boolean verifyUpdatedEdition(String edition) throws Exception {
		logger.info("Method: verifyUpdatedEdition Start");
		boolean flag = false;
		String result = null;
		try {
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.learn.tab.edition.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				result = element.get(0).getText();
				if (StringUtils.isNotBlank(result) && result.equalsIgnoreCase(edition)) {
					flag = true;
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verifyUpdatedEdition");
			log(logger, "Unable to verifyUpdatedEdition");
			throw new DriverException("Unable to verifyUpdatedEdition", e);
		}
		logger.info("Method: verifyUpdatedEdition End flag --> " + flag);
		return flag;
	}

	/**
	 * Method is to Verify updated RN Review Modules 2016 Package
	 * 
	 * @throws Exception
	 */

	public void verifyUpdatedRNReviewModulesEdition() throws Exception {
		logger.info("Method: verifyUpdatedRNReviewModulesEdition Start");
		List<WebElement> elements = baseHandler.findElements(".ebook-row>header>span");
		if (CollectionUtils.isNotEmpty(elements)) {

			VerificationHandler.verifyEquals("Adult Medical Surgical Nursing PN Review Module 9.0", elements.get(0).getText());
			VerificationHandler.verifyEquals("Community Health RN 7.0", elements.get(3).getText());
			VerificationHandler.verifyEquals("Fundamentals for Nursing 9.0", elements.get(4).getText());
			VerificationHandler.verifyEquals("Leadership and Management 7.0", elements.get(6).getText());
			VerificationHandler.verifyEquals("Maternal Newborn Nursing RN 10.0", elements.get(8).getText());
			VerificationHandler.verifyEquals("Mental Health Nursing RN 10.0", elements.get(10).getText());
			VerificationHandler.verifyEquals("Nursing Care of Children RN 10.0", elements.get(12).getText());
			VerificationHandler.verifyEquals("Nutrition for Nursing 6.0", elements.get(14).getText());
			VerificationHandler.verifyEquals("Pharmacology for Nursing RN 7.0", elements.get(16).getText());
		}
		logger.info("Method: verifyUpdatedRNReviewModulesEdition End");
	}

	/**
	 * Method is to Verify Offset Page Settings RN Review Modules
	 * 
	 * @throws Exception
	 */

	public void verifyOffsetPageSettings() throws Exception {
		logger.info("Method: verifyOffsetPageSettings Start");
		textHandler.writeText(
				PropertiesRepository.getString("new-atitesting.learn.tab.ebook.pdf.pagenumber.textbox.loc"),
				PropertiesRepository.getString("new-atitesting.learn.tab.ebook.pdf.pagenumber"));

		waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		VerificationHandler
				.verifyEquals(PropertiesRepository.getString("new-atitesting.learn.tab.ebook.pdf.pagenumber"),
						baseHandler.findElement(
								PropertiesRepository.getString("new-atitesting.learn.tab.ebook.pdf.pagenumber.loc"))
								.getText());
		logger.info("Method: verifyOffsetPageSettings End");
	}

	/**
	 * Method is to Verify Offset Page Settings RN Review Modules
	 * 
	 * @throws Exception
	 */

	public void clickOnPdfBookButton() throws Exception {
		logger.info("Method: clickOnPdfBookButton Start");
		List<WebElement> elements = baseHandler
				.findElements(PropertiesRepository.getString("new-atitesting.learn.tab.ebook.pdfbookbtn"));
		if (CollectionUtils.isNotEmpty(elements)) {
			elements.get(1).click();
		}
		logger.info("Method: clickOnPdfBookButton End");
	}

	/**
	 * Method is used to Select from Content Area dropdown
	 * 
	 * Content Area Name
	 * 
	 * @throws Exception
	 */

	public void selectFromContentAreaDropdown(String ContentAreaName) throws Exception {
		logger.info("Method: selectFromContentAreaDropdown Start");
		Select select = new Select(baseHandler
				.findElement(PropertiesRepository.getString("new-atitesting.learn.tab.contentareadropdown.loc")));
		select.selectByVisibleText(ContentAreaName);
		logger.info("Method: selectFromContentAreaDropdown End");
	}

	/**
	 * Method is to Verify that Virtual Classroom Capstone product is displayed
	 * 
	 * Product Name
	 * 
	 * @throws Exception
	 */

	public void verifyVirtualClassroomCapstonProduct(String ProductName) throws Exception {
		logger.info("Method: verifyVirtualClassroomCapstonProduct Start");
		List<WebElement> elements = baseHandler
				.findElements(PropertiesRepository.getString("new-atitesting.learn.tab.admission.content"));
		if (CollectionUtils.isNotEmpty(elements)) {

			for (int i = 0; i < elements.size(); i++) {
				VerificationHandler.verifyNotEquals(ProductName, elements.get(i).getText());
			}
		}
		logger.info("Method: verifyVirtualClassroomCapstonProduct End");
	}

	/**
	 * Method is used check if Never accessed Tutorials have Speedometer value
	 * as 0%
	 * 
	 * 
	 * @author syed.pasha
	 * @throws DriverException
	 */
	public boolean VerifyNeverAccessedSpedoAsZero() throws Exception {
		logger.info("Method: VerifyNeverAccessedSpedoAsZero Start");
		boolean flag = false;
		try {

			List<WebElement> moduleList = baseHandler.findElements(".flipper section[class='card front tutorial']");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					WebElement element = moduleList.get(i).findElement(By.cssSelector("footer span span"));
					WebElement elementToFind = moduleList.get(i);
					if (element != null) {
						// If Tutorial is never accesses and is Speedometer is
						// present
						if (("Never".equalsIgnoreCase(element.getText())) && (moduleList.get(i)
								.findElements(By.cssSelector("footer a div div[class='usage-overlay-50']"))
								.size() != 0)) {
							if (elementToFind != null) {
								flag = "0%".equals(moduleList.get(i)
										.findElement(By.cssSelector("footer a div div div span")).getText());
							}
						}
					}
				}
			}
		} catch (Exception e) {
			logger.info("Never accessed tutorials does not have speedometer value as 0%");
			throw new Exception("Never accessed tutorials does not have speedometer value as 0%");
		}
		logger.info("Method: VerifyNeverAccessedSpedoAsZero End --> " + flag);
		return flag;
	}

	/**
	 * Method initialize's the Arraylist with list of Tutorials with
	 * Speedometer.
	 * 
	 * 
	 * @author syed.pasha
	 * @throws DriverException
	 */
	public void AddArrayListwithTutorialsWithSpedometer() throws Exception {
		logger.info("Method: VerifyAddArrayListwithTutorialsWithSpedometer Start");
		boolean flag = false;
		try {

			List<WebElement> moduleList = baseHandler.findElements(".flipper section[class='card front tutorial']");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					WebElement element = moduleList.get(i)
							.findElement(By.cssSelector("section div[class='description']"));
					if ((element != null) && (moduleList.get(i)
							.findElements(By.cssSelector("footer a div div[class='usage-overlay-50']")).size() != 0)) {
						listOfTutorialsWithSpeedometer.add(element.getText());

					}
				}
			}
		} catch (Exception e) {
			logger.info("List not initalized");
			throw new Exception("List not initalized");
		}
		logger.info("Method: VerifyAddArrayListwithTutorialsWithSpedometer End --> " + flag);

	}

	/**
	 * Method initialize's the Map with list of Tutorials with Speedometer and
	 * Its values.
	 * 
	 * 
	 * @author syed.pasha
	 * @throws DriverException
	 */
	public void AddTutorialsWithSpedometerAndvaluesInMap() throws Exception {
		logger.info("Method: AddTutorialsWithSpedometerAndvaluesInMap Start");
		boolean flag = false;
		try {

			List<WebElement> moduleList = baseHandler.findElements(".flipper section[class='card front tutorial']");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					WebElement element = moduleList.get(i)
							.findElement(By.cssSelector("section div[class='description']"));
					if ((element != null) && (moduleList.get(i)
							.findElements(By.cssSelector("footer a div div[class='usage-overlay-50']")).size() != 0)) {
						tutorialsWithSpeedometerWithValues.put(element.getText(),
								moduleList.get(i)
										.findElement(
												By.cssSelector("footer a div div[class='usage-overlay-50'] div span"))
										.getText());
					}
				}
			}
		} catch (Exception e) {
			logger.info("Map not initialized");
			throw new Exception("Map not initalized");
		}
		logger.info("Method: AddTutorialsWithSpedometerAndvaluesInMap End --> " + flag);

	}

	/**
	 * Verify if Speedometer info table is present
	 * 
	 * 
	 * @author syed.pasha
	 * @param assessmentName
	 * @throws DriverException
	 */
	public boolean VerifyifInfoTablePresent() throws Exception {
		logger.info("Method: VerifyNeverAccessedSpedoAsZero Start ");
		boolean flag = false;
		String tableHeaderActual = "";
		try {
			System.out.println("");
			List<WebElement> moduleList = baseHandler.findElements(".flipper section[class='card front tutorial']");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					if (moduleList.get(i).findElements(By.cssSelector("footer a div div[class='usage-overlay-50")).size()>0) {
						moduleList.get(i).findElement(By.cssSelector("footer a div div[class='usage-overlay-50']")).click();
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						List<WebElement> tableHeader = moduleList.get(i).findElements(By.cssSelector("table tbody tr"));
						for (int j = 0; j < tableHeader.size(); j++) {
							tableHeaderActual = tableHeaderActual+ (tableHeader.get(j).findElement(By.cssSelector("td")).getText()) + ",";
						}
						flag = "Total Modules,Accessed Modules,Recent Score,Time Spent,Time Suggested,".equals(tableHeaderActual);
						break;
					}
				}
			}
		} catch (Exception e) {
			logger.info("Speedometer info table is not present");
			throw new Exception("Speedometer info table is not present");
		}
		logger.info("Method: VerifyNeverAccessedSpedoAsZero End --> " + flag);
		return flag;
	}

	/**
	 * Click on close button of info table
	 * 
	 * 
	 * @author syed.pasha
	 * @throws DriverException
	 */
	public boolean clickOnInfoTableCloseBtn() throws Exception {
		logger.info("Method: clickOnInfoTableCloseBtn Start");
		boolean flag = false;
		try {
			List<WebElement> moduleList = baseHandler.findElements(".flipper section[class='card front tutorial']");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					if (moduleList.get(i).findElements(By.cssSelector("div div[class='learn-card-front-usage usage-container'] div button")).size()>0) {
						moduleList.get(i).findElement(By.cssSelector("div div[class='learn-card-front-usage usage-container'] div button")).click();
						flag = (moduleList.get(i).findElement(By.cssSelector("table tbody tr td"))).isDisplayed();
						break;
					}
				}
			}
		} catch (Exception e) {
			logger.info("Could not click on close button of info table or the info table is not closed");
			throw new Exception("Could not click on close button of info table or the info table is not closed");
		}
		logger.info("Method: clickOnInfoTableCloseBtn End --> " + flag);
		return flag;
	}

	/**
	 * Click on Module Button which is having Speedometer
	 * 
	 * 
	 * @author syed.pasha
	 * @param assessmentName
	 * @throws DriverException
	 */
	public void clickOnModuleWithSpeedometer() throws Exception {
		logger.info("Method: clickOnModuleWithSpeedometer Start");
		try {
			List<WebElement> moduleList = baseHandler.findElements(".flipper section[class='card front tutorial']");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					if (moduleList.get(i).findElements(By.cssSelector("footer a div div[class='usage-overlay-50")).size()>0) {
						moduleList.get(i)
								.findElement(By.cssSelector(
										"nav[class='actions'] div[data-bind*='visible: !Tutorial.HasMultipleLearningLoopItems()'] a[class='button primary-button cardflip focus-element-flag']"))
								.click();
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						baseHandler.waitForPageToLoad(PropertiesRepository
								.getString("new-atitesting.learntab.tutorial.stt.all.card.front.button"));
						break;
					}
				}
			}
		} catch (Exception e) {
			logger.info("Not able to Click on Module with Speedometer");
			throw new Exception("Not able to Click on Module with Speedometer");
		}
		logger.info("Method: clickOnModuleWithSpeedometer End --> ");

	}

	/**
	 * Verify Table header for Speedometer on Card Back
	 * 
	 * 
	 * @author syed.pasha
	 * @param assessmentName
	 * @throws DriverException
	 */
	public boolean verifyUsageTableHeader(String locator, String expectedHeader) throws Exception {

		logger.info("Method: verifyUsageTableHeader Start");
		boolean flag = false;
		String tableHeaderActual = "";
		try {
			System.out.println("");
			List<WebElement> moduleList = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(moduleList)) {
				List<WebElement> tableHeader = moduleList.get(0).findElements(By.cssSelector(" tbody tr th"));
				for (int j = 0; j < tableHeader.size(); j++) {
					tableHeaderActual = tableHeaderActual + (tableHeader.get(j).getText()) + ",";
				}
				flag = tableHeaderActual.contains(expectedHeader);
			}
		} catch (Exception e) {
			logger.info("Cannot verify Table header");
			throw new Exception("Cannot verify Table header");
		}
		logger.info("Method: verifyUsageTableHeader End --> " + flag);
		return flag;
	}
	
	/**
	 * Verify Table header for Speedometer on Card Front
	 * 
	 * 
	 * @author syed.pasha
	 * @param assessmentName
	 * @throws DriverException
	 */
	public boolean verifyUsageTableHeaderCF(String locator, String expectedHeader) throws Exception {

		logger.info("Method: verifyUsageTableHeaderCF Start");
		boolean flag = false;
		String tableHeaderActual = "";
		try {
			System.out.println("");
			List<WebElement> moduleList = baseHandler.findElements(locator);
			if (CollectionUtils.isNotEmpty(moduleList)) {
				for (int j = 0; j < moduleList.size(); j++) {
					if(moduleList.get(j).isDisplayed())
					{
					tableHeaderActual = tableHeaderActual + (moduleList.get(j).getText()) + ",";
					}
				}
				flag = tableHeaderActual.contains(expectedHeader);
			}
		} catch (Exception e) {
			logger.info("Cannot verify Table header");
			throw new Exception("Cannot verify Table header");
		}
		logger.info("Method: verifyUsageTableHeaderCF End --> " + flag);
		return flag;
	}

	/**
	 * Verify if Ebook is present
	 * 
	 * 
	 * @author syed.pasha
	 * @param assessmentName
	 * @throws DriverException
	 */
	public boolean verifyEbookCardFront(String ebookName) throws Exception {

		logger.info("Method: verifyEbookCardFront Start");
		boolean flag = false;
		try {
			List<WebElement> moduleList = baseHandler
					.findElements(".flipper section[class='card front ebook'] div[class='description']");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				for (int i = 0; i < moduleList.size(); i++) {
					if (moduleList.get(i).getText().equals(ebookName)) {
						flag = true;
						break;
					}
				}
			}
		} catch (Exception e) {
			logger.info("Cannot verifyEbookCardFront");
			throw new Exception("Cannot verifyEbookCardFront");
		}
		logger.info("Method: v End --> " + flag);
		return flag;
	}

	/**
	 * Comparing actual and expected array lists of Tutorials
	 * 
	 * 
	 * @author syed.pasha
	 * @throws DriverException
	 */
	public boolean VerifySVandFVTutorialListAreEqual() throws Exception {
		logger.info("Method: VerifySVandFVTutorialListAreEqual Start");
		boolean flag = false;
		try {
			ArrayList<String> actualTutorialList = new ArrayList<String>();
			List<WebElement> moduleList = baseHandler
					.findElements(PropertiesRepository.getString("se.std.tutorial.list.loc"));
			if (CollectionUtils.isNotEmpty(moduleList)) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					actualTutorialList.add(moduleList.get(i).getText());
				}
			}
			flag = listOfTutorialsWithSpeedometer.containsAll(actualTutorialList)
					&& actualTutorialList.containsAll(listOfTutorialsWithSpeedometer);

		} catch (Exception e) {
			logger.info("Tutorial List for SV and FV are not Equal");
			throw new Exception("Tutorial List for SV and FV are not Equal");
		}
		logger.info("Method: VerifySVandFVTutorialListAreEqual End --> " + flag);
		return flag;
	}

	/**
	 * Comparing actual and expected HashMap for Tutorials and its Speedometer
	 * Values
	 * 
	 * 
	 * @author syed.pasha
	 * @throws DriverException
	 */
	public boolean VerifySVandFVTutorialListAndItsValueAreEqual() throws Exception {
		logger.info("Method: VerifySVandFVTutorialListAndItsValueAreEqual Start");
		boolean flag = false;
		try {
			Map<String, String> actualTutorialListAndValues = new HashMap<String, String>();
			List<WebElement> moduleList = baseHandler
					.findElements(PropertiesRepository.getString("se.std.tutorial.list.loc"));
			List<WebElement> moduleListValues = baseHandler
					.findElements(PropertiesRepository.getString("se.std.tutorial.list.speedometer.value.loc"));
			if (CollectionUtils.isNotEmpty(moduleList) && CollectionUtils.isNotEmpty(moduleListValues)
					&& (moduleList.size() == moduleListValues.size())) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					actualTutorialListAndValues.put(moduleList.get(i).getText(), moduleListValues.get(i).getText());
				}
			}
			if (actualTutorialListAndValues.size() == tutorialsWithSpeedometerWithValues.size()) {
				Map<String, String> actualTutorialListAndValuesSorted = new TreeMap<>(actualTutorialListAndValues);
				Map<String, String> tutorialsWithSpeedometerWithValuesSorted = new TreeMap<>(
						tutorialsWithSpeedometerWithValues);
				flag = tutorialsWithSpeedometerWithValuesSorted.equals(actualTutorialListAndValuesSorted);
			}

		} catch (Exception e) {
			logger.info("Tutorial List and its Speedometer Value for SV and FV are not Equal");
			throw new Exception("Tutorial List and Its Speedometer value for SV and FV are not Equal");
		}
		logger.info("Method: VerifySVandFVTutorialListAndItsValueAreEqual End --> " + flag);
		return flag;
	}

	/**
	 * Comparing actual and expected HashMap for Tutorials and its Speedometer
	 * Values
	 * 
	 * 
	 * @author syed.pasha
	 * @throws DriverException
	 */
	public boolean VerifySVandFVModuleListAndItsSpeedometerValueAreEqual() throws Exception {
		logger.info("Method: VerifySVandFVModuleListAndItsSpeedometerValueAreEqual Start");
		boolean flag = false;
		try {
			Map<String, String> actualModuleListAndValues = new HashMap<String, String>();
			List<WebElement> moduleList = baseHandler
					.findElements(PropertiesRepository.getString("se.std.tutorial.modules.loc"));
			List<WebElement> moduleListValues = baseHandler
					.findElements(PropertiesRepository.getString("se.std.tutorial.modules.speedometer.value.loc"));
			if (CollectionUtils.isNotEmpty(moduleList) && CollectionUtils.isNotEmpty(moduleListValues)
					&& (moduleList.size() == moduleListValues.size())) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					String splitedString = moduleList.get(i).getText().split(": ")[1];
					actualModuleListAndValues.put(splitedString, moduleListValues.get(i).getText());
				}
			}
			if (actualModuleListAndValues.size() == moduleNamesWithSpeedometerStatus.size()) {
				Map<String, String> actualModuleListAndValuesSorted = new TreeMap<>(actualModuleListAndValues);
				Map<String, String> moduleNamesWithSpeedometerStatusSorted = new TreeMap<>(
						moduleNamesWithSpeedometerStatus);
				flag = moduleNamesWithSpeedometerStatusSorted.equals(actualModuleListAndValuesSorted);
			}

		} catch (Exception e) {
			logger.info("Module List and its Speedometer Value for SV and FV are not Equal");
			throw new Exception("Module List and Its Speedometer value for SV and FV are not Equal");
		}
		logger.info("Method: VerifySVandFVModuleListAndItsSpeedometerValueAreEqual End --> " + flag);
		return flag;
	}

	/**
	 * Verify if enabled tutorials are displayed
	 * 
	 * 
	 * @author syed.pasha
	 * @throws DriverException
	 */
	public boolean VerifyIfEnabledTutorialsDisplayed() throws Exception {
		logger.info("Method: VerifyIfEnabledTutorialsDisplayed Start");
		boolean flag = false;
		
		WebDriverWait wait = new WebDriverWait(driver,120);
		wait.until(new ExpectedCondition<Boolean>() {
		    public Boolean apply(WebDriver driver) {
		        WebElement button = driver.findElement(By.cssSelector("div[data-bind='visible: IsTab1Loading']"));
		        String enabled = button.getAttribute("style");
				if (enabled.equals("display: none;")) {
					logger.info("Products load complete.");
					return true;
				} else {
					logger.info("Products are still loading......");
					return false;
				}
		    }
		});
		
		try {

			List<WebElement> moduleList = baseHandler.findElements(".flipper section[class='card front tutorial']");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				flag = true;
			}
		} catch (Exception e) {
			logger.info("There are no enabled tutorials");
			throw new Exception("There are no enabled tutorials");
		}
		logger.info("Method: VerifyIfEnabledTutorialsDisplayed End --> " + flag);
		return flag;
	}

	/**
	 * Verify if enabled eBooks are displayed
	 * 
	 * 
	 * @author syed.pasha
	 * @throws DriverException
	 */
	public boolean VerifyIfEnabledEbooksDisplayed() throws Exception {
		logger.info("Method: VerifyIfEnabledEbooksDisplayed Start");
		boolean flag = false;
		try {

			List<WebElement> moduleList = baseHandler.findElements(".flipper section[class='card front ebook']");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				flag = true;
			}
		} catch (Exception e) {
			logger.info("There are no enabled eBooks");
			throw new Exception("There are no enabled eBooks");
		}
		logger.info("Method: VerifyIfEnabledEbooksDisplayed End --> " + flag);
		return flag;
	}
	
	/**
	 * Verify if Speedometer is Displayed on all active tutorials except ATI
	 * TEAS SmartPrep tutorial.
	 * 
	 * 
	 * @author syed.pasha
	 * @throws DriverException
	 */
	public boolean VerifyIfSpeedometerIsDisplayedOnAllTutorials() throws Exception {
		logger.info("Method: VerifyIfSpeedometerIsDisplayedOnAllTutorials Start");
		boolean flag = false;
		try {

			List<WebElement> moduleList = baseHandler.findElements(".flipper section[class='card front tutorial']");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				int size = moduleList.size();
				for (int i = 0; i < size - 1; i++) {
					WebElement element = moduleList.get(i).findElement(By.cssSelector("section div[class='description']"));
					if ((element != null) && !(element.getText().equals("ATI TEAS SmartPrep")) && !(element.getText().equals("Access™ NCLEX-RN Video Review"))) {
						if ((moduleList.get(i).findElements(By.cssSelector("footer a div div[class='usage-overlay-50']")).size() != 0)) {
							flag = true;
						} else {
							flag = false;
							break;
						}
					}
				}

			}
		} catch (Exception e) {
			logger.info("Not all enabled Tutorials have Speedometer");
			throw new Exception("Not all enabled Tutorials have Speedometer");
		}
		logger.info("Method: VerifyIfSpeedometerIsDisplayedOnAllTutorials End --> " + flag);
		return flag;
	}

	/**
	 * Initializing Hashmap with module names and Speedometer value
	 * 
	 * 
	 * @author syed.pasha
	 * @throws DriverException
	 */
	public void InitializeMapWithModuleNameAndApeedometerValue() throws Exception {
		logger.info("Method: InitializeMapWithModuleNameAndApeedometerValue Start");
		try {
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			List<WebElement> moduleNameList = baseHandler.findElements(".product-result-take");
			List<WebElement> speedometerList = baseHandler.findElements(".usage-overlay-60-back");
			if (CollectionUtils.isNotEmpty(moduleNameList) && CollectionUtils.isNotEmpty(speedometerList)
					&& (moduleNameList.size() == speedometerList.size())) {
				int size = moduleNameList.size();
				for (int i = 0; i < size; i++) {
					// Map stores the name of module and its speedometer value
					moduleNamesWithSpeedometerStatus.put(moduleNameList.get(i).getText(),
							speedometerList.get(i).findElement(By.cssSelector("div span")).getText());
				}
			}
		} catch (Exception e) {
			logger.info("Cannot initialize Map-Speedometer might not be present");
			throw new Exception("Cannot initialize Map-Speedometer might not be present");
		}
		logger.info("Method: InitializeMapWithModuleNameAndApeedometerValue End ");

	}

	/**
	 * Method is used click Never accessed Tutorials with speedometer
	 * 
	 * 
	 * @author syed.pasha
	 * @throws DriverException
	 */

	public void clickModuleButtonNeverAccessed() throws Exception {
		logger.info("Method: clickModuleButtonNeverAccessed Start");
		List<WebElement> moduleList = baseHandler.findElements(".flipper section[class='card front tutorial']");
		if (CollectionUtils.isNotEmpty(moduleList)) {
			int size = moduleList.size();
			for (int i = 0; i < size; i++) {
				WebElement element = moduleList.get(i).findElement(By.cssSelector("footer span span"));
				if (element != null) {
					// If Tutorial is never accesses and is Speedometer is
					// present
					if (("Never".equalsIgnoreCase(element.getText())) && (moduleList.get(i)
							.findElements(By.cssSelector("footer a div div[class='usage-overlay-50']")).size() != 0)) {
						{
							moduleList.get(i)
									.findElement(By.cssSelector(
											"nav[class='actions'] div[data-bind*='visible: !Tutorial.HasMultipleLearningLoopItems()'] a[class='button primary-button cardflip focus-element-flag']"))
									.click();
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
							break;
						}
					}
				}
			}
		}
	}

	/**
	 * Method is used check if Never Accessed Module Speedometer have value as
	 * 0%
	 * 
	 * 
	 * @author syed.pasha
	 * @throws DriverException
	 */
	public boolean VerifyNeverAccessedModuleZeroSMValue(String SMloc) throws Exception {
		logger.info("Method: VerifyNeverAccessedModuleZeroSMValue Start ");
		boolean flag = false;
		try {
			List<WebElement> moduleList = baseHandler.findElements(".product-list-style>li ");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				int size = moduleList.size();
				for (int i = 0; i < size - 1; i++) {
					WebElement footerElement = moduleList.get(i).findElement(
							By.cssSelector(PropertiesRepository.getString("new-atitesting.learn.tab.module.accessed")));
					WebElement speedometerElement = moduleList.get(i)
							.findElement(By.cssSelector(PropertiesRepository.getString(SMloc)));
					if (("Never".equals(footerElement.getText())) && ("0%".equals(speedometerElement.getText()))) {
						flag = true;
						break;
					} else {
						flag = false;
						break;
					}
				}
			}
		} catch (Exception e) {
			logger.info("Never Accessed Module Speedometer does not have value as 0%");
			throw new Exception("Never Accessed Module Speedometer does not have value as 0%");
		}
		logger.info("Method: VerifyNeverAccessedModuleZeroSMValue End --> " + flag);
		return flag;
	}

	/**
	 * Method is used check if Element is displayed
	 * 
	 * 
	 * @author syed.pasha
	 * @throws DriverException
	 */
	public boolean IsDisplayed(String locator) throws Exception {
		logger.info("Method: IsDisplayed Start ");
		boolean flag = false;
		try {
			flag = checkElementDispalyed(locator);
		} catch (Exception e) {
			logger.info("Element is not present");
			throw new Exception("Element is not present");
		}
		logger.info("Method: IsDisplayed End --> " + flag);
		return flag;
	}

	/**
	 * Click on close button of info table on Card back
	 * 
	 * 
	 * @author syed.pasha
	 * @throws DriverException
	 */
	public boolean clickOnInfoTableCloseBtnCardBack() throws Exception {
		logger.info("Method: clickOnInfoTableCloseBtnCardBack Start");
		boolean flag = false;
		try {
			List<WebElement> moduleList = baseHandler.findElements(".usage-back-header");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					WebElement element = moduleList.get(0).findElement(By.cssSelector("button"));
					if (element != null && element.isDisplayed()) {
						element.click();
						// To check if close button is not displayed after
						// clicking close button.
						flag = (moduleList.get(i).findElement(By.cssSelector("button"))).isDisplayed();
						break;
					}
				}
			}
		} catch (Exception e) {
			logger.info("Could not click on close button of info table or the info table is not closed");
			throw new Exception("Could not click on close button of info table or the info table is not closed");
		}
		logger.info("Method: clickOnInfoTableCloseBtnCardBack End --> " + flag);
		return flag;
	}

	/**
	 * Verify Speedometer is not displayed on EBOOKS , FLASHCARDS, TEAS
	 * SMARTPREP , Video Case Studies and Board Vital Products
	 * 
	 * 
	 * @author syed.pasha
	 * @throws DriverException
	 */
	public boolean IdSpeedometerPresent() throws Exception {
		logger.info("Method: IdSpeedometerPresent Start");
		boolean flag = false;
		try {
			List<WebElement> moduleList = baseHandler.findElements(".flipper section[class='card front tutorial']");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				int size = moduleList.size();
				for (int i = 0; i < size - 1; i++) {
					WebElement elementDesc = moduleList.get(i)
							.findElement(By.cssSelector("section div[class='description']"));
					WebElement elementType = moduleList.get(i).findElement(By.cssSelector("div header span"));
					if ((elementDesc.getText().contains("ATI TEAS SmartPrep"))
							|| (elementDesc.getText().contains("Board Vital"))
							|| (elementType.getText().contains("EBOOKS "))
							|| (elementType.getText().contains("FLASHCARDS "))
							|| (elementType.getText().contains("Video Case Studies"))) {
						if (moduleList.get(i).findElements(By.cssSelector("div[class='usage-overlay-50']"))
								.size() != 0) {
							break;
						}
					}
				}
			}
			flag = true;
		} catch (Exception e) {
			logger.info("Speedometer is present , but its not suppsoed to be present here");
			throw new Exception("Speedometer is present , but its not suppsoed to be present here");
		}
		logger.info("Method: IdSpeedometerPresent End --> " + flag);
		return flag;
	}

	/**
	 * Get Card front info table Time Spent value
	 * 
	 * @author syed.pasha
	 * @throws Exception
	 * @throws DriverException
	 */
	public String getCardFrontTimeSpentValue(String productName) throws Exception {
		logger.info("Method: getCardFrontTimeSpentValue Start ");
		String timeSpent = "";
		try {
			List<WebElement> moduleList = baseHandler.findElements(".flipper section[class='card front tutorial']");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					WebElement productNameWE = moduleList.get(i)
							.findElement(By.cssSelector("section div[class='description']"));
					if (productNameWE != null && productNameWE.getText().equals(productName)) {
						moduleList.get(i).findElement(By.cssSelector("footer a div div[class='usage-overlay-50"))
								.click();
						List<WebElement> infoTableRows = moduleList.get(i)
								.findElements(By.cssSelector(".custom-table.front-usage-data>tbody>tr"));
						List<WebElement> infoTableData = infoTableRows.get(3).findElements(By.cssSelector("td"));
						timeSpent = infoTableData.get(1).getText();
						// closing card front info table
						moduleList.get(i).findElement(By.cssSelector("div div button")).click();
						break;
					}
				}
			}
		} catch (Exception e) {
			logger.info("Cannot get Card front info table Time Spent value");
			throw new Exception("Cannot get Card front info table Time Spent value");
		}
		logger.info("Method: getCardFrontTimeSpentValue End ");
		return timeSpent;
	}
	
	/**
	 * Get Card front info table 'Accessed Modules' value
	 * 
	 * @author syed.pasha
	 * @throws Exception
	 * @throws DriverException
	 */
	public String getCardFrontAccessedModulesValue(String productName) throws Exception {
		logger.info("Method: getCardFrontAccessedModulesValue Start");
		String timeSpent = "";
		try {
			List<WebElement> moduleList = baseHandler.findElements(".flipper section[class='card front tutorial']");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					WebElement productNameWE = moduleList.get(i)
							.findElement(By.cssSelector("section div[class='description']"));
					if (productNameWE != null && productNameWE.getText().equals(productName)) {
						moduleList.get(i).findElement(By.cssSelector("footer a div div[class='usage-overlay-50"))
								.click();
						List<WebElement> infoTableRows = moduleList.get(i)
								.findElements(By.cssSelector(".custom-table.front-usage-data>tbody>tr"));
						List<WebElement> infoTableData = infoTableRows.get(1).findElements(By.cssSelector("td"));
						timeSpent = infoTableData.get(1).getText();
						// closing card front info table
						moduleList.get(i).findElement(By.cssSelector("div div button")).click();
						break;
					}
				}
			}
		} catch (Exception e) {
			logger.info("Cannot get Card front info table Time Spent value");
			throw new Exception("Cannot get Card front info table Time Spent value");
		}
		logger.info("Method: getCardFrontAccessedModulesValue End ");
		return timeSpent;
	}

	/**
	 * Click on Modules button by Name
	 * 
	 * @author syed.pasha
	 * @throws Exception
	 * @throws DriverException
	 */
	public void clickModuleButtonByName(String productName) throws Exception {
		logger.info("Method: clickModuleButtonByName Start");
		try {
			List<WebElement> moduleList = baseHandler.findElements(".flipper section[class='card front tutorial']");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					WebElement productNameWE = moduleList.get(i)
							.findElement(By.cssSelector("section div[class='description']"));
					if (productNameWE != null && productNameWE.getText().equals(productName)) {
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
								moduleList.get(i).findElement(By.cssSelector("span[class='learn-button-text']")));
						moduleList.get(i).findElement(By.cssSelector("span[class='learn-button-text']")).click();
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						break;
					}
				}
			}
		} catch (Exception e) {
			logger.info("Cannot click on module button");
			throw new Exception("Cannot click on module button");
		}
		logger.info("Method: clickModuleButtonByName End ");
	}
	
	/**
	 * Click on Modules button by Name
	 * 
	 * @author syed.pasha
	 * @throws Exception
	 * @throws DriverException
	 */
	public void clickModuleButtonByNameSimulation(String productName) throws Exception {
		logger.info("Method: clickModuleButtonByNameSimulation Start ");
		try {
			List<WebElement> moduleList = baseHandler.findElements(".card.simulation.front");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					WebElement productNameWE = moduleList.get(i)
							.findElement(By.cssSelector("section div[class='description']"));
					if (productNameWE != null && productNameWE.getText().equals(productName)) {
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
								moduleList.get(i).findElement(By.cssSelector("nav div a")));
						moduleList.get(i).findElement(By.cssSelector("nav div a")).click();
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						break;
					}
				}
			}
		} catch (Exception e) {
			logger.info("Cannot click on module button");
			throw new Exception("Cannot click on module button");
		}
		logger.info("Method: clickModuleButtonByNameSimulation End ");
	}
	
	
	/**
	 * Click on Speedometer by Name
	 * 
	 * @author syed.pasha
	 * @throws Exception
	 * @throws DriverException
	 */
	public void clickSMByName(String productName) throws Exception {
		logger.info("Method: clickSMByName Start");
		try {
			List<WebElement> moduleList = baseHandler.findElements(".flipper section[class='card front tutorial']");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					WebElement productNameWE = moduleList.get(i)
							.findElement(By.cssSelector("section div[class='description']"));
					if (productNameWE != null && productNameWE.getText().equals(productName)) {
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",moduleList.get(i).findElement(By.cssSelector("span[class='learn-button-text']")));
						moduleList.get(i).findElement(By.cssSelector(".usage-overlay-50")).click();
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						break;
					}
				}
			}
		} catch (Exception e) {
			logger.info("Cannot click on Speedometer");
			throw new Exception("Cannot click on Speedometer");
		}
		logger.info("Method: clickSMByName End ");
	}
	

	/**
	 * Method is used check if Accessed Module are displayed
	 * 
	 * @author syed.pasha
	 * @throws DriverException
	 */
	public boolean VerifyAccessedModuleIsDisplayed() throws Exception {
		logger.info("Method: VerifyAccessedModuleIsDisplayed Start ");
		boolean flag = false;
		try {
			List<WebElement> moduleList = baseHandler.findElements(".product-list-style>li ");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				int size = moduleList.size();
				for (int i = 0; i < size - 1; i++) {
					WebElement footerElement = moduleList.get(i).findElement(By.cssSelector("footer div span"));
					if (!("Never".equals(footerElement.getText()))) {
						flag = true;
						break;
					}
				}
			}
		} catch (Exception e) {
			logger.info("Accessed Module are not displayed");
			throw new Exception("Accessed Module are not displayed");
		}
		logger.info("Method: VerifyAccessedModuleIsDisplayed End --> " + flag);
		return flag;
	}

	/**
	 * Method is used check if Accessed Module are displayed
	 * 
	 * @author syed.pasha
	 * @throws Exception
	 * @throws DriverException
	 */
	public int getCardBackTimeSpentValue() throws Exception {
		logger.info("Method: VerifyAccessedModuleIsDisplayed Start ");
		int timeSpent = 0;
		System.out.println("");
		try {
			List<WebElement> moduleList = baseHandler.findElements(".product-list-style>li");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				int size = moduleList.size();
				for (int i = 0; i < size - 1; i++) {
					String smValue = moduleList.get(i)
							.findElement(By.cssSelector("span[id='tutorialModuleUsagePercent']")).getText();
					int intSmValue = Integer.parseInt(smValue.substring(0, smValue.length() - 1));
					if (intSmValue > 0) {
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
								moduleList.get(i).findElement(By.cssSelector("span[id='tutorialModuleUsagePercent']")));
						moduleList.get(i).findElement(By.cssSelector("span[id='tutorialModuleUsagePercent']")).click();
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						List<WebElement> tableRow = moduleList.get(i)
								.findElements(By.cssSelector("section[class='usage-back-table'] table tbody tr"));
						for (int j = 0; j < tableRow.size(); j++) {
							// Skip Header
							if (j == 0) {
							} else {
								List<WebElement> tableData = tableRow.get(j).findElements(By.cssSelector("td"));
								String strTimeSpent = tableData.get(4).getText();
								timeSpent += Integer.parseInt(strTimeSpent.substring(0, strTimeSpent.length() - 1));
							}
						}
					}
				}
			}

		} catch (Exception e) {
			logger.info("Cannot get Card Back info table Time Spent value");
			throw new Exception("Cannot get Card Back info table Time Spent value");
		}
		logger.info("Method: VerifyAccessedModuleIsDisplayed End");
		return timeSpent;
	}

	/**
	 * Verify if non pulse products are accessible by pulse user in Learn Tab
	 * 
	 * @author syed.pasha
	 * @throws DriverException
	 */
	public boolean VerifyIfTeasSmartPrepIsAccesible(String nonPulseProductName) throws Exception {
		logger.info("Method: VerifyIfTeasSmartPrepIsAccesible Start ");
		boolean flag = false;

		try {
			if (nonPulseProductName.contains("ATI TEAS SmartPrep")) {
				List<WebElement> moduleList = baseHandler.findElements(".flipper section[class='card front tutorial']");
				if (CollectionUtils.isNotEmpty(moduleList)) {
					int size = moduleList.size();
					for (int i = 0; i < size; i++) {
						WebElement element = moduleList.get(i)
								.findElement(By.cssSelector("section div[class='description']"));
						if ((element != null) && (element.getText().contains(nonPulseProductName))) {
							((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
									moduleList.get(i).findElement(By.cssSelector("span[class='learn-button-text']")));
							moduleList.get(i).findElement(By.cssSelector("span[class='learn-button-text']")).click();
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
							baseHandler.waitToBeDisplayed(PropertiesRepository
									.getString("new-atitesting.learntab.tutorial.stt.all.card.front.button"));
							if (baseHandler.findElement("#ATITermsConsent") != null
									&& baseHandler.findElement("#ATITermsConsent").isDisplayed()) {
								// If ATI TEAS SmartPrep accessed for the first
								// time , then enter this loop
								baseHandler.findElement("#ATITermsConsent").click();
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
										baseHandler.findElement("#TermsConditionsDialog section a"));
								baseHandler.findElement("#TermsConditionsDialog section a").click();
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
							}
							List<WebElement> productList = baseHandler.findElements(".product-list-style>li");
							if (CollectionUtils.isNotEmpty(productList)) {
								productList.get(0).findElement(By.cssSelector("section div a")).click();
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								Actions builder = new Actions(driver);
								builder.sendKeys(Keys.ESCAPE).perform();
								windowHandler.switchToFrame("OpenPageFrame");
								flag = baseHandler.findElement("#contents-panel").isDisplayed();
								driver.switchTo().defaultContent();
								// close the Assessment Page
								baseHandler.findElement(".close-button.focus-element-flag").click();
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								// Close the Modules popup
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								baseHandler.waitToBeDisplayed(PropertiesRepository
										.getString("new-atitesting.learntab.tutorial.stt.all.card.front.button"));
								baseHandler.findElement(".closeButton.focus-element-flag").click();
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
							}
							break;
						}
					}
				}
			}

			else if (nonPulseProductName.contains("Active Stack® Pharmacology Flash Cards")) {

				List<WebElement> moduleList = baseHandler
						.findElements(".flipper section[class='card front flash-cards']");
				if (CollectionUtils.isNotEmpty(moduleList)) {
					int size = moduleList.size();
					for (int i = 0; i < size; i++) {
						WebElement element = moduleList.get(i)
								.findElement(By.cssSelector("section div[class='description']"));
						if ((element != null) && (element.getText().contains(nonPulseProductName))) {
							((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
									moduleList.get(i).findElement(By.cssSelector("span[class='learn-button-text']")));
							moduleList.get(i).findElement(By.cssSelector("span[class='learn-button-text']")).click();
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
							baseHandler.waitToBeDisplayed(PropertiesRepository
									.getString("new-atitesting.learntab.tutorial.stt.all.card.front.button"));
							List<WebElement> productList = baseHandler.findElements(".product-list-style>li");
							if (CollectionUtils.isNotEmpty(productList)) {
								productList.get(0).findElement(By.cssSelector("section div a")).click();
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								windowHandler.switchToFrame("tutorialFrame");
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								flag = baseHandler.findElement("#start-flashcards-btn").isDisplayed();
								driver.switchTo().defaultContent();
								// close the Assessment Page
								baseHandler.findElement(".close-button.focus-element-flag").click();
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								// Close the Modules popup
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								baseHandler.waitToBeDisplayed(PropertiesRepository
										.getString("new-atitesting.learntab.tutorial.stt.all.card.front.button"));
								baseHandler.findElement(".closeButton.focus-element-flag").click();
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
							}
							break;
						}
					}
				}
			} else if (nonPulseProductName.contains("RN eBook Library")) {
				List<WebElement> moduleList = baseHandler.findElements(".flipper section[class='card front ebook']");
				if (CollectionUtils.isNotEmpty(moduleList)) {
					int size = moduleList.size();
					for (int i = 0; i < size; i++) {
						WebElement element = moduleList.get(i)
								.findElement(By.cssSelector("section div[class='description']"));
						if ((element != null) && (element.getText().contains(nonPulseProductName))) {
							((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
									moduleList.get(i).findElement(By.cssSelector("span[class='learn-button-text']")));
							moduleList.get(i).findElement(By.cssSelector("span[class='learn-button-text']")).click();
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
							baseHandler.waitToBeDisplayed(".ebook-row");
							List<WebElement> productList = baseHandler.findElements(".ebook-row");
							if (CollectionUtils.isNotEmpty(productList)) {
								productList.get(0).findElement(By.cssSelector("section div a")).click();
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								Actions action = new Actions(driver);
								action.sendKeys(Keys.ESCAPE).perform();
								windowHandler.switchToFrame("OpenPageFrame");
								if (baseHandler.findElement("#helpCloseBtn").isDisplayed()) {
									baseHandler.findElement("#helpCloseBtn").click();
								}
								flag = baseHandler.findElement("#contents-panel").isDisplayed();
								driver.switchTo().defaultContent();
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								// close the Assessment Page
								baseHandler.findElement(".close-button.focus-element-flag").click();
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								// Close the Modules popup
								/*
								 * waitUntillLoadingImageIsDisappeared(
								 * "new-atitesting.peasewait.bufferLoc");
								 * baseHandler.waitToBeDisplayed(
								 * PropertiesRepository.getString(
								 * "new-atitesting.learntab.tutorial.stt.all.card.front.button"
								 * )); baseHandler.findElement(
								 * ".closeButton.focus-element-flag").click();
								 * waitUntillLoadingImageIsDisappeared(
								 * "new-atitesting.peasewait.bufferLoc");
								 */
								break;
							}
						}
					}
				}
			}
		} catch (Exception e) {
			logger.info(nonPulseProductName + " is not accessible by Pulse user");
			throw new Exception(nonPulseProductName + " is not accessible by Pulse user");
		}
		logger.info("Method: VerifyIfTeasSmartPrepIsAccesible End --> " + flag);
		return flag;
	}

	/**
	 * Verify if Video Case Study's are accessible by pulse user in Apply Tab
	 * 
	 * @author syed.pasha
	 * @throws DriverException
	 */
	public boolean VerifyIfVCSIsAccesible() throws Exception {
		logger.info("Method: VerifyIfVCSIsAccesible Start ");
		boolean flag = false;
		try {
			List<WebElement> moduleList = baseHandler.findElements(".card.simulation.front");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					WebElement element = moduleList.get(i).findElement(By.cssSelector("header span"));
					if ((element != null) && (element.getText().equals("Video Case Study"))) {
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
								moduleList.get(i).findElement(By.cssSelector(".card.simulation.front div nav div a")));
						moduleList.get(i).findElement(By.cssSelector(".card.simulation.front div nav div a")).click();
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						baseHandler.waitToBeDisplayed(PropertiesRepository
								.getString("new-atitesting.learntab.tutorial.stt.all.card.front.button"));
						List<WebElement> productList = baseHandler.findElements(".product-list-style>li");
						if (CollectionUtils.isNotEmpty(productList)) {
							productList.get(0).findElement(By.cssSelector("section div a")).click();
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
							windowHandler.switchToFrame("videoCaseStudiesModulesFrame");
							List<WebElement> tabList = baseHandler.findElements(".text");
							flag = tabList.get(0).getText().equals("Challenge");
							driver.switchTo().defaultContent();
							// Close the Video Case Study
							baseHandler.findElement(".close-button.focus-element-flag").click();
							// Close the Modules popup
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
							baseHandler.waitToBeDisplayed(PropertiesRepository
									.getString("new-atitesting.learntab.tutorial.stt.all.card.front.button"));
							baseHandler.findElement(".closeButton.focus-element-flag").click();
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						}
						break;
					}
					
				}
			}
		} catch (Exception e) {
			logger.info("Video Case Study is not accessible by Pulse user");
			throw new Exception("Video Case Study is not accessible by Pulse user");
		}
		logger.info("Method: VerifyIfVCSIsAccesible End --> " + flag);
		return flag;
	}

	/**
	 * Verify if Video Case Study's are accessible by pulse user in Apply Tab
	 * 
	 * @author syed.pasha
	 * @throws DriverException
	 */
	public boolean VerifyIfBoardVitalsIsAccesible() throws Exception {
		logger.info("Method: VerifyIfBoardVitalsIsAccesible Start ");
		boolean flag = false;
		try {
			List<WebElement> moduleList = baseHandler.findElements("section[class='card front board-vital']");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				if (moduleList.get(0).findElement(By.cssSelector("div nav div div a")).isDisplayed()) {
					logger.info("Enter this loop if the button reads Continue");
					// Enter this loop if the button reads Continue
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
							moduleList.get(0).findElement(By.cssSelector("div div nav div div a")));
					moduleList.get(0).findElement(By.cssSelector("div div nav div div a")).click();
				} else {
					logger.info("Enter this loop if the button reads Begin");
					// Enter this loop if the button reads Begin
					List<WebElement> moduleList2 = moduleList.get(0).findElements(By.cssSelector("div div nav>div"));
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
							moduleList2.get(1).findElement(By.cssSelector("a")));
					moduleList2.get(1).findElement(By.cssSelector("a")).click();
				}
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				baseHandler.waitToBeDisplayed(
						PropertiesRepository.getString("new-atitesting.learntab.tutorial.stt.all.card.front.button"));
				List<WebElement> productList = baseHandler.findElements(".product-list-style>li");
				if (CollectionUtils.isNotEmpty(productList)) {
					productList.get(0).findElement(By.cssSelector("section div div a")).click();
					logger.info("Clicked on first lesson");
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
					windowHandler.switchToFrame("BoardVitalsFrame");
					windowHandler.switchToFrame("BoardVitalsActivityFrame");
					flag = baseHandler.findElement("#card").isDisplayed();
					driver.switchTo().defaultContent();
					// Close the Board Vitals s
					baseHandler.findElement(".close-button.focus-element-flag").click();
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
					baseHandler.waitToBeDisplayed(PropertiesRepository
							.getString("new-atitesting.learntab.tutorial.stt.all.card.front.button"));
					// Close the Modules popup
					baseHandler.findElement(".closeButton.focus-element-flag").click();
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				}
			}

		} catch (Exception e) {
			logger.info("Board vital is not accessible by Pulse user");
			throw new Exception("Board vital is not accessible by Pulse user");
		}
		logger.info("Method: VerifyIfBoardVitalsIsAccesible End --> " + flag);
		return flag;
	}

	/**
	 * Verify if Card Back Module is present
	 * 
	 * @author syed.pasha
	 * @throws DriverException
	 */
	public boolean VerifyIfCardBackMaodulePresent(String moduleName) throws Exception {
		logger.info("Method: VerifyIfCardBackMaodulePresent Start ");
		boolean flag = false;
		try {
			List<WebElement> moduleList = baseHandler.findElements(".ebook-row");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				for (int i = 0; i < moduleList.size(); i++) {
					if (moduleList.get(i).findElement(By.cssSelector("header span")).getText().equals(moduleName)) {
						flag = true;
						break;
					}
				}
			}

		} catch (Exception e) {
			logger.info("Video Case Study is not accessible by Pulse user");
			throw new Exception("Video Case Study is not accessible by Pulse user");
		}
		logger.info("Method: VerifyIfCardBackMaodulePresent End --> " + flag);
		return flag;
	}

	/**
	 * Verify Module Button and its Count  for a give Tutorial/Ebook/FlashCard.
	 * 
	 * @author syed.pasha
	 * @throws DriverException
	 */
	public boolean VerifyModuleButtonAndItsCount(String moduleName , String count) throws Exception {
		logger.info("Method: VerifyModuleButtonAndItsCount Start ");
		boolean flag = false;
		try {
			List<WebElement> moduleList = baseHandler.findElements(".card.front.ebook");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				for (int i = 0; i < moduleList.size(); i++) {
					if (moduleList.get(i).findElement(By.cssSelector("div[class='description']")).getText().equals(moduleName)) {
						if (moduleList.get(i).findElement(By.cssSelector("div[class='result-count-temp']")).getText().equals(count)) {
							flag = true;
							break;
						}						
					}
				}
			}
		} catch (Exception e) {
			logger.info("Cannot VerifyModuleButtonAndItsCountr");
			throw new Exception("Cannot VerifyModuleButtonAndItsCount");
		}
		logger.info("Method: VerifyModuleButtonAndItsCount End --> " + flag);
		return flag;
	}

	/**
	 * @author syed.pasha
	 * @return
	 * @throws DriverException
	 */
	public boolean verifyModuleListOnCardBackRNEbook() throws DriverException {
		boolean flag = false;
		try {
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			List<String> moduleListActual = new ArrayList<String>();
			List<String> moduleListExpected = Arrays.asList("Adult Medical Surgical Nursing RN Review Module 10.0",
					"Community Health RN Review Module 7.0", "Fundamentals for Nursing Review Module 9.0", "Leadership and Management Review Module 7.0",
					"Maternal Newborn Nursing RN Review Module 10.0", "Mental Health Nursing RN Review Module 10.0",
					"Nursing Care of Children RN Review Module 10.0", "Nutrition for Nursing Review Module 6.0",
					"Pharmacology for Nursing RN Review Module 7.0", "2017 Nurse's Drug Handbook");
			List<WebElement> module = baseHandler.findElements(".library-section-name");
			if (CollectionUtils.isNotEmpty(module)) {
				for (int i = 0; i < module.size(); i++) {
					if(module.get(i).isDisplayed()){
					moduleListActual.add(module.get(i).getText());}
				}
			}
			Collections.sort(moduleListActual);
			Collections.sort(moduleListExpected);
			if (moduleListActual.equals(moduleListExpected)) {
				flag = true;
			}

		} catch (Exception e) {
			throw new DriverException();
		}
		return flag;
	}
	
	/**
	 * 
	 * @author syed.pasha
	 * @return
	 * @throws DriverException
	 */
	public boolean verifyModuleListOnCardBackPNEbook() throws DriverException {
		boolean flag = false;
		logger.info("Method: verifyModuleListOnCardBackPNEbook Start");
		try {
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			List<String> moduleListActual = new ArrayList<String>();
			List<String> moduleListExpected = Arrays.asList("Fundamentals of Nursing Review Module 9.0",
					"Mental Health Review Module 10.0", "Pharmacology Review Module 7.0", "Maternal Newborn Review Module 10.0",
					"Nursing Care of Children Review Module 10.0", "Leadership and Management Review Module 7.0",
					"Nutrition for Nursing Review Module 6.0", "Adult Medical-Surgical Review Module 10.0",
					"2017 Nurse's Drug Handbook");
			List<WebElement> module = baseHandler.findElements(".library-section-name");
			if (CollectionUtils.isNotEmpty(module)) {
				for (int i = 0; i < module.size(); i++) {
					if(module.get(i).isDisplayed())
					{
						moduleListActual.add(module.get(i).getText());
					}
				}
			}
			Collections.sort(moduleListActual);
			Collections.sort(moduleListExpected);
			if (moduleListActual.equals(moduleListExpected)) {
				flag = true;
			}

		} catch (Exception e) {
			throw new DriverException();
		}
		logger.info("Method: verifyModuleListOnCardBackPNEbook End ");
		return flag;
	}

	/**
	 * Nurse’s Drug Handbook should display at the bottom of the card front.
	 * @author syed.pasha
	 * @return
	 * @throws DriverException
	 */
	public boolean verifyNurseDrugHandbookIsLast() throws DriverException {
		boolean flag = false;
		try {
			List<WebElement> module = baseHandler.findElements("div[class='back js-back-active'] .library-section-name");
			if (CollectionUtils.isNotEmpty(module)) {
				if ((module.get(module.size()-1)).getText().equals("2017 Nurse's Drug Handbook")) {
					flag = true;
				}
			}
		} catch (Exception e) {
			throw new DriverException();
		}
		return flag;
	}
	
	/**
	 * Verify Tutorials Page tutorialName and moduleName
	 * @author syed.pasha
	 * @return boolean
	 * @throws DriverException
	 */
	public boolean verifyTutorialPageTutorialAndModuleName(String tutorialName , String moduleName) throws Exception{
		logger.info("verifyTutorialPage Start");
		boolean flag = false;
		waitUntillElementIsVisible(".lesson-header-details>ul>li>span");
		waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		Thread.sleep(4000);
		try {
			List<WebElement> element = baseHandler.findElements(".lesson-header-details>ul>li>span");
			flag =(element.get(1).getText().equals(tutorialName) && element.get(3).getText().equals(moduleName));
		} catch (Exception e) {
    		logger.info("Unable to verifyTutorialPage");
			log(logger, "Unable to verifyTutorialPage" );
    		throw new DriverException("Unable to verifyTutorialPage" , e); 
    	}
		
		logger.info("verifyTutorialPage End " + flag);
		return flag;
		}
	
	/**
	 * Verify product name in info pop up
	 * @author Sasmita
	 * @return boolean
	 * @throws DriverException
	 */


public boolean verifyIfProductNameAdded(String ProductName) throws Exception {
	logger.info("Method: verifyIfProductAdded Start");
	boolean flag = false;
	try {
		List<WebElement> elements = baseHandler
				.findElements(PropertiesRepository.getString("new-atitesting.product.information.popup.loc"));
		if (CollectionUtils.isNotEmpty(elements)) {
			VerificationHandler.verifyEquals(ProductName, elements.get(0).getText());
			flag = (ProductName.equals(elements.get(0).getText()));
		}
	} catch (Exception e) {
		logger.info("Product is not added");
		throw new Exception("Product is not added");
	}
	logger.info("Method: verifyIfProductAdded End flag --> " + flag);
	return flag;

}

/**
 * Click on Module Button which is having Speedometer
 * 
 * 
 * @author sasmita
 * @param assessmentName
 * @throws DriverException
 */
public void clickOnModuleWithSpeedometer(int index) throws Exception {
	logger.info("Method: clickOnModuleWithSpeedometer Start");
	try {
		List<WebElement> moduleList = baseHandler.findElements(".flipper section[class='card front tutorial']");
		if (CollectionUtils.isNotEmpty(moduleList)) {
			int size = moduleList.size();
			for (int i = 0; i < size; i++) {
				WebElement element = moduleList.get(index)
						.findElement(By.cssSelector("footer a div div[class='usage-overlay-50"));
				if (element != null) {
					moduleList.get(index)
							.findElement(By.cssSelector(
									".button.primary-button.cardflip.focus-element-flag"))
							.click();
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
					baseHandler.waitForPageToLoad(PropertiesRepository
							.getString("new-atitesting.learntab.tutorial.stt.all.card.front.button"));
					break;
				}
			}
		}
	} catch (Exception e) {
		logger.info("Not able to Click on Module with Speedometer");
		throw new Exception("Not able to Click on Module with Speedometer");
	}
	logger.info("Method: clickOnModuleWithSpeedometer End --> ");

}
/**
 * Verify if Speedometer info table is present
 * 
 * 
 * @author sasmita
 * @param assessmentName
 * @throws DriverException
 */
public boolean VerifyifInfoTablePresent(int index) throws Exception {
	logger.info("Method: VerifyNeverAccessedSpedoAsZero Start");
	boolean flag = false;
	String tableHeaderActual = "";
	try {
		System.out.println("");
		List<WebElement> moduleList = baseHandler.findElements(".flipper section[class='card front tutorial']");
		if (CollectionUtils.isNotEmpty(moduleList)) {
			int size = moduleList.size();
			for (int i = 0; i < size; i++) {
				WebElement element = moduleList.get(index)
						.findElement(By.cssSelector("footer a div div[class='usage-overlay-50"));
				if (element != null) {
					moduleList.get(index).findElement(By.cssSelector("footer a div div[class='usage-overlay-50']"))
							.click();
					List<WebElement> tableHeader = moduleList.get(i).findElements(By.cssSelector("table tbody tr"));
					for (int j = 0; j < tableHeader.size(); j++) {
						tableHeaderActual = tableHeaderActual
								+ (tableHeader.get(j).findElement(By.cssSelector("td")).getText()) + ",";
					}
					flag = "Total Modules,Accessed Modules,Recent Score,Time Spent,Time Suggested,"
							.equals(tableHeaderActual);
					break;
				}
			}
		}
	} catch (Exception e) {
		logger.info("Speedometer info table is not present");
		throw new Exception("Speedometer info table is not present");
	}
	logger.info("Method: VerifyNeverAccessedSpedoAsZero End --> " + flag);
	return flag;
}

/**
 * Initializing Hashmap with module names and Speedometer value
 * 
 * 
 * @author syed.pasha
 * @throws DriverException
 */
public boolean verifySpedometerForModuleLevel() throws Exception {
	logger.info("Method: verifySpedometerForModuleLevel Start");
	boolean flag = false;
	try {
		waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		
		List<WebElement> moduleNameList = baseHandler.findElements(".product-result-take");
		List<WebElement> speedometerList = baseHandler.findElements(".usage-overlay-60-back");
		if (CollectionUtils.isNotEmpty(moduleNameList) && CollectionUtils.isNotEmpty(speedometerList))
		{
			
				flag=true;
			
		}
	} catch (Exception e) {
		logger.info("Unable to find spedometer on module level");
		throw new Exception("Unable to find spedometer on module level");
	}
	logger.info("Method: verifySpedometerForModuleLevel End --->flag");
	return flag;

}

public boolean verifyebookEditionDropdown() throws Exception {
	logger.info("Method: verifyebookEditionDropdown Starts");
	boolean flag = false;
	try {
		
		List<WebElement> editionDD = baseHandler.findElements(PropertiesRepository.getString("newati.ebook.edition.dropdown"));
		if(CollectionUtils.isNotEmpty(editionDD) && editionDD.size() > 0 ) {
			Select sel = new Select(editionDD.get(0));
			List<WebElement> allOptions = sel.getOptions();
			if(CollectionUtils.isNotEmpty(allOptions)) {
					if(allOptions.get(0).getAttribute("value").equalsIgnoreCase("2016 eBook")&&
							allOptions.get(1).getAttribute("value").equalsIgnoreCase("2016 PDF")&&
							allOptions.get(2).getAttribute("value").equalsIgnoreCase("2013")){
						flag = true;
						
					}
				}
			}
		
	} catch (Exception e) {
		logger.info("Unable to verify edition drop down " );
		throw new DriverException("Unable to verifyebookEditionDropdown " , e); 
	}
	logger.info("Method: verifyebookEditionDropdown End flag --> " + flag);
	return flag;
  }
/**
 * Method is used to Select from ebook-edition drop down
 * 
 * Content Area Name
 * 
 * @throws Exception
 */

public boolean selectFromEbookeditionDD (String editionvalue) throws Exception {
	logger.info("Method: selectFromEbookeditionDD Start");
	boolean flag = false;
	try {
	Select select = new Select(baseHandler
			.findElement(PropertiesRepository.getString("newati.ebook.edition.dropdown")));
	select.selectByVisibleText(editionvalue);
	logger.info("Verify message " );
	List<WebElement> selectDDmsg = baseHandler.findElements(PropertiesRepository.getString("newati.ebook.filter.selection.msg"));
	if(CollectionUtils.isNotEmpty(selectDDmsg) && selectDDmsg.size() > 0 ) {
		if(selectDDmsg.get(0).getText().equalsIgnoreCase("Currently viewing Editions from:")
				&&selectDDmsg.get(1).getText().equalsIgnoreCase(editionvalue)){
			flag=true;
		}
	
	}
	} catch (Exception e) {
		logger.info("Unable to verify selected edition info " );
		throw new DriverException("Unable to verify selected edition info " , e); 
	}
	logger.info("Method: selectFromEbookeditionDD End flag --> " + flag);
	return flag;
  }

	/**
	 * Method is used to return the count of Speedometer having values greater than 0
	 * 
	 * Content Area Name
	 * 
	 * @throws Exception
	 */
	public int getCountOfSMGresterThanZero() throws DriverException {
		logger.info("Method: getCountOfSMGresterThanZero Start ");
		int count = 0;
		try {
			List<WebElement> list = baseHandler.findElements("#tutorialModuleUsagePercent");
			for (int i = 0; i < list.size(); i++) {
				if (!(list.get(i).getText().equals("0%"))) {
					count = count+1;
				}			
			}			
		} catch (Exception e) {
			logger.info("Unable to getCountOfSMGresterThanZero ");
			throw new DriverException("Unable to getCountOfSMGresterThanZero ", e);
		}
		logger.info("Method: getCountOfSMGresterThanZero End Count --> " + count);
		return count;
	}
		
	

}
