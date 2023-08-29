import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.opera.OperaOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ConfigurationWebDriver {
    public static WebDriver initChromeDriver() throws IOException {
        WebDriverManager.chromedriver().setup();
        FileInputStream propFile =
                new FileInputStream("test.properties");
        Properties p =
                new Properties(System.getProperties());
        p.load(propFile);
        String driverPath = p.getProperty("chromedriver");
        System.setProperty("webdriver.chrome.driver", driverPath);
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver initFirefoxDriver() throws IOException {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("capability.policy.default.Window.frameElement", "allAccess");
        FileInputStream propFile =
                new FileInputStream("test.properties");
        Properties p =
                new Properties(System.getProperties());
        p.load(propFile);
        String driverPath = p.getProperty("geckodriver");
        System.clearProperty("webdriver.chrome.driver");
        System.setProperty("webdriver.gecko.driver", driverPath);
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver initYandexDriver() throws IOException {
        //ChromeOptions options = new ChromeOptions();
        FileInputStream propFile =
                new FileInputStream("test.properties");
        Properties p =
                new Properties(System.getProperties());
        p.load(propFile);
        String driverPath = p.getProperty("yandexdriver");
        System.clearProperty("webdriver.chrome.driver");
        System.setProperty("webdriver.chrome.driver", driverPath);
       // options.setBinary(binaryPath);
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver getDriverByDriverType(DriverType driverType) throws IOException {
        if (driverType == DriverType.Firefox) {
            return initFirefoxDriver();
        }
        if (driverType == DriverType.Yandex){
            return initYandexDriver();
        }
        else {
            return initChromeDriver();
        }
    }
}
