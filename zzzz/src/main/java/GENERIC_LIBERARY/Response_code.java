package GENERIC_LIBERARY;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class Response_code {
	
	public int single_response(WebElement ele)
	{
		String link=ele.getAttribute("href");
		HttpURLConnection resp=null;
		try {
			 resp=(HttpURLConnection)new URL(link).openConnection();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			resp.setRequestMethod("Head");
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			resp.connect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int  response=0;
		try {
			 response=resp.getResponseCode();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;	
	}
	
	
	
	
	public void single_response(List<WebElement> ele)
	{
		SoftAssert a=new SoftAssert();
		for(WebElement r: ele)
		{
			String link=r.getAttribute("href");
			HttpURLConnection resp=null;
			try {
				 resp=(HttpURLConnection)new URL(link).openConnection();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				resp.setRequestMethod("Head");
			} catch (ProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				resp.connect();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int  response=0;
			try {
				 response=resp.getResponseCode();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			a.assertTrue(response<400,"This link got Failed"+r.getText()+" With response code of "+ response);	
		}	
		a.assertAll();		
	}
}
