package reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentReportManager {

    private static ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<>();

    private ExtentReportManager(){

    }

    static ExtentTest getExtentTestThreadLocal() {
        return extentTestThreadLocal.get();
    }

    public static void setExtentTestThreadLocal(ExtentTest extentTest) {

        extentTestThreadLocal.set(extentTest);
    }

    public static void removeExtentTestThreadLocal(){
        extentTestThreadLocal.remove();
    }




}
