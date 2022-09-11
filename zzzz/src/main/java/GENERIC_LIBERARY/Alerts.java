package GENERIC_LIBERARY;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class Alerts {
	Logger log =LogManager.getLogger();
	// TO CLICK ON THE  POSATIVE MEANING BUTTON
	public void alert_accept(WebDriver driver)
	{
		Alert a=driver.switchTo().alert();
		a.accept();
		log.info("CLICKED ON THE OK OR ACCEPT BUTTON OF POPUP");
		
	}
	
	// TO CLICK ON THE  NEGATIVE MEANING NO 
	public void alert_dismiss(WebDriver driver)
	{
		Alert a=driver.switchTo().alert();
		a.dismiss();
		log.info("CLICKD ON THE CANCEL OR DISMISS BUTTON OF ALERT");
	}
	
	//TO GET THE TEXT ON THE ALERT
	public String alert_sendText(WebDriver driver)
	{
		Alert a=driver.switchTo().alert();
		log.info("alert_sendText METHOD IS RETURNING TEXT ON ALERT--- THE TEXT SENT IS ---"+ a.getText());
		return a.getText();	
		
	}
	
	//TO PRINT THE TEXT ON THE ALERT
	public void alert_printText(WebDriver driver)
	{
		Alert a=driver.switchTo().alert();
		log.info("alert_printText METHOD IS PRINTING TEXT ON ALERT IN CONSOLE --- THE TEXT PRINTED IS ---"+ a.getText());
		System.out.println( a.getText());	
	}
	

}
