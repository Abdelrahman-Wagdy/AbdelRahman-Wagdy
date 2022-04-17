package driverSingleton;

import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


public class driverSingleton {
    static String chromePath = "src/drivers/chromedriver.exe";
    static String firefoxPath = "src/drivers/geckodriver.exe";
    static WebDriver driver;

    public static WebDriver getDriver(){
        return driver;
    }

    public static WebDriver setDriver(String type){
        if (type.equalsIgnoreCase("chrome")) {
            try {
                System.setProperty("webdriver.chrome.driver", chromePath);
                ChromeOptions options = new ChromeOptions();
                options.addArguments("use-fake-ui-for-media-stream");
                driver = new ChromeDriver(options);
                return driver;
            } catch (SessionNotCreatedException ex) {
                ex.printStackTrace();
            }
        } else if (type.equalsIgnoreCase(("firefox"))) {
            System.setProperty("webdriver.gecko.driver", firefoxPath);
            driver = new FirefoxDriver();
            return driver;
        }
        return null;
    }
}
