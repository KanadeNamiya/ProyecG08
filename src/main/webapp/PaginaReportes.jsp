<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="CSS/PaginaReportes.css" type="text/css" rel="stylesheet" />
<title>Pagina Reportes</title>
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

	<div  class="div">
		<button type="button" name="btnusu" class="btninsu"><a href="PaginaReportesUsuarios.jsp">Listado de usuarios</a></a></button>
		<button type="button" name="btnusu" class="btninsu"><a href="PaginaReportesClientes.jsp">Listado de clientes</a></a></button>
		<button type="button" name="btnusu" class="btninsu"><a href="PaginaReportesVentas.jsp">Listado de ventas</a></a></button>
	</div>
</form>

</body>
</html>