package pages;

import drivers.Driver;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.basepages.BasePage;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InlinePage extends BasePage {
    private Map<String,String> map = new HashMap<>();
    private By threeOclock = AppiumBy.ByAccessibilityId.accessibilityId("3");
    private By fiftheenMin = AppiumBy.ByAccessibilityId.accessibilityId("15");
    private By forthyfiveMin = AppiumBy.ByAccessibilityId.accessibilityId("45");
    private By resultHr = AppiumBy.id("android:id/hours");
    private By resultMin = AppiumBy.id("android:id/minutes");
    private By min30 = AppiumBy.ByAccessibilityId.accessibilityId("30");

    private By elements = AppiumBy.ByClassName.className("android.widget.RadialTimePickerView$RadialPickerTouchHelper");

    public InlinePage setClockTo345() throws MalformedURLException {
        Driver.getDriver().findElement(threeOclock).click();
        WebElement source = Driver.getDriver().findElement(fiftheenMin);
       WebElement target = Driver.getDriver().findElement(forthyfiveMin);
        dragAndDropElement(source,target);
        return new InlinePage();
    }
    public String getResult() throws MalformedURLException {
        String result = "";
        String hour = Driver.getDriver().findElement(resultHr).getText();
        String minutes = Driver.getDriver().findElement(resultMin).getText();
        return result = hour + minutes;
    }

    // Check for the number 30 on the screen
    //Check that the number of elements display is 12
    public boolean isDislayElemet12(){
        boolean is12 = false;
        List<WebElement> element12 = Driver.getDriver().findElements(elements);
        if (element12.size() == 12){
            is12 = true;
        }
        return is12;
    }

    public boolean is30Present() {
        boolean isPresent = false;
        List<WebElement> list = Driver.getDriver().findElements(elements);
        System.out.println(list);
        for (WebElement element : list) {
            if (element.getAttribute("content-desc").equalsIgnoreCase("30")) {
                System.out.println("Element attributes: "+ element.getAttribute("content-desc"));
                isPresent = true;
                break;
            }
        }
        return isPresent;
    }

}
