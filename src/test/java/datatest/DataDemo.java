package datatest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataDemo {

    public Object [][] JsonReader(String filePath, String dataName, int numberOfkeys) throws ParseException {

        Object [][] array = null;
        try (FileReader fileReader = new FileReader(filePath)) {
            JSONParser jsonParser = (JSONParser) new JSONParser().parse(fileReader);
           // jsonParser.parse((String) jsonObject.get(fileReader));
            JSONObject jsonObject= new JSONObject();
            jsonObject.get(jsonParser);

            Object object = jsonObject.get(dataName);
            JSONArray loginData = new JSONArray();
            Object object2 = loginData.add(object);
            JSONObject jsonObject2 = (JSONObject) object2;


            array = new String [loginData.size()][numberOfkeys];
            for(int i = 0; i < loginData.size(); i++){
                array [i][0] = jsonObject2.get("postnummer");
                array[i][1] = jsonObject2.get("password");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }

    @DataProvider
    public static Object [][] getData(){
       return new Object [][] {
               {"abd","cde","efg","ijk"},
               {"123","456","678","923"},
               {"zxc","dfg","hjk","erty"},
       };
    }

    @DataProvider
    public static Object [] getData2(){
        Map<String,String> map = new HashMap<>();
        map.put("username","abd");
        map.put("password","cde");
        map.put("email","efg");
        map.put("number","456");

        Map<String,String> map1 = new HashMap<>();
        map1.put("username","ijkl");
        map1.put("password","mno");
        map1.put("email","pqr");
        map1.put("number","123");

        Map<String,String> map2 = new HashMap<>();
        map2.put("username","tsg");
        map2.put("password","hop");
        map2.put("email","pop");
        map2.put("number","098");

        return new Object []{map,map1,map2};
//
//        List<Map<String,String>> list = new ArrayList<>();
//        list.add(map);
//        list.add(map1);
//        list.add(map2);
//
//        return list.toArray();
    }
    @Test(dataProvider = "getData")
    public static void runTest(String usernane, String password, String email, String number){
        System.out.println("This is username: " + usernane);
        System.out.println("This is password: " + password);
        System.out.println("This is email: " + email);
        System.out.println("This is number: " + number);

    }

    @Test(dataProvider = "getData2")
    public static void runTestMap(Map<String,String> map){
        System.out.println("This is username: " + map.get("username"));
        System.out.println("This is password: " + map.get("password"));
        System.out.println("This is email: " + map.get("email"));
        System.out.println("This is number: " + map.get("number"));
    }



    public static void main(String[] args) {
        //runTest();

    }
}
