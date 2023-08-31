package Modul1_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import POM.PBLoginPage;

public class PB_LoginPage 
{

    //declation
    @FindBy(xpath="//a[@class='sign-in']") private WebElement signIn;
    
    //intialization
    public PB_LoginPage(WebDriver driver)
    {
  	  PageFactory.initElements(driver, this);
    }

    
    //usage
    public void clickPBLoginPageSignInBtn()
    {
  	  signIn.click();
  	  
    }
}
