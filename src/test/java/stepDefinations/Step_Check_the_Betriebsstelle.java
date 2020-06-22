package stepDefinations;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import static org.junit.Assert.*;
import POM.Benutzereinstellungen_Page;
import POM.Detailansicht;
import POM.FilterPage;
import POM.HomePage;
import POM.loginPage;
import Utils.base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class Step_Check_the_Betriebsstelle extends base {
	
	public static FilterPage fp;
	public static String vurgangs_Nr;
	public static Detailansicht dp;
	public static String Zug_Nr;
	public static HomePage hp; 
	
	
	@Then("I entered {string} in Betriebsstelle")
	public void i_entered_in_Betriebsstelle(String optn) throws InterruptedException {
	   fp = new FilterPage(driver);
	   Thread.sleep(500);
	   fp.enterBriesbetten(optn);
	}
	
	@Then("I clicked on Arrow Down for only first row")
	public void i_clicked_on_Arrow_Down_for_only_first_row() throws InterruptedException {
		fp.clickarrow();
		fp.clickarrow();
	}
	
	
	@Then("I verified that {string} is present at Detailansicht page")
	public void i_verified_that_is_present_at_Detailansicht_page(String ExpectedValue) throws InterruptedException {
	    Thread.sleep(500);
	    dp = new Detailansicht(driver);
	   assertEquals(dp.getCellData(ExpectedValue), ExpectedValue);
	}
	


}
