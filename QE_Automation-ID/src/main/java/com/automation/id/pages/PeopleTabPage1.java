package com.automation.id.pages;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.ascendlearning.automation.ui.exceptions.DriverException;
import com.ascendlearning.automation.ui.handlers.ButtonHandler;
import com.ascendlearning.automation.ui.handlers.TextHandler;

public class PeopleTabPage1 extends IDBasePage {
	private ButtonHandler buttonHandler;
	private Logger logger = LogManager.getLogger(this.getClass());
	public PeopleTabPage1(WebDriver webDriver) {
		super(webDriver);
		textHandler = new TextHandler(driver);
		buttonHandler = new ButtonHandler(driver);
	}

	
	public void enterURL(String url) throws Exception {
		logger.info("Method : enterURL :::::::: START");
		driver.get(url);
		waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
		logger.info("Method : enterURL :::::::: END");
	}


	public boolean isElementSelected(String loc,int index) {
		logger.info("Method : isElementSelected :::::::: Start");
		List<WebElement> findElement = baseHandler.findElements(loc);
		if(CollectionUtils.isNotEmpty(findElement))
		{
			String attribute = findElement.get(index).getAttribute(PropertiesRepository.getString("id.common.aria.selected.loc"));
			if(attribute.equals("true"))
			return true;
		}
		logger.info("Method : isElementSelected :::::::: END");
		return false;
	}
	
