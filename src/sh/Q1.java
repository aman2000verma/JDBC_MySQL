package sh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Write a program for creating a table.
 */
public class Q1 {

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

		String query = "create table employee (emp_id int primary key not null, first_name varchar(255),"
				+ " last_name varchar(255), Salary int, dept_id int, email varchar(255), city varchar(255))";

		try {
			st.execute(query);
			System.out.println("Table Created Successfully.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		st.close();
		con.close();
	}

}
