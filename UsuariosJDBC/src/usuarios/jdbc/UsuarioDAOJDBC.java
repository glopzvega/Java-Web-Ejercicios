package usuarios.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Esta clase implementa la interfaz UsuarioDAO
 * es una implementacion con la tecnologia JDBC
 * podria haber otro tipo de implementacion con tecnologias 
 * como Hibernate, 	iBatis, SpringJDBC, etc.
 * 
 * @author Infosyst
 *
 */
public class UsuarioDAOJDBC implements UsuarioDAO {

	private Connection userConn;
	
	private final String SQL_INSERT = 
			"INSERT INTO usuarios (usuario, password) VALUES(?, ?)";
	
	private final String SQL_UPDATE =
			"UPDATE usuarios SET usuario=?, password=? WHERE id_usuario=?";
	
	private final String SQL_DELETE = 
			"DELETE FROM usuarios WHERE id_usuario=?";
	
	private final String SQL_SELECT = 
			"SELECT * FROM usuarios";
	
	/**
	 * Constructor vacio
	 */
	public UsuarioDAOJDBC(){
	
	}
	
	/**
	 * Constructor que recibe una Conexion
	 * @param Connection conn
	 */
	public UsuarioDAOJDBC(Connection conn){
		this.userConn = conn;
	}
	
	@Override
	public int insertUsuario(UsuarioDTO usuario)
			throws SQLException {
			Connection conn = null;
			PreparedStatement pstm = null;
			int rows = 0;
			
			try{
				
				conn = (this.userConn != null) ? this.userConn : Conexion.getConnection();
				pstm = conn.prepareStatement(SQL_INSERT);
				int index = 1;
				pstm.setString(index++, usuario.getNombre());
				pstm.setString(index, usuario.getPassword());
				
				rows = pstm.executeUpdate();
				System.out.println("Numero de registros afectados: " + rows);
				
				
			}
			finally{
				Conexion.close(pstm);
				if(this.userConn == null) Conexion.close(conn);
			}
			
		return rows;
	}

	@Override
	public int updateUsuario(UsuarioDTO usuario)
			throws SQLException {
		
		Connection conn = null;
		PreparedStatement pstm = null;
		int rows = 0;
		
		try{
			
			conn = (this.userConn != null) ? this.userConn : Conexion.getConnection();
			pstm = conn.prepareStatement(SQL_UPDATE);
			int index = 1;
			pstm.setString(index++, usuario.getNombre());
			pstm.setString(index++, usuario.getPassword());
			pstm.setInt(index, usuario.getId_usuario());		
			
			rows = pstm.executeUpdate();
			System.out.println("Numero de registros afectados: " + rows);
			
			
		}
		finally{
			Conexion.close(pstm);
			if(this.userConn == null) Conexion.close(conn);
		}
		
	return rows;
	}

	@Override
	public int deleteUsuario(UsuarioDTO usuario) throws SQLException {

		Connection conn = null;
		PreparedStatement pstm = null;
		int rows = 0;
		
		try{
			
			conn = (this.userConn != null) ? this.userConn : Conexion.getConnection();
			pstm = conn.prepareStatement(SQL_DELETE);
			pstm.setInt(1, usuario.getId_usuario());		
			
			rows = pstm.executeUpdate();
			System.out.println("Numero de registros afectados: " + rows);
			
			
		}
		finally{
			Conexion.close(pstm);
			if(this.userConn == null) Conexion.close(conn);
		}
		
	return rows;
	}

	@Override
	public List<UsuarioDTO> selectUsuario() throws SQLException {
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		UsuarioDTO usuario = null;
		List<UsuarioDTO> usuariosList = new ArrayList<UsuarioDTO>();
		
		try{
			
			conn = (this.userConn != null) ? this.userConn : Conexion.getConnection();
			pstm = conn.prepareStatement(SQL_SELECT);
			rs = pstm.executeQuery();
			
			while(rs.next()){
				
				//Por cada registro se recuperan los valores de las columnas y se genera un objeto DTO
				int id_usuario = rs.getInt(1);
				String user = rs.getString(2);
				String pass = rs.getString(3);
				
				//System.out.println(id_usuario);
				
				//Llenamos el DTO y lo agregamos a la lista de usuarios
				usuario = new UsuarioDTO();
				usuario.setId_usuario(id_usuario);
				usuario.setNombre(user);
				usuario.setPassword(pass);
				usuariosList.add(usuario);
				
			}
			
		}
		finally{
			
			//rs.close();
			Conexion.close(rs);
			Conexion.close(pstm);
			if(this.userConn != null) Conexion.close(conn);
		}	
		
		
		
		return usuariosList;
	}

}
