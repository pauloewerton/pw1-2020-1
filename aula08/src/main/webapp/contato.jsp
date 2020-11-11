<%@ page isELIgnored="false" %>
<html>
<body>
    <h2>Os dados de contato enviados foram:</h2>
    <p>Nome: ${param.nome}</p>
    <p>Telefone: ${param.telefone}</p>
    <p>Celular: ${paramValues.telefone[1]}</p>
    <p>E-mail: ${paramValues.email[0]}</p>

    <!-- Mapas dos atributos -->
    <h2>Objetos implícitos da EL</h2>

    <h3>Informacoes sobre a requisicao</h3>
    <p>Host: ${header["host"]}</p> <!-- utilizando indice em vez de ponto para acessar os atributos -->
    <p>Metodo HTTP: ${pageContext.request.method}</p> <!-- requestScope nao contem propriedades da requisicao -->

    <h3>Cookies</h3>
    <p>ID da sessao: ${cookie.JSESSIONID.value}</p>

    <h3>Parametros de contexto</h3>
    <p>Email de contato: ${initParam.mainEmail}</p>
</body>
</html>