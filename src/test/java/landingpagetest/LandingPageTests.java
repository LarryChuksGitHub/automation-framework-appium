package landingpagetest;

import basetest.BaseTest;
import drivers.Driver;
import org.testng.annotations.Test;
import pages.HomePage;

import java.net.MalformedURLException;

public class LandingPageTests extends BaseTest {
    @Test
    public void tapTest() throws MalformedURLException, InterruptedException {
        //setUp();
        HomePage homePage = new HomePage();
        var viewLandingPage = homePage.clickViews();
        viewLandingPage.clickFucos("Focus");
        Thread.sleep(10);
       // tearDown();
    }
    @Test
    public void tapCloningTest() throws MalformedURLException, InterruptedException {
        //setUp();
        HomePage homePage = new HomePage();
        var animationLandingPage  = homePage.clickAnimation();
        animationLandingPage.clickCloning();
        Thread.sleep(10);
      //  tearDown();
    }

    @Test
    public void tapActivityTest() throws MalformedURLException, InterruptedException {
        //setUp();
        HomePage homePage = new HomePage();
        var appLandingPage  = homePage.clickApp();
        appLandingPage.clickActivtity("Activity");
        //Thread.sleep(10);
       // tearDown();
    }

    @Test
    public void cloninglandingPageTest() throws MalformedURLException, InterruptedException {
       // setUp();
       // new HomePage().clickMenuItemWithText("Animation");
        Thread.sleep(100);
        //new AnimationLandingPage().clickMenuItemWithText("Cloning");
       // new CloningLandingPage().clickMenuItemWithText("RUN");
       // tearDown();
    }
    @Test
    public void viewslandingPageTest() throws MalformedURLException, InterruptedException {
        //setUp();
        var animation =new HomePage().clickAnimation();
        var cloning = animation.clickCloning();
        cloning.clickRun();
      //  tearDown();
    }
}
