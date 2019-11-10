package com.automation.asmt.page;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.ButtonHandler;
import com.ascendlearning.automation.ui.handlers.TextHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;

public class NewProctorMonitorPage extends ASMTBasePage {
	private Logger logger = LogManager.getLogger(this.getClass());
	public BaseHandler baseHandler;
	private TextHandler textHandler;
	private ButtonHandler buttonHandler;
	protected WebDriverWait wait;
	private WindowHandler windowHandler;
	
	boolean result=false;
	
	
	public NewProctorMonitorPage(WebDriver webDriver) {
		super(webDriver);
		baseHandler = new BaseHandler(driver);
		textHandler = new TextHandler(driver);
		buttonHandler = new ButtonHandler(driver);
		wait = new WebDriverWait(driver, PropertiesRepository.getInt("global.driver.wait"));
		windowHandler = new WindowHandler(driver);
		
	}
	
	
	
	private void verifyBatchGrid() throws Exception {
		logger.info("Method : Verify batch grid :::::::: Starts");
		try {
	
			logger.info("Verify batch grid--> ");
			WebElement approveButton = baseHandler.findElement(PropertiesRepository.getString(""));
			buttonHandler.clickButton(approveButton);	
			
		}
		catch (Exception e) {
				logger.info("unable to click on approve button for student" + e);
}
		logger.info("Method : click on approve button for student :::::::: Ends");
}
	
	
	
	
	
	
	
	////////   APPROVE BUTTON
	
	private void clickOnApproveButtonForStudent() throws Exception {
		logger.info("Method : click on approve button for student:::::::: Starts");
		try {
	
			logger.info("click on approve button for student--> ");
			WebElement approveButton = baseHandler.findElement(PropertiesRepository.getString("pmPage.ApproveButton"));
			buttonHandler.clickButton(approveButton);	
		
			
		}
		catch (Exception e) {
				logger.info("unable to click on approve button for student" + e);
}
		
		//logger.info("Method : click on approve button for student :::::::: Ends");
}
	
	
	//////  RESUME BUTTON
	
	private void clickOnResumeButtonForStudent() throws Exception {
		logger.info("Method : click on Resume button for student:::::::: Starts");
		try {
	
			logger.info("click on Resume button for student--> ");
			WebElement resumeButton = baseHandler.findElement(PropertiesRepository.getString(""));
			buttonHandler.clickButton(resumeButton);	
			
		}
		catch (Exception e) {
				logger.info("unable to click on Resume button for student" + e);
}
		logger.info("Method : click on Resume button for student :::::::: Ends");
}
	
	
	 /////   DENY BUTTON
	private void clickOnDenyButtonForStudent() throws Exception {
		logger.info("Method : click on Deny button for student:::::::: Starts");
		try {
	
			logger.info("click on Deny button for student--> ");
			WebElement denyButton = baseHandler.findElement(PropertiesRepository.getString("pmPage.DenyButton"));
			buttonHandler.clickButton(denyButton);	
			
		}
		catch (Exception e) {
				logger.info("unable to click on deny button for student" + e);
}
		logger.info("Method : click on deny button for student :::::::: Ends");
}
	
	
	////////  IGNORE BUTTON
	private void clickOnIgnoreButtonForStudent() throws Exception {
		logger.info("Method : click on Ignore button for student:::::::: Starts");
		try {
	
			logger.info("click on Ignore button for student--> ");
			WebElement ignoreButton = baseHandler.findElement(PropertiesRepository.getString(""));
			buttonHandler.clickButton(ignoreButton);	
			
		}
		catch (Exception e) {
				logger.info("unable to click on ignore button for student" + e);
}
		logger.info("Method : click on ignore button for student :::::::: Ends");
}
	
      //////Close  functionality from batch grid and need attention grid
	private void clickOnCloseButtonForStudentInNeedAttentionGrid() throws Exception {
		logger.info("Method : click on close button for student In Need Attention Grid:::::::: Starts");
		try {
	
			logger.info("click on close button for student In Need Attention Grid--> ");
			WebElement closeButtonFromNeedAttentionGrid = baseHandler.findElement(PropertiesRepository.getString(""));
			buttonHandler.clickButton(closeButtonFromNeedAttentionGrid);	
			
		}
		catch (Exception e) {
				logger.info("unable to click on close button for student Need Attention Grid for student" + e);
}
		logger.info("Method : click on close button for student In Need Attention Grid :::::::: Ends");
}
	
