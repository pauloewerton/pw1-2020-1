package br.edu.ifpb;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class ContatoController extends HttpServlet {
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

       List<Contato> contatos = new ArrayList<>();
       ServletConfig config = this.getServletConfig();
       Enumeration<String> paramNames = config.getInitParameterNames();

       while (paramNames.hasMoreElements()) {
           String name = paramNames.nextElement();
           contatos.add(new Contato(name, config.getInitParameter(name)));
       }

       String nomeQuery = request.getParameter("name");
       Contato contatoEncontrado = null;
       for (Contato c : contatos) {
           if (nomeQuery.equalsIgnoreCase(c.getNome())) {
               contatoEncontrado = new Contato(c.getNome(), c.getTelefone());
               break;
           }
       }

       if (contatoEncontrado != null) {
           RequestDispatcher dispatcher = request.getRequestDispatcher("/view");
           request.setAttribute("contato", contatoEncontrado);
           dispatcher.forward(request, response);
       } else {
           response.sendRedirect("/agenda/erro.html");
       }
    }
}
