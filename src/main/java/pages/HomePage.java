package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.basepages.BasePage;

import java.net.MalformedURLException;
import java.util.List;

public class HomePage extends BasePage {

    @AndroidFindBy(className = "android.widget.TextView")
    private List <WebElement> menuItems;


    private By views = AppiumBy.ByAccessibilityId.accessibilityId("Views");
    private By animation = AppiumBy.ByAccessibilityId.accessibilityId("Animation");
    private By app = AppiumBy.ByAccessibilityId.accessibilityId("App");

    public HomePage(){
       // PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()),this);
    }
    public ViewLandingPage clickViews() throws MalformedURLException {
        click("accessibilityId","Views");
        return new ViewLandingPage();
    }
    public AnimationLandingPage clickAnimation() throws MalformedURLException {
        click("accessibilityId","Animation");
        return new AnimationLandingPage();
    }
    public AppLandingPage clickApp() throws MalformedURLException {
        click("accessibilityId","App");
        return new AppLandingPage();
    }
}
