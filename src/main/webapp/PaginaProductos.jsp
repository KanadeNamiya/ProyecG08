<%@page import="controlador.conexion"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="CSS/PaginaProductos.css" type="text/css" rel="stylesheet" />
<title>Pagina Productos</title>
</head>
<header>
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
String nit="";
String ciudad="";
String direccion="";
String nombre="";
String telefono="";

if(request.getParameter("ni")!=null){
nit=request.getParameter("ni");
ciudad=request.getParameter("ci");
direccion=request.getParameter("di");
nombre=request.getParameter("no");
telefono=request.getParameter("te");
}
%>
<form action="Servletproductos" method="post">
	<div><h1>Información de Productos</h1></div>
	
	<div class="form-content">
		<div>
			<label class="labelestil" for="cedula">Codigo Producto:</label>
			<input type="number" id="nit" value="<%=nit %>" required="" name="nit"/>
		</div>
		<div>
			<label class="labelestil" for="nombreusuario">Iva Compra:</label>
			<input type="text" id="nombre" value="<%=nombre %>" name="nombre">
		</div>
		<div>
			<label class="labelestil" for="email">Nit Proveedor:</label>
			<input type="text" id="ciudad" value="<%=ciudad %>" name="ciudad">
		</div>
		<div>
			<label class="labelestil" for="usuario">Nombre Producto:</label>
			<input type="text" id="direccion" value="<%=direccion %>" name="direccion">
		</div>
		<div>
			<label class="labelestil" for="password">Precio Compra:</label>
			<input type="text" id="telefono" value="<%=telefono %>" name="telefono">
		</div>
		<div>
			<label class="labelestil" for="password">Precio Venta:</label>
			<input type="text" id="telefono" value="<%=telefono %>" name="telefono">
		</div>
	</div>
	<div>
		<input type="submit" name="btninsp" class="btninsu" value="Crear Producto">
		<input type="submit" name="btncrsp" class="btninsu" value="Consultar Producto">
		<input type="submit" name="btnacsp" class="btninsu" value="Actualizar Producto">
		<input type="submit" name="btnelsp" class="btninsu" value="Eliminar Producto">
	</div>
</form>	
</body>
</html>