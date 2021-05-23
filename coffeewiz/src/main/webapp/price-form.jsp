<!DOCTYPE html>
<html>
    <head>
        <title>PW1 Aula 04</title>
    </head>
    <body>
        <h1 style="text-align: center;">Pagina de Selecao de Cafe</h1>
        <form method="POST" action="SelectPrice">
            <p>Selecione a faxia de preco do cafe</p>
            <label for="price">Faixa de preco:</label>
            <select name="price" size="1">
                <option value="inexpensive">Barato</option>
                <option value="affordable">Razoavel</option>
                <option value="expensive">Caro</option>
            </select>
            <br><br>
            <input style="text-align: center;" type="submit" />
        </form>
    </body>
</html>