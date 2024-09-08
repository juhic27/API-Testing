//Name: Juhi Chaudhary
//Date: 26/08/2024

package Utility;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class reportgenerator {
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static int i = 1;
	public void startReport()
	{
		extent = new ExtentReports ("C:\\wipro java program\\APITesting_Project3\\src\\test\\resources\\Report\\reports.html", true);
		//TestHTMLReporter.config().setTheme(Theme.DARK);
		System.out.println("Report statrted");
    }

	public void startTest()
	{
		logger = extent.startTest("test" + i);
		i++;
		logger.log(LogStatus.PASS, "Test is pass");	
	//	logger.log(LogStatus.FAIL, "Test is Fail");

		System.out.println("Test started");
	}
	
	public void endTest()
	{
		extent.endTest(logger);
		System.out.println("Test ended");
	}

	public void endReport() 
	{
		extent.flush();
		extent.close();
		System.out.println("End of report");
		
	}
	
}	