	public boolean verifyPeopleTabByDefaultValue() throws DriverException, InterruptedException {
		logger.info("Method : verifyPeopleTabByDefaultValue :::::::: START");
		boolean flag = false;
		try {
			
			List<WebElement> Headers = driver.findElements(By.cssSelector(PropertiesRepository.getString("id.homepage.people.report.groups.tab.loc")));
			String tab1=Headers.get(0).getText();
			if (StringUtils.isNotEmpty(tab1)&& PropertiesRepository.getString("id.people.page.menu.header.value").equals(tab1.trim())) {
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to verifyPeopleTabByDefaultValue");
			throw new DriverException("Unable to verifyPeopleTabByDefaultValue", e);
		}
		logger.info("Method : verifyPeopleTabByDefaultValue :::::::: START");
		return flag;
	}

	/**
	 * Method used to search text and verify whether it is displayed in grid. 
	 * 
	 * @author saravanan.jothimani
	 * @param lastname
	 * @return
	 * @throws DriverException
	 * @throws InterruptedException
	 */
	public boolean searchAndVerifyByLastName(String lastname) throws DriverException, InterruptedException {
		logger.info("Method : searchAndVerifyByLastName :::::::: START");
		boolean flag = false;
		try {
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			/*
			 * WebElement LastNameSearchElement =
			 * verifyElement(PropertiesRepository.getString(
			 * "id.people.studentRoaster.search.loc"));
			 * textHandler.writeText(LastNameSearchElement, Lastname);
			 */
			WebElement lastNameElement = verifyElement(
					PropertiesRepository.getString("id.people.studentRoster.search.loc"));
			if (lastNameElement != null) {
				lastNameElement.sendKeys(lastname);
				lastNameElement.sendKeys(Keys.ENTER);
				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			}
			/*driver.findElement(By.cssSelector("#search")).sendKeys(lastname);
			driver.findElement(By.cssSelector("#search")).sendKeys(Keys.ENTER);
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));*/
			// verify result
			List<WebElement> resultgrid = baseHandler
					.findElements(PropertiesRepository.getString("id.people.student.roster.search.table.loc"));
			if (CollectionUtils.isNotEmpty(resultgrid)) {
				String Studentname = resultgrid.get(0).getText();
				if (StringUtils.isNotEmpty(Studentname) && Studentname.contains(lastname)) {
					flag = true;
				}
			}
		} catch (Exception e) {
			logger.info("Unable to search by last name");
			throw new DriverException("Unable to search by last name", e);
		}
		logger.info("Method : searchAndVerifyByLastName :::::::: End");
		return flag;

	}
	
	/**
	 * Method used to enter cohort in student roster page. 
	 * 
	 * @param Cohortname
	 * @return
	 * @throws DriverException
	 * @throws InterruptedException
	 */
	public boolean searchandVerifyStudentByCohort(String Cohortname) throws DriverException, InterruptedException {
		logger.info("Method : searchandVerifyStudentByCohort :::::::: START");
		boolean flag = false;
		try {
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			WebElement cohortDDValue1 = verifyElement("span.ati-heading:nth-child(3)");
			if (cohortDDValue1 != null) {
				cohortDDValue1.click();
				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				// Enter Cohort Name
				WebElement cohortNameTxtElement = driver.findElement(By.cssSelector(PropertiesRepository.getString("id.people.student.by.cohort.name.loc")));
				if (cohortNameTxtElement != null) {
					textHandler.writeText(PropertiesRepository.getString("id.people.student.by.cohort.name.text.box.loc"),
							Cohortname);
					cohortNameTxtElement.sendKeys(Keys.ENTER);
					waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
					
					// Clicking on Select DD 
					WebElement cohortDDValue = verifyElement(PropertiesRepository.getString("id.people.reassign.popup.cohort.select.dd.loc"));
					if (cohortDDValue != null) {
						cohortDDValue.click();
						waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
					}
					// Clicking on Save button. 
					List<WebElement> ele = baseHandler.findElements(
							PropertiesRepository.getString("id.people.studentroster.save.cohort.button.loc"));
					if (CollectionUtils.isNotEmpty(ele)) {
						ele.get(0).click();
					}
					waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

					// Verify result
					List<WebElement> resultcohert = driver.findElements(By.cssSelector(PropertiesRepository.getString("people.roster.studentlist")));
					for (int i = 0; i < resultcohert.size(); i++) {
						String StudentDetails = resultcohert.get(i).getText();
						if (StringUtils.isNotEmpty(StudentDetails) && StudentDetails.contains(Cohortname)) {
							flag = true;
						} else {
							flag = false;
						}
						if (!flag) {
							logger.info("Given cohort name is not displayed in table");
							break;
						}
					}
				}
			}
		} catch (Exception e) {

			logger.info("Unable to searchandVerifyStudentByCohort");
			throw new DriverException("Unable to searchandVerifyStudentByCohort", e);
		}
		logger.info("Method : searchandVerifyStudentByCohort :::::::: START flag --> " + flag);
		return flag;
	}
	
	
	public void clikOnStudentCheckBox(String Studentname) throws DriverException {
		logger.info("clikOnStudentCheckBox ::: START");
		boolean flag=false;
		try {
			while(flag==false){
			List<WebElement> resultcohert = driver.findElements(By.cssSelector(PropertiesRepository.getString("people.roster.studentlist")));
			for (int i = 0; i< resultcohert.size(); i++) {
			String StudentDetails=resultcohert.get(i).getText();
			if (StringUtils.isNotEmpty(StudentDetails)&& StudentDetails.contains(Studentname)) {
				resultcohert.get(i).findElement(By.cssSelector(PropertiesRepository.getString("id.people.student.check.box.loc"))).click();
				flag=true;
				System.out.println("abcccccc");
			}
			}
			
			driver.findElement(By.cssSelector(PropertiesRepository.getString("id.people.student.check.box.container.loc"))).click();
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			}
		} catch (Exception e) {
			logger.info("Not able to find student from list");
			throw new DriverException("Not able to find student from list");
		}
		
		logger.info("clikOnStudentCheckBox ::: ENDS");
	}
	
	/**
	 * This method will select one student check box and then it will click on Reassign button
	 * @return
	 * @throws DriverException
	 * @author Syed.Hoque
	 */
	
	public boolean selectStudentCheckBox(int index) throws DriverException{
		logger.info("selectStudentCheckBox ::: START");
		boolean flag = false;
		try{
			//select check box for one student
			List<WebElement> checkBoxElement=baseHandler.findElements(PropertiesRepository.getString("people.tab.ckeck.box"));
			if(CollectionUtils.isNotEmpty(checkBoxElement) & checkBoxElement.size()>0){
				logger.info("Check box is clicked");
				checkBoxElement.get(index).click();
				
				// Clicking on Reassign button. 
				List<WebElement> reAssignBtn=baseHandler.findElements(PropertiesRepository.getString("id.people.studentroster.save.cohort.button.loc"));
				if(CollectionUtils.isNotEmpty(reAssignBtn)){
					reAssignBtn.get(0).click();
					waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
					flag = true;
				}
			}
		}catch(Exception e){
			logger.info("Not able to find student from list");
			throw new DriverException("Not able to find student from list");	
		}
		logger.info("selectStudentCheckBox ::: ENDS flag --> " + flag);
		return flag;
	}
	
	
	
	
	
	public boolean verifyReassignVerifyPopup(String textpopup) throws DriverException {
		logger.info("verifyReassignVerifyPopup ::: START");
		boolean flag = false;
		try {
			List<WebElement> popupElement = baseHandler.findElements(PropertiesRepository.getString("reassigning.popup.headr"));
			if (CollectionUtils.isNotEmpty(popupElement)) {
				String text = popupElement.get(0).getText();
				if (StringUtils.isNotBlank(text) && textpopup.equalsIgnoreCase(text)) {
					flag = true;
				}
			} else {
				logger.info("Unable to verify popup message");
			}
		} catch (Exception e) {
			logger.info("Not able to verify reassign popup");
			throw new DriverException("Not able to verify reassign popup");
		}
		logger.info("verifyReassignVerifyPopup ::: END flag --> " + flag);
		return flag;
	}
	
	public boolean enterClassToReassignWithContent(String cohortInputName) throws DriverException {
		logger.info(" enterClassToReassignWithContent Start");
		boolean flag = false;
		try {
			// Verifying Reassign Cohort Popup.
			WebElement popupHeaderElement = verifyElement(
					PropertiesRepository.getString("id.people.reassign.popup.title.loc"));
			if (popupHeaderElement != null && PropertiesRepository.getString("id.people.reassign.popup.title.value")
					.equalsIgnoreCase(popupHeaderElement.getText())) {
				// Entering cohort value.
				WebElement cohortElement = verifyElement(
						PropertiesRepository.getString("id.people.reassign.popup.cohort.text.box.loc"));
				if (cohortElement != null) {
					cohortElement.clear();
					cohortElement.sendKeys(cohortInputName);
				} else {
					logger.info("Unable to enter cohort in Reassign cohort popup");
				}
				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));

				WebElement cohortDDValue = verifyElement(
						PropertiesRepository.getString("id.people.reassign.popup.cohort.select.dd.loc"));
				if (cohortDDValue != null) {
					cohortDDValue.click();
					// waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				}

				// Clicking on Confirm button.
				buttonHandler
						.clickButton(PropertiesRepository.getString("id.people.reassign.popup.confirm.button.loc"));

				// Getting second popup value.
				WebElement secondPopupElement = verifyElement(
						PropertiesRepository.getString("id.people.are.you.sure.title.loc"));
				if (secondPopupElement != null && PropertiesRepository.getString("id.people.are.you.sure.title.value")
						.equalsIgnoreCase(secondPopupElement.getText())) {
					// Getting Are you sure? first content and verify.
					boolean boolAreYouSureFirstContent = verifyMessage("id.people.are.you.sure.popup.first.content.loc",
							0, PropertiesRepository.getString("id.people.are.you.sure.popup.first.content.value"));

					// Getting Are you sure? Cohort Name.
					boolean cohortName = verifyMessage("id.people.are.you.sure.popup.selected.cohort.name.loc", 0,
							cohortInputName);

					// Getting Remember message value.
					boolean rememberContent = verifyMessage("id.people.are.you.sure.popup.remember.content.loc", 0,
							PropertiesRepository.getString("id.people.are.you.sure.popup.remember.content.value"));

					// Verifying Are you Sure content.
					if (boolAreYouSureFirstContent && cohortName && rememberContent) {

						// Clicking on Are you Sure Confirm button.
						buttonHandler.clickButton(
								PropertiesRepository.getString("id.people.are.you.sure.confirm.button.loc"));

						// Clicking on Continue button in In Progress Popup.
						WebElement inProgressPopup = verifyElement(
								PropertiesRepository.getString("id.people.in.progress.popup.title.loc"));
						if (inProgressPopup != null
								&& PropertiesRepository.getString("id.people.in.progress.popup.title.value")
										.equalsIgnoreCase(inProgressPopup.getText())) {

							// In Progress popup first content.
							boolean boolFirstContent = verifyMessage(
									"id.people.are.you.sure.popup.first.content.loc", 0,
									PropertiesRepository.getString("id.people.in.progress.first.content.value"));

							// In Progress Getting Cohort name.
							boolean inProgressCohortName = verifyMessage(
									"id.people.are.you.sure.popup.selected.cohort.name.loc",
									0, cohortInputName);

							// In Progress Second content.
							boolean boolSecondContent = verifyTextContains(
									PropertiesRepository.getString("id.people.are.you.sure.popup.first.content.loc"),
									PropertiesRepository.getString("id.people.in.progress.second.content.value"), 1);

							// In Progresss Third content.
							boolean boolThirdContent = verifyTextContains(
									PropertiesRepository.getString("id.people.are.you.sure.popup.first.content.loc"),
									PropertiesRepository.getString("id.people.in.progress.third.content.value"), 2);

							// Verifying In Progress Content.
							if (boolFirstContent && inProgressCohortName && boolSecondContent && boolThirdContent) {
								buttonHandler.clickButton(PropertiesRepository
										.getString("id.people.in.progress.popup.continue.button.loc"));
								flag = true;
							} else {
								logger.info("Unable to verify content in In Progress Popup");
							}
						} else {
							logger.info("Unable to click  Continue button in In Progress Popup");
						}
					} else {
						logger.info("Unable to verify Are you sure? popup content. ");

					}

				} else {
					logger.info("Unable to click Confirm button in Are you sure popup");
				}
			} else {
				logger.info("Popup header is not displayed");
			}
			/*
			 * windowHandler.switchToLatestWindow(); baseHandler.
			 * findElement(".cdk-overlay-container .mat-input-infix.mat-form-field-infix").
			 * sendKeys(classreassign);
			 * 
			 * baseHandler.findElement(PropertiesRepository.getString(
			 * "reassign.drop.down.ele")).click(); //click on confirm btn List<WebElement>
			 * ele=baseHandler.findElements(PropertiesRepository.getString(
			 * "id.people.studentroster.save.cohort.button.loc"));
			 * if(CollectionUtils.isNotEmpty(ele)){ ele.get(3).click(); } List<WebElement>
			 * confirm=baseHandler.findElements(PropertiesRepository.getString(
			 * "id.people.studentroster.save.cohort.button.loc"));
			 * if(CollectionUtils.isNotEmpty(confirm)){ confirm.get(3).click(); }
			 * 
			 * List<WebElement>
			 * continuebtn=baseHandler.findElements(PropertiesRepository.getString(
			 * "id.reassign.popup.cancel.button.loc"));
			 * if(CollectionUtils.isNotEmpty(continuebtn)){ continuebtn.get(0).click();
			 * waitForAwhile(4000); }
			 */

		} catch (Exception e) {
			logger.info("Unable assign to enterClassToReassignWithContent");
			throw new DriverException("Unable assign to enterClassToReassignWithContent", e);
		}
		logger.info("enterClassToReassignWithContent End flag --> " + flag);
		return flag;
	}
	
