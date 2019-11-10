package com.automation.newati.pages;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.DropDownHandler;

public class TestTabPage2 extends MyATITabMainPage {

	private Logger logger = LogManager.getLogger(this.getClass());
	private BaseHandler baseHandler;
	private DropDownHandler dropDownHandler;
	public HomePage homePage;
	public TestTabPage2(WebDriver webDriver) {
		super(webDriver);
		baseHandler = new BaseHandler(driver);
		dropDownHandler = new DropDownHandler(driver);
		homePage = new HomePage(driver);
	}

	/**
	 * Method used to verify assessment type under Test Tab. 
	 * Practice Assessment, Proctored Assessment and Quiz Bank.
	 * 
	 * @author saravanan.jothimani
	 * @param assessmentType
	 * @return
	 * @throws Exception
	 */
	public boolean verifyAssessmentType(List<String> assessmentType) throws Exception {
		logger.info("Method : verifyAssessmentType Start");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(
					PropertiesRepository.getString("new.atitestig.test.tab.all.assessment.card.front.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				for (WebElement assessmentTypeElement : element) {
					String assessmentUIType = assessmentTypeElement
							.findElement(By.cssSelector(PropertiesRepository
									.getString("new.atitestig.test.tab.all.assessment.card.front.assessment.type.loc")))
							.getText();
					if (StringUtils.isNotEmpty(assessmentUIType) && assessmentType.contains(assessmentUIType)) {
						flag = true;
					} else {
						logger.info("Unable to verify assessment type with assessment list assessmentUIType --> " + assessmentUIType);
						break;
					}
				}
			} else {
				logger.info("Unable to find assessment card front under Test Tab");
			}
		} catch (Exception e) {
			logger.info("Unable to verifyAssessmentType");
			log(logger, "Unable to verifyAssessmentType");
			throw new DriverException("Unable to verifyAssessmentType", e);
		}
		logger.info("Method: verifyAssessmentType End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to select dd based on index(view =0, type = 1, sort= 2)
	 * and optionValue to select option for corresponding selected dd. 
	 * 
	 * @author saravanan.jothimani
	 * @param ddIndex
	 * @param optionIndex
	 * @return
	 * @throws Exception
	 */
	public boolean selectOption(int ddIndex, String optionValue) throws Exception {
		logger.info("Method : selectOption Start");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("new.atitestig.test.tab.select.options.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				
				Select selectDD = dropDownHandler.getDropDown(element.get(ddIndex));
				if (selectDD != null) {
					List<WebElement> optionElement = selectDD.getOptions();
					for (WebElement optionUIValue : optionElement) {
						if (optionValue.equalsIgnoreCase(optionUIValue.getText().trim())) {
							optionUIValue.click();
							flag = true;
							break;
						} else {
							logger.info("Unable to select option value");
						}
					}
				} else {
					logger.info("Unable to identify select element");
				}
			} else {
				logger.info("Unable to find dd element");
			}
		} catch (Exception e) {
			logger.info("Unable to selectOption");
			log(logger, "Unable to selectOption");
			throw new DriverException("Unable to selectOption", e);
		}
		logger.info("Method: selectOption End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to select dd based on index(view =0, type = 1, sort= 2)
	 * and optionValue to select option for corresponding selected dd. 
	 * 
	 * @author saravanan.jothimani
	 * @param ddIndex
	 * @param optionIndex
	 * @return
	 * @throws Exception
	 */
	public String getSelectedOption(int ddIndex) throws Exception {
		logger.info("Method : getSelectedOption Start");
		String selecteOptionValue = null;
		try {
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("new.atitestig.test.tab.select.options.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				
				Select selectDD = dropDownHandler.getDropDown(element.get(ddIndex));
				if (selectDD != null) {
					WebElement selectedOptionElement = selectDD.getFirstSelectedOption();
					if(selectedOptionElement != null) {
						selecteOptionValue = selectedOptionElement.getText().trim();
					} else {
						logger.info("Unable to get selected option value");
					}
				} else {
					logger.info("Unable to identify select element");
				}
			} else {
				logger.info("Unable to find dd element");
			}
		} catch (Exception e) {
			logger.info("Unable to getSelectedOption");
			log(logger, "Unable to getSelectedOption");
			throw new DriverException("Unable to getSelectedOption", e);
		}
		logger.info("Method: getSelectedOption End flag --> " + selecteOptionValue);
		return selecteOptionValue;
	}
	
}
