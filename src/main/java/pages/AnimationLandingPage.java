package pages;

import org.openqa.selenium.WebElement;
import pages.basepages.BasePage;

import java.net.MalformedURLException;
import java.util.List;

public class AnimationLandingPage extends BasePage {

    private List<WebElement> webElements;

    public CloningLandingPage clickCloning() throws MalformedURLException {
        click("accessibilityId","Cloning");
        return new CloningLandingPage();
    }

}
