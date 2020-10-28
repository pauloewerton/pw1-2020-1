package br.edu.ifpb;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/view")
public class ContatoView extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Contato contato = (Contato) request.getAttribute("contato");

        response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>");
        out.println("Detalhes do contato:");
        out.println("</h1>");
        out.println("</p>");
        out.println("nome: " + contato.getNome());
        out.println("</p>");
        out.println("</p>");
        out.println("telefone: " + contato.getTelefone());
        out.println("</p>");
        out.println("</body>");
        out.println("</html>");

        out.close();
    }
}
