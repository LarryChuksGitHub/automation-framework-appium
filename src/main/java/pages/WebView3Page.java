package pages;

import drivers.Driver;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import pages.basepages.BasePage;

import java.util.HashMap;
import java.util.Map;

public class WebView3Page extends BasePage {
    private Map<String,String> map = new HashMap<>();
    private By webView3 = AppiumBy.ByAccessibilityId.accessibilityId("Open Chrome");

    public String getWebViewPageText(){
        return Driver.getDriver().findElement(webView3).getText();
    }
}
