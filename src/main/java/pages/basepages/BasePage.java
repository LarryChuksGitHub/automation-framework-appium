package pages.basepages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import drivers.Driver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static reports.ExtentReport.*;

public class BasePage {

    // locating elements
    //h3[text()='Testing Mini Bytes - YouTube’]   Xpath to find link in YouTube

    private Map<String,String> map = new HashMap<>();

    private void waitForVisibilty(WebElement element) {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        wait.pollingEvery(Duration.ofSeconds(1))
                .withMessage(()->"Waited 5 seconds for the element and could not find it")
                .until(ExpectedConditions.visibilityOf(element));
    }
    protected void click(WebElement element, String elementName){
        waitForVisibilty(element);
        element.click();
       getExtentTestPass(elementName+ " is clicked");
        getExtentTestInfo("Info to element with name: "+ elementName);
        //getExtentTestStart("Test started");
       // ExtentReport.getExtentTestSkip("Test was skipped");
        System.out.println("The element: " + elementName+ " is clicked");
    }

    protected void click(By by, String elementName) {
        click(Driver.getDriver().findElement(by),elementName);
    }
//
//    public static String clickMenuID(String elementTextName){
//        String id = String.format(focus,elementTextName);
//        return id;
//    }
    protected void click(String locatorType, String locatorValue, String elementName) {
        if(locatorType.equalsIgnoreCase("xpath")){
            click(Driver.getDriver().findElement(By.xpath(locatorValue)),elementName);
        } else if(locatorType.equalsIgnoreCase("id")){
            click(Driver.getDriver().findElement(AppiumBy.ById.id(locatorValue)), elementName);
        }else if(locatorType.equalsIgnoreCase("accessibility id") || locatorType.equalsIgnoreCase("accessibilityid")){
            click(Driver.getDriver().findElement(AppiumBy.ByAccessibilityId.accessibilityId(locatorValue)),elementName);
        }
        else if(locatorType.equalsIgnoreCase("className")){
            click(Driver.getDriver().findElement(AppiumBy.ByClassName.className(locatorValue)),elementName);
        }
        else if(locatorType.equalsIgnoreCase("name")){
            click(Driver.getDriver().findElement(AppiumBy.ByName.name(locatorValue)),elementName);
        }
        else if(locatorType.equalsIgnoreCase("cssSelector")){
            click(Driver.getDriver().findElement(By.cssSelector(locatorValue)),elementName);
        }
    }

    protected void click(List<WebElement> menuItems, String elementText){
        //android.widget.ListView[@resource-id='android:id/list']
        menuItems = Driver.getDriver().findElements(AppiumBy.ByClassName.className("android.widget.TextView"));
        // menuItems.parallelStream().filter(e->e.getText().contains(text)).findFirst().ifPresent(WebElement::click);
         WebElement element = menuItems.parallelStream().filter(e->e.getText().contains(elementText)).findFirst().get();
        click(element,elementText);
//        for (WebElement element : menuItems){
//            if(element.getText().equalsIgnoreCase(text)){
//                click(element,text);
//                //element.click();
//                break;
//            }
//        }
    }

    protected void click(String locatorType, String elementTextName) {
        String text = "%s";
        String temp = String.format(text,elementTextName);
        if(locatorType.equalsIgnoreCase("accessibilityId")  ){
            click(Driver.getDriver().findElement(AppiumBy.ByAccessibilityId.accessibilityId(temp)),elementTextName);
        } else if(locatorType.equalsIgnoreCase("id")){
            click(Driver.getDriver().findElement(By.id(temp)),elementTextName);
        }else if(locatorType.equalsIgnoreCase("name")){
            click(Driver.getDriver().findElement(By.name(temp)),elementTextName);
        }else if(locatorType.equalsIgnoreCase("className")){
            click(Driver.getDriver().findElement(By.className(temp)),elementTextName);
        }else if(locatorType.equalsIgnoreCase("xpath")){
            click(Driver.getDriver().findElement(By.xpath(temp)),elementTextName);
        }else if(locatorType.equalsIgnoreCase("cssSelector")){
            click(Driver.getDriver().findElement(By.cssSelector(temp)),elementTextName);
        }else if(locatorType.equalsIgnoreCase("linkText")){
            click(Driver.getDriver().findElement(By.linkText(temp)),elementTextName);
        } else if(locatorType.equalsIgnoreCase("partialLinkText")){
            click(Driver.getDriver().findElement(By.partialLinkText(temp)),elementTextName);
        } else if(locatorType.equalsIgnoreCase("tagName")){
            click(Driver.getDriver().findElement(By.tagName(temp)),elementTextName);
        }
    }


