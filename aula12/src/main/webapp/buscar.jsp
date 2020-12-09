<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta charset="UTF-8">
    </head>
    <body>
        <s:if test="contato == null">
            <h1>Contato não encontrado!</h1>
        </s:if>
        <s:else>
            <h2>Detalhes do contato:</h2>
            <p>ID: <c:out value="${contato.id}" /></p>
            <p>Nome: <c:out value="${contato.nome}" /></p>
            <p>Telefone: <c:out value="${contato.telefone}" /></p>
        </s:else>
    </body>
</html>