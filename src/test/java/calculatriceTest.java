import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

public class calculatriceTest {

	private AndroidDriver driver;

	@Before
	public void setUp() throws MalformedURLException {
		// Paramètres de l'environnement
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("platformVersion", "8.1");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
		desiredCapabilities.setCapability("appActivity", ".Calculator");
		// URL du device
		URL remoteUrl = new URL("http://localhost:4723/wd/hub");
		// Instanciation du driver
		driver = new AndroidDriver<AndroidElement>(remoteUrl, desiredCapabilities);
		// Implicit Wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void sampleTest() {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		MobileElement digit_4 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_4");
		digit_4.click();
		MobileElement btn_multiply = (MobileElement) driver.findElementByAccessibilityId("multiply");
		btn_multiply.click();
		MobileElement digit_3 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_3");
		digit_3.click();
		MobileElement btn_equals = (MobileElement) driver.findElementByAccessibilityId("equals");
		btn_equals.click();
		String resultat = driver.findElementById("com.android.calculator2:id/result").getText();
		assertEquals("12", resultat);
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
