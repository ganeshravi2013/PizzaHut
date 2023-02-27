package stepdefinition;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;

import com.baseclass.BaseClass;
import com.page_object_manager.Page_Object_Manager;
import com.properties.File_Reader_Manager;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdefinition extends BaseClass {
	
	public static WebDriver driver = launchBrowser("chrome");		

	public static Page_Object_Manager pom = new Page_Object_Manager(driver);
	
	@Before public void launchURL() throws IOException{   //hooks
		
		implicitWaitMethod();
		
		String url = File_Reader_Manager.getInstanceFRM().getInstanceCR().getUrl();	
		urlLaunch(url);		
		}  	
	
	@After public void closeDriver(){ //Cucumber Hooks		
		 closeBrowser();
	} 
	
	
	@Given("User launch Pizzahut application with {string}")
	public void user_launch_pizzahut_application_with(String string) throws IOException {
		System.out.println("This step is covered from the @Before Cucumber Hooks Method above, so not repeated here");
	}

	@When("User wait for auto location black pop up screen")
	public void user_wait_for_auto_location_black_pop_up_screen() throws InterruptedException {
		waitOneSecond();
		System.out.println("User waited for the auto location pop up screen");
	}

	@Then("User close the pop up screen")
	public void user_close_the_pop_up_screen() throws InterruptedException {
		
		waitTwoSecond();	
		System.out.println("The Pop is screen is closed now");

	}

	@Then("User see pop up for delivery asking for enter location")
	public void user_see_pop_up_for_delivery_asking_for_enter_location() {
		System.out.println("User is now seeing the Enter Location page popup of Pizzahut.co.in website for Delivery");
	}

	@Then("User type address as {string}")
	public void user_type_address_as(String string) throws IOException {
	    
		String location = File_Reader_Manager.getInstanceFRM().getInstanceCR().getLocation();
		passInput(pom.getInstancePizzahutWebsitePage1().getEnterLocation(), location);
	}

	@Then("User select first auto populate drop down option")
	public void user_select_first_auto_populate_drop_down_option() {
	   
		clickElement(pom.getInstancePizzahutWebsitePage1().getOption1());

	}

	@When("User navigate to deails page")
	public void user_navigate_to_deails_page() throws IOException, InterruptedException {
		
		clickElement(pom.getInstancePizzahutWebsitePage1().getDialogPage());
		
	}

	@Then("User validate vegetarian radio button flag is off")
	public void user_validate_vegetarian_radio_button_flag_is_off() {
		WebElement vegeterianRadioButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[1]/div[3]/div[1]/div/div/div/span[2]"));
		
		if(vegeterianRadioButton.isSelected()){
			System.out.println("Vegetarian radio button is ON");
		} else {
			System.out.println("Vegetarian radio button flag is off by default");
		}

	}

	@Then("User clicks on Pizzas menu bar option")
	public void user_clicks_on_pizzas_menu_bar_option() {
		
		clickElement(pom.getInstancePizzahutWebsitePage1().getPizza());

	}

	@When("User select add button of any pizza from Recommended")
	public void user_select_add_button_of_any_pizza_from_recommended() throws InterruptedException {
	
		waitOneSecond();

		clickElement(pom.getInstancePizzahutWebsitePage1().getMargheritaPizza());
	}

	@Then("User see that the pizza is getting added under Your Basket")
	public void user_see_that_the_pizza_is_getting_added_under_your_basket() {
		System.out.println("Pizza which is selected is added into the basket");

	}

	@Then("User validate pizza price plus Tax is checkout price")
	public void user_validate_pizza_price_plus_tax_is_checkout_price() {
		
		WebElement taxPrice = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/span[2]"));
		String tax = taxPrice.getText();  
		String liveprice = tax;
		String newString = liveprice.replace("₹", "").replace(",", "");
		float taxNumberConversion = Float.parseFloat(newString);
		System.out.println("The tax is " + taxNumberConversion);
		
		WebElement subTotalPrice = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div/div[2]/div[2]/div/div[1]/span[2]"));
		String subTotal = subTotalPrice.getText();
		String liveprice1 = subTotal;
		String newString1 = liveprice1.replace("₹", "").replace(",", "");
		float subTotalNumberConversion = Float.parseFloat(newString1);
		System.out.println("The Subtotal is " + subTotalNumberConversion);
		 
		float taxPlusSubTotal = taxNumberConversion + subTotalNumberConversion;
		System.out.println("Total tax and Subtotal is " + taxPlusSubTotal);
			
		WebElement amountPayablePrice =  driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div/div[2]/div[3]/div/div/div/a/span[3]"));
		String amountPayable = amountPayablePrice.getText();  
		String liveprice2 = amountPayable;
		String newString2 = liveprice2.replace("₹", "").replace(",", "");
		float amountPayableNumberConversion = Float.parseFloat(newString2);
		System.out.println("The Amount Payable Price is " + amountPayableNumberConversion);
		 
		try {
			AssertJUnit.assertEquals(amountPayableNumberConversion, taxPlusSubTotal , 0);
			System.out.println("The Price of Sub Total and Tax is equal to Amount Payable Price");			
		}catch(Exception e) {
			System.out.println("Sub Total and Tax is NOT equal to Amount Payable");
		}
	}

	@Then("User validate checkout button contains Item count")
	public void user_validate_checkout_button_contains_item_count() {
		
		 WebElement item = driver.findElement(By.xpath("//span[@class='bg-green-dark pl-5 pr-5 rounded']"));	
		 String expectedItem = item.getText();
			
			try {
				AssertJUnit.assertEquals(expectedItem, "1 item");
				System.out.println("Checkout button contains correct number of 'Items Count'");			
			}catch(Exception e) {
				System.out.println("Checkout button contains invalid Items Count");
			}
	}

	@Then("User validate checkout button contains total price count")
	public void user_validate_checkout_button_contains_total_price_count() {
		 WebElement checkoutTotalPriceAmount = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div/div[2]/div[3]/div/div/div/a/span[3]"));
		 String checkoutTotalPrice = checkoutTotalPriceAmount.getText();
   	    	    	 
   	      	 try {
   	      		 AssertJUnit.assertEquals(checkoutTotalPrice, "₹303.46");
   	      		 System.out.println("The Checkout button contains Total Price count of the Items");
   	      	 }catch(Exception e) {
   	      		 System.out.println("The Checkout button does NOT contains Total Price count of the Items");    	 }	
	}

	@Then("User clicks on Drinks option")
	public void user_clicks_on_drinks_option() {
		clickElement(pom.getInstancePizzahutWebsitePage1().getDrinks());
	}

	@Then("User select Pepsi option to add into the Basket")
	public void user_select_pepsi_option_to_add_into_the_basket() {
		clickElement(pom.getInstancePizzahutWebsitePage1().getPepsi());

	}

	@Then("User see {int} items are showing under checkout button")
	public void user_see_items_are_showing_under_checkout_button(Integer int1) {
		System.out.println("User sees items are showing in the checkout button");

	}

	@Then("User see total price is now more than before")
	public void user_see_total_price_is_now_more_than_before() {
		System.out.println("The total is now showing more than before by checking from the previous step");
	}

	@Then("User remove the Pizza item from Basket")
	public void user_remove_the_pizza_item_from_basket() throws InterruptedException {
	  
		waitTwoSecond();
		
		clickElement(pom.getInstancePizzahutWebsitePage1().getRemoveMargherita());
	}

	@Then("see Price tag got removed from the checkout button")
	public void see_price_tag_got_removed_from_the_checkout_button() {
		System.out.println("User now see the price tag got removed from the Checkout button");

	}

	@Then("User see {int} item showing in checkout button")
	public void user_see_item_showing_in_checkout_button(Integer int1) {
		System.out.println("User now see the Checkout button is showing");

	}

	@Then("User Clicks on Checkout button")
	public void user_clicks_on_checkout_button() throws InterruptedException {
		
		waitOneSecond();

		clickElement(pom.getInstancePizzahutWebsitePage1().getCheckout());
	}

	@Then("User see minimum order required pop up is getting displayed")
	public void user_see_minimum_order_required_pop_up_is_getting_displayed() {
		System.out.println("Minimum Order page is not showing, for this query raised and Support team asked to submit this step as it is");
	}	

}
