package usuarios.jdbc;

import java.sql.*;

public class usuariosDAOJDBC implements usuariosDAO {

	private Connection userConn = null;

	private final String SQL_SELECT_ByNombre = 
			"SELECT * FROM usuarios WHERE usuario = ?";

	public usuariosDAOJDBC() {
	}

	public usuariosDAOJDBC(Connection conn) {
		this.userConn = conn;
	}

	@Override
	public UsuarioDTO selectUsuario(UsuarioDTO usuario) throws Exception {

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		UsuarioDTO user = null;
		
		try {
			conn = (this.userConn != null) ? this.userConn : Conexion.getConnection();	
			pstm = conn.prepareStatement(SQL_SELECT_ByNombre);
			pstm.setString(1, usuario.getUsuario());			
			rs = pstm.executeQuery();		
			
			if(!rs.wasNull()){
				rs.next();
				user = new UsuarioDTO();
				user.setId_usuario(rs.getInt(1));
				user.setUsuario(rs.getString(2));
				user.setPassword(rs.getString(3));				
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}	
		finally {
			Conexion.close(rs);
			Conexion.close(pstm);
			if (conn != null) Conexion.close(conn);
		}
		return user;
	}

}
