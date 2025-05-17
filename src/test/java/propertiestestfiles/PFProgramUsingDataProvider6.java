package propertiestestfiles;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilitiesProgram.BrowserWindowUtility;
import utilitiesProgram.PropertiesFileUtility;

public class PFProgramUsingDataProvider6 {
		
	String pfpath;
	int apivalue;
	int uivalue;
   
	
    @DataProvider(name="myTestData")
    public Object[][] method()
    {
    	
    	Object[][] x= {
    				{"89738","lsg-vs-rcb-15th-match-indian-premier-league-2024",1,2},
    			{"89749","gt-vs-pbks-17th-match-indian-premier-league-2024",2,3}
    	};
    	return(x);
    }
	
	@Test(dataProvider="myTestData")
	public void e2etest(String matchid,String match,int innings,int batsman) throws Exception
	{
//Step2 :update properties files
		pfpath="C:\\2025\\Batch-269\\IDE-BDD\\org.bofa.cne\\src\\test\\resources\\PropertiesFiles\\config.properties";
	    String[] pnames= {"url","basepath"};
		String[] pvalues= {"https://www.cricbuzz.com/live-cricket-scorecard/"+matchid+"/"+match,"mcenter/v1/"+matchid+"/hscard"};
		PropertiesFileUtility.updatePropertiesFiles(pfpath, pnames, pvalues);
	
//Step3 :APIcreate and submit request
	
		RequestSpecification req=RestAssured.given();
		req.baseUri(PropertiesFileUtility.getValueFromPropertiesFiles(pfpath, "baseuri"));
		req.basePath(PropertiesFileUtility.getValueFromPropertiesFiles(pfpath, "basepath"));
		req.header("X-RapidAPI-Key",PropertiesFileUtility.getValueFromPropertiesFiles(pfpath, "apikey"));
		req.header("X-RapidAPI-Host",PropertiesFileUtility.getValueFromPropertiesFiles(pfpath, "apihost"));
		//submit request via post method
		Response res=req.get();
	//	Reporter.log(res.body().asPrettyString());
		//Display required value in response body
		apivalue=res.jsonPath().getInt("scoreCard["+(innings-1)+"].batTeamDetails.batsmenData.bat_"+batsman+".runs");
		System.out.println(apivalue);
	
	 //Step4  :Open browser
		RemoteWebDriver driver=new ChromeDriver();
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
				By.xpath("(//div[@id='innings_"+innings+"']//div[contains(@class,'cb-scrd-itms')])["+batsman+"]/div[3]"))).getText();
	    uivalue=Integer.parseInt(temp);
		System.out.println(uivalue);
	
	
//Step5 : validate or Assertion or verification or compare
		SimpleDateFormat sf= new SimpleDateFormat("dd-MMM-yyyy-hh-mm-ss-SSS");//capture screeshot.
		Date dt= new Date();
		File screenshot = driver.getScreenshotAs(OutputType.FILE);
		File fp = new File("src/test/resources/"+sf.format(dt)+".png");
		FileHandler.copy(screenshot, fp);
		
		if(apivalue==uivalue)
		{
			Reporter.log("E2E test passed"+matchid);
			//add screenshot to Reporter output section in index.html file
			Reporter.log(
					"<a href=\""+fp.getAbsolutePath()+"\"><img src=\""+fp.getAbsolutePath()+"\" height=\"100\" width=\"100\"/></a>");
		}
		else
		{
			Reporter.log("E2E test failed"+matchid);
			//add screenshot to Reporter output section in index.html file
		Reporter.log(
				"<a href=\""+fp.getAbsolutePath()+"\"><img src=\""+fp.getAbsolutePath()+"\" height=\"100\" width=\"100\"/></a>");
			Assert.fail();
		} 
		
		driver.quit();
	}
		//	System.out.println("Response");
		//	System.out.println("-----");
		//	res.then().log().all();
	}


