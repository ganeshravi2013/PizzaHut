package com.properties;

import java.io.IOException;

public class File_Reader_Manager {
	
	
    // This should always like Private constructor, one static method and non-static method
	// if a constructor is given as private, we cannot access outside the class.
	// if a method is called using class name, only static method within the class will be called.
	// with extends keyword we can access the method directly
	// without extends--> we can access the method by using class name.
		
		
		//private constructor
		private File_Reader_Manager() {

		}
		
		// static method
		public static File_Reader_Manager getInstanceFRM() {

			File_Reader_Manager frm = new File_Reader_Manager();
			return frm;
		}
		
		// non static method
		public Configuration_Reader getInstanceCR() throws IOException {
			
			Configuration_Reader cr = new Configuration_Reader();
			return cr;
		}


}
