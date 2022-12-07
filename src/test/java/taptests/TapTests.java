package taptests;

import basetest.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import drivers.Driver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import pages.basepages.BasePage;

import java.net.MalformedURLException;

import static pages.basepages.AndroidBasePage.*;

public class TapTests extends BaseTest {
    private ExtentReports extent;
    private ExtentSparkReporter spark;
    private TakesScreenshot takesScreenshot;
/**

    @Test
    public void tapViewTest() throws MalformedURLException {
        setUp();
//        WebElement element = driver.findElement(AppiumBy.ByAccessibilityId.accessibilityId(""));
//        WebElement element1 = driver.findElement(By.ByClassName.name(""));
//        WebElement element2 = driver.findElement(AppiumBy.ById.ByClassName.name(""));
//
//        driver.findElements(By.xpath("//android.widget.ListView[@resource-id='android:id/list']/android.widget.TextView"))
//                .parallelStream().map(WebElement::getText).forEach(System.out::println);
//        tap(driver, element);
//        // driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Webview\"))");
//        // driver.findElementByAndroidUIAutomator();
       // driver = (AndroidDriver) Driver.initDriver();
        WebElement view = Driver.getDriver().findElement(AppiumBy.ByAccessibilityId.accessibilityId("Views"));
        tapElement(view);
        tearDown();
    }
    private void tapElement(WebElement element) throws MalformedURLException {
        AndroidDriver driver = (AndroidDriver) Driver.getDriver();
        new TouchAction(driver).tap(TapOptions.tapOptions().withElement(ElementOption.element(element))).perform();
    }



@Test
    public void longPressTestTest() throws MalformedURLException {
        setUp();
        extent = new ExtentReports();
        spark =  new ExtentSparkReporter(System.getProperty("user.dir")+"/index.html");
        spark.config().setReportName("Test Automation");
        spark.config().getDocumentTitle();
        spark.config().setTheme(Theme.DARK);

        spark.config().getReportName();
        extent.attachReporter(spark);


        var test = extent.createTest("Reports")
                .assignAuthor("Larry").assignAuthor("Ebu")
                .assignCategory("Smoke Test")
                .assignDevice("Samsung " +"Galaxy " +"S " +"10")
                .pass("Test passed")
                .info("Larry Info")
                .skip("Test was skipped");
        test.pass("View is clicked");
        takeScreenShot(test);
    Driver.getDriver().findElement(AppiumBy.ByAccessibilityId.accessibilityId("Views")).click();
        takeScreenShot(test);
    Driver.getDriver().findElement(AppiumBy.ByAccessibilityId.accessibilityId("Expandable Lists")).click();
        takeScreenShot(test);
        test.pass("Expandable list is clicked");
    Driver.getDriver().findElement(AppiumBy.ByAccessibilityId.accessibilityId("1. Custom Adapter")).click();
        takeScreenShot(test);
        WebElement peopleNames = Driver.getDriver().findElement(By.ByXPath.xpath("//android.widget.TextView[@text='People Names']"));
        longPressElement(peopleNames);
        takeScreenShot(test);
        WebElement sampleMenu = Driver.getDriver().findElement(By.ByXPath.xpath("//android.widget.TextView[@text='Sample menu']"));
        String sampleMenuText = sampleMenu.getText();
        Assert.assertTrue(sampleMenu.isDisplayed());
        Assertions.assertThat(sampleMenuText)
                .withFailMessage(()->"Check").as("Check that the text is shown after long press")
                .hasSize(11)
                .contains("Sample")
                .doesNotContain("tiktok")
                .isNotEmpty()
                .isNotBlank()
                .containsWhitespaces()
                .hasSizeBetween(6,50)
                .hasSizeGreaterThan(9);
        extent.flush();
       // tearDown();
    }

    @Test
    public void setClockTest() throws MalformedURLException {
        setUp();
        Driver.getDriver().findElement(AppiumBy.ByAccessibilityId.accessibilityId("Views")).click();
        Driver.getDriver().findElement(AppiumBy.ByAccessibilityId.accessibilityId("Date Widgets")).click();
        Driver.getDriver().findElement(AppiumBy.ByAccessibilityId.accessibilityId("2. Inline")).click();
        Driver.getDriver().findElement(AppiumBy.ByAccessibilityId.accessibilityId("3")).click();
        WebElement target = Driver.getDriver().findElement(AppiumBy.ByAccessibilityId.accessibilityId("45"));
        target.click();
        WebElement minutes = Driver.getDriver().findElement(By.ByXPath.xpath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc='45']"));
        String minutesText = minutes.getText();
        Assert.assertEquals("45", minutesText, minutesText);

    }

    @Test
    public void dragAndDropTest() throws MalformedURLException, InterruptedException {
        setUp();
        Driver.getDriver().findElement(AppiumBy.ByAccessibilityId.accessibilityId("Views")).click();
        Driver.getDriver().findElement(AppiumBy.ByAccessibilityId.accessibilityId("Drag and Drop")).click();
        WebElement source = Driver.getDriver().findElement(AppiumBy.ById.id("io.appium.android.apis:id/drag_dot_1"));
        WebElement target = Driver.getDriver().findElement(AppiumBy.ById.id("io.appium.android.apis:id/drag_dot_2"));
       // dragAndDropElement(source, target);
        // Thread.sleep(3);
        String result = Driver.getDriver().findElement(AppiumBy.ById.id("io.appium.android.apis:id/drag_result_text")).getText();
        Assert.assertEquals(result, "Dropped!");
        //tearDown();
    }



    @Test
    public void swipeUp() throws MalformedURLException {
        setUp();
        Driver.getDriver().findElement(AppiumBy.ByAccessibilityId.accessibilityId("Views")).click();
        By element = AppiumBy.ByAccessibilityId.accessibilityId("WebView3");
        while (Driver.getDriver().findElements(element).isEmpty()) {
           // swipeToElement(BasePage.Direction.UP, 1);
        }
        // if(!driver.findElements(element).isEmpty()){
        Driver.getDriver().findElement(element).click();
        //driver.findElement(AppiumBy.ByAccessibilityId.accessibilityId("WebView3")).click();
        //}
        Assert.assertTrue(Driver.getDriver().findElement(AppiumBy.ByAccessibilityId.accessibilityId("Open Chrome")).isDisplayed());
        tearDown();
    }

    @Test
    public void swipeDown() throws MalformedURLException {
        setUp();
        Driver.getDriver().findElement(AppiumBy.ByAccessibilityId.accessibilityId("Views")).click();
        By element = AppiumBy.ByAccessibilityId.accessibilityId("WebView3");
        while (Driver.getDriver().findElements(element).isEmpty()) {
           // swipeToElement(BasePage.Direction.UP, 1);
        }
        element = AppiumBy.ByAccessibilityId.accessibilityId("Animation");
        while (Driver.getDriver().findElements(element).isEmpty()) {
           // swipeToElement(BasePage.Direction.DOWN, 1);
        }
        //if (!driver.findElements(element).isEmpty()) {
        Driver.getDriver().findElement(element).click();
        // }
        Assert.assertTrue(Driver.getDriver().findElement(AppiumBy.ByAccessibilityId.accessibilityId("Push")).isDisplayed());
    }

    */
}
