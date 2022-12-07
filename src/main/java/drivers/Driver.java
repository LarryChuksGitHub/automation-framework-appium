package drivers;

import org.openqa.selenium.WebDriver;
import utils.PropertyUtils;

import java.net.MalformedURLException;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public final class Driver {


    public static WebDriver getDriver() {
        return initDriver();
    }
   // private static WebDriver driver;

    private Driver(){}

    private  static WebDriver initDriver() {
        try {
            if(isNull(DriverManager.getThreadDriver())){
                 String environment = PropertyUtils.getEnvironmentValue("Environment");
                WebDriver driver = DriverFactory.getEnvironmentDriver(Environment.valueOf(environment));
                DriverManager.setThreadDriver(driver);
             }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
       // System.out.println("The thread driver is: " +DriverManager.getThreadDriver());
        return DriverManager.getThreadDriver();

    }

    public  static void quitDriver() throws MalformedURLException {
        if(nonNull(DriverManager.getThreadDriver())) {
            DriverManager.getThreadDriver().quit();
            DriverManager.unloadThreadDriver();
        }
    }
}
