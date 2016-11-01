<%-- 
    Document   : home
    Created on : 30/10/2016, 18:16:11
    Author     : Alexandre Barbieri
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <style type="text/css">
            table, td, .header {
                border: 1px solid black;
                border-collapse: collapse;
                padding: 3px;
                text-align: center;
                font-family: Calibri;
            }

            .header {
                background-color: #8E001C;
                color: white;
                font-weight: bold;
            }

        </style>
    </head>
    <body>
        <c:if test="${usuario == null}">
            <c:redirect url="index.jsp"></c:redirect>
        </c:if>
        <h1>Bem vindo, ${usuario.nome_usuario}</h1>
        <a href="Controller?command=Serie.listar">Listar Séries</a>
        <a href="Controller?command=Filme.listar">Listar Filmes</a>
        <a href="Controller?command=Usuario.logout">Logout</a>
        <br><br>
        <c:if test="${series != null}">
            <table>
                <thead>
                    <tr>
                        <td colspan="4" class="header">Séries</td>
                    </tr>
                </thead>
                <tr>
                    <td class="header">#</td>
                    <td class="header">Nome</td>
                    <td class="header">Quantidade de Episódios</td>
                    <td class="header">Nota</td>
                </tr>
                <c:forEach items="${series}" var="s">
                    <tr>
                        <td>${s.id_serie}</td>
                        <td>${s.nome_serie}</td>
                        <td>${s.episodios}</td>
                        <td>${s.nota}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>

        <c:if test="${filmes != null}">
            <br><br>
            <table>
                <thead>
                    <tr>
                        <td colspan="4" class="header">Filmes</td>
                    </tr>
                </thead>
                <tr>
                    <td class="header">#</td>
                    <td class="header">Nome</td>
                    <td class="header">Nota</td>
                </tr>
                <c:forEach items="${filmes}" var="f">
                    <tr>
                        <td>${f.id_filme}</td>
                        <td>${f.nome_filme}</td>
                        <td>${f.nota}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </body>
</html>