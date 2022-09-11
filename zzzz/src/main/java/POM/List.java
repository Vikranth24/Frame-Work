package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;



public class List {
	public WebDriver driver;
	
	public List( WebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(how=How.XPATH, using = "//input")
	private java.util.List<WebElement> e;
	
	public java.util.List<WebElement> getCollectionOfElements() {
		 return e;
		}
	
	


}

