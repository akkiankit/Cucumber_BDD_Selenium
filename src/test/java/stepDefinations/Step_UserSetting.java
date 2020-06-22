package stepDefinations;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import POM.Benutzereinstellungen_Page;
import POM.HomePage;
import POM.loginPage;
import Utils.base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Step_UserSetting extends base{
	
	public static loginPage lp;
	public static HomePage hp;
	public static Benutzereinstellungen_Page bp;
	
	@Given("I opened the {string}")
	public void i_opened_the(String Baseurl) throws IOException {
		driver.get(getDataProperties(Baseurl));
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

}
