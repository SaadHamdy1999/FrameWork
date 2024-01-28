import actions.BrowserActions;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utilities.DataReader;
import utilities.MyLogger;

@Listeners(utilities.Listeners.class)
public class BaseTest {
    String uniqueKey;
    MyLogger logger = new MyLogger();
    @Parameters("browser")
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {
        BrowserActions.setUpDriver(browser);
        uniqueKey = Thread.currentThread().getName();
        logger.writeMessageInLogFile(uniqueKey + "is opened successfully");
        BrowserActions.goToURL("https://demo.nopcommerce.com/");
    }


    @AfterMethod
    public void tearDown(){
        //System.out.println(uniqueKey);
        uniqueKey = Thread.currentThread().getName();
        BrowserActions.tearDown();
        logger.writeMessageInLogFile(uniqueKey + "is closed successfully");

    }
}
