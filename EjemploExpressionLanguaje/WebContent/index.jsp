<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Ejemplo de Expression Languaje</h1>

	<br>

	<a href="VariablesImplicitas.jsp?usuario=juan">Objetos implicitos
		con EL</a>

	<br>
	
	Formulario HTML
	
	<br>
	
	<form name="form1" action="accesoJavaBean.jsp">
		Base: <input type="text" name="base">
		<br>
		Altura: <input type="text" name="altura">
		<br>
		<input type="submit" value="Enviar">
	
	</form>
	

</body>
</html>