package myfirstjdbc;

import java.sql.*;

import myfirstjdbc.GUISQL.LoginState;

import db.ConnectToDB;

public class CRUDexample{

	public static void main(String[] args) {
		
		GUISQL test = new GUISQL();
		LoginState stateLogin = test.stateLogin;
		
		if (stateLogin == LoginState.LOGIN_CHECK) {
			ConnectToDB db = new ConnectToDB(test.getUsername(),
					test.getPassword());
		}
		System.out.println("hello");
//		try (Connection con = db.getConnection()) {
//			try (Statement stmt = con.createStatement()) {
//				create(con, stmt);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//		}

	}

	public static void create(Connection con, Statement stmt) {

		// String query = test.getQuery();
		// System.out.println(query);
		// try {
		// if (query != null) {
		// stmt.executeUpdate(query);
		// System.out.println("Success!\n" + query);
		// }
		// } catch (SQLException e) {
		// e.printStackTrace();
		// }

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
