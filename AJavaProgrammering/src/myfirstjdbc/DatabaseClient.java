package myfirstjdbc;

import java.sql.*;

import db.ConnectToDB;

public class DatabaseClient {

	public static void main(String[] args) {
		String bruker = args[0], passord = args[1];
		
		ConnectToDB db = new ConnectToDB(bruker, passord);
		try {
			Connection con = db.getConnection();			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}