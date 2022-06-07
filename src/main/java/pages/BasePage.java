package pages;

import actions.Assertions;
import actions.UIActions;
import utilities.DataReader;
import utilities.MyLogger;

import java.io.IOException;

public class BasePage {


    String[] locatorValueAndType;
    UIActions uiActions;
    Assertions assertions;
    MyLogger logger;
    public BasePage(String driverUniqueIdentifier)
    {
        uiActions = new UIActions(driverUniqueIdentifier);
        assertions = new Assertions(driverUniqueIdentifier);
        logger = new MyLogger();
    }
    protected void readLocator(String name){
        DataReader reader = new DataReader();
        locatorValueAndType = reader.readLocatorsFromJsonFile(name);
        }

        protected UIActions.locatorType convertTypefromStringToENUM(String type){
        if (type.equalsIgnoreCase("xpath")){
            return UIActions.locatorType.XPATH;
        }else if(type.equalsIgnoreCase("id")){
            return UIActions.locatorType.ID;
        }else if(type.equalsIgnoreCase("name")){
            return UIActions.locatorType.NAME;
        }else if(type.equalsIgnoreCase("classname")){
            return UIActions.locatorType.CLASSNAME;
        }else if(type.equalsIgnoreCase("css")){
            return UIActions.locatorType.CSS;
        }else if(type.equalsIgnoreCase("linktext")){
            return UIActions.locatorType.LINKTEXT;
        }
            try {
                throw new IOException("the type of locator "+ locatorValueAndType[0]+"is written incorrectly");
            } catch (IOException e) {
                logger.writeErrorInLogFile(e);
            }
            return null;
        }
}
