package com.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration_Reader {
	
public static Properties p;
	
	public Configuration_Reader() throws IOException {
		
// The Below Indicates from which the document we are getting like loading.
		
		File f = new File(
				"/home/ganeshravi2013g/eclipse-workspace/Pizzahut/src/main/java/com/properties/Pizzahut.properties");

		FileInputStream fis = new FileInputStream(f);
		
		p = new Properties(); // it was actually Properties p = new Properties(); , p was deaclared after this step.
		
		p.load(fis);
	
	}


	
	
	
	
	// whenever get comes, return should also come.
		public String getUrl() throws IOException {
					
			String url = p.getProperty("url"); 
			
			return url;
			
		}

		public String getLocation() throws IOException {

			String location = p.getProperty("location");
			
			return location;
			
		}
		
		public String getName() throws IOException {

			String name = p.getProperty("name");
			
			return name;
			
		}
		
		public String getPhone() throws IOException {

			String phone = p.getProperty("phone");
			
			return phone;
		}
		
		public String getEmail() throws IOException {

			String email = p.getProperty("email");
			
			return email;
		}
		
		public String getVouchercode() throws IOException {

			String vouchercode = p.getProperty("vouchercode");
			
			return vouchercode;
		}
		
		
		public String getScreenshotMethod() throws IOException {

			String screenshotMethod = p.getProperty("screenshotMethod");
			
			return screenshotMethod;
		}
		
		public String getErrorMessage() throws IOException {

			String errorMessage = p.getProperty("errorMessage");
			
			return errorMessage;
		}
		
		public String getCurrentUrl() throws IOException {

			String currentUrl = p.getProperty("currentUrl");
			
			return currentUrl;
		}
	
}
