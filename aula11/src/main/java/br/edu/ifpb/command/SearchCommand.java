package br.edu.ifpb.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpb.dao.Contato;
import br.edu.ifpb.dao.ContatoDaoImpl;

import java.sql.Connection;

public class SearchCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Long id = Long.parseLong(request.getParameter("contatoId"));
        Connection connection = (Connection) request.getAttribute("connection");
        Contato contato = new ContatoDaoImpl(connection).findById(id);

        request.setAttribute("contato", contato);

        return "buscar.jsp";
    }
    
}
