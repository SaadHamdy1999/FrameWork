package actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.util.HashMap;
import java.util.Map;

public class BrowserActions {

    public static Map <String, WebDriver> drivers = new HashMap<>();
    public static void setUpDriver(String DriverType, String DriverIdentifier) {
        switch (DriverType.toLowerCase()) {
            case "chrome" -> {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
                drivers.put(DriverIdentifier, new ChromeDriver());
            }
            case "firefox" -> {
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
                drivers.put(DriverIdentifier, new FirefoxDriver());
            }
            case "ie" -> {
                System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/drivers/IEDriverServer.exe");
                drivers.put(DriverIdentifier, new InternetExplorerDriver());
            }
        }
        drivers.get(DriverIdentifier).manage().window().maximize();
    }
    public static void goToURL(String URL, String DriverIdentifier){
        drivers.get(DriverIdentifier).get(URL);
    }
    public static void tearDown(String DriverIdentifier){
        drivers.get(DriverIdentifier).quit();
        drivers.remove(DriverIdentifier);
    }

}
