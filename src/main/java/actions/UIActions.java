package actions;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.MyLogger;

import static actions.BrowserActions.drivers;

public class UIActions {
    WebDriver driver;
    JavascriptExecutor jse;
    Select select;
    Actions actions;
    MyLogger logger;
    public UIActions(String DriverIdentifier)
    {
        driver= drivers.get(DriverIdentifier);
        jse =(JavascriptExecutor)driver;
        actions = new Actions(driver);
        logger = new MyLogger();
    }
    ////
    //////// click on element
    //// clickOnElement(String , )
    public void clickOnElement (By locator){
        try {
            driver.findElement(locator).click();
        }
        catch (Exception e){
            try{
                driver.findElement(locator).submit();

            }
            catch (Exception ex){
                logger.writeErrorInLogFile(ex);

            }
        }

    }
    public void clickOnElement (WebElement element){
        element.click();
    }

    public void clickOnElement (String selector, locatorType locatorType){
       locateElementByENUM(selector, locatorType).click();
    }
    /////
    ////////writing into textbox
    ////
    public void writeInTextBox(By locator, String text){
        try {
            driver.findElement(locator).sendKeys(text);
        }
        catch (Exception e){
            logger.writeErrorInLogFile(e);
        }
    }
    public void writeInTextBox(WebElement element, String text){
        element.sendKeys(text);
    }
    public void writeInTextBox(String selector, locatorType locatorType, String text){
        locateElementByENUM(selector, locatorType).sendKeys(text);
    }
    ////
    ////////scrolling to element
    ////
    public void scrollToElement(WebElement element)
    {
        jse.executeScript("arguments[0].scrollIntoView({behaviour: 'smooth', block: 'center'})",
                element);
    }
    public void scrollToElement(By locator){
        try{
        jse.executeScript("arguments[0].scrollIntoView({behaviour: 'smooth', block: 'center'})",
                driver.findElement(locator));}
        catch (Exception e){
            logger.writeErrorInLogFile(e);
        }
    }
    public void scrollToElement(String selector, locatorType locatorType){
        jse.executeScript("arguments[0].scrollIntoView({behaviour: 'smooth', block: 'center'})",
               locateElementByENUM(selector, locatorType));
    }

    ////
    //////selecting value from dropbox by value
    ////
    public void selectFromDropdownChoiceByValue(WebElement dropDownMenu, String value){
        select = new Select(dropDownMenu);
        select.selectByValue(value);
    }
    public void selectFromDropdownChoiceByValue(By dropdownLocator, String value){
        select = new Select(driver.findElement(dropdownLocator));
        select.selectByValue(value);
    }
    public void selectFromDropdownChoiceByValue(String dropdownSelector,locatorType locatorType,
                                                String value){
        select =new Select(locateElementByENUM(dropdownSelector,locatorType));
        select.selectByValue(value);
    }
    ////
    //////selecting index from dropbox by Index
    ////
    public void selectFromDropdownChoiceByIndex(WebElement dropDownMenu, int index){
        select = new Select(dropDownMenu);
        select.selectByIndex(index);
    }
    public void selectFromDropdownChoiceByIndex(By dropdownLocator, int index){
        select = new Select(driver.findElement(dropdownLocator));
        select.selectByIndex(index);
    }
    public void selectFromDropdownChoiceByIndex(String dropdownSelector,locatorType locatorType,
                                                int index){
        select =new Select(locateElementByENUM(dropdownSelector,locatorType));
        select.selectByIndex(index);
    }

    ////
    //////selecting value from dropbox by visible text
    ////
    public void selectFromDropdownChoiceByVisibleText(WebElement dropDownMenu, String visibleText){
        select = new Select(dropDownMenu);
        select.selectByVisibleText(visibleText);
    }
    public void selectFromDropdownChoiceByVisibleText(By dropdownLocator, String visibleText){
        select = new Select(driver.findElement(dropdownLocator));
        select.selectByVisibleText(visibleText);
    }
    public void selectFromDropdownChoiceByVisibleText(String dropdownSelector,locatorType locatorType,
                                                String visibleText){
        select =new Select(locateElementByENUM(dropdownSelector,locatorType));
        select.selectByVisibleText(visibleText);
    }
    ////
    //////double click
    ////
    public void doubleClickOnElement(WebElement element){
        actions.doubleClick(element).build().perform();
    }
    public void doubleClickOnElement(By locator){
        actions.doubleClick(driver.findElement(locator)).build().perform();
    }
    public void doubleClickOnElement(String selector,locatorType locatorType) {
        actions.doubleClick(locateElementByENUM(selector, locatorType)).build().
                perform();
    }







    private WebElement locateElementByENUM(String selector, locatorType locatorType){
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


    public enum locatorType{
        XPATH,
        ID,
        NAME,
        CSS,
        CLASSNAME,
        LINKTEXT
    }
}

