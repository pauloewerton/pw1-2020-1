<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta charset="UTF-8">
    </head>
    <body>
        <c:choose>
            <c:when test="${empty contato}">
                <h1>Contato não encontrado!</h1>
            </c:when>
            <c:otherwise>
                <h2>Detalhes do contato:</h2>
                <p>ID: <c:out value="${contato.id}" /></p>
                <p>Nome: <c:out value="${contato.nome}" /></p>
                <p>Telefone: <c:out value="${contato.telefone}" /></p>
            </c:otherwise>
        </c:choose>
    </body>
</html>