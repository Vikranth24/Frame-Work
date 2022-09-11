package GENERIC_LIBERARY;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScript {
	public WebDriver driver;
	public JavascriptExecutor javaScript = (JavascriptExecutor) driver;
	Logger log = LogManager.getLogger();

	public JavaScript(WebDriver driver) {
		driver = this.driver;
	}

	public void jsClick(WebElement element) {
		log.trace("EXPECTING TO CLICK THE ELEMENT USING JAVASCRIPT");
		javaScript.executeScript("arguments[0].click();", element);
		if (element.isSelected()) {
			log.info("ELEMENT GOT CLICKED USING JAVASCRIPT");
		} else {
			log.error("ELEMENT IS NOT CLICKED USING JAVASCRIPT");
		}
	}

	public void jsSendkeys(String data, WebElement element) {
		log.trace("EXPECTING TO SENDTEXT TO TEXTFIELD USING JAVASCRIPT");
		javaScript.executeScript("arguments[0].value='" + data + "';", element);
		if (element.getText().equals(data)) {
			log.info("TEXT IS SENT TO TEXTFIELD USING JAVASCRIPT");
		} else {
			log.error("TEXT IS NOT SENT TO TEXTFIELD USING JAVASCRIPT");
		}
	}

	public void jsScrollBy(int X, int Y) {
		log.trace("EXPECTING TO SCROOL TO " + "X " + X + "Y " + Y + " USING JAVASCRIPT");
		javaScript.executeScript("window.scrollBy(" + X + "," + Y + ")");
		log.info("SCROOL IS DONETO " + "X " + X + "Y " + Y + " USING JAVASCRIPT");
	}

	public void jsScrollTo(int X, int Y) {
		log.trace("EXPECTING TO SCROOL TO " + "X " + X + "Y " + Y + " USING JAVASCRIPT");
		javaScript.executeScript("window.scrollTo(" + X + "," + Y + ")");
		log.info("SCROOL IS DONETO " + "X " + X + "Y " + Y + " USING JAVASCRIPT");
	}

	public void jsScrollIntoView(boolean bool, WebElement element) {
		log.trace("EXPECTING TO REACH THE WEBELEMET IN THE PAGE USING JAVASCRIPT");
		javaScript.executeScript("arguments[0].scrollIntoView(" + bool + ")", element);
		if (element.isDisplayed()) {
			log.info("REACHED THE WEBELEMENT IN THE PAGE USING JAVASCRIPT");
		} else {
			log.info("ELEMENT WHICH WAS EXPECTED IS NOT VISIBLE AFTER USING jsScrollIntoView ");
		}
	}

	public void jsScrollToBottomOfThePage() {
		log.trace("EXPECTED TO REACH END OF THE PAGE USING JAVASCRIPT METHOD jsScrollToBottomOfThePage");
		javaScript.executeScript("arguments[0].scrollBy(0,document.body.scrollHeight')");
		log.info("REACHED END OF THE PAGE USING JAVA SCRIPT");
	}

	public void jsRefresh() {
		log.trace("EXPECTING TO REFRESH THE PAGE USING JAVA SCRIPT");
		javaScript.executeScript("history.go(0)");
		log.info("PAGE GOT REFRESHED");
	}

	public void jsClear(WebElement element) {
		String a = element.getText();

		log.trace("EXPECTING TO CLEAR THE TEXTFIELD TEXT");
		javaScript.executeScript("arguments[0].vlue='';", element);
		if (a.equals(element.getText())) {
			log.error("TEXT IS NOT CLEARED FROM TEXTFIELD");
		} else {
			log.info("TEXT IS CLEARED FROM THE TEXTFIELD");
		}
	}
	public void toChangeTheColorOfWebElement(String color, WebElement element) {
		javaScript.executeScript("arguments[0].style.backgroundColor = '" + color + "';", element);
	}

	public String jsFetchVale(WebElement element) {
		return (String) javaScript.executeScript("return arguments[0].value", element);
	}
}