	private void clickOnCloseButtonForStudentInBatchGrid() throws Exception {
		logger.info("Method : click on close button for student In Batch Grid:::::::: Starts");
		try {
	
			logger.info("click on close button for student In Batch Grid--> ");
			WebElement closeButtonFromBatchGrid = baseHandler.findElement(PropertiesRepository.getString("pmPage.CloseButtonBatchGrid"));
			buttonHandler.clickButton(closeButtonFromBatchGrid);	
			
		}
		catch (Exception e) {
				logger.info("unable to click on close button for student In Batch Grid for student" + e);
}
		logger.info("Method : click on close button for student In Batch Grid :::::::: Ends");
}
	
	////// Abandon functionality from batch grid and need attention grid
	
	private void clickOnAbandonButtonForStudentInNeedAttentionGrid() throws Exception {
		logger.info("Method : click on Abandon button for student In Need Attention Grid:::::::: Starts");
		try {
	
			logger.info("click on Abandon button for student In Need Attention Grid--> ");
			WebElement abandonButtonFromNeedAttentionGrid = baseHandler.findElement(PropertiesRepository.getString(""));
			buttonHandler.clickButton(abandonButtonFromNeedAttentionGrid);	
			
		}
		catch (Exception e) {
				logger.info("unable to click on Abandon button for student Need Attention Grid for student" + e);
}
		logger.info("Method : click on Abandon button for student In Need Attention Grid :::::::: Ends");
}
	
