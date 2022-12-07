package constants;

import java.util.Locale;

public final class FrameworkConstants {


    private FrameworkConstants(){}


    private static String resourcePath = System.getProperty("user.dir")+ "/src/main/resources";
    private static String appPath = resourcePath+ "/apps/ApiDemos-debug.apk";
    private static String configPropertiesPath = resourcePath+"/config/properties";

    public static String getAppPath() {
        return appPath;
    }

    public static String getConfigPropertiesPath() {
        return configPropertiesPath;

    }
}
