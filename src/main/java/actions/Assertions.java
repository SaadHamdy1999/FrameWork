package actions;

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
}
