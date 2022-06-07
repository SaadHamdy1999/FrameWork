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
    public Assertions(String driverUniqueIdentifier){
        driver = drivers.get(driverUniqueIdentifier);
        logger = new MyLogger();
    }
    public void assertOnURL(String expectedURL){
        Assert.assertEquals(driver.getCurrentUrl(),expectedURL);
    }
    public void throwFailAssertion(){
        Assert.fail();
    }
    public void assertOnElementText(String selector, UIActions.locatorType locatorType, String expected){
        Assert.assertEquals(locateElementByENUM(selector,locatorType).getText(),expected);
    }



    private WebElement locateElementByENUM(String selector, UIActions.locatorType locatorType){
        WebElement element= null;
        try{
            switch (locatorType)
            {
                case ID -> {
                    element = driver.findElement(By.id(selector));
                }
                case CSS -> {
                    element=  driver.findElement(By.cssSelector(selector));
                }
                case NAME -> {
                    element= driver.findElement(By.name(selector));
                }
                case XPATH -> {
                    element=driver.findElement(By.xpath(selector));
                }
                case CLASSNAME -> {
                    element= driver.findElement(By.className(selector));
                }
                case LINKTEXT -> {
                    element= driver.findElement(By.linkText(selector));
                }
            }
        }
        catch (Exception e){
            logger.writeErrorInLogFile(e);
        }

        return element;
    }
}
