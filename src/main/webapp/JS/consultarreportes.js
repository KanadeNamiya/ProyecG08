$(document).ready(function(){

//alert("hola en js")//;var numero=10,num=5;let n1=20;var numero=5;
//let n1=333;const letra="m"; alert(numero+"  "+n1);	
//function suma(){ var numero=10, num=5;res=numero+num;alert(res);}	suma();

	//alert("json");
	
	$(".btnusu").on("click",function(){
	consultageneral();	
	});
	
	
function consultageneral(){
$.ajax({
  url: "Servletusuario",
  type:"POST",
  dataType:"json",
  success: function( result ) {
    console.log(result);
	let tabla=document.querySelector('#tab');
	console.log(tabla);
	tabla.innerHTML="";
	tabla.innerHTML=`<caption>Lista de usuarios</caption>
	<tr><th>Cedula</th>
						<th>Nombre</th>
						<th>Correo Electronico</th>
						<th>Direccion</th>
						<th>Telefono</th>
						</tr>`
	
	for(let i of result){
		tabla.innerHTML+=`<tr><th>${i.cedulausuario}</th>
							<th>${i.emailusuario}</th>
							<th>${i.nombreusuario}</th>
							<th>${i.password}</th>
							<th>${i.usuario}</th></tr>`
	}
  }
});
}

	$(".btncli").on("click",function(){
	consultageneralc();	
	});
	
function consultageneralc(){
$.ajax({
  url: "Servletcliente",
  type:"POST",
  dataType:"json",
  success: function( result ) {
    console.log(result);
	let tabla=document.querySelector('#tab');
	console.log(tabla);
	tabla.innerHTML="";
	tabla.innerHTML=`<caption>Lista de clientes</caption>
	<tr>
						<th>Cedula</th>
						<th>Direccion</th>
						<th>Email</th>
						<th>Nombre cliente</th>
						<th>Telefono</th>
						</tr>`
	
	for(let i of result){
		tabla.innerHTML+=`<tr><th>${i.cedulacliente}</th>
							<th>${i.direccioncliente}</th>
							<th>${i.emailcliente}</th>
							<th>${i.nombrecliente}</th>
							<th>${i.telefonocliente}</th></tr>`
	}
  }
});
}

	$(".botonventa").on("click",function(){
	consultageneralv();	
	});
	
function consultageneralv(){
$.ajax({
  url: "Servletventas",
  type:"POST",
  dataType:"json",
  success: function( result ) {
    console.log(result);
	let tabla=document.querySelector('#tab');
	console.log(tabla);
	tabla.innerHTML="";
	tabla.innerHTML=`<caption>Lista de ventas</caption>
	<tr>
						<th>Cedula</th>
						<th>Nombre</th>
						<th>Valor total factura</th>
						</tr>`
	
	for(let i of result){
		tabla.innerHTML+=`<tr><th>${i.cedulacliente}</th>
							<th>${i.nombrecliente}</th>
							<th>${i.totalventa}</th>
							</tr>`
	};
	
	var totalSum = 0;
	i=0;
	for (let i of result){
		totalSum = i.totalventa+totalSum
	}
	tabla.innerHTML+=`<tr><th></th>
						  <th>Total:</th>
						  <th>${totalSum}</th>
	</tr>`

	
	
	
  }
});
}


	
});