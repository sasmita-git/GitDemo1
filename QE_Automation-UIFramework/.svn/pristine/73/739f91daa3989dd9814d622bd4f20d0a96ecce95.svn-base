package com.ascendlearning.automation.ui.listeners;


import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import org.testng.annotations.ITestAnnotation;

import com.ascendlearning.automation.ui.logging.LogHandler;
 
public class AnnotationTransformer extends TestListenerAdapter implements IAnnotationTransformer  {
	private Logger logger = LogHandler.getLogger(AnnotationTransformer.class);
	
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		annotation.setRetryAnalyzer(MyRetryAnalyzer.class);
	}
	
	
	@Override
    public void onTestFailure(ITestResult result) {
        if (result.getMethod().getRetryAnalyzer() != null) {
            MyRetryAnalyzer retryAnalyzer = (MyRetryAnalyzer)result.getMethod().getRetryAnalyzer();

            if(retryAnalyzer.isRetryAvailable()) {
                result.setStatus(ITestResult.FAILURE);
            } /*else {
                result.setStatus(ITestResult.FAILURE);
            }*/
			
            Reporter.setCurrentTestResult(result);
        }
    }
	
	@Override
	public void onTestSkipped(final ITestResult tr)
	{
	  if (tr.getThrowable() != null) {
	    tr.setStatus(ITestResult.FAILURE);
	  }
	  Reporter.setCurrentTestResult(tr);
	}

   @Override
   public void onFinish(ITestContext context) {
     Iterator<ITestResult> failedTestCases =context.getFailedTests().getAllResults().iterator();
    while (failedTestCases.hasNext()) {
    	logger.info("failedTestCases");
        ITestResult failedTestCase = failedTestCases.next();
        ITestNGMethod method = failedTestCase.getMethod();
        if (context.getFailedTests().getResults(method).size() > 1) {
        	logger.info("failed test case remove as dup:" + failedTestCase.getTestClass().toString());
            failedTestCases.remove();
        } else {

            if (context.getPassedTests().getResults(method).size() > 0) {
            	logger.info("failed test case remove as pass retry:" + failedTestCase.getTestClass().toString());
                failedTestCases.remove();
            }
        }
    }
   }
}