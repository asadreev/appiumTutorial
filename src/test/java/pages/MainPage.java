package pages;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class MainPage {


    private AndroidDriver<AndroidElement> driver;

    public MainPage() {
    }

    public MainPage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Open\"]")
    private AndroidElement openMenu;


    public void clickonMenuOpenItem() {
        openMenu.click();
    }


    public void openMenu() {
        clickonMenuOpenItem();
    }


}
