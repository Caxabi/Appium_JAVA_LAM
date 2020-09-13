import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ajoutContactTest {
	// Déclaration du driver
	private AndroidDriver<AndroidElement> driver;
	// Jeu de données
	String jdd_prenom = "Test_FirstName";
	String jdd_nom = "Test_LastName";
	String jdd_tel = "0601020304";
	String jdd_mail = "testmail@test.com";
	String element;

	@Before
	public void setUp() throws IOException, InterruptedException {
		// Paramètres de l'environnement
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("platformVersion", "8.1");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("appPackage", "com.simplemobiletools.contacts");
		desiredCapabilities.setCapability("appActivity", "com.simplemobiletools.contacts.activities.MainActivity");
		// URL du device
		URL remoteUrl = new URL("http://localhost:4723/wd/hub");
		// Instanciation du driver
		driver = new AndroidDriver<AndroidElement>(remoteUrl, desiredCapabilities);
		// Implicit Wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// Suppression de tous les contacts enregistrés par commande Android Debug Bridge
		// adb shell pm clear com.android.providers.contacts
		ProcessBuilder pb = new ProcessBuilder("adb", "shell", "pm clear", "com.android.providers.contacts");
		Process pc = pb.start();
		pc.waitFor();
	}

	@Test
	public void ajoutContact() {
		// Parametrage Explicit Wait
		WebDriverWait wait = new WebDriverWait(driver, 20);
		// Accepter les 2 alertes "allow changes" et "access to contacts"
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert2 = driver.switchTo().alert();
		alert2.accept();

		// Instanciation de la page des contacts
		PageContacts contacts = new PageContacts(driver);
		contacts.btnAjoutContact.click();

		// Instanciation de la page d'ajout de contacts
		PageNouveauContact nouveauContact = new PageNouveauContact(driver);

		// Saisie des informations du nouveau contact
		SocleTechnique.renseignerChamps(nouveauContact.contact_first_name, jdd_prenom);
		SocleTechnique.renseignerChamps(nouveauContact.contact_surname, jdd_nom);
		SocleTechnique.renseignerChamps(nouveauContact.contact_number, jdd_tel);
		SocleTechnique.renseignerChamps(nouveauContact.contact_email, jdd_mail);

		// Sauvegarde du nouveau contact et affichage de la page des contacts
		nouveauContact.btn_save.click();
		contacts = new PageContacts(driver);

		// Affichage de la fiche du contact Créé
		contacts.contact_name.click();
		PageFicheContact ficheContact = new PageFicheContact(driver);

		// Assertions sur le jeu de données
		assertEquals(jdd_prenom, ficheContact.contact_first_name.getText());
		assertEquals(jdd_nom, ficheContact.contact_surname.getText());
		assertEquals(jdd_tel, ficheContact.contact_number.getText());
		assertEquals(jdd_mail, ficheContact.contact_email.getText());

	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
