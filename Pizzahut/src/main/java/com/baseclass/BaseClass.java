package com.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {
	
	// Browser launch
	
	public static WebDriver driver; // static webdriver declaration
	
	public static WebDriver launchBrowser(String browsername) { // to pass the arguments, to call the browser whenever it is required
		
		if(browsername.equalsIgnoreCase("chrome")) { // equals ignore case is used since when we call this method, it will be case sensitive, so it ignores the error, for that reason here, equals ignorecase used.

		System.setProperty("webdriver.chrome.driver", "/home/ganeshravi2013g/Downloads/chromedriver.exe");
// in the above loan, system.get property is used for always the directory file can be used concept and concatenation added.
		
		driver = new ChromeDriver(); // here we need to declare the datatype in the class level, because of the usage of all time.
	
		driver.manage().window().maximize();
	 
		} else if(browsername.equalsIgnoreCase("IE")) {
			

			System.setProperty("webdriver.internetexplorer.driver",
					System.getProperty("user.dir")+"\\Driver\\cdeem\\chromedriver.exe");
	// in the above line, system.get property is used for always the directory file can be used concept and concatenation added.
			
			driver = new InternetExplorerDriver(); // here we need to declare the datatype in the class level, because of the usage of all time.
		
			driver.manage().window().maximize();
			
		}
		
		return driver;
	
	}
	
	//get
	public static void urlLaunch(String url) {

		driver.get(url);
	}
	
	// Thread.sleep --->One second
	public static void waitOneSecond() throws InterruptedException {

		Thread.sleep(1000);
	}
	
	// Thread.sleep --->Two second
	public static void waitTwoSecond() throws InterruptedException {

				Thread.sleep(2000);
	}
	
	//getTitle
	
	public static void getTitleMethod() {

		String title = driver.getTitle();
		System.out.println(title);
	}

    // close
	
	public static void closeBrowser() {

		driver.close();
		
	}

    // sendkeys
	
	public static void passInput(WebElement element, String input) {

		element.sendKeys(input);
	}

   // click
	
	public static void clickElement(WebElement element) {

		element.click();
	}
	
   // dropdown
	
	public static void dropdownSelectByIndex(WebElement element, int number) {

		Select dropdownindex = new Select(element);
		dropdownindex.selectByIndex(number);
	}
	
	public static void dropdownSelectByValue(WebElement element, String value) {
		
		Select dropdownvalue = new Select(element);
		dropdownvalue.selectByValue(value);
	
	}
	
	public static void dropdownSelectByVisibleText(WebElement element, String value) {
		
		Select dropdownvisibletext = new Select(element);
		dropdownvisibletext.selectByVisibleText(value);
	
	}
	
	// quit
	
	public static void quitBrowsers() {

		driver.quit();
		
	}
	
	// navigate 
	
	public static void navigateTo(String link_url) {

		driver.navigate().to(link_url);
		
	}
	
	public static void navigateBack() {

		driver.navigate().back();	
	}
	
	public static void navigateForward() {

		driver.navigate().forward();
		
	}
	
	
	public void navigateRefresh() {

		driver.navigate().refresh();
	}
	
	// get
	
	public static void getMethod(String data) {

		driver.get(data);
	}
	
	// Alert Methods
	
	public static void alertBoxAccept(WebElement element, String data) {

		Alert alertBoxAccept = driver.switchTo().alert();
		alertBoxAccept.accept();
	}
	
	public static void confirmBox(WebElement element, String data) {

		Alert confirmbox = driver.switchTo().alert();
		confirmbox.accept();
	}	
		
	public static void alertDismissBox (WebElement element, String data) {

		Alert alertDismissBox = driver.switchTo().alert();
		alertDismissBox.dismiss();
		
	}	
	
	public static void promptbox (WebElement element, String data) {

        Alert promptbox = driver.switchTo().alert();
        promptbox.sendKeys(data);
        promptbox.accept();
	}
	
	public static void lineBreaksAccept (WebElement element, String data) {

		Alert linebreaksAccept = driver.switchTo().alert();
		linebreaksAccept.accept();
	}
	
	public static void lineBreaksDismiss (WebElement element, String data) {

		Alert linebreaksDismiss = driver.switchTo().alert();
		linebreaksDismiss.dismiss();
        
	}
	
	// Actions Methods Below
	
	public static void dragAndDrop(WebElement source, WebElement target) {

		Actions act = new Actions(driver);
		act.dragAndDrop(source, target).build().perform();
		
	}
	
	public static void clickAndHold(WebElement source, WebElement target) {

		Actions act = new Actions(driver);
		act.clickAndHold(source).release(target).build().perform();
		
	}
	
	public static void moveToElement(WebElement element) {
  
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
		
	}
	
	public static void contextClick(WebElement element) {

		Actions act = new Actions(driver);
		act.contextClick(element).build().perform();
	}
	
	public static void doubleClick(WebElement element) {

		Actions act = new Actions(driver);
		act.doubleClick(element).build().perform();
	}
	
	//Frames
	
	public static void framesIndex(int index) {

		driver.switchTo().frame(index);
		
	}
	
	public static void framesString(String nameOrId) {

		driver.switchTo().frame(nameOrId);
	}
	
	public static void framesDefaultContent() {

		driver.switchTo().defaultContent();
		
	}
	
	// Robot
	
	public static void Robot(WebElement target) throws AWTException {

		Actions ac = new Actions(driver);
		Robot rb = new Robot();
		
		ac.moveToElement(target).build().perform();
		
		rb.keyPress(0);
		rb.keyRelease(0);

	}
	
	// Windows Handling
	
	public static void windowsHandling(String window) {
		
		String parentwindow = driver.getWindowHandle();
		
		Set<String> mutipleWindow = driver.getWindowHandles();
		
		for (String str : mutipleWindow) {
			
			driver.switchTo().window(str);
			
		}
		
	}
	
	
	// Checkbox
	
	public static void checkBox(WebElement element) {

		element.click();
		
		if(element.isSelected()) {
			System.out.println("Already Selected");
		} else {
			element.click();
		}
		
	}
	
	// isEnabled
	
	public static void isEnabled(WebElement element) {

		boolean enable = element.isEnabled();
		System.out.println(enable);
		
	}
	
	public static void isDisplayed(WebElement element) {

		boolean display = element.isDisplayed();
		System.out.println(display);
		
	}
	
	public static void isSelected(WebElement element) {

		boolean selected = element.isSelected();
		System.out.println(selected);
		
	}
	
	// get options
	
	public static void getOptions(String value) {

		getOptions(value);
		
	}
	
	// getCurrentUrl
	public static void getCurrentUrl(String value1) {

		String data = driver.getCurrentUrl();
		System.out.println("The Current URL is '" + data +"'");		
		
	}
	
	// getCurrenturl
			public static void getCurrenturl() {

				driver.getCurrentUrl();
				
			}
	
	//getText()
	public static void getText(String data) {

		getText(data);
		
	}
	
	// getAttribute()
	
	public static void getAttribute(String data) {

		getAttribute(data);
	}
	
	//explicitWait
	
	public static void explixitWaitMethod(WebElement data) {

		JavascriptExecutor js = (JavascriptExecutor)driver;
	//	WebDriverWait w = new WebDriverWait(driver, 20);
	//	w.until(ExpectedConditions.visibilityOf(data));
		js.executeScript("arguments[0].scrollIntoView()", data);
		
	}
	
	//implicitWait
	
	public static void implicitWaitMethod() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));;
	}
	
	// takesScreenshot
	
	public static void screenshotMethod(String location) throws IOException {

		TakesScreenshot ss = (TakesScreenshot) driver; // narrowing typecasting
		File src = ss.getScreenshotAs(OutputType.FILE);
		File dest = new File(location);
        FileUtils.copyFile(src,dest);
        
	}
	
	
	// Scroll up and down methods below
	
	public static void scrollUsingPixels() {

		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,1000)", "");
		
	}
	
	public static void scrollToBottom() {

		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight)", "");		
		
	}
	
	
	public static void scrollToElement(WebElement element) {

		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView()", element);
		
	}
	
	
	//getFirstSelectedOptions
	
	public static void getFirstSelectedOptions(String data) {

		getFirstSelectedOptions(data);
	}
	
	//getAllSelectedOptions

	public static void getAllSelectedOptions(String data) {

		getAllSelectedOptions(data);
	}
	
	// isMultiple()
	
	public static void isMultiple(String data) {
		
		isMultiple(data);
		
	}
	
	// RadioButton
	
	public static void radioButton(WebElement element1, WebElement element2) {

		if(element1.isSelected()) {
			
			System.out.println("Element1 Button is Selected");
		
	    } else if (element2.isSelected()){
		
		System.out.println("Element2 Button is Selected");
		
		element1.click();
		
	    }
		
	}
	
	//clear()
	
	public static void clearMethod(WebElement element) {

		element.clear();
	}		


}
