<#ftl strip_whitespace = true>

<#assign charset="UTF-8">
<#assign title="Example">
<!DOCTYPE html>
<html>
    <head>
        <title>${title}</title>
        <meta charset="${charset}">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <script>
            function enviar(){
                var oldPass = document.getElementById("inputPass").value;
                var pass = document.getElementById("nuevaPass").value;
                var passNueva = document.getElementById("passAgain").value;
                    debugger;
                if(oldPass == pass || pass != passNueva){
                    debugger;
                    document.getElementById("nuevaPass").style.borderColor = "red";
                    document.getElementById("nuevaPass").value="Las contraseñas no coinciden";
                    document.getElementById("nuevaPassAgain").value="Las contraseñas no coinciden";
                    return false;
                }
                    debugger;
                    return true;
            }
        </script>
        </head>
        <body>
            <div class="row">
                <div>
                    <form action="cambiopassword" method="get" onsubmit="return enviar();">
                        <input type="text" name="correo" placeholder="Introduzca el correo electronico" class="form-control"/>
                        <input type="pass" name="passLogin" placeholder="Introduzca la contraseña" id="inputPass" class="form-control">
                        <input type="password" name="nuevaPass" placeholder="Introduzca la nueva contraseña" class="form-control" id="nuevaPass"/>
                        <input type="password" name="nuevaPassAgain" placeholder="Repita la contraseña" class="form-control" id="passAgain"/>
                        <input type="submit" name="accion" value="cambiopassword" class="btn btn-primary">
                    </form>
                <div>
            </div>
        </body>
    </html>