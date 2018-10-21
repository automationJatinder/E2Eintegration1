package flipkart.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utilities {
	
	private final static String OR_Prop_File ="./Config/OR.properties";
	private final static String Config_File ="./Config/OR.properties";
//	private Properties properties;
	Properties properties;
	
	public String fetch_OR(String key) throws IOException
	{						
		FileInputStream file = new FileInputStream(OR_Prop_File);
		Properties properties = new Properties();
		properties.load(file);
		
		return properties.getProperty(key);
		
	}
	
	public String fetch_Config(String key) throws IOException
	{		
				
		FileInputStream file = new FileInputStream(Config_File);
		Properties properties = new Properties();
		properties.load(file);
		
		return properties.getProperty(key);
	}
	
	

}
