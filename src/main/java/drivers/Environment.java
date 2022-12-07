package drivers;

public enum Environment {
    LOCAL ("local"),SAUCELABS("saucelabs"),BROWSERSTACK("browserstack"),PERFECTO("perfecto");

    private String value;

    Environment(String value) {
    }
    public String getValue(){
        return value;
    }
}
