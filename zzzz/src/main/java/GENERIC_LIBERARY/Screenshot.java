package GENERIC_LIBERARY;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Date;  
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;


@SuppressWarnings("unused")
public class Screenshot extends Base_00 implements Paths 
{
	Logger log =LogManager.getLogger();
	public void screen(String result) 
	{	 
		TakesScreenshot scr=(TakesScreenshot)driver;
		File source=scr.getScreenshotAs(OutputType.FILE);
		String Destination=new String("user.dir")+"\\screenshot\\"+result+".png";
		
			try {
				FileUtils.copyFile(source,new File( Destination));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		log.info("Screen shot");
	}
}
