package drivers;

import org.openqa.selenium.WebDriver;

public final class DriverManager {

    private DriverManager(){}
    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

    public static WebDriver getThreadDriver(){
        return threadDriver.get();
    }
    public static void setThreadDriver(WebDriver driver){
        threadDriver.set(driver);
    }

    public static void unloadThreadDriver(){
        threadDriver.remove();
        threadDriver = null;
    }
}
