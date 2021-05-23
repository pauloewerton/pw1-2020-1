package br.edu.ifpb;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ContatoView extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {

            Contato contato = (Contato) request.getAttribute("contato");

            response.setContentType("text/html");

            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<body>");
            out.println("<h1>");
            out.println("Detalhes do Contato");
            out.println("</h1>");
            out.println("<p>");
            out.println("Nome: " + contato.getNome());
            out.println("</p>");
            out.println("<p>");
            out.println("Telefone: " + contato.getTelefone());
            out.println("</p>");
            out.println("</body>");
            out.println("</html>");

            out.close();
    }
}
