
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;

public final class SocleTechnique {

	// public static void waitForElement(WebDriver driver, WebElement element) {
	// WebDriverWait wait = new WebDriverWait(driver,20);
	// wait.until(ExpectedConditions.visibilityOf(element));
	// //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("XXXX")));
	// }

	public static void waitForElement(WebDriver driver, String element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element)));
	}

	public static void renseignerChamps(WebElement we, String s) {
		we.clear();
		we.sendKeys(s);
	}

	public static boolean isElementPresent(WebElement we, Logger log) {
		boolean resultat = we.isDisplayed();
		if (we.isDisplayed()) {
			log.error(we.getText() + " présent");

		} else {
			log.error(we.getText() + " absent");
		}
		return resultat;
	}

}