	public boolean enterClassToReassign(String classreassign) throws DriverException{
		logger.info(" enterClassToReassign Start");
		boolean flag = false;
		try{
			// Verifying Reassign Cohort Popup. 
			WebElement popupHeaderElement = verifyElement(PropertiesRepository.getString("id.people.reassign.popup.title.loc"));
			if(popupHeaderElement != null && PropertiesRepository.getString("id.people.reassign.popup.title.value").equalsIgnoreCase(popupHeaderElement.getText())) {
				// Entering cohort value. 
				WebElement cohortElement = verifyElement(PropertiesRepository.getString("id.people.reassign.popup.cohort.text.box.loc"));
				if(cohortElement != null ) {
					cohortElement.clear();
					cohortElement
					.sendKeys(classreassign);
				} else {
					logger.info("Unable to enter cohort in Reassign cohort popup");
				}
				waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				
				WebElement cohortDDValue = verifyElement(PropertiesRepository.getString("id.people.reassign.popup.cohort.select.dd.loc"));
				if (cohortDDValue != null) {
					cohortDDValue.click();
					//waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
				}
				
				// Clicking on Confirm button. 
				buttonHandler.clickButton(PropertiesRepository.getString("id.people.reassign.popup.confirm.button.loc"));
				
				// Getting second popup value. 
				WebElement secondPopupElement = verifyElement(PropertiesRepository.getString("id.people.are.you.sure.title.loc"));
				if(secondPopupElement != null && PropertiesRepository.getString("id.people.are.you.sure.title.value").equalsIgnoreCase(secondPopupElement.getText())) {
					// Clicking on Are you Sure Confirm button. 
					buttonHandler.clickButton(PropertiesRepository.getString("id.people.are.you.sure.confirm.button.loc"));
					// Clicking on Continue button in In Progress Popup. 
					WebElement inProgressPopup = verifyElement(PropertiesRepository.getString("id.people.in.progress.popup.title.loc"));
					if(inProgressPopup != null && PropertiesRepository.getString("id.people.in.progress.popup.title.value").equalsIgnoreCase(inProgressPopup.getText())) {
						buttonHandler.clickButton(PropertiesRepository.getString("id.people.in.progress.popup.continue.button.loc"));
						flag = true;
					} else {
						logger.info("Unable to click  Continue button in In Progress Popup");
					}
				} else {
					logger.info("Unable to click Confirm button in Are you sure popup");
				}
			} else {
				logger.info("Popup header is not displayed");
			}
			/*windowHandler.switchToLatestWindow();
			baseHandler.findElement(".cdk-overlay-container .mat-input-infix.mat-form-field-infix").sendKeys(classreassign);
			
			baseHandler.findElement(PropertiesRepository.getString("reassign.drop.down.ele")).click();
			//click on confirm btn
			List<WebElement> ele=baseHandler.findElements(PropertiesRepository.getString("id.people.studentroster.save.cohort.button.loc"));
			if(CollectionUtils.isNotEmpty(ele)){
				ele.get(3).click();
			}
			List<WebElement> confirm=baseHandler.findElements(PropertiesRepository.getString("id.people.studentroster.save.cohort.button.loc"));
			if(CollectionUtils.isNotEmpty(confirm)){
				confirm.get(3).click();
			}
			
			List<WebElement> continuebtn=baseHandler.findElements(PropertiesRepository.getString("id.reassign.popup.cancel.button.loc"));
			if(CollectionUtils.isNotEmpty(continuebtn)){
				continuebtn.get(0).click();
				waitForAwhile(4000);
			}*/
			
		}catch(Exception e){
			logger.info("Unable assign to enterClassToReassign");
			throw new DriverException("Unable assign to enterClassToReassign", e);	
		}
		logger.info("enterClassToReassign End flag --> "+ flag);
		return flag;
	}
	
	
	public void ReassignToCohort(String Cohortname) throws DriverException, InterruptedException {
		try {
			logger.info("Method: ReassignToCohort Starts");
			// Enter Cohort Name
			
			WebElement entercohort= verifyElement(PropertiesRepository.getString("id.Reassign.popup.Entercohort.loc"));
			Actions actions = new Actions(driver);
			actions.moveToElement(entercohort);
			actions.click();
			actions.sendKeys(Cohortname);
			actions.build().perform();
			
			entercohort.sendKeys(Cohortname);
			waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
			WebElement cohortDDValue = verifyElement(".mat-option-ripple.mat-ripple");
					if (cohortDDValue != null) {
						waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
						cohortDDValue.click();
						waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
					}
					// Clicking on confirm button
					WebElement confirmButton= verifyElement(PropertiesRepository.getString("id.reassign.popup.confirm.button.loc"));
					buttonHandler.clickButton(confirmButton);
					waitUntillLoadingImageIsDisappeared(PropertiesRepository.getString("id.common.page.loader"));
					WebElement confirmButton2= verifyElement(PropertiesRepository.getString("id.reassign.popup.confirm.button2.loc"));
					buttonHandler.clickButton(confirmButton2);
					WebElement continuebutton= verifyElement(PropertiesRepository.getString("id.reassign.popup.continue.button.loc"));
					buttonHandler.clickButton(continuebutton);
		} catch (Exception e) {
			
			logger.info("Unable assign to new cohert");
			throw new DriverException("Unable assign to new cohert", e);
		}
		

 }
	public boolean clickOnReassignForInstructor(String expectedtext) throws DriverException{
		logger.info(" clickOnReassignForInstructor start");
	    boolean flag=false;
		try{
			
			List<WebElement> removeReassign=baseHandler.findElements(PropertiesRepository.getString("reassign.btn"));
				if(removeReassign.size()!=0){
				removeReassign.get(0).click();
				//verify access denied pop up
				String actual=baseHandler.findElement(PropertiesRepository.getString("accessdenied.pop.text")).getText();
				if(actual.equalsIgnoreCase(expectedtext)){
					flag=true;
			}
			
			
			}
			
		}catch(Exception e){
			logger.info("Unable to verify access deny pop-up");
			throw new DriverException("Unable to verify access deny pop-up", e);	
		}
		return flag;
	}
	/*public void selectStudentCheckBox1(int checkBoxindex) throws DriverException{
		logger.info("selectStudentCheckBox1 ::: START");
		try{
			//select check box for one student
			List<WebElement> ele=baseHandler.findElements(PropertiesRepository.getString("people.tab.ckeck.box"));
			if(CollectionUtils.isNotEmpty(ele) & ele.size()>0){
				ele.get(checkBoxindex).click();
				waitForAwhile(1000);
			}
			
			
		}catch(Exception e){
			
			logger.info("Not able to find student from list");
			throw new DriverException("Not able to find student from list");	
		}
		logger.info("selectStudentCheckBox1 ::: ENDS");
	}
	/**
	 * @author Kumarisagarika.T
	 * @param Cohortname
	 * @throws DriverException
	 * @throws InterruptedException
	 */
	public boolean selectStudentCheckBox1ForInstructor(int checkBoxindex) throws DriverException{
		logger.info("selectStudentCheckBox1ForInstructor ::: START");
		String expect=PropertiesRepository.getString("number.of.student.text");
		String expect1=PropertiesRepository.getString("reassign.btn.txt");
		String expect2=PropertiesRepository.getString("remove.btn.txt");
		String expect3=PropertiesRepository.getString("export.btn.txt");
		boolean flag=false;
		try{
			
			//select check box for one student
			List<WebElement> ele=baseHandler.findElements(PropertiesRepository.getString("people.tab.ckeck.box"));
			if(CollectionUtils.isNotEmpty(ele) & ele.size()>0){
				ele.get(checkBoxindex).click();
				waitForAwhile(1000);
			//started here make another method
				String exp=baseHandler.findElement(PropertiesRepository.getString("selected.student.number")).getText();
				List<WebElement> lst=baseHandler.findElements(PropertiesRepository.getString("reassign.btn"));
				if(exp.equalsIgnoreCase(expect) && lst.get(0).getText().equalsIgnoreCase(expect1) && lst.get(1).getText().equalsIgnoreCase(expect2) && baseHandler.findElement(PropertiesRepository.getString("export.btn")).getText().equalsIgnoreCase(expect3))
				{
					if(lst.get(0).isDisplayed() && lst.get(1).isDisplayed() && baseHandler.findElement(PropertiesRepository.getString("export.btn")).isDisplayed()){
					flag=true;
			      logger.info("verified Remove,Reassign,export button allong with number of students selected text");}
					
				}
			}
			
			
		}catch(Exception e){
			
			logger.info("Not able to find student from list & not able to verify the elements");
			throw new DriverException("Not able to find student from list & not able to verify the elements");	
		}
		logger.info("selectStudentCheckBox1ForInstructor ::: ENDS");
		return flag;
		
	}
	/**
	 * @author Kumarisagarika.T
	 * @param Cohortname
	 * @throws DriverException
	 * @throws InterruptedException
	 */
	public boolean verifyStudentRosterPage(String name, String email, String cohort) throws DriverException{
		  logger.info("verifyStudentRosterPage ::: START");
		  boolean flag=false;
		  try{
		   
		 List<WebElement> lst1=baseHandler.findElements(PropertiesRepository.getString("collapse.icon"));
		 List<WebElement> lst2=baseHandler.findElements(PropertiesRepository.getString("column.header.name"));
		 List<WebElement> lst3=baseHandler.findElements(PropertiesRepository.getString("rows.per.page.dropdown"));
		 List<WebElement> lst4=baseHandler.findElements(PropertiesRepository.getString("cdn.dropdown"));
		 List<WebElement> lst5=baseHandler.findElements(PropertiesRepository.getString("search.by.lastname"));
		 List<WebElement> paginationNumber=baseHandler.findElements(PropertiesRepository.getString("pagination.number"));
		 List<WebElement> paginationCarats=baseHandler.findElements(PropertiesRepository.getString("pagination.carat"));
		 
		 if(CollectionUtils.isNotEmpty(lst1) && CollectionUtils.isNotEmpty(lst2) && CollectionUtils.isNotEmpty(lst3) && CollectionUtils.isNotEmpty(lst4) && CollectionUtils.isNotEmpty(lst5)){
			 if(lst1.get(0).isDisplayed() && lst3.get(0).isDisplayed() && lst4.get(0).isDisplayed() && lst5.get(0).isDisplayed()){
				 if(lst2.get(0).getText().equalsIgnoreCase(name) && lst2.get(1).getText().equalsIgnoreCase(email) && lst2.get(2).getText().equalsIgnoreCase(cohort)){
					if((CollectionUtils.isNotEmpty(paginationNumber) && paginationNumber.get(0).isDisplayed()) || (CollectionUtils.isNotEmpty(paginationCarats) && paginationCarats.get(0).isDisplayed())){
					 flag=true; 
				 }}
			 }
		 }logger.info("Verified StudentRoster Page UI content");
		   }catch(Exception e){
		   logger.info("Unable to verifyStudentRosterPage");
		   log(logger, "Unable to verifyStudentRosterPage");
		   throw new DriverException("Unable to verifyStudentRosterPage", e);  
		  }
		  logger.info("verifyStudentRosterPage ::: END");
		return flag;
		 }
	/**
	 * @author Kumarisagarika.T
	 * @param Cohortname
	 * @throws DriverException
	 * @throws InterruptedException
	 */
	public boolean checkStatusOfTransaction() throws DriverException
	{
		logger.info(" checkStatusOfTransaction start");
	    boolean flag=false;
		try{
			
			List<WebElement> removeReassignStatus=baseHandler.findElements(PropertiesRepository.getString("reassign.remove.status"));
				if(removeReassignStatus.size()!=0){
					String actualStatus=removeReassignStatus.get(0).getText();
				 
				if(actualStatus.equalsIgnoreCase("Complete")||actualStatus.equalsIgnoreCase("Failed")|| actualStatus.equalsIgnoreCase("Complete With Error")){
					flag=true;
					logger.info("Transaction status"+" "+actualStatus);
			}}
			
		}catch(Exception e){
			logger.info("Unable to remove/reassign the student");
			throw new DriverException("Unable to remove/reassign the student", e);	
		}
		return flag;
	}
	/**
	 * @author Kumarisagarika.T
	 * @param Cohortname
	 * @throws DriverException
	 * @throws InterruptedException
	 */
	public boolean selectStudentCheckBox1(int checkBoxindex) throws DriverException{
		logger.info("selectStudentCheckBox1 ::: START");
		String expect=PropertiesRepository.getString("number.of.student.text");
		String expect1=PropertiesRepository.getString("reassign.btn.txt");
		String expect2=PropertiesRepository.getString("remove.btn.txt");
		String expect3=PropertiesRepository.getString("export.btn.txt");
		boolean flag=false;
		try{
			
			//select check box for one student
			List<WebElement> ele=baseHandler.findElements(PropertiesRepository.getString("people.tab.ckeck.box"));
			if(CollectionUtils.isNotEmpty(ele) & ele.size()>0){
				ele.get(checkBoxindex).click();
				waitForAwhile(1000);
			//started here make another method
				String exp=baseHandler.findElement(PropertiesRepository.getString("selected.student.number")).getText();
				List<WebElement> lst=baseHandler.findElements(PropertiesRepository.getString("remove.btn1"));
				if(exp.equalsIgnoreCase(expect) && lst.get(0).getText().equalsIgnoreCase(expect1) && lst.get(1).getText().equalsIgnoreCase(expect2) && baseHandler.findElement(PropertiesRepository.getString("export.btn")).getText().equalsIgnoreCase(expect3))
				{
					if(lst.get(0).isDisplayed() && lst.get(1).isDisplayed() && baseHandler.findElement(PropertiesRepository.getString("export.btn")).isDisplayed()){
					flag=true;
			      logger.info("verified Remove,Reassign,export button allong with number of students selected text");}
					
				}
			}
			
			
		}catch(Exception e){
			
			logger.info("Not able to find student from list & not able to verify the elements");
			throw new DriverException("Not able to find student from list & not able to verify the elements");	
		}
		logger.info("selectStudentCheckBox1 ::: ENDS");
		return flag;
		
	}
	/**
	 * @author Kumarisagarika.T
	 * @param Cohortname
	 * @throws DriverException
	 * @throws InterruptedException
	 */
	public boolean clikOnremoveandverifyPopup(String expected1, String expected2) throws DriverException
	{
		logger.info(" clikOnremoveandverifyPopup start");
	    boolean flag=false;
		try{
			
			List<WebElement> remove=baseHandler.findElements(PropertiesRepository.getString("remove.btn"));
			if(CollectionUtils.isNotEmpty(remove)){
			remove.get(1).click();
			//verify remove pop up
			String actual1=baseHandler.findElement(PropertiesRepository.getString("remove.popup.header")).getText();
			if(actual1.equalsIgnoreCase(expected1)){
				List<WebElement> popupBody=baseHandler.findElements(PropertiesRepository.getString("removePopup.body"));
				if(CollectionUtils.isNotEmpty(popupBody)){
					String actual2=popupBody.get(0).getText();
					if(actual2.equalsIgnoreCase(expected2)){
						logger.info("verified remove pop-up");
						flag=true;
				}}}}
			
		}catch(Exception e){
			logger.info("Unable to verify the remove popup");
			throw new DriverException("Unable to verify remove popup", e);	
		}
		return flag;
	}
	/**
	 * @author Kumarisagarika.T
	 * @param Cohortname
	 * @throws DriverException
	 * @throws InterruptedException
	 */
	
