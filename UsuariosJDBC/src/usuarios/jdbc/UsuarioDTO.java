package usuarios.jdbc;

/**
 * Clase Java que representa un registro de la tabla de usuarios
 * @author Infosyst
 *
 */
public class UsuarioDTO {
	
	private int id_usuario;
	private String nombre;
	private String password;
	
	public int getId_usuario() {
		return id_usuario;
	}
	
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
