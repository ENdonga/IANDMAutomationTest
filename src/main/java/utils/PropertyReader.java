package utils;

import helpers.browser.BrowserType;
import helpers.resource.ResourceHelper;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader implements ConfigReader {
    private Properties properties;
    public static ConfigReader configReader = new PropertyReader();

    public PropertyReader(){
        try {
            String filePath = ResourceHelper.getResourcePath("/src/main/resources/config/config.properties");
            FileInputStream fis = new FileInputStream(new File(filePath));
            properties = new Properties();
            properties.load(fis);
        } catch (Exception e){
            System.out.println("Error message: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public int getImplicitWait() {
        return Integer.parseInt(properties.getProperty("implicitwait"));
    }

    public int getPageLoadTime() {
        return Integer.parseInt(properties.getProperty("pageloadtime"));
    }

    public int getExplicitWait() {
        return Integer.parseInt(properties.getProperty("explicitwait"));
    }

    public String getURL() {
        return properties.getProperty("applicationUrl");
    }

    public BrowserType getBrowserType() {
        return BrowserType.valueOf(properties.getProperty("browserType"));
    }
}
