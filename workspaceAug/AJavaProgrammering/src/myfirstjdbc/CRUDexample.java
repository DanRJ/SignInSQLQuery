package myfirstjdbc;

import java.sql.*;
import myfirstjdbc.GUISQL.LoginState;
import db.ConnectToDB;

public class CRUDexample {
	static GUISQL test = null;
	static boolean booltest = false;

	public CRUDexample() {
		
	}

	public static void createConnection(String inUsername, String inPassword) {
		
		ConnectToDB db = new ConnectToDB(inUsername, inPassword);

		try (Connection con = db.getConnection()) {
			try (Statement stmt = con.createStatement()) {
				while (!booltest) {
					createQuery(con, stmt);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		//
		// try (Connection con = db.getConnection()) {
		// try (Statement stmt = con.createStatement()) {
		// create(con, stmt);
		// } catch (SQLException e) {
		// e.printStackTrace();
		// }
		// } catch (SQLException e1) {
		// e1.printStackTrace();
		// }

	}

	public static void createQuery(Connection con, Statement stmt) {
		String query = test.getQuery();
		try {
			if (query != null) {
				stmt.executeUpdate(query);
				System.out.println("Success!\n" + query);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			booltest = true;
		}

		/*
		 * try { while (rs.next()) { System.out.printf("%-10s",
		 * rs.getString(1)); System.out.printf("%-10s%", rs.getString(2));
		 * System.out.printf("%-10s%", rs.getString(3));
		 * System.out.printf("%-10s%", rs.getString(4));
		 * System.out.printf("%-10s%", rs.getString(5)); } } catch (SQLException
		 * e) { e.printStackTrace(); } finally { if (rs != null) rs.close(); }
		 */

	}

}
