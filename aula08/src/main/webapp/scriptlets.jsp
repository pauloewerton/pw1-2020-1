<!-- Exemplo de diretiva -->
<%@ page import="java.util.*" %>
<html>
<body>
    <h2>Scripting em JSP</h2>
    <!-- Exemplo de scritplet -->
    <% 
        List<String> myList = new ArrayList<>();
        myList.add("ola");
        myList.add("mundo");

        for (String s : myList) {
            out.print("<em>" + s + "</em> ");
        }
    %>
    <!-- Exemplo de declaration -->
    <%! int count = 10; %>
    <!-- Exemplo de expression -->
    <h3>O valor do contador e: <%= count %></h3>
</body>
</html>
