package tutorials;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.BDDAssertions;
import org.assertj.core.api.SoftAssertions;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;


public class GenericsDemo <T extends Number>{

    private T obj;

    public GenericsDemo(T obj){
        this.obj = obj;
    }


    public static void main(String[] args) {
        GenericsDemo genericsDemo = new GenericsDemo(4);
        Map<String,String> map = new HashMap<>();
        map.put("game", "football");
        map.put("sex","M");
        map.put("car","kia");
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(map)
        //assertThat(map).containsEntry("game","football")
                .doesNotContain(entry("ke","g"))
                .doesNotContainEntry("dsf","fo")
                .hasSize(3)
                .containsValue("Benz")
                .containsKey("car");
        System.out.println("This should be printed out even when assert fails");
        softAssertions.assertAll();

        BDDAssertions.then(map).containsKey("sex").containsValue("girl");

    }
}
