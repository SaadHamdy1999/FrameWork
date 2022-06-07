import actions.BrowserActions;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utilities.DataReader;
import utilities.MyLogger;


public class BaseTest {
    String uniqueKey;
    MyLogger logger = new MyLogger();
    @Parameters("browser")
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser, ITestContext cxt) {
        uniqueKey = cxt.getAllTestMethods()[0].getTestClass().getName();
        //System.out.println(uniqueKey);
        BrowserActions.setUpDriver(browser,uniqueKey);
        logger.writeMessageInLogFile(uniqueKey + "is opened successfully");

        BrowserActions.goToURL("https://demo.nopcommerce.com/",uniqueKey);

    }


    @AfterMethod
    public void tearDown(ITestContext cxt){
        //System.out.println(uniqueKey);
        BrowserActions.tearDown(uniqueKey);
        logger.writeMessageInLogFile(uniqueKey + "is closed successfully");

    }
}
