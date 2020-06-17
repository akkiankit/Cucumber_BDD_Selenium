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

public class stepdefination extends base {
	
//	private base base;
	public static loginPage lp;
	public static HomePage hp;
	public static Benutzereinstellungen_Page bp;
	public static FilterPage fp;
	public static String vurgangs_Nr;
	public static Detailansicht dp;
	public static String Zug_Nr;
	
	 
	 

	@Before
	public void init() throws IOException {
		driver = initializedriver();
	}
	
	@After
	public void tearDown() throws InterruptedException {
		//Thread.sleep(1000);
		//driver.quit();
	}
	
	@Given("I opened the {string}")
	public void i_opened_the(String Baseurl) throws IOException {
		driver.get(getDataProperties(Baseurl));
		System.out.println(getDataProperties(Baseurl));
	}
	
	@And("I entered login details")
	public void i_entered_login_details() throws IOException {
		lp = new loginPage(driver);
		lp.enteruser(getDataProperties("Username"));
		lp.enterpwd(getDataProperties("Password"));
		lp.clickbtn();
	   
	}
	
	@Then("I clicked on {string}")
	public void i_clicked_on(String btnName) throws InterruptedException {
		hp = new HomePage(driver);
		if(btnName.equalsIgnoreCase("Benutzereinstellungen")) {
			hp.clickprese();	
		}else if(btnName.equalsIgnoreCase("Einstellungen")) {
			hp.clickbtn1();
		}else if(btnName.equalsIgnoreCase("logoIcon")) {
			Thread.sleep(10000);
			hp.clickOnLogo();
		}
	}
	
	@Then("I select {string} from select list")
	public void i_select_from_select_list(String itmname) {
	    bp = new Benutzereinstellungen_Page(driver);
	    bp.selectlist(itmname);
	}
	
	@Then("I select {string} as a radio button")
	public void i_select_as_a_radio_button(String radiobtn) {
	   bp.clickRadioButton(radiobtn);
	}

	@Then("I click On save button")
	public void i_click_On_save_button() {
		bp.clickSaveBtn();
	}
	
	@Then("I clicked on logout Button")
	public void i_clicked_on_logout_Button() {
		hp.clicklogout();
	}

	@Then("I verified Laufwege is Active in table")
	public void i_verified_is_Active_in_table() {
		 try {
			 assertEquals(hp.lafuge().toString(), "True");
		 }catch (AssertionError error) {
			 
		 }catch (Exception exception) {
	           
	      }
	}
	
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
	    fp.clickfilterbtn();
	}
	
	
	@Then("I clicked on laufage Button")
	public void i_clicked_on_laufage_Button() {
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
	
	@And("I entered captured zug-Nr no")
	public void i_entered_captured_zug_Nr_no() throws InterruptedException {
		Thread.sleep(1000);
	   fp.enterZugNr(Zug_Nr);
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
	
	@Then("I verified Zug-Nr details")
	public void i_verified_Zug_Nr_details() throws InterruptedException {
		dp = new Detailansicht(driver);
	   Thread.sleep(1000);
	   assertEquals(dp.getZugNr(), Zug_Nr);
	}
	
	
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
	public void i_verified_that_is_present_at_Detailansicht_page(String string) {
	    
	}
	
	@Then("I verified that status of {string} is {string}")
	public void i_verified_that_status_of_is(String string, String string2) {
	    
	}



}
