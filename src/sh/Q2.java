package sh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Write a program for inserting records into table.
 */
public class Q2 {

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

		String query1 = "insert into employee values(1, \"Jatin\", \"Thakur\", 30000, 1001, \"prateeksen@xyz.com\", \"Mandi\")";
		String query2 = "insert into employee values(2, \"Prateek\", \"Sen\", 30000, 1001, \"prateeksen@xyz.com\", \"Delhi\")";
		try {
			st.executeUpdate(query1);
			st.executeUpdate(query2);
			System.out.println("Insertion Successful");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		st.close();
		con.close();
	}

}
