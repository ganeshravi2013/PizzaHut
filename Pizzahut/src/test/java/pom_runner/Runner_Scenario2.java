package pom_runner;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.baseclass.BaseClass;
import com.page_object_manager.Page_Object_Manager;
import com.properties.File_Reader_Manager;

public class Runner_Scenario2 extends BaseClass{
	
	public static WebDriver driver = launchBrowser("chrome");		

	public static Page_Object_Manager pom = new Page_Object_Manager(driver);
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		implicitWaitMethod();
		
		String url = File_Reader_Manager.getInstanceFRM().getInstanceCR().getUrl();		
		urlLaunch(url);
		
		String location = File_Reader_Manager.getInstanceFRM().getInstanceCR().getLocation();
		passInput(pom.getInstancePizzahutWebsitePage2().getEnterLocation(), location);
		
		clickElement(pom.getInstancePizzahutWebsitePage2().getOption1());
		
		clickElement(pom.getInstancePizzahutWebsitePage2().getDialogPage());
		
		waitOneSecond();
		
		System.out.println("The Current URL is --> " + driver.getCurrentUrl());	
	
		String currentUrl = File_Reader_Manager.getInstanceFRM().getInstanceCR().getCurrentUrl();	
		
		if(currentUrl.contains("deals")) {
			System.out.println("the URL has text as ‘deals’");
		} else {
			System.out.println("the URL does NOT has text as ‘deals’");
		}
		
		clickElement(pom.getInstancePizzahutWebsitePage2().getSides());
		
		clickElement(pom.getInstancePizzahutWebsitePage2().getCheeseGarlicBread());
		
	
		String validBasketItem = pom.getInstancePizzahutWebsitePage2().getBasket().getText();
		
		if(validBasketItem.contains("Cheese")) {
			System.out.println("The Product is added to basket and also Checkout button is showing");

		}else {
			System.out.println("The Product is NOT added basket and also Checkout button is showing");
		}
	
		
		clickElement(pom.getInstancePizzahutWebsitePage2().getDrinks());

		clickElement(pom.getInstancePizzahutWebsitePage2().getPepsi());

		clickElement(pom.getInstancePizzahutWebsitePage2().getMiranda());

		clickElement(pom.getInstancePizzahutWebsitePage2().getCheckout());
		

		
		boolean onlinePayRadioButton = pom.getInstancePizzahutWebsitePage2().getOnlinePayRadioButton().isSelected();
		if(onlinePayRadioButton) {
			System.out.println("Online Pay RadioButton is selected by default");
		}else {
			System.out.println("Online Pay RadioButton is NOT selected by default");
		}

		
		clickElement(pom.getInstancePizzahutWebsitePage2().getCashOption());
		

		
		boolean iAgreeCheckbox = pom.getInstancePizzahutWebsitePage2().getIAgreeCheckbox().isEnabled();		
		if(iAgreeCheckbox) {
			System.out.println("I Agree Checkbox is checked by default");
		}else {
			System.out.println("I Agree Checkbox is NOT checked by default");
		}

		
		String name = File_Reader_Manager.getInstanceFRM().getInstanceCR().getName();
		passInput(pom.getInstancePizzahutWebsitePage2().getName(), name);
		
		String phone = File_Reader_Manager.getInstanceFRM().getInstanceCR().getPhone();
		passInput(pom.getInstancePizzahutWebsitePage2().getPhone(), phone);
		
		String email = File_Reader_Manager.getInstanceFRM().getInstanceCR().getEmail();
		passInput(pom.getInstancePizzahutWebsitePage2().getEmail(), email);
		
		clickElement(pom.getInstancePizzahutWebsitePage2().getApplyVoucherBox());
				
		clickElement(pom.getInstancePizzahutWebsitePage2().getVoucherOption());

		String voucherCode = File_Reader_Manager.getInstanceFRM().getInstanceCR().getVouchercode();
		passInput(pom.getInstancePizzahutWebsitePage2().getVoucherCode(), voucherCode);
				
		clickElement(pom.getInstancePizzahutWebsitePage2().getRedeem());

		waitTwoSecond();
		
		String errorMessage = File_Reader_Manager.getInstanceFRM().getInstanceCR().getErrorMessage();
		String errorMessageSorry = pom.getInstancePizzahutWebsitePage2().getErrorMessage().getText();
		
		if(errorMessageSorry.contains("Sorry")) {
			System.out.println("The Error Message is reflecting and starts with 'Sorry'");
			
		}else {
			System.out.println("No Error Message reflecting");
		}
		
		clickElement(pom.getInstancePizzahutWebsitePage2().getCloseVoucherBox());


		String validateAgainBasketPage = pom.getInstancePizzahutWebsitePage2().getAgainBasketPage().getText();
		System.out.println(validateAgainBasketPage);

		if(validateAgainBasketPage.contains("Your Basket")) {
			System.out.println("The Page is again moved back to the Basket Page");

		}else {
			System.out.println("The Page is NOT moved back to the Basket Page");
		}

	
        closeBrowser();	

	}
}
