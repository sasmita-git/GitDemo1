package com.automation.faculty.pages;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.ButtonHandler;
import com.ascendlearning.automation.ui.handlers.TextHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;
import com.automation.newati.pages.NewATIBasePage;

public class FacultyLoginPage extends NewATIBasePage {

	private Logger logger = LogManager.getLogger(this.getClass());
	
	private TextHandler textHandler;
	private ButtonHandler btnHandler;
	public BaseHandler baseHandler;
	long milliseconds =0;
	private String result = null;
	private WindowHandler windowHanlder;
	public FacultyLoginPage(WebDriver webDriver) {
		super(webDriver);
		textHandler = new TextHandler(driver);
		btnHandler = new ButtonHandler(driver);
		baseHandler = new BaseHandler(driver);
		windowHanlder=new WindowHandler(driver);
	}
	
	/**
	 * This method verifies the presence of web elements
	 * 
	 * @author Rakesh.Nayak
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isElementPresent(String Locator) throws Exception {
	          logger.info("Method : isElementPresent :::::::: START");
	          boolean flag = false;
	          try {
	                Thread.sleep(1000);
	                WebElement element = baseHandler.findElement(PropertiesRepository.getString(Locator));
	                if (element.isDisplayed()){
	                     flag = true;
	                     }else{
	                     flag = false;
	                    }
	              } catch (Exception e) {
	                      logger.info("WebElement is not found", e);
	              }
	              logger.info("Method : isElementPresent :::::::: END");
	              return flag;
	       }
	
	/**
	 * Method to used to login to application.
	 * 
	 * @param userName
	 * @param password
	 * @return
	 * @throws DriverException
	 */
	public void facultyLogin(String userName, String password) throws Exception {
		try {

			/*WebElement btnFacultyLogin = baseHandler
					.findElement(PropertiesRepository.getString("ati.home.facultylogin.button"));
			btnFacultyLogin.click();
			Thread.sleep(3000);
			waitUntillBufferInvisible(PropertiesRepository.getString("pulse.loading.symbol"));*/
			
			
			WebElement txtUserName = baseHandler
					.findElement(PropertiesRepository.getString("ati.facultylogin.username.text"));
			txtUserName.click();
			txtUserName.sendKeys(userName);
			WebElement txtPassword = baseHandler
					.findElement(PropertiesRepository.getString("ati.facultylogin.password.text"));
			txtPassword.sendKeys(password);
			WebElement btnGo = baseHandler.findElement(PropertiesRepository.getString("ati.facultylogin.go.button"));
			btnGo.click();
			Thread.sleep(10000);
			waitUntillBufferInvisible(PropertiesRepository.getString("pulse.loading.symbol"));
			/*boolean flag_popup = isElementPresent("ati.testing.blue.popup.close");
			if(flag_popup==true){
			WebElement iconClosePopup = baseHandler
					.findElement(PropertiesRepository.getString("ati.testing.blue.popup.close"));
			
			iconClosePopup.click();
			Thread.sleep(2000);
			}*/
			
			//Close Alert Box if present , close it
			if ((baseHandler.findElements("a[class='ati-modal-close']")).size()!=0)
			{	
				baseHandler.findElement("a[class='ati-modal-close']").click();
			}	
			
			log(logger , "Select Institution from the DropDown and clisk save");
			 baseHandler.findElement(PropertiesRepository.getString("se.std.pulse.home.page.dropdown")).click();
			 Thread.sleep(2000);
			 waitUntillBufferInvisible(PropertiesRepository.getString("pulse.loading.symbol"));
			 baseHandler.findElement(PropertiesRepository.getString("se.std.pulse.home.page.institution.input")).sendKeys(PropertiesRepository.getStringAsArray("Faculty.home.institution.name"));
			 Thread.sleep(4000);
			 waitUntillBufferInvisible(PropertiesRepository.getString("pulse.loading.symbol"));
			 baseHandler.findElement(PropertiesRepository.getString("se.std.pulse.home.page.institution")).click();
			 waitUntillBufferInvisible(PropertiesRepository.getString("pulse.loading.symbol"));
			 Thread.sleep(2000);
			 baseHandler.findElement(PropertiesRepository.getString("se.std.pulse.home.page.save.btn")).click();
			 
			 
			 			
			log(logger, "Clicking on Side Bar menu icon");
			WebElement sideBarIcon = baseHandler
					.findElement(PropertiesRepository.getString("ati.facultylogin.sidebar.menu"));
			sideBarIcon.isDisplayed();
			sideBarIcon.click();
			Thread.sleep(1000);
			log(logger, "Clicking on Analytics Tab");
			WebElement lblAnalytics = baseHandler
					.findElement(PropertiesRepository.getString("ati.facultylogin.leftnavigation.analytics"));
			lblAnalytics.click();
			Thread.sleep(2000);
			waitUntillBufferInvisible(PropertiesRepository.getString("pulse.loading.symbol"));
			log(logger, "Clicking on Viewdashboard Button");
//			driver.switchTo().frame((WebElement) driver.findElement(By.className("card-shadow")));
//			WebElement btnViewDashboard = baseHandler
//					.findElement(PropertiesRepository.getString("ati.testing.button.viewdashboard"));
//			btnViewDashboard.click();
			clickOncardTiles(0);
			Thread.sleep(1000);
			waitUntillBufferInvisible(PropertiesRepository.getString("pulse.loading.symbol"));
		} catch (Exception e) {
			logger.info("Unable to login", e);
		}
	  }

	private void If(boolean b) {
		// TODO Auto-generated method stub
		
	}
	
	public void clickOncardTiles(int index) throws DriverException{
		  logger.info("clickOncardTiles ::: START");
		  try{
		   List<WebElement> ele=baseHandler.findElements(PropertiesRepository.getString("analytics.landing.page.tiles"));
		   if(CollectionUtils.isNotEmpty(ele)&& ele.size()>0){
		    ele.get(index).click();
		    
		   }
		   /*baseHandler.findElement(PropertiesRepository.getString("analytics.landing.page.tiles")).click();*/
//		   waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader")); 
		  }catch(Exception e){
		   logger.info("Unable to click On tiles ");
		   log(logger, "Unable to click On tiles ");
		   throw new DriverException("Unable to click On tiles ", e); 
		  }
		  logger.info("clickOncardTiles ::: ENDS");
		 }
	
}
