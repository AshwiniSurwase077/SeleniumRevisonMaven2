package POM_DDF_TestNG_BaseClass_UtilityClass_PropertyFile_FailedTCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass  
{
	 public WebDriver driver;
public void initialization_browser() throws InterruptedException, IOException
{
	
		
	  driver=new ChromeDriver();
	  driver.get(UtilityClass.getPFData("URL"));
	  driver.manage(). timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.manage().window().maximize();
	  Thread.sleep(2000);
}
}
