<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="pt">
    <head>
        <meta charset="UTF-8">
    </head>

    <body>
        <c:if test="${empty param.nome}">
            <jsp:forward page="login-redir.html" />
        </c:if>

        <c:import url="header.jsp">
            <c:param name="nome" value="${param.nome}" />
        </c:import>

        <p>Meu e-mail é: <c:out value="${initParam.mainEmail}" default="fallback@ifpb.edu.br" /></p>

        <c:import url="footer.jsp" />
    </body>
</html>