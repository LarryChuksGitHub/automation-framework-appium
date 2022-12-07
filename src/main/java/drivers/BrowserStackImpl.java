package drivers;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class BrowserStackImpl implements IDriver{

    public WebDriver getDriver() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        // Set your access credentials
        caps.setCapability("browserstack.user", "hilarychukwuji_j57vAG");
        caps.setCapability("browserstack.key", "ZQwaC55nq2J54y7PDpm9");

        // Set URL of the application under test
        caps.setCapability("app", "bs://d888675ea19e0e8194da14260245a8e02e161d64");

        // Specify device and os_version for testing
        caps.setCapability("device", "Google Pixel 3");
        caps.setCapability("os_version", "9.0");

        // Set other BrowserStack capabilities
        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "browserstack-build-2");
        caps.setCapability("name", "Browserstack Test");


        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        return new AndroidDriver(new URL("http://hub.browserstack.com/wd/hub"), caps);
    }
}
