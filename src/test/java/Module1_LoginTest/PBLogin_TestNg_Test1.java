package Module1_LoginTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.internal.BaseClassFinder;

import Modul1_Login.PBHomePage;
import Modul1_Login.PBLogout;
import Modul1_Login.PBMobNumberPAge;
import Modul1_Login.PBMyAccountPAge;
import Modul1_Login.PB_LoginPage;
import Modul1_Login.PBmyprofilePage;
import Modul1_Login.PBpwdPAge;
import POM_DDF_TestNG_BaseClass_UtilityClass_PropertyFile_FailedTCases.BaseClass;
import POM_DDF_TestNG_BaseClass_UtilityClass_PropertyFile_FailedTCases.UtilityClass;

public class PBLogin_TestNg_Test1 extends BaseClass
{
	//declare gobally
	 PB_LoginPage login;
	 PBMobNumberPAge mobnum;
	 PBpwdPAge pwd;
	 PBHomePage  home;
	 PBMyAccountPAge myacc;
	 PBmyprofilePage  mypro;
	 PBLogout logout;
	 int   TCID;
	
	
	 
  @BeforeClass
  public void OPenBrowser() throws EncryptedDocumentException, IOException, InterruptedException
  {
	  TCID=101;
	  initialization_browser();
	  
	  //initialize locally
	   login=new  PB_LoginPage(driver);
	   mobnum=new PBMobNumberPAge(driver);
	   pwd=new PBpwdPAge(driver);
	   home=new PBHomePage(driver);
	   myacc=new PBMyAccountPAge (driver);
	   mypro=new PBmyprofilePage (driver);
	   logout=new PBLogout(driver);
  }
  
  @BeforeMethod
  public void loginToApp() throws InterruptedException , EncryptedDocumentException, IOException 
  {
	  login.clickPBLoginPageSignInBtn();
	  Thread.sleep(2000);
	  mobnum.inpPBMobNumberPagemobnum(UtilityClass.getPFData("UN")); 
	  mobnum.clickPBMobNumberloginwithpwd();
	  Thread.sleep(2000);
	  pwd.inpPBpwdPAgePWD(UtilityClass.getPFData("PWD"));
	  pwd.clickPBpwdPAgeSignIn();
	  Thread.sleep(2000);
  }
  
  @Test
  public void VerifyFullname() throws InterruptedException, EncryptedDocumentException, IOException
  {
	  home.openDDOptionPBHomePageMyAcc();
	  Thread.sleep(2000);
	  myacc.clickPBMyAccountPAgeMyProfile();
	
	  mypro.switchTochildwindow();
	  //mypro.VerifyPBMyprofilePagefullnam();
	  
	  String actfullname=mypro.getPBMyprofilePageFullname();
      String expfullname=UtilityClass.getTestData(0, 2);
      
      Assert.assertEquals(actfullname, expfullname,"failed both are difff");
      Thread.sleep(2000);
	    
  }
  
 
 @AfterMethod
 public void logout(ITestResult s1) throws IOException,InterruptedException 
  {

	 if(s1.getStatus()==ITestResult.FAILURE)
	 {
		 UtilityClass.captureSS(driver, TCID);
	 }
	 Thread.sleep(2000);
	  logout.clickPBlogoutlogout();
	  Thread.sleep(2000);
  }

 @AfterClass
 public void closebrowser()
 {
	 driver.close();
 }
  
}
