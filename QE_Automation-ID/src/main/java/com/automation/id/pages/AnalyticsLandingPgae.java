package com.automation.id.pages;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.TextHandler;

public class AnalyticsLandingPgae extends IDBasePage{

	private Logger logger = LogManager.getLogger(this.getClass());
	private BaseHandler baseHandler;

	public AnalyticsLandingPgae(WebDriver webDriver) {
		super(webDriver);
		baseHandler = new BaseHandler(driver);
		textHandler = new TextHandler(driver);
	}
	
	/**
	 * This method will click on any cards present on analytics landing page
	 * @author Syed.Hoque
	 * @throws DriverException 
	 */
	
	
	public void clickOncardTiles(int index) throws DriverException{
		logger.info("clickOncardTiles ::: START");
		try{
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			List<WebElement> ele=baseHandler.findElements(PropertiesRepository.getString("analytics.landing.page.tiles"));
			if(CollectionUtils.isNotEmpty(ele)&& ele.size()>0){
				ele.get(index).click();
			}
			/*baseHandler.findElement(PropertiesRepository.getString("analytics.landing.page.tiles")).click();*/
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));	
		}catch(Exception e){
			logger.info("Unable to click On tiles ");
			log(logger, "Unable to click On tiles ");
			throw new DriverException("Unable to click On tiles ", e);	
		}
		logger.info("clickOncardTiles ::: ENDS");
	}
	
	public void clickOncardTilesText(String text) throws DriverException{
		logger.info("clickOncardTiles ::: START");
		try{
			List<WebElement> ele=baseHandler.findElements(PropertiesRepository.getString("analytics.landing.page.tiles"));
			if(CollectionUtils.isNotEmpty(ele)&& ele.size()>0){
			for(int i=0;i<ele.size();i++){
				if(ele.get(i).getText().equalsIgnoreCase(text)){
					ele.get(i).click();
				break;
				}
			}
				
			}
			/*baseHandler.findElement(PropertiesRepository.getString("analytics.landing.page.tiles")).click();*/
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));	
		}catch(Exception e){
			logger.info("Unable to click On tiles ");
			log(logger, "Unable to click On tiles ");
			throw new DriverException("Unable to click On tiles ", e);	
		}
		logger.info("clickOncardTiles ::: ENDS");
	}
	/**
	 * This method will verify text and click on that
	 * @author Syed.Hoque
	 * @throws DriverException 
	 */
	
	/*if (CollectionUtils.isNotEmpty(element)) {
		int size = element.size();
		for (int index = 0; index < size; index++) {
			if (element.get(index).getText().trim().contains(text)) {
				flag = true;
				break;
			}
		}
	}*/
	
	
	/**
	 * This method will find any text from the page
	 * @param text
	 * @return
	 * @throws DriverException
	 * @author Syed.Hoque
	 */
	
	public boolean verifyReportingTileText(String loc ,int index,String expected) throws DriverException{
		logger.info("Start:: click On verifyReportingTileText ");
		boolean flag=false;
		try{
			
			List<WebElement> ele=baseHandler.findElements(loc);
			if(CollectionUtils.isNotEmpty(ele)){
				String actual=ele.get(index).getText().trim();
				if(actual.equalsIgnoreCase(expected)){
					flag=true;
				}
			}
			
		}catch(Exception e){
			logger.info("Unable to click On verifyReportingTileText ");
			log(logger, "Unable to click On verifyReportingTileText ");
			throw new DriverException("Unable to click On verifyReportingTileText ", e);	
		}
		logger.info("verifyMessage End flag" + flag);
		return flag;
	}
	
	
	
	
	
	
	public boolean VerifyReportingTextLink(String text) throws DriverException{
		logger.info("Start ::click On VerifyReportingTextLink ");
		boolean flag=false;
		try{
			List<WebElement> elements=baseHandler.findElements(PropertiesRepository.getString("analytics.betareporting.tiles"));
			if(CollectionUtils.isNotEmpty(elements)&& elements.size()>0){
			   for(int index=0;index<elements.size();index++){
				   if(elements.get(index).getText().trim().contains(text)){
					  flag = true;
					  elements.get(index).click();
					   break;
				   }
			   }
			}
			
		}catch(Exception e){
			logger.info("Unable to click On VerifyReportingTextLink ");
			log(logger, "Unable to click On VerifyReportingTextLink ");
			throw new DriverException("Unable to click On VerifyReportingTextLink ", e);		
		}
		logger.info("verifyMessage End flag" + flag);
		return flag;
	}
	
	public boolean VerifyReportingTextLink(String locator, String text) throws DriverException{
		logger.info("Start ::click On VerifyReportingTextLink ");
		boolean flag=false;
		try{
			List<WebElement> elements=baseHandler.findElements(locator);
			if(CollectionUtils.isNotEmpty(elements)&& elements.size()>0){
				int size = elements.size();
			   for(int index=0;index<size;index++){
				   List<WebElement> spanElement =elements.get(index).findElements(By.cssSelector("span"));
				   if(CollectionUtils.isNotEmpty(spanElement) &&
						   spanElement.get(0).getText().trim().contains(text)){
					   spanElement.get(0).click();
					   waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
					  flag = true;
					   break;
				   }
			   }
			}
			
		}catch(Exception e){
			logger.info("Unable to click On VerifyReportingTextLink ");
			log(logger, "Unable to click On VerifyReportingTextLink ");
			throw new DriverException("Unable to click On VerifyReportingTextLink ", e);		
		}
		logger.info("verifyMessage End flag" + flag);
		return flag;
	}
	
	/**
	 * this method will verify analytics page url
	 * @param text
	 * @return
	 * @throws DriverException
	 * @author Syed.Hoque
	 */
	
	public boolean verifyAnalyticsUrl(String expectedurl) throws DriverException{
		logger.info("Start :: verifyAnalyticsUrl method ");
		boolean flag=false;
		try{
			String currenturl=driver.getCurrentUrl();
			if(currenturl.equalsIgnoreCase(expectedurl)){
				flag=true;
			}
			
		}catch(Exception e){
			logger.info("Unable to click On verifyAnalyticsUrl ");
			log(logger, "Unable to click On verifyAnalyticsUrl ");
			throw new DriverException("Unable to click On verifyAnalyticsUrl ", e);		
		}
		logger.info("verifyAnalyticsUrl End flag -->" + flag);
		return flag;
	}
	
	
	/**
	 * this method will verify reporting tiles
	 * @param text
	 * @return
	 * @throws DriverException
	 * @author Syed.Hoque
	 */
	
	public boolean VerifyReportingTilesLink(String text,int indexs) throws DriverException{
		logger.info("Unable to click On VerifyReportingTilesLink ");
		boolean flag=false;
		try{
			List<WebElement> elements=baseHandler.findElements(PropertiesRepository.getString("analytics.reporting.tiles"));
			if(CollectionUtils.isNotEmpty(elements)&& elements.size()>0){
			   for(int index=0;index<elements.size();index++){
				   if(elements.get(index).getText().trim().contains(text)){
					  flag = true;
					   break;
				   }
			   }
			}
			
		}catch(Exception e){
			logger.info("Unable to click On VerifyReportingTilesLink ");
			log(logger, "Unable to click On VerifyReportingTilesLink ");
			throw new DriverException("Unable to click On VerifyReportingTilesLink ", e);		
		}
		logger.info("verifyMessage End flag" + flag);
		return flag;
	}
		
	public boolean clickAndSwitchtoNewwindow(String locator,String actualtext, int index) throws DriverException {
		logger.info("clickAndSwitchtoNewwindow starts ");
		boolean flag = false;
		try{
			/*WebElement element1 = baseHandler.findElement(locator);
		    element1.click();*/
		    String winHandleBefore = driver.getWindowHandle();
		    windowHandler.switchToLatestWindow();
		    List<WebElement> elements=baseHandler.findElements(PropertiesRepository.getString("analytics.reporting.dashboard.loc"));
			if(CollectionUtils.isNotEmpty(elements)){
		    	for(WebElement element:elements){
		    		if(actualtext.equalsIgnoreCase(element.getText().trim())){
		    			flag=true;
		    			
		    		}
		    	}
		    	
		    }
			driver.close();
 		driver.switchTo().window(winHandleBefore);
		}catch(Exception e){
			windowHandler.switchToMainWindow();
			logger.info("Unable to click on beta links and switch to new window ");
			log(logger, "Unable to click on beta links and switch to new window ");
			throw new DriverException("Unable to click on beta links and switch to new window ", e);		
		}
		logger.info("clickAndSwitchtoNewwindow End flag" + flag);		    
		return flag;
		
	}
	
	/**
	 * Method used to get report name based on index in Analytics Page. 
	 * 
	 * @author saravanan.jothimani
	 * @param reportName
	 * @param index
	 * @return
	 * @throws Exception
	 */
	public boolean verifyAnalyticsReportingHomePage(String reportName, int index) throws Exception {
		logger.info("Method : verifyAnalyticsReportingHomePage Start");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("id.analytics.reports.home.page.report.portlet.loc"));
			if(CollectionUtils.isNotEmpty(element)) {
				WebElement actualElement = element.get(index).findElement(By.cssSelector(PropertiesRepository.getString("id.analytics.reports.home.page.report.portlet.name.loc") ));
				if(actualElement != null && reportName.equalsIgnoreCase(actualElement.getText())) {
					flag =  true;
				}
			}
		}catch (Exception e) {
    		logger.info("Unable to verifyAnalyticsReportingHomePage" );
			log(logger, "Unable to verifyAnalyticsReportingHomePage" );
    		throw new DriverException("Unable to verifyAnalyticsReportingHomePage" , e); 
    	}
		logger.info("Method: verifyAnalyticsReportingHomePage End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to get report name based on index in Analytics Page. 
	 * 
	 * @author saravanan.jothimani
	 * @param reportName
	 * @param index
	 * @return
	 * @throws Exception
	 */
	public boolean verifyAnalyticsReportingHomePage(String reportName) throws Exception {
		logger.info("Method : verifyAnalyticsReportingHomePage Start");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("id.analytics.reports.home.page.report.portlet.loc"));
			if(CollectionUtils.isNotEmpty(element)) {
				int size = element.size();
				for(int index = 0; index < size; index ++) {
					WebElement actualElement = element.get(index).findElement(By.cssSelector(PropertiesRepository.getString("id.analytics.reports.home.page.report.portlet.name.loc") ));
					if(actualElement != null && reportName.equalsIgnoreCase(actualElement.getText())) {
						actualElement.click();
						flag =  true;
						break;
					}
				}
			} else {
				logger.info("Unable to get value from locators for verifyAnalyticsReportingHomePage");
			}
		}catch (Exception e) {
    		logger.info("Unable to verifyAnalyticsReportingHomePage" );
			log(logger, "Unable to verifyAnalyticsReportingHomePage" );
    		throw new DriverException("Unable to verifyAnalyticsReportingHomePage" , e); 
    	}
		logger.info("Method: verifyAnalyticsReportingHomePage End flag --> " + flag);
		return flag;
	}

}
