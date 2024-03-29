package com.automation.newati.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
import org.openqa.selenium.support.ui.Select;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.DropDownHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;

public class TutorialPage6 extends NewATIBasePage {

	private Logger logger = LogManager.getLogger(this.getClass());
	public String actualText = "";
	public BaseHandler baseHandler;
	private DropDownHandler dropDownHandler;
	private WindowHandler windowHandler;
	
	public TutorialPage6(WebDriver webDriver) {
		super(webDriver);
		baseHandler = new BaseHandler(driver);
		dropDownHandler = new DropDownHandler(driver);
		windowHandler = new WindowHandler(driver);
	}

	/**
	 * Method is used to verify spedometer for proctor assessment
	 * 
	 * @author Sasmita
	 * 
	 * @throws DriverException
	 */
	public boolean VerifySpedometerinProctorTestTab(String assessmentName) throws Exception {
		logger.info("Method: VerifySpedometerinProctorTestTab Start");
		boolean flag = false;
		try {
			List<WebElement> moduleList = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.all.modules.proctor.loc"));
			if (moduleList != null && moduleList.size() > 0) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					WebElement element = moduleList.get(i).findElement(By.cssSelector(
							PropertiesRepository.getString("new-atitesting.specific.product.testtab.name.loc")));
					if (assessmentName.equalsIgnoreCase(element.getText())) {
						List<WebElement> spedoMeter = baseHandler.findElements(
								PropertiesRepository.getString("new-atitesting.specific.spedometer.name.loc"));
						if (CollectionUtils.isNotEmpty(spedoMeter) && spedoMeter.get(0).isDisplayed()) {
							flag = true;
							logger.info("Method: VerifySpedometerinProctorTestTab End flag-- > " + flag);
						}
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						break;
					}
				}
			}
		} catch (Exception e) {
			throw new Exception("VerifySpedometerinProctorTestTab ", e);
		}
		logger.info("Method: VerifySpedometerinProctorTestTab End flag-- > " + flag);
		return flag;
	}

	/**
	 * Method is used to verify spedometer for Borad Vital product
	 * 
	 * @author Sasmita
	 * 
	 * @throws DriverException
	 */
	public boolean VerifySpedometerinNCLEXPREPTab(String assessmentName) throws Exception {
		logger.info("Method: VerifySpedometerinNCLEXPREPTab Start");
		boolean flag = false;
		try {
			List<WebElement> moduleList = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.all.modules.nclex.loc"));
			if (moduleList != null && moduleList.size() > 0) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					WebElement element = moduleList.get(i).findElement(By.cssSelector(
							PropertiesRepository.getString("new-atitesting.specific.modules.name.loc.name")));
					if (assessmentName.contains(element.getText())) {
						List<WebElement> spedoMeter = baseHandler.findElements(
								PropertiesRepository.getString("new-atitesting.specific.spedometer.name.loc"));
						if (CollectionUtils.isNotEmpty(spedoMeter) && spedoMeter.get(0).isDisplayed()) {
							flag = true;
							logger.info("Method: VerifySpedometerinNCLEXPREPTab End flag-- > " + flag);
						}
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
					}
				}
			}
		} catch (Exception e) {
			throw new Exception("VerifySpedometerinNCLEXPREPTab ", e);
		}
		logger.info("Method: VerifySpedometerinNCLEXPREPTab End flag-- > " + flag);
		return flag;
	}
	
	
	
	/**
	 * Verify if order id is generated for the purchases assessment
	 * @author syed.pash	 * 
	 * @throws DriverException
	 */
	public boolean VerifyifOrderIDGenerated(String assessmentName) throws Exception {
		logger.info("Method: VerifyifOrderIDGeneratedString Start");
		boolean flag = false;
		try {
			List<WebElement> moduleList = baseHandler
					.findElements("section[data-bind='visible: IsPurchaseHistoryVisible'] table tbody tr td");
			if (moduleList != null && moduleList.size() > 0 && moduleList.get(0)!= null && moduleList.get(2).getText().equals(assessmentName)) {
				flag = true;				
			}
		} catch (Exception e) {
			throw new Exception("VerifyifOrderIDGenerated ", e);
		}
		logger.info("Method: VerifyifOrderIDGeneratedString End flag-- > " + flag);
		return flag;
	}
	

	/**
	 * Select First institution 
	 * @author syed.pash	 * 
	 * @throws DriverException
	 */
	public void selectFirstInstitution( ) throws Exception {
		logger.info("Method: selectFirstInstitution Start");
		
		new Select(driver.findElement(By.id("ctl00_MainContent_swplistboxInstitutions_lstLeftList"))).selectByIndex(1);
		baseHandler.findElement("#ctl00_MainContent_swplistboxInstitutions_btnMoveToRight").click();
		baseHandler.findElement("#ctl00_MainContent_btnContinue").click();
		logger.info("Method: selectFirstInstitution End");
		
	}
	
	/**
	 * Verify if Purchases assessment are present in Learn Tab 
	 * @author syed.pash	 
	 * @throws DriverException
	 */
	public boolean verifyPurchasesAssessmentInLearnTab(String ass1 ,String ass2 ,String ass3 ) throws Exception {
		logger.info("Method: verifyPurchasesAssessmentInLearnTab Start");
		boolean flag = false;
		List<WebElement> elements = baseHandler.findElements("#tabs-1 .flipper");
		int count = 0;
		for(int i=0 ; i < elements.size() ; i++){
			if (elements.get(i).findElement(By.cssSelector("div[class='description']")).getText().contains(ass1)
					|| elements.get(i).findElement(By.cssSelector("div[class='description']")).getText().contains(ass2)) {
				count++;
			}
		}
		if(count ==2 )
		{
			flag = true;
		}
		logger.info("Method: verifyPurchasesAssessmentInLearnTab End");
		return flag;
	}
	
	/**
	 * Verify List of Ebook list and Ebook buttons are displayed
	 * 
	 * @author syed.pash
	 * @throws DriverException
	 */
	public boolean verifyEbooListAndBtnDisplayed() throws Exception {
		logger.info("Method: verifyEbooListAndBtnDisplayed Start");
		boolean flag = false;
		List<WebElement> elements = baseHandler.findElements(".ebook-row");
		int count = 0;
		for (int i = 0; i < elements.size(); i++) {
			if (elements.get(i).findElement(By.cssSelector("header span")).isDisplayed()
					&& elements.get(i).findElement(By.cssSelector("section div a span[style='color:black;']")).getText().equals("EBOOK") && elements.get(i).findElement(By.cssSelector("section div a span[style='color:black;']")).isDisplayed() ) {
				count++;
			}
		}
		if (count == 10) {
			flag = true;
		}
		logger.info("Method: verifyEbooListAndBtnDisplayed End");
		return flag;
	}
	
	/**
	 * Verify List of Ebook list and 'PDF Book' and 'Media Resources' buttons are displayed
	 * 
	 * @author syed.pash
	 * @throws DriverException
	 */
	public boolean verifyEbooListAndPDFAndMediaResourceBtnDisplayed() throws Exception {
		logger.info("Method: verifyEbooListAndPDFAndMediaResourceBtnDisplayed Start");
		boolean flag = false;
		List<WebElement> elements = baseHandler.findElements(".ebook-row");
			
		int count = 0;
		for (int i = 0; i < elements.size(); i++) {
			List<WebElement> elements2 = elements.get(i).findElements(By.cssSelector("section div"));
			List<WebElement> elements3 = elements.get(i).findElements(By.cssSelector("section div a[class='button secondary-button focus-element-flag']"));
			if (elements.get(i).findElement(By.cssSelector("header span")).isDisplayed()
					&& elements2.get(0).findElement(By.cssSelector("span")).getText().equals("PDF BOOK")
					&& elements2.get(0).findElement(By.cssSelector("span")).isDisplayed()
					&& elements3.get(0).getText().equals("MEDIA RESOURCES")
					&& elements3.get(0).isDisplayed()) {
				count++;
			}
		}
		if (count == 9) {
			flag = true;
		}
		logger.info("Method: verifyEbooListAndPDFAndMediaResourceBtnDisplayed End");
		return flag;
	}
	
	public boolean verifySTTLessonPage() throws Exception {
		logger.info("Method: verifySTTLessonPage Starts");
		boolean flag = false;
    	try {
    		waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
    		windowHandler.switchToFrame("tutorialFrame");
    		windowHandler.switchToFrame("contentframe_0");
    		WebElement logo=baseHandler.findElement(PropertiesRepository.getString("new-atitesting.STTLesson.Logo.loc"));
    		WebElement home=baseHandler.findElement(PropertiesRepository.getString("new-atitesting.STTLesson.home.loc"));
    		WebElement Course=baseHandler.findElement(PropertiesRepository.getString("new-atitesting.STTLesson.coursemenu.loc"));
    		WebElement reference=baseHandler.findElement(PropertiesRepository.getString("new-atitesting.STTLesson.reference.loc"));
    		WebElement Meetauthor=baseHandler.findElement(PropertiesRepository.getString("new-atitesting.STTLesson.MeetAuthor.loc"));
    		WebElement help=baseHandler.findElement(PropertiesRepository.getString("new-atitesting.STTLesson.help.loc"));
    		List<WebElement> Authordetails = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.STTLesson.bottomdetails.loc"));
    		if (logo.isDisplayed()&&home.isDisplayed()&&Course.isDisplayed()&&reference.isDisplayed()&&
    				Meetauthor.isDisplayed()&&help.isDisplayed()&& Authordetails.get(0).isDisplayed()&& 
    				Authordetails.get(0).isDisplayed()) {
				flag = true;
    		}
    		
    	} catch (Exception e) {
    		logger.info("Unable to verifySTTLessonPage");
			log(logger, "Unable to verifySTTLessonPage" );
    		throw new DriverException("Unable to verifySTTLessonPage" , e); 
    	}
    	logger.info("Method: verifySTTLessonPage End flag --> " + flag);
    	return flag;
	}
	public boolean STT_Verifycoursedropdown() throws Exception {
		logger.info("Method: STT_Verifycoursedropdown Starts");
		boolean flag = false;
    	try {
    		waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
    		WebElement Course=baseHandler.findElement(PropertiesRepository.getString("new-atitesting.STTLesson.coursemenu.loc"));
    		
    		Course.click();
    		waitForAwhile(1000);
    		List<WebElement> dropdownvalue=baseHandler.findElements(PropertiesRepository.getString("new-atitesting.STTLesson.course.menus.loc"));
    		String dv1=dropdownvalue.get(0).getText();
    		String dv2=dropdownvalue.get(1).getText();
    		String dv3=dropdownvalue.get(2).getText();
    		String dv4=dropdownvalue.get(3).getText();
    		String dv5=dropdownvalue.get(4).getText();
    		String dv6=dropdownvalue.get(5).getText();
    		if (dv1.trim().equals("About This Course") && dv2.trim().equals("Learning Outcomes") && dv3.trim().contains("Lesson 1") && dv4.trim().contains("Lesson 2") && dv5.trim().contains("Lesson 3") && dv6.trim().contains("Lesson 4")) {
			flag = true;
    		}
    		
    	} catch (Exception e) {
    		logger.info("Unable to STT_Verifycoursedropdown");
			log(logger, "Unable to STT_Verifycoursedropdown" );
    		throw new DriverException("Unable to verify STT_Verifycoursedropdown" , e); 
    	}
    	logger.info("Method: STT_Verifycoursedropdown End flag --> " + flag);
    	return flag;
	}
	public boolean STT_selectAndVerifyCoursecontent() throws Exception {
		logger.info("Method: STT_selectAndVerifyCoursecontent Starts");
		boolean flag = false;
    	try {
    		waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
    		WebElement Course=baseHandler.findElement(PropertiesRepository.getString("new-atitesting.STTLesson.coursemenu.loc"));
    		Course.click();
    		waitForAwhile(500);
    		List<WebElement> dropdownvalue=baseHandler.findElements(PropertiesRepository.getString("new-atitesting.STTLesson.course.menus.loc"));
    		waitForAwhile(500);
    		dropdownvalue.get(0).click();
    		waitForAwhile(1000);
    		WebElement Lessonstarted=baseHandler.findElement(PropertiesRepository.getString("new-atitesting.STT.Lesson.started.loc.update"));
    		waitForAwhile(500);
    		if (Lessonstarted.getText().contains("THIS COURSE")) {
				flag = true;
    		}
    		
    	} catch (Exception e) {
    		logger.info("Unable to STT_selectAndVerifyCoursecontent");
			log(logger, "Unable to STT_selectAndVerifyCoursecontent" );
    		throw new DriverException("Unable to verify STT_selectAndVerifyCoursecontent" , e); 
    	}
    	logger.info("Method: STT_Verifycoursedropdown End flag --> " + flag);
    	return flag;
	}
	public boolean STTLesson_CheckPaginationicon() throws Exception {
		logger.info("Method: STTLesson_CheckPaginationicon Starts");
		boolean flag = false;
    	try {
    		waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
    		WebElement previcon=baseHandler.findElement(PropertiesRepository.getString("new-atitesting.STT.Lesson.pagination.prev.loc"));
    		WebElement nexticon=baseHandler.findElement(PropertiesRepository.getString("new-atitesting.STT.Lesson.pagination.next.loc"));
    		
    		if (previcon.isDisplayed()&& nexticon.isDisplayed()) {
				flag = true;
    		}
    		
    	} catch (Exception e) {
    		logger.info("Unable to STTLesson_CheckPaginationicon");
			log(logger, "Unable to STTLesson_CheckPaginationicon" );
    		throw new DriverException("Unable to verify STT_selectAndVerifyCoursecontent" , e); 
    	}
    	logger.info("Method: STTLesson_CheckPaginationicon End flag --> " + flag);
    	return flag;
	}
	public boolean STTLesson_clickandVerifyReferenceTab() throws Exception {
		logger.info("Method: STTLesson_clickandVerifyReferenceTab Starts");
		boolean flag = false;
    	try {
    		waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
    		WebElement referencebutton=baseHandler.findElement(PropertiesRepository.getString("new-atitesting.STTLesson.reference.loc"));
    		referencebutton.click();
    		waitForAwhile(1000);
    		WebElement referencepage=baseHandler.findElement(PropertiesRepository.getString("new-atitesting.STT.reference.page.text.loc"));
    		List<WebElement>referencepagelinks=baseHandler.findElements(PropertiesRepository.getString("new-atitesting.STT.reference.links.loc"));
    		if (referencepage.isDisplayed()) {
    			for (int i=1;i<referencepagelinks.size();i++){
    				if(referencepagelinks.get(i).isDisplayed()){
    					flag=true;
    				}
    			}
				
    		}
    		
    	} catch (Exception e) {
    		logger.info("Unable to STTLesson_clickandVerifyReferenceTab");
			log(logger, "Unable to STTLesson_clickandVerifyReferenceTab" );
    		throw new DriverException("Unable to verify STTLesson_clickandVerifyReferenceTab" , e); 
    	}
    	logger.info("Method: STTLesson_clickandVerifyResourceTab End flag --> " + flag);
    	return flag;
	}
	public boolean STTLesson_MeetTheAuthorTab() throws Exception {
		logger.info("Method: STTLesson_MeetTheAuthorTab Starts");
		boolean flag = false;
    	try {
    		waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
    		WebElement Meetauthor=baseHandler.findElement(PropertiesRepository.getString("new-atitesting.STTLesson.MeetAuthor.loc"));
    		Meetauthor.click();
    		waitForAwhile(1000);
    		WebElement meetauthorpageText=baseHandler.findElement(PropertiesRepository.getString("new-atitesting.STT.meetauthor.page.text.loc"));
    		
    		if (meetauthorpageText.isDisplayed()) {
    			flag=true;
    				}
    		
    	} catch (Exception e) {
    		logger.info("Unable to STTLesson_MeetTheAuthorTab");
			log(logger, "Unable to STTLesson_MeetTheAuthorTab" );
    		throw new DriverException("Unable to verify STTLesson_clickandVerifyResourceTab" , e); 
    	}
    	logger.info("Method: STTLesson_MeetTheAuthorTab End flag --> " + flag);
    	return flag;
	}
	public boolean STTLesson_VerifyHelpTab() throws Exception {
		logger.info("Method: STTLesson_VerifyHelpTab Starts");
		boolean flag = false;
    	try {
    		waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
    		WebElement help=baseHandler.findElement(PropertiesRepository.getString("new-atitesting.STTLesson.help.loc"));
    		help.click();
    		waitForAwhile(1000);
    		WebElement troubleshoot=baseHandler.findElement(PropertiesRepository.getString("new-atitesting.STT.lesson.help.troubleshoot.loc"));
    		List<WebElement>helptabcontents=baseHandler.findElements(PropertiesRepository.getString("new-atitesting.STT.lesson.help.content.loc"));
    		if (troubleshoot.getText().equalsIgnoreCase("Troubleshooting")&& helptabcontents.get(0).getText().contains("Navigation")&& helptabcontents.get(1).getText().contains("Web links")&&
    				helptabcontents.get(2).getText().contains("References")&& helptabcontents.get(3).getText().contains("Pop-up windows")) {
    			flag=true;
				   		}
    		
    	} catch (Exception e) {
    		logger.info("Unable to STTLesson_VerifyHelpTab");
			log(logger, "Unable to STTLesson_VerifyHelpTab" );
    		throw new DriverException("Unable to verifySTTLesson_VerifyHelpTab" , e); 
    	}
    	logger.info("Method: STTLesson_VerifyHelpTab End flag --> " + flag);
    	return flag;
	}
	public boolean LearnTab_VerifyQuizbankTag() throws Exception {
		logger.info("Method: LearnTab_VerifyQuizbankTag Starts");
		boolean flag = false;
    	try {
    		waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
    		baseHandler.waitToBeDisplayed(".content-area-select>label");
			Select TypeDrop = dropDownHandler.getDropDown(PropertiesRepository
					.getString("new-atitesting.tutorial.dropdownLoc"));
			List<WebElement> dropdownoptions = TypeDrop.getOptions();
		    for (int i = 0; i < dropdownoptions.size(); i++) {
		    	System.out.println(dropdownoptions.get(i).getText());
		    	if(dropdownoptions.get(i).getText().equalsIgnoreCase("Quiz Banks")){
		    		flag=true;
		    	}
		    }
    		
    	} catch (Exception e) {
    		logger.info("Unable to verify LearnTab_VerifyQuizbankTag");
			log(logger, "Unable to verify LearnTab_VerifyQuizbankTag" );
    		throw new DriverException("Unable to verify LearnTab_VerifyQuizbankTag" , e); 
    	}
    	logger.info("Method: LearnTab_VerifyQuizbankTag End flag --> " + flag);
    	return flag;
	}
	public boolean Verify_VCSPage() throws Exception {
		logger.info("Method: Verify_VCSPage Starts");
		boolean flag = false;
    	try {
    		waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
    		windowHandler.switchToLatestWindow();
    		WebElement Videocase=baseHandler.findElement(PropertiesRepository.getString("new-atitesting.myati.VCSPage.Name.loc"));
    		if (Videocase.getText().equalsIgnoreCase(PropertiesRepository.getString("new.atitesting.applytab.tutorial.name"))) {
    			flag=true;
				   		}
    	} catch (Exception e) {
    		logger.info("Unable to verify Verify_VCSPage");
			log(logger, "Unable to verify Verify_VCSPage" );
    		throw new DriverException("Unable to verify Verify_VCSPage" , e); 
    	}
    	logger.info("Method: Verify_VCSPage End flag --> " + flag);
    	return flag;
	}
	
	public boolean verifyAllProducteName()
			throws Exception {
		logger.info("verifyAllProducteName Start");
		boolean flag = false;
		try {
			windowHandler.switchToLatestWindow();
			List<WebElement> element = baseHandler.findElements(".flipper");
			if(CollectionUtils.isNotEmpty(element)) {
				int size = element.size();
				for(int index = 0; index < size; index ++) {
					flag = false;
					
					String productname = element.get(index).findElement(By.cssSelector("header span")).getText();
					
					if(StringUtils.isNotBlank(productname) ){
						if(productname.equalsIgnoreCase("Tutorial") || productname.contains("Flashcards")||productname.contains("Quiz Bank")||productname.contains("eBook")) {
						flag = true;
						}
						if(!flag) {
							flag = false;
							break;
						}
					}
				}
			}
		}
		catch (Exception e) {
			logger.info("Unable to verifyAllProducteName");
			throw new Exception("Unable to verifyAllProducteName");
		}
		logger.info("Method: verifyAllProducteName End --> " + flag);
		return flag;
	}
	
	public void waitForAwhile(int milliSeconds)
	{
		try {
			Thread.sleep(milliSeconds);
		} catch (Exception e) {
		}
	}
	
	public void clickButtonByActionClassFromList(String loc,int index) throws Exception {
		logger.info("clickButtonByActionClassFromList Start ");
		try {
			driver.switchTo().defaultContent();
			windowHandler.switchToFrame("OpenPageFrame");
			List<WebElement> elements = baseHandler.findElements(PropertiesRepository.getString(loc));
			//List<WebElement> elements = baseHandler.findElements(loc);
			if(CollectionUtils.isNotEmpty(elements))
			{
				new Actions(driver).moveToElement(elements.get(index)).click().build().perform();
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			}
		} catch (Exception e) {
			logger.info("Unable to clickButtonByActionClassFromList");
			log(logger, "Unable to clickButtonByActionClassFromList");
			throw new DriverException("Unable to clickButtonByActionClassFromList", e);
		}
		logger.info("clickButtonByActionClassFromList End");
	}
	
	/**
	 * Method is used to complete Test
	 * 
	 * breakFlag If assessment has to be stopped in middle.
	 * 
	 * rationaleFlag Need to check for Rationale and My Answer.
	 * 
	 * @param bool
	 * @param breakFlag
	 * @param rationaleFlag
	 * @throws Exception
	 */
	public boolean takeTestPharmacologyAndNurseLogic30(boolean bool, boolean breakFlag,
			boolean rationaleFlag, boolean flagquestion) throws Exception {
		logger.info("Method : takeTestPharmacologyAndNurseLogic30 :::::::: Starts ");
		boolean flag = false;
		try {

			//waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			switchToAssessmentFrameHandler();
			// Getting Total Question Number
			String maxQtnTextNo = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.question.number.loc")).get(1).getText();

			// Convert String to Integer
			int maxCount = Integer.parseInt(maxQtnTextNo);

			// Getting Current Question Number
			String minQtnTextNo = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.question.number.loc")).get(0).getText();

			// Convert String to Integer
			int minCount = Integer.parseInt(minQtnTextNo);

			// Maximum Question minus Minimum Questions
			int count = maxCount - minCount;

			for (int i = 0; i <= count; i++) {

				List<WebElement> checkBoxElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.generic.tutorial.checkbox.new.multiple.answer.loc"));
				List<WebElement> radioElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.generic.tutorial.radio.button.new.multiple.answer.radio.loc"));

				if (checkBoxElement != null) {
					checkBoxElement.get(0).click();
					checkBoxElement.get(1).click();
				}

				if (CollectionUtils.isNotEmpty(radioElement) && radioElement.size() > 0) {
					List<WebElement> radioClickElement =baseHandler.findElements(".question-option.focus-element-flag>label");
					if(CollectionUtils.isNotEmpty(radioClickElement)) {
						radioClickElement.get(0).click();
					}
				}

				if (i == count) {
					//switchToAssessmentFrameHandler();
					List<WebElement> buttonElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
					if(CollectionUtils.isNotEmpty(buttonElement)) {
						if(buttonElement.get(0).isDisplayed()) {
							WebElement continueButtonElement = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
							if(continueButtonElement != null) {
								continueButtonElement.sendKeys(Keys.ENTER);
								waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								if(!continueButtonElement.isEnabled()) {
									clickButton(PropertiesRepository.getString("new-atitesting.myati.assessment.question.unanswered.close.loc"), 0);
									clickAssessmemtType();
								}
							}
						}
					}
					boolean resultFlag = takeAssessmentVerifySectionNew(rationaleFlag, flagquestion,"Finalize and View Results");
					logger.info("Verification of final popup -->" + resultFlag);
					if(resultFlag) {
						flag = true;
					}
				} else {
					if (i == 0 && flagquestion) {
						switchToAssessmentFrameHandler();
						verifyFlag(true);
						logger.info("Question has been flaged");
						Thread.sleep(4000);
					} else {
						//waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						//switchToAssessmentFrameHandler();
						waitUntillElementIsVisible(PropertiesRepository
								.getString("new-atitesting.generic.tutorial.submit.new.loc"));
						List<WebElement> buttonElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
						if(CollectionUtils.isNotEmpty(buttonElement)) {
							if(buttonElement.get(0).isDisplayed()) {
								WebElement continueButtonElement = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
								if(continueButtonElement != null) {
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									if(verifyQuestionUnAsweredPopup()) {
										List<WebElement> assessmentCompleteElement = baseHandler.findElements(".modal-section button");
										if(CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
											assessmentCompleteElement.get(0).click();
										}
										//clickButton(PropertiesRepository.getString("new-atitesting.myati.assessment.question.unanswered.close.loc"), 0);
										clickAssessmemtType();
									}
								}
							}
						}
					}
					if (rationaleFlag) {
						//waitUntillLoadingImageIsDisappeared("new-atitesting.pleasewait.bufferLoc");
						List<WebElement> rationalContinue = driver.findElements(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
						if(CollectionUtils.isNotEmpty(rationalContinue)) {
							rationalContinue.get(0).sendKeys(Keys.ENTER);
							waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						}
					}

					//switchToAssessmentFrameHandler();

					if (bool) {
						switchToAssessmentFrameHandler();
						waitUntillElementIsVisible(PropertiesRepository
								.getString("new-atitesting.generic.tutorial.continue.loc"));
						Thread.sleep(1000);
						List<WebElement> buttonElement = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.test.assessment.continue.button.loc"));
						if(CollectionUtils.isNotEmpty(buttonElement)) {
							if(buttonElement.get(0).isDisplayed()) {
								WebElement continueButtonElement = driver.findElement(By.cssSelector("footer[class='product-screen-footer'] #moveNext"));
								if(continueButtonElement != null) {
									continueButtonElement.sendKeys(Keys.ENTER);
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
									if(verifyQuestionUnAsweredPopup()) {
										List<WebElement> assessmentCompleteElement = baseHandler.findElements(".modal-section button");
										if(CollectionUtils.isNotEmpty(assessmentCompleteElement)) {
											assessmentCompleteElement.get(0).click();
										}
										//clickButton(PropertiesRepository.getString("new-atitesting.myati.assessment.question.unanswered.close.loc"), 0);
										clickAssessmemtType();
									}
								}
							}
						}

					}
					if (breakFlag) {
						windowHandler.switchToLatestWindow();
						flag = true;
						break;
					}
				}
			}
		} catch (DriverException e) {
			logger.info("unable to take practice assessment for takeTestPharmacologyAndNurseLogic30" + e);
		}
		waitUntillBufferInvisible(PropertiesRepository
				.getString("new-atitesting.pleasewait.bufferLoc"));
		logger.info("Method : takeTestPharmacologyAndNurseLogic30 :::::::: END flag--> "+ flag);
		return flag;
	}
	
	
	/**
	 * Method is used to click on Close Button in Assessment with confirmation popup.
	 *  
	 * @author saravanan.jothimani				
	 * @throws Exception
	 */
	public boolean clickAssessmentCloseButton() throws Exception {
		logger.info("Method: clickAssessmentCloseButton Starts");
		boolean flag = false;
		try {
			driver.switchTo().frame("assessmentFrame");
			List<WebElement> element = baseHandler.findElements("button[class='mat-button']");
			if(CollectionUtils.isNotEmpty(element)) {
				element.get(0).click();
				waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				// Confirmation Yes/ no popup, clicking on yes. 
				List<WebElement> yesElement = baseHandler.findElements("mat-dialog-container section div button[class='button secondary-button focus-element-flag ng-star-inserted']");
				if(CollectionUtils.isNotEmpty(yesElement)) {
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", yesElement.get(0));
					//yesElement.get(0).click();
					flag = true;
					windowHandler.switchToLatestWindow();
					waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
				}
			} else {
				logger.info("Unable to find locator for Assessment close button");
			}
		} catch (Exception e) {
			windowHandler.switchToLatestWindow();
			logger.info("Unable to clickAssessmentCloseButton");
			throw new DriverException("Unable to clickAssessmentCloseButton",
					e);
		}
		logger.info("Method: clickAssessmentCloseButton End flag --> "+ flag);
		return flag;
	}

	/**
	 * Method used to get Module results from IPP Page.
	 * 
	 * @author devika.rs
	 * @param Tutorials
	 * @return
	 * @throws Exception
	 */
	public boolean clickNCLEXModuleReuslt(String Tutorials) throws Exception {
		logger.info("Method: clickNCLEXModuleReuslt Start");
		boolean flag = false;
		try {
			List<WebElement> moduleList = baseHandler
					.findElements("table:nth-child(2) > tbody:nth-child(2) > tr > td:nth-child(1) > a");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					if (moduleList.get(i).getText().equals(Tutorials)) {
						moduleList.get(i).click();
						flag = true;
						break;
					}
				}
			}
		} catch (Exception e) {
			logger.info("Could not get score in clickNCLEXModuleReuslt");
			throw new Exception("Could not get score in clickNCLEXModuleReuslt");
		}
		logger.info("Method: clickNCLEXModuleReuslt End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to verify all module list which are displayed in card back. 
	 * 
	 * @author saravanan.jothimani
	 * @param moduleNames
	 * @return
	 * @throws Exception
	 */
	public boolean verifyModuleListInLearnTab(List<String> moduleNames) throws Exception {
		logger.info("Method : verifyModuleListInLearnTab Start");
		boolean flag = false;
		List<String> nameList = new ArrayList<String>();
		try {
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("new-atitesting.tutorial.cardback.module.name.loc"));
			if(CollectionUtils.isNotEmpty(element)) {
				for(WebElement nameElement : element) {
					nameList.add(nameElement.getText());
				}
			}
			Collections.sort(moduleNames);
			Collections.sort(nameList);
			System.out.println("moduleNames --> " + moduleNames);
			System.out.println("nameList --> " + nameList);
			if (CollectionUtils.isNotEmpty(moduleNames) && CollectionUtils.isNotEmpty(nameList)) {
				if (nameList.equals(moduleNames)) {
					flag = true;
				}
			}
		}catch (Exception e) {
    		logger.info("Unable to verifyModuleListInLearnTab" );
			log(logger, "Unable to verifyModuleListInLearnTab" );
    		throw new DriverException("Unable to verifyModuleListInLearnTab " , e); 
    	}
		logger.info("Method: verifyModuleListInLearnTabEnd flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to verify assessment name under test tab.
	 * 
	 * @author saravanan.jothimani
	 * @param assessmentName
	 * @return
	 * @throws Exception
	 */
	public boolean verifyAssessmentNameByName(String assessmentName) throws Exception {
		logger.info("Method: verifyAssessmentNameByName Start ");
		boolean flag = false;
		try {
			List<WebElement> moduleList = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.all.modules.loc.quiz.new"));
			if (moduleList != null && moduleList.size() > 0) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					WebElement element = moduleList.get(i).findElement(By.cssSelector(PropertiesRepository
							.getString("new-atitesting.tutorial.cardback.module.name.description.loc")));
					if (assessmentName.equalsIgnoreCase(element.getText())) {
						flag = true;
						break;
					}
				}
			} else {
				logger.info("Unable to find element in Test Tab");
			}
		} catch (Exception e) {
			logger.info("Unable to verifyAssessmentNameByName");
			log(logger, "Unable to verifyAssessmentNameByName");
			throw new DriverException("Unable to verifyAssessmentNameByName", e);
		}
		logger.info("Method: verifyAssessmentNameByName End flag --> " + flag);
		return flag;
	}

	public void clickModuleButtonByName(String assessmentName) throws Exception {
		logger.info("Method: clickModuleButtonByName Start ");
		try {
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			List<WebElement> moduleList = baseHandler
					.findElements(PropertiesRepository.getString("new-atitesting.all.modules.loc.quiz.new"));
			if (moduleList != null && moduleList.size() > 0) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					WebElement element = moduleList.get(i).findElement(By.cssSelector(PropertiesRepository
							.getString("new-atitesting.tutorial.cardback.module.name.description.loc")));
					if (assessmentName.equalsIgnoreCase(element.getText())) {
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
								moduleList.get(i).findElement(By.cssSelector(
										PropertiesRepository.getString("new-atitesting.tutorial.cardback.module.loc"))));
						moduleList.get(i)
								.findElement(By.cssSelector(
										PropertiesRepository.getString("new-atitesting.tutorial.cardback.module.loc")))
								.click();
						waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
						break;
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to clickModuleButtonByName");
			log(logger, "Unable to clickModuleButtonByName");
			throw new Exception("Unable to clickModuleButtonByName");
		}

		logger.info("Method: clickModuleButtonByName End");
	}
	
	/**
	 * Method used to select instance based on instance name. 
	 * 
	 * @author saravanan.jothimani
	 * @param instanceName
	 * @return
	 * @throws Exception
	 */
	public boolean clickSelectInstance(String instanceName) throws Exception {
		logger.info("Method : clickSelectInstance Start");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(
					"div[id='selectInstanceContainerLearnTab'] ul[class='product-list-style duplicate-list'] li");
			if (CollectionUtils.isNotEmpty(element)) {
				for (WebElement instanceWebElement : element) {
					// Getting instance name from Select Instance.
					WebElement instanceElement = instanceWebElement
							.findElement(By.cssSelector("div[class='duplicate-info-modules']"));
					if (instanceElement != null && instanceName.equalsIgnoreCase(instanceElement.getText().trim())) {
						// Clicking on Modules button.
						WebElement moduleElement = instanceWebElement
								.findElement(By.cssSelector("div[class='duplicate-action-modules'] a"));
						if (moduleElement != null) {
							String styleValue = moduleElement.getAttribute("style");
							if (!styleValue.equalsIgnoreCase("display: none;")) {
								moduleElement.click();
								flag = true;
								break;
							}
						}
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to clickSelectInstance");
			log(logger, "Unable to clickSelectInstance");
			throw new DriverException("Unable to clickSelectInstance", e);
		}
		logger.info("Method: clickSelectInstanceEnd flag --> " + flag);
		return flag;
	}
	
	
	/***
	 * @author Devika.RS
	 * @param Tutorials
	 * @return
	 * @throws Exception
	 */
	public boolean clickSTTPreAssessmentReuslt(String Tutorials) throws Exception {
		logger.info("Method: clickSTTPreAssessmentReuslt Start");
		boolean flag = false;
		try {
			List<WebElement> moduleList = baseHandler
					.findElements("section.multi-tables:nth-child(9) > div:nth-child(2) > table:nth-child(2) > tbody:nth-child(2) > tr:nth-child(2) > td:nth-child(1) > a:nth-child(1)");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					if (moduleList.get(i).getText().equals(Tutorials)) {
						moduleList.get(i).click();
						flag = true;
						break;
					}
				}
			}
		} catch (Exception e) {
			logger.info("Could not get score in clickSTTPreAssessmentReuslt");
			throw new Exception("Could not get score in clickSTTPreAssessmentReuslt");
		}
		logger.info("Method: clickSTTPreAssessmentReuslt End flag --> " + flag);
		return flag;
	}
	
	/***
	 * @author Devika.RS
	 * @param Tutorials
	 * @return
	 * @throws Exception
	 */
	public boolean clickSTTPostAssessmentReuslt(String Tutorials) throws Exception {
		logger.info("Method: clickSTTPostAssessmentReuslt Start");
		boolean flag = false;
		try {
			List<WebElement> moduleList = baseHandler
					.findElements("table.custom-table:nth-child(36) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(1) > a:nth-child(1)");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					if (moduleList.get(i).getText().equals(Tutorials)) {
						moduleList.get(i).click();
						flag = true;
						break;
					}
				}
			}
		} catch (Exception e) {
			logger.info("Could not get score in clickSTTPostAssessmentReuslt");
			throw new Exception("Could not get score in clickSTTPostAssessmentReuslt");
		}
		logger.info("Method: clickSTTPostAssessmentReuslt End flag --> " + flag);
		return flag;
	}
}


























