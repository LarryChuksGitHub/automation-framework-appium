package swipetests;

import basetest.BaseTest;
import facade.WebView3Facade;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.HomePage;

import java.net.MalformedURLException;

public class SwipeTests extends BaseTest {
    @Test
    public void swipeToWebView3Test() throws MalformedURLException {
       // setUp();
        String result=
        new WebView3Facade()
                .swipeToWebView3AndClick()
                .getWebViewPageText();
        Assertions.assertThat(result.equalsIgnoreCase("Open Chrome"));

    }
}
