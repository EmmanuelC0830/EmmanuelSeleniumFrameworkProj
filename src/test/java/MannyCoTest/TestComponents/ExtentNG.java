package MannyCoTest.TestComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentNG {
	
	public static ExtentReports getExtent()
	{
		String path = System.getProperty("user.dir") + "//reports//extent.html";
		ExtentSparkReporter ext = new ExtentSparkReporter(path);
		ext.config().setReportName("Automatiom Test");
		ext.config().setDocumentTitle("Ex Tests");
		
		ExtentReports xtent = new ExtentReports();
		xtent.attachReporter(ext);
		xtent.setSystemInfo("Tester", "MannyC");
		return xtent;
	}

}
