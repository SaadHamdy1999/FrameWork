package utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class MyLogger {
    Logger logger = Logger.getLogger(MyLogger.class);
    public MyLogger(){
        PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\main\\resources\\log4j.properties");
    }

    public void writeMessageInLogFile(String message){
        logger.debug(message);
    }
    public void writeErrorInLogFile(Exception e) {
        logger.error(e.getLocalizedMessage());
    }



}
