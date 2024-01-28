package actions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import java.util.HashMap;
import java.util.Map;

public class BrowserActions {

    public static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();
    public static ThreadLocal<ApiActions> apiHandler= new ThreadLocal<>();
    public static void setUpDriver(String DriverType) {
        switch (DriverType.toLowerCase()) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                drivers.set(new ChromeDriver(options));
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                drivers.set( new FirefoxDriver());
            }
            case "edge" -> {
                WebDriverManager.edgedriver().setup();
                drivers.set( new EdgeDriver());
            }
        }
        apiHandler.set(new ApiActions());
        drivers.get().manage().window().maximize();
    }
    public static void goToURL(String URL){
        drivers.get().get(URL);
    }
    public static void tearDown(){
        drivers.get().quit();
        drivers.remove();
    }

}
