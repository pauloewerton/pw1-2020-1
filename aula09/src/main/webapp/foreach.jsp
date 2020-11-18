<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
    <head>
        <meta charset="UTF-8">
    </head>

    <body>
        <h1>Ranked Movies List</h1>
        <c:set var="moviesList">Star Wars,The Avengers,Justice League</c:set>
        <table>
            <tr>
                <th>Ranking</th>
                <th>Title</th>
                <th>Storyline</th>
            </tr>
            <c:forEach var="movie" items="${moviesList}" varStatus="ranking">
                <tr>
                    <td><c:out value="${ranking.count}" /></td>
                    <td><c:out value="${movie}" /></td>
                    <td>
                        <form action="choose.jsp">
                            <input type="hidden" name="movie" value="${movie}">
                            <input type="submit" value="View Storyline">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>