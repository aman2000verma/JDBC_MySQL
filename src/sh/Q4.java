package sh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Write a program for updating records into table.
 */
public class Q4 {

	public static void main(String[] args) throws SQLException {

		String driver = "com.mysql.cj.jdbc.Driver";

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			return;
		}

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sh", "root", "123456789");
		Statement st = con.createStatement();

		String query = "update employee set salary = 25000 where salary>25000";
		try {
			st.executeUpdate(query);
			System.out.println("Update Successful");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		st.close();
		con.close();
	}

}
