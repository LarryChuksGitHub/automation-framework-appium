package pages;

import drivers.Driver;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.basepages.BasePage;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ViewLandingPage extends BasePage {

    private Map<String,String> map = new HashMap<>();

   private By dateWidgets = AppiumBy.ByAccessibilityId.accessibilityId("Date Widgets");
   private List<WebElement> viewPageElements;
    private By focus = AppiumBy.ByAccessibilityId.accessibilityId("Focus");
    private By webView3 = AppiumBy.ByAccessibilityId.accessibilityId("WebView3");


    public void clickFucos(String menuName) throws MalformedURLException {
        click("accessibilityid","Focus","Focus");
    }

//    public DateWidgetsPage clickDateWidgets() throws MalformedURLException {
//        click(dateWidgets,"Date Widget");
//        return new DateWidgetsPage();
//    }

    public DateWidgetsPage clickDateWidgets() throws MalformedURLException {
       click(viewPageElements,"Date Widgets");
        return new DateWidgetsPage();
  }


    //android.widget.TextView
    private void clickMenuItemWithText(String text) throws MalformedURLException {
        viewPageElements = Driver.getDriver().findElements(By.ByClassName.className("android.widget.TextView"));
        //webElements.parallelStream().filter(e -> e.getText().contains(text)).findFirst().ifPresent(WebElement::click);
    }

    public WebView3Page swipeToWebView3() throws MalformedURLException {
        swipeToElement(Direction.UP,1,webView3);
        click(webView3,"WebViews3");
        return new WebView3Page();
    }


}
