<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="CSS/BasesDatos.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="JS/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="JS/consultar.js"></script>
<title>Insert title here</title>
</head>
<body>
<header>
	<nav>
		<a href="PaginaInicio.jsp" class="nav-item">VOLVER</a>
		<a href="PaginaUsuario.jsp" class="nav-item">Usuarios</a>
		<a href="Login.jsp" class="nav-item">SALIR</a>
		<div class="animation start-home"></div>
	</nav>	

</header>



<form>
<input type="button" class="btncongenedos" name="btncongenedos" value="Consultar Usuarios">
</form>

<table id="tab" border="1">

</table>

</body>
</html>