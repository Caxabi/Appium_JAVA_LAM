import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PageNouveauContact {
	private AndroidDriver<AndroidElement> driver;
	public PageNouveauContact(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.simplemobiletools.contacts:id/contact_first_name")
	MobileElement contact_first_name;
	
	@AndroidFindBy(id="com.simplemobiletools.contacts:id/contact_surname")
	MobileElement contact_surname;
	
	@AndroidFindBy(id="com.simplemobiletools.contacts:id/contact_number")
	MobileElement contact_number;
	
	@AndroidFindBy(id="com.simplemobiletools.contacts:id/contact_email")
	MobileElement contact_email;
	
	@AndroidFindBy(id="com.simplemobiletools.contacts:id/save")
	MobileElement btn_save;
}