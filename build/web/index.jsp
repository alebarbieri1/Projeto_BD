<%-- 
    Document   : index
    Created on : 30/10/2016, 17:51:17
    Author     : Alexandre Barbieri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="Controller">
            <input type="hidden" name="command" value="Usuario.login"><br>
            <span style="width: 60px; display: inline-block;"><label>Usuário:</label></span><input type="text" name="usuario" id="usuario"><br>
            <span style="width: 60px; display: inline-block"><label>Senha:</label></span><input type="password" name="senha" id="senha"><br><br>
            <input type="submit" value="Entrar">
        </form>
    </body>
</html>
