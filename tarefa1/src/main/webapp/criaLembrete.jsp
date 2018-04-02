<%-- 
    Document   : criaLembrete
    Created on : Apr 2, 2018, 2:31:16 AM
    Author     : vyniciuspontes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cria Lembrete</title>
    </head>
    <body>
        <h1>Cria Lembrete</h1>
        
        <div>
            <form action="/tarefa1/guardaLembrete" method="POST">
                
                <label for="usuario">Nome do Usuario</label>
                <input type="text" name="usuario">
                
                <label for="usuario">Lembrete</label>
                <input type="text" name="lembrete">
                
                <button type="submit">Criar Lembrete</button>
            </form>
            
        </div>
        
    </body>
</html>
