package pages;

import pages.basepages.BasePage;

import java.net.MalformedURLException;

public class AppLandingPage extends BasePage {

    public void clickActivtity(String menuName) throws MalformedURLException {
        click("accessibilityId","Activity");
    }
}