	public boolean clickOnConfirmVerifyPopup(String header) throws DriverException{
		boolean flag=false;
		try{
			
			List<WebElement> btn= baseHandler.findElements(PropertiesRepository.getString("btn.confirm.for.remove"));
			if(btn.size()!=0){
				btn.get(3).click();
				String inProgress = baseHandler.findElement(PropertiesRepository.getString("inprogress.popup.header.for.remove")).getText();
				if(inProgress.equalsIgnoreCase(header)){
					flag=true;
					logger.info("verified inprogress popup");
					baseHandler.findElement(PropertiesRepository.getString("inprogress.continue.btn")).click();
				}
			}
			
		}catch(Exception e){
			logger.info("Unable to verify inprogress popup");
			throw new DriverException("Unable to verify inprogress popup", e);
		}
		return flag;
	}
	/**
	 * @author Kumarisagarika.T
	 * @param Cohortname
	 * @throws DriverException
	 * @throws InterruptedException
	 */
	public void clickOnElement(String loc,int index) throws DriverException{
		  logger.info("clickOnElement ::: START");
		  try{
		   
		   List<WebElement> ele=baseHandler.findElements(loc);
		   if(CollectionUtils.isNotEmpty(ele) && ele.size()>0){
		    ele.get(index).click();
		    Thread.sleep(2000);
		   }
		   
		  }catch(Exception e){
		   logger.info("Unable to clickOnElement ");
		   log(logger, "Unable to clickOnElement");
		   throw new DriverException("Unable to clickOnElement", e);  
		  }
		  logger.info("clickOnElement ::: END");
		 }
	/**
	 * @author Kumarisagarika.T
	 * @param Cohortname
	 * @throws DriverException
	 * @throws InterruptedException
	 */
	public boolean clickOnReassignAndCancel(String classreassign) throws DriverException{
		  logger.info("clickOnReassignAndCancel ::: START");
		  boolean flag=false;
		  try{
		   
		  List<WebElement> lst= baseHandler.findElements(PropertiesRepository.getString("remove.btn"));
		   lst.get(0).click();
		   
		   baseHandler.waitToBeDisplayed(baseHandler.findElement(PropertiesRepository.getString("cancel.btn.rosterpage")));
		   baseHandler.findElement(PropertiesRepository.getString("reassigning.cohort.text.field")).sendKeys(classreassign);
	       Thread.sleep(3000);
	       baseHandler.findElement(PropertiesRepository.getString("reassign.drop.down.ele")).click();
	       Thread.sleep(3000);
		   baseHandler.findElement(PropertiesRepository.getString("cancel.btn.rosterpage")).click();
		   //Thread.sleep(3000);
		   baseHandler.waitToBeDisplayed(baseHandler.findElement(PropertiesRepository.getString("selected.student.number")));
		   List<WebElement> ele= baseHandler.findElements(PropertiesRepository.getString("reassign.cohort.popup"));
		   if(CollectionUtils.isEmpty(ele)){
			   flag=true;
		   }
		   }catch(Exception e){
		   logger.info("Unable to verify clickOnReassignAndCancel ");
		   log(logger, "Unable to verify clickOnReassignAndCancel");
		   throw new DriverException("Unable to verify clickOnReassignAndCancel", e);  
		  }
		 
		   logger.info("Method: clickOnReassignAndCancel End " + flag);
			return flag;
		 }

