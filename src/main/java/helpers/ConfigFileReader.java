package helpers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import enums.BrowserType;
import enums.EnvironmentType;

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
	
	
	public BrowserType getBrowser() {
		String browser = prop.getProperty("browser");
		if(browser==null) {
			throw new RuntimeException("browser value is not defined in the Configuration.properties file");
		}
		if(browser.equalsIgnoreCase("chrome")) {
			return BrowserType.CHROME;
		}else if(browser.equalsIgnoreCase("firefox")) {
			return BrowserType.FIREFOX;
		}else if(browser.equalsIgnoreCase("ie")) {
			return BrowserType.IE;
		}else {
			throw new RuntimeException("Browser Name in Configuration.properties file is invalid: " + browser);
		}
	}
	
	public EnvironmentType getEnvironment() {
		String environment = prop.getProperty("environment");
		if(environment==null) {
			throw new RuntimeException("environment value is not defined in the Configuration.properties file");
		}
		if(environment.equalsIgnoreCase("local")) {
			return EnvironmentType.LOCAL;
		}else if(environment.equalsIgnoreCase("remote")) {
			return EnvironmentType.REMOTE;
		}else {
			throw new RuntimeException("Environment in Configuration.properties file is invalid: " + environment);
		}
	}
	
	public boolean getBrowserWindowMaximize() {
		String windowsMaximize = prop.getProperty("windowsMaximize");
		
		if(windowsMaximize!=null) {
			 return Boolean.parseBoolean(windowsMaximize);
		}
		// default 
		return true;
		
		
	}
	

}
