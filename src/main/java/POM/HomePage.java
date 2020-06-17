package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	By btn1 = By.cssSelector("a[id='nav-dropdown-admin']");
	By prsntn = By.linkText("Benutzereinstellungen");
	By lafaugeActive = By.id("tabs-tab-LAUFWEGE_TREE");
	By logout = By.xpath("//*[@id=\"menu\"]/li[2]/a");
//	By logoIcon = By.xpath("//button[@id='openFilterPanel']/div");
	By logoIcon = By.cssSelector("img#logo.logo");
	
	
	
	public void clickbtn1() {
		driver.findElement(btn1).click();
	}
	
	public void clickprese() {
		driver.findElement(prsntn).click();
	}
	
	public void clicklogout() {
		driver.findElement(logout).click();
	}
	
	public String lafuge() {
		return driver.findElement(lafaugeActive).getAttribute("aria-selected");
	}
	
	public void clicklafuge() {
		driver.findElement(lafaugeActive).click();
	}
	
	public void clickOnLogo() {
//		System.out.println("enter logoIcon");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", driver.findElement(logoIcon));
		driver.findElement(logoIcon).click();
	}
	
	
	
}
