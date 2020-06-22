package stepDefinations;

import java.io.IOException;

import Utils.base;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends base{
	
	@Before
	public void init() throws IOException {
		driver = initializedriver();
	}

	
	@After
	public void tearDown() throws InterruptedException {
		//Thread.sleep(1000);
		driver.quit();
	}
}
