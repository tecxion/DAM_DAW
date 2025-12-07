/*
Nombre: LibreriaJavaScript.js
Autor:  Anselmo Morteruel
Fecha:  10.11.2025
Asunto: Librería de funciones javascript para la UD3.
*/


// ---- Muestra el resultado de sumar los dos valores pasados como argumentos.

function sumar(num1,num2) {
  var valor1 = parseInt(document.getElementById(num1).value);
  var valor2 = parseInt(document.getElementById(num2).value);
  document.getElementById('resultado').innerHTML = 'La suma es: ' + (valor1 + valor2);
} 
  
// ---- Muestra una ventana con el contenido del argumento. (Debe ser un id)

function mostrarValor(idObjeto) {
  alert (document.getElementById(idObjeto).value);
}

// ---- Muestra una ventana con el texto deseado.

function mostrarMensaje(texto) {
  alert (texto);
}

// ---- Muestra una ventana con la fecha del sistema.

function mostrarFecha() {
  alert (Date());
}

//---- Muestra una ventana con la fecha formateada.

function mostrarFechaFormateada() {
  var fecha = new Date();
  var mensaje = fecha.toLocaleDateString();
  alert (mensaje);
}

// ---- Muestra u oculta el elemento pasado como argumento.

function mostrar(elemento) {
   document.getElementById(elemento).style.visibility="visible";
}

function ocultar(elemento) {
   document.getElementById(elemento).style.visibility="hidden";
}

// ---- Muestra u oculta el elemento pasado como argumento de otra forma. Incluye un temporizador para incluir al cargar la página.

/* Es necesario incluir también esta librería que se adjunta:
<script type='text/javascript' src='formexp.js'></script>
*/

function ver(elemento)
	{
		xDisplay(elemento, 'block');
	}
function nover(elemento)
	{
		xDisplay(elemento, 'none');
	}

function carga_pagina(elemento)
	{
		this.idObjeto=elemento;
		nover(elemento);
		window.setTimeout('ver(this.idObjeto)',3000);
		window.setTimeout('nover(this.idObjeto)',7000);
	}

// ---- Enmarca una entrada cuando recoge el foco (Evento onfocus)

function enfocar(idObjeto) {
   document.getElementById(idObjeto).style.border="2px solid red";
}

// ---- Desenmarca una entrada cuando pierde el foco (Evento onblur)

function desenfocar(idObjeto) {
   document.getElementById(idObjeto).style.border="1px solid black";
}

// ---- Enmarca / desenmarca una entrada cuando coge / pierde el foco

function enmarcar(idObjeto , color) {

   document.getElementById(idObjeto).style.borderStyle= 'solid';
   document.getElementById(idObjeto).style.borderColor = color;
}

// ---- Rellena un objeto de un color una determinada zona (Eventos onmouseover, onmouseout)

function rellenarColor(idObjeto, color) {
  document.getElementById(idObjeto).style.backgroundColor = color;
}
