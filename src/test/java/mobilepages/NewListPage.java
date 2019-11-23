package mobilepages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;

public class NewListPage extends MainPage {

    private AndroidDriver<AndroidElement> driver;


    public NewListPage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @AndroidFindBy(id = "com.tasks.android:id/task_list_name")
    private AndroidElement newListName;

    @AndroidFindBy(id = "com.tasks.android:id/save")
    private AndroidElement saveList;


    public void createNewList(String listName) {
        newListName.sendKeys(listName+"\n");
        //driver.sendKeyEvent(Keys.ENTER);
        //driver.pressKeyCode(AndroidKeyCode.ENTER);
        saveList.click();
    }


}
