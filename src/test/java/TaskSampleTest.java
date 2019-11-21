import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TaskSampleTest {

    public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;

    //Elements
    String OpenWidget = "//android.widget.ImageButton[@content-desc=\"Open\"]";

    @BeforeMethod
    public void setup () throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel 2 API 27");
        caps.setCapability("udid", "emulator-5554"); //DeviceId from "adb devices" command
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "8.1");
        caps.setCapability("appPackage", "com.tasks.android");
        caps.setCapability("appActivity", "com.tasks.android.activities.MainActivity");
        //caps.setCapability("app", "/Users/admin/Desktop/com.tasks.android_1.34.4.apk");

        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
        wait = new WebDriverWait(driver, 10);
    }


    @Test
    public void basicTest () throws InterruptedException {
        //Click
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(OpenWidget))).click();

        //Click I am searching a job
        //wait.until(ExpectedConditions.visibilityOfElementLocated
          //      (By.id("com.isinolsun.app:id/bluecollar_type_button"))).click();


        //Notification Allow
        //if (driver.findElements(By.id("com.android.packageinstaller:id/permission_allow_button")).size()>0) {
         //   driver.findElements(By.id("com.android.packageinstaller:id/permission_allow_button")).get(0).click();
       // }

        //wait.until(ExpectedConditions.visibilityOfElementLocated
                //(By.xpath(secondNewJob)));
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}