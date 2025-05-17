package propertiestestfiles;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilitiesProgram.BrowserWindowUtility;
import utilitiesProgram.PropertiesFileUtility;

public class PFProgram5 {
		
	String pfpath;
	int apivalue;
	int uivalue;
	
	
	//API
	@Test(priority=1)
	public void testAPI() throws Exception
	{
		//config file
		pfpath="C:\\2025\\Batch-269\\IDE-BDD\\org.bofa.cne\\src\\test\\resources\\PropertiesFiles\\config.properties";
	
		//create and submit request
		RequestSpecification req=RestAssured.given();
		req.baseUri(PropertiesFileUtility.getValueFromPropertiesFiles(pfpath, "baseuri"));
		req.basePath(PropertiesFileUtility.getValueFromPropertiesFiles(pfpath, "basepath"));
		req.header("X-RapidAPI-Key",PropertiesFileUtility.getValueFromPropertiesFiles(pfpath, "apikey"));
		req.header("X-RapidAPI-Host",PropertiesFileUtility.getValueFromPropertiesFiles(pfpath, "apihost"));
		//submit request via post method
		Response res=req.get();
		//Display required value in response
		apivalue=res.jsonPath().getInt("scoreCard[1].batTeamDetails.batsmenData.bat_2.runs");
		System.out.println(apivalue);
		
	}
	
	//UI
	@Test(priority=2)
	public void testUI() throws Exception
	{
	//open browser
		RemoteWebDriver  driver=new ChromeDriver();
		driver.get(PropertiesFileUtility.getValueFromPropertiesFiles(pfpath, "url"));
		BrowserWindowUtility browser=new BrowserWindowUtility(); 
		browser.browserMaximize(driver);//maximize browser
		Long m=Long.parseLong(PropertiesFileUtility.getValueFromPropertiesFiles(pfpath, "maxwaittimeinsecs"));
		Long l=Long.parseLong(PropertiesFileUtility.getValueFromPropertiesFiles(pfpath, "intervaltimeinmsecs"));
		FluentWait<RemoteWebDriver> wait=new FluentWait<RemoteWebDriver>(driver);
				wait.withTimeout(Duration.ofSeconds(m));
				wait.pollingEvery(Duration.ofMillis(l));
				//Get UI value
	    String temp =wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//div[@id='innings_2']//div[contains(@class,'cb-scrd-itms')])[2]/div[3]"))).getText();
	    uivalue=Integer.parseInt(temp);
		System.out.println(uivalue);
		//driver.quit();
	}
		
	@Test(priority=3)
		public void e2eTestValidation() throws Exception
		{
		
		//validate or Assertion or verification or compare
		if(apivalue==uivalue)
		{
			Reporter.log("E2E test passed");
		}
		else
		{
			Reporter.log("E2E test failed");
			Assert.fail();
		}
		//	System.out.println("Response");
		//	System.out.println("-----");
		//	res.then().log().all();
	}

}
