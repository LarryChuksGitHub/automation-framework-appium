package facade;

import pages.HomePage;
import pages.WebView3Page;

import java.net.MalformedURLException;

public class WebView3Facade {
    public WebView3Page swipeToWebView3AndClick() throws MalformedURLException {
        new HomePage()
                .clickViews().swipeToWebView3();
        return  new WebView3Page();
    }
}