    private void takeScreenShot(ExtentTest extentTest){
        var screenshot =((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BASE64);
        extentTest.pass(MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot).build());
    }

    public enum Direction {
        LEFT("left"), RIGHT("right"), UP("up"), DOWN("down");

        private String value;

        Direction(String value) {
            this.value = value;
        }

        private String getValue() {
            return this.value;
        }
    }
    protected void dragAndDropElement(WebElement source, WebElement target) {
        new TouchAction((AndroidDriver)Driver.getDriver()).longPress(LongPressOptions.longPressOptions()
                        .withDuration(Duration.ofSeconds(1))
                        .withElement(ElementOption.element(source)))
                .moveTo(ElementOption.element(target))
                .release()
                .perform();
        System.out.println("Source is set to target");
    }


    public void swipeToElement(Direction direction, long duration, By elementToSwipeTo) {
        Dimension dimension = Driver.getDriver().manage().window().getSize();
        int width = (int) dimension.getWidth();
        int height = (int) dimension.getHeight();
        int startX;
        int endX;
        int startY;
        int endY;
        switch (direction) {
            case UP:
                startX = (int) (width * 0.5);
                endX = (int) (width * 0.5);
                startY = (int) (height * 0.8);
                endY = (int) (height * 0.3);
                while (Driver.getDriver().findElements(elementToSwipeTo).isEmpty()){
                    new TouchAction((AndroidDriver)Driver.getDriver()).press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(duration)))
                            .moveTo(PointOption.point(endX, endY))
                            .release()
                            .perform();
                }
                break;

            case DOWN:
                startX = (int) (width * 0.5);
                endX = (int) (width * 0.5);
                startY = (int) (height * 0.3);
                endY = (int) (height * 0.8);

                while (Driver.getDriver().findElements(elementToSwipeTo).isEmpty()){
                    new TouchAction((AndroidDriver)Driver.getDriver()).press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(duration)))
                            .moveTo(PointOption.point(endX, endY))
                            .release()
                            .perform();
                }
                break;

            case LEFT:
                startX = (int) (width * 0.8);
                endX = (int) (width * 0.2);
                startY = (int) (height * 0.5);
                endY = (int) (height * 0.5);

                while (Driver.getDriver().findElements(elementToSwipeTo).isEmpty()){
                    new TouchAction((AndroidDriver)Driver.getDriver()).press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(duration)))
                            .moveTo(PointOption.point(endX, endY))
                            .release()
                            .perform();
                }
                break;

            case RIGHT:
                startX = (int) (width * 0.2);
                endX = (int) (width * 0.8);
                startY = (int) (height * 0.5);
                endY = (int) (height * 0.5);
                while (Driver.getDriver().findElements(elementToSwipeTo).isEmpty()){
                    new TouchAction((AndroidDriver)Driver.getDriver()).press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(duration)))
                            .moveTo(PointOption.point(endX, endY))
                            .release()
                            .perform();
                }
                break;
            default:
                System.out.println("Invalid direction");
        }

    }

    protected  void dragAndDropElementAnd(WebElement source, WebElement target) {
        new TouchAction((AndroidDriver)Driver.getDriver()).longPress(LongPressOptions.longPressOptions()
                        .withDuration(Duration.ofSeconds(2))
                        .withElement(ElementOption.element(source)))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(ElementOption.element(target))
                .release()
                .perform();
    }


    public  void longPressElement(WebElement element) {
        new TouchAction((AndroidDriver)Driver.getDriver()).longPress(LongPressOptions.longPressOptions().withDuration(Duration.ofSeconds(2))
                        .withElement(ElementOption.element(element)).withDuration(Duration.ofSeconds(2)))
                .release().perform();
    }

    protected  void tapElementWithCoordinates(int x, int y) {
        new TouchAction((AndroidDriver)Driver.getDriver()).tap(PointOption.point(x, y)).perform();
    }

    protected void tapElement(WebElement element) {
        new TouchAction((AndroidDriver)Driver.getDriver()).tap(TapOptions.tapOptions().withElement(ElementOption.element(element))).perform();
    }

}


