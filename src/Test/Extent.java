package Test;

import org.junit.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Extent {
//ExtentHtmlReporter htmlReporter;
   // ExtentReports extent;
    //helps to generate the logs in test report.
    //ExtentTest test;
    
    //@Parameters({ "Windows", "Chrome" })
	/*
	 * @Before public void startReport() { // initialize the HtmlReporter
	 * htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")
	 * +"/test-output/testReport.html");
	 * 
	 * //initialize ExtentReports and attach the HtmlReporter extent = new
	 * ExtentReports(); extent.attachReporter(htmlReporter);
	 * 
	 * //To add system or environment info by using the setSystemInfo method.
	 * extent.setSystemInfo("OS", "Windows"); extent.setSystemInfo("Browser",
	 * "Chrome");
	 * 
	 * //configuration items to change the look and feel //add content, manage tests
	 * etc htmlReporter.config().setChartVisibilityOnOpen(true);
	 * htmlReporter.config().setDocumentTitle("Extent Report Demo");
	 * htmlReporter.config().setReportName("Test Report");
	 * htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
	 * htmlReporter.config().setTheme(Theme.STANDARD); htmlReporter.config().
	 * setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'"); }
	 */
  @Test
  public void Test() {
	  
	  ExtentTest test;
	  ExtentReports extent;
	  ExtentHtmlReporter htmlReporter;
      //initialize ExtentReports and attach the HtmlReporter
	   htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/testReport.html");
      
      //initialize ExtentReports and attach the HtmlReporter
	  extent = new ExtentReports();
      extent.attachReporter(htmlReporter);
       
      //To add system or environment info by using the setSystemInfo method.
      extent.setSystemInfo("OS", "Windows");
      extent.setSystemInfo("Browser", "Chrome");
      
      //configuration items to change the look and feel
      //add content, manage tests etc
      htmlReporter.config().setChartVisibilityOnOpen(true);
      htmlReporter.config().setDocumentTitle("Extent Report Demo");
      htmlReporter.config().setReportName("Test Report");
      htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
      htmlReporter.config().setTheme(Theme.STANDARD);
      htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	  for(int i=1; i<=20; i++)
	  {
		  if(i%2==0) {
			  ExtentTest logger=extent.createTest("Test case "+i);
			  logger.log(Status.PASS, "Test case PASSED");
			  extent.flush();
		  }
			else  if(i%7==0)  {
			  ExtentTest logger2=extent.createTest("Test case "+i);
			  logger2.log(Status.FAIL, "Test case FAILED");
			  extent.flush();
		  }
			else { 
				 ExtentTest logger3=extent.createTest("Test case "+i);
			  logger3.log(Status.SKIP, "Test case SKIPED"); extent.flush(); 
			  }
			 
			
	  }
  }
}
