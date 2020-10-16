package sh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Write a program to display the department number and average salary for each
 * department.
 */
public class Q7 {

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
		ResultSet res = null;

		String query = "select dept_id, avg(salary) from employee group by dept_id";
		try {
			res = st.executeQuery(query);
			ResultSetMetaData meta = res.getMetaData();
			int colCount = meta.getColumnCount();

			for (int i = 1; i <= colCount; i++) {
				if (i != colCount)
					System.out.print(meta.getColumnName(i) + " | ");
				else
					System.out.print(meta.getColumnName(i) + "\n");
			}

			while (res.next()) {
				for (int i = 1; i <= colCount; i++) {
					if (i != colCount)
						System.out.print(res.getString(i) + " | ");
					else
						System.out.print(res.getString(i) + "\n");
				}
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		res.close();
		st.close();
		con.close();
	}

}
