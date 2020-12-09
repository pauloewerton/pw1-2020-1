<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta charset="UTF-8">
    </head>
    <body>
        <table>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Telefone</th>
            </tr>
            <s:iterator value="contatos">
                <tr>
                    <td><s:property value="id" /></td>
                    <td><s:property value="nome" /></td>
                    <td><s:property value="telefone" /></td>
                </tr>
            </s:iterator>
        </table>
    </body>
</html>