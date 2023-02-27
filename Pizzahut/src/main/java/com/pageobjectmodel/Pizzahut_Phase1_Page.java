package com.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pizzahut_Phase1_Page {
	
public WebDriver driver; // null
	
	@FindBy(xpath ="//input[@role='combobox']")
	private WebElement enterLocation;

	@FindBy(xpath ="(//button[@role='option'])[1]")
	private WebElement option1;
	
	@FindBy(xpath ="(//p[@class='text-left text-14 sm:text-16 leading-normal'])[1]")
	private WebElement dialogPage;
	
	@FindBy(xpath ="(//input[@name='toggle-button-0'])[1]")
	private WebElement radio;
	
	@FindBy(linkText ="Pizzas")
	private WebElement pizza;
	
	@FindBy(xpath ="//button[@data-synth='button--margherita-bestseller-pan-medium--one-tap']")
	private WebElement margheritaPizza;
	
	@FindBy(linkText ="Drinks")
	private WebElement drinks;

	@FindBy(xpath ="//button[@data-synth='button--pepsi-600ml--one-tap']")
	private WebElement pepsi;
	
	@FindBy(xpath ="//button[@data-synth='basket-item-remove--margherita-bestseller-pan-medium']")
	private WebElement removeMargherita;
	
	@FindBy(xpath ="(//a[@data-synth='link--checkout'])[2]")
	private WebElement checkout;
	
	@FindBy(xpath ="//*[@id=\\\"app\\\"]/div/div[1]/div[1]/div[3]/div[1]/div/div/div/span[2]")
	private WebElement vegeterianRadioButton;
	
	
	public Pizzahut_Phase1_Page(WebDriver driver2) {

		this.driver =driver2;
		PageFactory.initElements(driver, this);
	}

	public WebElement getEnterLocation() {
		return enterLocation;
	}

	public WebElement getOption1() {
		return option1;
	}

	public WebElement getDialogPage() {
		return dialogPage;
	}
	
	public WebElement getRadio() {
		return radio;
	}
	
	public WebElement getPizza() {
		return pizza;
	}
	
	public WebElement getMargheritaPizza() {
		return margheritaPizza;
	}
	
	public WebElement getDrinks() {
		return drinks;
	}
	public WebElement getPepsi() {
		return pepsi;
	}
	public WebElement getRemoveMargherita() {
		return removeMargherita;
	}	
	public WebElement getCheckout() {
		return checkout;
	}
	
	public WebElement getVegeterianRadioButton() {
		return vegeterianRadioButton;
	}
	
	

}
