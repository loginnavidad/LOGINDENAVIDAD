<#ftl strip_whitespace = true>

<#assign charset="UTF-8">
<#assign title="Example">
<!DOCTYPE html>
<html>
    <head>
        <title>${title}</title>
        <meta charset="${charset}">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        </head>
    <body>
        <p>${mensaje}</p>
        <p>Nombre de usuario: ${nombreUser}</p>
        <p>ID de usuario: ${idAlumno}</p>
        <p>Permiso de usuario: ${idPermiso}</p>
    </body>
    </html>