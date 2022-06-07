package waits;

import actions.UIActions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class WaitClass {
    Wait<WebDriver>wait;
    WebDriver driver;
    public WaitClass(WebDriver driver){
        this.driver= driver;
    }
    public void WaitUntil(By locator, int WaitDuration,
                          int checkTime, EnumExpectedConditions expectedConditions){
        wait = new FluentWait<WebDriver>(driver).
                withTimeout(Duration.ofSeconds((long)WaitDuration)).
                pollingEvery(Duration.ofSeconds((long)checkTime))
                .ignoring(NoSuchElementException.class);
        waitingCondition(locator,expectedConditions);

    }
    public void WaitUntil(String selector, UIActions.locatorType locatorType, int WaitDuration,
                          int checkTime, EnumExpectedConditions expectedConditions){
        wait = new FluentWait<WebDriver>(driver).
                withTimeout(Duration.ofSeconds((long)WaitDuration)).
                pollingEvery(Duration.ofSeconds((long)checkTime))
                .ignoring(NoSuchElementException.class);
        waitingCondition(GetByfromSelector(selector,locatorType),expectedConditions);

    }
    private By GetByfromSelector(String selector, UIActions.locatorType locatorType){
        switch (locatorType){
            case CLASSNAME -> {
                return  By.className(selector);
            }
            case XPATH -> {
                return By.xpath(selector);
            }
            case NAME -> {
                return By.name(selector);
            }
            case CSS -> {
                return By.cssSelector(selector);
            }
            case ID -> {
                return By.id(selector);
            }
        }
        return By.id(selector);
    }
    private void waitingCondition(By locator, EnumExpectedConditions expectedConditions){
        switch (expectedConditions){
            case ElementIsPresent -> {
                wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            }
            case ElementIsClickable -> {
                wait.until(ExpectedConditions.elementToBeClickable(locator));
            }
            case ElementIsVisible -> {
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

            }
        }
    }



    enum EnumExpectedConditions{
        ElementIsPresent,
        ElementIsClickable,
        ElementIsVisible
        }
}
