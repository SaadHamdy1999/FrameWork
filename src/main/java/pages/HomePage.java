package pages;

import junit.framework.Assert;

public class HomePage extends BasePage{
    public HomePage() {
        super();
    }
    public void clickOnRegistrationLink(){
        readLocator("RegisterLink");
        uiActions.clickOnElement(locatorValueAndType[0],
                convertTypefromStringToENUM(locatorValueAndType[1]));
        try {
            assertions.assertOnURL("https://demo.nopcommerce.com/register?returnUrl=%2F");
        }
        catch(Exception e){
            logger.writeErrorInLogFile(e);
            assertions.throwFailAssertion();
        }
    }
}
