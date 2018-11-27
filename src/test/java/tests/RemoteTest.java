package tests;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;


public class RemoteTest {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @Before

    public void chromeTesting() throws Exception {
        DesiredCapabilities chromeCaps = new DesiredCapabilities();
        chromeCaps.setCapability("platform", "LINUX");
        chromeCaps.setCapability("version", "");
        chromeCaps.setCapability("browserName", "chrome");

        driver = new RemoteWebDriver(new URL("http://192.168.50.5:4444/wd/hub"), chromeCaps);
        wait = new WebDriverWait(driver, 30, 1000);

        System.out.println("Your Chrome test is being loaded...");
    }

 // @Before
 // public void firefoxTesting() throws Exception {
 //     DesiredCapabilities firefoxCaps = new DesiredCapabilities();
 //     firefoxCaps.setCapability("platform", "LINUX");
 //     firefoxCaps.setCapability("version", "");
 //     firefoxCaps.setCapability("browserName", "firefox");
 //     firefoxCaps.setCapability("marionette", true);

 //     driver = new RemoteWebDriver(new URL("http://192.168.50.5:4444/wd/hub"), firefoxCaps);
 //     wait = new WebDriverWait(driver, 50, 5000);

 //     System.out.println("Your Firefox test is being loaded...");
 // }


    @After
    public void deleteCookiesAndDestroy() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
            driver = null;
        }
        System.out.println("This will run after each Test");
    }
}
