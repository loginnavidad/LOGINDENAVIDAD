/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//COGE EL MODAL
var modalAdministrador = document.getElementById('admin');
var modalProfe = document.getElementById('profe');
var modalAlum = document.getElementById('alum');
var modalAsig = document.getElementById('asig');

//COGE EL BOTON QUE HACE FUNCIONAR EL MODA
var administrador = document.getElementById("administrador");
var profesor = document.getElementById("profesor");
var alumno = document.getElementById("alumno");
var asignatura = document.getElementById("asignatura");

//ICONO DE CERRAR EL MODAL
var span = document.getElementsByClassName("close");


span[0].onclick = function() {
    modalAdministrador.style.display = "none";
}
span[1].onclick = function() {
    modalProfe.style.display = "none";
}
span[2].onclick = function() {
    modalAlum.style.display = "none";
}
span[3].onclick = function() {
    modalAsig.style.display = "none";
}



window.onclick = function(event) {
    if (event.target == modalAdministrador || event.target == modalProfe || event.target == modalAlum || event.target == modalAsig) {
        modalAdministrador.style.display = "none";
        modalProfe.style.display = "none";
        modalAlum.style.display = "none";
        modalAsig.style.display = "none";
    }
}

