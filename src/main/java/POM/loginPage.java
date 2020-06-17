package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
	
	public WebDriver driver;
	
	public loginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By user = By.id("username");
	By pwd = By.id("password");
	By lgn = By.id("login");
	
	
	public void enteruser(String us) {
		driver.findElement(user).sendKeys(us);
	}
	
	public void enterpwd(String pw) {
		driver.findElement(pwd).sendKeys(pw);
	}
	
	public void clickbtn() {
		driver.findElement(lgn).click();
	}

}
