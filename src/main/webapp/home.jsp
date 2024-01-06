<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>

<%
String rut = (String) session.getAttribute("rut");
String nombre = (String) session.getAttribute("nombre");
String apellido = (String) session.getAttribute("apellido");
String telefono = (String) session.getAttribute("telefono");
String fechaIngreso = (String) session.getAttribute("fechaIngreso");
%>

<h3><%out.println(rut); %></h3>
<h3><%out.println(nombre); %></h3>
<h3><%out.println(apellido); %></h3>
<h3><%out.println(telefono); %></h3>
<h3><%out.println(fechaIngreso); %></h3>

</body>
</html>