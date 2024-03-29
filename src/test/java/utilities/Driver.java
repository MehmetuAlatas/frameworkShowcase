package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.URL;

public class Driver {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private Driver() {
    }

    public static WebDriver getDriver() {
        //if this thread doesn't have a web driver yet - create it and add to pool
        if (driver.get() == null) {
            System.out.println("TRYING TO CREATE DRIVER");
            // this line will tell which browser should open based on the value from properties file
            String browserParamFromEnv = System.getProperty("browser");
            String browser = browserParamFromEnv == null ? ConfigurationReader.getProperty("browser") : browserParamFromEnv;
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver.set(new ChromeDriver());
                    break;
                case "chrome_headless":
                    WebDriverManager.chromedriver().setup();
                    driver.set(new ChromeDriver(new ChromeOptions().setHeadless(true)));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver.set(new FirefoxDriver());
                    break;
//                case "opera":
//                    WebDriverManager.operadriver().setup();
//                    driver.set(new OperaDriver());
//                    break;
                case "firefox_headless":
                    WebDriverManager.firefoxdriver().setup();
                    driver.set(new FirefoxDriver(new FirefoxOptions().setHeadless(true)));
                    break;
                case "ie":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows")) {
                        throw new WebDriverException("Your OS doesn't support Internet Explorer");
                    }
                    WebDriverManager.iedriver().setup();
                    driver.set(new InternetExplorerDriver());
                    break;
                case "edge":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows")) {
                        throw new WebDriverException("Your OS doesn't support Edge");
                    }
                    WebDriverManager.edgedriver().setup();
                    driver.set(new EdgeDriver());
                    break;
                case "safari":
                    if (!System.getProperty("os.name").toLowerCase().contains("mac")) {
                        throw new WebDriverException("Your OS doesn't support Safari");
                    }
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driver.set(new SafariDriver());
                    break;

//                case "remote_chrome":
//                    try {
//                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//                        desiredCapabilities.setBrowserName(BrowserType.CHROME);
//                        desiredCapabilities.setCapability("platform", Platform.ANY);
//                        driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), desiredCapabilities));
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                    break;
//                case "remote_firefox":
//                    try {
//                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//                        desiredCapabilities.setBrowserName(BrowserType.FIREFOX);
//                        desiredCapabilities.setCapability("platform", Platform.ANY);
//                        driver.set(new RemoteWebDriver(new URL("http://ec2-3-88-210-43.compute-1.amazonaws.com:4444/wd/hub"), desiredCapabilities));
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                    break;
            }
        }
        //return corresponded to thread id webdriver object
        driver.get().manage().window().maximize();
        return driver.get();

    }
    public static void close() {
        driver.get().quit();
        driver.remove();
    }
}
