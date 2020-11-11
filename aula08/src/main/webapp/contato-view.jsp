<%@ page isELIgnored="false" %>
<html>
<body>
    <h2>Contato Bean</h2>
    <p>Nome: ${contato.nome}</p>
    <p>Endereco: ${contato.endereco}</p>

    <h2>Contato Map</h2>
    <p>Nome: ${contatoMap.mapNome}</p>
    <p>Endereco: ${contatoMap.mapEndereco}</p>

    <h2>Contato List</h2>
    <p>Nome: ${contatoList[0].nome}</p>
    <p>Endereco: ${contatoList[0].endereco}</p>
    <p>Nome: ${contatoList[1].nome}</p>
    <p>Endereco: ${contatoList[1].endereco}</p>

    <h2>Operadores com EL</h2>
    <p>Atributo inexistente: ${naoExiste}</p>
    <p>Valores de atributo inexistente: ${naoExiste.inexistente}</p>
    <p>Expressoes aritmeticas com operando vazio: ${7 + naoExiste}</p>
    <p>Expressoes aritmeticas com operando vazio: ${7 / naoExiste}</p>
    <p>Expressoes aritmeticas com operando vazio: ${7 - naoExiste}</p>
    <p>Expressoes logicas com operando vazio vazio: ${7 < naoExiste}</p>
    <p>Expressoes logicas com operando vazio vazio: ${7 == naoExiste}</p>
    <p>Expressoes logicas com operando vazio vazio: ${naoExiste == naoExiste}</p>
    <p>Expressoes logicas com operando vazio vazio: ${7 != naoExiste}</p>
    <p>Expressoes logicas com operando vazio vazio: ${true and naoExiste}</p>
    <p>Expressoes logicas com operando vazio vazio: ${true or naoExiste}</p>
    <p>Expressoes logicas com operando vazio vazio: ${not naoExiste}</p>
</body>
</html>