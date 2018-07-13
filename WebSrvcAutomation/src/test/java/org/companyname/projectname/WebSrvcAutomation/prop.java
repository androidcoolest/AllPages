package org.companyname.projectname.WebSrvcAutomation;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.testng.annotations.Test;

@Test
public class prop {
	
	public void getPropsforme() throws IOException {
		Properties prop = new Properties();
	String propFileName = "config.properties";
	InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

	if (inputStream != null) {
		prop.load(inputStream);
		String Browser = prop.getProperty("Browser");
		System.out.println(Browser);

	} else {
		throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
	}
	//String Browser = prop.getProperty("user");
	
	}
}
