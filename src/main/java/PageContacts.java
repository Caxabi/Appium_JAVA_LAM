import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PageContacts {
	private AndroidDriver<AndroidElement> driver;
	public PageContacts(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.simplemobiletools.contacts:id/contact_name")
	MobileElement contact_name;
	
	@AndroidFindBy(id="com.simplemobiletools.contacts:id/fragment_fab")
	MobileElement btnAjoutContact;
}