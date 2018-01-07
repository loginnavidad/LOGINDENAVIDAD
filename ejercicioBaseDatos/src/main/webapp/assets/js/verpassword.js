var ver=null;
		var pass = "";
		var contenido = "";
		var tipo="";
		function coger(){
			ver = document.getElementById("ver");
		}
		function verPass(){
			pass = document.getElementById("inputPass");
			tipo = pass.getAttribute("type");
		
			contenido = pass.value;
			document.getElementById("form").removeChild(pass);
	
			html = document.createElement("input");
			html.setAttribute("type","text");
			html.setAttribute("name","passLogin");
			html.setAttribute("placeholder","Introduzca la contraseña");
			html.setAttribute("id","inputPass");
			html.setAttribute("value",contenido);
		
			document.getElementById("form").insertBefore(html, ver);
		}
		function noverPass(){
			pass = document.getElementById("inputPass");
			tipo = pass.getAttribute("type");
		
			contenido = pass.value;
			document.getElementById("form").removeChild(pass);
			html = document.createElement("input");
			html.setAttribute("type","password");
			html.setAttribute("name","passLogin");
			html.setAttribute("placeholder","Introduzca la contraseña");
			html.setAttribute("id","inputPass");
			html.setAttribute("value",contenido);
			document.getElementById("form").insertBefore(html, ver);
		}

