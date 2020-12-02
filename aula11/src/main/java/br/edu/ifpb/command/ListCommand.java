package br.edu.ifpb.command;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpb.dao.Contato;
import br.edu.ifpb.dao.ContatoDaoImpl;

public class ListCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Connection connection = (Connection) request.getAttribute("connection");
        List<Contato> contatos = new ContatoDaoImpl(connection).findAll();

        request.setAttribute("contatos", contatos);

        return "listar.jsp";
    }
}
