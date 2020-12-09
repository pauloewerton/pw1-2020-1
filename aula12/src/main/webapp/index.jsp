<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta charset="UTF-8">
        <s:head />
    </head>

    <body>
        <h2>Agenda Demo</h2>
        <h3>Selecione a opção desejada</h3>

        <div style="padding-left: 2px;">
            <label><em>Listar todos os contatos: </em></label>
            <button><a style="text-decoration: none;" href="<s:url action='list'/>">Listar</a></button>
        </div>

        <s:form action="search">
            <s:textfield name="id" label="Buscar contato por ID" />
            <s:submit value="Buscar" />
        </s:form>
    </body>
</html>
