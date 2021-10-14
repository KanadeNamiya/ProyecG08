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
String codproduc="";
String iva="";
String nit="";
String nompro="";
String compra="";
String venta="";

if(request.getParameter("ni")!=null){
codproduc=request.getParameter("ni");
iva=request.getParameter("ci");
nit=request.getParameter("di");
nompro=request.getParameter("no");
compra=request.getParameter("te");
venta=request.getParameter("to");
}
%>
<div>
<form  class="archivo" action="Achivos" method="post" enctype="multipart/form-data">
<section>
          <fieldset>
              <legend class="labelestil">Gestión Productos</legend>
                <form>
                    <input type="text" name="nomarchi" value="" placeholder="Nombre del archivo">           
                    <input type="submit" name="cargar" value="insertar" placeholder="texto">
                    <input type="file" class="btninsudos" name="archivo" required="" value=""placeholder="Nombre del archivo">

                </form>


          </fieldset>
</section>
</form>	
</div>
<div >

<form action="Servletproductos" method="post"class="mobile-screen">

	<div><h1>Información de Productos</h1></div>
	
	<div class="form-content">
		<div>
			<label class="labelestil" for="cedula">Codigo Producto:</label>
			<input type="number" id="nit" value="<%=codproduc %>" required="" name="codproduc"/>
		</div>
		<div>
			<label class="labelestil" for="nombreusuario">Iva Compra:</label>
			<input type="text" id="nombre" value="<%=iva %>" name="iva">
		</div>
		<div>
			<label class="labelestil" for="email">Nit Proveedor:</label>
			<input type="text" id="ciudad" value="<%=nit %>" name="nit">
		</div>
		<div>
			<label class="labelestil" for="usuario">Nombre Producto:</label>
			<input type="text" id="direccion" value="<%=nompro %>" name="nompro">
		</div>
		<div>
			<label class="labelestil" for="password">Precio Compra:</label>
			<input type="text" id="telefono" value="<%=compra %>" name="compra">
		</div>
		<div>
			<label class="labelestil" for="password">Precio Venta:</label>
			<input type="text" id="telefono" value="<%=venta %>" name="venta">
		</div>
	</div>
	<div>
		<input type="submit" name="btninsp" class="btninsu" value="Crear Producto">
		<input type="submit" name="btncrsp" class="btninsu" value="Consultar Producto">
		<input type="submit" name="btnacsp" class="btninsu" value="Actualizar Producto">
		<input type="submit" name="btnelsp" class="btninsu" value="Eliminar Producto">
	</div>
	
</form>	
</div>

</body>
</html>