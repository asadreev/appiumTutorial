public class IosTest {


    import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
    public class AppTest {
        public static URL url;
        public static DesiredCapabilities capabilities;
        public static IOSDriver<IOSElement> driver;

        //1
        @BeforeSuite
        public void setupAppium() throws MalformedURLException {
            //2
            final String URL_STRING = "http://127.0.0.1:4723/wd/hub";
            url = new URL(URL_STRING);

            //3
            capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone Simulator");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.4");
            capabilities.setCapability(MobileCapabilityType.APP, "[PATH_TO_YOUR_.APP_FILE_THAT_YOU_COMPILED]");
            capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
            capabilities.setCapability("useNewWDA", false);
            //4
            driver = new IOSDriver<IOSElement>(url, capabilities);
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            driver.resetApp();
        }
        //5
        @AfterSuite
        public void uninstallApp() throws InterruptedException {
            driver.removeApp("com.bzytan.appiumeveryday");
        }
        //6
        @Test (enabled=true) public void myFirstTest() throws InterruptedException {
            driver.resetApp();
        }
}
