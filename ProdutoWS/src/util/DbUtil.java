package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	private static Connection connection = null;

	public static Connection getConnection() {
		if (connection != null)
			return connection;
		else {
			try {
				String dburl = "jdbc:mysql://localhost:3306/crudproduto";
				String dbuser = "root";
				String dbpass = "";
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(dburl, dbuser, dbpass);

			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			return connection;
		}

	}
}
