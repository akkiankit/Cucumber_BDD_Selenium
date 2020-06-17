package POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Benutzereinstellungen_Page {

public WebDriver driver;
	
	public Benutzereinstellungen_Page(WebDriver driver) {
		this.driver = driver;
	}
	
	By stndFil = By.cssSelector("select.form-control");
	By savebtn = By.id("colorOverlay");
	By Bauma = By.cssSelector("input[value='Baumaßnahmen']");
	By lau = By.cssSelector("input[value='Laufwege']");
	By Darsetellung1 = By.cssSelector("input[value='SPLIT_MAP_TABLE']");
	By Darsetellung2 = By.cssSelector("input[value='SPLIT_MAP_TABLE_GANTT']");
	By Darsetellung3 = By.cssSelector("input[value='FULLSCREEN_TABLE']");
	
	
	public void selectlist(String item) {
		Select it = new Select(driver.findElement(stndFil));
		it.selectByVisibleText(item);
	}
	
	public void clickSaveBtn() {
		driver.findElement(savebtn).click();
	}
	
	public void clickBauma() {
		driver.findElement(Bauma).click();
	}
	
	public void clickLau() {
		driver.findElement(lau).click();
	}
	
	public void clickDars1() {
		driver.findElement(Darsetellung1).click();
	}
	
	public void clickDars2() {
		driver.findElement(Darsetellung2).click();
	}
	
	public void clickDars3() {
		driver.findElement(Darsetellung3).click();
	}
	
	public void clickRadioButton(String radBtn) {
		if(radBtn.equalsIgnoreCase("Baumaßnahmen")) {
			clickBauma();
		}else if(radBtn.equalsIgnoreCase("Laufwege")) {
			clickLau();
		}else if(radBtn.equalsIgnoreCase("Teilung Karte / Tabelle")) {
			clickDars1();
		}else if(radBtn.equalsIgnoreCase("Teilung Karte / Tabelle / Kalenderansicht")) {
			clickDars2();
		}else if(radBtn.equalsIgnoreCase("Vollbild Tabelle")) {
			clickDars3();
		}
		
	}
	
}
