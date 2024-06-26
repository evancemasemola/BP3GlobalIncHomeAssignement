package utilitis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerClass {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void initializeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
