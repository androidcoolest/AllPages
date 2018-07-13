package com.depositsolution.assignment;
import java.util.Properties;
 
/*
 * Class to read Config.properties
 */
public class Configuration
{
   //Variable Declaration
	Properties configFile;
   public Configuration()
   {
	configFile = new java.util.Properties();
	try {
	  configFile.load(this.getClass().getClassLoader().
	  getResourceAsStream("config.properties"));
	}catch(Exception eta){
	    eta.printStackTrace();
	}
   }
   
   //Return value when called from Test class
   public String getProperty(String key)
   {
	String value = this.configFile.getProperty(key);
	return value;
   }
}