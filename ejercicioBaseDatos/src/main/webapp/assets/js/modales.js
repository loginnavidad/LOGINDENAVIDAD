/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var modalAdministrador ="";
var modalProfe="";
var modalAlum="";
var modalAsig="";

var administrador="";
var profesor="";
var alumno="";
var asignatura="";

var span="";

var divs="";
function cargar(){
    divs = document.getElementsByTagName("div");
    //COGE EL MODAL
    modalProfe = document.getElementById('profe');
    modalAlum = document.getElementById('alum');
    modalAsig = document.getElementById('asig');
    modalCurs = document.getElementById("curs");
    //COGE EL BOTON QUE HACE FUNCIONAR EL MODA
    profesor = document.getElementById("profesor");
    alumno = document.getElementById("alumno");
    asignatura = document.getElementById("asignatura");
    curso = document.getElementById("curso");
    //ICONO DE CERRAR EL MODAL
    cp = document.getElementById("closep");
    ca = document.getElementById("closea");
    cas = document.getElementById("closeas");
    cc = document.getElementById("closec");
    
    
    profesor.addEventListener("click", verModalProfe);
    alumno.addEventListener("click", verModalAlum);
    asignatura.addEventListener("click", verModalAsig);
    curso.addEventListener("click", verModalCurso);
    
    cp.addEventListener("click", ocultarModalProfe);
    ca.addEventListener("click", ocultarModalAlum);
    cas.addEventListener("click", ocultarModalAsig);
    cc.addEventListener("click", ocultarModalCurso);
    
}

function verModalCurso(){
    modalCurs.style.display="block";
}
function verModalProfe(){
     modalProfe.style.display = "block";
}
function verModalAlum(){
    modalAlum.style.display = "block";
}
function verModalAsig(){
    modalAsig.style.display = "block";
}


function ocultarModalProfe() {
    modalProfe.style.display = "none";
}

function ocultarModalAlum() {
    modalAlum.style.display = "none";
}

function ocultarModalAsig() {
    modalAsig.style.display = "none";
}

function ocultarModalCurso() {
    modalCurs.style.display = "none";
}