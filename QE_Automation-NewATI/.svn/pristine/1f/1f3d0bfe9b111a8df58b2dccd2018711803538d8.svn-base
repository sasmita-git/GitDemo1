package com.automation.newati.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;

public class MyReportPage extends NewATIBasePage {

	private Logger logger = LogManager.getLogger(this.getClass());
	private BaseHandler baseHandler;
	private WindowHandler windowHandler;

	public MyReportPage(WebDriver webDriver) {
		super(webDriver);
		baseHandler = new BaseHandler(driver);
		windowHandler = new WindowHandler(driver);
	}

	
	
	/**
	 * Method used to verify IPP Page Header "Individual Performance Profile"
	 * 
	 * @author saravanan.jothimani
	 * @return
	 * @throws Exception
	 */
	public boolean verifyIPPPageHeader() throws Exception {
		logger.info("Method: verifyIPPPageHeader Starts");
		boolean flag = false;
		windowHandler = new WindowHandler(driver);
		try {
			windowHandler.switchToLatestWindow();
			waitUntillIPPPageIsLoaded(".sub-header>section>img");
			//waitUntillLoadingImageIsAppeared(".logo");
			//windowHandler.switchToFrame("assessmentFrame");
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository
							.getString("new-ati.report.header.loc"));
			if (CollectionUtils.isNotEmpty(element)) {

				if (element.get(0).getText().equalsIgnoreCase(PropertiesRepository.getString("new-ati.report.header.value"))) {
					flag = true;
				}
		}
		}catch (Exception e) {
			logger.info("Unable to verify IPP Page Header");
			log(logger, "Unable to verify IPP Page Header");
			throw new DriverException("Unable to verify IPP Page Header", e);
		}
		logger.info("Method: verifyIPPPageHeader End flag --> " + flag);
		return flag;
	}

	public boolean verifyIPPpageObjects() {
		boolean flag = false;
		try {
			windowHandler.switchToMainWindow();
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			WebElement element = baseHandler.findElement(PropertiesRepository.getString("new-atitesting.specific.modules.ipp.page.object"));
			if (element.isDisplayed()) {
				flag = true;
			}

		} catch (Exception e) {
			System.out.println("done ");
		}

		return flag;
	}

	public boolean verifyIPPPageSectionHeaders() {
		List<Boolean> list=new ArrayList<Boolean>();
		List<String> list1=new ArrayList<String>();
		try {
			String[] inputs = PropertiesRepository.getStringAsArray("new-ati.report.results.header.input");
			
			List<WebElement> findElement = baseHandler.findElements(PropertiesRepository.getString("new-ati.report.results.header"));
			for(int j=1;j<findElement.size();j++)
			{
					list1.add(findElement.get(j).getText().trim());
			}
			if(list1!=null)
			{
				for(int i=0;i<list1.size();i++)
				{
					if(list1.get(i).equals(inputs[i]))
					{
						list.add(true);
					}
					else
					{
						list.add(false);
					}
				}
			}
		} catch (Exception e) {
			logger.info("element is not visible");
		}
		
		return list.contains(false)?false:true;
	}
	
	
	/**
	 * Method used to Find the Download button after completing the test and click on it.
	 * 
	 * @author Vishal
	 * @return
	 * @throws Exception
	 */
	
	public void clickDownloadReportAfterTest(int index) throws Exception {
		logger.info("Method: clickDownloadReportAfterTest Starts");
		boolean flag=false;
		try {
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.myresult.page.download.button.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				element.get(index).click();
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to verify IPP Page Header");
			log(logger, "Unable to verify IPP Page Header");
			throw new DriverException("Unable to verify IPP Page Header", e);
		}
		logger.info("Method: verifyIPPPageHeader End flag --> " + flag);		
	}
	
	
	/**
	 * Method used to verify if the download button is present or not in the IPP page
	 * 
	 * @author Vishal
	 * @return
	 * @throws Exception
	 */
	
	public boolean verifyDownloadButtonPrescence() throws Exception {
		logger.info("Method: verifyDownloadButtonPrescence Starts");
		boolean flag=false;
		try {
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.myresult.page.download.button.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				String text=element.get(2).getText();
				if(StringUtils.isNotEmpty(text) && text.equalsIgnoreCase(PropertiesRepository.getString("new-ati.report.Download.button.value"))){
					flag = true;
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verify if Download Report button is present or not.");
			log(logger, "Unable to verify if Download Report button is present or not.");
			throw new DriverException("verifyDownloadButtonPrescence", e);
		}
		logger.info("Method: verifyDownloadButtonPrescence End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to verify if Individual Score is present or not in the IPP page
	 * 
	 * @author Vishal
	 * @return
	 * @throws Exception
	 */
	
	public boolean verifyIndividualScorePrescence(String loc) throws Exception {
		logger.info("Method: verifyIndividualScorePrescence Starts");
		boolean flag=false;
		try {
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString(loc));
			if (CollectionUtils.isNotEmpty(element)) {
				String text=element.get(0).getText();
				if(StringUtils.isNotEmpty(text)) {
					double value = Double.parseDouble(text);
					if(value > 0) {
						flag = true;
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verify if Individual Score is present or not.");
			log(logger, "Unable to verify if Individual Score is present or not.");
			throw new DriverException("verifyIndividualScorePrescence ", e);
		}
		logger.info("Method: verifyIndividualScorePrescence End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to verify if Time Spent is present or not in the IPP page
	 * 
	 * @author Vishal
	 * @return
	 * @throws Exception
	 */
	
	public boolean verifyTimeSpentPrescence() throws Exception {
		logger.info("Method: verifyTimeSpentPrescence Starts");
		boolean flag=false;
		try {
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("new-ati.report.time.spent.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				String text=element.get(0).getText();
				if(StringUtils.isNotEmpty(text)) {
					//logger.info("Time text: "+text);
					int minvalue = Integer.parseInt(text.substring(0, 2));
					int secvalue= Integer.parseInt(text.substring(3, 5));
					//logger.info("minvalue: "+minvalue+" secvalue: "+secvalue);
					if(minvalue > 0 || secvalue>0) {
						flag = true;
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verify if Time Spent is present or not.");
			log(logger, "Unable to verify if Time Spent is present or not.");
			throw new DriverException("verifyTimeSpentPrescence ", e);
		}
		logger.info("Method: verifyTimeSpentPrescence End flag --> " + flag);
		return flag;
	}
	
	
	
	/**
	 * Method used to verify if outcome table section is present or not in the IPP page
	 * 
	 * @author Vishal
	 * @return
	 * @throws Exception
	 */
	
	public boolean verifyOutcomeTableSection() throws Exception {
		logger.info("Method: verifyOutcomeTableSection Starts");
		boolean flag=false;
		try {
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("new-ati.report.table.headers.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				String text=element.get(1).getText();
				//logger.info("text: "+text);
				if(text.equalsIgnoreCase(PropertiesRepository.getString("new-ati.report.outcome.table.header.value"))){
					flag = true;
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verify Outcome.");
			log(logger, "Unable to verify Outcome.");
			throw new DriverException("verifyOutcomeTableSection ", e);
		}
		logger.info("Method: verifyOutcomeTableSection End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to verify if content area is present or not in the IPP page
	 * 
	 * @author Vishal
	 * @return
	 * @throws Exception
	 */
	
	public boolean verifyContentArea(String loc) throws Exception {
		logger.info("Method: verifyContentArea Starts");
		boolean flag=false;
		try {
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString(loc));
			if (CollectionUtils.isNotEmpty(element) && element.size()>0) {
				String text=element.get(1).getText();
				if(StringUtils.isNotEmpty(text) && !text.isEmpty()) {
						flag = true;
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verify ContentArea.");
			log(logger, "Unable to verify ContentArea.");
			throw new DriverException("verifyContentArea ", e);
		}
		logger.info("Method: verifyContentArea End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to verify if total number of questions is present or not in the IPP page
	 * 
	 * @author Vishal
	 * @return
	 * @throws Exception
	 */
	
	public boolean verifyTotalNumberOfQuestions() throws Exception {
		logger.info("Method: verifyTotalNumberOfQuestions Starts");
		boolean flag=false;
		try {
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("new-ati.report.total.questions.number"));
			if (CollectionUtils.isNotEmpty(element)) {
				String text=element.get(1).getText();
				if(StringUtils.isNotEmpty(text)) {
					//logger.info("text: "+text);
					int value=Integer.parseInt(text);
					//logger.info("value: "+value);
					if(value>=0) {
						flag = true;
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verify total number of questions.");
			log(logger, "Unable to verify total number of questions.");
			throw new DriverException("verifyTotalNumberOfQuestions  ", e);
		}
		logger.info("Method: verifyTotalNumberOfQuestions End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to verify if an element is displayed in the page or not
	 * 
	 * @change Vishal
	 * @return
	 * @throws Exception
	 * 
	 * elementName  - to display the element type at the log. 
	 *//*	
	
	public boolean isElementDisplayed(String loc, String elementName) throws DriverException {
		boolean flag = false;
		try {
			flag = false;
			if (baseHandler.isDisplayed(baseHandler
					.findElement(PropertiesRepository.getString(loc)))) {
				flag = true;
			}

		} catch (Exception e) {
			logger.info("Unable to verify "+ elementName + " ");
			throw new DriverException("Unable to verify "+ elementName + " ", e);
		}
		logger.info("" + elementName +"is present flag --> " + flag);
		return flag;
	}*/
	
	/**
	 * Method used to verify if the download button is present or not in the IPP page
	 * 
	 * @author Vishal
	 * @return
	 * @throws Exception
	 */
	
	public boolean verifyIPPElements(String value, String loc, String field, int index) throws Exception {
		logger.info("Method: verifyIPPElements Starts");
		boolean flag=false;
		try {
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString(loc));
			if (CollectionUtils.isNotEmpty(element)) {
				String text=element.get(index).getText();
				if(StringUtils.isNotEmpty(text) && text.equalsIgnoreCase(PropertiesRepository.getString(value))){
					flag = true;
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verify "+ field + " . "+e);
			log(logger, "Unable to verify "+ field + " . "+e);
		}
		logger.info("Method: verifyIPPElements End flag --> " + flag);
		return flag;
	}

}
