package pages;

import pages.basepages.BasePage;

import java.net.MalformedURLException;

public class CloningLandingPage extends BasePage {
    public void clickRun() throws MalformedURLException {
        click("accessibilityId","Run");
    }

}


