package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CarritoCompra extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String articuloNuevo = request.getParameter("articulo");
		
		HttpSession session = request.getSession();		
		List<String> listaProductos = (List<String>) session.getAttribute("listaProductos");
		
		if(listaProductos == null){			
			
			listaProductos = new ArrayList<String>();
			session.setAttribute("listaProductos", listaProductos);
			
		}
		
		if(articuloNuevo != null && !articuloNuevo.trim().equals("")){
			listaProductos.add(articuloNuevo);
		}
		
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<h1>Lista de Articulso</h1><br>");
		
		for(String articulo : listaProductos){
			
			out.println("<li>" + articulo + "</li>");
			
		
		}
		
		out.println("<br><br>");
		out.println("<a href='/CarritoComprasSesionesServlet/index.jsp'>De vuelta al index</a>");
		out.close();
		

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);

	}

}
