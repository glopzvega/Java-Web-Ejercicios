<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EL y Variables Implicitas</title>
</head>
<body>

<h1>EL y Variables Implicitas</h1>

<ul>

<li>Nombre de la aplicacion: ${pageContext.request.contextPath}</li>
<li>Navegador del Cliente: ${header["User-Agent"]}</li>
<li>Id session: ${cookie.JSESSIONID.value}</li>
<li>Web Sertver: ${pageContext.servletContext.serverInfo}</li>
<li>Valor Parametro: ${param["usuario"]}</li>

</ul>

</body>
</html>