package usuarios.jdbc;

import java.sql.SQLException;

public interface usuariosDAO {
	
	public UsuarioDTO selectUsuario(UsuarioDTO usuario) 
			throws Exception;	
	

}
