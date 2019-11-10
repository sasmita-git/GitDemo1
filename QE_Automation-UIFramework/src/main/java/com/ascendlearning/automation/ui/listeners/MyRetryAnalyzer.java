package com.ascendlearning.automation.ui.listeners;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.ascendlearning.automation.ui.logging.LogHandler;

public class MyRetryAnalyzer implements IRetryAnalyzer {
	
	private Logger logger = LogHandler.getLogger(AnnotationTransformer.class);
	private int MAX_RETRY_COUNT = 1;

	AtomicInteger count = new AtomicInteger(MAX_RETRY_COUNT);

	public boolean isRetryAvailable() {
		return (count.intValue() > 0);
	}

	@Override
	public boolean retry(ITestResult result) {
		boolean retry = false;
		if (isRetryAvailable()) {
			logger.info("Going to retry test case: " + result.getMethod() + ", "
					+ (MAX_RETRY_COUNT - count.intValue() + 1) + " out of " + MAX_RETRY_COUNT);
			retry = true;
			count.decrementAndGet();
		}
		return retry;
	}
}