	/**
	 * @author Kumarisagarika.T
	 * @param Cohortname
	 * @throws DriverException
	 * @throws InterruptedException
	 */
	public boolean clickOnRemoveAndCancel() throws DriverException {
		logger.info("clickOnReassignAndCancel ::: START");
		boolean flag = false;
		try {

			List<WebElement> lst = baseHandler.findElements(PropertiesRepository.getString("remove.btn"));
			lst.get(1).click();
			baseHandler.waitToBeDisplayed(
					baseHandler.findElement(PropertiesRepository.getString("cancel.btn.rosterpage")));
			baseHandler.findElement(PropertiesRepository.getString("cancel.btn.rosterpage")).click();
			baseHandler.waitToBeDisplayed(
					baseHandler.findElement(PropertiesRepository.getString("selected.student.number")));
			List<WebElement> ele = baseHandler.findElements(PropertiesRepository.getString("reassign.cohort.popup"));
			if (CollectionUtils.isEmpty(ele)) {
				flag = true;
			}
		} catch (Exception e) {
			logger.info("Unable to verify clickOnRemoveAndCancel ");
			log(logger, "Unable to verify clickOnRemoveAndCancel");
			throw new DriverException("Unable to verify clickOnRemoveAndCancel", e);
		}
		logger.info("clickOnRemoveAndCancel ::: END");
		return flag;
	}
	
