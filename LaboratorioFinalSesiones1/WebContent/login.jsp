<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	Estas en Login
	
	<form action="/LaboratorioFinalSesiones1/controller" >
	
		usuario: <input type="text" name="usuario"><br>
		password: <input type="text" name="password"><br>
		<input type="hidden" name="action" value="login">
		<input type="submit" value="Entrar">
	
	</form>
</body>
</html>