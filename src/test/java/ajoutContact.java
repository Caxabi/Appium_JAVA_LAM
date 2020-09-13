import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Alert;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ajoutContact {
	
	
	//static Logger logger = LoggerFactory.getLogger(PrixPanierTest.class);
	AndroidDriver driver;
	String jdd_nom = "Test_FirstName";
	String jdd_prenom = "Test_LastName";
	String jdd_tel = "0601020304";
	String jdd_mail = "testmail@test.com";
	String element;

	@Before
	public void setUp() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("platformVersion", "8.1");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("appPackage", "com.simplemobiletools.contacts");
		desiredCapabilities.setCapability("appActivity", "com.simplemobiletools.contacts.activities.MainActivity");
		URL remoteUrl = new URL("http://localhost:4723/wd/hub");
		driver = new AndroidDriver(remoteUrl, desiredCapabilities);
		//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test
	public void sampleTest() {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert2 = driver.switchTo().alert();
		alert2.accept();
		
		element = "com.simplemobiletools.contacts:id/fragment_fab";
		SocleTechnique.waitForElement(driver, element);
		MobileElement btnAllow3 = (MobileElement) driver.findElementById(element);
		btnAllow3.click();
		
		element = "com.simplemobiletools.contacts:id/contact_first_name";
		SocleTechnique.waitForElement(driver, element);
		MobileElement contact_first_name = (MobileElement) driver.findElementById(element);
		SocleTechnique.renseignerChamps(contact_first_name, jdd_nom);
		
		element = "com.simplemobiletools.contacts:id/contact_surname";
		SocleTechnique.waitForElement(driver, element);
		MobileElement contact_surname = (MobileElement) driver.findElementById(element);
		SocleTechnique.renseignerChamps(contact_surname, jdd_prenom);
		
		element = "com.simplemobiletools.contacts:id/contact_number";
		SocleTechnique.waitForElement(driver, element);
		MobileElement contact_number = (MobileElement) driver.findElementById(element);
		SocleTechnique.renseignerChamps(contact_number, jdd_tel);
		
		element = "com.simplemobiletools.contacts:id/contact_email";
		SocleTechnique.waitForElement(driver, element);
		MobileElement contact_email = (MobileElement) driver.findElementById(element);
		SocleTechnique.renseignerChamps(contact_email, jdd_mail);
		
		MobileElement btn_Save = (MobileElement) driver.findElementByAccessibilityId("Save");
		btn_Save.click();
		
		element = "com.simplemobiletools.contacts:id/contact_name";
		SocleTechnique.waitForElement(driver, element);
		MobileElement contact_name = (MobileElement) driver.findElementById(element);
		contact_name.click();
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
