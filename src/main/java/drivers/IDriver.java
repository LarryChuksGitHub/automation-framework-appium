package drivers;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.util.Map;

public interface IDriver {

    public WebDriver getDriver()
            throws MalformedURLException;
}
