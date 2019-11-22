package mobilepages;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import java.util.Iterator;

import java.util.List;
import java.util.ArrayList;


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

    @AndroidFindBy(id = "com.tasks.android:id/design_navigation_view")
    private AndroidElement navListsView;


    @AndroidFindBy(id = "design_menu_item_text")
    private List<AndroidElement> listsMenuItems;


    public void openMenu() {
        openMenu.click();
        navListsView.isDisplayed();
    }


    public List <String> getLabelsList() {

        List<String> labelsList = new ArrayList<String>();



        Iterator<AndroidElement> listIterator = listsMenuItems.iterator();
        		while (listIterator.hasNext()) {

            	 labelsList.add(listIterator.next().getText());

        		}



        return labelsList;
    }


}
