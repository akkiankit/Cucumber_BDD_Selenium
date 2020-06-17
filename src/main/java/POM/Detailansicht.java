package POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Detailansicht {
	
	public WebDriver driver;
	JavascriptExecutor js;
	Actions actions;
	public Detailansicht(WebDriver driver) {
		this.driver = driver;
	}
	
	By Act_ven = By.xpath("//*[@class='sc-gqjmRU nYta row']/div[3]/p");
	By Act_zen = By.xpath("//*[@id=\"trasseninfo\"]/div[1]/div/div[3]/p/div/div[1]");
	
	By tableRows = By.xpath("//*[@id='table']/tbody/tr");
	By tableCols = By.xpath("//*[@id='table']/tbody/tr/td[0]");
	
	public String get_Act_VengularNo() {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", driver.findElement(Act_ven));
		return driver.findElement(Act_ven).getText();
	}
	
	public String getZugNr() {
		return driver.findElement(Act_zen).getText();
	}
	
	public String getCellData(String data) {
		
		//actions.moveToElement(driver.findElement(By.id("table")));
		
		WebElement tbl = driver.findElement(By.id("table"));
		
		
		List<WebElement> rows = tbl.findElements(By.tagName("tr"));
		
		for(int i=0; i<rows.size(); i++) {
			List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
			for(int j=0; j<cols.size(); j++) {
				if(cols.get(j).getText().contains(data)) {
					return cols.get(j).getText();
				}
			}
		}
		return null;
		
	}

}
