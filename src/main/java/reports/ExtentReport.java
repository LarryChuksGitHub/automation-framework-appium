package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import drivers.Driver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class ExtentReport {

    private Map<String,String> map = new HashMap<>();

    private static ExtentReports extentReports;
    private static ExtentSparkReporter spark;

    private ExtentReport(){}

    private static ExtentTest getExtentTest() {
        return createExtentReport("Android automation test report");
    }

    private static ExtentTest extentTest;


    public static void initExtentReport(){
        if(Objects.isNull(ExtentReportManager.getExtentTestThreadLocal())){
            extentReports = new ExtentReports();
            String filePath = System.getProperty("user.dir") + "/src/main/java/reports/index.html";
            spark = new ExtentSparkReporter(filePath);
            spark.config().setDocumentTitle("Test Automation Reports");
            spark.config().setReportName("Test report");
            spark.config().setTheme(Theme.DARK);
            var reporter = spark.config().getReporter();
            extentReports.attachReporter(spark);
        }
    }
    private static ExtentTest createExtentReport(String testName){
        extentTest = extentReports.createTest(testName);
        extentTest.assignAuthor("Test "+ "from "+" Larry");
        extentTest.assignDevice("SG "+"10 " + " OS"+ " 11");
        ExtentReportManager.setExtentTestThreadLocal(extentTest);
        return extentTest;
    }

    public static Media takeScreenshot(){
        String result = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BASE64);
        Media media = MediaEntityBuilder.createScreenCaptureFromBase64String(result).build();
        return media;
    }

    public static String getExtentTestStart(String report){
        report = getExtentTest().getStatus().getName();
        return report;
    }
    public static ExtentTest getExtentTestPass(String report){
        return getExtentTest().pass(report);
    }
    public static ExtentTest getExtentTestSkip(String report){
        return getExtentTest().skip(report);
    }

    public static ExtentTest getExtentTestFail(String message){
        return getExtentTest().fail(message,takeScreenshot());
       // return null;
    }
    public static ExtentTest getExtentTestInfo(String info){
        return getExtentTest().info(info);
    }

    public static void quitExtendReport(){
        if(Objects.nonNull(ExtentReportManager.getExtentTestThreadLocal())) {
            extentReports.flush();
            ExtentReportManager.removeExtentTestThreadLocal();
        }
    }
}
