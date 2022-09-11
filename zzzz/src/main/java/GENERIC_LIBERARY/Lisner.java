package GENERIC_LIBERARY;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;



@SuppressWarnings("unused")
public class Lisner extends Screenshot  implements ITestListener{
	
	
	Logger log =LogManager.getLogger();
	
	Extends_Report r=new Extends_Report();
	
	ExtentReports extent=Extends_Report.reports();
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	ExtentTest test;
	 public void onTestFailure(ITestResult result) {
		 test.fail(result.getThrowable());
		  
		log.trace("TESTCASE GOT FAILED SO THE CONTROL REACHED LISNERS onTestFailure METHOD");
		 String res= result.getMethod().getMethodName();
		// extentTest.get().addScreenCaptureFromPath(res, res)
		screen( res) ; 	
	 } 
	    

	public void onTestStart(ITestResult result) {
		String s=result.getMethod().getMethodName();
		 test=extent.createTest(s);
		extentTest.set(test);	
	}

	
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test passed");
		log.info(result.getName()+ "is Passed");
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getName()+ "is Skipped");
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println(result.getName()+ "is Failed due to Timeout");
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		extent.flush();	
	}		 
}
