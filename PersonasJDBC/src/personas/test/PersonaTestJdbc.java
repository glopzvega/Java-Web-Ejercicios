package personas.test;

import java.util.List;

import personas.jdbc.Persona;
import personas.jdbc.PersonaJDBC;

public class PersonaTestJdbc {
	
	public static void main(String args[]){
		
		PersonaJDBC p = new PersonaJDBC();
		
		//p.selectPersonas();
		//p.insertPersona("Gerardo", "Cruz");
		
		//p.updatePersona(8, "David", "Nagera");
		//p.deletePersona(8);
		
		List<Persona> personas = p.selectPersonas();
		
		for(Persona persona : personas){
			
			System.out.print("id: " + persona.getId_persona());
			System.out.print(" nombre: " + persona.getNombre());
			System.out.println(" apellido: " + persona.getApellido());
			
		}
		
	}

}
