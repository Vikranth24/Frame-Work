package GENERIC_LIBERARY;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Window_handle {

	// TO GIVE CONTROL TO PERTICULAR TAB
	public void window_control(WebDriver driver, String a) {
		Set<String> s = driver.getWindowHandles();
		for (String aa : s)

		{
			driver.switchTo().window(aa);
			if (driver.getTitle().equals(a)) {
				break;
			}
		}
	}
	
	// TO GET THE CONTROL TO PARENT TAB
	public void window_Parent(WebDriver driver, String a) {
		String parent = driver.getWindowHandle();
		driver.switchTo().window(parent);
	}

   //PRINT THE TABS TITLE
	public void window_text_Print(WebDriver driver) {
		Set<String> s = driver.getWindowHandles();
		for (String a : s) {

			System.out.println(driver.switchTo().window(a).getTitle());
		}
	}

   //RETURNS SET OF ALPHANUMERICAL VALUE
	public Set<String> window(WebDriver driver) {
		Set<String> s = driver.getWindowHandles();
		return s;
	}
}
