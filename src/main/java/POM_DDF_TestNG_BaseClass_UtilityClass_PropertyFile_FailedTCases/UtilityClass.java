package POM_DDF_TestNG_BaseClass_UtilityClass_PropertyFile_FailedTCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass
{
	
	//fetch data from excel sheet
public static String getTestData(int rowIndex,int columnIndex) throws EncryptedDocumentException, IOException
{

	  FileInputStream file=new FileInputStream("C:\\Users\\Nexas\\eclipse-workspace\\Selenium_Rivision_Maven\\TestData\\DDF.xlsx");
	  Sheet sh = WorkbookFactory.create(file).getSheet("Sheet1");
	  
	  String value = sh.getRow(rowIndex).getCell(columnIndex).getStringCellValue();
	  return value;
}


   //take a screenshot
public static void captureSS(WebDriver driver,int TCID) throws IOException
{
	//FileInputStream file=new FileInputStream("E:\\ScreenShot\\Screenshot\\failedTCID"+TCID+".jpg");
  File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
  File dest=new File("C:\\Users\\Nexas\\eclipse-workspace\\Selenium_Rivision_Maven\\failedTceses"+TCID+".jpg");
  FileHandler.copy(src, dest);
}

public static String getPFData(String key) throws IOException
{
	FileInputStream file=new FileInputStream("C:\\Users\\Nexas\\eclipse-workspace\\Selenium_Rivision_Maven\\PropertFile.properties");
	Properties p=new Properties();
	p.load(file);
	return p.getProperty(key);
}

}
