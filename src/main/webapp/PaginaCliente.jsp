<%@page import="controlador.conexion"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1"> 
<link href="CSS/PaginaCliente.css" type="text/css" rel="stylesheet" />
<title>Pagina Cliente</title>
</head>
<header>
<div class="animation start-home"><a href="PaginaInicio.jsp" class="nav-item">Volver</a></div>
<div class="logo"><img src="IMG/TBMBanner.jpg" alt="TBM" class="logo"></div>
	<nav>
		<a href="PaginaUsuario.jsp" class="nav-item">Usuarios</a>
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
String cedulacliente ="";
String direccioncliente ="";
String emailcliente ="";
String nombrecliente ="";
String telefonocliente ="";

if(request.getParameter("ce")!=null){
cedulacliente=request.getParameter("ce");
direccioncliente=request.getParameter("di");
emailcliente=request.getParameter("em");
nombrecliente=request.getParameter("nom");
telefonocliente=request.getParameter("tel");
}
%>
<form action="Servletcliente" method="post" class="mobile-screen">
	<div><h1>Información de cliente</h1></div>
	
	<div class="form-content">
		<div>
			<label class="labelestil" for="cedulacliente">Cedula:</label>
			<input type="number" id="cedulacliente" value="<%=cedulacliente %>" required="" name="cedulacliente"/>
		</div>
		<div>
			<label class="labelestil" for="nombrecliente">Nombre completo:</label>
			<input type="text" id="nombrecliente" value="<%=nombrecliente %>" name="nombrecliente">
		</div>
		<div>
			<label class="labelestil" for="emailcliente">Email:</label>
			<input type="text" id="emailcliente" value="<%=emailcliente %>"  name="emailcliente">
		</div>
		<div>
			<label class="labelestil" for="direccioncliente">Dirección:</label>
			<input type="text" id="direccioncliente" value="<%=direccioncliente %>"  name="direccioncliente">
		</div>
		<div>
			<label class="labelestil" for="telefonocliente">Telefono:</label>
			<input type="text" id="telefonocliente" value="<%=telefonocliente %>"  name="telefonocliente">
		</div>
	</div>
	<div>
		<input type="submit" name="btninsc" class="btninsu" value="Crear Cliente">
		<input type="submit" name="btncrsu" class="btninsu" value="Consultar Cliente">
		<input type="submit" name="btnacsu" class="btninsu" value="Actualizar Cliente">
		<input type="submit" name="btnelsu" class="btninsu" value="Eliminar Cliente">
	</div>
</form>	

</body>
</html>