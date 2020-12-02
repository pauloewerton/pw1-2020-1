<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta charset="UTF-8">
    </head>
    <body>
        <table>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Telefone</th>
            </tr>
            <c:forEach var="contato" items="${contatos}">
                <tr>
                    <td><c:out value="${contato.id}" /></td>
                    <td><c:out value="${contato.nome}" /></td>
                    <td><c:out value="${contato.telefone}" /></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>