package GENERIC_LIBERARY;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Property implements Paths
{
	public String prop() {
		
		FileInputStream fin = null;
		try {
			fin = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\property.properties");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Properties property = new Properties();
		try {
			property.load(fin);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String value = property.getProperty("data");
		return value;
	}

}
