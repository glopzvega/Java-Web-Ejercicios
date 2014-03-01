package usuarios.test;

import java.sql.SQLException;
import java.util.List;

import usuarios.jdbc.UsuarioDAO;
import usuarios.jdbc.UsuarioDAOJDBC;
import usuarios.jdbc.UsuarioDTO;

public class UsuariosTest {

	public static void main(String args[]){
		
		UsuarioDAO Dao = new UsuarioDAOJDBC();
		//UsuarioDTO user1 = new UsuarioDTO();
		
		
		//user1.setNombre("Gera4");
		//user1.setPassword("Fly4");
		//user1.setId_usuario(4);
		
		
		try {			
			//Dao.insertUsuario(user1);
			//Dao.updateUsuario(user1);
			List<UsuarioDTO> usuarios =  Dao.selectUsuario();
			
			for(UsuarioDTO u: usuarios){				
				
				System.out.print("id: " + u.getId_usuario());
				System.out.print(" user: " + u.getNombre());
				System.out.print(" pass: " + u.getPassword());
				System.out.println();
				
				
			}
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
	}
	
}