	/**
	 * 
	 * @param cohortName
	 * @param index
	 * @return
	 * @throws Exception
	 */
	public boolean verifyCohortInTransferHistory(String cohortName, int index) throws Exception {
		logger.info("Method : Start");
		boolean flag = false;
		try {
			// Get the list of row in Transfer History.
			List<WebElement> element = baseHandler.findElements(PropertiesRepository.getString("id.people.transfer.history.table.row.loc"));
			if(CollectionUtils.isNotEmpty(element)) {
				// Get div details based on index. 
				List<WebElement> divIndexElement = element.get(index).findElements(By.cssSelector("div"));
				if(CollectionUtils.isNotEmpty(divIndexElement)) {
					
					// Getting first div and getting all label. 					
					List<WebElement> labelIndexElement1 = divIndexElement.get(0).findElements(By.cssSelector("label"));
					if(CollectionUtils.isNotEmpty(labelIndexElement1)) {
						if(labelIndexElement1.stream().filter(wE->wE.getText().trim().contains(cohortName)).count()>0){
							flag = true;
						}
					} else {
						logger.info("Unable to get values. ");
					}
					
					List<WebElement> labelIndexElement2 = divIndexElement.get(3).findElements(By.cssSelector("label"));
					if(CollectionUtils.isNotEmpty(labelIndexElement2)) {
						if(labelIndexElement1.stream().filter(wE->wE.getText().trim().contains("Complete")).count()>0){
							flag = true;
						}
					} else {
						logger.info("Unable to get values. ");
					}
					
				} else {
					logger.info("Unable to get rows");
				}
			} else {
				logger.info("Unable to find elements");
			}
		}catch (Exception e) {
    		logger.info("Unable to verifyCohortInTransferHistory" );
			log(logger, "Unable to verifyCohortInTransferHistory" );
    		throw new DriverException("Unable to verifyCohortInTransferHistory" , e); 
    	}
		logger.info("Method: verifyCohortInTransferHistory End flag --> " + flag);
		return flag;
	}
}
