package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	
	public static Properties prop;
	public static WebDriver driver;
	
	public static String getDataProperties(String key) throws IOException {
		
		prop = new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir") + "/src/test/java/Utils/data.properties");
		prop.load(fis);
		return prop.getProperty(key);
	}
	
	
	public static String getReportConfigPath() throws IOException{
	 String reportConfigPath = getDataProperties("reportConfigPath");
	 if(reportConfigPath!= null) return reportConfigPath;
	 else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath"); 
	}
	
	public WebDriver initializedriver() throws IOException {
		
		//String browserName = getDataProperties("browser");
		String browserName = System.getProperty("BROWSER");
		if(browserName == null) {
			browserName = getDataProperties("browser");
		}
		
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Driver/chromedriver");
			System.setProperty("webdriver.chrome.silentOutput","true");
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/Driver/geckodriver");
			driver= new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		return driver;
	}

}
