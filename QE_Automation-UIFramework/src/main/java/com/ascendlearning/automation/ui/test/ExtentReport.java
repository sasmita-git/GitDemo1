package com.ascendlearning.automation.ui.test;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.xml.XmlSuite;

import com.ascendlearning.automation.ui.config.GlobalProperties;
import com.ascendlearning.automation.ui.config.PropertiesRepository;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReport extends TestListenerAdapter implements IReporter {
	
	static WebDriver driver;
    private ExtentReports extent;
    public String fileseparator  = File.separator;
    public static String groups = (System.getProperty("groups") == null) ? "default" : System.getProperty("groups");    
    public static String env = (System.getProperty("env") == null) ? null : System.getProperty("env");
    
    static Map<String, String> testMap = new HashMap<String, String>();
    
    static Multimap<String, String> logMap = ArrayListMultimap.create();
   
    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    } 
	
	
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
    	String filepath  = "Reports"+File.separator+PropertiesRepository.getString("global.report.file.name");
    	StringBuffer suitenames = new StringBuffer();
    	Map<String, String> systeminfo = new HashMap<String, String>();
    	Capabilities capabilities = ((RemoteWebDriver) driver).getCapabilities();    
    	extent = new ExtentReports(filepath, true);
    	extent.loadConfig(new File("extent-config.xml"));
    	for (ISuite suite : suites) {
    		 suitenames.append(suite.getName()).append(" , ");
    	}  	
    	
    	if(PropertiesRepository.getString("global.browser.name").equalsIgnoreCase(GlobalProperties.ANDROID)) {
    		systeminfo.put("OS".toUpperCase(), GlobalProperties.ANDROID.toUpperCase());
    	} 
    	
    	systeminfo.put("Browser".toUpperCase(), capabilities.getBrowserName().toUpperCase());
    	systeminfo.put("Browser Version".toUpperCase(), capabilities.getVersion());
    	systeminfo.put("SUITE", groups.toUpperCase());
    	if (env != null)
    		systeminfo.put("Environment", env.toUpperCase());       
        
        extent.config().documentTitle(suitenames.toString()).reportName(groups.toUpperCase()).reportHeadline("Automation Suite".toUpperCase());
	               
	    extent.addSystemInfo(systeminfo);
       
  
        for (ISuite suite : suites) {
        	Map<String, ISuiteResult> result = suite.getResults();
  
            for (ISuiteResult r : result.values()) {
                ITestContext context = r.getTestContext();
               
                /*buildTestNodes(context.getPassedConfigurations(), LogStatus.PASS);
                buildTestNodes(context.getFailedConfigurations(), LogStatus.FAIL);
                buildTestNodes(context.getSkippedConfigurations(), LogStatus.SKIP);
                */
                buildTestNodes(context.getPassedTests(), LogStatus.PASS);
                buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
                buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
            }
        }  
        extent.flush();
        extent.close();
    }

    
	public String takesScreenshot() {
		String encodedImage = "";

		try {
			encodedImage = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return String.format(
				"<a href='data:image/png;base64,%s' target='_blank'><img src=data:image/png;base64,%s data-caption='ScreenShot'></a>",
				encodedImage, encodedImage);
	}

    public static String getStackTrace(Throwable throwable) {
		   if (throwable == null){
			   return "Exception is Null";
		   }
		   StringBuilder exception = new StringBuilder();
		   exception.append(throwable.getMessage());
		   
		   StackTraceElement[] trace = throwable.getStackTrace();
		   
		   for (int i=0; i<=10; i++){
			   exception.append(trace[i]);	  
		   }
		   return exception.toString();
	 }
       
    @Override
    public void onTestFailure(ITestResult tr) {
    	testMap.put(tr.getMethod().getDescription(), takesScreenshot());		 // Updated by Bharath on 2/24
	}
    
    @Override
    public void onConfigurationFailure(ITestResult itr) {
    	testMap.put(itr.getMethod().getDescription(), takesScreenshot()); 		// Updated by Bharath on 2/24
    }
    
    @Override
    public void onConfigurationSkip(ITestResult itr) {
    	testMap.put(itr.getMethod().getDescription(), takesScreenshot());		// Updated by Bharath on 2/24
    }

    
   private void buildTestNodes(IResultMap tests, LogStatus status) {
        ExtentTest test;
  
        if (tests.size() > 0) {
            for (ITestResult result : tests.getAllResults()) {
            	String message = "";  
            	Throwable exception =  result.getThrowable();
            	String testname = result.getMethod().getDescription();  // Updated by Bharath on 2/24
            
                test = extent.startTest(testname);
                //test.getTest().setStartedTime(startedTime);
                test.getTest().setStartedTime(getTime(result.getStartMillis()));
                test.getTest().setEndedTime(getTime(result.getEndMillis()));                
                              
                for (String log : logMap.get(testname)){
                	if (status.toString().equalsIgnoreCase("FAIL"))
                		test.log(LogStatus.INFO, log);
                	else if (status.toString().equalsIgnoreCase("SKIP"))
                		test.log(LogStatus.INFO, " ", log);
                	else
                		test.log(LogStatus.INFO, log);
                }       
                
                for (String group : result.getMethod().getGroups())
                    test.assignCategory(group);                  
  
                if (exception != null){		
                	message = "<span style='color:blue;font-weight:bold;'>REASON : </span>"+getStackTrace(exception);
                	test.log(status, "", "<span style='color:red;font-weight:bold;'>SCREENSHOT: Click on the image to enlarge:</span> <br> "+testMap.get(testname)+ "<br>" + message);
                }
				else{
					message = "<span style='color:green;font-weight:bold;'>STATUS : "+status+"</span>"; 
					test.log(status, message);
				}                
                extent.endTest(test);
            }
        }
    }

   public static void log(String method, String str) {	   
	   	logMap.put(method, str);		
	}

   public static void setDriver(WebDriver driver2) {
	   driver = driver2;	
   } 
   
   public static WebDriver getDriver() {
	   return driver;	
   } 
}

