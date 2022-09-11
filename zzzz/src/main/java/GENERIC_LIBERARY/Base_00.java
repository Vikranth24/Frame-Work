package GENERIC_LIBERARY;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import POM.Login_Page;
import POM.Logout_Page;

@SuppressWarnings("unused")
public class Base_00 implements Paths {
	private static final String UNUSED = "unused";
	public static WebDriver driver;
	Logger log =LogManager.getLogger();
	
	@BeforeSuite
	public void  Mysql(){
		JDBC j= new JDBC();
		j.database();
	}
	@SuppressWarnings(UNUSED)
	@org.testng.annotations.Parameters("browser")
	@BeforeTest(alwaysRun = true)
	public void Open_Browser(@Optional("chrome") String Browser) {
		
		log.trace("Trying to open "+Browser+" browser");
		
		ChromeOptions C_options = new ChromeOptions();
		C_options.setAcceptInsecureCerts(true);
		C_options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		if (! Chrome_Extension_Path.equalsIgnoreCase("zero")) {
			C_options.addEncodedExtensions(Chrome_Extension_Path);
		}
		if (! Chrome_Download_Folder_link.equalsIgnoreCase("zero")) {
			Map<String, Object> pro = new HashMap<String, Object>();
			pro.put("download.default_directory", Chrome_Download_Folder_link);
			C_options.setExperimentalOption("pro", pro);
		}

		OperaOptions O_options = new OperaOptions();
		O_options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		if (! Opera_Extension_Path.equalsIgnoreCase("zero")) {
			O_options.addEncodedExtensions(Opera_Extension_Path);
		}
		
		
		if (!Opera_Download_Folder_link.equalsIgnoreCase("zero")) {
			Map<String, Object> pro = new HashMap<String, Object>();
			pro.put("download.default_directory", Opera_Download_Folder_link);
			O_options.setExperimentalOption("pro", pro);
		}

		FirefoxOptions F_options = new FirefoxOptions();
		F_options.setAcceptInsecureCerts(true);

		EdgeOptions E_options = new EdgeOptions();
		SafariOptions S_options = new SafariOptions();
		
		if (Browser.equalsIgnoreCase("chrome")) {
			if(ChromeHeadless==1)
				C_options.addArguments("Headless");
			
			System.setProperty(Chrome_Key, Chrome_Path);
			driver = new ChromeDriver(C_options);
		    log.info("CHROME BROWSER LANCHED SUCCESSFULLY");

		} else if (Browser.equalsIgnoreCase("firefox")) {
			if(FirefoxHeadless==1)
				F_options.addArguments("Headless");
			System.setProperty(Firefox_Key, Firefox_Path);
			driver = new FirefoxDriver(F_options);
			log.info("FIREFOX BROWSER LANCHED SUCCESSFULLY");
		} else if (Browser.equalsIgnoreCase("opera")) {
			if(OperaHeadless==1)
				O_options.addArguments("Headless");
			System.setProperty(Opera_Key, Opera_Path);
			driver = new OperaDriver(O_options);
			log.info("OPERA BROWSER LANCHED SUCCESSFULLY");
		}

		else if (Browser.equalsIgnoreCase("edge")) {
			
			System.setProperty(edge_Key, edge_Path);
			driver = new EdgeDriver(E_options);
			log.info("EDGE BROWSER LANCHED SUCCESSFULLY");
		} else if (Browser.equalsIgnoreCase("safari")) {
			
			System.setProperty(Safari_Key, Safari_Path);
			driver = new SafariDriver(S_options);
			log.info("SAFARI BROWSER LANCHED SUCCESSFULLY");
		}

        driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
        log.trace("TRYING TO REACH THE URL" + URL);
		driver.get(URL);
		if(URL.equalsIgnoreCase(driver.getCurrentUrl()))
		{
			log.info("GOT THE EXPECTED WEBPAGE");
		}
		else
		{
			log.error(URL +" WAS EXPECTED BUT REACHED "+driver.getCurrentUrl());
		}
		
		driver.manage().window().maximize();
		log.info("WINDOW GOT MAXIMIZED");
		
	}

	@BeforeClass(alwaysRun = true)
	public void Login() {
		Login_Page in = new Login_Page();
	   log.trace("TRYING TO LOGIN TO THE PAGE USING THIS NAME"+ Login_email);
		in.logg();
	}

	@AfterClass(alwaysRun = true)
	public void Logout() {
		Logout_Page out = new Logout_Page();
		 log.trace("TRYING TO LOGOUT");
		out.out();
	}

	@AfterTest(alwaysRun = true)
	public void quit() {
		log.trace("TRYING TO CLOSE THE BROWSER");
		
		
		
		
		driver.quit();
		log.info("BROWSER GOT CLOSED");
	}
}
