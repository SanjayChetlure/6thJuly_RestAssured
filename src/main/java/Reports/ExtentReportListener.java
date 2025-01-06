package Reports;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportListener implements ITestListener 
{
        public ExtentSparkReporter sparkReporter;   //UI of Report  (Look & Feel)
        public ExtentReports extent;	//populate info to the report  eq:- ProjectName, ModuleName, tester name, browser name, OS
        public ExtentTest test;                //creating test case entries in reports & update status of test method

    public void onStart(ITestContext context)        //it creates report template at the start of execution
    {
        sparkReporter = new ExtentSparkReporter("src/main/java/Reports/AutomationExecutionReport.html");      
        sparkReporter.config().setDocumentTitle("Automation Report");  //title of the report
        sparkReporter.config().setReportName("Test Report");
        sparkReporter.config().setTheme(Theme.STANDARD);
        
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        
        extent.setSystemInfo("Envirnment", "QA");
        extent.setSystemInfo("Browser Name", "Chrome");
    }

    public void onTestSuccess(ITestResult result) 
    {
    	test = extent.createTest(result.getMethod().getMethodName());     //creating In Entry InTReport
        test.log(Status.PASS, "Test case is Passed: "+result.getName());    //update status
    }

    public void onTestFailure(ITestResult result)
    {
    	test = extent.createTest(result.getMethod().getMethodName());     //creating In Entry InTReport
        test.log(Status.FAIL, "Test case is Failed: "+result.getName());    //update status
        test.log(Status.FAIL, "Test case is Failed cause: "+result.getThrowable());  //get failure msg
    }

    public void onTestSkipped(ITestResult result)
    {
    	test = extent.createTest(result.getMethod().getMethodName());     //creating In Entry InTReport
        test.log(Status.SKIP, "Test case is Skipped: "+result.getName()); 
    }

    public void onFinish(ITestContext context) {
        if (extent != null) {
            extent.flush();
        }
    }
}
