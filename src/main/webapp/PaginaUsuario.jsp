<%@page import="controlador.conexion"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="CSS/PaginaUsuario.css" type="text/css" rel="stylesheet" />
<title>Pagina Usuarios</title>
</head>
<header>
<div class="animation start-home"><a href="PaginaInicio.jsp" class="nav-item">Volver</a></div>
<div class="logo"><img src="IMG/TBMBanner.jpg" alt="TBM" class="logo"></div>
	<nav>
		<a href="PaginaUsuario.jsp" class="nav-item">Usuario</a>
		<a href="PaginaCliente.jsp" class="nav-item">Clientes</a>
		<a href="PaginaProveedores.jsp" class="nav-item">Proveedores</a>
		<a href="PaginaProductos.jsp" class="nav-item">Productos</a>
		<a href="PaginaVentas.jsp" class="nav-item">Ventas</a>
		<a href="PaginaReportes.jsp" class="nav-item">Reportes</a>
		<div class="animation start-home"></div>
	</nav>	
</header>
<body>
<%
conexion cn=new conexion();
cn.conexionbd();
String cedulausuario =""; 
String emailusuario =""; 
String nombreusuario =""; 
String password =""; 
String usuario ="";

if(request.getParameter("ce")!=null){
cedulausuario=request.getParameter("ce");
emailusuario=request.getParameter("em");
nombreusuario=request.getParameter("nom");
password=request.getParameter("pass");
usuario=request.getParameter("usu");
}
%>
<form action="Servletusuario" method="post" class="mobile-screen">
	<div><h1>Informaci�n de usuario</h1></div>
	
	<div class="form-content">
		<div>
			<label class="labelestil" for="cedula">Cedula:</label>
			<input type="number" id="cedula" value="<%=cedulausuario %>" required="" name="cedulausuario"/>
		</div>
		<div>
			<label class="labelestil" for="nombreusuario">Nombre completo:</label>
			<input type="text" id="nombreusuario" value="<%=nombreusuario %>" name="nombreusuario">
		</div>
		<div>
			<label class="labelestil" for="email">Email:</label>
			<input type="text" id="email" value="<%=emailusuario %>" name="emailusuario">
		</div>
		<div>
			<label class="labelestil" for="usuario">Usuario:</label>
			<input type="text" id="usuario" value="<%=usuario %>" name="usuario">
		</div>
		<div>
			<label class="labelestil" for="password">Contrase�a:</label>
			<input type="text" id="password" value="<%=password %>" name="password">
		</div>
	</div>
	<div>
		<input type="submit" name="btninsu" class="btninsu" value="Crear Usuario">
		<input type="submit" name="btncrsu" class="btninsu" value="Consultar Usuario">
		<input type="submit" name="btnacsu" class="btninsu" value="Actualizar Usuario">
		<input type="submit" name="btnelsu" class="btninsu" value="Eliminar Usuario">
	</div>
</form>	


</body>
</html>