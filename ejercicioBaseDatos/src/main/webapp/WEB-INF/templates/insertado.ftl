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
        <#if insertado == 1>
        <div> ${mensaje}</div>
        <#elseif insertado == 0>
        <div>${mensaje}<div>
        </#if>


        </body>
    </html>