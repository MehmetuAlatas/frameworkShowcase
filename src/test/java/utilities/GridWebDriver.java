package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class GridWebDriver {

    protected WebDriver driver;

    {
        try {
            driver = new RemoteWebDriver(new URL("http://192.168.1.103:4444"),new ChromeOptions());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


}
