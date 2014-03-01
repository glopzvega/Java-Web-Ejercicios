package jdbc.prueba;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Conexion")
public class Conexion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse res)
			throws ServletException, IOException {
		
		Connection conexion = null;
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();

		try {
			// Leemos el driver de Oracle
			Class.forName("com.mysql.jdbc.Driver");

			// Nos conectamos a la BD local
			conexion = DriverManager.getConnection(
					"jdbc:mysql://localhost/test", "root", "root");

			/*
			 * //Nos conectamos a la BD de la ETSII String
			 * clave="claveSecretaETSII"; conexion = DriverManager.getConnection
			 * ( "jdbc:oracle:thin:@oracle0.ugr.es:1521:PRACTBD",
			 * "fjgarcia",clave);
			 */

			// Decimos que nos hemos conectado
			out.println("<html>");
			out.println("<body>");
			out.println("<h1>¡Hemos conectado!</h1>");
			out.println("</body>");
			out.println("</html>");

		} catch (ClassNotFoundException e1) {
			// Error si no puedo leer el driver de Oracle
			out.println("ERROR:No encuentro el driver de la BD: "
					+ e1.getMessage());
		} catch (SQLException e2) {
			// Error SQL: login/passwd mal
			out.println("ERROR:Fallo en SQL: " + e2.getMessage());
		} finally {
			// Finalmente desconecto de la BD
			try {
				if (conexion != null)
					conexion.close();
			} catch (SQLException e3) {
				out.println("ERROR:Fallo al desconectar de la BD: "
						+ e3.getMessage());
			}

		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
