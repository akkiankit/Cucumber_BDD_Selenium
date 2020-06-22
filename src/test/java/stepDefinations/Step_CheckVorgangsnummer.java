package stepDefinations;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import POM.Detailansicht;
import POM.FilterPage;
import Utils.base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Step_CheckVorgangsnummer extends base{
	
	public static FilterPage fp;
	public static String vurgangs_Nr;
	public static Detailansicht dp;
	
	@Given("I selected current Date")
	public void i_selected_current_Date() throws InterruptedException {
		Thread.sleep(1000);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM-yyyy");  
		LocalDateTime now = LocalDateTime.now();  
		System.out.println(dtf.format(now));  
		fp = new FilterPage(driver);
		Thread.sleep(500);
		fp.selectDate(dtf.format(now));
		Thread.sleep(1500);
		fp.selDate(dtf.format(now));
		Thread.sleep(1000);
	}
	
	@Then("I clicked on saveFilter button")
	public void i_clicked_on_saveFilter_button() throws InterruptedException {
		Thread.sleep(500);
		fp = new FilterPage(driver);
	    fp.clickfilterbtn();
	}
	
	@Then("I captured one of Vorgangs-Nr no")
	public void i_captured_one_of_Vorgangs_Nr_no() throws InterruptedException {
		Thread.sleep(1000);
		vurgangs_Nr = fp.getVorganNoText();
		System.out.println(vurgangs_Nr);
	   
	}
	
	@Then("I clicked on open Filter Button")
	public void i_clicked_on_open_Filter_Button() throws InterruptedException {
		Thread.sleep(500);
		fp.ClickOpenFilter();
	}
	
	@Then("I entered captured Vurgang-Nr no")
	public void i_entered_captured_Vurgang_Nr_no() {
	   fp.enterVurganNr(vurgangs_Nr);
	}

	@And("I clicked on Arrow Down")
	public void i_clicked_on_Arrow_Down() throws InterruptedException {
		Thread.sleep(1000);
		fp.clickArrowDown();
	   
	}
	
	@And("I clicked on Arrow Right")
	public void i_clicked_on_Arrow_Right() {
	    fp.clickArrowRight(0);
	}
	

	@Then("I Verified that Vurgang-Nr details")
	public void i_Verified_that_Vurgang_Nr_details() throws InterruptedException {
		dp = new Detailansicht(driver);
		Thread.sleep(500);
		System.out.println("Expected value : " + vurgangs_Nr);
		assertEquals(dp.get_Act_VengularNo(), vurgangs_Nr);
	}
	

}