	private void clickOnAbandonButtonForStudentInBatchGrid() throws Exception {
		logger.info("Method : click on Abandon button for student In Batch Grid:::::::: Starts");
		try {
	
			logger.info("click on Abandon button for student In Batch Grid--> ");
			WebElement abandonButtonFromBatchGrid = baseHandler.findElement(PropertiesRepository.getString("pmPage.AbandonButtonBatchGrid"));
			buttonHandler.clickButton(abandonButtonFromBatchGrid);	
			
		}
		catch (Exception e) {
				logger.info("unable to click on Abandon button for student In Batch Grid for student" + e);
}
		logger.info("Method : click on close Abandon for student In Batch Grid :::::::: Ends");
}
	/////////// 
	
	
	
	
	
	
	
public boolean monitoring() throws Exception {
		
		logger.info("Method : monitoring :::::::: Starts");
		try {
			
			clickOnApproveButtonForStudent();
			// clickOnResumeButtonForStudent();
			// clickOnDenyButtonForStudent();
			// clickOnIgnoreButtonForStudent();
			// clickOnCloseButtonForStudentInNeedAttentionGrid();
			// clickOnCloseButtonForStudentInBatchGrid();
			// clickOnAbandonButtonForStudentInNeedAttentionGrid();
			// clickOnAbandonButtonForStudentInBatchGrid();
			
			result=true;
			
		}
		catch (Exception e) {
				logger.info("unable to monitor" + e);
}
		logger.info("Method : monitoring :::::::: Ends");	
		return result;
}
	
	
	/////////////// MY CODE


public void swithToProctorFrame(WebDriver chromeDriver) throws DriverException {
	logger.info("Method: swithToProctorFrame Starts");
	try {
		windowHandler.switchToLatestWindow();
		List<WebElement> iframe = chromeDriver.findElements(By.cssSelector(".card-shadow"));
		if(CollectionUtils.isNotEmpty(iframe)) {
			chromeDriver.switchTo().frame(iframe.get(0));
		}
	} catch (Exception e) {
		logger.info("Unable to swithToProctorFrame" );
		log(logger, "Unable to swithToProctorFrame" );
		throw new DriverException("Unable to swithToProctorFrame" , e); 
	}
	logger.info("Method: swithToProctorFrame End " );
}

public WebElement verifyElement(WebDriver chromeDriver, String locator) throws DriverException {
	logger.info("verifyElement Start");
	WebElement webElement = null;
	try {
		List<WebElement> element = chromeDriver.findElements(By.cssSelector(locator));
		if(CollectionUtils.isNotEmpty(element)) {
			webElement = element.get(0);
		}
	} catch (Exception e) {
		logger.info("Unable to verifyElement");
		log(logger, "Unable to verifyElement" );
		throw new DriverException("Unable to verifyElement" , e); 
	}
	logger.info("verifyElement End");
	return webElement;
}



public boolean clickOnApprove(WebDriver chromeDriver) throws NullPointerException, DriverException {
logger.info("Method: click On Approve Starts ");
boolean flag = false;
try {
	
	swithToProctorFrame(chromeDriver);
	WebElement clickOnApproveButtonElement = verifyElement(chromeDriver, PropertiesRepository.getString("pmPage.ApproveButton"));
	Thread.sleep(4000);
    buttonHandler.clickButton(clickOnApproveButtonElement);
	windowHandler.switchToLatestWindow();
	flag = true;
}

catch (Exception e) {
	windowHandler.switchToLatestWindow();
	logger.info("Unable to click On Approve");
	log(logger, "Unable to click On Approve" );
	throw new DriverException("Unable to click On Approve" , e); 
}
logger.info("Method: click On Approve End--> " +flag);
return flag;
}



public boolean clickOnResume(WebDriver chromeDriver) throws NullPointerException, DriverException {
logger.info("Method: click On Resume Starts ");
boolean flag = false;
try {
	
	swithToProctorFrame(chromeDriver);
	WebElement clickOnResumeButtonElement = verifyElement(chromeDriver, PropertiesRepository.getString("pmPage.ResumeButton"));
	Thread.sleep(4000);
    buttonHandler.clickButton(clickOnResumeButtonElement);
	windowHandler.switchToLatestWindow();
	flag = true;
}

catch (Exception e) {
	windowHandler.switchToLatestWindow();
	logger.info("Unable to click On Resume");
	log(logger, "Unable to click On Resume" );
	throw new DriverException("Unable to click On Resume" , e); 
}
logger.info("Method: click On Resume End--> " +flag);
return flag;
}


public boolean clickOnAbandonFromNeedAttentionGrid(WebDriver chromeDriver) throws NullPointerException, DriverException {
logger.info("Method: click On Abandon From Need Attention Grid Starts ");
boolean flag = false;
try {
	
	swithToProctorFrame(chromeDriver);
	WebElement clickOnAbandonFromNeedAttentionGridElement = verifyElement(chromeDriver, PropertiesRepository.getString("pmPage.ApproveButton"));
	Thread.sleep(4000);
    buttonHandler.clickButton(clickOnAbandonFromNeedAttentionGridElement);
	windowHandler.switchToLatestWindow();
	flag = true;
}

catch (Exception e) {
	windowHandler.switchToLatestWindow();
	logger.info("Unable to click On Abandon From Need Attention Grid");
	log(logger, "Unable to click On Abandon From Need Attention Grid" );
	throw new DriverException("Unable to click On Abandon From Need Attention Grid" , e); 
}
logger.info("Method: click On Abandon From Need Attention Grid End--> " +flag);
return flag;
}

public boolean clickOnAbandonFromBatchGrid(WebDriver chromeDriver) throws NullPointerException, DriverException {
logger.info("Method: click On Abandon From Batch Grid Starts ");
boolean flag = false;
try {
	
	swithToProctorFrame(chromeDriver);
	WebElement clickOnAbandonFromBatchGridElement = verifyElement(chromeDriver, PropertiesRepository.getString("pmPage.AbandonButtonBatchGrid"));
	Thread.sleep(4000);
    buttonHandler.clickButton(clickOnAbandonFromBatchGridElement);
	windowHandler.switchToLatestWindow();
	flag = true;
}

catch (Exception e) {
	windowHandler.switchToLatestWindow();
	logger.info("Unable to click On Abandon From Batch Grid");
	log(logger, "Unable to click On Abandon From Batch Grid" );
	throw new DriverException("Unable to click On Abandon From Batch Grid" , e); 
}
logger.info("Method: click On Abandon From Batch Grid End--> " +flag);
return flag;
}

public boolean clickOnAbandonConfirmFromBatchGrid(WebDriver chromeDriver) throws NullPointerException, DriverException {
logger.info("Method: click On Abandon From Batch Grid Starts ");
boolean flag = false;
try {
	
	swithToProctorFrame(chromeDriver);
	WebElement clickOnAbandonConfirmFromBatchGridElement = verifyElement(chromeDriver, PropertiesRepository.getString("pmPage.abandon.confirm"));
	Thread.sleep(4000);
    buttonHandler.clickButton(clickOnAbandonConfirmFromBatchGridElement);
	windowHandler.switchToLatestWindow();
	flag = true;
}

catch (Exception e) {
	windowHandler.switchToLatestWindow();
	logger.info("Unable to click On Abandon From Batch Grid");
	log(logger, "Unable to click On Abandon From Batch Grid" );
	throw new DriverException("Unable to click On Abandon From Batch Grid" , e); 
}
logger.info("Method: click On Abandon From Batch Grid End--> " +flag);
return flag;
}

public boolean clickOnCloseFromBatchGrid(WebDriver chromeDriver) throws NullPointerException, DriverException {
logger.info("Method: click On Close From Batch Grid Starts ");
boolean flag = false;
try {
	
	swithToProctorFrame(chromeDriver);
	WebElement clickOnCloseFromBatchGridElement = verifyElement(chromeDriver, PropertiesRepository.getString("pmPage.CloseButtonBatchGrid"));
	Thread.sleep(4000);
    buttonHandler.clickButton(clickOnCloseFromBatchGridElement);
	windowHandler.switchToLatestWindow();
	flag = true;
}

catch (Exception e) {
	windowHandler.switchToLatestWindow();
	logger.info("Unable to click On Close From Batch Grid");
	log(logger, "Unable to click On Close From Batch Grid" );
	throw new DriverException("Unable to click On Close From Batch Grid" , e); 
}
logger.info("Method: click On Close From Batch Grid End--> " +flag);
return flag;
}

public boolean clickOnCloseConfirmFromBatchGrid(WebDriver chromeDriver) throws NullPointerException, DriverException {
logger.info("Method: click On Close From Batch Grid Starts ");
boolean flag = false;
try {
	
	swithToProctorFrame(chromeDriver);
	WebElement clickOnCloseConfirmFromBatchGridElement = verifyElement(chromeDriver, PropertiesRepository.getString("pmPage.close.confirm"));
	Thread.sleep(4000);
    buttonHandler.clickButton(clickOnCloseConfirmFromBatchGridElement);
	windowHandler.switchToLatestWindow();
	flag = true;
}

catch (Exception e) {
	windowHandler.switchToLatestWindow();
	logger.info("Unable to click On Close From Batch Grid");
	log(logger, "Unable to click On Close From Batch Grid" );
	throw new DriverException("Unable to click On Close From Batch Grid" , e); 
}
logger.info("Method: click On Close From Batch Grid End--> " +flag);
return flag;
}

public boolean clickOnglobalmenu(WebDriver chromeDriver) throws NullPointerException, DriverException {
logger.info("Method: click On global menu Starts ");
boolean flag = false;
try {
	
	swithToProctorFrame(chromeDriver);
	WebElement clickonglobalmenuElement = verifyElement(chromeDriver, PropertiesRepository.getString("global.menu"));
	Thread.sleep(4000);
    buttonHandler.clickButton(clickonglobalmenuElement);
	windowHandler.switchToLatestWindow();
	flag = true;
}

catch (Exception e) {
	windowHandler.switchToLatestWindow();
	logger.info("Unable to click On global menu");
	log(logger, "Unable to click On global menu" );
	throw new DriverException("Unable to click On global menu" , e); 
}
logger.info("Method: click On Approve End--> " +flag);
return flag;
}


public boolean clickOnProctorNewAssessment(WebDriver chromeDriver) throws NullPointerException, DriverException {
logger.info("Method: click On Proctor New Assessment Starts ");
boolean flag = false;
try {
	
	swithToProctorFrame(chromeDriver);
	WebElement clickOnResumeButtonElement = verifyElement(chromeDriver, PropertiesRepository.getString("proctor.new.assessments.button"));
	Thread.sleep(4000);
    buttonHandler.clickButton(clickOnResumeButtonElement);
	windowHandler.switchToLatestWindow();
	flag = true;
}

catch (Exception e) {
	windowHandler.switchToLatestWindow();
	logger.info("Unable to click On Proctor New Assessment");
	log(logger, "Unable to click On Proctor New Assessment" );
	throw new DriverException("Unable to click On Proctor New Assessment" , e); 
}
logger.info("Method: click On Proctor New Assessment End--> " +flag);
return flag;
}

public boolean searchassessmentinmodalpopup(WebDriver chromeDriver) throws NullPointerException, DriverException {
logger.info("Method: click On Proctor New Assessment Starts ");
boolean flag = false;
try {
	
	swithToProctorFrame(chromeDriver);
	WebElement clickOnResumeButtonElement = verifyElement(chromeDriver, PropertiesRepository.getString("PNA.assessment.search.button"));
	Thread.sleep(4000);
    buttonHandler.clickButton(clickOnResumeButtonElement);
	windowHandler.switchToLatestWindow();
	flag = true;
}

catch (Exception e) {
	windowHandler.switchToLatestWindow();
	logger.info("Unable to click On Proctor New Assessment");
	log(logger, "Unable to click On Proctor New Assessment" );
	throw new DriverException("Unable to click On Proctor New Assessment" , e); 
}
logger.info("Method: click On Proctor New Assessment End--> " +flag);
return flag;
}

public boolean searchhereassessmentinmodalpopup(WebDriver chromeDriver) throws NullPointerException, DriverException {
logger.info("Method: click On Proctor New Assessment Starts ");
boolean flag = false;
try {
	
	swithToProctorFrame(chromeDriver);
	WebElement clickOnResumeButtonElement = verifyElement(chromeDriver, PropertiesRepository.getString("PNA.search.assessment"));
	Thread.sleep(4000);
    buttonHandler.clickButton(clickOnResumeButtonElement);
	windowHandler.switchToLatestWindow();
	flag = true;
}

catch (Exception e) {
	windowHandler.switchToLatestWindow();
	logger.info("Unable to click On Proctor New Assessment");
	log(logger, "Unable to click On Proctor New Assessment" );
	throw new DriverException("Unable to click On Proctor New Assessment" , e); 
}
logger.info("Method: click On Proctor New Assessment End--> " +flag);
return flag;
}

public boolean enteringBatchIdinmodalpopup(WebDriver chromeDriver, String Batchid) throws NullPointerException, DriverException {
	logger.info("Method: entering batch id in modal pop up Starts ");
	boolean flag = false;
	try {
		
		swithToProctorFrame(chromeDriver);
		WebElement batchidinmodalpopupElement = verifyElement(chromeDriver, PropertiesRepository.getString("PNA.search.assessment"));
	    buttonHandler.clickButton(batchidinmodalpopupElement);
	    batchidinmodalpopupElement.sendKeys(Batchid);
	    Thread.sleep(3000);
		windowHandler.switchToLatestWindow();
		flag = true;
	}
	
	catch (Exception e) {
		windowHandler.switchToLatestWindow();
		logger.info("Unable to enter batch id in modal pop up");
		log(logger, "Unable to enter batch id in modal pop up" );
		throw new DriverException("Unable to enter batch id in modal pop up" , e); 
	}
	logger.info("Method: enter batch id in modal pop up End --> " +flag);
	return flag;
}

public boolean selectassessmentinmodalpopup(WebDriver chromeDriver) throws NullPointerException, DriverException {
logger.info("Method: select assessment in modal popup Starts ");
boolean flag = false;
try {
	
	swithToProctorFrame(chromeDriver);
	WebElement selectassessmentcheckboxElement = verifyElement(chromeDriver, PropertiesRepository.getString("PNA.searched.assessment.checkbox"));
	Thread.sleep(4000);
    buttonHandler.clickButton(selectassessmentcheckboxElement);
	windowHandler.switchToLatestWindow();
	flag = true;
}

catch (Exception e) {
	windowHandler.switchToLatestWindow();
	logger.info("Unable to select assessment in modal popup");
	log(logger, "Unable to select assessment in modal popup" );
	throw new DriverException("Unable to select assessment in modal popup" , e); 
}
logger.info("Method: select assessment in modal popup End--> " +flag);
return flag;
}

public boolean clickcontinueinmodalpopup(WebDriver chromeDriver) throws NullPointerException, DriverException {
logger.info("Method: select assessment in modal popup Starts ");
boolean flag = false;
try {
	
	swithToProctorFrame(chromeDriver);
	WebElement clickcontinueElement = verifyElement(chromeDriver, PropertiesRepository.getString("PNA.assessment.continue.button"));
	Thread.sleep(4000);
    buttonHandler.clickButton(clickcontinueElement);
	windowHandler.switchToLatestWindow();
	flag = true;
}

catch (Exception e) {
	windowHandler.switchToLatestWindow();
	logger.info("Unable to select assessment in modal popup");
	log(logger, "Unable to select assessment in modal popup" );
	throw new DriverException("Unable to select assessment in modal popup" , e); 
}
logger.info("Method: select assessment in modal popup End--> " +flag);
return flag;
}

public boolean clickAllCheckboxinmodalpopup(WebDriver chromeDriver, boolean click) throws NullPointerException, DriverException {
	logger.info("Method: clickAllCheckbox Starts ");
	boolean flag = false;
	try {
		
		swithToProctorFrame(chromeDriver);
		List<WebElement> element1 = chromeDriver.findElements(By.cssSelector(PropertiesRepository.getString("PNA.complete.agreement.all.checkbox")));
		if(CollectionUtils.isNotEmpty(element1)) {
			int size1 = element1.size();
			for(int index = 0; index < size1; index++) {
				WebElement navElement = element1.get(index);
				navElement.click();
				
    			}
			}
		
		windowHandler.switchToLatestWindow();
		flag = true;
	}
	
	catch (Exception e) {
		windowHandler.switchToLatestWindow();
		logger.info("Unable to clickAllCheckbox");
		log(logger, "Unable to clickAllCheckbox" );
		throw new DriverException("Unable to clickAllCheckbox" , e); 
	}
	logger.info("Method: clickAllCheckbox End flag--> " +flag);
	return flag;
}

public boolean enteringElectronicsignatureinmodalpopup(WebDriver chromeDriver, String Electronicsignature1) throws NullPointerException, DriverException {
	logger.info("Method: enteringProctIdAndPwd Starts ");
	boolean flag = false;
	try {
		
		swithToProctorFrame(chromeDriver);
		WebElement ElectronisignatureElement1 = verifyElement(chromeDriver, PropertiesRepository.getString("PNA.electronic.signature"));
		
		if(ElectronisignatureElement1 != null) {
			buttonHandler.clickButton(ElectronisignatureElement1);
			ElectronisignatureElement1.sendKeys(Electronicsignature1);
			flag = true;
		}
		
		windowHandler.switchToLatestWindow();
	} catch (Exception e) {
		windowHandler.switchToLatestWindow();
		logger.info("Unable to enter batch id");
		log(logger, "Unable to enteringProctIdAndPwd" );
		throw new DriverException("Unable to enteringProctIdAndPwd" , e); 
	}
	logger.info("Method: enteringProctIdAndPwd End flag--> " +flag);
	return flag;
}

public boolean clickIAgreeinmodalpopup(WebDriver chromeDriver) throws NullPointerException, DriverException {
	logger.info("Method: enteringProctIdAndPwd Starts ");
	boolean flag = false;
	try {
		
		swithToProctorFrame(chromeDriver);
		WebElement ClickIagree = verifyElement(chromeDriver, PropertiesRepository.getString("PNA.I.Agree"));
	    buttonHandler.clickButton(ClickIagree);
		windowHandler.switchToLatestWindow();
		flag = true;
	}
	
	catch (Exception e) {
		windowHandler.switchToLatestWindow();
		logger.info("Unable to enter batch id");
		log(logger, "Unable to enteringProctIdAndPwd" );
		throw new DriverException("Unable to enteringProctIdAndPwd" , e); 
	}
	logger.info("Method: enteringProctIdAndPwd End flag--> " +flag);
	return flag;
}
	

public boolean startproctoringinmodalpopup(WebDriver chromeDriver) throws NullPointerException, DriverException {
	logger.info("Method: enteringProctIdAndPwd Starts ");
	boolean flag = false;
	try {
		
		swithToProctorFrame(chromeDriver);
		WebElement ClickIagree = verifyElement(chromeDriver, PropertiesRepository.getString("PNA.start.proctoring"));
	    buttonHandler.clickButton(ClickIagree);
		windowHandler.switchToLatestWindow();
		flag = true;
	}
	
	catch (Exception e) {
		windowHandler.switchToLatestWindow();
		logger.info("Unable to enter batch id");
		log(logger, "Unable to enteringProctIdAndPwd" );
		throw new DriverException("Unable to enteringProctIdAndPwd" , e); 
	}
	logger.info("Method: enteringProctIdAndPwd End flag--> " +flag);
	return flag;
}

/// adding students from batch grid

public boolean gearbutton(WebDriver chromeDriver) throws NullPointerException, DriverException {
	logger.info("Method: click on gear button Starts ");
	boolean flag = false;
	try {
		
		swithToProctorFrame(chromeDriver);
		WebElement gearbuttonelement = verifyElement(chromeDriver, PropertiesRepository.getString("gear.button"));
	    buttonHandler.clickButton(gearbuttonelement);
		windowHandler.switchToLatestWindow();
		flag = true;
	}
	
	catch (Exception e) {
		windowHandler.switchToLatestWindow();
		logger.info("Unable to click on gear button");
		log(logger, "Unable to click on gear button" );
		throw new DriverException("Unable to click on gear button" , e); 
	}
	logger.info("Method: click on gear button--> " +flag);
	return flag;
}

public boolean addstudentsFromBatchGrid(WebDriver chromeDriver) throws NullPointerException, DriverException {
	logger.info("Method: add students From Batch Grid Starts ");
	boolean flag = false;
	try {
		
		swithToProctorFrame(chromeDriver);
		WebElement addstudentfrombatchgridbutton = verifyElement(chromeDriver, PropertiesRepository.getString("add.students.from.batch.grid"));
	    buttonHandler.clickButton(addstudentfrombatchgridbutton);
		windowHandler.switchToLatestWindow();
		flag = true;
	}
	
	catch (Exception e) {
		windowHandler.switchToLatestWindow();
		logger.info("Unable to add students From Batch Grid");
		log(logger, "Unable to add students From Batch Grid" );
		throw new DriverException("Unable to add students From Batch Grid" , e); 
	}
	logger.info("Method: add students From Batch Grid End flag--> " +flag);
	return flag;
}

public boolean clickonallcheckboxforstudentfrommodalpopup(WebDriver chromeDriver, boolean click) throws NullPointerException, DriverException {
	logger.info("Method: click on all checkbox for student Starts ");
	boolean flag = false;
	try {
		
		swithToProctorFrame(chromeDriver);
		List<WebElement> element2 = chromeDriver.findElements(By.cssSelector(PropertiesRepository.getString("add.students.modal.pop.up.all.student.check.box")));
		if(CollectionUtils.isNotEmpty(element2)) {
			int size = element2.size();
			for(int index = 0; index < size; index++) {
				WebElement navElement = element2.get(index);
				navElement.click();
				
    			}
			}
		
	    
	    
		windowHandler.switchToLatestWindow();
		flag = true;
	}
	
	catch (Exception e) {
		windowHandler.switchToLatestWindow();
		logger.info("Unable to click on all checkbox for student");
		log(logger, "Unable to click on all checkbox for student" );
		throw new DriverException("Unable to click on all checkbox for student" , e); 
	}
	logger.info("Method: clickAllCheckbox End flag--> " +flag);
	return flag;
}

public boolean addstudentsbutton(WebDriver chromeDriver) throws NullPointerException, DriverException {
	logger.info("Method: add students From Batch Grid Starts ");
	boolean flag = false;
	try {
		
		swithToProctorFrame(chromeDriver);
		WebElement addstudentfrombatchgridbutton = verifyElement(chromeDriver, PropertiesRepository.getString("add.students.modal.pop.up.add.students.button"));
	    buttonHandler.clickButton(addstudentfrombatchgridbutton);
		windowHandler.switchToLatestWindow();
		flag = true;
	}
	
	catch (Exception e) {
		windowHandler.switchToLatestWindow();
		logger.info("Unable to add students From Batch Grid");
		log(logger, "Unable to add students From Batch Grid" );
		throw new DriverException("Unable to add students From Batch Grid" , e); 
	}
	logger.info("Method: add students From Batch Grid End flag--> " +flag);
	return flag;
}


}
