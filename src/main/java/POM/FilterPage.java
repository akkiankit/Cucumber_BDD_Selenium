package POM;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class FilterPage {
	
	public WebDriver driver;
	
	JavascriptExecutor js;
	Actions actions;
	
	public FilterPage(WebDriver driver) {
		this.driver = driver;
	}

	By zeitrumDate = By.id("geltungszeitraumVon");
	By zeitrumD = By.id("geltungszeitraumBis");
	By savefil = By.cssSelector("button#applyFilter");
	By openfil = By.cssSelector("button#openFilterPanel");
	
	By zug = By.xpath("//*[@id=\"tree\"]/div/div[1]/div/div/div[1]/div/div/div[2]/div/div/div[1]/span/div/div/table/tbody/tr/td[1]");
	By monthheader = By.xpath("//*[@id=\"geltungszeitraum\"]/div[1]/div/div/div/div/div/div/div[2]/div[1]/div[1]");
	
	By vorganNotext = By.xpath("//*[@id=\"tree\"]/div/div[1]/div/div/div[1]/div/div/div[2]/div/div/div[1]/span/div/div/table/tbody/tr/td[1]");
	
	By vorganEdit = By.cssSelector("input[name='vorgnr'");
	By ZugNrEdit = By.cssSelector("input[name='zugnummer'");
	
	By arrowdown1 = By.cssSelector("button.rstcustom__expandButton[type='button']");
	By arrowRight = By.xpath("//*[@id=\"button-readDetails\"]");
	
	By betrie = By.cssSelector("input[id='bst-0']");
	By betrieselect = By.xpath("//*[contains(@id,'react-select')]");
	
	public void selectDate(String date1) {
		driver.findElement(zeitrumDate).click();;
		String[] dateStore = date1.toString().split("-");

		String dd = dateStore[0];
		String mmm = dateStore[1];
		String yyyy = dateStore[2];
		
		driver.findElement(By.xpath("//*[contains(@aria-label,'" + dd + ". " + mmm + "i " + yyyy + "')]")).click();
		
	}
	
	public void selDate(String date1) {
		String[] dateStore = date1.toString().split("-");
		String dd = dateStore[0];
		String mmm = dateStore[1];
		String yyyy = dateStore[2];
		
		driver.findElement(zeitrumD).click();;
		
		driver.findElement(By.xpath("//*[contains(@aria-label,'" + dd + ". " + mmm + "i " + yyyy + "')]")).click();
		
	}
	
	public void clickfilterbtn() {
		driver.findElement(savefil).click();
	}
	
	public String getVorganNoText() {
		return driver.findElement(vorganNotext).getText();
	}
	
	public void ClickOpenFilter() {
		
		driver.findElement(openfil).click();
	}
	
	public void enterVurganNr(String vur) {
		actions = new Actions(driver);
		actions.moveToElement(driver.findElement(vorganEdit));
		driver.findElement(vorganEdit).sendKeys(vur);
	}
	
	public void enterZugNr(String zrnr) {
		actions = new Actions(driver);
		actions.moveToElement(driver.findElement(ZugNrEdit));
		driver.findElement(ZugNrEdit).sendKeys(zrnr);
	}
	
	public void clickArrowDown() {
		
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", driver.findElement(arrowdown1));
		//driver.findElement(arrowdown1).click();
		
		Boolean dis = driver.findElements(arrowdown1).size()>0;
		while(dis) {
			System.out.println(dis);
			driver.findElement(arrowdown1).click();	
			try {
				dis = driver.findElements(arrowdown1).size()>0;
			} catch (NoSuchElementException e) {
				break ;
			}
		}
	}
	
	public void clickarrow() throws InterruptedException {
		Thread.sleep(300);
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", driver.findElement(arrowdown1));
		driver.findElement(arrowdown1).click();	
	}
	
	public void clickArrowRight(int index) {
		List<WebElement> arrowrightbtns = driver.findElements(arrowRight);
		System.out.println("arrow right button count is : "+ arrowrightbtns.size());
		for(int i=0; i < arrowrightbtns.size(); i++) {
			if(index == i) {
				arrowrightbtns.get(i).click();
			}
		}
		
	}
	
	public void enterBriesbetten(String option) {
		
		actions = new Actions(driver);
		
		actions.moveToElement(driver.findElement(betrie));
		
		driver.findElement(betrie).sendKeys(option);
		
		List<WebElement> opts = driver.findElements(betrieselect);
		System.out.println(opts.size());
		
		for(WebElement op:opts) {
			System.out.println(op.getText());
			if(op.getText().contains(option)) {
				
				op.click();;
			}
		}
	}
	
	
}
