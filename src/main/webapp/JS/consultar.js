$(document).ready(function(){

//alert("hola en js");var numero=10,num=5;let n1=20;var numero=5;
//let n1=333;const letra="m"; alert(numero+"  "+n1);	
//function suma(){ var numero=10, num=5;res=numero+num;alert(res);}	suma();

	//alert("json");
	
	
	$(".btncongenedos").on("click",function(){
	alert("boton");
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
	tabla.innerHTML=`<tr><th>cedula usuario</th>
						<th>email usuario</th>
						<th>nombre usuario</th>
						<th>password</th>
						<th>usuario</th>
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

	
});