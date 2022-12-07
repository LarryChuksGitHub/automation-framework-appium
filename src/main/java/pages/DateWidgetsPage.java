package pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import pages.basepages.BasePage;

import java.net.MalformedURLException;

public class DateWidgetsPage extends BasePage {
    private By inline = AppiumBy.ByAccessibilityId.accessibilityId("2. Inline");

    public InlinePage clickInline() throws MalformedURLException {
        click(inline,"Inline");
        return new InlinePage();
    }
}
