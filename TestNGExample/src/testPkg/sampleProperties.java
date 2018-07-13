package testPkg;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

//import org.openqa.selenium.WebDriver;

public class sampleProperties {

	public static void main(String[] args) throws IOException {
		FileInputStream f=new FileInputStream("/home/sam/eclipse-workspace/TestNGExample/src/testPkg/sample.properties");
		Properties prop=new Properties();
		prop.load(f);
		String whichBrowser=prop.getProperty("browser");
		System.out.println(whichBrowser);
		
		/*System.setProperty("web.driver.geckodriver", "");
		if(whichBrowser=="firefox")
		{
			WebDriver driver=new GeckoDriver();
		}*/
	}

}
