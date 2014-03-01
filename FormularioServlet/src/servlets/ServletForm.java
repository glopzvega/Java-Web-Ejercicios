package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletForm extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws IOException{
		
		PrintWriter out = response.getWriter();
		
		String user = request.getParameter("nombre");
		String pass = request.getParameter("password");
		
		out.println(user);
		out.println(pass);
		
		out.close();
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException{
		
		doGet(request, response);
	}

}
