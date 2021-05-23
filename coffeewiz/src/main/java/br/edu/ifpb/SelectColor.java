package br.edu.ifpb;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SelectColor")
public class SelectColor extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
           this.doGet(request, response); 
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
            HttpSession session = request.getSession(false);

            if (session == null) {
                response.sendRedirect("/coffeewiz/intensity-form.html");
            } else {
                System.out.println("session info" + session.getId());
                String color = request.getParameter("color");
                session.setAttribute("color", color);
            }

            RequestDispatcher view = request.getRequestDispatcher("price-form.jsp");
            view.forward(request, response);
    }
}