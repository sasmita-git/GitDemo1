package com.automation.newati.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.ascendlearning.automation.ui.handlers.BaseHandler;
import com.ascendlearning.automation.ui.handlers.WindowHandler;

public class MyResultsTabPage extends NewATIBasePage {

	private Logger logger = LogManager.getLogger(this.getClass());
	public BaseHandler baseHandler;
	private WindowHandler windowHandler;

	public MyResultsTabPage(WebDriver webDriver) {
		super(webDriver);
		baseHandler = new BaseHandler(driver);
		windowHandler = new WindowHandler(driver);
	}

	public boolean verifyAndClickProctorAssessmentName(String assessmentName, boolean click) throws Exception {
		// logger.info("verifyAndClickProctorAssessmentName Start");
		boolean flag = false;
		try {

			List<WebElement> element = baseHandler.findElements(".multi-tables");
			if (CollectionUtils.isNotEmpty(element)) {
				// Verify it has Proctor Section.
				WebElement proctorMainElement = element.get(0);
				// Getting custom-tables tbody and tr
				List<WebElement> proctorTRElement = proctorMainElement
						.findElements(By.cssSelector(".custom-table tbody tr"));
				if (CollectionUtils.isNotEmpty(proctorTRElement)) {
					int size = proctorTRElement.size();
					for (int index = 0; index < size; index++) {
						List<WebElement> individualTRElement = proctorTRElement.get(index)
								.findElements(By.cssSelector("td a[aria-label='Proctor Assessment Name']"));
						if (CollectionUtils.isNotEmpty(individualTRElement) && individualTRElement.size() > 0) {
							String proctorAssessmentName = individualTRElement.get(0).getText();
							if (StringUtils.isNotEmpty(proctorAssessmentName)
									&& proctorAssessmentName.equalsIgnoreCase(assessmentName)) {
								if (click) {
									individualTRElement.get(0).click();
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								}
								flag = true;
								break;
							}
						}
					}
				}
			}

		} catch (Exception e) {
			logger.info("Unable to click Proctor Assessment result section");
			log(logger, "Unable to click Proctor Assessment result section");
			throw new DriverException("Unable to click Proctor Assessment result section", e);
		}
		logger.info("verifyAndClickProctorAssessmentName End flag --> " + flag);
		return flag;
	}

