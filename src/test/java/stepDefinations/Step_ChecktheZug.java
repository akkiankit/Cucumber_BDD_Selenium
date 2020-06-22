package stepDefinations;

import static org.junit.Assert.assertEquals;

import POM.Detailansicht;
import POM.FilterPage;
import POM.HomePage;
import Utils.base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class Step_ChecktheZug extends base {
	
	public static HomePage hp; 
	public static String Zug_Nr;
	public static FilterPage fp;
	public static Detailansicht dp;
	
	@Then("I clicked on laufage Button")
	public void i_clicked_on_laufage_Button() throws InterruptedException {
		Thread.sleep(500);
		  hp = new HomePage(driver);
		  hp.clicklafuge();
	}
	
	@Then("I captured one of Zug-Nr no")
	public void i_captured_one_of_Zug_Nr_no() throws InterruptedException {
		fp = new FilterPage(driver);
		Thread.sleep(1000);
		Zug_Nr = fp.getVorganNoText();
		System.out.println(Zug_Nr);
	   
	}
	
	
	@And("I entered captured zug-Nr no")
	public void i_entered_captured_zug_Nr_no() throws InterruptedException {
		Thread.sleep(1000);
	   fp.enterZugNr(Zug_Nr);
	}
	
	
	
	@Then("I verified Zug-Nr details")
	public void i_verified_Zug_Nr_details() throws InterruptedException {
		dp = new Detailansicht(driver);
	   Thread.sleep(1000);
	   assertEquals(dp.getZugNr(), Zug_Nr);
	}

}
