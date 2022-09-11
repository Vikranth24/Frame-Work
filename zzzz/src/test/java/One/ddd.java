package One;





import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import GENERIC_LIBERARY.Base_00;


public class ddd  extends Base_00{
	
	Logger log =LogManager.getLogger();
	@Test(dependsOnMethods ="zdd" )
	public void mmm() 
	{
		System.out.println("good");
		log.info("log");
	}
	
	
	@Test(dataProvider = "get")
	public void zdd(String a, String b) throws InterruptedException
	{
		System.out.println(a+"     "+b);
		Thread.sleep(3000);
	log.info("log");
		
	}
	@DataProvider
	public Object[][] get()
	{
		Object[][] data=new Object[2][2];
		
		data[0][0]="hai";
		data[0][1]="bye";
		data[1][0]="tata";
		data[1][1]="kkk";
		return data;
		
	}

}
