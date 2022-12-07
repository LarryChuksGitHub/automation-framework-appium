package clocktest;

import basetest.BaseTest;
import drivers.Driver;
import facade.ClockFacade;
import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.InlinePage;

import java.net.MalformedURLException;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class SetClockTests extends BaseTest {

    @Test()
    public void setClockTest() throws MalformedURLException {
        // navigate to inline page
       String result =
                new ClockFacade()
                .navigateToClockPage()
                .setClockTo345()
               .getResult();
        //set clock to 3:45  //verify result

        //Check that the text is containing 345
        // Check that the text is not null
        //Check the lenght of the text is greater than 2 and less than 100
        // Check for the number 30 on the screen
        //Check that the number of elements display is 12
        assertThat(result).isEqualTo("345","Result does not contain 345").hasSizeBetween(2,100).hasSize(12).isNotNull().as("Result should be time").isNotBlank();
        Assert.assertTrue(Objects.nonNull(result));
        Assert.assertTrue(result.length() > 2 ,"Result ist not greater than 2");
        Assert.assertTrue(result.length() < 100 ,"Result ist not less smaller 100");
        InlinePage inlinePage = new InlinePage();
        Assert.assertTrue(inlinePage.is30Present(),"The elemet 30 is not displayed");
        Assert.assertTrue(inlinePage.isDislayElemet12(),"The number of elemet displayed is not 12");
        tearDown();
    }

    @Test()
    public void setClockTest2() throws MalformedURLException {
        // navigate to inline page
        setUp();
        //Driver.getDriver( map);
        // String result =
        new ClockFacade()
                .navigateToClockPage()
                .setClockTo345();
        // .getResult();
        //set clock to 3:45  //verify result
        // assertThat(result).isEqualTo("345");
        tearDown();
    }

    @DataProvider(parallel = true)
    public Object [] getDeviceData(){
        Map<String,String> map = new HashMap<>();
        map.put("device","Samsung Galaxy S10");
        map.put("version","11");

        Map<String,String> map2 = new HashMap<>();
        map2.put("device","HUAWEI P30 Pro");
        map2.put("version","10");

        List<Map<String,String>> deviceList = new ArrayList<>();
        deviceList.add(map);
        deviceList.add(map2);
        return deviceList.toArray();
    }
}
