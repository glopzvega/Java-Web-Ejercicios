package usuarios.jdbc;

import java.sql.SQLException;
import java.util.List;

/**
 * Esta interfaz contiene los metodos abstractos con las operaciones basicas para la tabla de 
 * Usuarios CRUD se debe crear una clase concreta para implementar el codigo asociado a cada metodo
 * 
 * @author Infosyst
 *
 */

public interface UsuarioDAO {

	public int insertUsuario(UsuarioDTO usuario) 
			throws SQLException;
	
	public int updateUsuario(UsuarioDTO usuario)
			throws SQLException;
	
	public int deleteUsuario(UsuarioDTO usuario)
			throws SQLException;
	
	public List<UsuarioDTO> selectUsuario()
			throws SQLException;
	
}
