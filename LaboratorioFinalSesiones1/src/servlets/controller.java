package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import usuarios.jdbc.UsuarioDTO;
import usuarios.jdbc.usuariosDAO;
import usuarios.jdbc.usuariosDAOJDBC;

/**
 * Servlet implementation class controller
 */
@WebServlet("/controller")
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig conf) throws ServletException {
		super.init(conf);
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");

		if (action.equals("listado")) {

			String usuario = null;

			HttpSession session = request.getSession();
			usuario = (String) session.getAttribute("usuario");

			if (usuario != null) {
				response.sendRedirect(request.getContextPath() + "/listado.jsp");
			} else {
				response.sendRedirect(request.getContextPath() + "/login.jsp");
			}
		} else if (action.equals("login")) {

			String userTMP = request.getParameter("usuario");
			String passTMP = request.getParameter("password");			
			
			if(verificaUsuario(userTMP, passTMP)){
				
				HttpSession session = request.getSession();
				session.setAttribute("usuario", userTMP);				
				response.sendRedirect(request.getContextPath() + "/listado.jsp");
			}
			else{
				response.sendError(response.SC_UNAUTHORIZED, "Las credenciales son incorrectas");				
			}
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private Boolean verificaUsuario(String Usuario, String Password) {

		Boolean login = false;
		
		usuariosDAO user = new usuariosDAOJDBC();
		UsuarioDTO u1 = new UsuarioDTO();
		u1.setUsuario(Usuario);
		
		try {
			u1 = user.selectUsuario(u1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(Usuario.equals(u1.getUsuario()) && Password.equals(u1.getPassword())){
			login = true;
		}		
		
		return login;
	}

}
