package utils;

import helpers.browser.BrowserType;

public interface ConfigReader {
    public int getImplicitWait();
    public int getPageLoadTime();
    public int getExplicitWait();
    public String getURL();
    public BrowserType getBrowserType();
}
