package utilities;

import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.UUID;

public class Listeners implements ITestListener {
    ScreenshotTaker screenshotTaker = new ScreenshotTaker();
    @Override
    public void onTestFailure(ITestResult result) {
        screenshotTaker.takeScreenShot(result.getMethod().getMethodName() + UUID.randomUUID());
        ITestListener.super.onTestFailure(result);
    }
}
