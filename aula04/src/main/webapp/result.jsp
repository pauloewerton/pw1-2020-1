<%@ page import="java.util.*" %>

<html>
    <body>
        <h1 style="text-align:center;">Recomendacoes de Cafe</h1>
        <p>
            <%
                List<String> styles = (List<String>) request.getAttribute("styles");
                for (String style : styles) {
                    out.print("<br> Experimente: " + style);
                }
            %>
        </p>
    </body>
</html>