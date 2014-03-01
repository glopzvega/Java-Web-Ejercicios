package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SesionesServlet extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		String titulo = null;
		Integer contadorVisitas = null;
		
		contadorVisitas = (Integer) session.getAttribute("contadorVisitas");
		
		if(contadorVisitas == null){			
			contadorVisitas = new Integer(1);
			titulo = "Bienvenido por primera vez";			
		}
		else{
			
			titulo = "Bienvenido Nuevamente";
			contadorVisitas += 1;
			
		}
		
		session.setAttribute("contadorVisitas", contadorVisitas);
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("Mensaje" +  titulo);
		out.println("<br>");
		out.println("No. de accesos al recurso" + contadorVisitas);
		out.println("<br>");
		out.println("Id de la session: " + session.getId());
		out.close();
		
		session.invalidate();
		
		
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);

	}

}
