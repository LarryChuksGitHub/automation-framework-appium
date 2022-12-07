package utils;

import constants.FrameworkConstants;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyUtils {
   static Properties properties = new Properties();
     static Map<String,String> map = new HashMap<>();

    static {
       // FileInputStream fileInputStream;
        try (FileInputStream fileInputStream = new FileInputStream(FrameworkConstants.getConfigPropertiesPath())){
            properties.load(fileInputStream);
            //properties.get(k)
            for (Map.Entry<Object, Object> entry : properties.entrySet()) {
                String key = String.valueOf(entry.getKey());
                String value = String.valueOf(entry.getValue());
                map.put(key, value);
            }
            }
        catch(IOException e){
                e.printStackTrace();
                System.exit(0);
            }
        }


        public static String getEnvironmentValue(String key){
        return map.get(key);
        }

}
