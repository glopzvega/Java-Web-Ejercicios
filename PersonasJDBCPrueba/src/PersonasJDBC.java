import java.sql.*;

import javax.activation.DataSource;

public class PersonasJDBC {

	private static String url = "jdbc:mysql://localhost:3306/test";
	
	public static void main(String []args){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = DriverManager.getConnection(url, "root", "root");
			Statement stm = conexion.createStatement();
			String sql = "select * from personas";
			ResultSet result = stm.executeQuery(sql);
			
			while(result.next()){
				
				System.out.print("ID: " + result.getInt(1));
				System.out.print(" Nombre: " + result.getString(2));
				System.out.println(" Apellido: " + result.getString(3));				
				
			}
			
			result.close();
			stm.close();
			conexion.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
