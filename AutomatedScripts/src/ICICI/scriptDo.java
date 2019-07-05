package ICICI;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class scriptDo extends driverDo{
	WebDriver newdriver;
	
	@Test
	@Parameters({"browser"})
	public void iciciemi(String browser) throws Exception
	{		
		String Url;
		if (browser.equals("chrome"))
		{
			newdriver=setchrome();
		}
		try {
			Url=getUrl();
			newdriver.get(Url);
			newdriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			newdriver.manage().window().maximize();
			
			WebElement seleLang=newdriver.findElement(By.xpath("//div[@class='desktop-only']//select[@name='category']"));
			WebElement emi = newdriver.findElement(By.xpath("//ul[@class='lhsnavigation']//*[contains(text(),'Personal Loan EMI Calculator')]"));
			emi.click();
			newdriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			WebElement frame1=newdriver.findElement(By.id("paymframe"));
			newdriver.switchTo().frame(frame1);
			newdriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			WebElement LoanAmt=newdriver.findElement(By.id("loanAmount"));
			LoanAmt.click();
			LoanAmt.clear();
			LoanAmt.sendKeys("",Keys.BACK_SPACE);
			LoanAmt.sendKeys("60000");	
			
			WebElement intr=newdriver.findElement(By.id("interestRate"));
			intr.click();
			intr.clear();
			intr.sendKeys("13.4");
			
			WebElement term=newdriver.findElement(By.id("loanTerm"));
			term.click();
			term.clear();
			term.sendKeys("23",Keys.TAB);
			
			WebElement emival=newdriver.findElement(By.xpath("//span[@id='monthlyRepayment']"));
			String result=emival.getText();
			System.out.println(result);
			//WebElement origframe=newdriver.findElement(By.xpath("//iframe[@height='0']"));
			
					
			driver.switchTo().defaultContent();
			//driver.switchTo().frame(origframe);
			
			
			
			//((JavascriptExecutor) newdriver).executeScript("arguments[0].scrollIntoView(true);", home);
			System.out.println("here");
//			Actions actions = new Actions(newdriver);
//			actions.moveToElement(LoanAmt);
//			actions.perform();
//			Thread.sleep(500);
			JavascriptExecutor js= ((JavascriptExecutor) newdriver);
			js.executeScript("scroll(0,400)");
			Thread.sleep(2000);
			js.executeScript("window.scrollTo(0,-document.body.scrollHeight);");
			newdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebElement home=newdriver.findElement(By.xpath("//div[2]//*[@href='/'][1]"));
			home.click();
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	
	}

}
