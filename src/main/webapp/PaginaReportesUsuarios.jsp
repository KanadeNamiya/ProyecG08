<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="CSS/PaginaReportes.css" type="text/css" rel="stylesheet" />
<title>Pagina Reportes</title>
<script type="text/javascript" src="JS/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="JS/consultarreportes.js"></script>
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
<form>
<div>

			<input type="button" id="btnusu" name="btnusu" class="btnusu" value="consultar">
</div>
<table id="tab" border="1">

</table>
</form>

</body>
</html>