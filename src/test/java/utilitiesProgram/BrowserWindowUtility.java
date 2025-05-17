package utilitiesProgram;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

//don't run, just use in other runner classes
public class BrowserWindowUtility
{
	public void browserMaximize(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	public void browserMinimize(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	public void browserFullScreen(WebDriver driver)
	{
		driver.manage().window().fullscreen();
	}
	public void browserRelocate(WebDriver driver, int x, int y)
	{
		driver.manage().window().setPosition(new Point(x,y));
	}
	public void browserResize(WebDriver driver, int w, int h)
	{
		driver.manage().window().setSize(new Dimension(w,h));
	}
	public void getBrowserNormalFromFullScreen(WebDriver driver) throws Exception
	{
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.keyRelease(KeyEvent.VK_ESCAPE);
	}
	public void browserRefresh(WebDriver driver)
	{
		driver.navigate().refresh();
	}
	public void browserForward(WebDriver driver) 
	{
		driver.navigate().forward();
	}
	public void browserBack(WebDriver driver) 
	{
		driver.navigate().back();
	}
	public void getNewWindoworTab(WebDriver driver, String type)
	{
		if(type.equalsIgnoreCase("window"))
		{
			driver.switchTo().newWindow(WindowType.WINDOW);
		}
		else if(type.equalsIgnoreCase("tab"))
		{
			driver.switchTo().newWindow(WindowType.TAB);
		}
		else
		{
			throw new RuntimeException("Invalid type");
		}
		
	}
	public void switchToDesiredBrowser(WebDriver driver, String handle)
	{
		driver.switchTo().window(handle);
	}
	public List<String> getAllBrowserWindowHandlesList(WebDriver driver)
	{
		Set<String> s=driver.getWindowHandles();
		List<String> l=new ArrayList<String>(s);
		return(l);
	}
}
