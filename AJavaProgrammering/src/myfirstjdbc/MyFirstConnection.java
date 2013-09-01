package myfirstjdbc;

import java.sql.*;

public class MyFirstConnection {
	public static void main(String[] args) {
		String brukernavn = args[0];
		String passord = args[1];
		/*
		 * Legg denne i url hvis man ikke skal ha lcoalhost
		 * "jdbc:mysql://mysql.nith.no/johdan12";
		*/
		String url = "jdbc:mysql://localhost/world";
	
		try {
			Connection con = DriverManager.getConnection(
					url,
					brukernavn,
					passord);	
			System.out.println("This works!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
