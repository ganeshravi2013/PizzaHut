package com.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pizzahut_Phase2_Page {
	
public WebDriver driver; // null
	
	@FindBy(xpath ="//input[@role='combobox']")
	private WebElement enterLocation;

	@FindBy(xpath ="(//button[@role='option'])[1]")
	private WebElement option1;
	
	@FindBy(xpath ="(//p[@class='text-left text-14 sm:text-16 leading-normal'])[1]")
	private WebElement dialogPage;
	
	@FindBy(linkText ="Sides")
	private WebElement sides;
	
	@FindBy(xpath ="//button[@data-synth='button--cheese-garlic-bread-single--one-tap']")
	private WebElement cheeseGarlicBread;
	
	@FindBy(linkText ="Drinks")
	private WebElement drinks;
	
	@FindBy(xpath ="//button[@data-synth='button--pepsi-600ml--one-tap']")
	private WebElement pepsi;
	
	@FindBy(xpath ="//button[@data-synth='button--mirinda-600ml--one-tap']")
	private WebElement miranda;
	
	@FindBy(xpath ="(//a[@data-synth='link--checkout'])[2]")
	private WebElement checkout;
	
	@FindBy(id ="checkout__name")
	private WebElement name;
	
	@FindBy(id ="checkout__phone")
	private WebElement phone;
	
	@FindBy(id ="checkout__email")
	private WebElement email;
	
	@FindBy(xpath ="//label[@data-synth='payment-method--cash-label']")
	private WebElement cashOption;
	
	@FindBy(xpath ="//button[@class='w-full']")
	private WebElement applyVoucherBox;
	
	@FindBy(xpath ="//div[@class='sc-fznMnq gdZumo']")
	private WebElement voucherOption;
	
	@FindBy(xpath ="//input[@name='voucherId']")
	private WebElement voucherCode;
	
	@FindBy(xpath ="//button[@type='submit']")
	private WebElement redeem;
	
	@FindBy(xpath ="//div[@class='sc-fznJRM ciBEcK']")
	private WebElement errorMessage;
	
	@FindBy(xpath ="//button[@class='icon-remove-3 absolute top-0 right-0 mr-20 mt-20']")
	private WebElement closeVoucherBox;
	
	@FindBy(xpath ="//div[@data-synth='basket-item-type--side']")
	private WebElement basket;

	@FindBy(xpath ="//input[@id='payment-method--razorpay']")
	private WebElement onlinePayRadioButton;
	
	@FindBy(xpath ="//input[@name='marketingOptIn']")
	private WebElement iAgreeCheckbox;
	
	@FindBy(xpath ="//h2[@class='typography-2 text-center px-20 pt-10 lg:pt-40 pb-10']")
	private WebElement againBasketPage;
	
	
	
	public Pizzahut_Phase2_Page(WebDriver driver2) {

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
	
	public WebElement getSides() {
		return sides;
	}
	
	public WebElement getCheeseGarlicBread() {
		return cheeseGarlicBread;
	}

	public WebElement getDrinks() {
		return drinks;
	}
	
	public WebElement getPepsi() {
		return pepsi;
	}
	
	public WebElement getMiranda() {
		return miranda;
	}
		
	public WebElement getCheckout() {
		return checkout;
	}
	
	public WebElement getName() {
		return name;
	}
	
	public WebElement getPhone() {
		return phone;
	}
	
	public WebElement getEmail() {
		return email;
	}
	
	public WebElement getCashOption() {
		return cashOption;
	}
	
	public WebElement getApplyVoucherBox() {
		return applyVoucherBox;
	}
	
	public WebElement getVoucherOption() {
		return voucherOption;
	}
	
	public WebElement getVoucherCode() {
		return voucherCode;
	}
	
	public WebElement getRedeem() {
		return redeem;
	}
	
	public WebElement getErrorMessage() {
		return errorMessage;
	}
	
	public WebElement getCloseVoucherBox() {
		return closeVoucherBox;
	}
	
	public WebElement getBasket() {
		return basket;
	}
	
	public WebElement getOnlinePayRadioButton() {
		return onlinePayRadioButton;
	}
	
	public WebElement getIAgreeCheckbox() {
		return iAgreeCheckbox;
	}
	
	public WebElement getAgainBasketPage() {
		return againBasketPage;
	}
	
	
	
}