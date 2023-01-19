package helpers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

	private final String propertyFilePath = "configs/configuration.properties";
	private Properties prop;

	public ConfigFileReader() {
		try {
			FileInputStream stream = new FileInputStream(propertyFilePath);
			prop = new Properties();
			try {
				prop.load(stream);
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("In valid properties file: ");
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at: " + propertyFilePath);
		}

	}
	
	public String getURL() {
		String url = prop.getProperty("url");
		if(url!=null) {
			return url;
		}else {
			throw new RuntimeException("url is not specify in the Configuration.properties file, please specify the url for the application");
		}
		
	}
	
	public long getImplicitlyWait() {
		String implictlyWait = prop.getProperty("implicitlyWait");
		if(implictlyWait!=null) {
			return  Long.parseLong(implictlyWait);
		}else {
			throw new RuntimeException("implictlyWait not specify in the configuration.properties file, please specify it");
		}
	}
	
	
	
	

}
