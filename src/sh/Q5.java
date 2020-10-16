package sh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Write a program for deleting records from table.
 */
public class Q5 {

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

		String query = "delete from employee where emp_id = 2";
		try {
			st.executeUpdate(query);
			System.out.println("Delete Successful");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		st.close();
		con.close();
	}

}
