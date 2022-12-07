package facade;

import pages.HomePage;
import pages.InlinePage;

import java.net.MalformedURLException;

public class ClockFacade {

    public InlinePage navigateToClockPage() throws MalformedURLException {
        new HomePage()
                .clickViews()
                .clickDateWidgets()
                .clickInline();
        return new InlinePage();
    }

    public InlinePage getInlinePage(){

        return new InlinePage();
    }

}
