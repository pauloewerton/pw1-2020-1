<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ page isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="pt">
    <head>
        <meta charset="UTF-8">
    </head>

    <body>
        <h1>Algo deu errado...</h1>
        <c:url value="error.png" var="errorImage" />
        <img src="${errorImage}" alt="Error Image">
    </body>
</html>