package com.page_object_manager;

import org.openqa.selenium.WebDriver;

import com.pageobjectmodel.Pizzahut_Phase1_Page;
import com.pageobjectmodel.Pizzahut_Phase2_Page;

public class Page_Object_Manager {
	

	// private datatype variable;
	// private WebElement refName;
	// private classname objectname;
	
	public WebDriver driver; // null
	
	private Pizzahut_Phase1_Page p1p; // null
	
	private Pizzahut_Phase2_Page p2p;

	public Page_Object_Manager(WebDriver driver2) {
		
		this.driver=driver2;
	}

	public Pizzahut_Phase1_Page getInstancePizzahutWebsitePage1() {
		
		if(p1p ==null ) {
			
			p1p = new Pizzahut_Phase1_Page(driver);
		}
		return p1p;
	}

	public Pizzahut_Phase2_Page getInstancePizzahutWebsitePage2() {
		
		if(p2p ==null ) {
			
			p2p = new Pizzahut_Phase2_Page(driver);
		}
		return p2p;
	}

}
