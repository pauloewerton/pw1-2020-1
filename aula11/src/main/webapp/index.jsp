<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
    <head>
        <meta charset="UTF-8">
    </head>

    <body>
        <h2>Agenda Demo</h2>
        <h3>Selecione a opção desejada</h3>

        <form action="controller" method="post">
            <label>Listar todos os contatos</label>
            <input type="hidden" name="command" value="ListCommand">
            <input type="submit" value="Listar">
        </form>

        <form action="controller" method="post">
            <label>Buscar contato por ID</label>
            <input type="text" name="contatoId">
            <input type="hidden" name="command" value="SearchCommand">
            <input type="submit" value="Buscar">
        </form>
    </body>
</html>
