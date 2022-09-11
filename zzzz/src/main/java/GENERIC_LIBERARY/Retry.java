package GENERIC_LIBERARY;

import org.testng.ITestResult;

public class Retry {
	int count=0;
	int retryCount=2;

	public boolean retry(ITestResult result) {
		if(retryCount>=count) {
			count++;
			return true;
		}
		return false;
	}
}
