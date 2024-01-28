package utilities;
import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;

import static actions.BrowserActions.drivers;

public class ScreenshotTaker {
    public void takeScreenShot(String testCaseName){
        var camera =(TakesScreenshot)drivers.get();
        File screenShot =camera.getScreenshotAs(OutputType.FILE);
        try {
            Files.move(screenShot, new File(("resources/screenshots/") +testCaseName+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
