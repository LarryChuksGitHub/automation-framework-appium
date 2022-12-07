package drivers;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class SaucelabsImpl implements IDriver{
    @Override
    public WebDriver getDriver() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        return new AndroidDriver(new URL("http://hub.browserstack.com/wd/hub"), caps);
    }
}
