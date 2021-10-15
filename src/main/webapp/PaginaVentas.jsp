<%@page import="controlador.conexion"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="CSS/PaginaVentas.css" type="text/css" rel="stylesheet" />
<title>Pagina Ventas</title>
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


<form action="PruebaVenta" method="post">
	<div><h1>Información de Ventas</h1></div>
	
	
		
		
			<input type="text" name="cedulacliente" id="cedulacliente" value="${cliente.getCedulacliente() }" placeholder="cedula" required=""/>
			<input type="text" name="nombrecliente" id="nombrecliente" value="${cliente.getNombrecliente() }" placeholder="nombre" >
			<input type="submit" name="enviarcel" class="btninsu" value="Enviar" required="">
	
			
<table>
		<tr>    
			<th>Codigo</th>
			<th>consultar Producto</th>
			<th> Producto</th>
			<th>Cantidad </th>
			<th>precio de Producto</th>
	   </tr>   
			
		<tr>
		     <td><input type="text" name="codigoproducto1" id="codigoproducto1" value="${cp.getCodproducto() }"  /></td>
		     <td><input type="submit" name="consultarProducto1" class="btninsu" value="Consultar "></td>
		     <td><input type="text" name="producto1" id="producto1" value="${cp.getNombrep() }" /></td>
			 <td><input type="text" id="cantidad1" name="cantidad1" /></td>
			 <td><input type="text" id="precioproducto1" value="${cp.getVenta()}" name="precioproducto1"/></td>
		</tr>
			
		<tr>
		    <td><input type="text" id="codigoproducto2" value="${cp2.getCodproducto() }"  name="codigoproducto2"/></td>
		    <td><input type="submit" name="consultarProducto2" class="btninsu" value="Consultar "></td>
		    <td><input type="text" id="producto2" value="${cp2.getNombrep() }" name="producto2"/></td>
		    <td><input type="text" id="cantidad2"  name="cantidad2"/></td>
		    <td><input type="text" id="precioproducto2" value="${cp2.getVenta()}"  name="precioproducto2"/></td>
	   </tr>
			
	   <tr>
		    <td><input type="text" id="codigoproducto3" value="${cp3.getCodproducto() }"  name="codigoproducto3"/></td>
		    <td><input type="submit" name="consultarProducto3" class="btninsu" value="Consultar "></td>
		    <td><input type="text" id="producto3" value="${cp3.getNombrep() }"  name="producto3"/></td>
			<td><input type="text" id="cantidad3"  name="cantidad3"/></td>
			<td><input type="text" id="precioproducto3" value="${cp3.getVenta()}" name="precioproducto3"/></td>
	  </tr> 
			
			
			
		
		</table>
		
	
	<div>
		<input type="submit" name="EnviarV" class="btninsu" value="Enviar Venta">
		 

	</div>
	<input type="hidden" name="codigone" value="${cedusu.getCedulausuario()}"  >
</form>	

</body>
</html>