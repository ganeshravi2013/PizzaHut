package pom_runner;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.baseclass.BaseClass;
import com.page_object_manager.Page_Object_Manager;
import com.properties.File_Reader_Manager;

public class Runner_Scenario1 extends BaseClass {
	
	public static WebDriver driver = launchBrowser("chrome");		

	public static Page_Object_Manager pom = new Page_Object_Manager(driver);
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		implicitWaitMethod();
		
		String url = File_Reader_Manager.getInstanceFRM().getInstanceCR().getUrl();		
		urlLaunch(url);
		
		String location = File_Reader_Manager.getInstanceFRM().getInstanceCR().getLocation();
		passInput(pom.getInstancePizzahutWebsitePage1().getEnterLocation(), location);
		
		clickElement(pom.getInstancePizzahutWebsitePage1().getOption1());
		
		clickElement(pom.getInstancePizzahutWebsitePage1().getDialogPage());
		
//		String attribute = pom.getInstancePizzahutWebsitePage().getRadio().getAttribute("value");

		clickElement(pom.getInstancePizzahutWebsitePage1().getPizza());
		
		waitOneSecond();

		clickElement(pom.getInstancePizzahutWebsitePage1().getMargheritaPizza());

		clickElement(pom.getInstancePizzahutWebsitePage1().getDrinks());

		clickElement(pom.getInstancePizzahutWebsitePage1().getPepsi());
		
		waitTwoSecond();
		
		clickElement(pom.getInstancePizzahutWebsitePage1().getRemoveMargherita());

		waitOneSecond();

		clickElement(pom.getInstancePizzahutWebsitePage1().getCheckout());
		
		waitOneSecond();

        closeBrowser();	

	}

}
