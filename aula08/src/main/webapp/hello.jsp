<%@ page isELIgnored="false" %>
<html>
<body>
    <%@ include file="header.html" %>
    <% if (request.getParameter("nome") == null) { %>
        <jsp:forward page="login-redir.jsp" />
    <% } %>
    <h3>Ola, ${param.nome}!</h3>
    <p>Meu e-mail e: ${initParam.mainEmail}</p>
    <%@ include file="footer.html" %>
</body>
</html>