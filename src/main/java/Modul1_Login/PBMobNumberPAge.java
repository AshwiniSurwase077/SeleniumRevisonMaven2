package Modul1_Login;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import POM.PBMobNumberPage;

public class PBMobNumberPAge 
{

	@FindBy(xpath="(//input[@type='number'])[2]")private WebElement mobnum;
	@FindBy(xpath="(//span[text()='Sign in with Password'])[2]")private WebElement loginwithpwd;
	
	public PBMobNumberPAge(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	
	public void inpPBMobNumberPagemobnum(String mobileNumber)
	{
		mobnum.sendKeys(mobileNumber);
	}
	
	public void clickPBMobNumberloginwithpwd()
	{
		loginwithpwd.click();
	}
}
