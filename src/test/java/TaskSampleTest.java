import com.google.common.collect.ImmutableList;
import io.appium.java_client.android.AndroidDriver;
import mobilepages.ListDetailsPage;
import mobilepages.MainPage;
import mobilepages.NewListPage;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class TaskSampleTest {

    public AndroidDriver driver;

    public static final String appPackageName = "com.tasks.android";
    public static final String appActivityName = "com.tasks.android.activities.MainActivity";


    @BeforeMethod
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel 2 API 27");
        caps.setCapability("udid", "emulator-5554");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "8.1");
        caps.setCapability("appPackage", appPackageName);
        caps.setCapability("appActivity", appActivityName);

        // Initialize driver

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        //driver.resetApp();
    }


    @Test(description = "Test menu items when no list exists")
    public void checkMenuItemsNoList() throws InterruptedException {

        List<String> expectedLabelsList = ImmutableList.of("New List", "Donate", "Help", "Settings");

        MainPage mainPage = new MainPage(driver);
        mainPage.openMenu();
        Assert.assertEquals(mainPage.getLabelsList(), expectedLabelsList);

    }

    @Test(description = "Test menu items when there is at least one list")
    public void checkmenuItems() throws InterruptedException {
        List<String> expectedLabelsList = ImmutableList.of("New List", "New Filtered List", "Recorder Tasks List", "Edit List", "Deleted Items", "Donate", "Help", "Settings");

        MainPage mainPage = new MainPage(driver);
        mainPage.openMenu();
        NewListPage newlist = new NewListPage(driver);
        newlist.createNewList("Test List 123");
        ListDetailsPage listdetailsPage = new ListDetailsPage(driver);
        listdetailsPage.openMenu();
        Assert.assertEquals(listdetailsPage.getLabelsList(), expectedLabelsList);
    }


    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
