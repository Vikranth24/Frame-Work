package GENERIC_LIBERARY;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class Extends_Report {
	static ExtentReports extent;

public static ExtentReports reports()
{
	String path=System.getProperty("user.dir")+"\\Extent_Reports\\"+"name.html";
	ExtentSparkReporter rep=new ExtentSparkReporter(path);
	rep.config().setReportName("Resutl");
	rep.config().setDocumentTitle("Automation test");
	extent =new ExtentReports();
	extent.attachReporter(rep);
	extent.setSystemInfo("Tester","Vikranth");
	return extent;
	
}

}
