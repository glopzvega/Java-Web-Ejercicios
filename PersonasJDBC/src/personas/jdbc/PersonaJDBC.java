package personas.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaJDBC {

	private static String SQL_SELECT = 
			"SELECT * FROM personas";

	private static String SQL_INSERT = 
			"INSERT INTO personas (nombre, apellido) VALUES (?,?)";
	
	private static String SQL_UPDATE = 
			"UPDATE personas SET nombre = ?, apellido = ? WHERE id_personas = ?";
	
	private static String SQL_DELETE = 
			"DELETE FROM personas WHERE id_personas = ?";

	private Connection con;
	private PreparedStatement pstm;
	private ResultSet rs;
	private int rows;
	private int index;

	public PersonaJDBC() {

		iniValues();

	}

	public int insertPersona(String nombre, String apellido) {

		iniValues();

		try {
			//con = Conexion.getConnection();
			pstm = getHandleConnection(SQL_INSERT);
			pstm.setString(index++, nombre);
			pstm.setString(index++, apellido);
			
			rows = pstm.executeUpdate();		
			System.out.println("Registros afectados: " + rows);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeHandleConection();
		}
		
		return rows;

	}
	
	public int updatePersona(int id, String nombre, String apellido){
		
		iniValues();		
		
		try{
			pstm = getHandleConnection(SQL_UPDATE);
			pstm.setString(index++, nombre);
			pstm.setString(index++, apellido);
			pstm.setInt(index, id);
			
			rows = pstm.executeUpdate();
			System.out.println("Registros afectados: " + rows);
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			closeHandleConection();			
		}
		
		return rows;
	}

	public int deletePersona(int id){
		
		iniValues();
		
		try {
			pstm = getHandleConnection(SQL_DELETE);
			pstm.setInt(index, id);
			rows = pstm.executeUpdate();
			System.out.println("Registros afectados: " + rows);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			closeHandleConection();
		}
		
		return rows;
	}
	
	public List<Persona> selectPersonas() {
		
		Persona persona = null;
		List<Persona> personas = new ArrayList<Persona>();

		iniValues();

		try {
			//con = Conexion.getConnection();
			pstm = getHandleConnection(SQL_SELECT);
			rs = pstm.executeQuery();

			while (rs.next()) {
				
				int id_persona = rs.getInt(1);
				String nombre = rs.getString(2);
				String apellido = rs.getString(3);
				
				persona = new Persona();
				persona.setId_persona(id_persona);
				persona.setNombre(nombre);
				persona.setApellido(apellido);
				personas.add(persona);
				

				//System.out.print(rs.getInt(index++));
				//System.out.print(" " + rs.getString(index++));
				//System.out.println(" " + rs.getString(index));
				//index = 1;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeHandleConection();
		}
		return personas;

	}
	
	private void iniValues() {
		con = null;
		pstm = null;
		rs = null;
		rows = 0;
		index = 1;
	}
	
	private PreparedStatement getHandleConnection(String SQL) 
			throws SQLException{
		
		iniValues();
		con = Conexion.getConnection();
				
		return con.prepareStatement(SQL);
	}
	
	private void closeHandleConection(){
		
		if(rs != null) Conexion.close(rs);
		if(pstm != null) Conexion.close(pstm);
		if(con != null) Conexion.close(con);
		
	}

}
