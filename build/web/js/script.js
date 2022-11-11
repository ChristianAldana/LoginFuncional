window.onload=function(){
    //let suma = 5+10;
     //alert(suma);
}

function lanzarMensaje(){
    //alert('Hola Mundo');
}

function mostrarVariables(){
    let variable1='texto de pruebas';
    let variable2 = 12345;
    let variableArray=["elemento1", "elemento2"];
    console.log(variable1);
    console.log(variable2);
    console.log(variableArray);
    console.log(variableArray[1]);    
}

function concatenarVariables(var1, var2){   
    let mensaje= var1+var2;
    console.log(mensaje);
}

function mostrarObjetos(var1, var2){
    let alumno={"codigo":var1, "nombre":var2}
    console.log(alumno);
    console.log(alumno.nombre);
}

function mostrarObjetosClasicos(){
    let alumno= new Object();
    alumno.nombre='Angel Vargas';
    alumno.codigo='0909-20-246';
    alumno.correo='correo@umg.edu.gt';
    metodoAnidadoQueMuestraPorConsola(alumno);
    eliminarPropiedadDeObjetos(alumno);
}

function metodoAnidadoQueMuestraPorConsola(unObjeto){
    console.log(unObjeto);
    console.log(unObjeto.nombre);
}

function eliminarPropiedadDeObjetos(objeto){
    delete objeto.correo;
    console.log(objeto);
}

function manipularElementosDelDom(){
    let alumno= new Object();
    let codigo=document.getElementById("codigo");
    let nombre=document.getElementById("nombre");
    let correo=document.getElementById("correo");
    alumno.codigo=codigo.value;
    alumno.nombre=nombre.value;
    alumno.correo=correo.value;
    console.log(alumno);
    codigo.value='';
    nombre.value='';
    correo.value='';
}

function crearElementosEnEjecusion() {
	let divCreadoEnEjecusion = document.createElement('div');	
	let otroElemento = document.createElement('h4');
	let botones = document.createElement('button');
	otroElemento.append('El titulo deseado');
	divCreadoEnEjecusion.append("texto a agregar");
    botones.setAttribute("value", "Click Aqui");
	let container= document.getElementById("principal");
	container.append(otroElemento);
	container.append(divCreadoEnEjecusion);
	container.append(botones);
 	//console.log(divCreadoEnEjecusion); 		
}

function eliminarElementosEnEjecusion(){
	let container= document.getElementById("principal");
	container.remove();
}

function desestructurarArrays(){
	let miArray=['uno', 'dos','tres'];

	let [a, b, c]=miArray;

	console.log(a);
	console.log(b);
	console.log(c);
}

function manejoDeExcepciones(){
	try{
		algoQueNoExiste();
	}catch(error){
		console.log(error);
		console.error('Errores del try catch');
		console.error(error);
	}
	
}

function enviarFormulario(){
	let request = new XMLHttpRequest();
request.open('POST', 'NewServlet', true);
request.setRequestHeader('Content-Type', 'text/plain; charset=UTF-8');

request.onreadystatechange = function() {
  if (request.readyState == XMLHttpRequest.DONE) {
    // Peticion terminada.
    if (request.status == 200) {
      // Todo salio bien
      console.log(request.response);
    } else {
      console.log("Error en el envío " + request.response);
    }
  }
}

var formData = new FormData(document.getElementById('form'));
request.send(formData);
}

function enviarFormularioOpcion2(){
	const XHR = new XMLHttpRequest();
	  var formData = new URLSearchParams(new FormData(document.getElementById('form'))).toString();
         
	  // Define what happens in case of error
	  XHR.addEventListener('error', (event) => {
	    alert('Oops! Something went wrong.');
	  });

	  // Set up our request
	  XHR.open('POST', 'NewServlet', true);
          XHR.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
          
          XHR.onload = () => {
            if (XHR.readyState === XHR.DONE && XHR.status === 200) {
              console.log("response => " + XHR.response);
              //console.log("response xml=> " + XHR.responseXML);
              document.getElementById('bodyTable').innerHTML=XHR.response;
              mostrarMensaje('Estudiante guardado exitosamente');
              limpiarFormulario();
            }
          };   
          XHR.send(formData);         
}


function limpiarFormulario(){
    document.getElementById("codigo").value='';
    document.getElementById("nombre").value='';
    document.getElementById("telefono").value='';
    document.getElementById("correo").value='';
    document.getElementById("direccion").value='';
}

function mostrarMensaje(mensaje){
  Swal.fire({
    icon: 'success',
    title: mensaje,
    showConfirmButton: false,
    timer: 1500
    })
}

function eliminarAlumno(codigo){
    const XHR = new XMLHttpRequest();
    var formData = new URLSearchParams(new FormData());

    // Define what happens in case of error
    XHR.addEventListener('error', (event) => {
      alert('Oops! Something went wrong.');
    });

    // Set up our request
    XHR.open('POST', 'NewServlet', true);
    XHR.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    XHR.onload = () => {
      if (XHR.readyState === XHR.DONE && XHR.status === 200) {
        console.log("response => " + XHR.response);
        mostrarMensaje('Estudiante Eliminado exitosamente');
        setTimeout( function() { window.location.reload() }, 2000 );
      }
    };        
    formData.append('codigo_alumno', codigo);
    formData.append('control', 'ELIMINAR');
    XHR.send(formData); 
    
}


