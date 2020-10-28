package br.edu.ifpb;

import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(
    urlPatterns = {"/search"},
    initParams = {
        @WebInitParam(name = "Jose", value = "8399887788"),
        @WebInitParam(name = "Maria", value = "8499887788"),
        @WebInitParam(name = "Joao", value = "8599887788"),
    }
)
public class ContatoController extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Contato> contatos = new ArrayList<>();
        ServletConfig config = this.getServletConfig();

        Enumeration<String> paramNames = config.getInitParameterNames();
        while (paramNames.hasMoreElements()) {
            String nome = paramNames.nextElement();
            contatos.add(new Contato(nome, config.getInitParameter(nome)));
        }

        String contatoQuery = request.getParameter("name");
        Contato contatoEncontrado = null;
        for (Contato c : contatos) {
            if (c.getNome().equalsIgnoreCase(contatoQuery)) {
                contatoEncontrado = new Contato(c.getNome(), c.getTelefone());
                break;
            }
        }

        if (contatoEncontrado != null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view");
            request.setAttribute("contato", contatoEncontrado);
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("/aula06/erro.html");
        }
    }
}