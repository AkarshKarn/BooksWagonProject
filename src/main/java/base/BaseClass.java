package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import util.TestUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class BaseClass {
    public static WebDriver webDriver;
    public static Properties prop;

    public static Logger log;

    public BaseClass(){
        try {
            prop=new Properties();
            FileInputStream fileInputStream=new FileInputStream("C:\\Users\\DELL\\IntelliJIdeaProjects\\Bookswagon\\src\\main\\java\\configurations\\configuration.prop");
            prop.load(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void initialization() {
        String browserName = prop.getProperty("browser");
        if (browserName.equals("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--disable-notifications");
            webDriver = new ChromeDriver(chromeOptions);
        } else if (browserName.equals("firefox")) {
            webDriver = new FirefoxDriver();
        }
        webDriver.get(prop.getProperty("url"));
        webDriver.manage().window().maximize();

        webDriver.manage().deleteAllCookies();
        webDriver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_TIMEOUT, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIMEOUT,TimeUnit.SECONDS);



    }
}


