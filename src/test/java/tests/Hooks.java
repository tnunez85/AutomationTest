package tests;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Hooks {
    public static WebDriver driver;
    public static WebDriverWait wait;
    private static final String WINDOWS_CHROME_DRIVER = "/drivers/chromedriver.exe";
    private static final String MAC_CHROME_DRIVER = "/drivers/2.36/chromedriver.mac";
    private static final String WINDOWS_FIREFOX_DRIVER = "/drivers/gecko/0.21.0/geckodriver.exe";

    @Before
    public void loginPage() {
        String navegador = "chrome";
        String os = System.getProperty("os.name").toLowerCase();

        if (navegador.equals("chrome")) {
            String operatingSystem = System.getProperty("user.dir") + WINDOWS_CHROME_DRIVER;
            if (!os.contains("windows")) {
                operatingSystem = System.getProperty("user.dir") + MAC_CHROME_DRIVER;
            }
            System.setProperty("webdriver.chrome.driver", operatingSystem);
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--start-maximized");
            driver = new ChromeDriver(chromeOptions);
            wait = new WebDriverWait(driver, 25, 200);
        }
        if (navegador.equals("firefox")) {
            String opeSystem = System.getProperty("user.dir") + WINDOWS_FIREFOX_DRIVER;
            System.setProperty("webdriver.gecko.driver", opeSystem);
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("--start-maximized");
            driver = new FirefoxDriver(firefoxOptions);
            wait = new WebDriverWait(driver, 20, 1000);
        }
        System.out.println("This will run in the beginning of Test");
    }

    @After
    public void deleteCookiesAndDestroy() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
            driver = null;
        }
        System.out.println("This will run after Test");
    }

}