	public boolean verifyITRIPPPageDetails() throws Exception {
		logger.info("Method: verifyITRIPPPageDetails Starts");
		boolean flag = false;
		try {
			waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
			List<WebElement> element = baseHandler.findElements(".table-data");
			if (CollectionUtils.isNotEmpty(element)) {
				WebElement majorContentAreasElement = element.get(0);
				if (majorContentAreasElement != null) {
					String headerName = majorContentAreasElement.findElement(By.cssSelector("header h3")).getText();
					if (StringUtils.isNotBlank(headerName)
							&& headerName.equalsIgnoreCase("Individual Performance in the Major Content Areas")) {
						// Verifying Major content area sub headings
						List<WebElement> majorContentSubHeadings = majorContentAreasElement.findElements(By.cssSelector(
								"section[class='proctored-data-section'] .row-data-area .row-data .row-data-item.item-grow-reg-proc div"));
						if (CollectionUtils.isNotEmpty(majorContentSubHeadings)) {
							String image = majorContentSubHeadings.get(1).getText();
							String single = majorContentSubHeadings.get(3).getText();
							String ordered = majorContentSubHeadings.get(5).getText();
							// Verifying sub header names
							if (StringUtils.isNotBlank(image) && StringUtils.isNotBlank(single)
									&& StringUtils.isNotBlank(ordered)) {
								if (image.equalsIgnoreCase("Image, Audio, and Video")
										&& single.equalsIgnoreCase("Single and Multiple Select")
										&& ordered.equalsIgnoreCase("FITB and Ordered Response")) {
									flag = true;
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verifyITRIPPPageDetails");
			log(logger, "Unable to verifyITRIPPPageDetails");
			throw new DriverException("Unable to verifyITRIPPPageDetails", e);
		}
		logger.info("Method: verifyITRIPPPageDetails End flag --> " + flag);
		return flag;
	}

	public boolean verifyTEASIPPPageDetails() throws Exception {
		logger.info("Method: verifyTEASIPPPageDetails Starts");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler.findElements(".table-data");
			if (CollectionUtils.isNotEmpty(element)) {
				WebElement majorContentAreasElement = element.get(0);
				if (majorContentAreasElement != null) {
					String headerName = majorContentAreasElement.findElement(By.cssSelector("header h3")).getText();
					if (StringUtils.isNotBlank(headerName)
							&& headerName.equalsIgnoreCase("Individual Performance in the Major Content Areas")) {
						// Verifying Major content area sub headings
						List<WebElement> majorContentSubHeadings = majorContentAreasElement.findElements(By.cssSelector(
								"section[class='proctored-data-section'] .row-data-area .row-data .row-data-item.item-grow-reg-proc div"));
						if (CollectionUtils.isNotEmpty(majorContentSubHeadings)) {
							String reading = majorContentSubHeadings.get(1).getText();
							System.out.println(reading);
							String maths = majorContentSubHeadings.get(3).getText();
							System.out.println(maths);
							String science = majorContentSubHeadings.get(5).getText();
							System.out.println(science);
							String english = majorContentSubHeadings.get(7).getText();
							System.out.println(english);

							// Verifying sub header names
							if (StringUtils.isNotBlank(reading) && StringUtils.isNotBlank(maths)
									&& StringUtils.isNotBlank(science) && StringUtils.isNotBlank(english)) {
								if (reading.equalsIgnoreCase("TEAS V Reading")
										&& maths.equalsIgnoreCase("TEAS V Mathematics")
										&& science.equalsIgnoreCase("TEAS V Science")
										&& english.equalsIgnoreCase("TEAS V English and Language Usage")) {
									flag = true;
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verifyTEASIPPPageDetails");
			log(logger, "Unable to verifyTEASIPPPageDetails");
			throw new DriverException("Unable to verifyTEASIPPPageDetails", e);
		}
		logger.info("Method: verifyTEASIPPPageDetails End flag --> " + flag);
		return flag;
	}

	/**
	 * Method is used to get the Simulation Name and its individual score.
	 * 
	 * 
	 * @author syed.pasha
	 * @throws DriverException
	 */
	public String[] getSimulationNameAndScore() throws Exception {
		logger.info("Method: getSimulationNameAndScore Start");
		String[] arraySimulationNameAndScore = new String[2];
		try {

			List<WebElement> moduleList = baseHandler.findElements("section[class='multi-tables']");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					if (moduleList.get(i)
							.findElements(By.cssSelector("header span[aria-label='Simulation Activity Name']"))
							.size() != 0) {
						WebElement element = moduleList.get(i)
								.findElement(By.cssSelector("header span[aria-label='Simulation Activity Name']"));
						List<WebElement> moduleListNext = moduleList.get(i)
								.findElements(By.cssSelector("div table tbody tr td"));
						if (moduleListNext.get(3).getText().equals("Needs Improvement")
								|| moduleListNext.get(3).getText().equals("Satisfactory")
								|| moduleListNext.get(3).getText().equals("Strong")) {
							arraySimulationNameAndScore[0] = element.getText();
							arraySimulationNameAndScore[1] = moduleListNext.get(3).getText();
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			logger.info("Could not get score");
			throw new Exception("Could not get score%");
		}
		logger.info("Method: getSimulationNameAndScore End --> ");
		return arraySimulationNameAndScore;
	}

	/**
	 * Method is used to get Last Date Accessed for given Name. and Click on Live
	 * Review Link
	 * 
	 *
	 * @throws DriverException
	 */
	public String getLastDateAccessed(String name, String clickOnName) throws Exception {
		logger.info("Method: getLastDateAccessed Start");
		String lastDateAccesses = "";
		try {

			List<WebElement> moduleList = baseHandler.findElements("section[class='multi-tables']");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					if ((moduleList.get(i).findElements(By.cssSelector("header span")).size() != 0)) {
						if (moduleList.get(i).findElement(By.cssSelector("header span")).getText().equals(name)) {
							List<WebElement> moduleListNext = moduleList.get(i)
									.findElements(By.cssSelector("div table tbody tr td"));
							lastDateAccesses = moduleListNext.get(1).getText();
							// Click on the Live review Link
							for (int j = 0; j < moduleListNext.size(); j++) {
								if (moduleListNext.get(j).getText().equals(clickOnName)) {
									moduleListNext.get(j).findElement(By.cssSelector("a")).click();
									break;
								}
							}
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			logger.info("Could not LastDateAccessed");
			throw new Exception("Could not get LastDateAccessed%");
		}
		logger.info("Method: getLastDateAccessed End --> ");
		return lastDateAccesses;
	}

	/**
	 * To verify if result all the product section displayed
	 * 
	 * @author Syed.pasha
	 * @return True if result all the product section displayed
	 * @throws Exception
	 */
	public boolean verifyResultSection() throws InterruptedException, DriverException {
		logger.info("Method: verifyResultSection Starts");
		boolean flag = false;
		try {
			List<Boolean> list = new ArrayList<Boolean>();
			List<WebElement> elements = baseHandler.findElements(".multi-tables");
			if (CollectionUtils.isNotEmpty(elements)) {
				List<WebElement> insideContentLocator = baseHandler
						.findElements(".table-header-subhead.focus-element-flag span");
				for (int i = 0; i < insideContentLocator.size(); i++) {

					list.add(insideContentLocator.get(i).isDisplayed());
					flag = true;
				}
			}
		} catch (Exception e) {
			log(logger, "Unable to verifyResultSection");
			throw new DriverException("Unable to verifyResultSection", e);
		}
		logger.info("Method: verifyResultSection End flag --> " + flag);
		return flag;
	}

	/**
	 * Method is used to Click on clickSimulation Module By Name.
	 * 
	 * 
	 * @author syed.pasha
	 * @throws DriverException
	 */
	public void clickSimulationModuleByName(String simulationModuleName) throws Exception {
		logger.info("Method: clickSimulationModuleByName Start");
		try {
			List<WebElement> moduleList = baseHandler.findElements("a[aria-label='Simulation Module Name']");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					if (moduleList.get(i).getText().equals(simulationModuleName)) {
						moduleList.get(i).click();
						break;
					}
				}
			}
		} catch (Exception e) {
			logger.info("Could not get score");
			throw new Exception("Could not get score%");
		}
		logger.info("Method: clickSimulationModuleByName End --> ");
	}

	/**
	 * Method used to click on a particular practice assessment link in the
	 * myResults page.
	 * 
	 * @change Vishal
	 * @return
	 * @throws Exception
	 */
	public boolean verifyAndClickPracticeAssessmentName(String assessmentName, boolean click) throws Exception {
		logger.info("verifyAndClickPracticeAssessmentName Start");
		boolean flag = false;
		try {

			List<WebElement> element = baseHandler.findElements(".multi-tables");
			if (CollectionUtils.isNotEmpty(element)) {
				// Verify if it has Practice Section.
				WebElement practiceMainElement = element.get(1);
				logger.info("prac element: " + element.get(1).getText());
				// Getting custom-tables tbody and tr
				List<WebElement> practiceTRElement = practiceMainElement
						.findElements(By.cssSelector(".custom-table tbody tr"));
				if (CollectionUtils.isNotEmpty(practiceTRElement)) {
					int size = practiceTRElement.size();
					// logger.info("Size: "+size);
					for (int index = 0; index < size; index++) {
						List<WebElement> individualTRElement = practiceTRElement.get(index)
								.findElements(By.cssSelector("td a[aria-label='Practice Assessment Name']"));
						if (CollectionUtils.isNotEmpty(individualTRElement) && individualTRElement.size() > 0) {
							String practiceAssessmentName = individualTRElement.get(0).getText();
							if (StringUtils.isNotEmpty(practiceAssessmentName)
									&& practiceAssessmentName.equalsIgnoreCase(assessmentName)) {
								if (click) {
									individualTRElement.get(0).click();
									waitUntillLoadingImageIsDisappeared("new-atitesting.peasewait.bufferLoc");
								}
								flag = true;
								break;
							}
						}
					}
				}
			}

		} catch (Exception e) {
			logger.info("Unable to click practice Assessment result section");
			log(logger, "Unable to click practice Assessment result section");
			throw new DriverException("Unable to click practice Assessment result section", e);
		}
		logger.info("verifyAndClickPracticeAssessmentName End flag --> " + flag);
		return flag;
	}

	public void clickSmartPrepModuleByName(String smartprepModuleName) throws Exception {
		logger.info("Method: clickSmartPrepModuleByName Start");
		try {
			List<WebElement> moduleheader = baseHandler.findElements(".table-section-subhead.focus-element-flag");
			List<WebElement> lessonbutton = baseHandler.findElements(".custom-table tbody tr td a");
			if (CollectionUtils.isNotEmpty(moduleheader)) {
				int size = moduleheader.size();
				for (int i = 0; i < size; i++) {
					if (moduleheader.get(i).getText().equals(smartprepModuleName)) {
						lessonbutton.get(i).click();
						break;
					}
				}
			}
		} catch (Exception e) {
			logger.info("not able to click lesson button");
			throw new Exception("not able to click lesson button");
		}
		logger.info("Method: clickSmartPrepModuleByName End --> ");
	}

	/*
	 * public Map<String, String> getMyResultsTableData(String assessmentName)
	 * throws Exception { logger.info("Method : Start"); boolean flag = false;
	 * Map<String, String> tableValues = new HashMap<String, String>(); try {
	 * List<WebElement> element = baseHandler.findElements(".multi-tables"); if
	 * (CollectionUtils.isNotEmpty(element)) { for(WebElement allElement : element)
	 * { String header = allElement.findElement(By.
	 * cssSelector(".table-header-subhead.focus-element-flag span"));
	 * if(StringUtils.isNotEmpty(header) && header.equalsIgnoreCase(assessmentName))
	 * {
	 * 
	 * } } } }catch (Exception e) { logger.info("Unable to " ); log(logger,
	 * "Unable to " ); throw new DriverException("Unable to " , e); }
	 * logger.info("Method: End flag --> " + flag); return flag; }
	 */

	/**
	 * 
	 * @param smartprepModuleName
	 * @return
	 * @throws Exception
	 */
	public boolean verify_smartprepIPPpage(String smartprepModuleName) throws Exception {
		logger.info("Method: verify_smartprepIPPpage Start");
		boolean flag = false;
		try {
			List<WebElement> IPPheader = baseHandler
					.findElements(".lesson-header-details > ul:nth-child(1) > li:nth-child(1) > span:nth-child(4)");
			if (IPPheader.get(0).getText().equalsIgnoreCase(smartprepModuleName)) {
				windowHandler.switchToFrame("OpenPageFrame");
				List<WebElement> Reportheader = baseHandler.findElements(".section-title");
				if (Reportheader.get(0).getText().contains(smartprepModuleName)) {
					flag = true;
				}
			}

		} catch (Exception e) {
			logger.info("not able to verify smartprep module name");
			throw new Exception("not able to verify smartprep module name");
		}
		logger.info("Method: verify_smartprepIPPpage End --> ");
		return flag;
	}

	public boolean verifySTTAssessmentInMyResultspage(String assessmentName) throws Exception {
		logger.info("verifySTTAssessmentInMyResultspage Start");
		boolean testFlag = false;
		boolean flag = false;
		try {

			List<WebElement> element = baseHandler.findElements(".multi-tables");
			if (CollectionUtils.isNotEmpty(element)) {
				for (WebElement tableElement : element) {
					List<WebElement> elmtHeader = tableElement
							.findElements(By.cssSelector(".table-header-subhead.focus-element-flag span"));
					int cnt = elmtHeader.size();
					for (int c = 0; c < cnt; c++) {
						if (CollectionUtils.isNotEmpty(elmtHeader)
								&& elmtHeader.get(c).getText().equalsIgnoreCase(assessmentName)) {
							List<WebElement> subHeaderElement = tableElement.findElements(
									By.cssSelector("span[class='table-section-subhead focus-element-flag']"));
							if (CollectionUtils.isNotEmpty(subHeaderElement)
									&& "Nurse Manager Program Pre-Assessment"
											.equalsIgnoreCase(subHeaderElement.get(0).getText().trim())
									&& "Nurse Manager Program Post-Assessment"
											.equalsIgnoreCase(subHeaderElement.get(1).getText().trim())) {
								List<WebElement> element1 = tableElement
										.findElements(By.cssSelector(".custom-table tr th"));
								if (
										element1.get(0).getText().equalsIgnoreCase("Module Activity")
										&& element1.get(1).getText().equalsIgnoreCase("Last Date Accessed")
										&& element1.get(2).getText().equalsIgnoreCase("Individual Score")
										&& element1.get(3).getText().equalsIgnoreCase("Time Spent")
										&& element1.get(4).getText().equalsIgnoreCase("CNEAwarded")
										&& element1.get(5).getText().equalsIgnoreCase("Print Certificate")
										
										&& element1.get(6).getText().equalsIgnoreCase("Module Activity")
										&& element1.get(7).getText().equalsIgnoreCase("Last Date Accessed")
										&& element1.get(8).getText().equalsIgnoreCase("Individual Score")
										&& element1.get(9).getText().equalsIgnoreCase("Time Spent")
										&& element1.get(10).getText().equalsIgnoreCase("CNEAwarded")
										&& element1.get(11).getText().equalsIgnoreCase("Print Certificate")
										) {
									List<WebElement> element2 = tableElement.findElements(By.cssSelector("table[class='custom-table']"));

									if (CollectionUtils.isNotEmpty(element2)) {
										List<WebElement> firstTableElement = element2.get(0).findElements(By.cssSelector("td"));
										List<WebElement> secondTableElement = element2.get(1).findElements(By.cssSelector("td"));
										if(CollectionUtils.isNotEmpty(firstTableElement) && CollectionUtils.isNotEmpty(secondTableElement)) {
											WebElement preAssessmentElement = firstTableElement.get(0).findElement(By.cssSelector("a"));
											WebElement postAssessmentElement = secondTableElement.get(0).findElement(By.cssSelector("a"));
											if(preAssessmentElement != null 
													&& "Pre-Assessment".equalsIgnoreCase(preAssessmentElement.getText().trim())
													&& "Post-Assessment".equalsIgnoreCase(postAssessmentElement.getText().trim())
													) {
												testFlag = true;
												break;
											}
										}
									}
								}
							} else {
								logger.info("Unable to verify sub header for STT");
							}
						}
					}
					if(testFlag) {
						flag =  true;
						break;
					}
					
				}
			}

		} catch (Exception e) {
			logger.info("Unable to verifySTTAssessmentInMyResultspage");
			log(logger, "Unable to verifySTTAssessmentInMyResultspage");
			throw new DriverException("Unable to verifySTTAssessmentInMyResultspage", e);
		}
		logger.info("verifySTTAssessmentInMyResultspage End flag --> " + flag);
		return flag;
	}

	public void clickQuizModuleReuslt(String simulationModuleName) throws Exception {
		logger.info("Method: clickQuizModuleReuslt Start");
		try {
			List<WebElement> moduleList = baseHandler.findElements(
					"section.multi-tables:nth-child(20) > div:nth-child(2) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(1) > a:nth-child(1)");
			if (CollectionUtils.isNotEmpty(moduleList)) {
				int size = moduleList.size();
				for (int i = 0; i < size; i++) {
					if (moduleList.get(i).getText().equals(simulationModuleName)) {
						moduleList.get(i).click();
						break;
					}
				}
			}
		} catch (Exception e) {
			logger.info("Could not get score");
			throw new Exception("Could not get score%");
		}
		logger.info("Method: clickQuizModuleReuslt End --> ");
	}

	/**
	 * Method used to verify LS Header and its section header and value .
	 * 
	 * @author saravanan.jothimani
	 * @param lsName
	 * @param quizNameClick
	 * @return
	 * @throws Exception
	 */
	public boolean verifyLSResultsSection(String lsName, boolean quizNameClick) throws Exception {
		logger.info("Method : verifyLSResultsSection Start");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("new.atitestig.my.results.section.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				for (WebElement rowElement : element) {
					// Getting LS Name
					List<WebElement> nameElement = rowElement.findElements(By.cssSelector(
							PropertiesRepository.getString("new.atitestig.my.results.section.header.loc")));
					if (CollectionUtils.isNotEmpty(nameElement)
							&& nameElement.get(0).getText().trim().equalsIgnoreCase(lsName)) {
						List<WebElement> tbodyElement = rowElement.findElements(By.cssSelector(
								PropertiesRepository.getString("new.atitestig.my.results.section.table.header.loc")));
						if (CollectionUtils.isNotEmpty(tbodyElement)) {
							List<WebElement> thElement = tbodyElement.get(0).findElements(By.cssSelector("th"));
							List<WebElement> trElement = tbodyElement.get(1).findElements(By.cssSelector("tr"));
							List<WebElement> tdElement = trElement.get(0).findElements(By.cssSelector("td"));
							// Getting Date Completed header and value.
							if (thElement.get(1).getText().trim()
									.equalsIgnoreCase(PropertiesRepository
											.getString("new.atitestig.my.results.section.table.header.date.completed"))
									&& tdElement.get(1).findElement(By.cssSelector("span")).isDisplayed()) {
								// Getting Individual Score header and value.
								if (thElement.get(2).getText().trim()
										.equalsIgnoreCase(PropertiesRepository
												.getString("new.atitestig.my.results.section.table.header.individual.score"))
										&& tdElement.get(2).findElement(By.cssSelector("span")).isDisplayed()) {
									// Getting Time Spent header and value.
									if (thElement.get(3).getText().trim()
											.equalsIgnoreCase(PropertiesRepository.getString(
													"new.atitestig.my.results.section.table.header.time.spent"))
											&& tdElement.get(3).findElement(By.cssSelector("span")).isDisplayed()) {
										// Getting Quiz Name header and value.
										if (thElement.get(0).getText().trim()
												.equalsIgnoreCase(PropertiesRepository.getString(
														"new.atitestig.my.results.section.table.header.quiz.name"))
												&& tdElement.get(0).findElement(By.cssSelector("a")).isDisplayed()) {
											if (quizNameClick) {
												tdElement.get(0).findElement(By.cssSelector("a")).click();
												waitUntillLoadingImageIsDisappeared(
														"new-atitesting.peasewait.bufferLoc");
												flag = true;
												break;
											}
										} else {
											logger.info("Unable to verify Quiz Name Header and row");
										}
									} else {
										logger.info("Unable to verify Time Spent Header and row");
									}
								} else {
									logger.info("Unable to verify Individual Score Header and row");
								}
							} else {
								logger.info("Unable to verify Date Completed Header and row");
							}
						} else {
							logger.info("Table is not displayed ");
						}

					} else {
						logger.info("Unable to verify LS Name");
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verifyLSResultsSection");
			log(logger, "Unable to verifyLSResultsSection");
			throw new DriverException("Unable to verifyLSResultsSection", e);
		}
		logger.info("Method: verifyLSResultsSection End flag --> " + flag);
		return flag;
	}
	
	/**
	 * Method used to verify Quiz Header and its section header and value .
	 * 
	 * @author saravanan.jothimani
	 * @param lsName
	 * @param quizNameClick
	 * @return
	 * @throws Exception
	 */
	public boolean verifyQuizResultsSection(String lsName, boolean quizNameClick) throws Exception {
		logger.info("Method : verifyQuizResultsSection Start");
		boolean flag = false;
		try {
			List<WebElement> element = baseHandler
					.findElements(PropertiesRepository.getString("new.atitestig.my.results.section.loc"));
			if (CollectionUtils.isNotEmpty(element)) {
				for (WebElement rowElement : element) {
					// Getting LS Name
					List<WebElement> nameElement = rowElement.findElements(By.cssSelector(
							PropertiesRepository.getString("new.atitestig.my.results.section.header.loc")));
					if (CollectionUtils.isNotEmpty(nameElement)
							&& nameElement.get(0).getText().trim().equalsIgnoreCase(lsName)) {
						List<WebElement> tbodyElement = rowElement.findElements(By.cssSelector(
								PropertiesRepository.getString("new.atitestig.my.results.section.table.header.loc")));
						if (CollectionUtils.isNotEmpty(tbodyElement)) {
							List<WebElement> thElement = tbodyElement.get(0).findElements(By.cssSelector("th"));
							List<WebElement> trElement = tbodyElement.get(1).findElements(By.cssSelector("tr"));
							List<WebElement> tdElement = trElement.get(0).findElements(By.cssSelector("td"));
							// Getting Date Completed header and value.
							if (thElement.get(1).getText().trim()
									.equalsIgnoreCase(PropertiesRepository
											.getString("new.atitestig.my.results.section.table.header.date.completed"))
									&& tdElement.get(1).findElement(By.cssSelector("span")).isDisplayed()) {
								// Getting Individual Score header and value.
								if (thElement.get(2).getText().trim()
										.equalsIgnoreCase(PropertiesRepository
												.getString("new.atitestig.my.results.section.table.header.individual.score"))
										&& tdElement.get(2).findElement(By.cssSelector("span")).isDisplayed()) {
									// Getting Time Spent header and value.
									if (thElement.get(3).getText().trim()
											.equalsIgnoreCase(PropertiesRepository.getString(
													"new.atitestig.my.results.section.table.header.time.spent"))
											&& tdElement.get(3).findElement(By.cssSelector("span")).isDisplayed()) {
										// Getting Quiz Name header and value.
										if (thElement.get(0).getText().trim()
												.equalsIgnoreCase(PropertiesRepository.getString(
														"new.atitestig.my.results.section.table.header.quiz.name"))
												&& tdElement.get(0).findElement(By.cssSelector("a")).isDisplayed()) {
											if (quizNameClick) {
												tdElement.get(0).findElement(By.cssSelector("a")).click();
												waitUntillLoadingImageIsDisappeared(
														"new-atitesting.peasewait.bufferLoc");
												flag = true;
												break;
											}
										} else {
											logger.info("Unable to verify Quiz Name Header and row");
										}
									} else {
										logger.info("Unable to verify Time Spent Header and row");
									}
								} else {
									logger.info("Unable to verify Individual Score Header and row");
								}
							} else {
								logger.info("Unable to verify Date Completed Header and row");
							}
						} else {
							logger.info("Table is not displayed ");
						}

					} else {
						logger.info("Unable to verify Quiz Name");
					}
				}
			}
		} catch (Exception e) {
			logger.info("Unable to verifyQuizResultsSection");
			log(logger, "Unable to verifyQuizResultsSection");
			throw new DriverException("Unable to verifyQuizResultsSection", e);
		}
		logger.info("Method: verifyQuizResultsSection End flag --> " + flag);
		return flag;
	}

}
