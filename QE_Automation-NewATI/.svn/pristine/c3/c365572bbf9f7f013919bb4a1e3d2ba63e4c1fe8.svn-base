package com.automation.faculty.pages;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.ButtonHandler;
import com.ascendlearning.automation.ui.handlers.TextHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;
import com.automation.newati.pages.NewATIBasePage;

public class PulseLandingPage extends NewATIBasePage {

	private Logger logger = LogManager.getLogger(this.getClass());

	private TextHandler textHandler;
	private ButtonHandler btnHandler;
	public BaseHandler baseHandler;
	public FacultyLoginPage pulseloginPage;
	long milliseconds = 0;
	private String result = null;
	private WindowHandler windowHanlder;

	public PulseLandingPage(WebDriver webDriver) {
		super(webDriver);
		textHandler = new TextHandler(driver);
		btnHandler = new ButtonHandler(driver);
		baseHandler = new BaseHandler(driver);
		windowHanlder = new WindowHandler(driver);
		pulseloginPage = new FacultyLoginPage(driver);
	}

	/**
	 * This method is used to search with student name Author
	 * Bharathreddy.Sodinapalle
	 * 
	 * @throws Exception
	 */
	public void searchWithStudentName(String studentName) throws Exception {
		logger.info("searchWithStudentName method start");
		if (baseHandler.isDisplayed(PropertiesRepository.getString("se.std.pulse.home.page.student.search.textbox"))) {
			baseHandler.findElement(PropertiesRepository.getString("se.std.pulse.home.page.student.search.textbox"))
					.sendKeys(studentName);
			btnHandler.clickButton(PropertiesRepository.getString("se.std.pulse.home.page.student.search.button"));
			Thread.sleep(10000);
			waitUntillBufferInvisible(PropertiesRepository.getString("pulse.loading.symbol"));
		}
		logger.info("searchWithStudentName method end");
	}

	/**
	 * This method is used to select year from graduated year drop down Author
	 * Bharathreddy.Sodinapalle
	 * 
	 * @throws Exception
	 */
	public void selectGraduatedYearInPulsePage() throws Exception {
		logger.info("selectGraduatedYearInPulsePage method start");
		// Select selectYear = new
		// Select(driver.findElement(By.xpath(".//div[1]/div/div/div/div/div[1]/div/div/div/div[3]/div/select")));
		Select selectYear = new Select(
				baseHandler.findElement(PropertiesRepository.getString("se.faculty.graduatedyear.dropdown")));
		selectYear.selectByVisibleText("2017");
		Thread.sleep(3000);
		logger.info("selectGraduatedYearInPulsePage method end");
		logger.info("Selected graduated year:" + selectYear.getFirstSelectedOption().getText());
	}

	/**
	 * This method is used to select class from class drop down Author
	 * Bharathreddy.Sodinapalle
	 * 
	 * @throws Exception
	 */
	public void selectClassInPulsePage(String classname) throws Exception {
		// Select selectClassValue = new
		// Select(driver.findElement(By.xpath(".//div[1]/div/div/div/div/div[1]/div/div/div/div[4]/div/select")));
		Select selectClassValue = new Select(
				baseHandler.findElement(PropertiesRepository.getString("se.faculty.class.dropdown")));
		selectClassValue.selectByVisibleText(classname);
		logger.info("Selected class name:" + classname);
	}

	/**
	 * This method is used to click on Details button Author
	 * Bharathreddy.Sodinapalle
	 * 
	 * @throws Exception
	 */
	public void clickDetailsButton(String classname) throws Exception {
		logger.info("Method: clickDetailsButton Starts");
		try {
			windowHanlder.switchToLatestWindow();
			Thread.sleep(5000);
			waitUntillBufferInvisible(PropertiesRepository.getString("pulse.loading.symbol"));
			// selectGraduatedYearInPulsePage();
			selectClassInPulsePage(classname);
			Thread.sleep(3000);
			btnHandler.clickButton(PropertiesRepository.getString("se.faculty.class.details.button"));
		} catch (Exception e) {
			logger.info("Unable to click Details Button ");
			log(logger, "Unable to  click Details Button ");
			throw new DriverException("Unable to verify Details Button", e);
		}
		logger.info("Method: clickDetailsButton End ");
	}

	/**
	 * Method used to click on Student User Pie Diagram
	 * 
	 * @author bharathreddy.sodinapalle
	 * @throws Exception
	 */
	public void clickStudentUserPieDiagram(String studentname) throws Exception {
		logger.info("Method: clickStudentUserPieDiagram Starts");
		try {
			Thread.sleep(10000);
			waitUntillBufferInvisible(PropertiesRepository.getString("pulse.loading.symbol"));
			searchWithStudentName(studentname);
			logger.info("clickStudentUserPieDiagram method middle");
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,250)", "");
			Thread.sleep(3000);
			// JavascriptExecutor executor = (JavascriptExecutor) driver;
			// executor.executeScript("arguments[0].click();",
			// baseHandler.findElement(PropertiesRepository.getString("std.eng.student.at.risk.pie.chart.loc.css")));
			btnHandler.clickButton(PropertiesRepository.getString("std.eng.student.at.risk.pie.chart.loc.css"));
			Thread.sleep(10000);
			// driver.navigate().refresh();
			// driver.findElement(By.xpath(PropertiesRepository.getString("std.eng.student.at.risk.pie.chart.loc"))).click();
			// Thread.sleep(8000);
			logger.info("clicked on Student User Pie Diagram ");
		} catch (Exception e) {
			logger.info("Unable to click Student User Pie Diagram");
			log(logger, "Unable to click Student User Pie Diagram");
			throw new DriverException("Unable to click Student User Pie Diagram", e);
		}
		logger.info("Method: clickStudentUserPieDiagram End ");
	}

	public void navigateToSEPage(String userName, String password, String classname, String studentname)
			throws Exception {

		// loginPage.launchApplication(url);
		waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Loging in with Faculty User");
		pulseloginPage.facultyLogin(userName, password);
		waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Student Details Button");
		clickDetailsButton(classname);
		waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		log(logger, "Clicking on Pie Diagram in Student Usage Column");
		clickStudentUserPieDiagram(studentname);
		waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
	}

	public void navigateToPatrialSEPage(String userName, String password, String classname, String studentname)
			throws Exception {

		// loginPage.launchApplication(url);
		waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");

		log(logger, "Loging in with Faculty User");
		pulseloginPage.facultyLogin(userName, password);

		log(logger, "Clicking on Student Details Button");
		clickDetailsButton(classname);

		log(logger, "Clicking on Pie Diagram in Student Usage Column");
		Thread.sleep(10000);
		waitUntillBufferInvisible(PropertiesRepository.getString("pulse.loading.symbol"));
		searchWithStudentName(studentname);
		
	}
	public void clickModuleByName(String moduleName, String loc) throws Exception {

		waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
		List<WebElement> moduleList = baseHandler.findElements(loc);
		if (moduleList != null && moduleList.size() > 0) {
			int size = moduleList.size();
			for (int i = 0; i < size; i++) {
				if (moduleList.get(i).getText().equals(moduleName)) {
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", moduleList.get(i));
					moduleList.get(i).click();
					Thread.sleep(3000);
					break;
				}
			}

		}
}

}
