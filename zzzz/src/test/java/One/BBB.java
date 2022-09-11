package One;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.logging.log4j.*;
import GENERIC_LIBERARY.Base_00;
import POM.List;

public class BBB extends Base_00 {
	
	@Test
	public void add() throws InterruptedException
	{
		
		Thread.sleep(3000);
		System.out.println("nnnnnnnnnnnnnnnnnnnnnnnnn");
	   driver.findElement(By.xpath("//button[text()='Recruiter']")).click();
	   Thread.sleep(3000);
	//Assert.assertTrue(false);	
	   }

	
	}
