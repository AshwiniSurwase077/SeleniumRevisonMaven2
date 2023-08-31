package Modul1_Login;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBmyprofilePage 
{

@FindBy(xpath="//input[@name='personName']") private WebElement fullname;
WebDriver driver;

public PBmyprofilePage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
	this.driver= driver;
}

public  void switchTochildwindow()
{
	Set<String> allIds = driver.getWindowHandles();
	ArrayList<String> al=new ArrayList(allIds);
	driver.switchTo().window(al.get(1));
}

public String getPBMyprofilePageFullname()
{
	String actfullname = fullname.getAttribute("value");
	return actfullname;
}
}
