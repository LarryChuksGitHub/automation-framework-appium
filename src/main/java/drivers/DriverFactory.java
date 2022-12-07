package drivers;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.util.Map;

public class DriverFactory {

   private static WebDriver driver;

    /**
     *
     * @param environment Takes Enum as Environment to run the tests
     * @return Webdriver
     * @throws MalformedURLException
     */
    public static WebDriver getEnvironmentDriver(Environment environment) throws MalformedURLException {
        if (Environment.LOCAL.equals(environment)) {
            return driver = new LocalDriverImp().getDriver();
        } else if (environment.equals(Environment.BROWSERSTACK)) {
           return driver = new BrowserStackImpl().getDriver();
        }else if (environment.equals(Environment.SAUCELABS)) {
            return driver = new SaucelabsImpl().getDriver();
        }
        return driver;
    }



}
