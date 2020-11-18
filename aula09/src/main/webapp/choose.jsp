<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="pt">
    <head>
        <meta charset="UTF-8">
    </head>

    <body>
        <h1><c:out value="${param.movie}" /> Storyline</h1>
        <c:choose>
            <c:when test="${param.movie == 'Star Wars'}">
                <p>
                    Luke Skywalker joins forces with a Jedi Knight, a cocky pilot, a Wookiee and two droids to save 
                    the galaxy from the Empire's world-destroying battle station, while also attempting to rescue Princess Leia
                    from the mysterious Darth Vader. 
                </p>
            </c:when>
            <c:when test="${param.movie == 'The Avengers'}">
                <p>
                    Earth's mightiest heroes must come together and learn to fight as a team if they are going to
                    stop the mischievous Loki and his alien army from enslaving humanity. 
                </p>
            </c:when>
            <c:when test="${param.movie == 'Justice League'}">
                <p>
                    Fueled by his restored faith in humanity and inspired by Superman's selfless act,
                    Bruce Wayne enlists the help of his new-found ally, Diana Prince, to face an even greater enemy.
                </p>
            </c:when>
            <c:otherwise>
                <p>
                    Unable to find storyline.
                </p>
            </c:otherwise>
        </c:choose>
    </body>
</html>