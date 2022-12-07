package basetest;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import drivers.Driver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.*;
import reports.ExtentReport;
import utils.AppiumManager;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;

public class BaseTest {

    // Access modifier reihenfolge private, protected, default, public

   // private Map<String,String> map = new HashMap<>();

    @BeforeSuite
    protected void setUpReport() throws IOException, InterruptedException {
       //AppiumManager.startAppi();
        ExtentReport.initExtentReport();
    }
    @AfterSuite
    protected void quitReport(){
        ExtentReport.quitExtendReport();
        //AppiumManager.stopServer();

    }
    @BeforeMethod
    protected void testInfoBeforeTest(ITestResult iTestResult){
        Driver.getDriver();

    }
    @AfterMethod
    protected void testInfoAfterTest(ITestResult iTestResult, Method m) throws MalformedURLException {
        if(iTestResult.getStatus() == ITestResult.STARTED){
            String name = iTestResult.getName();
            ExtentReport.getExtentTestStart("The " + name+ " got started");
        }
        if(iTestResult.getStatus() == ITestResult.FAILURE){
          String name = iTestResult.getName();
            ExtentReport.getExtentTestFail("Could not find the element so the test with name " + name + " failed");
        }
        if(iTestResult.getStatus() == ITestResult.SKIP){
            String name = iTestResult.getName();
            ExtentReport.getExtentTestSkip("The " + name+ " was skipped");
        }
        if(iTestResult.getStatus() == ITestResult.SUCCESS){
            String name = iTestResult.getName();
            ExtentReport.getExtentTestPass("The " + name+ " passed");
        }
        Driver.quitDriver();
    }

   @BeforeTest
    protected void setUp() throws MalformedURLException {
    }
   @AfterTest
    protected void tearDown() throws MalformedURLException {
   }
    protected void takeScreenShot(ExtentTest test) throws MalformedURLException {

        var screenshot =((TakesScreenshot)  Driver.getDriver()).getScreenshotAs(OutputType.BASE64);
        test.pass(MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build());
    }
}
