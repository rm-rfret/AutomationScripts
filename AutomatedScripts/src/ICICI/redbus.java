package ICICI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class redbus extends driverDo{

	
	WebDriver driver;
	@Test
	public void redlogin()
	{
		String Url="https://www.redbus.in";
		driver=setchrome();
		driver.get(Url);
		driver.findElement(By.xpath("//*[contains(text(),'Manage Booking')]")).click();
		WebDriverWait autocomplete=new WebDriverWait(driver, 5);
		autocomplete.until(
		        ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Reschedule')]"))).click();
		
	}
}
