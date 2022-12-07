package drivers;

import constants.FrameworkConstants;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class LocalDriverImp implements IDriver{


    public void setSystemPort(String systemPort) {
        this.systemPort = systemPort;
    }

    private String systemPort;

    public String getSystemPort(){
        return "8100";
    }

    public String getSystemPort2(){
        return "8200";
    }
    @Override
    public WebDriver getDriver() throws MalformedURLException {

        //Map<String,String> map;
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

            //desiredCapabilities.setCapability("systemPort","8100");
            desiredCapabilities.setCapability("appium:platformName", "Android");
            //desiredCapabilities.setCapability("appium:automationName","UiAutomator2");
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
            //desiredCapabilities.setCapability("systemPort","8200");
            //map.forEach(desiredCapabilities::setCapability);
            desiredCapabilities.setCapability("appium:platformVersion", "12");
            desiredCapabilities.setCapability("appium:deviceName", "Samsung Galaxy 10");

            //desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"");
            //desiredCapabilities.setCapability("newCommandTimeout", "45000");
            // desiredCapabilities.setCapability("chromedriverExecutable", "/Users/hilarychukwuji/IdeaProjects/dhlApp/drivers/chromedriver");

            //desiredCapabilities.setCapability("autoGrantPermission", true);
            //desiredCapabilities.setCapability("skipDeviceInitialization", true);
            //desiredCapabilities.setCapability("skipServerInstallation", true);

            desiredCapabilities.setCapability("unlockType", "pin");
            desiredCapabilities.setCapability("unlockKey", "0000");
            desiredCapabilities.setCapability("appium:app", FrameworkConstants.getAppPath());
            desiredCapabilities.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE,"/Users/hilarychukwuji/IdeaProjects/automationFramework/src/main/resources/mobiledrivers/chromedriver2");
           // desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");


            //desiredCapabilities.setCapability("appium:app","/Users/hilarychukwuji/IdeaProjects/automationFramework/src/main/resources/apps/dhl840.apk");
            desiredCapabilities.asMap().forEach((k,v)-> System.out.println(k+ " : " +v));

            // desiredCapabilities.setCapability("appium:browserName","Chrome");
            return new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
        }
}
