package POM;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MMM.yyyy");  
		LocalDateTime now = LocalDateTime.now();  
		System.out.println(dtf.format(now));  

	}

}
