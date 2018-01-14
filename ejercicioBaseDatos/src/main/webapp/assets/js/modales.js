/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var modalAdministrador ="";
var modalProfe="";
var modalAlum="";
var modalAsig="";
var modalProfeAsig = "";

var administrador="";
var profesor="";
var alumno="";
var asignatura="";
var profeasig = "";

var span="";

var divs="";
function cargar(){
    divs = document.getElementsByTagName("div");
    //COGE EL MODAL
    modalProfe = document.getElementById('profe');
    modalAlum = document.getElementById('alum');
    modalAsig = document.getElementById('asig');
    modalCurs = document.getElementById("curs");
    modalProfeAsig = document.getElementById("asigprofe");
    //COGE EL BOTON QUE HACE FUNCIONAR EL MODA
    profesor = document.getElementById("profesor");
    alumno = document.getElementById("alumno");
    asignatura = document.getElementById("asignatura");
    curso = document.getElementById("curso");
    profeasig = document.getElementById("asignarProfe");
    //ICONO DE CERRAR EL MODAL
    cp = document.getElementById("closep");
    ca = document.getElementById("closea");
    cas = document.getElementById("closeas");
    cc = document.getElementById("closec");
    cap = document.getElementById("closeap");
    
    profesor.addEventListener("click", verModalProfe);
    alumno.addEventListener("click", verModalAlum);
    asignatura.addEventListener("click", verModalAsig);
    curso.addEventListener("click", verModalCurso);
    profeasig.addEventListener("click", verModalProfeAsig);
    
    cp.addEventListener("click", ocultarModalProfe);
    ca.addEventListener("click", ocultarModalAlum);
    cas.addEventListener("click", ocultarModalAsig);
    cc.addEventListener("click", ocultarModalCurso);
    cap.addEventListener("click", ocultarModalProfeAsig);
    
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
function verModalProfeAsig(){
    modalProfeAsig.style.display = "block";
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

function ocultarModalProfeAsig(){
    modalProfeAsig.style.display = "none";
}