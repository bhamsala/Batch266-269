package propertiestestfiles;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import utilitiesProgram.BrowserWindowUtility;
import utilitiesProgram.PropertiesFileUtility;

public class PFProgram4 {

	public static void main(String[] args) throws Exception
	{
		
		String pfpath="C:\\2025\\Batch-269\\IDE-BDD\\org.bofa.cne\\src\\test\\resources\\PropertiesFiles\\config.properties";
		RemoteWebDriver driver=new ChromeDriver();
		driver.get(PropertiesFileUtility.getValueFromPropertiesFiles(pfpath, "url"));
		BrowserWindowUtility browser=new BrowserWindowUtility();
		browser.browserMaximize(driver);
		Long m=Long.parseLong(PropertiesFileUtility.getValueFromPropertiesFiles(pfpath, "maxwaittimeinsecs"));
		Long l=Long.parseLong(PropertiesFileUtility.getValueFromPropertiesFiles(pfpath, "intervaltimeinmsecs"));
		FluentWait<RemoteWebDriver> wait=new FluentWait<RemoteWebDriver>(driver);
				wait.withTimeout(Duration.ofSeconds(m));
				wait.pollingEvery(Duration.ofMillis(l));
		String uivalue=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//div[@id='innings_2']//div[contains(@class,'cb-scrd-itms')])[2]/div[3]"))).getText();
		System.out.println(uivalue);
		driver.quit();
	}

}
