package datatest;

import basetest.BaseTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import drivers.Driver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.util.*;

public class DataProviderTests extends BaseTest {

    private By emailfield = By.cssSelector("#capture_signIn_emailOrPostNumber");
    private By passwortfieldand = By.cssSelector("#capture_signIn_currentPassword");
    private By anmeldenButtonand = By.cssSelector("#eauth-sdk-login-submit");


    public Object [][] readJSONData(String jsPath,String contentData, int jsKeys) throws FileNotFoundException, ParseException {
        Object [][] resultArrays = null;

        try (FileReader fileReader  = new FileReader(jsPath)){
            Object content = new JSONParser().parse(fileReader);
            JSONObject jsonObject = (JSONObject)content;
            JSONArray loginData = (JSONArray) jsonObject.get(contentData);

            resultArrays = new String[loginData.size()][jsKeys];
            for (int i = 0; i < loginData.size();i++){
                JSONObject jsonObject1 = (JSONObject) loginData.get(i);
                resultArrays[i][0] = String.valueOf(jsonObject1.get("postnummer"));
                resultArrays[i][1] = String.valueOf(jsonObject1.get("password"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return resultArrays;
    }

    public Object [][] JsonReader(String filePath, String dataName, int numberOfkeys) throws ParseException {

        Object [][] array = null;
        try (FileReader fileReader = new FileReader(filePath)) {
            Object content = new JSONParser().parse(fileReader);
            JSONObject jsonObject= (JSONObject) content;
           // JSONObject jsonObject1 = (JSONObject) jsonObject.get(jsonParser);

            //Object object = jsonObject.get(dataName);
            JSONArray loginData = (JSONArray) jsonObject.get(dataName);
            //Object object2 = loginData(object);
          //JSONObject jsonObject2 = loginData.add(i);

            array = new String [loginData.size()][numberOfkeys];
            for(int i = 0; i < loginData.size(); i++){
                JSONObject jsonObject2= (JSONObject) loginData.get(i);
                array [i][0] = String.valueOf(jsonObject2.get("postnummer"));
                array[i][1] = String.valueOf(jsonObject2.get("password"));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }

    public static JSONArray  JacksonReader(){
        JSONObject jsonObject = null;
        JSONArray jsonArray = null;
        try {
            jsonObject = new ObjectMapper().readValue(System.getProperty("user.dir" +"/Users/hilarychukwuji/IdeaProjects/automationFramework/src/main/resources/data/testdata.json"), JSONObject.class);
         jsonArray = (JSONArray) jsonObject.get("loginData");
            for (int i = 0; i < jsonArray.size(); i++){
                Object result = jsonArray.get(i);
                //JSONObject jsonObject = (JSONObject) object;
                //var result = jsonObject.get("loginData");
                System.out.println(result);
            }
            System.out.println(jsonArray);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonArray;
    }

    public static void main(String[] args) {
        JacksonReader();
    }

    @DataProvider
    public Object [][] getJSONData() throws FileNotFoundException, ParseException {
        //Object [][] data = readJSONData("/Users/hilarychukwuji/IdeaProjects/automationFramework/src/main/resources/data/testdata.json","loginData",2);
       Object [][] data = JsonReader("/Users/hilarychukwuji/IdeaProjects/automationFramework/src/main/resources/data/testdata.json","loginData",2);
        //Object [][] data = JacksonReader();
        return data;
    }




    @Test(dataProvider = "getJSONData")
    public void runJSONTest(String postnummer, String password) throws MalformedURLException {
        setUp();
        Driver.getDriver().findElement(By.id("de.dhl.paket.git:id/onSkip")).click();
        Driver.getDriver().findElement(By.id("de.dhl.paket.git:id/buttonAll")).click();
        Driver.getDriver().findElement(By.id("de.dhl.paket.git:id/nav_item_more")).click();
        Driver.getDriver().findElement(By.id("de.dhl.paket.git:id/btn_login")).click();
        System.out.println(postnummer+ password);
        //System.out.println(password + password);
        //tearDown();

    }
    @Test(dataProvider = "getNormalData")
    public void runNormalDataTest(String postnummer, String password) throws MalformedURLException {
       // setUp();
        Driver.getDriver().findElement(By.id("de.dhl.paket.git:id/onSkip")).click();
        Driver.getDriver().findElement(By.id("de.dhl.paket.git:id/buttonAll")).click();
        Driver.getDriver().findElement(By.id("de.dhl.paket.git:id/nav_item_more")).click();
        Driver.getDriver().findElement(By.id("de.dhl.paket.git:id/btn_login")).click();
        System.out.println(postnummer);
        System.out.println(password);

    }

    @Test(dataProvider = "getData")
    public void runTest(String username, String password) throws MalformedURLException {
        setUp();
        Driver.getDriver().findElement(By.id("de.dhl.paket.git:id/onSkip")).click();
        Driver.getDriver().findElement(By.id("de.dhl.paket.git:id/buttonAll")).click();
        Driver.getDriver().findElement(By.id("de.dhl.paket.git:id/nav_item_more")).click();
        Driver.getDriver().findElement(By.id("de.dhl.paket.git:id/btn_login")).click();
        System.out.println(username);
        System.out.println(password);
        tearDown();


        //System.out.println
       // System.out.println(address);
       // System.out.println(mail);

    }


    @Test(dataProvider = "getDataMap")
    public void runMapTest(Map<String,String> map){
        System.out.println( map.get("username"));
        System.out.println( map.get("password"));
        System.out.println( map.get("mail"));
        System.out.println(map.get("address"));
        // System.out.println(mail);

    }

    @Test(dataProvider = "gataDataMapObject")
    public void runMapObjectTest(Map<String ,String> map) throws MalformedURLException, InterruptedException {
        setUp();
        Driver.getDriver().findElement(By.id("de.dhl.paket.git:id/onSkip")).click();
        Driver.getDriver().findElement(By.id("de.dhl.paket.git:id/buttonAll")).click();
        Driver.getDriver().findElement(By.id("de.dhl.paket.git:id/nav_item_more")).click();
        Driver.getDriver().findElement(By.id("de.dhl.paket.git:id/btn_login")).click();
//
//        switchToWebView((AndroidDriver) Driver.getDriver());
//        Driver.getDriver().findElement(emailfield).click();
//        Driver.getDriver().findElement(emailfield).sendKeys(map.get("postnummer"));
//        Driver.getDriver().findElement(passwortfieldand).click();
//        Driver.getDriver().findElement(passwortfieldand).sendKeys(map.get("password"));
//        Driver.getDriver().findElement(anmeldenButtonand).click();
//        switchToNative((AndroidDriver) Driver.getDriver());


//
//        System.out.println(map.get("username"));
//        System.out.println(map.get("password"));
//        System.out.println(map.get("mail"));
//        System.out.println(map.get("address"));

        // System.out.println(mail);

    }
    @DataProvider
    public Object[] gataDataMapObject(){
        Map<String,String> map = new HashMap<>();

        map.put("postnummer","872131805");
        map.put("password","Test1357");
        //map.put("mail","larry.com");
        //map.put("address","berlin");

        Map<String,String> map2 = new HashMap<>();

        map2.put("postnummer","39377874");
        map2.put("password","Startm!");
        //map2.put("mail","jere.com");
        //map2.put("address","lagos");

        List<Map<String,String>> listMap = new ArrayList<>();
        listMap.add(map);
        listMap.add(map2);

        return listMap.toArray();
    }

    @DataProvider
    public Object[] getDataMap(){
        Map<String, String> map = new HashMap<>();
        map.put("username","larry");
        map.put("password","pass123456");
        map.put("mail","g.com");
        map.put("address","luckeweg");
       // map.put("username","Jere");
        //map.put("password","Pass1234");

        Map<String, String> map2 = new HashMap<>();
        map2.put("username","larryX");
        map2.put("password","pass123456X");
        map2.put("mail","l.com");
       // map2.put("passwordX","passTestsX");
       // map2.put("usernameX","JereX");
        //map2.put("passwordX","Pass1234X");

        List<Map<String,String>> mapList = new ArrayList<>();
        mapList.add(map);
        mapList.add(map2);

        return mapList.toArray();

        //return mapList;
    }

    @DataProvider
    public Object[][] getNormalData(){
        return new Object[][]{
                {"postnummer","larry"},
                {"password","pass123456"},
                {"postnummer","Ebu"},
                {"password","passTests"}
        };

    }


    protected void switchToWebView(AndroidDriver androidDriver) throws InterruptedException {
        Thread.sleep(250);
        androidDriver = (AndroidDriver) Driver.getDriver();
        System.out.println("This is the current context: "+ androidDriver.getContext());
        //if (iosDriver.getContext().startsWith("WEBVIEW")){
        //    switchToNativeiOS(iosDriver);
        //}
        System.out.println("The context are: " + androidDriver.getContextHandles());
        Set<String> contextNames = androidDriver.getContextHandles();
        for (String contextName: contextNames){
            if(contextName.startsWith("WEBVIEW_de")){
                androidDriver.context(contextName);
                System.out.println("breaking out from the Context Handle (WebView) loop ");
                System.out.println("we are now in context: " + contextName);
                break;
            }
        }
    }

    protected void switchToNative(AndroidDriver androidDriver){
        androidDriver = (AndroidDriver) Driver.getDriver();
        androidDriver.context("NATIVE_APP");
        System.out.println("we are now in context: " + "Native");
    }
    protected void switchToWebViewiOS(IOSDriver iosDriver) throws InterruptedException {
        Thread.sleep(250);
        iosDriver = (IOSDriver) Driver.getDriver();
        System.out.println("This is the current context: "+ iosDriver.getContext());
        //if (iosDriver.getContext().startsWith("WEBVIEW")){
        //    switchToNativeiOS(iosDriver);
        //}
        System.out.println("The context are: " + iosDriver.getContextHandles());
        Set<String> contextNames = iosDriver.getContextHandles();
        for (String contextName: contextNames){
            if(contextName.startsWith("WEBVIEW")){
                iosDriver.context(contextName);
                System.out.println("breaking out from the Context Handle (WebView) loop ");
                System.out.println("we are now in context: " + contextName);
                break;
            }
        }
    }
    protected void switchToNativeiOS(IOSDriver iosDriver){
        iosDriver = (IOSDriver) Driver.getDriver();
        iosDriver.context("NATIVE_APP");
        System.out.println("The switching to context: " +iosDriver.getContext());
    }
}
