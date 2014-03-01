package usuarios.jdbc;

import java.sql.*;
import com.mysql.jdbc.Driver;

public class Conexion {

	private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static String JDBC_URL = "jdbc:mysql://localhost/test";
	private static String JDBC_USER = "root";
	private static String JDBC_PASS = "root";
	private static Driver driver = null;

	public static synchronized Connection getConnection() throws SQLException {

		if (driver == null) {

			try {

				Class jdbcDriverClass = Class.forName(JDBC_DRIVER);
				driver = (Driver) jdbcDriverClass.newInstance();
				DriverManager.registerDriver(driver);

			} catch (Exception e) {
				System.out.println("Fallo al cargar el driver JDBC!");
				e.printStackTrace();
			}

		}
		return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);

	}

	public static void close(ResultSet obj) {

		try {
			obj.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void close(PreparedStatement obj) {

		try {
			obj.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void close(Connection obj) {

		try {
			obj.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
