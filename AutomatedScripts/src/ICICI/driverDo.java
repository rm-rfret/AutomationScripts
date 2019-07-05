package ICICI;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class driverDo {
	WebDriver driver;
	
	public WebDriver setchrome()
	{		
		System.setProperty("webdriver.chrome.driver","D:\\programfiles\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		return driver;
	}
	public WebDriver fireFox()
	{
		System.setProperty("webdriver.gecko.driver", "D:\\programfiles\\chromedriver_win32\\gecko.exe");
		driver=new FirefoxDriver();
		return driver;
	}
	public String getUrl() throws Exception
	{
		Properties prop=null;
		try
		{
			InputStream file=new FileInputStream("config.properties");
			prop=new Properties();
			prop.load(file);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return prop.getProperty("Url1");
	}

}
