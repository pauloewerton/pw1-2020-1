package br.edu.ifpb;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpb.command.Command;

@WebServlet("/controller")
public class FrontController extends HttpServlet {

    private static final String CMD_BASE_PACKAGE = "br.edu.ifpb.command.";

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String commandName = request.getParameter("command");
        String nomeDaClasse = CMD_BASE_PACKAGE + commandName;

        try {
            Class classe = Class.forName(nomeDaClasse);
            Command command = (Command) classe.newInstance();
            String view = command.execute(request, response);

            request.getRequestDispatcher(view).forward(request, response);
        } catch (Exception e) {
            throw new ServletException("A lógica de negócios causou uma exceção", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {

        this.processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException {

        this.processRequest(req, resp);
    }
}
