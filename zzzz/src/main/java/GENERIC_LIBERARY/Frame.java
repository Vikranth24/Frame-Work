package GENERIC_LIBERARY;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Frame {
	Logger log =LogManager.getLogger();
	//SHIFT TO FRAME BASED ON TEXT SENT
	public void frame_id(WebDriver driver,String input) 
	{
		log.trace("EXPECTING TO REACH FRAME");
		driver.switchTo().frame(input);
		log.info("CONTROL IS ON FRAME");
			}
	///SHIFT TO FRAME BASED ON INDEX VALUE
	public void frame_int(WebDriver driver,int input) 
	{log.trace("EXPECTING TO REACH FRAME");
		driver.switchTo().frame(input);
		log.info("CONTROL IS ON FRAME");
			}
	
	//SHIFT TO FRAME BASED ON WEBELEMENT
	public void frame_web(WebDriver driver,WebElement web) 
	{
		log.trace("EXPECTING TO REACH FRAME");
		driver.switchTo().frame(web);
		log.info("CONTROL IS ON FRAME");
			}
	
		}



