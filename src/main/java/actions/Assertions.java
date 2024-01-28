package actions;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.MyLogger;

import static actions.BrowserActions.drivers;

public class Assertions {
    WebDriver driver;
    MyLogger logger;
    public Assertions(){
        driver = drivers.get();
        logger = new MyLogger();
    }
    public void assertOnURL(String expectedURL){
        Assert.assertEquals(driver.getCurrentUrl(),expectedURL);
    }
    public void throwFailAssertion(){
        Assert.fail();
    }
    public void assertOnElementText(String actual, String expected){
        Assert.assertEquals(actual,expected);
    }
    public void assertStatusCode(Integer expected, Response response){
        Assert.assertEquals(response.statusCode(),expected);
    }
    public void assertKeyEqualsExpectedValue (String key, String expectedValue,
                                              Response response){
        JSONObject body = new JSONObject(response.body().asString());
        Assert.assertEquals(body.get(key).toString(), expectedValue);
        logger.writeMessageInLogFile(String.format("Value in key %s equals expected value of %s",
                key,expectedValue));
    }
}
